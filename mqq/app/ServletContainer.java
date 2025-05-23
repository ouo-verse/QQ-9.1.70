package mqq.app;

import android.content.Intent;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import mqq.util.MqqConnRateReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ServletContainer {
    private final AppRuntime app;
    final ConcurrentHashMap<String, Servlet> managedServlet = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Set<String>> actionMap = new ConcurrentHashMap<>();
    private final ExecutorService mService = ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: mqq.app.ServletContainer.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new BaseThread(runnable, "ServletForward");
        }
    });
    private HighFreqLogUtil highFreqLogUtil = new HighFreqLogUtil(2);

    public ServletContainer(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerServletCommand(String str, Servlet servlet) {
        if (servlet instanceof MSFServlet) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("registerServletCommand className:");
            sb5.append(str);
            sb5.append(" servlet:");
            sb5.append(servlet);
            this.highFreqLogUtil.d("mqq", 1, sb5.toString());
            String[] preferSSOCommands = ((MSFServlet) servlet).getPreferSSOCommands();
            if (preferSSOCommands != null) {
                for (String str2 : preferSSOCommands) {
                    Set<String> set = this.actionMap.get(str2);
                    if (set == null) {
                        set = new HashSet<>();
                        this.actionMap.put(str2, set);
                    }
                    set.add(str);
                }
            }
        }
    }

    public void destroy() {
        this.mService.shutdown();
        Iterator<Map.Entry<String, Servlet>> it = this.managedServlet.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
        this.managedServlet.clear();
    }

    public void forward(AppRuntime appRuntime, final Intent intent) {
        boolean z16;
        if (this.mService.isShutdown()) {
            QLog.e("mqq", 1, "ServletContainer has destoryed," + intent.getComponent().getClassName() + " can not be started.");
            return;
        }
        final String className = intent.getComponent().getClassName();
        Runnable runnable = new Runnable() { // from class: mqq.app.ServletContainer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Servlet servlet = ServletContainer.this.getServlet(className);
                    if (servlet != null) {
                        if (servlet instanceof IDynamicRegisterServletCmd) {
                            ServletContainer.this.registerServletCommand(className, servlet);
                        }
                        servlet.service(intent);
                    }
                } catch (Exception e16) {
                    QLog.e("mqq", 1, "", e16);
                }
            }
        };
        if (intent instanceof NewIntent) {
            z16 = ((NewIntent) intent).runNow;
        } else {
            z16 = false;
        }
        if (!z16 && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mService.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void forwardForFail(NewIntent newIntent) {
        try {
            String className = newIntent.getComponent().getClassName();
            Servlet servlet = getServlet(className);
            if (servlet instanceof IDynamicRegisterServletCmd) {
                registerServletCommand(className, servlet);
            }
            if (servlet instanceof MSFServlet) {
                FromServiceMsg fromServiceMsg = new FromServiceMsg();
                fromServiceMsg.setMsgFail();
                ((MSFServlet) servlet).onReceive(fromServiceMsg);
            }
        } catch (Exception e16) {
            QLog.e("mqq", 1, e16, new Object[0]);
        }
    }

    Servlet getServlet(String str) {
        Class<?> loadClass;
        Servlet servlet = this.managedServlet.get(str);
        if (servlet != null) {
            return servlet;
        }
        synchronized (this.managedServlet) {
            Servlet servlet2 = this.managedServlet.get(str);
            try {
                if (servlet2 != null) {
                    return servlet2;
                }
                try {
                    loadClass = Class.forName(str);
                } catch (Throwable unused) {
                    loadClass = this.app.getClass().getClassLoader().loadClass(str);
                }
                Servlet servlet3 = (Servlet) loadClass.newInstance();
                servlet3.init(this.app, this);
                servlet3.onCreate();
                this.managedServlet.put(str, servlet3);
                if (!(servlet3 instanceof IDynamicRegisterServletCmd)) {
                    registerServletCommand(str, servlet3);
                }
                return servlet3;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
    }

    public void notifyMSFServlet(Class<? extends MSFServlet> cls, FromServiceMsg fromServiceMsg) {
        MSFServlet mSFServlet;
        if (cls != null) {
            mSFServlet = (MSFServlet) getServlet(cls.getName());
            if (mSFServlet != null) {
                mSFServlet.onReceive(fromServiceMsg);
            }
        } else {
            mSFServlet = null;
        }
        Set<String> set = this.actionMap.get(fromServiceMsg.getServiceCmd());
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                MSFServlet mSFServlet2 = (MSFServlet) getServlet(it.next());
                if (mSFServlet2 != null && mSFServlet2 != mSFServlet) {
                    mSFServlet2.onReceive(fromServiceMsg);
                } else if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                    MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, fromServiceMsg.getWupBuffer(), 20);
                }
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
            MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eMSFRecvInviteMsg, fromServiceMsg.getWupBuffer(), 19);
        }
    }
}

package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.report.StatReportManager;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MonitorSocketStat extends BaseThread {
    static IPatchRedirector $redirector_ = null;
    private static Handler mMonitorSocketHandler = null;
    private static HandlerThread mMonitorSocketThread = null;
    static final String tag = "MonitorSocketStat";
    private byte STATUS;
    private final LinkedBlockingDeque<com.tencent.mobileqq.msf.sdk.utils.b> dataFlow;
    private boolean isScreenOff;
    private long lastgotStatusTime;
    private final BroadcastReceiver mReceiver;
    private String processName;
    private boolean running;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MonitorSocketStat.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BaseApplication.getContext().registerReceiver(MonitorSocketStat.this.mReceiver, new IntentFilter(IECScreenReceiver.ACTION_SCREEN_OFF));
                BaseApplication.getContext().registerReceiver(MonitorSocketStat.this.mReceiver, new IntentFilter(IECScreenReceiver.ACTION_SCREEN_ON));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MonitorSocketStat.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                QLog.d(MonitorSocketStat.tag, 1, "onReceive intent==null");
                return;
            }
            String action = intent.getAction();
            QLog.dAsync(MonitorSocketStat.tag, 1, "onReceive action: " + action);
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                MonitorSocketStat.this.onScreenOn();
            } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                MonitorSocketStat.this.onScreenOff();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msf.sdk.utils.b f250719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f250720b;

        c(com.tencent.mobileqq.msf.sdk.utils.b bVar, int i3) {
            this.f250719a = bVar;
            this.f250720b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MonitorSocketStat.this, bVar, Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketStat.tag, 1, "sendMsg fail, total=" + MonitorSocketStat.this.dataFlow.size() + " dataFlowItem=" + this.f250719a + " result=" + this.f250720b);
            }
            try {
                MonitorSocketStat.this.dataFlow.put(this.f250719a);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(MonitorSocketStat.tag, 1, "MonitorSocketStat excep!", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MonitorSocketStat.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, "start to get status of Process");
            }
            if (MsfSdkUtils.isTopActivity(BaseApplication.getContext())) {
                if (MonitorSocketStat.this.isScreenOff) {
                    MonitorSocketStat.this.STATUS = (byte) 4;
                    return;
                } else {
                    MonitorSocketStat.this.STATUS = (byte) 1;
                    return;
                }
            }
            if (MonitorSocketStat.this.isScreenOff) {
                MonitorSocketStat.this.STATUS = (byte) 2;
            } else if (MsfSdkUtils.isTopActivity(BaseApplication.getContext()) || MonitorSocketStat.this.isScreenOff) {
                MonitorSocketStat.this.STATUS = (byte) 0;
            } else {
                MonitorSocketStat.this.STATUS = (byte) 3;
            }
        }
    }

    public MonitorSocketStat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.dataFlow = new LinkedBlockingDeque<>();
        this.running = true;
        this.isScreenOff = false;
        this.STATUS = (byte) 0;
        this.mReceiver = new b();
        setName(tag);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CheckNetFlowStatus");
        mMonitorSocketThread = baseHandlerThread;
        baseHandlerThread.start();
        Handler handler = new Handler(mMonitorSocketThread.getLooper());
        mMonitorSocketHandler = handler;
        handler.post(new a());
    }

    private void getnetFlowStatus() {
        runOnMonitorSocketThread(new d(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenOff() {
        this.isScreenOff = true;
        getnetFlowStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenOn() {
        this.isScreenOff = false;
        getnetFlowStatus();
    }

    public static boolean runOnMonitorSocketThread(Runnable runnable, int i3) {
        if (runnable == null) {
            return false;
        }
        if (mMonitorSocketHandler == null) {
            QLog.d(MonitorSocketImplFactory.tag, 2, "MonitorSocketHandler is null");
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CheckNetFlowStatus1");
            mMonitorSocketThread = baseHandlerThread;
            baseHandlerThread.start();
            mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
        }
        if (i3 > 0) {
            return mMonitorSocketHandler.postDelayed(runnable, i3);
        }
        return mMonitorSocketHandler.post(runnable);
    }

    public byte getSTATUS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Byte) iPatchRedirector.redirect((short) 3, (Object) this)).byteValue();
        }
        return this.STATUS;
    }

    public void insertData(com.tencent.mobileqq.msf.sdk.utils.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        if (this.running) {
            try {
                this.dataFlow.add(bVar);
            } catch (Throwable unused) {
                this.running = false;
                LinkedBlockingDeque<com.tencent.mobileqq.msf.sdk.utils.b> linkedBlockingDeque = this.dataFlow;
                if (linkedBlockingDeque != null) {
                    linkedBlockingDeque.clear();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x011b  */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        LinkedBlockingDeque<com.tencent.mobileqq.msf.sdk.utils.b> linkedBlockingDeque;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.processName == null) {
            this.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
        }
        try {
            if ((BaseApplication.getContext().getPackageName() + ":MSF").equals(this.processName)) {
                while (this.running) {
                    try {
                        com.tencent.mobileqq.msf.sdk.utils.b take = this.dataFlow.take();
                        take.f250723a = this.processName;
                        MsfService.getCore().getNetFlowStore().a(take);
                        if (this.dataFlow.size() <= 1 && System.currentTimeMillis() - this.lastgotStatusTime >= 60000) {
                            getnetFlowStatus();
                            this.lastgotStatusTime = System.currentTimeMillis();
                        }
                    } catch (Throwable th5) {
                        QLog.d(MonitorSocketImplFactory.tag, 1, "" + th5, th5);
                        StatReportManager.reportMonitorSocketIllegalMonitorStateException(th5);
                        this.running = false;
                        try {
                            LinkedBlockingDeque<com.tencent.mobileqq.msf.sdk.utils.b> linkedBlockingDeque2 = this.dataFlow;
                            if (linkedBlockingDeque2 != null) {
                                linkedBlockingDeque2.clear();
                                return;
                            }
                            return;
                        } catch (Throwable th6) {
                            QLog.d(MonitorSocketImplFactory.tag, 1, QCircleLpReportDc05507.KEY_CLEAR, th6);
                            return;
                        }
                    }
                }
                return;
            }
            while (this.running) {
                try {
                    com.tencent.mobileqq.msf.sdk.utils.b take2 = this.dataFlow.take();
                    if (take2 != null) {
                        int sendMsg = MsfServiceSdk.get().sendMsg(MsfServiceSdk.get().getDataFlowMsg(this.processName, take2));
                        if (sendMsg < 0) {
                            runOnMonitorSocketThread(new c(take2, sendMsg), ((int) ((Math.random() * 5.0d) + 3.0d)) * 1000);
                        }
                    }
                    if (this.dataFlow.size() <= 1 && System.currentTimeMillis() - this.lastgotStatusTime >= 60000) {
                        getnetFlowStatus();
                        this.lastgotStatusTime = System.currentTimeMillis();
                    }
                } catch (Exception e16) {
                    QLog.d(MonitorSocketImplFactory.tag, 1, "" + e16, e16);
                    this.running = false;
                }
            }
            return;
        } catch (Exception e17) {
            linkedBlockingDeque = this.dataFlow;
            if (linkedBlockingDeque != null) {
            }
            QLog.d(MonitorSocketImplFactory.tag, 1, "" + e17, e17);
        }
        linkedBlockingDeque = this.dataFlow;
        if (linkedBlockingDeque != null) {
            linkedBlockingDeque.clear();
        }
        QLog.d(MonitorSocketImplFactory.tag, 1, "" + e17, e17);
    }

    public void setProcessName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.processName = str;
        }
    }
}

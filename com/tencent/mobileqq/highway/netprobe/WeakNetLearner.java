package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeakNetLearner implements IHwManager {
    static IPatchRedirector $redirector_ = null;
    private static final long REPORT_INTERVAL = 600000;
    public static final String REPORT_TAG_NAME = "actWeaknetProbe";
    private static final int REPORT_THRESHOLD = 12;
    public static final String TAG = "WekaNet Learner";
    public static Context mContext;

    /* renamed from: cb, reason: collision with root package name */
    private WeakNetCallback f236837cb;
    private AtomicInteger doneNum;
    private volatile boolean isDestroy;
    public long lastReportTime;
    private ProbeHandler probeHandler;
    private HandlerThread probeThread;
    private HashMap<String, Long> repeactTaskMonitor;
    private HashMap<String, String> reports;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface PROBE_REASON {
        public static final int CONNTIMEOUT_ERROR = -1202;
        public static final int INVALID_DATA = -1101;
        public static final int READTIMEOUT_ERROR = -1201;
        public static final int TRANSACTION_FAIL = -1102;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ProbeHandler extends Handler {
        static IPatchRedirector $redirector_ = null;
        public static final int QUIT = 2;
        public static final int START = 1;

        public ProbeHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeakNetLearner.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    WeakNetLearner.this.probeHandler = null;
                    WeakNetLearner.this.probeThread.quit();
                    return;
                }
                return;
            }
            ((ProbeTask) message.obj).startProbe();
        }
    }

    public WeakNetLearner(Context context, WeakNetCallback weakNetCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) weakNetCallback);
            return;
        }
        this.lastReportTime = -1L;
        this.doneNum = new AtomicInteger(0);
        this.isDestroy = false;
        mContext = context;
        this.probeThread = new BaseHandlerThread(TAG);
        this.reports = new HashMap<>();
        this.repeactTaskMonitor = new HashMap<>();
        this.f236837cb = weakNetCallback;
        this.probeThread.setName("Highway-BDH-WeakNet");
        this.probeThread.start();
        this.probeHandler = new ProbeHandler(this.probeThread.getLooper());
    }

    private void doAfterOverflow() {
        HashMap<String, String> reportParams = getReportParams(this.reports);
        WeakNetCallback weakNetCallback = this.f236837cb;
        if (weakNetCallback != null && reportParams != null) {
            weakNetCallback.onResultOverflow(reportParams);
        }
    }

    private HashMap<String, String> getReportParams(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            synchronized (hashMap) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String trim = entry.getValue().trim();
                    int i3 = 1000;
                    if (trim.length() < 1000) {
                        hashMap2.put(key.trim(), trim);
                    } else {
                        int i16 = 1;
                        int i17 = 0;
                        while (i3 <= trim.length()) {
                            String substring = trim.substring(i17, i3);
                            int i18 = i3 + 1000;
                            if (i18 >= trim.length()) {
                                i18 = trim.length();
                            }
                            hashMap2.put(key.trim() + "_" + i16, substring);
                            i16++;
                            i17 = i3;
                            i3 = i18;
                        }
                    }
                    arrayList.add(key);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    hashMap.remove((String) it.next());
                }
            }
            return hashMap2;
        }
        return null;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return mContext;
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.isDestroy = true;
        if (this.doneNum.get() != 0) {
            doAfterOverflow();
            this.doneNum = null;
        }
        ProbeHandler probeHandler = this.probeHandler;
        if (probeHandler != null) {
            probeHandler.sendEmptyMessage(2);
        }
        this.reports.clear();
        mContext = null;
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void onTaskFinish(ProbeTask probeTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) probeTask);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        synchronized (this.reports) {
            this.reports.put(probeTask.getKey(), probeTask.resp.getResult());
        }
        int incrementAndGet = this.doneNum.incrementAndGet();
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.lastReportTime;
        if (j3 <= 0 || uptimeMillis - j3 >= 600000 || incrementAndGet >= 12) {
            doAfterOverflow();
            this.doneNum.set(0);
            this.lastReportTime = uptimeMillis;
        }
    }

    public boolean startProbe(ProbeTask probeTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) probeTask)).booleanValue();
        }
        if (probeTask == null || this.isDestroy) {
            return false;
        }
        Long l3 = this.repeactTaskMonitor.get(probeTask.getKey());
        long uptimeMillis = SystemClock.uptimeMillis();
        if (l3 != null && uptimeMillis - l3.longValue() < 60000) {
            return false;
        }
        synchronized (this.repeactTaskMonitor) {
            this.repeactTaskMonitor.put(probeTask.getKey(), Long.valueOf(uptimeMillis));
        }
        probeTask.learner = new WeakReference<>(this);
        ProbeHandler probeHandler = this.probeHandler;
        if (probeHandler != null) {
            Message obtainMessage = probeHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = probeTask;
            this.probeHandler.sendMessage(obtainMessage);
        }
        return true;
    }
}

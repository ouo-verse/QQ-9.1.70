package com.tencent.bugly.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RMonitorFeatureHelper {
    private static final long REPORT_USERINFO_DELAY = 10000;
    private static final String TAG = "RMonitorFeatureHelper";
    private static RMonitorFeatureHelper sInstance;
    private final Set<String> mStartedPluginList = new CopyOnWriteArraySet();
    private MyHandler myHandler = null;
    private Set<String> reportUserInfoPluginSet = new HashSet();
    private Looper mLooper = ThreadManager.getMonitorThreadLooper();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class MyHandler extends Handler {
        private static final int REPORT_USERINFO_MSG = 1;

        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    Logger.f365497g.i(RMonitorFeatureHelper.TAG, "triggerUserInfoUpload");
                    Method declaredMethod = CrashReport.class.getDeclaredMethod("triggerUserInfoUpload", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, new Object[0]);
                } catch (Throwable unused) {
                }
            }
        }
    }

    RMonitorFeatureHelper() {
    }

    public static RMonitorFeatureHelper getInstance() {
        if (sInstance == null) {
            synchronized (RMonitorFeatureHelper.class) {
                if (sInstance == null) {
                    sInstance = new RMonitorFeatureHelper();
                }
            }
        }
        return sInstance;
    }

    private void reportUserInfoForce() {
        if (this.myHandler == null) {
            this.myHandler = new MyHandler(this.mLooper);
        }
        if (!this.myHandler.hasMessages(1)) {
            this.myHandler.sendEmptyMessageDelayed(1, 10000L);
        }
    }

    public void addPluginNameForReportUserInfo(String str) {
        this.reportUserInfoPluginSet.add(str);
    }

    public JSONArray getStartedPluginList() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.mStartedPluginList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        return jSONArray;
    }

    public boolean isPluginStarted(String str) {
        return this.mStartedPluginList.contains(str);
    }

    public void onPluginClosed(String str) {
        this.mStartedPluginList.remove(str);
    }

    public void onPluginStarted(String str) {
        this.mStartedPluginList.add(str);
        if (this.reportUserInfoPluginSet.contains(str)) {
            reportUserInfoForce();
        }
    }
}

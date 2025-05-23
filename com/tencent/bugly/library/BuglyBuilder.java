package com.tencent.bugly.library;

import android.text.TextUtils;
import com.tencent.bugly.common.sp.ISharedPreferencesProvider;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.eup.a;
import com.tencent.feedback.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyBuilder implements BuglyConstants {
    public static final String ServerHostTypeBuglyOversea = "https://android.bugly.tencent.com";
    public static final String ServerHostTypeBuglyPro = "https://pro.bugly.qq.com";
    public static final String ServerHostTypeDefault = "https://rmonitor.qq.com";
    public final String appId;
    public final String appKey;
    private final List<String> monitorList;
    private final CrashStrategyBean strategyBean;
    public String appVersion = null;
    public String buildNumber = null;
    public String uniqueId = null;
    public String userId = null;
    public String deviceModel = "unknown";
    public boolean debugMode = false;
    public String appVersionType = "Unknown";
    public int logLevel = BuglyLogLevel.LEVEL_WARN;
    public String appChannel = null;
    public boolean enableAllThreadStackCrash = true;
    public boolean enableAllThreadStackAnr = true;
    public boolean enableCrashProtect = true;
    public String hotPatchNum = null;
    public ISharedPreferencesProvider spProvider = null;
    public String serverHostType = null;

    public BuglyBuilder(String str, String str2) {
        this.appId = str;
        this.appKey = str2;
        CrashStrategyBean crashStrategyBean = new CrashStrategyBean();
        this.strategyBean = crashStrategyBean;
        crashStrategyBean.setEnableNativeCrashMonitor(true);
        crashStrategyBean.setEnableANRCrashMonitor(true);
        crashStrategyBean.setEnableCatchAnrTrace(true);
        crashStrategyBean.setCrashHandler(null);
        crashStrategyBean.setUploadHandler(null);
        ArrayList arrayList = new ArrayList();
        this.monitorList = arrayList;
        arrayList.add(BuglyMonitorName.FLUENCY_METRIC);
        arrayList.add(BuglyMonitorName.LOOPER_STACK);
        arrayList.add(BuglyMonitorName.LAUNCH);
        arrayList.add(BuglyMonitorName.MEMORY_METRIC);
        arrayList.add(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS);
        arrayList.add(BuglyMonitorName.MEMORY_JAVA_LEAK);
        arrayList.add(BuglyMonitorName.MEMORY_BIG_BITMAP);
        arrayList.add(BuglyMonitorName.NET_QUALITY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CrashStrategyBean StrategyBean() {
        return this.strategyBean;
    }

    public void addMonitor(String str) {
        if (!this.monitorList.contains(str)) {
            this.monitorList.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getMonitorList() {
        return this.monitorList;
    }

    public void removeMonitor(String str) {
        this.monitorList.remove(str);
    }

    public void setCrashHandleListener(CrashHandleListener crashHandleListener) {
        this.strategyBean.setCrashHandler(crashHandleListener);
    }

    public void setQutLibraryPath(ArrayList<String> arrayList) {
        a.y(arrayList);
    }

    public void setServerHostType(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.serverHostType = str;
        }
    }

    public void setUploadHandleListener(UploadHandleListener uploadHandleListener) {
        this.strategyBean.setUploadHandler(uploadHandleListener);
    }
}

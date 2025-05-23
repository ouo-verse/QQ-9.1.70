package com.tencent.mobileqq.perf.process.state.exit;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0003J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0003J\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0010\u001a\u00020\u0006*\u00020\u00038CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/exit/k;", "", "", "Landroid/app/ApplicationExitInfo;", "b", "exitInfo", "", "d", "e", "", "f", "", "maxNum", "a", "c", "(Landroid/app/ApplicationExitInfo;)Ljava/lang/String;", "key", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f257927a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            long timestamp;
            long timestamp2;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                timestamp = ((ApplicationExitInfo) t17).getTimestamp();
                Long valueOf = Long.valueOf(timestamp);
                timestamp2 = ((ApplicationExitInfo) t16).getTimestamp();
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(timestamp2));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257927a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @RequiresApi(30)
    private final List<ApplicationExitInfo> b() {
        boolean z16;
        List sortedWith;
        int collectionSizeOrDefault;
        List mutableList;
        Set<String> set;
        List take;
        List<ApplicationExitInfo> a16 = a(10);
        List<ApplicationExitInfo> list = a16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        Set<String> stringSet = fromV2.getStringSet("reported_Process_info", null);
        if (stringSet != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (!stringSet.contains(f257927a.c((ApplicationExitInfo) obj))) {
                    arrayList.add(obj);
                }
            }
            a16 = arrayList;
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(a16, new a());
        List list2 = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(f257927a.c((ApplicationExitInfo) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        if (stringSet != null) {
            mutableList.addAll(stringSet);
            take = CollectionsKt___CollectionsKt.take(mutableList, 10);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) take);
        }
        set = CollectionsKt___CollectionsKt.toSet(mutableList);
        fromV2.putStringSet("reported_Process_info", set);
        return a16;
    }

    @RequiresApi(30)
    private final String c(ApplicationExitInfo applicationExitInfo) {
        int pid;
        long timestamp;
        StringBuilder sb5 = new StringBuilder();
        pid = applicationExitInfo.getPid();
        sb5.append(pid);
        sb5.append(util.base64_pad_url);
        timestamp = applicationExitInfo.getTimestamp();
        sb5.append(timestamp);
        return sb5.toString();
    }

    @RequiresApi(30)
    private final String d(ApplicationExitInfo exitInfo) {
        int reason;
        reason = exitInfo.getReason();
        switch (reason) {
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "APP CRASH(EXCEPTION)";
            case 5:
                return "APP CRASH(NATIVE)";
            case 6:
                return QZoneAppCtrlUploadFileLogic.ANR_PATH;
            case 7:
                return "INITIALIZATION FAILURE";
            case 8:
                return "PERMISSION CHANGE";
            case 9:
                return "EXCESSIVE RESOURCE USAGE";
            case 10:
                return "USER REQUESTED";
            case 11:
                return "USER STOPPED";
            case 12:
                return "DEPENDENCY DIED";
            case 13:
                return "OTHER KILLS BY SYSTEM";
            default:
                return "UNKNOWN";
        }
    }

    @RequiresApi(30)
    private final String e(ApplicationExitInfo exitInfo) {
        try {
            String str = (String) exitInfo.getClass().getMethod("subreasonToString", Integer.TYPE).invoke(null, exitInfo.getClass().getMethod("getSubReason", new Class[0]).invoke(exitInfo, new Object[0]));
            if (str == null) {
                return "null";
            }
            return str;
        } catch (Exception e16) {
            QLog.e("ProcessExitState", 1, "getSubReason fail", e16);
            return "null";
        }
    }

    @Nullable
    public final List<ApplicationExitInfo> a(int maxNum) {
        List<ApplicationExitInfo> historicalProcessExitReasons;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, maxNum);
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        historicalProcessExitReasons = ((ActivityManager) systemService).getHistoricalProcessExitReasons(MobileQQ.PACKAGE_NAME, 0, maxNum);
        return historicalProcessExitReasons;
    }

    public final void f() {
        String processName;
        int status;
        int importance;
        long pss;
        long rss;
        String description;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (Build.VERSION.SDK_INT < 30 || Math.random() > MainProcConfig.INSTANCE.e().H()[3].floatValue()) {
            return;
        }
        try {
            List<ApplicationExitInfo> b16 = b();
            if (b16 != null) {
                for (ApplicationExitInfo applicationExitInfo : b16) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    processName = applicationExitInfo.getProcessName();
                    Intrinsics.checkNotNullExpressionValue(processName, "exitInfo.processName");
                    hashMap.put("processName", processName);
                    k kVar = f257927a;
                    hashMap.put("reason", kVar.d(applicationExitInfo));
                    hashMap.put("subReason", kVar.e(applicationExitInfo));
                    status = applicationExitInfo.getStatus();
                    hashMap.put("status", String.valueOf(status));
                    importance = applicationExitInfo.getImportance();
                    hashMap.put("importance", String.valueOf(importance));
                    pss = applicationExitInfo.getPss();
                    long j3 = 1024;
                    hashMap.put("pss", String.valueOf(pss / j3));
                    rss = applicationExitInfo.getRss();
                    hashMap.put("rss", String.valueOf(rss / j3));
                    description = applicationExitInfo.getDescription();
                    if (description == null) {
                        description = "null";
                    }
                    Intrinsics.checkNotNullExpressionValue(description, "exitInfo.description ?: \"null\"");
                    hashMap.put("description", description);
                    com.tencent.mobileqq.perf.report.a.a(hashMap);
                    com.tencent.mobileqq.perf.process.util.c.f257947a.a("processExitInfo", hashMap);
                }
            }
        } catch (Exception unused) {
            QLog.d("ProcessExitState", 1, "report process exit state fail, " + this);
        }
    }
}

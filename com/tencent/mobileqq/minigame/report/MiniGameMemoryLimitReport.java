package com.tencent.mobileqq.minigame.report;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameMemoryLimitReport;", "", "()V", "BEACON_EVENT_CODE_EXCEPTION", "", "TAG", "reportEvent", "", "appId", "level", BeaconKey.DALVIKPSS, BeaconKey.NATIVEPSS, BeaconKey.OTHERPSS, BeaconKey.TOTALPSS, "BeaconKey", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameMemoryLimitReport {
    private static final String BEACON_EVENT_CODE_EXCEPTION = "minigame_memory_limit";
    public static final MiniGameMemoryLimitReport INSTANCE = new MiniGameMemoryLimitReport();
    private static final String TAG = "MiniGameMemoryLimitReport";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameMemoryLimitReport$BeaconKey;", "", "()V", "APPID", "", "DALVIKPSS", "LEVEL", "NATIVEPSS", "OTHERPSS", "TOTALPSS", "UID", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class BeaconKey {
        public static final String APPID = "appid";
        public static final String DALVIKPSS = "dalvikPss";
        public static final BeaconKey INSTANCE = new BeaconKey();
        public static final String LEVEL = "level";
        public static final String NATIVEPSS = "nativePss";
        public static final String OTHERPSS = "otherPss";
        public static final String TOTALPSS = "totalPss";
        public static final String UID = "uid";

        BeaconKey() {
        }
    }

    MiniGameMemoryLimitReport() {
    }

    @JvmStatic
    public static final void reportEvent(String appId, String level, String dalvikPss, String nativePss, String otherPss, String totalPss) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(dalvikPss, "dalvikPss");
        Intrinsics.checkNotNullParameter(nativePss, "nativePss");
        Intrinsics.checkNotNullParameter(otherPss, "otherPss");
        Intrinsics.checkNotNullParameter(totalPss, "totalPss");
        HashMap hashMap = new HashMap();
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime().account");
        hashMap.put("uid", account);
        hashMap.put("appid", appId);
        hashMap.put("level", level);
        hashMap.put(BeaconKey.DALVIKPSS, dalvikPss);
        hashMap.put(BeaconKey.NATIVEPSS, nativePss);
        hashMap.put(BeaconKey.OTHERPSS, otherPss);
        hashMap.put(BeaconKey.TOTALPSS, totalPss);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "start MemoryLimitReport " + level + " ");
        }
        MiniGameBeaconReport.report(BEACON_EVENT_CODE_EXCEPTION, hashMap, true, true);
    }
}

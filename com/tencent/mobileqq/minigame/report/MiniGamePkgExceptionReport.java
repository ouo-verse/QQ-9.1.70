package com.tencent.mobileqq.minigame.report;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGamePkgExceptionReport;", "", "()V", "BEACON_EVENT_CODE_EXCEPTION", "", "TAG", "reportEvent", "", BeaconKey.VERSION_TYPE, "appId", "BeaconKey", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePkgExceptionReport {
    private static final String BEACON_EVENT_CODE_EXCEPTION = "minigame_packager_exception";
    public static final MiniGamePkgExceptionReport INSTANCE = new MiniGamePkgExceptionReport();
    private static final String TAG = "MiniSdk-MiniGamePkgExceptionReport";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGamePkgExceptionReport$BeaconKey;", "", "()V", "MINIGAME_APPID", "", "QUA", "UID", "VERSION_TYPE", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class BeaconKey {
        public static final BeaconKey INSTANCE = new BeaconKey();
        public static final String MINIGAME_APPID = "miniGameAppid";
        public static final String QUA = "qua";
        public static final String UID = "uid";
        public static final String VERSION_TYPE = "zipfilePath";

        BeaconKey() {
        }
    }

    MiniGamePkgExceptionReport() {
    }

    @JvmStatic
    public static final void reportEvent(String zipfilePath, String appId) {
        Intrinsics.checkNotNullParameter(zipfilePath, "zipfilePath");
        Intrinsics.checkNotNullParameter(appId, "appId");
        HashMap hashMap = new HashMap();
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime().account");
        hashMap.put("uid", account);
        String qua3 = QUA.getQUA3();
        Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
        hashMap.put("qua", qua3);
        hashMap.put(BeaconKey.VERSION_TYPE, zipfilePath);
        hashMap.put(BeaconKey.MINIGAME_APPID, appId);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "start report exception " + appId + " " + zipfilePath);
        }
        MiniGameBeaconReport.report(BEACON_EVENT_CODE_EXCEPTION, hashMap, true, true);
    }
}

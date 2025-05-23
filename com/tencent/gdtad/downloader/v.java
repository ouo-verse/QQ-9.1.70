package com.tencent.gdtad.downloader;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/gdtad/downloader/v;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "eventId", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", "", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f109204a = new v();

    v() {
    }

    private final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        String currentUin = VasUtil.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "getCurrentUin()");
        hashMap.put("uin", currentUin);
        String qimei = QQDeviceInfo.getQIMEI();
        Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
        hashMap.put("imei", qimei);
        hashMap.put(StartupReportKey.PLATFORM_ID, "2");
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        hashMap.put("phone_model", MODEL);
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        hashMap.put("phone_brands", BRAND);
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        hashMap.put(AppConstants.Preferences.QQ_VERSION, subVersion);
        hashMap.put("data_timestamp", String.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    public final void b(@NotNull String eventId, @NotNull DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        HashMap<String, String> a16 = a();
        String str = downloadInfo.f341194k0;
        Intrinsics.checkNotNullExpressionValue(str, "downloadInfo.moduleId");
        a16.put("aid", str);
        QQBeaconReport.reportWithAppKey("0DOU02FUWJ47F98X", VasUtil.getCurrentUin(), eventId, a16);
    }
}

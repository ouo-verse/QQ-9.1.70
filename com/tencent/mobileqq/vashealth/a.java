package com.tencent.mobileqq.vashealth;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vashealth/a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f312206a = new a();

    a() {
    }

    @NotNull
    public final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_id", "040");
        hashMap.put("sub_module_id", "-1");
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
        return hashMap;
    }
}

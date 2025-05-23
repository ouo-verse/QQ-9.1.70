package com.tencent.mobileqq.vas.adv.preload;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/e;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "eventId", "Lorg/json/JSONObject;", "adJson", "", "b", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f308162a = new e();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308163a;

        static {
            int[] iArr = new int[MaskAdvName.values().length];
            try {
                iArr[MaskAdvName.QQ_WEATHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaskAdvName.QQ_HEALTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaskAdvName.TIANSHU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaskAdvName.QQ_SHOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MaskAdvName.QFS_PUB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f308163a = iArr;
        }
    }

    e() {
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

    public final void b(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject adJson) {
        String str;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        int i3 = a.f308163a[businessName.ordinal()];
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            str = "";
                        } else {
                            str = "qfs_pub";
                        }
                    } else {
                        str = "shop";
                    }
                } else {
                    str = "tianshu";
                }
            } else {
                str = AdHippyFragment.HEALTH_NAME;
            }
        } else {
            str = "weather";
        }
        HashMap<String, String> a16 = a();
        if (str.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            a16.put("business", str);
        }
        if (adJson != null && adJson.length() > 0) {
            String jSONObject = adJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "adJson.toString()");
            a16.put("adValid", jSONObject);
        }
        QQBeaconReport.reportWithAppKey("0DOU02FUWJ47F98X", VasUtil.getCurrentUin(), eventId, a16);
    }
}

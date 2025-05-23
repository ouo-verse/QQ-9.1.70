package com.tencent.mobileqq.vas.adv.maskad;

import android.content.Context;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/a;", "", "", "j", "f", "", "i", "e", "g", h.F, "Landroid/content/Context;", "d", "traceId", "", "k", "", "c", "b", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f308093a = new a();

    a() {
    }

    private final Context d() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final String e() {
        return h() + "key_sports_mask_ad_show" + g();
    }

    private final int f() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(getContext(), QMMKVFile.FILE_AD)");
        return fromV2.decodeInt(e(), 0);
    }

    private final String g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }

    private final String h() {
        String account;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) {
            return "";
        }
        return account;
    }

    private final String i() {
        return h() + "key_weather_mask_ad_show" + g();
    }

    private final int j() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(getContext(), QMMKVFile.FILE_AD)");
        return fromV2.decodeInt(i(), 0);
    }

    public final boolean a() {
        boolean z16;
        iz2.a aVar = (iz2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105618");
        if (aVar == null) {
            aVar = new iz2.a();
        }
        int sportsMaskAdDayLimit = aVar.getSportsMaskAdDayLimit();
        int f16 = f();
        if (f16 >= sportsMaskAdDayLimit) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("MaskAdFreqHelper", 1, "disableSportsMaskAdReq:", Boolean.valueOf(z16), ", sportsMaskAdReqDayLimit:", Integer.valueOf(sportsMaskAdDayLimit), ", todaySportsMaskAdShowTime:", Integer.valueOf(f16));
        return z16;
    }

    public final boolean b() {
        boolean z16;
        iz2.a aVar = (iz2.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105618");
        if (aVar == null) {
            aVar = new iz2.a();
        }
        int weatherMaskAdDayLimit = aVar.getWeatherMaskAdDayLimit();
        int j3 = j();
        if (j3 >= weatherMaskAdDayLimit) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("MaskAdFreqHelper", 1, "disableWeatherMaskAdReq:", Boolean.valueOf(z16), ", weatherMaskAdReqDayLimit:", Integer.valueOf(weatherMaskAdDayLimit), ", todayWeatherMaskAdShowTime:", Integer.valueOf(j3));
        return z16;
    }

    public final boolean c(@NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (com.tencent.mobileqq.ad.debug.a.f186830a.k()) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        if (from.decodeStringSet("key_qq_shop_mask_ad_show_freq_set", new LinkedHashSet()).isEmpty()) {
            return true;
        }
        return !r0.contains(traceId);
    }

    public final void k(@NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        MMKVOptionEntity from = QMMKV.from(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        Set<String> decodeStringSet = from.decodeStringSet("key_qq_shop_mask_ad_show_freq_set", new LinkedHashSet());
        if (decodeStringSet.size() > 500) {
            decodeStringSet.clear();
        }
        decodeStringSet.add(traceId);
        from.encodeStringSet("key_qq_shop_mask_ad_show_freq_set", decodeStringSet);
    }

    public final void l() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(getContext(), QMMKVFile.FILE_AD)");
        int f16 = f() + 1;
        fromV2.encodeInt(e(), f16);
        QLog.d("MaskAdFreqHelper", 1, "updateSportsMaskAdTodayShow:", Integer.valueOf(f16));
    }

    public final void m() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(getContext(), QMMKVFile.FILE_AD)");
        int j3 = j() + 1;
        fromV2.encodeInt(i(), j3);
        QLog.d("MaskAdFreqHelper", 1, "updateWeatherMaskAdTodayShow:", Integer.valueOf(j3));
    }
}

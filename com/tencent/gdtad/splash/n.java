package com.tencent.gdtad.splash;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/gdtad/splash/n;", "", "", "i", tl.h.F, "", "key", "j", "", "l", "k", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "r", "p", "t", DomainData.DOMAIN_NAME, "v", "<init>", "()V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f109392a = new n();

    n() {
    }

    private final boolean h() {
        if (((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getAmsOlympicShowLimitEnable() && l("realTimeSelectOlympicShowLimit") >= ((IGdtAPI) QRoute.api(IGdtAPI.class)).getOlympicSplashLimit()) {
            return false;
        }
        return true;
    }

    private final boolean i() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        if (System.currentTimeMillis() - fromV2.getLong(j("realTimeRequestTime"), 0L) > ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDuration()) {
            return true;
        }
        return false;
    }

    private final String j(String key) {
        return key + k();
    }

    private final String k() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }

    private final int l(String key) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return fromV2.getInt(j(key), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        if (!((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getAmsOlympicShowLimitEnable()) {
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String j3 = f109392a.j("realTimeSelectOlympicShowLimit");
        fromV2.putInt(j3, fromV2.getInt(j3, 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String str = "realTimeSelectColdLimit" + f109392a.k();
        fromV2.putInt(str, fromV2.getInt(str, 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String str = "realTimeSelectHotLimit" + f109392a.k();
        fromV2.putInt(str, fromV2.getInt(str, 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        String j3 = f109392a.j("realTimeSelectAllLimit");
        fromV2.putInt(j3, fromV2.getInt(j3, 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        fromV2.putLong(f109392a.j("realTimeRequestTime"), System.currentTimeMillis());
    }

    public final boolean f() {
        if (((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashIsEffectiveTime() && i() && l("realTimeSelectColdLimit") < ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashColdLimit() && l("realTimeSelectAllLimit") < ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashAllLimit() && h()) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashIsEffectiveTime() && i() && l("realTimeSelectHotLimit") < ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashHotLimit() && l("realTimeSelectAllLimit") < ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashAllLimit() && h()) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        if (l("realTimeSelectOlympicShowLimit") < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getOlympicSplashLimit()) {
            return true;
        }
        return false;
    }

    public final void n() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.i
            @Override // java.lang.Runnable
            public final void run() {
                n.o();
            }
        }, 16, null, false);
    }

    public final void p() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.k
            @Override // java.lang.Runnable
            public final void run() {
                n.q();
            }
        }, 16, null, false);
    }

    public final void r() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.l
            @Override // java.lang.Runnable
            public final void run() {
                n.s();
            }
        }, 16, null, false);
    }

    public final void t() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.m
            @Override // java.lang.Runnable
            public final void run() {
                n.u();
            }
        }, 16, null, false);
    }

    public final void v() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.j
            @Override // java.lang.Runnable
            public final void run() {
                n.w();
            }
        }, 16, null, false);
    }
}

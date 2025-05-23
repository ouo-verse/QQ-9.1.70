package com.tencent.mobileqq.fe;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0007J\b\u0010\u0016\u001a\u00020\u0010H\u0007R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010 \u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010$\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108F@BX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR*\u0010(\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b'\u0010\u001f\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/fe/d;", "", "", "key", "value", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "count", "timeGap", "j", "g", "Lkotlin/Pair;", "", "f", "curTime", "", "a", "susCount", "lastTime", tl.h.F, DomainData.DOMAIN_NAME, "b", "I", "MAX_SUS_COUNT", "TIME_CHECK_GAP", "e", "()Z", "l", "(Z)V", "safeModeToggleEnable$annotations", "()V", "safeModeToggleEnable", "d", "k", "safeModeEnableValue$annotations", "safeModeEnableValue", "c", "i", "appForeGround$annotations", "appForeGround", "<init>", "FEKitSDK_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes12.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static int MAX_SUS_COUNT;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int TIME_CHECK_GAP;

    /* renamed from: c, reason: collision with root package name */
    public static final d f205825c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f205825c = new d();
        MAX_SUS_COUNT = 5;
        TIME_CHECK_GAP = 5000;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(long curTime) {
        int i3;
        Pair<Long, Integer> f16 = f("SafeMode_Reset_Count_Key_20220909");
        long longValue = f16.component1().longValue();
        int intValue = f16.component2().intValue();
        if (curTime - longValue < TIME_CHECK_GAP) {
            i3 = intValue + 1;
        } else {
            i3 = 1;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(curTime);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        m("SafeMode_Reset_Count_Key_20220909", sb5.toString());
        if (i3 > 3) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean b() {
        if (!c()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d dVar = f205825c;
        Pair<Long, Integer> f16 = dVar.f("SafeMode_Count_Key_20220909");
        long longValue = f16.component1().longValue();
        int intValue = f16.component2().intValue();
        dVar.g();
        if (d()) {
            if (currentTimeMillis - longValue <= 3600000 && !dVar.a(currentTimeMillis)) {
                return true;
            }
            k(false);
        }
        if (dVar.h(intValue, currentTimeMillis, longValue) <= MAX_SUS_COUNT) {
            return false;
        }
        k(true);
        return true;
    }

    public static final boolean c() {
        return f.a().b("AppStatus_Value_Key_20241025");
    }

    public static final boolean d() {
        return f.a().b("SafeMode_Value_Key_20220909");
    }

    public static final boolean e() {
        return f.a().b("SafeMode_ToggleEnabled_20220926");
    }

    private final Pair<Long, Integer> f(String key) {
        long j3;
        List split$default;
        String countAndTime = f.a().g(key);
        int i3 = 1;
        if (!Intrinsics.areEqual("0", countAndTime)) {
            Intrinsics.checkExpressionValueIsNotNull(countAndTime, "countAndTime");
            split$default = StringsKt__StringsKt.split$default((CharSequence) countAndTime, new String[]{"|"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                Integer valueOf = Integer.valueOf((String) split$default.get(1));
                Intrinsics.checkExpressionValueIsNotNull(valueOf, "Integer.valueOf(tmp[1])");
                i3 = valueOf.intValue();
                Long valueOf2 = Long.valueOf((String) split$default.get(0));
                Intrinsics.checkExpressionValueIsNotNull(valueOf2, "java.lang.Long.valueOf(tmp[0])");
                j3 = valueOf2.longValue();
                return new Pair<>(Long.valueOf(j3), Integer.valueOf(i3));
            }
        }
        j3 = 0;
        return new Pair<>(Long.valueOf(j3), Integer.valueOf(i3));
    }

    private final void g() {
        List split$default;
        int i3 = MAX_SUS_COUNT;
        int i16 = TIME_CHECK_GAP;
        String countAndTime = f.a().g("SafeMode_Toggle_GAPCONFIG_20220926");
        if (!Intrinsics.areEqual("0", countAndTime)) {
            Intrinsics.checkExpressionValueIsNotNull(countAndTime, "countAndTime");
            split$default = StringsKt__StringsKt.split$default((CharSequence) countAndTime, new String[]{"|"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                Integer valueOf = Integer.valueOf((String) split$default.get(1));
                Intrinsics.checkExpressionValueIsNotNull(valueOf, "Integer.valueOf(tmp[1])");
                i3 = valueOf.intValue();
                Integer valueOf2 = Integer.valueOf((String) split$default.get(0));
                Intrinsics.checkExpressionValueIsNotNull(valueOf2, "Integer.valueOf(tmp[0])");
                i16 = valueOf2.intValue();
            }
        }
        if (i3 > MAX_SUS_COUNT) {
            MAX_SUS_COUNT = i3;
        }
        if (i16 < TIME_CHECK_GAP) {
            TIME_CHECK_GAP = i16;
        }
    }

    private final int h(int susCount, long curTime, long lastTime) {
        int i3 = 1;
        if (curTime - lastTime < TIME_CHECK_GAP) {
            c.c("FEKitSafeMode", 1, "unsafe start ,time|susCount :" + curTime + QbAddrData.DATA_SPLITER + susCount);
            i3 = 1 + susCount;
        } else {
            c.c("FEKitSafeMode", 1, "safe start ,time|susCount :" + curTime + QbAddrData.DATA_SPLITER + susCount);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(curTime);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        m("SafeMode_Count_Key_20220909", sb5.toString());
        return i3;
    }

    public static final void i(boolean z16) {
        f.a().e("AppStatus_Value_Key_20241025", z16);
    }

    @JvmStatic
    public static final void j(int count, int timeGap) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(timeGap);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(count);
        f.a().f("SafeMode_Toggle_GAPCONFIG_20220926", sb5.toString());
    }

    private static final void k(boolean z16) {
        f.a().e("SafeMode_Value_Key_20220909", z16);
    }

    public static final void l(boolean z16) {
        f.a().e("SafeMode_ToggleEnabled_20220926", z16);
    }

    private final void m(String key, String value) {
        f.a().f(key, value);
    }

    @JvmStatic
    public static final boolean n() {
        long currentTimeMillis;
        long longValue;
        boolean z16;
        try {
            d dVar = f205825c;
            dVar.g();
            currentTimeMillis = System.currentTimeMillis();
            Pair<Long, Integer> f16 = dVar.f("SafeMode_Count_Key_20220909");
            longValue = f16.component1().longValue();
            f16.component2().intValue();
        } catch (Throwable unused) {
        }
        if (!d()) {
            return false;
        }
        if (currentTimeMillis - longValue > 3600000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            k(false);
            return true;
        }
        return false;
    }
}

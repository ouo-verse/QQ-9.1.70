package com.tencent.luggage.wxa.s3;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.rmonitor.base.config.data.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f140021a = new f();

    public static final List b() {
        try {
            return f140021a.a().p().e();
        } catch (e e16) {
            w.b("WxaDeviceLogic", k.FEATURES_KEY + MsgSummary.STR_COLON, e16);
            return null;
        } catch (NullPointerException e17) {
            w.b("WxaDeviceLogic", k.FEATURES_KEY + MsgSummary.STR_COLON, e17);
            return null;
        }
    }

    public static final String c() {
        try {
            String f16 = f140021a.a().p().f();
            if (f16 == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(f16, "activateDevice.savedDeviceInfo.hostAppId  ?: \"\"");
            return f16;
        } catch (e e16) {
            w.b("WxaDeviceLogic", "hostAppId" + MsgSummary.STR_COLON, e16);
            return "";
        } catch (NullPointerException e17) {
            w.b("WxaDeviceLogic", "hostAppId" + MsgSummary.STR_COLON, e17);
            return "";
        }
    }

    public final String d() {
        try {
            String l3 = f140021a.a().p().l();
            if (l3 == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(l3, "activateDevice.savedDeviceInfo.token ?: \"\"");
            return l3;
        } catch (e e16) {
            w.b("WxaDeviceLogic", "token" + MsgSummary.STR_COLON, e16);
            return "";
        } catch (NullPointerException e17) {
            w.b("WxaDeviceLogic", "token" + MsgSummary.STR_COLON, e17);
            return "";
        }
    }

    public final String e() {
        try {
            String m3 = f140021a.a().p().m();
            if (m3 == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(m3, "activateDevice.savedDeviceInfo.userName ?: \"\"");
            return m3;
        } catch (e e16) {
            w.b("WxaDeviceLogic", "username" + MsgSummary.STR_COLON, e16);
            return "";
        } catch (NullPointerException e17) {
            w.b("WxaDeviceLogic", "username" + MsgSummary.STR_COLON, e17);
            return "";
        }
    }

    public final boolean f() {
        return a().B();
    }

    public final boolean g() {
        return a().g();
    }

    public final void h() {
        a().init();
    }

    public final boolean i() {
        return g();
    }

    public final c a() {
        com.tencent.luggage.wxa.h1.b a16 = com.tencent.luggage.wxa.h1.e.a(c.class);
        Intrinsics.checkNotNullExpressionValue(a16, "customize(IActivateDevice::class.java)");
        return (c) a16;
    }
}

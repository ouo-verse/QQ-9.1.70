package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.fu;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ad {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388016a;

        static {
            int[] iArr = new int[gf.values().length];
            f388016a = iArr;
            try {
                iArr[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388016a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388016a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388016a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f388016a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f388016a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f388016a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f388016a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f388016a[gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f388016a[gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends hq<T, ?>> hb a(Context context, T t16, gf gfVar) {
        return b(context, t16, gfVar, !gfVar.equals(gf.Registration), context.getPackageName(), s.c(context).d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends hq<T, ?>> hb b(Context context, T t16, gf gfVar, boolean z16, String str, String str2) {
        return c(context, t16, gfVar, z16, str, str2, true);
    }

    protected static <T extends hq<T, ?>> hb c(Context context, T t16, gf gfVar, boolean z16, String str, String str2, boolean z17) {
        byte[] e16 = fv.e(t16);
        if (e16 == null) {
            jz4.c.m("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        hb hbVar = new hb();
        if (z16) {
            String t17 = s.c(context).t();
            if (TextUtils.isEmpty(t17)) {
                jz4.c.m("regSecret is empty, return null");
                return null;
            }
            try {
                e16 = fu.c(com.xiaomi.push.aa.b(t17), e16);
            } catch (Exception unused) {
                jz4.c.B("encryption error. ");
            }
        }
        gu guVar = new gu();
        guVar.f389190a = 5L;
        guVar.f24774a = "fakeid";
        hbVar.a(guVar);
        hbVar.a(ByteBuffer.wrap(e16));
        hbVar.a(gfVar);
        hbVar.b(z17);
        hbVar.b(str);
        hbVar.a(z16);
        hbVar.a(str2);
        return hbVar;
    }

    public static hq d(Context context, hb hbVar) {
        byte[] m381a;
        if (hbVar.m383b()) {
            byte[] j3 = f.j(context, hbVar, d.ASSEMBLE_PUSH_FCM);
            if (j3 == null) {
                j3 = com.xiaomi.push.aa.b(s.c(context).t());
            }
            try {
                m381a = fu.b(j3, hbVar.m381a());
            } catch (Exception e16) {
                throw new l("the aes decrypt failed.", e16);
            }
        } else {
            m381a = hbVar.m381a();
        }
        hq e17 = e(hbVar.a(), hbVar.f24808b);
        if (e17 != null) {
            fv.d(e17, m381a);
        }
        return e17;
    }

    private static hq e(gf gfVar, boolean z16) {
        switch (a.f388016a[gfVar.ordinal()]) {
            case 1:
                return new hg();
            case 2:
                return new hm();
            case 3:
                return new hk();
            case 4:
                return new ho();
            case 5:
                return new hi();
            case 6:
                return new gv();
            case 7:
                return new ha();
            case 8:
                return new hh();
            case 9:
                if (z16) {
                    return new he();
                }
                gw gwVar = new gw();
                gwVar.a(true);
                return gwVar;
            case 10:
                return new ha();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends hq<T, ?>> hb f(Context context, T t16, gf gfVar, boolean z16, String str, String str2) {
        return c(context, t16, gfVar, z16, str, str2, false);
    }
}

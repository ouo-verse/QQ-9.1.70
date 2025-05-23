package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
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

/* compiled from: P */
/* loaded from: classes28.dex */
public class ai {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f389595a;

        static {
            int[] iArr = new int[gf.values().length];
            f389595a = iArr;
            try {
                iArr[gf.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f389595a[gf.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f389595a[gf.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f389595a[gf.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f389595a[gf.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f389595a[gf.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f389595a[gf.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f389595a[gf.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f389595a[gf.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f389595a[gf.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static hq a(Context context, hb hbVar) {
        if (hbVar.m383b()) {
            return null;
        }
        byte[] m381a = hbVar.m381a();
        hq b16 = b(hbVar.a(), hbVar.f24808b);
        if (b16 != null) {
            fv.d(b16, m381a);
        }
        return b16;
    }

    private static hq b(gf gfVar, boolean z16) {
        switch (a.f389595a[gfVar.ordinal()]) {
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
}

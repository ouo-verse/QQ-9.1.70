package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bn;
import com.xiaomi.push.bx;
import com.xiaomi.push.de;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.ha;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.al;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes28.dex */
public class af {

    /* renamed from: b, reason: collision with root package name */
    private static af f388017b;

    /* renamed from: c, reason: collision with root package name */
    private static Queue<String> f388018c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f388019d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f388020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388021a;

        static {
            int[] iArr = new int[gf.values().length];
            f388021a = iArr;
            try {
                iArr[gf.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388021a[gf.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388021a[gf.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388021a[gf.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f388021a[gf.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f388021a[gf.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f388021a[gf.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f388020a = applicationContext;
        if (applicationContext == null) {
            this.f388020a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i3) {
        return com.xiaomi.push.service.x.O(context, str, map, i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PushMessageHandler.a c(hb hbVar, boolean z16, byte[] bArr, String str, int i3, Intent intent) {
        gs gsVar;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            hq d16 = ad.d(this.f388020a, hbVar);
            if (d16 == null) {
                jz4.c.B("receiving an un-recognized message. " + hbVar.f389249a);
                df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "18");
                z.f(this.f388020a, hbVar, z16);
                return null;
            }
            gf a16 = hbVar.a();
            jz4.c.p("processing a message, action=", a16, ", hasNotified=", Boolean.valueOf(z16));
            switch (a.f388021a[a16.ordinal()]) {
                case 1:
                    if (!hbVar.m383b()) {
                        jz4.c.B("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (s.c(this.f388020a).w() && !z16) {
                        jz4.c.m("receive a message in pause state. drop it");
                        df.a(this.f388020a).g(this.f388020a.getPackageName(), de.e(i3), str, "12");
                        return null;
                    }
                    hi hiVar = (hi) d16;
                    gr a17 = hiVar.a();
                    if (a17 == null) {
                        jz4.c.B("receive an empty message without push content, drop it");
                        df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "22");
                        z.g(this.f388020a, hbVar, z16);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z16) {
                        if (com.xiaomi.push.service.x.J(hbVar)) {
                            MiPushClient.U(this.f388020a, a17.m333a(), hbVar.m375a(), hbVar.f389250b, a17.b());
                        } else {
                            if (hbVar.m375a() != null) {
                                gsVar = new gs(hbVar.m375a());
                            } else {
                                gsVar = new gs();
                            }
                            if (gsVar.m342a() == null) {
                                gsVar.a(new HashMap());
                            }
                            gsVar.m342a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.V(this.f388020a, a17.m333a(), gsVar, a17.b());
                        }
                    }
                    if (!z16) {
                        if (!TextUtils.isEmpty(hiVar.d()) && MiPushClient.k(this.f388020a, hiVar.d()) < 0) {
                            MiPushClient.g(this.f388020a, hiVar.d());
                        } else if (!TextUtils.isEmpty(hiVar.c()) && MiPushClient.h0(this.f388020a, hiVar.c()) < 0) {
                            MiPushClient.j(this.f388020a, hiVar.c());
                        }
                    }
                    gs gsVar2 = hbVar.f24802a;
                    String str2 = (gsVar2 == null || gsVar2.m342a() == null) ? null : hbVar.f24802a.f24766a.get("jobkey");
                    String str3 = str2;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = a17.m333a();
                    }
                    if (!z16 && m(this.f388020a, str2)) {
                        jz4.c.m("drop a duplicate message, key=" + str2);
                        df.a(this.f388020a).j(this.f388020a.getPackageName(), de.e(i3), str, "2:" + str2);
                    } else {
                        MiPushMessage b16 = p.b(hiVar, hbVar.m375a(), z16);
                        if (b16.getPassThrough() == 0 && !z16 && com.xiaomi.push.service.x.L(b16.getExtra())) {
                            com.xiaomi.push.service.x.r(this.f388020a, hbVar, bArr);
                            return null;
                        }
                        String u16 = com.xiaomi.push.service.x.u(b16.getExtra(), intExtra);
                        jz4.c.p("receive a message, msgid=", a17.m333a(), ", jobkey=", str2, ", btn=", Integer.valueOf(intExtra), ", typeId=", u16, ", hasNotified=", Boolean.valueOf(z16));
                        if (z16 && b16.getExtra() != null && !TextUtils.isEmpty(u16)) {
                            Map<String, String> extra = b16.getExtra();
                            if (intExtra != 0 && hbVar.m375a() != null) {
                                ag.h(this.f388020a).o(hbVar.m375a().c(), intExtra);
                            }
                            if (com.xiaomi.push.service.x.J(hbVar)) {
                                Intent a18 = a(this.f388020a, hbVar.f389250b, extra, intExtra);
                                a18.putExtra("eventMessageType", i3);
                                a18.putExtra("messageId", str);
                                a18.putExtra("jobkey", str3);
                                String c16 = a17.c();
                                if (!TextUtils.isEmpty(c16)) {
                                    a18.putExtra("payload", c16);
                                }
                                this.f388020a.startActivity(a18);
                                z.b(this.f388020a, hbVar);
                                df.a(this.f388020a).f(this.f388020a.getPackageName(), de.e(i3), str, 3006, u16);
                                jz4.c.n("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f388020a;
                                Intent a19 = a(context, context.getPackageName(), extra, intExtra);
                                if (a19 != null) {
                                    if (!u16.equals(com.xiaomi.push.service.r.f389776c)) {
                                        a19.putExtra("key_message", b16);
                                        a19.putExtra("eventMessageType", i3);
                                        a19.putExtra("messageId", str);
                                        a19.putExtra("jobkey", str3);
                                    }
                                    this.f388020a.startActivity(a19);
                                    z.b(this.f388020a, hbVar);
                                    jz4.c.n("PushMessageProcessor", "start activity succ");
                                    df.a(this.f388020a).f(this.f388020a.getPackageName(), de.e(i3), str, 1006, u16);
                                    if (u16.equals(com.xiaomi.push.service.r.f389776c)) {
                                        df.a(this.f388020a).g(this.f388020a.getPackageName(), de.e(i3), str, "13");
                                    }
                                } else {
                                    jz4.c.C("PushMessageProcessor", "missing target intent for message: " + a17.m333a() + ", typeId=" + u16);
                                }
                            }
                            jz4.c.n("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = b16;
                    }
                    if (hbVar.m375a() == null && !z16) {
                        k(hiVar, hbVar);
                    }
                    return miPushMessage;
                case 2:
                    hg hgVar = (hg) d16;
                    String str4 = s.c(this.f388020a).f388093d;
                    if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, hgVar.m405a())) {
                        long b17 = ag.h(this.f388020a).b();
                        if (b17 > 0 && SystemClock.elapsedRealtime() - b17 > 900000) {
                            jz4.c.m("The received registration result has expired.");
                            df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "26");
                            return null;
                        }
                        s.c(this.f388020a).f388093d = null;
                        if (hgVar.f24828a == 0) {
                            s.c(this.f388020a).o(hgVar.f389297e, hgVar.f389298f, hgVar.f389304l);
                            g.a(this.f388020a);
                            df.a(this.f388020a).f(this.f388020a.getPackageName(), de.e(i3), str, 6006, "1");
                        } else {
                            df.a(this.f388020a).f(this.f388020a.getPackageName(), de.e(i3), str, 6006, "2");
                        }
                        if (!TextUtils.isEmpty(hgVar.f389297e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(hgVar.f389297e);
                        }
                        MiPushCommandMessage a26 = p.a(ed.COMMAND_REGISTER.f24710a, arrayList3, hgVar.f24828a, hgVar.f389296d, null, hgVar.m406a());
                        ag.h(this.f388020a).W();
                        return a26;
                    }
                    jz4.c.m("bad Registration result:");
                    df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "21");
                    return null;
                case 3:
                    if (!hbVar.m383b()) {
                        jz4.c.B("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hm) d16).f389357a == 0) {
                        s.c(this.f388020a).e();
                        MiPushClient.n(this.f388020a);
                    }
                    PushMessageHandler.a();
                    return miPushMessage;
                case 4:
                    hk hkVar = (hk) d16;
                    if (hkVar.f389336a == 0) {
                        MiPushClient.j(this.f388020a, hkVar.b());
                    }
                    if (!TextUtils.isEmpty(hkVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(hkVar.b());
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("resp-cmd:");
                    ed edVar = ed.COMMAND_SUBSCRIBE_TOPIC;
                    sb5.append(edVar);
                    sb5.append(", ");
                    sb5.append(hkVar.a());
                    jz4.c.D(sb5.toString());
                    return p.a(edVar.f24710a, arrayList2, hkVar.f389336a, hkVar.f389339d, hkVar.c(), null);
                case 5:
                    ho hoVar = (ho) d16;
                    if (hoVar.f389366a == 0) {
                        MiPushClient.T(this.f388020a, hoVar.b());
                    }
                    if (!TextUtils.isEmpty(hoVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(hoVar.b());
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("resp-cmd:");
                    ed edVar2 = ed.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb6.append(edVar2);
                    sb6.append(", ");
                    sb6.append(hoVar.a());
                    jz4.c.D(sb6.toString());
                    return p.a(edVar2.f24710a, arrayList, hoVar.f389366a, hoVar.f389369d, hoVar.c(), null);
                case 6:
                    bx.f(this.f388020a.getPackageName(), this.f388020a, d16, gf.Command, bArr.length);
                    ha haVar = (ha) d16;
                    String b18 = haVar.b();
                    List<String> m369a = haVar.m369a();
                    if (haVar.f389237a == 0) {
                        if (TextUtils.equals(b18, ed.COMMAND_SET_ACCEPT_TIME.f24710a) && m369a != null && m369a.size() > 1) {
                            MiPushClient.e(this.f388020a, m369a.get(0), m369a.get(1));
                            if (QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT.equals(m369a.get(0)) && QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT.equals(m369a.get(1))) {
                                s.c(this.f388020a).j(true);
                            } else {
                                s.c(this.f388020a).j(false);
                            }
                            m369a = f(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m369a);
                        } else if (TextUtils.equals(b18, ed.COMMAND_SET_ALIAS.f24710a) && m369a != null && m369a.size() > 0) {
                            MiPushClient.g(this.f388020a, m369a.get(0));
                        } else if (TextUtils.equals(b18, ed.COMMAND_UNSET_ALIAS.f24710a) && m369a != null && m369a.size() > 0) {
                            MiPushClient.P(this.f388020a, m369a.get(0));
                        } else if (TextUtils.equals(b18, ed.COMMAND_SET_ACCOUNT.f24710a) && m369a != null && m369a.size() > 0) {
                            MiPushClient.f(this.f388020a, m369a.get(0));
                        } else if (TextUtils.equals(b18, ed.COMMAND_UNSET_ACCOUNT.f24710a) && m369a != null && m369a.size() > 0) {
                            MiPushClient.O(this.f388020a, m369a.get(0));
                        } else if (TextUtils.equals(b18, ed.COMMAND_CHK_VDEVID.f24710a)) {
                            return null;
                        }
                    }
                    List<String> list = m369a;
                    jz4.c.D("resp-cmd:" + b18 + ", " + haVar.a());
                    return p.a(b18, list, haVar.f389237a, haVar.f389240d, haVar.c(), null);
                case 7:
                    bx.f(this.f388020a.getPackageName(), this.f388020a, d16, gf.Notification, bArr.length);
                    if (d16 instanceof gw) {
                        gw gwVar = (gw) d16;
                        String a27 = gwVar.a();
                        jz4.c.D("resp-type:" + gwVar.b() + ", code:" + gwVar.f389210a + ", " + a27);
                        if (gp.DisablePushMessage.f24750a.equalsIgnoreCase(gwVar.f389213d)) {
                            if (gwVar.f389210a == 0) {
                                synchronized (ac.class) {
                                    if (ac.b(this.f388020a).f(a27)) {
                                        ac.b(this.f388020a).h(a27);
                                        ac b19 = ac.b(this.f388020a);
                                        v vVar = v.DISABLE_PUSH;
                                        if ("syncing".equals(b19.c(vVar))) {
                                            ac.b(this.f388020a).d(vVar, "synced");
                                            MiPushClient.q(this.f388020a);
                                            MiPushClient.p(this.f388020a);
                                            PushMessageHandler.a();
                                            ag.h(this.f388020a).N();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(ac.b(this.f388020a).c(v.DISABLE_PUSH))) {
                                synchronized (ac.class) {
                                    if (ac.b(this.f388020a).f(a27)) {
                                        if (ac.b(this.f388020a).a(a27) < 10) {
                                            ac.b(this.f388020a).g(a27);
                                            ag.h(this.f388020a).I(true, a27);
                                        } else {
                                            ac.b(this.f388020a).h(a27);
                                        }
                                    }
                                }
                            } else {
                                ac.b(this.f388020a).h(a27);
                            }
                        } else if (gp.EnablePushMessage.f24750a.equalsIgnoreCase(gwVar.f389213d)) {
                            if (gwVar.f389210a == 0) {
                                synchronized (ac.class) {
                                    if (ac.b(this.f388020a).f(a27)) {
                                        ac.b(this.f388020a).h(a27);
                                        ac b26 = ac.b(this.f388020a);
                                        v vVar2 = v.ENABLE_PUSH;
                                        if ("syncing".equals(b26.c(vVar2))) {
                                            ac.b(this.f388020a).d(vVar2, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(ac.b(this.f388020a).c(v.ENABLE_PUSH))) {
                                synchronized (ac.class) {
                                    if (ac.b(this.f388020a).f(a27)) {
                                        if (ac.b(this.f388020a).a(a27) < 10) {
                                            ac.b(this.f388020a).g(a27);
                                            ag.h(this.f388020a).I(false, a27);
                                        } else {
                                            ac.b(this.f388020a).h(a27);
                                        }
                                    }
                                }
                            } else {
                                ac.b(this.f388020a).h(a27);
                            }
                        } else if (gp.ThirdPartyRegUpdate.f24750a.equalsIgnoreCase(gwVar.f389213d)) {
                            o(gwVar);
                        } else if (gp.UploadTinyData.f24750a.equalsIgnoreCase(gwVar.f389213d)) {
                            h(gwVar);
                        }
                    } else if (d16 instanceof he) {
                        he heVar = (he) d16;
                        if ("registration id expired".equalsIgnoreCase(heVar.f389261d)) {
                            List<String> w3 = MiPushClient.w(this.f388020a);
                            List<String> x16 = MiPushClient.x(this.f388020a);
                            List<String> y16 = MiPushClient.y(this.f388020a);
                            String v3 = MiPushClient.v(this.f388020a);
                            jz4.c.D("resp-type:" + heVar.f389261d + ", " + heVar.m390a());
                            MiPushClient.I(this.f388020a, gt.RegIdExpired);
                            for (String str5 : w3) {
                                MiPushClient.P(this.f388020a, str5);
                                MiPushClient.Y(this.f388020a, str5, null);
                            }
                            for (String str6 : x16) {
                                MiPushClient.T(this.f388020a, str6);
                                MiPushClient.f0(this.f388020a, str6, null);
                            }
                            for (String str7 : y16) {
                                MiPushClient.O(this.f388020a, str7);
                                MiPushClient.b0(this.f388020a, str7, null);
                            }
                            String[] split = v3.split(",");
                            if (split.length == 2) {
                                MiPushClient.N(this.f388020a);
                                MiPushClient.e(this.f388020a, split[0], split[1]);
                            }
                        } else if (gp.ClientInfoUpdateOk.f24750a.equalsIgnoreCase(heVar.f389261d)) {
                            if (heVar.m391a() != null && heVar.m391a().containsKey("app_version")) {
                                s.c(this.f388020a).g(heVar.m391a().get("app_version"));
                            }
                        } else {
                            try {
                                if (gp.NormalClientConfigUpdate.f24750a.equalsIgnoreCase(heVar.f389261d)) {
                                    hd hdVar = new hd();
                                    fv.d(hdVar, heVar.m396a());
                                    com.xiaomi.push.service.l.d(ah.d(this.f388020a), hdVar);
                                } else if (gp.CustomClientConfigUpdate.f24750a.equalsIgnoreCase(heVar.f389261d)) {
                                    hc hcVar = new hc();
                                    fv.d(hcVar, heVar.m396a());
                                    com.xiaomi.push.service.l.c(ah.d(this.f388020a), hcVar);
                                } else if (gp.SyncInfoResult.f24750a.equalsIgnoreCase(heVar.f389261d)) {
                                    w.c(this.f388020a, heVar);
                                } else if (gp.ForceSync.f24750a.equalsIgnoreCase(heVar.f389261d)) {
                                    jz4.c.m("receive force sync notification");
                                    w.d(this.f388020a, false);
                                } else if (gp.CancelPushMessage.f24750a.equals(heVar.f389261d)) {
                                    jz4.c.D("resp-type:" + heVar.f389261d + ", " + heVar.m390a());
                                    if (heVar.m391a() != null) {
                                        int i16 = -2;
                                        if (heVar.m391a().containsKey(com.xiaomi.push.service.r.M)) {
                                            String str8 = heVar.m391a().get(com.xiaomi.push.service.r.M);
                                            if (!TextUtils.isEmpty(str8)) {
                                                try {
                                                    i16 = Integer.parseInt(str8);
                                                } catch (NumberFormatException e16) {
                                                    e16.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i16 >= -1) {
                                            MiPushClient.r(this.f388020a, i16);
                                        } else {
                                            MiPushClient.s(this.f388020a, heVar.m391a().containsKey(com.xiaomi.push.service.r.K) ? heVar.m391a().get(com.xiaomi.push.service.r.K) : "", heVar.m391a().containsKey(com.xiaomi.push.service.r.L) ? heVar.m391a().get(com.xiaomi.push.service.r.L) : "");
                                        }
                                    }
                                    j(heVar);
                                } else if (gp.HybridRegisterResult.f24750a.equals(heVar.f389261d)) {
                                    try {
                                        hg hgVar2 = new hg();
                                        fv.d(hgVar2, heVar.m396a());
                                        k.a(this.f388020a, hgVar2);
                                    } catch (hu e17) {
                                        jz4.c.q(e17);
                                    }
                                } else if (gp.HybridUnregisterResult.f24750a.equals(heVar.f389261d)) {
                                    try {
                                        hm hmVar = new hm();
                                        fv.d(hmVar, heVar.m396a());
                                        k.b(this.f388020a, hmVar);
                                    } catch (hu e18) {
                                        jz4.c.q(e18);
                                    }
                                } else if (!gp.PushLogUpload.f24750a.equals(heVar.f389261d)) {
                                    if (gp.DetectAppAlive.f24750a.equals(heVar.f389261d)) {
                                        jz4.c.w("receive detect msg");
                                        q(heVar);
                                    } else if (al.b(heVar)) {
                                        jz4.c.w("receive notification handle by cpra");
                                    }
                                }
                            } catch (hu unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (l e19) {
            jz4.c.q(e19);
            i(hbVar);
            df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "19");
            z.f(this.f388020a, hbVar, z16);
            return null;
        } catch (hu e26) {
            jz4.c.q(e26);
            jz4.c.B("receive a message which action string is not valid. is the reg expired?");
            df.a(this.f388020a).i(this.f388020a.getPackageName(), de.e(i3), str, "20");
            z.f(this.f388020a, hbVar, z16);
            return null;
        }
    }

    private PushMessageHandler.a d(hb hbVar, byte[] bArr) {
        String str = null;
        try {
            hq d16 = ad.d(this.f388020a, hbVar);
            if (d16 == null) {
                jz4.c.B("message arrived: receiving an un-recognized message. " + hbVar.f389249a);
                return null;
            }
            gf a16 = hbVar.a();
            jz4.c.m("message arrived: processing an arrived message, action=" + a16);
            if (a.f388021a[a16.ordinal()] != 1) {
                return null;
            }
            if (!hbVar.m383b()) {
                jz4.c.B("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hi hiVar = (hi) d16;
            gr a17 = hiVar.a();
            if (a17 == null) {
                jz4.c.B("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gs gsVar = hbVar.f24802a;
            if (gsVar != null && gsVar.m342a() != null) {
                str = hbVar.f24802a.f24766a.get("jobkey");
            }
            MiPushMessage b16 = p.b(hiVar, hbVar.m375a(), false);
            b16.setArrivedMessage(true);
            jz4.c.m("message arrived: receive a message, msgid=" + a17.m333a() + ", jobkey=" + str);
            return b16;
        } catch (l e16) {
            jz4.c.q(e16);
            jz4.c.B("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (hu e17) {
            jz4.c.q(e17);
            jz4.c.B("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static af e(Context context) {
        if (f388017b == null) {
            f388017b = new af(context);
        }
        return f388017b;
    }

    private void g() {
        SharedPreferences sharedPreferences = this.f388020a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0L)) > 1800000) {
            MiPushClient.I(this.f388020a, gt.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    private void h(gw gwVar) {
        boolean z16;
        String a16 = gwVar.a();
        jz4.c.w("receive ack " + a16);
        Map<String, String> m356a = gwVar.m356a();
        if (m356a != null) {
            String str = m356a.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                jz4.c.w("receive ack : messageId = " + a16 + "  realSource = " + str);
                bn b16 = bn.b(this.f388020a);
                if (gwVar.f389210a == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                b16.j(a16, str, Boolean.valueOf(z16));
            }
        }
    }

    private void i(hb hbVar) {
        jz4.c.m("receive a message but decrypt failed. report now.");
        he heVar = new he(hbVar.m375a().f24764a, false);
        heVar.c(gp.DecryptMessageFail.f24750a);
        heVar.b(hbVar.m376a());
        heVar.d(hbVar.f389250b);
        HashMap hashMap = new HashMap();
        heVar.f24813a = hashMap;
        hashMap.put("regid", MiPushClient.E(this.f388020a));
        ag.h(this.f388020a).y(heVar, gf.Notification, false, null);
    }

    private void j(he heVar) {
        gw gwVar = new gw();
        gwVar.c(gp.CancelPushMessageACK.f24750a);
        gwVar.a(heVar.m390a());
        gwVar.a(heVar.a());
        gwVar.b(heVar.b());
        gwVar.e(heVar.d());
        gwVar.a(0L);
        gwVar.d("success clear push message.");
        ag.h(this.f388020a).C(gwVar, gf.Notification, false, true, null, false, this.f388020a.getPackageName(), s.c(this.f388020a).d(), false);
    }

    private void k(hi hiVar, hb hbVar) {
        gs m375a = hbVar.m375a();
        if (m375a != null) {
            m375a = com.xiaomi.push.service.ac.a(m375a.m340a());
        }
        gv gvVar = new gv();
        gvVar.b(hiVar.b());
        gvVar.a(hiVar.m414a());
        gvVar.a(hiVar.a().a());
        if (!TextUtils.isEmpty(hiVar.c())) {
            gvVar.c(hiVar.c());
        }
        if (!TextUtils.isEmpty(hiVar.d())) {
            gvVar.d(hiVar.d());
        }
        gvVar.a(fv.b(this.f388020a, hbVar));
        ag.h(this.f388020a).w(gvVar, gf.AckMessage, m375a);
    }

    private void l(String str, long j3, d dVar) {
        v b16 = u.b(dVar);
        if (b16 == null) {
            return;
        }
        if (j3 == 0) {
            synchronized (ac.class) {
                if (ac.b(this.f388020a).f(str)) {
                    ac.b(this.f388020a).h(str);
                    if ("syncing".equals(ac.b(this.f388020a).c(b16))) {
                        ac.b(this.f388020a).d(b16, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(ac.b(this.f388020a).c(b16))) {
            synchronized (ac.class) {
                if (ac.b(this.f388020a).f(str)) {
                    if (ac.b(this.f388020a).a(str) < 10) {
                        ac.b(this.f388020a).g(str);
                        ag.h(this.f388020a).E(str, b16, dVar, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
                    } else {
                        ac.b(this.f388020a).h(str);
                    }
                }
            }
            return;
        }
        ac.b(this.f388020a).h(str);
    }

    private static boolean m(Context context, String str) {
        synchronized (f388019d) {
            s.c(context);
            SharedPreferences b16 = s.b(context);
            if (f388018c == null) {
                String[] split = b16.getString("pref_msg_ids", "").split(",");
                f388018c = new LinkedList();
                for (String str2 : split) {
                    f388018c.add(str2);
                }
            }
            if (f388018c.contains(str)) {
                return true;
            }
            f388018c.add(str);
            if (f388018c.size() > 25) {
                f388018c.poll();
            }
            String d16 = com.xiaomi.push.ag.d(f388018c, ",");
            SharedPreferences.Editor edit = b16.edit();
            edit.putString("pref_msg_ids", d16);
            Cif.a(edit);
            return false;
        }
    }

    private boolean n(hb hbVar) {
        Map<String, String> m342a;
        if (hbVar.m375a() == null) {
            m342a = null;
        } else {
            m342a = hbVar.m375a().m342a();
        }
        if (m342a == null) {
            return false;
        }
        String str = m342a.get("push_server_action");
        if (!TextUtils.equals(str, "hybrid_message") && !TextUtils.equals(str, "platform_message")) {
            return false;
        }
        return true;
    }

    private void o(gw gwVar) {
        jz4.c.z("ASSEMBLE_PUSH : " + gwVar.toString());
        String a16 = gwVar.a();
        Map<String, String> m356a = gwVar.m356a();
        if (m356a != null) {
            String str = m356a.get("RegInfo");
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + q.FCM.name())) {
                    jz4.c.m("ASSEMBLE_PUSH : receive fcm token sync ack");
                    Context context = this.f388020a;
                    d dVar = d.ASSEMBLE_PUSH_FCM;
                    f.m(context, dVar, str);
                    l(a16, gwVar.f389210a, dVar);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("brand:");
                q qVar = q.HUAWEI;
                sb5.append(qVar.name());
                if (!str.contains(sb5.toString())) {
                    if (!str.contains("channel:" + qVar.name())) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("brand:");
                        q qVar2 = q.OPPO;
                        sb6.append(qVar2.name());
                        if (!str.contains(sb6.toString())) {
                            if (!str.contains("channel:" + qVar2.name())) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("brand:");
                                q qVar3 = q.VIVO;
                                sb7.append(qVar3.name());
                                if (!str.contains(sb7.toString())) {
                                    if (!str.contains("channel:" + qVar3.name())) {
                                        return;
                                    }
                                }
                                jz4.c.m("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                Context context2 = this.f388020a;
                                d dVar2 = d.ASSEMBLE_PUSH_FTOS;
                                f.m(context2, dVar2, str);
                                l(a16, gwVar.f389210a, dVar2);
                                return;
                            }
                        }
                        jz4.c.m("ASSEMBLE_PUSH : receive COS token sync ack");
                        Context context3 = this.f388020a;
                        d dVar3 = d.ASSEMBLE_PUSH_COS;
                        f.m(context3, dVar3, str);
                        l(a16, gwVar.f389210a, dVar3);
                        return;
                    }
                }
                jz4.c.m("ASSEMBLE_PUSH : receive hw token sync ack");
                Context context4 = this.f388020a;
                d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
                f.m(context4, dVar4, str);
                l(a16, gwVar.f389210a, dVar4);
            }
        }
    }

    private void p(hb hbVar) {
        gs m375a = hbVar.m375a();
        if (m375a != null) {
            m375a = com.xiaomi.push.service.ac.a(m375a.m340a());
        }
        gv gvVar = new gv();
        gvVar.b(hbVar.m376a());
        gvVar.a(m375a.m341a());
        gvVar.a(m375a.m339a());
        if (!TextUtils.isEmpty(m375a.m346b())) {
            gvVar.c(m375a.m346b());
        }
        gvVar.a(fv.b(this.f388020a, hbVar));
        ag.h(this.f388020a).y(gvVar, gf.AckMessage, false, m375a);
    }

    private void q(he heVar) {
        Map<String, String> m391a = heVar.m391a();
        if (m391a == null) {
            jz4.c.m("detect failed because null");
            return;
        }
        String str = (String) com.xiaomi.push.service.k.g(m391a, "pkgList", null);
        if (TextUtils.isEmpty(str)) {
            jz4.c.m("detect failed because empty");
            return;
        }
        Map<String, String> i3 = com.xiaomi.push.g.i(this.f388020a, str);
        if (i3 != null) {
            String str2 = i3.get("alive");
            String str3 = i3.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                he heVar2 = new he();
                heVar2.a(heVar.m390a());
                heVar2.b(heVar.b());
                heVar2.d(heVar.d());
                heVar2.c(gp.DetectAppAliveResult.f24750a);
                HashMap hashMap = new HashMap();
                heVar2.f24813a = hashMap;
                hashMap.put("alive", str2);
                if (Boolean.parseBoolean((String) com.xiaomi.push.service.k.g(m391a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
                    heVar2.f24813a.put("notAlive", str3);
                }
                ag.h(this.f388020a).y(heVar2, gf.Notification, false, null);
                return;
            }
            jz4.c.w("detect failed because no alive process");
            return;
        }
        jz4.c.m("detect failed because get status illegal");
    }

    public PushMessageHandler.a b(Intent intent) {
        String action = intent.getAction();
        jz4.c.m("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                jz4.c.B("receiving an empty message, drop");
                df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, "12");
                return null;
            }
            hb hbVar = new hb();
            try {
                fv.d(hbVar, byteArrayExtra);
                s c16 = s.c(this.f388020a);
                gs m375a = hbVar.m375a();
                gf a16 = hbVar.a();
                gf gfVar = gf.SendMessage;
                if (a16 == gfVar && m375a != null && !c16.w() && !booleanExtra) {
                    m375a.a("mrt", stringExtra);
                    m375a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!n(hbVar)) {
                        p(hbVar);
                    } else {
                        jz4.c.w("this is a mina's message, ack later");
                        m375a.a("__hybrid_message_ts", String.valueOf(m375a.m339a()));
                        m375a.a("__hybrid_device_status", String.valueOf((int) fv.b(this.f388020a, hbVar)));
                    }
                }
                String str = "";
                if (hbVar.a() == gfVar && !hbVar.m383b()) {
                    if (com.xiaomi.push.service.x.J(hbVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hbVar.b();
                        if (m375a != null) {
                            str = m375a.m341a();
                        }
                        objArr[1] = str;
                        jz4.c.m(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, String.format("13: %1$s", hbVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hbVar.b();
                        if (m375a != null) {
                            str = m375a.m341a();
                        }
                        objArr2[1] = str;
                        jz4.c.m(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, String.format("14: %1$s", hbVar.b()));
                    }
                    z.c(this.f388020a, hbVar, booleanExtra);
                    return null;
                }
                if (hbVar.a() == gfVar && hbVar.m383b() && com.xiaomi.push.service.x.J(hbVar) && (!booleanExtra || m375a == null || m375a.m342a() == null || !m375a.m342a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hbVar.b();
                    if (m375a != null) {
                        str = m375a.m341a();
                    }
                    objArr3[1] = str;
                    jz4.c.m(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, String.format("25: %1$s", hbVar.b()));
                    z.e(this.f388020a, hbVar, booleanExtra);
                    return null;
                }
                if (!c16.s() && hbVar.f389249a != gf.Registration) {
                    if (com.xiaomi.push.service.x.J(hbVar)) {
                        return c(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    z.h(this.f388020a, hbVar, booleanExtra);
                    boolean u16 = c16.u();
                    jz4.c.B("receive message without registration. need re-register!registered?" + u16);
                    df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, "15");
                    if (u16) {
                        g();
                    }
                } else if (c16.s() && c16.x()) {
                    if (hbVar.f389249a == gf.UnRegistration) {
                        if (hbVar.m383b()) {
                            c16.e();
                            MiPushClient.n(this.f388020a);
                            PushMessageHandler.a();
                        } else {
                            jz4.c.B("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        z.h(this.f388020a, hbVar, booleanExtra);
                        MiPushClient.i0(this.f388020a);
                    }
                } else {
                    return c(hbVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (hu e16) {
                df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, "16");
                jz4.c.q(e16);
            } catch (Exception e17) {
                df.a(this.f388020a).d(this.f388020a.getPackageName(), intent, "17");
                jz4.c.q(e17);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                hb hbVar2 = new hb();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        fv.d(hbVar2, byteArrayExtra2);
                    }
                } catch (hu unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(hbVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                jz4.c.B("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    jz4.c.B("message arrived: receiving an empty message, drop");
                    return null;
                }
                hb hbVar3 = new hb();
                try {
                    fv.d(hbVar3, byteArrayExtra3);
                    s c17 = s.c(this.f388020a);
                    if (com.xiaomi.push.service.x.J(hbVar3)) {
                        jz4.c.B("message arrived: receive ignore reg message, ignore!");
                    } else if (!c17.s()) {
                        jz4.c.B("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (c17.s() && c17.x()) {
                        jz4.c.B("message arrived: app info is invalidated");
                    } else {
                        return d(hbVar3, byteArrayExtra3);
                    }
                } catch (Exception e18) {
                    jz4.c.B("fail to deal with arrived message. " + e18);
                }
            }
        }
        return null;
    }

    public List<String> f(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}

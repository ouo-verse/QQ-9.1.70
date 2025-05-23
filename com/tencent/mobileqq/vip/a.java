package com.tencent.mobileqq.vip;

import MQQ.VipUserInfo;
import VIP.AIOSendRes;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static String f312765i;

    /* renamed from: j, reason: collision with root package name */
    public static String f312766j;

    /* renamed from: k, reason: collision with root package name */
    public static String f312767k;

    /* renamed from: l, reason: collision with root package name */
    public static String f312768l;

    /* renamed from: m, reason: collision with root package name */
    public static String f312769m;

    /* renamed from: n, reason: collision with root package name */
    public static String f312770n;

    /* renamed from: o, reason: collision with root package name */
    public static String f312771o;

    /* renamed from: p, reason: collision with root package name */
    public static String f312772p;

    /* renamed from: q, reason: collision with root package name */
    public static String f312773q;

    /* renamed from: r, reason: collision with root package name */
    public static String f312774r;

    /* renamed from: s, reason: collision with root package name */
    public static int f312775s;

    /* renamed from: t, reason: collision with root package name */
    public static String f312776t;

    /* renamed from: u, reason: collision with root package name */
    public static int f312777u;

    /* renamed from: v, reason: collision with root package name */
    private static a f312778v;

    /* renamed from: a, reason: collision with root package name */
    private int f312779a;

    /* renamed from: b, reason: collision with root package name */
    private int f312780b;

    /* renamed from: c, reason: collision with root package name */
    private String f312781c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f312782d;

    /* renamed from: e, reason: collision with root package name */
    private int f312783e;

    /* renamed from: f, reason: collision with root package name */
    private String f312784f;

    /* renamed from: g, reason: collision with root package name */
    private String f312785g;

    /* renamed from: h, reason: collision with root package name */
    private String f312786h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f312765i = "aioVipDonateInfoSpFile_";
        f312766j = "lastCheckTime_";
        f312767k = "sendDisable";
        f312768l = "checkFreq";
        f312769m = "grayTail";
        f312770n = "sendList";
        f312771o = "popGraytips";
        f312772p = "graytips";
        f312773q = "hightLight";
        f312774r = WadlProxyConsts.KEY_JUMP_URL;
        f312775s = 1;
        f312776t = "";
        f312777u = 1;
        f312778v = null;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312779a = -1;
        this.f312780b = -1;
        this.f312781c = null;
        this.f312782d = null;
        this.f312783e = -1;
    }

    public static a a() {
        if (f312778v == null) {
            synchronized (a.class) {
                if (f312778v == null) {
                    f312778v = new a();
                }
            }
        }
        return f312778v;
    }

    private void b(QQAppInterface qQAppInterface) {
        SharedPreferences.Editor edit = qQAppInterface.getApplication().getSharedPreferences(f312765i, 0).edit();
        edit.putInt(f312771o, this.f312783e);
        if (!TextUtils.isEmpty(this.f312784f)) {
            edit.putString(f312772p, this.f312784f);
        }
        if (!TextUtils.isEmpty(this.f312785g)) {
            edit.putString(f312773q, this.f312785g);
        }
        if (!TextUtils.isEmpty(this.f312786h)) {
            edit.putString(f312774r, this.f312786h);
        }
        edit.apply();
    }

    @TargetApi(9)
    public void c(QQAppInterface qQAppInterface, AIOSendRes aIOSendRes) {
        MqqHandler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) aIOSendRes);
            return;
        }
        if (qQAppInterface != null && aIOSendRes != null) {
            this.f312783e = aIOSendRes.iPopGrayStip;
            this.f312784f = aIOSendRes.sGrayStipMsg;
            Map<String, String> map = aIOSendRes.mHighLightMap;
            if (map != null && map.size() > 0) {
                String next = map.keySet().iterator().next();
                this.f312785g = next;
                if (!TextUtils.isEmpty(next)) {
                    this.f312786h = map.get(this.f312785g);
                }
            }
            b(qQAppInterface);
            if (this.f312783e == f312777u && (handler = qQAppInterface.getHandler(ChatActivity.class)) != null) {
                handler.sendMessage(handler.obtainMessage(60));
            }
        }
    }

    @TargetApi(9)
    public void d(QQAppInterface qQAppInterface, VipUserInfo vipUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) vipUserInfo);
            return;
        }
        if (qQAppInterface != null && vipUserInfo != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            SharedPreferences.Editor edit = qQAppInterface.getApplication().getSharedPreferences(f312765i + currentAccountUin, 0).edit();
            this.f312779a = vipUserInfo.iSendDisable;
            this.f312780b = vipUserInfo.iCheckFreq;
            if (!TextUtils.isEmpty(vipUserInfo.sGrayTail)) {
                String str = vipUserInfo.sGrayTail;
                this.f312781c = str;
                edit.putString(f312769m, str);
            }
            ArrayList<Long> arrayList = vipUserInfo.vSendList;
            if (arrayList != null && arrayList.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                if (this.f312782d == null) {
                    this.f312782d = new ArrayList();
                }
                for (int i3 = 0; i3 < vipUserInfo.vSendList.size(); i3++) {
                    String valueOf = String.valueOf(vipUserInfo.vSendList.get(i3));
                    sb5.append(valueOf);
                    sb5.append(",");
                    this.f312782d.add(valueOf);
                }
                edit.putString(f312770n, sb5.toString());
            }
            edit.putInt(f312767k, this.f312779a);
            edit.putInt(f312768l, this.f312780b);
            edit.apply();
        }
    }
}

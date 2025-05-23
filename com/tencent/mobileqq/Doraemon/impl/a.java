package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.i;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.Doraemon.manifest.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends DoraemonAPIManager {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    private String f154126o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, Integer> f154127p;

    /* renamed from: q, reason: collision with root package name */
    protected com.tencent.mobileqq.miniapp.d f154128q;

    /* renamed from: r, reason: collision with root package name */
    private String f154129r;

    /* renamed from: s, reason: collision with root package name */
    private String f154130s;

    /* renamed from: t, reason: collision with root package name */
    private String f154131t;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C7077a implements DefaultDoraemonAppInfoHelper.g {
        static IPatchRedirector $redirector_;

        C7077a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.g
        public void a(com.tencent.mobileqq.miniapp.d dVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, i3);
                return;
            }
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "onGetAppInfo(), appInfo=" + dVar + ", status=" + i3);
            a aVar = a.this;
            aVar.f154128q = dVar;
            aVar.r(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f154133d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.b f154134e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f154135f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154136h;

        b(i iVar, com.tencent.mobileqq.Doraemon.b bVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154133d = iVar;
            this.f154134e = bVar;
            this.f154135f = jSONObject;
            this.f154136h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, iVar, bVar, jSONObject, aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.f();
                QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.f154133d.f154099a);
                a.this.D(this.f154133d, 2);
                a.this.q(0, this.f154134e, this.f154135f, this.f154136h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f154138d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.b f154139e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f154140f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154141h;

        c(i iVar, com.tencent.mobileqq.Doraemon.b bVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154138d = iVar;
            this.f154139e = bVar;
            this.f154140f = jSONObject;
            this.f154141h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, iVar, bVar, jSONObject, aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.f();
                QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.f154138d.f154099a);
                a.this.D(this.f154138d, 1);
                a.this.q(4, this.f154139e, this.f154140f, this.f154141h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f154143d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.b f154144e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f154145f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154146h;

        d(i iVar, com.tencent.mobileqq.Doraemon.b bVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154143d = iVar;
            this.f154144e = bVar;
            this.f154145f = jSONObject;
            this.f154146h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, iVar, bVar, jSONObject, aVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            a.this.f();
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.f154143d.f154099a);
            a.this.q(4, this.f154144e, this.f154145f, this.f154146h);
        }
    }

    public a(Activity activity, int i3, String str) {
        super(activity, i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str);
            return;
        }
        this.f154127p = new HashMap();
        this.f154126o = "doraemon_user_permission_" + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }

    private int B(i iVar) {
        Integer num = this.f154127p.get(iVar.f154099a);
        if (num == null) {
            if (BaseApplication.getContext().getSharedPreferences(this.f154126o, 4).getLong(this.f154072d + "_" + iVar.f154099a + "_2", 0L) > NetConnInfoCenter.getServerTimeMillis()) {
                num = 2;
            } else {
                num = 0;
            }
            this.f154127p.put(iVar.f154099a, num);
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(i iVar, int i3) {
        if (2 == i3) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() + 2592000000L;
            BaseApplication.getContext().getSharedPreferences(this.f154126o, 4).edit().putLong(this.f154072d + "_" + iVar.f154099a + "_2", serverTimeMillis).apply();
        }
        this.f154127p.put(iVar.f154099a, Integer.valueOf(i3));
    }

    public String A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.f154130s;
        if (str == null) {
            return BaseApplication.getContext().getPackageName();
        }
        return str;
    }

    public void C(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.f154129r = str;
        this.f154130s = str2;
        this.f154131t = str3;
    }

    @Override // com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    public com.tencent.mobileqq.miniapp.d k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.miniapp.d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f154128q;
    }

    @Override // com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    protected void l(com.tencent.mobileqq.Doraemon.b bVar, JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bVar, jSONObject, aVar);
            return;
        }
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "apiConfig=" + bVar + ", apiParam=" + bVar + ", apiCallback=" + aVar);
        int i3 = bVar.f154092c;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + bVar.f154092c);
                    q(6, bVar, jSONObject, aVar);
                    return;
                }
                if (this.f154082n.isLogin(i(com.tencent.mobileqq.Doraemon.manifest.a.f154225a.get("login"), false))) {
                    q(0, bVar, jSONObject, aVar);
                    return;
                } else {
                    QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
                    q(5, bVar, jSONObject, aVar);
                    return;
                }
            }
            i i16 = DefaultDoraemonAppInfoHelper.h().i(bVar.f154090a);
            if (i16 == null) {
                q(1, bVar, jSONObject, aVar);
                return;
            }
            int B = B(i16);
            if (B == 1) {
                q(4, bVar, jSONObject, aVar);
                return;
            }
            if (B == 2) {
                q(0, bVar, jSONObject, aVar);
                return;
            }
            com.tencent.mobileqq.miniapp.d k3 = k();
            if (k3 == null) {
                str = null;
            } else {
                str = k3.f246795d;
            }
            if (TextUtils.isEmpty(str)) {
                str = HardCodeUtil.qqStr(R.string.cpl);
            }
            String str3 = str;
            if (k3 == null) {
                str2 = null;
            } else {
                str2 = k3.f246796e;
            }
            u(str3, str2, BaseApplication.getContext().getResources().getString(R.string.cpk, str3), i16.f154100b, HardCodeUtil.qqStr(R.string.igh), new b(i16, bVar, jSONObject, aVar), HardCodeUtil.qqStr(R.string.igj), new c(i16, bVar, jSONObject, aVar), new d(i16, bVar, jSONObject, aVar));
            return;
        }
        q(0, bVar, jSONObject, aVar);
    }

    @Override // com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    protected Map<String, com.tencent.mobileqq.Doraemon.b> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.C7084a.C7085a.a();
    }

    @Override // com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            DefaultDoraemonAppInfoHelper.h().f(this.f154072d, this.f154070b, this.f154071c, this.f154129r, this.f154130s, this.f154131t, new C7077a());
        }
    }
}

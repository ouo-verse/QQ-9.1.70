package com.tencent.mobileqq.qqgift.data.service;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements Cloneable {
    static IPatchRedirector $redirector_;
    public int C;
    public int D;
    public boolean E;
    public int F;
    public c G;
    public long H;
    public int I;
    public int J;
    public long K;
    public boolean L;
    public Map<String, String> M;
    public boolean N;
    public List<a> P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f264871a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f264872b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f264873c0;

    /* renamed from: d, reason: collision with root package name */
    public int f264874d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f264875d0;

    /* renamed from: e, reason: collision with root package name */
    public String f264876e;

    /* renamed from: e0, reason: collision with root package name */
    public long f264877e0;

    /* renamed from: f, reason: collision with root package name */
    public int f264878f;

    /* renamed from: f0, reason: collision with root package name */
    public List<b> f264879f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f264880g0;

    /* renamed from: h, reason: collision with root package name */
    public int f264881h;

    /* renamed from: h0, reason: collision with root package name */
    public String f264882h0;

    /* renamed from: i, reason: collision with root package name */
    public int f264883i;

    /* renamed from: m, reason: collision with root package name */
    public int f264884m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f264885a;

        /* renamed from: b, reason: collision with root package name */
        public long f264886b;

        /* renamed from: c, reason: collision with root package name */
        public String f264887c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f264888d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f264889a;

        /* renamed from: b, reason: collision with root package name */
        public long f264890b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ExpireInfo{time=" + this.f264889a + ", num=" + this.f264890b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements Cloneable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public long f264891d;

        /* renamed from: e, reason: collision with root package name */
        public String f264892e;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            c cVar = new c();
            cVar.f264891d = this.f264891d;
            cVar.f264892e = this.f264892e;
            return cVar;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = 1;
        this.L = false;
        this.X = "";
        this.f264871a0 = "0";
        this.f264872b0 = "0";
        this.f264873c0 = "0";
        this.f264879f0 = new ArrayList();
        this.f264880g0 = "";
        this.f264882h0 = "";
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = new d();
        dVar.f264874d = this.f264874d;
        dVar.f264876e = this.f264876e;
        dVar.f264878f = this.f264878f;
        dVar.f264881h = this.f264881h;
        dVar.f264883i = this.f264883i;
        dVar.f264884m = this.f264884m;
        dVar.C = this.C;
        dVar.D = this.D;
        dVar.E = this.E;
        dVar.F = this.F;
        c cVar = this.G;
        if (cVar != null) {
            dVar.G = cVar.clone();
        }
        dVar.H = this.H;
        dVar.I = this.I;
        dVar.J = this.J;
        dVar.K = this.K;
        dVar.L = this.L;
        dVar.f264875d0 = this.f264875d0;
        if (this.M != null) {
            dVar.M = new HashMap(this.M);
        }
        dVar.N = this.N;
        if (this.P != null) {
            dVar.P = new ArrayList(this.P);
        }
        return dVar;
    }

    public boolean b() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.F == 1 && (cVar = this.G) != null && cVar.f264891d > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getName());
        sb5.append('{');
        sb5.append("giftID=");
        sb5.append(this.f264874d);
        sb5.append(",price=");
        sb5.append(this.f264878f);
        sb5.append(",giftType=");
        sb5.append(this.f264881h);
        sb5.append(",effectLevel=");
        sb5.append(this.f264883i);
        sb5.append(",priority=");
        sb5.append(this.f264884m);
        sb5.append(",materialID=");
        sb5.append(this.C);
        sb5.append(",giftPay=");
        sb5.append(this.F);
        sb5.append(",isSelected=");
        sb5.append(this.E);
        sb5.append(",hitSeq=");
        sb5.append(this.H);
        sb5.append(",curHitNum=");
        sb5.append(this.I);
        sb5.append(",allHitNum=");
        sb5.append(this.J);
        sb5.append(",receiver=");
        sb5.append(this.K);
        sb5.append(",isHide=");
        sb5.append(this.N);
        sb5.append(",tagPos=");
        sb5.append(this.Z);
        if (!TextUtils.isEmpty(this.f264876e)) {
            sb5.append(",giftName=");
            sb5.append(this.f264876e);
        }
        if (!TextUtils.isEmpty(this.Q)) {
            sb5.append(",dynamicImgUrl=");
            sb5.append(this.Q);
        }
        if (!TextUtils.isEmpty(this.R)) {
            sb5.append(",staticImgUrl=");
            sb5.append(this.R);
        }
        if (!TextUtils.isEmpty(this.S)) {
            sb5.append(",tabDesc=");
            sb5.append(this.S);
        }
        if (!TextUtils.isEmpty(this.T)) {
            sb5.append(",itemDesc=");
            sb5.append(this.T);
        }
        if (!TextUtils.isEmpty(this.U)) {
            sb5.append(",tabName=");
            sb5.append(this.U);
        }
        if (!TextUtils.isEmpty(this.V)) {
            sb5.append(",tabId=");
            sb5.append(this.V);
        }
        if (!TextUtils.isEmpty(this.W)) {
            sb5.append(",tagUrl=");
            sb5.append(this.W);
        }
        if (!TextUtils.isEmpty(this.f264871a0)) {
            sb5.append(",isfansGroupGift=");
            sb5.append(this.f264871a0);
        }
        if (!TextUtils.isEmpty(this.f264872b0)) {
            sb5.append(",fansGroupLevel=");
            sb5.append(this.f264872b0);
        }
        if (this.G != null) {
            sb5.append(",countDownTime=");
            sb5.append(this.G.f264891d);
            if (!TextUtils.isEmpty(this.G.f264892e)) {
                sb5.append(",promptText=");
                sb5.append(this.G.f264892e);
            }
        }
        Map<String, String> map = this.M;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.M.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    sb5.append(",ext.key=");
                    sb5.append(entry.getKey());
                }
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb5.append(",ext.value=");
                    sb5.append(entry.getValue());
                }
            }
        }
        if (this.f264875d0) {
            sb5.append(",isPackage=true");
            sb5.append(",totalNum=");
            sb5.append(this.f264877e0);
            sb5.append(",expireInfos=");
            sb5.append(this.f264879f0);
        }
        sb5.append("}");
        return sb5.toString();
    }
}

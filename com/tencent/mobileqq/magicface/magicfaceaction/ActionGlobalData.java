package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ActionGlobalData {
    static IPatchRedirector $redirector_;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public String F;
    TimerTask G;

    /* renamed from: a, reason: collision with root package name */
    a f243348a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f243349b;

    /* renamed from: c, reason: collision with root package name */
    public String f243350c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f243351d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f243352e;

    /* renamed from: f, reason: collision with root package name */
    public String f243353f;

    /* renamed from: g, reason: collision with root package name */
    public int f243354g;

    /* renamed from: h, reason: collision with root package name */
    public String f243355h;

    /* renamed from: i, reason: collision with root package name */
    public int f243356i;

    /* renamed from: j, reason: collision with root package name */
    public String f243357j;

    /* renamed from: k, reason: collision with root package name */
    public String f243358k;

    /* renamed from: l, reason: collision with root package name */
    public String f243359l;

    /* renamed from: m, reason: collision with root package name */
    public c f243360m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f243361n;

    /* renamed from: o, reason: collision with root package name */
    public int f243362o;

    /* renamed from: p, reason: collision with root package name */
    public float f243363p;

    /* renamed from: q, reason: collision with root package name */
    public int f243364q;

    /* renamed from: r, reason: collision with root package name */
    public int f243365r;

    /* renamed from: s, reason: collision with root package name */
    public int f243366s;

    /* renamed from: t, reason: collision with root package name */
    public int f243367t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f243368u;

    /* renamed from: v, reason: collision with root package name */
    public String f243369v;

    /* renamed from: w, reason: collision with root package name */
    int f243370w;

    /* renamed from: x, reason: collision with root package name */
    public int f243371x;

    /* renamed from: y, reason: collision with root package name */
    public int f243372y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f243373z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void b();

        void c();
    }

    public ActionGlobalData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243349b = true;
        this.f243350c = "send";
        this.f243351d = false;
        this.f243352e = true;
        this.f243353f = "non-ver";
        this.f243354g = 0;
        this.f243361n = false;
        this.f243366s = 50;
        this.f243367t = 30;
        this.f243368u = true;
        this.f243370w = 0;
        this.G = new TimerTask() { // from class: com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionGlobalData.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ActionGlobalData actionGlobalData = ActionGlobalData.this;
                actionGlobalData.f243370w++;
                actionGlobalData.f243363p -= 0.1f;
                a aVar = actionGlobalData.f243348a;
                if (aVar != null) {
                    aVar.b();
                }
                ActionGlobalData actionGlobalData2 = ActionGlobalData.this;
                if (actionGlobalData2.f243370w * 100 == actionGlobalData2.f243362o * 1000) {
                    actionGlobalData2.f243363p = 0.0f;
                    a aVar2 = actionGlobalData2.f243348a;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                    cancel();
                }
            }
        };
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f243348a = aVar;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f243363p = this.f243362o;
            ThreadManagerV2.getTimer().schedule(this.G, 0L, 100L);
        }
    }
}

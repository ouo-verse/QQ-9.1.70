package com.tencent.mobileqq.miniapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g implements IEventReceiver {
    static IPatchRedirector $redirector_;
    private static volatile g C;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, com.tencent.mobileqq.miniapp.a> f246813d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, MiniAppOptions> f246814e;

    /* renamed from: f, reason: collision with root package name */
    private c f246815f;

    /* renamed from: h, reason: collision with root package name */
    private f f246816h;

    /* renamed from: i, reason: collision with root package name */
    private MiniAppInfoManager f246817i;

    /* renamed from: m, reason: collision with root package name */
    private SparseArray<com.tencent.mobileqq.miniapp.b> f246818m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends e<g> {
        static IPatchRedirector $redirector_;

        public a(g gVar) {
            super(gVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // com.tencent.mobileqq.miniapp.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar, boolean z16, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, gVar, Boolean.valueOf(z16), dVar);
            } else {
                if (gVar == null) {
                    return;
                }
                if (z16) {
                    gVar.i((com.tencent.mobileqq.miniapp.a) gVar.f246813d.get(dVar.f246807p));
                } else {
                    gVar.q(dVar.f246792a, dVar.f246793b, 1001);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends e<g> {
        static IPatchRedirector $redirector_;

        public b(g gVar) {
            super(gVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // com.tencent.mobileqq.miniapp.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar, boolean z16, d dVar) {
            com.tencent.mobileqq.miniapp.b l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, gVar, Boolean.valueOf(z16), dVar);
                return;
            }
            if (gVar == null) {
                return;
            }
            if (!z16 || (l3 = gVar.l(dVar.f246801j)) == null) {
                gVar.q(dVar.f246792a, dVar.f246793b, 1002);
            } else {
                gVar.f246816h.c(dVar, l3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c extends QQUIEventReceiver<g, com.tencent.mobileqq.miniapp.c> {
        static IPatchRedirector $redirector_;

        public c(@NonNull g gVar) {
            super(gVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // com.tribe.async.dispatch.QQUIEventReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(@NonNull g gVar, @NonNull com.tencent.mobileqq.miniapp.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar, (Object) cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppManager", 2, "receive event:" + cVar.toString());
            }
            int i3 = cVar.f246789h;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 && !cVar.f246788f) {
                            d dVar = cVar.f246787e;
                            gVar.q(dVar.f246792a, dVar.f246793b, 1004);
                            return;
                        }
                        return;
                    }
                    Object[] objArr = cVar.f246791m;
                    gVar.s(d.b((String) objArr[0], ((Integer) objArr[1]).intValue()));
                    return;
                }
                Object[] objArr2 = cVar.f246791m;
                gVar.n((MiniAppActivity) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (MiniAppOptions) cVar.f246791m[3]);
                return;
            }
            if ("MiniAppLauncher".equals(cVar.f246790i) && com.tencent.mobileqq.miniapp.b.b((String) cVar.f246791m[0]) == 1 && ((Integer) cVar.f246791m[2]).intValue() != 2) {
                String str = (String) cVar.f246791m[1];
                if (cVar.f246788f) {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.o7x), 0).show();
                    d b16 = gVar.f246817i.b(str, 2, 0, false);
                    if (b16 != null) {
                        b16.f246808q.putString("unzipped_path", (String) cVar.f246791m[3]);
                        gVar.o((com.tencent.mobileqq.miniapp.a) gVar.f246813d.get(b16.f246807p));
                        return;
                    }
                }
                String[] d16 = d.d(str);
                gVar.q(d16[1], Integer.parseInt(d16[0]), 1003);
            }
        }

        @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
        public Class acceptEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return com.tencent.mobileqq.miniapp.c.class;
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f246813d = new LinkedHashMap();
        this.f246814e = new HashMap();
        this.f246816h = new f();
        this.f246817i = new MiniAppInfoManager();
        this.f246815f = new c(this);
        com.tencent.biz.qqstory.base.c.a().registerSubscriber("MiniAppManager", this.f246815f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.tencent.mobileqq.miniapp.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppManager", 2, "downloadApp. cacheKey=", aVar.f246786b.f246807p);
        }
        b bVar = new b(this);
        d dVar = aVar.f246786b;
        j(dVar.f246792a, dVar.f246793b, 2, true, bVar);
    }

    public static g m() {
        if (C == null) {
            synchronized (g.class) {
                if (C == null) {
                    C = new g();
                }
            }
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(MiniAppActivity miniAppActivity, String str, int i3, MiniAppOptions miniAppOptions) {
        com.tencent.mobileqq.miniapp.a b16 = this.f246816h.b(miniAppActivity, str, i3);
        if (b16 == null) {
            q(str, i3, 1000);
            return;
        }
        String b17 = d.b(str, i3);
        this.f246813d.put(b17, b16);
        this.f246814e.put(b17, miniAppOptions);
        j(str, i3, 1, true, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(com.tencent.mobileqq.miniapp.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppManager", 2, "launchApp. cacheKey=", aVar.f246786b.f246807p);
        }
        this.f246816h.d(aVar, this.f246814e.get(aVar.f246786b.f246807p));
    }

    private d p(String str, int i3, d dVar, int i16, boolean z16, e eVar, int i17) {
        Reference reference;
        Reference reference2;
        Reference reference3;
        Reference reference4;
        Reference reference5;
        if (dVar != null && this.f246817i.a(dVar, i16, i17)) {
            if (eVar != null && (reference5 = eVar.f246812a) != null) {
                eVar.a(reference5.get(), true, dVar);
            }
            return dVar;
        }
        if (dVar != null && i16 == 1 && this.f246817i.d(dVar)) {
            com.tencent.mobileqq.miniapp.a aVar = this.f246813d.get(dVar.f246807p);
            if (aVar != null) {
                aVar.c(dVar);
            }
            if (eVar != null && (reference4 = eVar.f246812a) != null) {
                eVar.a(reference4.get(), true, dVar);
            }
            return dVar;
        }
        if (dVar != null && i16 == 2 && this.f246817i.e(dVar)) {
            com.tencent.mobileqq.miniapp.a aVar2 = this.f246813d.get(dVar.f246807p);
            if (aVar2 != null) {
                aVar2.c(dVar);
            }
            if (eVar != null && (reference3 = eVar.f246812a) != null) {
                eVar.a(reference3.get(), true, dVar);
            }
            return dVar;
        }
        if (z16) {
            if (i16 != 1 && i16 != 2) {
                if (eVar != null && (reference2 = eVar.f246812a) != null) {
                    eVar.a(reference2.get(), false, null);
                }
            } else {
                if (dVar == null) {
                    dVar = new d(str, i3);
                    com.tencent.mobileqq.miniapp.a aVar3 = this.f246813d.get(dVar.f246807p);
                    if (aVar3 != null) {
                        aVar3.c(dVar);
                    }
                }
                this.f246817i.c(dVar, i16, eVar);
            }
            return null;
        }
        if (eVar != null && (reference = eVar.f246812a) != null) {
            eVar.a(reference.get(), false, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, int i3, int i16) {
        QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.o7m), 0).show();
        QLog.e("MiniAppManager", 1, "onInitFailed. errorCode=", Integer.valueOf(i16), ", appId=", str, ", appType=", Integer.valueOf(i3));
        u(str, i3);
        s(d.b(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppManager", 2, "removeMiniApp. cacheKey=", str);
        }
        com.tencent.mobileqq.miniapp.a remove = this.f246813d.remove(str);
        if (remove != null) {
            remove.b();
        }
        this.f246814e.remove(str);
    }

    public static void t(Activity activity, String str, int i3, MiniAppOptions miniAppOptions) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppManager", 2, "runApp. appId=", str, ", appType=", Integer.valueOf(i3));
        }
        Intent intent = new Intent(activity, (Class<?>) MiniAppActivity.class);
        intent.putExtra("key_appid", str);
        intent.putExtra("key_appType", i3);
        intent.putExtra("key_options", miniAppOptions);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(268435456);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    public d j(String str, int i3, int i16, boolean z16, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), eVar);
        }
        return k(str, i3, i16, z16, eVar, 0);
    }

    public d k(String str, int i3, int i16, boolean z16, e eVar, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), eVar, Integer.valueOf(i17));
        }
        if (eVar == null) {
            return this.f246817i.b(d.b(str, i3), i16, i17, true);
        }
        return p(str, i3, this.f246817i.b(d.b(str, i3), i16, i17, false), i16, z16, eVar, i17);
    }

    public com.tencent.mobileqq.miniapp.b l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.miniapp.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.f246818m == null) {
            this.f246818m = new SparseArray<>();
        }
        int b16 = com.tencent.mobileqq.miniapp.b.b(str);
        if (b16 > 0) {
            com.tencent.mobileqq.miniapp.b bVar = this.f246818m.get(b16);
            if (bVar == null) {
                AKOfflineDownloader aKOfflineDownloader = new AKOfflineDownloader();
                this.f246818m.put(b16, aKOfflineDownloader);
                return aKOfflineDownloader;
            }
            return bVar;
        }
        return null;
    }

    public void r(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
        } else {
            this.f246817i.f246780a.put(dVar.f246807p, dVar);
        }
    }

    void u(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppManager", 2, "stopApp. appId=", str, ", appType=", Integer.valueOf(i3));
        }
        com.tencent.mobileqq.miniapp.a aVar = this.f246813d.get(d.b(str, i3));
        if (aVar != null && aVar.a()) {
            aVar.e();
        }
    }
}

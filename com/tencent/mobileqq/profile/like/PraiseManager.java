package com.tencent.mobileqq.profile.like;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.cache.api.Business;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.quickupdate.PraiseDownloadBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

/* loaded from: classes16.dex */
public class PraiseManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static String f260197m;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f260198d;

    /* renamed from: e, reason: collision with root package name */
    public Context f260199e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.cache.api.collection.a<Integer, d> f260200f;

    /* renamed from: h, reason: collision with root package name */
    public final List<WeakReference<a>> f260201h;

    /* renamed from: i, reason: collision with root package name */
    public final Vector<Integer> f260202i;

    /* loaded from: classes16.dex */
    public class LoadCallback implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f260209d;

        /* renamed from: e, reason: collision with root package name */
        public int f260210e;

        /* renamed from: f, reason: collision with root package name */
        public String f260211f;

        public LoadCallback(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PraiseManager.this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            this.f260209d = i3;
            this.f260210e = i16;
            this.f260211f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            WeakReference[] weakReferenceArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (PraiseManager.this.f260201h) {
                if (!PraiseManager.this.f260201h.isEmpty()) {
                    weakReferenceArr = (WeakReference[]) Array.newInstance(PraiseManager.this.f260201h.get(0).getClass(), PraiseManager.this.f260201h.size());
                    PraiseManager.this.f260201h.toArray(weakReferenceArr);
                } else {
                    weakReferenceArr = null;
                }
            }
            if (weakReferenceArr != null) {
                try {
                    for (WeakReference weakReference : weakReferenceArr) {
                        if (weakReference != null && weakReference.get() != null) {
                            a aVar = (a) weakReference.get();
                            int i16 = this.f260209d;
                            aVar.M0(i16, PraiseManager.this.f260200f.e(Integer.valueOf(i16)), this.f260210e, this.f260211f);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("PraiseManager", 1, "LoadCallback failed", e16);
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface a {
        void M0(int i3, d dVar, int i16, String str);
    }

    /* loaded from: classes16.dex */
    class b implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f260212d;

        /* renamed from: e, reason: collision with root package name */
        public int f260213e;

        /* renamed from: f, reason: collision with root package name */
        public a f260214f;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PraiseManager.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
        public void M0(int i3, d dVar, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), dVar, Integer.valueOf(i16), str);
                return;
            }
            int i17 = this.f260212d + 1;
            this.f260212d = i17;
            if (i17 == this.f260213e) {
                PraiseManager.this.j(this);
                a aVar = this.f260214f;
                if (aVar != null) {
                    aVar.M0(0, null, 0, "");
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f260197m = "ProfilePersonalLikeCurrentId_";
        }
    }

    public PraiseManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f260198d = qQAppInterface;
        this.f260199e = qQAppInterface.getApp().getApplicationContext();
        this.f260200f = new com.tencent.cache.api.collection.a<>(Business.Default, "PraiseInfo", 21);
        this.f260202i = new Vector<>();
        this.f260201h = new ArrayList(3);
    }

    public static int f(AppInterface appInterface) {
        if (appInterface == null) {
            return 0;
        }
        return VipMMKV.getPraise(appInterface.getApplication()).getInt(f260197m + appInterface.getCurrentAccountUin(), 0);
    }

    public static void i(QQAppInterface qQAppInterface, int i3) {
        if (qQAppInterface == null) {
            return;
        }
        VipMMKV.getPraise(qQAppInterface.getApplication()).edit().putInt(f260197m + qQAppInterface.getCurrentAccountUin(), i3).commit();
    }

    boolean a(d dVar) {
        if (new File(dVar.f260237e).exists() && new File(dVar.f260239g).exists()) {
            return true;
        }
        return false;
    }

    void b(int i3, boolean z16, String str) {
        String savePath = ((PraiseDownloadBusiness) QQVasUpdateBusiness.getBusiness(PraiseDownloadBusiness.class)).getSavePath(i3);
        StringBuilder P = l.P();
        P.append(savePath);
        String str2 = File.separator;
        P.append(str2);
        P.append("config.json");
        d b16 = d.b(i3, P.toString());
        Boolean bool = null;
        if (b16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PraiseManager", 2, "createPraiseInfo from local, id=" + i3 + " from:" + str);
            }
            StringBuilder P2 = l.P();
            P2.append(savePath);
            P2.append(str2);
            P2.append("whiteBlackImg.png");
            b16.f260237e = P2.toString();
            StringBuilder P3 = l.P();
            P3.append(savePath);
            P3.append(str2);
            P3.append("colorImg.png");
            b16.f260239g = P3.toString();
            StringBuilder P4 = l.P();
            P4.append(savePath);
            P4.append(str2);
            P4.append("goldImg.png");
            b16.f260241i = P4.toString();
            if (!a(b16)) {
                if (z16) {
                    d(i3, str);
                } else {
                    bool = Boolean.FALSE;
                }
            } else if (c(b16)) {
                this.f260200f.f(Integer.valueOf(i3), b16);
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
        } else if (z16) {
            d(i3, str);
        } else {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            this.f260198d.runOnUiThread(new LoadCallback(i3, 0, str));
            this.f260202i.removeElement(Integer.valueOf(i3));
        }
    }

    boolean c(d dVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 320;
        options.inTargetDensity = this.f260199e.getResources().getDisplayMetrics().densityDpi;
        Bitmap m3 = BubbleManager.m(dVar.f260237e, options);
        if (m3 == null) {
            return false;
        }
        dVar.f260238f = m3;
        Bitmap m16 = BubbleManager.m(dVar.f260239g, options);
        if (m16 == null) {
            return false;
        }
        dVar.f260240h = m16;
        dVar.f260242j = BubbleManager.m(dVar.f260241i, options);
        String savePath = ((PraiseDownloadBusiness) QQVasUpdateBusiness.getBusiness(PraiseDownloadBusiness.class)).getSavePath(dVar.f260233a);
        StringBuilder P = l.P();
        P.append(savePath);
        String str = File.separator;
        P.append(str);
        P.append("dynamicImg.png");
        String sb5 = P.toString();
        if (new File(sb5).exists()) {
            dVar.f260243k = sb5;
        }
        StringBuilder P2 = l.P();
        P2.append(savePath);
        P2.append(str);
        P2.append("goldDynamicImg.png");
        String sb6 = P2.toString();
        if (new File(sb6).exists()) {
            dVar.f260244l = sb6;
            return true;
        }
        return true;
    }

    void d(int i3, String str) {
        if (i3 == 0) {
            return;
        }
        PraiseDownloadBusiness praiseDownloadBusiness = (PraiseDownloadBusiness) QQVasUpdateBusiness.getBusiness(PraiseDownloadBusiness.class);
        praiseDownloadBusiness.addDownLoadListener(i3, new Runnable(praiseDownloadBusiness, i3, str) { // from class: com.tencent.mobileqq.profile.like.PraiseManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PraiseDownloadBusiness f260206d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f260207e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f260208f;

            {
                this.f260206d = praiseDownloadBusiness;
                this.f260207e = i3;
                this.f260208f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PraiseManager.this, praiseDownloadBusiness, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String savePath = this.f260206d.getSavePath(this.f260207e);
                StringBuilder P = l.P();
                P.append(savePath);
                String str2 = File.separator;
                P.append(str2);
                P.append("config.json");
                d b16 = d.b(this.f260207e, P.toString());
                if (b16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PraiseManager", 2, "createPraiseInfo after download complete, id=" + this.f260207e);
                    }
                    StringBuilder P2 = l.P();
                    P2.append(savePath);
                    P2.append(str2);
                    P2.append("whiteBlackImg.png");
                    b16.f260237e = P2.toString();
                    StringBuilder P3 = l.P();
                    P3.append(savePath);
                    P3.append(str2);
                    P3.append("colorImg.png");
                    b16.f260239g = P3.toString();
                    StringBuilder P4 = l.P();
                    P4.append(savePath);
                    P4.append(str2);
                    P4.append("goldImg.png");
                    b16.f260241i = P4.toString();
                    if (PraiseManager.this.a(b16) && PraiseManager.this.c(b16)) {
                        PraiseManager.this.f260200f.f(Integer.valueOf(this.f260207e), b16);
                    }
                }
                PraiseManager praiseManager = PraiseManager.this;
                praiseManager.f260198d.runOnUiThread(new LoadCallback(this.f260207e, 1, this.f260208f));
                PraiseManager.this.f260202i.removeElement(Integer.valueOf(this.f260207e));
            }
        });
        praiseDownloadBusiness.startDownload(i3);
    }

    public boolean e(Set<Integer> set, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) set, (Object) aVar)).booleanValue();
        }
        if (set == null || set.isEmpty()) {
            return true;
        }
        b bVar = new b();
        bVar.f260213e = set.size();
        bVar.f260214f = aVar;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.f260200f.e(Integer.valueOf(intValue)) == null) {
                h(bVar);
                g(intValue, true, "from_load_all");
            } else {
                bVar.f260212d++;
            }
        }
        if (bVar.f260212d == set.size()) {
            return true;
        }
        return false;
    }

    public d g(int i3, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), str);
        }
        if (i3 <= 0) {
            return null;
        }
        d e16 = this.f260200f.e(Integer.valueOf(i3));
        if (e16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PraiseManager", 2, "get praise info from cache, id=" + i3 + " from:" + str);
            }
            return e16;
        }
        if (!this.f260202i.contains(Integer.valueOf(i3))) {
            if (QLog.isColorLevel()) {
                QLog.d("PraiseManager", 2, "start create praise info, id=" + i3);
            }
            this.f260202i.add(Integer.valueOf(i3));
            ThreadManagerV2.executeOnFileThread(new Runnable(i3, z16, str) { // from class: com.tencent.mobileqq.profile.like.PraiseManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f260203d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f260204e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f260205f;

                {
                    this.f260203d = i3;
                    this.f260204e = z16;
                    this.f260205f = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PraiseManager.this, Integer.valueOf(i3), Boolean.valueOf(z16), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        PraiseManager.this.b(this.f260203d, this.f260204e, this.f260205f);
                    } catch (Exception e17) {
                        QLog.e("PraiseManager", 1, "createPraiseInfo failed, id=" + this.f260203d, e17);
                    }
                }
            });
        }
        return null;
    }

    public void h(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.f260201h) {
            for (WeakReference<a> weakReference : this.f260201h) {
                if (weakReference != null && weakReference.get() == aVar) {
                    return;
                }
            }
            this.f260201h.add(new WeakReference<>(aVar));
        }
    }

    public void j(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.f260201h) {
            WeakReference<a> weakReference = null;
            for (WeakReference<a> weakReference2 : this.f260201h) {
                if (weakReference2 != null && weakReference2.get() == aVar) {
                    weakReference = weakReference2;
                }
            }
            this.f260201h.remove(weakReference);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f260200f.d();
        }
    }
}

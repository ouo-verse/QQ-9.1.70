package com.tencent.mobileqq.magicface.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* loaded from: classes15.dex */
public class PngFrameManager implements Manager, com.tencent.mobileqq.magicface.drawable.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f243273d;

    /* renamed from: e, reason: collision with root package name */
    ConcurrentHashMap<String, e> f243274e;

    /* renamed from: f, reason: collision with root package name */
    HashMap<Long, Boolean> f243275f;

    /* renamed from: h, reason: collision with root package name */
    d f243276h;

    /* renamed from: i, reason: collision with root package name */
    Handler f243277i;

    /* renamed from: m, reason: collision with root package name */
    h f243278m;

    /* loaded from: classes15.dex */
    public interface a {
        void a(boolean z16);

        void b(MarketFaceItemBuilder.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class b extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<com.tencent.mobileqq.magicface.drawable.a> f243289a;

        public b(com.tencent.mobileqq.magicface.drawable.a aVar) {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f243289a = new mqq.util.WeakReference(aVar);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.tencent.mobileqq.magicface.drawable.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            WeakReference<com.tencent.mobileqq.magicface.drawable.a> weakReference = this.f243289a;
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                aVar.handleMsg(message);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f243290a;

        /* renamed from: b, reason: collision with root package name */
        public int f243291b;

        /* renamed from: c, reason: collision with root package name */
        public MarketFaceItemBuilder.c f243292c;

        /* renamed from: d, reason: collision with root package name */
        public String f243293d;

        /* renamed from: e, reason: collision with root package name */
        public long f243294e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f243295f;

        /* renamed from: g, reason: collision with root package name */
        public a f243296g;

        /* renamed from: h, reason: collision with root package name */
        public Object f243297h;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PngFrameManager.this);
            }
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public PngFrameManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameManager", 2, "PngFrameManager \u3010Constructor\u3011  ");
        }
        this.f243273d = qQAppInterface;
        this.f243277i = a(this);
        this.f243276h = new d();
        this.f243274e = new ConcurrentHashMap<>();
        this.f243275f = new HashMap<>();
        this.f243278m = ((DownloaderFactory) this.f243273d.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
    }

    public static Handler a(com.tencent.mobileqq.magicface.drawable.a aVar) {
        return new b(aVar);
    }

    private void n(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    com.tencent.mobileqq.magicface.drawable.c b(String str, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameManager", 2, "func getPngFrameDrawable begins,epId:" + str + ",pos:" + i3 + ",showProcess:" + z16);
        }
        String str2 = "PngFrameManager_" + str + "_" + i3;
        e c16 = c(str);
        com.tencent.mobileqq.magicface.drawable.c cVar = null;
        if (c16 == null) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(str2);
        if (g16 instanceof com.tencent.mobileqq.magicface.drawable.c) {
            cVar = (com.tencent.mobileqq.magicface.drawable.c) g16;
        }
        if (cVar != null && !z16 && cVar.d()) {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, drawable exists in map,pos:" + i3);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, \u3010NOT find\u3011  drawable in the map.");
            }
            c16.f243329g = z16;
            cVar = new com.tencent.mobileqq.magicface.drawable.c(c16, this.f243273d.getApplication().getResources());
            imageCacheHelper.i(str2, cVar, Business.AIO);
            cVar.e(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
        }
        return cVar;
    }

    public e c(String str) {
        ConcurrentHashMap<String, e> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.f243274e) != null) {
            e eVar = concurrentHashMap.get(str);
            if (eVar != null) {
                return eVar;
            }
            return h(str);
        }
        return null;
    }

    public synchronized boolean d(long j3) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, j3)).booleanValue();
        }
        if (this.f243275f == null) {
            this.f243275f = new HashMap<>();
        }
        if (this.f243275f.get(Long.valueOf(j3)) == null && (handler = this.f243277i) != null) {
            handler.postDelayed(new Runnable(j3) { // from class: com.tencent.mobileqq.magicface.drawable.PngFrameManager.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f243288d;

                {
                    this.f243288d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PngFrameManager.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PngFrameManager.this.f243275f.put(Long.valueOf(this.f243288d), Boolean.TRUE);
                    }
                }
            }, 500L);
            return true;
        }
        return false;
    }

    void e(c cVar) {
        MarketFaceItemBuilder.c cVar2;
        if (cVar != null && (cVar2 = cVar.f243292c) != null && cVar.f243294e == cVar2.f179383k && cVar.f243296g != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func onTypeGif, \u3010rsyType is GIF, use the OLD way to show.\u3011");
            }
            cVar.f243296g.a(true);
        }
    }

    void f(c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + cVar);
        }
        if (new File(MarketFaceConstants.pngFramePath.replace("[epId]", cVar.f243293d)).exists()) {
            l(cVar);
            return;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork != 1 && systemNetwork != 3 && systemNetwork != 4 && systemNetwork != 0) {
            k(cVar);
            return;
        }
        n(cVar.f243292c.f179382j, 0);
        cVar.f243292c.f179380h.setImageResource(R.drawable.fnm);
        m(cVar);
    }

    void g(c cVar) {
        n(cVar.f243292c.f179382j, 0);
        cVar.f243292c.f179380h.setImageResource(R.drawable.fnm);
        ThreadManagerV2.post(new Runnable(cVar) { // from class: com.tencent.mobileqq.magicface.drawable.PngFrameManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f243281d;

            {
                this.f243281d = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PngFrameManager.this, (Object) cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                PngFrameManager pngFrameManager;
                d dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                File file = new File(MarketFaceConstants.emoticonJsonFilePath.replace("[epId]", this.f243281d.f243293d));
                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) PngFrameManager.this.f243273d.getRuntimeService(IEmoticonManagerService.class);
                EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(this.f243281d.f243293d);
                if (syncFindEmoticonPackageById == null) {
                    syncFindEmoticonPackageById = new EmoticonPackage();
                    syncFindEmoticonPackageById.epId = this.f243281d.f243293d;
                    syncFindEmoticonPackageById.aio = true;
                }
                synchronized (PngFrameManager.this) {
                    if (PngFrameManager.this.f243277i != null) {
                        if (file.exists()) {
                            this.f243281d.f243290a = PngFrameManager.this.f243276h.f(file);
                            PngFrameManager.this.f243277i.obtainMessage(224, this.f243281d).sendToTarget();
                            syncFindEmoticonPackageById.rscType = this.f243281d.f243290a;
                            iEmoticonManagerService.saveEmoticonPackage(syncFindEmoticonPackageById);
                        } else {
                            g gVar = new g(com.tencent.mobileqq.core.util.a.c(this.f243281d.f243293d), file);
                            gVar.K = true;
                            if (DownloaderFactory.o(gVar, PngFrameManager.this.f243273d) == 0 && (dVar = (pngFrameManager = PngFrameManager.this).f243276h) != null && pngFrameManager.f243277i != null) {
                                this.f243281d.f243290a = dVar.f(file);
                                syncFindEmoticonPackageById.rscType = this.f243281d.f243290a;
                                iEmoticonManagerService.saveEmoticonPackage(syncFindEmoticonPackageById);
                                PngFrameManager.this.f243277i.obtainMessage(224, this.f243281d).sendToTarget();
                            }
                        }
                    }
                }
            }
        }, 5, null, true);
    }

    public e h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e c16 = this.f243276h.c(str);
        if (c16 != null) {
            this.f243274e.put(str, c16);
        }
        return c16;
    }

    @Override // com.tencent.mobileqq.magicface.drawable.a
    public void handleMsg(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message);
            return;
        }
        switch (message.what) {
            case 224:
                c cVar = (c) message.obj;
                MarketFaceItemBuilder.c cVar2 = cVar.f243292c;
                int i3 = cVar.f243290a;
                cVar2.f179384l = i3;
                if (i3 == 0) {
                    e(cVar);
                    return;
                } else {
                    if (i3 == 1) {
                        f(cVar);
                        return;
                    }
                    return;
                }
            case 225:
                c cVar3 = (c) message.obj;
                n(cVar3.f243292c.f179379g, 8);
                l(cVar3);
                return;
            case 226:
                c cVar4 = (c) message.obj;
                n(cVar4.f243292c.f179382j, 8);
                cVar4.f243292c.f179380h.setImageResource(R.drawable.fnn);
                return;
            case 227:
                c cVar5 = (c) message.obj;
                long j3 = cVar5.f243294e;
                MarketFaceItemBuilder.c cVar6 = cVar5.f243292c;
                if (j3 != cVar6.f179383k) {
                    return;
                }
                n(cVar6.f179382j, 8);
                n(cVar5.f243292c.f179379g, 0);
                cVar5.f243292c.f179380h.setImageBitmap((Bitmap) cVar5.f243297h);
                return;
            default:
                return;
        }
    }

    @SuppressLint({"InlinedApi"})
    void i(MarketFaceItemBuilder.c cVar, boolean z16) {
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
        int i16 = ((200 * i3) + 160) / 320;
        int i17 = ((200 * i3) + 160) / 320;
        if (z16) {
            cVar.f179380h.setLayoutParams(new FrameLayout.LayoutParams(i16, i17));
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.f179380h.getLayoutParams();
        layoutParams.width = i16;
        layoutParams.height = i17;
    }

    public void j(String str, MarketFaceItemBuilder.c cVar, long j3, boolean z16, boolean z17, a aVar) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, cVar, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), aVar);
            return;
        }
        if (!TextUtils.isEmpty(str) && cVar != null) {
            i(cVar, z17);
            c cVar2 = new c();
            cVar2.f243296g = aVar;
            cVar2.f243293d = cVar.f179378f.getEmoticon().epId;
            cVar2.f243292c = cVar;
            cVar2.f243294e = j3;
            cVar2.f243295f = z16;
            cVar2.f243291b = d.e(str);
            MarketFaceItemBuilder.c cVar3 = cVar2.f243292c;
            if (cVar3.f179382j == null) {
                cVar3.f179382j = new ProgressBar(BaseApplication.getContext());
            }
            MarketFaceItemBuilder.c cVar4 = cVar2.f243292c;
            if (cVar4.f179379g == null) {
                cVar4.f179379g = new ImageView(BaseApplication.getContext());
            }
            int g16 = d.g(str);
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func setMagicDrawable, \u3010rscType\u3011:" + g16 + ",\u3010randomValue\u3011:" + cVar2.f243291b + ",\u3010showProcess\u3011:" + z16 + ",tag:" + j3);
            }
            cVar.f179384l = g16;
            if (g16 != -1) {
                if (g16 != 0) {
                    if (g16 == 1) {
                        f(cVar2);
                    }
                } else {
                    e(cVar2);
                }
            } else {
                g(cVar2);
            }
            if (cVar2.f243292c.f179381i == null || (handler = this.f243277i) == null) {
                return;
            }
            handler.postDelayed(new Runnable(cVar2) { // from class: com.tencent.mobileqq.magicface.drawable.PngFrameManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ c f243279d;

                /* renamed from: com.tencent.mobileqq.magicface.drawable.PngFrameManager$1$a */
                /* loaded from: classes15.dex */
                class a implements View.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            MarketFaceItemBuilder.c cVar = AnonymousClass1.this.f243279d.f243292c;
                            ProgressBar progressBar = cVar.f179382j;
                            if (progressBar != null && cVar.f179379g != null && progressBar.getVisibility() != 0 && AnonymousClass1.this.f243279d.f243292c.f179379g.getVisibility() == 0) {
                                c cVar2 = AnonymousClass1.this.f243279d;
                                cVar2.f243295f = true;
                                cVar2.f243292c.f179382j.setVisibility(0);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                PngFrameManager.this.m(anonymousClass1.f243279d);
                                c cVar3 = AnonymousClass1.this.f243279d;
                                a aVar = cVar3.f243296g;
                                if (aVar != null) {
                                    aVar.b(cVar3.f243292c);
                                }
                            }
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                {
                    this.f243279d = cVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PngFrameManager.this, (Object) cVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MarketFaceItemBuilder.c cVar5 = this.f243279d.f243292c;
                    ProgressBar progressBar = cVar5.f179382j;
                    if (progressBar != null && cVar5.f179379g != null && progressBar.getVisibility() != 0 && this.f243279d.f243292c.f179379g.getVisibility() == 0) {
                        this.f243279d.f243292c.f179381i.setOnClickListener(new a());
                    }
                }
            }, 1000L);
            return;
        }
        if (aVar != null) {
            aVar.a(true);
        }
    }

    void k(c cVar) {
        String replace = MarketFaceConstants.emoticonAIOPreviewPath.replace("[epId]", cVar.f243293d).replace("[eId]", cVar.f243292c.f179378f.getEmoticon().eId);
        Bitmap f16 = ImageCacheHelper.f98636a.f(replace);
        if (f16 != null && !f16.isRecycled()) {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func showAIOPreview, \u3010aio preview\u3011, exist in Cache.");
            }
            cVar.f243297h = f16;
            synchronized (this) {
                Handler handler = this.f243277i;
                if (handler != null) {
                    handler.obtainMessage(227, cVar).sendToTarget();
                }
            }
            return;
        }
        n(cVar.f243292c.f179382j, 0);
        cVar.f243292c.f179380h.setImageResource(R.drawable.fnm);
        ThreadManagerV2.post(new Runnable(replace, cVar) { // from class: com.tencent.mobileqq.magicface.drawable.PngFrameManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f243282d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f243283e;

            /* renamed from: com.tencent.mobileqq.magicface.drawable.PngFrameManager$3$a */
            /* loaded from: classes15.dex */
            class a extends f {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // com.tencent.mobileqq.vip.f
                public void onDone(g gVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PngFrameManager", 2, "func onDone.\u3010aio preview\u3011");
                    }
                    synchronized (PngFrameManager.this) {
                        if (PngFrameManager.this.f243277i != null) {
                            if (gVar.i() != 3) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                PngFrameManager.this.f243277i.obtainMessage(226, anonymousClass3.f243283e).sendToTarget();
                            } else {
                                Bitmap a16 = PngGifEngine.a(AnonymousClass3.this.f243282d);
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                c cVar = anonymousClass32.f243283e;
                                cVar.f243297h = a16;
                                PngFrameManager.this.f243277i.obtainMessage(227, cVar).sendToTarget();
                                ImageCacheHelper.f98636a.i(AnonymousClass3.this.f243282d, a16, Business.AIO);
                            }
                        }
                    }
                }
            }

            {
                this.f243282d = replace;
                this.f243283e = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PngFrameManager.this, replace, cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (FileUtils.fileExists(this.f243282d)) {
                    this.f243283e.f243297h = PngGifEngine.a(this.f243282d);
                    synchronized (PngFrameManager.this) {
                        Handler handler2 = PngFrameManager.this.f243277i;
                        if (handler2 != null) {
                            handler2.obtainMessage(227, this.f243283e).sendToTarget();
                        }
                    }
                    return;
                }
                String str = this.f243283e.f243292c.f179378f.getEmoticon().eId;
                g gVar = new g(EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str).replace("[width]", "200").replace("[height]", "200"), new File(this.f243282d));
                gVar.Q = true;
                PngFrameManager.this.f243278m.startDownload(gVar, new a(), null);
            }
        }, 5, null, true);
    }

    void l(c cVar) {
        e c16 = c(cVar.f243293d);
        if (c16 != null && c16.b()) {
            com.tencent.mobileqq.magicface.drawable.c b16 = b(cVar.f243293d, cVar.f243291b, cVar.f243295f);
            MarketFaceItemBuilder.c cVar2 = cVar.f243292c;
            if (cVar2 != null && cVar2.f179383k == cVar.f243294e) {
                if (b16 != null) {
                    n(cVar2.f179382j, 8);
                    cVar.f243292c.f179380h.setImageDrawable(b16);
                    return;
                } else {
                    synchronized (this) {
                        Handler handler = this.f243277i;
                        if (handler != null) {
                            handler.obtainMessage(226, cVar).sendToTarget();
                        }
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameManager", 2, "func showDrawable ends, \u3010holder not Exists!\u3011");
            }
        }
    }

    void m(c cVar) {
        ThreadManagerV2.post(new Runnable(cVar) { // from class: com.tencent.mobileqq.magicface.drawable.PngFrameManager.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f243285d;

            /* renamed from: com.tencent.mobileqq.magicface.drawable.PngFrameManager$4$a */
            /* loaded from: classes15.dex */
            class a extends f {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f243286a;

                a(String str) {
                    this.f243286a = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) str);
                    }
                }

                @Override // com.tencent.mobileqq.vip.f
                public void onDone(g gVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PngFrameManager", 2, "func onDone.\u3010pngZip\u3011");
                    }
                    synchronized (PngFrameManager.this) {
                        if (PngFrameManager.this.f243277i != null) {
                            if (gVar.i() != 3) {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                PngFrameManager.this.f243277i.obtainMessage(226, anonymousClass4.f243285d).sendToTarget();
                            } else {
                                try {
                                    FileUtils.uncompressZip(this.f243286a, MarketFaceConstants.pngFramePath.replace("[epId]", AnonymousClass4.this.f243285d.f243293d), false);
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                                new File(this.f243286a).delete();
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                PngFrameManager.this.h(anonymousClass42.f243285d.f243292c.f179378f.getEmoticon().epId);
                                AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                                PngFrameManager.this.f243277i.obtainMessage(225, anonymousClass43.f243285d).sendToTarget();
                            }
                        }
                    }
                }
            }

            {
                this.f243285d = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PngFrameManager.this, (Object) cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PngFrameManager", 2, "func showPngFrame, zip NOT exist, download from Server.");
                }
                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) PngFrameManager.this.f243273d.getRuntimeService(IEmoticonManagerService.class);
                EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(this.f243285d.f243293d);
                if (syncFindEmoticonPackageById == null) {
                    syncFindEmoticonPackageById = new EmoticonPackage();
                    syncFindEmoticonPackageById.epId = this.f243285d.f243293d;
                    syncFindEmoticonPackageById.aio = true;
                }
                syncFindEmoticonPackageById.rscType = 1;
                iEmoticonManagerService.saveEmoticonPackage(syncFindEmoticonPackageById);
                String str = this.f243285d.f243292c.f179378f.getEmoticon().eId;
                String replace = EmotionPanelConstans.emoticonPNGZIPUrl.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str);
                String replace2 = MarketFaceConstants.emoticonEncryptPath.replace("[epId]", this.f243285d.f243293d).replace("[eId]", str);
                String replace3 = EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str).replace("[width]", "200").replace("[height]", "200");
                String replace4 = MarketFaceConstants.emoticonAIOPreviewPath.replace("[epId]", this.f243285d.f243293d).replace("[eId]", str);
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                arrayList.add(replace);
                hashMap.put(replace, new File(replace2));
                arrayList.add(replace3);
                hashMap.put(replace3, new File(replace4));
                g gVar = new g(arrayList, hashMap, "random_magicface_" + this.f243285d.f243293d);
                gVar.Q = true;
                PngFrameManager.this.f243278m.startDownload(gVar, new a(replace2), null);
            }
        }, 5, null, true);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameManager", 2, "PngFrameManager \u3010onDestroy\u3011  ");
        }
        ConcurrentHashMap<String, e> concurrentHashMap = this.f243274e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f243274e = null;
        }
        HashMap<Long, Boolean> hashMap = this.f243275f;
        if (hashMap != null) {
            hashMap.clear();
            this.f243275f = null;
        }
        this.f243277i = null;
        this.f243278m = null;
    }
}

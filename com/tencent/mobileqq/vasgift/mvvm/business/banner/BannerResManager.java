package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.utils.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BannerResManager {

    /* renamed from: l, reason: collision with root package name */
    private static volatile BannerResManager f311711l;

    /* renamed from: a, reason: collision with root package name */
    private oh2.a f311712a;

    /* renamed from: g, reason: collision with root package name */
    private PAGFile f311718g;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<SparseArray<Bitmap>> f311714c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<Bitmap> f311715d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<Bitmap> f311716e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private final SparseArray<PAGFile> f311717f = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray<PAGFile> f311719h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    private int f311720i = 0;

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<com.tencent.mobileqq.vasgift.view.anim.c> f311721j = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final QQGiftResourceBusiness f311713b = (QQGiftResourceBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(com.tencent.mobileqq.qqgift.updatasystem.c.class);

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.mobileqq.vasgift.utils.n f311722k = new com.tencent.mobileqq.vasgift.utils.n();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().startsWith("animation.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements b.InterfaceC8940b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f311731a;

        b(String str) {
            this.f311731a = str;
        }

        @Override // com.tencent.mobileqq.vasgift.utils.b.InterfaceC8940b
        public void onComplete(boolean z16) {
            if (z16) {
                BannerResManager.this.j(this.f311731a);
            } else {
                QLog.e("BannerResManager", 1, "loadPag failed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements qh2.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f311733d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f311734e;

        c(int i3, long j3) {
            this.f311733d = i3;
            this.f311734e = j3;
        }

        @Override // qh2.g
        public void onLoadFail(int i3, int i16, int i17, String str) {
            QLog.e("BannerResManager", 1, "load failed:" + this.f311733d);
        }

        @Override // qh2.b
        public void onLoadSuccess(int i3, String str) {
            QLog.i("BannerResManager", 1, "load success::" + this.f311733d);
            VasPerfReportUtils.report(VasPerfReportUtils.BANNER_RES_DOWNLOADED, "", "", "", System.currentTimeMillis() - this.f311734e);
        }
    }

    BannerResManager(oh2.a aVar) {
        this.f311712a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final Bitmap bitmap, final f fVar) {
        if (bitmap == null) {
            fVar.onLoadFailed();
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager.6
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap roundFaceBitmap = ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getRoundFaceBitmap(bitmap);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2 = roundFaceBitmap;
                        if (bitmap2 != null) {
                            fVar.a(bitmap2);
                        } else {
                            fVar.onLoadFailed();
                        }
                    }
                });
            }
        });
    }

    private void C() {
        if (this.f311719h.get(2) == null) {
            this.f311719h.put(2, K(R.raw.f169444ey));
        }
    }

    private void D() {
        if (this.f311717f.get(2) == null) {
            this.f311717f.put(2, K(R.raw.f169445ez));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(String str) {
        String[] list = new File(str).list(new a());
        if (list != null && list.length > 0) {
            return false;
        }
        FileUtils.deleteDirectory(str);
        this.f311720i = 0;
        QLog.e("BannerResManager", 1, "[downloadAnimationRes] file is exist but is empty, dir:" + str);
        return true;
    }

    private void H() {
        this.f311715d.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.nk7));
        this.f311716e.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.nkm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.f311714c.get(2) != null) {
            return;
        }
        SparseArray<Bitmap> sparseArray = new SparseArray<>();
        this.f311714c.put(2, sparseArray);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = ImmersiveUtils.dpToPx(30.0f);
        options.outWidth = ImmersiveUtils.dpToPx(22.0f);
        sparseArray.put(0, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.nju, options));
        sparseArray.put(1, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.njv, options));
        sparseArray.put(2, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.njw, options));
        sparseArray.put(3, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.njx, options));
        sparseArray.put(4, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.njy, options));
        sparseArray.put(5, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.njz, options));
        sparseArray.put(6, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161927nk0, options));
        sparseArray.put(7, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161928nk1, options));
        sparseArray.put(8, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161929nk2, options));
        sparseArray.put(9, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.f161930nk3, options));
        sparseArray.put(10, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.nkn, options));
        sparseArray.put(11, BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.nk6, options));
        H();
    }

    private PAGFile K(int i3) {
        InputStream openRawResource = BaseApplication.getContext().getResources().openRawResource(i3);
        try {
            int available = openRawResource.available();
            if (available <= 0) {
                QLog.e("BannerResManager", 1, "readPagFromRaw error, size is 0");
                return null;
            }
            byte[] bArr = new byte[available];
            openRawResource.read(bArr, 0, available);
            return PAGFile.Load(bArr);
        } catch (Throwable th5) {
            try {
                QLog.e("BannerResManager", 1, "readPagFromRaw error", th5);
                return null;
            } finally {
                FileUtils.close(openRawResource);
            }
        }
    }

    private void h(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("animation.pag");
        this.f311718g = PagViewMonitor.Load(sb5.toString());
        this.f311717f.put(1, PagViewMonitor.Load(str + str2 + 1 + str2 + "qqgift_combo_wave.pag"));
        this.f311717f.put(3, PagViewMonitor.Load(str + str2 + 3 + str2 + "qqgift_combo_wave.pag"));
        this.f311717f.put(4, PagViewMonitor.Load(str + str2 + 4 + str2 + "qqgift_combo_wave.pag"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("combo");
        sb5.append(str2);
        String sb6 = sb5.toString();
        for (int i3 = 1; i3 <= 4; i3++) {
            com.tencent.mobileqq.vasgift.view.anim.c cVar = new com.tencent.mobileqq.vasgift.view.anim.c();
            cVar.f312097a = sb6 + i3 + "_click.png";
            cVar.f312098b = sb6 + i3 + "_combo.png";
            cVar.f312099c = sb6 + i3 + "_trans.png";
            cVar.f312100d = sb6 + i3 + "_transtips.png";
            for (int i16 = 0; i16 < 10; i16++) {
                cVar.f312101e.put(Integer.valueOf(i16), sb6 + i3 + "_" + i16 + ".png");
            }
            cVar.f312101e.put(10, sb6 + i3 + "_x.png");
            this.f311721j.put(i3, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (QQGiftPAGAnimationViewImpl.f311895g.a()) {
            SparseArray<PAGFile> sparseArray = this.f311719h;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(1);
            sb5.append(str2);
            sb5.append("qq_gift_boom.pag");
            sparseArray.put(1, PagViewMonitor.Load(sb5.toString()));
            this.f311719h.put(3, PagViewMonitor.Load(str + str2 + 3 + str2 + "qq_gift_boom.pag"));
            this.f311719h.put(4, PagViewMonitor.Load(str + str2 + 4 + str2 + "qq_gift_boom.pag"));
            h(str);
            return;
        }
        QQGiftPAGAnimationViewImpl.f311895g.b(BaseApplication.getContext(), new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, int i3) {
        SparseArray<Bitmap> sparseArray = new SparseArray<>();
        this.f311714c.put(i3, sparseArray);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(i3);
        sb5.append(str2);
        String sb6 = sb5.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = ImmersiveUtils.dpToPx(30.0f);
        options.outWidth = ImmersiveUtils.dpToPx(22.0f);
        for (int i16 = 0; i16 < 10; i16++) {
            sparseArray.put(i16, BitmapFactory.decodeFile(sb6 + "qq_gift_" + i16 + ".png", options));
        }
        sparseArray.put(10, BitmapFactory.decodeFile(sb6 + "qq_gift_x.png", options));
        sparseArray.put(11, BitmapFactory.decodeFile(sb6 + "qq_gift_bg.png", options));
        options.outHeight = ImmersiveUtils.dpToPx(60.0f);
        options.outWidth = ImmersiveUtils.dpToPx(60.0f);
        this.f311715d.put(i3, BitmapFactory.decodeFile(sb6 + "qqgift_combo.png", options));
        options.outHeight = ImmersiveUtils.dpToPx(121.0f);
        options.outWidth = ImmersiveUtils.dpToPx(58.0f);
        this.f311716e.put(i3, BitmapFactory.decodeFile(sb6 + "qqgift_stimulate.png", options));
    }

    private Bitmap v(int i3) {
        SparseArray<Bitmap> sparseArray = this.f311714c.get(2);
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    private URLDrawable w(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        try {
            return URLDrawable.getDrawable(str, uRLDrawableOptions);
        } catch (Throwable th5) {
            QLog.e("BannerResManager", 1, "getDrawable failed: " + th5.getMessage());
            return null;
        }
    }

    @Nullable
    public static synchronized BannerResManager x() {
        BannerResManager bannerResManager;
        synchronized (BannerResManager.class) {
            bannerResManager = f311711l;
        }
        return bannerResManager;
    }

    public static synchronized BannerResManager y(oh2.a aVar) {
        BannerResManager bannerResManager;
        synchronized (BannerResManager.class) {
            if (f311711l == null) {
                f311711l = new BannerResManager(aVar);
            }
            bannerResManager = f311711l;
        }
        return bannerResManager;
    }

    public Bitmap B(int i3) {
        return z(i3, 10);
    }

    public boolean E(int i3) {
        return new File(n(i3)).exists();
    }

    public void G(com.tencent.mobileqq.qqgift.sdk.config.a aVar) {
        int i3;
        oh2.a aVar2;
        if (this.f311720i == 2) {
            return;
        }
        this.f311720i = 1;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager.1
            @Override // java.lang.Runnable
            public void run() {
                BannerResManager.this.I();
                QLog.i("BannerResManager", 1, "load banner loadDefaultRes");
            }
        }, 64, null, true);
        if (aVar == null) {
            i3 = 0;
        } else {
            i3 = aVar.f264972a;
        }
        if (this.f311722k.b(i3) || (aVar2 = this.f311712a) == null) {
            return;
        }
        aVar2.f(25, new qh2.b() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager.2
            @Override // qh2.g
            public void onLoadFail(int i16, int i17, int i18, String str) {
                BannerResManager.this.f311720i = 0;
                QLog.e("BannerResManager", 1, "load banner res failed " + i17 + str);
            }

            @Override // qh2.b
            public void onLoadSuccess(int i16, final String str) {
                BannerResManager.this.f311720i = 2;
                QLog.i("BannerResManager", 1, "load banner res success");
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!BannerResManager.this.F(str)) {
                            BannerResManager.this.k(str, 1);
                            BannerResManager.this.k(str, 3);
                            BannerResManager.this.k(str, 4);
                            BannerResManager.this.j(str);
                            BannerResManager.this.i(str);
                            QLog.i("BannerResManager", 1, "load banner bitmap res complete");
                        }
                    }
                }, 64, null, true);
            }
        });
    }

    public void J(String str, f fVar) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int dpToPx = ImmersiveUtils.dpToPx(40.0f);
        obtain.mRequestWidth = dpToPx;
        obtain.mRequestHeight = dpToPx;
        URLDrawable w3 = w(str, obtain);
        if (w3 == null) {
            return;
        }
        Drawable currDrawable = w3.getCurrDrawable();
        if (currDrawable instanceof RegionDrawable) {
            A(((RegionDrawable) currDrawable).getBitmap(), fVar);
        }
        w3.setURLDrawableListener(new d(w3, fVar));
        w3.startDownload(true);
    }

    public synchronized void L() {
        QLog.i("BannerResManager", 1, "release");
        f311711l = null;
        this.f311714c.clear();
        this.f311715d.clear();
        this.f311716e.clear();
        this.f311717f.clear();
        this.f311719h.clear();
        this.f311718g = null;
        this.f311712a = null;
    }

    public void M(int i3, SparseArray<Bitmap> sparseArray) {
        if (sparseArray == null) {
            QLog.i("BannerResManager", 1, "setCustomResWithLevel failed! data is null...");
            return;
        }
        if (this.f311714c.get(i3) != null) {
            QLog.i("BannerResManager", 1, "setCustomResWithLevel failed! data is already existed! level:" + i3);
            return;
        }
        this.f311714c.put(i3, sparseArray);
    }

    public void l(int i3, qh2.b bVar) {
        if (this.f311712a == null) {
            return;
        }
        this.f311712a.f(i3, new c(i3, System.currentTimeMillis()));
    }

    public void m(int i3, qh2.f fVar) {
        oh2.a aVar = this.f311712a;
        if (aVar != null) {
            aVar.e(i3, fVar);
        }
    }

    public String n(int i3) {
        StringBuilder sb5 = new StringBuilder();
        QQGiftResourceBusiness qQGiftResourceBusiness = this.f311713b;
        sb5.append(qQGiftResourceBusiness.getSavePath(qQGiftResourceBusiness.f(i3, 2)));
        sb5.append(File.separator);
        sb5.append("piaodai.pag");
        return sb5.toString();
    }

    public Bitmap o(int i3) {
        return z(i3, 11);
    }

    public PAGFile p(int i3) {
        C();
        PAGFile pAGFile = this.f311719h.get(i3);
        if (pAGFile == null) {
            pAGFile = this.f311719h.get(2);
        }
        if (pAGFile == null) {
            QLog.e("BannerResManager", 1, "getBoomFilePath return null");
        }
        return pAGFile;
    }

    public PAGFile q() {
        return this.f311718g;
    }

    public Bitmap r(int i3) {
        Bitmap bitmap = this.f311715d.get(i3);
        if (bitmap == null) {
            return this.f311715d.get(2);
        }
        return bitmap;
    }

    public com.tencent.mobileqq.vasgift.view.anim.c s(int i3) {
        com.tencent.mobileqq.vasgift.view.anim.c cVar = this.f311721j.get(i3);
        if (cVar == null) {
            return new com.tencent.mobileqq.vasgift.view.anim.c();
        }
        return cVar;
    }

    public Bitmap t(int i3) {
        Bitmap bitmap = this.f311716e.get(i3);
        if (bitmap == null) {
            return this.f311716e.get(2);
        }
        return bitmap;
    }

    public PAGFile u(int i3) {
        D();
        PAGFile pAGFile = this.f311717f.get(i3);
        if (pAGFile == null) {
            pAGFile = this.f311717f.get(2);
        }
        if (pAGFile == null) {
            QLog.e("BannerResManager", 1, "getComboWavePag return null");
        }
        return pAGFile;
    }

    public Bitmap z(int i3, int i16) {
        Bitmap bitmap;
        SparseArray<Bitmap> sparseArray = this.f311714c.get(i3);
        if (sparseArray != null) {
            bitmap = sparseArray.get(i16);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return v(i16);
        }
        return bitmap;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f311736d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f311737e;

        d(URLDrawable uRLDrawable, f fVar) {
            this.f311736d = uRLDrawable;
            this.f311737e = fVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            this.f311737e.onLoadFailed();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            Drawable currDrawable = this.f311736d.getCurrDrawable();
            if (currDrawable instanceof RegionDrawable) {
                BannerResManager.this.A(((RegionDrawable) currDrawable).getBitmap(), this.f311737e);
            }
            this.f311737e.onLoadFailed();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}

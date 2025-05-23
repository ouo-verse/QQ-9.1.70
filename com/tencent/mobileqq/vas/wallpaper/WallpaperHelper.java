package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.tencent.android.gldrawable.api.AutoEtcOptions;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import v33.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WallpaperHelper {

    /* renamed from: a, reason: collision with root package name */
    private boolean f311404a = false;

    /* renamed from: b, reason: collision with root package name */
    private u33.a f311405b = null;

    /* renamed from: c, reason: collision with root package name */
    private s33.b f311406c = null;

    /* renamed from: d, reason: collision with root package name */
    private VipWallpaperService.c f311407d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f311408e = false;

    /* renamed from: f, reason: collision with root package name */
    private String f311409f = "";

    /* renamed from: g, reason: collision with root package name */
    private ReTryRunnable f311410g = new ReTryRunnable(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ConfigChangeListener implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<WallpaperHelper> f311411d;

        /* renamed from: e, reason: collision with root package name */
        private VipWallpaperService.c f311412e;

        ConfigChangeListener(WallpaperHelper wallpaperHelper) {
            this.f311411d = new WeakReference<>(wallpaperHelper);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            final WallpaperHelper wallpaperHelper = this.f311411d.get();
            if (wallpaperHelper != null) {
                final VipWallpaperService.c d16 = VipWallpaperService.d(sharedPreferences);
                VipWallpaperService.c cVar = this.f311412e;
                if (cVar == null || !cVar.equals(d16)) {
                    this.f311412e = d16;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ConfigChangeListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wallpaperHelper.h(d16, true);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ReTryRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<WallpaperHelper> f311415d;

        /* renamed from: e, reason: collision with root package name */
        VipWallpaperService.c f311416e;

        public ReTryRunnable(WallpaperHelper wallpaperHelper) {
            this.f311415d = new WeakReference<>(wallpaperHelper);
        }

        public void a(VipWallpaperService.c cVar) {
            this.f311416e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            VipWallpaperService.c cVar;
            WallpaperHelper wallpaperHelper = this.f311415d.get();
            if (wallpaperHelper != null && (cVar = this.f311416e) != null) {
                wallpaperHelper.h(cVar, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Function0<Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s33.b f311417d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VipWallpaperService.c f311418e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f311419f;

        a(s33.b bVar, VipWallpaperService.c cVar, File file) {
            this.f311417d = bVar;
            this.f311418e = cVar;
            this.f311419f = file;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke() {
            return WallpaperHelper.this.f(this.f311417d, this.f311418e, this.f311419f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Function1<IFactoryStub, Drawable> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f311421d;

        b(File file) {
            this.f311421d = file;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawable invoke(IFactoryStub iFactoryStub) {
            return iFactoryStub.useCache(true).fromFile(this.f311421d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private s33.a c(s33.b bVar, VipWallpaperService.c cVar) {
        Drawable drawable;
        this.f311409f = null;
        File file = new File(cVar.f311402b);
        QLog.i("VipWallpaper", 1, "use " + cVar.toString() + " imgFile exists = " + file.exists());
        if (!cVar.f311401a.equals("0")) {
            a aVar = new a(bVar, cVar, file);
            if (VasToggle.isEnable(VasToggle.GLDRAWABLE, true) && bVar.a()) {
                File file2 = new File(cVar.f311402b.replace("aioImage", "aio_bg.mp4"));
                if (file2.exists()) {
                    drawable = GLDrawableApi.asyncFactory(aVar, new b(file2));
                    this.f311409f = "wallpaper-video";
                    if (drawable == null) {
                        drawable = aVar.invoke();
                    }
                }
            }
            drawable = null;
            if (drawable == null) {
            }
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = VipWallpaperService.b();
        }
        if (drawable != null) {
            QLog.i("VipWallpaper", 1, "use " + drawable.getClass().getName());
            return new t33.a(drawable);
        }
        QLog.i("VipWallpaper", 1, "drawable error");
        return null;
    }

    private s33.b d(SurfaceHolder surfaceHolder) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new c(surfaceHolder);
        }
        return new v33.b(surfaceHolder);
    }

    @Nullable
    private Drawable e(File file, Drawable drawable) {
        ApngDrawable apngDrawable;
        if (drawable == null && ChatBackgroundManager.t(file)) {
            if (!this.f311408e) {
                an h16 = an.h();
                if (h16.isLoaded()) {
                    this.f311408e = true;
                } else {
                    this.f311408e = h16.loadSoLib();
                }
            }
            if (this.f311408e) {
                try {
                    apngDrawable = new ApngDrawable(file, (Resources) null);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    apngDrawable.getImage().setSupportGlobalPasued(false);
                    this.f311409f = "wallpaper-apng";
                    return apngDrawable;
                } catch (Throwable th6) {
                    th = th6;
                    drawable = apngDrawable;
                    th.printStackTrace();
                    return drawable;
                }
            }
            return drawable;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Drawable f(s33.b bVar, VipWallpaperService.c cVar, File file) {
        IGLDrawable iGLDrawable;
        Bitmap bitmap = null;
        if (VasToggle.getBooleanDataSet(VasToggle.GLDRAWABLE, "etc", true) && bVar.a()) {
            AutoEtcOptions autoEtcOptions = new AutoEtcOptions();
            autoEtcOptions.setFilePath(cVar.f311402b);
            iGLDrawable = GLDrawableApi.factory().useCache(false).fromBundle(autoEtcOptions.toBundle());
            if (iGLDrawable instanceof IGLDrawable) {
                this.f311409f = "wallpaper-aetc";
            }
        } else {
            iGLDrawable = null;
        }
        Drawable e16 = e(file, iGLDrawable);
        if (e16 == null) {
            try {
                bitmap = BitmapFactory.decodeFile(cVar.f311402b);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                this.f311409f = "wallpaper-static";
                return bitmapDrawable;
            }
            return e16;
        }
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(VipWallpaperService.c cVar, boolean z16) {
        if (this.f311404a) {
            return;
        }
        if (z16) {
            this.f311410g.f311416e = null;
        }
        if (!cVar.equals(this.f311407d)) {
            m();
            s33.a c16 = c(this.f311406c, cVar);
            if (c16 != null) {
                u33.a aVar = new u33.a(c16, this.f311406c);
                this.f311405b = aVar;
                aVar.f();
                this.f311407d = cVar;
                return;
            }
            this.f311407d = null;
            this.f311410g.a(cVar);
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f311410g);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.f311410g, 3000L);
            }
        }
    }

    private void m() {
        u33.a aVar = this.f311405b;
        if (aVar != null) {
            aVar.d();
            this.f311405b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WallpaperColors g() {
        Color valueOf;
        if (Build.VERSION.SDK_INT >= 27) {
            valueOf = Color.valueOf(Color.parseColor("#ff000000"));
            QLog.i("VipWallpaper", 1, "onComputeColors " + valueOf.toString());
            return new WallpaperColors(valueOf, valueOf, valueOf);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        u33.a aVar = this.f311405b;
        if (aVar != null && !this.f311404a) {
            aVar.b(i16, i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(Context context, SurfaceHolder surfaceHolder) {
        this.f311404a = false;
        this.f311406c = d(surfaceHolder);
        SharedPreferences a16 = VipWallpaperService.a(context);
        a16.registerOnSharedPreferenceChangeListener(new ConfigChangeListener(this));
        h(VipWallpaperService.d(a16), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        m();
        this.f311404a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z16) {
        u33.a aVar = this.f311405b;
        if (aVar == null) {
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f311410g);
                ThreadManagerV2.getUIHandlerV2().post(this.f311410g);
                return;
            }
            return;
        }
        if (z16) {
            aVar.e();
            if (!TextUtils.isEmpty(this.f311409f) && VasStatisticCollector.isHit() && QLog.isColorLevel()) {
                QLog.d("VipWallpaper", 2, "wallpaperType=" + this.f311409f);
                return;
            }
            return;
        }
        aVar.c();
    }
}

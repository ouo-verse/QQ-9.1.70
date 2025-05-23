package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qqui.tempapi.IQQUITempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cz;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k implements URLDrawable.URLDrawableListener, FaceDrawable.OnLoadingStateChangeListener, Drawable.Callback {
    private static final LruCache<String, Integer> D = new LruCache<>(100);
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private final Context f201685d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f201686e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f201687f;

    /* renamed from: h, reason: collision with root package name */
    private int f201688h = -1;

    /* renamed from: i, reason: collision with root package name */
    private String f201689i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f201690m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(Drawable drawable);

        void b(Drawable drawable, Throwable th5);

        void c(int i3);

        void d(Drawable drawable, int i3);

        void e(@NonNull Drawable drawable);

        void onLoadSuccess(Drawable drawable);
    }

    public k(@NonNull Context context) {
        this.f201685d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Drawable c16 = c();
        if (c16 == this.f201690m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap drawabletoBitmapV2 = BaseImageUtil.drawabletoBitmapV2(c16, 15, 15);
        if (drawabletoBitmapV2 == null) {
            QLog.e("ColorURLDrawable", 1, "Failed to create bitmap!!!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ColorURLDrawable", 2, "drawable to bitmap cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.f201687f = xy2.d.b(drawabletoBitmapV2).b().p(-2697514);
        D.put(this.f201689i, Integer.valueOf(this.f201687f));
        a aVar = this.C;
        if (aVar != null) {
            aVar.c(this.f201687f);
        }
        QLog.d("ColorURLDrawable", 1, "get color cost: " + (System.currentTimeMillis() - currentTimeMillis2) + "ms color: #" + String.format("%08X", Integer.valueOf(this.f201687f)) + " url: " + this.f201689i + " drawable: " + c16.getClass().getName());
        drawabletoBitmapV2.recycle();
    }

    private void e() {
        Integer num = D.get(this.f201689i);
        if (num != null) {
            this.f201687f = num.intValue();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.d();
                }
            }, 16, null, true);
        }
    }

    private void g(URL url) {
        Integer num = D.get(this.f201689i);
        if (num != null) {
            this.f201687f = num.intValue();
        }
        if (ProtocolDownloaderConstants.PROTOCOL_RES_DRAWABLE.equals(url.getProtocol())) {
            try {
                this.f201686e = AppCompatResources.getDrawable(this.f201685d, Integer.parseInt(url.getHost()));
                e();
                return;
            } catch (Throwable th5) {
                this.f201686e = null;
                QLog.e("ColorURLDrawable", 1, "load res error: url error.", th5);
                return;
            }
        }
        if (ProtocolDownloaderConstants.PROTOCAL_UIN_DRAWABLE.equals(url.getProtocol())) {
            Drawable c16 = cz.c(url.getQuery(), this);
            this.f201686e = c16;
            c16.setCallback(this);
            return;
        }
        Resources resources = this.f201685d.getResources();
        if (URLDrawable.depImp == null) {
            ((IQQUITempApi) QRoute.api(IQQUITempApi.class)).initUrlDrawable();
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = Utils.n(28.0f, resources);
        obtain.mRequestHeight = Utils.n(28.0f, resources);
        Drawable drawable = this.f201690m;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        this.f201686e = drawable2;
        drawable2.setURLDrawableListener(this);
        if (drawable2.getStatus() == 1) {
            e();
        } else {
            drawable2.startDownload();
        }
    }

    public int b() {
        return this.f201687f;
    }

    public Drawable c() {
        Drawable drawable = this.f201686e;
        if (drawable == null) {
            return this.f201690m;
        }
        return drawable;
    }

    public void f(String str, int i3) {
        if (this.f201688h != i3) {
            this.f201688h = i3;
            this.f201690m = AppCompatResources.getDrawable(this.f201685d, i3);
        }
        if (TextUtils.equals(this.f201689i, str)) {
            return;
        }
        this.f201689i = str;
        this.f201687f = -2697514;
        if (TextUtils.isEmpty(str)) {
            this.f201686e = null;
            return;
        }
        try {
            g(new URL(str));
        } catch (MalformedURLException e16) {
            this.f201686e = null;
            QLog.e("ColorURLDrawable", 1, "parse url failed!", e16);
        }
    }

    public void h(a aVar) {
        this.C = aVar;
    }

    public void i(Drawable drawable) {
        this.f201690m = drawable;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        a aVar;
        Drawable drawable2 = this.f201686e;
        if (drawable == drawable2 && (drawable2 instanceof FaceDrawable) && (aVar = this.C) != null) {
            aVar.e(drawable);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        a aVar = this.C;
        if (aVar != null) {
            aVar.a(uRLDrawable);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        a aVar = this.C;
        if (aVar != null) {
            aVar.b(uRLDrawable, th5);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        a aVar = this.C;
        if (aVar != null) {
            aVar.d(uRLDrawable, i3);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        e();
        a aVar = this.C;
        if (aVar != null) {
            aVar.onLoadSuccess(uRLDrawable);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
    public void onLoadingStateChanged(int i3, int i16) {
        if (i16 == 1) {
            e();
            a aVar = this.C;
            if (aVar != null) {
                aVar.onLoadSuccess(this.f201686e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
    }
}

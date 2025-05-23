package com.qq.e.comm.plugin.base.media.a;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.k.u;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    private static String f39186e = "ImageTask";

    /* renamed from: a, reason: collision with root package name */
    private String f39187a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f39188b;

    /* renamed from: c, reason: collision with root package name */
    private d f39189c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39190d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39191f;

    /* renamed from: g, reason: collision with root package name */
    private File f39192g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39193h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f39200a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f39201b;

        /* renamed from: c, reason: collision with root package name */
        public d f39202c;

        /* renamed from: e, reason: collision with root package name */
        public File f39204e;

        /* renamed from: d, reason: collision with root package name */
        public boolean f39203d = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f39205f = true;
    }

    public e(a aVar) {
        this.f39191f = false;
        this.f39193h = true;
        this.f39187a = aVar.f39200a;
        this.f39188b = aVar.f39201b;
        this.f39189c = aVar.f39202c;
        this.f39191f = aVar.f39203d;
        this.f39192g = aVar.f39204e;
        this.f39193h = aVar.f39205f;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GDTLogger.e("ImageTask run not allowed use in main thread!");
            c();
            return;
        }
        File file = this.f39192g;
        if (file == null || !file.exists() || (bitmap = h.a(this.f39192g, this.f39188b)) == null) {
            bitmap = null;
        }
        if (bitmap == null && !TextUtils.isEmpty(this.f39187a)) {
            bitmap = u.a(this.f39187a, this.f39188b);
        }
        if (bitmap != null) {
            this.f39190d = true;
        }
        b();
        if (bitmap != null) {
            GDTLogger.i(f39186e + "run. imgUrl: " + this.f39187a + " complete");
            a((Movie) null, bitmap);
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                e eVar = e.this;
                Object a16 = eVar.a(eVar.f39187a);
                if (a16 instanceof Bitmap) {
                    bitmap2 = (Bitmap) a16;
                } else {
                    bitmap2 = null;
                }
                if (bitmap2 != null) {
                    GDTLogger.i(e.f39186e + "run. imgUrl: " + e.this.f39187a + " complete");
                    e.this.a((Movie) null, bitmap2);
                    return;
                }
                GDTLogger.i(e.f39186e + "run. imgUrl: " + e.this.f39187a + " fail");
                e.this.c();
            }
        });
    }

    private void b() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f39189c != null) {
                    e.this.f39189c.a(e.this.f39187a, e.this.f39190d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.e.4
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f39189c != null) {
                    e.this.f39189c.a(e.this.f39187a, e.this.f39188b, 406);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Movie movie, final Bitmap bitmap) {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.base.media.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f39188b != null && e.this.f39193h) {
                    e.this.f39188b.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (movie != null && (e.this.f39188b instanceof b)) {
                        ((b) e.this.f39188b).a(movie);
                        ((b) e.this.f39188b).a(true);
                    } else if (e.this.f39188b instanceof b) {
                        if (!e.this.f39191f || !((b) e.this.f39188b).a()) {
                            e.this.f39188b.setImageBitmap(bitmap);
                        }
                        ((b) e.this.f39188b).a(true);
                    } else {
                        e.this.f39188b.setImageBitmap(bitmap);
                    }
                }
                if (e.this.f39189c != null) {
                    e.this.f39189c.a(e.this.f39187a, e.this.f39188b, bitmap, movie);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str) {
        Object obj = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(10000);
            obj = u.a(str, httpURLConnection, this.f39188b);
            b();
            return obj;
        } catch (Exception unused) {
            c();
            return obj;
        }
    }
}

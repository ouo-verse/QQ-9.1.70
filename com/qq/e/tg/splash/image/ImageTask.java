package com.qq.e.tg.splash.image;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageTask implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    private static String f40836e = "ImageTask";

    /* renamed from: a, reason: collision with root package name */
    private String f40837a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f40838b;

    /* renamed from: c, reason: collision with root package name */
    private ImageLoadingListener f40839c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40840d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40841f;

    /* renamed from: g, reason: collision with root package name */
    private File f40842g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f40843h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Params {
        public File imageFile;
        public ImageLoadingListener imageLoadingListener;
        public ImageView imageView;
        public String imgUrl;
        public boolean isGaussianUrl = false;
        public boolean needSetSourceInternal = true;

        public final boolean isValid() {
            if (!TextUtils.isEmpty(this.imgUrl)) {
                File file = this.imageFile;
                if (file == null || !file.exists()) {
                    return false;
                }
                return true;
            }
            return true;
        }
    }

    public ImageTask(Params params) {
        this.f40841f = false;
        this.f40843h = true;
        this.f40837a = params.imgUrl;
        this.f40838b = params.imageView;
        this.f40839c = params.imageLoadingListener;
        this.f40841f = params.isGaussianUrl;
        this.f40842g = params.imageFile;
        this.f40843h = params.needSetSourceInternal;
    }

    private void b() {
        ImageLoadingListener imageLoadingListener = this.f40839c;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingStatus(this.f40837a, this.f40840d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ImageLoadingListener imageLoadingListener = this.f40839c;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingFailed(this.f40837a, this.f40838b, 406);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        ImageView imageView;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GDTLogger.e("ImageTask run not allowed use in main thread!");
            c();
            return;
        }
        File file = this.f40842g;
        Movie movie = null;
        if (file != null && file.exists()) {
            Movie movieFromDisk = GifImageUtil.getMovieFromDisk(this.f40842g);
            if (movieFromDisk != null || (bitmap = BitmapUtil.decodeBitmapFromFile(this.f40842g, this.f40838b)) == null) {
                bitmap = null;
            }
            movie = movieFromDisk;
        } else {
            bitmap = null;
        }
        if (!TextUtils.isEmpty(this.f40837a) && (movie = GifImageUtil.getMovieFromDisk(this.f40837a)) == null && (imageView = this.f40838b) != null) {
            bitmap = GifImageUtil.getBitmapFromDisk(this.f40837a, imageView);
        }
        if (movie != null || bitmap != null) {
            this.f40840d = true;
        }
        b();
        if (movie == null && bitmap == null) {
            GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.tg.splash.image.ImageTask.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    ImageTask imageTask = ImageTask.this;
                    Object a16 = imageTask.a(imageTask.f40837a);
                    Movie movie2 = null;
                    if (a16 instanceof Movie) {
                        movie2 = (Movie) a16;
                        bitmap2 = null;
                    } else if (a16 instanceof Bitmap) {
                        bitmap2 = (Bitmap) a16;
                    } else {
                        bitmap2 = null;
                    }
                    if (movie2 == null && bitmap2 == null) {
                        GDTLogger.i(ImageTask.f40836e + "run. imgUrl: " + ImageTask.this.f40837a + " fail");
                        ImageTask.this.c();
                        return;
                    }
                    GDTLogger.i(ImageTask.f40836e + "run. imgUrl: " + ImageTask.this.f40837a + " complete");
                    ImageTask.this.a(movie2, bitmap2);
                }
            });
            return;
        }
        GDTLogger.i(f40836e + "run. imgUrl: " + this.f40837a + " complete");
        a(movie, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str) {
        Object obj;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(10000);
            obj = GifImageUtil.getMovieOrBitmapFromUrl(str, httpURLConnection, this.f40838b);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            b();
        } catch (Exception unused2) {
            c();
            return obj;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Movie movie, Bitmap bitmap) {
        ImageLoadingListener imageLoadingListener = this.f40839c;
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingComplete(this.f40837a, this.f40838b, bitmap, movie);
        }
    }
}

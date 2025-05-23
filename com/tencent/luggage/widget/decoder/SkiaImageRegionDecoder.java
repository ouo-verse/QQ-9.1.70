package com.tencent.luggage.widget.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.n6.c;
import com.tencent.luggage.wxa.o6.d;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SkiaImageRegionDecoder implements d {

    /* renamed from: a, reason: collision with root package name */
    public BitmapRegionDecoder f120378a;

    /* renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f120379b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap.Config f120380c;

    @Keep
    public SkiaImageRegionDecoder() {
        this(null);
    }

    public final Lock a() {
        return this.f120379b.readLock();
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public Bitmap decodeRegion(Rect rect, int i3) {
        a().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.f120378a;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i3;
                options.inPreferredConfig = this.f120380c;
                Bitmap decodeRegion = this.f120378a.decodeRegion(rect, options);
                if (decodeRegion != null) {
                    return decodeRegion;
                }
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            a().unlock();
        }
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public Point init(Context context, Uri uri) {
        Resources resourcesForApplication;
        int i3;
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i3 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i3 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i3 = 0;
            }
            this.f120378a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i3), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.f120378a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f120378a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    this.f120378a = BitmapRegionDecoder.newInstance(openInputStream, false);
                    try {
                        openInputStream.close();
                    } catch (Exception unused2) {
                    }
                } else {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
            } catch (Throwable th5) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th5;
            }
        }
        return new Point(this.f120378a.getWidth(), this.f120378a.getHeight());
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public synchronized boolean isReady() {
        boolean z16;
        BitmapRegionDecoder bitmapRegionDecoder = this.f120378a;
        if (bitmapRegionDecoder != null) {
            if (!bitmapRegionDecoder.isRecycled()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public synchronized void recycle() {
        this.f120379b.writeLock().lock();
        try {
            this.f120378a.recycle();
            this.f120378a = null;
        } finally {
            this.f120379b.writeLock().unlock();
        }
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.f120379b = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = c.getPreferredBitmapConfig();
        if (config != null) {
            this.f120380c = config;
        } else if (preferredBitmapConfig != null) {
            this.f120380c = preferredBitmapConfig;
        } else {
            this.f120380c = Bitmap.Config.RGB_565;
        }
    }
}

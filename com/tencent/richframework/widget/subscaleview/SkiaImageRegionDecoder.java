package com.tencent.richframework.widget.subscaleview;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final ReadWriteLock decoderLock;

    @Keep
    public SkiaImageRegionDecoder() {
        this(null);
    }

    private Lock getDecodeLock() {
        return this.decoderLock.readLock();
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i3) {
        getDecodeLock().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
            if (bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i3;
                options.inPreferredConfig = this.bitmapConfig;
                Bitmap decodeRegion = this.decoder.decodeRegion(rect, options);
                if (decodeRegion != null) {
                    return decodeRegion;
                }
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            getDecodeLock().unlock();
        }
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    @NonNull
    public Point init(Context context, @NonNull Uri uri) throws Exception {
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
            this.decoder = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i3), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.decoder = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.decoder = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    this.decoder = BitmapRegionDecoder.newInstance(openInputStream, false);
                    try {
                        openInputStream.close();
                    } catch (Exception e16) {
                        RFWLog.e("SkiaImageRegionDecoder", RFWLog.USR, e16);
                    }
                } else {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
            } catch (Throwable th5) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                        RFWLog.e("SkiaImageRegionDecoder", RFWLog.USR, e17);
                    }
                }
                throw th5;
            }
        }
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    public synchronized boolean isReady() {
        boolean z16;
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        if (bitmapRegionDecoder != null) {
            if (!bitmapRegionDecoder.isRecycled()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            this.decoder.recycle();
            this.decoder = null;
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    public SkiaImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.decoderLock = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}

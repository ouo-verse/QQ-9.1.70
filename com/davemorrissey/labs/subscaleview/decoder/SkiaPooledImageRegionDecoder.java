package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class SkiaPooledImageRegionDecoder implements d {

    /* renamed from: i, reason: collision with root package name */
    private static final String f32568i = "SkiaPooledImageRegionDecoder";

    /* renamed from: j, reason: collision with root package name */
    private static boolean f32569j = false;

    /* renamed from: a, reason: collision with root package name */
    private a f32570a;

    /* renamed from: b, reason: collision with root package name */
    private final ReadWriteLock f32571b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f32572c;

    /* renamed from: d, reason: collision with root package name */
    private Context f32573d;

    /* renamed from: e, reason: collision with root package name */
    private Uri f32574e;

    /* renamed from: f, reason: collision with root package name */
    private long f32575f;

    /* renamed from: g, reason: collision with root package name */
    private final Point f32576g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f32577h;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Semaphore f32578a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<BitmapRegionDecoder, Boolean> f32579b;

        a() {
            this.f32578a = new Semaphore(0, true);
            this.f32579b = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder g() {
            this.f32578a.acquireUninterruptibly();
            return i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void h(BitmapRegionDecoder bitmapRegionDecoder) {
            this.f32579b.put(bitmapRegionDecoder, Boolean.FALSE);
            this.f32578a.release();
        }

        private synchronized BitmapRegionDecoder i() {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.f32579b.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean j() {
            return this.f32579b.isEmpty();
        }

        private synchronized boolean k(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.f32579b.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!entry.getValue().booleanValue()) {
                        return false;
                    }
                    entry.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void l() {
            while (!this.f32579b.isEmpty()) {
                BitmapRegionDecoder g16 = g();
                g16.recycle();
                this.f32579b.remove(g16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(BitmapRegionDecoder bitmapRegionDecoder) {
            if (k(bitmapRegionDecoder)) {
                this.f32578a.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int n() {
            return this.f32579b.size();
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (f32569j) {
            Log.d(f32568i, str);
        }
    }

    private int g() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        BitmapRegionDecoder bitmapRegionDecoder2;
        Resources resourcesForApplication;
        int i3;
        String uri = this.f32574e.toString();
        long j3 = Long.MAX_VALUE;
        if (uri.startsWith("android.resource://")) {
            String authority = this.f32574e.getAuthority();
            if (this.f32573d.getPackageName().equals(authority)) {
                resourcesForApplication = this.f32573d.getResources();
            } else {
                resourcesForApplication = this.f32573d.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.f32574e.getPathSegments();
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
            try {
                j3 = this.f32573d.getResources().openRawResourceFd(i3).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder2 = BitmapRegionDecoder.newInstance(this.f32573d.getResources().openRawResource(i3), false);
        } else if (uri.startsWith("file:///android_asset/")) {
            String substring = uri.substring(22);
            try {
                j3 = this.f32573d.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder2 = BitmapRegionDecoder.newInstance(this.f32573d.getAssets().open(substring, 1), false);
        } else {
            if (uri.startsWith("file://")) {
                bitmapRegionDecoder = BitmapRegionDecoder.newInstance(uri.substring(7), false);
                try {
                    File file = new File(uri);
                    if (file.exists()) {
                        j3 = file.length();
                    }
                } catch (Exception unused4) {
                }
            } else {
                InputStream inputStream = null;
                try {
                    ContentResolver contentResolver = this.f32573d.getContentResolver();
                    inputStream = contentResolver.openInputStream(this.f32574e);
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                    try {
                        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f32574e, "r");
                        if (openAssetFileDescriptor != null) {
                            j3 = openAssetFileDescriptor.getLength();
                        }
                    } catch (Exception unused5) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused6) {
                            bitmapRegionDecoder = newInstance;
                        }
                    }
                    bitmapRegionDecoder2 = newInstance;
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th5;
                }
            }
            bitmapRegionDecoder2 = bitmapRegionDecoder;
        }
        this.f32575f = j3;
        this.f32576g.set(bitmapRegionDecoder2.getWidth(), bitmapRegionDecoder2.getHeight());
        this.f32571b.writeLock().lock();
        try {
            a aVar = this.f32570a;
            if (aVar != null) {
                aVar.h(bitmapRegionDecoder2);
            }
        } finally {
            this.f32571b.writeLock().unlock();
        }
    }

    private boolean i() {
        ActivityManager activityManager = (ActivityManager) this.f32573d.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    private void j() {
        if (this.f32577h.compareAndSet(false, true) && this.f32575f < Long.MAX_VALUE) {
            f("Starting lazy init of additional decoders");
            new BaseThread() { // from class: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (SkiaPooledImageRegionDecoder.this.f32570a != null) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                        if (skiaPooledImageRegionDecoder.e(skiaPooledImageRegionDecoder.f32570a.n(), SkiaPooledImageRegionDecoder.this.f32575f)) {
                            try {
                                if (SkiaPooledImageRegionDecoder.this.f32570a != null) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.f("Starting decoder");
                                    SkiaPooledImageRegionDecoder.this.h();
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.f("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                }
                            } catch (Exception e16) {
                                SkiaPooledImageRegionDecoder.this.f("Failed to start decoder: " + e16.getMessage());
                            }
                        } else {
                            return;
                        }
                    }
                }
            }.start();
        }
    }

    @Keep
    public static void setDebug(boolean z16) {
        f32569j = z16;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.d
    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i3) {
        f("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.f32576g.x || rect.height() < this.f32576g.y) {
            j();
        }
        this.f32571b.readLock().lock();
        try {
            a aVar = this.f32570a;
            if (aVar != null) {
                BitmapRegionDecoder g16 = aVar.g();
                if (g16 != null) {
                    try {
                        if (!g16.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i3;
                            options.inPreferredConfig = this.f32572c;
                            Bitmap decodeRegion = g16.decodeRegion(rect, options);
                            if (decodeRegion != null) {
                                return decodeRegion;
                            }
                            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                        }
                    } finally {
                        this.f32570a.m(g16);
                    }
                }
                if (g16 != null) {
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.f32571b.readLock().unlock();
        }
    }

    public boolean e(int i3, long j3) {
        if (i3 >= 4) {
            f("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j16 = i3 * j3;
        if (j16 > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            f("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i3 >= g()) {
            f("No additional encoders allowed, limited by CPU cores (" + g() + ")");
            return false;
        }
        if (i()) {
            f("No additional encoders allowed, memory is low");
            return false;
        }
        f("Additional decoder allowed, current count is " + i3 + ", estimated native memory " + (j16 / 1048576) + "Mb");
        return true;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.d
    @NonNull
    public Point init(Context context, @NonNull Uri uri) throws Exception {
        this.f32573d = context;
        this.f32574e = uri;
        h();
        return this.f32576g;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.d
    public synchronized boolean isReady() {
        boolean z16;
        a aVar = this.f32570a;
        if (aVar != null) {
            if (!aVar.j()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.d
    public synchronized void recycle() {
        this.f32571b.writeLock().lock();
        try {
            a aVar = this.f32570a;
            if (aVar != null) {
                aVar.l();
                this.f32570a = null;
                this.f32573d = null;
                this.f32574e = null;
            }
        } finally {
            this.f32571b.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.f32570a = new a();
        this.f32571b = new ReentrantReadWriteLock(true);
        this.f32575f = Long.MAX_VALUE;
        this.f32576g = new Point(0, 0);
        this.f32577h = new AtomicBoolean(false);
        Bitmap.Config h06 = SubsamplingScaleImageView.h0();
        if (config != null) {
            this.f32572c = config;
        } else if (h06 != null) {
            this.f32572c = h06;
        } else {
            this.f32572c = Bitmap.Config.RGB_565;
        }
    }
}

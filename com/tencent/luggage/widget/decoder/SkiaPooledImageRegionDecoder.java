package com.tencent.luggage.widget.decoder;

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
import com.tencent.luggage.wxa.o6.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class SkiaPooledImageRegionDecoder implements d {

    /* renamed from: i, reason: collision with root package name */
    public static final String f120381i = "SkiaPooledImageRegionDecoder";

    /* renamed from: j, reason: collision with root package name */
    public static boolean f120382j = false;

    /* renamed from: a, reason: collision with root package name */
    public c f120383a;

    /* renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f120384b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap.Config f120385c;

    /* renamed from: d, reason: collision with root package name */
    public Context f120386d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f120387e;

    /* renamed from: f, reason: collision with root package name */
    public long f120388f;

    /* renamed from: g, reason: collision with root package name */
    public final Point f120389g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f120390h;

    /* loaded from: classes5.dex */
    public class a extends BaseThread {
        public a() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (SkiaPooledImageRegionDecoder.this.f120383a != null) {
                SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                if (skiaPooledImageRegionDecoder.a(skiaPooledImageRegionDecoder.f120383a.e(), SkiaPooledImageRegionDecoder.this.f120388f)) {
                    try {
                        if (SkiaPooledImageRegionDecoder.this.f120383a != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.a("Starting decoder");
                            SkiaPooledImageRegionDecoder.this.c();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.a("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        }
                    } catch (Exception e16) {
                        SkiaPooledImageRegionDecoder.this.a("Failed to start decoder: " + e16.getMessage());
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements FileFilter {
        public b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Semaphore f120393a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f120394b;

        public c() {
            this.f120393a = new Semaphore(0, true);
            this.f120394b = new ConcurrentHashMap();
        }

        public final synchronized int e() {
            return this.f120394b.size();
        }

        public final synchronized boolean c() {
            return this.f120394b.isEmpty();
        }

        public final synchronized void d() {
            while (!this.f120394b.isEmpty()) {
                BitmapRegionDecoder a16 = a();
                a16.recycle();
                this.f120394b.remove(a16);
            }
        }

        public final BitmapRegionDecoder a() {
            this.f120393a.acquireUninterruptibly();
            return b();
        }

        public final synchronized BitmapRegionDecoder b() {
            for (Map.Entry entry : this.f120394b.entrySet()) {
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return (BitmapRegionDecoder) entry.getKey();
                }
            }
            return null;
        }

        public final void c(BitmapRegionDecoder bitmapRegionDecoder) {
            if (b(bitmapRegionDecoder)) {
                this.f120393a.release();
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public final synchronized void a(BitmapRegionDecoder bitmapRegionDecoder) {
            this.f120394b.put(bitmapRegionDecoder, Boolean.FALSE);
            this.f120393a.release();
        }

        public final synchronized boolean b(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry entry : this.f120394b.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!((Boolean) entry.getValue()).booleanValue()) {
                        return false;
                    }
                    entry.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    @Keep
    public static void setDebug(boolean z16) {
        f120382j = z16;
    }

    public final boolean d() {
        ActivityManager activityManager = (ActivityManager) this.f120386d.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public Bitmap decodeRegion(Rect rect, int i3) {
        a("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.f120389g.x || rect.height() < this.f120389g.y) {
            e();
        }
        this.f120384b.readLock().lock();
        try {
            c cVar = this.f120383a;
            if (cVar != null) {
                BitmapRegionDecoder a16 = cVar.a();
                if (a16 != null) {
                    try {
                        if (!a16.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i3;
                            options.inPreferredConfig = this.f120385c;
                            Bitmap decodeRegion = a16.decodeRegion(rect, options);
                            if (decodeRegion != null) {
                                return decodeRegion;
                            }
                            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                        }
                    } finally {
                        this.f120383a.c(a16);
                    }
                }
                if (a16 != null) {
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.f120384b.readLock().unlock();
        }
    }

    public final void e() {
        if (this.f120390h.compareAndSet(false, true) && this.f120388f < Long.MAX_VALUE) {
            a("Starting lazy init of additional decoders");
            new a().start();
        }
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public Point init(Context context, Uri uri) {
        this.f120386d = context;
        this.f120387e = uri;
        c();
        return this.f120389g;
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public synchronized boolean isReady() {
        boolean z16;
        c cVar = this.f120383a;
        if (cVar != null) {
            if (!cVar.c()) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    @Override // com.tencent.luggage.wxa.o6.d
    public synchronized void recycle() {
        this.f120384b.writeLock().lock();
        try {
            c cVar = this.f120383a;
            if (cVar != null) {
                cVar.d();
                this.f120383a = null;
                this.f120386d = null;
                this.f120387e = null;
            }
        } finally {
            this.f120384b.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.f120383a = new c(null);
        this.f120384b = new ReentrantReadWriteLock(true);
        this.f120388f = Long.MAX_VALUE;
        this.f120389g = new Point(0, 0);
        this.f120390h = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = com.tencent.luggage.wxa.n6.c.getPreferredBitmapConfig();
        if (config != null) {
            this.f120385c = config;
        } else if (preferredBitmapConfig != null) {
            this.f120385c = preferredBitmapConfig;
        } else {
            this.f120385c = Bitmap.Config.RGB_565;
        }
    }

    public final int b() {
        return Runtime.getRuntime().availableProcessors();
    }

    public final void c() {
        BitmapRegionDecoder bitmapRegionDecoder;
        BitmapRegionDecoder bitmapRegionDecoder2;
        Resources resourcesForApplication;
        int i3;
        String uri = this.f120387e.toString();
        long j3 = Long.MAX_VALUE;
        if (uri.startsWith("android.resource://")) {
            String authority = this.f120387e.getAuthority();
            if (this.f120386d.getPackageName().equals(authority)) {
                resourcesForApplication = this.f120386d.getResources();
            } else {
                resourcesForApplication = this.f120386d.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.f120387e.getPathSegments();
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
                j3 = this.f120386d.getResources().openRawResourceFd(i3).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder2 = BitmapRegionDecoder.newInstance(this.f120386d.getResources().openRawResource(i3), false);
        } else if (uri.startsWith("file:///android_asset/")) {
            String substring = uri.substring(22);
            try {
                j3 = this.f120386d.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder2 = BitmapRegionDecoder.newInstance(this.f120386d.getAssets().open(substring, 1), false);
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
                    ContentResolver contentResolver = this.f120386d.getContentResolver();
                    inputStream = contentResolver.openInputStream(this.f120387e);
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                    try {
                        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f120387e, "r");
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
        this.f120388f = j3;
        this.f120389g.set(bitmapRegionDecoder2.getWidth(), bitmapRegionDecoder2.getHeight());
        this.f120384b.writeLock().lock();
        try {
            c cVar = this.f120383a;
            if (cVar != null) {
                cVar.a(bitmapRegionDecoder2);
            }
        } finally {
            this.f120384b.writeLock().unlock();
        }
    }

    public boolean a(int i3, long j3) {
        if (i3 >= 4) {
            a("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j16 = i3 * j3;
        if (j16 > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            a("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i3 >= b()) {
            a("No additional encoders allowed, limited by CPU cores (" + b() + ")");
            return false;
        }
        if (d()) {
            a("No additional encoders allowed, memory is low");
            return false;
        }
        a("Additional decoder allowed, current count is " + i3 + ", estimated native memory " + (j16 / 1048576) + "Mb");
        return true;
    }

    public final int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new b()).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public final void a(String str) {
        if (f120382j) {
            Log.d(f120381i, str);
        }
    }
}

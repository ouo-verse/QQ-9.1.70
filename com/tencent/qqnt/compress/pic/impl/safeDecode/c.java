package com.tencent.qqnt.compress.pic.impl.safeDecode;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\tH\u0002J$\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u0007R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/safeDecode/c;", "", "dataSource", "Lcom/tencent/qqnt/compress/pic/impl/safeDecode/d;", "safeDecodeOption", "Landroid/graphics/Bitmap;", "e", "", h.F, "Landroid/graphics/BitmapFactory$Options;", "opts", "b", "i", "isShareable", "Landroid/graphics/BitmapRegionDecoder;", "g", "options", "c", "k", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "l", "isNeedCache", "d", "", "Ljava/lang/String;", "rootPath", "flashbackCachePath", "flashbackRegionPath", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final c f355748a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static String rootPath;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static String flashbackCachePath;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static String flashbackRegionPath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f355748a = new c();
        File externalFilesDir = BaseApplication.context.getExternalFilesDir("PicRegionCache");
        Intrinsics.checkNotNull(externalFilesDir);
        String str = externalFilesDir.getAbsolutePath() + "/hugeImageCache";
        rootPath = str;
        flashbackCachePath = str + "/flashback.mc";
        flashbackRegionPath = rootPath + "/flashbackRegion.mc";
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(Object dataSource, BitmapFactory.Options opts, d safeDecodeOption) {
        boolean z16;
        if (opts.outWidth * opts.outHeight < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            if (QLog.isColorLevel()) {
                QLog.d("PicCompress_SafeBitmapFactory", 2, "\u56fe\u7247\u5c0f\u4e8e\u533a\u57df\u89e3\u7801\u9608\u503c");
            }
            z16 = false;
        } else {
            z16 = true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        long j3 = 1024;
        long j16 = (((memoryInfo.totalMem / j3) / j3) / j3) + 1;
        if (j16 > 8) {
            if (QLog.isColorLevel()) {
                QLog.d("PicCompress_SafeBitmapFactory", 2, "\u624b\u673a\u5185\u5b58\u591f\u5927\u3002ram\uff1a" + j16);
            }
            z16 = false;
        }
        if (opts.outWidth * opts.outHeight > SafeBitmapFactory.PX_THRESHOID_DEFAULTS && (dataSource instanceof String)) {
            int i3 = a.INSTANCE.a(flashbackCachePath).i((String) dataSource);
            if (i3 != 0) {
                if (i3 == 1) {
                    safeDecodeOption.e(1);
                    if (!QLog.isColorLevel()) {
                        return true;
                    }
                    QLog.d("PicCompress_SafeBitmapFactory", 2, "\u95ea\u9000\u7f13\u5b58\u4e2d\u5b58\u5728\u8be5\u6570\u636e\uff0c\u8bf4\u660e\u4e4b\u524d\u5d29\u6e83\uff0c\u91c7\u7528\u533a\u57df\u89e3\u7801\u3002");
                    return true;
                }
            } else {
                safeDecodeOption.i(true);
                safeDecodeOption.e(0);
            }
        }
        return z16;
    }

    private final Bitmap c(Object dataSource, BitmapFactory.Options options) {
        if (dataSource instanceof String) {
            return BitmapFactory.decodeFile((String) dataSource, options);
        }
        if (dataSource instanceof InputStream) {
            return BitmapFactory.decodeStream((InputStream) dataSource, null, options);
        }
        if (dataSource instanceof FileDescriptor) {
            return BitmapFactory.decodeFileDescriptor((FileDescriptor) dataSource, null, options);
        }
        if (!(dataSource instanceof byte[])) {
            return null;
        }
        byte[] bArr = (byte[]) dataSource;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    private final Bitmap e(Object dataSource, d safeDecodeOption) {
        if (h(dataSource, safeDecodeOption)) {
            return i(dataSource, safeDecodeOption);
        }
        Bitmap c16 = c(dataSource, safeDecodeOption.b());
        if ((dataSource instanceof String) && safeDecodeOption.c()) {
            a.INSTANCE.a(flashbackCachePath).h((String) dataSource);
        }
        return c16;
    }

    public static /* synthetic */ Bitmap f(c cVar, Object obj, BitmapFactory.Options options, boolean z16, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return cVar.d(obj, options, z16);
    }

    private final BitmapRegionDecoder g(Object dataSource, boolean isShareable) {
        if (dataSource instanceof String) {
            return BitmapRegionDecoder.newInstance((String) dataSource, isShareable);
        }
        if (dataSource instanceof FileDescriptor) {
            return BitmapRegionDecoder.newInstance((FileDescriptor) dataSource, isShareable);
        }
        if (dataSource instanceof byte[]) {
            byte[] bArr = (byte[]) dataSource;
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, isShareable);
        }
        return null;
    }

    private final boolean h(Object obj, d dVar) {
        if (obj instanceof InputStream) {
            if (QLog.isColorLevel()) {
                QLog.d("PicCompress_SafeBitmapFactory", 2, "\u6e90\u6570\u636e\u662fInputStream\uff0c\u4e0d\u4f7f\u7528\u533a\u57df\u89e3\u7801");
            }
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        f355748a.c(obj, options);
        dVar.k(options.outWidth);
        dVar.j(options.outHeight);
        if (options.outWidth * options.outHeight < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            if (QLog.isColorLevel()) {
                QLog.d("PicCompress_SafeBitmapFactory", 2, "\u56fe\u7247\u592a\u5c0f\uff0c\u5c0f\u4e8e\u95ea\u9000\u68c0\u6d4b\u9608\u503c\uff0c\u4e0d\u7528\u533a\u57df\u89e3\u7801");
            }
            return false;
        }
        if (com.tencent.qqnt.util.bitmap.a.f362978a.a(obj)) {
            return false;
        }
        return b(obj, options, dVar);
    }

    private final Bitmap i(final Object dataSource, d safeDecodeOption) {
        BitmapFactory.Options options;
        int i3;
        Bitmap k3;
        BitmapFactory.Options b16 = safeDecodeOption.b();
        if (b16 == null) {
            options = new BitmapFactory.Options();
        } else {
            options = b16;
        }
        if (safeDecodeOption.a() && (k3 = k(dataSource, b16)) != null) {
            return k3;
        }
        if (dataSource instanceof String) {
            int i16 = a.INSTANCE.a(flashbackRegionPath).i((String) dataSource);
            if (i16 != 0) {
                if (i16 == 1) {
                    safeDecodeOption.f(1);
                    if (QLog.isColorLevel()) {
                        QLog.d("PicCompress_SafeBitmapFactory", 2, "\u95ea\u9000\u7f13\u5b58\u4e2d\u5b58\u5728\u8be5\u6570\u636e\uff0c\u8bf4\u660e\u4e4b\u524d\u7528\u533a\u57df\u89e3\u7801\u5d29\u6e83\u8fc7\u3002\u964d\u4f4e\u7ebf\u7a0b\u6570");
                    }
                }
            } else {
                safeDecodeOption.f(0);
            }
        }
        if (QLog.isColorLevel()) {
            Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            long j3 = 1024;
            QLog.d("PicCompress_SafeBitmapFactory", 4, "\u5f53\u524d\u7cfb\u7edf\u5269\u4f59\u5185\u5b58\u3002availMem\uff1a" + ((memoryInfo.availMem / j3) / j3) + "MB");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        c(dataSource, options2);
        options2.inJustDecodeBounds = false;
        int i17 = options2.outWidth;
        int i18 = (i17 / 400) + 1;
        int i19 = options2.outHeight;
        int i26 = (i19 / 400) + 1;
        int i27 = options.inSampleSize;
        if (i27 > 0) {
            i17 /= i27;
        }
        if (i27 > 0) {
            i19 /= i27;
        }
        final int i28 = i17 / i18;
        final int i29 = i19 / i26;
        if (QLog.isColorLevel()) {
            QLog.d("PicCompress_SafeBitmapFactory", 2, "\u533a\u57df\u89e3\u7801\u539f\u56fe \u5bbd\uff1a" + options2.outWidth + ", \u9ad8: " + options2.outHeight + " inSampleSize\uff1a" + options.inSampleSize);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i17, i19, options.inPreferredConfig);
        final CountDownLatch countDownLatch = new CountDownLatch(i26 * i18);
        boolean z16 = true;
        if (safeDecodeOption.d() == 1) {
            i3 = 4;
        } else {
            i3 = 7;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicCompress_SafeBitmapFactory", 2, "threadCount\uff1a" + i3);
        }
        Semaphore semaphore = new Semaphore(i3);
        Canvas canvas = new Canvas(createBitmap);
        int i36 = 0;
        while (i36 < i26) {
            int i37 = 0;
            while (i37 < i18) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                final int i38 = i37;
                final BitmapFactory.Options options3 = options;
                final int i39 = i36;
                final Canvas canvas2 = canvas;
                Semaphore semaphore2 = semaphore;
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqnt.compress.pic.impl.safeDecode.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.j(options3, i38, i28, i39, i29, dataSource, canvas2, countDownLatch);
                    }
                });
                semaphore2.release();
                i37 = i38 + 1;
                z16 = z16;
                i36 = i39;
                canvas = canvas2;
                semaphore = semaphore2;
                i26 = i26;
                i18 = i18;
            }
            i36++;
        }
        boolean z17 = z16;
        try {
            countDownLatch.await(20L, TimeUnit.SECONDS);
        } catch (InterruptedException e17) {
            e17.printStackTrace();
        }
        if (safeDecodeOption.a()) {
            Intrinsics.checkNotNull(b16);
            l(dataSource, createBitmap, b16);
        }
        if (b16 != null) {
            b16.inJustDecodeBounds = z17;
            c(dataSource, b16);
            b16.inJustDecodeBounds = false;
        }
        if (safeDecodeOption.d() == 0) {
            a a16 = a.INSTANCE.a(flashbackRegionPath);
            Intrinsics.checkNotNull(dataSource, "null cannot be cast to non-null type kotlin.String");
            a16.h((String) dataSource);
        }
        return createBitmap;
    }

    public static final void j(BitmapFactory.Options fopts, int i3, int i16, int i17, int i18, Object dataSource, Canvas canvas, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(fopts, "$fopts");
        Intrinsics.checkNotNullParameter(dataSource, "$dataSource");
        Intrinsics.checkNotNullParameter(canvas, "$canvas");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        try {
            try {
                int i19 = fopts.inSampleSize;
                if (i19 <= 0) {
                    i19 = 1;
                }
                int i26 = i3 * i16;
                int i27 = i17 * i18;
                Rect rect = new Rect(i26 * i19, i27 * i19, (i3 + 1) * i16 * i19, (i17 + 1) * i18 * i19);
                BitmapRegionDecoder g16 = f355748a.g(dataSource, true);
                Intrinsics.checkNotNull(g16);
                Bitmap decodeRegion = g16.decodeRegion(rect, fopts);
                synchronized (canvas) {
                    canvas.drawBitmap(decodeRegion, i26, i27, (Paint) null);
                    Unit unit = Unit.INSTANCE;
                }
                decodeRegion.recycle();
                g16.recycle();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    private final Bitmap k(Object dataSource, BitmapFactory.Options options) {
        Integer num;
        String b16 = com.tencent.qqnt.util.string.a.f362984a.b(com.tencent.qqnt.util.string.b.f362987a.e(dataSource));
        if (options != null) {
            num = Integer.valueOf(options.inSampleSize);
        } else {
            num = null;
        }
        String str = b16 + "_" + num;
        String str2 = rootPath + File.separator + str;
        File file = new File(str2);
        if (QLog.isColorLevel()) {
            QLog.d("PicCompress_SafeBitmapFactory", 2, "\u7f13\u5b58PATH:" + str2);
        }
        if (!file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(str2);
    }

    private final void l(Object dataSource, Bitmap r46, BitmapFactory.Options options) {
        String str = com.tencent.qqnt.util.string.a.f362984a.b(com.tencent.qqnt.util.string.b.f362987a.e(dataSource)) + "_" + options.inSampleSize;
        String str2 = rootPath + File.separator + str;
        try {
            File file = new File(rootPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            Intrinsics.checkNotNull(r46);
            r46.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    @Nullable
    public final Bitmap d(@NotNull Object dataSource, @Nullable BitmapFactory.Options opts, boolean isNeedCache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, dataSource, opts, Boolean.valueOf(isNeedCache));
        }
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        d dVar = new d();
        dVar.h(opts);
        dVar.g(isNeedCache);
        return e(dataSource, dVar);
    }
}

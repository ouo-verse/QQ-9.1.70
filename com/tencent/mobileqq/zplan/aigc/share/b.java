package com.tencent.mobileqq.zplan.aigc.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.tencent.av.zplan.avatar.utils.ThreadUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J&\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/b;", "", "", tl.h.F, "", "d", "", "url", WadlProxyConsts.PARAM_FILENAME, "cacheDirName", "Lcom/tencent/mobileqq/zplan/aigc/share/d;", "callback", "e", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "tmpFileName", "c", "g", "", "backgroundColor", "", "cornerRadius", "scale", "b", "", "timestamp", "l", "Z", "isBimapAllCached", "()Z", "i", "(Z)V", "isBitmapWithoutQRCached", "k", "isBitmapWithoutQRAndQHeadCached", "j", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f330597a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isBimapAllCached;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isBitmapWithoutQRCached;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isBitmapWithoutQRAndQHeadCached;

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String fileName, String cacheDirName, d callback, String url) {
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(fileName, "$fileName");
        Intrinsics.checkNotNullParameter(cacheDirName, "$cacheDirName");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(url, "$url");
        b bVar = f330597a;
        Bitmap g16 = bVar.g(fileName, cacheDirName);
        if (g16 != null) {
            callback.onSuccess(g16);
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openStream = new URL(url).openStream();
                Bitmap decodeStream = BitmapFactory.decodeStream(openStream);
                if (decodeStream != null) {
                    callback.onSuccess(decodeStream);
                    bVar.c(decodeStream, fileName, cacheDirName);
                    if (openStream != null) {
                        try {
                            openStream.close();
                            return;
                        } catch (IOException e16) {
                            QLog.e("AIGCShareHelper", 1, "download image finally, error = " + e16);
                            return;
                        }
                    }
                    return;
                }
                callback.onFailure("download image failed, url = " + url);
                if (openStream != null) {
                    try {
                        openStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        sb5 = new StringBuilder();
                        sb5.append("download image finally, error = ");
                        sb5.append(e);
                        QLog.e("AIGCShareHelper", 1, sb5.toString());
                    }
                }
            } catch (IOException e18) {
                QLog.e("AIGCShareHelper", 1, "download image failed, url = " + url);
                callback.onFailure("download image failed, url = " + url + ", msg: " + e18.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e19) {
                        e = e19;
                        sb5 = new StringBuilder();
                        sb5.append("download image finally, error = ");
                        sb5.append(e);
                        QLog.e("AIGCShareHelper", 1, sb5.toString());
                    }
                }
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e26) {
                    QLog.e("AIGCShareHelper", 1, "download image finally, error = " + e26);
                }
            }
            throw th5;
        }
    }

    public final Bitmap b(Bitmap bitmap, int backgroundColor, float cornerRadius, float scale) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = (int) (bitmap.getWidth() * scale);
        int height = (int) (bitmap.getHeight() * scale);
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(1);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(bitmap, (output.getWidth() - bitmap.getWidth()) / 2.0f, (output.getHeight() - bitmap.getHeight()) / 2.0f, paint);
        Intrinsics.checkNotNullExpressionValue(output, "output");
        return output;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Bitmap bitmap, String tmpFileName, String cacheDirName) {
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(tmpFileName, "tmpFileName");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, cacheDirName).getAbsolutePath()));
        BufferedOutputStream bufferedOutputStream2 = null;
        if (!file.exists() && !file.mkdirs()) {
            QLog.e("AIGCShareHelper", 1, "mkdir failed " + file.getAbsolutePath());
            return null;
        }
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), tmpFileName);
            if (file2.exists()) {
                file2.delete();
            }
            String absolutePath = file2.getAbsolutePath();
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e17) {
                        QLog.d("AIGCShareHelper", 2, e17.getMessage());
                    }
                    return absolutePath;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            QLog.d("AIGCShareHelper", 2, e18.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.d("AIGCShareHelper", 2, e.getMessage());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e26) {
                        QLog.d("AIGCShareHelper", 2, e26.getMessage());
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final boolean d() {
        QLog.i("AIGCShareHelper", 1, "share bitmap cache status, isBimapAllCached: " + isBimapAllCached + " , isBitmapWithoutQRCached: " + isBitmapWithoutQRCached + " , isBitmapWithoutQRAndQHeadCached: " + isBitmapWithoutQRAndQHeadCached);
        return isBimapAllCached && isBitmapWithoutQRCached && isBitmapWithoutQRAndQHeadCached;
    }

    public final void e(final String url, final String fileName, final String cacheDirName, final d callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(fileName, cacheDirName, callback, url);
            }
        });
    }

    public final Bitmap g(String fileName, String cacheDirName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, cacheDirName).getAbsolutePath()));
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        File file2 = new File(file.getAbsolutePath(), fileName);
        if (file2.exists()) {
            return BitmapFactory.decodeFile(file2.getAbsolutePath());
        }
        return null;
    }

    public final void i(boolean z16) {
        isBimapAllCached = z16;
    }

    public final void j(boolean z16) {
        isBitmapWithoutQRAndQHeadCached = z16;
    }

    public final void k(boolean z16) {
        isBitmapWithoutQRCached = z16;
    }

    public final String l(long timestamp) {
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date(timestamp * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "format.format(date)");
        return format;
    }

    public final void h() {
        isBimapAllCached = false;
        isBitmapWithoutQRCached = false;
        isBitmapWithoutQRAndQHeadCached = false;
    }
}

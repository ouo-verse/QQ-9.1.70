package com.tencent.mobileqq.zplan.meme.api.impl;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPGifDecoder;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/api/impl/e;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "limitAlpha", "", "b", "", "sharpPPath", "gifPath", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f333985a = new e();

    e() {
    }

    private final void b(Bitmap bitmap, int limitAlpha) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        IntBuffer allocate = IntBuffer.allocate(width);
        bitmap.copyPixelsToBuffer(allocate);
        for (int i3 = 0; i3 < width; i3++) {
            if (Color.alpha(allocate.get(i3)) <= limitAlpha) {
                allocate.put(i3, -1);
            }
        }
        allocate.rewind();
        bitmap.copyPixelsFromBuffer(allocate);
    }

    public final boolean a(String sharpPPath, String gifPath) {
        Intrinsics.checkNotNullParameter(sharpPPath, "sharpPPath");
        Intrinsics.checkNotNullParameter(gifPath, "gifPath");
        QLog.i("MemeGifConvertor", 1, "convertSharpP2Gif " + sharpPPath + " to " + gifPath);
        File file = new File(sharpPPath);
        boolean z16 = false;
        if (file.exists() && file.length() > 0) {
            FileUtils.createFileIfNotExits(gifPath);
            long currentTimeMillis = System.currentTimeMillis();
            SharpPGifDecoder sharpPGifDecoder = new SharpPGifDecoder(sharpPPath);
            GifCoder gifCoder = new GifCoder();
            gifCoder.setUseOrignalBitmap(true);
            gifCoder.setEncoderDither(true);
            Bitmap bitmap = null;
            try {
                int frameCount = sharpPGifDecoder.getFrameCount();
                Bitmap createBitmap = Bitmap.createBitmap(sharpPGifDecoder.getDstWidth(), sharpPGifDecoder.getDstHeight(), Bitmap.Config.ARGB_8888);
                try {
                    createBitmap.eraseColor(0);
                    int P2 = ZPlanFeatureSwitch.f369852a.P2();
                    int i3 = 0;
                    while (i3 < frameCount) {
                        NewGifDecoder.GifFrame next = sharpPGifDecoder.next(createBitmap);
                        if ((next != null ? next.image : null) == null) {
                            QLog.w("MemeGifConvertor", 1, "convertSharpP2Gif frame " + i3 + " decode sharpP error");
                            gifCoder.closeEncoder();
                            sharpPGifDecoder.close();
                            if (!createBitmap.isRecycled()) {
                                createBitmap.recycle();
                            }
                            return z16;
                        }
                        Bitmap frameBmp = next.image;
                        long j3 = currentTimeMillis;
                        int max = Math.max(1, (int) next.delay);
                        Intrinsics.checkNotNullExpressionValue(frameBmp, "frameBmp");
                        try {
                            b(frameBmp, P2);
                            if (!gifCoder.encodeGif(frameBmp, gifPath, max)) {
                                QLog.w("MemeGifConvertor", 1, "convertSharpP2Gif frame " + i3 + " encode gif error");
                                gifCoder.closeEncoder();
                                sharpPGifDecoder.close();
                                if (createBitmap.isRecycled()) {
                                    return false;
                                }
                                createBitmap.recycle();
                                return false;
                            }
                            i3++;
                            currentTimeMillis = j3;
                            z16 = false;
                        } catch (Throwable th5) {
                            th = th5;
                            bitmap = createBitmap;
                            try {
                                QLog.w("MemeGifConvertor", 1, "convertSharpP2Gif fail", th);
                                return false;
                            } finally {
                                gifCoder.closeEncoder();
                                sharpPGifDecoder.close();
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                            }
                        }
                    }
                    QLog.i("MemeGifConvertor", 2, "convertSharpP2Gif success cost " + (System.currentTimeMillis() - currentTimeMillis));
                    gifCoder.closeEncoder();
                    sharpPGifDecoder.close();
                    if (!createBitmap.isRecycled()) {
                        createBitmap.recycle();
                    }
                    return true;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } else {
            QLog.w("MemeGifConvertor", 1, "convertSharpP2Gif input file is not exist");
            return false;
        }
    }
}

package com.tencent.aelight.camera.ae.flashshow.autotest;

import android.graphics.Bitmap;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/autotest/c;", "", "", "renderId", "width", "height", "", "filePath", "", "b", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "path", CustomImageProps.QUALITY, "Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64158a = new c();

    c() {
    }

    public final void b(int renderId, int width, int height, String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Bitmap saveTexture = RendererUtils.saveTexture(renderId, width, height);
        if (saveTexture == null) {
            QLog.e("LSCameraTestUtil", 4, "saveTextureID2File|failed!bitmap is null ,path:" + filePath);
            return;
        }
        a(saveTexture, filePath, 100);
        saveTexture.recycle();
        QLog.i("LSCameraTestUtil", 4, "saveTextureID2File|successful!path:" + filePath);
    }

    public final BitmapUtils.SAVE_STATUS a(Bitmap bitmap, String path, int quality) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(path);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(path);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        BitmapUtils.SAVE_STATUS save_status = BitmapUtils.SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Intrinsics.checkNotNull(bitmap);
                        String format = String.format("OutOfMemoryError! saveBitmap. path = %s, width = %d, height = %d.", Arrays.copyOf(new Object[]{path, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())}, 3));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        ReportUtil.report(format);
                        BitmapUtils.SAVE_STATUS save_status2 = BitmapUtils.SAVE_STATUS.SAVE_OOM;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                BitmapUtils.SAVE_STATUS save_status3 = BitmapUtils.SAVE_STATUS.SAVE_SUCCESS;
                IOUtils.closeQuietly(fileOutputStream2);
                return save_status3;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}

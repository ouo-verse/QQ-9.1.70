package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.pic.compress.g;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(b bVar) {
        super(r0);
        String str;
        if (bVar == null) {
            str = null;
        } else {
            str = bVar.f184463c;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }

    boolean c(String str) {
        boolean z16;
        Bitmap safeDecode;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int exifOrientation = BaseImageUtil.getExifOrientation(this.f184463c);
        String str2 = "generate " + this.f184461a;
        int i3 = 1;
        while (true) {
            if (i3 <= 4) {
                try {
                    options.inSampleSize = i3;
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f184461a, 2, str2 + ",localPath:" + this.f184463c + " sample:" + i3 + " path:" + str + " degree:" + exifOrientation);
                    }
                    safeDecode = SafeBitmapFactory.safeDecode(this.f184463c, options);
                    if (exifOrientation != 0 && safeDecode != null) {
                        Matrix matrix = new Matrix();
                        int width = safeDecode.getWidth();
                        int height = safeDecode.getHeight();
                        matrix.postRotate(exifOrientation, width >> 1, height >> 1);
                        safeDecode = Bitmap.createBitmap(safeDecode, 0, 0, width, height, matrix, true);
                    }
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f184461a, 2, str2 + ",oom localPath:" + this.f184463c + " sample:" + i3 + " degree:" + exifOrientation);
                    }
                    e16.printStackTrace();
                    System.gc();
                }
                if (g.i(str, safeDecode, 80, "incompatible to jpg", null)) {
                    z16 = true;
                    break;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(this.f184461a, 2, str2 + ",compressQuality fail");
                }
                i3 *= 2;
            } else {
                z16 = false;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f184461a, 2, str2 + ",result:" + z16 + " sample:" + i3 + " path:" + str + " degree:" + exifOrientation);
        }
        return z16;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String t16 = g.t(this.f184463c, 2);
        if (!new File(t16).exists()) {
            boolean c16 = c(t16);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.f184462b, c16, 0L, FileUtils.getFileSizes(t16), null, "");
            if (c16) {
                if (QLog.isColorLevel()) {
                    f.b("PIC_TAG_ERROR", "check file type,generateCompatibleFile suc", "outputPath" + t16 + " originFile" + this.f184463c + " fileType:" + this.f184461a);
                }
                return t16;
            }
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_ERROR", "check file type,generateCompatibleFile fail", " originFile" + this.f184463c + " fileType:" + this.f184461a);
                return null;
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_ERROR", "check file type,compatibleFile exists", "outputPath" + t16 + " originFile" + this.f184463c + " fileType:" + this.f184461a);
        }
        return t16;
    }
}

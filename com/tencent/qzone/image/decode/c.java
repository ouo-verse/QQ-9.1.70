package com.tencent.qzone.image.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageOptionSampleSize;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f364012a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f364012a = new ConcurrentHashMap<>();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private BitmapReference c(IDecoder iDecoder, FileInputStream fileInputStream, BitmapFactory.Options options) {
        if (fileInputStream == null) {
            ImageManagerLog.e("QzoneImageDecodeManager_Normal", "decode fail: inputStream is null");
            return null;
        }
        if (iDecoder != null) {
            return iDecoder.decodeImage(fileInputStream, options);
        }
        ImageManagerLog.e("QzoneImageDecodeManager_Normal", "decode fail: decoder is null");
        return null;
    }

    @Override // com.tencent.qzone.image.decode.a
    public boolean a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
        }
        if (file != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qzone.image.decode.a
    public Bitmap b(File file, String str, int i3, int i16) {
        int intValue;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, file, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.Options options = BitmapUtils.getOptions();
                int hashCode = file.getAbsolutePath().hashCode();
                Integer num = f364012a.get(Integer.valueOf(hashCode));
                if (num == null) {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    intValue = ImageOptionSampleSize.computeSampleSize(i3, i16, options.outWidth, options.outHeight);
                    f364012a.put(Integer.valueOf(hashCode), Integer.valueOf(intValue));
                } else {
                    intValue = num.intValue();
                }
                ImageManagerLog.w("QzoneImageDecodeManager_Normal", "decode: sampleSize is " + intValue);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.outWidth = i3;
                options.outHeight = i16;
                options.inSampleSize = intValue;
                BitmapReference c16 = c(ImageManager.getInstance().getDecoder(), fileInputStream, options);
                if (c16 != null) {
                    bitmap = c16.getBitmap();
                } else {
                    bitmap = null;
                }
                fileInputStream.close();
                return bitmap;
            } finally {
            }
        } catch (Throwable th5) {
            ImageManagerLog.fatal("QzoneImageDecodeManager_Normal", th5);
            return null;
        }
    }
}

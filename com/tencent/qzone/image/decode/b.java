package com.tencent.qzone.image.decode;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qzone.image.decode.a
    public boolean a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
        }
        return com.tencent.qzone.avif.a.a(file);
    }

    @Override // com.tencent.qzone.image.decode.a
    public Bitmap b(File file, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, file, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        byte[] readFile = ImageManagerEnv.g().readFile(file.getAbsolutePath());
        if (readFile != null && readFile.length != 0) {
            AvifDecoder c16 = AvifDecoder.c(readFile);
            if (c16 == null) {
                ImageManagerLog.e("QzoneImageDecodeManager_Avif", "decode fail: decoder is null");
                return null;
            }
            if (!c16.j()) {
                ImageManagerLog.e("QzoneImageDecodeManager_Avif", "decode fail: no next image");
                c16.b();
                return null;
            }
            AvifImage g16 = c16.g();
            Bitmap createBitmap = Bitmap.createBitmap(g16.b(), g16.a(), Bitmap.Config.ARGB_8888);
            c16.f(createBitmap);
            c16.b();
            return createBitmap;
        }
        ImageManagerLog.e("QzoneImageDecodeManager_Avif", "decode fail: fileContent is empty");
        return null;
    }
}

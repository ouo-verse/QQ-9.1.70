package com.tencent.qzone.image.decode;

import android.graphics.Bitmap;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements a {
    static IPatchRedirector $redirector_;

    public d() {
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
        return SharpPUtils.isSharpP(file);
    }

    @Override // com.tencent.qzone.image.decode.a
    public Bitmap b(File file, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, file, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(file.getAbsolutePath());
        if (sharpPDecoderHelper.parseHeader() != 0) {
            ImageManagerLog.e("QzoneImageDecodeManager_Sharpp", "decode fail: status is not ok");
            return null;
        }
        if (SharpPUtils.isJpg(sharpPDecoderHelper.getMimeType())) {
            ImageManagerLog.w("QzoneImageDecodeManager_Sharpp", "decode sharp to jpg");
            return sharpPDecoderHelper.decodeSharpP2JPG(i3, i16, Bitmap.Config.ARGB_8888);
        }
        ImageManagerLog.w("QzoneImageDecodeManager_Sharpp", "decode sharp to png");
        return sharpPDecoderHelper.decodeSharpP2PNG(i3, i16, Bitmap.Config.ARGB_8888);
    }
}

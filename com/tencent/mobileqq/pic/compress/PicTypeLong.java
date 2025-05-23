package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PicTypeLong extends d {
    static IPatchRedirector $redirector_;

    PicTypeLong(CompressInfo compressInfo) {
        super(compressInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) compressInfo);
        }
    }

    @Override // com.tencent.mobileqq.pic.compress.d
    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f258690l != 1) {
            return false;
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.T && g.x(compressInfo.D)) {
            CompressInfo compressInfo2 = this.f258689k;
            compressInfo2.H = compressInfo2.D;
            compressInfo2.P = this.f258688j + this.f258689k.f258514d + HardCodeUtil.qqStr(R.string.p7c);
            com.tencent.mobileqq.pic.f.b(this.f258688j, this.f258689k.f258514d + " compress()", HardCodeUtil.qqStr(R.string.p7d));
            return true;
        }
        CompressInfo compressInfo3 = this.f258689k;
        compressInfo3.H = g.t(compressInfo3.D, compressInfo3.L);
        if (TextUtils.isEmpty(this.f258689k.H)) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " destPath is empty");
            return false;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.f258689k.H)) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " destPath exist. return true");
            return true;
        }
        try {
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(this.f258689k.D, null);
            if (decodeFileWithBufferedStream == null) {
                com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " bm == null, maybe is broken");
                return false;
            }
            String str = this.f258689k.H;
            int f16 = f();
            CompressInfo compressInfo4 = this.f258689k;
            boolean i3 = g.i(str, decodeFileWithBufferedStream, f16, compressInfo4.f258514d, compressInfo4);
            if (!JpegExifReader.isCrashJpeg(this.f258689k.D)) {
                try {
                    if (!BaseImageUtil.saveExif(new ExifInterface(this.f258689k.D), new ExifInterface(this.f258689k.H), true)) {
                        com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", "Failed to save exif");
                    }
                } catch (IOException e16) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", "cannot read exif, " + e16.getMessage());
                }
            }
            decodeFileWithBufferedStream.recycle();
            return i3;
        } catch (OutOfMemoryError unused) {
            this.f258689k.b(true);
            com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " decodeFile oom, execute commonCompress()");
            this.f258689k.H = "";
            return c();
        }
    }

    @Override // com.tencent.mobileqq.pic.compress.d
    protected int e(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) compressInfo)).intValue();
        }
        int i3 = compressInfo.L;
        if (i3 == 0 || i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        return -1;
    }
}

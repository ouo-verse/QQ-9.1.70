package com.tencent.mobileqq.pic.compress;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PicTypeNormal extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static final int f258667n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        Resources resources = BaseApplication.getContext().getResources();
        int i3 = resources.getDisplayMetrics().heightPixels;
        int i16 = resources.getDisplayMetrics().widthPixels;
        if (i3 <= i16) {
            i3 = i16;
        }
        f258667n = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PicTypeNormal(CompressInfo compressInfo) {
        super(compressInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) compressInfo);
        }
    }

    @Override // com.tencent.mobileqq.pic.compress.d
    protected boolean d() {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z17 = false;
        if (this.f258690l != 0) {
            return false;
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.T && g.x(compressInfo.D)) {
            CompressInfo compressInfo2 = this.f258689k;
            compressInfo2.H = compressInfo2.D;
            compressInfo2.P = this.f258688j + this.f258689k.f258514d + HardCodeUtil.qqStr(R.string.p7f);
            com.tencent.mobileqq.pic.f.b(this.f258688j, this.f258689k.f258514d + " compress()", HardCodeUtil.qqStr(R.string.p7e));
            return true;
        }
        int[] i16 = i();
        if (i16 == null) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " largerSide is null");
            return false;
        }
        int i17 = i16[0];
        int i18 = i16[1];
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
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (!g.a(options, this.f258689k.D, i18, i17)) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " calculateInSampleSize fail");
            return false;
        }
        try {
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(this.f258689k.D, options);
            if (decodeFileWithBufferedStream == null) {
                com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " bm == null, maybe is broken");
                return false;
            }
            int width = decodeFileWithBufferedStream.getWidth();
            int height = decodeFileWithBufferedStream.getHeight();
            Matrix matrix = new Matrix();
            if (width > height) {
                i3 = width;
            } else {
                i3 = height;
            }
            float f16 = 1.0f;
            if (i3 > i17) {
                f16 = i17 / (i3 * 1.0f);
                z16 = true;
            } else {
                z16 = false;
            }
            int rotateDegree = LibraImageUtil.getRotateDegree(Option.obtain().setLocalPath(this.f258689k.D));
            if (this.f258689k.C && rotateDegree != 0 && rotateDegree % 90 == 0) {
                matrix.postRotate(rotateDegree, width >> 1, height >> 1);
                z17 = true;
            }
            if (z16) {
                matrix.postScale(f16, f16);
            }
            if (z17 || z16) {
                try {
                    decodeFileWithBufferedStream = Bitmap.createBitmap(decodeFileWithBufferedStream, 0, 0, width, height, matrix, true);
                } catch (NullPointerException unused) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " scale or rotate createBitmap NullPointerException");
                } catch (OutOfMemoryError unused2) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", this.f258689k.f258514d + " scale or rotate createBitmap OutOfMemoryError");
                }
            }
            String str = this.f258689k.H;
            int f17 = f();
            CompressInfo compressInfo4 = this.f258689k;
            boolean i19 = g.i(str, decodeFileWithBufferedStream, f17, compressInfo4.f258514d, compressInfo4);
            if (!JpegExifReader.isCrashJpeg(this.f258689k.D)) {
                try {
                    if (!BaseImageUtil.saveExif(new ExifInterface(this.f258689k.D), new ExifInterface(this.f258689k.H), true)) {
                        com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", "Failed to save exif");
                    }
                } catch (Throwable th5) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", "cannot read exif, " + th5.getMessage());
                }
            } else {
                com.tencent.mobileqq.pic.f.d(this.f258688j, "compress()", "crash jpeg, skip saveExif");
            }
            if (decodeFileWithBufferedStream != null) {
                decodeFileWithBufferedStream.recycle();
            }
            return i19;
        } catch (OutOfMemoryError e16) {
            this.f258689k.b(true);
            e16.printStackTrace();
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
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                return 2;
            }
            return -1;
        }
        return 0;
    }

    protected int[] i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.L == 2) {
            return null;
        }
        int i3 = compressInfo.V;
        if (i3 > 0) {
            return new int[]{i3, i3 * 2};
        }
        int[] iArr = new int[2];
        int i16 = a.f258671d;
        int i17 = f258667n;
        if (i16 > i17) {
            i16 = i17;
        }
        iArr[0] = i16;
        iArr[1] = i16 * 2;
        com.tencent.mobileqq.pic.f.b("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + iArr[0]);
        return iArr;
    }
}

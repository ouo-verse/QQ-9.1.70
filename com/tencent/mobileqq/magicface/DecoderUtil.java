package com.tencent.mobileqq.magicface;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DecoderUtil {
    static IPatchRedirector $redirector_;
    public static boolean IS_LOAD_SUCESS;
    private static String nativeLibraryPath;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f243271a;

        a(CountDownLatch countDownLatch) {
            this.f243271a = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DecoderUtil.this, (Object) countDownLatch);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            try {
                if (loadExtResult != null) {
                    try {
                    } catch (Exception e16) {
                        QLog.e("DecoderUtil", 1, e16, new Object[0]);
                    }
                    if (loadExtResult.isSucc()) {
                        String soLoadPath = loadExtResult.getSoLoadPath(SoLoadConstants.SONAME_AV_OLD_AVC_DEC);
                        if (!TextUtils.isEmpty(soLoadPath)) {
                            DecoderUtil.nativeLibraryPath = soLoadPath;
                        }
                        this.f243271a.countDown();
                        return;
                    }
                }
                QLog.w("DecoderUtil", 2, "load error");
                this.f243271a.countDown();
            } catch (Throwable th5) {
                this.f243271a.countDown();
                throw th5;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        IS_LOAD_SUCESS = false;
        try {
            System.loadLibrary("magicfaceDec");
            IS_LOAD_SUCESS = true;
        } catch (UnsatisfiedLinkError unused) {
            IS_LOAD_SUCESS = false;
            if (QLog.isColorLevel()) {
                QLog.e("DecoderUtil", 2, "Fail to load libmagicfaceDec.so.");
            }
        }
        nativeLibraryPath = "";
    }

    public DecoderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (new File(nativeLibraryPath).exists()) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).load(SoLoadConstants.SONAME_AV_OLD_AVC_DEC, new a(countDownLatch));
        try {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
            if (QLog.isColorLevel()) {
                QLog.i("DecoderUtil", 2, "nativeLibraryDir[" + nativeLibraryPath + "]");
            }
        } catch (InterruptedException e16) {
            QLog.e("DecoderUtil", 1, e16, new Object[0]);
        }
    }

    public int createAlphaDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (TextUtils.isEmpty(nativeLibraryPath)) {
            return createAlphaDecoder("none");
        }
        return createAlphaDecoder(nativeLibraryPath);
    }

    public native int createAlphaDecoder(String str);

    public int createVideoDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (TextUtils.isEmpty(nativeLibraryPath)) {
            return createVideoDecoder("none");
        }
        return createVideoDecoder(nativeLibraryPath);
    }

    public native int createVideoDecoder(String str);

    public native int decodeAlphaDecoder(byte[] bArr, int i3, byte[] bArr2);

    public native int decodeAlphaDecoderReturnYUV(byte[] bArr, int i3, byte[] bArr2);

    public native int decodeVideoDecoder(byte[] bArr, int i3, byte[] bArr2);

    public native int decodeVideoDecoderReturnYUV(byte[] bArr, int i3, byte[] bArr2);

    public native int getHeightAlphaDecoder();

    public native int getHeightVideoDecoder();

    public native int getWidthAlphaDecoder();

    public native int getWidthVideoDecoder();

    public native int releaseAlphaDecoder();

    public native int releaseVideoDecoder();

    public void testfunc1(byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, bArr, Long.valueOf(j3));
        }
    }

    public void testfunc2(byte b16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Byte.valueOf(b16), Long.valueOf(j3));
        }
    }

    public void testfunc3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void testfunc4(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        }
    }
}

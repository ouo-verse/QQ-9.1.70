package com.tencent.mobileqq.qrscan.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime) {
        if (!((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isRingerVibrate(appRuntime) && !((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isRingerSilent(appRuntime) && !((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isRingEqualsZero(appRuntime)) {
            AudioUtil.n(R.raw.f169446aa, false);
        }
    }

    public static String b(String str) {
        System.currentTimeMillis();
        try {
            return HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return "";
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            try {
                String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                if (d16 == null) {
                    return "";
                }
                return d16;
            } catch (IOException unused2) {
                return "";
            }
        }
    }

    public static int c(BitmapFactory.Options options, int i3) {
        int i16 = options.outWidth;
        int i17 = 1;
        if (i16 > i3) {
            while ((i16 / 2) / i17 > i3) {
                i17 *= 2;
            }
        }
        return i17;
    }

    public static Bitmap d(byte[] bArr, int i3, int i16) {
        Bitmap bitmap;
        try {
            bitmap = new YuvProxy.NV21ToBitmap(BaseApplication.getContext()).nv21ToBitmap(bArr, i3, i16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "getBitmapFromYuv error ", th5);
            bitmap = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "getBitmapFromYuv bitmap:" + bitmap);
        }
        return bitmap;
    }

    public static Bitmap e(String str, int i3, int i16) {
        int c16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            o.decodeFileWithBuffer(str, options);
            if (i3 <= 0 && i16 <= 0) {
                c16 = 1;
            } else {
                c16 = c(options, i3);
            }
            options.inSampleSize = c16;
            options.inJustDecodeBounds = false;
            return o.decodeFileWithBuffer(str, options);
        } catch (Exception e16) {
            QZLog.e("Util", 1, "getBitmapFromFile, exception", e16);
            return null;
        } catch (OutOfMemoryError unused) {
            QZLog.e("Util", 1, "getBitmapFromFile, OutOfMemoryError");
            return null;
        }
    }
}

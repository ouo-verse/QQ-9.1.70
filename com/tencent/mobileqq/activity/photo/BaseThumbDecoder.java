package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseThumbDecoder {
    static IPatchRedirector $redirector_;

    public BaseThumbDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean checkBitmapValid(LocalMediaInfo localMediaInfo, Bitmap bitmap, int i3) {
        if (i3 == 0 && bitmap.getWidth() == localMediaInfo.thumbWidth && bitmap.getHeight() == localMediaInfo.thumbWidth && bitmap.getConfig() == Bitmap.Config.RGB_565) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap realDecodeBitmap(LocalMediaInfo localMediaInfo, BitmapFactory.Options options, String str) {
        Bitmap bitmap = null;
        try {
            SafeBitmapFactory.SafeDecodeOption safeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
            safeDecodeOption.inOptions = options;
            safeDecodeOption.inNeedFlashBackTest = true;
            bitmap = SafeBitmapFactory.safeDecode(localMediaInfo.path, safeDecodeOption);
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "ThumbDecoder regionDecodeInfo:" + safeDecodeOption.toString());
            }
            if (!safeDecodeOption.isInJustDecodeBounds && safeDecodeOption.needRegionDecode) {
                HashMap<String, String> info = safeDecodeOption.getInfo();
                info.put("from", str);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "safeDecode", safeDecodeOption.isGetBitmap, safeDecodeOption.runTime, safeDecodeOption.rawHeight * safeDecodeOption.rawWidth, info, "");
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        return bitmap;
    }
}

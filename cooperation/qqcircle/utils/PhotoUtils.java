package cooperation.qqcircle.utils;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes28.dex */
public class PhotoUtils {
    private static final String TAG = "PhotoUtils";

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0037 -> B:14:0x004f). Please report as a decompilation issue!!! */
    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "create new bitmap file exception ", e16);
            }
        }
        boolean z17 = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    if (z16) {
                        bitmap.recycle();
                    }
                    bufferedOutputStream2.close();
                } catch (Exception e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e(TAG, 1, "saveBitmapToFile exception", e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
            return z17;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}

package com.tencent.luggage.scanner.camera;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.luggage.wxa.yp.b;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScanUtil {
    public static void copyFile(String str, String str2, boolean z16) {
        File file = new File(str2);
        File file2 = new File(str);
        if (file2.exists()) {
            if (!file.exists() || (file.exists() && z16)) {
                try {
                    file.delete();
                    FileUtils.copyFile(file2, file);
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static QbarNative.QbarAiModelParam getAiModeParam(Context context) {
        try {
            String str = context.getFilesDir().getAbsolutePath() + "/" + QBar.QBAR_AI_DATA_DIR;
            String str2 = str + "/detect_model.bin";
            String str3 = str + "/detect_model.param";
            String str4 = str + "/srnet.bin";
            String str5 = str + "/srnet.param";
            SharedPreferences sharedPreferences = context.getSharedPreferences(QBar.QBAR_AI_PREFERENCE, 0);
            int i3 = sharedPreferences.getInt(QBar.QBAR_AI_MODEL_VERSION, 0);
            int i16 = sharedPreferences.getInt(QBar.QBAR_AI_MODEL_COPY_VERSION, 0);
            b.c("ScanUtil", String.format("version %d, copyVersion %d", Integer.valueOf(i3), Integer.valueOf(i16)));
            if (i3 != 103 || i3 != i16) {
                copyFile(context.getResources().getAssets().open("qbar/detect_model.bin"), str2, true);
                copyFile(context.getResources().getAssets().open("qbar/detect_model.param"), str3, true);
                copyFile(context.getResources().getAssets().open("qbar/srnet.bin"), str4, true);
                copyFile(context.getResources().getAssets().open("qbar/srnet.param"), str5, true);
                sharedPreferences.edit().putInt(QBar.QBAR_AI_MODEL_VERSION, 103).apply();
                sharedPreferences.edit().putInt(QBar.QBAR_AI_MODEL_COPY_VERSION, 103).commit();
            }
            QbarNative.QbarAiModelParam qbarAiModelParam = new QbarNative.QbarAiModelParam();
            qbarAiModelParam.detect_model_bin_path_ = str2;
            qbarAiModelParam.detect_model_param_path_ = str3;
            qbarAiModelParam.superresolution_model_bin_path_ = str4;
            qbarAiModelParam.superresolution_model_param_path_ = str5;
            return qbarAiModelParam;
        } catch (Exception e16) {
            b.b("ScanUtil", "copy qbar ai model file error! " + e16.getMessage());
            return null;
        }
    }

    public static boolean getBoolean(String str, boolean z16) {
        if (str != null) {
            try {
            } catch (NumberFormatException unused) {
                return z16;
            }
        }
        return Boolean.parseBoolean(str);
    }

    public static double getDouble(String str, double d16) {
        if (str != null) {
            try {
            } catch (NumberFormatException unused) {
                return d16;
            }
        }
        return Double.parseDouble(str);
    }

    public static float getFloat(String str, float f16) {
        if (str != null) {
            try {
            } catch (NumberFormatException unused) {
                return f16;
            }
        }
        return Float.parseFloat(str);
    }

    public static int getInt(String str, int i3) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.decode(str).intValue();
                }
                return i3;
            } catch (NumberFormatException unused) {
                return i3;
            }
        }
        return i3;
    }

    public static long getLong(String str, long j3) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Long.decode(str).longValue();
                }
                return j3;
            } catch (NumberFormatException unused) {
                return j3;
            }
        }
        return j3;
    }

    public static boolean isNullOrNil(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static void copyFile(InputStream inputStream, String str, boolean z16) {
        File file = new File(str);
        if (!file.exists() || (file.exists() && z16)) {
            try {
                file.delete();
                FileUtils.copyInputStreamToFile(inputStream, file);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }
}

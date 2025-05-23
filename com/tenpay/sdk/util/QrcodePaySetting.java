package com.tenpay.sdk.util;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.util.Utils;
import java.io.File;
import java.io.RandomAccessFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class QrcodePaySetting {
    private static final String TAG = "QrcodePaySetting";
    private static String mFilePath;
    private static JSONObject mObj;

    private static void checkDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
    }

    public static void checkPrepare() {
        if (mObj == null) {
            prepare(BaseApplication.context, com.tencent.mobileqq.base.a.c());
        }
    }

    public static void commit() {
        JSONObject jSONObject = mObj;
        if (jSONObject != null) {
            writeFile(mFilePath, jSONObject.toString());
        }
    }

    public static boolean getBoolean(String str, boolean z16) {
        JSONObject jSONObject = mObj;
        if (jSONObject != null && jSONObject.has(str)) {
            return mObj.optBoolean(str);
        }
        return z16;
    }

    private static String getCertPath(Context context) {
        return context.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
    }

    private static String getFilePath(Context context, String str) {
        return context.getFilesDir().getParentFile().getAbsolutePath() + "/cert/qrcode_pay_setting_" + str;
    }

    public static int getInt(String str, int i3) {
        JSONObject jSONObject = mObj;
        if (jSONObject != null && jSONObject.has(str)) {
            return mObj.optInt(str);
        }
        return i3;
    }

    public static String getString(String str, String str2) {
        JSONObject jSONObject = mObj;
        if (jSONObject != null && jSONObject.has(str)) {
            return mObj.optString(str);
        }
        return str2;
    }

    public static void prepare(Context context, String str) {
        QwLog.i("uin = " + str);
        checkDir(getCertPath(context));
        String filePath = getFilePath(context, str);
        mFilePath = filePath;
        String readFile = readFile(filePath);
        if (readFile != null) {
            try {
                mObj = new JSONObject(readFile);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        if (mObj == null) {
            mObj = new JSONObject();
        }
    }

    public static void putBoolean(String str, boolean z16) {
        try {
            mObj.put(str, z16);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static void putInt(String str, int i3) {
        try {
            mObj.put(str, i3);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static void putString(String str, String str2) {
        try {
            mObj.put(str, str2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private static String readFile(String str) {
        RandomAccessFile randomAccessFile;
        QwLog.i("readFile filePath=" + str);
        RandomAccessFile randomAccessFile2 = null;
        r0 = null;
        String str2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Exception unused) {
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            str2 = randomAccessFile.readUTF();
        } catch (Exception unused2) {
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile2 = randomAccessFile;
            Utils.closeObject(randomAccessFile2);
            throw th;
        }
        Utils.closeObject(randomAccessFile);
        return str2;
    }

    private static void writeFile(String str, String str2) {
        QwLog.i("writeFile filePath=" + str);
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rws");
            try {
                randomAccessFile2.writeUTF(str2);
                Utils.closeObject(randomAccessFile2);
            } catch (Exception unused) {
                randomAccessFile = randomAccessFile2;
                Utils.closeObject(randomAccessFile);
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = randomAccessFile2;
                Utils.closeObject(randomAccessFile);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th6) {
            th = th6;
        }
    }
}

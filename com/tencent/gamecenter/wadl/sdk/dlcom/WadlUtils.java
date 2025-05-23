package com.tencent.gamecenter.wadl.sdk.dlcom;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.app.WadlConstant;
import com.tencent.gamecenter.wadl.util.j;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.a;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.util.Pair;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlUtils {
    public static final String HEADER_ACCESS_TYPE = "X-Forwarded-Access-Type";
    public static final int ONE_DAY = 86400;
    public static final String TAG = "Wadl_WadlUtils";
    public static final int UNIT_MB = 1048576;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String calcMd5(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            long length = file.length();
            if (length > 0) {
                str2 = getFileMd5(file, 0L, length - 1);
                if (str2 != null) {
                    return "";
                }
                return str2;
            }
        }
        str2 = null;
        if (str2 != null) {
        }
    }

    public static int checkFileSign(String str, String str2, String str3) {
        QLog.d(TAG, 1, "checkFileSign apkId=" + str + ",apkFile=" + str2 + ",sign=" + str3);
        if (TextUtils.isEmpty(str3)) {
            return 0;
        }
        try {
            JSONObject parseSignToJson = parseSignToJson(str3);
            if (parseSignToJson == null) {
                return 50001;
            }
            File file = new File(str2);
            if (file.exists() && file.isFile() && file.length() > 0) {
                long length = file.length();
                QLog.d(TAG, 1, "checkFileSign signJson=" + parseSignToJson.toString() + ",apkSize=" + length);
                String optString = parseSignToJson.optString("appid");
                if (parseSignToJson.optInt(WadlConstant.SIGN_IS_WHITE) != 0) {
                    return 0;
                }
                long optLong = parseSignToJson.optLong("fileSize");
                JSONObject optJSONObject = parseSignToJson.optJSONObject("sign");
                if (optJSONObject != null && length == optLong && TextUtils.equals(str, optString)) {
                    if (checkMd5(optJSONObject, file, length)) {
                        return 0;
                    }
                    return 50005;
                }
                QLog.d(TAG, 1, "checkFileSign signAppId=" + optString + ",apkSize=" + length + ",signFileSize=" + optLong);
                return 50003;
            }
            QLog.d(TAG, 1, "checkFileSign apkFile=" + str2 + " not exists");
            return 50006;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "checkFileSign exception:" + e16.getMessage());
            return 50002;
        }
    }

    public static boolean checkMd5(JSONObject jSONObject, File file, long j3) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String[] split = str.split("-");
            String optString = jSONObject.optString(str);
            if (split.length == 2 && !TextUtils.isEmpty(optString)) {
                long parseLong = Long.parseLong(split[0]);
                long parseLong2 = Long.parseLong(split[1]);
                if (parseLong >= 0 && parseLong < parseLong2 && parseLong2 < j3) {
                    String fileMd5 = getFileMd5(file, parseLong, parseLong2);
                    QLog.d(TAG, 1, "checkFileSign start=" + parseLong + ",end=" + parseLong2 + ",serverMd5=" + optString + ",localMd5=" + fileMd5);
                    if (TextUtils.equals(optString, fileMd5)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static String decodeStr(String str, String str2, int i3) {
        byte[] d16;
        String str3 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] decode = Base64.decode(str, i3);
                if (decode != null && decode.length > 0 && (d16 = new j().d(decode, str2.getBytes())) != null) {
                    str3 = new String(d16);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "decodeStr exception:", e16);
            }
            QLog.d(TAG, 1, "decodeStr decodeStr=" + str3);
        }
        return str3;
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static boolean fileExists(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static Pair<Integer, Integer> getBatteryValue() {
        Intent registerReceiver = new ContextWrapper(MobileQQ.sMobileQQ.getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return new Pair<>(Integer.valueOf(registerReceiver.getIntExtra("level", -1)), Integer.valueOf(registerReceiver.getIntExtra("scale", -1)));
    }

    public static URLDrawable getDrawable(String str, int i3, int i16) {
        initURLDrawable();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        if (str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
            obtain.mPlayGifImage = true;
        } else if (str.endsWith(".apng")) {
            obtain.mUseApngImage = true;
        }
        return URLDrawable.getDrawable(str, obtain);
    }

    public static String getFileMd5(File file, long j3, long j16) {
        String str = "";
        BufferedInputStream bufferedInputStream = null;
        if (file != null && j3 >= 0) {
            try {
                if (j3 < j16) {
                    try {
                        if (j16 < file.length()) {
                            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                            try {
                                bufferedInputStream2.skip(j3);
                                int min = (int) Math.min((j16 + 1) - j3, 16384L);
                                byte[] bArr = new byte[min];
                                while (j3 <= j16) {
                                    if ((min + j3) - 1 > j16) {
                                        min = (int) ((j16 - j3) + 1);
                                    }
                                    bufferedInputStream2.read(bArr, 0, min);
                                    messageDigest.update(bArr, 0, min);
                                    j3 += min;
                                }
                                str = a.b(messageDigest.digest());
                                bufferedInputStream = bufferedInputStream2;
                            } catch (Exception e16) {
                                e = e16;
                                bufferedInputStream = bufferedInputStream2;
                                QLog.e(TAG, 1, "getFileMd5 exception:" + e.getMessage());
                                IOUtil.closeStream(bufferedInputStream);
                                return str;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = bufferedInputStream2;
                                IOUtil.closeStream(bufferedInputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        IOUtil.closeStream(bufferedInputStream);
        return str;
    }

    public static String getNetType() {
        int networkType = NetworkUtil.getNetworkType(MobileQQ.sMobileQQ);
        if (networkType != 1) {
            if (networkType != 6) {
                if (networkType != 3) {
                    if (networkType != 4) {
                        return null;
                    }
                    return "4G";
                }
                return "3G";
            }
            return "5G";
        }
        return q.f250391w;
    }

    public static String getOriginSizeStr(long j3) {
        long j16 = j3 / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j16 > 1024) {
            float f16 = ((float) j16) / 1024.0f;
            if (f16 > 1024.0f) {
                return decimalFormat.format(f16 / 1024.0f) + "GB";
            }
            return decimalFormat.format(f16) + "M";
        }
        return j16 + "KB";
    }

    public static String getString(int i3) {
        try {
            return com.tencent.open.adapter.a.f().e().getString(i3);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "getString error, resId=" + i3);
            return "";
        }
    }

    public static int getVersionCode(String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(MobileQQ.sMobileQQ.getPackageManager(), str, 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void initURLDrawable() {
        com.tencent.mobileqq.perf.memory.cache.b.f257663a.e();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initMemoryControlSDK");
        }
    }

    public static boolean isPhoneRooted(Context context) {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                if (new File(strArr[i3] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isRuningTask(int i3) {
        if (i3 != 4 && i3 != 2 && i3 != 13) {
            return false;
        }
        return true;
    }

    public static boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) MobileQQ.sMobileQQ.getSystemService("power");
        if (powerManager != null && powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    public static boolean isSdCardEnough(long j3, float f16) {
        long j16 = ah.U()[1] * 1048576;
        QLog.d(TAG, 1, "isSdCardEnough availSize=" + j16 + ",pkgSize=" + j3 + ",rate=" + f16);
        if (((float) j16) >= ((float) j3) * f16) {
            return true;
        }
        return false;
    }

    public static boolean isSignError(int i3) {
        if (i3 != 50001 && i3 != 50002 && i3 != 50003) {
            return false;
        }
        return true;
    }

    public static boolean isUnderWifiConnection() {
        boolean z16;
        try {
            z16 = AppNetConnInfo.isWifiConn();
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = true;
        }
        QLog.d(TAG, 1, "isUnderWifiConnection():" + z16);
        return z16;
    }

    public static void notifyPreExit() {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_SERVICE_EXIT_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    public static long parseContentLengthFromRange(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("/")) != null && split.length == 2) {
            try {
                return Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    public static JSONObject parseSignToJson(String str) {
        try {
            String decodeStr = decodeStr(str, WadlConstant.APK_SIGN_KEY, 2);
            if (TextUtils.isEmpty(decodeStr)) {
                return null;
            }
            return new JSONObject(decodeStr);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parseToJson exception:" + e16.getMessage());
            return null;
        }
    }

    public static long parseToLong(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    public static boolean rename(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static String getString(int i3, Object... objArr) {
        try {
            return com.tencent.open.adapter.a.f().e().getString(i3, objArr);
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "getString error, resId=" + i3 + ",objects=" + objArr);
            return "";
        }
    }
}

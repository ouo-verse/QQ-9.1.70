package com.qq.e.tg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.io.File;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TangramUtil {
    public static final int PERSONAL_AD_RECOMMEND_CLOSE = 0;
    public static final int PERSONAL_AD_RECOMMEND_OPEN = 1;

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            int length = decode.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(decode, 1, bArr, 0, length);
            SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec("adPrivacyUser_v1".getBytes()));
            Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
            cipher.init(2, generateSecret, new IvParameterSpec("b5k886cp".getBytes()));
            return new String(cipher.doFinal(bArr));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static void clearSplashCacheData(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(context.getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                String sb6 = sb5.toString();
                GDTLogger.e("clear Splash Cache Data , path is " + sb6);
                FileUtil.deleteDir(new File(sb6));
                String str3 = context.getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath() + str2 + "resource";
                GDTLogger.e("clear Splash source , path is " + sb6);
                FileUtil.deleteDir(new File(str3));
                TGSplashPreCacheUtil.clearPreCacheData();
                com.qq.e.comm.a.b(sb6);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static String encryptUserData(String str) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec("adPrivacyUser_v1".getBytes()));
            Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
            cipher.init(1, generateSecret, new IvParameterSpec("b5k886cp".getBytes()));
            bArr = cipher.doFinal(str.getBytes());
        } catch (Throwable th5) {
            th5.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[bArr.length + 1];
            bArr2[0] = 1;
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            return Base64.encodeToString(bArr2, 2);
        } catch (Throwable th6) {
            th6.printStackTrace();
            return null;
        }
    }

    public static boolean getNoLoginPersonalAdRecommendStatus() {
        if (SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_USER_NOLOGIN_AD_RECOMMEND_STATUS, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean getPersonalAdRecommendStatus() {
        if (SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_USER_AD_RECOMMEND_STATUS, 1) == 1) {
            return true;
        }
        return false;
    }

    public static long getSplashCacheSize(Context context) {
        long j3 = 0;
        if (context == null) {
            return 0L;
        }
        try {
            String absolutePath = context.getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath();
            j3 = FileUtil.getDirSize(absolutePath);
            GDTLogger.i("get tangram splash cache size , path is " + absolutePath + " , and size is " + j3);
            return j3;
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
            return j3;
        }
    }

    public static String getUserAdInterestLabel() {
        String string = SharedPreferencedUtil.getString(SharedPreferencedUtil.KEY_USER_AD_INTEREST_LABEL, null);
        String a16 = a(string);
        GDTLogger.d("encryptedString = " + string + ", decryptedString = " + a16);
        return a16;
    }

    public static void setNoLoginPersonalAdRecommendStatus(boolean z16) {
        GDTLogger.d("setNoLoginPersonalAdRecommendStatus isOpened = " + z16);
        SharedPreferencedUtil.putInt(SharedPreferencedUtil.KEY_USER_NOLOGIN_AD_RECOMMEND_STATUS, z16 ? 1 : 0);
    }

    public static void setPersonalAdRecommendStatus(boolean z16) {
        GDTLogger.d("setPersonalAdRecommendStatus isOpened = " + z16);
        SharedPreferencedUtil.putInt(SharedPreferencedUtil.KEY_USER_AD_RECOMMEND_STATUS, z16 ? 1 : 0);
    }

    public static boolean setUserAdInterestLabel(String str) {
        String str2;
        GDTLogger.d("setUserAdInterestLabel labelId = " + str);
        if (TextUtils.isEmpty(str)) {
            SharedPreferencedUtil.remove(SharedPreferencedUtil.KEY_USER_AD_INTEREST_LABEL);
            return true;
        }
        if (GDTADManager.getInstance().getSM() == null) {
            str2 = "SDK has no init completely";
        } else {
            if (str.length() > GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.AD_INTEREST_LABEL_MAX_LENGHTH, 360)) {
                str2 = "labelId.length() > maxLength";
            } else {
                try {
                    new JSONObject(str);
                    String encryptUserData = encryptUserData(str);
                    if (!TextUtils.isEmpty(encryptUserData)) {
                        SharedPreferencedUtil.putString(SharedPreferencedUtil.KEY_USER_AD_INTEREST_LABEL, encryptUserData);
                    }
                    GDTLogger.d("Ad Interest Label EncryptedString = " + encryptUserData);
                    return true;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    str2 = "labelId is not json string";
                }
            }
        }
        GDTLogger.w(str2);
        return false;
    }
}

package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.filter.GLSLRender;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUtils {
    private static final String DOT = "\\.";
    private static final String TAG = "TVKPlayer[TVKUtils]";
    private static String sAppVersion = "";
    private static int sBuildNum = -1;

    public static boolean byte2File(byte[] bArr, int i3, String str, String str2) {
        FileOutputStream fileOutputStream;
        if (bArr == null || bArr.length == 0 || i3 == 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file + File.separator + str2);
        if (file2.exists() && file2.length() == i3) {
            return true;
        }
        if (file2.exists() && !file2.delete()) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        try {
                            bufferedOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Exception e16) {
                            TVKLogUtil.e(TAG, e16);
                        }
                        return true;
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        TVKLogUtil.e(TAG, e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e18) {
                                TVKLogUtil.e(TAG, e18);
                                return false;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e19) {
                                TVKLogUtil.e(TAG, e19);
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Exception e27) {
            e = e27;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    public static Map<String, Integer> convertRawAbTestInfoToMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, Integer.valueOf(jSONObject.getInt(str2)));
            }
        } catch (JSONException unused) {
            TVKLogUtil.e(TAG, "[convertRawAbTestInfoToMap] Unrecognized abTestInfo: " + str);
        }
        return hashMap;
    }

    public static void copyAssetsToDst(Context context, String str, String str2) {
        InputStream inputStream;
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str3 : list) {
                    if (!"".equals(str)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        String str4 = File.separator;
                        sb5.append(str4);
                        sb5.append(str3);
                        copyAssetsToDst(context, sb5.toString(), str2 + str4 + str3);
                    } else {
                        copyAssetsToDst(context, str3, str2 + File.separator + str3);
                    }
                }
                return;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file2 = new File(str2);
                    inputStream = context.getAssets().open(str);
                    try {
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        fileOutputStream2.write(bArr, 0, read);
                                    } else {
                                        fileOutputStream2.flush();
                                        inputStream.close();
                                        fileOutputStream2.close();
                                        fileOutputStream2.flush();
                                        inputStream.close();
                                        fileOutputStream2.close();
                                        return;
                                    }
                                }
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                TVKLogUtil.e(TAG, e);
                                if (fileOutputStream != null) {
                                    fileOutputStream.flush();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.flush();
                                    } catch (IOException e17) {
                                        TVKLogUtil.e(TAG, e17);
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                } catch (Exception e19) {
                    e = e19;
                    inputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = null;
                }
            } catch (IOException e26) {
                TVKLogUtil.e(TAG, e26);
            }
        } catch (IOException e27) {
            TVKLogUtil.e(TAG, e27);
        }
    }

    public static String generateFlowId() {
        return UUID.randomUUID().toString() + System.nanoTime() + "_" + TVKVersion.getPlatform();
    }

    public static String generateMapPairStringByAnd(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String[] strArr = new String[map.size()];
            map.keySet().toArray(strArr);
            List<String> asList = Arrays.asList(strArr);
            Collections.sort(asList);
            StringBuilder sb5 = new StringBuilder();
            for (String str : asList) {
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(map.get(str));
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            return sb5.toString();
        }
        return "";
    }

    public static String getAppVersion(String str) {
        if (!TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(DOT);
            if (split != null && split.length == 4) {
                str = str.substring(0, str.lastIndexOf("."));
            }
        } else {
            str = AEResManagerConfigBean.DEFAULT_VERSION;
        }
        sAppVersion = str;
        return str;
    }

    public static int getBuildNumber(String str) {
        int i3;
        int i16 = sBuildNum;
        if (-1 != i16) {
            return i16;
        }
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(DOT);
            if (split.length == 4) {
                try {
                    i3 = Integer.parseInt(split[3]);
                } catch (NumberFormatException e16) {
                    TVKLogUtil.e(TAG, e16);
                } catch (Exception e17) {
                    TVKLogUtil.e(TAG, e17);
                }
                sBuildNum = i3;
                return i3;
            }
        }
        i3 = 0;
        sBuildNum = i3;
        return i3;
    }

    public static Object getField(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean getMapValueBool(Map<String, Object> map, String str, boolean z16) {
        Object obj = map.get(str);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return z16;
    }

    public static float getMapValueFloat(Map<String, Object> map, String str, float f16) {
        Object obj = map.get(str);
        if (obj != null) {
            return ((Float) obj).floatValue();
        }
        return f16;
    }

    public static int getMapValueInteger(Map<String, Object> map, String str, int i3) {
        Object obj = map.get(str);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return i3;
    }

    public static long getMapValueLong(Map<String, Object> map, String str, long j3) {
        Object obj = map.get(str);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return j3;
    }

    public static Object getMapValueObject(Map<String, Object> map, String str) {
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static String getMapValueString(Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str);
        if (obj != null) {
            return (String) obj;
        }
        return str2;
    }

    public static String getMd5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb5 = new StringBuilder(40);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if ((i3 >> 4) == 0) {
                    sb5.append("0");
                    sb5.append(Integer.toHexString(i3));
                } else {
                    sb5.append(Integer.toHexString(i3));
                }
            }
            return sb5.toString();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16.toString());
            return null;
        }
    }

    public static String getSafeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getString(byte[] bArr, int i3, int i16, String str) {
        if (bArr != null) {
            if (str != null && str.length() != 0) {
                try {
                    return new String(bArr, i3, i16, str);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr, i3, i16);
                }
            }
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }

    public static int getTextureFromBitmap(Context context, String str) {
        InputStream open;
        if (str == null) {
            return 0;
        }
        InputStream inputStream = null;
        try {
            if (str.contains("/")) {
                open = new FileInputStream(str);
            } else {
                open = context.getAssets().open(str);
            }
            inputStream = open;
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    TVKLogUtil.e(TAG, e16);
                }
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            if (i3 == 0) {
                TVKLogUtil.e(TAG, "Failed at glGenTextures");
                return 0;
            }
            if (decodeStream == null) {
                GLES20.glDeleteTextures(1, iArr, 0);
                TVKLogUtil.e(TAG, "Failed at glGenTextures");
                return 0;
            }
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, decodeStream, 0);
            decodeStream.recycle();
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            return iArr[0];
        } catch (Throwable unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e17) {
                    TVKLogUtil.e(TAG, e17);
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static byte[] gzipDeCompress(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        if (bArr != 0) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayInputStream(bArr);
                        try {
                            bArr = new ByteArrayOutputStream();
                        } catch (EOFException unused) {
                            bArr = 0;
                            gZIPInputStream2 = null;
                        } catch (IOException unused2) {
                            bArr = 0;
                            gZIPInputStream2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            bArr = 0;
                            gZIPInputStream = null;
                        }
                        try {
                            gZIPInputStream2 = new GZIPInputStream(length);
                        } catch (EOFException unused3) {
                            gZIPInputStream2 = null;
                        } catch (IOException unused4) {
                            gZIPInputStream2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            gZIPInputStream = null;
                            if (length != 0) {
                                try {
                                    length.close();
                                } catch (IOException unused5) {
                                    return null;
                                }
                            }
                            if (bArr != 0) {
                                bArr.close();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            throw th;
                        }
                    } catch (EOFException unused6) {
                        bArr = 0;
                        length = 0;
                        gZIPInputStream2 = null;
                    } catch (IOException unused7) {
                        bArr = 0;
                        length = 0;
                        gZIPInputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        bArr = 0;
                        length = 0;
                        gZIPInputStream = null;
                    }
                    try {
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int read = gZIPInputStream2.read(bArr2, 0, 8192);
                            if (read != -1) {
                                bArr.write(bArr2, 0, read);
                            } else {
                                byte[] byteArray = bArr.toByteArray();
                                try {
                                    length.close();
                                    bArr.close();
                                    gZIPInputStream2.close();
                                    return byteArray;
                                } catch (IOException unused8) {
                                    return null;
                                }
                            }
                        }
                    } catch (EOFException unused9) {
                        byte[] byteArray2 = bArr.toByteArray();
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (IOException unused10) {
                                return null;
                            }
                        }
                        bArr.close();
                        if (gZIPInputStream2 != null) {
                            gZIPInputStream2.close();
                        }
                        return byteArray2;
                    } catch (IOException unused11) {
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (IOException unused12) {
                                return null;
                            }
                        }
                        if (bArr != 0) {
                            bArr.close();
                        }
                        if (gZIPInputStream2 != null) {
                            gZIPInputStream2.close();
                        }
                        return null;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        return null;
    }

    public static boolean isHitting(double d16) {
        if (Math.random() < d16) {
            return true;
        }
        return false;
    }

    public static boolean isManufacturerInList(String str) {
        String manufacturer = TVKVcSystemInfo.getManufacturer();
        TVKLogUtil.i(TAG, "[isManufacturerInList] device manufacturer: " + manufacturer);
        if (TextUtils.isEmpty(manufacturer)) {
            return false;
        }
        return isStringInArrayCaseInsensitive(manufacturer, splitStringToArray(str, ","));
    }

    public static boolean isModelInList(String str) {
        String deviceModel = TVKVcSystemInfo.getDeviceModel();
        if (TextUtils.isEmpty(deviceModel)) {
            return false;
        }
        return isStringInArrayCaseInsensitive(deviceModel, splitStringToArray(str, ","));
    }

    public static boolean isNetworkPlayUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return str.split(":")[0].matches("^((https|http|ftp|rtsp|rtmp|mms|webrtc)?)");
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            if (!Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(new BigDecimal(str).toString()).matches()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isStringInArrayCaseInsensitive(@NonNull String str, @NonNull String[] strArr) {
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] mergeBytes(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return null;
        }
        if (bArr != null && bArr.length != 0) {
            if (bArr2 != null && bArr2.length != 0) {
                byte[] bArr3 = new byte[bArr.length + bArr2.length];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
                return bArr3;
            }
            return bArr;
        }
        return bArr2;
    }

    public static boolean optBoolean(String str, boolean z16) {
        if ("true".equalsIgnoreCase(str)) {
            return true;
        }
        if ("false".equalsIgnoreCase(str)) {
            return false;
        }
        return z16;
    }

    public static double optDouble(String str, double d16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return d16;
    }

    public static float optFloat(String str, float f16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return f16;
    }

    public static int optInt(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return i3;
    }

    public static long optLong(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return j3;
    }

    public static String pathRemoveTailSeparator(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.endsWith(File.pathSeparator)) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void sendMessage(Handler handler, int i3, int i16, int i17, Object obj) {
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = i3;
            obtain.arg1 = i16;
            obtain.arg2 = i17;
            obtain.obj = obj;
            handler.sendMessage(obtain);
        }
    }

    public static void sendMessageDelay(Handler handler, int i3, int i16, int i17, Object obj, long j3) {
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.what = i3;
            obtain.arg1 = i16;
            obtain.arg2 = i17;
            obtain.obj = obj;
            handler.sendMessageDelayed(obtain, j3);
        }
    }

    public static String[] splitStringToArray(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.split(str2);
            }
        } catch (PatternSyntaxException e16) {
            TVKLogUtil.e(TAG, "splitStringToArray\uff1a" + e16);
        }
        return new String[0];
    }
}

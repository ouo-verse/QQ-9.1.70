package com.tenpay.util;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncApi;
import com.tenpay.zxing.QrCodeWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Utils {
    public static final String CERT_SCENE_FINE_NAME = "qb_tenpay_sp_cert_scene";
    public static final String KEY_SHARE_COMMON_BUSSI_CID = "comm_bussi_cid";
    private static float density = -1.0f;
    private static final int invalidAge = -1;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class _RealnameFlag {
        public static final int BankCard_Authen = 4;
        public static final int BankCard_NonAuthen = 8;
        public static final int China_Mobile = 16;
        public static final int China_TeleCom = 64;
        public static final int China_Union = 32;
        public static final int Education_Verify = 128;
        public static final int Face_OCR = 512;
        public static final int IDCard_Upload = 2;
        public static final int Pay_Union = 256;
        public static final int Public_Security = 1;
    }

    public static void addCertScene(Context context, String str, int i3, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(CERT_SCENE_FINE_NAME + str, 0).edit();
        edit.putInt(str2, i3);
        edit.commit();
    }

    public static void addCommonBusinessCid(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("qb_tenpay_common" + str, 0).edit();
        edit.putString(KEY_SHARE_COMMON_BUSSI_CID, str2);
        edit.commit();
    }

    public static void addToMapIfHasKeyValue(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            map.put(str, str2);
        }
    }

    public static boolean arrayContain(int[] iArr, int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i16 : iArr) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    public static String asciiAESSort(TreeMap<String, String> treeMap) {
        String str;
        Set<Map.Entry<String, String>> entrySet = treeMap.entrySet();
        StringBuffer stringBuffer = new StringBuffer("");
        for (Map.Entry<String, String> entry : entrySet) {
            if (stringBuffer.length() == 0) {
                str = "%s=%s";
            } else {
                str = "&%s=%s";
            }
            stringBuffer.append(String.format(str, entry.getKey(), entry.getValue()));
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> bundle2Map(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                hashMap.put(str, obj.toString());
            }
        }
        return hashMap;
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static String changeY2F(String str) {
        String bigDecimal = new BigDecimal(str).multiply(new BigDecimal(100)).toString();
        if (bigDecimal.indexOf(".") > 0) {
            return bigDecimal.substring(0, bigDecimal.indexOf("."));
        }
        return bigDecimal;
    }

    public static boolean checkAmountValid(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(46) == 0) {
            return false;
        }
        if (str.indexOf(46) > 0 && str.indexOf(46) < str.length() - 3) {
            return false;
        }
        try {
            if (Double.valueOf(str).doubleValue() <= 0.0d) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void closeObject(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean compareString(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str.length() != 0 && (str2 == null || str2.length() == 0)) {
            return true;
        }
        try {
            if (Double.parseDouble(str.replaceAll(",", "")) - Double.parseDouble(str2.replaceAll(",", "")) <= 0.0d) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static Drawable createCornerRectDrawable(int i3, int i16, int i17, int i18) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i16);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setStroke(i17, i18);
        return gradientDrawable;
    }

    public static String cutTextByPix(Context context, String str, float f16, TextPaint textPaint) {
        if (f16 == 0.0f) {
            return str;
        }
        float dp2Px = dp2Px(context, f16);
        if (textPaint.measureText(str) <= dp2Px) {
            return str;
        }
        for (int length = str.length(); length > 0; length--) {
            String substring = str.substring(0, length - 1);
            if (textPaint.measureText(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX) <= dp2Px) {
                return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
        }
        return str;
    }

    public static long dateToStamp(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static String div(String str, String str2, int i3, boolean z16) throws Exception {
        if (i3 < 0) {
            return "0";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        if (z16) {
            return new DecimalFormat("#0.00").format(bigDecimal.divide(bigDecimal2, i3, 4).doubleValue());
        }
        return new DecimalFormat("#0.##").format(bigDecimal.divide(bigDecimal2, i3, 4).doubleValue());
    }

    public static long divToLong(long j3, int i3, int i16) throws Exception {
        BigDecimal divide = new BigDecimal(j3).divide(new BigDecimal(i3), i16, 4);
        if (divide == null) {
            return 0L;
        }
        return divide.longValue();
    }

    public static int dp2Px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            try {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable.draw(canvas);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return bitmap;
    }

    public static String fen2Yuan(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return transformToMoney(str, 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String fenToYuan2(String str) throws Exception {
        boolean z16;
        if (str != null && str.matches("\\-?[0-9]+")) {
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                z16 = true;
            } else {
                z16 = false;
            }
            while (str.startsWith("0") && str.length() > 1) {
                str = str.substring(1);
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (str.length() == 1) {
                stringBuffer.append("0.0");
                stringBuffer.append(str);
            } else if (str.length() == 2) {
                stringBuffer.append("0.");
                stringBuffer.append(str);
            } else {
                stringBuffer.append(str.substring(0, str.length() - 2));
                stringBuffer.append(".");
                stringBuffer.append(str.substring(str.length() - 2));
            }
            if (z16) {
                return "-" + stringBuffer.toString();
            }
            return stringBuffer.toString();
        }
        throw new Exception("\u91d1\u989d\u683c\u5f0f\u6709\u8bef");
    }

    public static String formatDate(int i3, int i16, int i17) {
        String valueOf = String.valueOf(i16);
        String valueOf2 = String.valueOf(i17);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        if (valueOf2.length() == 1) {
            valueOf2 = "0" + valueOf2;
        }
        return i3 + "/" + valueOf + "/" + valueOf2;
    }

    private static Bitmap genBMByMatrix(BitMatrix bitMatrix, int i3, int i16) throws WriterException {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i17 = 0; i17 < height; i17++) {
            int i18 = i17 * width;
            for (int i19 = 0; i19 < width; i19++) {
                int i26 = i18 + i19;
                int i27 = -1;
                if (bitMatrix.get(i19, i17)) {
                    if (i3 == -1) {
                        i27 = -16777216;
                    } else {
                        i27 = i3;
                    }
                } else if (i16 != -1) {
                    i27 = i16;
                }
                iArr[i26] = i27;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private static Bitmap genQrCode(String str, int i3, int i16, int i17, int i18) throws WriterException {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.L);
        String guessAppropriateEncoding = guessAppropriateEncoding(str);
        if (!TextUtils.isEmpty(guessAppropriateEncoding)) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) guessAppropriateEncoding);
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return genBMByMatrix(new QRCodeWriter().encode(str, i3, i16, enumMap), i17, i18);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    private static int getAgeByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.getTimeInMillis() - date.getTime() < 0) {
            return -1;
        }
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        calendar.setTime(date);
        int i18 = calendar.get(1);
        int i19 = calendar.get(2);
        int i26 = calendar.get(5);
        int i27 = i3 - i18;
        if ((i16 <= i19 && i16 == i19 && i17 < i26) || i16 < i19) {
            return i27 - 1;
        }
        return i27;
    }

    public static int getAgeByIDNumber(String str) {
        String substring;
        if (str.length() == 15) {
            substring = "19" + str.substring(6, 12);
        } else {
            if (str.length() == 18) {
                substring = str.substring(6, 14);
            }
            return -1;
        }
        return getAgeByDate(new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(substring));
    }

    public static Bitmap getBarCode(String str, int i3, int i16, int i17) {
        QwLog.i("w = " + i16 + " h = " + i17);
        try {
            return genBMByMatrix(new QrCodeWriter().encode(str, i16, i17), i3, -1);
        } catch (Exception e16) {
            QwLog.i("exception error: " + e16.getClass().getSimpleName());
            return null;
        }
    }

    public static int getCertScene(Context context, String str, String str2) {
        return context.getSharedPreferences(CERT_SCENE_FINE_NAME + str, 0).getInt(str2, -1);
    }

    public static String getCommonBusinessCid(Context context, String str) {
        return context.getSharedPreferences("qb_tenpay_common" + str, 0).getString(KEY_SHARE_COMMON_BUSSI_CID, null);
    }

    public static long getCurrentTicks() {
        return System.nanoTime();
    }

    public static String getCurrentTime() {
        Time time = new Time();
        time.setToNow();
        time.switchTimezone("Asia/Shanghai");
        try {
            return time.format("%Y%m%d%H%M%S");
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static float getDensity(Context context) {
        float f16 = density;
        if (-1.0f != f16) {
            return f16;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float f17 = displayMetrics.density;
        density = f17;
        return f17;
    }

    public static Bitmap getDensityBitmap(Context context, Bitmap bitmap, float f16) {
        if (bitmap == null) {
            return null;
        }
        float f17 = context.getResources().getDisplayMetrics().density;
        if (f17 == f16) {
            return bitmap;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) ((bitmap.getWidth() * f17) / f17), (int) ((bitmap.getHeight() * f17) / f17), true);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String getHost(String str) {
        Uri parse = Uri.parse(str);
        if (parse != null) {
            return parse.getHost();
        }
        return "";
    }

    public static String getImagePath() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/";
        }
        return "/system/DCIM/Camera/";
    }

    public static int getNavigationBarHeight(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getQrCode(Context context, String str, Bitmap bitmap, int i3, int i16, int i17) {
        QwLog.i("shareLink = " + str);
        if (density <= 0.0f) {
            getDensity(context);
        }
        try {
            int i18 = i3 / 2;
            Bitmap genQrCode = genQrCode(str, i18, i18, i16, i17);
            QwLog.i("gen qrcode over...");
            if (bitmap == null) {
                return genQrCode;
            }
            if (genQrCode == null) {
                return null;
            }
            Canvas canvas = new Canvas(genQrCode);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            float f16 = 6;
            float f17 = density;
            int i19 = (int) ((i18 / 2) - (f16 * f17));
            int i26 = (int) ((i18 / 2) + (f16 * f17));
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i19, i19, i26, i26), paint);
            QwLog.i("gen qrcode append logo over...");
            return genQrCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f16, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            if (z16) {
                canvas.drawRect(new Rect(0, (int) (height - f16), width, height), paint);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static int getScreenHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.y;
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            if (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("Mi 10") || DeviceInfoMonitor.getModel().contains("MIX 2") || DeviceInfoMonitor.getModel().contains("Redmi Note 8 Pro") || DeviceInfoMonitor.getModel().contains("Redmi K20 Pro")) {
                boolean z16 = false;
                if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                    z16 = true;
                }
                if (z16) {
                    return QFuncApi.getRealHeight(context);
                }
                return i3;
            }
            return i3;
        }
        return i3;
    }

    @SuppressLint({"NewApi"})
    public static int getScreenWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public static StateListDrawable getStateListDrawableWithCorner(int i3, int i16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed, -16842766}, createCornerRectDrawable(8, i16, 0, 0));
        stateListDrawable.addState(new int[0], createCornerRectDrawable(8, i3, 0, 0));
        return stateListDrawable;
    }

    public static ColorStateList getTextColorStateList(int i3, int i16) {
        int[] iArr = {i16, i16, i3};
        int[][] iArr2 = new int[2];
        int[] iArr3 = new int[1];
        iArr3[0] = 16842919;
        iArr2[0] = iArr3;
        int[] iArr4 = new int[1];
        iArr4[0] = -16842910;
        iArr2[1] = iArr4;
        iArr2[2] = new int[0];
        return new ColorStateList(iArr2, iArr);
    }

    public static Map<String, String> getUriParams(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static String getVerifyCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
        }
        return "";
    }

    public static int[] getViewLocation(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static Rect getViewRect(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        int i3 = iArr[0];
        rect.left = i3;
        rect.top = iArr[1];
        rect.right = i3 + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    public static boolean hasSmartBar() {
        if (!QFuncApi.isFlymeOS()) {
            return false;
        }
        try {
            Method method = Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(null, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
        }
        String str = Build.DEVICE;
        if (!str.equals("mx2") && !str.equals("mx3")) {
            if (!str.equals("mx")) {
                str.equals("m9");
            }
            return false;
        }
        return true;
    }

    public static String hideNick(String str, int i3) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2 && i3 == 0) {
            return String.format("**%s", str.substring(str.length() - 1, str.length()));
        }
        return str;
    }

    public static String hideUin(String str, int i3) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2 && 1 == i3) {
            return String.format("%s****%s", str.substring(0, 2), str.substring(str.length() - 2, str.length()));
        }
        return str;
    }

    public static boolean invalidateID(String str) {
        if (str.length() != 15 && str.length() != 18) {
            return false;
        }
        if (str.length() != 18) {
            return true;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length() - 1) {
            try {
                int i17 = i3 + 1;
                i16 += Integer.parseInt(str.substring(i3, i17)) * iArr[i3];
                i3 = i17;
            } catch (Exception unused) {
                return false;
            }
        }
        return String.valueOf(str.charAt(17)).equalsIgnoreCase(String.valueOf(cArr[i16 % 11]));
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        str.trim().length();
        return false;
    }

    public static boolean isNameVerify(int i3) {
        if ((i3 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isStringNull(String str) {
        if (!isEmpty(str) && !"NULL".equals(str.toUpperCase())) {
            return false;
        }
        return true;
    }

    public static boolean isWiFiActive(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i3 = 0; i3 < allNetworkInfo.length; i3++) {
                if (NetworkMonitor.getTypeName(allNetworkInfo[i3]).equals(Global.TRACKING_WIFI) && allNetworkInfo[i3].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray joinJSONArray(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (Exception unused) {
                return null;
            }
        } else {
            length = 0;
        }
        for (int i16 = 0; i16 < length; i16++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i16);
            if (i16 == length - 1) {
                stringBuffer.append(jSONObject.toString());
            } else {
                stringBuffer.append(jSONObject.toString());
                stringBuffer.append(",");
            }
        }
        if (jSONArray2 != null) {
            i3 = jSONArray2.length();
        } else {
            i3 = 0;
        }
        if (i3 > 0 && length > 0) {
            stringBuffer.append(",");
        }
        for (int i17 = 0; i17 < i3; i17++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i17);
            if (i17 == i3 - 1) {
                stringBuffer.append(jSONObject2.toString());
            } else {
                stringBuffer.append(jSONObject2.toString());
                stringBuffer.append(",");
            }
        }
        stringBuffer.insert(0, "[").append("]");
        return new JSONArray(stringBuffer.toString());
    }

    public static HashMap<String, String> jsonToMap(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public static int px2Dp(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Bitmap reSizeBitmap(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() != i3 || bitmap.getHeight() != i16) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true);
            bitmap.recycle();
            return createScaledBitmap;
        }
        return bitmap;
    }

    public static void removeSpByKey(Context context, String str, String str2) {
        try {
            context.getSharedPreferences(str, 0).edit().remove(str2).apply();
        } catch (Throwable th5) {
            QwLog.e(th5.toString());
        }
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3) {
        if (bitmap == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || compressFormat == null) {
            return false;
        }
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    boolean compress = bitmap.compress(compressFormat, i3, fileOutputStream2);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    return compress;
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public static String saveScreenToFile(Activity activity, Context context, View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        Date date = new Date();
        String str = simpleDateFormat.format(date) + "_" + date.getTime() + ".jpg";
        QwLog.i("name=" + str);
        Bitmap shot = shot(activity, view);
        if (shot == null) {
            return "";
        }
        String str2 = getImagePath() + str;
        QwLog.i("path=" + str2);
        saveBitmapToFile(shot, str2, Bitmap.CompressFormat.JPEG, 80);
        return str2;
    }

    public static String sha256(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(bytes);
            return bytes2Hex(messageDigest.digest()).toUpperCase();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static Bitmap shot(Activity activity, View view) {
        try {
            view.setDrawingCacheEnabled(true);
            return view.getDrawingCache();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String sortAndCatValues(Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        LinkedList<Map.Entry> linkedList = new LinkedList(map.entrySet());
        Collections.sort(linkedList, new Comparator() { // from class: com.tenpay.util.Utils.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                return ((Map.Entry) obj).getKey().toString().compareTo(((Map.Entry) obj2).getKey().toString());
            }
        });
        boolean z16 = true;
        for (Map.Entry entry : linkedList) {
            QwLog.i("sort key = " + entry.getKey() + ", value = " + entry.getValue());
            if (entry.getKey().toString().length() > 0 && entry.getValue().toString().length() > 0) {
                if (z16) {
                    sb5.append(entry.getValue().toString());
                    z16 = false;
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(entry.getValue().toString());
                }
            }
        }
        return sb5.toString();
    }

    public static int sp2px(float f16, Context context) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static long ticksToNowInMs(long j3) {
        return ((System.nanoTime() - j3) / 1000) / 1000;
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap, int i3, int i16) {
        float f16;
        float f17;
        float f18;
        float f19;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= height) {
                f19 = width;
                f18 = f19 / 2.0f;
                f16 = f19;
                f17 = 0.0f;
            } else {
                f16 = height;
                f17 = (width - height) / 2.0f;
                f18 = f16 / 2.0f;
                f19 = width - f17;
                width = height;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect((int) f17, (int) 0.0f, (int) f19, (int) f16);
            Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f16, (int) f16);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawCircle(f18, f18, f18, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            if (i3 > 0) {
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setColor(i16);
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeWidth(i3);
                canvas.drawCircle(f18, f18, f18 - (i3 / 2), paint2);
            }
            return createBitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static void touchEditText(Handler handler, final EditText editText) {
        if (handler != null && editText != null) {
            handler.postDelayed(new Runnable() { // from class: com.tenpay.util.Utils.2
                @Override // java.lang.Runnable
                public void run() {
                    MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
                    editText.dispatchTouchEvent(obtain);
                    MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
                    editText.dispatchTouchEvent(obtain2);
                    obtain.recycle();
                    obtain2.recycle();
                }
            }, 100L);
        }
    }

    public static String transformToMoney(String str, int i3) {
        return transformToMoney(str, i3, true);
    }

    public static JSONObject tryNewJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String yuan2Fen(String str) {
        try {
            return new DecimalFormat("#").format(new BigDecimal(str).multiply(new BigDecimal("100")).doubleValue());
        } catch (Exception unused) {
            return "";
        }
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static String transformToMoney(String str, int i3, boolean z16) {
        try {
            if (i3 != 0) {
                return i3 == 1 ? new DecimalFormat("#0.00").format(str) : "";
            }
            try {
                return div(str, "100", 2, z16);
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    return fenToYuan2(str);
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return "0";
                }
            }
        } catch (Exception e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, String> jsonToMap(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        return jsonToMap(jSONObject);
    }
}

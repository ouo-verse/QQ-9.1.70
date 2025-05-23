package com.tencent.mobileqq.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.vas.util.impl.VasNamePlateUtilImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EstablishSetting;
import cooperation.qzone.QzoneIPCModule;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    protected static final char[] f306518a = {'\u3002', '\uff1f', '\uff01', '!', '?', '\uff0c', '\uff1b', ',', TokenParser.SP};

    /* renamed from: b, reason: collision with root package name */
    protected static String f306519b = ".*(\\+86|086)?\\d{5,12}.*";

    /* renamed from: c, reason: collision with root package name */
    public static String f306520c = "";

    /* renamed from: d, reason: collision with root package name */
    private static final Set<Long> f306521d = new HashSet<Long>(100) { // from class: com.tencent.mobileqq.util.Utils.1
        {
            add(542245351L);
            add(80000967L);
            add(215880685L);
            add(68368003L);
            add(60008L);
            add(110789L);
            add(596584L);
            add(850258L);
            add(989666L);
            add(1966180L);
            add(2543061L);
            add(2899363L);
            add(4281717L);
            add(4704652L);
            add(5153657L);
            add(13365087L);
            add(17178190L);
            add(29994233L);
            add(150169438L);
            add(151600600L);
            add(172441708L);
            add(184533330L);
            add(262325660L);
            add(297977477L);
            add(337330417L);
            add(399999999L);
            add(413596295L);
            add(518810117L);
            add(56960055L);
            add(731237972L);
            add(820634905L);
            add(931521880L);
            add(1161421341L);
            add(1527368145L);
            add(1924262792L);
            add(2557747810L);
            add(2736184070L);
            add(42821188L);
            add(76183582L);
            add(79267777L);
            add(80000967L);
            add(139588861L);
            add(110789L);
            add(596584L);
            add(13365087L);
            add(4704652L);
            add(17178190L);
            add(1527368145L);
            add(56960055L);
            add(5153657L);
            add(29994233L);
            add(518810117L);
            add(60008L);
            add(2899363L);
            add(79267777L);
            add(80000967L);
            add(150169438L);
            add(931521880L);
            add(24315L);
            add(711029L);
            add(542245351L);
            add(10123L);
            add(511781L);
            add(10015L);
            add(848087L);
            add(32507773L);
            add(150169438L);
            add(824814503L);
            add(80000967L);
            add(542245351L);
            add(3833286L);
            add(43087L);
            add(656650031L);
            add(106224576L);
            add(66862063L);
            add(9948938L);
            add(164215L);
            add(64566184L);
            add(306392284L);
            add(445288149L);
            add(2283978633L);
            add(2362919671L);
            add(12425110L);
            add(289717882L);
            add(596584L);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static String f306522e = null;

    /* renamed from: f, reason: collision with root package name */
    private static StringBuilder f306523f = new StringBuilder();

    /* renamed from: g, reason: collision with root package name */
    private static int f306524g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f306525h = {HardCodeUtil.qqStr(R.string.f208265c9), HardCodeUtil.qqStr(R.string.f208245c7), HardCodeUtil.qqStr(R.string.f208355ch), HardCodeUtil.qqStr(R.string.f208295cb), HardCodeUtil.qqStr(R.string.f208365ci), HardCodeUtil.qqStr(R.string.f208275c_), HardCodeUtil.qqStr(R.string.f208225c5), HardCodeUtil.qqStr(R.string.f208335cf), HardCodeUtil.qqStr(R.string.f208325ce), HardCodeUtil.qqStr(R.string.f208385ck), HardCodeUtil.qqStr(R.string.f208235c6), HardCodeUtil.qqStr(R.string.f208285ca)};

    /* renamed from: i, reason: collision with root package name */
    static Boolean f306526i = null;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.util.Utils$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f306527d;

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f306527d;
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static long A(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static boolean B() {
        if (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().exists()) {
            return true;
        }
        return false;
    }

    public static byte[] C(String str) {
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                int i17 = i3 + 1;
                bArr[i16] = (byte) (((Character.digit(str.charAt(i3), 16) << 4) | Character.digit(str.charAt(i17), 16)) & 255);
                i16++;
                i3 = i17 + 1;
            }
            return bArr;
        }
        throw new RuntimeException("Odd number of characters.");
    }

    public static ByteStringMicro D(String str) {
        return ByteStringMicro.copyFrom(C(str));
    }

    public static byte[] E(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = str.toUpperCase().toCharArray();
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (i(charArray[i16 + 1]) | (i(charArray[i16]) << 4));
            }
            return bArr;
        }
        return null;
    }

    public static boolean F() {
        boolean z16;
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null && allAccounts.size() >= 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Utils", 2, "isAccountNumExceedMax, isExceed=" + z16);
        }
        return z16;
    }

    public static boolean G(String str) {
        if (str == null) {
            return false;
        }
        return AppConstants.BABY_Q_UIN.equals(str);
    }

    public static boolean H(char c16) {
        if (c16 >= '\u4e00' && c16 <= '\u9fbf') {
            return true;
        }
        return false;
    }

    public static boolean I(String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            j3 = 0;
        }
        if (j3 < 2726500000L || j3 > 2726511999L) {
            if (j3 < 800000000 || j3 > 800099999) {
                if (j3 < 938000000 || j3 > 938099999) {
                    if (j3 < 1068660000 || j3 > 1068669960) {
                        if ((j3 >= 2355000000L && j3 <= 2355199999L) || j3 == 56268888) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public static boolean J(String str) {
        if (str != null && !str.equals(AppConstants.VOTE_MSG_UIN) && !str.equals(String.valueOf(AppConstants.JOIN_TROOP_UIN)) && !str.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)) && !str.equals(String.valueOf(AppConstants.LBS_HELLO_UIN)) && !str.equals(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN)) && !str.equals(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN)) && !str.equals(String.valueOf(AppConstants.TROOP_ASSISTANT_UIN)) && !str.equals(String.valueOf(AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN)) && !str.equals(String.valueOf(AppConstants.TROOP_BAR_ASSISTANT_UIN)) && !str.equals(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN)) && !str.equals(String.valueOf(AppConstants.DATALINE_PC_UIN)) && !str.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN)) && !str.equals(String.valueOf(AppConstants.DATALINE_PHONE_UIN)) && !str.equals(String.valueOf(AppConstants.DATALINE_PRINTER_UIN)) && !str.equals(String.valueOf(AppConstants.SMARTDEVICE_UIN)) && !str.equals(String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN)) && !str.equals(String.valueOf(AppConstants.SAME_STATE_BOX_UIN)) && !str.equals(String.valueOf(AppConstants.DATE_UIN)) && !str.equals(String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN)) && !str.equals(String.valueOf(AppConstants.SEC_MSG_UIN)) && !str.equals(String.valueOf(AppConstants.WIFI_HOT_CHAT_UIN)) && !str.equals(String.valueOf(AppConstants.ACTIVATE_FRIENDS_UIN)) && !str.equals(String.valueOf(AppConstants.EC_SHOP_ASSISTANT_UIN)) && !str.equals(String.valueOf(AppConstants.READINJOY_UIN)) && !str.equals(String.valueOf(AppConstants.DINGDONG_UIN)) && !str.equals(String.valueOf(AppConstants.SEND_BLESS_UIN)) && !str.equals(String.valueOf(AppConstants.KANDIAN_MERGE_UIN)) && !str.equals(String.valueOf(AppConstants.HOTCHAT_CENTER_LONGVALUE)) && !str.equals(String.valueOf(AppConstants.CONFESS_UIN)) && !str.equals(String.valueOf(AppConstants.TEMP_MSG_BOX_UIN))) {
            return false;
        }
        return true;
    }

    public static boolean K() {
        boolean z16;
        long j3;
        Boolean bool = f306526i;
        if (bool == null) {
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                String uin = firstSimpleAccount.getUin();
                if (!TextUtils.isEmpty(uin)) {
                    try {
                        j3 = Long.parseLong(uin);
                    } catch (Exception unused) {
                        j3 = 0;
                    }
                    if (f306521d.contains(Long.valueOf(j3))) {
                        z16 = true;
                        bool = Boolean.valueOf(z16);
                    }
                }
            }
            z16 = false;
            bool = Boolean.valueOf(z16);
        }
        return bool.booleanValue();
    }

    public static boolean L(long j3) {
        return f306521d.contains(Long.valueOf(j3));
    }

    public static boolean M(String str) {
        if (str != null && str.length() > 0 && !"0".equals(str) && !MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN.equals(str) && !VasNamePlateUtilImpl.WILDCARD.equals(str) && !"80000000".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean N(Context context, String str) {
        if (context != null && str != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                    return true;
                }
            }
        }
        return false;
    }

    public static int O(long j3) {
        return (int) j3;
    }

    public static long P(int i3) {
        return i3 & 4294967295L;
    }

    public static void Q(String str) {
        ExceptionTracker.printCallStack(str, 1);
    }

    public static final float R(int i3, Resources resources) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / resources.getDisplayMetrics().density;
    }

    public static int S(int i3, int i16, int i17) {
        if (i16 != 0 && i17 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    public static void T(View view, Drawable drawable) {
        if (drawable != null && view != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            int paddingTop = view.getPaddingTop() + rect.top;
            int paddingLeft = view.getPaddingLeft() + rect.left;
            int paddingRight = view.getPaddingRight() + rect.right;
            int paddingBottom = view.getPaddingBottom() + rect.bottom;
            view.setBackgroundDrawable(drawable);
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static String U(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (str == null) {
            sb5.append("null");
        } else if (str.length() == 0) {
            sb5.append("");
        } else {
            int length = str.length();
            if (length > 10) {
                sb5.append(str.charAt(0));
                sb5.append(str.charAt(1));
                sb5.append("***");
                sb5.append(str.charAt(length - 1));
                sb5.append('[');
                sb5.append(length);
                sb5.append(']');
            } else {
                sb5.append(str.charAt(0));
                for (int i3 = 1; i3 < str.length(); i3++) {
                    sb5.append('*');
                }
            }
        }
        return sb5.toString();
    }

    public static int V(byte b16) {
        if (b16 < 0) {
            return b16 + 256;
        }
        return b16;
    }

    public static String a(@NonNull String str) {
        String str2;
        if (EstablishSetting.isCpu64Bit()) {
            str2 = "arm64-v8a";
        } else {
            str2 = "armeabi-v7a";
        }
        String str3 = str + File.separator + str2;
        if (!new File(str3).exists()) {
            QLog.e("Utils", 1, "appendAbiSuffixIfExists, " + str2 + " path not exist.");
            return str;
        }
        return str3;
    }

    public static long b(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56);
    }

    public static short c(byte[] bArr, int i3) {
        return (short) ((V(bArr[i3]) << 8) | V(bArr[i3 + 1]));
    }

    public static long d(byte[] bArr, int i3) {
        return (V(bArr[i3]) << 24) | V(bArr[i3 + 3]) | (V(bArr[i3 + 2]) << 8) | (V(bArr[i3 + 1]) << 16);
    }

    public static String e(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length);
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString.toUpperCase());
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static int f(int i3) {
        int i16 = 2;
        if (f306523f.length() > 560) {
            try {
                int length = f306523f.toString().getBytes("utf-8").length;
                if (f306524g != length && QLog.isColorLevel()) {
                    QLog.d("Utils", 2, "calculate byte num not equal byte num returned by getBytes(),totalByteNum is:" + f306524g + ",byteNum" + length);
                }
            } catch (UnsupportedEncodingException unused) {
            }
            f306523f.setLength(0);
            f306524g = 0;
        }
        if (i3 >= 0 && i3 < 128) {
            i16 = 1;
        } else if (i3 < 128 || i3 >= 2048) {
            if (i3 >= 2048 && i3 < 65536) {
                i16 = 3;
            } else if (i3 >= 65536 && i3 < 2097152) {
                i16 = 4;
            } else if (i3 >= 2097152 && i3 < 67108864) {
                i16 = 5;
            } else {
                i16 = 6;
            }
        }
        f306523f.append(Character.toChars(i3));
        f306524g += i16;
        return i16;
    }

    public static int g(String str) {
        return h(str)[0];
    }

    public static int[] h(String str) {
        int[] iArr = new int[2];
        if (str == null) {
            iArr[1] = 0;
            iArr[0] = 0;
            return iArr;
        }
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 20) {
                int i18 = i3 + 4;
                if (i18 < length) {
                    int i19 = i3 + 1;
                    if (str.charAt(i19) == '\u00ff' || str.charAt(i19) == '\u01ff') {
                        i16 += 20;
                        i17++;
                        i3 = i18;
                    }
                }
                i3++;
                i16 = (i3 >= length || str.charAt(i3) < '\u0104') ? i16 + 12 : i16 + 40;
            } else {
                i16 += f(codePointAt);
                if (codePointAt > 255) {
                    i3++;
                }
            }
            i3++;
        }
        iArr[0] = i16;
        iArr[1] = i17;
        return iArr;
    }

    private static byte i(char c16) {
        return (byte) "0123456789ABCDEF".indexOf(c16);
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("Utils", 1, e16, new Object[0]);
            }
        }
    }

    public static int k(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        if (j3 == j16) {
            return 0;
        }
        return 1;
    }

    public static int l(long j3, long j16) {
        return k(j3 - Long.MIN_VALUE, j16 - Long.MIN_VALUE);
    }

    public static String m(String str, int i3) {
        if (str == null) {
            return str;
        }
        if (str.length() != 0 && str.length() > i3) {
            String substring = str.substring(0, i3);
            if (substring.codePointAt(substring.length() - 1) != 20 && (substring.length() < 4 || substring.codePointAt(substring.length() - 4) != 20)) {
                return substring;
            }
            return substring.substring(0, substring.length() - 1);
        }
        return str;
    }

    public static final int n(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static float o(float f16, Resources resources) {
        return (f16 * resources.getDisplayMetrics().density) + 0.5f;
    }

    public static boolean p(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    public static int q(Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static int r(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i3, i16);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, 1, 19);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, 2, 18);
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(1, 3, 20);
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(1, 4, 19);
        Calendar calendar6 = Calendar.getInstance();
        calendar6.set(1, 5, 20);
        Calendar calendar7 = Calendar.getInstance();
        calendar7.set(1, 6, 21);
        Calendar calendar8 = Calendar.getInstance();
        calendar8.set(1, 7, 22);
        Calendar calendar9 = Calendar.getInstance();
        calendar9.set(1, 8, 22);
        Calendar calendar10 = Calendar.getInstance();
        calendar10.set(1, 9, 22);
        Calendar calendar11 = Calendar.getInstance();
        calendar11.set(1, 10, 23);
        Calendar calendar12 = Calendar.getInstance();
        calendar12.set(1, 11, 22);
        Calendar calendar13 = Calendar.getInstance();
        calendar13.set(1, 12, 21);
        if (calendar.compareTo(calendar2) > 0 && calendar.compareTo(calendar3) <= 0) {
            return 1;
        }
        if (calendar.compareTo(calendar3) > 0 && calendar.compareTo(calendar4) <= 0) {
            return 2;
        }
        if (calendar.compareTo(calendar4) > 0 && calendar.compareTo(calendar5) <= 0) {
            return 3;
        }
        if (calendar.compareTo(calendar5) > 0 && calendar.compareTo(calendar6) <= 0) {
            return 4;
        }
        if (calendar.compareTo(calendar6) > 0 && calendar.compareTo(calendar7) <= 0) {
            return 5;
        }
        if (calendar.compareTo(calendar7) > 0 && calendar.compareTo(calendar8) <= 0) {
            return 6;
        }
        if (calendar.compareTo(calendar8) > 0 && calendar.compareTo(calendar9) <= 0) {
            return 7;
        }
        if (calendar.compareTo(calendar9) > 0 && calendar.compareTo(calendar10) <= 0) {
            return 8;
        }
        if (calendar.compareTo(calendar10) > 0 && calendar.compareTo(calendar11) <= 0) {
            return 9;
        }
        if (calendar.compareTo(calendar11) > 0 && calendar.compareTo(calendar12) <= 0) {
            return 10;
        }
        if (calendar.compareTo(calendar12) <= 0 || calendar.compareTo(calendar13) > 0) {
            return 12;
        }
        return 11;
    }

    public static String s(int i3) {
        if (i3 >= 1) {
            String[] strArr = f306525h;
            if (i3 <= strArr.length) {
                return strArr[i3 - 1];
            }
            return "";
        }
        return "";
    }

    public static String t(int i3, int i16) {
        return s(r(i3, i16));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(Context context, String str) {
        BufferedReader bufferedReader;
        Throwable th5;
        InputStream inputStream;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e16) {
                e = e16;
                bufferedReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                if (bufferedReader != null) {
                }
                if (inputStream == null) {
                }
            }
        } catch (IOException e17) {
            e = e17;
            inputStream = null;
            bufferedReader = null;
        } catch (Throwable th7) {
            bufferedReader = null;
            th5 = th7;
            inputStream = null;
        }
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                str2 = sb5.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    QLog.e("Utils", 1, "getContentFromAssets close input stream error, fileName:", str, e18);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e19) {
                        QLog.e("Utils", 1, "getContentFromAssets close content reader error, fileName:", str, e19);
                    }
                }
            } catch (Throwable th8) {
                th5 = th8;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e26) {
                        QLog.e("Utils", 1, "getContentFromAssets close input stream error, fileName:", str, e26);
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream.close();
                        throw th5;
                    } catch (IOException e27) {
                        QLog.e("Utils", 1, "getContentFromAssets close content reader error, fileName:", str, e27);
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (IOException e28) {
            e = e28;
            QLog.e("Utils", 1, "getContentFromAssets error, fileName:", str, e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e29) {
                    QLog.e("Utils", 1, "getContentFromAssets close input stream error, fileName:", str, e29);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e36) {
                    QLog.e("Utils", 1, "getContentFromAssets close content reader error, fileName:", str, e36);
                }
            }
            return str2;
        }
        return str2;
    }

    public static long v() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear(10);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        return calendar.getTimeInMillis();
    }

    @SuppressLint({"NewApi"})
    public static String w(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/");
        }
        return null;
    }

    public static int x(String str) {
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (H(str.charAt(i16))) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        QLog.d("Utils", 1, "getMixStringLength, str :" + str + ",length :" + i3);
        return i3;
    }

    public static int y(Intent intent) {
        String str;
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.e("Utils", 2, "onActivityResult data=null");
            }
            return -1;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("result");
        } else {
            str = "{}";
        }
        if (QLog.isColorLevel()) {
            QLog.i("Utils", 2, "onActivityResult data=" + str);
        }
        try {
            return new JSONObject(str).optInt(QzoneIPCModule.RESULT_CODE, -1);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Utils", 2, "getPayResultCode " + e16);
            }
            return -1;
        }
    }

    public static long z() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }
}

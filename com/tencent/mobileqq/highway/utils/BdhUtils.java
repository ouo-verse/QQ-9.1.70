package com.tencent.mobileqq.highway.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BdhUtils {
    static IPatchRedirector $redirector_ = null;
    public static String APN_TYPE_3GNET = null;
    public static String APN_TYPE_3GWAP = null;
    public static String APN_TYPE_CMNET = null;
    public static String APN_TYPE_CMWAP = null;
    public static String APN_TYPE_CTNET = null;
    public static String APN_TYPE_CTWAP = null;
    public static String APN_TYPE_UNINET = null;
    public static String APN_TYPE_UNIWAP = null;
    private static final String KEY_PRE_APN = "APN_";
    private static final String KEY_WIFI_DEFAULT = "WIFI_DEFAULT";
    private static Uri PREFERRED_APN_URI = null;
    private static final String SUB_TAG = "BdhUtils";
    private static final char[] digits;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
        APN_TYPE_CTNET = "ctnet";
        APN_TYPE_CTWAP = "ctwap";
        APN_TYPE_CMNET = "cmnet";
        APN_TYPE_CMWAP = "cmwap";
        APN_TYPE_UNINET = "uninet";
        APN_TYPE_UNIWAP = "uniwap";
        APN_TYPE_3GNET = "3gnet";
        APN_TYPE_3GWAP = "3gwap";
    }

    public BdhUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void DWord2Byte(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }

    public static int analysisIOProblem(IOException iOException) {
        String message = iOException.getMessage();
        String externalStorageState = Environment.getExternalStorageState();
        if (message.contains("EACCES")) {
            return 9039;
        }
        if (message.contains("ENOSPC")) {
            return 9040;
        }
        if (message.contains("Read-only") || !"mounted".equals(externalStorageState)) {
            return 9039;
        }
        return 9303;
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = digits;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    public static void copyData(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        System.arraycopy(bArr2, i16, bArr, i3, i17);
    }

    public static byte[] encode(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (0 != 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getApnType(Context context) {
        String str;
        String str2 = "nomatch";
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), PREFERRED_APN_URI, null, null, null, null);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return "nomatch";
        }
        cursor.moveToFirst();
        String lowerCase = cursor.getString(cursor.getColumnIndex(QCircleAlphaUserReporter.KEY_USER)).toLowerCase();
        if (lowerCase.startsWith(APN_TYPE_CTNET)) {
            str = APN_TYPE_CTNET;
        } else if (lowerCase.startsWith(APN_TYPE_CTWAP)) {
            str = APN_TYPE_CTWAP;
        } else if (lowerCase.startsWith(APN_TYPE_CMNET)) {
            str = APN_TYPE_CMNET;
        } else if (lowerCase.startsWith(APN_TYPE_CMWAP)) {
            str = APN_TYPE_CMWAP;
        } else if (lowerCase.startsWith(APN_TYPE_UNINET)) {
            str = APN_TYPE_UNINET;
        } else {
            if (lowerCase.startsWith(APN_TYPE_UNIWAP)) {
                str = APN_TYPE_UNIWAP;
            }
            cursor.close();
            return str2;
        }
        str2 = str;
        cursor.close();
        return str2;
    }

    public static HttpURLConnection getConnectionWithDefaultProxy(String str, String str2, int i3) throws MalformedURLException, IOException {
        return (HttpURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, i3)));
    }

    public static HttpURLConnection getConnectionWithXOnlineHost(String str, String str2, int i3) throws MalformedURLException, IOException {
        String substring;
        String str3;
        URL url;
        int indexOf = str.indexOf(47, 7);
        if (indexOf < 0) {
            str3 = str.substring(7);
            substring = "";
        } else {
            String substring2 = str.substring(7, indexOf);
            substring = str.substring(indexOf);
            str3 = substring2;
        }
        if (i3 != 80) {
            url = new URL("http://" + str2 + ":" + i3 + substring);
        } else {
            url = new URL("http://" + str2 + substring);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("X-Online-Host", str3);
        return httpURLConnection;
    }

    public static ArrayList<String> getCurNetKey(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        int systemNetwork = HwNetworkUtil.getSystemNetwork(context);
        if (systemNetwork != 1) {
            if (systemNetwork == 2 || systemNetwork == 3 || systemNetwork == 4) {
                arrayList.add(KEY_PRE_APN + HwNetworkUtil.getCurrentApn(context));
            }
        } else {
            String wifiSubNet = HwNetworkUtil.getWifiSubNet(context);
            if (!TextUtils.isEmpty(wifiSubNet)) {
                arrayList.add(wifiSubNet);
                BdhLogUtil.LogEvent("N", "BdhUtils getCurNetKey, wifiSubNet = " + wifiSubNet);
            } else {
                arrayList.add(KEY_WIFI_DEFAULT);
                BdhLogUtil.LogEvent("N", "BdhUtils getCurNetKey, wifiSubNet is empty");
            }
        }
        return arrayList;
    }

    public static long getLongData(byte[] bArr, int i3) {
        if (bArr == null) {
            return 0L;
        }
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + ((bArr[i3 + 3] & 255) << 0);
    }

    public static byte[] hexToBytes(String str) {
        int i3;
        int i16;
        if (str == null) {
            return null;
        }
        int length = str.length();
        String upperCase = str.toUpperCase();
        if (length % 2 != 0 || length == 0) {
            return null;
        }
        int i17 = length / 2;
        byte[] bArr = new byte[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = i18 * 2;
            char charAt = upperCase.charAt(i19);
            char charAt2 = upperCase.charAt(i19 + 1);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    i3 = (charAt - 'A') + 10;
                }
                return null;
            }
            i3 = charAt - '0';
            int i26 = (i3 << 4) + 0;
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 >= 'A' && charAt2 <= 'F') {
                    i16 = (charAt2 - 'A') + 10;
                }
                return null;
            }
            i16 = charAt2 - '0';
            bArr[i18] = (byte) (i26 + i16);
        }
        return bArr;
    }

    public static boolean isBdhNetConnected(Context context) {
        return HwNetworkUtil.isNetworkConnected(context);
    }

    public static boolean isNetWorkProb(int i3) {
        if (i3 != 3 && i3 != 8 && i3 != 14 && i3 != 7 && i3 != 9 && i3 != 2 && i3 != 5 && i3 != 4) {
            return false;
        }
        return true;
    }

    public static String getApnType(String str) {
        String str2;
        if (str == null) {
            return "nomatch";
        }
        try {
            if (str.startsWith(APN_TYPE_CTNET)) {
                str2 = APN_TYPE_CTNET;
            } else if (str.startsWith(APN_TYPE_CTWAP)) {
                str2 = APN_TYPE_CTWAP;
            } else if (str.startsWith(APN_TYPE_CMNET)) {
                str2 = APN_TYPE_CMNET;
            } else if (str.startsWith(APN_TYPE_CMWAP)) {
                str2 = APN_TYPE_CMWAP;
            } else if (str.startsWith(APN_TYPE_UNINET)) {
                str2 = APN_TYPE_UNINET;
            } else if (str.startsWith(APN_TYPE_UNIWAP)) {
                str2 = APN_TYPE_UNIWAP;
            } else if (str.startsWith(APN_TYPE_3GNET)) {
                str2 = APN_TYPE_3GNET;
            } else {
                if (!str.startsWith(APN_TYPE_3GWAP)) {
                    return "nomatch";
                }
                str2 = APN_TYPE_3GWAP;
            }
            return str2;
        } catch (Exception unused) {
            return "nomatch";
        }
    }
}

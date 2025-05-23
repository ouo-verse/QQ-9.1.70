package com.pay.tool;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.pay.http.APPluginUrlConf;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APIPConfig;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes2.dex */
public class APMidasTools {
    static long lastClickTime;

    public static String getCurrentThreadName(Thread thread) {
        return thread.getName();
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }

    public static String getSysServerDomain() {
        String str = APMidasPayAPI.env;
        if (APMidasPayHelper.isPayCenterSDK) {
            return APIPConfig.getDomain(str);
        }
        if (str.equals(APMidasPayAPI.ENV_DEV)) {
            return APPluginUrlConf.UNIPAY_DEV_DOMAIN;
        }
        if (str.equals("test")) {
            return APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
        }
        return "api.unipay.qq.com";
    }

    public static long getTimeInterval(long j3, long j16) {
        return j16 - j3;
    }

    public static String getUUID() {
        try {
            return UUID.randomUUID().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUrlParamsValue(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String[] split = str.split("[?]");
        if (split.length > 1 && (str3 = split[1]) != null) {
            for (String str6 : str3.split("[&]")) {
                String[] split2 = str6.split("[=]");
                if (split2.length <= 1 || (str4 = split2[0]) == null) {
                    str4 = null;
                }
                if (split2.length <= 1 || (str5 = split2[1]) == null) {
                    str5 = null;
                }
                if (str4 != null && str4.compareToIgnoreCase(str2) == 0) {
                    return str5;
                }
            }
        }
        return null;
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 3000) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static String map2UrlParams(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(entry.getValue());
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static String urlDecode(String str, int i3) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (i3 <= 0) {
                return str;
            }
            int i16 = 0;
            while (i16 < i3) {
                try {
                    str2 = URLDecoder.decode(str, "utf-8");
                } catch (Exception e16) {
                    APLog.i("urlEncode", e16.toString());
                }
                i16++;
                str = str2;
            }
        } else {
            APLog.w("", "\u89e3\u7801\u5185\u5bb9\u4e3a\u7a7a");
        }
        return str2;
    }

    public static String urlEncode(String str, int i3) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (i3 <= 0) {
                return str;
            }
            int i16 = 0;
            while (i16 < i3) {
                try {
                    str2 = URLEncoder.encode(str, "utf-8");
                } catch (Exception e16) {
                    APLog.i("urlEncode", e16.toString());
                }
                i16++;
                str = str2;
            }
        } else {
            APLog.i("urlEncode", "\u7f16\u7801\u5185\u5bb9\u4e3a\u7a7a");
        }
        return str2;
    }
}

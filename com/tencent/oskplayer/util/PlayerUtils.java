package com.tencent.oskplayer.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DefaultHttpDataSource;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoKeyGenerator;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.oskplayer.service.DNSService;
import com.tencent.oskplayer.support.util.OskDebug;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: classes22.dex */
public class PlayerUtils {
    public static final int DnsServiceModePrependIp = 1;
    public static final int DnsServiceModeReplaceDomain = 0;
    public static final int LOG_TEXT_MAX_LENGTH = 1000;
    static final int PROXY_SUB_ERROR_CODE_BASE = -20000;
    static final int SUB_ERROR_CODE_NOT_PARSED = -1;
    private static final String TAG = "PlayerUtils";
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static String htmlMagic = "<html";
    private static final Pattern IPV4_ADDR_PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    public static HashMap<String, String> sVideoKeyCacheMap = new HashMap<>();
    private static String mobile_detail_info = null;
    private static final Object LOCK_0 = new Object();
    private static volatile int H265_REPORT_KEY_VERSION = 1;
    private static String h265MobileDetailInfoKey = null;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static HashMap<String, Boolean> sIsHLSStreamCacheMap = new HashMap<>();

    public static String bytesToHex(byte[] bArr, int i3) {
        int min = Math.min(i3, bArr.length);
        char[] cArr = new char[min * 2];
        String str = "";
        for (int i16 = 0; i16 < min; i16++) {
            int i17 = i16 % 16;
            if (i17 == 0 && i16 != 0) {
                str = str + "\n";
            }
            if (i17 == 0) {
                str = str + String.format("%2s:", Integer.toHexString(i16));
            }
            if (i16 % 2 == 0) {
                str = str + " ";
            }
            int i18 = bArr[i16] & 255;
            int i19 = i16 * 2;
            char[] cArr2 = hexArray;
            cArr[i19] = cArr2[i18 >>> 4];
            String str2 = str + cArr[i19];
            int i26 = i19 + 1;
            cArr[i26] = cArr2[i18 & 15];
            str = str2 + cArr[i26];
        }
        if (bArr.length > min) {
            return str + " ....";
        }
        return str;
    }

    private static int count(String str, char c16) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            if (c16 == str.charAt(i16)) {
                i3++;
            }
        }
        return i3;
    }

    private static String doGetMobileDetailInfo() {
        if (h265MobileDetailInfoKey == null) {
            h265MobileDetailInfoKey = (((((((("" + DeviceInfoMonitor.getModel()) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.RELEASE) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.SDK_INT) + ContainerUtils.FIELD_DELIMITER) + getNumberOfCores()) + ContainerUtils.FIELD_DELIMITER) + H265_REPORT_KEY_VERSION;
        }
        return h265MobileDetailInfoKey;
    }

    public static int findFreePort(int i3) throws IllegalStateException {
        try {
            return findFreePort();
        } catch (IllegalStateException unused) {
            for (int i16 = 0; i16 < i3; i16++) {
                try {
                    return findFreePort();
                } catch (IllegalStateException unused2) {
                    log(5, TAG, "retry findFreePort i=" + i16);
                }
            }
            throw new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=" + i3);
        }
    }

    public static String formatVideoTime(long j3) {
        long round = Math.round((j3 * 1.0d) / 1000.0d);
        long j16 = round % 60;
        long j17 = (round / 60) % 60;
        long j18 = round / 3600;
        StringBuilder sb5 = new StringBuilder();
        Formatter formatter = new Formatter(sb5, Locale.getDefault());
        sb5.setLength(0);
        if (j18 > 0) {
            return formatter.format("%d:%02d:%02d", Long.valueOf(j18), Long.valueOf(j17), Long.valueOf(j16)).toString();
        }
        return formatter.format("%02d:%02d", Long.valueOf(j17), Long.valueOf(j16)).toString();
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i3;
        int i16;
        do {
            atomicInteger = sNextGeneratedId;
            i3 = atomicInteger.get();
            i16 = i3 + 1;
            if (i16 > 16777215) {
                i16 = 1;
            }
        } while (!atomicInteger.compareAndSet(i3, i16));
        return i3;
    }

    public static String getAbsoluteUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.startsWith("http")) {
                return str2;
            }
            try {
                return new URL(new URL(str), str2).toString();
            } catch (MalformedURLException unused) {
                return getAbsoluteUrl2(str, str2);
            }
        }
        return str;
    }

    private static String getAbsoluteUrl2(String str, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        return str + str2;
    }

    public static String getConnectionTypeStr(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return "TYPE_UNKNOWN";
            }
            return "TYPE_WIFI";
        }
        return "TYPE_MOBILE";
    }

    public static long getDownloadResponseCode(long j3, long j16) {
        int i3;
        String[] userProxy = getUserProxy();
        if (userProxy != null) {
            log(4, TAG, "proxy setting " + join((Iterator<String>) Arrays.asList(userProxy).iterator(), "|"));
            i3 = -3;
        } else {
            i3 = -2;
        }
        return ((j3 - j16) - (i3 * 100000000)) / JsonGrayBusiId.UI_RESERVE_100000_110000;
    }

    public static long getDownloadRetCode(long j3, long j16) {
        int i3;
        String[] userProxy = getUserProxy();
        if (userProxy != null) {
            log(4, TAG, "proxy setting " + join((Iterator<String>) Arrays.asList(userProxy).iterator(), "|"));
            i3 = -3;
        } else {
            i3 = -2;
        }
        return (i3 * 100000000) + (j3 * JsonGrayBusiId.UI_RESERVE_100000_110000) + j16;
    }

    public static int getH265ReportedKeyVersion() {
        return H265_REPORT_KEY_VERSION;
    }

    public static String getMobileDetailInfo() {
        String str;
        synchronized (LOCK_0) {
            if (mobile_detail_info == null) {
                mobile_detail_info = doGetMobileDetailInfo();
            }
            str = mobile_detail_info;
        }
        return str;
    }

    private static int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.oskplayer.util.PlayerUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (Pattern.matches("cpu[0-9]+", file.getName())) {
                        return true;
                    }
                    return false;
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private static int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long getPlayVideoRetCode(int i3, long j3, String str) {
        long j16;
        if (!TextUtils.isEmpty(str) && str.equals(IVideoReporter.SALT_LIVEVIDEO)) {
            j16 = -10000000000L;
        } else {
            j16 = 0;
        }
        return (j16 - 200000000) + (i3 * 100000) + j3;
    }

    public static String getPrintableStackTrace(Throwable th5) {
        return OskDebug.getPrintableStackTrace(th5);
    }

    public static String getStackTrace() {
        return OskDebug.getStackTrace();
    }

    public static long getSubErrorCode(Map<String, List<String>> map) {
        if (map != null) {
            long parseErrorList = parseErrorList(map.get("x-server-error"));
            if (parseErrorList != -1 && parseErrorList != 0) {
                return parseErrorList;
            }
            long parseErrorList2 = parseErrorList(map.get("x-proxy-error"));
            if (parseErrorList2 != -1) {
                return parseErrorList2 - 20000;
            }
            long parseErrorList3 = parseErrorList(map.get("error"));
            if (parseErrorList3 != -1) {
                return parseErrorList3;
            }
            return VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
        }
        return VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
    }

    public static String getUrlFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Uri.parse(str).getLastPathSegment();
        }
        return null;
    }

    public static String[] getUserProxy() {
        try {
            Object invoke = ConnectivityManager.class.getMethod("getProxy", new Class[0]).invoke((ConnectivityManager) PlayerConfig.g().getAppContext().getSystemService("connectivity"), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return getUserProxy(invoke);
        } catch (NoSuchMethodException | Exception unused) {
            return null;
        }
    }

    public static String getVideoUuidFromVideoUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (isLocalFile(str)) {
            return "local";
        }
        if (isNoProxyUrl(str)) {
            return "noproxy";
        }
        Map<String, String> parseParams = HttpParser.parseParams(str);
        if (parseParams != null && !parseParams.isEmpty()) {
            return parseParams.get("uuid");
        }
        log(6, TAG, "getVideoUuidFromVideoUrl fail " + str);
        return null;
    }

    public static String guessExtension(String str) {
        String fileExtension = OskFile.getFileExtension(getUrlFileName(str));
        if (TextUtils.isEmpty(fileExtension)) {
            return "unknown";
        }
        return fileExtension;
    }

    public static boolean isAssetsUri(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("file:///android_asset")) {
            return true;
        }
        return false;
    }

    public static boolean isContentHtml(byte[] bArr) {
        if (bArr == null || bArr.length <= 100) {
            return false;
        }
        byte[] bArr2 = new byte[100];
        System.arraycopy(bArr, 0, bArr2, 0, 100);
        return new String(bArr2).toLowerCase().replaceAll("\\s", "").contains(htmlMagic);
    }

    public static boolean isHLSStream(String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (sIsHLSStreamCacheMap.containsKey(str)) {
            return sIsHLSStreamCacheMap.get(str).booleanValue();
        }
        try {
            String path = new URL(str).getPath();
            if (!TextUtils.isEmpty(path)) {
                if (path.toLowerCase().endsWith(".m3u8")) {
                    z16 = true;
                }
            }
        } catch (Exception unused) {
            log(5, TAG, "isHLSStream illegal url " + str);
        }
        sIsHLSStreamCacheMap.put(str, Boolean.valueOf(z16));
        return z16;
    }

    public static boolean isIPV4(String str) {
        if (!TextUtils.isEmpty(str)) {
            return IPV4_ADDR_PATTERN.matcher(str).matches();
        }
        return false;
    }

    public static boolean isIPV4Address(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String[] split = str.split("\\.");
                    if (split.length != 4) {
                        return false;
                    }
                    for (String str2 : split) {
                        int parseInt = Integer.parseInt(str2);
                        if (parseInt >= 0 && parseInt <= 255) {
                        }
                        return false;
                    }
                    if (str.endsWith(".")) {
                        return false;
                    }
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static boolean isIPV6(String str) {
        if (TextUtils.isEmpty(str) || count(str, ':') < 2) {
            return false;
        }
        return true;
    }

    public static boolean isLocalFile(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("/") || str.startsWith(HippyBridge.URI_SCHEME_FILE))) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) PlayerConfig.g().getAppContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        log(5, TAG, "isNetworkAvailable cant access ConnectivityManager missing permission?");
        return false;
    }

    public static boolean isNoProxyUrl(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith(VideoManager.getInstance().getLocalServerPrefix())) {
            return true;
        }
        return false;
    }

    public static boolean isOnMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static boolean isRawResourceUri(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://")) {
            return true;
        }
        return false;
    }

    public static boolean isRubbishPhoneMobile() {
        String model = DeviceInfoMonitor.getModel();
        if (!"M040".equals(model) && !"MX4".equals(model) && !"MX4 Pro".equals(model) && !"m2 note".equals(model)) {
            return false;
        }
        return true;
    }

    public static String join(Iterator<String> it, String str) {
        String str2 = "";
        if (it != null) {
            while (it.hasNext()) {
                str2 = str2 + it.next();
                if (it.hasNext()) {
                    str2 = str2 + str;
                }
            }
        }
        return str2;
    }

    public static void log(int i3, String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            log(i3, str, it.next());
        }
    }

    public static String parseDomain(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String authority = new URL(str).getAuthority();
            if (!TextUtils.isEmpty(authority) && (indexOf = authority.indexOf(":")) >= 0 && indexOf < authority.length()) {
                return authority.substring(0, indexOf);
            }
            return authority;
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    private static long parseErrorList(List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str = list.get(0);
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    log(6, TAG, "getSubErrorCode: long string is ill-format");
                    return -1L;
                }
            }
            return -1L;
        }
        return -1L;
    }

    public static int parseM3u8Number(String str) {
        int i3;
        String parseM3u8Option = parseM3u8Option(str);
        if (TextUtils.isEmpty(parseM3u8Option)) {
            return -1;
        }
        try {
            i3 = Integer.parseInt(parseM3u8Option);
        } catch (Exception e16) {
            log(6, TAG, "parseM3u8Number error " + e16);
            i3 = -1;
        }
        if (i3 == -1) {
            try {
                return (int) Float.parseFloat(parseM3u8Option);
            } catch (Exception e17) {
                log(6, TAG, "parseM3u8Number error " + e17);
                return i3;
            }
        }
        return i3;
    }

    public static String parseM3u8Option(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("#") || (indexOf = str.indexOf(":")) == -1) {
            return "";
        }
        String substring = str.substring(indexOf + 1);
        if (str.lastIndexOf(",") != -1) {
            return substring.substring(0, substring.length() - 1);
        }
        return substring;
    }

    public static String parseVideoFileName(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getLastPathSegment();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String parseVideoKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = sVideoKeyCacheMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        VideoKeyGenerator videoKeyGenerator = PlayerConfig.g().getVideoKeyGenerator();
        if (videoKeyGenerator == null) {
            videoKeyGenerator = new DefaultVideoKeyGenerator();
        }
        String generate = videoKeyGenerator.generate(str);
        sVideoKeyCacheMap.put(str, generate);
        return generate;
    }

    public static String probeRealUrl(String str, DNSService dNSService, int i3, String str2) {
        URL url;
        HttpURLConnection httpURLConnection;
        try {
            URL url2 = new URL(str);
            log(4, str2, "probeRealUrl " + url2.toExternalForm());
            boolean z16 = false;
            int i16 = 0;
            while (true) {
                int i17 = i16 + 1;
                if (i16 <= 20) {
                    if (dNSService != null) {
                        try {
                            log(4, str2, "probeRealUrl DnsServiceMode=" + i3);
                            if (i3 == 1) {
                                url = new URL(replaceDomainPrependIp(dNSService, url2.toExternalForm(), 2000L));
                            } else if (i3 == 0) {
                                url = new URL(replaceDomain(dNSService, url2.toExternalForm(), 2000L));
                            } else {
                                log(5, str2, "Unknown DnsServiceOpType: " + i17);
                            }
                            url2 = url;
                        } catch (Exception e16) {
                            log(5, str2, "Caught Exception while probeRealUrl: " + getPrintableStackTrace(e16));
                            return null;
                        }
                    }
                    if (shouldByPassProxySetting(url2)) {
                        httpURLConnection = (HttpURLConnection) url2.openConnection(Proxy.NO_PROXY);
                    } else {
                        httpURLConnection = (HttpURLConnection) url2.openConnection();
                    }
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(12000);
                    httpURLConnection.setDoOutput(z16);
                    httpURLConnection.setInstanceFollowRedirects(z16);
                    httpURLConnection.connect();
                    Object submitTask = ThreadUtils.submitTask(new DefaultHttpDataSource.GetResponseCodeCallable(httpURLConnection), 12000, true, "GetResponseCodeCallable", str2 + ".probeRealUrl");
                    if (submitTask == null) {
                        httpURLConnection.disconnect();
                        log(6, TAG, "getResponseCode Timeout");
                        return null;
                    }
                    int intValue = ((Integer) submitTask).intValue();
                    if (intValue != 300 && intValue != 301 && intValue != 302 && intValue != 303 && intValue != 307 && intValue != 308) {
                        log(4, str2, "probeRealUrl success:sourceUrl=" + str + ",realUrl=" + url2.toExternalForm() + ",redirectCount=" + i17);
                        return url2.toExternalForm();
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    log(4, str2, "probeRealUrl redirectTo=" + headerField);
                    httpURLConnection.disconnect();
                    url2 = DefaultHttpDataSource.handleRedirect(url2, headerField);
                    i16 = i17;
                    z16 = false;
                } else {
                    log(5, str2, "Too many redirects: " + i17);
                    return null;
                }
            }
        } catch (MalformedURLException e17) {
            log(6, str2, "probeRealUrl failed " + e17);
            return null;
        }
    }

    public static String removeLineBreaks(String str, String str2) {
        if (str2 == null) {
            str2 = "|";
        }
        if (str != null) {
            return str.replaceAll("\\r\\n", str2).replaceAll("\\r|\\n", str2);
        }
        return str;
    }

    public static String replaceDomain(DNSService dNSService, String str, long j3) {
        String resolve;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String parseDomain = parseDomain(str);
        if (!TextUtils.isEmpty(parseDomain) && !isIPV4(parseDomain) && !isIPV6(parseDomain)) {
            if (j3 > 0) {
                resolve = dNSService.resolve(parseDomain, j3, TimeUnit.MILLISECONDS);
            } else {
                resolve = dNSService.resolve(parseDomain);
            }
            if (!TextUtils.isEmpty(resolve)) {
                return str.replaceFirst(parseDomain, resolve);
            }
            return str;
        }
        return str;
    }

    public static String replaceDomainPrependIp(DNSService dNSService, String str, long j3) {
        String resolve;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String parseDomain = parseDomain(str);
        if (!TextUtils.isEmpty(parseDomain) && !isIPV4(parseDomain) && !isIPV6(parseDomain)) {
            if (j3 > 0) {
                resolve = dNSService.resolve(parseDomain, j3, TimeUnit.MILLISECONDS);
            } else {
                resolve = dNSService.resolve(parseDomain);
            }
            if (!TextUtils.isEmpty(resolve)) {
                String[] split = str.split(QzoneWebViewOfflinePlugin.STR_DEVIDER);
                if (split.length > 1) {
                    return split[0] + QzoneWebViewOfflinePlugin.STR_DEVIDER + resolve + "/" + split[1];
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static Uri replaceUriParameter(Uri uri, String str, String str2) {
        String queryParameter;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str3 : queryParameterNames) {
            if (str3.equals(str)) {
                queryParameter = str2;
            } else {
                queryParameter = uri.getQueryParameter(str3);
            }
            clearQuery.appendQueryParameter(str3, queryParameter);
        }
        return clearQuery.build();
    }

    public static int rubbishPhoneOffset() {
        String model = DeviceInfoMonitor.getModel();
        if (!"M040".equals(model) && !"MX4".equals(model) && !"m2 note".equals(model)) {
            return 0;
        }
        return 1;
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j3) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j3);
    }

    public static void setH265ReportKeyVersion(int i3) {
        H265_REPORT_KEY_VERSION = i3;
    }

    public static boolean shouldByPassProxySetting(URL url) {
        String str;
        InetAddress inetAddress = null;
        try {
            str = url.getHost();
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        try {
            inetAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused2) {
        }
        if (inetAddress == null) {
            return false;
        }
        if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            return true;
        }
        try {
            if (NetworkInterface.getByInetAddress(inetAddress) == null) {
                return false;
            }
            return true;
        } catch (SocketException unused3) {
            return false;
        }
    }

    public static List<String> splitEqually(String str, int i3) {
        ArrayList arrayList = new ArrayList(((str.length() + i3) - 1) / i3);
        int i16 = 0;
        while (i16 < str.length()) {
            int i17 = i16 + i3;
            arrayList.add(str.substring(i16, Math.min(str.length(), i17)));
            i16 = i17;
        }
        return arrayList;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public static String wrapFileScheme(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
            return "file://" + str;
        }
        return str;
    }

    public static void runOnUiThread(Runnable runnable, int i3) {
        Looper mainLooper = Looper.getMainLooper();
        Handler handler = new Handler(mainLooper);
        if (mainLooper.getThread() != Thread.currentThread()) {
            if (i3 > 0) {
                handler.postDelayed(runnable, i3);
                return;
            } else {
                handler.post(runnable);
                return;
            }
        }
        if (i3 > 0) {
            handler.postDelayed(runnable, i3);
        } else {
            runnable.run();
        }
    }

    public static void log(int i3, String str, String str2) {
        log(i3, str, str2, null);
    }

    public static void log(int i3, String str, String str2, Throwable th5) {
        if (th5 != null) {
            str2 = str2 + ":" + getPrintableStackTrace(th5);
        }
        if (str2.length() > 1000) {
            log(i3, str, splitEqually(str2, 1000));
            return;
        }
        QLog logger = PlayerConfig.g().getLogger();
        if (logger == null) {
            if (i3 == 2) {
                Log.v(str, str2);
                return;
            }
            if (i3 == 3) {
                Log.d(str, str2);
                return;
            }
            if (i3 == 4) {
                Log.i(str, str2);
                return;
            } else if (i3 == 5) {
                Log.w(str, str2);
                return;
            } else {
                if (i3 != 6) {
                    return;
                }
                Log.e(str, str2);
                return;
            }
        }
        if (i3 == 2) {
            logger.v(str, str2);
            return;
        }
        if (i3 == 3) {
            logger.d(str, str2);
            return;
        }
        if (i3 == 4) {
            logger.i(str, str2);
        } else if (i3 == 5) {
            logger.w(str, str2);
        } else {
            if (i3 != 6) {
                return;
            }
            logger.e(str, str2);
        }
    }

    public static int findFreePort() throws IllegalStateException {
        ServerSocket serverSocket;
        Throwable th5;
        ServerSocket serverSocket2 = null;
        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException unused) {
        } catch (Throwable th6) {
            serverSocket = null;
            th5 = th6;
        }
        try {
            try {
                serverSocket.setReuseAddress(true);
                int localPort = serverSocket.getLocalPort();
                try {
                    serverSocket.close();
                } catch (IOException unused2) {
                }
                try {
                    serverSocket.close();
                } catch (IOException unused3) {
                }
                return localPort;
            } catch (Throwable th7) {
                th5 = th7;
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th5;
            }
        } catch (IOException unused5) {
            serverSocket2 = serverSocket;
            if (serverSocket2 != null) {
                try {
                    serverSocket2.close();
                } catch (IOException unused6) {
                }
            }
            throw new IllegalStateException("Could not find a free TCP/IP port to start video proxy");
        }
    }

    public static String join(List<String> list, String str) {
        return list != null ? join(list.iterator(), str) : "";
    }

    private static String[] getUserProxy(Object obj) throws Exception {
        Class<?> cls = Class.forName("android.net.ProxyProperties");
        String[] strArr = {(String) cls.getMethod("getHost", new Class[0]).invoke(obj, new Object[0]), String.valueOf((Integer) cls.getMethod("getPort", new Class[0]).invoke(obj, new Object[0])), (String) cls.getMethod("getExclusionList", new Class[0]).invoke(obj, new Object[0])};
        if (strArr[0] != null) {
            return strArr;
        }
        return null;
    }

    public static String join(List<String> list) {
        return join(list, "|");
    }
}

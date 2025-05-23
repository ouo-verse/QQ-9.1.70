package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.a;
import com.tencent.qzonehub.api.IDataUtils;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.params.BasicHttpParams;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneHttpDownloadUtil extends HttpDownloadUtil {
    public static final int DOWNLOAD_MD5_FAILED = -999;
    private static final String FILE_EXT_JPG_LONG = "jpeg";
    private static final String FILE_EXT_JPG_SHORT = "jpg";
    private static final String FILE_EXT_PNG = "png";
    private static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_PNG = "image/png";
    private static final String MIME_TYPE_SHARPP = "image/sharpp";
    private static final int PHOTO_DECODE_QUALITY = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_OFFLINE_DECODE_PHOTO_QUALITY, 90);
    public static final String TAG = "QZoneHttpDownloadUtil";

    public static boolean download(AppInterface appInterface, String str, File file, String str2, int i3) {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Download failed-----------activeNetworkInfo is null");
            }
            return false;
        }
        try {
            URL url = new URL(getFilterUrl(str));
            int download = download(appInterface, url, file, recentNetworkInfo, 2, str2, i3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str2 + "\nurl = " + url.toString() + "\nRESULT_CODE = " + download);
            }
            return download == 0;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static String encodeFile(String str, boolean z16) {
        byte[] bArr;
        String str2 = "";
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                InputStream inputStream = null;
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                        inputStream = z16 ? new GZIPInputStream(bufferedInputStream) : bufferedInputStream;
                        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                        try {
                            bArr = new byte[16384];
                        } catch (OutOfMemoryError unused) {
                            bArr = new byte[4096];
                        }
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        str2 = byteArrayToHex(messageDigest.digest());
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "encode-Exception:", e16);
                        }
                    }
                    return str2;
                } finally {
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(inputStream);
                }
            }
            QLog.w(TAG, 2, "encode-File does not exist or is not file:" + str);
        }
        return "";
    }

    public static String getFilterUrl(String str) {
        int indexOf;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf("#")) <= -1) ? str : str.substring(0, indexOf);
    }

    public static String getValueByName(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return "";
        }
        String str3 = "";
        for (String str4 : str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1).split("\\&")) {
            if (str4.contains(str2)) {
                str3 = str4.replace(str2 + ContainerUtils.KEY_VALUE_DELIMITER, "");
            }
        }
        return str3;
    }

    public static String sourceFileMd5(String str, boolean z16) {
        String encodeFile = encodeFile(str, z16);
        if (encodeFile != null) {
            return encodeFile.toLowerCase();
        }
        return "";
    }

    private static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            cArr2[i3] = cArr[(b16 >>> 4) & 15];
            i3 = i16 + 1;
            cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr2);
    }

    private static String getHeaderValue(Header[] headerArr, String str) {
        if (str != null && str.length() != 0 && headerArr != null) {
            for (Header header : headerArr) {
                if (header != null && str.equals(header.getName())) {
                    return header.getValue();
                }
            }
        }
        return null;
    }

    private static boolean saveHeadersToFile(Header[] headerArr, File file, String str, HashMap<String, String> hashMap) {
        boolean z16;
        boolean z17;
        if (headerArr == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        if (headerArr.length <= 0) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            z17 = true;
            for (Header header : headerArr) {
                try {
                    String name = header.getName();
                    String value = header.getValue();
                    if (hashMap != null && hashMap.containsKey(name)) {
                        value = hashMap.get(name);
                    }
                    if (!"Date".equalsIgnoreCase(name) && !"Expires".equalsIgnoreCase(name) && !"Last-Modified".equalsIgnoreCase(name) && (!QzoneOfflinePluginJsForQQ.checkDownloadFont(str) || !"Content-Encoding".equalsIgnoreCase(name))) {
                        try {
                            jSONObject.put(name, value);
                            QzoneOfflinePluginJsForQQ.detaillog("saved header: " + name + "->" + value);
                        } catch (JSONException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, e16.getMessage(), e16);
                            }
                            z17 = false;
                        }
                    }
                } catch (FileNotFoundException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        QLog.d(TAG, 1, "FileNotFoundException file exist=" + file.exists() + ", dir exist=" + file.getParentFile().exists());
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
                        return false;
                    } catch (Throwable unused2) {
                        z16 = z17;
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
                        return z16;
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    z16 = z17;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, e.getMessage(), e);
                        }
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
                        return false;
                    } catch (Throwable unused3) {
                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
                        return z16;
                    }
                } catch (Throwable unused4) {
                    fileOutputStream = fileOutputStream2;
                    z16 = z17;
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
                    return z16;
                }
            }
            if (z17) {
                fileOutputStream2.write(jSONObject.toString().getBytes("UTF-8"));
                fileOutputStream2.flush();
                file.setLastModified(System.currentTimeMillis());
            }
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream2);
            return z17;
        } catch (FileNotFoundException unused5) {
            z17 = true;
        } catch (IOException e18) {
            e = e18;
            z16 = true;
        } catch (Throwable unused6) {
            z16 = true;
            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(fileOutputStream);
            return z16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x07f4 A[ADDED_TO_REGION, EDGE_INSN: B:130:0x07f4->B:128:0x07f4 BREAK  A[LOOP:0: B:39:0x00e8->B:126:0x07e6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x072b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x070e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x06f9 A[Catch: all -> 0x07f5, TryCatch #40 {all -> 0x07f5, blocks: (B:187:0x05c4, B:189:0x05ca, B:163:0x0649, B:165:0x064f, B:90:0x06d3, B:92:0x06d9, B:93:0x06f2, B:150:0x06f9, B:152:0x06fd, B:155:0x0702), top: B:186:0x05c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x064f A[Catch: all -> 0x07f5, TRY_LEAVE, TryCatch #40 {all -> 0x07f5, blocks: (B:187:0x05c4, B:189:0x05ca, B:163:0x0649, B:165:0x064f, B:90:0x06d3, B:92:0x06d9, B:93:0x06f2, B:150:0x06f9, B:152:0x06fd, B:155:0x0702), top: B:186:0x05c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x068b A[Catch: Exception -> 0x06c0, TryCatch #56 {Exception -> 0x06c0, blocks: (B:193:0x0600, B:195:0x0606, B:197:0x060c, B:198:0x060f, B:200:0x0615, B:176:0x06bd, B:168:0x0685, B:170:0x068b, B:172:0x0691, B:173:0x0694, B:175:0x069a), top: B:192:0x0600 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x069a A[Catch: Exception -> 0x06c0, TryCatch #56 {Exception -> 0x06c0, blocks: (B:193:0x0600, B:195:0x0606, B:197:0x060c, B:198:0x060f, B:200:0x0615, B:176:0x06bd, B:168:0x0685, B:170:0x068b, B:172:0x0691, B:173:0x0694, B:175:0x069a), top: B:192:0x0600 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x066a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05ca A[Catch: all -> 0x07f5, TRY_LEAVE, TryCatch #40 {all -> 0x07f5, blocks: (B:187:0x05c4, B:189:0x05ca, B:163:0x0649, B:165:0x064f, B:90:0x06d3, B:92:0x06d9, B:93:0x06f2, B:150:0x06f9, B:152:0x06fd, B:155:0x0702), top: B:186:0x05c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0606 A[Catch: Exception -> 0x06c0, TryCatch #56 {Exception -> 0x06c0, blocks: (B:193:0x0600, B:195:0x0606, B:197:0x060c, B:198:0x060f, B:200:0x0615, B:176:0x06bd, B:168:0x0685, B:170:0x068b, B:172:0x0691, B:173:0x0694, B:175:0x069a), top: B:192:0x0600 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0615 A[Catch: Exception -> 0x06c0, TRY_LEAVE, TryCatch #56 {Exception -> 0x06c0, blocks: (B:193:0x0600, B:195:0x0606, B:197:0x060c, B:198:0x060f, B:200:0x0615, B:176:0x06bd, B:168:0x0685, B:170:0x068b, B:172:0x0691, B:173:0x0694, B:175:0x069a), top: B:192:0x0600 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04d7 A[Catch: all -> 0x04ff, Exception -> 0x0501, IOException -> 0x0503, TryCatch #45 {IOException -> 0x0503, Exception -> 0x0501, all -> 0x04ff, blocks: (B:280:0x0442, B:282:0x044b, B:285:0x0462, B:287:0x047a, B:288:0x04d3, B:290:0x04a6, B:317:0x04ac, B:318:0x04b6, B:320:0x04c2, B:236:0x04d7, B:238:0x04e1), top: B:279:0x0442 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0576 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0559 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0165 A[Catch: all -> 0x012f, Exception -> 0x013f, IOException -> 0x014f, TRY_ENTER, TRY_LEAVE, TryCatch #41 {IOException -> 0x014f, Exception -> 0x013f, all -> 0x012f, blocks: (B:436:0x0113, B:48:0x0165), top: B:435:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a1 A[Catch: all -> 0x03d5, Exception -> 0x03d8, IOException -> 0x03db, TRY_LEAVE, TryCatch #37 {IOException -> 0x03db, Exception -> 0x03d8, all -> 0x03d5, blocks: (B:82:0x039b, B:84:0x03a1, B:267:0x0407, B:269:0x0410), top: B:81:0x039b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x06d9 A[Catch: all -> 0x07f5, TryCatch #40 {all -> 0x07f5, blocks: (B:187:0x05c4, B:189:0x05ca, B:163:0x0649, B:165:0x064f, B:90:0x06d3, B:92:0x06d9, B:93:0x06f2, B:150:0x06f9, B:152:0x06fd, B:155:0x0702), top: B:186:0x05c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x06f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int download(AppInterface appInterface, URL url, File file, NetworkInfo networkInfo, int i3, String str, int i16) {
        HttpGet httpGet;
        int i17;
        File file2;
        BufferedOutputStream bufferedOutputStream;
        int i18;
        HttpEntity httpEntity;
        HttpEntity httpEntity2;
        int i19;
        long j3;
        HttpGet httpGet2;
        BasicHttpParams basicHttpParams;
        int i26;
        HttpEntity httpEntity3;
        Throwable th5;
        Exception exc;
        HttpEntity httpEntity4;
        IOException iOException;
        int i27;
        File parentFile;
        String str2;
        String str3;
        int i28;
        HttpEntity httpEntity5;
        int i29;
        File parentFile2;
        int i36;
        int i37;
        int i38;
        String mimeTypeFromUrl;
        HttpEntity httpEntity6;
        long contentLength;
        HttpEntity httpEntity7;
        HttpEntity httpEntity8;
        HashMap hashMap;
        long j16;
        BufferedOutputStream bufferedOutputStream2;
        IOException iOException2;
        long j17;
        FileNotFoundException fileNotFoundException;
        int i39;
        int i46;
        HashMap hashMap2;
        Bitmap.CompressFormat compressFormat;
        String sourceFileMd5;
        File file3 = file;
        String str4 = str;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = new Object();
        if (file3 == null) {
            QLog.d(TAG, 1, "Download. result=DOWNLOAD_SAVE_FILE_FAIL as file == null.");
            return 4;
        }
        int i47 = i3 < 0 ? 2 : i3;
        try {
            File parentFile3 = file.getParentFile();
            if (parentFile3 != null && !parentFile3.exists()) {
                parentFile3.mkdirs();
            }
            String url2 = url.toString();
            String valueByName = getValueByName(url2, "_checkmd5");
            try {
                try {
                    httpGet = new HttpGet(url2);
                } catch (IllegalArgumentException unused) {
                    QLog.d(TAG, 1, "Download. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
                    return 13;
                }
            } catch (IllegalArgumentException unused2) {
                httpGet = new HttpGet(HttpDownloadUtil.getEscapeSequence(url2));
            }
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            int i48 = 20000;
            if (networkInfo != null) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
                if (NetworkUtil.isMobileNetworkInfo(networkInfo) && ((netGetExInfo == null || netGetExInfo.endsWith("wap")) && defaultHost != null && defaultPort > 0)) {
                    basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
                }
                if (NetworkUtil.isMobileNetworkInfo(networkInfo)) {
                    basicHttpParams2.setIntParameter("http.socket.buffer-size", 2048);
                } else {
                    basicHttpParams2.setIntParameter("http.socket.buffer-size", 4096);
                    i48 = 10000;
                    i17 = 30000;
                    basicHttpParams2.setParameter("http.connection.timeout", Integer.valueOf(i48));
                    basicHttpParams2.setParameter("http.socket.timeout", Integer.valueOf(i17));
                    httpGet.setParams(basicHttpParams2);
                    file2 = new File(file.getPath() + FileCacheService.HeaderFileSuffix);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    bufferedOutputStream = null;
                    i18 = -1;
                    httpEntity = null;
                    while (true) {
                        BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                        if (i18 != 0) {
                            httpEntity2 = httpEntity;
                            i19 = i47;
                            basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(url.getHost(), url.getPort()));
                            httpGet.setParams(basicHttpParams2);
                        } else {
                            httpEntity2 = httpEntity;
                            i19 = i47;
                        }
                        try {
                            mimeTypeFromUrl = QzoneOfflinePluginJsForQQ.getMimeTypeFromUrl(url2, i16);
                            if (mimeTypeFromUrl != null) {
                                try {
                                    httpGet.addHeader("Accept", mimeTypeFromUrl);
                                    QzoneOfflinePluginJsForQQ.detaillog("HttpGet addHeader, Accept : " + mimeTypeFromUrl);
                                } catch (IOException e16) {
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity4 = httpEntity2;
                                    iOException = e16;
                                    j3 = currentTimeMillis;
                                    httpGet2 = httpGet;
                                    basicHttpParams = basicHttpParams2;
                                    i26 = i18;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (iOException instanceof UnknownHostException) {
                                    }
                                    if (httpEntity4 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    if (i38 != 0) {
                                    }
                                    HttpEntity httpEntity9 = httpEntity4;
                                    i29 = i38;
                                    httpEntity5 = httpEntity9;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                } catch (Exception e17) {
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity3 = httpEntity2;
                                    exc = e17;
                                    j3 = currentTimeMillis;
                                    httpGet2 = httpGet;
                                    basicHttpParams = basicHttpParams2;
                                    i26 = i18;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (httpEntity3 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    parentFile2 = file.getParentFile();
                                    if (parentFile2 != null) {
                                    }
                                    if (file.exists()) {
                                    }
                                    httpEntity5 = httpEntity3;
                                    i29 = 5;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                } catch (Throwable th6) {
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity3 = httpEntity2;
                                    th5 = th6;
                                    j3 = currentTimeMillis;
                                    httpGet2 = httpGet;
                                    basicHttpParams = basicHttpParams2;
                                    i26 = i18;
                                    i27 = 5;
                                    try {
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        try {
                                            parentFile = file.getParentFile();
                                            if (parentFile != null) {
                                            }
                                            if (file.exists()) {
                                            }
                                        } catch (Exception unused3) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } finally {
                                    }
                                }
                            }
                            if (QzoneOfflinePluginJsForQQ.isSupportGZIP()) {
                                httpGet.addHeader("Accept-Encoding", "gzip");
                            }
                            httpGet.addHeader("Origin", str4);
                            QzoneOfflinePluginJsForQQ.detaillog("HttpGet addHeader, Origin : " + str4);
                            HttpResponse execute = HttpDownloadUtil.CLIENT.execute(new HttpHost(url.getHost()), httpGet);
                            StatusLine statusLine = execute.getStatusLine();
                            Header[] allHeaders = execute.getAllHeaders();
                            HashMap hashMap3 = new HashMap();
                            i29 = statusLine.getStatusCode();
                            HttpEntity entity = execute.getEntity();
                            httpGet2 = httpGet;
                            if (200 != i29) {
                                basicHttpParams = basicHttpParams2;
                                try {
                                    contentLength = entity.getContentLength();
                                    try {
                                        i26 = i18;
                                    } catch (FileNotFoundException e18) {
                                        e = e18;
                                        hashMap = hashMap3;
                                        httpEntity6 = entity;
                                        j16 = contentLength;
                                        i26 = i18;
                                    } catch (IOException e19) {
                                        e = e19;
                                        hashMap = hashMap3;
                                        httpEntity6 = entity;
                                        j16 = contentLength;
                                        i26 = i18;
                                    } catch (Exception e26) {
                                        e = e26;
                                        httpEntity8 = entity;
                                        i26 = i18;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        httpEntity7 = entity;
                                        i26 = i18;
                                    }
                                    try {
                                        BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(file3));
                                        try {
                                            entity.writeTo(bufferedOutputStream4);
                                            bufferedOutputStream4.flush();
                                            httpEntity6 = entity;
                                            bufferedOutputStream2 = bufferedOutputStream4;
                                        } catch (FileNotFoundException e27) {
                                            e = e27;
                                            hashMap = hashMap3;
                                            httpEntity6 = entity;
                                            bufferedOutputStream2 = bufferedOutputStream4;
                                        } catch (IOException e28) {
                                            e = e28;
                                            hashMap = hashMap3;
                                            httpEntity6 = entity;
                                            bufferedOutputStream2 = bufferedOutputStream4;
                                        } catch (Exception e29) {
                                            e = e29;
                                            httpEntity6 = entity;
                                            bufferedOutputStream2 = bufferedOutputStream4;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            httpEntity6 = entity;
                                            bufferedOutputStream2 = bufferedOutputStream4;
                                        }
                                    } catch (FileNotFoundException e36) {
                                        e = e36;
                                        hashMap = hashMap3;
                                        httpEntity6 = entity;
                                        j16 = contentLength;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        fileNotFoundException = e;
                                        j17 = 0;
                                        i39 = 5;
                                        StringBuilder sb5 = new StringBuilder();
                                        int i49 = i39;
                                        sb5.append("FileNotFoundException file exist=");
                                        sb5.append(file.exists());
                                        sb5.append(", dir exist=");
                                        sb5.append(file.getParentFile().exists());
                                        QLog.d(TAG, 1, sb5.toString(), fileNotFoundException);
                                        i27 = i49;
                                        if (j16 > 0) {
                                        }
                                        if (i27 != 0) {
                                        }
                                        i29 = i46;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (httpEntity6 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        if (i29 != 0) {
                                        }
                                        httpEntity5 = httpEntity6;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (IOException e37) {
                                        e = e37;
                                        hashMap = hashMap3;
                                        httpEntity6 = entity;
                                        j16 = contentLength;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        iOException2 = e;
                                        j17 = 0;
                                        i27 = 5;
                                        try {
                                            if (QLog.isColorLevel()) {
                                            }
                                            i27 = 4;
                                            if (j16 > 0) {
                                            }
                                            if (i27 != 0) {
                                            }
                                            i29 = i46;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (httpEntity6 != null) {
                                            }
                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                            if (i29 != 0) {
                                            }
                                            httpEntity5 = httpEntity6;
                                        } catch (IOException e38) {
                                            e = e38;
                                            httpEntity4 = httpEntity6;
                                            iOException = e;
                                            j3 = currentTimeMillis;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (iOException instanceof UnknownHostException) {
                                            }
                                            if (httpEntity4 != null) {
                                            }
                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                            if (i38 != 0) {
                                            }
                                            HttpEntity httpEntity92 = httpEntity4;
                                            i29 = i38;
                                            httpEntity5 = httpEntity92;
                                            i18 = i26 + 1;
                                            if (i29 == 0) {
                                            }
                                            i36 = 2;
                                            if (i29 != 0) {
                                            }
                                            if (i29 != 0) {
                                            }
                                            return i29;
                                        } catch (Exception e39) {
                                            e = e39;
                                            httpEntity3 = httpEntity6;
                                            exc = e;
                                            j3 = currentTimeMillis;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (httpEntity3 != null) {
                                            }
                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                            parentFile2 = file.getParentFile();
                                            if (parentFile2 != null) {
                                            }
                                            if (file.exists()) {
                                            }
                                            httpEntity5 = httpEntity3;
                                            i29 = 5;
                                            i18 = i26 + 1;
                                            if (i29 == 0) {
                                            }
                                            i36 = 2;
                                            if (i29 != 0) {
                                            }
                                            if (i29 != 0) {
                                            }
                                            return i29;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            httpEntity3 = httpEntity6;
                                            th5 = th;
                                            j3 = currentTimeMillis;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (httpEntity3 != null) {
                                            }
                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                            parentFile = file.getParentFile();
                                            if (parentFile != null) {
                                            }
                                            if (file.exists()) {
                                            }
                                            httpEntity5 = httpEntity3;
                                            i29 = 5;
                                            i18 = i26 + 1;
                                            if (i29 == 0) {
                                            }
                                            i36 = 2;
                                            if (i29 != 0) {
                                            }
                                            if (i29 != 0) {
                                            }
                                            return i29;
                                        }
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (Exception e46) {
                                        e = e46;
                                        httpEntity8 = entity;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        httpEntity3 = httpEntity8;
                                        exc = e;
                                        j3 = currentTimeMillis;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile2 = file.getParentFile();
                                        if (parentFile2 != null) {
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        httpEntity7 = entity;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        httpEntity3 = httpEntity7;
                                        th5 = th;
                                        j3 = currentTimeMillis;
                                        i27 = 5;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile = file.getParentFile();
                                        if (parentFile != null) {
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    }
                                } catch (IOException e47) {
                                    e = e47;
                                    j3 = currentTimeMillis;
                                    httpEntity2 = entity;
                                    i26 = i18;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity4 = httpEntity2;
                                    iOException = e;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (iOException instanceof UnknownHostException) {
                                    }
                                    if (httpEntity4 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    if (i38 != 0) {
                                    }
                                    HttpEntity httpEntity922 = httpEntity4;
                                    i29 = i38;
                                    httpEntity5 = httpEntity922;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                } catch (Exception e48) {
                                    e = e48;
                                    j3 = currentTimeMillis;
                                    httpEntity2 = entity;
                                    i26 = i18;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity3 = httpEntity2;
                                    exc = e;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (httpEntity3 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    parentFile2 = file.getParentFile();
                                    if (parentFile2 != null) {
                                    }
                                    if (file.exists()) {
                                    }
                                    httpEntity5 = httpEntity3;
                                    i29 = 5;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                } catch (Throwable th11) {
                                    th = th11;
                                    j3 = currentTimeMillis;
                                    httpEntity2 = entity;
                                    i26 = i18;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    httpEntity3 = httpEntity2;
                                    th5 = th;
                                    i27 = 5;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (httpEntity3 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    parentFile = file.getParentFile();
                                    if (parentFile != null) {
                                    }
                                    if (file.exists()) {
                                    }
                                    httpEntity5 = httpEntity3;
                                    i29 = 5;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                }
                                try {
                                    try {
                                        j17 = file.length();
                                        j16 = contentLength;
                                        try {
                                            file3.setLastModified(System.currentTimeMillis());
                                            if (QLog.isColorLevel()) {
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append("Download success. cost ");
                                                hashMap = hashMap3;
                                                try {
                                                    sb6.append(System.currentTimeMillis() - currentTimeMillis);
                                                    sb6.append(", size is ");
                                                    sb6.append(j17);
                                                    sb6.append(" for ");
                                                    sb6.append(url);
                                                    QLog.i(TAG, 2, sb6.toString());
                                                } catch (FileNotFoundException e49) {
                                                    e = e49;
                                                    fileNotFoundException = e;
                                                    i39 = 5;
                                                    StringBuilder sb52 = new StringBuilder();
                                                    int i492 = i39;
                                                    sb52.append("FileNotFoundException file exist=");
                                                    sb52.append(file.exists());
                                                    sb52.append(", dir exist=");
                                                    sb52.append(file.getParentFile().exists());
                                                    QLog.d(TAG, 1, sb52.toString(), fileNotFoundException);
                                                    i27 = i492;
                                                    if (j16 > 0) {
                                                    }
                                                    if (i27 != 0) {
                                                    }
                                                    i29 = i46;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    if (httpEntity6 != null) {
                                                    }
                                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                    if (i29 != 0) {
                                                    }
                                                    httpEntity5 = httpEntity6;
                                                    i18 = i26 + 1;
                                                    if (i29 == 0) {
                                                    }
                                                    i36 = 2;
                                                    if (i29 != 0) {
                                                    }
                                                    if (i29 != 0) {
                                                    }
                                                    return i29;
                                                } catch (IOException e56) {
                                                    e = e56;
                                                    iOException2 = e;
                                                    i27 = 5;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d(TAG, 2, "\u4fdd\u5b58\u6587\u4ef6\u5931\u8d25", iOException2);
                                                    }
                                                    i27 = 4;
                                                    if (j16 > 0) {
                                                    }
                                                    if (i27 != 0) {
                                                    }
                                                    i29 = i46;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    if (httpEntity6 != null) {
                                                    }
                                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                    if (i29 != 0) {
                                                    }
                                                    httpEntity5 = httpEntity6;
                                                    i18 = i26 + 1;
                                                    if (i29 == 0) {
                                                    }
                                                    i36 = 2;
                                                    if (i29 != 0) {
                                                    }
                                                    if (i29 != 0) {
                                                    }
                                                    return i29;
                                                }
                                            } else {
                                                hashMap = hashMap3;
                                            }
                                        } catch (FileNotFoundException e57) {
                                            e = e57;
                                            hashMap = hashMap3;
                                        } catch (IOException e58) {
                                            e = e58;
                                            hashMap = hashMap3;
                                        }
                                    } catch (Exception e59) {
                                        e = e59;
                                        httpEntity3 = httpEntity6;
                                        exc = e;
                                        j3 = currentTimeMillis;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile2 = file.getParentFile();
                                        if (parentFile2 != null) {
                                            parentFile2.mkdirs();
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        httpEntity3 = httpEntity6;
                                        th5 = th;
                                        j3 = currentTimeMillis;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        i27 = 5;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile = file.getParentFile();
                                        if (parentFile != null) {
                                            parentFile.mkdirs();
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    }
                                } catch (FileNotFoundException e65) {
                                    e = e65;
                                    hashMap = hashMap3;
                                    j16 = contentLength;
                                    fileNotFoundException = e;
                                    j17 = 0;
                                    i39 = 5;
                                    StringBuilder sb522 = new StringBuilder();
                                    int i4922 = i39;
                                    sb522.append("FileNotFoundException file exist=");
                                    sb522.append(file.exists());
                                    sb522.append(", dir exist=");
                                    sb522.append(file.getParentFile().exists());
                                    QLog.d(TAG, 1, sb522.toString(), fileNotFoundException);
                                    i27 = i4922;
                                    if (j16 > 0) {
                                    }
                                    if (i27 != 0) {
                                    }
                                    i29 = i46;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    if (httpEntity6 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    if (i29 != 0) {
                                    }
                                    httpEntity5 = httpEntity6;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                } catch (IOException e66) {
                                    e = e66;
                                    hashMap = hashMap3;
                                    j16 = contentLength;
                                    iOException2 = e;
                                    j17 = 0;
                                    i27 = 5;
                                    if (QLog.isColorLevel()) {
                                    }
                                    i27 = 4;
                                    if (j16 > 0) {
                                    }
                                    if (i27 != 0) {
                                    }
                                    i29 = i46;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    if (httpEntity6 != null) {
                                    }
                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                    if (i29 != 0) {
                                    }
                                    httpEntity5 = httpEntity6;
                                    i18 = i26 + 1;
                                    if (i29 == 0) {
                                    }
                                    i36 = 2;
                                    if (i29 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    return i29;
                                }
                                if (valueByName != null) {
                                    try {
                                    } catch (FileNotFoundException e67) {
                                        fileNotFoundException = e67;
                                        i39 = 0;
                                        StringBuilder sb5222 = new StringBuilder();
                                        int i49222 = i39;
                                        sb5222.append("FileNotFoundException file exist=");
                                        sb5222.append(file.exists());
                                        sb5222.append(", dir exist=");
                                        sb5222.append(file.getParentFile().exists());
                                        QLog.d(TAG, 1, sb5222.toString(), fileNotFoundException);
                                        i27 = i49222;
                                        if (j16 > 0) {
                                        }
                                        if (i27 != 0) {
                                        }
                                        i29 = i46;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (httpEntity6 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        if (i29 != 0) {
                                        }
                                        httpEntity5 = httpEntity6;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (IOException e68) {
                                        iOException2 = e68;
                                        i27 = 0;
                                        if (QLog.isColorLevel()) {
                                        }
                                        i27 = 4;
                                        if (j16 > 0) {
                                        }
                                        if (i27 != 0) {
                                        }
                                        i29 = i46;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (httpEntity6 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        if (i29 != 0) {
                                        }
                                        httpEntity5 = httpEntity6;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (Exception e69) {
                                        httpEntity3 = httpEntity6;
                                        exc = e69;
                                        j3 = currentTimeMillis;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile2 = file.getParentFile();
                                        if (parentFile2 != null) {
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    } catch (Throwable th13) {
                                        httpEntity3 = httpEntity6;
                                        th5 = th13;
                                        j3 = currentTimeMillis;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        i27 = 0;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (httpEntity3 != null) {
                                        }
                                        ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                        parentFile = file.getParentFile();
                                        if (parentFile != null) {
                                        }
                                        if (file.exists()) {
                                        }
                                        httpEntity5 = httpEntity3;
                                        i29 = 5;
                                        i18 = i26 + 1;
                                        if (i29 == 0) {
                                        }
                                        i36 = 2;
                                        if (i29 != 0) {
                                        }
                                        if (i29 != 0) {
                                        }
                                        return i29;
                                    }
                                    if (valueByName.length() != 0 && (sourceFileMd5 = sourceFileMd5(file.getAbsolutePath(), "gzip".equalsIgnoreCase(getHeaderValue(allHeaders, "Content-Encoding")))) != null && !sourceFileMd5.equals(valueByName)) {
                                        QLog.w(TAG, 2, "MD5 check failed !! input=" + url2 + " ,md5 should be=" + sourceFileMd5);
                                        i27 = -999;
                                        if (j16 > 0 && j17 < j16) {
                                            try {
                                                if (QLog.isColorLevel()) {
                                                    QLog.w(TAG, 2, "Download fail. contentLen=" + j16 + ", fileLen=" + file.length() + ", url=" + url);
                                                }
                                                i27 = 8;
                                            } catch (IOException e75) {
                                                e = e75;
                                                httpEntity4 = httpEntity6;
                                                iOException = e;
                                                j3 = currentTimeMillis;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (iOException instanceof UnknownHostException) {
                                                }
                                                if (httpEntity4 != null) {
                                                }
                                                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                if (i38 != 0) {
                                                }
                                                HttpEntity httpEntity9222 = httpEntity4;
                                                i29 = i38;
                                                httpEntity5 = httpEntity9222;
                                                i18 = i26 + 1;
                                                if (i29 == 0) {
                                                }
                                                i36 = 2;
                                                if (i29 != 0) {
                                                }
                                                if (i29 != 0) {
                                                }
                                                return i29;
                                            } catch (Exception e76) {
                                                e = e76;
                                                httpEntity3 = httpEntity6;
                                                exc = e;
                                                j3 = currentTimeMillis;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity3 != null) {
                                                }
                                                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                parentFile2 = file.getParentFile();
                                                if (parentFile2 != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                httpEntity5 = httpEntity3;
                                                i29 = 5;
                                                i18 = i26 + 1;
                                                if (i29 == 0) {
                                                }
                                                i36 = 2;
                                                if (i29 != 0) {
                                                }
                                                if (i29 != 0) {
                                                }
                                                return i29;
                                            } catch (Throwable th14) {
                                                th = th14;
                                                httpEntity3 = httpEntity6;
                                                th5 = th;
                                                j3 = currentTimeMillis;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity3 != null) {
                                                }
                                                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                parentFile = file.getParentFile();
                                                if (parentFile != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                httpEntity5 = httpEntity3;
                                                i29 = 5;
                                                i18 = i26 + 1;
                                                if (i29 == 0) {
                                                }
                                                i36 = 2;
                                                if (i29 != 0) {
                                                }
                                                if (i29 != 0) {
                                                }
                                                return i29;
                                            }
                                        }
                                        if (i27 != 0) {
                                            try {
                                                if ("image/sharpp".equals(getHeaderValue(allHeaders, "Content-Type"))) {
                                                    if (a.b(BaseApplication.getContext())) {
                                                        String fileExt = QzoneOfflinePluginJsForQQ.getFileExt(url2);
                                                        if ("jpg".equals(fileExt) || "jpeg".equals(fileExt) || "png".equals(fileExt)) {
                                                            String absolutePath = file.getAbsolutePath();
                                                            File h16 = a.h(file);
                                                            Bitmap decodeSharpPByFilePath = SharpPUtil.decodeSharpPByFilePath(h16.getAbsolutePath());
                                                            File file4 = new File(absolutePath);
                                                            if (decodeSharpPByFilePath != null) {
                                                                i46 = i27;
                                                                try {
                                                                    if ("png".equals(fileExt)) {
                                                                        try {
                                                                            compressFormat = Bitmap.CompressFormat.PNG;
                                                                        } catch (IOException e77) {
                                                                            e = e77;
                                                                            httpEntity4 = httpEntity6;
                                                                            iOException = e;
                                                                            j3 = currentTimeMillis;
                                                                            bufferedOutputStream = bufferedOutputStream2;
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.d(TAG, 2, "Download fail 1. url=" + url, iOException);
                                                                            }
                                                                            if (iOException instanceof UnknownHostException) {
                                                                                if (!(iOException instanceof ConnectTimeoutException) && !(iOException instanceof SocketTimeoutException)) {
                                                                                    i38 = iOException instanceof SocketException ? 11 : 4;
                                                                                }
                                                                                i38 = 2;
                                                                            } else {
                                                                                i38 = 10;
                                                                            }
                                                                            if (httpEntity4 != null) {
                                                                                try {
                                                                                    httpEntity4.consumeContent();
                                                                                } catch (IOException e78) {
                                                                                    QLog.w(TAG, 1, "entity.consumeContent error", e78);
                                                                                }
                                                                            }
                                                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                            if (i38 != 0) {
                                                                                try {
                                                                                    File parentFile4 = file.getParentFile();
                                                                                    if (parentFile4 != null && !parentFile4.exists()) {
                                                                                        parentFile4.mkdirs();
                                                                                    }
                                                                                    if (file.exists()) {
                                                                                        QLog.d(TAG, 1, "delete file in finally: " + file.delete() + "url = " + url2);
                                                                                    }
                                                                                } catch (Exception unused4) {
                                                                                }
                                                                            }
                                                                            HttpEntity httpEntity92222 = httpEntity4;
                                                                            i29 = i38;
                                                                            httpEntity5 = httpEntity92222;
                                                                            i18 = i26 + 1;
                                                                            if (i29 == 0) {
                                                                            }
                                                                            i36 = 2;
                                                                            if (i29 != 0) {
                                                                            }
                                                                            if (i29 != 0) {
                                                                            }
                                                                            return i29;
                                                                        } catch (Exception e79) {
                                                                            e = e79;
                                                                            httpEntity3 = httpEntity6;
                                                                            exc = e;
                                                                            j3 = currentTimeMillis;
                                                                            bufferedOutputStream = bufferedOutputStream2;
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.d(TAG, 2, "Download fail 2. url=" + url, exc);
                                                                            }
                                                                            if (httpEntity3 != null) {
                                                                                try {
                                                                                    httpEntity3.consumeContent();
                                                                                } catch (IOException e85) {
                                                                                    QLog.w(TAG, 1, "entity.consumeContent error", e85);
                                                                                }
                                                                            }
                                                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                            parentFile2 = file.getParentFile();
                                                                            if (parentFile2 != null && !parentFile2.exists()) {
                                                                                parentFile2.mkdirs();
                                                                            }
                                                                            if (file.exists()) {
                                                                                boolean delete = file.delete();
                                                                                str2 = TAG;
                                                                                str3 = "delete file in finally: " + delete + "url = " + url2;
                                                                                i28 = 1;
                                                                                QLog.d(str2, i28, str3);
                                                                            }
                                                                            httpEntity5 = httpEntity3;
                                                                            i29 = 5;
                                                                            i18 = i26 + 1;
                                                                            if (i29 == 0) {
                                                                            }
                                                                            i36 = 2;
                                                                            if (i29 != 0) {
                                                                            }
                                                                            if (i29 != 0) {
                                                                            }
                                                                            return i29;
                                                                        } catch (Throwable th15) {
                                                                            th = th15;
                                                                            i27 = i46;
                                                                            httpEntity3 = httpEntity6;
                                                                            th5 = th;
                                                                            j3 = currentTimeMillis;
                                                                            bufferedOutputStream = bufferedOutputStream2;
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.e(TAG, 2, "Download fail 2. url=" + url, th5);
                                                                            }
                                                                            if (httpEntity3 != null) {
                                                                                try {
                                                                                    httpEntity3.consumeContent();
                                                                                } catch (IOException e86) {
                                                                                    QLog.w(TAG, 1, "entity.consumeContent error", e86);
                                                                                }
                                                                            }
                                                                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                            parentFile = file.getParentFile();
                                                                            if (parentFile != null && !parentFile.exists()) {
                                                                                parentFile.mkdirs();
                                                                            }
                                                                            if (file.exists()) {
                                                                                boolean delete2 = file.delete();
                                                                                str2 = TAG;
                                                                                str3 = "delete file in finally: " + delete2 + "url = " + url2;
                                                                                i28 = 1;
                                                                                QLog.d(str2, i28, str3);
                                                                            }
                                                                            httpEntity5 = httpEntity3;
                                                                            i29 = 5;
                                                                            i18 = i26 + 1;
                                                                            if (i29 == 0) {
                                                                            }
                                                                            i36 = 2;
                                                                            if (i29 != 0) {
                                                                            }
                                                                            if (i29 != 0) {
                                                                            }
                                                                            return i29;
                                                                        }
                                                                    } else {
                                                                        compressFormat = Bitmap.CompressFormat.JPEG;
                                                                    }
                                                                    j3 = currentTimeMillis;
                                                                } catch (IOException e87) {
                                                                    e = e87;
                                                                    j3 = currentTimeMillis;
                                                                } catch (Exception e88) {
                                                                    e = e88;
                                                                    j3 = currentTimeMillis;
                                                                } catch (Throwable th16) {
                                                                    th = th16;
                                                                    j3 = currentTimeMillis;
                                                                }
                                                                try {
                                                                    if (PhotoUtils.saveBitmapToFile(decodeSharpPByFilePath, absolutePath, compressFormat, PHOTO_DECODE_QUALITY, true)) {
                                                                        FileUtils.deleteFile(h16);
                                                                        long length = file4.length();
                                                                        hashMap2 = hashMap;
                                                                        hashMap2.put("Content-Type", "png".equals(fileExt) ? "image/png" : "image/jpeg");
                                                                        hashMap2.put("Content-Length", String.valueOf(length));
                                                                        if (QLog.isDevelopLevel()) {
                                                                            QLog.i(TAG, 4, "sharpp\u8f6c\u6362\u4e3ajpg/png\u6210\u529f, \u6587\u4ef6\u957f\u5ea6=" + length + JefsClass.INDEX_URL + url + " ,path=" + absolutePath);
                                                                        }
                                                                    } else {
                                                                        hashMap2 = hashMap;
                                                                        h16.renameTo(file4);
                                                                    }
                                                                } catch (IOException e89) {
                                                                    e = e89;
                                                                    httpEntity4 = httpEntity6;
                                                                    iOException = e;
                                                                    bufferedOutputStream = bufferedOutputStream2;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (iOException instanceof UnknownHostException) {
                                                                    }
                                                                    if (httpEntity4 != null) {
                                                                    }
                                                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                    if (i38 != 0) {
                                                                    }
                                                                    HttpEntity httpEntity922222 = httpEntity4;
                                                                    i29 = i38;
                                                                    httpEntity5 = httpEntity922222;
                                                                    i18 = i26 + 1;
                                                                    if (i29 == 0) {
                                                                    }
                                                                    i36 = 2;
                                                                    if (i29 != 0) {
                                                                    }
                                                                    if (i29 != 0) {
                                                                    }
                                                                    return i29;
                                                                } catch (Exception e95) {
                                                                    e = e95;
                                                                    httpEntity3 = httpEntity6;
                                                                    exc = e;
                                                                    bufferedOutputStream = bufferedOutputStream2;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (httpEntity3 != null) {
                                                                    }
                                                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                    parentFile2 = file.getParentFile();
                                                                    if (parentFile2 != null) {
                                                                    }
                                                                    if (file.exists()) {
                                                                    }
                                                                    httpEntity5 = httpEntity3;
                                                                    i29 = 5;
                                                                    i18 = i26 + 1;
                                                                    if (i29 == 0) {
                                                                    }
                                                                    i36 = 2;
                                                                    if (i29 != 0) {
                                                                    }
                                                                    if (i29 != 0) {
                                                                    }
                                                                    return i29;
                                                                } catch (Throwable th17) {
                                                                    th = th17;
                                                                    i27 = i46;
                                                                    httpEntity3 = httpEntity6;
                                                                    th5 = th;
                                                                    bufferedOutputStream = bufferedOutputStream2;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (httpEntity3 != null) {
                                                                    }
                                                                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                                                                    parentFile = file.getParentFile();
                                                                    if (parentFile != null) {
                                                                    }
                                                                    if (file.exists()) {
                                                                    }
                                                                    httpEntity5 = httpEntity3;
                                                                    i29 = 5;
                                                                    i18 = i26 + 1;
                                                                    if (i29 == 0) {
                                                                    }
                                                                    i36 = 2;
                                                                    if (i29 != 0) {
                                                                    }
                                                                    if (i29 != 0) {
                                                                    }
                                                                    return i29;
                                                                }
                                                            } else {
                                                                i46 = i27;
                                                                j3 = currentTimeMillis;
                                                                hashMap2 = hashMap;
                                                                h16.renameTo(file4);
                                                            }
                                                        }
                                                    } else {
                                                        i46 = i27;
                                                        j3 = currentTimeMillis;
                                                        hashMap2 = hashMap;
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.i(TAG, 4, "\u4e0d\u652f\u6301sharpp\u89e3\u7801");
                                                        }
                                                    }
                                                    saveHeadersToFile(allHeaders, file2, url2, hashMap2);
                                                }
                                                i46 = i27;
                                                j3 = currentTimeMillis;
                                                hashMap2 = hashMap;
                                                saveHeadersToFile(allHeaders, file2, url2, hashMap2);
                                            } catch (IOException e96) {
                                                e = e96;
                                                j3 = currentTimeMillis;
                                            } catch (Exception e97) {
                                                e = e97;
                                                j3 = currentTimeMillis;
                                            } catch (Throwable th18) {
                                                th = th18;
                                                j3 = currentTimeMillis;
                                            }
                                        } else {
                                            i46 = i27;
                                            j3 = currentTimeMillis;
                                            if (QLog.isColorLevel()) {
                                                QLog.d(TAG, 2, "\u4e0b\u8f7d\u5931\u8d25\uff0c\u4e0d\u5199\u5165header\u6587\u4ef6. url=" + url);
                                            }
                                        }
                                        i29 = i46;
                                        bufferedOutputStream = bufferedOutputStream2;
                                    }
                                }
                                i27 = 0;
                                if (j16 > 0) {
                                    if (QLog.isColorLevel()) {
                                    }
                                    i27 = 8;
                                }
                                if (i27 != 0) {
                                }
                                i29 = i46;
                                bufferedOutputStream = bufferedOutputStream2;
                            } else {
                                j3 = currentTimeMillis;
                                httpEntity6 = entity;
                                basicHttpParams = basicHttpParams2;
                                i26 = i18;
                                bufferedOutputStream = bufferedOutputStream3;
                            }
                            if (httpEntity6 != null) {
                                try {
                                    httpEntity6.consumeContent();
                                } catch (IOException e98) {
                                    QLog.w(TAG, 1, "entity.consumeContent error", e98);
                                }
                            }
                            ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                            if (i29 != 0) {
                                try {
                                    File parentFile5 = file.getParentFile();
                                    if (parentFile5 != null && !parentFile5.exists()) {
                                        parentFile5.mkdirs();
                                    }
                                    if (file.exists()) {
                                        QLog.d(TAG, 1, "delete file in finally: " + file.delete() + "url = " + url2);
                                    }
                                } catch (Exception unused5) {
                                }
                            }
                            httpEntity5 = httpEntity6;
                        } catch (IOException e99) {
                            e = e99;
                            j3 = currentTimeMillis;
                            httpGet2 = httpGet;
                            basicHttpParams = basicHttpParams2;
                        } catch (Exception e100) {
                            e = e100;
                            j3 = currentTimeMillis;
                            httpGet2 = httpGet;
                            basicHttpParams = basicHttpParams2;
                        } catch (Throwable th19) {
                            th = th19;
                            j3 = currentTimeMillis;
                            httpGet2 = httpGet;
                            basicHttpParams = basicHttpParams2;
                        }
                        i18 = i26 + 1;
                        if (i29 == 0) {
                            QLog.w(TAG, 1, "Download. result=" + i29 + ", url=" + url + ", tryCount=" + i18);
                        } else if (QLog.isColorLevel()) {
                            i36 = 2;
                            QLog.d(TAG, 2, "Download. result=" + i29 + ", url=" + url);
                            if (i29 != 0 && i29 != -999 && i18 < i36) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(500L);
                                    } catch (InterruptedException unused6) {
                                    }
                                }
                            }
                            if (i29 != 0 || i29 == -999 || i18 >= (i37 = i19)) {
                                break;
                            }
                            httpEntity = httpEntity5;
                            i47 = i37;
                            httpGet = httpGet2;
                            basicHttpParams2 = basicHttpParams;
                            currentTimeMillis = j3;
                            file3 = file;
                            str4 = str;
                        }
                        i36 = 2;
                        if (i29 != 0) {
                            synchronized (obj) {
                            }
                        }
                        if (i29 != 0) {
                            break;
                        }
                        break;
                    }
                    return i29;
                }
            }
            i17 = 60000;
            basicHttpParams2.setParameter("http.connection.timeout", Integer.valueOf(i48));
            basicHttpParams2.setParameter("http.socket.timeout", Integer.valueOf(i17));
            httpGet.setParams(basicHttpParams2);
            file2 = new File(file.getPath() + FileCacheService.HeaderFileSuffix);
            if (file.exists()) {
            }
            if (file2.exists()) {
            }
            bufferedOutputStream = null;
            i18 = -1;
            httpEntity = null;
            while (true) {
                BufferedOutputStream bufferedOutputStream32 = bufferedOutputStream;
                if (i18 != 0) {
                }
                mimeTypeFromUrl = QzoneOfflinePluginJsForQQ.getMimeTypeFromUrl(url2, i16);
                if (mimeTypeFromUrl != null) {
                }
                if (QzoneOfflinePluginJsForQQ.isSupportGZIP()) {
                }
                httpGet.addHeader("Origin", str4);
                QzoneOfflinePluginJsForQQ.detaillog("HttpGet addHeader, Origin : " + str4);
                HttpResponse execute2 = HttpDownloadUtil.CLIENT.execute(new HttpHost(url.getHost()), httpGet);
                StatusLine statusLine2 = execute2.getStatusLine();
                Header[] allHeaders2 = execute2.getAllHeaders();
                HashMap hashMap32 = new HashMap();
                i29 = statusLine2.getStatusCode();
                HttpEntity entity2 = execute2.getEntity();
                httpGet2 = httpGet;
                if (200 != i29) {
                }
                if (httpEntity6 != null) {
                }
                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedOutputStream);
                if (i29 != 0) {
                }
                httpEntity5 = httpEntity6;
                i18 = i26 + 1;
                if (i29 == 0) {
                }
                i36 = 2;
                if (i29 != 0) {
                }
                if (i29 != 0) {
                }
                httpEntity = httpEntity5;
                i47 = i37;
                httpGet = httpGet2;
                basicHttpParams2 = basicHttpParams;
                currentTimeMillis = j3;
                file3 = file;
                str4 = str;
            }
            return i29;
        } catch (Exception unused7) {
            QLog.d(TAG, 1, "Download. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
            return 4;
        }
    }
}

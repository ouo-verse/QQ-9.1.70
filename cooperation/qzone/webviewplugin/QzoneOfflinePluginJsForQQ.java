package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.image.ImageConsts;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.webso.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.font.FontManager;
import cooperation.qzone.util.QzoneBanApkDownloadHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneOfflinePluginJsForQQ extends QzoneInternalWebViewPlugin {
    public static final boolean DEBUG_OFFLINE = false;
    private static final int INPUTSTREAM_BUFFER_SIZE;
    public static final int MIN_VERSON_SUPPORT_SHARPP = 36521;
    private static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST_DEFAULT = "{'html':'text/html','css':'text/css','js':'application/javascript','jpg':'image/jpeg','jpeg':'image/jpeg','png':'image/png','bmp':'image/bmp','image':'image','webp':'image/webp'}";
    private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP_DEFAULT = 1;
    private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP_DEFAULT = 1;
    private static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST_DEFAULT = ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn";
    private static final String TAG = "QzoneOfflinePluginJsForQQ";
    private static final boolean gEnalbeQzoneOffline;
    private static String gOfflineDomainWhiteList;
    public static WeakReference<Activity> mActivity;
    public static WeakReference<CustomWebView> mWebView;

    static {
        gEnalbeQzoneOffline = 1 == QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_KEY_OFFLINE_ENABLE, 1);
        INPUTSTREAM_BUFFER_SIZE = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_KEY_OFFLINE_CACHE_BUFFER_SIZE, 16384);
        gOfflineDomainWhiteList = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_KEY_OFFLINE_CACHE_WHITELIST, SECONDARY_KEY_OFFLINE_CACHE_WHITELIST_DEFAULT);
    }

    public static boolean checkDownloadFont(String str) {
        if (TextUtils.isEmpty(str) || !(str.contains("?_offline=1") || str.contains("&_offline=1"))) {
            return false;
        }
        return str.contains("&fontId=") || str.contains("?fontId=");
    }

    public static boolean checkOfflineUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((!str.contains("?_offline=1") && !str.contains("&_offline=1")) || checkDownloadFont(str) || !gEnalbeQzoneOffline) {
            return false;
        }
        if (str.contains("_proxy=") && (str.contains("?_proxy=1") || str.contains("&_proxy=1") || str.contains("?_proxy=true") || str.contains("&_proxy=true"))) {
            return false;
        }
        boolean isDomainInWhiteList = isDomainInWhiteList(getDomain(str));
        if (isDomainInWhiteList) {
            detaillog("\u8d70offline url=" + str);
        }
        return isDomainInWhiteList;
    }

    private static void devlog(String str) {
        if (!QLog.isDevelopLevel() || TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i(TAG, 4, str);
    }

    private static HashMap<String, String> getConfigExtMap() {
        return jsonString2Map(QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST, SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST_DEFAULT));
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getFileExt(String str) {
        int lastIndexOf;
        String[] split;
        try {
            URL url = new URL(str);
            String query = url.getQuery();
            if (query != null && (split = query.split(ContainerUtils.FIELD_DELIMITER)) != null) {
                for (String str2 : split) {
                    int indexOf = str2.indexOf(61);
                    if (indexOf > 0 && indexOf < str2.length() - 1 && "_fileExt".equalsIgnoreCase(str2.substring(0, indexOf))) {
                        return str2.substring(indexOf + 1);
                    }
                }
            }
            String path = url.getPath();
            if (path == null || (lastIndexOf = path.lastIndexOf(".")) < 0 || lastIndexOf >= path.length() - 1) {
                return null;
            }
            return path.substring(lastIndexOf + 1);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMimeTypeFromUrl(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = i3 > 36521;
        boolean z17 = i3 > 0;
        boolean isSupportWebpAndSharpp = isSupportWebpAndSharpp();
        if (checkOfflineUrl(str)) {
            HashMap<String, String> configExtMap = getConfigExtMap();
            String fileExt = getFileExt(str);
            if (configExtMap != null && configExtMap.containsKey(fileExt)) {
                sb5.append(configExtMap.get(fileExt));
            }
        } else if (checkDownloadFont(str)) {
            sb5.append("application/octet-stream");
        }
        String sb6 = sb5.toString();
        if (sb6 != null && sb6.startsWith("image")) {
            if (isSupportWebpAndSharpp && z17 && !sb6.contains("webp")) {
                sb5.append(",");
                sb5.append("image/webp");
            }
            if (isSupportWebpAndSharpp && z16 && !sb6.contains("sharpp")) {
                sb5.append(",");
                sb5.append(ImageConsts.IMAGE_TYPE_SHARPP);
            }
            sb5.append(",");
            sb5.append("image/*");
            sb5.append(",");
            sb5.append("*/*");
        }
        return sb5.toString();
    }

    private static Object interceptDownloadFontRequest(String str) {
        int fontIdByUrl = getFontIdByUrl(str);
        if (fontIdByUrl > 0) {
            String trueTypeFont = FontManager.getInstance().getTrueTypeFont(fontIdByUrl, str, null, true, null);
            if (!TextUtils.isEmpty(trueTypeFont)) {
                File file = new File(trueTypeFont);
                if (!file.exists()) {
                    QLog.e(TAG, 1, "getResponse local file not exists :" + trueTypeFont);
                    return null;
                }
                try {
                    WebResourceResponse webResourceResponse = new WebResourceResponse("application/octet-stream", "utf-8", new FileInputStream(trueTypeFont));
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, String.format("[SUCC] get offline cache,url : %s,mineType : %s", str, "application/octet-stream"));
                    }
                    HashMap<String, String> cacheHeadersOfFile = getCacheHeadersOfFile(file);
                    if (cacheHeadersOfFile != null) {
                        webResourceResponse.setResponseHeaders(cacheHeadersOfFile);
                    }
                    return webResourceResponse;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "interceptDownloadFontRequest Exception: " + e16);
                }
            }
        }
        QLog.e(TAG, 1, "[FAIL] interceptDownloadFontRequest fontId: +" + fontIdByUrl + ",url : " + str);
        return null;
    }

    public static boolean isSupportGZIP() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP, 1) > 0;
    }

    public static boolean isSupportWebpAndSharpp() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP, 1) > 0;
    }

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available() + 1];
                    fileInputStream2.read(bArr);
                    String str = new String(bArr, "UTF-8");
                    fileInputStream2.close();
                    return str;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                }
            } catch (Throwable unused2) {
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static Object shouldInterceptRequest(AppInterface appInterface, WebView webView, String str, String str2) {
        File downLoadFileIfNeeded;
        boolean z16;
        WebResourceResponse webResourceResponse;
        if (webView != null && WebSoPlugin.A(webView) && e.E(str) && !checkOfflineUrl(str) && !checkDownloadFont(str)) {
            int i3 = WebSoPlugin.E;
            Object tag = webView.getTag(i3);
            int i16 = WebSoPlugin.F;
            Object tag2 = webView.getTag(i16);
            if (tag instanceof String) {
                String str3 = (String) tag;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(str3.getBytes("UTF-8")), INPUTSTREAM_BUFFER_SIZE);
                        webView.setTag(i3, null);
                        webView.setTag(i16, null);
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "UTF-8", bufferedInputStream);
                        if (QLog.isColorLevel()) {
                            QLog.i("WebSo", 2, "webview use WebSo! url: " + str + " , time cost=" + (System.currentTimeMillis() - ((tag2 == null || !(tag2 instanceof Long)) ? 0L : ((Long) tag2).longValue())));
                        }
                        return webResourceResponse2;
                    } catch (Throwable th5) {
                        QLog.w(TAG, 1, "get buffer input stream fail", th5);
                        return null;
                    }
                }
            }
        }
        if (checkOfflineUrl(str)) {
            HashMap<String, String> configExtMap = getConfigExtMap();
            String fileExt = getFileExt(str);
            String str4 = (configExtMap == null || !configExtMap.containsKey(fileExt)) ? null : configExtMap.get(fileExt);
            if (str4 != null && str4.length() != 0) {
                if (QzoneZipCacheHelper.checkDownloadZip(str)) {
                    downLoadFileIfNeeded = QzoneZipCacheHelper.getFileIfExists(appInterface, str);
                } else {
                    downLoadFileIfNeeded = QzoneOfflineCacheHelper.downLoadFileIfNeeded(appInterface, str, null, true, str2);
                }
                if (downLoadFileIfNeeded != null && downLoadFileIfNeeded.exists()) {
                    HashMap<String, String> cacheHeadersOfFile = getCacheHeadersOfFile(downLoadFileIfNeeded);
                    if (cacheHeadersOfFile != null && cacheHeadersOfFile.get("Content-Type") != null) {
                        str4 = cacheHeadersOfFile.get("Content-Type");
                        detaillog("Use real Content-Type header as MIME type: " + str4);
                    }
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(downLoadFileIfNeeded), INPUTSTREAM_BUFFER_SIZE);
                        if (cacheHeadersOfFile == null || !"gzip".equalsIgnoreCase(cacheHeadersOfFile.get("Content-Encoding"))) {
                            z16 = false;
                        } else {
                            if (!isSupportGZIP()) {
                                ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedInputStream2);
                                return null;
                            }
                            cacheHeadersOfFile.remove("Content-Encoding");
                            detaillog("make gzip inputstream");
                            z16 = true;
                        }
                        if (z16) {
                            webResourceResponse = new WebResourceResponse(str4, "utf-8", new GZIPInputStream(bufferedInputStream2));
                        } else {
                            webResourceResponse = new WebResourceResponse(str4, "utf-8", bufferedInputStream2);
                        }
                        detaillog(String.format("[SUCC] get offline cache,url:%s ,minetype:%s", str, str4));
                        if (cacheHeadersOfFile != null) {
                            webResourceResponse.setResponseHeaders(cacheHeadersOfFile);
                        }
                        return webResourceResponse;
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "shouldInterceptRequest Exception: " + e16);
                    }
                } else {
                    devlog(String.format("not get offline cache,start download,url:%s ,minetype:%s", str, str4));
                    return null;
                }
            } else {
                devlog(String.format("not support this ext,url:%s ,minetype:%s", str, str4));
                return null;
            }
        } else {
            if (checkDownloadFont(str)) {
                return interceptDownloadFontRequest(str);
            }
            if (QzoneBanApkDownloadHelper.isDomainInBlackList(str2) && QzoneBanApkDownloadHelper.isUrlMatchQzoneCallAppUrlList(str)) {
                return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
            }
            detaillog(String.format("not get offline cache,not offline,url:%s", str));
        }
        return null;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        return false;
    }

    private static int getFontIdByUrl(String str) {
        String query;
        try {
            query = new URL(str).getQuery();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
        if (TextUtils.isEmpty(query)) {
            return 0;
        }
        for (String str2 : query.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(61);
            if (indexOf > 0 && indexOf < str2.length() - 1 && MessageForRichState.SIGN_MSG_FONT_ID.equalsIgnoreCase(str2.substring(0, indexOf))) {
                return Integer.parseInt(str2.substring(indexOf + 1));
            }
        }
        return 0;
    }

    public static boolean isDomainInWhiteList(String str) {
        String str2;
        if (str != null && str.length() != 0 && (str2 = gOfflineDomainWhiteList) != null && str2.length() != 0) {
            for (String str3 : str2.split(",")) {
                if (str3 != null) {
                    String trim = str3.trim();
                    if (trim.startsWith(".")) {
                        if (str.endsWith(trim)) {
                            return true;
                        }
                    } else if (str.equals(trim)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static HashMap<String, String> jsonString2Map(String str) {
        String optString;
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                if (keys != null && keys.hasNext()) {
                    HashMap<String, String> hashMap = null;
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (str2 != null && (optString = jSONObject.optString(str2)) != null) {
                            if (hashMap == null) {
                                hashMap = new HashMap<>();
                            }
                            hashMap.put(str2, optString);
                        }
                    }
                    return hashMap;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static HashMap<String, String> getCacheHeadersOfFile(File file) {
        if (file == null) {
            return null;
        }
        String str = file.getPath() + FileCacheService.HeaderFileSuffix;
        detaillog("> getCacheHeadersOfFile: " + str);
        File file2 = new File(str);
        if (file2.exists()) {
            try {
                return jsonString2Map(readFile(file2));
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        detaillog("> getCacheHeadersOfFile: return null");
        return null;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public Object handleEvent(String str, long j3) {
        AppInterface appInterface;
        WebViewPlugin.b bVar;
        WebViewPlugin.b bVar2;
        if (j3 != 8) {
            return null;
        }
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || (bVar2 = webViewPlugin.mRuntime) == null) {
            appInterface = null;
        } else {
            appInterface = bVar2.b();
            mWebView = new WeakReference<>(this.parentPlugin.mRuntime.e());
            mActivity = new WeakReference<>(this.parentPlugin.mRuntime.a());
        }
        WebViewPlugin webViewPlugin2 = this.parentPlugin;
        Activity a16 = (webViewPlugin2 == null || (bVar = webViewPlugin2.mRuntime) == null) ? null : bVar.a();
        Intent intent = a16 != null ? a16.getIntent() : null;
        String stringExtra = intent != null ? intent.getStringExtra("url") : null;
        WeakReference<CustomWebView> weakReference = mWebView;
        return shouldInterceptRequest(appInterface, weakReference != null ? weakReference.get() : null, str, stringExtra);
    }

    public static void detaillog(String str) {
    }
}

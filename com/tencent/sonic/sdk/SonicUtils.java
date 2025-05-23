package com.tencent.sonic.sdk;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sonic.sdk.SonicDataHelper;
import com.tencent.sonic.sdk.SonicResourceDataHelper;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_CHARSET;
    private static final String SONIC_CLEAR_CACHE_TIME = "check_and_clear_cache_time";
    private static final String SONIC_TAG_DIFF_BEGIN = "<!--wnsdiff-";
    private static final String SONIC_TAG_DIFF_END = "-->";
    private static final String SONIC_TAG_KEY_BEGIN = "{";
    private static final String SONIC_TAG_KEY_END = "}";
    private static final String SONIC_TAG_PATTERN = "<!--wnsdiff-?(\\w*)-->([\\s\\S]+?)<!--wnsdiff-?(\\w*)-end-->";
    private static final String SONIC_TAG_TITLE_CLOSE = "</title>";
    private static final String SONIC_TAG_TITLE_KEY = "{title}";
    private static final String SONIC_TAG_TITLE_OPEN = "<title>";
    private static final String TAG = "SonicSdk_SonicUtils";
    private static final char[] hexChar;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT_CHARSET = Charset.defaultCharset().name();
            hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    public SonicUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String addSonicUrlParam(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder(str);
            int lastIndexOf = sb5.lastIndexOf("/");
            if (lastIndexOf < 0) {
                lastIndexOf = 0;
            }
            String str4 = ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            String str5 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            int length = str4.length();
            while (true) {
                try {
                    int indexOf = sb5.indexOf(str4, lastIndexOf);
                    if (-1 == indexOf) {
                        indexOf = sb5.indexOf(str5, lastIndexOf);
                    }
                    if (indexOf <= 0) {
                        break;
                    }
                    int indexOf2 = sb5.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + length);
                    if (indexOf2 > 0) {
                        sb5.replace(indexOf + 1, indexOf2 + 1, "");
                    } else {
                        sb5.replace(indexOf, sb5.length(), "");
                    }
                } catch (Throwable th5) {
                    log(TAG, 6, "addSonicUrlParam error:" + th5.getMessage());
                }
            }
            if (-1 != sb5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str3);
            } else {
                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str3);
            }
            return sb5.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String addTagInfo(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                sb5.append("<script> var _WebSoLocalTime=");
                sb5.append(str2);
                sb5.append(";</script>");
                sb5.append("<script> var _WebSoNetTime=");
                sb5.append(str3);
                sb5.append(";</script>");
                if (shouldLog(3)) {
                    log(TAG, 3, "add _WebSoLocalTime=" + str2 + ", add _WebSoNetTime=" + str3);
                }
            } catch (Throwable th5) {
                log(TAG, 6, "addTagInfo error:" + th5.getMessage());
            }
        }
        return sb5.toString();
    }

    static String buildHtml(String str, JSONObject jSONObject, String str2, int i3) {
        return buildHtml(str, jSONObject, str2, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCharset(String str) {
        String lowerCase;
        int indexOf;
        String str2 = DEFAULT_CHARSET;
        if (!TextUtils.isEmpty(str) && (indexOf = (lowerCase = str.toLowerCase()).indexOf(HttpMsg.CHARSET)) != -1) {
            String replace = lowerCase.substring(indexOf).replace(" ", "");
            int indexOf2 = replace.indexOf(";");
            if (indexOf2 == -1) {
                indexOf2 = replace.length();
            }
            String substring = replace.substring(8, indexOf2);
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            return str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject getDiffData(String str, JSONObject jSONObject) {
        try {
            String readFile = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(str)));
            if (!TextUtils.isEmpty(readFile)) {
                jSONObject = getDiffData(new JSONObject(readFile), jSONObject);
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return jSONObject;
            }
            jSONObject.put(SonicSession.WEB_RESPONSE_LOCAL_REFRESH_TIME, System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th5) {
            log(TAG, 6, "getDiffData error1:" + th5.getMessage());
            return null;
        }
    }

    public static HashMap<String, String> getFilteredHeaders(Map<String, List<String>> map) {
        List<String> value;
        HashMap<String, String> hashMap = new HashMap<>();
        if (map != null) {
            try {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (!"Set-Cookie".equalsIgnoreCase(entry.getKey()) && !"Cache-Control".equalsIgnoreCase(entry.getKey()) && !"Expires".equalsIgnoreCase(entry.getKey()) && !"Etag".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && 1 == value.size()) {
                        hashMap.put(entry.getKey(), value.get(0));
                    }
                }
            } catch (Throwable th5) {
                log(TAG, 6, "getFilteredHeaders error! " + th5.getMessage());
            }
        }
        return hashMap;
    }

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes(), 0, str.getBytes().length);
            return toHexString(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMime(String str) {
        String path = Uri.parse(str).getPath();
        if (path.endsWith(".css")) {
            return "text/css";
        }
        if (path.endsWith(PTSFileUtil.JS_FORMAT)) {
            return "application/x-javascript";
        }
        if (!path.endsWith(".jpg") && !path.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp")) {
            return "text/html";
        }
        return "image/*";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSHA1(String str) {
        return TextUtils.isEmpty(str) ? "" : getSHA1(str.getBytes());
    }

    private static void handleCacheControl(Map<String, List<String>> map, SonicDataHelper.SessionData sessionData) {
        List<String> list;
        if (map.containsKey("Cache-Control".toLowerCase())) {
            List<String> list2 = map.get("Cache-Control".toLowerCase());
            if (list2 != null && list2.size() > 0) {
                String lowerCase = list2.get(0).toLowerCase();
                if (lowerCase.contains("max-age")) {
                    String substring = lowerCase.substring(lowerCase.indexOf("max-age"));
                    int indexOf = substring.indexOf(",");
                    if (indexOf == -1) {
                        indexOf = substring.length();
                    }
                    try {
                        long parseLong = Long.parseLong(substring.substring(8, indexOf)) * 1000;
                        if (parseLong != 0) {
                            sessionData.expiredTime = parseLong + System.currentTimeMillis();
                        }
                    } catch (Exception e16) {
                        log(TAG, 6, "handleCacheControl:sessionId(" + sessionData.sessionId + ") error:" + e16.getMessage());
                    }
                } else if (lowerCase.contains("private") || lowerCase.contains("public")) {
                    sessionData.expiredTime = System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE;
                }
            } else if (map.containsKey("Expires") && (list = map.get("Expires")) != null && list.size() > 0) {
                String str = list.get(0);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                try {
                    sessionData.expiredTime = simpleDateFormat.parse(str).getTime() + MiniBoxNoticeInfo.HOUR_8;
                } catch (Exception e17) {
                    log(TAG, 6, "handleCacheControl:sessionId(" + sessionData.sessionId + ") error:" + e17.getMessage());
                }
            }
            long currentTimeMillis = System.currentTimeMillis() + SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_AGE;
            if (sessionData.expiredTime > currentTimeMillis) {
                sessionData.expiredTime = currentTimeMillis;
            }
        }
    }

    private static void handleResourceExpireTime(String str, SonicResourceDataHelper.ResourceData resourceData) {
        String queryParameter = Uri.parse(str).getQueryParameter("max-age");
        if (TextUtils.isEmpty(queryParameter)) {
            resourceData.expiredTime = Long.MAX_VALUE;
            return;
        }
        try {
            long parseLong = Long.parseLong(queryParameter) * 1000;
            if (parseLong != 0) {
                resourceData.expiredTime = parseLong + System.currentTimeMillis();
            }
        } catch (Exception e16) {
            log(TAG, 6, "handleResourceExpireTime:resourceUrl(" + str + ") error:" + e16.getMessage());
        }
    }

    public static void log(String str, int i3, String str2) {
        SonicEngine.getInstance().getRuntime().log(str, i3, str2);
    }

    static String mergeLocalAndBuildHtml(String str, String str2, JSONObject jSONObject, int i3) {
        if (!TextUtils.isEmpty(str2) && jSONObject != null) {
            log(TAG, 6, "sessionId(" + str + "), mergeLocalAndBuildHtml");
            StringBuilder sb5 = new StringBuilder(str2.length() + i3);
            String readFile = SonicFileUtils.readFile(new File(SonicFileUtils.getSonicDataPath(str)));
            try {
                if (!TextUtils.isEmpty(readFile)) {
                    JSONObject jSONObject2 = new JSONObject(readFile);
                    if (jSONObject2.has("data")) {
                        jSONObject2 = jSONObject2.optJSONObject("data");
                    }
                    if (jSONObject2 != null) {
                        Iterator keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String obj = keys.next().toString();
                            if (!jSONObject.has(obj)) {
                                jSONObject.put(obj, jSONObject2.optString(obj));
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                log(TAG, 6, "merge local data encounter error, " + th5.getMessage());
            }
            sb5.append(str2);
            Iterator keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String obj2 = keys2.next().toString();
                int indexOf = sb5.indexOf(obj2);
                if (-1 != indexOf) {
                    sb5.replace(indexOf, obj2.length() + indexOf, jSONObject.optString(obj2));
                }
            }
            return sb5.toString();
        }
        return null;
    }

    static boolean needRefreshPage(String str) {
        if (!TextUtils.isEmpty(str) && ("false".equals(str) || "true".equals(str))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean needSaveData(boolean z16, String str, Map<String, List<String>> map) {
        boolean z17;
        if (!TextUtils.isEmpty(str) && ("store".equals(str) || "true".equals(str))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && z16) {
            List<String> list = map.get("Cache-Control".toLowerCase());
            if (map.containsKey("Cache-Control")) {
                if (list != null && list.size() > 0) {
                    String lowerCase = list.get(0).toLowerCase();
                    if (lowerCase.contains("no-cache") || lowerCase.contains("no-store") || lowerCase.contains("must-revalidate")) {
                        return false;
                    }
                }
            } else if (map.containsKey("Pragma")) {
                return false;
            }
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeAllSessionCache() {
        File file = new File(SonicFileUtils.getSonicCacheDirPath());
        if (file.exists()) {
            SonicDataHelper.clear();
            SonicChunkDataHelper.clear();
            return SonicFileUtils.deleteAllChildFiles(file);
        }
        return false;
    }

    public static void removeResourceCache(String str) {
        SonicResourceDataHelper.removeResourceData(str);
        SonicFileUtils.deleteResourceFiles(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeSessionCache(String str) {
        SonicDataHelper.removeSessionData(str);
        SonicChunkDataHelper.removeChunkData(str);
        SonicFileUtils.deleteSonicFiles(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveClearCacheTime(long j3) {
        SonicEngine.getInstance().getRuntime().getSonicSharedPreferences().edit().putLong(SONIC_CLEAR_CACHE_TIME, j3).apply();
    }

    public static boolean saveResourceFiles(String str, byte[] bArr, Map<String, List<String>> map) {
        if (bArr != null && !SonicFileUtils.writeFile(bArr, SonicFileUtils.getSonicResourcePath(str))) {
            log(TAG, 6, "saveResourceFiles error: write resource data fail.");
            return false;
        }
        if (map != null && map.size() > 0 && !SonicFileUtils.writeFile(SonicFileUtils.convertHeadersToString(map), SonicFileUtils.getSonicResourceHeaderPath(str))) {
            log(TAG, 6, "saveResourceFiles error: write header file fail.");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean saveSessionFiles(String str, String str2, String str3, String str4, Map<String, List<String>> map) {
        if (!TextUtils.isEmpty(str2) && !SonicFileUtils.writeFile(str2, SonicFileUtils.getSonicHtmlPath(str))) {
            log(TAG, 6, "saveSessionData error: write html file fail.");
            return false;
        }
        if (!TextUtils.isEmpty(str3) && !SonicFileUtils.writeFile(str3, SonicFileUtils.getSonicTemplatePath(str))) {
            log(TAG, 6, "saveSessionData error: write template file fail.");
            return false;
        }
        if (!TextUtils.isEmpty(str4) && !SonicFileUtils.writeFile(str4, SonicFileUtils.getSonicDataPath(str))) {
            log(TAG, 6, "saveSessionData error: write data file fail.");
            return false;
        }
        if (map != null && map.size() > 0 && !SonicFileUtils.writeFile(SonicFileUtils.convertHeadersToString(map), SonicFileUtils.getSonicHeaderPath(str))) {
            log(TAG, 6, "saveSessionData error: write header file fail.");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public static void saveSonicData(String str, String str2, String str3, String str4, long j3, boolean z16, Map<String, List<String>> map) {
        if (shouldLog(4)) {
            log(TAG, 4, "saveSonicData sessionId = " + str + ", eTag = " + str2 + ", templateTag = " + str3 + ",htmlSha1 = " + str4 + ", htmlSize = " + j3);
        }
        SonicDataHelper.SessionData sessionData = new SonicDataHelper.SessionData();
        sessionData.sessionId = str;
        handleCacheControl(map, sessionData);
        sessionData.eTag = str2;
        sessionData.templateTag = str3;
        sessionData.htmlSha1 = str4;
        sessionData.htmlSize = j3;
        sessionData.templateUpdateTime = System.currentTimeMillis();
        sessionData.isRedPointPreload = z16 ? 1 : 0;
        SonicDataHelper.saveSessionData(str, sessionData);
    }

    public static void saveSonicResourceData(String str, String str2, long j3) {
        if (shouldLog(4)) {
            log(TAG, 4, "saveSonicResourceData resourceUrl = " + str + ", resourceSha1 = " + str2 + ", resourceSize = " + j3);
        }
        SonicResourceDataHelper.ResourceData resourceData = new SonicResourceDataHelper.ResourceData();
        resourceData.resourceId = getMD5(str);
        resourceData.resourceSha1 = str2;
        resourceData.resourceSize = j3;
        handleResourceExpireTime(str, resourceData);
        resourceData.lastUpdateTime = System.currentTimeMillis();
        SonicResourceDataHelper.saveResourceData(resourceData.resourceId, resourceData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean separateTemplateAndData(String str, String str2, StringBuilder sb5, StringBuilder sb6) {
        String str3;
        String str4;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("separateTemplateAndData:sessionId(");
        sb7.append(str);
        sb7.append(") start, htmlString = ");
        if (str2.length() > 128) {
            str3 = str2.substring(0, 128);
        } else {
            str3 = str2;
        }
        sb7.append(str3);
        log(TAG, 4, sb7.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            Matcher matcher = Pattern.compile(SONIC_TAG_PATTERN, 8).matcher(str2);
            int i16 = 0;
            while (matcher.find()) {
                String group = matcher.group();
                int indexOf = group.indexOf(SONIC_TAG_DIFF_BEGIN);
                int indexOf2 = group.indexOf(SONIC_TAG_DIFF_END);
                if (indexOf != -1 && (i3 = indexOf + 12) < indexOf2) {
                    str4 = group.substring(i3, indexOf2);
                } else {
                    str4 = null;
                }
                String str5 = SONIC_TAG_KEY_BEGIN + str4 + SONIC_TAG_KEY_END;
                if (shouldLog(3)) {
                    log(TAG, 3, "separateTemplateAndData:sessionId(" + str + "), key = " + str5);
                }
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(group)) {
                    jSONObject.put(str5, group);
                    sb5.append(str2.substring(i16, matcher.start()));
                    sb5.append(str5);
                    i16 = matcher.end();
                }
            }
            if (i16 < str2.length() && sb5.length() > 0) {
                sb5.append(str2.substring(i16, str2.length()));
            }
            int indexOf3 = sb5.indexOf(SONIC_TAG_TITLE_OPEN);
            int indexOf4 = sb5.indexOf(SONIC_TAG_TITLE_CLOSE, indexOf3 + 7) + 8;
            if (indexOf3 != -1 && indexOf3 < indexOf4) {
                jSONObject.put(SONIC_TAG_TITLE_KEY, sb5.substring(indexOf3, indexOf4));
                sb5.replace(indexOf3, indexOf4, SONIC_TAG_TITLE_KEY);
            }
            sb6.append(jSONObject.toString());
            log(TAG, 4, "separateTemplateAndData:sessionId(" + str + ") end, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
            return true;
        } catch (Exception e16) {
            log(TAG, 6, "separateTemplateAndData:sessionId(" + str + ") error:" + e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldClearCache(long j3) {
        if (System.currentTimeMillis() - SonicEngine.getInstance().getRuntime().getSonicSharedPreferences().getLong(SONIC_CLEAR_CACHE_TIME, 0L) > j3) {
            return true;
        }
        return false;
    }

    public static boolean shouldLog(int i3) {
        return SonicEngine.getInstance().getRuntime().shouldLog(i3);
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            char[] cArr = hexChar;
            sb5.append(cArr[(b16 & 240) >>> 4]);
            sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String buildHtml(String str, JSONObject jSONObject, String str2, int i3, boolean z16) {
        String buildHtml;
        File file = new File(SonicFileUtils.getSonicTemplatePath(str));
        if (file.exists()) {
            String readFile = SonicFileUtils.readFile(file);
            if (!TextUtils.isEmpty(readFile)) {
                if (z16) {
                    buildHtml = mergeLocalAndBuildHtml(str, readFile, jSONObject, i3);
                } else {
                    buildHtml = buildHtml(readFile, jSONObject, i3);
                }
                if (TextUtils.isEmpty(str2) || str2.equalsIgnoreCase(getSHA1(buildHtml))) {
                    return buildHtml;
                }
                SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable(str, buildHtml) { // from class: com.tencent.sonic.sdk.SonicUtils.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$htmlString;
                    final /* synthetic */ String val$sessionId;

                    {
                        this.val$sessionId = str;
                        this.val$htmlString = buildHtml;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) buildHtml);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SonicFileUtils.writeFile(this.val$htmlString, SonicFileUtils.getSonicHtmlPath(this.val$sessionId) + ".tmp");
                    }
                }, 0L);
                log(TAG, 6, "buildHtml error: verify sha1 error.");
                return null;
            }
            log(TAG, 6, "buildHtml error: template string is empty.");
        } else {
            log(TAG, 6, "buildHtml error: template file is not exists.");
        }
        return null;
    }

    public static String getSHA1(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(bArr, 0, bArr.length);
                return toHexString(messageDigest.digest());
            } catch (Exception unused) {
            }
        }
        return "";
    }

    static JSONObject getDiffData(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                String optString = jSONObject2.optString(obj);
                if (!optString.equals(jSONObject.optString(obj))) {
                    jSONObject3.put(obj, optString);
                    if (shouldLog(3)) {
                        log(TAG, 3, "getDiffData:find diff data, key ->" + obj + ", length=" + optString.length() + ".");
                    }
                }
            }
            return jSONObject3;
        } catch (Throwable th5) {
            log(TAG, 6, "getDiffData error2:" + th5.getMessage());
            return null;
        }
    }

    static String buildHtml(String str, JSONObject jSONObject, int i3) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + i3);
        sb5.append(str);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            String optString = jSONObject.optString(obj);
            int indexOf = sb5.indexOf(obj);
            if (-1 != indexOf) {
                sb5.replace(indexOf, obj.length() + indexOf, optString);
            }
        }
        return sb5.toString();
    }
}

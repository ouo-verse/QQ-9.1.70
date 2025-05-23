package com.tencent.qqlive.tvkplayer.vinfo.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKNetVideoInfoCache {
    private static final String COOKIE_KEY_VUSERID = "vuserid";
    private static final String HTTP_HEADERS_KEY_PREFIX = "HTTPHeaders-";
    protected static final String TAG = "TVKNetVideoInfoCache";
    private final List<String> mKeysToBeRemovedFromParamsMap;

    /* JADX INFO: Access modifiers changed from: protected */
    public TVKNetVideoInfoCache(@NonNull List<String> list, @NonNull List<String> list2) {
        this.mKeysToBeRemovedFromParamsMap = new ArrayList(list);
        for (String str : list2) {
            this.mKeysToBeRemovedFromParamsMap.add(HTTP_HEADERS_KEY_PREFIX + str);
        }
    }

    private Map<String, String> generateParamsMap(Map<String, String> map, Map<String, String> map2) {
        HashMap hashMap = new HashMap(map);
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            hashMap.put(HTTP_HEADERS_KEY_PREFIX + entry.getKey(), entry.getValue());
        }
        modifyParamsMap(hashMap);
        return hashMap;
    }

    public String generateCacheKey(@NonNull Map<String, String> map, @NonNull Map<String, String> map2) {
        if (map.isEmpty()) {
            TVKLogUtil.w(TAG, "failed to generate cache key: empty request map");
            return "";
        }
        Map<String, String> generateParamsMap = generateParamsMap(map, map2);
        ArrayList<String> arrayList = new ArrayList(generateParamsMap.keySet());
        Collections.sort(arrayList);
        StringBuilder sb5 = new StringBuilder();
        for (String str : arrayList) {
            if (!this.mKeysToBeRemovedFromParamsMap.contains(str)) {
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(generateParamsMap.get(str));
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        if (sb5.length() == 0) {
            TVKLogUtil.w(TAG, "failed to generate cache key: no valid request param found");
            return "";
        }
        sb5.append(getClass().getSimpleName());
        return TVKUtils.getMd5(sb5.toString());
    }

    @Nullable
    public TVKNetVideoInfo get(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.w(TAG, "failed to get: empty cache key");
            return null;
        }
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            TVKLogUtil.w(TAG, "failed to get: application context is null");
            return null;
        }
        LocalCache localCache = LocalCache.get(applicationContext);
        if (localCache == null) {
            TVKLogUtil.w(TAG, "failed to get: local cache is null");
            return null;
        }
        try {
            TVKNetVideoInfo tVKNetVideoInfo = (TVKNetVideoInfo) localCache.getAsObject(str);
            if (tVKNetVideoInfo == null) {
                TVKLogUtil.w(TAG, "failed to get: no cached object found");
                return null;
            }
            tVKNetVideoInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_CACHE);
            return tVKNetVideoInfo;
        } catch (ClassCastException unused) {
            TVKLogUtil.w(TAG, "failed to get: ClassCastException encountered. Unbelievable");
            return null;
        }
    }

    protected abstract boolean isObjectToBeCachedInvalid(TVKNetVideoInfo tVKNetVideoInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public void modifyParamsMap(Map<String, String> map) {
        String str = map.get(HTTP_HEADERS_KEY_PREFIX + TVKCommonParamEnum.RequestHeaders.COOKIE);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Matcher matcher = Pattern.compile("(?<=(^|;))vuserid=[^;]*").matcher(str);
        if (matcher.find()) {
            map.put(HTTP_HEADERS_KEY_PREFIX + TVKCommonParamEnum.RequestHeaders.COOKIE, str.substring(matcher.start(), matcher.end()));
            return;
        }
        TVKLogUtil.w(TAG, "failed to extract vuserid in cookie string. Use full cookie instead");
    }

    public abstract boolean put(String str, TVKNetVideoInfo tVKNetVideoInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean put(String str, TVKNetVideoInfo tVKNetVideoInfo, int i3) {
        if (i3 <= 0) {
            TVKLogUtil.w(TAG, "failed to cache: invalid duration: " + i3);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.w(TAG, "failed to cache: empty cache key");
            return false;
        }
        if (isObjectToBeCachedInvalid(tVKNetVideoInfo)) {
            TVKLogUtil.w(TAG, "failed to cache: video info invalid");
            return false;
        }
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            TVKLogUtil.w(TAG, "failed to cache: application context is null");
            return false;
        }
        LocalCache localCache = LocalCache.get(applicationContext);
        if (localCache == null) {
            TVKLogUtil.w(TAG, "failed to cache: local cache is null");
            return false;
        }
        localCache.put(str, tVKNetVideoInfo, i3);
        return true;
    }
}

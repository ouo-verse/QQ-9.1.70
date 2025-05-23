package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKUrlBuilder {
    private final Map<String, String> mParamsMap = new HashMap();
    private String mUrl;

    public TVKUrlBuilder() {
        reset();
    }

    public TVKUrlBuilder addParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.mParamsMap.put(str, str2);
        return this;
    }

    public String buildUrl() {
        StringBuilder sb5 = new StringBuilder(this.mUrl);
        String str = this.mUrl;
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str2);
        sb5.append(TVKHttpUtils.encodeParamsToStringForUrlEncoding(this.mParamsMap, "UTF-8"));
        return sb5.toString();
    }

    public void reset() {
        this.mParamsMap.clear();
        this.mUrl = "";
    }

    public TVKUrlBuilder setUrl(String str) {
        if (str == null) {
            str = "";
        }
        this.mUrl = str;
        return this;
    }

    public TVKUrlBuilder addParam(Map<String, String> map) {
        if (map == null) {
            return this;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addParam(entry.getKey(), entry.getValue());
        }
        return this;
    }
}

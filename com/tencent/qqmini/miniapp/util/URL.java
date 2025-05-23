package com.tencent.qqmini.miniapp.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class URL {
    private static Pattern schemePattern = Pattern.compile("[\\w\\d+_]+://");
    private String fullUrl;
    private String path;
    private String query;
    private Map<String, String> queryParam;

    public URL(String str, Map<String, String> map) {
        new HashMap();
        this.path = str;
        this.queryParam = map;
        this.query = "";
        if (map != null) {
            for (String str2 : map.keySet()) {
                this.query += str2 + ContainerUtils.KEY_VALUE_DELIMITER + map.get(str2) + ContainerUtils.FIELD_DELIMITER;
            }
        }
        this.fullUrl = str;
        if (TextUtils.isEmpty(this.query)) {
            return;
        }
        this.query = this.query.substring(0, r6.length() - 1);
        this.fullUrl = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + this.query;
    }

    public String getFullUrl() {
        return this.fullUrl;
    }

    public String getPath() {
        return this.path;
    }

    public String getQuery() {
        return this.query;
    }

    public Map<String, String> getQueryParam() {
        return this.queryParam;
    }

    public void setQueryParam(Map<String, String> map) {
        this.queryParam = map;
        String str = "";
        if (map != null) {
            for (String str2 : map.keySet()) {
                str = str + str2 + ContainerUtils.KEY_VALUE_DELIMITER + map.get(str2) + ContainerUtils.FIELD_DELIMITER;
            }
        }
        this.query = str;
        if (!TextUtils.isEmpty(str)) {
            this.query = this.query.substring(0, r5.length() - 1);
            this.fullUrl = this.path + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + this.query;
        }
    }

    public URL(String str) {
        this.queryParam = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fullUrl = str;
        str = str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER) ? str.replaceFirst("^.*://", "") : str;
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            this.path = str;
            return;
        }
        String[] split = str.split("\\?");
        this.path = split[0];
        String str2 = split[1];
        this.query = str2;
        for (String str3 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
            if (str3.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                String[] split2 = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                this.queryParam.put(split2[0], split2.length > 1 ? split2[1] : "");
            }
        }
    }
}

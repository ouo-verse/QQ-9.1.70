package com.tencent.bugly.common.reporter.link;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface PluginLinkData {
    void collectPluginLinkData(JSONObject jSONObject, List<String> list);

    LinkDataDBCacheMng getLinkDataDBCacheMng();

    LinkData getRecentLinkDataFromCurrentLaunch(String str, String str2, long j3);

    void recordPluginLinkData(JSONObject jSONObject);

    void setLinkDataDBCacheMng(LinkDataDBCacheMng linkDataDBCacheMng);
}

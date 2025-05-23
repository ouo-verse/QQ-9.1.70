package com.tencent.thumbplayer.api.asset;

import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPUrlMediaAsset extends ITPMediaAsset {
    void addBackUrl(String str);

    void addBackUrl(String str, Map<String, String> map);

    void setHttpHeader(Map<String, String> map);

    void setUrl(String str);

    void setUrl(String str, Map<String, String> map);
}

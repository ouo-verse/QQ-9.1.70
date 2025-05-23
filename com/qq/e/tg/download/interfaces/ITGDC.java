package com.qq.e.tg.download.interfaces;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITGDC {
    void configure(JSONObject jSONObject);

    void registerCustomDownloader(String str, ITangramDownloader iTangramDownloader);

    void unRegisterCustomDownloader(String str);
}

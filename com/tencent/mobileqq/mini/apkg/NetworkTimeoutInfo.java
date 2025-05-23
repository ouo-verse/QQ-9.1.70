package com.tencent.mobileqq.mini.apkg;

import com.tencent.component.network.downloader.impl.ipc.Const;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NetworkTimeoutInfo {
    public static final int TIME_DEFAULT_MS = 60000;
    public int request = 60000;
    public int connectSocket = 60000;
    public int uploadFile = 60000;
    public int downloadFile = 60000;

    public static NetworkTimeoutInfo parse(JSONObject jSONObject) {
        NetworkTimeoutInfo networkTimeoutInfo = new NetworkTimeoutInfo();
        networkTimeoutInfo.request = jSONObject == null ? 60000 : jSONObject.optInt(Const.BUNDLE_KEY_REQUEST, 60000);
        networkTimeoutInfo.connectSocket = jSONObject == null ? 60000 : jSONObject.optInt("connectSocket", 60000);
        networkTimeoutInfo.uploadFile = jSONObject == null ? 60000 : jSONObject.optInt("uploadFile", 60000);
        networkTimeoutInfo.downloadFile = jSONObject != null ? jSONObject.optInt("downloadFile", 60000) : 60000;
        return networkTimeoutInfo;
    }
}

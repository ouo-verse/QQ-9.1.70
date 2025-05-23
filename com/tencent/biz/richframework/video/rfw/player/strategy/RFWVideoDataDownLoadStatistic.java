package com.tencent.biz.richframework.video.rfw.player.strategy;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoDataDownLoadStatistic {
    private long mHttpCount;
    private long mP2PCount;
    private long mPCDNCount;

    public long getHttpCount() {
        return this.mHttpCount;
    }

    public long getP2PCount() {
        return this.mP2PCount;
    }

    public long getPCDNCount() {
        return this.mPCDNCount;
    }

    public void updateDownLoadInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("HttpDownloadSize")) {
            this.mHttpCount = jSONObject.optLong("HttpDownloadSize");
        }
        if (jSONObject.has("PcdnDownloadSize")) {
            this.mPCDNCount = jSONObject.optLong("PcdnDownloadSize");
        }
        if (jSONObject.has("P2PDownloadSize")) {
            this.mP2PCount = jSONObject.optLong("P2PDownloadSize");
        }
    }
}

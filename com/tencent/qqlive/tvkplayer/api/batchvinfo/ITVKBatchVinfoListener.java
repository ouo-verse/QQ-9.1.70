package com.tencent.qqlive.tvkplayer.api.batchvinfo;

import com.tencent.qqlive.tvkplayer.api.TVKError;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKBatchVinfoListener {
    void onFailure(int i3, TVKError tVKError);

    void onSuccess(int i3, Map<String, TVKBatchVinfoResponseInfo> map);
}

package com.tencent.tmdownloader.internal.network;

import com.tencent.tmassistant.common.jce.GetConfigRequest;
import com.tencent.tmassistant.common.jce.GetConfigResponse;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IGetConfigListener {
    void onPushConfigRequestFinish(GetConfigRequest getConfigRequest, GetConfigResponse getConfigResponse, boolean z16);
}

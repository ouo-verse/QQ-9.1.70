package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetResponse;

/* loaded from: classes9.dex */
public interface ResponseProcessor extends Processor {
    void onResponse(NetResponse netResponse) throws Exception;
}

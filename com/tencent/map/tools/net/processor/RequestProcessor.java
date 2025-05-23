package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetRequest;

/* loaded from: classes9.dex */
public interface RequestProcessor extends Processor {
    void onRequest(NetRequest netRequest) throws Exception;
}

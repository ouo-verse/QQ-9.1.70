package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.FileUploadResetException;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mi extends me implements RequestProcessor {
    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public final void onRequest(NetRequest netRequest) {
        netRequest.setRespHeaders(HttpMsg.USERRETURNCODE);
    }

    @Override // com.tencent.mapsdk.internal.me, com.tencent.map.tools.net.processor.ResponseProcessor
    public final void onResponse(NetResponse netResponse) {
        String headerField = netResponse.getHeaderField(HttpMsg.USERRETURNCODE);
        int parseInt = Integer.parseInt(headerField);
        if (parseInt != 0) {
            if (parseInt == -2) {
                netResponse.exception(new FileUploadResetException());
            }
            netResponse.exception(new Exception("FileUploader user error:".concat(String.valueOf(headerField))));
        }
    }
}

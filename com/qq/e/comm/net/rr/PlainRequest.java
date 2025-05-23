package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: classes3.dex */
public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, int i3, byte[] bArr) {
        super(str, i3, bArr);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new PlainResponse(httpURLConnection);
    }

    public PlainRequest(String str, Map<String, String> map, int i3) {
        super(str, map, i3);
    }
}

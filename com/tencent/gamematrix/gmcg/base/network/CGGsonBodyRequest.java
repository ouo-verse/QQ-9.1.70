package com.tencent.gamematrix.gmcg.base.network;

import androidx.annotation.Nullable;
import com.android.volley.h;
import com.android.volley.k;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGsonBodyRequest<T> extends CGGsonRequest<T> {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", "utf-8");

    public CGGsonBodyRequest(int i3, String str, Class<T> cls, @Nullable String str2, h.b<T> bVar, h.a aVar) {
        super(i3, str, cls, str2, bVar, aVar);
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        try {
            String str = this.mRequestBody;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            k.f("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8");
            return null;
        }
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.tencent.gamematrix.gmcg.base.network.CGGsonRequest
    protected void printRequestInfo() {
        Object[] objArr = new Object[2];
        objArr[0] = getUrl();
        String str = this.mRequestBody;
        if (str == null) {
            str = "null";
        }
        objArr[1] = str;
        CGLog.i(String.format("[http request] url: %s, requestBody: %s", objArr));
    }

    public CGGsonBodyRequest(int i3, String str, Class<T> cls, @Nullable String str2, Object obj, h.b<T> bVar, h.a aVar) {
        super(i3, str, cls, str2, obj, bVar, aVar);
    }

    public CGGsonBodyRequest(int i3, String str, Class<T> cls, Map<String, String> map, Map<String, String> map2, @Nullable String str2, h.b<T> bVar, h.a aVar) {
        super(i3, str, cls, map, map2, str2, bVar, aVar);
    }
}

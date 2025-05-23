package com.tencent.gamematrix.gmcg.base.network;

import android.graphics.PointF;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.g;
import com.android.volley.h;
import com.android.volley.toolbox.e;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGsonRequest<T> extends Request<T> {
    private Gson mGson;
    private Map<String, String> mHeaders;

    @GuardedBy("mLock")
    private h.b<T> mListener;
    private final Object mLock;
    private Map<String, String> mParameters;

    @Nullable
    protected String mRequestBody;
    private Class<T> mRespClazz;

    public CGGsonRequest(int i3, String str, Class<T> cls, h.b<T> bVar, h.a aVar) {
        this(i3, str, cls, null, null, null, bVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(String str, h.a aVar, VolleyError volleyError) {
        printErrorInfo(str, volleyError);
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    protected static void printErrorInfo(String str, VolleyError volleyError) {
        String str2;
        g gVar;
        if (volleyError != null && volleyError.getMessage() != null) {
            str2 = volleyError.getMessage();
        } else {
            str2 = "unknown";
        }
        if (volleyError != null && (gVar = volleyError.networkResponse) != null && gVar.f31332b != null) {
            str2 = str2 + "\nnetwork response: " + new String(volleyError.networkResponse.f31332b);
        }
        CGLog.e(String.format("[http error] url: %s, error: %s", str, str2));
    }

    @Override // com.android.volley.Request
    public void cancel() {
        CGLog.i(String.format("[http cancel] url: %s", getUrl()));
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(T t16) {
        h.b<T> bVar;
        synchronized (this.mLock) {
            bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.onResponse(t16);
        }
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.mHeaders;
        if (map == null) {
            return super.getHeaders();
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.mParameters;
        if (map == null) {
            return super.getParams();
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public h<T> parseNetworkResponse(g gVar) {
        try {
            String str = new String(gVar.f31332b, e.f(gVar.f31333c));
            printResponseInfo(str);
            return h.c(this.mGson.fromJson(str, (Class) this.mRespClazz), e.e(gVar));
        } catch (JsonSyntaxException e16) {
            return h.a(new ParseError(e16));
        } catch (UnsupportedEncodingException e17) {
            return h.a(new ParseError(e17));
        }
    }

    protected void printRequestInfo() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = getUrl();
        Map<String, String> map = this.mParameters;
        if (map != null) {
            str = map.toString();
        } else {
            str = "null";
        }
        objArr[1] = str;
        CGLog.i(String.format("[http request] url: %s, parameters: %s", objArr));
    }

    protected void printResponseInfo(String str) {
        CGLog.i(String.format("[http response] %s, url: %s", str, getUrl()));
    }

    public CGGsonRequest(int i3, String str, Class<T> cls, @Nullable String str2, h.b<T> bVar, h.a aVar) {
        this(i3, str, cls, null, null, str2, bVar, aVar);
    }

    public CGGsonRequest(int i3, String str, Class<T> cls, @Nullable String str2, Object obj, h.b<T> bVar, h.a aVar) {
        this(i3, str, cls, null, null, str2, bVar, aVar);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PointF.class, obj);
        this.mGson = gsonBuilder.create();
    }

    public CGGsonRequest(int i3, String str, Class<T> cls, Map<String, String> map, h.b<T> bVar, h.a aVar) {
        this(i3, str, cls, null, map, null, bVar, aVar);
    }

    public CGGsonRequest(int i3, final String str, Class<T> cls, Map<String, String> map, Map<String, String> map2, @Nullable String str2, h.b<T> bVar, final h.a aVar) {
        super(i3, str, new h.a() { // from class: com.tencent.gamematrix.gmcg.base.network.a
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGGsonRequest.lambda$new$0(str, aVar, volleyError);
            }
        });
        this.mLock = new Object();
        this.mGson = new Gson();
        this.mRespClazz = cls;
        this.mHeaders = map;
        this.mParameters = map2;
        this.mRequestBody = str2;
        this.mListener = bVar;
        printRequestInfo();
    }
}

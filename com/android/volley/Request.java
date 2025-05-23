package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.android.volley.c;
import com.android.volley.h;
import com.android.volley.k;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    @Nullable
    private c.a mCacheEntry;

    @GuardedBy("mLock")
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;

    @Nullable
    @GuardedBy("mLock")
    private h.a mErrorListener;
    private final k.a mEventLog;
    private final Object mLock;
    private final int mMethod;

    @GuardedBy("mLock")
    private a mRequestCompleteListener;
    private RequestQueue mRequestQueue;

    @GuardedBy("mLock")
    private boolean mResponseDelivered;
    private j mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private boolean mShouldRetryConnectionErrors;
    private boolean mShouldRetryServerErrors;
    private Object mTag;
    private final String mUrl;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface a {
        void a(Request<?> request, h<?> hVar);

        void b(Request<?> request);
    }

    @Deprecated
    public Request(String str, h.a aVar) {
        this(-1, str, aVar);
    }

    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb5.append(URLEncoder.encode(entry.getKey(), str));
                    sb5.append('=');
                    sb5.append(URLEncoder.encode(entry.getValue(), str));
                    sb5.append(Typography.amp);
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb5.toString().getBytes(str);
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("Encoding not supported: " + str, e16);
        }
    }

    private static int findDefaultTrafficStatsTag(String str) {
        Uri parse;
        String host;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            return host.hashCode();
        }
        return 0;
    }

    public void addMarker(String str) {
        if (k.a.f31344c) {
            this.mEventLog.a(str, Thread.currentThread().getId());
        }
    }

    @CallSuper
    public void cancel() {
        synchronized (this.mLock) {
            this.mCanceled = true;
            this.mErrorListener = null;
        }
    }

    public void deliverError(VolleyError volleyError) {
        h.a aVar;
        synchronized (this.mLock) {
            aVar = this.mErrorListener;
        }
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void deliverResponse(T t16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finish(final String str) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.e(this);
        }
        if (k.a.f31344c) {
            final long id5 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.android.volley.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.mEventLog.a(str, id5);
                        Request.this.mEventLog.b(Request.this.toString());
                    }
                });
            } else {
                this.mEventLog.a(str, id5);
                this.mEventLog.b(toString());
            }
        }
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params = getParams();
        if (params != null && params.size() > 0) {
            return encodeParameters(params, getParamsEncoding());
        }
        return null;
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    @Nullable
    public c.a getCacheEntry() {
        return this.mCacheEntry;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method != 0 && method != -1) {
            return Integer.toString(method) + '-' + url;
        }
        return url;
    }

    @Nullable
    public h.a getErrorListener() {
        h.a aVar;
        synchronized (this.mLock) {
            aVar = this.mErrorListener;
        }
        return aVar;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.mMethod;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    protected String getParamsEncoding() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> postParams = getPostParams();
        if (postParams != null && postParams.size() > 0) {
            return encodeParameters(postParams, getPostParamsEncoding());
        }
        return null;
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Nullable
    @Deprecated
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return getParams();
    }

    @Deprecated
    protected String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public j getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public final int getSequence() {
        Integer num = this.mSequence;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object getTag() {
        return this.mTag;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean hasHadResponseDelivered() {
        boolean z16;
        synchronized (this.mLock) {
            z16 = this.mResponseDelivered;
        }
        return z16;
    }

    public boolean isCanceled() {
        boolean z16;
        synchronized (this.mLock) {
            z16 = this.mCanceled;
        }
        return z16;
    }

    public void markDelivered() {
        synchronized (this.mLock) {
            this.mResponseDelivered = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyListenerResponseNotUsable() {
        a aVar;
        synchronized (this.mLock) {
            aVar = this.mRequestCompleteListener;
        }
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyListenerResponseReceived(h<?> hVar) {
        a aVar;
        synchronized (this.mLock) {
            aVar = this.mRequestCompleteListener;
        }
        if (aVar != null) {
            aVar.a(this, hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract h<T> parseNetworkResponse(g gVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendEvent(int i3) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.g(this, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(c.a aVar) {
        this.mCacheEntry = aVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNetworkRequestCompleteListener(a aVar) {
        synchronized (this.mLock) {
            this.mRequestCompleteListener = aVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.mRequestQueue = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(j jVar) {
        this.mRetryPolicy = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i3) {
        this.mSequence = Integer.valueOf(i3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z16) {
        this.mShouldCache = z16;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryConnectionErrors(boolean z16) {
        this.mShouldRetryConnectionErrors = z16;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z16) {
        this.mShouldRetryServerErrors = z16;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public final boolean shouldRetryConnectionErrors() {
        return this.mShouldRetryConnectionErrors;
    }

    public final boolean shouldRetryServerErrors() {
        return this.mShouldRetryServerErrors;
    }

    public String toString() {
        String str;
        String str2 = RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb5 = new StringBuilder();
        if (isCanceled()) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb5.append(str);
        sb5.append(getUrl());
        sb5.append(" ");
        sb5.append(str2);
        sb5.append(" ");
        sb5.append(getPriority());
        sb5.append(" ");
        sb5.append(this.mSequence);
        return sb5.toString();
    }

    public Request(int i3, String str, @Nullable h.a aVar) {
        this.mEventLog = k.a.f31344c ? new k.a() : null;
        this.mLock = new Object();
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mShouldRetryConnectionErrors = false;
        this.mCacheEntry = null;
        this.mMethod = i3;
        this.mUrl = str;
        this.mErrorListener = aVar;
        setRetryPolicy(new d());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        return priority == priority2 ? this.mSequence.intValue() - request.mSequence.intValue() : priority2.ordinal() - priority.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }
}

package com.android.volley;

/* compiled from: P */
/* loaded from: classes.dex */
public class VolleyError extends Exception {
    public final g networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNetworkTimeMs(long j3) {
        this.networkTimeMs = j3;
    }

    public VolleyError(g gVar) {
        this.networkResponse = gVar;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th5) {
        super(str, th5);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th5) {
        super(th5);
        this.networkResponse = null;
    }
}

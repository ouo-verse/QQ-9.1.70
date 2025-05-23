package com.android.volley;

/* compiled from: P */
/* loaded from: classes.dex */
public interface j {
    int getCurrentRetryCount();

    int getCurrentTimeout();

    void retry(VolleyError volleyError) throws VolleyError;
}

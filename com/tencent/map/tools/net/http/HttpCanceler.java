package com.tencent.map.tools.net.http;

import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetAdapter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HttpCanceler {
    private Callback<Boolean> mCancelCallback;
    private boolean mCanceled;
    private NetAdapter mConnection;

    public void cancel() {
        NetAdapter netAdapter = this.mConnection;
        if (netAdapter != null && netAdapter.cancel()) {
            this.mCanceled = true;
        }
        Callback<Boolean> callback = this.mCancelCallback;
        if (callback != null) {
            callback.callback(Boolean.valueOf(this.mCanceled));
        }
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void setHttpAccessRequest(NetAdapter netAdapter, Callback<Boolean> callback) {
        this.mConnection = netAdapter;
        this.mCancelCallback = callback;
    }
}

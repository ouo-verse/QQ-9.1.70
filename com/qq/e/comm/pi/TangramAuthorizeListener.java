package com.qq.e.comm.pi;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface TangramAuthorizeListener {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface AuthCallBack {
        void onFailed();

        void onSuccess(JSONObject jSONObject);
    }

    void authorize(AuthCallBack authCallBack);
}

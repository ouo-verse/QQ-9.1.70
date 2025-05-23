package com.tencent.qqlive.module.videoreport.storage.util;

import com.google.gson.Gson;
import com.tencent.qqlive.module.videoreport.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GsonObjectCoder implements Coder {
    private static final String TAG = "GsonObjectCoder";
    private Gson mGson;

    public GsonObjectCoder() {
        this(GsonHelper.build());
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.util.Coder
    public <T> T decode(String str, Class<T> cls) {
        try {
            return (T) this.mGson.fromJson(str, (Class) cls);
        } catch (Exception e16) {
            Log.e(TAG, "decode failure, error: " + e16.getLocalizedMessage());
            return null;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.util.Coder
    public String encode(Object obj) {
        try {
            return this.mGson.toJson(obj);
        } catch (Exception e16) {
            Log.e(TAG, "encode failure, error: " + e16.getLocalizedMessage());
            return null;
        }
    }

    public GsonObjectCoder(Gson gson) {
        this.mGson = gson;
    }
}

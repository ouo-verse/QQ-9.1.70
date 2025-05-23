package com.tencent.ams.dsdk.event;

import com.tencent.ams.dsdk.core.DKEngine;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DKMethodHandler {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Callback {
        void onFailure(int i3, String str);

        void onResult(Object obj);
    }

    String getModuleId();

    boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, Callback callback) throws Exception;
}

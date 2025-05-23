package com.tencent.luggage.wxaapi;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface WxaExtendApiJSBridge {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum ErrMsg {
        OK,
        FAIL,
        CANCEL
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void callback(@NonNull ErrMsg errMsg, @Nullable String str, @Nullable JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void invoke(@NonNull String str, @NonNull String str2, @Nullable JSONObject jSONObject, a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void openUrl(@Nullable Activity activity, @NonNull String str);
    }

    void setInvokeHandler(b bVar);

    void setOpenUrlHandler(c cVar);
}

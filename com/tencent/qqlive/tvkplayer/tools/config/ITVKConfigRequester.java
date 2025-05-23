package com.tencent.qqlive.tvkplayer.tools.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKConfigRequester {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ConfigRequestListener {
        public static final String EXTRA_KEY_EXP_NAME = "expName";
        public static final String EXTRA_KEY_POLICY_ID = "sGrayPolicyId";

        void onError(@NonNull TVKConfigRequestException tVKConfigRequestException);

        void onFetched(@NonNull HashMap<String, String> hashMap, @Nullable HashMap<String, String> hashMap2);
    }

    void cancel();

    void executeRequest() throws TVKConfigRequestException;

    void setRequestHttpHeaders(@NonNull Map<String, String> map);

    void setRequestListener(ConfigRequestListener configRequestListener);
}

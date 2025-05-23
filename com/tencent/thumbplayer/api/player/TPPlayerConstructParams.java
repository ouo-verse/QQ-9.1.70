package com.tencent.thumbplayer.api.player;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes26.dex */
public class TPPlayerConstructParams {
    public static final String CONSTRUCT_ID_QUEUE_INT_CORE_TYPE = "construct_id_queue_int_core_type";
    private final HashMap<String, TPOptionalParam<?>> mOptionalParamMap = new HashMap<>();

    public synchronized void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        this.mOptionalParamMap.put(tPOptionalParam.getKey(), tPOptionalParam);
    }

    @NonNull
    public synchronized List<TPOptionalParam<?>> getOptionalParams() {
        return new ArrayList(this.mOptionalParamMap.values());
    }
}

package com.tencent.tav.decoder;

import androidx.annotation.Nullable;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class RenderContextParams {
    public static final String INLINE_KEY_NEXT_FRAME_TIME = "inlineKey_nextFrameTime";
    private final HashMap<String, Object> params = new HashMap<>();

    public HashMap<String, Object> getAllParams() {
        return this.params;
    }

    @Nullable
    public Object getParam(String str) {
        return this.params.get(str);
    }

    public void putParam(String str, Object obj) {
        this.params.put(str, obj);
    }
}

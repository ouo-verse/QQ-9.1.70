package com.tencent.tavkit.composition.video;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.video.TAVVideoEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseVideoEffect implements TAVVideoEffect {
    private static final String TAG = "BaseVideoEffect";

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @Deprecated
    public final TAVVideoEffect.Filter createFilter() {
        Logger.w(TAG, "createFilter: \u8fd9\u4e2a\u65b9\u6cd5\u4e0d\u5e94\u8be5\u8c03\u7528\uff0c\u5e94\u8be5\u8c03\u7528 createFilter(RenderInfo renderInfo) stack = " + Log.getStackTraceString(new RuntimeException()));
        return createFilter(null);
    }

    public abstract TAVVideoEffect.Filter createFilter(@Nullable RenderInfo renderInfo);
}

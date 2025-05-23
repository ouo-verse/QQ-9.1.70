package com.tencent.tav.report;

import androidx.annotation.Nullable;
import com.tencent.tav.decoder.RenderContextParams;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IReporter {
    void onReport(@Nullable RenderContextParams renderContextParams, HashMap<String, String> hashMap);
}

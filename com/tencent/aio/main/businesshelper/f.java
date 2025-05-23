package com.tencent.aio.main.businesshelper;

import androidx.lifecycle.LifecycleEventObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/main/businesshelper/f;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface f extends LifecycleEventObserver {
    void V(@NotNull com.tencent.aio.api.runtime.a context);

    void onCreate(@NotNull com.tencent.aio.api.runtime.a context);

    void onDestroy();
}

package com.tencent.aio.main.businesshelper;

import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u5e9f\u5f03\uff0c\u7981\u6b62\u4f7f\u7528")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/main/businesshelper/c;", "", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "a", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface c {
    void a(@NotNull AIOParam aioParam);

    void onCreate();

    void onDestroy();
}

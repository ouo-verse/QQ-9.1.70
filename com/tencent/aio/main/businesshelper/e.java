package com.tencent.aio.main.businesshelper;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0004H\u0017\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/main/businesshelper/e;", "", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "", "getTag", "", "getId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface e {
    int getId();

    @NotNull
    String getTag();

    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    void onCreate(@NotNull b param);

    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    void onDestroy();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
        public static void a(@NotNull e eVar, @NotNull b param) {
            Intrinsics.checkNotNullParameter(param, "param");
        }

        @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
        public static void b(@NotNull e eVar) {
        }
    }
}

package com.tencent.aio.main.businesshelper;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.fragment.ChatFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/main/fragment/ChatFragment;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class d {
    @Deprecated(message = "\u5e9f\u5f03\uff0c \u7981\u6b62\u4f7f\u7528")
    public static final void a(@NotNull ChatFragment onStartAio, @NotNull AIOParam aioParam) {
        boolean z16;
        Intrinsics.checkNotNullParameter(onStartAio, "$this$onStartAio");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        if (onStartAio.getFirstScreenHelper$sdk_debug() == null) {
            String p16 = aioParam.p();
            if (p16 != null && p16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String p17 = aioParam.p();
                Intrinsics.checkNotNull(p17);
                Object newInstance = Class.forName(p17).newInstance();
                if (newInstance instanceof c) {
                    onStartAio.setFirstScreenHelper$sdk_debug((c) newInstance);
                    c firstScreenHelper$sdk_debug = onStartAio.getFirstScreenHelper$sdk_debug();
                    Intrinsics.checkNotNull(firstScreenHelper$sdk_debug);
                    firstScreenHelper$sdk_debug.onCreate();
                }
            }
        }
        c firstScreenHelper$sdk_debug2 = onStartAio.getFirstScreenHelper$sdk_debug();
        if (firstScreenHelper$sdk_debug2 != null) {
            firstScreenHelper$sdk_debug2.a(aioParam);
        }
    }
}

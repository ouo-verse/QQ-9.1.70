package com.tencent.rdelivery.reshub.core;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/d;", "Lcom/tencent/rdelivery/reshub/api/l;", "Lcom/tencent/rdelivery/reshub/api/a;", "appInfo", "Ljz3/e;", DownloadInfo.spKey_Config, "", "a", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d implements com.tencent.rdelivery.reshub.api.l {
    @Override // com.tencent.rdelivery.reshub.api.l
    public boolean a(@NotNull com.tencent.rdelivery.reshub.api.a appInfo, @NotNull jz3.e config) {
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(config, "config");
        String str = config.f411266g;
        Intrinsics.checkExpressionValueIsNotNull(str, "config.downloadUrl");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, ".zip", false, 2, null);
        if (!endsWith$default) {
            String str2 = config.f411266g;
            Intrinsics.checkExpressionValueIsNotNull(str2, "config.downloadUrl");
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str2, ".7z", false, 2, null);
            if (!endsWith$default2) {
                return false;
            }
            j.L.I();
            return false;
        }
        return true;
    }
}

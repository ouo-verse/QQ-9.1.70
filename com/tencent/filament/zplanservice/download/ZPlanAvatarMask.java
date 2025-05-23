package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = true, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarMask;", "", "hideSlotPart", "", "", "([Ljava/lang/String;)V", "getHideSlotPart", "()[Ljava/lang/String;", "[Ljava/lang/String;", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarMask {

    @NotNull
    private final String[] hideSlotPart;

    public ZPlanAvatarMask(@NotNull String[] hideSlotPart) {
        Intrinsics.checkNotNullParameter(hideSlotPart, "hideSlotPart");
        this.hideSlotPart = hideSlotPart;
    }

    @NotNull
    public final String[] getHideSlotPart() {
        return this.hideSlotPart;
    }
}

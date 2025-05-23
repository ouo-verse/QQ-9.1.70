package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.view.event.TouchEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/filament/zplan/view/event/TouchEventType;", "Lcom/tencent/filament/zplan/scene/square/ObjectTapType;", "a", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class l {
    @Nullable
    public static final ObjectTapType a(@NotNull TouchEventType toObjectTapType) {
        Intrinsics.checkNotNullParameter(toObjectTapType, "$this$toObjectTapType");
        int i3 = k.f106114a[toObjectTapType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return ObjectTapType.LONG;
            }
            return ObjectTapType.DOUBLE;
        }
        return ObjectTapType.SINGLE;
    }
}

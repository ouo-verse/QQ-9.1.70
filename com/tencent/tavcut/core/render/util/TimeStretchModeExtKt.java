package com.tencent.tavcut.core.render.util;

import com.tencent.tavcut.core.render.builder.light.model.type.TimeStretchMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u00a8\u0006\u0003"}, d2 = {"toPagTimeStretchMode", "", "Lcom/tencent/tavcut/core/render/builder/light/model/type/TimeStretchMode;", "lib_tavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TimeStretchModeExtKt {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimeStretchMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TimeStretchMode.SCALE.ordinal()] = 1;
            iArr[TimeStretchMode.NONE.ordinal()] = 2;
        }
    }

    public static final int toPagTimeStretchMode(@NotNull TimeStretchMode toPagTimeStretchMode) {
        Intrinsics.checkParameterIsNotNull(toPagTimeStretchMode, "$this$toPagTimeStretchMode");
        int i3 = WhenMappings.$EnumSwitchMapping$0[toPagTimeStretchMode.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            return 2;
        }
        return 0;
    }
}

package com.tencent.robot.aio.input.styleconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "", "a", "b", "robot-business-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    public static final boolean a(@NotNull InputStyleType inputStyleType) {
        Intrinsics.checkNotNullParameter(inputStyleType, "<this>");
        if (inputStyleType != InputStyleType.STYLE_SINGLE_BASE && inputStyleType != InputStyleType.STYLE_SINGLE_PLUS) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull InputStyleType inputStyleType) {
        Intrinsics.checkNotNullParameter(inputStyleType, "<this>");
        if (inputStyleType == InputStyleType.STYLE_SINGLE_PLUS) {
            return true;
        }
        return false;
    }
}

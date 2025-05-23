package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\n\u00a2\u0006\u0002\u0010\u0007\u001a<\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u0002H\u0001H\u0086\n\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {HippyTextInputController.COMMAND_getValue, "T", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "", "value", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Triton_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ValueHolderKt {
    public static final <T> T getValue(@NotNull ValueHolder<T> getValue, @Nullable Object obj, @NotNull KProperty<?> property) {
        Intrinsics.checkParameterIsNotNull(getValue, "$this$getValue");
        Intrinsics.checkParameterIsNotNull(property, "property");
        return getValue.getValue();
    }

    public static final <T> void setValue(@NotNull ValueHolder<T> setValue, @Nullable Object obj, @NotNull KProperty<?> property, T t16) {
        Intrinsics.checkParameterIsNotNull(setValue, "$this$setValue");
        Intrinsics.checkParameterIsNotNull(property, "property");
        setValue.setValue(t16);
    }
}

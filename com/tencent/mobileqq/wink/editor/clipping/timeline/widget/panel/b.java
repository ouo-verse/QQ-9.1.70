package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a8\u0006\t"}, d2 = {"", "obj", "", "fieldName", "Lkotlin/Function1;", "Ljava/lang/reflect/Field;", "", "callback", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    public static final void a(@NotNull Object obj, @NotNull String fieldName, @NotNull Function1<? super Field, Unit> callback) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(field, "field");
            callback.invoke(field);
            field.setAccessible(isAccessible);
        } catch (NoSuchFieldException unused) {
        }
    }
}

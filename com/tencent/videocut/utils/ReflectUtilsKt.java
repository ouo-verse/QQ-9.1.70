package com.tencent.videocut.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u001a%\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u0018\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"", "obj", "", "fieldName", "Lkotlin/Function1;", "Ljava/lang/reflect/Field;", "", "callback", "c", "", "exceptedFieldNames", "b", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object;", "a", "lib_utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ReflectUtilsKt {
    @Nullable
    public static final Object a(@NotNull final Object obj, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        c(obj, fieldName, new Function1<Field, Unit>(obj) { // from class: com.tencent.videocut.utils.ReflectUtilsKt$getFieldData$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object $obj;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$obj = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) Ref.ObjectRef.this, obj);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Field field) {
                invoke2(field);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Field it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                Ref.ObjectRef.this.element = it.get(this.$obj);
            }
        });
        return objectRef.element;
    }

    @Nullable
    public static final Object b(@NotNull Object obj, @NotNull String[] exceptedFieldNames) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(exceptedFieldNames, "exceptedFieldNames");
        for (String str : exceptedFieldNames) {
            Object a16 = a(obj, str);
            if (a16 != null) {
                return a16;
            }
        }
        return null;
    }

    public static final void c(@NotNull Object obj, @NotNull String fieldName, @NotNull Function1<? super Field, Unit> callback) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            Intrinsics.checkNotNullExpressionValue(field, "field");
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            callback.invoke(field);
            field.setAccessible(isAccessible);
        } catch (NoSuchFieldException unused) {
        }
    }
}

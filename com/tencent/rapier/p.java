package com.tencent.rapier;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rapier/p;", "", "Ljava/lang/reflect/Type;", "type", "", "b", "", "index", "Ljava/lang/reflect/ParameterizedType;", "a", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f364089a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f364089a = new p();
        }
    }

    p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public final Type a(int index, @NotNull ParameterizedType type) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Type) iPatchRedirector.redirect((short) 2, (Object) this, index, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Type[] actualTypeArguments = type.getActualTypeArguments();
        if (index >= 0 && index < actualTypeArguments.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Type paramType = actualTypeArguments[index];
            if (paramType instanceof WildcardType) {
                Type type2 = ((WildcardType) paramType).getUpperBounds()[0];
                Intrinsics.checkNotNullExpressionValue(type2, "paramType.upperBounds[0]");
                return type2;
            }
            Intrinsics.checkNotNullExpressionValue(paramType, "paramType");
            return paramType;
        }
        throw new IllegalArgumentException(("Index " + index + " not in range [0," + actualTypeArguments.length + ") for " + type).toString());
    }

    public final boolean b(@Nullable Type type) {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) type)).booleanValue();
        }
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (b(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return b(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }
}

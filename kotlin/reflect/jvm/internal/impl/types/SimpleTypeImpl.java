package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class SimpleTypeImpl extends SimpleType {

    @NotNull
    private final List<TypeProjection> arguments;

    @NotNull
    private final TypeConstructor constructor;
    private final boolean isMarkedNullable;

    @NotNull
    private final MemberScope memberScope;

    @NotNull
    private final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleTypeImpl(@NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments, boolean z16, @NotNull MemberScope memberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        this.constructor = constructor;
        this.arguments = arguments;
        this.isMarkedNullable = z16;
        this.memberScope = memberScope;
        this.refinedTypeFactory = refinedTypeFactory;
        if ((getMemberScope() instanceof ErrorScope) && !(getMemberScope() instanceof ThrowingScope)) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + '\n' + getConstructor());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z16) {
        if (z16 == isMarkedNullable()) {
            return this;
        }
        if (z16) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new SimpleTypeWithAttributes(this, newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public SimpleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }
}

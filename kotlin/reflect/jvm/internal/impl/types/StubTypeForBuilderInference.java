package kotlin.reflect.jvm.internal.impl.types;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {

    @NotNull
    private final TypeConstructor constructor;

    @NotNull
    private final MemberScope memberScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StubTypeForBuilderInference(@NotNull NewTypeVariableConstructor originalTypeVariable, boolean z16, @NotNull TypeConstructor constructor) {
        super(originalTypeVariable, z16);
        Intrinsics.checkNotNullParameter(originalTypeVariable, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        this.constructor = constructor;
        this.memberScope = originalTypeVariable.getBuiltIns().getAnyType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    @NotNull
    public AbstractStubType materialize(boolean z16) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), z16, getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Stub (BI): ");
        sb5.append(getOriginalTypeVariable());
        if (isMarkedNullable()) {
            str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }
}

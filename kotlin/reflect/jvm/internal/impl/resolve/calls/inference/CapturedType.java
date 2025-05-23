package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CapturedType extends SimpleType implements CapturedTypeMarker {

    @NotNull
    private final TypeAttributes attributes;

    @NotNull
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;

    @NotNull
    private final TypeProjection typeProjection;

    public /* synthetic */ CapturedType(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z16, TypeAttributes typeAttributes, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i3 & 2) != 0 ? new CapturedTypeConstructorImpl(typeProjection) : capturedTypeConstructor, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? TypeAttributes.Companion.getEmpty() : typeAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public List<TypeProjection> getArguments() {
        List<TypeProjection> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Captured(");
        sb5.append(this.typeProjection);
        sb5.append(')');
        if (isMarkedNullable()) {
            str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public CapturedType makeNullableAsSpecified(boolean z16) {
        return z16 == isMarkedNullable() ? this : new CapturedType(this.typeProjection, getConstructor(), z16, getAttributes());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public CapturedType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.typeProjection.refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, getConstructor(), isMarkedNullable(), getAttributes());
    }

    public CapturedType(@NotNull TypeProjection typeProjection, @NotNull CapturedTypeConstructor constructor, boolean z16, @NotNull TypeAttributes attributes) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.typeProjection = typeProjection;
        this.constructor = constructor;
        this.isMarkedNullable = z16;
        this.attributes = attributes;
    }
}

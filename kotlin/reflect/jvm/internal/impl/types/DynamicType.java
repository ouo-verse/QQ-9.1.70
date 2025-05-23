package kotlin.reflect.jvm.internal.impl.types;

import com.tencent.hippy.qq.api.TabPreloadItem;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DynamicType extends FlexibleType implements DynamicTypeMarker {

    @NotNull
    private final TypeAttributes attributes;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DynamicType(@NotNull KotlinBuiltIns builtIns, @NotNull TypeAttributes attributes) {
        super(r0, r3);
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        SimpleType nothingType = builtIns.getNothingType();
        Intrinsics.checkNotNullExpressionValue(nothingType, "builtIns.nothingType");
        SimpleType nullableAnyType = builtIns.getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(nullableAnyType, "builtIns.nullableAnyType");
        this.attributes = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public SimpleType getDelegate() {
        return getUpperBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public DynamicType makeNullableAsSpecified(boolean z16) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public DynamicType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        return TabPreloadItem.TAB_NAME_DYNAMIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public DynamicType replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new DynamicType(TypeUtilsKt.getBuiltIns(getDelegate()), newAttributes);
    }
}

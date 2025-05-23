package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RawTypeImpl extends FlexibleType implements RawType {
    RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z16) {
        super(simpleType, simpleType2);
        if (z16) {
            return;
        }
        KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
    }

    private static final boolean render$onlyOutDiffers(String str, String str2) {
        String removePrefix;
        removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) "out ");
        if (!Intrinsics.areEqual(str, removePrefix) && !Intrinsics.areEqual(str2, "*")) {
            return false;
        }
        return true;
    }

    private static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        int collectionSizeOrDefault;
        List<TypeProjection> arguments = kotlinType.getArguments();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer.renderTypeProjection((TypeProjection) it.next()));
        }
        return arrayList;
    }

    private static final String render$replaceArgs(String str, String str2) {
        boolean contains$default;
        String substringBefore$default;
        String substringAfterLast$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, Typography.less, false, 2, (Object) null);
        if (!contains$default) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(str, Typography.less, (String) null, 2, (Object) null);
        sb5.append(substringBefore$default);
        sb5.append(Typography.less);
        sb5.append(str2);
        sb5.append(Typography.greater);
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, Typography.greater, (String) null, 2, (Object) null);
        sb5.append(substringAfterLast$default);
        return sb5.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public SimpleType getDelegate() {
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public MemberScope getMemberScope() {
        ClassDescriptor classDescriptor;
        ClassifierDescriptor mo1779getDeclarationDescriptor = getConstructor().mo1779getDeclarationDescriptor();
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = null;
        byte b16 = 0;
        if (mo1779getDeclarationDescriptor instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) mo1779getDeclarationDescriptor;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution(typeParameterUpperBoundEraser, 1, b16 == true ? 1 : 0));
            Intrinsics.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution())");
            return memberScope;
        }
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().mo1779getDeclarationDescriptor()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        String joinToString$default;
        List zip;
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(options, "options");
        String renderType = renderer.renderType(getLowerBound());
        String renderType2 = renderer.renderType(getUpperBound());
        if (options.getDebugMode()) {
            return "raw (" + renderType + ".." + renderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return renderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
        List<String> render$renderArguments = render$renderArguments(renderer, getLowerBound());
        List<String> render$renderArguments2 = render$renderArguments(renderer, getUpperBound());
        List<String> list = render$renderArguments;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$render$newArgs$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "(raw) " + it;
            }
        }, 30, null);
        zip = CollectionsKt___CollectionsKt.zip(list, render$renderArguments2);
        List list2 = zip;
        boolean z16 = true;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                if (!render$onlyOutDiffers((String) pair.getFirst(), (String) pair.getSecond())) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            renderType2 = render$replaceArgs(renderType2, joinToString$default);
        }
        String render$replaceArgs = render$replaceArgs(renderType, joinToString$default);
        if (Intrinsics.areEqual(render$replaceArgs, renderType2)) {
            return render$replaceArgs;
        }
        return renderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public RawTypeImpl makeNullableAsSpecified(boolean z16) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z16), getUpperBound().makeNullableAsSpecified(z16));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    @NotNull
    public RawTypeImpl replaceAttributes(@NotNull TypeAttributes newAttributes) {
        Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(newAttributes), getUpperBound().replaceAttributes(newAttributes));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        this(lowerBound, upperBound, false);
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType((KotlinTypeMarker) getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType((KotlinTypeMarker) getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) refineType, (SimpleType) refineType2, true);
    }
}

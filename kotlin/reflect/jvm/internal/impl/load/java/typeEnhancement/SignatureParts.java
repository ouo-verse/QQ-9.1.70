package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes28.dex */
public final class SignatureParts extends AbstractSignatureParts<AnnotationDescriptor> {

    @NotNull
    private final AnnotationQualifierApplicabilityType containerApplicabilityType;

    @NotNull
    private final LazyJavaResolverContext containerContext;
    private final boolean isCovariant;
    private final boolean skipRawTypeArguments;

    @Nullable
    private final Annotated typeContainer;

    public /* synthetic */ SignatureParts(Annotated annotated, boolean z16, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotated, z16, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i3 & 16) != 0 ? false : z17);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @NotNull
    public Iterable<AnnotationDescriptor> getAnnotations(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((KotlinType) kotlinTypeMarker).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @NotNull
    public Iterable<AnnotationDescriptor> getContainerAnnotations() {
        List emptyList;
        Annotations annotations;
        Annotated annotated = this.typeContainer;
        if (annotated == null || (annotations = annotated.getAnnotations()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @NotNull
    public AnnotationQualifierApplicabilityType getContainerApplicabilityType() {
        return this.containerApplicabilityType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @Nullable
    public JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers() {
        return this.containerContext.getDefaultTypeQualifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getContainerIsVarargParameter() {
        Annotated annotated = this.typeContainer;
        if ((annotated instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) annotated).getVarargElementType() != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getEnableImprovementsInStrictMode() {
        return this.containerContext.getComponents().getSettings().getTypeEnhancementImprovementsInStrictMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @Nullable
    public FqNameUnsafe getFqNameUnsafe(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor((KotlinType) kotlinTypeMarker);
        if (classDescriptor != null) {
            return DescriptorUtils.getFqName(classDescriptor);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getSkipRawTypeArguments() {
        return this.skipRawTypeArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isArrayOrPrimitiveArray(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return KotlinBuiltIns.isArrayOrPrimitiveArray((KotlinType) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isCovariant() {
        return this.isCovariant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isEqual(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker other) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return this.containerContext.getComponents().getKotlinTypeChecker().equalTypes((KotlinType) kotlinTypeMarker, (KotlinType) other);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isFromJava(@NotNull TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(typeParameterMarker, "<this>");
        return typeParameterMarker instanceof LazyJavaTypeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean isNotNullTypeParameterCompat(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return ((KotlinType) kotlinTypeMarker).unwrap() instanceof NotNullTypeParameterImpl;
    }

    public SignatureParts(@Nullable Annotated annotated, boolean z16, @NotNull LazyJavaResolverContext containerContext, @NotNull AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z17) {
        Intrinsics.checkNotNullParameter(containerContext, "containerContext");
        Intrinsics.checkNotNullParameter(containerApplicabilityType, "containerApplicabilityType");
        this.typeContainer = annotated;
        this.isCovariant = z16;
        this.containerContext = containerContext;
        this.containerApplicabilityType = containerApplicabilityType;
        this.skipRawTypeArguments = z17;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @NotNull
    public AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> getAnnotationTypeQualifierResolver() {
        return this.containerContext.getComponents().getAnnotationTypeQualifierResolver();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @Nullable
    public KotlinType getEnhancedForWarnings(@NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return TypeWithEnhancementKt.getEnhancement((KotlinType) kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean getForceWarning(@NotNull AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        return ((annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) || ((annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && !getEnableImprovementsInStrictMode() && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    @NotNull
    public TypeSystemInferenceExtensionContext getTypeSystem() {
        return SimpleClassicTypeSystemContext.INSTANCE;
    }
}

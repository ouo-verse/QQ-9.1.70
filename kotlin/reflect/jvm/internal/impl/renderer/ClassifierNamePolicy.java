package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public interface ClassifierNamePolicy {

    /* loaded from: classes28.dex */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {

        @NotNull
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifier).getName();
                Intrinsics.checkNotNullExpressionValue(name, "classifier.name");
                return renderer.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifier);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return renderer.renderFqName(fqName);
        }
    }

    /* loaded from: classes28.dex */
    public static final class SHORT implements ClassifierNamePolicy {

        @NotNull
        public static final SHORT INSTANCE = new SHORT();

        SHORT() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.Named, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            List asReversedMutable;
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifier).getName();
                Intrinsics.checkNotNullExpressionValue(name, "classifier.name");
                return renderer.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifier.getName());
                classifier = classifier.getContainingDeclaration();
            } while (classifier instanceof ClassDescriptor);
            asReversedMutable = CollectionsKt__ReversedViewsKt.asReversedMutable(arrayList);
            return RenderingUtilsKt.renderFqName(asReversedMutable);
        }
    }

    /* loaded from: classes28.dex */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {

        @NotNull
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor classifierDescriptor) {
            Name name = classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
            String render = RenderingUtilsKt.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            String qualifierName = qualifierName(containingDeclaration);
            if (qualifierName != null && !Intrinsics.areEqual(qualifierName, "")) {
                return qualifierName + '.' + render;
            }
            return render;
        }

        private final String qualifierName(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return qualifiedNameForSourceCode((ClassifierDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().toUnsafe();
                Intrinsics.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                return RenderingUtilsKt.render(unsafe);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            return qualifiedNameForSourceCode(classifier);
        }
    }

    @NotNull
    String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer);
}

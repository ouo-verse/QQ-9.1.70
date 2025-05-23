package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LazyJavaAnnotations implements Annotations {

    @NotNull
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;

    @NotNull
    private final JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final LazyJavaResolverContext f412746c;

    public LazyJavaAnnotations(@NotNull LazyJavaResolverContext c16, @NotNull JavaAnnotationOwner annotationOwner, boolean z16) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        this.f412746c = c16;
        this.annotationOwner = annotationOwner;
        this.areAnnotationsFreshlySupported = z16;
        this.annotationDescriptors = c16.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<JavaAnnotation, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations$annotationDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final AnnotationDescriptor invoke(@NotNull JavaAnnotation annotation) {
                LazyJavaResolverContext lazyJavaResolverContext;
                boolean z17;
                Intrinsics.checkNotNullParameter(annotation, "annotation");
                JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
                lazyJavaResolverContext = LazyJavaAnnotations.this.f412746c;
                z17 = LazyJavaAnnotations.this.areAnnotationsFreshlySupported;
                return javaAnnotationMapper.mapOrResolveJavaAnnotation(annotation, lazyJavaResolverContext, z17);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo1774findAnnotation(@NotNull FqName fqName) {
        AnnotationDescriptor invoke;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        JavaAnnotation findAnnotation = this.annotationOwner.findAnnotation(fqName);
        if (findAnnotation == null || (invoke = this.annotationDescriptors.invoke(findAnnotation)) == null) {
            return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.annotationOwner, this.f412746c);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        if (this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence asSequence;
        Sequence map;
        Sequence plus;
        Sequence filterNotNull;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.annotationOwner.getAnnotations());
        map = SequencesKt___SequencesKt.map(asSequence, this.annotationDescriptors);
        plus = SequencesKt___SequencesKt.plus((Sequence<? extends AnnotationDescriptor>) ((Sequence<? extends Object>) map), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.f412746c));
        filterNotNull = SequencesKt___SequencesKt.filterNotNull(plus);
        return filterNotNull.iterator();
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i3 & 4) != 0 ? false : z16);
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.gcore.abase.utils.PatternUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Annotations EMPTY = new Annotations() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion$EMPTY$1
            @Nullable
            public Void findAnnotation(@NotNull FqName fqName) {
                Intrinsics.checkNotNullParameter(fqName, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean hasAnnotation(@NotNull FqName fqName) {
                return Annotations.DefaultImpls.hasAnnotation(this, fqName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<AnnotationDescriptor> iterator() {
                List emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList.iterator();
            }

            @NotNull
            public String toString() {
                return PatternUtils.NO_MATCH;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            /* renamed from: findAnnotation, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AnnotationDescriptor mo1774findAnnotation(FqName fqName) {
                return (AnnotationDescriptor) findAnnotation(fqName);
            }
        };

        Companion() {
        }

        @NotNull
        public final Annotations create(@NotNull List<? extends AnnotationDescriptor> annotations) {
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            if (annotations.isEmpty()) {
                return EMPTY;
            }
            return new AnnotationsImpl(annotations);
        }

        @NotNull
        public final Annotations getEMPTY() {
            return EMPTY;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static AnnotationDescriptor findAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            AnnotationDescriptor annotationDescriptor;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    annotationDescriptor = it.next();
                    if (Intrinsics.areEqual(annotationDescriptor.getFqName(), fqName)) {
                        break;
                    }
                } else {
                    annotationDescriptor = null;
                    break;
                }
            }
            return annotationDescriptor;
        }

        public static boolean hasAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (annotations.mo1774findAnnotation(fqName) != null) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    /* renamed from: findAnnotation */
    AnnotationDescriptor mo1774findAnnotation(@NotNull FqName fqName);

    boolean hasAnnotation(@NotNull FqName fqName);

    boolean isEmpty();
}

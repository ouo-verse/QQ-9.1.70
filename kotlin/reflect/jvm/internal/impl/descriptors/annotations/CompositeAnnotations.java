package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CompositeAnnotations implements Annotations {

    @NotNull
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(@NotNull List<? extends Annotations> delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo1774findAnnotation(@NotNull final FqName fqName) {
        Sequence asSequence;
        Sequence mapNotNull;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(asSequence, new Function1<Annotations, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$findAnnotation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final AnnotationDescriptor invoke(@NotNull Annotations it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.mo1774findAnnotation(FqName.this);
            }
        });
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(mapNotNull);
        return (AnnotationDescriptor) firstOrNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull FqName fqName) {
        Sequence asSequence;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        Iterator it = asSequence.iterator();
        while (it.hasNext()) {
            if (((Annotations) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((Annotations) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence asSequence;
        Sequence flatMap;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        flatMap = SequencesKt___SequencesKt.flatMap(asSequence, new Function1<Annotations, Sequence<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$iterator$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Sequence<AnnotationDescriptor> invoke(@NotNull Annotations it) {
                Sequence<AnnotationDescriptor> asSequence2;
                Intrinsics.checkNotNullParameter(it, "it");
                asSequence2 = CollectionsKt___CollectionsKt.asSequence(it);
                return asSequence2;
            }
        });
        return flatMap.iterator();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CompositeAnnotations(@NotNull Annotations... delegates) {
        this((List<? extends Annotations>) r2);
        List list;
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        list = ArraysKt___ArraysKt.toList(delegates);
    }
}

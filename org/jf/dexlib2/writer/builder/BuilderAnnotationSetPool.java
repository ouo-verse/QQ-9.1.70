package org.jf.dexlib2.writer.builder;

import com.google.common.base.d;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.r;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.writer.AnnotationSetSection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class BuilderAnnotationSetPool extends BaseBuilderPool implements AnnotationSetSection<BuilderAnnotation, BuilderAnnotationSet> {

    @Nonnull
    private final ConcurrentMap<Set<? extends Annotation>, BuilderAnnotationSet> internedItems;

    public BuilderAnnotationSetPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderAnnotationSet, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderAnnotationSet>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderAnnotationSetPool.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderAnnotationSet builderAnnotationSet) {
                return builderAnnotationSet.offset;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderAnnotationSet builderAnnotationSet, int i3) {
                int i16 = builderAnnotationSet.offset;
                builderAnnotationSet.offset = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderAnnotationSet internAnnotationSet(@Nullable Set<? extends Annotation> set) {
        if (set == null) {
            return BuilderAnnotationSet.EMPTY;
        }
        BuilderAnnotationSet builderAnnotationSet = this.internedItems.get(set);
        if (builderAnnotationSet != null) {
            return builderAnnotationSet;
        }
        BuilderAnnotationSet builderAnnotationSet2 = new BuilderAnnotationSet(ImmutableSet.copyOf(r.x(set.iterator(), new d<Annotation, BuilderAnnotation>() { // from class: org.jf.dexlib2.writer.builder.BuilderAnnotationSetPool.1
            @Override // com.google.common.base.d
            @Nullable
            public BuilderAnnotation apply(Annotation annotation) {
                return ((BuilderAnnotationPool) BuilderAnnotationSetPool.this.dexBuilder.annotationSection).internAnnotation(annotation);
            }
        })));
        BuilderAnnotationSet putIfAbsent = this.internedItems.putIfAbsent(builderAnnotationSet2, builderAnnotationSet2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderAnnotationSet2;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSetSection
    @Nonnull
    public Collection<? extends BuilderAnnotation> getAnnotations(@Nonnull BuilderAnnotationSet builderAnnotationSet) {
        return builderAnnotationSet.annotations;
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    public int getItemOffset(@Nonnull BuilderAnnotationSet builderAnnotationSet) {
        return builderAnnotationSet.offset;
    }

    @Override // org.jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(@Nullable BuilderAnnotationSet builderAnnotationSet) {
        if (builderAnnotationSet == null) {
            return 0;
        }
        return builderAnnotationSet.offset;
    }
}

package org.jf.dexlib2.writer.builder;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderAnnotationSet extends AbstractSet<BuilderAnnotation> {
    public static final BuilderAnnotationSet EMPTY = new BuilderAnnotationSet(ImmutableSet.of());

    @Nonnull
    final Set<BuilderAnnotation> annotations;
    int offset = 0;

    public BuilderAnnotationSet(@Nonnull Set<BuilderAnnotation> set) {
        this.annotations = set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @Nonnull
    public Iterator<BuilderAnnotation> iterator() {
        return this.annotations.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.annotations.size();
    }
}

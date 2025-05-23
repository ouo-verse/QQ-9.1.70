package org.jf.dexlib2.writer.pool;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.writer.AnnotationSetSection;

/* loaded from: classes29.dex */
public class AnnotationSetPool extends BaseNullableOffsetPool<Set<? extends Annotation>> implements AnnotationSetSection<Annotation, Set<? extends Annotation>> {
    public AnnotationSetPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.jf.dexlib2.writer.AnnotationSetSection
    @Nonnull
    public Collection<? extends Annotation> getAnnotations(@Nonnull Set<? extends Annotation> set) {
        return set;
    }

    public void intern(@Nonnull Set<? extends Annotation> set) {
        if (set.size() > 0 && ((Integer) this.internedItems.put(set, 0)) == null) {
            Iterator<? extends Annotation> it = set.iterator();
            while (it.hasNext()) {
                ((AnnotationPool) this.dexPool.annotationSection).intern(it.next());
            }
        }
    }
}

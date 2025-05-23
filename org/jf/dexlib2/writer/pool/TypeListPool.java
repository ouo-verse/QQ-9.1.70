package org.jf.dexlib2.writer.pool;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.writer.TypeListSection;

/* loaded from: classes29.dex */
public class TypeListPool extends BaseNullableOffsetPool<Key<? extends Collection<? extends CharSequence>>> implements TypeListSection<CharSequence, Key<? extends Collection<? extends CharSequence>>> {

    /* loaded from: classes29.dex */
    public static class Key<TypeCollection extends Collection<? extends CharSequence>> implements Comparable<Key<? extends Collection<? extends CharSequence>>> {

        @Nonnull
        TypeCollection types;

        public Key(@Nonnull TypeCollection typecollection) {
            this.types = typecollection;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.types.size() != key.types.size()) {
                return false;
            }
            Iterator it = key.types.iterator();
            Iterator it5 = this.types.iterator();
            while (it5.hasNext()) {
                if (!((CharSequence) it5.next()).toString().equals(((CharSequence) it.next()).toString())) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            Iterator it = this.types.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                i3 = (i3 * 31) + ((CharSequence) it.next()).toString().hashCode();
            }
            return i3;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            Iterator it = this.types.iterator();
            while (it.hasNext()) {
                sb5.append(((CharSequence) it.next()).toString());
            }
            return sb5.toString();
        }

        @Override // java.lang.Comparable
        public int compareTo(Key<? extends Collection<? extends CharSequence>> key) {
            Iterator it = key.types.iterator();
            for (CharSequence charSequence : this.types) {
                if (!it.hasNext()) {
                    return 1;
                }
                int compareTo = charSequence.toString().compareTo(((CharSequence) it.next()).toString());
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return it.hasNext() ? -1 : 0;
        }
    }

    public TypeListPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    public void intern(@Nonnull Collection<? extends CharSequence> collection) {
        if (collection.size() > 0) {
            if (((Integer) this.internedItems.put(new Key(collection), 0)) == null) {
                Iterator<? extends CharSequence> it = collection.iterator();
                while (it.hasNext()) {
                    ((TypePool) this.dexPool.typeSection).intern(it.next());
                }
            }
        }
    }

    @Override // org.jf.dexlib2.writer.pool.BaseNullableOffsetPool, org.jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(@Nullable Key<? extends Collection<? extends CharSequence>> key) {
        if (key == null || key.types.size() == 0) {
            return 0;
        }
        return super.getNullableItemOffset((TypeListPool) key);
    }

    @Override // org.jf.dexlib2.writer.TypeListSection
    @Nonnull
    public Collection<? extends CharSequence> getTypes(Key<? extends Collection<? extends CharSequence>> key) {
        if (key == null) {
            return ImmutableList.of();
        }
        return key.types;
    }
}

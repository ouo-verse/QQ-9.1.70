package org.jf.dexlib2.writer.builder;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderMapEntryCollection<Key> extends AbstractCollection<Map.Entry<Key, Integer>> {

    @Nonnull
    private final Collection<Key> keys;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class MapEntry implements Map.Entry<Key, Integer> {

        @Nonnull
        private Key key;

        MapEntry() {
        }

        @Override // java.util.Map.Entry
        @Nonnull
        public Key getKey() {
            return this.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Integer getValue() {
            return Integer.valueOf(BuilderMapEntryCollection.this.getValue(this.key));
        }

        @Override // java.util.Map.Entry
        public Integer setValue(Integer num) {
            return Integer.valueOf(BuilderMapEntryCollection.this.setValue(this.key, num.intValue()));
        }
    }

    public BuilderMapEntryCollection(@Nonnull Collection<Key> collection) {
        this.keys = collection;
    }

    protected abstract int getValue(@Nonnull Key key);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @Nonnull
    public Iterator<Map.Entry<Key, Integer>> iterator() {
        final Iterator<Key> it = this.keys.iterator();
        return new Iterator<Map.Entry<Key, Integer>>() { // from class: org.jf.dexlib2.writer.builder.BuilderMapEntryCollection.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Map.Entry<Key, Integer> next() {
                MapEntry mapEntry = new MapEntry();
                mapEntry.key = it.next();
                return mapEntry;
            }
        };
    }

    protected abstract int setValue(@Nonnull Key key, int i3);

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.keys.size();
    }
}

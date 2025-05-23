package org.jf.dexlib2.rewriter;

import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RewriterUtils {
    public static <T> Iterable<T> rewriteIterable(@Nonnull final Rewriter<T> rewriter, @Nonnull final Iterable<? extends T> iterable) {
        return new Iterable<T>() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.3
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                final Iterator<T> it = iterable.iterator();
                return new Iterator<T>() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.3.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        return (T) RewriterUtils.rewriteNullable(rewriter, it.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        it.remove();
                    }
                };
            }
        };
    }

    public static <T> List<T> rewriteList(@Nonnull final Rewriter<T> rewriter, @Nonnull final List<? extends T> list) {
        return new AbstractList<T>() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.2
            @Override // java.util.AbstractList, java.util.List
            public T get(int i3) {
                return (T) RewriterUtils.rewriteNullable(Rewriter.this, list.get(i3));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return list.size();
            }
        };
    }

    @Nullable
    public static <T> T rewriteNullable(@Nonnull Rewriter<T> rewriter, @Nullable T t16) {
        if (t16 == null) {
            return null;
        }
        return rewriter.rewrite(t16);
    }

    public static <T> Set<T> rewriteSet(@Nonnull final Rewriter<T> rewriter, @Nonnull final Set<? extends T> set) {
        return new AbstractSet<T>() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            @Nonnull
            public Iterator<T> iterator() {
                final Iterator it = set.iterator();
                return new Iterator<T>() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        return (T) RewriterUtils.rewriteNullable(rewriter, it.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        it.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return set.size();
            }
        };
    }

    public static TypeReference rewriteTypeReference(@Nonnull final Rewriter<String> rewriter, @Nonnull final TypeReference typeReference) {
        return new BaseTypeReference() { // from class: org.jf.dexlib2.rewriter.RewriterUtils.4
            @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
            @Nonnull
            public String getType() {
                return (String) Rewriter.this.rewrite(typeReference.getType());
            }
        };
    }
}

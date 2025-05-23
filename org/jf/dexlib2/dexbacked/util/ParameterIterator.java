package org.jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseMethodParameter;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.MethodParameter;

/* loaded from: classes29.dex */
public class ParameterIterator implements Iterator<MethodParameter> {
    private final Iterator<? extends Set<? extends Annotation>> parameterAnnotations;
    private final Iterator<String> parameterNames;
    private final Iterator<? extends CharSequence> parameterTypes;

    public ParameterIterator(@Nonnull List<? extends CharSequence> list, @Nonnull List<? extends Set<? extends Annotation>> list2, @Nonnull Iterator<String> it) {
        this.parameterTypes = list.iterator();
        this.parameterAnnotations = list2.iterator();
        this.parameterNames = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.parameterTypes.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public MethodParameter next() {
        final Set<? extends Annotation> of5;
        final String charSequence = this.parameterTypes.next().toString();
        if (this.parameterAnnotations.hasNext()) {
            of5 = this.parameterAnnotations.next();
        } else {
            of5 = ImmutableSet.of();
        }
        final String next = this.parameterNames.hasNext() ? this.parameterNames.next() : null;
        return new BaseMethodParameter() { // from class: org.jf.dexlib2.dexbacked.util.ParameterIterator.1
            @Override // org.jf.dexlib2.iface.MethodParameter
            @Nonnull
            public Set<? extends Annotation> getAnnotations() {
                return of5;
            }

            @Override // org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
            @Nullable
            public String getName() {
                return next;
            }

            @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
            @Nonnull
            public String getType() {
                return charSequence;
            }
        };
    }
}

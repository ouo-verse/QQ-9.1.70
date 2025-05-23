package org.jf.dexlib2.writer.util;

import com.google.common.base.d;
import com.google.common.base.k;
import com.google.common.collect.l;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.dexlib2.util.EncodedValueUtils;
import org.jf.util.AbstractForwardSequentialList;
import org.jf.util.CollectionUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StaticInitializerUtil {
    private static final k<Field> HAS_INITIALIZER = new k<Field>() { // from class: org.jf.dexlib2.writer.util.StaticInitializerUtil.2
        @Override // com.google.common.base.k
        public boolean apply(Field field) {
            EncodedValue initialValue = field.getInitialValue();
            return (initialValue == null || EncodedValueUtils.isDefaultValue(initialValue)) ? false : true;
        }
    };
    private static final d<Field, EncodedValue> GET_INITIAL_VALUE = new d<Field, EncodedValue>() { // from class: org.jf.dexlib2.writer.util.StaticInitializerUtil.3
        @Override // com.google.common.base.d
        public EncodedValue apply(Field field) {
            EncodedValue initialValue = field.getInitialValue();
            return initialValue == null ? ImmutableEncodedValueFactory.defaultValueForType(field.getType()) : initialValue;
        }
    };

    @Nullable
    public static ArrayEncodedValue getStaticInitializers(@Nonnull final SortedSet<? extends Field> sortedSet) {
        final int lastIndexOf = CollectionUtils.lastIndexOf(sortedSet, HAS_INITIALIZER);
        if (lastIndexOf > -1) {
            return new BaseArrayEncodedValue() { // from class: org.jf.dexlib2.writer.util.StaticInitializerUtil.1
                @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
                @Nonnull
                public List<? extends EncodedValue> getValue() {
                    return new AbstractForwardSequentialList<EncodedValue>() { // from class: org.jf.dexlib2.writer.util.StaticInitializerUtil.1.1
                        @Override // org.jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                        @Nonnull
                        public Iterator<EncodedValue> iterator() {
                            return l.i(sortedSet).n(lastIndexOf + 1).o(StaticInitializerUtil.GET_INITIAL_VALUE).iterator();
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                        public int size() {
                            return lastIndexOf + 1;
                        }
                    };
                }
            };
        }
        return null;
    }
}

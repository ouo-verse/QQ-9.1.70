package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public interface z<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();

    @NullableDecl
    V get(K k3);
}

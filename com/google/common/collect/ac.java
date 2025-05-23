package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
interface ac<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}

package com.tencent.biz.richframework.collection;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;", "T", "Ljava/lang/ref/WeakReference;", "referent", "(Ljava/lang/Object;)V", "equals", "", "other", "", "hashCode", "", "common_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWComparableWeakRef<T> extends WeakReference<T> {
    public RFWComparableWeakRef(T t16) {
        super(t16);
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof RFWComparableWeakRef) {
            if (get() != null && Intrinsics.areEqual(get(), ((RFWComparableWeakRef) other).get())) {
                return true;
            }
            return false;
        }
        return super.equals(other);
    }

    public int hashCode() {
        if (get() != null) {
            T t16 = get();
            if (t16 != null) {
                return t16.hashCode();
            }
            return 0;
        }
        return super.hashCode();
    }
}

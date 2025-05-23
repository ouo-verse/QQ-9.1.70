package com.tencent.mobileqq.troop.troopsquare.home.vm;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0002\u00a8\u0006\u0007"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "mapper", "kotlin.jvm.PlatformType", "c", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <X, Y> LiveData<Y> c(LiveData<X> liveData, final Function1<? super X, ? extends Y> function1) {
        LiveData<Y> map = Transformations.map(liveData, new Function() { // from class: com.tencent.mobileqq.troop.troopsquare.home.vm.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Object d16;
                d16 = c.d(Function1.this, obj);
                return d16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(this, mapper)");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }
}

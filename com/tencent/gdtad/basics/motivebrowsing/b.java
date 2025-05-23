package com.tencent.gdtad.basics.motivebrowsing;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aA\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u00a8\u0006\u000b"}, d2 = {"T", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LiveData;", "liveData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "", "observer", "b", "qqad-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {
    public static final <T> void b(@NotNull LifecycleOwner lifecycleOwner, @NotNull LiveData<T> liveData, @NotNull final Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.gdtad.basics.motivebrowsing.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.c(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 observer, Object obj) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (obj != null) {
            observer.invoke(obj);
        }
    }
}

package e12;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001aA\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a%\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "observer", "c", "default", "b", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {
    public static final <T> T b(@NotNull LiveData<T> liveData, T t16) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        T value = liveData.getValue();
        if (value != null) {
            return value;
        }
        return t16;
    }

    public static final <T> void c(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner owner, @NotNull final Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        liveData.observe(owner, new Observer() { // from class: e12.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.d(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 observer, Object obj) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (obj != null) {
            observer.invoke(obj);
        }
    }
}

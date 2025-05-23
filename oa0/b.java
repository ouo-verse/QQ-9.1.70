package oa0;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Loa0/b;", "T", "Landroidx/lifecycle/Observer;", "Loa0/a;", "event", "", "a", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "onEventUnhandledContent", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b<T> implements Observer<a<? extends T>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<T, Unit> onEventUnhandledContent;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function1<? super T, Unit> onEventUnhandledContent) {
        Intrinsics.checkNotNullParameter(onEventUnhandledContent, "onEventUnhandledContent");
        this.onEventUnhandledContent = onEventUnhandledContent;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable a<? extends T> event) {
        T a16;
        if (event != null && (a16 = event.a()) != null) {
            this.onEventUnhandledContent.invoke(a16);
        }
    }
}

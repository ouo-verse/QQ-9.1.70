package kotlin;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "Lkotlin/Function0;", "", "listener", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    public static final void b(@NotNull View view, @NotNull final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        view.setOnClickListener(new e(new View.OnClickListener() { // from class: fq1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.c(Function0.this, view2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 listener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }
}

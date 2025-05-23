package jt1;

import android.view.View;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001\u00a8\u0006\b"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "", "action", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {
    public static final void b(@NotNull final View view, @NotNull final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        view.setOnClickListener(new View.OnClickListener() { // from class: jt1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.c(view, action, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_setOnClickListenerWithGuard, Function1 action, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_setOnClickListenerWithGuard, "$this_setOnClickListenerWithGuard");
        Intrinsics.checkNotNullParameter(action, "$action");
        QLog.i("ViewUtil", 1, "onclick | " + this_setOnClickListenerWithGuard.getId());
        if (o.a(this_setOnClickListenerWithGuard)) {
            QLog.i("ViewUtil", 1, "fastClick | " + this_setOnClickListenerWithGuard.getId());
        } else {
            action.invoke(this_setOnClickListenerWithGuard);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

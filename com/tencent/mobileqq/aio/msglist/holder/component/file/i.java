package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aB\u0010\n\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\"(\u0010\u0012\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Landroid/view/ViewGroup;", "", "style", "", "autoAdd", "Lkotlin/Function1;", "Landroid/widget/ProgressBar;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "(Landroid/view/ViewGroup;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;)Landroid/widget/ProgressBar;", "Landroid/view/View;", "value", "getLayout_constraintRight_toRightOf", "(Landroid/view/View;)I", "c", "(Landroid/view/View;I)V", "layout_constraintRight_toRightOf", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    private static final ProgressBar a(ViewGroup viewGroup, Integer num, boolean z16, Function1<? super ProgressBar, Unit> function1) {
        int i3;
        Context context = viewGroup.getContext();
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        ProgressBar progressBar = new ProgressBar(context, null, i3);
        Object invoke = LayoutBuilderKt.b().invoke(viewGroup, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        progressBar.setLayoutParams((ViewGroup.LayoutParams) invoke);
        function1.invoke(progressBar);
        if (z16) {
            viewGroup.addView(progressBar);
        }
        return progressBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ProgressBar b(ViewGroup viewGroup, Integer num, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return a(viewGroup, num, z16, function1);
    }

    public static final void c(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).rightToRight = i3;
        }
    }
}

package kk2;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\b\u0005\u00a8\u0006\b"}, d2 = {"Landroid/view/ViewGroup$LayoutParams;", "T", "Landroid/view/View;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    public static final <T extends ViewGroup.LayoutParams> void a(@NotNull View view, @NotNull Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type T of com.tencent.mobileqq.qqvideoedit.zplan.util.ViewExtKt.updateLayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }
}

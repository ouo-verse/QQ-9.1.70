package com.tencent.mobileqq.troop.teamup.publish;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\u000b"}, d2 = {"Landroid/view/View;", "V", "D", "", "Ljava/lang/Class;", "viewClass", "Lkotlin/Function2;", "", "binder", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    @NotNull
    public static final <V extends View, D> RecyclerView.Adapter<?> a(@NotNull List<? extends D> list, @NotNull Class<V> viewClass, @NotNull Function2<? super V, ? super D, Unit> binder) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(binder, "binder");
        return new a(viewClass, list, binder);
    }
}

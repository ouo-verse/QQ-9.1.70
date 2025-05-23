package com.tencent.mobileqq.guild.base.recyclerview.loadmore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.guild.util.qqui.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/b;", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;", "Landroid/view/ViewGroup;", "", "layoutResId", "Landroid/view/View;", h.F, HippyNestedScrollComponent.PRIORITY_PARENT, "f", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "holder", "e", "b", "c", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class b extends a {
    private final View h(ViewGroup viewGroup, @LayoutRes int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(this.context).infla\u2026layoutResId, this, false)");
        return inflate;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.loadmore.a
    @NotNull
    public View b(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(R.id.yrw);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.loadmore.a
    @NotNull
    public View c(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(R.id.yrx);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.loadmore.a
    @NotNull
    public View d(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return holder.getView(R.id.yry);
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.loadmore.a
    @NotNull
    public View e(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup viewGroup = (ViewGroup) holder.getView(R.id.yrz);
        if (viewGroup.getChildCount() == 0) {
            viewGroup.addView(d.c(viewGroup.getContext(), false));
        }
        return viewGroup;
    }

    @Override // com.tencent.mobileqq.guild.base.recyclerview.loadmore.a
    @NotNull
    public View f(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return h(parent, R.layout.f3n);
    }
}

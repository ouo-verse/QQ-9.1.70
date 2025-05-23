package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "upArrow", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "arrowView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final ImageView arrowView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.arrowView = (ImageView) itemView.findViewById(R.id.f53902dr);
    }

    public final void l(boolean upArrow) {
        if (upArrow) {
            ImageView imageView = this.arrowView;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_chevron_up_icon_secondary_01);
                return;
            }
            return;
        }
        ImageView imageView2 = this.arrowView;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.qui_chevron_down_icon_secondary);
        }
    }
}

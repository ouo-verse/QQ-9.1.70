package com.tencent.biz.qqcircle.immersive.search.prompt.history;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/history/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "hintResId", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvHint", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final TextView tvHint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.tvHint = (TextView) itemView.findViewById(R.id.f53952dw);
    }

    public final void l(int hintResId) {
        TextView textView = this.tvHint;
        if (textView != null) {
            textView.setText(hintResId);
        }
    }
}

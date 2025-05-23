package com.tencent.mobileqq.guild.aisearch.msgholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/msgholder/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "content", "", "bindData", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tipTextView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView tipTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.jm8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tip)");
        this.tipTextView = (TextView) findViewById;
    }

    public final void bindData(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.tipTextView.setText(content);
    }
}

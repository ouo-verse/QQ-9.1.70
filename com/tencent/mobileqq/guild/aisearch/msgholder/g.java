package com.tencent.mobileqq.guild.aisearch.msgholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001f\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/msgholder/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "queryString", "", "bindData", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "getUserTextView", "()Landroid/widget/TextView;", "userTextView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView userTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.userTextView = (TextView) itemView.findViewById(R.id.f115806x1);
    }

    public final void bindData(@NotNull String queryString) {
        Intrinsics.checkNotNullParameter(queryString, "queryString");
        this.userTextView.setText(queryString);
    }
}

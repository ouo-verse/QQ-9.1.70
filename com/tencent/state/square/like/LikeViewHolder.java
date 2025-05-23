package com.tencent.state.square.like;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/like/LikeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "from", "Landroid/widget/TextView;", "getFrom", "()Landroid/widget/TextView;", "head", "Lcom/tencent/state/view/CircleBoarderImageView;", "getHead", "()Lcom/tencent/state/view/CircleBoarderImageView;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "nick", "getNick", "time", "getTime", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeViewHolder extends RecyclerView.ViewHolder {
    private final TextView from;
    private final CircleBoarderImageView head;
    private final ImageView icon;
    private final TextView nick;
    private final TextView time;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeViewHolder(View contentView) {
        super(contentView);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        View findViewById = contentView.findViewById(R.id.qvu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.user_avatar)");
        this.head = (CircleBoarderImageView) findViewById;
        View findViewById2 = contentView.findViewById(R.id.qwc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.user_nick)");
        this.nick = (TextView) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.q56);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.like_from)");
        this.from = (TextView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.q7y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.master_like_icon)");
        this.icon = (ImageView) findViewById4;
        View findViewById5 = contentView.findViewById(R.id.q5d);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.like_time)");
        this.time = (TextView) findViewById5;
    }

    public final TextView getFrom() {
        return this.from;
    }

    public final CircleBoarderImageView getHead() {
        return this.head;
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final TextView getNick() {
        return this.nick;
    }

    public final TextView getTime() {
        return this.time;
    }
}

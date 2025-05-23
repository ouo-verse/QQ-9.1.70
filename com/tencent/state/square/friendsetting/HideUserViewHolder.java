package com.tencent.state.square.friendsetting;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ls4.f;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/friendsetting/HideUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "headView", "Landroid/widget/ImageView;", "getHeadView", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "nick", "Landroid/widget/TextView;", "getNick", "()Landroid/widget/TextView;", "Landroid/view/View;", "cancel", "Landroid/view/View;", "getCancel", "()Landroid/view/View;", "Lls4/f;", "data", "Lls4/f;", "getData", "()Lls4/f;", "setData", "(Lls4/f;)V", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "listener", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "getListener", "()Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "itemView", "<init>", "(Landroid/view/View;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class HideUserViewHolder extends RecyclerView.ViewHolder {
    private final View cancel;
    private f data;
    private final ImageView headView;
    private final IDecodeTaskCompletionListener listener;
    private final TextView nick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HideUserViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.qw8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.user_head)");
        this.headView = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.q_h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.nick)");
        this.nick = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.pi7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.cancel_hide)");
        this.cancel = findViewById3;
        this.listener = new IDecodeTaskCompletionListener() { // from class: com.tencent.state.square.friendsetting.HideUserViewHolder.1
            @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
            public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
                f data = HideUserViewHolder.this.getData();
                if (!Intrinsics.areEqual(uin, data != null ? String.valueOf(data.f415524a) : null) || avatar == null) {
                    return;
                }
                HideUserViewHolder.this.getHeadView().setImageBitmap(avatar);
            }
        };
    }

    public final View getCancel() {
        return this.cancel;
    }

    public final f getData() {
        return this.data;
    }

    public final ImageView getHeadView() {
        return this.headView;
    }

    public final IDecodeTaskCompletionListener getListener() {
        return this.listener;
    }

    public final TextView getNick() {
        return this.nick;
    }

    public final void setData(f fVar) {
        this.data = fVar;
    }
}

package com.tencent.mobileqq.minigame.va.downloadui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cancelView", "Landroid/widget/Button;", "getCancelView", "()Landroid/widget/Button;", "controllerView", "getControllerView", "coverView", "Landroid/widget/ImageView;", "getCoverView", "()Landroid/widget/ImageView;", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressDescription", "Landroid/widget/TextView;", "getProgressDescription", "()Landroid/widget/TextView;", "titleView", "getTitleView", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameDownloadingHolder extends RecyclerView.ViewHolder {
    private final Button cancelView;
    private final Button controllerView;
    private final ImageView coverView;
    private final ProgressBar progressBar;
    private final TextView progressDescription;
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGameDownloadingHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.rcr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.cover)");
        this.coverView = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.rlg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.title)");
        this.titleView = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.rkn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.progressbar)");
        this.progressBar = (ProgressBar) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.rkl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.progress_des)");
        this.progressDescription = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.rcq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.controller)");
        this.controllerView = (Button) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.rcl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.cancel)");
        this.cancelView = (Button) findViewById6;
    }

    public final Button getCancelView() {
        return this.cancelView;
    }

    public final Button getControllerView() {
        return this.controllerView;
    }

    public final ImageView getCoverView() {
        return this.coverView;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final TextView getProgressDescription() {
        return this.progressDescription;
    }

    public final TextView getTitleView() {
        return this.titleView;
    }
}

package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RecyclerView.ViewHolder {
    private QFSBottomConfigFeedItemView E;

    public a(@NonNull View view) {
        super(view);
    }

    public void l(d dVar, int i3) {
        View view = this.itemView;
        if (view instanceof QFSBottomConfigFeedItemView) {
            QFSBottomConfigFeedItemView qFSBottomConfigFeedItemView = (QFSBottomConfigFeedItemView) view;
            this.E = qFSBottomConfigFeedItemView;
            qFSBottomConfigFeedItemView.bindData(dVar, i3);
        }
    }
}

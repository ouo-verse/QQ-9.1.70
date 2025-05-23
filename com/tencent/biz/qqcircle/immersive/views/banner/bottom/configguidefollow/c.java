package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends RecyclerView.ViewHolder {
    private QFSBottomConfigGuideFollowItemView E;

    public c(@NonNull View view) {
        super(view);
    }

    public void l(d dVar, int i3) {
        View view = this.itemView;
        if (view instanceof QFSBottomConfigGuideFollowItemView) {
            QFSBottomConfigGuideFollowItemView qFSBottomConfigGuideFollowItemView = (QFSBottomConfigGuideFollowItemView) view;
            this.E = qFSBottomConfigGuideFollowItemView;
            qFSBottomConfigGuideFollowItemView.bindData(dVar, i3);
        }
    }
}

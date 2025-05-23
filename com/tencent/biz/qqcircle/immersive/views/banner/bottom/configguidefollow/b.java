package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends RecyclerView.ViewHolder {
    private QFSBottomConfigGuideFollowAllItemView E;

    public b(@NonNull View view) {
        super(view);
    }

    public void l(d dVar, int i3) {
        View view = this.itemView;
        if (view instanceof QFSBottomConfigGuideFollowAllItemView) {
            QFSBottomConfigGuideFollowAllItemView qFSBottomConfigGuideFollowAllItemView = (QFSBottomConfigGuideFollowAllItemView) view;
            this.E = qFSBottomConfigGuideFollowAllItemView;
            qFSBottomConfigGuideFollowAllItemView.bindData(dVar, i3);
        }
    }
}

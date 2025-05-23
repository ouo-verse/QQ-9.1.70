package com.tencent.biz.richframework.video.rfw.drive;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IRFWLayerItemViewScrollerStatus extends IRFWLayerScrollerStatus {
    RFWVideoView getVideoView();

    boolean isFloatingView();

    boolean isVideoType();

    void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder);

    void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder);
}

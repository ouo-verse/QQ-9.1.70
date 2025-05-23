package com.tencent.biz.richframework.animation.recyclerview;

import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface EnhanceHolderAnimationInterface {
    ViewPropertyAnimatorCompat getHolderChangeAnimation(EnhanceItemAnimator.ChangeInfo changeInfo, long j3, boolean z16);

    ViewPropertyAnimatorCompat getHolderMoveAnimation(EnhanceItemAnimator.MoveInfo moveInfo, long j3);

    ViewPropertyAnimatorCompat getHolderRemoveAnimation(RecyclerView.ViewHolder viewHolder);

    boolean onPreAnimateChange(EnhanceItemAnimator.ChangeInfo changeInfo);
}

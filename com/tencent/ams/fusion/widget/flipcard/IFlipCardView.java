package com.tencent.ams.fusion.widget.flipcard;

import com.tencent.ams.fusion.widget.base.AnimatableView;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IFlipCardView extends AnimatableView {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface BonusPageClickListener {
        void onClick(float f16, float f17);
    }

    void setBonusPageClickListener(BonusPageClickListener bonusPageClickListener);

    void setFlipCardInfo(FlipCardInfo flipCardInfo);

    void setInteractiveListener(FlipCardInteractiveListener flipCardInteractiveListener);
}

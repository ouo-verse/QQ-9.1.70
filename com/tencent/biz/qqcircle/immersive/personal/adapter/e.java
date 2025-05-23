package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalCollectBoxDetailHeadWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSPersonalCollectBoxDetailHeadWidget C;

    public e(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        if (this.C == null) {
            this.C = new QFSPersonalCollectBoxDetailHeadWidget(viewGroup.getContext(), (QCircleBaseFragment) getParentFragment(), this);
        }
        this.C.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPersonalCollectBoxDetailHeadBlock";
    }

    public void i0(QQCircleFeedBase$StFavoritesFeedsPageRsp qQCircleFeedBase$StFavoritesFeedsPageRsp) {
        QFSPersonalCollectBoxDetailHeadWidget qFSPersonalCollectBoxDetailHeadWidget = this.C;
        if (qFSPersonalCollectBoxDetailHeadWidget != null) {
            qFSPersonalCollectBoxDetailHeadWidget.l0(qQCircleFeedBase$StFavoritesFeedsPageRsp);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

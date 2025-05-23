package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoPanelWidget;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends j {
    public a(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.j, com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    /* renamed from: i0 */
    public QCircleBaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPersonalInfoPanelWidget qFSPersonalInfoPanelWidget = new QFSPersonalInfoPanelWidget(viewGroup.getContext(), (QFSPersonalDetailsFragment) getParentFragment());
        this.C = qFSPersonalInfoPanelWidget;
        qFSPersonalInfoPanelWidget.setReportBean(getReportBean());
        return this.C;
    }
}

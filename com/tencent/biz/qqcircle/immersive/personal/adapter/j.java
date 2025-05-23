package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends com.tencent.biz.qqcircle.bizparts.c {
    protected QFSPersonalInfoWidget C;

    public j(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPersonalInfoBlock";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public QCircleBaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = new QFSPersonalInfoWidget(viewGroup.getContext(), (QFSPersonalDetailsFragment) getParentFragment());
        this.C = qFSPersonalInfoWidget;
        qFSPersonalInfoWidget.setReportBean(getReportBean());
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = this.C;
        if (qFSPersonalInfoWidget != null) {
            qFSPersonalInfoWidget.onPartDestroy(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = this.C;
        if (qFSPersonalInfoWidget != null) {
            qFSPersonalInfoWidget.x0(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = this.C;
        if (qFSPersonalInfoWidget != null) {
            qFSPersonalInfoWidget.y0(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStart(Activity activity) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = this.C;
        if (qFSPersonalInfoWidget != null) {
            qFSPersonalInfoWidget.z0(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(Activity activity) {
        QFSPersonalInfoWidget qFSPersonalInfoWidget = this.C;
        if (qFSPersonalInfoWidget != null) {
            qFSPersonalInfoWidget.A0(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

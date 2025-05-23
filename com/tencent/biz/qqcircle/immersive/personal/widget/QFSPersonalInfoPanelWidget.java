package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalInfoPanelWidget extends QFSPersonalInfoWidget {
    public QFSPersonalInfoPanelWidget(Context context, QFSPersonalDetailsFragment qFSPersonalDetailsFragment) {
        super(context, qFSPersonalDetailsFragment);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget
    protected boolean C0() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalInfoWidget, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalInfoPanelWidget";
    }
}

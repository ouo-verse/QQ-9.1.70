package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedChannelView extends QFSMixFeedBaseWidgetView<e30.b> {

    /* renamed from: e, reason: collision with root package name */
    private QFSMixFeedFlipper f90854e;

    public QFSMixFeedChannelView(@NonNull Context context) {
        super(context);
        QFSMixFeedFlipper qFSMixFeedFlipper = (QFSMixFeedFlipper) findViewById(R.id.f47161wj);
        this.f90854e = qFSMixFeedFlipper;
        qFSMixFeedFlipper.setContentRootView(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gja;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedChannelView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            QQCircleDitto$StItemContainer i16 = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            if (i16 != null && i16.items.size() >= 1) {
                this.f90854e.setVisibility(0);
                this.f90854e.setData(i16.items.get(), i3);
                j20.a aVar = (j20.a) getInteractor();
                if (aVar != null && aVar.isContainerOnScreen()) {
                    QLog.d("QFSMixFeedChannelView", 1, "[bindData] isContainerOnScreen = true");
                    this.f90854e.g();
                }
                this.f90854e.setInteractor(aVar);
                return;
            }
            QLog.e("QFSMixFeedChannelView", 1, "[bindData] stItemContainer == null || stItemContainer.items.size() < 1");
            this.f90854e.setVisibility(8);
            return;
        }
        QLog.e("QFSMixFeedChannelView", 1, "[bindData] feedBlockData == null");
    }
}

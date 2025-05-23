package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.bean.g;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxAddFeedItemView<T extends com.tencent.biz.qqcircle.immersive.personal.bean.g> extends QFSPersonalPraisedItemView<T> {
    public QUICheckBox D;

    public QFSPersonalCollectBoxAddFeedItemView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void s0(T t16) {
        this.f89202f.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPraisedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalCollectBoxAddFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPraisedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.D = (QUICheckBox) view.findViewById(R.id.y1d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPraisedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void bindData(T t16, int i3) {
        super.bindData(t16, i3);
        this.D.setChecked(t16.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void r0(T t16) {
        this.f89201e.setVisibility(8);
    }
}

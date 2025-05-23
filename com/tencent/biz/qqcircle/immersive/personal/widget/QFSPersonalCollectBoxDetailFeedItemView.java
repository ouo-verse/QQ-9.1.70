package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxDetailFeedItemView extends QFSPersonalCollectBoxAddFeedItemView<com.tencent.biz.qqcircle.immersive.personal.bean.h> {
    public QFSPersonalCollectBoxDetailFeedItemView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedItemView
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.h hVar, int i3) {
        super.bindData(hVar, i3);
        if (hVar.k()) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedItemView
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void r0(com.tencent.biz.qqcircle.immersive.personal.bean.h hVar) {
        int i3 = 8;
        if (hVar.k()) {
            this.f89201e.setVisibility(8);
            return;
        }
        ImageView imageView = this.f89201e;
        if (hVar.e() == 2) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPraisedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedItemView, com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalCollectBoxDetailFeedItemView";
    }
}

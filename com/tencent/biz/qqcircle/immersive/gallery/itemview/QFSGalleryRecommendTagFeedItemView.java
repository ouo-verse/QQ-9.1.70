package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryRecommendTagFeedItemView extends QCircleBaseWidgetView<List<QQCircleDitto$StItemInfo>> {

    /* renamed from: d, reason: collision with root package name */
    private QFSGalleryRecommendTagFeedSubItemView f86441d;

    /* renamed from: e, reason: collision with root package name */
    private QFSGalleryRecommendTagFeedSubItemView f86442e;

    public QFSGalleryRecommendTagFeedItemView(@NonNull Context context) {
        super(context);
        l0(this);
    }

    private void l0(View view) {
        this.f86441d = (QFSGalleryRecommendTagFeedSubItemView) view.findViewById(R.id.f43261m0);
        this.f86442e = (QFSGalleryRecommendTagFeedSubItemView) view.findViewById(R.id.f43271m1);
    }

    private void m0(List<QQCircleDitto$StItemInfo> list) {
        if (list != null && list.size() == 2) {
            QFSGalleryRecommendTagFeedSubItemView qFSGalleryRecommendTagFeedSubItemView = this.f86441d;
            if (qFSGalleryRecommendTagFeedSubItemView != null && this.f86442e != null) {
                qFSGalleryRecommendTagFeedSubItemView.setData(list.get(0));
                this.f86442e.setData(list.get(1));
                return;
            } else {
                QLog.d("QFSGalleryRecommendTagFeedItemView", 1, "sub item is null");
                return;
            }
        }
        QLog.d("QFSGalleryRecommendTagFeedItemView", 1, "tag item info is null");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gcz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryRecommendTagFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<QQCircleDitto$StItemInfo> list, int i3) {
        m0(list);
    }
}

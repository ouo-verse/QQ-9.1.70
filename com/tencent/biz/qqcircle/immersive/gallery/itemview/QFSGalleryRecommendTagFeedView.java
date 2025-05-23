package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.gallery.adapter.b;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryRecommendTagFeedView extends QCircleBaseWidgetView<QQCircleDitto$StItemContainer> {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f86449d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView.LayoutManager f86450e;

    /* renamed from: f, reason: collision with root package name */
    private b f86451f;

    public QFSGalleryRecommendTagFeedView(@NonNull Context context) {
        super(context);
        l0(this);
    }

    private void l0(View view) {
        if (view == null) {
            QLog.d("QFSGalleryRecommendTagFeedView", 1, "rootView is null, return");
            return;
        }
        this.f86449d = (RecyclerView) view.findViewById(R.id.f43191lt);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 0, false);
        this.f86450e = safeLinearLayoutManager;
        this.f86449d.setLayoutManager(safeLinearLayoutManager);
        this.f86449d.setItemAnimator(new DefaultItemAnimator());
        b bVar = new b();
        this.f86451f = bVar;
        bVar.k0(this.f86449d);
        this.f86449d.setAdapter(this.f86451f);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gcy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryRecommendTagFeedView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer, int i3) {
        b bVar = this.f86451f;
        if (bVar != null) {
            bVar.j0(qQCircleDitto$StItemContainer);
        }
    }
}

package com.tencent.biz.qqcircle.comment.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSCommentAreaTabItemInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSCommentAreaTabBaseView extends QCircleBaseWidgetView<QFSCommentAreaTabItemInfo> {
    protected com.tencent.biz.qqcircle.viewmodels.m C;

    /* renamed from: d, reason: collision with root package name */
    private final QCircleBlockContainer f84027d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.adapter.q f84028e;

    /* renamed from: f, reason: collision with root package name */
    private final QCirclePanelLoadingView f84029f;

    /* renamed from: h, reason: collision with root package name */
    private final ViewGroup f84030h;

    /* renamed from: i, reason: collision with root package name */
    protected final TextView f84031i;

    /* renamed from: m, reason: collision with root package name */
    private final View f84032m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f84034d;

        b(RecyclerView recyclerView) {
            this.f84034d = recyclerView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f84034d.getViewTreeObserver().removeOnPreDrawListener(this);
            com.tencent.biz.qqcircle.utils.d.j(this.f84034d);
            return false;
        }
    }

    public QFSCommentAreaTabBaseView(@NonNull Context context) {
        super(context);
        this.f84027d = (QCircleBlockContainer) findViewById(R.id.f30790pa);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f164853b42);
        this.f84030h = viewGroup;
        this.f84031i = (TextView) viewGroup.findViewById(R.id.f166327f13);
        View findViewById = viewGroup.findViewById(R.id.f361113o);
        this.f84032m = findViewById;
        findViewById.setVisibility(8);
        QCirclePanelLoadingView qCirclePanelLoadingView = (QCirclePanelLoadingView) findViewById(R.id.f30810pc);
        this.f84029f = qCirclePanelLoadingView;
        qCirclePanelLoadingView.setHintText("");
        qCirclePanelLoadingView.setNeedHideWhenDetachedFromWindow(false);
        q0();
        o0();
        p0();
    }

    private void q0() {
        this.C = (com.tencent.biz.qqcircle.viewmodels.m) getViewModel(com.tencent.biz.qqcircle.viewmodels.m.class);
        QLog.d("QFSCommentAreaTabVPAdapter", 4, "initBlock");
        if (this.C == null) {
            QLog.e("QFSCommentAreaTabVPAdapter", 4, "initBlock, viewModel is null. ");
        }
    }

    private void r0(boolean z16) {
        int i3;
        QCircleBlockContainer qCircleBlockContainer = this.f84027d;
        if (qCircleBlockContainer == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qCircleBlockContainer.setVisibility(i3);
        if (z16 && this.f84027d.getRecyclerView() != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f84027d.getRecyclerView(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
        }
    }

    private void w0() {
        NestScrollRecyclerView recyclerView;
        QCircleBlockContainer qCircleBlockContainer = this.f84027d;
        if (qCircleBlockContainer == null) {
            recyclerView = null;
        } else {
            recyclerView = qCircleBlockContainer.getRecyclerView();
        }
        if (recyclerView == null) {
            QLog.e(getLogTag(), 1, "showTopAnimation recyclerView is null");
        } else {
            QLog.d(getLogTag(), 1, "showTopAnimation");
            recyclerView.getViewTreeObserver().addOnPreDrawListener(new b(recyclerView));
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentAreaTabVPAdapter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo, int i3) {
        QLog.d(getLogTag(), 1, "[bindData]");
    }

    public com.tencent.biz.qqcircle.adapter.q l0() {
        return this.f84028e;
    }

    public QCircleBlockContainer m0() {
        return this.f84027d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(UIStateData<List<QFSCommentAreaTabItemInfo>> uIStateData) {
        boolean z16;
        QLog.d("QFSCommentAreaTabVPAdapter", 4, "handleRsp");
        if (uIStateData == null) {
            QLog.e(getLogTag(), 1, "[handleRsp] listUIStateData == null");
            r0(false);
            this.f84027d.getRecyclerView().scrollToPosition(0);
            return;
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 1) {
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                } else {
                    QLog.d("QFSCommentAreaTabVPAdapter", 4, "handleRsp isFinish: " + uIStateData.getIsFinish());
                    this.f84028e.setDatas(uIStateData.getData());
                    if (uIStateData.getData() != null && uIStateData.getData().size() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    s0(z16);
                    u0(false);
                    s0(false);
                    this.f84027d.getBlockMerger().onLoadMoreCompleted(true, uIStateData.getIsFinish());
                    this.f84028e.getLoadInfo().setFinish(uIStateData.getIsFinish());
                    this.f84028e.getLoadInfo().setCurrentState(4);
                    if (!uIStateData.getIsLoadMore()) {
                        w0();
                    }
                    r0(true);
                    if (!uIStateData.getIsLoadMore()) {
                        VideoReport.traversePage(this.f84027d);
                        return;
                    }
                    return;
                }
            } else {
                r0(false);
                s0(false);
                u0(true);
                return;
            }
        }
        QLog.d("QFSCommentAreaTabVPAdapter", 4, "handleRsp uiState: " + uIStateData.getState());
        u0(false);
        s0(true);
        r0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0() {
        if (this.f84027d == null) {
            return;
        }
        com.tencent.biz.qqcircle.adapter.q qVar = new com.tencent.biz.qqcircle.adapter.q(null);
        this.f84028e = qVar;
        qVar.i0(this.C);
        this.f84027d.getRecyclerView().setNestedScrollingEnabled(true);
        this.f84027d.getRecyclerView().addOnScrollListener(new a());
        this.f84027d.registerBlock(this.f84028e);
        v0(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921346o));
    }

    protected abstract void p0();

    protected void s0(boolean z16) {
        int i3;
        ViewGroup viewGroup = this.f84030h;
        if (viewGroup == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
    }

    protected void u0(boolean z16) {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.f84029f;
        if (qCirclePanelLoadingView == null) {
            return;
        }
        if (z16) {
            qCirclePanelLoadingView.n0();
        } else {
            qCirclePanelLoadingView.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0(String str) {
        QCircleBlockMerger blockMerger;
        QCircleBlockContainer qCircleBlockContainer = this.f84027d;
        if (qCircleBlockContainer != null && (blockMerger = qCircleBlockContainer.getBlockMerger()) != null && !TextUtils.isEmpty(str)) {
            blockMerger.setNoMoreHint(str);
        }
    }
}

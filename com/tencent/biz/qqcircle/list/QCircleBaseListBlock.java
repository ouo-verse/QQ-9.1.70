package com.tencent.biz.qqcircle.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.b;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import java.io.Serializable;
import java.util.List;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QCircleBaseListBlock<E, T> extends BaseListBlock<E, T> {
    protected QCircleExtraTypeInfo mExtraTypeInfo;
    private QCircleReportBean mReportBean;

    public QCircleBaseListBlock(Bundle bundle) {
        super(bundle);
    }

    protected void assembleFromReportData() {
        Intent intent;
        QCircleInitBean qCircleInitBean;
        QCircleReportBean qCircleReportBean;
        if (getHostFragment() != null && getHostFragment().getActivity() != null && (intent = getHostFragment().getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean") && (qCircleInitBean = (QCircleInitBean) intent.getSerializableExtra("key_bundle_common_init_bean")) != null && qCircleInitBean.getFromReportBean() != null && (qCircleReportBean = this.mReportBean) != null) {
            qCircleReportBean.assembleFromReportData(qCircleInitBean.getFromReportBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleStatusView createStatusView() {
        final QCircleFullScreenStatusView qCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
        qCircleFullScreenStatusView.setEmptyImageAndText(getEmptyStateImageType(), getEmptyStateTitleText(), getEmptyStateDescText(), getEmptyStateActionText());
        qCircleFullScreenStatusView.J0();
        qCircleFullScreenStatusView.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.list.QCircleBaseListBlock.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QCircleBaseListBlock.this.onRefreshData();
                QCircleFullScreenStatusView qCircleFullScreenStatusView2 = qCircleFullScreenStatusView;
                if (qCircleFullScreenStatusView2 != null) {
                    qCircleFullScreenStatusView2.setVisibility(8);
                }
                if (QCircleBaseListBlock.this.getBlockMerger() instanceof QCircleBlockMerger) {
                    ((QCircleBlockMerger) QCircleBaseListBlock.this.getBlockMerger()).k0();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return qCircleFullScreenStatusView;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ String getAttachInfoFromItemData(E e16);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ String getAttachInfoFromRsp(Object obj);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getBackgroundColor() {
        return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getEmptyStateActionText() {
        return c.F3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getEmptyStateDescText() {
        return c.G3();
    }

    protected int getEmptyStateImageType() {
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getEmptyStateTitleText() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ boolean getIsFinishFromRsp(Object obj);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ void getListDataAsync(IDataCallBack<E> iDataCallBack, String str);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ List<E> getListDataFromRsp(Object obj, boolean z16);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ int getPageCount();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.a
    public int getPageId() {
        return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected int getParentPageId() {
        return QCircleReportBean.getParentPageId(getLogTag(), this.mReportBean);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ Object getRequest(String str);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getStatusBarColor() {
        return QCirclePluginUtil.getDefaultThemeColor();
    }

    protected boolean needShowFullScreenStatusView() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        QLog.d(getLogTag(), 1, "onPrepareParams");
        if (getBlockContainer() == null) {
            return;
        }
        if (needShowFullScreenStatusView()) {
            getBlockContainer().setStatusViewInterface(createStatusView());
        } else {
            QLog.d(getLogTag(), 1, "[onInitBlock] not need show full screen status view");
        }
        Serializable serializable = this.mInitBean;
        if (serializable instanceof QCircleInitBean) {
            this.mExtraTypeInfo = ((QCircleInitBean) serializable).getExtraTypeInfo();
        }
        NestScrollRecyclerView recyclerView = getBlockContainer().getRecyclerView();
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.biz.qqcircle.list.QCircleBaseListBlock.1
                public void handleScrollChanged(int i3) {
                    QCircleAspectScrollProcessor.getInstance().onScrollState(QCircleBaseListBlock.this, i3);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView2, int i3) {
                    super.onScrollStateChanged(recyclerView2, i3);
                    handleScrollChanged(i3);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().setSoftInputMode(32);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        j.f().h();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showEmptyView() {
        String emptyHint;
        if (!needShowFullScreenStatusView()) {
            QLog.d(getLogTag(), 1, "[showEmptyView] not need show full screen status view");
            return;
        }
        if (getHostFragment() != null && getHostFragment().sh() != null && getHostFragment().sh().getStatusInterface() != null) {
            IStatusViewProvider statusInterface = getHostFragment().sh().getStatusInterface();
            if (getEmptyHint() == null) {
                emptyHint = "";
            } else {
                emptyHint = getEmptyHint();
            }
            statusInterface.showEmptyView(emptyHint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showErrorView(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            str = h.a(R.string.f181603e8);
        }
        String str2 = str;
        boolean needShowFullScreenStatusView = needShowFullScreenStatusView();
        QLog.e(getLogTag(), 1, " return error\uff01errMsg:" + str2 + ", needShowFullScreenStatusView = " + needShowFullScreenStatusView);
        if (getNUM_BACKGOURND_ICON() > 0) {
            cj.c(false, j3, str2, 1, QCircleToast.f91645e);
        } else if (getHostFragment() != null && getHostFragment().sh() != null && needShowFullScreenStatusView) {
            ((QCircleStatusView) getHostFragment().sh().getStatusInterface()).A0(str2, !QCirclePluginUtil.isRequestSecurityHit(j3), j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            this.mReportBean = new QCircleReportBean();
        }
        assembleFromReportData();
        return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }
}

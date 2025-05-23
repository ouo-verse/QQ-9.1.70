package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSUnsupportedMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.widget.QFSMessageDeleteBottomSheet;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.helpers.r;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoriesRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseMessageListBlock<T> extends QCircleBaseListBlock<QFSMessageItemInfo, T> {
    private static final String TAG = "QFSBaseMessageListBlock";
    protected int launchTo;
    protected int mCurrentSelectedType;
    protected int mDrawerId;
    private boolean mFromPush;
    protected QCircleInitBean mInitBean;
    protected boolean mIsFirstResume;
    private QCirclePanelLoadingView mLoadingView;
    protected NestScrollRecyclerView mRecyclerView;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
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

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSMessageItemInfo f91428d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f91429e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QFSBaseMessageItemView f91430f;

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements QFSMessageDeleteBottomSheet.a {
            a() {
            }

            @Override // com.tencent.biz.qqcircle.fragments.message.widget.QFSMessageDeleteBottomSheet.a
            public void onClick() {
                b bVar = b.this;
                if (!QFSBaseMessageListBlock.this.deletePrivateMessage(bVar.f91428d, bVar.f91429e)) {
                    b bVar2 = b.this;
                    QFSBaseMessageListBlock.this.handleDeleteMessage(bVar2.f91428d, bVar2.f91429e);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock$b$b, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0919b implements j.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QFSMessageDeleteBottomSheet.a f91433a;

            C0919b(QFSMessageDeleteBottomSheet.a aVar) {
                this.f91433a = aVar;
            }

            @Override // com.tencent.biz.qqcircle.j.f
            public void onClick(int i3) {
                Context context = QFSBaseMessageListBlock.this.getContext();
                b bVar = b.this;
                new QFSMessageDeleteBottomSheet(context, bVar.f91430f, this.f91433a, bVar.f91428d).show();
                b bVar2 = b.this;
                QFSBaseMessageListBlock.this.dtReportDeletePopMenuClick(bVar2.f91430f, bVar2.f91428d);
            }
        }

        b(QFSMessageItemInfo qFSMessageItemInfo, int i3, QFSBaseMessageItemView qFSBaseMessageItemView) {
            this.f91428d = qFSMessageItemInfo;
            this.f91429e = i3;
            this.f91430f = qFSBaseMessageItemView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (this.f91428d.isNeedTop()) {
                z16 = false;
            } else {
                com.tencent.biz.qqcircle.j.f().j(this.f91430f, new C0919b(new a()), null);
                QFSBaseMessageListBlock.this.dtReportDeletePopMenuImp(this.f91430f, this.f91428d);
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSMessageItemInfo f91435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f91436b;

        c(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
            this.f91435a = qFSMessageItemInfo;
            this.f91436b = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (j3 == 0 && z16) {
                QLog.d(QFSBaseMessageListBlock.TAG, 1, "[handleDeleteMessage] request delete success");
                QFSBaseMessageListBlock.this.getDataList().remove(this.f91435a);
                QFSBaseMessageListBlock.this.notifyItemRemoved(this.f91436b);
                List<QFSMessageItemInfo> dataList = QFSBaseMessageListBlock.this.getDataList();
                if (dataList != null && dataList.isEmpty()) {
                    QFSBaseMessageListBlock.this.onRefreshData();
                }
            }
        }
    }

    public QFSBaseMessageListBlock(Bundle bundle) {
        super(bundle);
        this.mIsFirstResume = true;
        this.mCurrentSelectedType = -1;
    }

    private void handleLoading() {
        BaseRequest baseRequest = (BaseRequest) getRequest(null);
        if (baseRequest instanceof QFSMessageNoticeCategoriesRequest) {
            ((QFSMessageNoticeCategoriesRequest) baseRequest).enableTransRedPointInfo();
        }
        if (BaseRequest.isCacheExist(baseRequest)) {
            if (needShowRefreshAnimationWhenCacheDataLoaded()) {
                getBlockMerger().getRefreshViewProvider().setState(4);
                return;
            }
            return;
        }
        getHostFragment().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock.2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    QFSBaseMessageListBlock.this.showLoadingView();
                    QFSBaseMessageListBlock.this.getHostFragment().getLifecycle().removeObserver(this);
                }
            }
        });
    }

    private void hideLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.mLoadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
            if (getBlockContainer() != null) {
                getBlockContainer().setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        QLog.d(getLogTag(), 1, "showLoadingView");
        View view = getHostFragment().getView();
        if (view == null) {
            return;
        }
        if (this.mLoadingView == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.f1204479k);
            if (viewStub == null) {
                return;
            } else {
                this.mLoadingView = (QCirclePanelLoadingView) viewStub.inflate();
            }
        }
        if (getBlockContainer() != null) {
            getBlockContainer().setVisibility(8);
        }
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918345v));
        this.mLoadingView.n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public QCircleStatusView createStatusView() {
        QCircleStatusView createStatusView = super.createStatusView();
        createStatusView.setBackgroundColorType(0);
        PublicListInnerFragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            createStatusView.setBackgroundDrawable(hostFragment.getResources().getDrawable(R.drawable.kkg));
        }
        return createStatusView;
    }

    public boolean deletePrivateMessage(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        List<QFSMessageItemInfo> dataList;
        if (qFSMessageItemInfo == null || qFSMessageItemInfo.getType() != -103 || (dataList = getDataList()) == null) {
            return false;
        }
        HostDataTransUtils.removeMessage(qFSMessageItemInfo.getRecentData());
        q.r().i(qFSMessageItemInfo.getRecentData());
        dataList.remove(qFSMessageItemInfo);
        notifyItemRemoved(i3);
        if (dataList.isEmpty()) {
            onRefreshData();
            return true;
        }
        return true;
    }

    protected void dtReportDeletePopMenuClick(View view, QFSMessageItemInfo qFSMessageItemInfo) {
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, new QCircleDTParamBuilder().buildElementParams());
    }

    protected void dtReportDeletePopMenuImp(View view, QFSMessageItemInfo qFSMessageItemInfo) {
        VideoReport.setElementId(view, "em_xsj_delete_button");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, new QCircleDTParamBuilder().buildElementParams());
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(QFSMessageItemInfo qFSMessageItemInfo) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ String getAttachInfoFromRsp(Object obj);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getContentLayoutId() {
        return R.layout.g4h;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_MESSAGE_NOTICE();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ boolean getIsFinishFromRsp(Object obj);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() != null && getDataList().size() > i3) {
            QFSMessageItemInfo qFSMessageItemInfo = getDataList().get(i3);
            if (qFSMessageItemInfo.getType() == -100) {
                return qFSMessageItemInfo.getStNotice().noticeType.get();
            }
            return qFSMessageItemInfo.getType();
        }
        QLog.e(getLogTag(), 2, "getItemViewType()  return MESSAGE_TYPE_UNSUPPORTED");
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ List<Object> getListDataFromRsp(Object obj, boolean z16);

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ Object getRequest(String str);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return q.r().A().size() + 1;
    }

    public void handleDeleteMessage(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        q.r().j(qFSMessageItemInfo, new c(qFSMessageItemInfo, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleItemOnLongClick(BaseListBlock.BaseListVH baseListVH, QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        if (baseListVH != null && qFSMessageItemInfo != null) {
            View view = baseListVH.itemView;
            if (!(view instanceof QFSBaseMessageItemView)) {
                return;
            }
            QFSBaseMessageItemView qFSBaseMessageItemView = (QFSBaseMessageItemView) view;
            qFSBaseMessageItemView.setOnLongClickListener(new b(qFSMessageItemInfo, i3, qFSBaseMessageItemView));
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    protected boolean needShowRefreshAnimationWhenCacheDataLoaded() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void notifyAfterHandleListData(boolean z16, boolean z17, boolean z18) {
        hideLoadingView();
        if (!z16) {
            notifyLoadingComplete(true, z18);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean onBackEvent() {
        if (this.mFromPush) {
            QLog.d(getLogTag(), 1, "mFromPush back launchFolderPage");
            if (QCircleReportHelper.getInstance().getPageStackSize() <= 1) {
                com.tencent.biz.qqcircle.launcher.c.I(getContext(), new QCircleFolderBean());
            }
            getActivity().finish();
            return true;
        }
        QLog.d(getLogTag(), 1, "not mFromPush back finish");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (getDataList() != null && (viewHolder instanceof BaseListBlock.BaseListVH)) {
            QFSMessageItemInfo qFSMessageItemInfo = getDataList().get(i3);
            qFSMessageItemInfo.setLaunchTo(this.launchTo);
            ((BaseListBlock.BaseListVH) viewHolder).setData(qFSMessageItemInfo, i3, this.mExtraTypeInfo);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        FragmentActivity activity = getParentFragment().getActivity();
        Class<? extends QFSBaseMessageItemView> cls = q.r().A().get(Integer.valueOf(i3));
        if (cls != null) {
            try {
                QFSBaseMessageItemView newInstance = cls.getConstructor(Context.class, Integer.TYPE).newInstance(activity, Integer.valueOf(i3));
                newInstance.setReportBean(getReportBean());
                newInstance.setPageParam(this.launchTo, this.mCurrentSelectedType);
                return new BaseListBlock.BaseListVH(newInstance);
            } catch (Exception e16) {
                QLog.w(getLogTag(), 1, "getItemViewConstructor reflect error: viewType=" + i3 + ", itemViewClass=" + cls + "\nerror: " + e16);
            }
        }
        QLog.e(getLogTag(), 2, "onCreateViewHolder()  return new QFSUnsupportedMessageItemView()");
        return new BaseListBlock.BaseListVH(new QFSUnsupportedMessageItemView(activity, i3));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        String str;
        super.onInitBlock(bundle);
        if (bundle == null) {
            QLog.e(getLogTag(), 1, "onInitBlock params is null");
            return;
        }
        QCircleInitBean qCircleInitBean = (QCircleInitBean) bundle.getSerializable("key_bundle_common_init_bean");
        if (qCircleInitBean != null) {
            this.launchTo = qCircleInitBean.getLaunchTo();
            this.mDrawerId = qCircleInitBean.getDrawerId();
            str = qCircleInitBean.getLaunchFrom();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mFromPush = TextUtils.equals(str, String.valueOf(7));
        }
        int i3 = bundle.getInt("key_from_page_id", 0);
        setReportBean(new QCircleReportBean().setPageId(59).setFromPageId(i3).setDtPageId(getDaTongPageId()));
        QLog.d(getLogTag(), 1, "[onInitBlock] launchTo:" + this.launchTo + ", mDrawerId:" + this.mDrawerId + ", mFromPush:" + this.mFromPush + ", fromPageId:" + i3);
        Context context = getContext();
        if (getBlockMerger() != null && context != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(context);
            qFSNormalNoMoreHintView.setHintTextColor(QFSQUIUtilsKt.d(context, R.color.qui_common_text_tertiary));
            getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        this.mRecyclerView = getBlockContainer().getRecyclerView();
        handleLoading();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        QLog.d(getLogTag(), 1, "onPartCreate");
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d(getLogTag(), 1, "onPartDestroy");
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.mIsFirstResume = false;
        QLog.d(getLogTag(), 1, "onPartPause");
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        r.a().b();
        QLog.d(getLogTag(), 1, "onPartResume");
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    public void setCurrentSelectedType(int i3) {
        this.mCurrentSelectedType = i3;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void setInitBean(Serializable serializable) {
        super.setInitBean(serializable);
        this.mInitBean = (QCircleInitBean) serializable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showErrorView(String str, long j3) {
        super.showErrorView(str, j3);
        hideLoadingView();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<QFSMessageItemInfo> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}

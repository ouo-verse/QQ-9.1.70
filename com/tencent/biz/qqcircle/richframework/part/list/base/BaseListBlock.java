package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseListBlock<E, T> extends com.tencent.biz.qqcircle.bizparts.a<E> {
    public static final String PAGE_BLOCK_POSITION = "page_block_position";
    private List<E> mAllListData;
    protected Serializable mInitBean;
    protected boolean mIsFinish;
    protected String mLastAttachInfo;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class BaseListVH extends RecyclerView.ViewHolder {
        public BaseListVH(BaseWidgetView baseWidgetView) {
            super(baseWidgetView);
        }

        public void setData(Object obj, int i3, QCircleExtraTypeInfo qCircleExtraTypeInfo) {
            View view = this.itemView;
            if (view instanceof BaseWidgetView) {
                view.setTag(this);
                ((BaseWidgetView) this.itemView).setExtraTypeInfo(qCircleExtraTypeInfo);
                ((BaseWidgetView) this.itemView).setData(obj, i3);
            }
        }
    }

    public BaseListBlock(Bundle bundle) {
        super(bundle);
    }

    private void handleLoadMoreData() {
        int size;
        List<E> list = this.mAllListData;
        if (list == null || list.size() <= 0 || (size = this.mAllListData.size() - getDataList().size()) <= 0) {
            return;
        }
        if (size > getPageCount()) {
            size = getPageCount();
            this.mIsFinish = false;
        } else {
            this.mIsFinish = true;
        }
        QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", Integer.valueOf(this.mAllListData.size()), Integer.valueOf(size)));
        handleListData(this.mAllListData.subList(getDataList().size(), getDataList().size() + size), false, true, this.mIsFinish);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRefreshData(List<E> list) {
        boolean z16;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mAllListData = list;
        int size = list.size();
        int min = Math.min(size, getPageCount());
        if (getDataList().size() > min && getDataList().size() <= size) {
            min = getDataList().size();
        }
        if (min == size) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsFinish = z16;
        QLog.d(getLogTag(), 1, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", Integer.valueOf(size), Integer.valueOf(min), Integer.valueOf(getDataList().size())));
        handleListData(list.subList(0, min), false, false, this.mIsFinish);
    }

    public abstract /* synthetic */ String getAttachInfoFromItemData(E e16);

    public abstract /* synthetic */ String getAttachInfoFromRsp(Object obj);

    public abstract int getBackgroundColor();

    public Map<String, Object> getChildDaTongPageParams() {
        return null;
    }

    public int getContentLayoutId() {
        return R.layout.g5a;
    }

    public abstract List<Part> getCustomParts();

    public String getDaTongPageId() {
        return "";
    }

    public abstract String getDropFrameMonitorTag();

    public abstract String getEmptyHint();

    public PublicListInnerFragment getHostFragment() {
        if (getParentFragment() instanceof PublicListInnerFragment) {
            return (PublicListInnerFragment) getParentFragment();
        }
        return null;
    }

    public abstract /* synthetic */ boolean getIsFinishFromRsp(Object obj);

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    public abstract /* synthetic */ void getListDataAsync(IDataCallBack<E> iDataCallBack, String str);

    public abstract /* synthetic */ List<E> getListDataFromRsp(Object obj, boolean z16);

    @Override // com.tencent.biz.qqcircle.bizparts.a
    public abstract String getLogTag();

    public abstract /* synthetic */ int getPageCount();

    public abstract /* synthetic */ Object getRequest(String str);

    public BaseRequest getRequestWithLoadInfo(LoadInfo loadInfo, String str) {
        if (!loadInfo.isInitState() && !loadInfo.isRefreshState()) {
            if (loadInfo.isLoadMoreState()) {
                return (BaseRequest) getRequest(str);
            }
        } else {
            BaseRequest baseRequest = (BaseRequest) getRequest(null);
            if (baseRequest != null) {
                baseRequest.setEnableCache(loadInfo.isInitState());
                return baseRequest;
            }
        }
        return null;
    }

    public abstract int getStatusBarColor();

    public abstract String getTitle();

    public abstract View getTitleTabView(ViewGroup viewGroup);

    public void handleListData(final List<E> list, final boolean z16, final boolean z17, final boolean z18) {
        preHandleListData(list, z16, z17, z18);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.1
            @Override // java.lang.Runnable
            public void run() {
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    if (z17) {
                        BaseListBlock.this.addAll(list);
                    } else {
                        BaseListBlock.this.setDatas(new ArrayList(list));
                    }
                    BaseListBlock.this.showListView();
                    BaseListBlock.this.getLoadInfo().setFinish(z18);
                } else {
                    QLog.e(BaseListBlock.this.getLogTag(), 1, "handleListDataRsp() return empty data");
                    if (z17) {
                        if (BaseListBlock.this.getNUM_BACKGOURND_ICON() > 0) {
                            BaseListBlock.this.getLoadInfo().setFinish(z18);
                        } else {
                            QLog.d(BaseListBlock.this.getLogTag(), 1, "error state empty data,but execute load more");
                        }
                    } else {
                        BaseListBlock.this.showEmptyView();
                        BaseListBlock.this.clearData();
                        BaseListBlock.this.notifyDataSetChanged();
                    }
                }
                BaseListBlock.this.notifyAfterHandleListData(z16, z17, z18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleResponse(boolean z16, final boolean z17, long j3, @Nullable final BaseRequest baseRequest, final String str, final T t16) {
        if (z16 && j3 == 0 && t16 != null) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.5
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
                    List<E> listDataFromRsp = BaseListBlock.this.getListDataFromRsp(t16, isProtocolCache);
                    BaseListBlock baseListBlock = BaseListBlock.this;
                    baseListBlock.mIsFinish = baseListBlock.getIsFinishFromRsp(t16);
                    BaseListBlock baseListBlock2 = BaseListBlock.this;
                    baseListBlock2.mLastAttachInfo = baseListBlock2.getAttachInfoFromRsp(t16);
                    if (listDataFromRsp != null) {
                        String logTag = BaseListBlock.this.getLogTag();
                        if (baseRequest == null) {
                            str2 = "";
                        } else {
                            str2 = baseRequest.get$cmd() + "rspData size:" + listDataFromRsp.size() + " | isFinish:" + BaseListBlock.this.mIsFinish + " | attachInfo:" + BaseListBlock.this.getAttachInfoFromRsp(t16);
                        }
                        QLog.d(logTag, 1, str2);
                        BaseListBlock baseListBlock3 = BaseListBlock.this;
                        baseListBlock3.handleListData(listDataFromRsp, isProtocolCache, z17, baseListBlock3.mIsFinish);
                        return;
                    }
                    QLog.e(BaseListBlock.this.getLogTag(), 1, "handleResponse but listData is null");
                }
            });
        } else {
            showErrorView(str, j3);
            notifyLoadingComplete(true, false);
        }
    }

    public abstract void initTitleBar(View view);

    public boolean isNeedQUIBackgroundDrawable() {
        return false;
    }

    public boolean isNeedQUIColor() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        BaseRequest requestWithLoadInfo = getRequestWithLoadInfo(loadInfo, this.mLastAttachInfo);
        QLog.d(getLogTag(), 1, "loadData: " + loadInfo);
        if (requestWithLoadInfo != null && getParentFragment() != null) {
            final boolean isLoadMoreState = loadInfo.isLoadMoreState();
            final boolean isEnableCache = requestWithLoadInfo.isEnableCache();
            final String str = requestWithLoadInfo.get$cmd();
            VSNetworkHelper.getInstance().sendRequest(getParentFragment().hashCode(), requestWithLoadInfo, (VSDispatchObserver.OnVSRspCallBack<?>) new VSDispatchObserver.OnVSRspCallBack<T>() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.2
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, T t16) {
                    QLog.d(BaseListBlock.this.getLogTag(), 1, str + "onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2 + " | isLoadMore:" + isLoadMoreState + " | isCache:" + isEnableCache);
                    BaseListBlock.this.handleResponse(z16, isLoadMoreState, j3, baseRequest, str2, t16);
                }
            });
            return;
        }
        String str2 = null;
        if (!loadInfo.isInitState() && !loadInfo.isRefreshState()) {
            if (loadInfo.isLoadMoreState()) {
                IDataCallBack<E> iDataCallBack = new IDataCallBack<E>() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.4
                    @Override // com.tencent.richframework.data.idata.IDataCallBack
                    public void onFetchData(boolean z16, long j3, List<E> list, String str3, boolean z17) {
                    }
                };
                if (getDataList() != null && getDataList().size() > 0) {
                    str2 = getAttachInfoFromItemData(getDataList().get(getDataList().size() - 1));
                }
                if (str2 != null) {
                    getListDataAsync(iDataCallBack, str2);
                    return;
                } else {
                    handleLoadMoreData();
                    return;
                }
            }
            return;
        }
        IDataCallBack<E> iDataCallBack2 = new IDataCallBack<E>() { // from class: com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.3
            @Override // com.tencent.richframework.data.idata.IDataCallBack
            public void onFetchData(boolean z16, long j3, List<E> list, String str3, boolean z17) {
                BaseListBlock.this.handleRefreshData(list);
            }
        };
        QLog.d(getLogTag(), 1, "loadData: getListDataAsync");
        getListDataAsync(iDataCallBack2, null);
    }

    protected void notifyAfterHandleListData(boolean z16, boolean z17, boolean z18) {
        notifyLoadingComplete(true, z18);
    }

    public void onDoubleClickTitle() {
        if (getBlockContainer() != null && getBlockContainer().getRecyclerView() != null) {
            getBlockContainer().getRecyclerView().scrollToPosition(0);
        }
    }

    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public /* bridge */ /* synthetic */ void onPartDestroy(Activity activity) {
        com.tencent.biz.richframework.part.b.b(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    public abstract void onTitleTabSelectedChanged(View view, boolean z16);

    public void setInitBean(Serializable serializable) {
        this.mInitBean = serializable;
    }

    public void setInitData(ArrayList<E> arrayList) {
        setDatas(arrayList);
    }

    protected void showEmptyView() {
        if (getHostFragment() != null && getHostFragment().sh() != null) {
            getHostFragment().sh().getStatusInterface().showHintView(getEmptyHint());
        }
    }

    protected void showErrorView(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            str = h.a(R.string.f181603e8);
        }
        String str2 = str;
        if (getNUM_BACKGOURND_ICON() > 0) {
            cj.c(false, j3, str2, 1, QCircleToast.f91645e);
        } else if (getHostFragment() != null && getHostFragment().sh() != null) {
            getHostFragment().sh().getStatusInterface().showHintView(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListView() {
        if (getHostFragment() != null && getHostFragment().sh() != null) {
            if (getHostFragment().sh().getStatusInterface() != null && getHostFragment().sh().getStatusInterface().getStatusView() != null) {
                getHostFragment().sh().getStatusInterface().getStatusView().setVisibility(8);
            }
            getHostFragment().sh().getRecyclerView().setVisibility(0);
        }
    }

    public void onSingleClickTitle() {
    }

    protected void preHandleListData(List<E> list, boolean z16, boolean z17, boolean z18) {
    }
}

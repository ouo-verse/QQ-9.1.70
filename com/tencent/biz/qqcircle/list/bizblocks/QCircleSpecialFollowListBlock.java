package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StRelationInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSpecialFollowListBlock extends QCircleBaseListBlock<FeedCloudMeta$StRelationInfo, QCircleSpecialFollowManager.g> implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final String TAG = "QCircleSpecialFollowLis";
    private final QCircleSpecialFollowManager mSpecialFollowMgr;

    public QCircleSpecialFollowListBlock(Bundle bundle) {
        super(bundle);
        this.mSpecialFollowMgr = QCircleSpecialFollowManager.g();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(FeedCloudMeta$StRelationInfo feedCloudMeta$StRelationInfo) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(QCircleSpecialFollowManager.g gVar) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getBackgroundColor() {
        return QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_SPECIAL_FOLLOW_LIST();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f185133nr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateActionText() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateDescText() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f185143ns);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>(Arrays.asList(QCircleSpecialFollowUpdateEvent.class, QCircleSpecialFollowListLoadEvent.class));
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f185123nq);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
        if (view == null) {
            return;
        }
        view.setBackgroundColor(getBackgroundColor());
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        if (loadInfo.isInitState()) {
            getBlockContainer().getBlockMerger().setNoMoreHint("");
            this.mSpecialFollowMgr.l();
        } else if (loadInfo.isRefreshState()) {
            this.mSpecialFollowMgr.l();
        } else if (loadInfo.isLoadMoreState()) {
            this.mSpecialFollowMgr.h();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
        if (!(viewHolder.itemView instanceof QCircleSpecialFollowUserItemView)) {
            return;
        }
        if (getNUM_BACKGOURND_ICON() == 1) {
            ((QCircleSpecialFollowUserItemView) viewHolder.itemView).setItemBgType(0);
            return;
        }
        if (i3 == 0) {
            ((QCircleSpecialFollowUserItemView) viewHolder.itemView).setItemBgType(1);
        } else if (i3 == getNUM_BACKGOURND_ICON() - 1) {
            ((QCircleSpecialFollowUserItemView) viewHolder.itemView).setItemBgType(3);
        } else {
            ((QCircleSpecialFollowUserItemView) viewHolder.itemView).setItemBgType(2);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListBlock.BaseListVH(new QCircleSpecialFollowUserItemView(getParentFragment().getActivity()));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d(TAG, 4, "onPartDestroy");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.d(TAG, 4, "onPartPause");
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.d(TAG, 4, "onPartResume");
        RFWThemeUtil.setStatusBarColor(getActivity(), QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_backplate));
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

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        boolean z16 = false;
        if (simpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent) {
            QCircleSpecialFollowUpdateEvent qCircleSpecialFollowUpdateEvent = (QCircleSpecialFollowUpdateEvent) simpleBaseEvent;
            if (qCircleSpecialFollowUpdateEvent.isFollow) {
                getBlockContainer().getBlockMerger().onRefreshWithAnim();
                return;
            }
            String str = qCircleSpecialFollowUpdateEvent.uin;
            int i3 = 0;
            while (true) {
                if (i3 >= this.mDataList.size()) {
                    break;
                }
                if (str.equals(((FeedCloudMeta$StRelationInfo) this.mDataList.get(i3)).f398459id.get())) {
                    this.mDataList.remove(i3);
                    notifyDataSetChanged();
                    if (this.mDataList.isEmpty()) {
                        showEmptyView();
                    }
                    z16 = true;
                } else {
                    i3++;
                }
            }
            if (!z16 && !this.mIsFinish) {
                getBlockContainer().getBlockMerger().onRefreshWithAnim();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCircleSpecialFollowListLoadEvent) {
            QCircleSpecialFollowListLoadEvent qCircleSpecialFollowListLoadEvent = (QCircleSpecialFollowListLoadEvent) simpleBaseEvent;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceiveEvent: load ");
            sb5.append(qCircleSpecialFollowListLoadEvent.isRefresh);
            sb5.append(" ");
            if (qCircleSpecialFollowListLoadEvent.resp != null) {
                z16 = true;
            }
            sb5.append(z16);
            QLog.i(TAG, 4, sb5.toString());
            QCircleSpecialFollowManager.g gVar = qCircleSpecialFollowListLoadEvent.resp;
            if (gVar == null) {
                handleResponse(false, !qCircleSpecialFollowListLoadEvent.isRefresh, -1L, null, "", null);
            } else {
                handleResponse(true, !qCircleSpecialFollowListLoadEvent.isRefresh, 0L, null, "", gVar);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(QCircleSpecialFollowManager.g gVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getIsFinishFromRsp: ");
        sb5.append(gVar.f91523b == null);
        QLog.i(TAG, 4, sb5.toString());
        return gVar.f91523b == null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<FeedCloudMeta$StRelationInfo> getListDataFromRsp(QCircleSpecialFollowManager.g gVar, boolean z16) {
        List<FeedCloudMeta$StRelationInfo> list = gVar.f91522a;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<FeedCloudMeta$StRelationInfo> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}

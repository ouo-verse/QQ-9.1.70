package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSMessageFriendRecomRefreshCompleteEvent;
import com.tencent.biz.qqcircle.events.QFSMessageQuickThankEvent;
import com.tencent.biz.qqcircle.events.QFSPublicListInnerBlockRegisterEvent;
import com.tencent.biz.qqcircle.helpers.QFSPublicListTabCommonHelper;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.helpers.t;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoryDetailRequest;
import com.tencent.biz.qqcircle.requests.QFSQuickThankPSVRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudRead$StGetNoticeCategoryDetailPageRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleThank$QuickThankPSVRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageSecondListBlock extends QFSBaseMessageListBlock<FeedCloudRead$StGetNoticeCategoryDetailPageRsp> implements SimpleEventReceiver {
    private static final int MIN_NEW_FRIEND_LOAD_MORE_COUNT = 3;
    private static final int MIN_PEER_BLOCK_SIZE_SHOW_LOAD_MORE_ITEM = 2;
    private static final String TAG = "QFSMessageSecondListBlock";
    private boolean mAllowQuickThank;
    private final List<QFSMessageItemInfo> mLoadMoreCacheItemInfoList;
    private boolean mNeedAddSpilt;
    private b mOnRedPointReceiveListener;
    private final Map<Integer, String> mRspAndTraceIdMap;
    private long mSplitTime;
    private int mSubTabType;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, int i16);
    }

    public QFSMessageSecondListBlock(Bundle bundle) {
        super(bundle);
        this.mNeedAddSpilt = true;
        this.mLoadMoreCacheItemInfoList = new ArrayList();
        this.mRspAndTraceIdMap = new HashMap();
        initParams(bundle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
    
        r5 = new com.tencent.biz.qqcircle.beans.QFSMessageItemInfo(-1001);
        com.tencent.qphone.base.util.QLog.d(getLogTag(), 1, "[addLoadMoreItem] dataSize = " + r0 + ", index = " + r3 + ", mIsFinish" + r9.mIsFinish);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b8, code lost:
    
        if (r3 != (-1)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        if (r9.mIsFinish != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        r10.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        r11 = java.lang.Math.max(3, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        if (r1.hasNext() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        r0 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d6, code lost:
    
        if (r1.nextIndex() <= r11) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d8, code lost:
    
        r1.remove();
        r9.mLoadMoreCacheItemInfoList.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        if (r9.mLoadMoreCacheItemInfoList.size() > 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00eb, code lost:
    
        if (r9.mIsFinish != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ed, code lost:
    
        r10.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addLoadMoreItem(List<QFSMessageItemInfo> list, boolean z16) {
        int i3;
        int i16;
        if (z16) {
            return;
        }
        this.mLoadMoreCacheItemInfoList.clear();
        int i17 = 0;
        if (getBlockMerger() != null && getBlockMerger().getDataList() != null) {
            i3 = getBlockMerger().getDataList().size();
        } else {
            i3 = 0;
        }
        if (i3 < 2) {
            QLog.d(getLogTag(), 1, "[addLoadMoreItem] peerBlockSize = " + i3);
            return;
        }
        if (list != null) {
            i17 = list.size();
        }
        if (i17 <= 3) {
            QLog.d(getLogTag(), 1, "[addLoadMoreItem] listData.size <= 3");
            return;
        }
        ListIterator<QFSMessageItemInfo> listIterator = list.listIterator();
        while (true) {
            if (listIterator.hasNext()) {
                FeedCloudMeta$StNotice stNotice = listIterator.next().getStNotice();
                if (stNotice == null) {
                    return;
                }
                if (this.mSplitTime > stNotice.createTime.get()) {
                    i16 = listIterator.nextIndex() - 1;
                    break;
                }
            } else {
                i16 = -1;
                break;
            }
        }
    }

    private void addLocalSplitTimeItem(List<QFSMessageItemInfo> list, boolean z16) {
        int i3;
        if (list == null) {
            return;
        }
        if (!z16) {
            this.mNeedAddSpilt = true;
        }
        if (!this.mNeedAddSpilt) {
            return;
        }
        ListIterator<QFSMessageItemInfo> listIterator = list.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            FeedCloudMeta$StNotice stNotice = listIterator.next().getStNotice();
            if (stNotice == null) {
                return;
            }
            if (this.mNeedAddSpilt && this.mSplitTime > stNotice.createTime.get()) {
                this.mNeedAddSpilt = false;
                if (z16 || listIterator.nextIndex() != 1) {
                    i3 = listIterator.nextIndex() - 1;
                }
            }
        }
        i3 = -1;
        if (i3 != -1 && canShowSplitLine()) {
            list.add(i3, new QFSMessageItemInfo(-1000));
        }
    }

    private boolean canShowSplitLine() {
        if (supportNewMsgUiExp()) {
            return false;
        }
        return true;
    }

    private void fillStatusInfo(List<QFSMessageItemInfo> list) {
        boolean z16;
        if (list == null) {
            return;
        }
        boolean supportNewMsgUiExp = supportNewMsgUiExp();
        for (QFSMessageItemInfo qFSMessageItemInfo : list) {
            if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNotice() != null) {
                boolean z17 = true;
                if (this.mSplitTime < qFSMessageItemInfo.getMessageTimestamp()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean contains = qFSMessageItemInfo.getStNotice().opMask.get().contains(6);
                if (RFWLog.isDevelopLevel()) {
                    RFWLog.d(TAG, RFWLog.DEV, "fillStatusInfo isNewFromSplitTime:" + z16 + ",highLight:" + contains);
                }
                if (!contains && !z16) {
                    z17 = false;
                }
                qFSMessageItemInfo.setIsNewMessage(z17);
                qFSMessageItemInfo.setCanShowHighLightUiStyle(supportNewMsgUiExp);
            }
        }
    }

    private QFSMessageItemInfo findLoadMoreItem() {
        List<QFSMessageItemInfo> dataList = getDataList();
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        for (QFSMessageItemInfo qFSMessageItemInfo : dataList) {
            if (qFSMessageItemInfo.getType() == -1001) {
                return qFSMessageItemInfo;
            }
        }
        return null;
    }

    private void handleCommentUpdateEvent(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (qCircleCommentUpdateEvent.eventStatus == 5 && this.isOnResume) {
            QCircleToast.l(QCircleToast.f91646f, QCircleApplication.APP.getResources().getString(R.string.f1917245k), 0, true, false);
        }
    }

    private void handleFriendRecomRefreshCompleteEvent(@NonNull QFSMessageFriendRecomRefreshCompleteEvent qFSMessageFriendRecomRefreshCompleteEvent) {
        int currentState;
        if (!isLaunchToNewFriendsPage()) {
            return;
        }
        if (getLoadInfo() == null) {
            currentState = 0;
        } else {
            currentState = getLoadInfo().getCurrentState();
        }
        QLog.d(getLogTag(), 1, "[handleFriendRecomRefreshComplete] loadState = " + currentState + ", mIsFinish = " + this.mIsFinish);
        if (currentState == 4) {
            notifyLoadingComplete(true, this.mIsFinish);
        }
    }

    private void handleMessageQuickThankEvent(QFSMessageQuickThankEvent qFSMessageQuickThankEvent) {
        if (qFSMessageQuickThankEvent.getLaunch() != this.launchTo) {
            return;
        }
        QFSQuickThankPSVRequest qFSQuickThankPSVRequest = new QFSQuickThankPSVRequest(this.mSplitTime, qFSMessageQuickThankEvent.getLaunch());
        VSNetworkHelper.getInstance().sendRequest(qFSQuickThankPSVRequest, new a());
        QCircleToast.l(QCircleToast.f91646f, uq3.o.g0("msgAllThanksConfirmTxt"), 0, true, false);
        Iterator<QFSMessageItemInfo> it = getDataList().iterator();
        QLog.d(TAG, 1, "NFT-[handleMessageQuickThankEvent] mSplitTime: " + this.mSplitTime + " | request traceId: " + qFSQuickThankPSVRequest.getTraceId());
        while (it.hasNext()) {
            QFSMessageItemInfo next = it.next();
            if (next.getType() == -1004) {
                it.remove();
            } else {
                FeedCloudMeta$StNotice stNotice = next.getStNotice();
                QQCircleFeedBase$StNoticeBusiData noticeBusiData = next.getNoticeBusiData();
                if (stNotice != null && noticeBusiData != null && stNotice.createTime.get() > this.mSplitTime) {
                    noticeBusiData.thanked.set(true);
                    next.setConsumed();
                }
            }
        }
        notifyDataSetChanged();
    }

    private void handleNewFriendLoadMore(@NonNull final QFSPublicListInnerBlockRegisterEvent qFSPublicListInnerBlockRegisterEvent) {
        if (!isLaunchToNewFriendsPage()) {
            return;
        }
        if (qFSPublicListInnerBlockRegisterEvent.needRegister()) {
            handleRegisterEndListBlock();
        } else {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSMessageSecondListBlock.this.handleUnRegisterEndListBlock(qFSPublicListInnerBlockRegisterEvent.isFriendRecomBlockEmpty());
                }
            });
        }
    }

    private void handleRegisterEndListBlock() {
        QLog.d(TAG, 1, "[handleRegisterEndListBlock] mSubTabType" + this.mSubTabType);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondListBlock.3
            @Override // java.lang.Runnable
            public void run() {
                PublicListInnerFragment hostFragment = QFSMessageSecondListBlock.this.getHostFragment();
                if (hostFragment == null) {
                    return;
                }
                hostFragment.Dh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnRegisterEndListBlock(boolean z16) {
        int currentState;
        PublicListInnerFragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        if (getLoadInfo() == null) {
            currentState = 0;
        } else {
            currentState = getLoadInfo().getCurrentState();
        }
        QLog.d(getLogTag(), 1, "[handleUnRegisterEndListBlock] mIsFinish = " + this.mIsFinish + ", loadState = " + currentState + ", isFriendRecomBlockEmpty = " + z16 + " | mSubTabType: " + this.mSubTabType);
        if (!this.mIsFinish || z16) {
            hostFragment.Hh();
        }
        QFSMessageItemInfo findLoadMoreItem = findLoadMoreItem();
        if (findLoadMoreItem != null && findLoadMoreItem.getType() == -1001) {
            getDataList().remove(findLoadMoreItem);
        }
        List<QFSMessageItemInfo> list = this.mLoadMoreCacheItemInfoList;
        if (list != null && list.size() > 0) {
            addAll(this.mLoadMoreCacheItemInfoList);
            this.mLoadMoreCacheItemInfoList.clear();
        }
        if (getBlockMerger() != null && !this.mIsFinish) {
            getBlockMerger().triggerToLoadMore();
        }
        if (currentState == 4 && this.mIsFinish) {
            notifyLoadingComplete(true, true);
        }
    }

    private void initParams(Bundle bundle) {
        int i3 = bundle.getInt(BaseListBlock.PAGE_BLOCK_POSITION, -1);
        if (i3 == -1) {
            return;
        }
        this.mSubTabType = QFSPublicListTabCommonHelper.c(i3, QFSPublicListTabCommonHelper.e(bundle));
        QLog.d(TAG, 1, "NFT-[initParams] mSubTabType: " + this.mSubTabType + " | position: " + i3);
    }

    private boolean isLaunchToNewFriendsPage() {
        QCircleInitBean qCircleInitBean;
        if (t.b(this.mSubTabType) || (qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean) == null || qCircleInitBean.getLaunchTo() != 4 || (this instanceof QFSMessageFriendRecomBlock)) {
            return false;
        }
        return true;
    }

    private boolean isNeedAddLoadMoreItemNewFriendPage() {
        if (this.mSubTabType == 19) {
            return false;
        }
        boolean isLaunchToNewFriendsPage = isLaunchToNewFriendsPage();
        boolean b16 = m30.a.b();
        QLog.d(getLogTag(), 1, "[isNeedAddLoadMoreItemNewFriendPage] isLaunchToNewFriend = " + isLaunchToNewFriendsPage + ", isHitExp =  " + b16);
        if (!isLaunchToNewFriendsPage || !b16) {
            return false;
        }
        return true;
    }

    private boolean needRegisterEndListBlockWhenFinish(boolean z16, boolean z17) {
        MultiViewBlock uh5;
        int i3;
        if (!isLaunchToNewFriendsPage() || !z16 || !z17) {
            return false;
        }
        if (getHostFragment() == null) {
            uh5 = null;
        } else {
            uh5 = getHostFragment().uh();
        }
        if (uh5 == null) {
            QLog.e(getLogTag(), 1, "[needRegisterEndListBlockWhenFinish] endListBlock == null");
            return false;
        }
        boolean isFinish = uh5.getLoadInfo().isFinish();
        if (uh5.getDataList() != null) {
            i3 = uh5.getDataList().size();
        } else {
            i3 = 0;
        }
        QLog.d(getLogTag(), 1, "[needRegisterEndListBlockWhenFinish] endBlockFinish = " + isFinish + ", endBlockDataSize = " + i3);
        if (i3 <= 0 && isFinish) {
            return false;
        }
        return true;
    }

    private void notifyRedPointReceiveChange(int i3, int i16) {
        b bVar = this.mOnRedPointReceiveListener;
        if (bVar == null) {
            QLog.e(TAG, 1, "[notifyRedPointReceiveChange] red point receive listener should not be null.");
        } else {
            bVar.a(i3, i16);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
        if (qCircleInitBean != null) {
            String str = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.MessageList.DT_ENTRANCE_NAME);
            if (t.b(this.mSubTabType)) {
                str = String.valueOf(19);
            }
            QLog.d(TAG, 1, "[getChildDaTongPageParams] entranceName: " + str + " launchTo: " + ((QFSBaseMessageListBlock) this).mInitBean.getLaunchTo() + ", subTabType:" + this.mSubTabType);
            hashMap.put("xsj_msg_entrance_name_new", str);
            int i3 = this.mSubTabType;
            if (i3 < 0) {
                i3 = ((QFSBaseMessageListBlock) this).mInitBean.getLaunchTo();
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ENTRANCE_NAME, Integer.valueOf(i3));
        }
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_FEATURE_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateActionText() {
        if (isLaunchToNewFriendsPage()) {
            return uq3.c.D3();
        }
        return super.getEmptyStateActionText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateDescText() {
        if (isLaunchToNewFriendsPage()) {
            return uq3.c.E3();
        }
        if (t.b(this.mSubTabType)) {
            return null;
        }
        return super.getEmptyStateDescText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock
    public String getEmptyStateTitleText() {
        if (t.b(this.mSubTabType)) {
            return uq3.c.G3();
        }
        return super.getEmptyStateTitleText();
    }

    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QFSPublicListInnerBlockRegisterEvent.class);
        arrayList.add(QFSMessageFriendRecomRefreshCompleteEvent.class);
        arrayList.add(QFSMessageQuickThankEvent.class);
        return arrayList;
    }

    protected int getItemInfoType() {
        return -100;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
        if (qCircleInitBean == null) {
            return "";
        }
        return qCircleInitBean.getmCategory();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleListData(List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        super.handleListData(list, z16, z17, z18);
        if (needRegisterEndListBlockWhenFinish(z17, z18)) {
            handleRegisterEndListBlock();
        }
        if (!z17 && !z16 && getBlockMerger() != null) {
            getBlockMerger().resetTryToLoadMoreCount();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean isLastPeerBlock() {
        List<MultiViewBlock> list;
        boolean z16;
        boolean z17;
        if (!isLaunchToNewFriendsPage()) {
            return super.isLastPeerBlock();
        }
        if (getBlockContainer() != null) {
            list = getBlockMerger().getDataList();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            MultiViewBlock multiViewBlock = list.get(list.size() - 1);
            if (multiViewBlock == null) {
                QLog.e(getLogTag(), 1, "[isLastPeerBlock] endBlock == null");
                return false;
            }
            if (multiViewBlock == this) {
                QLog.d(getLogTag(), 1, "[isLastPeerBlock] endBlock == this");
                return true;
            }
            if (getLoadInfo() != null && getLoadInfo().isFinish()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (multiViewBlock.getLoadInfo() != null && multiViewBlock.getLoadInfo().isFinish()) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.d(getLogTag(), 1, "[isLastPeerBlock] curBlockFinish = " + z16 + ", endBlockFinish = " + z17 + ", cacheSize = " + this.mLoadMoreCacheItemInfoList.size());
            if (!z16 || !z17 || this.mLoadMoreCacheItemInfoList.size() > 0) {
                return false;
            }
            return true;
        }
        QLog.e(getLogTag(), 1, "[isLastPeerBlock] peerBlocks error");
        return false;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (257 == i3) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAtUpdateEvent(getContext(), intent));
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.mIsFirstResume) {
            QLog.d(getLogTag(), 1, "onPartResume registerReceiver");
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            handleCommentUpdateEvent((QCircleCommentUpdateEvent) simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof QFSPublicListInnerBlockRegisterEvent) {
            handleNewFriendLoadMore((QFSPublicListInnerBlockRegisterEvent) simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof QFSMessageFriendRecomRefreshCompleteEvent) {
            handleFriendRecomRefreshCompleteEvent((QFSMessageFriendRecomRefreshCompleteEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMessageQuickThankEvent) {
            handleMessageQuickThankEvent((QFSMessageQuickThankEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onRefreshData() {
        if (isLaunchToNewFriendsPage() && getBlockMerger() != null) {
            getBlockMerger().onLoadMoreCompleted(true, false, false);
        }
        super.onRefreshData();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void preHandleListData(List<QFSMessageItemInfo> list, boolean z16, boolean z17, boolean z18) {
        QLog.d(TAG, 1, "[preHandleListData] isNeedAddLoadMoreItemNewFriendPage(): " + isNeedAddLoadMoreItemNewFriendPage() + " | fromCache: " + z16 + " | isLoadMore: " + z17 + " | isFinish: " + z18 + " | mSubTabType: " + this.mSubTabType);
        fillStatusInfo(list);
        if (isNeedAddLoadMoreItemNewFriendPage()) {
            addLoadMoreItem(list, z17);
        } else {
            addLocalSplitTimeItem(list, z17);
        }
        if (!z17 && !z16 && this.mAllowQuickThank) {
            list.add(0, new QFSMessageItemInfo(-1004));
        }
    }

    public void registerBlockRedPointReceive(b bVar) {
        this.mOnRedPointReceiveListener = bVar;
    }

    public boolean supportNewMsgUiExp() {
        QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
        if (qCircleInitBean != null && qCircleInitBean.getLaunchTo() == 4 && !(this instanceof QFSMessageFriendRecomBlock)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp) {
        return feedCloudRead$StGetNoticeCategoryDetailPageRsp.attach_info.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp) {
        return !feedCloudRead$StGetNoticeCategoryDetailPageRsp.has_more.get();
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @WorkerThread
    public List<QFSMessageItemInfo> getListDataFromRsp(FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp, boolean z16) {
        ArrayList arrayList = new ArrayList();
        List<FeedCloudMeta$StNotice> list = feedCloudRead$StGetNoticeCategoryDetailPageRsp.notices.get();
        if (!RFSafeListUtils.isEmpty(list)) {
            for (FeedCloudMeta$StNotice feedCloudMeta$StNotice : list) {
                QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(getItemInfoType());
                qFSMessageItemInfo.setTraceId(this.mRspAndTraceIdMap.get(Integer.valueOf(feedCloudRead$StGetNoticeCategoryDetailPageRsp.hashCode())));
                qFSMessageItemInfo.setMessageTimestamp(feedCloudMeta$StNotice.createTime.get());
                qFSMessageItemInfo.setStNotice(feedCloudMeta$StNotice);
                qFSMessageItemInfo.setNoticeBusiData(q.r().x(feedCloudMeta$StNotice, z16));
                qFSMessageItemInfo.setUserBusiData(q.r().C(feedCloudMeta$StNotice, z16));
                arrayList.add(qFSMessageItemInfo);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QFSMessageNoticeCategoryDetailRequest(str, ((QFSBaseMessageListBlock) this).mInitBean, this.mSubTabType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, boolean z17, long j3, BaseRequest baseRequest, String str, FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp) {
        if (feedCloudRead$StGetNoticeCategoryDetailPageRsp != null && baseRequest != null) {
            this.mRspAndTraceIdMap.put(Integer.valueOf(feedCloudRead$StGetNoticeCategoryDetailPageRsp.hashCode()), baseRequest.getTraceId());
        }
        if (z16 && j3 == 0 && feedCloudRead$StGetNoticeCategoryDetailPageRsp != null) {
            if (!z17) {
                Pair<Integer, Integer> a16 = t.a(feedCloudRead$StGetNoticeCategoryDetailPageRsp, this.mSubTabType);
                notifyRedPointReceiveChange(a16.first.intValue(), a16.second.intValue());
                this.mSplitTime = feedCloudRead$StGetNoticeCategoryDetailPageRsp.last_read_timestamp.get();
                String d16 = bh.d(feedCloudRead$StGetNoticeCategoryDetailPageRsp.ext.mapInfo.get(), "allow_quick_thank");
                List<QQCircleFeedBase$StTabInfo> d17 = QFSPublicListTabCommonHelper.d(getActivity() == null ? null : getActivity().getIntent());
                this.mAllowQuickThank = TextUtils.equals(d16, String.valueOf(1));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("NFT-[notifyRedPointReceiveChange]trace id: ");
                sb5.append(baseRequest != null ? baseRequest.getTraceId() : null);
                sb5.append(" | tabType: ");
                sb5.append(a16.first);
                sb5.append(" | total: ");
                sb5.append(a16.second);
                sb5.append(" | mSplitTime: ");
                sb5.append(this.mSplitTime);
                sb5.append(" | mAllowQuickThank: ");
                sb5.append(this.mAllowQuickThank);
                sb5.append(" | subTabType: ");
                sb5.append(this.mSubTabType);
                sb5.append(" | launchTo: ");
                QCircleInitBean qCircleInitBean = ((QFSBaseMessageListBlock) this).mInitBean;
                sb5.append(qCircleInitBean != null ? Integer.valueOf(qCircleInitBean.getLaunchTo()) : "-1");
                sb5.append(" | hashCode: ");
                sb5.append(hashCode());
                sb5.append(" | title: ");
                sb5.append(QFSPublicListTabCommonHelper.f(d17, a16.first.intValue()));
                QLog.d(TAG, 1, sb5.toString());
            }
            super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetNoticeCategoryDetailPageRsp);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.bizblocks.QFSBaseMessageListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleThank$QuickThankPSVRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleThank$QuickThankPSVRsp qQCircleThank$QuickThankPSVRsp) {
        }
    }
}

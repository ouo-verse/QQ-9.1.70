package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.debug.QCircleDebugInfoDataManager;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSTurnPageEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.lazyload.QFSLazyLoadUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCirclePermissionErrorView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleForQZoneVideoState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public abstract class QFSLayerBasePart extends u implements SimpleEventReceiver, t40.a, t40.c, t40.h {
    public static final int FEED_DATA_POS_REFRESH = -1001;
    public static final int FEED_DATA_REPLACE = -1000;
    public static final int FEED_INSERT_SILENT = -1002;
    private static final String KEY_PUSH_IS_FROM = "KEY_PUSH_IS_FROM";
    private static final String TAG = "QFSLayerBasePart";
    public static final int UI_STATE_LOCAL_REFRESH = 104;
    public static final int UI_STATE_RERANK_FINISH = 103;
    public static final int UI_STATE_TYPE_CLIP_FEED = 102;
    public static final int UI_STATE_TYPE_RED_POINT_SCREEN_RSP = 100;
    protected boolean hasNoticeLazyLoadRightPersonalPage;
    protected FrameLayout mBottomContainer;
    private int mContentAdapterFeedPos;
    protected QCircleStatusView mFaultHintView;
    private t30.f mFeedCounterWrapper;
    protected com.tencent.biz.qqcircle.immersive.adapter.m mLayerPageAdapter;
    protected QFSPageTurnContainer mLayerPageContainer;
    protected QCirclePanelLoadingView mLoadingView;
    protected QCirclePermissionErrorView mPermissionErrorView;
    private String mPushFrom;
    private String mReturnPageId;
    private String mSchemaFeedId;
    private e30.b mSchemaFeedInfo;
    protected int mCurrentFeedPos = -1;
    protected boolean mIsNeedDelaySendFeedChangeEvent = false;
    private QFSPublishTipsUtils mPublishTipsUtils = new QFSPublishTipsUtils();
    private final com.tencent.biz.qqcircle.immersive.adapter.m mEmptyAdapter = new com.tencent.biz.qqcircle.immersive.adapter.m();
    protected final com.tencent.biz.qqcircle.immersive.report.f mPlayPageReport = new com.tencent.biz.qqcircle.immersive.report.f(getTAG());
    protected final com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a mFeedWasteCollector = new com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart$8, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ int val$playerPos;

        AnonymousClass8(int i3) {
            this.val$playerPos = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
            QFSPageTurnContainer qFSPageTurnContainer = qFSLayerBasePart.mLayerPageContainer;
            if (qFSPageTurnContainer != null) {
                qFSLayerBasePart.setViewPageToCurrentItem(qFSPageTurnContainer.B(), QFSLayerBasePart.this.mCurrentFeedPos, false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.biz.qqcircle.immersive.adapter.m mVar = QFSLayerBasePart.this.mLayerPageAdapter;
            if (mVar != null && mVar.getDataList().size() != 0) {
                QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                if (qFSLayerBasePart.mLayerPageContainer != null) {
                    int i3 = this.val$playerPos;
                    qFSLayerBasePart.mCurrentFeedPos = i3;
                    qFSLayerBasePart.mContentAdapterFeedPos = i3;
                    QFSLayerBasePart.this.mLayerPageContainer.B().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.cb
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSLayerBasePart.AnonymousClass8.this.lambda$run$0();
                        }
                    });
                    return;
                }
            }
            QLog.d(QFSLayerBasePart.TAG, 1, "handleInsertState, return ");
        }
    }

    private void broadcastPartUpdateFeed() {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null && this.mLayerPageAdapter.getDataList().size() > this.mCurrentFeedPos) {
            e30.b bVar = (e30.b) RFSafeListUtils.get(this.mLayerPageAdapter.getDataList(), this.mCurrentFeedPos);
            broadcastMessage("layer_notify_part_update_feed", bVar);
            broadcastMessage("layer_notify_part_update_feed_index", Integer.valueOf(this.mCurrentFeedPos));
            this.mFeedWasteCollector.c(bVar);
        }
    }

    private boolean canShowErrorView(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null || uIStateData.getState() != 4 || !isEmptyContent()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkViewPagerPosIsValid() {
        List<e30.b> feedList;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pos_check_when_scroll_finish", true) || (feedList = getFeedList()) == null || feedList.isEmpty() || !v30.b.i(getCurrentSelectFeed())) {
            return;
        }
        int e16 = v30.b.e(feedList);
        QLog.d(TAG, 1, "[checkViewPagerPosIsValid] is empty feed,lastUselessIndex:" + e16);
        if (e16 < 0) {
            e16 = 0;
        }
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && qFSPageTurnContainer.B() != null) {
            QLog.d(TAG, 1, "[checkViewPagerPosIsValid] real scroll");
            setViewPageToCurrentItem(this.mLayerPageContainer.B(), e16 + 2, false);
        }
    }

    private void fastSetViewPagerPos(int i3) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_layer_fast_set_pos", true)) {
            return;
        }
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && qFSPageTurnContainer.B() != null) {
            ViewPager2 B = this.mLayerPageContainer.B();
            if (B.getCurrentItem() != i3) {
                QLog.d(TAG, 1, "[fastSetViewPagerPos] setDataList setCurrentItem: " + i3);
                setViewPageToCurrentItem(B, i3, false);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "[fastSetViewPagerPos] viewPager is null");
    }

    private e30.b getCurrentSelectFeed() {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar == null) {
            return null;
        }
        int i3 = this.mCurrentFeedPos;
        List<e30.b> dataList = mVar.getDataList();
        if (i3 < 0 || dataList == null || i3 >= dataList.size()) {
            return null;
        }
        return dataList.get(i3);
    }

    private void handleCollectedFeedEvent(@NonNull QFSCollectedFeedEvent qFSCollectedFeedEvent) {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar;
        e30.b item;
        int i3 = this.mCurrentFeedPos;
        if (i3 < 0 || (mVar = this.mLayerPageAdapter) == null || i3 >= mVar.getDataList().size() || !qFSCollectedFeedEvent.isCollected() || !qFSCollectedFeedEvent.isShowGoWatchBanner() || (item = this.mLayerPageAdapter.getItem(this.mCurrentFeedPos)) == null || !TextUtils.equals(item.g().f398449id.get(), qFSCollectedFeedEvent.getFeedId())) {
            return;
        }
        this.mPublishTipsUtils.w(this.mLayerPageContainer, item.g(), qFSCollectedFeedEvent.isHasCollectBox());
        this.mPublishTipsUtils.t(getReportBean());
    }

    private void handleDeleteState(UIStateData<List<e30.b>> uIStateData) {
        int i3 = this.mCurrentFeedPos;
        if (i3 != -1) {
            this.mLayerPageAdapter.onFeedUnSelected(new RFWFeedSelectInfo(i3).setUnSelectedType("TYPE_UNSELECTED_DELETE"));
        }
        if (this.mCurrentFeedPos < this.mLayerPageAdapter.getDataList().size() - 1) {
            setViewPageToCurrentItem(this.mLayerPageContainer.B(), this.mCurrentFeedPos + 1, true);
        }
        this.mLayerPageAdapter.I0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.10
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerBasePart.this.checkEmptyContentOperation();
                QFSLayerBasePart.this.notifyPostFeedChange(false, "TYPE_SELECT_FEED_DELETE");
            }
        });
    }

    private void handleInsertState(UIStateData<List<e30.b>> uIStateData) {
        if (this.mFaultHintView != null && uIStateData.getData() != null && !uIStateData.getData().isEmpty()) {
            this.mFaultHintView.o0();
            showBottomContainer(0);
        }
        final int pos = uIStateData.getPos();
        QLog.d(TAG, 1, "handleInsertState, mCurrentFeedPos: " + this.mCurrentFeedPos + ", insertPos: " + pos);
        int i3 = this.mCurrentFeedPos;
        if (i3 != -1 && i3 != pos) {
            this.mLayerPageAdapter.onFeedUnSelected(new RFWFeedSelectInfo(i3).setUnSelectedType("TYPE_UNSELECTED_INSERT"));
        }
        this.mLayerPageAdapter.I0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.12
            @Override // java.lang.Runnable
            public void run() {
                QFSPageTurnContainer qFSPageTurnContainer;
                com.tencent.biz.qqcircle.immersive.adapter.m mVar = QFSLayerBasePart.this.mLayerPageAdapter;
                if (mVar != null && mVar.getDataList().size() != 0 && (qFSPageTurnContainer = QFSLayerBasePart.this.mLayerPageContainer) != null) {
                    int currentItem = qFSPageTurnContainer.B().getCurrentItem();
                    QLog.d(QFSLayerBasePart.TAG, 1, "handleInsertState, currentItem: " + currentItem + ", pos: " + pos);
                    int i16 = pos;
                    if (currentItem != i16) {
                        QFSLayerBasePart.this.mLayerPageContainer.B().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                                if (qFSLayerBasePart.mLayerPageContainer == null) {
                                    return;
                                }
                                boolean isContainerOnScreen = qFSLayerBasePart.isContainerOnScreen();
                                QLog.d(QFSLayerBasePart.TAG, 1, "handleInsertState, do setCurrentItem pos: " + pos + " | isContainerOnScreen: " + isContainerOnScreen);
                                AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                QFSLayerBasePart qFSLayerBasePart2 = QFSLayerBasePart.this;
                                qFSLayerBasePart2.mCurrentFeedPos = pos;
                                qFSLayerBasePart2.setViewPageToCurrentItem(qFSLayerBasePart2.mLayerPageContainer.B(), pos, isContainerOnScreen);
                            }
                        });
                        return;
                    } else {
                        QFSLayerBasePart.this.notifyCurrentFeedChange(i16);
                        return;
                    }
                }
                QLog.d(QFSLayerBasePart.TAG, 1, "handleInsertState, return ");
            }
        });
        this.mLayerPageAdapter.onDataRefresh();
    }

    private void handleModifyState(final UIStateData<List<e30.b>> uIStateData) {
        this.mLayerPageAdapter.I0(uIStateData.getData(), false, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.11
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                if (qFSLayerBasePart.mLayerPageAdapter != null && qFSLayerBasePart.mLayerPageContainer != null) {
                    if (uIStateData.getType() == 104 && uIStateData.getPos() > 0 && !fb0.a.b("QFSLayerBasePart_LOCAL_REFRESH", 2000L)) {
                        String b16 = ac0.b.b();
                        if (!TextUtils.isEmpty(b16)) {
                            QCircleToast.o(b16, 3000);
                        }
                    }
                    if (uIStateData.getType() != 102 && uIStateData.getType() != 104) {
                        if (uIStateData.getType() == 100) {
                            QLog.d(QFSLayerBasePart.TAG, 1, "handleModifyState do notifyDataSetChanged");
                            QFSLayerBasePart.this.mContentAdapterFeedPos = 0;
                            QFSLayerBasePart qFSLayerBasePart2 = QFSLayerBasePart.this;
                            qFSLayerBasePart2.mCurrentFeedPos = 0;
                            qFSLayerBasePart2.notifyCurrentFeedChange(0);
                            QFSLayerBasePart qFSLayerBasePart3 = QFSLayerBasePart.this;
                            qFSLayerBasePart3.setViewPageToCurrentItem(qFSLayerBasePart3.mLayerPageContainer.B(), 0, false);
                            QFSLayerBasePart.this.mLayerPageAdapter.notifyDataSetChanged();
                            return;
                        }
                        QFSLayerBasePart qFSLayerBasePart4 = QFSLayerBasePart.this;
                        qFSLayerBasePart4.mLayerPageAdapter.onFeedSelected(new RFWFeedSelectInfo(qFSLayerBasePart4.mLayerPageContainer.B().getCurrentItem()).setSelectedType("TYPE_SELECT_ADAPTER_MODIFY"));
                        return;
                    }
                    int pos = uIStateData.getPos();
                    QLog.d(QFSLayerBasePart.TAG, 1, "handleModifyState content pos:" + pos);
                    QFSLayerBasePart.this.mContentAdapterFeedPos = pos;
                    QFSLayerBasePart qFSLayerBasePart5 = QFSLayerBasePart.this;
                    qFSLayerBasePart5.mCurrentFeedPos = pos;
                    qFSLayerBasePart5.setViewPageToCurrentItem(qFSLayerBasePart5.mLayerPageContainer.B(), pos, false);
                    QFSLayerBasePart.this.mLayerPageAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void handleTurnPageEvent(QFSTurnPageEvent qFSTurnPageEvent) {
        QFSPageTurnContainer qFSPageTurnContainer;
        if (this.mLayerPageAdapter != null && (qFSPageTurnContainer = this.mLayerPageContainer) != null) {
            ViewPager2 B = qFSPageTurnContainer.B();
            int currentItem = B.getCurrentItem() + qFSTurnPageEvent.getTurnOffsetIndex();
            QLog.d(TAG, 1, "[handleTurnPageEvent] nextIndex: " + currentItem);
            if (currentItem >= 0 && currentItem < this.mLayerPageAdapter.getNUM_BACKGOURND_ICON()) {
                setViewPageToCurrentItem(B, currentItem, true);
            }
        }
    }

    private void handlerDataPosRefresh(UIStateData<List<e30.b>> uIStateData) {
        QFSPageTurnContainer qFSPageTurnContainer;
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList().size() != 0 && (qFSPageTurnContainer = this.mLayerPageContainer) != null) {
            int currentItem = qFSPageTurnContainer.B().getCurrentItem();
            final int pos = uIStateData.getPos();
            QLog.d(TAG, 1, "[handlerDataPosRefresh]currentItem: " + currentItem + ", pos: " + pos);
            this.mLayerPageContainer.B().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ca
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLayerBasePart.this.lambda$handlerDataPosRefresh$0(pos);
                }
            });
            return;
        }
        QLog.d(TAG, 1, "handleInsertState, return ");
    }

    private void handlerInsertSilent(UIStateData<List<e30.b>> uIStateData) {
        if (this.mFaultHintView != null && uIStateData.getData() != null && !uIStateData.getData().isEmpty()) {
            this.mFaultHintView.o0();
            showBottomContainer(0);
        }
        int pos = uIStateData.getPos();
        QLog.d(TAG, 1, "INSERT-[handlerSmallInsertFeedEventReplace], mCurrentFeedPos: " + this.mCurrentFeedPos + ", currentPos: " + pos);
        this.mLayerPageAdapter.I0(uIStateData.getData(), true, new AnonymousClass8(pos));
    }

    private void hideFastPlay() {
        if (!l40.i.I()) {
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView == null) {
            RFWLog.d(TAG, RFWLog.USR, "[hideFastPlay] rootView is null");
            return;
        }
        l40.a aVar = (l40.a) RFWIocAbilityProvider.g().getIocInterface(l40.a.class, partRootView, null);
        if (aVar == null) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "[hideFastPlay] real hide");
        aVar.Q6();
    }

    private void initLayerPageContainerListener() {
        this.mLayerPageContainer.B().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.4
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i3) {
                QCircleAspectScrollProcessor.getInstance().onScrollState(QFSLayerBasePart.this, i3);
                super.onPageScrollStateChanged(i3);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i3, float f16, int i16) {
                super.onPageScrolled(i3, f16, i16);
                QFSLayerBasePart.this.mLayerPageAdapter.onFeedPageScrolled(i3, f16, i16);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i3) {
                super.onPageSelected(i3);
                QFSLayerBasePart.this.pageContainerOnPageSelected(i3);
                VideoReport.traversePage(QFSLayerBasePart.this.mLayerPageContainer);
                QCircleForQZoneVideoState.setCurrentFeedPos(i3);
                QFSLayerBasePart.this.checkViewPagerPosIsValid();
            }
        });
        this.mLayerPageContainer.setOnLoadDataCallback(new QFSPageTurnContainer.h() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.5
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.h
            public void onLoadData(boolean z16, int i3) {
                QFSLayerBasePart.this.requestDataByTouchType(z16, false, i3);
            }
        });
    }

    private void initListener() {
        initLayerPageContainerListener();
    }

    private void initSchemaFeed(List<e30.b> list) {
        e30.b bVar;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(this.mSchemaFeedId) && (bVar = list.get(0)) != null && bVar.g() != null && TextUtils.equals(bVar.g().f398449id.get(), this.mSchemaFeedId)) {
            this.mSchemaFeedInfo = bVar;
        }
    }

    private void initSchemaInfo() {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getSchemeAttrs() != null) {
            this.mPushFrom = initBean.getSchemeAttrs().get(KEY_PUSH_IS_FROM);
            this.mSchemaFeedId = initBean.getSchemeAttrs().get("feedid");
            this.mReturnPageId = initBean.getSchemeAttrs().get("ret_pg");
        }
    }

    private boolean isRealLoadDataFinishFromServer(@NotNull UIStateData<List<e30.b>> uIStateData) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_layer_load_data_intercept_logic", true) || uIStateData.getType() != 103) {
            return true;
        }
        if (RFWLog.isDevelopLevel()) {
            RFWLog.d(TAG, RFWLog.DEV, "load data from rerank");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlerDataPosRefresh$0(int i3) {
        setViewPageToCurrentItem(this.mLayerPageContainer.B(), i3, isContainerOnScreen());
    }

    private void notifyAdapterOnUnselected(final int i3, final int i16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.6
            @Override // java.lang.Runnable
            public void run() {
                QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                if (qFSLayerBasePart.mLayerPageAdapter == null) {
                    return;
                }
                qFSLayerBasePart.onHandlerMessage("event_hide_comment", null);
                QFSLayerBasePart.this.mLayerPageAdapter.onFeedUnSelected(new RFWFeedSelectInfo(i3).setNextPosition(i16).setUnSelectedType("TYPE_UNSELECTED_NORMAL"));
            }
        });
    }

    private void recordFeedWasteInfo() {
        a.C0885a b16 = this.mFeedWasteCollector.b();
        this.mFeedWasteCollector.e();
        this.mPlayPageReport.H(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPageToCurrentItem(ViewPager2 viewPager2, int i3, boolean z16) {
        if (viewPager2 == null) {
            RFWLog.d(TAG, RFWLog.USR, "[setViewPageToCurrentItem] view page is null, position: " + i3);
            return;
        }
        try {
            viewPager2.setCurrentItem(i3, z16);
        } catch (Throwable th5) {
            RFWLog.e(TAG, RFWLog.USR, "[setViewPageToCurrentItem] ex: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkEmptyContentOperation() {
        if (isEmptyContent() && getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    protected void clearData() {
        if (getLayerPageAdapter() != null && getLayerPageAdapter().getNUM_BACKGOURND_ICON() != 0 && getLayerPageAdapter().getDataList() != null) {
            getLayerPageAdapter().I0(new ArrayList(), true, null);
            getLayerPageAdapter().notifyDataSetChanged();
        }
    }

    protected void disableViewPagerAnim() {
        QFSPageTurnContainer qFSPageTurnContainer;
        ViewPager2 B;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_view_pager_anim", true) && (qFSPageTurnContainer = this.mLayerPageContainer) != null && (B = qFSPageTurnContainer.B()) != null) {
            QLog.d(TAG, 1, "[disableViewPagerAnim] setPageTransformer empty");
            B.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.3
                @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
                public void transformPage(@NonNull View view, float f16) {
                }
            });
        }
    }

    protected MutableLiveData<UIStateData<List<e30.b>>> getDisplayFeedControl() {
        return null;
    }

    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTurnPageEvent.class);
        arrayList.add(QFSCollectedFeedEvent.class);
        return arrayList;
    }

    @Override // t40.a
    public List<e30.b> getFeedList() {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            return mVar.getDataList();
        }
        return null;
    }

    @Override // t40.a
    public int getFeedPosition() {
        return this.mCurrentFeedPos;
    }

    public int getFeedSourceType() {
        return 0;
    }

    public QCircleInitBean getInitBean() {
        return null;
    }

    public com.tencent.biz.qqcircle.immersive.adapter.m getLayerPageAdapter() {
        return this.mLayerPageAdapter;
    }

    public QFSPageTurnContainer getLayerPageContainer() {
        return this.mLayerPageContainer;
    }

    public int getLayerPageType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    protected com.tencent.biz.qqcircle.immersive.adapter.m getPageAdapter() {
        return new com.tencent.biz.qqcircle.immersive.adapter.m(getHostFragment());
    }

    public int getTabType() {
        return 0;
    }

    public Drawable getTransitionLoadingDrawable() {
        Object broadcastGetMessage = broadcastGetMessage("qfs_get_layer_transition_anim_drawable", null);
        if (!(broadcastGetMessage instanceof Drawable)) {
            return null;
        }
        return (Drawable) broadcastGetMessage;
    }

    public String getViewModelKey() {
        return TAG + hashCode();
    }

    protected abstract IDataDisplaySurface<e30.b> getViewModelSurface();

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleEmptyState() {
        QCircleStatusView qCircleStatusView;
        hideLoadingView();
        if (isEmptyContent() && (qCircleStatusView = this.mFaultHintView) != null) {
            qCircleStatusView.showEmptyView("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleErrorState(UIStateData<List<e30.b>> uIStateData, long j3, String str) {
        ViewStub viewStub;
        QCircleInitBean initBean;
        hideLoadingView();
        if (uIStateData != null && !uIStateData.getIsLoadMore() && (initBean = getInitBean()) != null) {
            com.tencent.biz.qqcircle.immersive.utils.y.k(initBean.getFeedId());
        }
        if (isPrivateFeed(j3)) {
            QLog.d(TAG, 1, "[handleErrorState] isPrivateFeed");
            if (this.mPermissionErrorView == null && (viewStub = (ViewStub) getPartRootView().findViewById(R.id.f44861qb)) != null) {
                this.mPermissionErrorView = (QCirclePermissionErrorView) viewStub.inflate();
            }
            if (this.mPermissionErrorView != null) {
                clearData();
                if (j3 == 10048) {
                    str = null;
                }
                this.mPermissionErrorView.e(getActivity(), str);
                return;
            }
        }
        if (isFatalError(j3)) {
            clearData();
            this.mFaultHintView.E0(str, false, j3);
            showBottomContainer(8);
        } else {
            if (canShowErrorView(uIStateData)) {
                clearData();
                this.mFaultHintView.B0(str);
                showBottomContainer(8);
                return;
            }
            com.tencent.biz.qqcircle.utils.cj.c(false, j3, str, 1, QCircleToast.f91645e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: handleFeedRsp */
    public void Z9(UIStateData<List<e30.b>> uIStateData) {
        String msg2;
        QLog.d(getTAG(), 1, "FeedLine_ listUIStateData = " + uIStateData.getState());
        com.tencent.biz.qqcircle.immersive.utils.ba.e(uIStateData.getData(), this.mCurrentFeedPos);
        this.mPlayPageReport.p(uIStateData);
        if (getLayerPageContainer() != null && getLayerPageAdapter() != null) {
            initSchemaFeed(uIStateData.getData());
            int state = uIStateData.getState();
            switch (state) {
                case -1001:
                    handlerDataPosRefresh(uIStateData);
                case -1002:
                    handlerInsertSilent(uIStateData);
                    break;
                case -1000:
                    handlerDataReplace(uIStateData);
                    break;
                default:
                    switch (state) {
                        case 0:
                            QLog.e(getTAG(), 1, "handleEmptyState() return empty data");
                            handleEmptyState();
                            hideFastPlay();
                            break;
                        case 1:
                            QLog.e(getTAG(), 1, "handleLoadState()");
                            Object broadcastGetMessage = broadcastGetMessage("qfs_is_open_layer_transition_anim", null);
                            if ((broadcastGetMessage instanceof Boolean) && ((Boolean) broadcastGetMessage).booleanValue()) {
                                hideLoadingView();
                            } else {
                                handleLoadState();
                            }
                            if (uIStateData.getData() != null) {
                                QLog.i(getTAG(), 1, "[handleFeedRsp] -> UIStateData.UI_STATE_LOADING -> handleSuccessState");
                                handleSuccessState(uIStateData, true);
                                break;
                            }
                            break;
                        case 2:
                        case 3:
                            if (uIStateData.getData() != null) {
                                QLog.i(getTAG(), 1, "handleFeedsRsp() return success  , size = " + uIStateData.getData().size() + " , isLoadMore = " + uIStateData.getIsLoadMore() + " , isFinish = " + uIStateData.getIsFinish() + " , isUpTurning = " + uIStateData.getIsUpTurning());
                                handleSuccessState(uIStateData, false);
                                break;
                            } else {
                                QLog.e(getTAG(), 1, "handleFeedsRsp() return list is empty");
                                break;
                            }
                        case 4:
                            QLog.e(getTAG(), 1, "handleFeedsRsp() return error status");
                            if (uIStateData.getMsg() == null) {
                                msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8);
                            } else {
                                msg2 = uIStateData.getMsg();
                            }
                            handleErrorState(uIStateData, uIStateData.getRetCode(), msg2);
                            hideFastPlay();
                            break;
                        case 5:
                            handleSuccessState(uIStateData, true);
                            break;
                        case 6:
                            handleDeleteState(uIStateData);
                            break;
                        case 7:
                            handleModifyState(uIStateData);
                            break;
                        case 8:
                            handleInsertState(uIStateData);
                            break;
                    }
            }
            if (state != 1 && isRealLoadDataFinishFromServer(uIStateData)) {
                this.mLayerPageContainer.p(!uIStateData.getIsFinish());
                this.mLayerPageContainer.o(!uIStateData.getIsFinish());
            }
            QCircleDebugInfoDataManager.h().m(uIStateData.getData());
        }
    }

    protected void handleLoadState() {
        if (!isEmptyContent()) {
            return;
        }
        QCircleStatusView qCircleStatusView = this.mFaultHintView;
        if (qCircleStatusView != null) {
            qCircleStatusView.o0();
            showBottomContainer(0);
        }
        QCirclePanelLoadingView qCirclePanelLoadingView = this.mLoadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.n0();
        }
        QLog.d(TAG, 1, "[LoadMore-handleLoadState]");
        if (this.mLayerPageContainer != null && z20.h.b()) {
            this.mLayerPageContainer.setLoadMoreEnable(false);
            this.mLayerPageContainer.setTouchEnable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleSuccessState(final UIStateData<List<e30.b>> uIStateData, boolean z16) {
        hideLoadingView();
        final int pos = uIStateData.getPos();
        QCircleStatusView qCircleStatusView = this.mFaultHintView;
        if (qCircleStatusView == null) {
            return;
        }
        qCircleStatusView.o0();
        showBottomContainer(0);
        if (uIStateData.isFakeData()) {
            this.mLayerPageContainer.setFakeLoadingMoreAnim();
        } else if (this.mLayerPageContainer.I()) {
            this.mLayerPageContainer.l();
        }
        if (uIStateData.getIsLoadMore()) {
            handleModifyState(uIStateData);
        } else if (uIStateData.getIsUpTurning()) {
            com.tencent.biz.qqcircle.immersive.manager.f.f().l(this.mLayerPageAdapter.getDataList());
            this.mLayerPageAdapter.I0(uIStateData.getData(), false, null);
        } else {
            int i3 = this.mCurrentFeedPos;
            if (i3 != -1 && i3 != pos) {
                this.mLayerPageAdapter.onFeedUnSelected(new RFWFeedSelectInfo(i3).setNextPosition(0));
            }
            this.mCurrentFeedPos = pos;
            List<e30.b> dataList = this.mLayerPageAdapter.getDataList();
            com.tencent.biz.qqcircle.immersive.manager.f.f().l(dataList);
            this.mLayerPageAdapter.I0(uIStateData.getData(), true, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.9
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d(QFSLayerBasePart.TAG, 1, "[handleSuccessState] setDataList call, pos: " + pos);
                    com.tencent.biz.qqcircle.immersive.adapter.m mVar = QFSLayerBasePart.this.mLayerPageAdapter;
                    if (mVar != null && mVar.getDataList().size() != 0) {
                        QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                        if (qFSLayerBasePart.mLayerPageContainer != null) {
                            qFSLayerBasePart.fakeDateNotifyDataSetChanged((List) uIStateData.getData());
                            QFSLayerBasePart qFSLayerBasePart2 = QFSLayerBasePart.this;
                            qFSLayerBasePart2.mIsNeedDelaySendFeedChangeEvent = true;
                            int currentItem = qFSLayerBasePart2.mLayerPageContainer.B().getCurrentItem();
                            int i16 = pos;
                            if (currentItem != i16) {
                                QLog.d(QFSLayerBasePart.TAG, 1, "[handleSuccessState] setDataList setCurrentItem: " + pos);
                                QFSLayerBasePart qFSLayerBasePart3 = QFSLayerBasePart.this;
                                qFSLayerBasePart3.setViewPageToCurrentItem(qFSLayerBasePart3.mLayerPageContainer.B(), pos, false);
                                return;
                            }
                            QFSLayerBasePart.this.notifyCurrentFeedChange(i16);
                            if (!uq3.c.e0()) {
                                QLog.d(QFSLayerBasePart.TAG, 1, "[handleSuccessState] setDataList notify selected return");
                                return;
                            }
                            QLog.d(QFSLayerBasePart.TAG, 1, "[handleSuccessState] setDataList notify selected: " + pos);
                            QFSLayerBasePart.this.notifyAdapterOnSelected(pos, "TYPE_SELECT_REFRESH");
                        }
                    }
                }
            });
            fastSetViewPagerPos(pos);
            notifyDataRefresh(dataList);
            this.mLayerPageAdapter.onDataRefresh();
        }
        u30.d.d().n(uIStateData.getData(), pos);
        noticeLazyLoadRightPersonalPage(uIStateData.getIsLoadMore());
        QFSEcommercePreloadManager.j().n(getContext(), getPageId(), uIStateData.getData());
    }

    protected void handlerDataReplace(UIStateData<List<e30.b>> uIStateData) {
        triggerFeedReplace((e30.b) RFSafeListUtils.get(uIStateData.getData(), uIStateData.getPos()), uIStateData.getPos());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.mLoadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        QLog.d(TAG, 1, "[LoadMore-hideLoadingView]");
        if (this.mLayerPageContainer != null && z20.h.b()) {
            this.mLayerPageContainer.setLoadMoreEnable(true);
            this.mLayerPageContainer.setTouchEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPageReport(Activity activity) {
        this.mPlayPageReport.v(activity);
    }

    public boolean isContainerOnScreen() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEmptyContent() {
        if (getLayerPageAdapter() == null) {
            return true;
        }
        return getLayerPageAdapter().E0();
    }

    protected boolean isFatalError(long j3) {
        if (j3 != 10009 && j3 != 10014) {
            return false;
        }
        return true;
    }

    protected boolean isPrivateFeed(long j3) {
        if (j3 != 10048 && j3 != 10023) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void noticeLazyLoadRightPersonalPage(boolean z16) {
        if (this.hasNoticeLazyLoadRightPersonalPage) {
            return;
        }
        QFSLazyLoadUtils.f();
        this.hasNoticeLazyLoadRightPersonalPage = true;
    }

    protected void noticeRightPersonalData(int i3) {
        e30.b bVar;
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar == null || ab0.a.a(i3, mVar.getDataList()) || getContext() == null || w20.a.j().l(getContext().hashCode()) == null || (bVar = this.mLayerPageAdapter.getDataList().get(i3)) == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        e40.j jVar = new e40.j();
        jVar.f395620a = g16;
        jVar.f395621b = g16.poster.get();
        w20.a.j().l(getContext().hashCode()).postValue(jVar);
    }

    protected void notifyAdapterOnSelected(final int i3, final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.7
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.qqcircle.immersive.adapter.m mVar = QFSLayerBasePart.this.mLayerPageAdapter;
                if (mVar == null) {
                    return;
                }
                mVar.onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType(str));
            }
        });
        noticeRightPersonalData(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyCurrentFeedChange(int i3) {
        if (this.mLayerPageContainer == null) {
            return;
        }
        if (this.mContentAdapterFeedPos != i3) {
            QLog.d(getTAG(), 1, "notifyCurrentFeedChange = " + i3);
        }
        this.mContentAdapterFeedPos = i3;
        broadcastPartUpdateFeed();
        int q16 = this.mLayerPageContainer.q();
        this.mLayerPageContainer.k(i3, q16);
        this.mLayerPageContainer.i(i3, q16);
        noticeRightPersonalData(i3);
    }

    public void notifyPostFeedChange(boolean z16, final String str) {
        long j3;
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.13
            @Override // java.lang.Runnable
            public void run() {
                QFSPageTurnContainer qFSPageTurnContainer;
                QFSLayerBasePart qFSLayerBasePart = QFSLayerBasePart.this;
                com.tencent.biz.qqcircle.immersive.adapter.m mVar = qFSLayerBasePart.mLayerPageAdapter;
                if (mVar != null && (qFSPageTurnContainer = qFSLayerBasePart.mLayerPageContainer) != null) {
                    mVar.onFeedSelected(new RFWFeedSelectInfo(qFSPageTurnContainer.B().getCurrentItem()).setSelectedType(str));
                    QFSLayerBasePart qFSLayerBasePart2 = QFSLayerBasePart.this;
                    qFSLayerBasePart2.notifyCurrentFeedChange(qFSLayerBasePart2.mCurrentFeedPos);
                }
            }
        };
        if (z16) {
            j3 = 0;
        } else {
            j3 = 200;
        }
        rFWThreadManager.postMainDelay(runnable, j3, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.d(getTAG(), 1, "fs_lifecycle onActivityResult mCurrentFeedPos = " + this.mCurrentFeedPos);
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.onResumed(new RFWFeedSelectInfo(this.mCurrentFeedPos));
        }
    }

    public void onHandlerMessage(String str, Object... objArr) {
        PartManager partManager = getPartManager();
        if (partManager == null) {
            QLog.d(getTAG(), 1, "[onTabHandlerMessage] manager should not be null.");
            return;
        }
        if (TextUtils.equals(str, "event_open_comment")) {
            partManager.broadcastMessage("comment_panel_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_hide_comment")) {
            partManager.broadcastMessage("comment_panel_dismiss", null);
            return;
        }
        if (TextUtils.equals(str, "event_open_comment_input")) {
            partManager.broadcastMessage("comment_input_window_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_share")) {
            partManager.broadcastMessage("share_action_show_share_sheet", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_silent_share")) {
            partManager.broadcastMessage("share_action_silent_share", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_friend_push_panel")) {
            partManager.broadcastMessage("light_interact_list_show", objArr[0]);
            return;
        }
        if (TextUtils.equals(str, "event_open_push_progress_panel")) {
            broadcastMessage("open_push_progress_panel", objArr[0]);
        } else if (TextUtils.equals(str, "event_open_push_mission_panel")) {
            broadcastMessage("open_push_mission_panel", objArr[0]);
        } else if (TextUtils.equals(str, "event_open_similar_panel")) {
            broadcastMessage("action_open_similar_panel", objArr[0]);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        MutableLiveData<UIStateData<List<e30.b>>> displayFeedControl;
        super.onInitView(view);
        registerIoc(this, t40.a.class);
        QFSPageTurnContainer qFSPageTurnContainer = (QFSPageTurnContainer) view.findViewById(R.id.f165301vg1);
        this.mLayerPageContainer = qFSPageTurnContainer;
        this.mPlayPageReport.q(qFSPageTurnContainer, getReportBean(), getInitBean());
        initSchemaInfo();
        registerIoc(this.mLayerPageContainer, this, t40.c.class);
        registerIoc(this.mLayerPageContainer, this, t40.h.class);
        registerIoc(this.mLayerPageContainer, this.mPlayPageReport, t40.f.class);
        this.mLayerPageAdapter = getPageAdapter();
        if (this.mLayerPageContainer.B() != null) {
            this.mLayerPageContainer.B().setAdapter(this.mLayerPageAdapter);
        } else {
            QLog.d(TAG, 1, "[onInitView] current view pager should not be null.");
        }
        this.mLayerPageContainer.setChildDisallowInterceptListener(new QFSPageTurnContainer.e() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.e
            public boolean isChildDisallowInterceptListener(View view2, e40.p pVar) {
                if (view2 instanceof com.tencent.biz.qqcircle.immersive.manager.a) {
                    boolean V = ((com.tencent.biz.qqcircle.immersive.manager.a) view2).V(pVar);
                    QCircleForQZoneVideoState.setIsDisallowInterceptEvent(V);
                    return V;
                }
                return false;
            }
        });
        this.mFaultHintView = (QCircleStatusView) view.findViewById(R.id.vfv);
        this.mBottomContainer = (FrameLayout) view.findViewById(R.id.vh5);
        this.mFaultHintView.setTokenByErrorCode(10014L, 16);
        this.mFaultHintView.setTokenByErrorCode(10009L, 1);
        this.mFaultHintView.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QFSLayerBasePart.this.mLayerPageContainer.g();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        com.tencent.biz.qqcircle.immersive.utils.w.a(this.mFaultHintView, QCircleDaTongConstant.ElementId.EM_XSJ_BLANK_FULL_TIP);
        this.mLoadingView = (QCirclePanelLoadingView) view.findViewById(R.id.f165300vg0);
        initListener();
        IDataDisplaySurface<e30.b> viewModelSurface = getViewModelSurface();
        if (viewModelSurface != null) {
            w20.a.j().registerDisplaySurface(getViewModelKey(), viewModelSurface);
            if (viewModelSurface instanceof QFSLayerBaseViewModel) {
                this.mFeedCounterWrapper = new t30.f(getTAG(), t30.f.T1(this.mLayerPageContainer.B()), ((QFSLayerBaseViewModel) viewModelSurface).j());
            }
        }
        if (this.mFeedCounterWrapper == null && (displayFeedControl = getDisplayFeedControl()) != null) {
            this.mFeedCounterWrapper = new t30.f(getTAG(), t30.f.T1(this.mLayerPageContainer.B()), displayFeedControl);
        }
        t30.f fVar = this.mFeedCounterWrapper;
        if (fVar != null) {
            fVar.O1(true);
        }
        disableViewPagerAnim();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        initPageReport(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QLog.d(getTAG(), 1, "fs_lifecycle onPartDestroy  mCurrentFeedPos = " + this.mCurrentFeedPos);
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QFSEcommercePreloadManager.j().r(getContext());
        this.mFeedWasteCollector.a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QLog.d(getTAG(), 1, "fs_lifecycle onPartPause  mCurrentFeedPos = " + this.mCurrentFeedPos);
        super.onPartPause(activity);
        recordFeedWasteInfo();
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.onPaused(new RFWFeedSelectInfo(this.mCurrentFeedPos));
        }
        e30.b currentSelectFeed = getCurrentSelectFeed();
        if (currentSelectFeed != null) {
            feedCloudMeta$StFeed = currentSelectFeed.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (!TextUtils.isEmpty(this.mPushFrom)) {
            this.mPlayPageReport.B("push_from", this.mPushFrom);
        }
        if (!TextUtils.isEmpty(this.mReturnPageId)) {
            QCirclePluginGlobalInfo.j0(this.mSchemaFeedInfo);
            QLog.d(getTAG(), 1, "fs_lifecycle onPartPause mReturnPageId:" + this.mReturnPageId + ",mSchemaFeedInfo:" + this.mSchemaFeedInfo);
        }
        this.mPlayPageReport.x(this.mCurrentFeedPos, feedCloudMeta$StFeed);
        t30.f fVar = this.mFeedCounterWrapper;
        if (fVar != null) {
            fVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    @RFWTestDataSource(key = "feed_recycle_view", objName = "mLayerPageContainer.mViewPager2")
    public void onPartResume(Activity activity) {
        QLog.d(getTAG(), 1, "fs_lifecycle onPartResume  mCurrentFeedPos = " + this.mCurrentFeedPos);
        super.onPartResume(activity);
        List<e30.b> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.onResumed(new RFWFeedSelectInfo(this.mCurrentFeedPos));
            arrayList = this.mLayerPageAdapter.getDataList();
        }
        this.mPlayPageReport.y(arrayList);
        noticeRightPersonalData(this.mCurrentFeedPos);
        t30.f fVar = this.mFeedCounterWrapper;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        QLog.d(getTAG(), 1, "fs_lifecycle onPartStart  mCurrentFeedPos = " + this.mCurrentFeedPos);
        super.onPartStart(activity);
        if (this.mLayerPageAdapter != null && uq3.c.N()) {
            this.mLayerPageAdapter.onStart(new RFWFeedSelectInfo(this.mCurrentFeedPos));
        } else {
            QLog.d(getTAG(), 1, "fs_lifecycle onPartStart  return ");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        QLog.d(getTAG(), 1, "fs_lifecycle onPartStop  mCurrentFeedPos = " + this.mCurrentFeedPos);
        super.onPartStop(activity);
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.onStop(new RFWFeedSelectInfo(this.mCurrentFeedPos));
        }
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTurnPageEvent) {
            handleTurnPageEvent((QFSTurnPageEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSCollectedFeedEvent) {
            handleCollectedFeedEvent((QFSCollectedFeedEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pageContainerOnPageSelected(int i3) {
        if (this.mCurrentFeedPos != i3) {
            QLog.d(getTAG(), 1, "fs_lifecycle mLayerPageContainer onPageSelected  position = " + i3 + " , mCurrentFeedPos = " + this.mCurrentFeedPos);
        }
        this.mCurrentFeedPos = i3;
        notifyCurrentFeedChange(i3);
    }

    protected void requestDataByTouchType(boolean z16, boolean z17, int i3) {
        requestData(z16, z17);
    }

    public void setContainerOnPageSelected(e30.b bVar) {
        List<e30.b> dataList;
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && qFSPageTurnContainer.B() != null) {
            com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
            if (mVar == null) {
                dataList = null;
            } else {
                dataList = mVar.getDataList();
            }
            if (dataList != null && !dataList.isEmpty()) {
                int size = dataList.size();
                int b16 = com.tencent.biz.qqcircle.utils.bj.b(dataList, bVar);
                if (b16 >= 0 && b16 < size) {
                    e30.b bVar2 = (e30.b) RFSafeListUtils.get(this.mLayerPageAdapter.getDataList(), b16);
                    QLog.e(TAG, 1, "VFS-[setContainerOnPageSelected] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(bVar2) + " | content: " + com.tencent.biz.qqcircle.utils.bj.e(bVar2) + " | position: " + b16);
                    setViewPageToCurrentItem(this.mLayerPageContainer.B(), b16, false);
                    return;
                }
                QLog.e(TAG, 1, "VFS-[setContainerOnPageSelected] current position: " + b16 + ",illegality.");
                return;
            }
            QLog.e(TAG, 1, "VFS-[setContainerOnPageSelected] current sources is empty.");
            return;
        }
        QLog.e(TAG, 1, "VFS-[setContainerOnPageSelected] view pager is null.");
    }

    public void showBottomContainer(int i3) {
        FrameLayout frameLayout = this.mBottomContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void switchToContentState() {
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && this.mLayerPageAdapter != null && qFSPageTurnContainer.B() != null) {
            RecyclerView.Adapter adapter = this.mLayerPageContainer.B().getAdapter();
            QLog.d(getTAG(), 1, "switchToContentState adapter:" + adapter + ",mEmptyAdapter:" + this.mEmptyAdapter);
            if (adapter == this.mEmptyAdapter) {
                QLog.d(getTAG(), 1, "[switchToContentState] switchToContentState real, mContentAdapterFeedPos: " + this.mContentAdapterFeedPos);
                this.mLayerPageContainer.B().setAdapter(this.mLayerPageAdapter);
                setViewPageToCurrentItem(this.mLayerPageContainer.B(), this.mContentAdapterFeedPos, false);
            }
        }
    }

    public void switchToEmptyState() {
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer == null || qFSPageTurnContainer.B() == null || this.mLayerPageContainer.B().getAdapter() == this.mEmptyAdapter) {
            return;
        }
        QLog.d(getTAG(), 1, "switchToEmptyState");
        this.mContentAdapterFeedPos = this.mLayerPageContainer.B().getCurrentItem();
        this.mEmptyAdapter.setHostFragment(getHostFragment());
        this.mLayerPageContainer.B().setAdapter(this.mEmptyAdapter);
        this.mLayerPageContainer.m();
        QFSBaseFragment hostFragment = getHostFragment();
        if (hostFragment != null) {
            String str = getContext().hashCode() + "_" + hostFragment.hashCode();
            for (String str2 : f40.a.f397822a) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().clearGroup(str, str2);
            }
            QLog.d(getTAG(), 1, "switchToEmptyState clearContext:" + str);
        }
    }

    @Override // t40.a
    public void triggerFeedReplace(e30.b bVar, int i3) {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.triggerFeedReplace(i3);
        } else {
            QLog.d(TAG, 1, "[triggerFeedReplace] mLayerPageAdapter == null.");
        }
    }

    public void triggerFullDetailFeed(e30.b bVar, int i3) {
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            mVar.triggerFullDetailFeed(i3);
        } else {
            QLog.d(TAG, 1, "[triggerFullDetailFeed] mLayerPageAdapter == null.");
        }
    }

    @Override // t40.h
    public void updateProgress(long j3) {
        broadcastMessage("feed_video_progress", Long.valueOf(j3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public QFSBaseFragment getHostFragment() {
        return super.getHostFragment();
    }

    protected void fakeDateNotifyDataSetChanged(List<e30.b> list) {
    }

    public void notifyDataRefresh(List<e30.b> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestData(boolean z16, boolean z17) {
    }
}

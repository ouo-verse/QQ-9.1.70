package com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QFSUpdateFeedListEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSFullScreenFeedAlbumChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenAlbumClickEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenAlbumModeChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenListScrollStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.utils.ab;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends QFSLayerBasePart {

    /* renamed from: d, reason: collision with root package name */
    private o f86610d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleInitBean f86611e;

    /* renamed from: f, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f86612f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f86613h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f86614i = false;

    /* renamed from: m, reason: collision with root package name */
    private int f86615m = -1;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            super.onPageScrollStateChanged(i3);
            QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[onPageScrollStateChanged] state: " + i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenListScrollStateChangeEvent(i3));
        }
    }

    private void E9(boolean z16) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (z16) {
            activity.finish();
        } else {
            G9(activity);
        }
    }

    private void F9(e30.b bVar, int i3) {
        QFSPageTurnContainer qFSPageTurnContainer;
        if (bVar != null && (qFSPageTurnContainer = this.mLayerPageContainer) != null) {
            VideoReport.setElementId(qFSPageTurnContainer, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(bVar));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_PUSHED, Boolean.valueOf(QCirclePluginUtil.isUserPushThisFeed(bVar.g().f398449id.get())));
            VideoReport.setElementParams(this.mLayerPageContainer, buildElementParams);
            VideoReport.setElementExposePolicy(this.mLayerPageContainer, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.mLayerPageContainer, EndExposurePolicy.REPORT_ALL);
        }
    }

    private void G9(final Activity activity) {
        if (activity == null) {
            return;
        }
        if (uq3.o.g1() && !N9()) {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            try {
                window.setWindowAnimations(0);
                activity.setRequestedOrientation(1);
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.O9(activity);
                    }
                }, 10L);
                return;
            } catch (Throwable th5) {
                QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[enterOutAnimFinish] out animation ex: ", th5);
                return;
            }
        }
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[enterOutAnimFinish] enter old flow, back pressed.");
        activity.onBackPressed();
    }

    private void H9(QFSFullScreenAlbumModeChangeEvent qFSFullScreenAlbumModeChangeEvent) {
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[handlerAlbumModeChangeEvent] feedId: " + qFSFullScreenAlbumModeChangeEvent.getFeedId() + " | isAlbumMode: " + qFSFullScreenAlbumModeChangeEvent.isAlbumMode());
        R9(qFSFullScreenAlbumModeChangeEvent.isAlbumMode());
    }

    private void I9(@NonNull QFSFullScreenCloseEvent qFSFullScreenCloseEvent) {
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[handlerFullScreenCloseEvent] feed id: " + qFSFullScreenCloseEvent.getFeedId());
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null) {
            QFSVideoView qFSVideoView = weakReference.get();
            if (qFSFullScreenCloseEvent.isFinishActivity() && qFSVideoView != null) {
                qFSVideoView.pause();
            }
            RFWPlayerReuseUtils.prepareToReusePlayer(qFSVideoView);
        }
        E9(qFSFullScreenCloseEvent.isFinishActivity());
    }

    private void J9(@NonNull QFSFullScreenAlbumClickEvent qFSFullScreenAlbumClickEvent) {
        List<e30.b> dataList;
        if (qFSFullScreenAlbumClickEvent.getUnSelectedFeed() != null && qFSFullScreenAlbumClickEvent.getSelectedFeed() != null && this.f86610d != null) {
            try {
                if (qFSFullScreenAlbumClickEvent.isAlbumListEnd()) {
                    R9(false);
                } else {
                    R9(true);
                }
                com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
                if (mVar == null) {
                    dataList = null;
                } else {
                    dataList = mVar.getDataList();
                }
                if (dataList == null) {
                    QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[handlerScreenAlbumClickEvent] source should not be null.");
                    return;
                }
                int d16 = bj.d(dataList, bj.g(qFSFullScreenAlbumClickEvent.getUnSelectedFeed()));
                if (d16 == -1) {
                    QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[notifyFeedReplaceData] current position illegality, end flow.");
                    return;
                }
                QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[notifyFeedReplaceData] layer position: " + d16 + " | unselected: " + bj.g(qFSFullScreenAlbumClickEvent.getUnSelectedFeed()) + " | selected: " + bj.g(qFSFullScreenAlbumClickEvent.getSelectedFeed()) + " | adapterSource: " + bj.g(dataList.get(d16)));
                e30.b bVar = dataList.get(d16);
                String g16 = bj.g(bVar);
                e30.b bVar2 = new e30.b(qFSFullScreenAlbumClickEvent.getSelectedFeed());
                bVar.m(bVar2);
                triggerFeedReplace(bVar, d16);
                SimpleEventBus.getInstance().dispatchEvent(new QFSUpdateFeedListEvent(g16, bVar2, 2));
                return;
            } catch (Throwable th5) {
                QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[handlerScreenAlbumClickEvent] error: ", th5);
                return;
            }
        }
        QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[handlerScreenAlbumClickEvent] current feed data illegal, end flow.");
    }

    private void K9() {
        MutableLiveData<UIStateData<List<e30.b>>> j3;
        o oVar = this.f86610d;
        if (oVar == null) {
            j3 = null;
        } else {
            j3 = oVar.j();
        }
        if (j3 == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[initObserver] error: ", new NullPointerException());
        } else if (getHostFragment() == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[initObserver] host fragment should not be null, ex: ", new NullPointerException());
        } else {
            j3.observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    l.this.P9((UIStateData) obj);
                }
            });
        }
    }

    private void L9() {
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
            this.f86611e = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        }
        this.f86613h = ab.u(this.f86611e);
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[initScrollExpValue] mIsSupportScrollExp: " + this.f86613h);
    }

    private void M9() {
        String str;
        if (this.f86610d == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[initViewData] full screen view model should not be null.");
            return;
        }
        L9();
        QCircleInitBean qCircleInitBean = this.f86611e;
        if (qCircleInitBean == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[initViewData] current init bean is null, end flow.", new NullPointerException());
            getActivity().finish();
            return;
        }
        FeedCloudMeta$StFeed feed = qCircleInitBean.getFeed();
        F9(new e30.b(feed), this.f86611e.getDataPosInList());
        this.f86610d.j2(Arrays.asList(feed));
        if (this.f86613h) {
            this.f86610d.g2(this.f86611e, true, false);
        }
        if (feed == null) {
            str = null;
        } else {
            str = feed.f398449id.get();
        }
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[initViewData] mIsSupportScrollExp: " + this.f86613h + " | feedId: " + str);
    }

    private boolean N9() {
        return uq3.o.i0("MAA-AN10|").contains(DeviceInfoMonitor.getModel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O9(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[enterOutAnimFinish] activity finish, request orientation.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(UIStateData uIStateData) {
        Q9(uIStateData);
    }

    private void Q9() {
        QCircleInitBean qCircleInitBean = this.f86611e;
        if (qCircleInitBean == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[updateAlbumMode] update album mode fail.");
        } else {
            qCircleInitBean.putBusinessData("fullScreenAlbumMode", Boolean.valueOf(this.f86614i));
        }
    }

    private void R9(boolean z16) {
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[updateAlbumMode] isAlbumMode: " + z16);
        this.f86614i = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSFullScreenCloseEvent.class);
        eventClass.add(QFSFullScreenAlbumClickEvent.class);
        eventClass.add(QFSFullScreenAlbumModeChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    /* renamed from: getInitBean */
    public QCircleInitBean getMInitBean() {
        Q9();
        return this.f86611e;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        QCircleReportBean reportBean;
        if (getHostFragment() == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[getViewModelSurface] host fragment should not be null, ex: ", new NullPointerException());
            return null;
        }
        o oVar = (o) getHostFragment().getViewModel(o.class);
        this.f86610d = oVar;
        if (oVar != null && (reportBean = getReportBean()) != null) {
            this.f86610d.h2(reportBean.getDtPageId());
        }
        K9();
        M9();
        return this.f86610d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null && getHostFragment().isResumed()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void noticeLazyLoadRightPersonalPage(boolean z16) {
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[noticeLazyLoadRightPersonalPage] isLoadMore: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void notifyCurrentFeedChange(int i3) {
        o oVar;
        super.notifyCurrentFeedChange(i3);
        if (this.f86615m == i3 || !this.f86613h) {
            return;
        }
        if (ab.t(getMInitBean()) && (oVar = this.f86610d) != null && !this.f86614i) {
            oVar.e2(i3);
        }
        com.tencent.biz.qqcircle.immersive.adapter.m mVar = this.mLayerPageAdapter;
        if (mVar != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenFeedAlbumChangeEvent((e30.b) RFSafeListUtils.get(mVar.getDataList(), i3)));
        }
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[notifyCurrentFeedChange] pos: " + i3);
        R9(false);
        this.f86615m = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ViewGroup.LayoutParams layoutParams;
        super.onInitView(view);
        this.mLayerPageContainer.setRefreshEnable(false);
        this.mLayerPageContainer.setLoadMoreEnable(this.f86613h);
        ImageView z16 = this.mLayerPageContainer.z();
        ViewGroup.LayoutParams layoutParams2 = null;
        if (z16 == null) {
            layoutParams = null;
        } else {
            layoutParams = z16.getLayoutParams();
        }
        if (z16 != null && (layoutParams instanceof FrameLayout.LayoutParams)) {
            z16.setVisibility(8);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams3.height = 0;
            z16.setLayoutParams(layoutParams3);
        }
        QFSPullRefreshLayout y16 = this.mLayerPageContainer.y();
        if (y16 != null) {
            layoutParams2 = y16.getLayoutParams();
        }
        if (y16 != null && (layoutParams2 instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams4.setMargins(0, 0, 0, 0);
            y16.setLayoutParams(layoutParams4);
        }
        this.mLayerPageAdapter = new c(getHostFragment());
        this.mLayerPageContainer.B().setAdapter(this.mLayerPageAdapter);
        this.f86612f = new a();
        this.mLayerPageContainer.B().registerOnPageChangeCallback(this.f86612f);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer != null && qFSPageTurnContainer.B() != null) {
            this.mLayerPageContainer.B().unregisterOnPageChangeCallback(this.f86612f);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFullScreenCloseEvent) {
            I9((QFSFullScreenCloseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenAlbumClickEvent) {
            J9((QFSFullScreenAlbumClickEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFullScreenAlbumModeChangeEvent) {
            H9((QFSFullScreenAlbumModeChangeEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        o oVar = this.f86610d;
        if (oVar == null) {
            QLog.e("GFF-QFSFullScreenVideoListPart", 1, "[requestData] full screen view model should not be null.");
            return;
        }
        if (this.f86613h) {
            oVar.g2(this.f86611e, z16, z17);
        }
        QLog.d("GFF-QFSFullScreenVideoListPart", 1, "[requestData] isLoadMore: " + z16 + " | enableProtocolCache: " + z17 + " | mIsSupportScrollExp: " + this.f86613h);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
    }
}

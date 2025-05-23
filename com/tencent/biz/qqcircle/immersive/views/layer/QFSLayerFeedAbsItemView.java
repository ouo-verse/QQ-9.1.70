package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedExposeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.cm;
import com.tencent.biz.qqcircle.immersive.manager.a;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.j;
import com.tencent.biz.qqcircle.immersive.utils.at;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import e30.b;
import e40.p;
import feedcloud.FeedCloudMeta$StFeed;
import h20.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import t40.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSLayerFeedAbsItemView extends QCircleBaseWidgetView<b> implements IRFWLayerItemViewScrollerStatus, a {
    protected long C;
    protected t40.a D;
    protected f E;
    protected cm F;

    /* renamed from: d, reason: collision with root package name */
    protected HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> f90793d;

    /* renamed from: e, reason: collision with root package name */
    protected final HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> f90794e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f90795f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView.ViewHolder f90796h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f90797i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f90798m;

    public QFSLayerFeedAbsItemView(@NonNull Context context, int i3) {
        super(context, i3);
        this.f90794e = new LinkedHashMap();
        this.f90795f = false;
        this.f90797i = false;
        this.f90798m = false;
        this.C = -1L;
        this.F = null;
    }

    private void A0(Context context, View view) {
        if (view == null) {
            QLog.d(getLogTag(), 1, "[notifyInitView] root view should not be null.");
            return;
        }
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : s0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.X0(this.mParentView);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    qFSBaseFeedChildPresenter.N0(view);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                        QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onInitView:", Long.valueOf(currentTimeMillis2), "ms");
                    }
                } catch (NullPointerException e16) {
                    QCircleAlphaUserReporter.reportLog(QCircleAlphaUserReporter.KEY_FEED_ITEM_VIEW_NP_EXCEPTION_EVENT, new QCircleAlphaUserReportDataBuilder().setAttachInfo(Log.getStackTraceString(e16).substring(0, 1024)).setExtraInfo(qFSBaseFeedChildPresenter.w0()));
                    if (QCircleApplication.isRDMVersion() || HostAppSettingUtil.isGrayVersion()) {
                        QLog.e(getLogTag(), 1, "all children views:", at.d(view));
                    }
                    QLog.e(getLogTag(), 1, "onInitView error:", Log.getStackTraceString(e16));
                    throw e16;
                }
            }
        }
    }

    private void B0() {
        QLog.d(getLogTag(), 1, "fs_lifecycle [reCallLifecycleForDetailFeedRsp]");
        Collection<QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> values = s0().values();
        if (this.f90798m) {
            QLog.d(getLogTag(), 1, "fs_lifecycle [reCallLifecycleForDetailFeedRsp] onAttachedToWindow");
            for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : values) {
                if (qFSBaseFeedChildPresenter != null && !qFSBaseFeedChildPresenter.X()) {
                    qFSBaseFeedChildPresenter.K0();
                }
            }
        }
        if (this.f90797i) {
            QLog.d(getLogTag(), 1, "fs_lifecycle [reCallLifecycleForDetailFeedRsp] onViewHolderAttachedToWindow");
            for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter2 : values) {
                if (qFSBaseFeedChildPresenter2 != null && !qFSBaseFeedChildPresenter2.X()) {
                    qFSBaseFeedChildPresenter2.onViewHolderAttachedToWindow(this.f90796h);
                }
            }
        }
    }

    private void C0() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_simple_feed_enable_diy_dispatch_select_event", true)) {
            QLog.d(getLogTag(), 1, "fs_lifecycle [reCallSelectLifecycleForDetailFeedRsp] return from config");
            return;
        }
        QLog.d(getLogTag(), 1, "fs_lifecycle [reCallSelectLifecycleForDetailFeedRsp]");
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : s0().values()) {
            if (qFSBaseFeedChildPresenter != null && !qFSBaseFeedChildPresenter.X()) {
                qFSBaseFeedChildPresenter.onFeedSelected(new RFWFeedSelectInfo(this.dataPosInList).setSelectedType("TYPE_SELECT_TRIGGER_DETAIL_FEED_FULL"));
            }
        }
    }

    private String getViewPropParamValue(View view) {
        boolean z16;
        int hashCode = view.hashCode();
        boolean isHardwareAccelerated = view.isHardwareAccelerated();
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return "[hashCode" + hashCode + " | isHardwareAccelerated: " + isHardwareAccelerated + " | isVisible: " + z16;
    }

    private void l0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: v70.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerFeedAbsItemView.this.v0();
            }
        });
    }

    private QCircleExtraTypeInfo m0() {
        b data = getData();
        if (data == null) {
            QLog.d(getLogTag(), 1, "[createExtraInfo] data should not be null.");
            return null;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.pageType = getPageId();
        qCircleExtraTypeInfo.mFeed = data.g();
        qCircleExtraTypeInfo.mPlayScene = 2;
        qCircleExtraTypeInfo.sourceType = getParentPageId();
        qCircleExtraTypeInfo.mDataPosition = getDataPosInList();
        return qCircleExtraTypeInfo;
    }

    private void u0() {
        HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> s06 = s0();
        this.F = new cm();
        Iterator<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> it = p0().iterator();
        while (it.hasNext()) {
            Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> next = it.next();
            try {
                QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> newInstance = next.newInstance();
                if (newInstance != null && newInstance.H0()) {
                    this.F.c(newInstance);
                    newInstance.d1(this.mViewType);
                    s06.put(next, newInstance);
                    if (newInstance.X()) {
                        this.f90794e.put(next, newInstance);
                    }
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            }
        }
    }

    private void w0() {
        this.f90798m = true;
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.K0();
            }
        }
    }

    private void y0() {
        this.f90798m = false;
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.M0();
            }
        }
    }

    protected void D0(QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter) {
        QCircleExtraTypeInfo qCircleExtraTypeInfo = getQCircleExtraTypeInfo();
        if (qCircleExtraTypeInfo == null) {
            qCircleExtraTypeInfo = m0();
        }
        if (qFSBaseFeedChildPresenter != null) {
            qFSBaseFeedChildPresenter.U0(qCircleExtraTypeInfo);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.manager.a
    public boolean V(p pVar) {
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null && qFSBaseFeedChildPresenter.D0(pVar)) {
                if (pVar != null && this.C != pVar.c()) {
                    this.C = pVar.c();
                    QLog.d(getLogTag(), 1, "[isDisAllowInterceptEvent] return true from " + qFSBaseFeedChildPresenter);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ RFWVideoView getVideoView() {
        return com.tencent.biz.richframework.video.rfw.drive.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.D = (t40.a) getIocInterface(t40.a.class);
        u0();
        A0(getContext(), this);
    }

    public /* synthetic */ boolean isFloatingView() {
        return com.tencent.biz.richframework.video.rfw.drive.a.b(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ boolean isVideoType() {
        return com.tencent.biz.richframework.video.rfw.drive.a.c(this);
    }

    protected abstract void n0(@NonNull b bVar, int i3);

    public HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> o0() {
        if (this.f90795f) {
            return this.f90794e;
        }
        return s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        QLog.d(getLogTag(), 1, "fs_lifecycle [onAttachedToWindow]  pageId = " + getPageId());
        super.onAttachedToWindow();
        w0();
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.d(getLogTag(), 1, "fs_lifecycle onDestroy,itemViewType = " + this.mViewType);
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onDestroy();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onDestroy:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        QLog.d(getLogTag(), 1, "fs_lifecycle [onDetachedFromWindow]  pageId = " + getPageId());
        super.onDetachedFromWindow();
        y0();
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedPageScrolled(int i3, float f16, int i16) {
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onFeedPageScrolled(i3, f16, i16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    @RFWTestDataSource(key = "feed_item_view", objName = "this")
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        QLog.d(getLogTag(), 1, "fs_lifecycle onFeedSelected  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType + " ,thisPropParam: " + getViewPropParamValue(this));
        l0();
        if (this.dataPosInList != rFWFeedSelectInfo.getPosition()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d(getLogTag(), 1, "fs_lifecycle onFeedSelected updateNewPos = " + rFWFeedSelectInfo.getPosition());
            setDataPosInList(rFWFeedSelectInfo.getPosition());
        }
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                if (z16) {
                    qFSBaseFeedChildPresenter.onPosUpdate(rFWFeedSelectInfo.getPosition());
                }
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onFeedSelected(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onFeedSelected:", Long.valueOf(currentTimeMillis2), "ms");
                }
                if (qFSBaseFeedChildPresenter.E0() && !rFWFeedSelectInfo.isIsReselected()) {
                    qFSBaseFeedChildPresenter.Q0();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onFeedUnSelected  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType + " ,thisPropParam: " + getViewPropParamValue(this));
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onFeedUnSelected(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onFeedUnSelected:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onLoadFeedExport(int i3, int i16) {
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onLoadFeedExport(i3, i16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPageScrolledIdle(int i3) {
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onPageScrolledIdle(i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onPaused  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType);
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onPaused(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onPaused:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPosUpdate(int i3) {
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onPosUpdate(i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onResumed  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType + " ,thisPropParam: " + getViewPropParamValue(this));
        l0();
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onResumed(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onResumed:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onStart  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType + " ,thisPropParam: " + getViewPropParamValue(this));
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onStart(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onStart:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onStop  selectInfo = " + rFWFeedSelectInfo + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType);
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.onStop(rFWFeedSelectInfo);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onStop:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onViewHolderAttachedToWindow holder = " + viewHolder + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType);
        this.f90797i = true;
        this.f90796h = viewHolder;
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onViewHolderAttachedToWindow(viewHolder);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.d(getLogTag(), 1, "fs_lifecycle onViewHolderDetachedFromWindow holder = " + viewHolder + " ,itemView.dataPosInList = " + this.dataPosInList + " ,itemViewType = " + this.mViewType);
        this.f90797i = false;
        this.f90796h = null;
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onViewHolderDetachedFromWindow(viewHolder);
            }
        }
    }

    protected abstract ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0();

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.biz.qqcircle.immersive.layer.base.b q0() {
        t40.a aVar = this.D;
        if (aVar != null && aVar.getInitBean() != null) {
            return n50.a.a(this.D.getInitBean());
        }
        QLog.e(getLogTag(), 1, "mFeedIocInteract == null || mFeedIocInteract.getInitBean() == null");
        return null;
    }

    public f r0() {
        if (!c.h()) {
            return (f) getIocInterface(f.class);
        }
        if (this.E == null) {
            this.E = (f) getIocInterface(f.class);
        }
        return this.E;
    }

    public HashMap<Class, QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>> s0() {
        if (this.f90793d == null) {
            this.f90793d = new LinkedHashMap();
        }
        return this.f90793d;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setParentView(ViewGroup viewGroup) {
        super.setParentView(viewGroup);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(b bVar, int i3) {
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        for (QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> qFSBaseFeedChildPresenter : o0().values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.V0(bVar);
                D0(qFSBaseFeedChildPresenter);
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.L0(g16, i3);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d(getLogTag() + "_" + qFSBaseFeedChildPresenter.w0(), 1, "onBindData:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void v0() {
        b data = getData();
        if (data != null && data.g() != null) {
            FeedCloudMeta$StFeed g16 = data.g();
            t40.a aVar = this.D;
            if (aVar != null && aVar.isContainerOnScreen()) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedExposeEvent(g16, g16.f398449id.get()));
            }
            QCircleFolderFunnelCollect.setFeedInfo(g16.f398449id.get(), g16.type.get(), g16.video.playUrl.get());
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_CONTENT_EXPOSE);
            f r06 = r0();
            if (r06 != null) {
                r06.H6();
                return;
            }
            return;
        }
        QLog.d(getLogTag(), 1, "fs_lifecycle notifyFeedExpose data is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        boolean f16 = j.f(bVar);
        boolean z16 = this.f90795f;
        QLog.d(getLogTag(), 1, "fs_lifecycle [bindData]  isSimpleFeed = " + f16 + ",old bindDataIsSimpleFeed:" + z16);
        if (z16 && !f16) {
            B0();
        }
        this.f90795f = f16;
        x0(bVar, i3);
        n0(bVar, i3);
        if (!z16 || f16) {
            return;
        }
        C0();
    }
}

package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.event.QZoneAlbumSwitchTabEvent;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLoadingPercentProgressView;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoSearchDebugView;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoTopScanningWidgetView;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxSwitchTabEvent;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZonePermission;
import ha.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bJ\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "", "scanningStatus", "L9", "Q9", "", "isFullAuthorizeView", "P9", "R9", "Luc/a;", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "isSelected", "O9", "onPartDestroy", "", "getLogTag", "d", "Z", "standaloneMode", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "f", "mStandaloneRecyclerView", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;", tl.h.F, "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView;", "mFullAuthorizedView", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLoadingPercentProgressView;", "i", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLoadingPercentProgressView;", "mFullScanningView", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoSearchDebugView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoSearchDebugView;", "mSearchPicInfoDebugView", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoTopScanningWidgetView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoTopScanningWidgetView;", "mTopScanningView", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "D", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "E", "Landroid/view/View;", "mLoadingTipView", "Lha/b;", UserInfo.SEX_FEMALE, "Lha/b;", "mAuthorizedDialog", "Lqa/a;", "G", "Lqa/a;", "mRecommendListViewModel", "H", "I", "mLastScanningStatus", "<init>", "(Z)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendOperatePart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneAlbumxLocalPhotoTopScanningWidgetView mTopScanningView;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: E, reason: from kotlin metadata */
    private View mLoadingTipView;

    /* renamed from: F, reason: from kotlin metadata */
    private ha.b mAuthorizedDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private qa.a mRecommendListViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private int mLastScanningStatus = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean standaloneMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mStandaloneRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxLocalPhotoScanAuthorizeWidgetView mFullAuthorizedView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxLoadingPercentProgressView mFullScanningView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxLocalPhotoSearchDebugView mSearchPicInfoDebugView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart$b", "Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoScanAuthorizeWidgetView$b;", "Landroid/view/View;", "view", "", "hasConfirm", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.b {
        b() {
        }

        @Override // com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView.b
        public void a(View view, boolean hasConfirm) {
            Intrinsics.checkNotNullParameter(view, "view");
            QZoneAlbumxLocalPhotoRecommendOperatePart.this.P9(true);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f52699b;

        c(boolean z16) {
            this.f52699b = z16;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d(QZoneAlbumxLocalPhotoRecommendOperatePart.this.getTAG(), 1, "[requestStoragePermissionAndInitRecommend] --> isFullAuthorizeView = " + this.f52699b + ", onAllGranted");
            QZoneAlbumxLocalPhotoRecommendOperatePart.this.R9();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendOperatePart$d", "Lha/b$b;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements b.InterfaceC10426b {
        d() {
        }

        @Override // ha.b.InterfaceC10426b
        public void a() {
            QZoneAlbumxLocalPhotoRecommendOperatePart.this.P9(false);
        }
    }

    public QZoneAlbumxLocalPhotoRecommendOperatePart(boolean z16) {
        this.standaloneMode = z16;
    }

    private final uc.a I9() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(6);
        String a16 = com.qzone.util.l.a(R.string.jfk);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026ecommend_blank_title_txt)");
        QUIEmptyState.Builder title = imageType.setTitle(a16);
        String a17 = com.qzone.util.l.a(R.string.jfj);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_alb\u2026recommend_blank_desc_txt)");
        QUIEmptyState.Builder backgroundColorType = title.setDesc(a17).setBackgroundColorType(0);
        if (this.standaloneMode) {
            String string = getContext().getString(R.string.jfp);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026to_recommend_loading_tip)");
            backgroundColorType.setButton(string, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneAlbumxLocalPhotoRecommendOperatePart.J9(QZoneAlbumxLocalPhotoRecommendOperatePart.this, view);
                }
            });
        }
        uc.a d16 = new uc.a().d(backgroundColorType);
        Intrinsics.checkNotNullExpressionValue(d16, "QZoneBlankStateBean().setEmptyDataBuilder(builder)");
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZoneAlbumxLocalPhotoRecommendOperatePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ka.a y16 = ho.i.y();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y16.j(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoScanAuthorizeWidgetView] */
    /* JADX WARN: Type inference failed for: r11v12, types: [com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLocalPhotoTopScanningWidgetView] */
    /* JADX WARN: Type inference failed for: r11v15, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.view.View] */
    public final void L9(int scanningStatus) {
        QLog.d(getTAG(), 1, "[handleScanningStatusChanged] scanningStatus = " + scanningStatus + ", mLastScanningStatus = " + this.mLastScanningStatus);
        if (this.mLastScanningStatus == scanningStatus) {
            return;
        }
        this.mLastScanningStatus = scanningStatus;
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = this.mStandaloneRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStandaloneRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(8);
        QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = this.mFullAuthorizedView;
        if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = null;
        }
        qZoneAlbumxLocalPhotoScanAuthorizeWidgetView.setVisibility(8);
        QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView = this.mFullScanningView;
        if (qZoneAlbumxLoadingPercentProgressView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullScanningView");
            qZoneAlbumxLoadingPercentProgressView = null;
        }
        qZoneAlbumxLoadingPercentProgressView.setVisibility(8);
        View view = this.mLoadingTipView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTipView");
            view = null;
        }
        view.setVisibility(8);
        QZoneAlbumxLocalPhotoTopScanningWidgetView qZoneAlbumxLocalPhotoTopScanningWidgetView = this.mTopScanningView;
        if (qZoneAlbumxLocalPhotoTopScanningWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopScanningView");
            qZoneAlbumxLocalPhotoTopScanningWidgetView = null;
        }
        qZoneAlbumxLocalPhotoTopScanningWidgetView.setVisibility(8);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView2 = null;
        }
        qZoneBlankStateView2.o0();
        if (scanningStatus == 0) {
            ?? r112 = this.mFullAuthorizedView;
            if (r112 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
            } else {
                qZoneBlankStateView = r112;
            }
            qZoneBlankStateView.setVisibility(0);
            Q9();
            return;
        }
        if (scanningStatus == 1) {
            QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView2 = this.mFullScanningView;
            if (qZoneAlbumxLoadingPercentProgressView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFullScanningView");
                qZoneAlbumxLoadingPercentProgressView2 = null;
            }
            qZoneAlbumxLoadingPercentProgressView2.setVisibility(0);
            QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView3 = this.mFullScanningView;
            if (qZoneAlbumxLoadingPercentProgressView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFullScanningView");
                qZoneAlbumxLoadingPercentProgressView3 = null;
            }
            qZoneAlbumxLoadingPercentProgressView3.q0();
            if (this.standaloneMode) {
                ?? r113 = this.mLoadingTipView;
                if (r113 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadingTipView");
                } else {
                    qZoneBlankStateView = r113;
                }
                qZoneBlankStateView.setVisibility(0);
                return;
            }
            return;
        }
        if (scanningStatus == 2) {
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setVisibility(0);
            ?? r114 = this.mTopScanningView;
            if (r114 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopScanningView");
            } else {
                qZoneBlankStateView = r114;
            }
            qZoneBlankStateView.setVisibility(0);
            return;
        }
        if (scanningStatus == 3) {
            if (this.standaloneMode) {
                return;
            }
            ?? r115 = this.mRecyclerView;
            if (r115 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                qZoneBlankStateView = r115;
            }
            qZoneBlankStateView.setVisibility(0);
            return;
        }
        if (scanningStatus == 4) {
            QZoneBlankStateView qZoneBlankStateView3 = this.mBlankView;
            if (qZoneBlankStateView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            } else {
                qZoneBlankStateView = qZoneBlankStateView3;
            }
            qZoneBlankStateView.s0();
            return;
        }
        if (scanningStatus != 5) {
            return;
        }
        ?? r116 = this.mStandaloneRecyclerView;
        if (r116 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("mStandaloneRecyclerView");
        } else {
            qZoneBlankStateView = r116;
        }
        qZoneBlankStateView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZoneAlbumxLocalPhotoRecommendOperatePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ka.a y16 = ho.i.y();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y16.j(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(boolean isFullAuthorizeView) {
        boolean requestStoragePermission = QZonePermission.requestStoragePermission(getActivity(), new c(isFullAuthorizeView), QQPermissionConstants.Business.SCENE.QQ_QZONE_FEED_GUIDE_UPLOAD_ALBUM);
        if (requestStoragePermission) {
            QLog.d(getTAG(), 1, "[requestStoragePermissionAndInitRecommend] --> isFullAuthorizeView = " + isFullAuthorizeView + ", isGranted = " + requestStoragePermission);
            R9();
        }
    }

    private final void Q9() {
        com.qzone.reborn.albumx.qzone.local.g gVar = com.qzone.reborn.albumx.qzone.local.g.f52662a;
        boolean k3 = gVar.k();
        QLog.d(getTAG(), 1, "[showAuthorizedDialog] show authorized dialog, hasShowAuthorizedDialog = " + k3);
        if (k3 || this.standaloneMode) {
            return;
        }
        if (this.mAuthorizedDialog == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ha.b bVar = new ha.b(context);
            this.mAuthorizedDialog = bVar;
            Intrinsics.checkNotNull(bVar);
            bVar.X(new d());
        }
        ha.b bVar2 = this.mAuthorizedDialog;
        if (bVar2 != null) {
            bVar2.show();
        }
        gVar.o(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        ha.b bVar = this.mAuthorizedDialog;
        if (bVar != null) {
            bVar.dismiss();
        }
        o7.c.f(true);
        qa.a aVar = this.mRecommendListViewModel;
        qa.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        aVar.X1(1);
        qa.a aVar3 = this.mRecommendListViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.W1();
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxSwitchTabEvent(3));
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneAlbumSwitchTabEvent(4));
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(qa.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumx\u2026istViewModel::class.java)");
        qa.a aVar = (qa.a) viewModel;
        this.mRecommendListViewModel = aVar;
        qa.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        aVar.Z1(this.standaloneMode);
        qa.a aVar3 = this.mRecommendListViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar3 = null;
        }
        MutableLiveData<Integer> Q1 = aVar3.Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendOperatePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                QZoneAlbumxLocalPhotoRecommendOperatePart qZoneAlbumxLocalPhotoRecommendOperatePart = QZoneAlbumxLocalPhotoRecommendOperatePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneAlbumxLocalPhotoRecommendOperatePart.L9(it.intValue());
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxLocalPhotoRecommendOperatePart.M9(Function1.this, obj);
            }
        });
        qa.a aVar4 = this.mRecommendListViewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
        } else {
            aVar2 = aVar4;
        }
        aVar2.O1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendOperatePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nf7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_feed_list)");
        this.mRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.nfc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.rv_standalone_feed_list)");
        this.mStandaloneRecyclerView = (RecyclerView) findViewById2;
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f9669);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        RecyclerView recyclerView = this.mStandaloneRecyclerView;
        QZoneAlbumxLocalPhotoSearchDebugView qZoneAlbumxLocalPhotoSearchDebugView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStandaloneRecyclerView");
            recyclerView = null;
        }
        bVar.f(recyclerView, dimension);
        View findViewById3 = rootView.findViewById(R.id.f162800mp3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026oto_scan_authorized_view)");
        QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = (QZoneAlbumxLocalPhotoScanAuthorizeWidgetView) findViewById3;
        this.mFullAuthorizedView = qZoneAlbumxLocalPhotoScanAuthorizeWidgetView;
        if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = null;
        }
        bVar.e(qZoneAlbumxLocalPhotoScanAuthorizeWidgetView, dimension);
        ga.a aVar = new ga.a();
        aVar.e("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-first-frame.png");
        aVar.d("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-shouquan-animation.png");
        aVar.f(1);
        QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 = this.mFullAuthorizedView;
        if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 = null;
        }
        qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2.setData(aVar);
        QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 = this.mFullAuthorizedView;
        if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
            qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 = null;
        }
        qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3.setMOnViewClickListener(new b());
        View findViewById4 = rootView.findViewById(R.id.moh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ll_loading_progress_view)");
        QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView = (QZoneAlbumxLoadingPercentProgressView) findViewById4;
        this.mFullScanningView = qZoneAlbumxLoadingPercentProgressView;
        if (this.standaloneMode) {
            if (qZoneAlbumxLoadingPercentProgressView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFullScanningView");
                qZoneAlbumxLoadingPercentProgressView = null;
            }
            qZoneAlbumxLoadingPercentProgressView.setDurationScale(6.0f);
        }
        View findViewById5 = rootView.findViewById(R.id.mpe);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_photo_top_scanning_view)");
        this.mTopScanningView = (QZoneAlbumxLocalPhotoTopScanningWidgetView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.mpf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026l_recommend_search_debug)");
        this.mSearchPicInfoDebugView = (QZoneAlbumxLocalPhotoSearchDebugView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.qzone_blank_view)");
        QZoneBlankStateView qZoneBlankStateView = (QZoneBlankStateView) findViewById7;
        this.mBlankView = qZoneBlankStateView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(I9());
        View findViewById8 = rootView.findViewById(R.id.moi);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026bumx_full_loading_tip_tv)");
        this.mLoadingTipView = findViewById8;
        if (findViewById8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTipView");
            findViewById8 = null;
        }
        findViewById8.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumxLocalPhotoRecommendOperatePart.N9(QZoneAlbumxLocalPhotoRecommendOperatePart.this, view);
            }
        });
        initViewModel();
        boolean b16 = o7.c.b();
        boolean j3 = com.qzone.reborn.albumx.qzone.local.g.f52662a.j();
        QLog.d(getTAG(), 1, "[onInitView] hasOpenAuthorizedSwitch=" + b16 + ", hasReadStoragePermission=" + j3);
        QZoneUploadRecommendDirector.INSTANCE.a().preloadRes();
        if (b16 && j3) {
            K9(getActivity());
            qa.a aVar2 = this.mRecommendListViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
                aVar2 = null;
            }
            aVar2.X1(1);
            qa.a aVar3 = this.mRecommendListViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
                aVar3 = null;
            }
            aVar3.W1();
        } else {
            qa.a aVar4 = this.mRecommendListViewModel;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
                aVar4 = null;
            }
            aVar4.X1(0);
        }
        if (gd.a.f401926a.c("KEY_SHOW_RECOMMEND_PHOTO_DEBUG_INFO", false)) {
            QZoneAlbumxLocalPhotoSearchDebugView qZoneAlbumxLocalPhotoSearchDebugView2 = this.mSearchPicInfoDebugView;
            if (qZoneAlbumxLocalPhotoSearchDebugView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchPicInfoDebugView");
            } else {
                qZoneAlbumxLocalPhotoSearchDebugView = qZoneAlbumxLocalPhotoSearchDebugView2;
            }
            qZoneAlbumxLocalPhotoSearchDebugView.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        qa.a aVar = this.mRecommendListViewModel;
        QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        aVar.a2();
        QZoneAlbumxLoadingPercentProgressView qZoneAlbumxLoadingPercentProgressView2 = this.mFullScanningView;
        if (qZoneAlbumxLoadingPercentProgressView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFullScanningView");
        } else {
            qZoneAlbumxLoadingPercentProgressView = qZoneAlbumxLoadingPercentProgressView2;
        }
        qZoneAlbumxLoadingPercentProgressView.release();
    }

    private final void K9(Activity activity) {
        if (activity == null || Build.VERSION.SDK_INT < 29 || !com.qzone.reborn.configx.g.f53821a.b().u()) {
            return;
        }
        com.qzone.reborn.albumx.qzone.local.g gVar = com.qzone.reborn.albumx.qzone.local.g.f52662a;
        if (gVar.i() || !gVar.j()) {
            return;
        }
        QLog.d(getTAG(), 1, "[checkMediaLocationPermission] --> request permission");
        ActivityCompat.requestPermissions(activity, new String[]{QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION}, 0);
    }

    public final void O9(boolean isSelected) {
        if (isSelected) {
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = this.mFullAuthorizedView;
            QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 = null;
            if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
                qZoneAlbumxLocalPhotoScanAuthorizeWidgetView = null;
            }
            if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView.getVisibility() == 0) {
                QZoneAlbumxLocalPhotoScanAuthorizeWidgetView qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 = this.mFullAuthorizedView;
                if (qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFullAuthorizedView");
                } else {
                    qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2 = qZoneAlbumxLocalPhotoScanAuthorizeWidgetView3;
                }
                qZoneAlbumxLocalPhotoScanAuthorizeWidgetView2.u0();
            }
        }
    }
}

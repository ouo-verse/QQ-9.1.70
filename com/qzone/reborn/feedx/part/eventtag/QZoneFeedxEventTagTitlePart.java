package com.qzone.reborn.feedx.part.eventtag;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.qzone.reborn.feedx.widget.refresh.QZoneOnlyProgressRefreshHeader;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010 R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "ha", "initViewModel", "ga", "Z9", "W5", "", "aa", "ca", "da", "verticalOffset", "totalScrollRange", "ba", "", "animRatio", "pa", "Y9", "V9", "view", "leftMarginDp", "W9", "rightMarginDp", "X9", "", "getLogTag", "onInitView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mTitleBar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mTitleBackView", "f", "mTitleMoreView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mCenterTextView", "Lcom/google/android/material/appbar/AppBarLayout;", "i", "Lcom/google/android/material/appbar/AppBarLayout;", "mAppBarLayout", "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/refresh/QZoneOnlyProgressRefreshHeader;", "mRefreshHeader", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "D", "mCoverContainerView", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "E", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mEventTagViewModel", UserInfo.SEX_FEMALE, "I", "mCurVerticalOffset", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagTitlePart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: G, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int H = ef.d.b(25);
    private static final int I = ef.d.b(100);

    /* renamed from: C, reason: from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout mCoverContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneFeedxEventTagViewModel mEventTagViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCurVerticalOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mTitleBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitleBackView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitleMoreView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mCenterTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout mAppBarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneOnlyProgressRefreshHeader mRefreshHeader;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagTitlePart$a;", "", "", "COVER_BG_SCROLL_THRESHOLD", "I", "a", "()I", "COVER_BG_TOP_MARGIN", "b", "", "COVER_BG_SCROLL_FACTOR", UserInfo.SEX_FEMALE, "ELEMENT_DISMISS_FACTOR", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QZoneFeedxEventTagTitlePart.H;
        }

        public final int b() {
            return QZoneFeedxEventTagTitlePart.I;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagTitlePart$b", "Lcom/google/android/material/appbar/AppBarLayout$g;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements AppBarLayout.g {
        b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (QZoneFeedxEventTagTitlePart.this.mCurVerticalOffset == verticalOffset) {
                return;
            }
            QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = QZoneFeedxEventTagTitlePart.this.mEventTagViewModel;
            SmartRefreshLayout smartRefreshLayout = null;
            if (qZoneFeedxEventTagViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
                qZoneFeedxEventTagViewModel = null;
            }
            if (qZoneFeedxEventTagViewModel.w2().getValue() == null) {
                QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = QZoneFeedxEventTagTitlePart.this.mEventTagViewModel;
                if (qZoneFeedxEventTagViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
                    qZoneFeedxEventTagViewModel2 = null;
                }
                UIStateData<List<BusinessFeedData>> value = qZoneFeedxEventTagViewModel2.x2().getValue();
                if (bl.b(value != null ? value.getData() : null)) {
                    return;
                }
            }
            QZoneFeedxEventTagTitlePart.this.mCurVerticalOffset = verticalOffset;
            SmartRefreshLayout smartRefreshLayout2 = QZoneFeedxEventTagTitlePart.this.mRefreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.setEnabled(verticalOffset >= 0);
            QZoneFeedxEventTagTitlePart.this.ba(verticalOffset, appBarLayout.p());
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagTitlePart$c", "Lth/a;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "", "onHeaderMoving", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends th.a {
        c() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(IRefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            float coerceAtLeast;
            float coerceAtMost;
            Companion companion = QZoneFeedxEventTagTitlePart.INSTANCE;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((offset - companion.a()) * 1.5f, 0.0f);
            FrameLayout frameLayout = QZoneFeedxEventTagTitlePart.this.mCoverContainerView;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverContainerView");
                frameLayout = null;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, companion.b());
            frameLayout.setTranslationY(coerceAtMost);
            RFWLog.d(QZoneFeedxEventTagTitlePart.this.getTAG(), RFWLog.USR, "onHeaderMoving, translationY:" + coerceAtLeast);
        }
    }

    private final void V9() {
        TextView textView = this.mCenterTextView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterTextView");
            textView = null;
        }
        textView.setVisibility(0);
        ImageView imageView2 = this.mTitleBackView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView2 = null;
        }
        imageView2.setBackgroundColor(0);
        ImageView imageView3 = this.mTitleMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
            imageView3 = null;
        }
        imageView3.setBackgroundColor(0);
        ImageView imageView4 = this.mTitleBackView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView4 = null;
        }
        W9(imageView4, ar.e(10.0f));
        ImageView imageView5 = this.mTitleMoreView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
            imageView5 = null;
        }
        X9(imageView5, ar.e(10.0f));
        ImageView imageView6 = this.mTitleBackView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView6 = null;
        }
        rn.h.a(imageView6, "qui_chevron_left_icon_navigation_01", R.color.qui_common_icon_primary);
        ImageView imageView7 = this.mTitleMoreView;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
        } else {
            imageView = imageView7;
        }
        rn.h.a(imageView, "qui_more_icon_navigation_01", R.color.qui_common_icon_primary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W5() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
            appBarLayout = null;
        }
        appBarLayout.setExpanded(true, true);
    }

    private final void W9(View view, int leftMarginDp) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = leftMarginDp;
        }
    }

    private final void X9(View view, int rightMarginDp) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = rightMarginDp;
        }
    }

    private final void Y9() {
        TextView textView = this.mCenterTextView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterTextView");
            textView = null;
        }
        textView.setVisibility(8);
        ImageView imageView2 = this.mTitleBackView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView2 = null;
        }
        imageView2.setBackgroundResource(R.drawable.f169970);
        ImageView imageView3 = this.mTitleMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
            imageView3 = null;
        }
        imageView3.setBackgroundResource(R.drawable.f169970);
        ImageView imageView4 = this.mTitleBackView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView4 = null;
        }
        W9(imageView4, ar.e(16.0f));
        ImageView imageView5 = this.mTitleMoreView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
            imageView5 = null;
        }
        X9(imageView5, ar.e(16.0f));
        ImageView imageView6 = this.mTitleBackView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView6 = null;
        }
        rn.h.a(imageView6, "qui_chevron_left_icon_navigation_01", R.color.qui_common_icon_white);
        ImageView imageView7 = this.mTitleMoreView;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
        } else {
            imageView = imageView7;
        }
        rn.h.a(imageView, "qui_more_icon_navigation_01", R.color.qui_common_icon_white);
    }

    private final void Z9() {
        fo.b j3 = new fo.b().j(EndExposurePolicy.REPORT_NONE);
        ImageView imageView = this.mTitleBackView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView = null;
        }
        fo.c.o(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, j3);
        ImageView imageView3 = this.mTitleMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
        } else {
            imageView2 = imageView3;
        }
        fo.c.o(imageView2, "em_qz_more", j3);
    }

    private final void ca() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
            appBarLayout = null;
        }
        appBarLayout.e(new b());
    }

    private final void da() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableOverScrollDrag(false);
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setHeaderMaxDragRate(2.0f);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setHeaderTriggerRate(0.9f);
        SmartRefreshLayout smartRefreshLayout5 = this.mRefreshLayout;
        if (smartRefreshLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout5 = null;
        }
        smartRefreshLayout5.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.feedx.part.eventtag.l
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZoneFeedxEventTagTitlePart.ea(QZoneFeedxEventTagTitlePart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout6 = this.mRefreshLayout;
        if (smartRefreshLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout6;
        }
        smartRefreshLayout2.setOnMultiListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(QZoneFeedxEventTagTitlePart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this$0.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        qZoneFeedxEventTagViewModel.P1();
    }

    private final void ga() {
        FrameLayout frameLayout = this.mTitleBar;
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout = null;
        }
        frameLayout.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(frameLayout.getContext()) + aa();
        frameLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(frameLayout.getContext()), 0, 0);
        QZoneOnlyProgressRefreshHeader qZoneOnlyProgressRefreshHeader2 = this.mRefreshHeader;
        if (qZoneOnlyProgressRefreshHeader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshHeader");
        } else {
            qZoneOnlyProgressRefreshHeader = qZoneOnlyProgressRefreshHeader2;
        }
        qZoneOnlyProgressRefreshHeader.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(qZoneOnlyProgressRefreshHeader.getContext()) + aa();
        qZoneOnlyProgressRefreshHeader.setPadding(0, ImmersiveUtils.getStatusBarHeight(qZoneOnlyProgressRefreshHeader.getContext()), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(QZoneFeedxEventTagTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W5();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZoneFeedxEventTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFeedxE\u2026TagViewModel::class.java)");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) viewModel;
        this.mEventTagViewModel = qZoneFeedxEventTagViewModel;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = null;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w26 = qZoneFeedxEventTagViewModel.w2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit> function1 = new Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagTitlePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                invoke2(qZoneTagFeedList$GetTagFeedListHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                TextView textView;
                AppBarLayout appBarLayout;
                PBStringField pBStringField;
                textView = QZoneFeedxEventTagTitlePart.this.mCenterTextView;
                AppBarLayout appBarLayout2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterTextView");
                    textView = null;
                }
                textView.setText((qZoneTagFeedList$GetTagFeedListHeadRsp == null || (pBStringField = qZoneTagFeedList$GetTagFeedListHeadRsp.tag_name) == null) ? null : pBStringField.get());
                appBarLayout = QZoneFeedxEventTagTitlePart.this.mAppBarLayout;
                if (appBarLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
                } else {
                    appBarLayout2 = appBarLayout;
                }
                appBarLayout2.setVerticalScrollBarEnabled(qZoneTagFeedList$GetTagFeedListHeadRsp == null);
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagTitlePart.ma(Function1.this, obj);
            }
        });
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel3 = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel3 = null;
        }
        MutableLiveData<UIStateData<List<BusinessFeedData>>> x26 = qZoneFeedxEventTagViewModel3.x2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends BusinessFeedData>>, Unit> function12 = new Function1<UIStateData<List<? extends BusinessFeedData>>, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagTitlePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends BusinessFeedData>> uIStateData) {
                invoke2((UIStateData<List<BusinessFeedData>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<BusinessFeedData>> uIStateData) {
                if (uIStateData != null) {
                    SmartRefreshLayout smartRefreshLayout = QZoneFeedxEventTagTitlePart.this.mRefreshLayout;
                    if (smartRefreshLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
                        smartRefreshLayout = null;
                    }
                    smartRefreshLayout.finishRefresh();
                }
            }
        };
        x26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagTitlePart.na(Function1.this, obj);
            }
        });
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel4 = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
        } else {
            qZoneFeedxEventTagViewModel2 = qZoneFeedxEventTagViewModel4;
        }
        MutableLiveData<Boolean> y26 = qZoneFeedxEventTagViewModel2.y2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagTitlePart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isScrollTop) {
                Intrinsics.checkNotNullExpressionValue(isScrollTop, "isScrollTop");
                if (isScrollTop.booleanValue()) {
                    QZoneFeedxEventTagTitlePart.this.W5();
                }
            }
        };
        y26.observe(lifecycleOwner3, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagTitlePart.oa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(QZoneFeedxEventTagTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(QZoneFeedxEventTagTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("open_event_tag_action_panel", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxEventTagTitlePart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ha(rootView);
        initViewModel();
        ga();
        ca();
        da();
    }

    private final int aa() {
        return ar.e(50.0f);
    }

    private final void ha(View rootView) {
        View findViewById = rootView.findViewById(R.id.mvx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026feed_event_tag_title_bar)");
        this.mTitleBar = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mv9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026one_event_tag_title_back)");
        this.mTitleBackView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.muf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026e_event_tag_center_title)");
        this.mCenterTextView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.mvb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026one_event_tag_title_more)");
        this.mTitleMoreView = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.mu9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026event_tag_app_bar_layout)");
        this.mAppBarLayout = (AppBarLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f162832mv3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026event_tag_refresh_header)");
        this.mRefreshHeader = (QZoneOnlyProgressRefreshHeader) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f162833mv4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026event_tag_refresh_layout)");
        this.mRefreshLayout = (SmartRefreshLayout) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.muk);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026vent_tag_cover_container)");
        this.mCoverContainerView = (FrameLayout) findViewById8;
        FrameLayout frameLayout = this.mTitleBar;
        ImageView imageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.eventtag.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedxEventTagTitlePart.ia(QZoneFeedxEventTagTitlePart.this, view);
            }
        });
        ImageView imageView2 = this.mTitleBackView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBackView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.eventtag.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedxEventTagTitlePart.ja(QZoneFeedxEventTagTitlePart.this, view);
            }
        });
        ImageView imageView3 = this.mTitleMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.eventtag.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedxEventTagTitlePart.la(QZoneFeedxEventTagTitlePart.this, view);
            }
        });
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102283", false);
        RFWLog.d(getTAG(), RFWLog.USR, "[initView], enableShareIcon:" + isSwitchOn);
        ImageView imageView4 = this.mTitleMoreView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleMoreView");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(isSwitchOn ? 0 : 8);
        Y9();
        Z9();
    }

    private final void pa(float animRatio) {
        int alphaComponent = ColorUtils.setAlphaComponent(getContext().getResources().getColor(R.color.qui_common_fill_light_primary), (int) (255.0f * animRatio));
        FrameLayout frameLayout = this.mTitleBar;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout = null;
        }
        frameLayout.setBackgroundColor(alphaComponent);
        if (animRatio < 1.0f) {
            Y9();
        } else {
            V9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(int verticalOffset, int totalScrollRange) {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(verticalOffset) / ((int) (totalScrollRange * 0.65f)), 1.0f);
        pa(coerceAtMost);
        FrameLayout frameLayout = this.mCoverContainerView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverContainerView");
            frameLayout = null;
        }
        frameLayout.setTranslationY(verticalOffset / 1.5f);
    }
}

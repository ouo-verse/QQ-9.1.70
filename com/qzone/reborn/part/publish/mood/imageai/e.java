package com.qzone.reborn.part.publish.mood.imageai;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.b;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.part.publish.mood.imageai.widget.QZonePublishAiTextLoadingView;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qshadow.QZoneAutoTexting$TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0002rsB\u0017\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u00100\u001a\u00020+\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0016\u0010\u001f\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010-R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010=R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010=R\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010\u0003\u00a8\u0006t"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/e;", "Landroid/app/Dialog;", "", "Z", "f0", "", "b0", "initViews", "w0", "i0", "j0", "showLoadingView", "e0", "u0", "Y", "p0", "q0", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "dataList", "o0", "Lkotlin/Pair;", "", "a0", "n0", "m0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "c0", "Lcm/b$c;", "listener", "r0", "Lcom/qzone/reborn/part/publish/mood/imageai/e$b;", "s0", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "D", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", UserInfo.SEX_FEMALE, "containerView", "Landroid/widget/FrameLayout;", "G", "Landroid/widget/FrameLayout;", "flContentView", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "ivTipsView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "tvTitleView", "Landroidx/recyclerview/widget/RecyclerView;", "J", "Landroidx/recyclerview/widget/RecyclerView;", "rvContent", "K", "ivLogoView", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "L", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "M", "ivRetryView", "Lcm/b;", "N", "Lcm/b;", "contentAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "P", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcm/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcm/e;", "footerAdapter", "Lcom/qzone/reborn/part/publish/mood/imageai/widget/QZonePublishAiTextLoadingView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/part/publish/mood/imageai/widget/QZonePublishAiTextLoadingView;", "loadingView", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankStateView", "T", "Lcm/b$c;", "itemClickListener", "U", "Lcom/qzone/reborn/part/publish/mood/imageai/e$b;", "clickRetryListener", "V", "Ljava/lang/Integer;", "aiTextStatus", "", "W", "isAddFooterView", "<init>", "(Landroid/app/Activity;Landroid/view/View;)V", "X", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends ReportDialog {
    private static final float Y = ar.e(320.0f) / ar.e(890.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout flContentView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView ivTipsView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView tvTitleView;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView rvContent;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView ivLogoView;

    /* renamed from: L, reason: from kotlin metadata */
    private QUIPolarLightView polarLightView;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView ivRetryView;

    /* renamed from: N, reason: from kotlin metadata */
    private cm.b contentAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private cm.e footerAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    private QZonePublishAiTextLoadingView loadingView;

    /* renamed from: S, reason: from kotlin metadata */
    private QZoneBlankStateView blankStateView;

    /* renamed from: T, reason: from kotlin metadata */
    private b.c itemClickListener;

    /* renamed from: U, reason: from kotlin metadata */
    private b clickRetryListener;

    /* renamed from: V, reason: from kotlin metadata */
    private Integer aiTextStatus;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isAddFooterView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/e$b;", "", "", UserInfo.SEX_FEMALE, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void F();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/qzone/reborn/part/publish/mood/imageai/e$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "", "d", "[Z", "canScroll", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean[] canScroll = new boolean[2];

        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            RecyclerView recyclerView = e.this.rvContent;
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (e.this.rvContent != null && linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() != 0) {
                    return true;
                }
                RecyclerView recyclerView2 = e.this.rvContent;
                Intrinsics.checkNotNull(recyclerView2);
                View childAt = recyclerView2.getChildAt(0);
                this.canScroll[1] = childAt == null || childAt.getTop() != 0;
                return this.canScroll[1];
            }
            return super.canScrollDown(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            RecyclerView recyclerView = e.this.rvContent;
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (e.this.rvContent != null && linearLayoutManager != null) {
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                RecyclerView recyclerView2 = e.this.rvContent;
                Intrinsics.checkNotNull(recyclerView2);
                boolean z16 = true;
                if (findLastVisibleItemPosition != recyclerView2.getChildCount() - 1) {
                    return true;
                }
                RecyclerView recyclerView3 = e.this.rvContent;
                Intrinsics.checkNotNull(recyclerView3);
                RecyclerView recyclerView4 = e.this.rvContent;
                Intrinsics.checkNotNull(recyclerView4);
                View childAt = recyclerView3.getChildAt(recyclerView4.getChildCount() - 1);
                boolean[] zArr = this.canScroll;
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    RecyclerView recyclerView5 = e.this.rvContent;
                    Intrinsics.checkNotNull(recyclerView5);
                    if (bottom == recyclerView5.getHeight()) {
                        z16 = false;
                    }
                }
                zArr[0] = z16;
                return this.canScroll[0];
            }
            return super.canScrollUp(x16, y16);
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57179d() {
            e eVar = e.this;
            eVar.containerView = LayoutInflater.from(eVar.getContext()).inflate(R.layout.hln, (ViewGroup) null);
            e.this.initViews();
            return e.this.containerView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return e.this.b0();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Activity activity, View rootView) {
        super(activity, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.activity = activity;
        this.rootView = rootView;
    }

    private final void Y() {
        RFWConcatAdapter rFWConcatAdapter;
        cm.e eVar;
        if (!this.isAddFooterView && (rFWConcatAdapter = this.concatAdapter) != null && (eVar = this.footerAdapter) != null) {
            this.isAddFooterView = true;
            if (rFWConcatAdapter != null) {
                Intrinsics.checkNotNull(eVar);
                rFWConcatAdapter.addAdapter(eVar);
                return;
            }
            return;
        }
        QLog.e("QZonePublishPicToTextHalfDialog", 1, "[addFooterView] concatAdapter" + this.concatAdapter);
    }

    private final void Z() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(19);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
        } catch (Exception e16) {
            QLog.e("QZonePublishPicToTextHalfDialog", 1, "setStatusTextColor fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b0() {
        return (int) (Y * pl.a.f426446a.n(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.rvContent;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(0);
    }

    private final void e0() {
        FrameLayout frameLayout;
        QZoneBlankStateView qZoneBlankStateView = new QZoneBlankStateView(getContext(), null);
        qZoneBlankStateView.setVisibility(8);
        if (qZoneBlankStateView.getParent() == null && (frameLayout = this.flContentView) != null) {
            frameLayout.addView(qZoneBlankStateView);
        }
        this.blankStateView = qZoneBlankStateView;
    }

    private final void f0() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        View x16 = qUSHalfScreenFloatingView.x();
        if (x16 != null) {
            x16.setBackground(getContext().getResources().getDrawable(R.drawable.lft));
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView4;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.part.publish.mood.imageai.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                e.g0(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void i0() {
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        ViewGroup.LayoutParams layoutParams = qUIPolarLightView != null ? qUIPolarLightView.getLayoutParams() : null;
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = b0();
        QUIPolarLightView qUIPolarLightView2 = this.polarLightView;
        if (qUIPolarLightView2 != null) {
            qUIPolarLightView2.setLayoutParams(layoutParams);
            PolarImageRender polarLightRender = qUIPolarLightView2.getPolarLightRender();
            polarLightRender.p(0.025f);
            polarLightRender.r(0.4f);
            polarLightRender.q(new a.b(0.7f, 0.5f, 0.7f, 0.5f, 0.0f));
            polarLightRender.s(f.f58673a.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initViews() {
        View view = this.containerView;
        if (view == null) {
            return;
        }
        this.flContentView = (FrameLayout) view.findViewById(R.id.f69073hr);
        this.ivLogoView = (ImageView) view.findViewById(R.id.f69083hs);
        this.tvTitleView = (TextView) view.findViewById(R.id.f69123hw);
        this.ivTipsView = (ImageView) view.findViewById(R.id.f69113hv);
        this.rvContent = (RecyclerView) view.findViewById(R.id.f69093ht);
        this.polarLightView = (QUIPolarLightView) view.findViewById(R.id.f69133hx);
        this.ivRetryView = (ImageView) view.findViewById(R.id.f69103hu);
        ImageView imageView = this.ivTipsView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.mood.imageai.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.k0(e.this, view2);
                }
            });
        }
        ImageView imageView2 = this.ivRetryView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.mood.imageai.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.l0(e.this, view2);
                }
            });
        }
        w0();
        i0();
        j0();
        showLoadingView();
        e0();
        p0();
        q0();
    }

    private final void j0() {
        cm.b bVar = new cm.b(this.rootView);
        bVar.q0(this.itemClickListener);
        this.contentAdapter = bVar;
        this.footerAdapter = new cm.e();
        this.concatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.contentAdapter});
        RecyclerView recyclerView = this.rvContent;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
            Intrinsics.checkNotNull(rFWConcatAdapter);
            recyclerView.setAdapter(rFWConcatAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m0() {
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView = this.loadingView;
        if (qZonePublishAiTextLoadingView != null) {
            qZonePublishAiTextLoadingView.n0();
        }
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView2 = this.loadingView;
        if (qZonePublishAiTextLoadingView2 != null) {
            qZonePublishAiTextLoadingView2.setVisibility(0);
        }
        cm.b bVar = this.contentAdapter;
        if (bVar != null) {
            bVar.setItems(new ArrayList());
        }
        RecyclerView recyclerView = this.rvContent;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankStateView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setVisibility(8);
        }
        b bVar2 = this.clickRetryListener;
        if (bVar2 != null) {
            bVar2.F();
        }
    }

    private final void n0() {
        ho.i.q(getContext(), "https://rule.tencent.com/rule/202409050001");
    }

    private final void p0() {
        fo.c.l(this.containerView, this.rootView);
        fo.c.o(this.containerView, "em_qz_pic_generate_text_result", new fo.b().g(ClickPolicy.REPORT_NONE));
    }

    private final void q0() {
        fo.c.l(this.ivRetryView, this.rootView);
        fo.c.o(this.ivRetryView, "em_qz_refresh", new fo.b().j(EndExposurePolicy.REPORT_NONE));
    }

    private final void showLoadingView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView = new QZonePublishAiTextLoadingView(context, null);
        if (qZonePublishAiTextLoadingView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            FrameLayout frameLayout = this.flContentView;
            if (frameLayout != null) {
                frameLayout.addView(qZonePublishAiTextLoadingView, layoutParams);
            }
        }
        qZonePublishAiTextLoadingView.setVisibility(0);
        qZonePublishAiTextLoadingView.n0();
        this.loadingView = qZonePublishAiTextLoadingView;
    }

    private final void u0() {
        String a16;
        RecyclerView recyclerView = this.rvContent;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankStateView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setVisibility(0);
            if (NetworkUtil.isNetworkAvailable()) {
                a16 = com.qzone.reborn.configx.g.f53821a.b().l1();
            } else {
                a16 = com.qzone.util.l.a(R.string.f2197967d);
            }
            qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.z(qZoneBlankStateView.getContext(), a16));
            qZoneBlankStateView.s0();
        }
    }

    private final void w0() {
        Option obtain = Option.obtain();
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain.setUrl(gVar.b().n1()).setTargetView(this.ivLogoView).setLoadingDrawableId(R.drawable.trans).setFailedDrawableId(R.drawable.trans));
        TextView textView = this.tvTitleView;
        if (textView == null) {
            return;
        }
        textView.setText(gVar.b().m1());
    }

    public final void c0(List<QZoneAutoTexting$TextInfo> dataList) {
        QLog.i("QZonePublishPicToTextHalfDialog", 1, "[handleAiTextInfo] dataList:" + dataList);
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView = this.loadingView;
        if (qZonePublishAiTextLoadingView != null) {
            qZonePublishAiTextLoadingView.setVisibility(8);
        }
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView2 = this.loadingView;
        if (qZonePublishAiTextLoadingView2 != null) {
            qZonePublishAiTextLoadingView2.p0();
        }
        if (!bl.b(dataList)) {
            QZoneBlankStateView qZoneBlankStateView = this.blankStateView;
            if (qZoneBlankStateView != null) {
                qZoneBlankStateView.setVisibility(8);
            }
            cm.b bVar = this.contentAdapter;
            if (bVar != null) {
                bVar.setItems(dataList, new Runnable() { // from class: com.qzone.reborn.part.publish.mood.imageai.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.d0(e.this);
                    }
                });
            }
            Y();
        } else {
            u0();
        }
        o0(dataList);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.m();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Z();
        setContentView(R.layout.hlo);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        this.halfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        f0();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
        QZonePublishAiTextLoadingView qZonePublishAiTextLoadingView = this.loadingView;
        if (qZonePublishAiTextLoadingView != null) {
            qZonePublishAiTextLoadingView.p0();
        }
    }

    public final void r0(b.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
    }

    public final void s0(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.clickRetryListener = listener;
    }

    private final Pair<Integer, String> a0(List<QZoneAutoTexting$TextInfo> dataList) {
        String str = "";
        int i3 = 0;
        int i16 = 1;
        for (Object obj : dataList) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo = (QZoneAutoTexting$TextInfo) obj;
            if (qZoneAutoTexting$TextInfo.status.get() == 2) {
                i16 = 2;
            }
            str = ((Object) str) + qZoneAutoTexting$TextInfo.f429485id.get();
            if (i3 < dataList.size() - 1) {
                str = ((Object) str) + ",";
            }
            i3 = i17;
        }
        QLog.i("QZonePublishPicToTextHalfDialog", 1, "[getAiTextInfo] status:" + i16 + " allTextId:" + ((Object) str));
        return new Pair<>(Integer.valueOf(i16), str);
    }

    private final void o0(List<QZoneAutoTexting$TextInfo> dataList) {
        Map mutableMapOf;
        if (bl.b(dataList)) {
            QLog.e("QZonePublishPicToTextHalfDialog", 1, "[reportAiTextShow] dataList is empty");
            return;
        }
        Intrinsics.checkNotNull(dataList);
        Pair<Integer, String> a06 = a0(dataList);
        int intValue = a06.component1().intValue();
        String component2 = a06.component2();
        Integer num = this.aiTextStatus;
        if (num != null && num.intValue() == intValue) {
            QLog.e("QZonePublishPicToTextHalfDialog", 1, "[reportAiTextShow] same status is " + intValue);
            return;
        }
        this.aiTextStatus = Integer.valueOf(intValue);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("status", Integer.valueOf(intValue)), TuplesKt.to("all_text_id", component2));
        fo.c.c("ev_qz_candidate_text_show", mutableMapOf);
    }
}

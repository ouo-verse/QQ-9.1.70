package com.qzone.reborn.layer.part;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.layer.part.bw;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.gallery.anim.TransitionAnimUtil;
import com.tencent.richframework.gallery.anim.TransitionAnimator;
import com.tencent.richframework.gallery.anim.TransitionInitData;
import com.tencent.richframework.gallery.anim.TransitionManager;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 v2\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002:\u0001wB\u0007\u00a2\u0006\u0004\bt\u0010uJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0003J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\u0012\u0010%\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\fH\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\fH\u0016J\u0016\u00100\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u00102\u001a\u000201H\u0016R\u0018\u00105\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010GR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020#0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010XR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010q\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010s\u00a8\u0006x"}, d2 = {"Lcom/qzone/reborn/layer/part/bw;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "updateBackgroundAlpha", "", "changeIgnoreViewAlpha", "showIgnoreView", "", "ha", "la", "initAndStartAnim", "resetVisibleAndBg", "position", "Landroid/widget/ImageView;", "getCurrentImageView", "imageView", "initDragFrameLayout", "Landroid/graphics/RectF;", "getCurrentPicViewRect", "initStartAnim", "canShowExitAnim", "needUpdateRect", "updateEnd", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "animBean", "updateEnterRect", "updateCurrentPicView", "ga", "showExitAnim", "finishActivity", "Landroid/view/View;", "targetView", "ea", ViewStickEventHelper.IS_SHOW, "na", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "picInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "da", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onBackEvent", "uiStateData", "onChanged", "", "getLogTag", "d", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "mAnimBean", "Ljava/util/UUID;", "e", "Ljava/util/UUID;", "mTranUUID", "Lcom/tencent/richframework/gallery/anim/TransitionManager;", "f", "Lcom/tencent/richframework/gallery/anim/TransitionManager;", "mTransitionManager", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", tl.h.F, "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "mInitBean", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "mAnimRootLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mTempImageView", "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "mDragLayout", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "E", "mCurrentPicView", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "mHideViews", "G", "Z", "mHasInit", "H", "Ljava/lang/String;", "mEnterMediaId", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "I", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mEnterMediaInfo", "J", "mIsAfterPreDraw", "Lcom/tencent/libra/IPicLoader;", "K", "Lcom/tencent/libra/IPicLoader;", "mPicLoader", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "L", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "mOperationListener", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "getAnimCreator", "()Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "animCreator", "getRealScreenHeight", "()I", "realScreenHeight", "isSameEnterAndExist", "()Z", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bw extends RFWLayerBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    private RFWDragLayout mDragLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mCurrentPicView;

    /* renamed from: F, reason: from kotlin metadata */
    private final List<View> mHideViews = new ArrayList();

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHasInit;

    /* renamed from: H, reason: from kotlin metadata */
    private String mEnterMediaId;

    /* renamed from: I, reason: from kotlin metadata */
    private RFWLayerItemMediaInfo mEnterMediaInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsAfterPreDraw;

    /* renamed from: K, reason: from kotlin metadata */
    private IPicLoader mPicLoader;

    /* renamed from: L, reason: from kotlin metadata */
    private ILayerOperationListener mOperationListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile RFWTransAnimBean mAnimBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile UUID mTranUUID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TransitionManager mTransitionManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWLayerInitBean mInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mAnimRootLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mTempImageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/layer/part/bw$b", "Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "", "value", "onAnimaUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TransitionAnimator.OnAnimCallback {
        b() {
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimaUpdate(float value) {
            RFWDragLayout rFWDragLayout = bw.this.mDragLayout;
            if (rFWDragLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout = null;
            }
            rFWDragLayout.setWindowBgAlpha(value);
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationCancel() {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "onAnimationEnd");
            RecyclerView recyclerView = bw.this.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(0);
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationEnd() {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "onAnimationEnd");
            RecyclerView recyclerView = bw.this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            bw.this.na(false);
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationStart() {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "onAnimationStart");
            RecyclerView recyclerView = bw.this.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(4);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/layer/part/bw$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f58015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ bw f58016e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/layer/part/bw$c$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes37.dex */
        public static final class a extends RecyclerView.OnScrollListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ bw f58017d;

            a(bw bwVar) {
                this.f58017d = bwVar;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    RFWDragLayout rFWDragLayout = this.f58017d.mDragLayout;
                    if (rFWDragLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                        rFWDragLayout = null;
                    }
                    rFWDragLayout.setFeatureEnable(!this.f58017d.ha());
                }
            }
        }

        c(View view, bw bwVar) {
            this.f58015d = view;
            this.f58016e = bwVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean b(MotionEvent motionEvent, float f16, float f17) {
            return Math.abs(f16) <= f17;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f58015d.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f58016e.mIsAfterPreDraw = true;
            bw bwVar = this.f58016e;
            View findViewById = this.f58015d.findViewById(R.id.f20488i);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.drag_frame_layout)");
            bwVar.mDragLayout = (RFWDragLayout) findViewById;
            this.f58016e.mRecyclerView = (RecyclerView) this.f58015d.findViewById(R.id.neg);
            RFWDragLayout rFWDragLayout = this.f58016e.mDragLayout;
            UUID uuid = null;
            if (rFWDragLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout = null;
            }
            rFWDragLayout.setTargetDragView(this.f58016e.mRecyclerView);
            RecyclerView recyclerView = this.f58016e.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.addOnScrollListener(new a(this.f58016e));
            }
            RFWDragLayout rFWDragLayout2 = this.f58016e.mDragLayout;
            if (rFWDragLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout2 = null;
            }
            rFWDragLayout2.setFeatureEnable(true);
            RFWDragLayout rFWDragLayout3 = this.f58016e.mDragLayout;
            if (rFWDragLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout3 = null;
            }
            rFWDragLayout3.setEnableDragVertical(true);
            RFWDragLayout rFWDragLayout4 = this.f58016e.mDragLayout;
            if (rFWDragLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout4 = null;
            }
            rFWDragLayout4.setEnableDragHorizontal(true);
            RFWDragLayout rFWDragLayout5 = this.f58016e.mDragLayout;
            if (rFWDragLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout5 = null;
            }
            rFWDragLayout5.setOnDragListener(new b(this.f58016e));
            RFWDragLayout rFWDragLayout6 = this.f58016e.mDragLayout;
            if (rFWDragLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout6 = null;
            }
            rFWDragLayout6.setDragInterceptDelegate(new RFWDragLayout.DragInterceptDelegate() { // from class: com.qzone.reborn.layer.part.bx
                @Override // com.tencent.richframework.widget.drag.RFWDragLayout.DragInterceptDelegate
                public final boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
                    boolean b16;
                    b16 = bw.c.b(motionEvent, f16, f17);
                    return b16;
                }
            });
            RFWLayerInitBean rFWLayerInitBean = this.f58016e.mInitBean;
            if (rFWLayerInitBean == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
                rFWLayerInitBean = null;
            }
            boolean z16 = false;
            if (rFWLayerInitBean.getTransitionBean() != null) {
                if (this.f58016e.mCurrentPicView == null) {
                    bw bwVar2 = this.f58016e;
                    bwVar2.mCurrentPicView = bwVar2.getCurrentImageView(0);
                }
                if (this.f58016e.mCurrentPicView == null || this.f58016e.mPicLoader == null) {
                    this.f58016e.resetVisibleAndBg();
                    return true;
                }
                ImageView imageView = this.f58016e.mTempImageView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTempImageView");
                    imageView = null;
                }
                ImageView imageView2 = this.f58016e.mCurrentPicView;
                Intrinsics.checkNotNull(imageView2);
                imageView.setScaleType(imageView2.getScaleType());
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.f58016e.mEnterMediaInfo;
                if (rFWLayerItemMediaInfo != null) {
                    UUID uuid2 = this.f58016e.mTranUUID;
                    if (uuid2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                        uuid2 = null;
                    }
                    if (RFWLayerLaunchUtil.isEnterDrawableHasCut(uuid2, rFWLayerItemMediaInfo)) {
                        z16 = true;
                    }
                }
                if (!z16 || !RFWNetworkUtils.isNetworkAvailable(this.f58016e.getActivity())) {
                    ImageView imageView3 = this.f58016e.mTempImageView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTempImageView");
                        imageView3 = null;
                    }
                    TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
                    UUID uuid3 = this.f58016e.mTranUUID;
                    if (uuid3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                    } else {
                        uuid = uuid3;
                    }
                    imageView3.setImageDrawable(transitionAnimUtil.getTransViewAndDrawable(uuid).getCoverDrawable());
                    this.f58016e.initAndStartAnim();
                } else {
                    this.f58016e.la();
                }
                return true;
            }
            RFWLog.e("RFWTransitionAnimPart", RFWLog.USR, "bean is null");
            this.f58016e.resetVisibleAndBg();
            return true;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/layer/part/bw$c$b", "Lcom/tencent/richframework/widget/drag/RFWDragLayout$OnDragListener;", "", "onStartDrag", "", "factor", "onDragging", "", "isDragToClose", "onEndDrag", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes37.dex */
        public static final class b implements RFWDragLayout.OnDragListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ bw f58018a;

            b(bw bwVar) {
                this.f58018a = bwVar;
            }

            @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
            public void onStartDrag() {
                this.f58018a.updateCurrentPicView(true);
                this.f58018a.ga();
                this.f58018a.changeIgnoreViewAlpha(0.0f);
            }

            @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
            public void onEndDrag(boolean isDragToClose) {
                if (isDragToClose) {
                    if (this.f58018a.canShowExitAnim()) {
                        this.f58018a.showExitAnim(false);
                    } else {
                        this.f58018a.finishActivity();
                    }
                    if (this.f58018a.mOperationListener != null) {
                        ILayerOperationListener iLayerOperationListener = this.f58018a.mOperationListener;
                        Intrinsics.checkNotNull(iLayerOperationListener);
                        iLayerOperationListener.onDragClose();
                        return;
                    }
                    return;
                }
                this.f58018a.showIgnoreView();
                this.f58018a.updateBackgroundAlpha(255);
            }

            @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
            public void onDragging(float factor) {
                int i3 = (int) (factor * 1.0f * 255.0f);
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 > 255) {
                    i3 = 255;
                }
                this.f58018a.updateBackgroundAlpha(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowExitAnim() {
        if (this.mTransitionManager == null || this.mCurrentSelectedItem == null) {
            return false;
        }
        boolean isSameEnterAndExist = isSameEnterAndExist();
        if (isSameEnterAndExist) {
            TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
            UUID uuid = this.mTranUUID;
            if (uuid == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                uuid = null;
            }
            ImageView enterImageView = transitionAnimUtil.getTransViewAndDrawable(uuid).getEnterImageView();
            if (enterImageView != null) {
                UUID uuid2 = this.mTranUUID;
                if (uuid2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                    uuid2 = null;
                }
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                this.mAnimBean = RFWLayerLaunchUtil.getTransAnimBean(uuid2, enterImageView, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getLayerPicInfo() : null, true);
            }
            if (this.mAnimBean != null) {
                updateEnterRect(this.mAnimBean);
            }
        }
        if (this.mAnimBean == null) {
            return false;
        }
        RFWTransAnimBean rFWTransAnimBean = this.mAnimBean;
        Intrinsics.checkNotNull(rFWTransAnimBean);
        if (rFWTransAnimBean.getIsBackTransition()) {
            return getAnimCreator() != null || isSameEnterAndExist;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeIgnoreViewAlpha(float alpha) {
        Iterator<View> it = this.mHideViews.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishActivity() {
        if (getActivity() != null) {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "finishActivity");
            na(true);
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        ea(this.mRecyclerView);
        Iterator<View> it = this.mHideViews.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(4);
        }
    }

    private final RFWTransitionHelper.TransAnimCreator getAnimCreator() {
        RFWLayerInitBean rFWLayerInitBean = this.mInitBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            rFWLayerInitBean = null;
        }
        int mTransAnimBeanCreatorId = rFWLayerInitBean.getMTransAnimBeanCreatorId();
        if (mTransAnimBeanCreatorId != 0) {
            return RFWTransitionHelper.INSTANCE.getTransitionBeanCreator(mTransAnimBeanCreatorId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getCurrentImageView(int position) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.mRecyclerView;
        View findViewByPosition = (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) ? null : layoutManager.findViewByPosition(position);
        RFWLog.i("RFWLayerPagePart", RFWLog.USR, "currentPos:" + position + "itemView:" + findViewByPosition);
        ImageView imageView = findViewByPosition != null ? (ImageView) findViewByPosition.findViewById(R.id.nee) : null;
        if (imageView == null) {
            return findViewByPosition != null ? (ImageView) findViewByPosition.findViewById(R.id.f74033v6) : null;
        }
        return imageView;
    }

    private final RectF getCurrentPicViewRect(ImageView imageView) {
        return new RectF(RFWImageUtil.getImageVisibleRect(imageView, imageView.getScaleType()));
    }

    private final int getRealScreenHeight() {
        boolean isInMultiWindowMode;
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(getContext()) + DisplayUtil.getTopHeight(getContext());
        if (getActivity() == null || Build.VERSION.SDK_INT < 24) {
            return instantScreenHeight;
        }
        isInMultiWindowMode = getActivity().isInMultiWindowMode();
        return isInMultiWindowMode ? instantScreenHeight - DisplayUtil.getTopHeight(getContext()) : instantScreenHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ha() {
        RecyclerView recyclerView = this.mRecyclerView;
        boolean z16 = false;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getLayoutManager() != null) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                Intrinsics.checkNotNull(recyclerView2);
                SafeLinearLayoutManager safeLinearLayoutManager = (SafeLinearLayoutManager) recyclerView2.getLayoutManager();
                if (safeLinearLayoutManager != null && safeLinearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    z16 = true;
                }
                return !z16;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(final bw this$0, RFWTransitionHelper.TransAnimCreator creator, RFWLayerPicInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(creator, "$creator");
        Intrinsics.checkNotNullParameter(it, "$it");
        UUID uuid = this$0.mTranUUID;
        if (uuid == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
            uuid = null;
        }
        String picId = it.getPicId();
        Intrinsics.checkNotNull(picId);
        this$0.mAnimBean = creator.generateTransAnimBean(uuid, picId);
        this$0.getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.bv
            @Override // java.lang.Runnable
            public final void run() {
                bw.ja(bw.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initAndStartAnim() {
        if (!this.mHasInit) {
            ImageView imageView = this.mTempImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageView");
                imageView = null;
            }
            initDragFrameLayout(imageView);
            this.mHasInit = true;
        }
        TransitionManager transitionManager = this.mTransitionManager;
        if (transitionManager == null) {
            resetVisibleAndBg();
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "not show anim");
        } else if (transitionManager != null) {
            transitionManager.startEnterAnim(new b());
        }
    }

    private final void initDragFrameLayout(ImageView imageView) {
        RFWLayerInitBean rFWLayerInitBean = this.mInitBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            rFWLayerInitBean = null;
        }
        this.mAnimBean = rFWLayerInitBean.getTransitionBean();
        if (this.mAnimBean == null) {
            RFWLog.w(getTAG(), RFWLog.USR, "initDragFrameLayout mAnimBean == null, no open anim");
        } else {
            this.mTransitionManager = new TransitionManager();
            initStartAnim(imageView);
        }
    }

    private final void initStartAnim(ImageView imageView) {
        int measuredWidth;
        int measuredHeight;
        if (this.mAnimBean != null) {
            if (this.mTranUUID == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
            }
            TransitionInitData transitionInitData = new TransitionInitData();
            TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
            UUID uuid = this.mTranUUID;
            FrameLayout frameLayout = null;
            if (uuid == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                uuid = null;
            }
            transitionInitData.setCoverDrawable(transitionAnimUtil.getTransViewAndDrawable(uuid).getCoverDrawable());
            RFWTransAnimBean rFWTransAnimBean = this.mAnimBean;
            if (rFWTransAnimBean != null) {
                transitionInitData.setLayoutStartRect(new RectF(rFWTransAnimBean.getLayoutRect().getLeft(), rFWTransAnimBean.getLayoutRect().getTop(), rFWTransAnimBean.getLayoutRect().getRight(), rFWTransAnimBean.getLayoutRect().getBottom()));
                if (rFWTransAnimBean.getImageRect() != null) {
                    transitionInitData.setImageStartRect(new RectF(r2.getLeft(), r2.getTop(), r2.getRight(), r2.getBottom()));
                }
                transitionInitData.setImageEndRect(getCurrentPicViewRect(imageView));
                transitionInitData.setFadeCoverTimeMs(rFWTransAnimBean.getFadeCoverTimeMs());
                transitionInitData.setTransitionDelayTimeMs(rFWTransAnimBean.getTransitionDelayTimeMs());
                transitionInitData.setTransitionAniDurationMs(rFWTransAnimBean.getTransitionDuration());
                transitionInitData.setStartScaleType(rFWTransAnimBean.getScaleType());
                transitionInitData.setBackgroundColor(-16777216);
                FrameLayout frameLayout2 = this.mAnimRootLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
                    frameLayout2 = null;
                }
                if (frameLayout2.getMeasuredWidth() == 0) {
                    measuredWidth = DisplayUtil.getInstantScreenWidth(getContext());
                } else {
                    RFWDragLayout rFWDragLayout = this.mDragLayout;
                    if (rFWDragLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                        rFWDragLayout = null;
                    }
                    measuredWidth = rFWDragLayout.getMeasuredWidth();
                }
                FrameLayout frameLayout3 = this.mAnimRootLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
                    frameLayout3 = null;
                }
                if (frameLayout3.getMeasuredHeight() == 0) {
                    measuredHeight = getRealScreenHeight();
                } else {
                    FrameLayout frameLayout4 = this.mAnimRootLayout;
                    if (frameLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
                        frameLayout4 = null;
                    }
                    measuredHeight = frameLayout4.getMeasuredHeight();
                }
                transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, measuredWidth, measuredHeight));
                TransitionManager transitionManager = this.mTransitionManager;
                if (transitionManager != null) {
                    FrameLayout frameLayout5 = this.mAnimRootLayout;
                    if (frameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
                    } else {
                        frameLayout = frameLayout5;
                    }
                    transitionManager.initCoverViewAndData(frameLayout, transitionInitData);
                    return;
                }
                return;
            }
            return;
        }
        RFWLog.e(getTAG(), RFWLog.USR, "initStartAnim params error");
    }

    private final boolean isSameEnterAndExist() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            if (Intrinsics.areEqual(this.mEnterMediaId, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(bw this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mAnimBean == null) {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "can't find mAnimBean");
        } else {
            this$0.na(false);
            this$0.updateEnterRect(this$0.mAnimBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        RFWLayerInitBean rFWLayerInitBean = this.mInitBean;
        ImageView imageView = null;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            rFWLayerInitBean = null;
        }
        RFWTransAnimBean transitionBean = rFWLayerInitBean.getTransitionBean();
        RFWLayerPicInfo.RFWPicInfo da5 = da(transitionBean != null ? transitionBean.getLayerPicInfo() : null);
        if (da5 != null && this.mCurrentPicView != null && this.mCurrentSelectedItem != null) {
            Option cacheKey = Option.obtain().setUrl(da5.getUrl()).setLocalPath(da5.getLocalPath()).setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(da5.getLocalPath())).build());
            ImageView imageView2 = this.mCurrentPicView;
            Intrinsics.checkNotNull(imageView2);
            Option requestWidth = cacheKey.setRequestWidth(imageView2.getWidth());
            ImageView imageView3 = this.mCurrentPicView;
            Intrinsics.checkNotNull(imageView3);
            Option requestHeight = requestWidth.setRequestHeight(imageView3.getHeight());
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            Option extraData = requestHeight.setExtraData(RFWLayerImageLoader.getExtraData(rFWLayerItemMediaInfo, RFWLayerPicInfo.PicType.LARGE));
            ImageView imageView4 = this.mTempImageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageView");
            } else {
                imageView = imageView4;
            }
            Option needShowLoadingDrawable = extraData.setTargetView(imageView).setNeedShowLoadingDrawable(false);
            needShowLoadingDrawable.disableHardwareDecode();
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setVisibility(4);
            }
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "start loadImage");
            IPicLoader iPicLoader = this.mPicLoader;
            if (iPicLoader != null) {
                iPicLoader.loadImage(needShowLoadingDrawable, new IPicLoadStateListener() { // from class: com.qzone.reborn.layer.part.bu
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        bw.ma(bw.this, loadState, option);
                    }
                });
                return;
            }
            return;
        }
        resetVisibleAndBg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(bw this$0, LoadState state, Option option1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option1, "option1");
        RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "loadImage1 seq:" + option1.getSeq() + " state:" + state);
        if (state.isFinishSuccess()) {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "startAnim");
            TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
            UUID uuid = this$0.mTranUUID;
            ImageView imageView = null;
            if (uuid == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTranUUID");
                uuid = null;
            }
            TransitionAnimUtil.TransViewAndDrawable transViewAndDrawable = transitionAnimUtil.getTransViewAndDrawable(uuid);
            ImageView imageView2 = this$0.mTempImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTempImageView");
            } else {
                imageView = imageView2;
            }
            transViewAndDrawable.saveCoverDrawable(imageView.getDrawable());
            this$0.initAndStartAnim();
            return;
        }
        if (state.isFinishError()) {
            RFWLog.i("RFWTransitionAnimPart", RFWLog.USR, "isFinishError");
            this$0.resetVisibleAndBg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(final boolean isShow) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.bt
            @Override // java.lang.Runnable
            public final void run() {
                bw.oa(isShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetVisibleAndBg() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        RFWDragLayout rFWDragLayout = this.mDragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
            rFWDragLayout = null;
        }
        rFWDragLayout.setWindowBgAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExitAnim(boolean needUpdateRect) {
        updateEnd(needUpdateRect);
        ga();
        RFWDragLayout rFWDragLayout = this.mDragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
            rFWDragLayout = null;
        }
        float scaleX = rFWDragLayout.getTargetDragView().getScaleX();
        TransitionManager transitionManager = this.mTransitionManager;
        if (transitionManager != null) {
            transitionManager.startExitAnim(new d(scaleX));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackgroundAlpha(int alpha) {
        Drawable background = getPartRootView().getBackground();
        if (background == null) {
            return;
        }
        background.setAlpha(alpha);
    }

    private final void updateEnd(boolean needUpdateRect) {
        TransitionInitData transitionInitData;
        updateCurrentPicView(needUpdateRect);
        if (this.mCurrentPicView == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "updateEnd: mCurrentPicView is null");
            return;
        }
        if (this.mTransitionManager == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "updateEnd: mTransitionManager is null");
            return;
        }
        RFWDragLayout rFWDragLayout = this.mDragLayout;
        RFWDragLayout rFWDragLayout2 = null;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
            rFWDragLayout = null;
        }
        float scaleX = rFWDragLayout.getScaleX();
        ImageView imageView = this.mCurrentPicView;
        Intrinsics.checkNotNull(imageView);
        imageView.getLocationInWindow(new int[2]);
        TransitionManager transitionManager = this.mTransitionManager;
        RectF rectF = new RectF((transitionManager == null || (transitionInitData = transitionManager.getTransitionInitData()) == null) ? null : transitionInitData.getImageEndRect());
        float f16 = 2;
        float width = (rectF.width() / f16) + rectF.left;
        float height = (rectF.height() / f16) + rectF.top;
        RectF rectF2 = new RectF(width - ((rectF.width() / f16) * scaleX), height - ((rectF.height() / f16) * scaleX), width + ((rectF.width() / f16) * scaleX), height + ((rectF.height() / f16) * scaleX));
        RFWDragLayout rFWDragLayout3 = this.mDragLayout;
        if (rFWDragLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
            rFWDragLayout3 = null;
        }
        float translationX = rFWDragLayout3.getTranslationX();
        RFWDragLayout rFWDragLayout4 = this.mDragLayout;
        if (rFWDragLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
        } else {
            rFWDragLayout2 = rFWDragLayout4;
        }
        rectF2.offset(translationX, rFWDragLayout2.getTranslationY());
        TransitionManager transitionManager2 = this.mTransitionManager;
        Intrinsics.checkNotNull(transitionManager2);
        transitionManager2.updateEndAnimRect(rectF2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWTransitionAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean onBackEvent = super.onBackEvent();
        if (!onBackEvent && canShowExitAnim()) {
            updateCurrentPicView(true);
            showExitAnim(true);
            return true;
        }
        if (this.mCurrentSelectedItem != null) {
            finishActivity();
        }
        return onBackEvent;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        UUID randomUUID;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) getPartHost().getHostActivity().getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        if (rFWLayerInitBean == null) {
            return;
        }
        this.mInitBean = rFWLayerInitBean;
        RFWTransAnimBean transitionBean = rFWLayerInitBean.getTransitionBean();
        if (transitionBean == null || (randomUUID = transitionBean.getUUid()) == null) {
            randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
        }
        this.mTranUUID = randomUUID;
        this.mPicLoader = RFWLayerIOCUtil.getPicLoaderFromView(rootView);
        this.mOperationListener = RFWLayerIOCUtil.getLayerOperationListener(rootView);
        RFWLayerInitBean rFWLayerInitBean2 = this.mInitBean;
        FrameLayout frameLayout = null;
        if (rFWLayerInitBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
            rFWLayerInitBean2 = null;
        }
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerInitBean2.getRichMediaDataList();
        if (richMediaDataList != null) {
            RFWLayerInitBean rFWLayerInitBean3 = this.mInitBean;
            if (rFWLayerInitBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
                rFWLayerInitBean3 = null;
            }
            rFWLayerItemMediaInfo = richMediaDataList.get(rFWLayerInitBean3.getEnterPos());
        } else {
            rFWLayerItemMediaInfo = null;
        }
        this.mEnterMediaInfo = rFWLayerItemMediaInfo;
        this.mEnterMediaId = rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null;
        ViewGroup viewGroup = (ViewGroup) rootView;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169067hn4, viewGroup, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout2 = (FrameLayout) inflate;
        this.mAnimRootLayout = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
            frameLayout2 = null;
        }
        View findViewById = frameLayout2.findViewById(R.id.y9r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mAnimRootLayout.findView\u2026.transition.R.id.iv_temp)");
        this.mTempImageView = (ImageView) findViewById;
        FrameLayout frameLayout3 = this.mAnimRootLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
        } else {
            frameLayout = frameLayout3;
        }
        viewGroup.addView(frameLayout);
        rootView.getViewTreeObserver().addOnPreDrawListener(new c(rootView, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentPicView(boolean needUpdateRect) {
        TransitionManager transitionManager;
        ImageView currentImageView = getCurrentImageView(0);
        this.mCurrentPicView = currentImageView;
        if (currentImageView != null && (transitionManager = this.mTransitionManager) != null) {
            Intrinsics.checkNotNull(transitionManager);
            ImageView imageView = this.mCurrentPicView;
            Intrinsics.checkNotNull(imageView);
            transitionManager.setCoverDrawable(imageView.getDrawable());
            if (needUpdateRect) {
                Rect rect = new Rect();
                ImageView imageView2 = this.mCurrentPicView;
                Intrinsics.checkNotNull(imageView2);
                imageView2.getGlobalVisibleRect(rect);
                ImageView imageView3 = this.mCurrentPicView;
                Intrinsics.checkNotNull(imageView3);
                RectF rectF = new RectF(RFWImageUtil.getImageVisibleRect(imageView3, imageView3.getScaleType()));
                TransitionManager transitionManager2 = this.mTransitionManager;
                Intrinsics.checkNotNull(transitionManager2);
                transitionManager2.updateEndAnimRect(rectF);
                return;
            }
            return;
        }
        RFWLog.e("RFWTransitionAnimPart", RFWLog.USR, "updateCurrentPicView but current picView is null");
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, androidx.lifecycle.Observer
    public void onChanged(UIStateData<RFWLayerState> uiStateData) {
        final RFWTransitionHelper.TransAnimCreator animCreator;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.onChanged(uiStateData);
        if (uiStateData.getLatestModifyRecord() != null && uiStateData.getLatestModifyRecord().getModifyType() == 4 && this.mIsAfterPreDraw) {
            RecyclerView recyclerView = this.mRecyclerView;
            if ((recyclerView != null && recyclerView.getVisibility() == 0) && (animCreator = getAnimCreator()) != null) {
                RFWLayerItemMediaInfo selectedItemMedia = uiStateData.getData().getSelectedItemMedia();
                RFWDragLayout rFWDragLayout = null;
                if (selectedItemMedia == null) {
                    this.mAnimBean = null;
                    RFWDragLayout rFWDragLayout2 = this.mDragLayout;
                    if (rFWDragLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                    } else {
                        rFWDragLayout = rFWDragLayout2;
                    }
                    rFWDragLayout.setFeatureEnable(false);
                    return;
                }
                RFWDragLayout rFWDragLayout3 = this.mDragLayout;
                if (rFWDragLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                    rFWDragLayout3 = null;
                }
                rFWDragLayout3.setFeatureEnable(true);
                final RFWLayerPicInfo layerPicInfo = selectedItemMedia.getLayerPicInfo();
                if (layerPicInfo != null) {
                    this.mAnimBean = null;
                    na(true);
                    if (TextUtils.isEmpty(layerPicInfo.getPicId())) {
                        return;
                    }
                    RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.layer.part.bs
                        @Override // java.lang.Runnable
                        public final void run() {
                            bw.ia(bw.this, animCreator, layerPicInfo);
                        }
                    });
                }
            }
        }
    }

    private final RFWLayerPicInfo.RFWPicInfo da(RFWLayerPicInfo picInfo) {
        if (picInfo != null) {
            return picInfo.getCurrentPicInfo();
        }
        return null;
    }

    private final void ea(View targetView) {
        if (targetView == null || !(targetView.getParent() instanceof ViewGroup) || targetView == getPartRootView()) {
            return;
        }
        ViewParent parent = targetView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childView = viewGroup.getChildAt(i3);
            if (childView != targetView) {
                FrameLayout frameLayout = this.mAnimRootLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAnimRootLayout");
                    frameLayout = null;
                }
                if (childView != frameLayout && childView.getVisibility() == 0) {
                    List<View> list = this.mHideViews;
                    Intrinsics.checkNotNullExpressionValue(childView, "childView");
                    list.add(childView);
                }
            }
        }
        if (targetView.getParent() instanceof View) {
            Object parent2 = targetView.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            ea((View) parent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showIgnoreView() {
        changeIgnoreViewAlpha(1.0f);
    }

    private final void updateEnterRect(RFWTransAnimBean animBean) {
        RFWTransAnimBean.SourceRect imageRect;
        if (animBean == null || this.mTransitionManager == null || (imageRect = animBean.getImageRect()) == null) {
            return;
        }
        RectF rectF = new RectF(imageRect.getLeft(), imageRect.getTop(), imageRect.getRight(), imageRect.getBottom());
        TransitionManager transitionManager = this.mTransitionManager;
        if (transitionManager != null) {
            transitionManager.updateStartAnimRect(rectF, rectF, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/layer/part/bw$d", "Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "", "value", "onAnimaUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements TransitionAnimator.OnAnimCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f58020b;

        d(float f16) {
            this.f58020b = f16;
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationEnd() {
            bw.this.finishActivity();
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationStart() {
            bw.this.getMLayerViewModel().mRichMediaInfo.removeObservers(bw.this.getPartHost().getLifecycleOwner());
            RecyclerView recyclerView = bw.this.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(4);
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimaUpdate(float value) {
            if (value <= 0.01f) {
                bw.this.na(true);
            }
            RFWDragLayout rFWDragLayout = bw.this.mDragLayout;
            if (rFWDragLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragLayout");
                rFWDragLayout = null;
            }
            rFWDragLayout.setWindowBgAlpha(this.f58020b * value);
        }

        @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
        public void onAnimationCancel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(boolean z16) {
    }
}

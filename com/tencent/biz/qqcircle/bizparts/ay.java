package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSEnablePicScaleEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentSheetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\f*\u0004NRVZ\u0018\u0000 c2\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00103R\u0018\u0010>\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00100R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010HR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010HR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020A8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/ay;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "enable", "", "R9", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "updateListener", "U9", "T9", "S9", "W9", "", "ea", "showOnly", "Y9", "V9", "aa", "ca", "Landroid/view/View;", "targetView", "", "ignoreViews", "ba", "da", "target", "Z9", NodeProps.VISIBLE, "X9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "", "getLogTag", "getInitRelyViewStubId", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartPause", "", "d", "Ljava/util/List;", "mHideViews", "Lcom/tencent/biz/qqcircle/utils/QFSCommentSheetView;", "e", "Lcom/tencent/biz/qqcircle/utils/QFSCommentSheetView;", "mHalfScreenView", "f", "Landroid/view/View;", "mPanelRootView", tl.h.F, "I", "mNormalPaddingBottom", "i", "mLayoutHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mLayoutWidth", BdhLogUtil.LogTag.Tag_Conn, "mTargetViewHeight", "D", "mTargetViewWidth", "E", "mTargetView", UserInfo.SEX_FEMALE, "mTopMargin", "", "G", "J", "mContentHeight", "H", "mContentStartY", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mShowAnimator", "mDismissAnimator", "K", "Z", "mEnableSlide", "com/tencent/biz/qqcircle/bizparts/ay$b", "L", "Lcom/tencent/biz/qqcircle/bizparts/ay$b;", "eventReceiver", "com/tencent/biz/qqcircle/bizparts/ay$f", "M", "Lcom/tencent/biz/qqcircle/bizparts/ay$f;", "onHalfScreenShowListener", "com/tencent/biz/qqcircle/bizparts/ay$g", "N", "Lcom/tencent/biz/qqcircle/bizparts/ay$g;", "onTopUpdateListener", "com/tencent/biz/qqcircle/bizparts/ay$e", "P", "Lcom/tencent/biz/qqcircle/bizparts/ay$e;", "onDismissListener", "Q9", "()J", "scaleTopViewHeight", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ay extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: C, reason: from kotlin metadata */
    private int mTargetViewHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTargetViewWidth;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mTargetView;

    /* renamed from: F, reason: from kotlin metadata */
    private int mTopMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private long mContentHeight;

    /* renamed from: H, reason: from kotlin metadata */
    private long mContentStartY;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ValueAnimator mShowAnimator;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ValueAnimator mDismissAnimator;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mEnableSlide;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b eventReceiver;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final f onHalfScreenShowListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final g onTopUpdateListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e onDismissListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<View> mHideViews = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSCommentSheetView mHalfScreenView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mPanelRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mNormalPaddingBottom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLayoutHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mLayoutWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J(\u0010\t\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007`\bH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$b", "Lcom/tencent/biz/qqcircle/utils/cr;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qqcircle.utils.cr {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSEnablePicScaleEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof QFSEnablePicScaleEvent) {
                ay.this.R9(((QFSEnablePicScaleEvent) event).getEnable());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Iterator it = ay.this.mHideViews.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ay.this.V9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$e", "Lcom/tencent/biz/qqcircle/utils/QFSCommentSheetView$i;", "", "onDismiss", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements QFSCommentSheetView.i {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.i
        public void onDismiss() {
            QLog.d(ay.this.getTAG(), 1, "dismiss ani part" + hashCode());
            ay.this.X9(true);
            ay.this.Y9(false);
            ay.this.W9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$g", "Lcom/tencent/biz/qqcircle/utils/QFSCommentSheetView$h;", "", "yOffset", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class g implements QFSCommentSheetView.h {
        g() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.h
        public void a(float yOffset) {
            float f16;
            FrameLayout.LayoutParams layoutParams;
            if (ay.this.mEnableSlide) {
                View view = ay.this.mTargetView;
                ay ayVar = ay.this;
                if (view == null) {
                    QLog.e(ayVar.getTAG(), 1, "targetView = null");
                }
                if (view != null) {
                    QFSCommentSheetView qFSCommentSheetView = ay.this.mHalfScreenView;
                    if (qFSCommentSheetView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                        qFSCommentSheetView = null;
                    }
                    if (qFSCommentSheetView.getVisibility() != 8 && view.getLayoutParams() != null) {
                        if (!ay.this.S9()) {
                            QFSCommentSheetView qFSCommentSheetView2 = ay.this.mHalfScreenView;
                            if (qFSCommentSheetView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                                qFSCommentSheetView2 = null;
                            }
                            if (qFSCommentSheetView2.n() != 0) {
                                QFSCommentSheetView qFSCommentSheetView3 = ay.this.mHalfScreenView;
                                if (qFSCommentSheetView3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                                    qFSCommentSheetView3 = null;
                                }
                                float n3 = qFSCommentSheetView3.n() - yOffset;
                                QFSCommentSheetView qFSCommentSheetView4 = ay.this.mHalfScreenView;
                                if (qFSCommentSheetView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                                    qFSCommentSheetView4 = null;
                                }
                                float r16 = n3 / qFSCommentSheetView4.r();
                                QFSCommentSheetView qFSCommentSheetView5 = ay.this.mHalfScreenView;
                                if (qFSCommentSheetView5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                                    qFSCommentSheetView5 = null;
                                }
                                float s16 = qFSCommentSheetView5.s() / ((float) ay.this.Q9());
                                if (s16 > 1.0f) {
                                    QFSCommentSheetView qFSCommentSheetView6 = ay.this.mHalfScreenView;
                                    if (qFSCommentSheetView6 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                                        qFSCommentSheetView6 = null;
                                    }
                                    f16 = qFSCommentSheetView6.s() - ((float) ay.this.Q9());
                                    s16 = 1.0f;
                                } else {
                                    f16 = 0.0f;
                                }
                                float f17 = 1;
                                float f18 = f17 - ((f17 - s16) * r16);
                                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                    layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                                } else {
                                    layoutParams = null;
                                }
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(ay.this.getContext(), (AttributeSet) null);
                                }
                                layoutParams.height = (int) (ay.this.mTargetViewHeight * f18);
                                layoutParams.width = (int) (ay.this.mTargetViewWidth * f18);
                                int i3 = (int) (((ay.this.mTopMargin * (f17 - r16)) + f16) - ((((float) ay.this.mContentStartY) * r16) * s16));
                                if (i3 > ay.this.mTopMargin) {
                                    i3 = ay.this.mTopMargin;
                                }
                                layoutParams.topMargin = i3;
                                layoutParams.gravity = 49;
                                view.setLayoutParams(layoutParams);
                                QLog.d(ay.this.getTAG(), 4, "[onTopUpdate] y: " + yOffset + ", height: " + layoutParams.height + ", width: " + layoutParams.width + ", topMargin: " + layoutParams.topMargin + ", currentScrollY: " + n3 + ", currentScrollScale: " + r16);
                                return;
                            }
                            QLog.d(ay.this.getTAG(), 1, "[onTopUpdate] mHalfScreenView seems not layout");
                            return;
                        }
                        QLog.d(ay.this.getTAG(), 1, "hasHappenConfigChange = true");
                        if (com.tencent.biz.qqcircle.utils.bz.k()) {
                            ay.this.W9();
                        }
                        QFSCommentSheetView qFSCommentSheetView7 = ay.this.mHalfScreenView;
                        if (qFSCommentSheetView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                            qFSCommentSheetView7 = null;
                        }
                        qFSCommentSheetView7.setTag(null);
                        ay.this.mEnableSlide = false;
                        return;
                    }
                    QLog.e(ay.this.getTAG(), 1, "slideView is gone, still receive onScrollChange or mTopLinkView is null");
                    return;
                }
                return;
            }
            QLog.e(ay.this.getTAG(), 1, "onScrollChanged mEnable = false");
        }
    }

    public ay() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(0f, 1f).setDurat\u2026N_DURATION.toLong()\n    )");
        this.mShowAnimator = duration;
        ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(1f, 0f).setDurat\u2026N_DURATION.toLong()\n    )");
        this.mDismissAnimator = duration2;
        this.eventReceiver = new b();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.bizparts.ax
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ay.z9(ay.this, valueAnimator);
            }
        };
        U9(animatorUpdateListener);
        T9(animatorUpdateListener);
        this.onHalfScreenShowListener = new f();
        this.onTopUpdateListener = new g();
        this.onDismissListener = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long Q9() {
        long j3 = this.mContentHeight;
        if (j3 == 0) {
            return this.mTargetViewHeight;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(boolean enable) {
        QLog.d(getTAG(), 1, "handlePicScaleEvent " + enable);
        QFSCommentSheetView qFSCommentSheetView = null;
        if (enable) {
            QFSCommentSheetView qFSCommentSheetView2 = this.mHalfScreenView;
            if (qFSCommentSheetView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                qFSCommentSheetView2 = null;
            }
            qFSCommentSheetView2.d(this.onHalfScreenShowListener);
            QFSCommentSheetView qFSCommentSheetView3 = this.mHalfScreenView;
            if (qFSCommentSheetView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
                qFSCommentSheetView3 = null;
            }
            qFSCommentSheetView3.e(this.onTopUpdateListener);
            QFSCommentSheetView qFSCommentSheetView4 = this.mHalfScreenView;
            if (qFSCommentSheetView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            } else {
                qFSCommentSheetView = qFSCommentSheetView4;
            }
            qFSCommentSheetView.c(this.onDismissListener);
            return;
        }
        QFSCommentSheetView qFSCommentSheetView5 = this.mHalfScreenView;
        if (qFSCommentSheetView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qFSCommentSheetView5 = null;
        }
        qFSCommentSheetView5.B(this.onHalfScreenShowListener);
        QFSCommentSheetView qFSCommentSheetView6 = this.mHalfScreenView;
        if (qFSCommentSheetView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qFSCommentSheetView6 = null;
        }
        qFSCommentSheetView6.C(this.onTopUpdateListener);
        QFSCommentSheetView qFSCommentSheetView7 = this.mHalfScreenView;
        if (qFSCommentSheetView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
        } else {
            qFSCommentSheetView = qFSCommentSheetView7;
        }
        qFSCommentSheetView.A(this.onDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S9() {
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        Boolean bool = null;
        if (qFSCommentSheetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qFSCommentSheetView = null;
        }
        Object tag = qFSCommentSheetView.getTag();
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        }
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    private final void T9(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.mDismissAnimator.addListener(new c());
        this.mDismissAnimator.addUpdateListener(updateListener);
    }

    private final void U9(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.mShowAnimator.addListener(new d());
        this.mShowAnimator.addUpdateListener(updateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        Iterator<View> it = this.mHideViews.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
        com.tencent.biz.qqcircle.immersive.utils.r.Z0(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        if (!this.mEnableSlide) {
            QLog.e(getTAG(), 1, "restoreViews mEnable = false");
            return;
        }
        this.mEnableSlide = false;
        View view = this.mTargetView;
        if (view == null) {
            QLog.e(getTAG(), 1, "restoreViews mTargetView == null");
            return;
        }
        int ea5 = ea();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mLayoutWidth, this.mLayoutHeight);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = ea5;
        view.setLayoutParams(layoutParams);
        QLog.d(getTAG(), 1, " restoreViews mLayoutWidth=" + this.mLayoutWidth + ", mLayoutHeight=" + this.mLayoutHeight, ", layoutParams.topMargin=", Integer.valueOf(layoutParams.topMargin), ", videoView:", view.hashCode() + ", bottomMargin:" + ea5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(boolean visible) {
        int i3;
        if (QCirclePluginUtil.isInLocalActivity(getActivity())) {
            View view = this.mPanelRootView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
                view = null;
            }
            View view3 = this.mPanelRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
                view3 = null;
            }
            int paddingLeft = view3.getPaddingLeft();
            View view4 = this.mPanelRootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
                view4 = null;
            }
            int paddingTop = view4.getPaddingTop();
            View view5 = this.mPanelRootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
            } else {
                view2 = view5;
            }
            int paddingRight = view2.getPaddingRight();
            if (visible) {
                i3 = this.mNormalPaddingBottom;
            } else {
                i3 = 0;
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(boolean showOnly) {
        List<? extends View> mutableListOf;
        View findViewById = getPartRootView().findViewById(R.id.f43991nz);
        View[] viewArr = new View[1];
        View view = this.mPanelRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
            view = null;
        }
        viewArr[0] = view;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(viewArr);
        this.mTargetView = findViewById;
        if (showOnly) {
            if (findViewById != null) {
                this.mEnableSlide = true;
                ba(findViewById, mutableListOf);
            } else {
                QLog.e(getTAG(), 1, "no qfs_image_banner found");
            }
            aa();
            return;
        }
        ca();
    }

    private final void Z9(View target, List<? extends View> ignoreViews) {
        boolean contains;
        this.mHideViews.clear();
        List<View> list = this.mHideViews;
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        list.addAll(com.tencent.biz.qqcircle.utils.cp.a(target, ignoreViews, rootView));
        String tag = getTAG();
        contains = CollectionsKt___CollectionsKt.contains(this.mHideViews, this.mTargetView);
        QLog.d(tag, 1, "hidden views contains mTargetView: " + contains);
    }

    private final void aa() {
        if (this.mShowAnimator.isRunning()) {
            this.mShowAnimator.cancel();
        }
        this.mDismissAnimator.start();
    }

    private final void ba(View targetView, List<? extends View> ignoreViews) {
        int[] iArr = new int[2];
        targetView.getLocationInWindow(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            QLog.e(getTAG(), 1, "showTargetViewOnly but view isn't in window");
        } else {
            da(targetView);
            Z9(targetView, ignoreViews);
        }
    }

    private final void ca() {
        if (this.mDismissAnimator.isRunning()) {
            this.mDismissAnimator.cancel();
        }
        this.mShowAnimator.start();
    }

    private final void da(View targetView) {
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        this.mLayoutWidth = layoutParams.width;
        this.mLayoutHeight = layoutParams.height;
        this.mTopMargin = targetView.getTop();
        this.mTargetViewWidth = targetView.getWidth();
        this.mTargetViewHeight = targetView.getHeight();
        this.mContentHeight = 0L;
        this.mContentStartY = 0L;
    }

    private final int ea() {
        ViewGroup viewGroup;
        View view = this.mTargetView;
        if (view == null || !com.tencent.biz.qqcircle.utils.bz.k()) {
            return 0;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return 0;
        }
        return (int) (((viewGroup.getHeight() / 2) - (((viewGroup.getHeight() + r1) * 0.88f) / 1.88f)) + DisplayUtil.getTopHeight(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(ay this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (!(animation.getAnimatedValue() instanceof Float)) {
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Iterator<View> it = this$0.mHideViews.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.u2_;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentScaleLayerAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.u28);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.comment_panel_view)");
        this.mPanelRootView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelRootView");
            findViewById = null;
        }
        this.mNormalPaddingBottom = findViewById.getPaddingBottom();
        View findViewById2 = rootView.findViewById(R.id.f47571xn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026comment_half_screen_view)");
        this.mHalfScreenView = (QFSCommentSheetView) findViewById2;
        R9(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/bizparts/ay$f", "Lcom/tencent/biz/qqcircle/utils/QFSCommentSheetView$k;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "", "newState", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f implements QFSCommentSheetView.k {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefaultStart() {
            QLog.d(ay.this.getTAG(), 1, "show ani part" + hashCode());
            ay.this.X9(false);
            if (!ay.this.mEnableSlide) {
                ay.this.Y9(true);
            } else {
                QLog.d(ay.this.getTAG(), 1, "onShow return: isEnableSlide: true");
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotalStart() {
            QLog.d(ay.this.getTAG(), 1, "show ani part" + hashCode());
            ay.this.X9(false);
            if (!ay.this.mEnableSlide) {
                ay.this.Y9(true);
            } else {
                QLog.d(ay.this.getTAG(), 1, "onShow return: isEnableSlide: true");
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefault() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotal() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onStateChange(int newState) {
        }
    }
}

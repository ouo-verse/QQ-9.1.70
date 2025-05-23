package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.animation.transition.TransitionInitData;
import com.tencent.biz.richframework.animation.transition.TransitionManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/af;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "C9", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "bean", "Lcom/tencent/biz/richframework/animation/transition/TransitionInitData;", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "isPartEnable", "d", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "e", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "animBean", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager;", "f", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager;", "transitionMgr", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "rootFrameLayout", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "contentRootLayout", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class af extends com.tencent.biz.qqcircle.immersive.part.u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isLandscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSTransitionAnimBean animBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TransitionManager transitionMgr = new TransitionManager();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout rootFrameLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup contentRootLayout;

    public af(@Nullable QCircleInitBean qCircleInitBean, boolean z16) {
        this.isLandscape = z16;
        if (qCircleInitBean instanceof QCircleCommentPicLayerBean) {
            this.animBean = ((QCircleCommentPicLayerBean) qCircleInitBean).getTransitionAnimBean();
        }
    }

    private final TransitionInitData B9(QFSTransitionAnimBean bean) {
        TransitionInitData transitionInitData = new TransitionInitData();
        transitionInitData.setCoverDrawable(TransitionAnimUtil.getCoverDrawable());
        transitionInitData.setLayoutStartRect(new RectF(bean.getLayoutRect().getLeft(), bean.getLayoutRect().getTop(), bean.getLayoutRect().getRight(), bean.getLayoutRect().getBottom()));
        if (bean.getImageRect() != null) {
            transitionInitData.setImageStartRect(new RectF(r1.getLeft(), r1.getTop(), r1.getRight(), r1.getBottom()));
        }
        transitionInitData.setEnterAnimFadeCoverTimeMs(bean.getEnterAnimFadeCoverTimeMs());
        transitionInitData.setExitAnimFadeCoverTimeMs(bean.getExitAnimFadeCoverTimeMs());
        transitionInitData.setTransitionDelayTimeMs(bean.getTransitionDelayTimeMs());
        transitionInitData.setTransitionAniDurationMs(bean.getTransitionDurationMs());
        transitionInitData.setStartScaleType(ImageView.ScaleType.FIT_CENTER);
        transitionInitData.setEndScaleType(ImageView.ScaleType.FIT_CENTER);
        int i3 = 0;
        transitionInitData.setBackgroundColor(0);
        float instantScreenWidth = DisplayUtil.getInstantScreenWidth(getContext());
        float instantScreenHeight = DisplayUtil.getInstantScreenHeight(getContext());
        transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, instantScreenWidth, instantScreenHeight));
        if (!this.isLandscape) {
            i3 = cx.a(56.0f);
        }
        transitionInitData.setImageEndRect(new RectF(0.0f, 0.0f, instantScreenWidth, instantScreenHeight - i3));
        return transitionInitData;
    }

    private final void C9() {
        Unit unit;
        QFSTransitionAnimBean qFSTransitionAnimBean = this.animBean;
        if (qFSTransitionAnimBean != null) {
            FrameLayout frameLayout = this.rootFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            ViewGroup viewGroup = this.contentRootLayout;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.transitionMgr.initCoverViewAndData(this.rootFrameLayout, B9(qFSTransitionAnimBean));
            this.transitionMgr.startEnterAnim(new a());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d("QFSCommentImageTransitionPart", 1, "[startTransition] no animBean");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (!QCircleDeviceInfoUtils.isLowDevice() && !bz.r()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        super.onInitView(rootView);
        ViewGroup viewGroup = null;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f356612g);
        } else {
            frameLayout = null;
        }
        this.rootFrameLayout = frameLayout;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f356512f);
        }
        this.contentRootLayout = viewGroup;
        if (!this.isLandscape) {
            C9();
        } else {
            TransitionAnimUtil.clearCacheDrawable();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/af$a", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager$OnAnimEndListener;", "", "onAnimEnd", "onAnimCancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements TransitionManager.OnAnimEndListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            QLog.d("QFSCommentImageTransitionPart", 1, "[startTransition] onAnimEnd");
            af.this.transitionMgr.dismissCoverView();
            int color = QCircleSkinHelper.getInstance().getColor(R.color.cje);
            FrameLayout frameLayout = af.this.rootFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(color);
            }
            ViewGroup viewGroup = af.this.contentRootLayout;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            VideoReport.traversePage(af.this.rootFrameLayout);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
        }
    }
}

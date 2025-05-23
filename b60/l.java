package b60;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleCommentPicLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPicInfo;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.animation.transition.TransitionInitData;
import com.tencent.biz.richframework.animation.transition.TransitionManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lb60/l;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "B9", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "bean", "Lcom/tencent/biz/richframework/animation/transition/TransitionInitData;", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "isPartEnable", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;", "initBean", "e", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "animBean", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager;", "f", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager;", "transitionMgr", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "rootFrameLayout", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "contentRootLayout", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleCommentPicLayerBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l extends u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QCircleCommentPicLayerBean initBean;

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

    public l(@Nullable QCircleCommentPicLayerBean qCircleCommentPicLayerBean) {
        QFSTransitionAnimBean qFSTransitionAnimBean;
        this.initBean = qCircleCommentPicLayerBean;
        if (qCircleCommentPicLayerBean != null) {
            qFSTransitionAnimBean = qCircleCommentPicLayerBean.getTransitionAnimBean();
        } else {
            qFSTransitionAnimBean = null;
        }
        this.animBean = qFSTransitionAnimBean;
    }

    private final TransitionInitData A9(QFSTransitionAnimBean bean) {
        List<QFSCommentPicInfo> commentPicInfoList;
        Object orNull;
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
        boolean z16 = false;
        transitionInitData.setBackgroundColor(0);
        float instantScreenWidth = DisplayUtil.getInstantScreenWidth(getContext());
        float instantScreenHeight = DisplayUtil.getInstantScreenHeight(getContext()) - DisplayUtil.getTopHeight(getContext());
        transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, instantScreenWidth, instantScreenHeight));
        QCircleCommentPicLayerBean qCircleCommentPicLayerBean = this.initBean;
        if (qCircleCommentPicLayerBean != null && (commentPicInfoList = qCircleCommentPicLayerBean.getCommentPicInfoList()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(commentPicInfoList, 0);
            QFSCommentPicInfo qFSCommentPicInfo = (QFSCommentPicInfo) orNull;
            if (qFSCommentPicInfo != null && qFSCommentPicInfo.isEmojiPic()) {
                z16 = true;
            }
        }
        if (z16) {
            float f16 = 2;
            float f17 = (instantScreenWidth * 1.0f) / f16;
            float a16 = (cx.a(240.0f) * 1.0f) / f16;
            float f18 = (instantScreenHeight * 1.0f) / f16;
            float a17 = cx.a(40.0f);
            transitionInitData.setImageEndRect(new RectF(f17 - a16, (f18 - a16) - a17, f17 + a16, (f18 + a16) - a17));
        } else {
            transitionInitData.setImageEndRect(new RectF(0.0f, 0.0f, instantScreenWidth, instantScreenHeight));
        }
        return transitionInitData;
    }

    private final void B9() {
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
            this.transitionMgr.initCoverViewAndData(this.rootFrameLayout, A9(qFSTransitionAnimBean));
            this.transitionMgr.startEnterAnim(new a(), true);
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
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f359713a);
        } else {
            frameLayout = null;
        }
        this.rootFrameLayout = frameLayout;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f359613_);
        }
        this.contentRootLayout = viewGroup;
        B9();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"b60/l$a", "Lcom/tencent/biz/richframework/animation/transition/TransitionManager$OnAnimEndListener;", "", "onAnimEnd", "onAnimCancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements TransitionManager.OnAnimEndListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            int color = QCircleSkinHelper.getInstance().getColor(R.color.cje);
            FrameLayout frameLayout = l.this.rootFrameLayout;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(color);
            }
            ViewGroup viewGroup = l.this.contentRootLayout;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
        }
    }
}

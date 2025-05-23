package com.tencent.mobileqq.zplan.avatar.impl.loading.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.avatar.impl.loading.view.ZPlanAvatarLoadingV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.loading.recorder.d;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import fi3.am;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oc4.a;
import t74.u;
import tl.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010*\u001a\u00020\rH\u0016R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00109R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00109R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/loading/view/ZPlanAvatarLoadingV2;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/d;", "", DomainData.DOMAIN_NAME, "v", "", "targetState", "w", h.F, "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "delay", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Landroid/animation/ObjectAnimator;", "l", "i", "pauseAnim", "resumeAnim", "destroy", "Landroid/view/ViewGroup;", "getView", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "listener", "setCloseListener", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "getCloseIcon", HippyTKDListViewAdapter.X, "Landroid/view/View$OnClickListener;", "setOnLoadingClickListener", "setSwitchState", "styleMode", "setStyleMode", "avatarRecorderType", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "res", "a", "p", "o", "Lfi3/am;", "d", "Lfi3/am;", "mBinding", "e", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "mCloseListener", "", "f", "Ljava/lang/String;", "mLoadingTextHint", "I", "mCurrentProgress", "", "Z", "mAvatarAreaIsShowing", "mRecordAvatarCanShow", BdhLogUtil.LogTag.Tag_Conn, "mState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarLoadingV2 extends FrameLayout implements ISceneLoadingView, d {

    /* renamed from: C, reason: from kotlin metadata */
    private int mState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final am mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ISceneLoadingView.b mCloseListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mLoadingTextHint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurrentProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mAvatarAreaIsShowing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mRecordAvatarCanShow;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/loading/view/ZPlanAvatarLoadingV2$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ZPlanAvatarLoadingV2.this.mBinding.f398847e.setAlpha(0.0f);
            ZPlanAvatarLoadingV2.this.mBinding.f398846d.setAlpha(0.0f);
            ZPlanAvatarLoadingV2.this.mBinding.f398858p.setAlpha(0.0f);
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/avatar/impl/loading/view/ZPlanAvatarLoadingV2$c", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements URLDrawableDownListener {
        c() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
            QLog.i("ZPlanAvatarLoadingV2", 1, "onLoadProgressed p2:" + p26);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View p06, URLDrawable p16) {
            QLog.i("ZPlanAvatarLoadingV2", 1, "onLoadSucceed");
            ZPlanAvatarLoadingV2.r(ZPlanAvatarLoadingV2.this, 0L, 1, null);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View p06, URLDrawable p16) {
            QLog.w("ZPlanAvatarLoadingV2", 1, "onLoadCancelled");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
            QLog.e("ZPlanAvatarLoadingV2", 1, "onLoadFailed", p26);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
            QLog.w("ZPlanAvatarLoadingV2", 1, "onLoadInterrupted");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarLoadingV2(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanAvatarLoadingV2 this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISceneLoadingView.b bVar = this$0.mCloseListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.onCloseClick(it);
        }
    }

    private final ObjectAnimator i() {
        float alpha = this.mBinding.f398853k.getAlpha();
        QLog.i("ZPlanAvatarLoadingV2", 1, "currentAlpha :" + alpha);
        ObjectAnimator anim = ObjectAnimator.ofFloat(this.mBinding.f398853k, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 0.0f);
        anim.setDuration(o());
        anim.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.a());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: hf3.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZPlanAvatarLoadingV2.j(ZPlanAvatarLoadingV2.this, valueAnimator);
            }
        });
        anim.addListener(new b());
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZPlanAvatarLoadingV2 this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Float f16 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f16 != null) {
            float floatValue = f16.floatValue();
            this$0.mBinding.f398844b.setAlpha(floatValue);
            this$0.mBinding.f398860r.setAlpha(floatValue);
        }
    }

    private final ObjectAnimator l() {
        float alpha = getAlpha();
        QLog.i("ZPlanAvatarLoadingV2", 1, "currentAlpha :" + alpha);
        ObjectAnimator anim = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 0.0f);
        anim.setDuration(o());
        anim.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.a());
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    private final View m() {
        IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) QRoute.api(IZplanCacheApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Object cache = iZplanCacheApi.getCache(context, ZplanCacheComponentType.CARD_TOP_LIST);
        if (cache instanceof View) {
            return (View) cache;
        }
        return null;
    }

    private final void n() {
        if (this.mAvatarAreaIsShowing) {
            u.Companion companion = u.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (companion.d(context, true)) {
                this.mBinding.f398851i.setVisibility(0);
                this.mBinding.f398845c.setVisibility(8);
            } else {
                this.mBinding.f398851i.setVisibility(8);
                this.mBinding.f398845c.setVisibility(0);
            }
        }
    }

    private final void q(long delay) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: hf3.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarLoadingV2.t(ZPlanAvatarLoadingV2.this);
            }
        }, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZPlanAvatarLoadingV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    private final void u() {
        QLog.i("ZPlanAvatarLoadingV2", 1, "refreshLoadingUIImpl mState:" + this.mState + ", mRecordAvatarCanShow:" + this.mRecordAvatarCanShow);
        if (this.mState == 1 && this.mRecordAvatarCanShow) {
            this.mBinding.f398845c.setVisibility(0);
            this.mBinding.f398851i.setVisibility(4);
            this.mAvatarAreaIsShowing = true;
        } else {
            this.mBinding.f398845c.setVisibility(4);
            this.mBinding.f398851i.setVisibility(0);
            this.mAvatarAreaIsShowing = false;
        }
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        if (zPlanQQMC.enableBottomLoadingHint()) {
            this.mBinding.f398852j.setVisibility(0);
        } else {
            this.mBinding.f398852j.setVisibility(8);
        }
        if (zPlanQQMC.enableCenterLoadingTips()) {
            this.mBinding.f398856n.setVisibility(0);
            this.mBinding.f398857o.setVisibility(0);
            this.mBinding.f398854l.setVisibility(0);
        } else {
            this.mBinding.f398856n.setVisibility(8);
            this.mBinding.f398857o.setVisibility(8);
            this.mBinding.f398854l.setVisibility(8);
        }
    }

    private final void v() {
        this.mBinding.f398854l.setText(this.mCurrentProgress + "%");
        this.mBinding.f398855m.setProgress(this.mCurrentProgress);
    }

    private final void w(final int targetState) {
        boolean z16 = this.mState != targetState;
        this.mState = targetState;
        if (z16) {
            r(this, 0L, 1, null);
        }
        ViewGroup.LayoutParams layoutParams = this.mBinding.f398863u.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.weight = targetState == 2 ? 23.5f : 11.7f;
        }
        ViewGroup.LayoutParams layoutParams3 = this.mBinding.f398848f.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.weight = targetState == 2 ? 44.2f : 12.8f;
        }
        this.mBinding.f398850h.setVisibility(targetState != 2 ? 8 : 0);
        post(new Runnable() { // from class: hf3.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarLoadingV2.y(ZPlanAvatarLoadingV2.this, targetState);
            }
        });
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZPlanAvatarLoadingV2 this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(i3);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.recorder.d
    public void a(int avatarRecorderType, ZPlanRecordResource res) {
        Intrinsics.checkNotNullParameter(res, "res");
        QLog.i("ZPlanAvatarLoadingV2", 1, "onRecordRes res:" + res);
        Rect a16 = e84.a.f395879a.a();
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        option.mRequestWidth = a16.width();
        option.mRequestHeight = a16.height();
        option.mUseSharpPAnimImage = true;
        option.mLoadingDrawable = new ColorDrawable(0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_double_bitmap", true);
        option.mExtraInfo = bundle;
        c cVar = new c();
        if (res.o()) {
            this.mRecordAvatarCanShow = true;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(res.getLocalPath(), option);
            this.mBinding.f398847e.setURLDrawableDownListener(cVar);
            this.mBinding.f398847e.setImageDrawable(fileDrawable);
            return;
        }
        if (res.p()) {
            this.mRecordAvatarCanShow = true;
            URLImageView uRLImageView = this.mBinding.f398847e;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.avatarIcon");
            String remoteUrl = res.getRemoteUrl();
            if (remoteUrl == null) {
                remoteUrl = "";
            }
            Intrinsics.checkNotNullExpressionValue(option, "option");
            CommonExKt.u(uRLImageView, remoteUrl, option, cVar);
            return;
        }
        this.mRecordAvatarCanShow = false;
        QLog.e("ZPlanAvatarLoadingV2", 1, "onRecordRes invalid res");
        r(this, 0L, 1, null);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View getCloseIcon() {
        ImageView imageView = this.mBinding.f398850h;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.loadingBackIcon");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public void k() {
        ISceneLoadingView.a.b(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public long o() {
        return 100L;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ObjectAnimator p() {
        if (this.mAvatarAreaIsShowing) {
            return i();
        }
        return l();
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public boolean s(com.tencent.sqshow.zootopia.scene.component.c cVar) {
        return ISceneLoadingView.a.a(this, cVar);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setCloseListener(ISceneLoadingView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCloseListener = listener;
    }

    @Override // c84.a
    public void setProgress(int progress) {
        n();
        if (this.mCurrentProgress == 100) {
            return;
        }
        this.mCurrentProgress = progress;
        v();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void setSwitchState(int targetState) {
        w(targetState);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public View x() {
        LinearLayout linearLayout = this.mBinding.f398851i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.loadingContentArea");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    /* renamed from: z */
    public boolean getMRecordAvatarIsShowing() {
        return ISceneLoadingView.a.c(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarLoadingV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void destroy() {
        QLog.i("ZPlanAvatarLoadingV2", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mBinding.f398849g.c();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void pauseAnim() {
        QLog.i("ZPlanAvatarLoadingV2", 1, "pauseAnim");
        this.mBinding.f398849g.e();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public void resumeAnim() {
        QLog.i("ZPlanAvatarLoadingV2", 1, "resumeAnim");
        this.mBinding.f398849g.f();
    }

    public /* synthetic */ ZPlanAvatarLoadingV2(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarLoadingV2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        am g16 = am.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        this.mLoadingTextHint = c84.c.f30451a.a();
        this.mState = 1;
        g16.f398850h.setOnClickListener(new View.OnClickListener() { // from class: hf3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanAvatarLoadingV2.f(ZPlanAvatarLoadingV2.this, view);
            }
        });
        g16.f398859q.l();
        setOnClickListener(null);
        q(1000L);
    }

    private final void h(int targetState) {
        int statusBarHeight;
        if (targetState == 1) {
            View m3 = m();
            if (m3 != null) {
                ViewGroup.LayoutParams layoutParams = m3.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    statusBarHeight = layoutParams2.topMargin;
                } else {
                    statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
                }
                int height = m3.getHeight() + statusBarHeight;
                ViewGroup.LayoutParams layoutParams3 = this.mBinding.f398862t.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = height;
                }
            }
        } else {
            ViewGroup.LayoutParams layoutParams4 = this.mBinding.f398862t.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = 0;
            }
        }
        requestLayout();
    }

    static /* synthetic */ void r(ZPlanAvatarLoadingV2 zPlanAvatarLoadingV2, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        zPlanAvatarLoadingV2.q(j3);
    }

    public void setStyleMode(int styleMode) {
        if (styleMode == 1) {
            w(1);
        } else if (styleMode == 2) {
            w(2);
        } else if (styleMode == 3) {
            w(2);
        }
        requestLayout();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView
    public ViewGroup getView() {
        return this;
    }

    public void setOnLoadingClickListener(View.OnClickListener l3) {
    }
}

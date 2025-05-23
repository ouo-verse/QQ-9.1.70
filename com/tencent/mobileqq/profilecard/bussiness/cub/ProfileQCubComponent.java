package com.tencent.mobileqq.profilecard.bussiness.cub;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r01.c;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/view/View;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "animatableListener", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "qCubView", "Landroid/widget/ImageView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/ViewGroup;", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "data", "getComponentName", "", "getComponentType", "", "hideQCubView", "", "onCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDataUpdate", "reportDT", "setProfileActivityDelegate", "delegate", "Lcom/tencent/mobileqq/profilecard/base/component/IProfileActivityDelegate;", "setQCubView", "bean", "Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubBean;", "AnimationCallBack", "Companion", "IndirectAnimationRunnable", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileQCubComponent extends AbsProfileComponent<View> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EM_DATACARD_Q = "em_datacard_q";

    @NotNull
    private static final String PG_SOURCE_Q = "pg_source_Q";

    @NotNull
    public static final String TAG = "ProfileQCubComponent";

    @Nullable
    private Animatable2Compat.AnimationCallback animatableListener;

    @Nullable
    private ImageView qCubView;

    @Nullable
    private ViewGroup rootView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubComponent$AnimationCallBack;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "handler", "Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubComponent$IndirectAnimationRunnable;", "viewWeakReference", "Lmqq/util/WeakReference;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class AnimationCallBack extends Animatable2Compat.AnimationCallback {
        static IPatchRedirector $redirector_;

        @Nullable
        private IndirectAnimationRunnable handler;

        @NotNull
        private WeakReference<View> viewWeakReference;

        public AnimationCallBack(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.viewWeakReference = new WeakReference<>(view);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            super.onAnimationEnd(drawable);
            if (this.handler == null) {
                this.handler = new IndirectAnimationRunnable();
            }
            IndirectAnimationRunnable indirectAnimationRunnable = this.handler;
            if (indirectAnimationRunnable != null) {
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
                indirectAnimationRunnable.setDrawable((c) drawable);
            }
            View view = this.viewWeakReference.get();
            if (view != null) {
                view.postDelayed(this.handler, 15000L);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubComponent$Companion;", "", "()V", "EM_DATACARD_Q", "", "PG_SOURCE_Q", "TAG", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/cub/ProfileQCubComponent$IndirectAnimationRunnable;", "Ljava/lang/Runnable;", "Lr01/c;", "drawable", "", "setDrawable", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "drawableWeakReference", "Lmqq/util/WeakReference;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class IndirectAnimationRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        @Nullable
        private WeakReference<c> drawableWeakReference;

        public IndirectAnimationRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            WeakReference<c> weakReference = this.drawableWeakReference;
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.setLoopCount(1);
                cVar.start();
            }
        }

        public final void setDrawable(@NotNull c drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            } else {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                this.drawableWeakReference = new WeakReference<>(drawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileQCubComponent(@NotNull IComponentCenter componentCenter, @NotNull ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentCenter, (Object) cardInfo);
        }
    }

    private final boolean canShow(ProfileCardInfo data) {
        ProfileQCubUtil profileQCubUtil = ProfileQCubUtil.INSTANCE;
        if (!profileQCubUtil.isShowProfileQCubExp(data.card)) {
            return false;
        }
        Card card = data.card;
        if (card.qqCubIsOn) {
            return true;
        }
        if (TextUtils.equals(card.uin, this.mApp.getCurrentAccountUin()) || !profileQCubUtil.isOpenGuestAllLookTest()) {
            return false;
        }
        return true;
    }

    private final void hideQCubView() {
        ImageView imageView = this.qCubView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void reportDT() {
        VideoReport.setElementId(this.qCubView, EM_DATACARD_Q);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PG_SOURCE_Q, "1");
        VideoReport.setElementParams(this.qCubView, linkedHashMap);
    }

    private final void setQCubView(final ProfileQCubBean bean) {
        ImageView imageView = this.qCubView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.cub.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileQCubComponent.setQCubView$lambda$0(ProfileQCubComponent.this, bean, view);
                }
            });
        }
        ImageView imageView2 = this.qCubView;
        boolean z16 = false;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Option option = new Option().setTargetView(this.qCubView).setUrl(bean.getUrl());
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.cub.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                ProfileQCubComponent.setQCubView$lambda$2(ProfileQCubComponent.this, bean, loadState, option2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setQCubView$lambda$0(ProfileQCubComponent this$0, ProfileQCubBean bean, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this$0.mActivity, bean.getJumpUrl());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setQCubView$lambda$2(ProfileQCubComponent this$0, ProfileQCubBean bean, LoadState loadState, Option option) {
        ImageView imageView;
        c cVar;
        String replace$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        if (loadState == LoadState.STATE_SUCCESS && (imageView = this$0.qCubView) != null) {
            Intrinsics.checkNotNull(imageView);
            Object drawable = imageView.getDrawable();
            if (drawable instanceof c) {
                cVar = (c) drawable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.setLoopCount(2);
                if (this$0.animatableListener == null) {
                    ImageView imageView2 = this$0.qCubView;
                    Intrinsics.checkNotNull(imageView2);
                    this$0.animatableListener = new AnimationCallBack(imageView2);
                }
                Animatable2Compat.AnimationCallback animationCallback = this$0.animatableListener;
                Intrinsics.checkNotNull(animationCallback);
                cVar.registerAnimationCallback(animationCallback);
            }
            ImageView imageView3 = this$0.qCubView;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (cVar != null) {
                cVar.start();
            }
            if (TextUtils.isEmpty(bean.getText())) {
                QLog.e(TAG, 1, "setQCubView text is null");
                return;
            }
            QBaseActivity qBaseActivity = this$0.mActivity;
            if (qBaseActivity != null) {
                String text = bean.getText();
                Intrinsics.checkNotNull(text);
                replace$default = StringsKt__StringsJVMKt.replace$default(text, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
                com.tencent.mobileqq.widget.tip.a.r(qBaseActivity).W(-1).p0(Color.parseColor("#FF1A1C1E")).j0(10.0f, 8.0f, 10.0f, 8.0f).e0(true).o0(replace$default).S(this$0.qCubView).i0(8.0f, 0.0f).p(false).b0(5000L).k0(2).R(0).Z(0, 1).g0(false).r0(false).s0();
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1046;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(@Nullable QBaseActivity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
    public void setProfileActivityDelegate(@Nullable IProfileActivityDelegate delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) delegate);
            return;
        }
        super.setProfileActivityDelegate(delegate);
        if (delegate != null) {
            this.rootView = delegate.getRootView();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(@Nullable ProfileCardInfo data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) data)).booleanValue();
        }
        if ((data != null ? data.card : null) != null && canShow(data)) {
            ProfileQCubBean profileQCubBean = (ProfileQCubBean) data.card.getBusinessInfo(ProfileQCubBean.class);
            if ((this.rootView instanceof RelativeLayout) && profileQCubBean != null) {
                if (this.qCubView == null) {
                    this.qCubView = new ImageView(this.mActivity);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.a(54.0f), e.a(85.0f));
                    ImageView imageView = this.qCubView;
                    if (imageView != null) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                    layoutParams.addRule(2, R.id.f27940hl);
                    layoutParams.addRule(11);
                    ImageView imageView2 = this.qCubView;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                    ViewGroup viewGroup = this.rootView;
                    Intrinsics.checkNotNull(viewGroup);
                    viewGroup.addView(this.qCubView, layoutParams);
                }
                reportDT();
                setQCubView(profileQCubBean);
                return super.lambda$checkValidComponent$3((ProfileQCubComponent) data);
            }
            hideQCubView();
            return super.lambda$checkValidComponent$3((ProfileQCubComponent) data);
        }
        hideQCubView();
        return super.lambda$checkValidComponent$3((ProfileQCubComponent) data);
    }
}

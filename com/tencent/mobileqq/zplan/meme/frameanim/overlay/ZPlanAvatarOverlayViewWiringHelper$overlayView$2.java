package com.tencent.mobileqq.zplan.meme.frameanim.overlay;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import fi3.bt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t74.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Incorrect field signature: TT; */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "T", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "K", "Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanAvatarOverlayViewWiringHelper$overlayView$2 extends Lambda implements Function0<ConstraintLayout> {
    final /* synthetic */ ViewModelStoreOwner $lifecycleSpan;
    final /* synthetic */ ZPlanAvatarOverlayViewWiringHelper<T, K> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewWiringHelper<TT;TK;>;TT;)V */
    public ZPlanAvatarOverlayViewWiringHelper$overlayView$2(ZPlanAvatarOverlayViewWiringHelper zPlanAvatarOverlayViewWiringHelper, ViewModelStoreOwner viewModelStoreOwner) {
        super(0);
        this.this$0 = zPlanAvatarOverlayViewWiringHelper;
        this.$lifecycleSpan = viewModelStoreOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final ZPlanAvatarOverlayViewWiringHelper this$0, final Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper$overlayView$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                bt s16;
                String w3;
                bt s17;
                QLog.i("ZPlanAvatarOverlayViewWiringHelper", 1, "is showing loading status changed. new: " + bool);
                this$0.y(bool);
                Boolean it = bool;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                int i3 = it.booleanValue() ? 0 : 8;
                s16 = this$0.s();
                LottieAnimationView lottieAnimationView = s16.f399152d;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.transformationAnimation");
                LottieLoader lottieLoader = new LottieLoader(lottieAnimationView.getContext());
                w3 = this$0.w();
                lottieLoader.fromNetworkWithCacheBitmap(lottieAnimationView, w3);
                lottieAnimationView.setRepeatCount(-1);
                lottieAnimationView.setRepeatMode(1);
                s17 = this$0.s();
                s17.f399151c.setVisibility(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZPlanAvatarOverlayViewWiringHelper this$0, Boolean isShowingErrorBubble) {
        WeakReference weakReference;
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel;
        String u16;
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel2;
        String u17;
        int t16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanAvatarOverlayViewWiringHelper", 1, "error tips showing status changed: new: " + isShowingErrorBubble);
        weakReference = this$0.bubbleControllerRef;
        com.tencent.mobileqq.zplan.bubble.b bVar = weakReference != null ? (com.tencent.mobileqq.zplan.bubble.b) weakReference.get() : null;
        if (bVar == null) {
            QLog.e("ZPlanAvatarOverlayViewWiringHelper", 1, "bubble controller ref is null!");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(isShowingErrorBubble, "isShowingErrorBubble");
        if (isShowingErrorBubble.booleanValue()) {
            if (ZPlanQQMC.INSTANCE.enableErrorBubbleOnQZone()) {
                u17 = this$0.u();
                t16 = this$0.t();
                bVar.f(u17, t16);
            }
            zPlanAvatarOverlayViewModel = this$0.viewModel;
            int recordErrorCode = zPlanAvatarOverlayViewModel.getRecordErrorCode();
            u16 = this$0.u();
            this$0.x(recordErrorCode, u16);
            zPlanAvatarOverlayViewModel2 = this$0.viewModel;
            zPlanAvatarOverlayViewModel2.g2();
            return;
        }
        bVar.c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ConstraintLayout invoke() {
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel;
        Observer<? super Boolean> observer;
        ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel2;
        Observer<? super Boolean> observer2;
        bt s16;
        bt s17;
        QLog.i("ZPlanAvatarOverlayViewWiringHelper", 1, "ZPlanAvatarOverlayViewWiringHelper init overlayView");
        final ZPlanAvatarOverlayViewWiringHelper<T, K> zPlanAvatarOverlayViewWiringHelper = this.this$0;
        ((ZPlanAvatarOverlayViewWiringHelper) zPlanAvatarOverlayViewWiringHelper).isShowingLoadingObserver = new Observer() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarOverlayViewWiringHelper$overlayView$2.c(ZPlanAvatarOverlayViewWiringHelper.this, (Boolean) obj);
            }
        };
        zPlanAvatarOverlayViewModel = ((ZPlanAvatarOverlayViewWiringHelper) this.this$0).viewModel;
        LiveData<Boolean> c26 = zPlanAvatarOverlayViewModel.c2();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.$lifecycleSpan;
        observer = ((ZPlanAvatarOverlayViewWiringHelper) this.this$0).isShowingLoadingObserver;
        Intrinsics.checkNotNull(observer);
        c26.observe(lifecycleOwner, observer);
        final ZPlanAvatarOverlayViewWiringHelper<T, K> zPlanAvatarOverlayViewWiringHelper2 = this.this$0;
        ((ZPlanAvatarOverlayViewWiringHelper) zPlanAvatarOverlayViewWiringHelper2).isShowingErrorTisObserver = new Observer() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanAvatarOverlayViewWiringHelper$overlayView$2.d(ZPlanAvatarOverlayViewWiringHelper.this, (Boolean) obj);
            }
        };
        zPlanAvatarOverlayViewModel2 = ((ZPlanAvatarOverlayViewWiringHelper) this.this$0).viewModel;
        LiveData<Boolean> b26 = zPlanAvatarOverlayViewModel2.b2();
        LifecycleOwner lifecycleOwner2 = (LifecycleOwner) this.$lifecycleSpan;
        observer2 = ((ZPlanAvatarOverlayViewWiringHelper) this.this$0).isShowingErrorTisObserver;
        Intrinsics.checkNotNull(observer2);
        b26.observe(lifecycleOwner2, observer2);
        s16 = this.this$0.s();
        s16.getRoot().setTag("loadingView");
        s17 = this.this$0.s();
        return s17.getRoot();
    }
}

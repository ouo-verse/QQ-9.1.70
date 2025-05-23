package com.tencent.mobileqq.zplan.meme.frameanim.overlay;

import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel;
import com.tencent.mobileqq.zplan.meme.frameanim.report.datong.DaTongReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import fi3.bt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li3.BubbleReportData;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u0002*\b\b\u0001\u0010\u0005*\u00020\u00042\u00020\u0006:\u0001\u0019B%\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010F\u001a\u00028\u0000\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00010G\u00a2\u0006\u0004\bI\u0010JJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u001b\u0010\u001e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0014\u0010&\u001a\u00028\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b(\u0010)R \u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u001b\u00109\u001a\u0002058VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0A8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010B\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewWiringHelper;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "T", "Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewModel;", "K", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "", "code", "", "msg", "", HippyTKDListViewAdapter.X, "", "isShowingLoading", "y", "(Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/zplan/bubble/b;", "bubbleController", "e", "Lli3/a;", "data", "b", "needTimeout", "d", "a", "release", "Lkotlin/Lazy;", "w", "()Ljava/lang/String;", "transformationAnimURL", "t", "()I", "defaultErrBubbleExpirationSec", "c", "u", "defaultErrBubbleText", "Lcom/tencent/mobileqq/zplan/meme/frameanim/overlay/ZPlanAvatarOverlayViewModel;", "viewModel", "Lfi3/bt;", ReportConstant.COSTREPORT_PREFIX, "()Lfi3/bt;", "binding", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "bubbleControllerRef", "Landroidx/lifecycle/Observer;", "g", "Landroidx/lifecycle/Observer;", "isShowingLoadingObserver", tl.h.F, "isShowingErrorTisObserver", "Landroidx/constraintlayout/widget/ConstraintLayout;", "i", "v", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "overlayView", "j", "Lli3/a;", "reportData", "Ljava/util/concurrent/atomic/AtomicLong;", "k", "Ljava/util/concurrent/atomic/AtomicLong;", "beginLoadingTime", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isShowingOverlay", "Landroid/view/LayoutInflater;", "inflater", "lifecycleSpan", "Ljava/lang/Class;", "viewModelClass", "<init>", "(Landroid/view/LayoutInflater;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;)V", "l", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarOverlayViewWiringHelper<T extends ViewModelStoreOwner & LifecycleOwner, K extends ZPlanAvatarOverlayViewModel> implements com.tencent.mobileqq.zplan.meme.frameanim.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy transformationAnimURL;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy defaultErrBubbleExpirationSec;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy defaultErrBubbleText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final K viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile WeakReference<com.tencent.mobileqq.zplan.bubble.b> bubbleControllerRef;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Observer<Boolean> isShowingLoadingObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Observer<Boolean> isShowingErrorTisObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy overlayView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private BubbleReportData reportData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private AtomicLong beginLoadingTime;

    public ZPlanAvatarOverlayViewWiringHelper(final LayoutInflater inflater, T lifecycleSpan, Class<K> viewModelClass) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(lifecycleSpan, "lifecycleSpan");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper$transformationAnimURL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ZPlanFeatureSwitch.f369852a.F1();
            }
        });
        this.transformationAnimURL = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper$defaultErrBubbleExpirationSec$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZPlanFeatureSwitch.f369852a.J1());
            }
        });
        this.defaultErrBubbleExpirationSec = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper$defaultErrBubbleText$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ZPlanFeatureSwitch.f369852a.K1();
            }
        });
        this.defaultErrBubbleText = lazy3;
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(lifecycleSpan).get(viewModelClass);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(life\u2026Span).get(viewModelClass)");
        this.viewModel = (K) viewModel;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<bt>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bt invoke() {
                bt g16 = bt.g(inflater);
                Integer e16 = ni3.a.f420201a.e();
                if (e16 != null) {
                    g16.f399150b.setGuidelineBegin(e16.intValue());
                }
                return g16;
            }
        });
        this.binding = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new ZPlanAvatarOverlayViewWiringHelper$overlayView$2(this, lifecycleSpan));
        this.overlayView = lazy5;
        QLog.i("ZPlanAvatarOverlayViewWiringHelper", 1, "construct new " + this);
        this.beginLoadingTime = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final bt s() {
        return (bt) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        return ((Number) this.defaultErrBubbleExpirationSec.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u() {
        return (String) this.defaultErrBubbleText.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String w() {
        return (String) this.transformationAnimURL.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int code, String msg2) {
        BubbleReportData bubbleReportData = this.reportData;
        if (bubbleReportData != null) {
            DaTongReport.f334065a.h(bubbleReportData.getUin(), bubbleReportData.getBusinessId(), bubbleReportData.getSessionId(), code, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Boolean isShowingLoading) {
        BubbleReportData bubbleReportData = this.reportData;
        if (bubbleReportData != null) {
            if (Intrinsics.areEqual(isShowingLoading, Boolean.TRUE)) {
                this.beginLoadingTime.getAndSet(System.currentTimeMillis());
                DaTongReport.f334065a.j(bubbleReportData.getUin(), bubbleReportData.getBusinessId(), bubbleReportData.getSessionId());
            } else {
                long andSet = this.beginLoadingTime.getAndSet(0L);
                if (andSet > 0) {
                    DaTongReport.f334065a.i(bubbleReportData.getUin(), bubbleReportData.getBusinessId(), bubbleReportData.getSessionId(), System.currentTimeMillis() - andSet);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public void a() {
        this.viewModel.T1();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public void b(BubbleReportData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.reportData = data;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public LiveData<Boolean> c() {
        return this.viewModel.c2();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public void d(boolean needTimeout) {
        this.viewModel.W1(needTimeout);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public void e(com.tencent.mobileqq.zplan.bubble.b bubbleController) {
        this.bubbleControllerRef = new WeakReference<>(bubbleController);
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    public void release() {
        QLog.i("ZPlanAvatarOverlayViewWiringHelper", 1, this + " release");
        this.bubbleControllerRef = null;
        Observer<Boolean> observer = this.isShowingLoadingObserver;
        if (observer != null) {
            this.viewModel.c2().removeObserver(observer);
        }
        this.isShowingLoadingObserver = null;
        Observer<Boolean> observer2 = this.isShowingErrorTisObserver;
        if (observer2 != null) {
            this.viewModel.b2().removeObserver(observer2);
        }
        this.isShowingErrorTisObserver = null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.e
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout f() {
        return (ConstraintLayout) this.overlayView.getValue();
    }
}

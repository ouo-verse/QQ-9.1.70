package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.FeedBatchManageSearchPreparationViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002,-B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\r8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010!\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lvi1/d;", "", "C9", "D9", "B9", "", "state", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "withAnimation", "I0", "e5", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "d", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "viewDependencies", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "searchPreparationViewModel", "f", "Z", "c5", "()Z", "G9", "(Z)V", "isInSearchMode", tl.h.F, "isRunningAnimation", "<init>", "(Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;)V", "i", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageInteractStateViewControllerPart extends Part implements vi1.d {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f218154i = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b viewDependencies;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchPreparationViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInSearchMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRunningAnimation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$a;", "", "", "ANIMATION_DURATION", "J", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$b;", "", "Landroid/view/View;", "b", "()Landroid/view/View;", "searchLayer", "a", "presentationLayer", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        @NotNull
        View a();

        @NotNull
        View b();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            FeedBatchManageInteractStateViewControllerPart.this.isRunningAnimation = false;
            FeedBatchManageInteractStateViewControllerPart.this.viewDependencies.a().setVisibility(8);
            FeedBatchManageInteractStateViewControllerPart.this.F9(2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/FeedBatchManageInteractStateViewControllerPart$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            FeedBatchManageInteractStateViewControllerPart.this.viewDependencies.b().setVisibility(8);
            FeedBatchManageInteractStateViewControllerPart.this.isRunningAnimation = false;
            FeedBatchManageInteractStateViewControllerPart.this.F9(0);
        }
    }

    public FeedBatchManageInteractStateViewControllerPart(@NotNull b viewDependencies) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        this.viewDependencies = viewDependencies;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<FeedBatchManageSearchPreparationViewModel>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart$searchPreparationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedBatchManageSearchPreparationViewModel invoke() {
                return (FeedBatchManageSearchPreparationViewModel) FeedBatchManageInteractStateViewControllerPart.this.getViewModel(FeedBatchManageSearchPreparationViewModel.class);
            }
        });
        this.searchPreparationViewModel = lazy;
    }

    private final void B9() {
        ViewParent parent = this.viewDependencies.a().getParent();
        if ((parent instanceof ViewGroup) && this.viewDependencies.b().getParent() == null) {
            View b16 = this.viewDependencies.b();
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            Unit unit = Unit.INSTANCE;
            ((ViewGroup) parent).addView(b16, layoutParams);
        }
    }

    private final void C9() {
        this.isRunningAnimation = true;
        F9(1);
        B9();
        this.viewDependencies.b().setVisibility(0);
        this.viewDependencies.b().setAlpha(0.0f);
        this.viewDependencies.b().animate().setDuration(250L).alpha(1.0f).setListener(new c()).start();
        this.viewDependencies.a().animate().setDuration(250L).alpha(0.0f).start();
    }

    private final void D9() {
        this.isRunningAnimation = true;
        F9(3);
        b bVar = this.viewDependencies;
        bVar.a().setVisibility(0);
        bVar.b().setVisibility(0);
        this.viewDependencies.b().animate().setDuration(250L).alpha(0.0f).setListener(new d()).start();
        this.viewDependencies.a().animate().setDuration(250L).alpha(1.0f).start();
    }

    private final FeedBatchManageSearchPreparationViewModel E9() {
        return (FeedBatchManageSearchPreparationViewModel) this.searchPreparationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(int state) {
        MutableLiveData<Integer> mutableLiveData;
        FeedBatchManageSearchPreparationViewModel E9 = E9();
        if (E9 != null) {
            mutableLiveData = E9.M1();
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(Integer.valueOf(state));
        }
    }

    public void G9(boolean z16) {
        this.isInSearchMode = z16;
    }

    @Override // vi1.d
    public void I0(boolean withAnimation) {
        if (!getIsInSearchMode() && !this.isRunningAnimation) {
            G9(true);
            if (withAnimation) {
                C9();
                return;
            }
            B9();
            F9(1);
            b bVar = this.viewDependencies;
            View b16 = bVar.b();
            b16.setVisibility(0);
            b16.setAlpha(1.0f);
            View a16 = bVar.a();
            a16.setVisibility(8);
            a16.setAlpha(0.0f);
            F9(2);
            return;
        }
        QLog.d("FeedBatchManagement.Search.StateController", 1, "already in search mode");
    }

    @Override // vi1.d
    /* renamed from: c5, reason: from getter */
    public boolean getIsInSearchMode() {
        return this.isInSearchMode;
    }

    @Override // vi1.d
    public void e5(boolean withAnimation) {
        if (getIsInSearchMode() && !this.isRunningAnimation) {
            G9(false);
            if (withAnimation) {
                D9();
                return;
            }
            F9(3);
            b bVar = this.viewDependencies;
            View a16 = bVar.a();
            a16.setVisibility(0);
            a16.setAlpha(1.0f);
            View b16 = bVar.b();
            b16.setVisibility(8);
            b16.setAlpha(0.0f);
            F9(0);
            return;
        }
        QLog.d("FeedBatchManagement.Search.StateController", 1, "already exited search mode");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (getIsInSearchMode()) {
            e5(true);
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        PartIOCKt.registerIoc(this, this, vi1.d.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(this, vi1.d.class);
    }
}

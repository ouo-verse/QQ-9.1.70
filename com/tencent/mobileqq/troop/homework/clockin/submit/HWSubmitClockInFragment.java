package com.tencent.mobileqq.troop.homework.clockin.submit;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel;
import com.tencent.mobileqq.troop.homework.clockin.submit.vm.a;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWAudioRecordPart;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/HWSubmitClockInFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", "view", "", "initUI", "Dh", "Bh", "", "getContentLayoutId", "", "needImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onStart", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onDestroyView", "Landroid/content/Intent;", "intent", "onNewIntent", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel;", "viewModel", "D", "Landroid/view/View;", "containerView", "Lcom/tencent/mobileqq/troop/homework/entry/ui/view/InputMethodGuard;", "E", "Lcom/tencent/mobileqq/troop/homework/entry/ui/view/InputMethodGuard;", "inputMethodGuard", UserInfo.SEX_FEMALE, "Z", "inputMethodIsActive", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWSubmitClockInFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static WeakReference<View> H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private InputMethodGuard inputMethodGuard;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean inputMethodIsActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/HWSubmitClockInFragment$a;", "", "", "troopUin", "clockInId", "", "date", "", "isMakeUp", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/collections/ArrayList;", "items", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "logicParentViewRef", "", "a", "sLogicParentViewRef", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.submit.HWSubmitClockInFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ void b(Companion companion, String str, String str2, long j3, boolean z16, ArrayList arrayList, WeakReference weakReference, int i3, Object obj) {
            ArrayList arrayList2;
            if ((i3 & 16) != 0) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList;
            }
            companion.a(str, str2, j3, z16, arrayList2, weakReference);
        }

        @JvmStatic
        public final void a(@NotNull String troopUin, @NotNull String clockInId, long date, boolean isMakeUp, @NotNull ArrayList<BaseItem> items, @Nullable WeakReference<View> logicParentViewRef) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, clockInId, Long.valueOf(date), Boolean.valueOf(isMakeUp), items, logicParentViewRef);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(clockInId, "clockInId");
            Intrinsics.checkNotNullParameter(items, "items");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("clock_in_id", clockInId);
            intent.putExtra("date", date);
            intent.putExtra("is_make_up", isMakeUp);
            intent.putExtra("media_item_list", items);
            HWSubmitClockInFragment.H = logicParentViewRef;
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicTransFragmentActivity.class, HWSubmitClockInFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/submit/HWSubmitClockInFragment$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWSubmitClockInFragment.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            FragmentActivity activity = HWSubmitClockInFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            FragmentActivity activity2 = HWSubmitClockInFragment.this.getActivity();
            if (activity2 != null) {
                activity2.overridePendingTransition(0, 0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWSubmitClockInFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HWSubmitClockInViewModel.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        Unit unit;
        if (getView() == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return;
            }
        }
        View view = this.containerView;
        if (view != null) {
            view.animate().translationYBy(view.getHeight()).setDuration(200L).start();
        }
        View view2 = getView();
        if (view2 != null) {
            view2.animate().alpha(0.0f).setDuration(150L).setStartDelay(150L).setListener(new b()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWSubmitClockInViewModel Ch() {
        return (HWSubmitClockInViewModel) this.viewModel.getValue();
    }

    private final void Dh() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.submit.vm.a> obtainUiState = Ch().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.submit.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.submit.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.HWSubmitClockInFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWSubmitClockInFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.submit.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.submit.vm.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (aVar instanceof a.C8719a) {
                    HWSubmitClockInFragment.this.Bh();
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWSubmitClockInFragment.Eh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(HWSubmitClockInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            InputMethodUtil.hide(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(HWSubmitClockInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(HWSubmitClockInFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new HWSubmitClockInFragment$initUI$3$1(view, this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(final HWSubmitClockInFragment this$0, boolean z16, int i3) {
        int coerceAtLeast;
        int i16;
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputMethodIsActive = z16;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - ViewUtils.dip2px(60.0f), 0);
        View view2 = this$0.containerView;
        if (view2 != null) {
            i16 = view2.getPaddingBottom();
        } else {
            i16 = 0;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, coerceAtLeast);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HWSubmitClockInFragment.Kh(HWSubmitClockInFragment.this, valueAnimator);
            }
        });
        ofInt.start();
        if (!z16 && (view = this$0.containerView) != null) {
            view.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(HWSubmitClockInFragment this$0, ValueAnimator valueAnimator) {
        Integer num;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.containerView;
        if (view != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                num = (Integer) animatedValue;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            view.setPadding(0, 0, 0, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Lh(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "insets.getInsets(WindowI\u2026Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void initUI(View view) {
        view.findViewById(R.id.if5).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWSubmitClockInFragment.Fh(HWSubmitClockInFragment.this, view2);
            }
        });
        ((TextView) view.findViewById(R.id.f903852b)).setText(Ch().S1());
        view.findViewById(R.id.azb).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWSubmitClockInFragment.Gh(HWSubmitClockInFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.f903752a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(R.id.submit_button)");
        TriggerRunnerKt.c(findViewById, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWSubmitClockInFragment.Hh(HWSubmitClockInFragment.this, view2);
            }
        }, 1, null);
        View findViewById2 = view.findViewById(R.id.b9t);
        this.containerView = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HWSubmitClockInFragment.Ih(view2);
                }
            });
        }
        InputMethodGuard inputMethodGuard = (InputMethodGuard) view.findViewById(R.id.dmx);
        this.inputMethodGuard = inputMethodGuard;
        if (inputMethodGuard != null) {
            inputMethodGuard.setOnInputMethodChangeListener(new InputMethodGuard.a() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.f
                @Override // com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a
                public final void Xb(boolean z16, int i3) {
                    HWSubmitClockInFragment.Jh(HWSubmitClockInFragment.this, z16, i3);
                }
            });
        }
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.if5), new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.g
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat Lh;
                Lh = HWSubmitClockInFragment.Lh(view2, windowInsetsCompat);
                return Lh;
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.troop.homework.clockin.submit.part.a(), new HWAudioRecordPart(), new HWMediaSelectPart(HWMediaSelectPart.SourceType.HW_CLOCK));
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g0j;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            if (!(activity instanceof QBaseActivity)) {
                return;
            }
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            qBaseActivity.overridePendingTransition(R.anim.f154431s, R.anim.f154430r);
            com.tencent.mobileqq.theme.a.d(qBaseActivity.getWindow());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Bh();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onDestroyView();
            InputMethodUtil.hide(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
        } else {
            getPartManager().onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Dh();
    }
}

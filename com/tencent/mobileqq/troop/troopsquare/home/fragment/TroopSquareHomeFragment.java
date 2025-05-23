package com.tencent.mobileqq.troop.troopsquare.home.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareLoadingPart;
import com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareRecommendPart;
import com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareTopicBannerPart;
import com.tencent.mobileqq.troop.troopsquare.home.part.i;
import com.tencent.mobileqq.troop.troopsquare.home.part.k;
import com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareHomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "dismiss", "vh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackEvent", "Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "uh", "()Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "viewModel", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "draggableLayout", "", "getGroupCode", "()J", "groupCode", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareHomeFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout draggableLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareHomeFragment$a;", "", "Landroid/content/Context;", "context", "", "troopUin", "ext", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareHomeFragment$a, reason: from kotlin metadata */
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

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String troopUin, @NotNull String ext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, troopUin, ext);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(ext, "ext");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
            intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154533mz);
            intent.putExtra("troop_square_ext", ext);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, TroopSquareHomeFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareHomeFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TroopSquareHomeViewModel.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Animation animation;
        if (!isAdded()) {
            return;
        }
        RelativeLayout relativeLayout = this.draggableLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout = null;
        }
        Object tag = relativeLayout.getTag();
        if (tag instanceof Animation) {
            animation = (Animation) tag;
        } else {
            animation = null;
        }
        if (animation != null) {
            animation.cancel();
        }
        RelativeLayout relativeLayout3 = this.draggableLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout3 = null;
        }
        RelativeLayout relativeLayout4 = this.draggableLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
        } else {
            relativeLayout2 = relativeLayout4;
        }
        ViewPropertyAnimator withEndAction = relativeLayout2.animate().translationY(ImmersiveUtils.getScreenHeight()).setInterpolator(new AccelerateInterpolator()).setDuration(150L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopSquareHomeFragment.th(TroopSquareHomeFragment.this);
            }
        });
        withEndAction.start();
        relativeLayout3.setTag(withEndAction);
    }

    private final long getGroupCode() {
        return uh().O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(TroopSquareHomeFragment this$0) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(this$0.getParentFragmentManager());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        FragmentManager fragmentManager = (FragmentManager) m476constructorimpl;
        if (fragmentManager != null && !fragmentManager.isStateSaved()) {
            fragmentManager.beginTransaction().remove(this$0).commit();
        } else {
            QLog.i("TroopSquare.Home.TroopSquareHomeFragment", 1, "TroopSquareHomeFragment: fm state is already saved");
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final TroopSquareHomeViewModel uh() {
        return (TroopSquareHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vh() {
        Animation animation;
        RelativeLayout relativeLayout = this.draggableLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout = null;
        }
        Object tag = relativeLayout.getTag();
        if (tag instanceof Animation) {
            animation = (Animation) tag;
        } else {
            animation = null;
        }
        if (animation != null) {
            animation.cancel();
        }
        RelativeLayout relativeLayout3 = this.draggableLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout3 = null;
        }
        RelativeLayout relativeLayout4 = this.draggableLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
        } else {
            relativeLayout2 = relativeLayout4;
        }
        ViewPropertyAnimator withEndAction = relativeLayout2.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(150L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopSquareHomeFragment.wh(TroopSquareHomeFragment.this);
            }
        });
        withEndAction.start();
        relativeLayout3.setTag(withEndAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(TroopSquareHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.draggableLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout = null;
        }
        relativeLayout.setTag(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new k(), new TroopSquareTopicBannerPart(getGroupCode()), new TroopSquareRecommendPart(), new com.tencent.mobileqq.troop.troopsquare.home.part.b(new TroopSquareHomeFragment$assembleParts$1(this), new TroopSquareHomeFragment$assembleParts$2(this)), new i(getGroupCode()), new TroopSquareLoadingPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (!(activity instanceof QBaseActivity)) {
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
        RFWImmersiveUtils.setNavigationBarColor(qBaseActivity.getWindow(), ie0.a.f().g(activity, R.color.qui_common_bg_bottom_light, 1000));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        super.onBackEvent();
        dismiss();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        QLog.i("TroopSquare.Home.TroopSquareHomeFragment", 4, "troopCode=" + getGroupCode());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            root = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            uh().T1();
            root = inflater.inflate(R.layout.f169161i14, container, false);
            View findViewById = root.findViewById(R.id.uln);
            Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.draggable_layout)");
            this.draggableLayout = (RelativeLayout) findViewById;
            Intrinsics.checkNotNullExpressionValue(root, "root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }
}

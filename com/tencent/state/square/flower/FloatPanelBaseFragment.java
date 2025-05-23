package com.tencent.state.square.flower;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.state.AnimListener;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFlowerFrameworkBinding;
import com.tencent.state.view.FloatPanelDragListener;
import com.tencent.state.view.RoundRelativeLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H&\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001eH\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/flower/FloatPanelBaseFragment;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/tencent/state/VasBaseSubFragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "dragPercent", "", "frameworkBinding", "Lcom/tencent/state/square/databinding/VasSquareFlowerFrameworkBinding;", "getFrameworkBinding", "()Lcom/tencent/state/square/databinding/VasSquareFlowerFrameworkBinding;", "setFrameworkBinding", "(Lcom/tencent/state/square/databinding/VasSquareFlowerFrameworkBinding;)V", "initFrameWorkView", "", "initSubViewBinding", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/LayoutInflater;)Landroidx/viewbinding/ViewBinding;", "onBackPressed", "", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", BaseConstants.BROADCAST_USERSYNC_ENTER, "nextAnim", "onCreateView", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class FloatPanelBaseFragment<T extends ViewBinding> extends VasBaseSubFragment {
    private T binding;
    private float dragPercent;
    private VasSquareFlowerFrameworkBinding frameworkBinding;

    private final void initFrameWorkView(VasSquareFlowerFrameworkBinding binding) {
        RoundRelativeLayout roundRelativeLayout = binding.contentLayout;
        roundRelativeLayout.mRadius = ViewExtensionsKt.dip((View) roundRelativeLayout, 8);
        roundRelativeLayout.mCorners = 3;
        binding.blankLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.flower.FloatPanelBaseFragment$initFrameWorkView$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatPanelBaseFragment.this.onBackPressed();
            }
        });
        FrameLayout frameLayout = binding.dragHandle;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return");
            FrameLayout frameLayout2 = binding.panelRoot;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.panelRoot");
            frameLayout.setOnTouchListener(new FloatPanelDragListener(context, frameLayout2, new Function1<Float, Unit>() { // from class: com.tencent.state.square.flower.FloatPanelBaseFragment$initFrameWorkView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke(f16.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f16) {
                    FloatPanelBaseFragment.this.dragPercent = f16;
                    FloatPanelBaseFragment.this.onBackPressed();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VasSquareFlowerFrameworkBinding getFrameworkBinding() {
        return this.frameworkBinding;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    public abstract T initSubViewBinding(LayoutInflater inflater);

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        popFragment(this);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return null");
        if (enter) {
            Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.f154350j7);
            loadAnimation.setAnimationListener(new AnimListener() { // from class: com.tencent.state.square.flower.FloatPanelBaseFragment$onCreateAnimation$$inlined$also$lambda$1
                @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RelativeLayout relativeLayout;
                    int color = ContextCompat.getColor(activity, R.color.f8055x);
                    VasSquareFlowerFrameworkBinding frameworkBinding = FloatPanelBaseFragment.this.getFrameworkBinding();
                    if (frameworkBinding == null || (relativeLayout = frameworkBinding.dialogRoot) == null) {
                        return;
                    }
                    relativeLayout.setBackgroundColor(color);
                }

                @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    AnimListener.DefaultImpls.onAnimationRepeat(this, animation);
                }

                @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AnimListener.DefaultImpls.onAnimationStart(this, animation);
                }
            });
            return loadAnimation;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.dragPercent, 1, 1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setAnimationListener(new AnimListener() { // from class: com.tencent.state.square.flower.FloatPanelBaseFragment$onCreateAnimation$$inlined$also$lambda$2
            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AnimListener.DefaultImpls.onAnimationEnd(this, animation);
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AnimListener.DefaultImpls.onAnimationRepeat(this, animation);
            }

            @Override // com.tencent.state.AnimListener, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                RelativeLayout relativeLayout;
                VasSquareFlowerFrameworkBinding frameworkBinding = FloatPanelBaseFragment.this.getFrameworkBinding();
                if (frameworkBinding == null || (relativeLayout = frameworkBinding.dialogRoot) == null) {
                    return;
                }
                relativeLayout.setBackgroundColor(0);
            }
        });
        return translateAnimation;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.frameworkBinding = VasSquareFlowerFrameworkBinding.inflate(inflater);
        T initSubViewBinding = initSubViewBinding(inflater);
        this.binding = initSubViewBinding;
        VasSquareFlowerFrameworkBinding vasSquareFlowerFrameworkBinding = this.frameworkBinding;
        if (vasSquareFlowerFrameworkBinding != null && (frameLayout = vasSquareFlowerFrameworkBinding.contentContainer) != null) {
            frameLayout.addView(initSubViewBinding != null ? initSubViewBinding.getMRv() : null, new FrameLayout.LayoutParams(-1, -2));
        }
        VasSquareFlowerFrameworkBinding vasSquareFlowerFrameworkBinding2 = this.frameworkBinding;
        if (vasSquareFlowerFrameworkBinding2 != null) {
            return vasSquareFlowerFrameworkBinding2.getMRv();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        VasSquareFlowerFrameworkBinding vasSquareFlowerFrameworkBinding = this.frameworkBinding;
        if (vasSquareFlowerFrameworkBinding != null) {
            initFrameWorkView(vasSquareFlowerFrameworkBinding);
        }
    }

    protected final void setBinding(T t16) {
        this.binding = t16;
    }

    protected final void setFrameworkBinding(VasSquareFlowerFrameworkBinding vasSquareFlowerFrameworkBinding) {
        this.frameworkBinding = vasSquareFlowerFrameworkBinding;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}

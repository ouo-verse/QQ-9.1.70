package com.tencent.mobileqq.ai.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.QuickLiveData;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/ai/main/AIAvatarEmptyViewPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "containerView", "", "f", "Z", "hadLoadEmpty", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", tl.h.F, "D9", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarEmptyViewPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadLoadEmpty;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    public AIAvatarEmptyViewPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarEmptyViewPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarEmptyViewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIAvatarMainViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarMainViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarMainViewModel.Companion companion = AIAvatarMainViewModel.INSTANCE;
                    Fragment hostFragment = AIAvatarEmptyViewPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.vm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarEmptyViewPart$emptyView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarEmptyViewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUIEmptyState invoke() {
                    ViewGroup viewGroup;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarEmptyViewPart.this.hadLoadEmpty = true;
                    QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(AIAvatarEmptyViewPart.this.getContext()).setImageType(16);
                    String string = AIAvatarEmptyViewPart.this.getActivity().getResources().getString(R.string.f2172460h);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026g.qvip_ai_avatar_no_data)");
                    QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    viewGroup = AIAvatarEmptyViewPart.this.containerView;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        viewGroup = null;
                    }
                    viewGroup.addView(build, layoutParams);
                    return build;
                }
            });
            this.emptyView = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIEmptyState D9() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final AIAvatarMainViewModel E9() {
        return (AIAvatarMainViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        this.containerView = (ViewGroup) rootView;
        QuickLiveData<Boolean> e26 = E9().e2();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.ai.main.AIAvatarEmptyViewPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarEmptyViewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                boolean z16;
                QUIEmptyState D9;
                QUIEmptyState D92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    D92 = AIAvatarEmptyViewPart.this.D9();
                    D92.setVisibility(0);
                    return;
                }
                z16 = AIAvatarEmptyViewPart.this.hadLoadEmpty;
                if (z16) {
                    D9 = AIAvatarEmptyViewPart.this.D9();
                    D9.setVisibility(8);
                }
            }
        };
        e26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.ai.main.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIAvatarEmptyViewPart.F9(Function1.this, obj);
            }
        });
    }
}

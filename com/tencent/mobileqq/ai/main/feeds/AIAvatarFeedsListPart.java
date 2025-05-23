package com.tencent.mobileqq.ai.main.feeds;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ai.AIAvatarCapsuleTabBar;
import com.tencent.mobileqq.ai.main.AIAvatarFeedsTabInfo;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/AIAvatarFeedsListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar;", "e", "Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar;", "tabBar", "Lcom/tencent/mobileqq/widget/QQViewPager;", "f", "Lcom/tencent/mobileqq/widget/QQViewPager;", "viewPager", "Lcom/tencent/mobileqq/ai/main/feeds/g;", tl.h.F, "Lcom/tencent/mobileqq/ai/main/feeds/g;", "adapter", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarFeedsListPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIAvatarCapsuleTabBar tabBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQViewPager viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private g adapter;

    public AIAvatarFeedsListPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsListPart.this);
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
                    Fragment hostFragment = AIAvatarFeedsListPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIAvatarMainViewModel E9() {
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
        View findViewById = rootView.findViewById(R.id.sfk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026avatar_main_page_tab_bar)");
        this.tabBar = (AIAvatarCapsuleTabBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.sfl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026tar_main_page_view_pager)");
        this.viewPager = (QQViewPager) findViewById2;
        MutableLiveData<List<AIAvatarFeedsTabInfo>> X1 = E9().X1();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        final AIAvatarFeedsListPart$onInitView$1 aIAvatarFeedsListPart$onInitView$1 = new AIAvatarFeedsListPart$onInitView$1(this);
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.ai.main.feeds.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIAvatarFeedsListPart.F9(Function1.this, obj);
            }
        });
    }
}

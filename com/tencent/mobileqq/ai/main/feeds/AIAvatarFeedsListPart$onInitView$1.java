package com.tencent.mobileqq.ai.main.feeds;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.ai.AIAvatarCapsuleTabBar;
import com.tencent.mobileqq.ai.main.AIAvatarFeedsTabInfo;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
final class AIAvatarFeedsListPart$onInitView$1 extends Lambda implements Function1<List<? extends AIAvatarFeedsTabInfo>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIAvatarFeedsListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIAvatarFeedsListPart$onInitView$1(AIAvatarFeedsListPart aIAvatarFeedsListPart) {
        super(1);
        this.this$0 = aIAvatarFeedsListPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIAvatarFeedsListPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIAvatarFeedsListPart this$0) {
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar;
        AIAvatarMainViewModel E9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.ai.c cVar = com.tencent.mobileqq.ai.c.f187660a;
        aIAvatarCapsuleTabBar = this$0.tabBar;
        if (aIAvatarCapsuleTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            aIAvatarCapsuleTabBar = null;
        }
        E9 = this$0.E9();
        cVar.a(aIAvatarCapsuleTabBar, E9.b2());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends AIAvatarFeedsTabInfo> list) {
        invoke2((List<AIAvatarFeedsTabInfo>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<AIAvatarFeedsTabInfo> list) {
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar;
        AIAvatarMainViewModel E9;
        AIAvatarMainViewModel E92;
        QQViewPager qQViewPager;
        g gVar;
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar2;
        QQViewPager qQViewPager2;
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        aIAvatarCapsuleTabBar = this.this$0.tabBar;
        AIAvatarCapsuleTabBar aIAvatarCapsuleTabBar4 = null;
        if (aIAvatarCapsuleTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            aIAvatarCapsuleTabBar = null;
        }
        E9 = this.this$0.E9();
        aIAvatarCapsuleTabBar.setTabData(E9.b2());
        AIAvatarFeedsListPart aIAvatarFeedsListPart = this.this$0;
        FragmentManager childFragmentManager = aIAvatarFeedsListPart.getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        E92 = this.this$0.E9();
        aIAvatarFeedsListPart.adapter = new g(childFragmentManager, E92);
        qQViewPager = this.this$0.viewPager;
        if (qQViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager = null;
        }
        gVar = this.this$0.adapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            gVar = null;
        }
        qQViewPager.setAdapter(gVar);
        aIAvatarCapsuleTabBar2 = this.this$0.tabBar;
        if (aIAvatarCapsuleTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            aIAvatarCapsuleTabBar2 = null;
        }
        qQViewPager2 = this.this$0.viewPager;
        if (qQViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            qQViewPager2 = null;
        }
        aIAvatarCapsuleTabBar2.setViewPager(qQViewPager2);
        aIAvatarCapsuleTabBar3 = this.this$0.tabBar;
        if (aIAvatarCapsuleTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
        } else {
            aIAvatarCapsuleTabBar4 = aIAvatarCapsuleTabBar3;
        }
        final AIAvatarFeedsListPart aIAvatarFeedsListPart2 = this.this$0;
        aIAvatarCapsuleTabBar4.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ai.main.feeds.f
            @Override // java.lang.Runnable
            public final void run() {
                AIAvatarFeedsListPart$onInitView$1.b(AIAvatarFeedsListPart.this);
            }
        }, 200L);
    }
}

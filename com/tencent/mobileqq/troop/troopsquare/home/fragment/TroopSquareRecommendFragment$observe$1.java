package com.tencent.mobileqq.troop.troopsquare.home.fragment;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.TroopSquareRecommendAdapter;
import com.tencent.mobileqq.troop.troopsquare.home.view.TroopSquareListLoadingView;
import com.tencent.mobileqq.widget.listitem.ab;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/troop/troopsquare/data/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareRecommendFragment$observe$1 extends Lambda implements Function1<List<? extends com.tencent.mobileqq.troop.troopsquare.data.a>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSquareRecommendFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareRecommendFragment$observe$1(TroopSquareRecommendFragment troopSquareRecommendFragment) {
        super(1);
        this.this$0 = troopSquareRecommendFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareRecommendFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSquareRecommendFragment this$0) {
        TroopSquareListLoadingView troopSquareListLoadingView;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopSquareListLoadingView = this$0.troopSquareListLoadingView;
        FrameLayout frameLayout2 = null;
        if (troopSquareListLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSquareListLoadingView");
            troopSquareListLoadingView = null;
        }
        ab.c(troopSquareListLoadingView);
        frameLayout = this$0.loadingLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        } else {
            frameLayout2 = frameLayout;
        }
        frameLayout2.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.troopsquare.data.a> list) {
        invoke2((List<com.tencent.mobileqq.troop.troopsquare.data.a>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<com.tencent.mobileqq.troop.troopsquare.data.a> it) {
        TroopSquareListLoadingView troopSquareListLoadingView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        if (it.isEmpty()) {
            this.this$0.Hh(16, "\u6682\u65e0\u6570\u636e");
        } else {
            this.this$0.Dh();
        }
        TroopSquareRecommendAdapter zh5 = this.this$0.zh();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zh5.p0(it);
        troopSquareListLoadingView = this.this$0.troopSquareListLoadingView;
        if (troopSquareListLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSquareListLoadingView");
            troopSquareListLoadingView = null;
        }
        final TroopSquareRecommendFragment troopSquareRecommendFragment = this.this$0;
        troopSquareListLoadingView.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopSquareRecommendFragment$observe$1.b(TroopSquareRecommendFragment.this);
            }
        });
    }
}

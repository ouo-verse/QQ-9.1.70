package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSquareLoadingPart$failedView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSquareLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareLoadingPart$failedView$2(TroopSquareLoadingPart troopSquareLoadingPart) {
        super(0);
        this.this$0 = troopSquareLoadingPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareLoadingPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSquareLoadingPart this$0, View view) {
        TroopSquareHomeViewModel E9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtil.isNetworkAvailable()) {
            this$0.J9(false, true, false);
            E9 = this$0.E9();
            E9.T1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIEmptyState invoke() {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIEmptyState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QUIEmptyState.Builder title = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5).setBackgroundColorType(0).setTitle("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        final TroopSquareLoadingPart troopSquareLoadingPart = this.this$0;
        QUIEmptyState build = title.setButton("\u91cd\u8bd5", new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSquareLoadingPart$failedView$2.b(TroopSquareLoadingPart.this, view);
            }
        }).build();
        TroopSquareLoadingPart troopSquareLoadingPart2 = this.this$0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        build.setLayoutParams(layoutParams);
        relativeLayout = troopSquareLoadingPart2.loadingLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            relativeLayout = null;
        }
        relativeLayout.addView(build);
        return build;
    }
}

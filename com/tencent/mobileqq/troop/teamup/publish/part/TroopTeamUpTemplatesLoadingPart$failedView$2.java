package com.tencent.mobileqq.troop.teamup.publish.part;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout;
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
public final class TroopTeamUpTemplatesLoadingPart$failedView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopTeamUpTemplatesLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpTemplatesLoadingPart$failedView$2(TroopTeamUpTemplatesLoadingPart troopTeamUpTemplatesLoadingPart) {
        super(0);
        this.this$0 = troopTeamUpTemplatesLoadingPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpTemplatesLoadingPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopTeamUpTemplatesLoadingPart this$0, View view) {
        com.tencent.mobileqq.troop.teamup.publish.vm.d A9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (NetworkUtil.isNetworkAvailable()) {
            A9 = this$0.A9();
            A9.P1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIEmptyState invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIEmptyState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View partRootView = this.this$0.getPartRootView();
        Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout");
        TroopTeamUpTemplatesLayout troopTeamUpTemplatesLayout = (TroopTeamUpTemplatesLayout) partRootView;
        QUIEmptyState.Builder title = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5).setBackgroundColorType(0).setTitle("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        final TroopTeamUpTemplatesLoadingPart troopTeamUpTemplatesLoadingPart = this.this$0;
        QUIEmptyState build = title.setButton("\u91cd\u8bd5", new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpTemplatesLoadingPart$failedView$2.b(TroopTeamUpTemplatesLoadingPart.this, view);
            }
        }).build();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToBottom = troopTeamUpTemplatesLayout.z0().getId();
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.bottomToBottom = 0;
        build.setLayoutParams(layoutParams);
        troopTeamUpTemplatesLayout.addView(build);
        return build;
    }
}

package com.tencent.mobileqq.troop.teamup.detail.part;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/vm/data/b;", "kotlin.jvm.PlatformType", "result", "", "invoke", "(Lcom/tencent/mobileqq/troop/teamup/detail/vm/data/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class TroopTeamUpDetailContentPart$onInitView$2 extends Lambda implements Function1<com.tencent.mobileqq.troop.teamup.detail.vm.data.b, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopTeamUpDetailContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpDetailContentPart$onInitView$2(TroopTeamUpDetailContentPart troopTeamUpDetailContentPart) {
        super(1);
        this.this$0 = troopTeamUpDetailContentPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpDetailContentPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopTeamUpDetailContentPart this$0, View view) {
        FrameLayout frameLayout;
        Dialog dialog;
        TroopTeamUpDetailVM I9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        frameLayout = this$0.errorContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        this$0.loadingDialog = LoadingUtil.showLoadingDialog(this$0.getContext(), null, false);
        dialog = this$0.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
        I9 = this$0.I9();
        I9.u2();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.teamup.detail.vm.data.b bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.tencent.mobileqq.troop.teamup.detail.vm.data.b bVar) {
        Dialog dialog;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        dialog = this.this$0.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        FrameLayout frameLayout5 = null;
        if (!bVar.c()) {
            frameLayout2 = this.this$0.errorContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(0);
            frameLayout3 = this.this$0.errorContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                frameLayout3 = null;
            }
            if (frameLayout3.getChildCount() == 0) {
                String b16 = bVar.b();
                TroopTeamUpDetailContentPart troopTeamUpDetailContentPart = this.this$0;
                if (b16.length() == 0) {
                    b16 = troopTeamUpDetailContentPart.getContext().getString(R.string.f236007d7);
                    Intrinsics.checkNotNullExpressionValue(b16, "context.getString(R.stri\u2026team_up_detail_net_error)");
                }
                boolean z16 = bVar.a() != 10002;
                QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5).setHalfScreenState(false).setBackgroundColorType(0);
                final TroopTeamUpDetailContentPart troopTeamUpDetailContentPart2 = this.this$0;
                String string = troopTeamUpDetailContentPart2.getContext().getString(R.string.f235987d5);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026eam_up_detail_load_error)");
                backgroundColorType.setTitle(string);
                backgroundColorType.setDesc(b16);
                if (z16) {
                    String string2 = troopTeamUpDetailContentPart2.getContext().getString(R.string.f236047da);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026oop_team_up_detail_retry)");
                    backgroundColorType.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TroopTeamUpDetailContentPart$onInitView$2.b(TroopTeamUpDetailContentPart.this, view);
                        }
                    });
                }
                QUIEmptyState build = backgroundColorType.build();
                frameLayout4 = this.this$0.errorContainer;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
                } else {
                    frameLayout5 = frameLayout4;
                }
                frameLayout5.addView(build, -1, -1);
                return;
            }
            return;
        }
        frameLayout = this.this$0.errorContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
        } else {
            frameLayout5 = frameLayout;
        }
        frameLayout5.setVisibility(8);
    }
}

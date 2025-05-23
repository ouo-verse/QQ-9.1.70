package com.tencent.mobileqq.troop.deletemember.parts;

import android.app.Dialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/Dialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopDeleteMemberPart$deleteDialog$2 extends Lambda implements Function0<Dialog> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopDeleteMemberPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopDeleteMemberPart$deleteDialog$2(TroopDeleteMemberPart troopDeleteMemberPart) {
        super(0);
        this.this$0 = troopDeleteMemberPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopDeleteMemberPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Dialog this_apply, TroopDeleteMemberPart this$0, View view) {
        com.tencent.mobileqq.troop.deletemember.a aVar;
        com.tencent.mobileqq.troop.deletemember.a aVar2;
        CheckBox M9;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_apply.isShowing()) {
            this_apply.dismiss();
        }
        q d16 = new q(bg.e()).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_cel");
        aVar = this$0.viewModel;
        com.tencent.mobileqq.troop.deletemember.a aVar3 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        q c16 = d16.c(aVar.M1());
        String[] strArr = new String[1];
        aVar2 = this$0.viewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar3 = aVar2;
        }
        strArr[0] = aVar3.N1();
        c16.b(strArr).g();
        M9 = this$0.M9();
        this$0.L9(0, M9.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Dialog invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final ReportDialog reportDialog = new ReportDialog(this.this$0.getActivity(), R.style.qZoneInputDialog);
        final TroopDeleteMemberPart troopDeleteMemberPart = this.this$0;
        reportDialog.setContentView(R.layout.f167936ng);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.c0g));
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        textView2.setText(R.string.cancel);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.deletemember.parts.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopDeleteMemberPart$deleteDialog$2.b(reportDialog, troopDeleteMemberPart, view);
            }
        });
        return reportDialog;
    }
}

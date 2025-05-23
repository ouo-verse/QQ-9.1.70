package com.tencent.mobileqq.troop.deletemember.parts;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopDeleteMemberPart$checkBox$2 extends Lambda implements Function0<CheckBox> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopDeleteMemberPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopDeleteMemberPart$checkBox$2(TroopDeleteMemberPart troopDeleteMemberPart) {
        super(0);
        this.this$0 = troopDeleteMemberPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopDeleteMemberPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopDeleteMemberPart this$0, View view) {
        CheckBox M9;
        com.tencent.mobileqq.troop.deletemember.a aVar;
        com.tencent.mobileqq.troop.deletemember.a aVar2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M9 = this$0.M9();
        if (M9.isChecked()) {
            q d16 = new q(bg.e()).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_nomore");
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
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CheckBox invoke() {
        Dialog N9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CheckBox) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        N9 = this.this$0.N9();
        View findViewById = N9.findViewById(R.id.checkBoxConfirm);
        final TroopDeleteMemberPart troopDeleteMemberPart = this.this$0;
        CheckBox checkBox = (CheckBox) findViewById;
        checkBox.setText(HardCodeUtil.qqStr(R.string.h0e));
        if (checkBox.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = checkBox.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(14);
            checkBox.setLayoutParams(layoutParams2);
        }
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.deletemember.parts.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopDeleteMemberPart$checkBox$2.b(TroopDeleteMemberPart.this, view);
            }
        });
        return checkBox;
    }
}

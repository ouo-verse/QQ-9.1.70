package com.tencent.mobileqq.troop.troopselector;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "showLimitDialog", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopSelectorFragment$initObserver$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TroopSelectorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectorFragment$initObserver$3(TroopSelectorFragment troopSelectorFragment) {
        super(1);
        this.this$0 = troopSelectorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSelectorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            dialogInterface.dismiss();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        r8 = r7.this$0.limitDialog;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(Boolean showLimitDialog) {
        TroopSelectorConfig Ih;
        QQCustomDialog qQCustomDialog;
        QQCustomDialog qQCustomDialog2;
        TroopSelectorConfig Ih2;
        Intrinsics.checkNotNullExpressionValue(showLimitDialog, "showLimitDialog");
        if (showLimitDialog.booleanValue()) {
            Ih = this.this$0.Ih();
            if (Ih != null && Ih.a() == 2) {
                return;
            }
            qQCustomDialog = this.this$0.limitDialog;
            if (qQCustomDialog == null) {
                TroopSelectorFragment troopSelectorFragment = this.this$0;
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(troopSelectorFragment.getActivity(), 230);
                final TroopSelectorFragment troopSelectorFragment2 = this.this$0;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String qqStr = HardCodeUtil.qqStr(R.string.f20674595);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_troop_\u2026or_forward_num_limit_tip)");
                Object[] objArr = new Object[1];
                Ih2 = troopSelectorFragment2.Ih();
                objArr[0] = Ih2 != null ? Integer.valueOf(Ih2.b()) : null;
                String format = String.format(qqStr, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                createCustomDialog.setMessage(format);
                createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f20675596), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        TroopSelectorFragment$initObserver$3.b(TroopSelectorFragment.this, dialogInterface, i3);
                    }
                });
                troopSelectorFragment.limitDialog = createCustomDialog;
            }
            FragmentActivity activity = this.this$0.getActivity();
            if (!((activity == null || activity.isFinishing()) ? false : true) || qQCustomDialog2 == null) {
                return;
            }
            qQCustomDialog2.show();
        }
    }
}

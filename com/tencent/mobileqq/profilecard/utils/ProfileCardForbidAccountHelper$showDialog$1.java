package com.tencent.mobileqq.profilecard.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileCardForbidAccountHelper$showDialog$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $activity;
    final /* synthetic */ ProfileCardForbidAccountHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileCardForbidAccountHelper$showDialog$1(ProfileCardForbidAccountHelper profileCardForbidAccountHelper, Context context) {
        super(0);
        this.this$0 = profileCardForbidAccountHelper;
        this.$activity = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) profileCardForbidAccountHelper, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(ProfileCardForbidAccountHelper this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2(ProfileCardForbidAccountHelper this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialog = null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z16;
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        z16 = this.this$0.hasShowDialog;
        if (z16) {
            return;
        }
        ProfileCardForbidAccountHelper profileCardForbidAccountHelper = this.this$0;
        Context context = this.$activity;
        String qqStr = HardCodeUtil.qqStr(R.string.f175302y7);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f175452yl);
        final ProfileCardForbidAccountHelper profileCardForbidAccountHelper2 = this.this$0;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, qqStr, (String) null, qqStr2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.utils.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ProfileCardForbidAccountHelper$showDialog$1.invoke$lambda$1(ProfileCardForbidAccountHelper.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        final ProfileCardForbidAccountHelper profileCardForbidAccountHelper3 = this.this$0;
        createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.profilecard.utils.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ProfileCardForbidAccountHelper$showDialog$1.invoke$lambda$3$lambda$2(ProfileCardForbidAccountHelper.this, dialogInterface);
            }
        });
        profileCardForbidAccountHelper.dialog = createCustomDialog;
        try {
            dialog = this.this$0.dialog;
            if (dialog != null) {
                dialog.show();
            }
            this.this$0.hasShowDialog = true;
        } catch (Exception e16) {
            QLog.e(ProfileCardForbidAccountHelper.TAG, 1, "showDialog exception:", e16);
        }
    }
}

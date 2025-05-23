package com.tencent.mobileqq.troop.troopsetting.part;

import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSettingChatGroupPart$modifyTroopNameDialog$2 extends Lambda implements Function0<QQCustomDialog> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSettingChatGroupPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSettingChatGroupPart$modifyTroopNameDialog$2(TroopSettingChatGroupPart troopSettingChatGroupPart) {
        super(0);
        this.this$0 = troopSettingChatGroupPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingChatGroupPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QQCustomDialog invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? DialogUtil.createCustomDialog(this.this$0.getContext(), 230, "", "\u5f53\u524d\u7fa4\u804a\u4ec5\u7fa4\u4e3b/\u7fa4\u7ba1\u7406\u5458\u53ef\u4fee\u6539\u7fa4\u804a\u540d\u79f0", (String) null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopSettingChatGroupPart$modifyTroopNameDialog$2.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null) : (QQCustomDialog) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}

package com.tencent.mobileqq.activity.home.chats.biz;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class z extends d implements UpgradeTipsDialog.b {
    static IPatchRedirector $redirector_;
    public static Intent D;
    public static boolean E;
    private UpgradeTipsDialog C;

    public z(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void na() {
        UpgradeTipsDialog upgradeTipsDialog = this.C;
        if (upgradeTipsDialog != null) {
            try {
                try {
                    upgradeTipsDialog.dismiss();
                } catch (Exception e16) {
                    QLog.e("UpgradeController_UpgradePart", 1, "handleMessageForInstallUpgradeBarHide", e16);
                }
            } finally {
                this.C = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(DialogInterface dialogInterface) {
        if (dialogInterface == this.C) {
            this.C = null;
        }
    }

    private void pa(Message message) {
        QLog.i("UpgradeController_UpgradePart", 1, "onReceiverShowUpgradeTips");
        AppRuntime X9 = X9();
        if (!(X9 instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) X9;
        if (this.C == null) {
            Object obj = message.obj;
            if (obj instanceof UpgradeDetailWrapper) {
                UpgradeDetailWrapper upgradeDetailWrapper = (UpgradeDetailWrapper) obj;
                upgradeDetailWrapper.f306170d = new UpgradeInfo();
                int P2 = ConfigHandler.P2(qQAppInterface);
                if (P2 >= 5) {
                    com.tencent.mobileqq.upgrade.banner.b.j(false);
                    QLog.i("UpgradeController_UpgradePart", 1, "onReceiverShowUpgradeTips count=" + P2);
                    return;
                }
                if (ConfigHandler.f3(qQAppInterface)) {
                    QLog.i("UpgradeController_UpgradePart", 1, "onReceiverShowUpgradeTips isDailyShowTips");
                } else {
                    if (ConfigHandler.Q2(qQAppInterface, 0) == null) {
                        QLog.i("UpgradeController_UpgradePart", 1, "onReceiverShowUpgradeTips null == url");
                        return;
                    }
                    UpgradeTipsDialog upgradeTipsDialog = new UpgradeTipsDialog(getActivity(), qQAppInterface, upgradeDetailWrapper, this);
                    this.C = upgradeTipsDialog;
                    upgradeTipsDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.home.chats.biz.y
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            z.this.oa(dialogInterface);
                        }
                    });
                }
            }
        }
    }

    private void qa() {
        if (D != null) {
            QLog.i("UpgradeController_UpgradePart", 1, "onResume, show upgrade dialog");
            sa(D);
            D = null;
        } else if (E) {
            QLog.i("UpgradeController_UpgradePart", 1, "onResume, show upgrade banner");
            com.tencent.mobileqq.upgrade.banner.b.j(false);
            E = false;
        }
    }

    private void ra() {
        UpgradeTipsDialog upgradeTipsDialog;
        if (la() && (upgradeTipsDialog = this.C) != null && upgradeTipsDialog.S()) {
            try {
                AppRuntime X9 = X9();
                if (!(X9 instanceof QQAppInterface)) {
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) X9;
                this.C.show();
                ConfigHandler.h3(qQAppInterface);
                ConfigHandler.k3(qQAppInterface, ConfigHandler.P2(qQAppInterface) + 1);
                com.tencent.mobileqq.upgrade.activity.q.d("Update_tips", "Upd_tips_appear", 0);
            } catch (Exception e16) {
                com.tencent.mobileqq.upgrade.activity.q.d("Update_tips", "Upd_tips_appear", -1);
                QLog.e("UpgradeController_UpgradePart", 1, "showUpgradeDetailInfoIfNecessary", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.upgrade.UpgradeTipsDialog.b
    public void E7(UpgradeTipsDialog upgradeTipsDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) upgradeTipsDialog);
        } else {
            ra();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void J9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ra();
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ra();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "UpgradeController_UpgradePart";
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1134020) {
            pa(message);
            return true;
        }
        if (i3 == 1134019) {
            na();
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a, mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        UpgradeTipsDialog upgradeTipsDialog = this.C;
        if (upgradeTipsDialog != null) {
            try {
                try {
                    upgradeTipsDialog.dismiss();
                } catch (Exception e16) {
                    QLog.e("UpgradeController_UpgradePart", 1, "onAccountChanged", e16);
                }
            } finally {
                this.C = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        UpgradeTipsDialog upgradeTipsDialog = this.C;
        if (upgradeTipsDialog != null) {
            upgradeTipsDialog.U(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            qa();
        }
    }

    public void sa(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
        } else if (getActivity() != null) {
            getActivity().startActivity(intent);
        }
    }
}

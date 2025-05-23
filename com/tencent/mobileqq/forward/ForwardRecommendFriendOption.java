package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardRecommendFriendOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    AbsShareMsg f210794d;

    /* renamed from: e, reason: collision with root package name */
    AbsStructMsg f210795e;

    public ForwardRecommendFriendOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        AbsStructMsg absStructMsg = this.f210795e;
        if (absStructMsg != null) {
            qQCustomDialog.addView(absStructMsg.getPreDialogView(this.mActivity, null));
            return true;
        }
        if (this.f210794d != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), 0, BaseAIOUtils.f(-15.0f, this.mActivity.getResources()), BaseAIOUtils.f(5.0f, this.mActivity.getResources()));
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardRecommendFriendOption", 2, "updateImageView addStructView");
            }
            qQCustomDialog.addView(this.f210794d.getPreDialogView(this.mActivity, null), layoutParams);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int intExtra = this.mIntent.getIntExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, -1);
        if (intExtra == 63) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005B35", "0X8005B35", 0, 0, "", "", "", "");
        } else if (intExtra == 84) {
            if (this.mIntent.getIntExtra("pa_type", -1) == 53) {
                ReportController.o(this.app, "CliOper", "", "", "0X8007017", "0X8007017", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "0X800716A", "0X800716A", 0, 0, "", "", "", "");
            }
        }
        super.forwardOnCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int intExtra = this.mIntent.getIntExtra(AppConstants.Key.STRUCT_MSG_SERVICE_ID, -1);
        if (intExtra == 63) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005B34", "0X8005B34", 0, 0, "", "", "", "");
        } else if (intExtra == 84) {
            if (this.mIntent.getIntExtra("pa_type", -1) == 53) {
                ReportController.o(this.app, "CliOper", "", "", "0X8007018", "0X8007018", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "0X8007169", "0X8007169", 0, 0, "", "", "", "");
            }
        }
        super.forwardOnConfirm();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(this.mExtraData.getByteArray(AppConstants.Key.STRUCT_MSG_BYTES));
        this.f210795e = com.tencent.mobileqq.structmsg.i.d(this.mExtraData.getByteArray("struct_msg_show_in_dialog"));
        if (d16 != null && (d16 instanceof AbsShareMsg)) {
            this.f210794d = (AbsShareMsg) d16;
            return true;
        }
        return true;
    }
}

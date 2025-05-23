package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardQZoneRichImageOption extends ForwardSdkBaseOption {
    static IPatchRedirector $redirector_;
    private boolean T;

    public ForwardQZoneRichImageOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        AbsShareMsg absShareMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        if (this.T && (absShareMsg = this.G) != null) {
            absShareMsg.mSourceName = this.mIntent.getStringExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
            this.G.mSourceIcon = this.mIntent.getStringExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON);
        }
        if (qQCustomDialog != null && this.G != null) {
            ForwardSdkBaseOption.g gVar = new ForwardSdkBaseOption.g(this.mActivity);
            this.F = gVar;
            qQCustomDialog.addView(gVar.b());
            qQCustomDialog.adjustMessageTopBottomMargin(0.0f, 10.0f);
            addSourceNameView(this.G.mSourceName, qQCustomDialog);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mConfirmDialog.setMessage("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.fromCreateDiscussion) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.fromCreateDiscussion = false;
        }
        super.forwardOnConfirm();
    }

    @Override // com.tencent.mobileqq.forward.ForwardSdkBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210818d = this.mExtraData.getLong("req_share_id");
        boolean booleanExtra = this.mIntent.getBooleanExtra("is_ec_live_share", false);
        this.T = booleanExtra;
        if (this.f210818d > 0 && !booleanExtra) {
            QQAppInterface qQAppInterface = this.app;
            Share.o(qQAppInterface, this.mAppContext, qQAppInterface.getCurrentAccountUin(), this.f210818d, 0L, this.Q);
        }
        s();
        Bundle bundle = new Bundle(this.mExtraData);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
        if (e16 != null && (e16 instanceof AbsShareMsg)) {
            this.G = (AbsShareMsg) e16;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        m();
        return true;
    }
}

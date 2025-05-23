package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* loaded from: classes12.dex */
public class ForwardEmojiPacketSendOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    int f210623d;

    public ForwardEmojiPacketSendOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
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

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        this.mExtraData.putString("uin", bundle.getString("uin"));
        this.mExtraData.putInt("uintype", bundle.getInt("uintype"));
        this.mExtraData.putBoolean("isBack2Root", true);
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        this.mIntent = aliasIntent;
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        this.mIntent = m3;
        m3.putExtras(this.mExtraData);
        this.mActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean(AppConstants.Key.FORWARD_EMOPGK_ID, true).commit();
        this.mActivity.startActivity(this.mIntent);
        ReportController.o(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", AppConstants.Key.FORWARD_EMOPGK_ID);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void preForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.preForward();
        ReportController.o(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", this.mIntent.getIntExtra(AppConstants.Key.FORWARD_EMOPGK_ID, -1) + "");
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210623d = this.mIntent.getIntExtra(AppConstants.Key.FORWARD_EMOPGK_ID, -1);
        return true;
    }
}

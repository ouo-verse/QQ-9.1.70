package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ActivateFriendShareFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private long E;
    private String F;
    private Activity G;
    QQAppInterface H;

    public ActivateFriendShareFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Intent ph() {
        Intent intent = new Intent();
        String str = this.F;
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(97).d(HardCodeUtil.qqStr(R.string.j1s) + this.D).b("web", str, str, str, str).a();
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(27);
        c16.R0 = 1;
        c16.m(new StructMsgItemTitle(this.D));
        c16.m(new ap(String.valueOf(this.E)));
        c16.m(new com.tencent.mobileqq.structmsg.view.a(1, this.H.getCurrentAccountUin(), ""));
        c16.m(new com.tencent.mobileqq.structmsg.view.a(1, this.C, ""));
        a16.addItem(c16);
        a16.mCompatibleText = HardCodeUtil.qqStr(R.string.j1r);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        intent.putExtra("forward_type", -3);
        intent.putExtra("uin", this.C);
        intent.putExtra("emoInputType", 2);
        ReportController.o(this.H, "dc00898", "", "", "0X8007AD9", "0X8007AD9", 1, 0, "", "", "", "");
        return intent;
    }

    private void qh() {
        ForwardBaseOption d16 = com.tencent.mobileqq.forward.k.d(ph(), this.H, this.G);
        d16.preForward();
        Bundle bundle = new Bundle();
        bundle.putInt("uintype", 0);
        bundle.putString("uin", this.C);
        bundle.putString("uinname", com.tencent.mobileqq.utils.ac.H(this.H, this.C));
        d16.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        Intent intent = this.G.getIntent();
        this.C = intent.getStringExtra("friend_uin");
        this.D = intent.getStringExtra("content");
        this.E = intent.getLongExtra("timestamp", System.currentTimeMillis());
        this.F = intent.getStringExtra(WadlProxyConsts.KEY_JUMP_URL);
        qh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        this.G = getBaseActivity();
        if (getBaseActivity().getAppInterface() instanceof QQAppInterface) {
            this.H = (QQAppInterface) getBaseActivity().getAppInterface();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriendShareFragment", 2, "onWindowFocusChanged: isFocused=" + z16);
        }
        if (z16) {
            this.G.finish();
        }
    }
}

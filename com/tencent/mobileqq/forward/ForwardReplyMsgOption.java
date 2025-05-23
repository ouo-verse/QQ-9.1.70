package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.cw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardReplyMsgOption extends ForwardTextOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ChatMessage f210796d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardReplyMsgOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQCustomDialog qQCustomDialog = ForwardReplyMsgOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    QQCustomDialog qQCustomDialog2 = ForwardReplyMsgOption.this.mConfirmDialog;
                    if (qQCustomDialog2 instanceof cw) {
                        z16 = ((cw) qQCustomDialog2).X();
                    } else {
                        z16 = false;
                    }
                    ForwardReplyMsgOption.this.mIntent.putExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, z16);
                    ForwardReplyMsgOption forwardReplyMsgOption = ForwardReplyMsgOption.this;
                    NtMsgForwardUtils.q(forwardReplyMsgOption.mActivity, forwardReplyMsgOption.mIntent);
                    NTChatHistoryMsgForwardSingleton nTChatHistoryMsgForwardSingleton = NTChatHistoryMsgForwardSingleton.INSTANCE;
                    ForwardReplyMsgOption forwardReplyMsgOption2 = ForwardReplyMsgOption.this;
                    nTChatHistoryMsgForwardSingleton.previewForwardMsg(forwardReplyMsgOption2.mActivity, forwardReplyMsgOption2.mIntent);
                    ForwardReplyMsgOption.this.reportClickContentAction();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForwardReplyMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardTextOption, com.tencent.mobileqq.forward.ForwardBaseOption
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
    @Override // com.tencent.mobileqq.forward.ForwardTextOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        View buildNewVersionContentView = super.buildNewVersionContentView();
        View findViewById = buildNewVersionContentView.findViewById(R.id.lim);
        if (findViewById == null) {
            return buildNewVersionContentView;
        }
        findViewById.setOnClickListener(new a());
        return buildNewVersionContentView;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String dialogContent = super.getDialogContent();
        if (this.f210796d != null) {
            return HardCodeUtil.qqStr(R.string.mpi) + dialogContent;
        }
        return dialogContent;
    }

    @Override // com.tencent.mobileqq.forward.ForwardTextOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean preloadData = super.preloadData();
        long j3 = this.mExtraData.getLong(AppConstants.Key.FORWARD_UNISEQ, -1L);
        if (j3 == -1) {
            return preloadData;
        }
        this.f210796d = ((com.tencent.mobileqq.replymsg.a) this.app.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(j3);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardReplyMsgOption", 2, "ForwardReplyMsgOption preloadData mChatMessage=" + this.f210796d);
        }
        return preloadData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        this.mExtraData.putInt("KEY_MSG_FORWARD_ID", com.tencent.mobileqq.activity.aio.forward.b.d().c());
        return super.sendMessage2TargetOnConfirm(str, str2, i3);
    }
}

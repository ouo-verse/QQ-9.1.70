package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardVoiceCallOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    boolean f210942d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ChatActivityUtils.u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardVoiceCallOption.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ForwardVoiceCallOption.this.mActivity.setResult(-1);
                ForwardVoiceCallOption.this.mActivity.finish();
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ForwardVoiceCallOption.this.mActivity.setResult(-1);
                ForwardVoiceCallOption.this.mActivity.finish();
            }
        }
    }

    public ForwardVoiceCallOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.f210942d = false;
            this.mSurpportTroopDiscussionTmpConv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        this.mForwardAbilities.add(e.V3);
        if (allowPhoneContactAbility()) {
            this.mForwardAbilities.add(e.U3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bundle);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        a aVar = new a();
        int i16 = bundle.getInt("uintype");
        String string = bundle.getString("troop_uin");
        String string2 = bundle.getString("uin");
        String string3 = bundle.getString("uinname");
        if (i16 != 0 && i16 != 1004) {
            if (i16 == 1006) {
                ChatActivityUtils.h0(this.app, this.mActivity, i16, "0", string3, string2, true, string, true, true, aVar, "from_internal");
            }
        } else {
            ChatActivityUtils.h0(this.app, this.mActivity, i16, string2, string3, "", true, string, true, true, aVar, "from_internal");
        }
        ReportController.o(this.app, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        for (RecentUser recentUser : list) {
            if (recentUser != null && (recentUser.getType() != 1006 || isSupportAbility(e.U3))) {
                if (recentUser.getType() != 9501 && recentUser.getType() != 6004 && recentUser.getType() != 7000) {
                    if (recentUser.getType() == 0 && !Utils.J(recentUser.uin) && !Utils.I(recentUser.uin) && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) {
                        if (friendsManager != null && friendsManager.c0(recentUser.uin)) {
                            arrayList.add(recentUser);
                        }
                    } else {
                        if (recentUser.getType() != 1006) {
                            if (recentUser.getType() == 1004 || recentUser.getType() == 1000) {
                                if (this.mSurpportTroopDiscussionTmpConv) {
                                }
                            }
                        }
                        arrayList.add(recentUser);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return HardCodeUtil.qqStr(R.string.mrm);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210942d = this.mIntent.getBooleanExtra("fromWebXman", false);
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void reportForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ReportController.o(this.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
        if (this.f210942d) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void reportOnSearch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ReportController.o(this.app, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
        }
    }
}

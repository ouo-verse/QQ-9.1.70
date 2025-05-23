package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardChooseFriendOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ResultReceiver f210605d;

    /* renamed from: e, reason: collision with root package name */
    int f210606e;

    /* renamed from: f, reason: collision with root package name */
    int f210607f;

    /* renamed from: h, reason: collision with root package name */
    private String f210608h;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f210609d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f210610e;

        a(int i3, Bundle bundle) {
            this.f210609d = i3;
            this.f210610e = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardChooseFriendOption.this, Integer.valueOf(i3), bundle);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ForwardChooseFriendOption forwardChooseFriendOption = ForwardChooseFriendOption.this;
            if (forwardChooseFriendOption.f210605d != null) {
                ForwardChooseFriendOption.this.f210605d.send(0, forwardChooseFriendOption.l(this.f210609d, this.f210610e));
            }
            Activity activity = ForwardChooseFriendOption.this.mActivity;
            if (activity != null) {
                activity.setResult(1);
                ForwardChooseFriendOption.this.mActivity.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardChooseFriendOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    public ForwardChooseFriendOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210606e = 0;
        this.f210607f = 0;
        this.mSurpportTroopDiscussionTmpConv = true;
        this.f210606e = intent.getIntExtra("choose_friend_businessType", 0);
        this.f210607f = intent.getIntExtra("choose_friend_businessSubType", 0);
    }

    private boolean m() {
        if (this.f210606e == 1 && this.f210607f == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("choose_friend_is_contacts", false);
        boolean booleanExtra3 = this.mIntent.getBooleanExtra("choose_friend_is_groupchats", false);
        boolean booleanExtra4 = this.mIntent.getBooleanExtra("choose_friend_is_create_group_chat", false);
        if (booleanExtra && allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        } else {
            this.mForwardAbilities.remove(e.O3);
        }
        if (booleanExtra2 && allowPhoneContactAbility()) {
            this.mForwardAbilities.add(e.U3);
        } else {
            this.mForwardAbilities.remove(e.U3);
        }
        if (booleanExtra3) {
            this.mForwardAbilities.add(e.P3);
            this.mForwardAbilities.add(e.Q3);
        } else {
            this.mForwardAbilities.remove(e.P3);
            this.mForwardAbilities.remove(e.Q3);
        }
        if (booleanExtra4) {
            this.mForwardAbilities.remove(e.Y3);
        } else {
            this.mForwardAbilities.add(e.Y3);
        }
        this.mForwardAbilities.add(e.V3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bundle);
            return;
        }
        if (m()) {
            super.buildForwardDialog(i3, bundle);
            ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerselectpage.list", 0, 0, "", "", "", "");
            ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerconfirmpage.show", 0, 0, "", "", "", "");
            return;
        }
        if (this.f210606e == 1 && this.f210607f == 2) {
            ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.payerselectpage.list", 0, 0, "", "", "", "");
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        if (bundle != null) {
            z16 = bundle.getBoolean("choose_friend_needConfirm");
        } else {
            z16 = false;
        }
        if (z16) {
            String string = bundle.getString("choose_friend_confirmTitle");
            String string2 = bundle.getString("choose_friend_confirmContent");
            if (!TextUtils.isEmpty(string2) && string2.contains("[nick]")) {
                String string3 = bundle.getString("uin");
                String string4 = bundle.getString("uinname");
                if (!TextUtils.isEmpty(string4)) {
                    string2 = string2.replace("[nick]", string4);
                } else if (!TextUtils.isEmpty(string3)) {
                    string2 = string2.replace("[nick]", string3);
                }
            }
            DialogUtil.createCustomDialog(this.mActivity, 230, string, string2, HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new a(i3, bundle), new b()).show();
            return;
        }
        if (this.f210605d != null) {
            this.f210605d.send(0, l(i3, bundle));
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(1);
            this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        String editString = this.mConfirmDialog.getEditString();
        this.mExtraData.putString("emsg", editString);
        if (this.f210606e > 0 && this.f210605d != null) {
            Bundle l3 = l(e.N3.intValue(), this.mExtraData);
            l3.putString("emsg", editString);
            this.f210605d.send(0, l3);
            if (this.f210607f > 0 && this.mActivity != null) {
                Intent intent = new Intent();
                intent.putExtras(this.mExtraData);
                this.mActivity.setResult(-1, intent);
                this.mActivity.finish();
            }
            if (m()) {
                ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "editsay.button", 0, 0, "", "", "", "");
                if (!TextUtils.isEmpty(editString) && !editString.equals(this.f210608h)) {
                    ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerconfirmpage.send", 0, 0, "", "", "", "");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (m()) {
            String stringExtra = this.mIntent.getStringExtra("choose_friend_dialog_sub_title");
            if (TextUtils.isEmpty(stringExtra)) {
                return HardCodeUtil.qqStr(R.string.mok);
            }
            return stringExtra;
        }
        return super.getDialogContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getEditHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (m()) {
            String stringExtra = this.mIntent.getStringExtra("choose_friend_dialog_input");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "\u7ed9TA\u7559\u8a00";
            }
            this.f210608h = stringExtra;
            return stringExtra;
        }
        return super.getEditHint();
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
                    if (recentUser.getType() == 0 && !Utils.J(recentUser.uin) && !Utils.I(recentUser.uin) && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()) && isSupportAbility(e.O3)) {
                        if (friendsManager != null && friendsManager.c0(recentUser.uin)) {
                            arrayList.add(recentUser);
                        }
                    } else if (recentUser.getType() != 1006 && ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || !this.mSurpportTroopDiscussionTmpConv)) {
                        if ((recentUser.getType() == 1 && isSupportAbility(e.P3)) || (recentUser.getType() == 3000 && isSupportAbility(e.Q3))) {
                            arrayList.add(recentUser);
                        }
                    } else if (isSupportAbility(e.O3)) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String stringExtra = this.mIntent.getStringExtra("choose_friend_title");
        if (TextUtils.isEmpty(stringExtra)) {
            return HardCodeUtil.qqStr(R.string.mon);
        }
        return stringExtra;
    }

    protected Bundle l(int i3, Bundle bundle) {
        TroopInfo B;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) bundle);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        ArrayList<String> arrayList5 = new ArrayList<>();
        ArrayList<Integer> arrayList6 = new ArrayList<>();
        ArrayList<Integer> arrayList7 = new ArrayList<>();
        if (bundle != null) {
            int i16 = bundle.getInt("uintype", -1);
            String str = "";
            if (i16 != 0 && i16 != 1004) {
                if (i16 == 1006) {
                    arrayList.add("");
                    arrayList2.add(bundle.getString("uin"));
                    arrayList3.add(bundle.getString("uinname"));
                } else if (i16 == 3000 || i16 == 1) {
                    String string = bundle.getString("uinname");
                    String string2 = bundle.getString("uin");
                    if (!TextUtils.isEmpty(string2)) {
                        int i17 = 0;
                        if (i16 == 1) {
                            arrayList7.add(4);
                            TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
                            if (troopManager != null && (B = troopManager.B(string2)) != null) {
                                i17 = B.wMemberNum;
                            }
                        } else if (i16 == 3000) {
                            arrayList7.add(8);
                            com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                            if (nVar != null) {
                                i17 = nVar.q(string2);
                                DiscussionInfo h16 = nVar.h(string2);
                                if (h16 != null) {
                                    string = h16.discussionName;
                                }
                            }
                        }
                        arrayList4.add(string2);
                        if (string != null) {
                            str = string;
                        }
                        arrayList5.add(str);
                        arrayList6.add(Integer.valueOf(i17));
                    }
                }
            } else {
                arrayList.add(bundle.getString("uin"));
                arrayList2.add("");
                arrayList3.add(bundle.getString("uinname"));
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("choose_friend_uins", arrayList);
        bundle2.putStringArrayList("choose_friend_phones", arrayList2);
        bundle2.putStringArrayList("choose_friend_names", arrayList3);
        if (arrayList4.size() > 0) {
            bundle2.putStringArrayList("choose_friend_group_uins", arrayList4);
            bundle2.putStringArrayList("choose_friend_group_names", arrayList5);
            bundle2.putIntegerArrayList("choose_friend_group_counts", arrayList6);
            bundle2.putIntegerArrayList("choose_friend_group_types", arrayList7);
        }
        return bundle2;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210605d = (ResultReceiver) this.mIntent.getParcelableExtra("choose_friend_callback");
        return true;
    }
}

package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class ForwardH5PTVOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ResultReceiver f210672d;

    public ForwardH5PTVOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
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
        this.mIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
        this.mIntent.getBooleanExtra("choose_friend_is_contacts", false);
        int intExtra = this.mIntent.getIntExtra("choose_friend_h5_type", 0);
        if (QLog.isColorLevel()) {
            QLog.d("h5ptv", 2, "bType=" + intExtra);
        }
        if (intExtra == 1 && allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (intExtra == 4) {
            this.mForwardAbilities.add(e.P3);
        }
        if (intExtra == 8) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (intExtra == 13) {
            this.mForwardAbilities.add(e.O3);
            this.mForwardAbilities.add(e.P3);
            this.mForwardAbilities.add(e.Q3);
        }
        if (intExtra == 12) {
            this.mForwardAbilities.add(e.P3);
            this.mForwardAbilities.add(e.Q3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int i16 = bundle.getInt("uintype", -1);
        if (i16 != 0 && i16 != 1004) {
            if (i16 == 1006) {
                arrayList.add("");
                arrayList2.add(bundle.getString("uin"));
                arrayList3.add(bundle.getString("uinname"));
                arrayList4.add("2");
            } else if (i16 == 1) {
                arrayList.add(bundle.getString("uin"));
                arrayList2.add("");
                arrayList3.add(bundle.getString("uinname"));
                arrayList4.add("4");
            } else if (i16 == 3000) {
                arrayList.add(bundle.getString("uin"));
                arrayList2.add("");
                arrayList3.add(bundle.getString("uinname"));
                arrayList4.add("8");
            }
        } else {
            arrayList.add(bundle.getString("uin"));
            arrayList2.add("");
            arrayList3.add(bundle.getString("uinname"));
            arrayList4.add("1");
        }
        if (this.f210672d != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("choose_friend_uins", arrayList);
            bundle2.putStringArrayList("choose_friend_phones", arrayList2);
            bundle2.putStringArrayList("choose_friend_names", arrayList3);
            bundle2.putStringArrayList("choose_friend_types", arrayList4);
            this.f210672d.send(0, bundle2);
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(1);
            this.mActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        int intExtra = this.mIntent.getIntExtra("choose_friend_h5_type", 0);
        for (RecentUser recentUser : list) {
            if (recentUser != null && (recentUser.getType() != 1006 || isSupportAbility(e.U3))) {
                if (recentUser.getType() != 9501 && recentUser.getType() != 6004 && recentUser.getType() != 7000) {
                    if (recentUser.getType() == 0 && !Utils.J(recentUser.uin) && !Utils.I(recentUser.uin) && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) {
                        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(recentUser.uin), "ForwardH5PTVOption") && (intExtra == 1 || intExtra == 13)) {
                            arrayList.add(recentUser);
                        }
                    } else if (recentUser.getType() == 1) {
                        if (intExtra == 4 || intExtra == 13 || intExtra == 12) {
                            arrayList.add(recentUser);
                        }
                    } else if (recentUser.getType() == 3000 && (intExtra == 8 || intExtra == 13 || intExtra == 12)) {
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
            return HardCodeUtil.qqStr(R.string.f172005mp4);
        }
        return stringExtra;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultiFriend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        this.f210672d = (ResultReceiver) this.mIntent.getParcelableExtra("choose_friend_callback");
        return true;
    }
}

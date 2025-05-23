package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardSelectContactOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardSelectContactOption(Intent intent) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int intExtra = this.mIntent.getIntExtra("acceptType", 13);
        if ((intExtra & 1) != 0 && allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if ((intExtra & 4) != 0 && allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if ((intExtra & 8) != 0 && allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            return;
        }
        if (this.mIntent.getIntExtra("openAIOForPtt", 0) != 1) {
            showProgressDialog(R.string.cpr);
            UiApiPlugin.J(this.mActivity, this.app, this.mIntent.getLongExtra("appid", -1L), new String[]{bundle.getString("uin")}, new int[]{bundle.getInt("uintype")});
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        this.mExtraData.putString("uin", bundle.getString("uin"));
        this.mExtraData.putInt("uintype", bundle.getInt("uintype"));
        this.mExtraData.putString("uinname", bundle.getString("uinname"));
        m3.putExtras(this.mExtraData);
        m3.putExtra("open_chat_from_voice_changer_guide", true);
        this.mActivity.startActivity(m3);
        this.mActivity.finish();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null) {
                if (Utils.J(recentUser.uin) || recentUser.getType() == 10004 || ((recentUser.getType() == 0 && CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) || ((recentUser.getType() != 0 || !isSupportAbility(e.O3)) && ((recentUser.getType() != 1 || isHotChat(recentUser.uin) || !isSupportAbility(e.P3)) && ((recentUser.getType() != 1006 || !isSupportAbility(e.U3)) && (recentUser.getType() != 3000 || !isSupportAbility(e.Q3))))))) {
                    if (recentUser.getType() == 1004 || recentUser.getType() == 1000) {
                        if (this.mSurpportTroopDiscussionTmpConv) {
                        }
                    }
                }
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }
}

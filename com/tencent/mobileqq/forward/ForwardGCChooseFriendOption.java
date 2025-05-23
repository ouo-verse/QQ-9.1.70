package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardGCChooseFriendOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final String f210664d;

    /* renamed from: e, reason: collision with root package name */
    private final String f210665e;

    public ForwardGCChooseFriendOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210664d = intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID);
        this.f210665e = intent.getStringExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC);
        intent.putExtra("is_need_show_toast", false);
    }

    private boolean l() {
        if (this.mIntent == null || TextUtils.isEmpty(this.f210664d) || !this.mIntent.getBooleanExtra(AppConstants.Key.KEY_GC_SHOW_GAME_FRIEND_ENTRANCE, false)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra(AppConstants.Key.KEY_GC_SHOW_TROOP_ENTRANCE, false);
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
        if (m() && allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (l()) {
            this.mForwardAbilities.add(e.f211018f4);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            return;
        }
        Intent intent = new Intent();
        Intent intent2 = this.mIntent;
        if (intent2 != null) {
            intent.putExtras(intent2);
        }
        intent.putExtras(bundle);
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(-1, intent);
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
        for (RecentUser recentUser : list) {
            if (recentUser.getType() == 0) {
                arrayList.add(recentUser);
            } else if (recentUser.getType() == 1 && m()) {
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean needSendMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onActivityCreated();
        if (this.mActivity instanceof ForwardRecentActivity) {
            ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).reportChooseFriendPageExpo(this.f210664d, l(), this.f210665e);
        }
        if (l()) {
            ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).requestFriendInfoFromSvr(this.f210664d);
        }
    }
}

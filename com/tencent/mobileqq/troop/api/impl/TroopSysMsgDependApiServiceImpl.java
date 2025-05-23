package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.widget.AnimationTextView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSysMsgDependApiServiceImpl implements ITroopSysMsgDependApiService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopSysMsgDependApiService";
    private AppRuntime app;

    public TroopSysMsgDependApiServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public TextView getAnimationTextInstance(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextView) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        return new AnimationTextView(context);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public void getFriendInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            ((FriendListHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(str));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public String getSubscriptName(AppRuntime appRuntime, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) context);
        }
        return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface) appRuntime, context);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public boolean isBrowserAppInterface(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return appRuntime instanceof BrowserAppInterface;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public boolean isQQAppInterface(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return appRuntime instanceof QQAppInterface;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
    public void openTroopProfile(Context context, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) bundle);
        } else {
            ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(context, bundle);
        }
    }
}

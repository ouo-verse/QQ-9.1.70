package com.tencent.mobileqq.addfriend.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendServiceApiImpl implements IAddFriendServiceApi {
    static IPatchRedirector $redirector_ = null;
    private static final String ADD_FRIEND_REQUEST_SP = "add_friend_request_sp";
    private static final long REQUEST_DISPLAY_DURATION = 500654080;
    private static final long REQUEST_MAYKNOW_DISPLAY_DURATION = 86400000;
    private static final long REQUEST_PHONECONTACT_DISPLAY_DURATION = 259200000;
    private SharedPreferences addFriendSp;
    AppInterface mApp;

    public AddFriendServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.addFriendSp = null;
        }
    }

    private SharedPreferences getAddFriendSp() {
        if (this.addFriendSp == null) {
            this.addFriendSp = this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + ADD_FRIEND_REQUEST_SP, 0);
        }
        return this.addFriendSp;
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi
    public boolean hasSendAddFriendReq(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? hasSendAddFriendReq(str, false) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (AppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setAddFriendReqStatus(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            getAddFriendSp().edit().putLong(str, System.currentTimeMillis()).commit();
        } else {
            if (getAddFriendSp().contains(str)) {
                getAddFriendSp().edit().remove(str).commit();
            }
            if (!z17) {
                ((FriendHandler) this.mApp.getBusinessHandler(FriendHandler.class.getName())).notifyUI(100, z16, str);
                return;
            }
            return;
        }
        z17 = true;
        if (!z17) {
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi
    public boolean hasSendAddFriendReq(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? hasSendAddFriendReq(str, z16, false) : ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16))).booleanValue();
    }

    @Override // com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi
    public boolean hasSendAddFriendReq(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long j3 = getAddFriendSp().getLong(str, 0L);
        if (j3 == 0 && str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            j3 = getAddFriendSp().getLong(str.replace(Marker.ANY_NON_NULL_MARKER, ""), 0L);
        }
        if (j3 == 0 && str.startsWith("+86")) {
            j3 = getAddFriendSp().getLong(str.replace("+86", ""), 0L);
        }
        if (j3 == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        long j16 = z16 ? 259200000L : REQUEST_DISPLAY_DURATION;
        if (z17) {
            j16 = 86400000;
        }
        if (currentTimeMillis > 0 && currentTimeMillis < j16) {
            return true;
        }
        getAddFriendSp().edit().remove(str).commit();
        return false;
    }
}

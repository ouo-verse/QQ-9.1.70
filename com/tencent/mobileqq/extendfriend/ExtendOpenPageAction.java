package com.tencent.mobileqq.extendfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.fragment.RealNameVerifiedFragment;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;

/* loaded from: classes12.dex */
public class ExtendOpenPageAction extends ax {
    static IPatchRedirector $redirector_;
    private Handler Q;

    public ExtendOpenPageAction(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this.f307437b, new Intent(), -1);
        return true;
    }

    private boolean G() {
        String str = this.f307441f.get("uin");
        int i3 = 3045;
        int i16 = 61;
        try {
            if (this.f307441f.containsKey("source_id")) {
                i3 = Integer.parseInt(this.f307441f.get("source_id"));
            }
            if (this.f307441f.containsKey("sub_source_id")) {
                i16 = Integer.parseInt(this.f307441f.get("sub_source_id"));
            }
        } catch (Exception e16) {
            QLog.e("expand.ExtendOpenPageAction", 1, e16, new Object[0]);
        }
        int i17 = i3;
        int i18 = i16;
        if (TextUtils.isEmpty(str)) {
            QLog.w("expand.ExtendOpenPageAction", 1, "gotoAddFriendPage uin is empty!");
            return false;
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f307437b, 1, str, "", i17, i18, "", "", null, "", ""));
        if ("graytip".equals(this.f307441f.get("from"))) {
            HashMap hashMap = new HashMap();
            hashMap.put("to_uid", str);
            hashMap.put(ServiceConst.PARA_SESSION_ID, ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).getSessionId(this.f307436a.getCurrentAccountUin(), str));
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#gray_tips_add_friend", true, hashMap);
        }
        return true;
    }

    private void H() {
        String str = this.f307441f.get("uin");
        ExpandUserInfo o16 = ((e) this.f307436a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).o(str, false);
        Intent intent = new Intent();
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 1044);
        if (o16 != null) {
            intent.putExtra("subId", ExpandUserInfo.fromTypeToSubID(o16.fromType));
            intent.putExtra(IExpandFragmentRouter.FROM_TYPE_CHAT, o16.fromType);
        }
        if (!(this.f307437b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(this.f307437b, intent, ChatSettingFragment.class);
    }

    private boolean I() {
        Intent intent = new Intent(this.f307437b, (Class<?>) InterestSwitchEditActivity.class);
        if (!(this.f307437b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean J() {
        JsonObject jsonObject = new JsonObject();
        for (String str : this.f307441f.keySet()) {
            jsonObject.addProperty(str, this.f307441f.get(str));
        }
        String str2 = this.f307441f.get("from");
        int i3 = 0;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        } else {
            try {
                i3 = Integer.parseInt(str2);
            } catch (NumberFormatException e16) {
                QLog.w("expand.ExtendOpenPageAction", 1, "gotoExpandChatList ", e16);
            }
        }
        ((IExpandEntrance) QRoute.api(IExpandEntrance.class)).enterExpandByJumpAction(this.f307437b, this.f307436a, IExpandEntrance.PAGE_CHAT_LIST, i3, jsonObject.toString());
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick(str2);
        return true;
    }

    private boolean K() {
        JsonObject jsonObject = new JsonObject();
        for (String str : this.f307441f.keySet()) {
            jsonObject.addProperty(str, this.f307441f.get(str));
        }
        String str2 = this.f307441f.get("from");
        int i3 = 0;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        } else {
            try {
                i3 = Integer.parseInt(str2);
            } catch (NumberFormatException e16) {
                QLog.w("expand.ExtendOpenPageAction", 1, "gotoExpandHome " + e16);
            }
        }
        ((IExpandEntrance) QRoute.api(IExpandEntrance.class)).enterExpandByJumpAction(this.f307437b, this.f307436a, IExpandEntrance.PAGE_MATCH_HOME, i3, jsonObject.toString());
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick(str2);
        return true;
    }

    private boolean L() {
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("fromPage");
        if (str2 == null || TextUtils.isEmpty(str2)) {
            str2 = Integer.toString(23);
        }
        ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).startExtendFriendCardOnClickAvatar(this.f307437b, str, Integer.parseInt(str2));
        return true;
    }

    private boolean M() {
        if (this.Q == null) {
            this.Q = new Handler(Looper.getMainLooper());
        }
        this.Q.post(new Runnable() { // from class: com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExtendOpenPageAction.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    String str = ExtendOpenPageAction.this.f307441f.get("uin");
                    NewReportPlugin.S((QBaseActivity) ExtendOpenPageAction.this.f307437b, str, NewReportPlugin.j(str, NewReportPlugin.p(2)), "0", null, ExtendOpenPageAction.this.f307436a.getCurrentAccountUin(), 20005, null, new Bundle());
                }
            }
        });
        return true;
    }

    private boolean N(String str) {
        Intent intent = new Intent();
        intent.putExtra("scene", str);
        QPublicFragmentActivity.start(this.f307437b, intent, RealNameVerifiedFragment.class);
        Context context = this.f307437b;
        if (context instanceof Activity) {
            ((Activity) context).finish();
            return true;
        }
        return true;
    }

    private boolean O() {
        if (this.Q == null) {
            this.Q = new Handler(Looper.getMainLooper());
        }
        this.Q.post(new Runnable() { // from class: com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExtendOpenPageAction.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("expand.ExtendOpenPageAction", 2, "gotoSafetyReport, thread:" + Thread.currentThread().getName());
                String str = ExtendOpenPageAction.this.f307441f.get("uin");
                ExtendOpenPageAction extendOpenPageAction = ExtendOpenPageAction.this;
                NewReportPlugin.U((QBaseActivity) extendOpenPageAction.f307437b, 1044, str, extendOpenPageAction.f307436a.getCurrentAccountUin());
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        QLog.d("expand.ExtendOpenPageAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        try {
            String str = this.f307441f.get("page");
            if ("profile".equals(str)) {
                return L();
            }
            if ("accountsafe".equals(str)) {
                return F();
            }
            if ("safetyreport".equals(str)) {
                return O();
            }
            if ("chatsetting".equals(str)) {
                H();
                return false;
            }
            if ("home".equals(str)) {
                return K();
            }
            if ("displaySetting".equals(str)) {
                return I();
            }
            if ("addfriend".equals(str)) {
                return G();
            }
            if ("profilereport".equals(str)) {
                return M();
            }
            if ("chatlist".equals(str)) {
                return J();
            }
            if (!"verified".equals(str)) {
                return false;
            }
            return N(this.f307441f.get("scene"));
        } catch (Exception e16) {
            QLog.e("expand.ExtendOpenPageAction", 1, "doAction error: " + e16.getMessage());
            i("expand.ExtendOpenPageAction");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            super.i(str);
        }
    }
}

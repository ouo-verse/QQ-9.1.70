package com.tencent.mobileqq.subaccount.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.h;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountControllUtilImpl implements ISubAccountControllUtil {
    static IPatchRedirector $redirector_;

    public SubAccountControllUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void bindRecentItem(AppInterface appInterface, ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            h.c(appInterface, arrayList, i3);
        } else {
            iPatchRedirector.redirect((short) 4, this, appInterface, arrayList, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public Pair<Boolean, Boolean> checkSubAccountLoginStatus(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface, (Object) str);
        }
        return h.d(appInterface, str);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void cleanAllSubAccountMessageUnread(AppInterface appInterface, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, appInterface, Boolean.valueOf(z16), str);
        } else {
            h.e(appInterface, z16, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean cleanAllThirdQQUnreadMsgNum(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) appInterface)).booleanValue();
        }
        return h.f(appInterface);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void cleanOneSubAccountMessageUnread(AppInterface appInterface, boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, appInterface, Boolean.valueOf(z16), str, str2);
        } else {
            h.g(appInterface, z16, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void cleanReqSubAccountSpecialCareListSysTime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) appInterface);
        } else {
            h.h(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean cleanThirdQQUnreadMsgNum(AppInterface appInterface, SimpleAccount simpleAccount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) appInterface, (Object) simpleAccount)).booleanValue();
        }
        return h.i(appInterface, simpleAccount);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void clearAllData(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h.j(appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void clearSubAccountAssistantTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            SubAccountAssistantUtil.f291050a.i(-1L);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public int getAllSubAccountMsgUnreadNum(AppInterface appInterface, IConversationFacade iConversationFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInterface, (Object) iConversationFacade)).intValue();
        }
        return h.m(appInterface, iConversationFacade);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public int getAllSubAccountTroopMsgUnreadNum(AppInterface appInterface, IConversationFacade iConversationFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) appInterface, (Object) iConversationFacade)).intValue();
        }
        return h.n(appInterface, iConversationFacade);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public int getAllThirdQQMsgUnreadLastTime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) appInterface)).intValue();
        }
        return h.o(appInterface);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public int getLocalThirdUnreadMsgNum(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInterface, (Object) str)).intValue();
        }
        return h.s(appInterface, str);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public RecentContactData getRecentContactData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RecentContactData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return SubAccountAssistantUtil.f291050a.d();
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public String getShowName(AppInterface appInterface, SimpleAccount simpleAccount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this, (Object) appInterface, (Object) simpleAccount);
        }
        return h.u(appInterface, simpleAccount);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void getSubAccountSpecialCareListFromService(AppInterface appInterface, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, appInterface, Boolean.valueOf(z16), str);
        } else {
            h.w(appInterface, z16, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public ISubAccountControlService.a getUnreadCount(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (ISubAccountControlService.a) iPatchRedirector.redirect((short) 35, (Object) this, (Object) appInterface, (Object) str);
        }
        return h.y(appInterface, str);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void initAllData(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface);
        } else {
            h.z(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean isAnyAccountBind(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface)).booleanValue();
        }
        return h.A(appInterface);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean isHeadIconLongClickFunc(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, appInterface, Boolean.valueOf(z16))).booleanValue();
        }
        return h.C(appInterface, z16);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean isRemoveSubUnreadConversationDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return SubAccountAssistantUtil.f291050a.g();
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean isThirdAccountDisplayFunc(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, this, appInterface, Boolean.valueOf(z16))).booleanValue();
        }
        return h.E(appInterface, z16);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean loadServerMessage(AppInterface appInterface, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, appInterface, str, Boolean.valueOf(z16))).booleanValue();
        }
        return h.G(appInterface, str, z16);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean needShowHintDialog(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return h.H(appInterface, str);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void onTimeFormatChange(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h.I(appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void setBindUinStatus(AppInterface appInterface, byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            h.J(appInterface, b16, str);
        } else {
            iPatchRedirector.redirect((short) 11, this, appInterface, Byte.valueOf(b16), str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void setDisplayThirdQQChecked(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, appInterface, Boolean.valueOf(z16));
        } else {
            h.L(appInterface, z16);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void setRecentItemSubAccountContentAndUnread(AppInterface appInterface, Context context, RecentItemSubAccount recentItemSubAccount, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appInterface, context, recentItemSubAccount, msgSummary);
        } else {
            h.M(appInterface, context, recentItemSubAccount, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void setTopInRecentList(AppInterface appInterface, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appInterface, str, Boolean.valueOf(z16));
        } else {
            h.N(appInterface, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void showMaxHintDialog(AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime, (Object) qBaseActivity);
        } else {
            h.O(appRuntime, qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean startGetThirdQQUnreadNum(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, appInterface, Boolean.valueOf(z16))).booleanValue();
        }
        return h.P(appInterface, z16);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void unbindAllRecentItem(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appInterface, i3);
        } else {
            h.R(appInterface, i3);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void unbindRecentItem(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h.S(appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public boolean updateAllThirdQQMsgUnreadLastTime(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) appInterface, i3)).booleanValue();
        }
        return h.T(appInterface, i3);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void bindRecentItem(AppInterface appInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            h.b(appInterface, str, i3);
        } else {
            iPatchRedirector.redirect((short) 5, this, appInterface, str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
    public void setBindUinStatus(AppInterface appInterface, byte b16, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            h.K(appInterface, b16, arrayList);
        } else {
            iPatchRedirector.redirect((short) 12, this, appInterface, Byte.valueOf(b16), arrayList);
        }
    }
}

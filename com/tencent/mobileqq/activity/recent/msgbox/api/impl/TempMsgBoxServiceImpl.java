package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxHandler;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.b;
import com.tencent.mobileqq.activity.recent.msgbox.c;
import com.tencent.mobileqq.activity.recent.msgbox.i;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TempMsgBoxServiceImpl implements ITempMsgBoxService {
    static IPatchRedirector $redirector_;

    public TempMsgBoxServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public void addNicknameToVideoMsg(int i3, String str, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, msgSummary);
        } else {
            i.a(i3, str, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public int getAllFilterMsgUnreadNumOfQCall(AppInterface appInterface, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) message)).intValue();
        }
        return b.a(appInterface, message);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public HashMap<String, com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b> getBusinessHandlerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return i.b();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public Map<Integer, String> getBusinessStringMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return i.c();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public c getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (c) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return i.f185697a;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public List<RecentUser> getFilterBoxRecentUsers(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
        return b.b(appInterface);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public String getFilterMsgBoxHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return FilterMsgBoxHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public Map<Integer, Integer> getServiceIdMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return i.e();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public Map<Integer, Integer> getSummaryTextMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return i.f();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public int getTempMsgBoxUnread(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface)).intValue();
        }
        return i.g(appInterface);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public int getTempSettingStatus(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        return i.h(z16, z17);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public ArrayList<Integer> getTempUinTypeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TempChatPluginManagerImpl.getTempUinTypeList();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public String getTitleName(AppInterface appInterface, RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface, (Object) recentUser);
        }
        return i.i(appInterface, recentUser);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public long getUpdateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return b.d();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public ConversationInfo onGetUnreadCount(ConversationInfo conversationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) conversationInfo);
        }
        return i.k(conversationInfo);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public void removeFilterBoxIfNecessary(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appInterface, Boolean.valueOf(z16));
        } else {
            b.e(appInterface, z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public void removeMsgBoxIfNecessary(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, appInterface, Boolean.valueOf(z16));
        } else {
            i.m(appInterface, z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public void reportTempMsgBoxExposure(AppInterface appInterface, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) appInterface, obj);
        } else {
            i.n(appInterface, obj);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
    public void saveUpdateTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            b.f(j3);
        }
    }
}

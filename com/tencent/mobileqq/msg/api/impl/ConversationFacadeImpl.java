package com.tencent.mobileqq.msg.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ConversationFacadeImpl implements IConversationFacade {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ConversationFacadeImpl";
    private QQAppInterface mApp;

    public ConversationFacadeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void addNewSayHelloToSet(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) str);
        } else {
            this.mApp.getConversationFacade().e(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void addUnread(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
        } else {
            this.mApp.getConversationFacade().g(list);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void cleanUnread(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            this.mApp.getConversationFacade().o(str, i3, j3, z16);
        } else {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void cleanUnreadFrom(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.mApp.getConversationFacade().s(str, i3, j3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void decreaseUnread(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), messageRecord);
        } else {
            this.mApp.getConversationFacade().w(str, i3, messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void decreaseUnreads(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), list);
        } else {
            this.mApp.getConversationFacade().x(str, i3, list);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public ConversationInfo getConversationInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, i3);
        }
        return this.mApp.getConversationFacade().y(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public Set<ConversationInfo> getConversationInfoSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mApp.getConversationFacade().z();
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public long getLastRead(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, i3)).longValue();
        }
        return this.mApp.getConversationFacade().C(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getPublicAccountConversationRedMask(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mApp.getConversationFacade().F(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getReadUnreadCount(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mApp.getConversationFacade().H(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getReadUnreadMark(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mApp.getConversationFacade().J(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public ConversationInfo getTinyConvInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (ConversationInfo) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, i3);
        }
        return this.mApp.getConversationFacade().P(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public GroupMsgMask getTroopMask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (GroupMsgMask) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        return this.mApp.getTroopMask(str);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getUnreadCount(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mApp.getConversationFacade().R(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getUnreadCountConfess(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return this.mApp.getConversationFacade().S(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public int getUnreadCountFromExtInt2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, i3)).intValue();
        }
        return this.mApp.getConversationFacade().U(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void increaseUnread(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public boolean isInMsgBox(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.mApp.getConversationFacade().g0(str, i3, str2) : ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public boolean isSyncMsgFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        Automator automator = this.mApp.mAutomator;
        if (automator != null && automator.H2()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public boolean isUinInRecentList(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3)).booleanValue();
        }
        return this.mApp.getConversationFacade().i0(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public boolean isUinInRecentNotSubAccount(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        return this.mApp.getConversationFacade().j0(str);
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void moveBoxToMessageTab(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
        } else {
            this.mApp.getConversationFacade().k0(str, i3, str2, i16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = "ConversationFacadeImpl onCreate: app instanceOf QQApp: ";
            objArr[1] = Boolean.valueOf(appRuntime instanceof QQAppInterface);
            objArr[2] = "app is null: ";
            if (appRuntime == null) {
                z16 = true;
            }
            objArr[3] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void removeUnreadItem(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, i3);
        } else {
            this.mApp.getConversationFacade().n0(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void setSubAccountTroopUnReadMsg(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void setUnreadMark(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mApp.getConversationFacade().s0(str, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void updateLastRead(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.mApp.getConversationFacade().t0(str, i3, j3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void updateTroopGuildUnreadCount(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mApp.getConversationFacade().w0(str, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void cleanUnread(String str, int i3, long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.mApp.getConversationFacade().p(str, i3, j3, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public boolean isInMsgBox(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.mApp.getConversationFacade().f0(str, i3) : ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, i3)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msg.api.IConversationFacade
    public void cleanUnread(String str, int i3, long j3, boolean z16, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.mApp.getConversationFacade().q(str, i3, j3, z16, z17, i16);
        } else {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
        }
    }
}

package com.tencent.imcore.message;

import com.tencent.mobileqq.app.msgnotify.MsgCacheInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Message extends MessageRecord {
    static IPatchRedirector $redirector_;
    public String actMsgContentValue;
    public String action;
    public int bizType;
    public int counter;
    public CharSequence emoRecentMsg;
    public long fileSize;
    public int fileType;
    public boolean hasReply;

    @notColumn
    public boolean isCacheValid;

    @notColumn
    public boolean isFromLS;
    public MessageRecord lastMsg;
    public ArrayList<MsgCacheInfo> msgInfoList;
    public String nickName;

    @notColumn
    public CharSequence prefixOfNickname;
    public String pttUrl;
    public long shareAppID;

    @Deprecated
    public int unReadNum;

    public Message() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.counter = 0;
        this.fileType = -1;
        this.action = null;
        this.fileSize = -1L;
        this.nickName = null;
        this.isCacheValid = true;
        this.bizType = -1;
    }

    public void cleanMessageRecordBaseField() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f203106msg = null;
        this.emoRecentMsg = null;
        this.fileType = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return Message.class;
    }

    public CharSequence getMessageText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CharSequence charSequence = this.emoRecentMsg;
        if (charSequence == null) {
            return this.f203106msg;
        }
        return charSequence;
    }

    public boolean needNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = this.bizType;
        if (i3 != 25 && i3 != 18 && i3 != 17 && i3 != 5 && i3 != 14 && i3 != 27 && i3 != 4 && i3 != 15 && i3 != 13) {
            return false;
        }
        return true;
    }
}

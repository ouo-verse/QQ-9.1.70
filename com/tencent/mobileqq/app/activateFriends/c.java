package com.tencent.mobileqq.app.activateFriends;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated(since = "\u7981\u6b62\u4f7f\u7528\uff0c\u4e0b\u67b6\u8fc7\u7a0b\uff0c\u9002\u914d\u4ee3\u7801")
/* loaded from: classes11.dex */
abstract class c<T> extends ChatMessage implements com.tencent.mobileqq.reminder.db.c<T> {
    static IPatchRedirector $redirector_;
    private T mMsgBody;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public final void doParse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            this.mMsgBody = createMsgBody();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseDeprecatedForRecord", 2, "Message parse error.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getExtLong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.extLong;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getExtStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.extStr;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getFrienduin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.frienduin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final boolean getIsread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isread;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getIstroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.istroop;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final JSONObject getMExJsonObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (JSONObject) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mExJsonObject;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f203106msg;
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    public final T getMsgBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.mMsgBody == null && !this.mIsParsed) {
            parse();
        }
        return this.mMsgBody;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final byte[] getMsgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.msgData;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getMsgtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.msgtype;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @NonNull
    public final String getSelfuin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.selfuin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getSenderuin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.senderuin;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final long getUniseq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.uniseq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public final void postwrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public final void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public final void setExtLong(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.extLong = i3;
        }
    }

    public final void setExtStr(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.extStr = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setFrienduin(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.frienduin = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setIsread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.isread = z16;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setIstroop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.istroop = i3;
        }
    }

    public final void setMExJsonObject(@Nullable JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) jSONObject);
        } else {
            this.mExJsonObject = jSONObject;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsg(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.f203106msg = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    public final void setMsgBody(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) t16);
        } else {
            this.mMsgBody = t16;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsgData(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bArr);
        } else {
            this.msgData = bArr;
        }
    }

    public final void setMsgtype(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.msgtype = i3;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setSelfuin(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.selfuin = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setSenderuin(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.senderuin = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.time = j3;
        }
    }

    public final void setUniseq(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.uniseq = j3;
        }
    }
}

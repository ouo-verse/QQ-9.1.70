package com.tencent.mobileqq.reminder.db.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,senderuin,msgData,istroop,shmsgseq,msgseq")
/* loaded from: classes18.dex */
public class ReminderRecord extends Entity implements com.tencent.mobileqq.reminder.db.b {
    static IPatchRedirector $redirector_;

    @Deprecated
    public int extInt;
    public int extLong;
    public String extStr;

    @Deprecated
    public int extraflag;
    public String frienduin;

    @Deprecated
    public boolean isValid;
    public boolean isread;
    public int issend;
    public int istroop;
    public int longMsgCount;
    public int longMsgId;
    public int longMsgIndex;
    public JSONObject mExJsonObject;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public String f281037msg;
    public byte[] msgData;
    public long msgId;
    public long msgUid;
    public long msgseq;
    public int msgtype;
    public String selfuin;
    public int sendFailCode;
    public String senderuin;
    public long shmsgseq;
    public long time;
    public long uniseq;
    public int versionCode;
    public long vipBubbleID;

    public ReminderRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isValid = true;
        this.versionCode = 3;
        createMessageUniseq();
    }

    private void createMessageUniseq() {
        long j3 = (int) this.time;
        this.uniseq = j3;
        if (j3 == 0) {
            this.uniseq = (int) (System.currentTimeMillis() / 1000);
        }
        this.uniseq = (this.uniseq << 32) | Math.abs(new Random().nextInt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public final Class<? extends Entity> getClassForTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ReminderRecord.class;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public String getExtInfoFromExtStr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if ((this.extLong & 1) != 1 || TextUtils.isEmpty(this.extStr)) {
            return "";
        }
        try {
            if (this.mExJsonObject == null) {
                this.mExJsonObject = new JSONObject(this.extStr);
            }
            if (!this.mExJsonObject.has(str)) {
                return "";
            }
            return this.mExJsonObject.getString(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageRecord", 2, e16.getMessage(), e16);
            }
            return "";
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getExtLong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.extLong;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final String getExtStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (JSONObject) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mExJsonObject;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f281037msg;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    @Nullable
    public final byte[] getMsgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.msgData;
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final int getMsgtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
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

    @Override // com.tencent.mobileqq.persistence.Entity
    public final String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return ReminderRecordKtKt.a();
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public long getTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.time;
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
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            byte[] bArr = this.msgData;
            if (bArr != null) {
                this.f281037msg = new String(bArr, "UTF-8");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageRecord", 2, e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String str = this.f281037msg;
        if (str != null && str != null) {
            try {
                this.msgData = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessageRecord", 2, e16.getMessage(), e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public void saveExtInfoToExtStr(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            if (TextUtils.isEmpty(this.extStr)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, str2);
                this.extStr = jSONObject.toString();
                this.mExJsonObject = jSONObject;
            } else {
                JSONObject jSONObject2 = new JSONObject(this.extStr);
                jSONObject2.put(str, str2);
                this.extStr = jSONObject2.toString();
                this.mExJsonObject = jSONObject2;
            }
            this.extLong |= 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageRecord", 2, e16.getMessage(), e16);
            }
        }
    }

    public final void setExtLong(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.extLong = i3;
        }
    }

    public final void setExtStr(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) jSONObject);
        } else {
            this.mExJsonObject = jSONObject;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsg(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.f281037msg = str;
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.b
    public final void setMsgData(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bArr);
        } else {
            this.msgData = bArr;
        }
    }

    public final void setMsgtype(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
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

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return "ReminderRecord{frienduin='" + this.frienduin + "', istroop=" + this.istroop + "time=" + this.time + ", uniseq=" + this.uniseq + ", msg='" + this.f281037msg + "', msgseq=" + this.msgseq + '}';
    }
}

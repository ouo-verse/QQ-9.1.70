package com.tencent.mobileqq.fts.data.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FTSMessage extends FTSEntity {
    static IPatchRedirector $redirector_ = null;
    public static final int FTS_TYPE_MSG_2 = 1;
    private static final String TAG = "Q.fts.FTSMessage";
    public int friendIndex;
    public int friendNum;
    public int istroop;
    public CharSequence matchSecondTitle;
    public CharSequence matchTitle;
    public long msgCounter;
    public MsgExts msgExts;
    public int msgtype;
    public int searchStrategy;
    public int senderNum;
    public String senderuin;
    public long uin;

    public FTSMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.searchStrategy = -1;
        this.senderNum = -1;
        this.friendNum = -1;
        this.friendIndex = -1;
        this.msgCounter = 0L;
    }

    public static String getExt1(long j3, int i3) {
        return String.valueOf(j3) + "ZzZ" + String.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    public String createDeleteSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'type:");
            sb5.append(this.mType);
            if (this.mOId != Long.MIN_VALUE) {
                sb5.append(" oid:");
                sb5.append(this.mOId);
            }
            sb5.append(" ext1:");
            sb5.append(getExt1(this.uin, this.istroop));
            sb5.append("';");
            if (QLog.isColorLevel()) {
                if (this.mOId != Long.MIN_VALUE) {
                    if (!TextUtils.isEmpty(this.mContent)) {
                        QLog.i(TAG, 2, "FTS delete\uff1aFTSMessage Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + ", msgType = " + this.mExt3 + ", senderUin = " + this.mExt2 + ", msg|size = " + this.mContent.charAt(0) + "|" + this.mContent.length() + "]");
                    } else {
                        QLog.i(TAG, 2, "FTS delete\uff1aFTSMessage Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + ", msgType = " + this.mExt3 + ", senderUin = " + this.mExt2 + "]");
                    }
                } else {
                    QLog.i(TAG, 2, "FTS delete\uff1aFTSTable Info [oId = " + this.mOId + ", selfUin&istroop = " + this.mExt1 + "]");
                }
            }
            return sb5.toString();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "createDeleteSQL failure: ", th5);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    public String createInsertSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return String.format("FTSMessage Info [oId = %d, selfUin&istroop = %s, msgType = %s, senderUin = %s, msg|size = %s]", Long.valueOf(this.mOId), this.mExt1, this.mExt3, this.mExt2, aw.a(this.mContent));
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    public String createUpdateSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return createDeleteSQL();
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    protected void doDeserialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int indexOf = this.mExt1.indexOf("ZzZ");
        if (indexOf == -1) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "doDeserialize: failure, ext1 not valid");
                return;
            }
            return;
        }
        try {
            this.uin = Long.parseLong(this.mExt1.substring(0, indexOf));
            this.istroop = Integer.parseInt(this.mExt1.substring(indexOf + 3));
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "doDeserialize: failure", e16);
            }
        }
        try {
            this.senderuin = this.mExt2;
            this.msgtype = Integer.parseInt(this.mExt3);
            byte[] bArr = this.mExts;
            if (bArr != null && bArr.length > 0) {
                this.msgExts = (MsgExts) MsgExts.unserialize(bArr, 1);
            } else {
                this.msgExts = null;
            }
            if (!TextUtils.isEmpty(this.mExt4)) {
                this.msgCounter = Long.parseLong(this.mExt4);
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, "FTSMessage doDeserialize e:", e17.toString());
        }
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    protected void doSerialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mExt1 = getExt1(this.uin, this.istroop);
        this.mExt2 = this.senderuin;
        this.mExt3 = String.valueOf(this.msgtype);
        MsgExts msgExts = this.msgExts;
        if (msgExts != null) {
            this.mExts = MsgExts.serialize(msgExts, 1);
        } else {
            this.msgExts = null;
        }
        this.mExt4 = String.valueOf(this.msgCounter);
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "IndexContent";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "FTSMessage{uin=" + this.uin + ", istroop=" + this.istroop + ", senderuin='" + this.senderuin + ", msgtype=" + this.msgtype + ", proximity=" + this.mProximity + ", msgExts=" + this.msgExts + '}';
    }

    @Override // com.tencent.mobileqq.fts.v1.FTSEntity
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    public FTSMessage(int i3, String str, long j3, String str2, String str3, String str4, byte[] bArr) {
        super(i3, str, j3, str2, str3, str4, bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, str3, str4, bArr);
            return;
        }
        this.searchStrategy = -1;
        this.senderNum = -1;
        this.friendNum = -1;
        this.friendIndex = -1;
        this.msgCounter = 0L;
    }

    public FTSMessage(int i3, int i16, int i17, int i18, String str, long j3, String str2, String str3, String str4, byte[] bArr) {
        super(i3, i16, i17, i18, str, j3, str2, str3, str4, bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str, Long.valueOf(j3), str2, str3, str4, bArr);
            return;
        }
        this.searchStrategy = -1;
        this.senderNum = -1;
        this.friendNum = -1;
        this.friendIndex = -1;
        this.msgCounter = 0L;
    }

    public FTSMessage(int i3, int i16, int i17, int i18, String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, byte[] bArr) {
        super(i3, i16, i17, i18, str, j3, str2, str3, str4, str5, str6, str7, str8, str9, str10, bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str, Long.valueOf(j3), str2, str3, str4, str5, str6, str7, str8, str9, str10, bArr);
            return;
        }
        this.searchStrategy = -1;
        this.senderNum = -1;
        this.friendNum = -1;
        this.friendIndex = -1;
        this.msgCounter = 0L;
    }
}

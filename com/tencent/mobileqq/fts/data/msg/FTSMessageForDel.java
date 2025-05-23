package com.tencent.mobileqq.fts.data.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FTSMessageForDel extends FTSMessage {
    static IPatchRedirector $redirector_ = null;
    public static final int MODE_DEL_ALL = 3;
    public static final int MODE_DEL_ENTIRE_CONTENT = 4;
    public static final int MODE_DEL_ONE = 1;
    public static final int MODE_DEL_PATCH = 2;
    private static final String TAG = "FTSMessageForDel";
    public String mExt1Key;
    private ArrayList<String> mOIdList;
    public int mode;

    public FTSMessageForDel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mOIdList = new ArrayList<>(30);
            this.mode = 1;
        }
    }

    private String createDelForEntire() {
        try {
            return new StringBuilder("DELETE FROM IndexContent;").toString();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "createDeleteSQL failure: ", th5);
                return null;
            }
            return null;
        }
    }

    private String createDelForOne() {
        try {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext1:");
            sb5.append(this.mExt1Key);
            sb5.append(" oid:");
            for (int i3 = 0; i3 < this.mOIdList.size(); i3++) {
                if (i3 > 0) {
                    sb5.append(" OR ");
                }
                sb5.append(this.mOIdList.get(i3));
            }
            sb5.append("';");
            return sb5.toString();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "createDeleteSQL failure: ", th5);
                return null;
            }
            return null;
        }
    }

    private String createDelForPatch() {
        StringBuilder sb5 = new StringBuilder(50);
        String ext1 = FTSMessage.getExt1(this.uin, this.istroop);
        sb5.append("DELETE FROM IndexContent WHERE IndexContent MATCH 'ext4:");
        sb5.append(this.msgCounter);
        sb5.append(" ext1:");
        sb5.append(ext1);
        sb5.append("';");
        return sb5.toString();
    }

    public void appendOId(FTSMessageDelete fTSMessageDelete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fTSMessageDelete);
        } else {
            this.mOIdList.add(String.valueOf(fTSMessageDelete.mOId));
        }
    }

    @Override // com.tencent.mobileqq.fts.data.msg.FTSMessage, com.tencent.mobileqq.fts.v1.FTSEntity
    public String createDeleteSQL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int i3 = this.mode;
        if (i3 == 2) {
            return createDelForPatch();
        }
        if (i3 == 4) {
            return createDelForEntire();
        }
        return createDelForOne();
    }
}

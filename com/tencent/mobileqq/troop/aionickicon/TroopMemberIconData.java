package com.tencent.mobileqq.troop.aionickicon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.nt_im_msg_general_flags_body$MsgIcon;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "memberUin")
/* loaded from: classes19.dex */
public class TroopMemberIconData extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopMemberIconData";

    @unique
    public String memberUin;
    public byte[] nickIconBytes;

    public TroopMemberIconData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.memberUin = "";
            this.nickIconBytes = null;
        }
    }

    public nt_im_msg_general_flags_body$MsgIcon getMsgIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (nt_im_msg_general_flags_body$MsgIcon) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        byte[] bArr = this.nickIconBytes;
        if (bArr != null && bArr.length != 0) {
            try {
                return (nt_im_msg_general_flags_body$MsgIcon) MessageMicro.mergeFrom(new nt_im_msg_general_flags_body$MsgIcon(), this.nickIconBytes);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[getMsgIcon] exception = " + e16);
            }
        }
        return null;
    }
}

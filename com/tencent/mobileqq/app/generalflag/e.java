package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16, generalflags$ResvAttr generalflags_resvattr) {
        byte[] bArr;
        if ((messageRecord instanceof ChatMessage) && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(KplRoleInfo.MSG_EXT_KEY))) {
            try {
                String gameNickByUin = KplHelper.getGameNickByUin(qQAppInterface, messageRecord.selfuin);
                String gameNickByUin2 = KplHelper.getGameNickByUin(qQAppInterface, messageRecord.frienduin);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(messageRecord.selfuin, gameNickByUin);
                jSONObject.put(messageRecord.frienduin, gameNickByUin2);
                String jSONObject2 = jSONObject.toString();
                if (QLog.isColorLevel()) {
                    QLog.d(KplRoleInfo.KPL_TAG, 2, "general kpl flag=" + jSONObject2);
                }
                bArr = jSONObject2.getBytes("utf-8");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(KplRoleInfo.KPL_TAG, 2, "some error at MessageHandlerUtils::getGeneralFlagElemFromMsg()");
                }
                e16.printStackTrace();
                bArr = null;
            }
            if (bArr != null) {
                generalflags_resvattr.bytes_kpl_info.set(ByteStringMicro.copyFrom(bArr));
                return true;
            }
            return z16;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        return new boolean[]{z16, a((QQAppInterface) appInterface, messageRecord, z17, generalflags_resvattr)};
    }
}

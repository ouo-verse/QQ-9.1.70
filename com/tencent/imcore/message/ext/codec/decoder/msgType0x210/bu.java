package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bu implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xce push message ");
        }
        submsgtype0xce$MsgBody submsgtype0xce_msgbody = new submsgtype0xce$MsgBody();
        try {
            submsgtype0xce_msgbody.mergeFrom(msgType0x210.vProtobuf);
            String str = submsgtype0xce_msgbody.string_params.get();
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "yuyue(push):OnLinePushMessageProcessor receive 0xce strJson=" + str);
            }
            String optString = new JSONObject(str).optString("appid");
            String[] split = GameCenterSpUtils.readFromSp("QQGAME_DOWNLOAD_LIST").split("\\|");
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 < split.length) {
                    if (!TextUtils.isEmpty(split[i3]) && !TextUtils.isEmpty(optString) && split[i3].equals(optString)) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (!z16 && !TextUtils.isEmpty(optString)) {
                GameCenterUtil.addAppidToList(optString, "QQGAME_LIST");
                GameCenterUtil.saveAppDetail(optString, str, "QQGAME_APPID_DETAIL_");
                GameCenterBroadcastReceiver.c();
            }
            ((IQQGameCheckService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter(4);
            hl0.a.b(qQAppInterface, "426", "202136", optString, "42601", "1", "116");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}

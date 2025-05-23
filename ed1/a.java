package ed1;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.data.e;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n;
import com.tencent.mobileqq.service.message.p;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements n {
    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        AppInterface appInterface;
        IQQGameCheckService iQQGameCheckService;
        IQQGameCheckService iQQGameCheckService2;
        IQQGameCheckService iQQGameCheckService3;
        IQQGameCheckService iQQGameCheckService4;
        IQQGameFullScreenNoticeService iQQGameFullScreenNoticeService;
        QLog.i("GameMsgOfflineDecoder", 1, "GameMsg, OFFLINE SubType0x11c receive");
        MsgBody msgBody = new MsgBody();
        try {
            msgBody.mergeFrom(msg_comm_msgtype0x210.msg_content.get().toByteArray());
            int i3 = msgBody.uint32_cmd.get();
            msgBody.uint32_timestamp.get();
            String stringUtf8 = msgBody.bytes_data.get().toStringUtf8();
            JSONObject jSONObject = new JSONObject(stringUtf8);
            long j3 = msg_comm_msg.msg_head.get().msg_uid.get();
            msg_comm_msg.msg_head.get().msg_time.get();
            QLog.i("GameMsgOfflineDecoder", 1, "cmd:" + i3);
            if (i3 == 5) {
                e.g(messageHandler.Q, jSONObject, j3);
            } else if (i3 == 8) {
                ((IGameMsgManagerService) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IGameMsgManagerService.class, "all")).onGameSwitchChange(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID), jSONObject.optInt("switchType"), jSONObject.optInt("value"));
            } else if (i3 == 13) {
                AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface2 != null && (iQQGameFullScreenNoticeService = (IQQGameFullScreenNoticeService) appInterface2.getRuntimeService(IQQGameFullScreenNoticeService.class, "")) != null) {
                    iQQGameFullScreenNoticeService.onFullScreenPushReceived(jSONObject);
                }
            } else if (i3 == 1) {
                AppInterface appInterface3 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface3 != null && (iQQGameCheckService4 = (IQQGameCheckService) appInterface3.getRuntimeService(IQQGameCheckService.class, "")) != null) {
                    iQQGameCheckService4.handlePreDownloadPush(stringUtf8, "offlineMsg");
                }
            } else if (i3 != 16) {
                if (i3 == 17) {
                    AppInterface appInterface4 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface4 != null && (iQQGameCheckService3 = (IQQGameCheckService) appInterface4.getRuntimeService(IQQGameCheckService.class, "")) != null) {
                        iQQGameCheckService3.handlePreUpdatePush(stringUtf8, "offlineMsg");
                    }
                } else if (i3 == 22) {
                    AppInterface appInterface5 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface5 != null && (iQQGameCheckService2 = (IQQGameCheckService) appInterface5.getRuntimeService(IQQGameCheckService.class, "")) != null) {
                        iQQGameCheckService2.handlePreImitatePush(stringUtf8);
                    }
                } else if (i3 == 23 && (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && (iQQGameCheckService = (IQQGameCheckService) appInterface.getRuntimeService(IQQGameCheckService.class, "")) != null) {
                    iQQGameCheckService.handleKeepLivePush(stringUtf8);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.getApp());
    }
}

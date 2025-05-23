package iv;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.qav_rtc_cmd_encoder$EncodeWrapper;
import com.tencent.av.qav_rtc_push_online$PushMsg;
import com.tencent.av.qav_rtc_push_online$PushOnlineMsg;
import com.tencent.component.network.utils.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.cj;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupAudioMemNumChangeNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoInviteMemberUpdateNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoMemNumPushInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;
import com.tencent.qqnt.kernel.nativeinterface.InviteInfo;
import com.tencent.qqnt.kernel.nativeinterface.s;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.util.WnsNetworkConst;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IKernelAVSDKListener {

    /* renamed from: a, reason: collision with root package name */
    private static String f408791a = "KernelAVSDKListenerImpl";

    private int a(String str) {
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom")) {
            return 512;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom")) {
            return 513;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom")) {
            return 515;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom")) {
            return 514;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser")) {
            return 516;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS")) {
            return WnsNetworkConst.WRITE_FAIL;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync")) {
            return 517;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoS2CInvite")) {
            return 768;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap")) {
            return WnsNetworkConst.NETWORK_DISABLE;
        }
        if (str.equalsIgnoreCase("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoS2COnlinePush")) {
            return 769;
        }
        if (str.equalsIgnoreCase("MultiVideo.s2c")) {
            return 1;
        }
        return str.equalsIgnoreCase("MultiVideo.s2cack") ? 2 : 0;
    }

    private void b(InviteInfo inviteInfo, int i3, String str) {
        String str2;
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        long longAccountUin = qQAppInterface.getLongAccountUin();
        byte[] decode = Base64.decode(str, 0);
        qav_rtc_cmd_encoder$EncodeWrapper qav_rtc_cmd_encoder_encodewrapper = new qav_rtc_cmd_encoder$EncodeWrapper();
        try {
            qav_rtc_cmd_encoder_encodewrapper.mergeFrom(decode);
            if (!qav_rtc_cmd_encoder_encodewrapper.cmd.has()) {
                str2 = "";
            } else {
                str2 = qav_rtc_cmd_encoder_encodewrapper.cmd.get();
            }
            byte[] byteArray = qav_rtc_cmd_encoder_encodewrapper.content.has() ? qav_rtc_cmd_encoder_encodewrapper.content.get().toByteArray() : null;
            QLog.i(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd. cmd[" + str2 + "].");
            long j3 = inviteInfo.relationId;
            if (str2.equals("QRTC_C2C_CMD_S2C_ONLINE_PUSH")) {
                boolean b16 = com.tencent.av.core.a.b(byteArray);
                String valueOf = String.valueOf(j3);
                if (!TextUtils.isEmpty(String.valueOf(j3))) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3)), f408791a);
                    if (friendsSimpleInfoWithUid != null) {
                        valueOf = friendsSimpleInfoWithUid.p();
                    }
                }
                long onlineStauts = qQAppInterface.getOnlineStauts();
                Intent intent = new Intent("tencent.video.q2v.RecvSharpVideoCallOnline");
                intent.setClassName(qQAppInterface.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
                intent.putExtra("uin", String.valueOf(longAccountUin));
                intent.putExtra("fromUin", String.valueOf(j3));
                intent.putExtra("buffer", byteArray);
                intent.putExtra("time", 0);
                intent.putExtra("name", valueOf);
                intent.putExtra("isPttRecordingOrPlaying", qQAppInterface.isPttRecordingOrPlaying());
                intent.putExtra("isRequest", b16);
                intent.putExtra("onLineStatus", onlineStauts);
                intent.putExtra("traceId", "");
                intent.putExtra("msf_timestamp", System.currentTimeMillis());
                qQAppInterface.getApp().sendBroadcast(intent);
                return;
            }
            if (str2.equals("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoS2COnlinePush")) {
                qav_rtc_push_online$PushOnlineMsg qav_rtc_push_online_pushonlinemsg = new qav_rtc_push_online$PushOnlineMsg();
                try {
                    qav_rtc_push_online_pushonlinemsg.mergeFrom(byteArray);
                    if (qav_rtc_push_online_pushonlinemsg.push_type.has()) {
                        int i16 = qav_rtc_push_online_pushonlinemsg.push_type.get();
                        QLog.i(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd. pushType[" + i16 + "].");
                        if (i16 == 3) {
                            if (!qav_rtc_push_online_pushonlinemsg.push_msg.has()) {
                                QLog.e(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd failed. no push_msg field.");
                                return;
                            }
                            qav_rtc_push_online$PushMsg qav_rtc_push_online_pushmsg = qav_rtc_push_online_pushonlinemsg.push_msg.get();
                            if (!qav_rtc_push_online_pushmsg.login_push_msg.has()) {
                                QLog.e(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd failed. no login_push_msg field.");
                                return;
                            } else {
                                qQAppInterface.getGAudioHandler().z(qav_rtc_push_online_pushmsg.login_push_msg);
                                return;
                            }
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd failed2. err: " + e16.getMessage());
                    return;
                }
            }
            Intent intent2 = new Intent("tencent.video.q2v.RecvMultiVideoCallOnline");
            intent2.setClassName(qQAppInterface.getApplication().getPackageName(), "com.tencent.av.VideoMsgBroadcastReceiver");
            intent2.putExtra("uin", String.valueOf(longAccountUin));
            intent2.putExtra("fromUin", String.valueOf(j3));
            intent2.putExtra("cmd_type", a(str2));
            intent2.putExtra("cmd_content", byteArray);
            qQAppInterface.getApp().sendBroadcast(intent2);
        } catch (InvalidProtocolBufferMicroException e17) {
            QLog.e(f408791a, 1, "KernelAVSDKListenerImpl. onRecvCmd failed. err: " + e17.getMessage());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public /* synthetic */ void OnGroupVideoActionToAVSDK(int i3, String str) {
        s.a(this, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public /* synthetic */ void OnGroupVideoMemNumPushInfo(GroupVideoMemNumPushInfo groupVideoMemNumPushInfo) {
        s.b(this, groupVideoMemNumPushInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public /* synthetic */ void OnGroupVideoServerPushToAVSDK(int i3, byte[] bArr) {
        s.c(this, i3, bArr);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public void OnInviteActionToAVSDK(InviteInfo inviteInfo, int i3, String str) {
        QLog.i(f408791a, 1, "KernelAVSDKListenerImpl. OnInviteActionToAVSDK. relationId[" + inviteInfo.relationId + "], inviteType[" + inviteInfo.inviteType + "], fromUid[" + inviteInfo.fromUid + "], actionType[" + i3 + "].");
        b(inviteInfo, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public void onActionToAVSDK(int i3, String str) {
        QLog.i(f408791a, 1, "KernelAVSDKListenerImpl. onActionToAVSDK. actionType[" + i3 + "].");
        InviteInfo inviteInfo = new InviteInfo();
        inviteInfo.relationId = 0L;
        inviteInfo.fromUid = "";
        inviteInfo.inviteType = 0;
        b(inviteInfo, i3, str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public void onGroupAudioMemNumChange(GroupAudioMemNumChangeNotifyInfo groupAudioMemNumChangeNotifyInfo) {
        long[] jArr;
        QLog.i(f408791a, 1, "KernelAVSDKListenerImpl. onGroupAudioMemNumChange. " + groupAudioMemNumChangeNotifyInfo);
        cj gAudioHandler = ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getGAudioHandler();
        int i3 = groupAudioMemNumChangeNotifyInfo.onlineCount;
        if (i3 > 0) {
            jArr = new long[i3];
            Object[] array = groupAudioMemNumChangeNotifyInfo.memberUins.toArray();
            for (int i16 = 0; i16 < array.length; i16++) {
                jArr[i16] = ((Long) array[i16]).longValue();
            }
        } else {
            jArr = null;
        }
        gAudioHandler.s(1, Long.toString(groupAudioMemNumChangeNotifyInfo.groupCode), groupAudioMemNumChangeNotifyInfo.onlineCount, jArr, 10, 0, 0, 0);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public /* synthetic */ void onGroupVideoInviteMemberUpdate(GroupVideoInviteMemberUpdateNotifyInfo groupVideoInviteMemberUpdateNotifyInfo) {
        s.g(this, groupVideoInviteMemberUpdateNotifyInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
    public /* synthetic */ void onRecvGroupVideoJsonBufferRsp(int i3, int i16, String str, String str2) {
        s.h(this, i3, i16, str, str2);
    }
}

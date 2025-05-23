package com.tencent.mobileqq.guild.message;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.fi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.common.common$ExtInfo;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.msgpush.s2cmsg$ChannelRecommendDaily;
import tencent.im.group_pro_proto.msgpush.s2cmsg$RedpointEventBody;
import tencent.im.group_pro_proto.msgpush.s2cmsg$S2cEventBody;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class aa extends com.tencent.mobileqq.guild.message.base.q {

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.guild.message.base.k f230112c;

    public aa(AppInterface appInterface) {
        super(appInterface);
    }

    public static int F(AppRuntime appRuntime, int i3) {
        try {
            if (((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("MOBILE_SERVICE_EXTEND_SET_MUTABLE_FLAG")) {
                return 67108864 | i3;
            }
        } catch (Exception e16) {
            QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "addInMutableFlag", e16);
        }
        return i3;
    }

    private s2cmsg$ChannelRecommendDaily G(im_msg_body$CommonElem im_msg_body_commonelem) {
        s2cmsg$S2cEventBody s2cmsg_s2ceventbody = new s2cmsg$S2cEventBody();
        try {
            s2cmsg_s2ceventbody.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            s2cmsg$ChannelRecommendDaily s2cmsg_channelrecommenddaily = new s2cmsg$ChannelRecommendDaily();
            try {
                s2cmsg_channelrecommenddaily.mergeFrom(s2cmsg_s2ceventbody.channel_recommend_daily.get().toByteArray());
                return s2cmsg_channelrecommenddaily;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "decodeChannelRecommendBody: error: parse channelRecommendDaily");
                return null;
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
            QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "decodeChannelRecommendBody: error: parse EventBody");
            return null;
        }
    }

    private s2cmsg$RedpointEventBody H(im_msg_body$CommonElem im_msg_body_commonelem) {
        s2cmsg$S2cEventBody s2cmsg_s2ceventbody = new s2cmsg$S2cEventBody();
        try {
            s2cmsg_s2ceventbody.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            s2cmsg$RedpointEventBody s2cmsg_redpointeventbody = new s2cmsg$RedpointEventBody();
            try {
                s2cmsg_redpointeventbody.mergeFrom(s2cmsg_s2ceventbody.redpoint_event_body.get().toByteArray());
                return s2cmsg_redpointeventbody;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "processSystem: error: parse EventBody");
                return null;
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
            QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "processSystem: error: parse EventBody");
            return null;
        }
    }

    private im_msg_body$CommonElem I(common$Msg common_msg) {
        for (im_msg_body$Elem im_msg_body_elem : common_msg.body.get().rich_text.get().elems.get()) {
            if (im_msg_body_elem.common_elem.has()) {
                return im_msg_body_elem.common_elem.get();
            }
        }
        return null;
    }

    private long J(common$Msg common_msg) {
        if (common_msg.head.has() && common_msg.head.content_head.has()) {
            return common_msg.head.content_head.get().sub_type.get();
        }
        return 0L;
    }

    private boolean K(im_msg_body$CommonElem im_msg_body_commonelem) {
        boolean z16;
        s2cmsg$ChannelRecommendDaily G = G(im_msg_body_commonelem);
        if (G == null) {
            QLog.e("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "handleChannelRecommendPush error, decode failed");
            return false;
        }
        if (!GuardManager.sInstance.isApplicationForeground() && ca.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "handleChannelRecommendPush " + z16 + " title:" + G.title.get().toStringUtf8() + " subtitle:" + G.sub_title.get().toStringUtf8() + " avatar:" + G.avatar.get().toStringUtf8() + " jump_link:" + G.jump_link.get().toStringUtf8());
        if (!z16) {
            return false;
        }
        S(G);
        return true;
    }

    private boolean L(im_msg_body$CommonElem im_msg_body_commonelem) {
        s2cmsg$RedpointEventBody H = H(im_msg_body_commonelem);
        if (H == null) {
            return false;
        }
        QLog.i("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "handleClearUnreadNotify type=" + H.redpoint_type_v8992.get() + " count=" + H.count.get() + " mute=" + H.mute_switch.get());
        return true;
    }

    private void M(Intent intent, String str) {
        PushReportData pushReportData = new PushReportData();
        pushReportData.setAction("receive");
        pushReportData.setUin(this.f230314a.getCurrentAccountUin());
        pushReportData.setTime(NetConnInfoCenter.getServerTime());
        pushReportData.setAppStatus(2);
        pushReportData.setPushType(PushReportData.PushType.PUSH_TYPE_FEATURED_GUILD.ordinal());
        pushReportData.setSgrpPushUrl(str);
        intent.putExtra(PushReportData.GUILD_NOTIFY_REPORT, (Parcelable) pushReportData);
        ((com.tencent.mobileqq.guild.report.g) this.f230314a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildReportHandlerName())).L0(pushReportData);
    }

    private boolean N(im_msg_body$CommonElem im_msg_body_commonelem, common$ExtInfo common_extinfo, String str) {
        if (H(im_msg_body_commonelem) == null) {
            return false;
        }
        return common_extinfo.s2c_msg_info.has();
    }

    private boolean O(im_msg_body$CommonElem im_msg_body_commonelem) {
        s2cmsg$RedpointEventBody H = H(im_msg_body_commonelem);
        if (H == null) {
            return false;
        }
        QLog.i("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 1, "handleSettingChangedNotify type=" + H.redpoint_type_v8992.get() + " count=" + H.count.get() + " mute=" + H.mute_switch.get());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(s2cmsg$ChannelRecommendDaily s2cmsg_channelrecommenddaily, Intent intent, Bitmap bitmap) {
        String stringUtf8 = s2cmsg_channelrecommenddaily.title.get().toStringUtf8();
        String stringUtf82 = s2cmsg_channelrecommenddaily.sub_title.get().toStringUtf8();
        M(intent, s2cmsg_channelrecommenddaily.jump_link.get().toStringUtf8());
        R(stringUtf8, stringUtf82, bitmap, intent);
    }

    private void Q(common$Msg common_msg, int i3) {
        im_msg_body$CommonElem I;
        boolean z16;
        com.tencent.mobileqq.guild.message.base.k kVar;
        if (common_msg != null && (I = I(common_msg)) != null && 501 == I.uint32_service_type.get()) {
            int J = (int) J(common_msg);
            if (QLog.isColorLevel()) {
                QLog.i("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 2, "processS2CSystemMsg subType=" + J + " from=" + i3);
            }
            IGPSService iGPSService = (IGPSService) this.f230314a.getRuntimeService(IGPSService.class, "");
            fi fiVar = new fi(common_msg.head.routing_head.guild_id.get() + "", common_msg.head.routing_head.channel_id.get() + "", common_msg.head.routing_head.from_uin.get() + "", common_msg.head.routing_head.from_tinyid.get() + "", common_msg.head.routing_head.guild_code.get() + "", common_msg.head.routing_head.direct_message_flag.get());
            iGPSService.onSrvPushMsg(3842, J, fiVar, I.bytes_pb_elem.get().toByteArray());
            if (J == 1) {
                z16 = N(I, common_msg.ext_info, fiVar.f());
            } else if (J == 2) {
                z16 = L(I);
            } else if (J == 3) {
                z16 = O(I);
            } else if (J == 6) {
                z16 = K(I);
            } else {
                z16 = false;
            }
            if (z16 && (kVar = f230112c) != null) {
                kVar.a(this.f230314a);
            }
        }
    }

    private void R(String str, String str2, Bitmap bitmap, Intent intent) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(str2);
        QQNotificationManager.getInstance().notify("BaseGuildMessageProcessor.GuildS2CMessageProcessor", NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, new NotificationCompat.Builder(this.f230314a.getApp()).setSmallIcon(tp1.a.g()).setLargeIcon(bitmap).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setAutoCancel(true).setPriority(2).setStyle(bigTextStyle).setTicker(str2).setChannelId(QQNotificationManager.CHANNEL_ID_OTHER).setContentIntent(PendingIntent.getActivity(this.f230314a.getApp(), NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON, intent, F(this.f230314a, 134217728))).build());
        if (QLog.isColorLevel()) {
            QLog.i("BaseGuildMessageProcessor.GuildS2CMessageProcessor", 2, "createSystemNotification " + str + " content=" + str2);
        }
    }

    private void S(final s2cmsg$ChannelRecommendDaily s2cmsg_channelrecommenddaily) {
        final Intent intent = new Intent();
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setGuildTabIntent(this.f230314a.getApplicationContext(), intent);
        intent.putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, NotificationUtil.Constants.NOTIFY_ID_GUILD_COMMON);
        intent.putExtra("goto_guildtab_actiontype", GuildMainFrameConstants.D);
        Bundle bundle = new Bundle();
        intent.putExtra("goto_guildtab_actionextra", bundle);
        bundle.putString("jump_url", s2cmsg_channelrecommenddaily.jump_link.get().toStringUtf8());
        com.tencent.mobileqq.guild.util.v.f(s2cmsg_channelrecommenddaily.avatar.get().toStringUtf8(), QQGuildUIUtil.f(48.0f), QQGuildUIUtil.f(48.0f), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.message.z
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                aa.this.P(s2cmsg_channelrecommenddaily, intent, bitmap);
            }
        });
    }

    public static void T(com.tencent.mobileqq.guild.message.base.r rVar) {
        if (rVar instanceof com.tencent.mobileqq.guild.message.base.m) {
            f230112c = (com.tencent.mobileqq.guild.message.base.k) rVar;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.s
    public void a(Object... objArr) {
        if (objArr != null && objArr.length == 2) {
            Q((common$Msg) objArr[0], ((Integer) objArr[1]).intValue());
        } else {
            n(getClass().getName());
        }
    }
}

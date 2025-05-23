package com.tencent.mobileqq.guild.message.serversendarkmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tencent.im.group_pro_proto.cmd0x101b.cmd0x101b$AppPlayInfo;
import tencent.im.group_pro_proto.cmd0x101b.cmd0x101b$GameParam;
import tencent.im.group_pro_proto.cmd0x101b.cmd0x101b$ReqBody;
import tencent.im.group_pro_proto.cmd0x101b.cmd0x101b$YouLeGameInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildInvitationArkMsgHandler extends BusinessHandler implements c {

    /* renamed from: d, reason: collision with root package name */
    private long f230798d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f230799e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static a f230800c;

        /* renamed from: a, reason: collision with root package name */
        private Map<Long, Integer> f230801a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private Map<Long, Boolean> f230802b = new HashMap();

        a() {
        }

        public static a c() {
            if (f230800c == null) {
                synchronized (a.class) {
                    a aVar = f230800c;
                    if (aVar != null) {
                        return aVar;
                    }
                    f230800c = new a();
                }
            }
            return f230800c;
        }

        public void a(long j3, int i3) {
            synchronized (this.f230801a) {
                if (this.f230801a.containsKey(Long.valueOf(j3))) {
                    return;
                }
                this.f230801a.put(Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        public void b(long j3, boolean z16) {
            synchronized (a.class) {
                boolean z17 = true;
                this.f230801a.put(Long.valueOf(j3), Integer.valueOf(this.f230801a.get(Long.valueOf(j3)).intValue() - 1));
                if (this.f230802b.containsKey(Long.valueOf(j3))) {
                    Map<Long, Boolean> map = this.f230802b;
                    Long valueOf = Long.valueOf(j3);
                    if (!this.f230802b.get(Long.valueOf(j3)).booleanValue() || !z16) {
                        z17 = false;
                    }
                    map.put(valueOf, Boolean.valueOf(z17));
                } else {
                    this.f230802b.put(Long.valueOf(j3), Boolean.valueOf(z16));
                }
            }
        }

        public int d(long j3) {
            int intValue;
            synchronized (this.f230801a) {
                intValue = this.f230801a.get(Long.valueOf(j3)).intValue();
                if (intValue == 0) {
                    this.f230801a.remove(Long.valueOf(j3));
                }
            }
            return intValue;
        }

        public boolean e(long j3) {
            boolean booleanValue;
            synchronized (this.f230802b) {
                booleanValue = this.f230802b.get(Long.valueOf(j3)).booleanValue();
                this.f230802b.remove(Long.valueOf(j3));
            }
            return booleanValue;
        }
    }

    protected GuildInvitationArkMsgHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230798d = 0L;
        this.f230799e = new Bundle();
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        b.a();
        long j3 = fromServiceMsg.extraData.getLong("GUILD_INVITATION_SEND_ID", this.f230798d);
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                i3 = mergeFrom.uint32_result.get();
                str = mergeFrom.str_error_msg.get();
                if (i3 == 0) {
                    a.c().b(j3, true);
                    QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, "handleSendArkMsgBackPackage result:" + i3 + " errMsg" + str);
                } else {
                    a.c().b(j3, false);
                    QLog.e("Guild.share.InvitationArkMsgHandler.0x101b", 1, "handleSendArkMsgBackPackage result:" + i3 + " errMsg" + str);
                }
                if (a.c().d(j3) == 0) {
                    J2(a.c().e(j3));
                }
            } catch (Exception e16) {
                QLog.e("Guild.share.InvitationArkMsgHandler.0x101b", 1, "handleSendArkMsgBackPackage|oidb_sso parseFrom byte " + e16.toString());
                e16.printStackTrace();
                a.c().b(j3, false);
                return;
            }
        } else {
            i3 = -1;
            str = "";
        }
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(8, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(boolean z16, String str, String str2) {
        int i3;
        Context applicationContext = this.appRuntime.getApplicationContext();
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (!z16) {
            str = str2;
        }
        QQToast.makeText(applicationContext, i3, str, 0).show();
    }

    private void G2(cmd0x101b$ReqBody cmd0x101b_reqbody, long j3) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4123);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x101b_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0x101b_1");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(5000L);
        createToServiceMsg.extraData.putLong("GUILD_INVITATION_SEND_ID", j3);
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).startGuildMsgProtocolReport(createToServiceMsg);
        sendPbReq(createToServiceMsg);
    }

    private boolean H2(cmd0x101b$ReqBody cmd0x101b_reqbody, Bundle bundle) {
        int i3 = bundle.getInt("uintype", -1);
        long j3 = bundle.getLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, 0L);
        long j16 = bundle.getLong(AppConstants.Key.GUILD_SOURCE_ID, 0L);
        String string = bundle.getString(QQCustomArkDialogUtil.META_DATA, "");
        cmd0x101b_reqbody.business_type.set(bundle.getInt("businessType", 0));
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.share.InvitationArkMsgHandler.0x101b", 2, " your metaData is empty! ");
            }
            return false;
        }
        if (j16 != 0 && i3 != -1 && !TextUtils.isEmpty("246610") && !TextUtils.isEmpty("ka")) {
            String string2 = bundle.getString(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_ID, "");
            if (!TextUtils.isEmpty(string2)) {
                cmd0x101b$YouLeGameInfo cmd0x101b_youlegameinfo = new cmd0x101b$YouLeGameInfo();
                cmd0x101b$GameParam cmd0x101b_gameparam = new cmd0x101b$GameParam();
                cmd0x101b_gameparam.game_id.set(string2);
                cmd0x101b_gameparam.team_id.set(bundle.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_ID, ""));
                cmd0x101b_gameparam.team_guild_id.set(bundle.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_GUILD_ID, ""));
                cmd0x101b_gameparam.team_channel_id.set(bundle.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_CHANNEL_ID, ""));
                cmd0x101b_gameparam.jump_action.set(bundle.getString(AppConstants.Key.GUILD_INVITATION_YOLO_JUMP_ACTION, ""));
                cmd0x101b_youlegameinfo.game_param.set(cmd0x101b_gameparam);
                cmd0x101b_youlegameinfo.mode_id.set(bundle.getInt(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_MODE_ID));
                cmd0x101b_reqbody.extend_param.set(ByteStringMicro.copyFrom(cmd0x101b_youlegameinfo.toByteArray()));
            }
            String string3 = bundle.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_SESSION_ID, "");
            if (!TextUtils.isEmpty(string3)) {
                cmd0x101b$AppPlayInfo cmd0x101b_appplayinfo = new cmd0x101b$AppPlayInfo();
                cmd0x101b_appplayinfo.session_id.set(string3);
                String string4 = bundle.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_TITLE, "");
                String string5 = bundle.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_FILE_ID, "");
                if (!TextUtils.isEmpty(string4)) {
                    cmd0x101b_appplayinfo.title.set(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    cmd0x101b_appplayinfo.file_id.set(string5);
                }
                cmd0x101b_reqbody.extend_param.set(ByteStringMicro.copyFrom(cmd0x101b_appplayinfo.toByteArray()));
            }
            cmd0x101b_reqbody.from.set("246610");
            cmd0x101b_reqbody.biz.set("ka");
            cmd0x101b_reqbody.src_guild_id.set(j16);
            cmd0x101b_reqbody.src_channel_id.set(j3);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, "fetch target_type, sourceGuildId, from, biz failed!  type: " + i3 + " sourceGuildId: " + j16 + " from: 246610 biz: ka");
        }
        return false;
    }

    private boolean I2(cmd0x101b$ReqBody cmd0x101b_reqbody, Bundle bundle) {
        String string = bundle.getString("guild_id", "");
        String string2 = bundle.getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, " try to get target_guild_id failed! ");
                return false;
            }
            return false;
        }
        cmd0x101b_reqbody.target_type.set(3);
        cmd0x101b_reqbody.dst_guild_id.set(Long.parseLong(string));
        cmd0x101b_reqbody.dst_channel_id.set(Long.parseLong(string2));
        return true;
    }

    private void J2(final boolean z16) {
        final String r16;
        final String r17;
        if (this.f230799e.containsKey("toast_success_wording")) {
            r16 = this.f230799e.getString("toast_success_wording");
        } else {
            r16 = QQGuildUIUtil.r(R.string.f156691kw);
        }
        if (this.f230799e.containsKey("toast_failed_wording")) {
            r17 = this.f230799e.getString("toast_failed_wording");
        } else {
            r17 = QQGuildUIUtil.r(R.string.f156681kv);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.serversendarkmsg.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildInvitationArkMsgHandler.this.F2(z16, r16, r17);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x101b_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.share.InvitationArkMsgHandler.0x101b", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0x101b_1".equals(serviceCmd)) {
                E2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.InvitationArkMsgHandler.0x101b", 2, "onReceive,res == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.guild.message.serversendarkmsg.c
    public void v1(@NonNull Bundle bundle, String str, long j3, int i3) {
        AttaIdReportData attaIdReportData;
        this.f230798d = j3;
        a.c().a(j3, i3);
        cmd0x101b$ReqBody cmd0x101b_reqbody = new cmd0x101b$ReqBody();
        int i16 = bundle.getInt("uintype", -1);
        if (!H2(cmd0x101b_reqbody, bundle)) {
            a.c().b(j3, false);
            return;
        }
        cmd0x101b_reqbody.leave_message.set(str);
        String string = bundle.getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, " try to get target_uin failed! ");
            }
            a.c().b(j3, false);
            return;
        }
        int i17 = bundle.getInt("businessType", 0);
        byte[] bArr = new byte[0];
        if (bundle.containsKey("extra_key_atta_report_id") && (attaIdReportData = (AttaIdReportData) bundle.getParcelable("extra_key_atta_report_id")) != null) {
            bArr = IGProDataApi.INSTANCE.a().encodeShareAttaData(attaIdReportData.c());
            if (QLog.isColorLevel()) {
                QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, " try to report atta data " + attaIdReportData.toString());
            }
        }
        if (bArr.length > 0) {
            cmd0x101b_reqbody.share_atta_data.set(ByteStringMicro.copyFrom(bArr));
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 10014) {
                    QLog.w("Guild.share.InvitationArkMsgHandler.0x101b", 1, "targetType is not: toFriends or toTroop or toGuild, targetType:  " + i16);
                    a.c().b(j3, false);
                    return;
                }
                if (!I2(cmd0x101b_reqbody, bundle)) {
                    a.c().b(j3, false);
                    return;
                }
            } else {
                cmd0x101b_reqbody.target_type.set(2);
                cmd0x101b_reqbody.target_gcode.set(Long.parseLong(string));
            }
        } else if (i17 == 20) {
            long[] longArray = bundle.getLongArray("BATCH_C2C_UIN_LIST");
            if (longArray != null && longArray.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (long j16 : longArray) {
                    arrayList.add(Long.valueOf(j16));
                }
                cmd0x101b_reqbody.target_uins.set(arrayList);
                cmd0x101b_reqbody.target_type.set(4);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("Guild.share.InvitationArkMsgHandler.0x101b", 2, " try to get BATCH_C2C_UIN_LIST failed! ");
                }
                a.c().b(j3, false);
                return;
            }
        } else {
            cmd0x101b_reqbody.target_type.set(1);
            cmd0x101b_reqbody.target_uin.set(Long.parseLong(string));
        }
        G2(cmd0x101b_reqbody, j3);
        this.f230799e.clear();
        this.f230799e.putAll(bundle);
    }
}

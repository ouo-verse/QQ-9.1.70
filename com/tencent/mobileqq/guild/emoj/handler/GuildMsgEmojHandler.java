package com.tencent.mobileqq.guild.emoj.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.emoj.a;
import com.tencent.mobileqq.guild.emoj.d;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.group_pro_proto.cmd0x101e.cmd0x101e$MsgRet;
import tencent.im.group_pro_proto.cmd0x101e.cmd0x101e$RspBody;
import tencent.im.group_pro_proto.cmd0x1027.cmd0x1027$RspBody;
import tencent.im.group_pro_proto.cmd0x1027.cmd0x1027$UserInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildMsgEmojHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f217906d;

    public GuildMsgEmojHandler(AppInterface appInterface) {
        super(appInterface);
        this.f217906d = appInterface;
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        long j3;
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        long j16 = toServiceMsg.extraData.getLong(AppConstants.Key.COLUMN_SHMSG_SEQ);
        String string3 = toServiceMsg.extraData.getString("emojId");
        int i16 = toServiceMsg.extraData.getInt("emojType");
        String string4 = toServiceMsg.extraData.getString("requestCookie");
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        int i17 = -1;
        if (!fromServiceMsg.isSuccess()) {
            str = "";
            z18 = false;
            z17 = false;
        } else {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                i17 = oidb_sso_oidbssopkg.uint32_result.get();
            } catch (Exception e16) {
                e = e16;
            }
            try {
                str = oidb_sso_oidbssopkg.str_error_msg.get();
                if (i17 == 0) {
                    try {
                        cmd0x1027$RspBody cmd0x1027_rspbody = new cmd0x1027$RspBody();
                        cmd0x1027_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        if (cmd0x1027_rspbody.last_page.has()) {
                            try {
                                z16 = cmd0x1027_rspbody.last_page.get();
                            } catch (Exception e17) {
                                e = e17;
                                z16 = false;
                                QLog.e("GuildMsgEmojHandler", 1, "handleGetLikesUserList fail.", e);
                                z17 = z16;
                                z18 = false;
                                QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
                                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
                                notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
                            }
                        } else {
                            z16 = false;
                        }
                        try {
                            str2 = cmd0x1027_rspbody.cookie.get();
                            int i18 = 0;
                            while (cmd0x1027_rspbody.f435940msg.has() && i18 < cmd0x1027_rspbody.f435940msg.size()) {
                                try {
                                    cmd0x1027$UserInfo cmd0x1027_userinfo = cmd0x1027_rspbody.f435940msg.get(i18).get();
                                    cmd0x1027$RspBody cmd0x1027_rspbody2 = cmd0x1027_rspbody;
                                    a aVar = new a();
                                    String str3 = str2;
                                    try {
                                        aVar.f217866d = cmd0x1027_userinfo.head_url.get();
                                        aVar.f217865c = cmd0x1027_userinfo.nick_name.get();
                                        if (cmd0x1027_userinfo.tiny_id.has()) {
                                            try {
                                                j3 = cmd0x1027_userinfo.tiny_id.get();
                                            } catch (Exception e18) {
                                                e = e18;
                                                str2 = str3;
                                                QLog.e("GuildMsgEmojHandler", 1, "handleGetLikesUserList fail.", e);
                                                z17 = z16;
                                                z18 = false;
                                                QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
                                                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
                                                notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
                                            }
                                        } else {
                                            j3 = 0;
                                        }
                                        int i19 = i17;
                                        try {
                                            aVar.f217864b = j3;
                                            arrayList.add(aVar);
                                            i18++;
                                            cmd0x1027_rspbody = cmd0x1027_rspbody2;
                                            i17 = i19;
                                            str2 = str3;
                                        } catch (Exception e19) {
                                            e = e19;
                                            i17 = i19;
                                            str2 = str3;
                                            QLog.e("GuildMsgEmojHandler", 1, "handleGetLikesUserList fail.", e);
                                            z17 = z16;
                                            z18 = false;
                                            QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
                                            ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
                                            notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
                                        }
                                    } catch (Exception e26) {
                                        e = e26;
                                    }
                                } catch (Exception e27) {
                                    e = e27;
                                    QLog.e("GuildMsgEmojHandler", 1, "handleGetLikesUserList fail.", e);
                                    z17 = z16;
                                    z18 = false;
                                    QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
                                    ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
                                    notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
                                }
                            }
                            i3 = i17;
                            str2 = str2;
                            z18 = true;
                        } catch (Exception e28) {
                            e = e28;
                        }
                    } catch (Exception e29) {
                        e = e29;
                    }
                } else {
                    i3 = i17;
                    z18 = false;
                    z16 = false;
                }
                i17 = i3;
                z17 = z16;
            } catch (Exception e36) {
                e = e36;
                str = "";
                z16 = false;
                QLog.e("GuildMsgEmojHandler", 1, "handleGetLikesUserList fail.", e);
                z17 = z16;
                z18 = false;
                QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
                notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
            }
        }
        QLog.i("GuildMsgEmojHandler", 2, "handleGetLikesUserList, guildId: " + string + ", channelId = " + string2 + ", isSuccess = " + z18 + ", result = " + i17 + ", shmsgseq = " + j16 + ", emojId = " + string3 + ", emojType = " + i16 + ", isLastPage = " + z17 + ", likesDatas.size() = " + arrayList.size() + ", cookie = " + str2);
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf(i17), str, Boolean.valueOf(z18));
        notifyUI(d.f217883f, z18, new Object[]{string, string2, Long.valueOf(j16), string3, Integer.valueOf(i16), string4, str2, Boolean.valueOf(z17), arrayList});
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        long j3;
        long j16;
        long j17;
        String str5;
        cmd0x101e$RspBody cmd0x101e_rspbody;
        cmd0x101e$RspBody cmd0x101e_rspbody2;
        cmd0x101e$MsgRet cmd0x101e_msgret;
        String str6;
        String string = toServiceMsg.extraData.getString("guildId");
        String string2 = toServiceMsg.extraData.getString("channelId");
        long j18 = toServiceMsg.extraData.getLong(AppConstants.Key.COLUMN_SHMSG_SEQ);
        String string3 = toServiceMsg.extraData.getString("emojId");
        long j19 = toServiceMsg.extraData.getLong("emojType");
        boolean z17 = toServiceMsg.extraData.getBoolean("setEmoj");
        long j26 = toServiceMsg.extraData.getLong(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        long j27 = toServiceMsg.extraData.getLong("taskType");
        cmd0x101e$RspBody cmd0x101e_rspbody3 = new cmd0x101e$RspBody();
        long j28 = 0;
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                try {
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
            try {
                cmd0x101e_rspbody2 = cmd0x101e_rspbody3.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e18) {
                e = e18;
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    cmd0x101e_rspbody = cmd0x101e_rspbody3;
                    sb5.append("handleSetOrCancelEmoj|oidb_sso parseFrom byte ");
                    sb5.append(e.toString());
                    QLog.d("GuildMsgEmojHandler", 2, sb5.toString());
                } else {
                    cmd0x101e_rspbody = cmd0x101e_rspbody3;
                }
                e.printStackTrace();
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                cmd0x101e_rspbody2 = cmd0x101e_rspbody;
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str7 = oidb_sso_oidbssopkg.str_error_msg.get();
                cmd0x101e_msgret = cmd0x101e_rspbody2.msg_ret.get();
                if (cmd0x101e_msgret.has()) {
                }
                str = "GuildMsgEmojHandler";
                if (i3 != 0) {
                }
                String str8 = str6;
                str3 = str7;
                str2 = str8;
                if (z16) {
                }
                str4 = str2;
                if (!QLog.isColorLevel()) {
                }
                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf((int) j16), str4, Boolean.valueOf(z16));
                notifyUI(d.f217882e, z16, new Object[]{string, string2, Long.valueOf(j18), string3, Long.valueOf(j19), Boolean.valueOf(z17), Integer.valueOf(i3), Long.valueOf(j17), Long.valueOf(j3), Long.valueOf(j16), str4});
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            String str72 = oidb_sso_oidbssopkg.str_error_msg.get();
            cmd0x101e_msgret = cmd0x101e_rspbody2.msg_ret.get();
            if (cmd0x101e_msgret.has()) {
                str6 = "";
            } else {
                j28 = cmd0x101e_msgret.ret_code.get();
                str6 = cmd0x101e_msgret.ret_msg.get();
            }
            str = "GuildMsgEmojHandler";
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str82 = str6;
            str3 = str72;
            str2 = str82;
        } else {
            i3 = -1;
            str = "GuildMsgEmojHandler";
            z16 = false;
            str2 = "";
            str3 = str2;
        }
        if (z16 && !TextUtils.isEmpty(str3)) {
            str4 = str3;
        } else {
            str4 = str2;
        }
        if (!QLog.isColorLevel()) {
            String str9 = str3;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("handleSetOrCancelEmoj, guildId: ");
            sb6.append(string);
            sb6.append(", result = ");
            sb6.append(i3);
            sb6.append(", isSuccess = ");
            sb6.append(z16);
            sb6.append(", channelId: ");
            sb6.append(string2);
            sb6.append(", shmsgseq: ");
            sb6.append(j18);
            sb6.append(", emojId: ");
            sb6.append(string3);
            sb6.append(", emojType: ");
            sb6.append(j19);
            sb6.append(", setEmoj: ");
            sb6.append(z17);
            sb6.append(", taskId = ");
            sb6.append(j26);
            sb6.append(", taskType = ");
            sb6.append(j27);
            sb6.append(", retCode = ");
            j3 = j27;
            j16 = j28;
            sb6.append(j16);
            sb6.append(", retMsg = ");
            str4 = str4;
            sb6.append(str4);
            j17 = j26;
            sb6.append(", errMsg: ");
            if (str9 == null) {
                str5 = "";
            } else {
                str5 = str9;
            }
            sb6.append(str5);
            QLog.i(str, 2, sb6.toString());
        } else {
            j3 = j27;
            j16 = j28;
            j17 = j26;
        }
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(1, toServiceMsg, fromServiceMsg, Integer.valueOf((int) j16), str4, Boolean.valueOf(z16));
        notifyUI(d.f217882e, z16, new Object[]{string, string2, Long.valueOf(j18), string3, Long.valueOf(j19), Boolean.valueOf(z17), Integer.valueOf(i3), Long.valueOf(j17), Long.valueOf(j3), Long.valueOf(j16), str4});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x101e_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x101e_2");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x1027_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgEmojHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0x101e_1".equals(fromServiceMsg.getServiceCmd()) || "OidbSvcTrpcTcp.0x101e_2".equals(fromServiceMsg.getServiceCmd())) {
                E2(toServiceMsg, fromServiceMsg, obj);
            }
            if ("OidbSvcTrpcTcp.0x1027_1".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMsgEmojHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}

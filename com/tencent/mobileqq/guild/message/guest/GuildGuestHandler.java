package com.tencent.mobileqq.guild.message.guest;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.j;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildGuestHandler extends BusinessHandler {
    public GuildGuestHandler(AppInterface appInterface) {
        super(appInterface);
    }

    void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        String string = toServiceMsg.extraData.getString("guildId");
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.comm.GuildGuestHandler", 2, "handleReportGuestEnteringGuild|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            oidb_sso_oidbssopkg.str_error_msg.get();
            if (i3 == 0) {
                z16 = true;
                QLog.i("Guild.comm.GuildGuestHandler", 2, "handleReportGuestEnteringGuild, guildId: " + string + ", result = " + i3 + ", isSuccess = " + z16);
                notifyUI(j.f230581e, z16, new Object[]{string});
            }
        } else {
            i3 = -1;
        }
        z16 = false;
        QLog.i("Guild.comm.GuildGuestHandler", 2, "handleReportGuestEnteringGuild, guildId: " + string + ", result = " + i3 + ", isSuccess = " + z16);
        notifyUI(j.f230581e, z16, new Object[]{string});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xfa8_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return j.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.comm.GuildGuestHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0xfa8_1".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.comm.GuildGuestHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}

package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRevokeMessageHandler extends BusinessHandler {
    public GuildRevokeMessageHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void H2(boolean z16, final int i3) {
        if (!z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRevokeMessageHandler.this.K2(i3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, int i3) {
        int i16;
        String str;
        boolean z16;
        String string = toServiceMsg.extraData.getString("channelId");
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong(AppConstants.Key.COLUMN_SHMSG_SEQ));
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildRevokeMessageHandler", 2, "handleRecallMsgRsp|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            i16 = oidb_sso_oidbssopkg.uint32_result.get();
            str = oidb_sso_oidbssopkg.str_error_msg.get();
            if (i16 == 0) {
                z16 = true;
                QLog.d("GuildRevokeMessageHandler", 1, "handleRecallMsgRsp. result: " + i16 + ", serviceType" + i3 + ", isSuccess: " + z16 + ", errMsg: " + str + ", channelId: " + string + ", shmsgseq: " + valueOf);
                if (i3 != 1) {
                    J2(i16);
                    notifyUI(n.f230677i, z16, new Object[]{string, valueOf});
                    return;
                } else {
                    if (i3 == 3) {
                        H2(z16, i16);
                        return;
                    }
                    return;
                }
            }
        } else {
            i16 = -1;
            str = "";
        }
        z16 = false;
        QLog.d("GuildRevokeMessageHandler", 1, "handleRecallMsgRsp. result: " + i16 + ", serviceType" + i3 + ", isSuccess: " + z16 + ", errMsg: " + str + ", channelId: " + string + ", shmsgseq: " + valueOf);
        if (i3 != 1) {
        }
    }

    private void J2(int i3) {
        if (i3 == 200501 || i3 == 200502 || i3 == 200503) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.GuildRevokeMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((BaseBusinessHandler) GuildRevokeMessageHandler.this).appRuntime != null && ((BaseBusinessHandler) GuildRevokeMessageHandler.this).appRuntime.getApplicationContext() != null) {
                        QQToast.makeText(((BaseBusinessHandler) GuildRevokeMessageHandler.this).appRuntime.getApplicationContext(), 1, R.string.f153201bg, 0).show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(int i3) {
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null && appInterface.getApplicationContext() != null) {
            if ((i3 >= 200501 && i3 < 200699) || i3 == 300005) {
                QQToast.makeText(this.appRuntime.getApplicationContext(), 1, R.string.f143070l3, 0).show();
            } else {
                QQToast.makeText(this.appRuntime.getApplicationContext(), 1, R.string.f1511016s, 0).show();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xf5e_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0xf5e_3");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return n.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildRevokeMessageHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0xf5e_1".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj, 1);
            }
            if ("OidbSvcTrpcTcp.0xf5e_3".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj, 3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildRevokeMessageHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}

package com.tencent.mobileqq.guild.robot.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.f;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.robot.api.impl.GuildRobotConfigApiImpl;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotConfigApiImpl implements IGuildRobotConfigApi {
    private static final String TAG = "GuildRobotConfigApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkRobotStatusInGuild$0(int i3, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp, f fVar) {
        boolean z16 = true;
        if (i3 == 0 && gProGuildRobotPermissionRsp != null) {
            int robotStatus = gProGuildRobotPermissionRsp.getRobotStatus();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkRobotStatusInGuild, onResponse, status=", Integer.valueOf(robotStatus));
            }
            if (robotStatus != 1) {
                z16 = false;
            }
            fVar.a(z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkRobotStatusInGuild, onError, errCode=", Integer.valueOf(i3));
        }
        fVar.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkRobotStatusInGuild$1(final f fVar, final int i3, String str, final GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ww1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildRobotConfigApiImpl.lambda$checkRobotStatusInGuild$0(i3, gProGuildRobotPermissionRsp, fVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public void checkRobotStatusInGuild(String str, String str2, final f fVar) {
        ac g16 = sx1.f.g();
        if (g16 != null && fVar != null) {
            try {
                g16.fetchGuildRobotPermission(new GProGuildRobotPermissionReq(Long.parseLong(str2), Long.parseLong(str)), new IGProFetchGuildRobotPermissionCallback() { // from class: ww1.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback
                    public final void onFetchGuildRobotPermission(int i3, String str3, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
                        GuildRobotConfigApiImpl.lambda$checkRobotStatusInGuild$1(com.tencent.mobileqq.guild.api.f.this, i3, str3, gProGuildRobotPermissionRsp);
                    }
                });
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "checkRobotStatusInGuild | " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public String getMsgFromRobotFlag() {
        return "3161";
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public String getPushMsgSettingLink() {
        return ch.V();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public String getRobotActiveMsgFlag() {
        return "1";
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public int getRobotArkPermissionCacheTime() {
        return ch.U();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public int getRobotCmdSortGuildLimit(int i3) {
        int X = ch.X();
        if (X != 0) {
            i3 = X;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "robotCmdSortGuildLimit = " + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public int getRobotCmdSortRobotLimit(int i3) {
        int Y = ch.Y();
        if (Y != 0) {
            i3 = Y;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "robotCmdSortRobotLimit = " + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi
    public int getRobotInitiativeMsgNum(int i3) {
        int Z = ch.Z();
        if (Z != 0) {
            return Z;
        }
        return i3;
    }
}

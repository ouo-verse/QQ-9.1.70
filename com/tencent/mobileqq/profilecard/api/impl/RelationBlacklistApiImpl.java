package com.tencent.mobileqq.profilecard.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$Account;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CheckReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CheckRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CountBlockListRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$MigrateReq;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$MigrateRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$UnblockReq;

/* compiled from: P */
/* loaded from: classes35.dex */
public class RelationBlacklistApiImpl implements IRelationBlacklistApi {
    private static final int OIDB_CMD_0X1222 = 4642;
    private static final int OIDB_CMD_0X1223 = 4643;
    private static final int OIDB_CMD_0X1224 = 4644;
    private static final int OIDB_CMD_0X122b = 4651;
    private static final int OIDB_CMD_0X122d = 4653;
    private static final String OIDB_CMD_ADD_BLACK_USER = "OidbSvcTrpcTcp.0x1222_0";
    private static final String OIDB_CMD_CHECK_BLACK_USER = "OidbSvcTrpcTcp.0x1224_0";
    private static final String OIDB_CMD_DELE_BLACK_USER = "OidbSvcTrpcTcp.0x1223_0";
    private static final String OIDB_CMD_GET_SHIELD_NUMBER = "OidbSvcTrpcTcp.0x122d_0";
    private static final String OIDB_CMD_SHIELD_TRANSFER = "OidbSvcTrpcTcp.0x122b_0";
    private static final String TAG = "RelationBlacklistApiImpl";

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public boolean isEnableBlackList() {
        return com.tencent.relation.common.config.toggle.c.I.g(false);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public void sendAddBlacklistRequest(String str, final RelationBlacklistListener relationBlacklistListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && Friends.isValidUin(str)) {
            RelationBlacklist$BlockReq relationBlacklist$BlockReq = new RelationBlacklist$BlockReq();
            RelationBlacklist$Account relationBlacklist$Account = new RelationBlacklist$Account();
            relationBlacklist$Account.uin.set(Long.parseLong(str));
            relationBlacklist$Account.type.set(3);
            relationBlacklist$BlockReq.account.set(relationBlacklist$Account);
            relationBlacklist$BlockReq.source_id.set(0L);
            ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.RelationBlacklistApiImpl.1
                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                public void onResult(int i3, byte[] bArr, Bundle bundle) {
                    if (i3 != 0) {
                        QLog.d(RelationBlacklistApiImpl.TAG, 2, "sendAddBlacklistRequest, server error:" + i3);
                        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f160761vw));
                        RelationBlacklistListener relationBlacklistListener2 = relationBlacklistListener;
                        if (relationBlacklistListener2 != null) {
                            relationBlacklistListener2.onResult(false, bArr);
                            return;
                        }
                        return;
                    }
                    RelationBlacklist$BlockRsp relationBlacklist$BlockRsp = new RelationBlacklist$BlockRsp();
                    try {
                        relationBlacklist$BlockRsp.mergeFrom(bArr);
                        RelationBlacklistListener relationBlacklistListener3 = relationBlacklistListener;
                        if (relationBlacklistListener3 != null) {
                            relationBlacklistListener3.onResult(true, relationBlacklist$BlockRsp);
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            }, relationBlacklist$BlockReq.toByteArray(), OIDB_CMD_ADD_BLACK_USER, 4642, 0);
            return;
        }
        QLog.e(TAG, 1, "sendAddBlacklistRequest is invalid! uin is " + str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public void sendBlacklistCheckRequest(String str, final RelationBlacklistListener relationBlacklistListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && Friends.isValidUin(str)) {
            RelationBlacklist$CheckReq relationBlacklist$CheckReq = new RelationBlacklist$CheckReq();
            RelationBlacklist$Account relationBlacklist$Account = new RelationBlacklist$Account();
            relationBlacklist$Account.uin.set(Long.parseLong(str));
            relationBlacklist$Account.type.set(3);
            relationBlacklist$CheckReq.account.set(relationBlacklist$Account);
            relationBlacklist$CheckReq.is_check_forward.set(true);
            relationBlacklist$CheckReq.is_check_backward.set(true);
            ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.RelationBlacklistApiImpl.4
                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                public void onResult(int i3, byte[] bArr, Bundle bundle) {
                    if (i3 == 0 && bArr != null) {
                        RelationBlacklist$CheckRsp relationBlacklist$CheckRsp = new RelationBlacklist$CheckRsp();
                        try {
                            relationBlacklist$CheckRsp.mergeFrom(bArr);
                            RelationBlacklistListener relationBlacklistListener2 = relationBlacklistListener;
                            if (relationBlacklistListener2 != null) {
                                relationBlacklistListener2.onResult(true, relationBlacklist$CheckRsp);
                                return;
                            }
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    QLog.d(RelationBlacklistApiImpl.TAG, 2, "sendBlacklistCheckRequest, server error:" + i3);
                    RelationBlacklistListener relationBlacklistListener3 = relationBlacklistListener;
                    if (relationBlacklistListener3 != null) {
                        relationBlacklistListener3.onResult(false, bArr);
                    }
                }
            }, relationBlacklist$CheckReq.toByteArray(), OIDB_CMD_CHECK_BLACK_USER, 4644, 0);
            return;
        }
        QLog.e(TAG, 1, "sendBlacklistCheckRequest is invalid! uin is " + str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public void sendDeleteBlacklistRequest(String str, final RelationBlacklistListener relationBlacklistListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && Friends.isValidUin(str)) {
            RelationBlacklist$UnblockReq relationBlacklist$UnblockReq = new RelationBlacklist$UnblockReq();
            RelationBlacklist$Account relationBlacklist$Account = new RelationBlacklist$Account();
            relationBlacklist$Account.uin.set(Long.parseLong(str));
            relationBlacklist$Account.type.set(3);
            relationBlacklist$UnblockReq.account.set(relationBlacklist$Account);
            ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.RelationBlacklistApiImpl.2
                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                public void onResult(int i3, byte[] bArr, Bundle bundle) {
                    if (i3 != 0) {
                        QLog.d(RelationBlacklistApiImpl.TAG, 2, "sendDeleteBlacklistRequest, server error:" + i3);
                        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.f160761vw));
                    }
                    RelationBlacklistListener relationBlacklistListener2 = relationBlacklistListener;
                    if (relationBlacklistListener2 != null) {
                        relationBlacklistListener2.onResult(i3 == 0, bArr);
                    }
                }
            }, relationBlacklist$UnblockReq.toByteArray(), OIDB_CMD_DELE_BLACK_USER, 4643, 0);
            return;
        }
        QLog.e(TAG, 1, "sendDeleteBlacklistRequest is invalid! uin is " + str);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public void sendGetShieldListNumberRequest(final RelationBlacklistListener relationBlacklistListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.RelationBlacklistApiImpl.3
            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                if (i3 == 0 && bArr != null) {
                    RelationBlacklist$CountBlockListRsp relationBlacklist$CountBlockListRsp = new RelationBlacklist$CountBlockListRsp();
                    try {
                        relationBlacklist$CountBlockListRsp.mergeFrom(bArr);
                        RelationBlacklistListener relationBlacklistListener2 = relationBlacklistListener;
                        if (relationBlacklistListener2 != null) {
                            relationBlacklistListener2.onResult(true, relationBlacklist$CountBlockListRsp);
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                QLog.d(RelationBlacklistApiImpl.TAG, 2, "sendGetShieldListNumberRequest, server error:" + i3);
                RelationBlacklistListener relationBlacklistListener3 = relationBlacklistListener;
                if (relationBlacklistListener3 != null) {
                    relationBlacklistListener3.onResult(false, bArr);
                }
            }
        }, new RelationBlacklist$CountBlockListReq().toByteArray(), OIDB_CMD_GET_SHIELD_NUMBER, OIDB_CMD_0X122d, 0);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi
    public void sendShieldListTransferRequest(final RelationBlacklistListener relationBlacklistListener) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.profilecard.api.impl.RelationBlacklistApiImpl.5
            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                if (i3 != 0) {
                    QLog.d(RelationBlacklistApiImpl.TAG, 2, "sendShieldListTransferRequest, server error:" + i3);
                    RelationBlacklistListener relationBlacklistListener2 = relationBlacklistListener;
                    if (relationBlacklistListener2 != null) {
                        relationBlacklistListener2.onResult(false, bArr);
                        return;
                    }
                    return;
                }
                MessageMicro<RelationBlacklist$MigrateRsp> messageMicro = new MessageMicro<RelationBlacklist$MigrateRsp>() { // from class: tencent.im.oidb.cmdBlacklist.RelationBlacklist$MigrateRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0L, ""}, RelationBlacklist$MigrateRsp.class);
                    public final PBUInt64Field code = PBField.initUInt64(0);

                    /* renamed from: msg, reason: collision with root package name */
                    public final PBStringField f436004msg = PBField.initString("");
                };
                try {
                    messageMicro.mergeFrom(bArr);
                    RelationBlacklistListener relationBlacklistListener3 = relationBlacklistListener;
                    if (relationBlacklistListener3 != null) {
                        relationBlacklistListener3.onResult(true, messageMicro);
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }, new MessageMicro<RelationBlacklist$MigrateReq>() { // from class: tencent.im.oidb.cmdBlacklist.RelationBlacklist$MigrateReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RelationBlacklist$MigrateReq.class);
        }.toByteArray(), OIDB_CMD_SHIELD_TRANSFER, 4651, 0);
    }
}

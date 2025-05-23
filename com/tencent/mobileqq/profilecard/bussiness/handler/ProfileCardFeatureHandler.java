package com.tencent.mobileqq.profilecard.bussiness.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.bussiness.observer.ProfileCardFeatureObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xd9c.oidb_0xd9c$ReqBody;
import tencent.im.oidb.cmd0xd9c.oidb_0xd9c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes35.dex */
public class ProfileCardFeatureHandler extends BusinessHandler {
    public static final String CMD_GET_FRIEND_SOURCE = "OidbSvc.0xd9c_11";
    private static final String KEY_TARGET_UIN = "key_target_uin";
    private static final String TAG = "ProfileCardFeatureHandler";

    public ProfileCardFeatureHandler(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_GET_FRIEND_SOURCE);
        }
        return this.allowCmdSet;
    }

    public void getFriendSource(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getFriendSource targetUin=%s", Long.valueOf(j3)));
        }
        String currentUin = this.appRuntime.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            QLog.d(TAG, 1, String.format("getFriendSource selfUin=null", new Object[0]));
            return;
        }
        oidb_0xd9c$ReqBody oidb_0xd9c_reqbody = new oidb_0xd9c$ReqBody();
        oidb_0xd9c_reqbody.rpt_frd_uins.add(Long.valueOf(j3));
        oidb_0xd9c_reqbody.uint64_uin.set(Long.parseLong(currentUin));
        oidb_0xd9c_reqbody.uint32_need_wording.set(1);
        oidb_0xd9c_reqbody.uint32_need_desc.set(1);
        oidb_0xd9c_reqbody.uint32_basic_source.set(1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3484);
        oidb_sso_oidbssopkg.uint32_service_type.set(11);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xd9c_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(CMD_GET_FRIEND_SOURCE);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong(KEY_TARGET_UIN, j3);
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void handlerGetFriendSource(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        int resultCode = fromServiceMsg.getResultCode();
        boolean isSuccess = fromServiceMsg.isSuccess();
        toServiceMsg.extraData.getLong(KEY_TARGET_UIN);
        String str = "";
        if (isSuccess) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.has()) {
                    i3 = mergeFrom.uint32_result.get();
                    if (i3 == 0) {
                        z16 = true;
                        if (z16) {
                            try {
                                oidb_0xd9c$RspBody oidb_0xd9c_rspbody = new oidb_0xd9c$RspBody();
                                oidb_0xd9c_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                                if (oidb_0xd9c_rspbody.rpt_friend_list.has() && oidb_0xd9c_rspbody.rpt_friend_list.size() > 0) {
                                    str = oidb_0xd9c_rspbody.rpt_friend_list.get(0).bytes_source_wording.get().toStringUtf8();
                                }
                            } catch (Exception e16) {
                                e = e16;
                                resultCode = i3;
                                QLog.e(TAG, 1, "handlerGetFriendSource fail.", e);
                                isSuccess = false;
                                if (QLog.isColorLevel()) {
                                }
                                notifyUI(1001, isSuccess, new Object[]{Integer.valueOf(resultCode), str});
                            }
                        }
                        isSuccess = z16;
                        resultCode = i3;
                    }
                } else {
                    i3 = resultCode;
                }
                z16 = false;
                if (z16) {
                }
                isSuccess = z16;
                resultCode = i3;
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handlerGetFriendSource success=%s resultCode=%s", Boolean.valueOf(isSuccess), Integer.valueOf(resultCode)));
        }
        notifyUI(1001, isSuccess, new Object[]{Integer.valueOf(resultCode), str});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ProfileCardFeatureObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(serviceCmd) && CMD_GET_FRIEND_SOURCE.equals(serviceCmd)) {
            handlerGetFriendSource(toServiceMsg, fromServiceMsg, obj);
        }
    }
}

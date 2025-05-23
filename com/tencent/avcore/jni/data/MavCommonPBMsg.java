package com.tencent.avcore.jni.data;

import com.tencent.avcore.jni.data.MavAccountInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class MavCommonPBMsg {
    static IPatchRedirector $redirector_;

    /* loaded from: classes3.dex */
    public static class MavCommonChannelInfo {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "MavCommonChannelInfo";
        public int businessType;
        public int cmdType;
        public String fromAccount;
        public long groupId;
        public int relationType;
        public long roomId;

        public MavCommonChannelInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static MavCommonChannelInfo getCommonInfoByPbBuffer(byte[] bArr) {
            if (bArr == null) {
                AVCoreLog.e(TAG, "getCommonInfoByPbBuffer empty buffer");
                return null;
            }
            MavAccountInfo.MAVCommonChannelMsg mAVCommonChannelMsg = new MavAccountInfo.MAVCommonChannelMsg();
            try {
                mAVCommonChannelMsg.mergeFrom(bArr);
                MavCommonChannelInfo mavCommonChannelInfo = new MavCommonChannelInfo();
                mavCommonChannelInfo.fromAccount = mAVCommonChannelMsg.from_account.get();
                mavCommonChannelInfo.cmdType = mAVCommonChannelMsg.cmd_type.get();
                mavCommonChannelInfo.relationType = mAVCommonChannelMsg.relation_type.get();
                mavCommonChannelInfo.businessType = mAVCommonChannelMsg.business_type.get();
                mavCommonChannelInfo.roomId = mAVCommonChannelMsg.room_id.get();
                mavCommonChannelInfo.groupId = mAVCommonChannelMsg.group_id.get();
                return mavCommonChannelInfo;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                AVCoreLog.e(TAG, "getCommonInfoByPbBuffer decode pb failed");
                return null;
            }
        }
    }

    public MavCommonPBMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

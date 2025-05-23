package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCreateUpdatableMsgReq;
import NS_MINI_INTERFACE.INTERFACE$StCreateUpdatableMsgRsp;
import NS_MINI_INTERFACE.INTERFACE$StUpdatableMsgShareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CreateUpdatableMsgRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_updatablemsg.CreateUpdatableMsg";
    private static final String TAG = "CreateUpdatableMsgRequest";
    public static final int UPDATABLE_MSG_FROM_AUDIT = 3;
    public static final int UPDATABLE_MSG_FROM_EXPERIENCE = 2;
    public static final int UPDATABLE_MSG_FROM_ONLINE = 1;
    private INTERFACE$StCreateUpdatableMsgReq req;

    public CreateUpdatableMsgRequest(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr) {
        INTERFACE$StCreateUpdatableMsgReq iNTERFACE$StCreateUpdatableMsgReq = new INTERFACE$StCreateUpdatableMsgReq();
        this.req = iNTERFACE$StCreateUpdatableMsgReq;
        iNTERFACE$StCreateUpdatableMsgReq.appid.set(str);
        this.req.templateId.set(str2);
        this.req.from.set(i3);
        this.req.serviceType.set(i18);
        if (bArr != null) {
            this.req.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        INTERFACE$StUpdatableMsgShareInfo iNTERFACE$StUpdatableMsgShareInfo = new INTERFACE$StUpdatableMsgShareInfo();
        iNTERFACE$StUpdatableMsgShareInfo.scene.set(i16);
        if (i17 > 0) {
            iNTERFACE$StUpdatableMsgShareInfo.subScene.set(i17);
        }
        if (i16 == 0) {
            iNTERFACE$StUpdatableMsgShareInfo.groupId.set(str3);
            iNTERFACE$StUpdatableMsgShareInfo.chatUin.set("");
        } else if (i16 != 1) {
            QLog.e(TAG, 2, "Create StUpdatableMsgShareInfo with wrong scene:" + i16);
        } else {
            iNTERFACE$StUpdatableMsgShareInfo.chatUin.set(str3);
            iNTERFACE$StUpdatableMsgShareInfo.groupId.set("");
        }
        this.req.shareInfo.set(iNTERFACE$StUpdatableMsgShareInfo);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, NS_MINI_INTERFACE.INTERFACE$StCreateUpdatableMsgRsp] */
    public static INTERFACE$StCreateUpdatableMsgRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<INTERFACE$StCreateUpdatableMsgRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StCreateUpdatableMsgRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StCreateUpdatableMsgRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
        };
        try {
            r06.mergeFrom(ProtoBufRequest.decode(bArr));
            return r06;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}

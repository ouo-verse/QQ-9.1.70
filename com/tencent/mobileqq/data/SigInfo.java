package com.tencent.mobileqq.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import tencent.im.msg.im_msg_body$CustomFace;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SigInfo {
    public byte[] sessionKey;
    public byte[] signature;
    public short wSignatureLen;

    public static void fillCustomFaceSessionKey(AppInterface appInterface, im_msg_body$CustomFace im_msg_body_customface) {
        byte[] sessionKey = ((IPicTransFile) appInterface.getRuntimeService(IPicTransFile.class, "")).getSessionKey();
        if (sessionKey != null) {
            im_msg_body_customface.bytes_signature.set(ByteStringMicro.copyFrom(sessionKey));
        }
    }
}

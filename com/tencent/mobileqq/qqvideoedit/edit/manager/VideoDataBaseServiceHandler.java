package com.tencent.mobileqq.qqvideoedit.edit.manager;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class VideoDataBaseServiceHandler extends BusinessHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    public VideoDataBaseServiceHandler(AppInterface appInterface) {
        super(appInterface);
    }

    public abstract Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    public final <T> T E2(byte[] bArr, String str, T t16) {
        nj2.a aVar = new nj2.a(true);
        try {
            aVar.setEncodeName("utf-8");
            aVar.decode(bArr);
            return (T) aVar.getByClass(str, t16);
        } catch (Exception unused) {
            return null;
        }
    }

    public abstract boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket);
}

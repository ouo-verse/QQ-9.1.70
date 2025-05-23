package com.tencent.mobileqq.wink.edit.manager;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class WinkDataBaseServiceHandler extends BusinessHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    public WinkDataBaseServiceHandler(AppInterface appInterface) {
        super(appInterface);
    }

    public abstract Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    public final <T> T E2(byte[] bArr, String str, T t16) {
        x53.a aVar = new x53.a(true);
        try {
            aVar.setEncodeName("utf-8");
            aVar.decode(bArr);
            return (T) aVar.getByClass(str, t16);
        } catch (Throwable th5) {
            QLog.e("WinkDataBaseServiceHandler", 1, "decodeCompressPacked... exception:", th5);
            return null;
        }
    }

    public abstract boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket);
}

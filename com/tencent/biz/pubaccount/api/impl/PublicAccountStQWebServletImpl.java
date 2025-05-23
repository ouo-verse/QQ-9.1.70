package com.tencent.biz.pubaccount.api.impl;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.biz.pubaccount.api.IPublicAccountStQWebServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes32.dex */
public class PublicAccountStQWebServletImpl extends PublicAccountServletImpl implements IPublicAccountStQWebServlet {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl
    public byte[] getResponseBytesData(FromServiceMsg fromServiceMsg) {
        byte[] responseBytesData = super.getResponseBytesData(fromServiceMsg);
        if (responseBytesData == null) {
            return null;
        }
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(responseBytesData);
            return stQWebRsp.busiBuff.get().toByteArray();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}

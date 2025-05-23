package com.tencent.ilinkservice;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkTdiCloneSessionImpl implements IlinkTdiCloneSessionInterface {
    private final String TAG = "IlinkServiceTdiClone";
    private TdiCloneCallback m_callback_;
    private int m_clone_id_;
    private IlinkTdiSessionImpl m_master_;

    public IlinkTdiCloneSessionImpl(int i3, IlinkTdiSessionImpl ilinkTdiSessionImpl) {
        this.m_clone_id_ = i3;
        this.m_master_ = ilinkTdiSessionImpl;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void cancelAppRequest(int i3) {
        this.m_master_.cloneCancelAppRequest(this.m_clone_id_, i3);
    }

    public int getCloneId() {
        return this.m_clone_id_;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public TdiApiProto.TdiUserInfo getUserInfo() {
        return this.m_master_.cloneGetUserInfo();
    }

    public void onCloneDestroyed() {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiClone", "onCloneDestroyed", new Object[0]);
        TdiCloneCallback tdiCloneCallback = this.m_callback_;
        if (tdiCloneCallback != null) {
            tdiCloneCallback.onCloneDestroyed();
        }
    }

    public void onReceiveAppMessage(byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiClone", "onReceiveAppMessage", new Object[0]);
        TdiCloneCallback tdiCloneCallback = this.m_callback_;
        if (tdiCloneCallback != null) {
            try {
                tdiCloneCallback.onReceiveAppMessage(TdiApiProto.TdiAppMessage.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void onReceiveAppResponse(int i3, int i16, byte[] bArr) {
        IlinkServiceLogImpl.getInstance().d("IlinkServiceTdiClone", "clone onReceiveAppResponse error:" + i16 + ", taskid:" + i3, new Object[0]);
        TdiCloneCallback tdiCloneCallback = this.m_callback_;
        if (tdiCloneCallback != null) {
            try {
                tdiCloneCallback.onReceiveAppResponse(i3, i16, TdiApiProto.TdiAppResponse.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public int sendAppRequest(TdiApiProto.TdiAppRequest tdiAppRequest) {
        return this.m_master_.cloneSendAppRequest(this.m_clone_id_, tdiAppRequest);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setCallback(TdiCloneCallback tdiCloneCallback) {
        this.m_callback_ = tdiCloneCallback;
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setSmcBaseInfo(IlinkServiceProto.IlinkSmcBaseInfo ilinkSmcBaseInfo) {
        this.m_master_.setSmcBaseInfo(ilinkSmcBaseInfo);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void setSmcUin(int i3) {
        this.m_master_.setSmcUin(i3);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17) {
        this.m_master_.writeKvData(i3, bArr, z16, i16, z17, i17);
    }

    @Override // com.tencent.ilinkservice.IlinkTdiCloneSessionInterface
    public void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17) {
        this.m_master_.writeKvData(i3, bArr, z16, i16, z17);
    }
}

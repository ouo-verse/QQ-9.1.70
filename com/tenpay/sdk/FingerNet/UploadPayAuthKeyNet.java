package com.tenpay.sdk.FingerNet;

import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadKeyNet;

/* loaded from: classes27.dex */
public class UploadPayAuthKeyNet implements IWrapUploadKeyNet {
    private ISoterNetCallback<IWrapUploadKeyNet.UploadResult> mCallback = null;

    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void execute() {
        ISoterNetCallback<IWrapUploadKeyNet.UploadResult> iSoterNetCallback = this.mCallback;
        if (iSoterNetCallback != null) {
            iSoterNetCallback.onNetEnd(new IWrapUploadKeyNet.UploadResult(true));
        }
    }

    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void setCallback(ISoterNetCallback<IWrapUploadKeyNet.UploadResult> iSoterNetCallback) {
        this.mCallback = iSoterNetCallback;
    }

    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetBaseWrapper
    public void setRequest(IWrapUploadKeyNet.UploadRequest uploadRequest) {
    }
}

package com.qzone.proxy.vipcomponent.adapter;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.vipcomponent.adapter.IVipManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipRequestWrapper extends QZoneRequest {
    protected IVipManager.RequestCallbackListener mRequestCallbackListener;
    protected ServiceCallbackWrapper mServiceCallbackWrapper;

    protected VipRequestWrapper(String str) {
        super(str);
        this.mServiceCallbackWrapper = null;
        this.mRequestCallbackListener = null;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public IVipManager.RequestCallbackListener getRequestCallbackListener() {
        return this.mRequestCallbackListener;
    }

    public ServiceCallbackWrapper getServiceCallbackWrapper() {
        return this.mServiceCallbackWrapper;
    }

    public void setRequestCallbackListener(IVipManager.RequestCallbackListener requestCallbackListener) {
        this.mRequestCallbackListener = requestCallbackListener;
    }

    public void setServiceCallbackWrapper(ServiceCallbackWrapper serviceCallbackWrapper) {
        this.mServiceCallbackWrapper = serviceCallbackWrapper;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        String[] split;
        String requestCmd = getRequestCmd();
        return (TextUtils.isEmpty(requestCmd) || (split = requestCmd.split("\\.")) == null || split.length <= 0) ? requestCmd : split[split.length - 1];
    }

    public VipRequestWrapper(String str, JceStruct jceStruct) {
        super(str);
        this.mServiceCallbackWrapper = null;
        this.mRequestCallbackListener = null;
        this.req = jceStruct;
    }
}

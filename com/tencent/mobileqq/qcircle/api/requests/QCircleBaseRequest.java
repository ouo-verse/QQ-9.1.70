package com.tencent.mobileqq.qcircle.api.requests;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import androidx.annotation.Nullable;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.request.VSNetQUICUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class QCircleBaseRequest extends VSBaseRequest {
    private static final String KEY_GW_RP_TRANSFER = "gwRPTransfer";

    private void addCompressType(PROTOCAL.StQWebReq stQWebReq) {
        if (!isGzipCompressed()) {
            QLog.i(BaseRequest.TAG, 2, "not contains gip cmd");
            return;
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("fc-compress-type");
        entry.value.set("gz");
        stQWebReq.Extinfo.add(entry);
    }

    private String getGwRpTransfer(PROTOCAL.StQWebRsp stQWebRsp) {
        if (stQWebRsp != null && !stQWebRsp.Extinfo.isEmpty()) {
            for (COMM.Entry entry : stQWebRsp.Extinfo.get()) {
                if (entry != null && KEY_GW_RP_TRANSFER.equals(entry.key.get())) {
                    return entry.value.get();
                }
            }
        }
        return null;
    }

    protected String getAttachInfo() {
        return null;
    }

    public QCircleAlphaUserReportDataBuilder getCmdSuccessRateEventData(BaseRequest baseRequest, PROTOCAL.StQWebRsp stQWebRsp, @Nullable Object obj) {
        long ssoResultCode;
        String ssoFailMsg;
        if (getSsoResultCode() == 1000 && stQWebRsp != null) {
            ssoResultCode = stQWebRsp.retCode.get();
            ssoFailMsg = stQWebRsp.errMsg.get().toStringUtf8();
        } else {
            ssoResultCode = getSsoResultCode();
            ssoFailMsg = getSsoFailMsg();
        }
        return VSNetQUICUtils.wrapQUIC(baseRequest, new QCircleAlphaUserReportDataBuilder().setCmd(getCmdName()).setSvrRetCode(String.valueOf(ssoResultCode)).setRetCode(getRetCode()).setInfo(getInfo()).setMsg(ssoFailMsg).setTimeCost(getNetworkTimeCost()).setUrl(getUrl()).setRate(getRate()).setType(getType()).setRefer(getRefer()).setAttachInfo(getAttachInfo()).setExtraInfo(getTraceId()).setCount(getCount()).setState(getState()).setFeedId(getFeedId()).setUser(getUser()).setExtras(getExtras()).setGwRpTransfer(getGwRpTransfer(stQWebRsp)));
    }

    protected int getCount() {
        return 0;
    }

    protected HashMap<String, String> getExtras() {
        return null;
    }

    protected String getFeedId() {
        return null;
    }

    protected String getInfo() {
        return null;
    }

    protected double getRate() {
        return 0.0d;
    }

    protected String getRefer() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(byteStringMicro));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set("92");
        stQWebReq.Extinfo.add(entry);
        COMM.Entry entry2 = new COMM.Entry();
        entry2.key.set("sw-plugin-qua");
        entry2.value.set(((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getPluginQUA());
        stQWebReq.Extinfo.add(entry2);
        COMM.Entry entry3 = new COMM.Entry();
        entry3.key.set("environment_id");
        entry3.value.set(QCircleHostGlobalInfo.getCurMsfServerId());
        stQWebReq.Extinfo.add(entry3);
        addCompressType(stQWebReq);
        return stQWebReq.toByteArray();
    }

    protected String getRetCode() {
        return null;
    }

    protected String getState() {
        return null;
    }

    protected String getType() {
        return null;
    }

    protected String getUrl() {
        return null;
    }

    protected String getUser() {
        return null;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public void reportCmdSuccessRate(final BaseRequest baseRequest, final PROTOCAL.StQWebRsp stQWebRsp, @Nullable final Object obj) {
        super.reportCmdSuccessRate(baseRequest, stQWebRsp, obj);
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest.1
            @Override // java.lang.Runnable
            public void run() {
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportCmdSuccessRateEvent(QCircleBaseRequest.this.getCmdSuccessRateEventData(baseRequest, stQWebRsp, obj));
            }
        });
    }
}

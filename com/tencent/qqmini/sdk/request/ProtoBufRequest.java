package com.tencent.qqmini.sdk.request;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class ProtoBufRequest {
    public static final int JSON_CONTENT_TYPE = 1;
    public static final String KEY_ERROR_MSG = "errMsg";
    public static final String KEY_RETURN_CODE = "retCode";
    public static final int PB_CONTENT_TYPE = 0;
    public static final String TAG = "ProtoBufRequest";
    private static volatile AtomicInteger sSeq = new AtomicInteger(0);
    public int seqNo;

    private String getTraceId() {
        String account = LoginManager.getInstance().getAccount();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        sb5.append(account);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] decode(byte[] bArr) {
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(bArr);
            return stQWebRsp.busiBuff.get().toByteArray();
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "decode fail.", e16);
            return null;
        }
    }

    public byte[] encode() {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        int incrementAndGet = sSeq.incrementAndGet();
        this.seqNo = incrementAndGet;
        stQWebReq.Seq.set(incrementAndGet);
        stQWebReq.traceid.set(getTraceId());
        if (QUAUtil.getQUA() != null) {
            stQWebReq.qua.set(QUAUtil.getQUA());
        }
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy.getDeviceInfo() != null) {
            stQWebReq.deviceInfo.set(channelProxy.getDeviceInfo());
        }
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
        stQWebReq.Module.set(getModule());
        stQWebReq.Cmdname.set(getCmdName());
        PROTOCAL.StAuthInfo stAuthInfo = new PROTOCAL.StAuthInfo();
        if (LoginManager.getInstance().getAccount() != null) {
            stAuthInfo.uin.set(LoginManager.getInstance().getAccount());
        }
        if (LoginManager.getInstance().getLoginSig() != null) {
            stAuthInfo.sig.set(ByteStringMicro.copyFrom(LoginManager.getInstance().getLoginSig()));
        }
        stAuthInfo.type.set(LoginManager.getInstance().getLoginType());
        if (!QUAUtil.isQQApp() && LoginManager.getInstance().getPlatformId() != null) {
            stAuthInfo.platform.set(LoginManager.getInstance().getPlatformId());
        }
        if (LoginManager.getInstance().getPayOpenId() != null) {
            stAuthInfo.openid.set(LoginManager.getInstance().getPayOpenId());
        }
        if (LoginManager.getInstance().getAppId() != null) {
            stAuthInfo.appid.set(LoginManager.getInstance().getAppId());
        }
        if (LoginManager.getInstance().getPayOpenKey() != null) {
            stAuthInfo.sessionkey.set(ByteStringMicro.copyFrom(LoginManager.getInstance().getPayOpenKey().getBytes()));
        }
        stQWebReq.loginSig.set(stAuthInfo);
        stQWebReq.contentType.set(getContentType());
        QMLog.d("ProtoBufRequest", "cmd : " + stQWebReq.Cmdname.get() + "  traceId:" + stQWebReq.traceid.get());
        return stQWebReq.toByteArray();
    }

    protected abstract byte[] getBusiBuf();

    protected abstract String getCmdName();

    public String getCmdString() {
        return "";
    }

    public int getContentType() {
        return 0;
    }

    protected abstract String getModule();

    public JSONObject getResponse(byte[] bArr) {
        try {
            PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
            stQWebRsp.mergeFrom(bArr);
            byte[] byteArray = stQWebRsp.busiBuff.get().toByteArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", stQWebRsp.retCode.get());
            jSONObject.put("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
            JSONObject response = getResponse(byteArray, jSONObject);
            if (response != null) {
                return response;
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("ProtoBufRequest", "Failed to getResponse", e16);
            return null;
        }
    }

    public abstract JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception;

    public String toString() {
        return "ProtoBufRequest{seqNo=" + this.seqNo + ",CmdName=" + getCmdName() + '}';
    }
}

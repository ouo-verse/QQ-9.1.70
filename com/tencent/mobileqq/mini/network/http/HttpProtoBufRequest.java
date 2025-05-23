package com.tencent.mobileqq.mini.network.http;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public abstract class HttpProtoBufRequest {
    public static final String KEY_ERROR_MSG = "errMsg";
    public static final String KEY_RETURN_CODE = "retCode";
    public static final String TAG = "HttpProtoBufRequest";
    private static volatile AtomicInteger sSeq = new AtomicInteger(0);
    public int seqNo;

    public static byte[] decode(byte[] bArr) {
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(bArr);
            return stQWebRsp.busiBuff.get().toByteArray();
        } catch (Exception e16) {
            QLog.d(TAG, 1, "decode exception: " + Log.getStackTraceString(e16));
            return null;
        }
    }

    private String getTraceId() {
        String loginMiniAppUin = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        sb5.append(loginMiniAppUin);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        String sb6 = sb5.toString();
        QLog.d("miniapp-cmd", 1, "[https]. send request cmd=" + getCmdName() + " traceId=" + sb6);
        return sb6;
    }

    public byte[] encode() {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        int incrementAndGet = sSeq.incrementAndGet();
        this.seqNo = incrementAndGet;
        stQWebReq.Seq.set(incrementAndGet);
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
        stQWebReq.traceid.set(getTraceId());
        stQWebReq.Module.set(getModule());
        stQWebReq.Cmdname.set(getCmdName());
        PROTOCAL.StAuthInfo stAuthInfo = new PROTOCAL.StAuthInfo();
        stAuthInfo.uin.set(MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
        stQWebReq.loginSig.set(stAuthInfo);
        return stQWebReq.toByteArray();
    }

    protected abstract byte[] getBusiBuf();

    protected abstract String getCmdName();

    protected abstract String getModule();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract JSONObject onResponse(int i3, byte[] bArr);
}

package com.tencent.mobileqq.msf.core.f0.c.d;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.x.m;
import com.tencent.mobileqq.msf.core.x.o;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msfcore.MSFRequestAdapter;
import com.tencent.mobileqq.msfcore.MSFResponseAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sign.QQSecuritySign;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248095a = "MSF.C.ServiceMsgAdapter";

    /* renamed from: b, reason: collision with root package name */
    private static final int f248096b = 4;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int b(MSFResponseAdapter mSFResponseAdapter) {
        int state = mSFResponseAdapter.getState();
        int failReason = mSFResponseAdapter.getFailReason();
        int ssoRet = mSFResponseAdapter.getSsoRet();
        if (state == 3 && ssoRet == 0) {
            return 1000;
        }
        if (state == 4 && failReason == 4) {
            return ssoRet;
        }
        return 1002;
    }

    private int c(ToServiceMsg toServiceMsg) {
        if (o.x().d().contains(toServiceMsg.getServiceCmd())) {
            return 100;
        }
        return 50;
    }

    private HashMap<String, byte[]> d(ToServiceMsg toServiceMsg) {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        for (Map.Entry<String, byte[]> entry : toServiceMsg.getTransInfo().entrySet()) {
            if (entry != null && o.x().k().contains(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue());
                if (QLog.isColorLevel()) {
                    QLog.d(f248095a, 2, "transInfo set key: " + entry.getKey());
                }
            }
        }
        return hashMap;
    }

    private boolean e(ToServiceMsg toServiceMsg) {
        if (!o.x().e().contains(toServiceMsg.getServiceCmd()) && ((TextUtils.isEmpty(toServiceMsg.getServiceCmd()) || !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT)) && ((!BaseConstants.CMD_REQUEST_CONFIG.equals(toServiceMsg.getServiceCmd()) || !((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_DISABLE_MERGE, Boolean.FALSE)).booleanValue()) && (m.g() || (!toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG) && !com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg.getServiceCmd())))))) {
            return false;
        }
        return true;
    }

    public MSFRequestAdapter a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MSFRequestAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        }
        MSFRequestAdapter mSFRequestAdapter = new MSFRequestAdapter();
        mSFRequestAdapter.setSeq(toServiceMsg.getRequestSsoSeq());
        mSFRequestAdapter.setCmd(toServiceMsg.getServiceCmd());
        mSFRequestAdapter.setUin(toServiceMsg.getUin());
        mSFRequestAdapter.setOptions(b(toServiceMsg));
        mSFRequestAdapter.setPriority(c(toServiceMsg));
        if (toServiceMsg.getTimeout() <= TTL.MAX_VALUE && toServiceMsg.getTimeout() > 0) {
            mSFRequestAdapter.setTimeout((int) (toServiceMsg.getTimeout() / 1000));
        } else {
            mSFRequestAdapter.setTimeout(30);
        }
        mSFRequestAdapter.setUinType(toServiceMsg.getUinType());
        mSFRequestAdapter.setUid(MsfCore.sCore.getAccountCenter().g().d(toServiceMsg.getUin()));
        if (!TextUtils.isEmpty(toServiceMsg.getTraceInfo())) {
            mSFRequestAdapter.setTraceInfo(toServiceMsg.getTraceInfo());
        }
        byte[] wupBuffer = toServiceMsg.getWupBuffer();
        if (wupBuffer.length < 4) {
            wupBuffer = MsfMsgUtil.addByteLen(wupBuffer);
        }
        mSFRequestAdapter.setData(wupBuffer);
        mSFRequestAdapter.setTransInfo(d(toServiceMsg));
        a(mSFRequestAdapter, toServiceMsg);
        return mSFRequestAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private int b(ToServiceMsg toServiceMsg) {
        boolean isNeedCallback = toServiceMsg.isNeedCallback();
        boolean z16 = isNeedCallback;
        if (toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG)) {
            z16 = (isNeedCallback ? 1 : 0) | '@';
        }
        boolean z17 = z16;
        if (e(toServiceMsg)) {
            z17 = (z16 ? 1 : 0) | '\b';
        }
        ?? r06 = z17;
        if (!toServiceMsg.isSupportRetry()) {
            r06 = (z17 ? 1 : 0) | 2;
        }
        return o.x().g().contains(toServiceMsg.getServiceCmd()) ? r06 | 16 : r06;
    }

    public FromServiceMsg a(MSFResponseAdapter mSFResponseAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mSFResponseAdapter);
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), mSFResponseAdapter.getSeq(), mSFResponseAdapter.getUin(), mSFResponseAdapter.getCmd());
        fromServiceMsg.setUinType(mSFResponseAdapter.getUinType());
        fromServiceMsg.putWupBuffer(mSFResponseAdapter.getRecvData());
        int b16 = b(mSFResponseAdapter);
        fromServiceMsg.setRequestSsoSeq(mSFResponseAdapter.getSeq());
        fromServiceMsg.setBusinessFail(b16, mSFResponseAdapter.getSsoErrTips());
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SEND_TIME, Long.valueOf(mSFResponseAdapter.getSendTime()));
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_WRITE_SOCKET_TIME, Long.valueOf(mSFResponseAdapter.getWriteSocketTime()));
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_RECV_TIME, Long.valueOf(mSFResponseAdapter.getRecvTime()));
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_RECV_WAY, Integer.valueOf(mSFResponseAdapter.getRecvWay()));
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_IS_BAD_NETWORK, Boolean.valueOf(mSFResponseAdapter.getIsBadNetwork()));
        if (b16 == 1000) {
            fromServiceMsg.setTrpcRspRetCode(mSFResponseAdapter.getTrpcRetcode());
            fromServiceMsg.setTrpcRspFuncRetCode(mSFResponseAdapter.getTrpcFuncRetCode());
            fromServiceMsg.setTrpcRspErrorMsg(mSFResponseAdapter.getTrpcErrMsg());
            if (mSFResponseAdapter.getHasReserveFields()) {
                fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_FLAG, Integer.valueOf(mSFResponseAdapter.getSecSignFlag()));
            }
            fromServiceMsg.setIsColorLevel(mSFResponseAdapter.getIsUinDyed());
            HashMap<String, byte[]> transInfo = mSFResponseAdapter.getTransInfo();
            if (transInfo != null) {
                for (Map.Entry<String, byte[]> entry : transInfo.entrySet()) {
                    if (entry != null) {
                        fromServiceMsg.addTransInfo(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return fromServiceMsg;
    }

    private void a(MSFRequestAdapter mSFRequestAdapter, ToServiceMsg toServiceMsg) {
        long j3;
        byte[] bArr;
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion() && com.tencent.mobileqq.msf.core.d0.a.c().a() == 0) {
            return;
        }
        try {
            if (!com.tencent.mobileqq.msf.core.d0.a.c().d()) {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mobileqq.msf.core.d0.a.c().a(MsfCore.sCore, com.tencent.mobileqq.msf.core.o.k());
                if (QLog.isColorLevel()) {
                    QLog.d(f248095a, 2, "[FEKitManager], init cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_INIT_COST_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            String serviceCmd = toServiceMsg.getServiceCmd();
            long currentTimeMillis2 = System.currentTimeMillis();
            QQSecuritySign.SignResult a16 = com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg, serviceCmd);
            if (a16 == null || (bArr = a16.sign) == null) {
                j3 = currentTimeMillis2;
            } else {
                int length = bArr.length;
                byte[] bArr2 = a16.token;
                int length2 = bArr2 == null ? 0 : bArr2.length;
                byte[] bArr3 = a16.extra;
                int length3 = bArr3 == null ? 0 : bArr3.length;
                if (QLog.isColorLevel()) {
                    QLog.d(f248095a, 2, "[FEKitManager], set sign of cmd = " + serviceCmd + "\n sign = " + MsfSdkUtils.getShortHexString(a16.sign, Math.min(length / 2, 8)) + ", len = " + length + "\n token = " + MsfSdkUtils.getShortHexString(a16.token, Math.min(length2 / 2, 8)) + ", len = " + length2 + "\n extra = " + MsfSdkUtils.getShortHexString(a16.extra, Math.min(length3 / 2, 8)) + ", len = " + length3);
                }
                mSFRequestAdapter.setSecSign(a16.sign);
                byte[] bArr4 = a16.token;
                if (bArr4 == null) {
                    bArr4 = new byte[0];
                }
                mSFRequestAdapter.setSecDeviceToken(bArr4);
                byte[] bArr5 = a16.extra;
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                mSFRequestAdapter.setSecExtra(bArr5);
                j3 = System.currentTimeMillis();
                toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_IS_SECURITY_SIGN, Boolean.TRUE);
                toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_COST_TIME, Long.valueOf(j3 - currentTimeMillis2));
            }
            if (QLog.isColorLevel()) {
                QLog.d(f248095a, 2, "[FEKitManager] set security sign cost time = " + (j3 - currentTimeMillis2));
            }
        } catch (Exception e16) {
            QLog.e(f248095a, 1, "[FEKitManager] set sign error", e16);
        }
    }
}

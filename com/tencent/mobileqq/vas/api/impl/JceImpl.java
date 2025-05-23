package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.RemoteException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.AbsProtocol;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJceSSo;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class JceImpl extends AbsProtocol implements IJce {

    /* renamed from: d, reason: collision with root package name */
    private static String f308469d = ((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName();
    private String mCmd;
    private HashMap<String, JceStruct> mJceRespMap;
    private String mReqType;
    private String mRspType;
    private String mServantName;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends EIPCCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f308470d;

        a(BusinessObserver businessObserver) {
            this.f308470d = businessObserver;
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
            Bundle bundle;
            if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
                Serializable serializable = bundle.getSerializable(PbProtocolSSoImpl.RESP_KEY_IS_DATA);
                boolean z16 = eIPCResult.data.getBoolean("isSuccess");
                int i3 = eIPCResult.data.getInt("type");
                BusinessObserver businessObserver = this.f308470d;
                if (businessObserver != null) {
                    businessObserver.onUpdate(i3, z16, serializable);
                }
            }
        }
    }

    public JceImpl() {
        this.mJceRespMap = new HashMap<>();
        this.mReqType = "req";
        this.mRspType = "rsp";
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public IJce build(String str, String str2) {
        return new JceImpl(str, str2);
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, UniPacket uniPacket) {
        String reqSeq = IJce.Util.reqSeq(toServiceMsg);
        ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).unRegisterSeqKey(reqSeq);
        if (this.mJceRespMap.containsKey(reqSeq)) {
            JceStruct jceStruct = this.mJceRespMap.get(reqSeq);
            this.mJceRespMap.remove(reqSeq);
            return uniPacket.getByClass(this.mRspType, jceStruct);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public void encode(ToServiceMsg toServiceMsg, UniPacket uniPacket, int i3) {
        uniPacket.setServantName(this.mServantName);
        uniPacket.setFuncName(toServiceMsg.extraData.getString("funcName"));
        uniPacket.setRequestId(i3);
        uniPacket.put(this.mReqType, toServiceMsg.extraData.get("req"));
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public String getCmd() {
        return this.mCmd;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return getClass().getName();
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public void request(String str, JceStruct jceStruct, JceStruct jceStruct2, BusinessObserver businessObserver, boolean z16) {
        String str2 = MobileQQ.processName;
        if (str2 == null) {
            return;
        }
        if (!str2.equals(BaseApplication.getContext().getPackageName())) {
            ((IJceSSo) RemoteProxy.getProxy(k.class)).request(str, jceStruct, jceStruct2, new a(businessObserver), z16, this);
            return;
        }
        JceStruct interceptJce = interceptJce(this.mServantName, this.mCmd, str, jceStruct);
        if (interceptJce != null) {
            onJceCallBack(interceptJce, businessObserver);
            return;
        }
        AppInterface appInterface = VasUtil.getAppInterface();
        ToServiceMsg createToServiceMsg = ((ISVIPHandler) appInterface.getBusinessHandler(f308469d)).createToServiceMsg(this.mCmd, businessObserver, z16);
        String reqSeq = IJce.Util.reqSeq(createToServiceMsg);
        this.mJceRespMap.put(reqSeq, jceStruct2);
        ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).registerSeqKey(this, reqSeq);
        createToServiceMsg.extraData.putSerializable("req", jceStruct);
        createToServiceMsg.extraData.putString("funcName", str);
        appInterface.sendToService(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public IJce build(String str, String str2, int i3) {
        return new JceImpl(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.vas.api.IJce
    public IJce build(String str, String str2, String str3, String str4) {
        return new JceImpl(str, str2, str3, str4);
    }

    @Deprecated
    public JceImpl(String str, String str2) {
        this.mJceRespMap = new HashMap<>();
        this.mReqType = "req";
        this.mRspType = "rsp";
        this.mCmd = str2;
        this.mServantName = str;
        if (com.tencent.mobileqq.service.a.c(str2)) {
            return;
        }
        com.tencent.mobileqq.service.a.g(str2, new String[]{f308469d});
    }

    public JceImpl(String str, String str2, int i3) {
        this(str, str2);
        if (i3 == 2) {
            this.mReqType = "stReq";
            this.mRspType = "stRsp";
        }
    }

    public JceImpl(String str, String str2, String str3, String str4) {
        this(str, str2);
        this.mCmd = str2;
        this.mServantName = str;
        com.tencent.mobileqq.service.a.a(str2, f308469d);
        this.mReqType = str3;
        this.mRspType = str4;
    }
}

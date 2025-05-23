package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class BaseHandler implements RichProtoProc.RichProtoHandler, ProtoReqManagerImpl.IProtoRespBack, AppConstants.RichMediaErrorCode {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.BaseHandler";
    int mReqUrlCount;

    public BaseHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mReqUrlCount = 0;
        }
    }

    public static int getHandlerNetType() {
        return getHandlerNetType(NetworkCenter.getInstance().getNetType());
    }

    public static String getTimeoutReasonForRichMedia(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            if (fromServiceMsg.getResultCode() == 1013) {
                return String.valueOf(1013);
            }
            if (fromServiceMsg.getResultCode() == 1002) {
                String str = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, "timeout_reason_UNKNOWN");
                if (str.equals(n.V)) {
                    return "timeout_reason_SERVER_NO_RESPONSE";
                }
                return str;
            }
            return null;
        }
        return null;
    }

    public void cancel(RichProto.RichProtoReq richProtoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) richProtoReq);
        }
    }

    protected void handleSucResp(FromServiceMsg fromServiceMsg, byte[] bArr, RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp, StatictisInfo statictisInfo, ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fromServiceMsg, bArr, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
        }
    }

    abstract void initResps(RichProto.RichProtoReq richProtoReq);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inner_sendToProtoReq(RichProto.RichProtoReq richProtoReq, ProtoReqManagerImpl.ProtoReq protoReq) {
        initResps(richProtoReq);
        richProtoReq.protoReq = protoReq;
        IProtoReqManager iProtoReqManager = richProtoReq.protoReqMgr;
        if (iProtoReqManager != null) {
            iProtoReqManager.sendProtoReq(protoReq);
        }
    }

    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) protoResp, (Object) protoReq);
            return;
        }
        FromServiceMsg fromServiceMsg = protoResp.resp;
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        RichProto.RichProtoReq richProtoReq = (RichProto.RichProtoReq) protoReq.busiData;
        RichProto.RichProtoResp richProtoResp = richProtoReq.resp;
        StatictisInfo statictisInfo = protoResp.statisInfo;
        if (fromServiceMsg.getResultCode() != 1000) {
            String str3 = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, "");
            if (!str3.equals(n.V) && !str3.equals("")) {
                setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_CON_ERRO, str3, fromServiceMsg.getBusinessFailMsg(), statictisInfo, richProtoResp.resps);
            } else {
                int resultCode = fromServiceMsg.getResultCode();
                if (resultCode != 1002 && resultCode != 1013) {
                    String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
                    if (businessFailMsg == null) {
                        str2 = "";
                    } else {
                        str2 = businessFailMsg;
                    }
                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQUEST_MSF_ERROR, String.valueOf(resultCode), str2, statictisInfo, richProtoResp.resps);
                } else {
                    String timeoutReasonForRichMedia = getTimeoutReasonForRichMedia(fromServiceMsg);
                    String businessFailMsg2 = fromServiceMsg.getBusinessFailMsg();
                    if (businessFailMsg2 == null) {
                        str = "";
                    } else {
                        str = businessFailMsg2;
                    }
                    setResult(-1, AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT, timeoutReasonForRichMedia, str, statictisInfo, richProtoResp.resps);
                }
            }
        } else {
            handleSucResp(fromServiceMsg, wupBuffer, richProtoReq, richProtoResp, statictisInfo, protoResp, protoReq);
        }
        RichProtoProc.onBusiProtoResp(richProtoReq, richProtoResp);
    }

    public void setResult(int i3, int i16, String str, String str2, StatictisInfo statictisInfo, List<RichProto.RichProtoResp.RespCommon> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, statictisInfo, list);
            return;
        }
        Iterator<RichProto.RichProtoResp.RespCommon> it = list.iterator();
        while (it.hasNext()) {
            setResult(i3, i16, str, str2, statictisInfo, it.next());
        }
    }

    public boolean shouldRetryByRetCodeForGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (i3 != 196 && i3 != 194 && i3 != 197 && i3 != 199 && i3 != 200 && i3 != 201 && i3 != 203 && i3 != 202) {
            return true;
        }
        return false;
    }

    public static int getHandlerNetType(int i3) {
        int i16 = 3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i16 = 7;
                } else if (i3 == 4) {
                    i16 = 8;
                }
            }
            i16 = 6;
        }
        String apnType = NetworkCenter.getInstance().getApnType();
        if (apnType == null || !apnType.contains("wap")) {
            return i16;
        }
        return 5;
    }

    public void setResult(int i3, int i16, String str, String str2, StatictisInfo statictisInfo, RichProto.RichProtoResp.RespCommon respCommon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, statictisInfo, respCommon);
            return;
        }
        respCommon.result = i3;
        respCommon.errCode = i16;
        respCommon.reason = str;
        respCommon.errStr = str2;
        if (i3 == 0) {
            respCommon.successCount = 1;
            respCommon.failCount = statictisInfo.retryCount - 1;
            return;
        }
        respCommon.successCount = 0;
        respCommon.failCount = statictisInfo.retryCount;
        QLog.i(TAG, 1, "result:" + i3 + " errCode:" + i16 + " reason:" + str + " errStr:" + str2);
    }
}

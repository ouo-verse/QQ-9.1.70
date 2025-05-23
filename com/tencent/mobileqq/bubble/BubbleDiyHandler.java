package com.tencent.mobileqq.bubble;

import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BubbleDiyHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f200576d;

    public BubbleDiyHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f200576d = qQAppInterface;
        }
    }

    private void D2(List<String> list, List<BubbleDiyComu$UserTextInfo> list2) {
        long j3;
        for (String str : list) {
            BubbleDiyComu$UserTextInfo bubbleDiyComu$UserTextInfo = new BubbleDiyComu$UserTextInfo();
            String[] split = str.split("_");
            if (split.length == 2) {
                int i3 = 0;
                try {
                    j3 = Long.parseLong(split[0]);
                } catch (NumberFormatException e16) {
                    e = e16;
                    j3 = 0;
                }
                try {
                    i3 = Integer.parseInt(split[1]);
                } catch (NumberFormatException e17) {
                    e = e17;
                    QLog.e("BubbleDiyHandler", 1, "", e);
                    if (j3 > 0) {
                        bubbleDiyComu$UserTextInfo.text_uin.set(j3);
                        bubbleDiyComu$UserTextInfo.text_id.set(i3);
                        list2.add(bubbleDiyComu$UserTextInfo);
                    }
                }
                if (j3 > 0 && i3 > 0) {
                    bubbleDiyComu$UserTextInfo.text_uin.set(j3);
                    bubbleDiyComu$UserTextInfo.text_id.set(i3);
                    list2.add(bubbleDiyComu$UserTextInfo);
                }
            }
        }
    }

    private void F2(ToServiceMsg toServiceMsg, BubbleDiyComu$Bubble_Rsp bubbleDiyComu$Bubble_Rsp) {
        if (bubbleDiyComu$Bubble_Rsp.ret.get() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "DiyText...fetch key \u56de\u5305 sso \u6210\u529f \uff0cserver \u5931\u8d25\uff0cret = " + bubbleDiyComu$Bubble_Rsp.ret.get());
            }
            super.notifyUI(toServiceMsg, 1, false, (Object) null);
            return;
        }
        if (bubbleDiyComu$Bubble_Rsp.rspcmd_0x01.has() && bubbleDiyComu$Bubble_Rsp.rspcmd_0x01.user_text_info.has()) {
            List<BubbleDiyComu$UserTextInfo> list = bubbleDiyComu$Bubble_Rsp.rspcmd_0x01.user_text_info.get();
            List<BubbleDiyEntity> arrayList = new ArrayList<>();
            if (list != null) {
                G2(list, arrayList);
            }
            BubbleDiyFetcher.m().s(this.f200576d, true, arrayList);
            super.notifyUI(toServiceMsg, 1, true, (Object) arrayList);
            return;
        }
        super.notifyUI(toServiceMsg, 1, false, (Object) null);
    }

    private void G2(List<BubbleDiyComu$UserTextInfo> list, List<BubbleDiyEntity> list2) {
        for (BubbleDiyComu$UserTextInfo bubbleDiyComu$UserTextInfo : list) {
            if (bubbleDiyComu$UserTextInfo.text.has() && bubbleDiyComu$UserTextInfo.text_uin.has() && bubbleDiyComu$UserTextInfo.text_id.has()) {
                try {
                    JSONObject jSONObject = new JSONObject(bubbleDiyComu$UserTextInfo.text.get());
                    BubbleDiyEntity bubbleDiyEntity = new BubbleDiyEntity();
                    bubbleDiyEntity.uinAndDiyId = bubbleDiyComu$UserTextInfo.text_uin.get() + "_" + bubbleDiyComu$UserTextInfo.text_id.get();
                    bubbleDiyEntity.diyText = jSONObject.optString("diyText");
                    bubbleDiyEntity.bottomLeftId = jSONObject.optString("bl");
                    bubbleDiyEntity.bottomRightId = jSONObject.optString(TtmlNode.TAG_BR);
                    bubbleDiyEntity.topLeftId = jSONObject.optString("tl");
                    bubbleDiyEntity.topRightId = jSONObject.optString(ReportConstant.COSTREPORT_TRANS);
                    list2.add(bubbleDiyEntity);
                    if (QLog.isColorLevel()) {
                        QLog.i("BubbleDiyHandler", 2, "onReceive: uinAndDiyId: " + bubbleDiyEntity.uinAndDiyId + ",config: " + bubbleDiyComu$UserTextInfo.text.get());
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BubbleDiyHandler", 2, "", e16);
                    }
                }
            }
        }
    }

    public void E2(List<String> list, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) businessObserver);
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("BubbleDiyHandler", 2, "try fetchDiyTexts: " + TextUtils.join(",", list));
            }
            BubbleDiyComu$Bubble_Req_Comm bubbleDiyComu$Bubble_Req_Comm = new BubbleDiyComu$Bubble_Req_Comm();
            bubbleDiyComu$Bubble_Req_Comm.platform.set(109L);
            bubbleDiyComu$Bubble_Req_Comm.osver.set(Build.VERSION.RELEASE);
            bubbleDiyComu$Bubble_Req_Comm.mqqver.set(AppSetting.f99551k);
            BubbleDiyComu$Bubble_GetDiyText_Req bubbleDiyComu$Bubble_GetDiyText_Req = new BubbleDiyComu$Bubble_GetDiyText_Req();
            ArrayList arrayList = new ArrayList();
            D2(list, arrayList);
            if (arrayList.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.i("BubbleDiyHandler", 2, "no diy id need request: " + TextUtils.join(",", list));
                    return;
                }
                return;
            }
            bubbleDiyComu$Bubble_GetDiyText_Req.user_text_info.set(arrayList);
            BubbleDiyComu$Bubble_Req bubbleDiyComu$Bubble_Req = new BubbleDiyComu$Bubble_Req();
            bubbleDiyComu$Bubble_Req.cmd.set(1);
            bubbleDiyComu$Bubble_Req.packet_seq.set(System.currentTimeMillis());
            bubbleDiyComu$Bubble_Req.comm.set(bubbleDiyComu$Bubble_Req_Comm);
            bubbleDiyComu$Bubble_Req.reqcmd_0x01.set(bubbleDiyComu$Bubble_GetDiyText_Req);
            ToServiceMsg createToServiceMsg = super.createToServiceMsg("bubble.1", businessObserver);
            createToServiceMsg.putWupBuffer(bubbleDiyComu$Bubble_Req.toByteArray());
            super.sendPbReq(createToServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        BubbleDiyComu$Bubble_Rsp bubbleDiyComu$Bubble_Rsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("bubble.1")) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            String valueOf = String.valueOf(toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR));
            if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "keySeq=" + valueOf + " isSuccess=" + isSuccess + " resultCode=" + fromServiceMsg.getResultCode());
            }
            if (isSuccess) {
                try {
                    bubbleDiyComu$Bubble_Rsp = new BubbleDiyComu$Bubble_Rsp().mergeFrom((byte[]) obj);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BubbleDiyHandler", 2, "DiyText bubbleRsp is null \u4e1a\u52a1\u56de\u5305 \u5f02\u5e38");
                    }
                    bubbleDiyComu$Bubble_Rsp = null;
                }
                if (bubbleDiyComu$Bubble_Rsp != null) {
                    F2(toServiceMsg, bubbleDiyComu$Bubble_Rsp);
                    return;
                } else {
                    super.notifyUI(toServiceMsg, 1, false, (Object) null);
                    return;
                }
            }
            super.notifyUI(toServiceMsg, 1, false, (Object) null);
            if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "DiyText isSuccess is false sso\u901a\u9053  \u5f02\u5e38");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleDiyHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
        }
    }
}

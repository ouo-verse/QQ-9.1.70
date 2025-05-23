package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VerifyCodeInfo {
    static IPatchRedirector $redirector_;
    public int appSeq;
    public int ssoSeq;
    public int svrSeqNo;
    public String uin;
    public String verifyNote;
    public byte[] verifyimage;
    public String verifyurl;
    public String vpicSid;
    public int wupSeq;

    public VerifyCodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static VerifyCodeInfo getVerifyCodeInfo(FromServiceMsg fromServiceMsg) {
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
        verifyCodeInfo.verifyimage = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE);
        verifyCodeInfo.verifyNote = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG);
        verifyCodeInfo.svrSeqNo = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSVRSEQ)).intValue();
        verifyCodeInfo.vpicSid = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFPICSID);
        verifyCodeInfo.wupSeq = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFWUPSEQ)).intValue();
        verifyCodeInfo.ssoSeq = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSSOEQ)).intValue();
        verifyCodeInfo.uin = fromServiceMsg.getUin();
        verifyCodeInfo.verifyurl = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYURL);
        verifyCodeInfo.appSeq = fromServiceMsg.getAppSeq();
        return verifyCodeInfo;
    }

    public static void putVerifyCodeInfo(FromServiceMsg fromServiceMsg, VerifyCodeInfo verifyCodeInfo) {
        if (verifyCodeInfo == null) {
            return;
        }
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE, verifyCodeInfo.verifyimage);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG, verifyCodeInfo.verifyNote);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSVRSEQ, Integer.valueOf(verifyCodeInfo.svrSeqNo));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFPICSID, verifyCodeInfo.vpicSid);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFWUPSEQ, Integer.valueOf(verifyCodeInfo.wupSeq));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSSOEQ, Integer.valueOf(verifyCodeInfo.ssoSeq));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFUIN, fromServiceMsg.getUin());
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYURL, verifyCodeInfo.verifyurl);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFAPPSEQ, Integer.valueOf(fromServiceMsg.getAppSeq()));
    }

    public static void putVerifyCodeInfo(ToServiceMsg toServiceMsg, VerifyCodeInfo verifyCodeInfo) {
        if (toServiceMsg == null || verifyCodeInfo == null) {
            return;
        }
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE, verifyCodeInfo.verifyimage);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG, verifyCodeInfo.verifyNote);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSVRSEQ, Integer.valueOf(verifyCodeInfo.svrSeqNo));
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFPICSID, verifyCodeInfo.vpicSid);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFWUPSEQ, Integer.valueOf(verifyCodeInfo.wupSeq));
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSSOEQ, Integer.valueOf(verifyCodeInfo.ssoSeq));
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFUIN, toServiceMsg.getUin());
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYURL, verifyCodeInfo.verifyurl);
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFAPPSEQ, Integer.valueOf(toServiceMsg.getAppSeq()));
    }

    public static VerifyCodeInfo getVerifyCodeInfo(ToServiceMsg toServiceMsg) {
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
        verifyCodeInfo.verifyimage = (byte[]) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE);
        verifyCodeInfo.verifyNote = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG);
        verifyCodeInfo.svrSeqNo = ((Integer) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSVRSEQ)).intValue();
        verifyCodeInfo.vpicSid = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFPICSID);
        verifyCodeInfo.wupSeq = ((Integer) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFWUPSEQ)).intValue();
        verifyCodeInfo.ssoSeq = ((Integer) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFSSOEQ)).intValue();
        verifyCodeInfo.uin = toServiceMsg.getUin();
        verifyCodeInfo.verifyurl = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYURL);
        verifyCodeInfo.appSeq = toServiceMsg.getAppSeq();
        return verifyCodeInfo;
    }
}

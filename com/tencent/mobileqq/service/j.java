package com.tencent.mobileqq.service;

import ColorNick.QC.readItemInfoReq;
import ColorNick.QC.readItemInfoRsp;
import GROUP.MessageRemindReq;
import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastReq;
import MQQ.GetRoamToastRsp;
import ProfileLogic.QC.readUserInfoReq;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagReq;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileReq;
import ProfileLogic.QC.setUserProfileRsp;
import QC.BubbleRecommendReq;
import QC.BubbleRecommendRsp;
import QC.FaceReq;
import QC.FaceRsp;
import QC.FontRecommendReq;
import QC.FontRecommendRsp;
import QC.SetFontBubbleReq;
import QC.SetFontBubbleRsp;
import QC.UniGetRsp;
import QC.UniLoginCheckReq;
import QC.UniLoginCheckRsp;
import QC.UniSetRsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f286139d;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, IJce> f286140e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286139d = 0;
            f286140e = new ConcurrentHashMap<>();
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private <T> T a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, T t16) {
        if (fromServiceMsg == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            return (T) uniPacket.getByClass("rsp", t16);
        } catch (Exception e16) {
            QLog.e("VasService", 1, "decodeWUP: ", e16);
            return null;
        }
    }

    public static void b(IJce iJce, String str) {
        f286140e.put(str, iJce);
    }

    public static void c(String str) {
        f286140e.remove(str);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return i.f286138a;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasService", 2, "decode: cmd=" + toServiceMsg.getServiceCmd());
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            if (toServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus")) {
                int intValue = ((Integer) uniPacket.getByClass("", -1)).intValue();
                ArrayList arrayList = new ArrayList();
                int i3 = toServiceMsg.extraData.getInt(QCircleDaTongConstant.ElementParamValue.OPERATION, -1);
                arrayList.add(Integer.valueOf(intValue));
                arrayList.add(Integer.valueOf(i3));
                if (i3 == 257) {
                    boolean booleanValue = ((Boolean) uniPacket.getByClass("bOpenAuth", new Boolean(false))).booleanValue();
                    arrayList.add(Boolean.valueOf(booleanValue));
                    if (QLog.isColorLevel()) {
                        QLog.d("VasService", 2, "decode: ret=" + intValue + " openAuth=" + booleanValue + " funName=" + uniPacket.getFuncName());
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("VasService", 2, "decode: ret=" + intValue + " funName=" + uniPacket.getFuncName());
                }
                return arrayList;
            }
            if (toServiceMsg.getServiceCmd().equals("groupnick.readitem")) {
                readItemInfoRsp readiteminforsp = (readItemInfoRsp) uniPacket.getByClass("stRsp", new readItemInfoRsp());
                if (QLog.isColorLevel()) {
                    QLog.d("VasService", 2, "decode: ret =  funName = " + uniPacket.getFuncName() + " infoRsp = " + readiteminforsp.toString());
                }
                return readiteminforsp;
            }
            if (toServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo")) {
                return (readUserInfoRsp) uniPacket.getByClass("stRsp", new readUserInfoRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile")) {
                return (setUserProfileRsp) uniPacket.getByClass("stRsp", new setUserProfileRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag")) {
                return (setUserFlagRsp) uniPacket.getByClass("stRsp", new setUserFlagRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo")) {
                return (MessageRemindRsp) uniPacket.getByClass("stRsp", new MessageRemindRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend")) {
                return (FontRecommendRsp) uniPacket.getByClass("rsp", new FontRecommendRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend")) {
                return (BubbleRecommendRsp) uniPacket.getByClass("rsp", new BubbleRecommendRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble")) {
                return (SetFontBubbleRsp) uniPacket.getByClass("rsp", new SetFontBubbleRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast")) {
                return (GetRoamToastRsp) uniPacket.getByClass("stRsp", new GetRoamToastRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("Face.setFace")) {
                return (FaceRsp) uniPacket.getByClass("rsp", new FaceRsp());
            }
            if (toServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check")) {
                return (UniLoginCheckRsp) uniPacket.getByClass("rsp", new UniLoginCheckRsp());
            }
            if ("QCUniBusinessLogic.uniSet".equals(toServiceMsg.getServiceCmd())) {
                return a(toServiceMsg, fromServiceMsg, new UniSetRsp());
            }
            if ("QCUniBusinessLogic.uniGet".equals(toServiceMsg.getServiceCmd())) {
                return a(toServiceMsg, fromServiceMsg, new UniGetRsp());
            }
            if (!f286140e.containsKey(IJce.Util.reqSeq(toServiceMsg))) {
                return null;
            }
            return f286140e.get(IJce.Util.reqSeq(toServiceMsg)).decode(toServiceMsg, fromServiceMsg, uniPacket);
        } catch (Exception e16) {
            QLog.e("VasService", 1, "decode error: ", e16);
            return null;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasService", 2, "encodeReqMsg: cmd=" + toServiceMsg.getServiceCmd());
        }
        if (toServiceMsg.getServiceCmd().equals("FriendClone.CloneAuthStatus")) {
            int i3 = toServiceMsg.extraData.getInt(QCircleDaTongConstant.ElementParamValue.OPERATION, -1);
            if (i3 == 257) {
                uniPacket.setFuncName("getCloneAuthStatus");
            } else {
                if (i3 != 258) {
                    return false;
                }
                uniPacket.setFuncName("setCloneAuthStatus");
            }
            uniPacket.setServantName("MQQ.FriendCloneServer.FriendCloneObj");
            int i16 = f286139d;
            f286139d = i16 + 1;
            uniPacket.setRequestId(i16);
            String string = toServiceMsg.extraData.getString("uUin");
            boolean z16 = toServiceMsg.extraData.getBoolean("bOpenAuth", false);
            if (TextUtils.isEmpty(string)) {
                QLog.e("VasService", 2, "encodeReqMsg: uin is empty");
                return false;
            }
            uniPacket.put("uUin", Long.valueOf(Long.parseLong(string)));
            uniPacket.put("bOpenAuth", Boolean.valueOf(z16));
            if (QLog.isColorLevel()) {
                QLog.d("VasService", 2, "encodeReqMsg: svName=" + uniPacket.getServantName() + " funName=" + uniPacket.getFuncName() + " uin=" + uniPacket.getByClass("uUin", new Long(1L)) + " openAuth=" + uniPacket.getByClass("bOpenAuth", new Boolean(false)));
            }
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("groupnick.readitem")) {
            uniPacket.setFuncName("readItemInfo");
            uniPacket.put("stReq", (readItemInfoReq) toServiceMsg.extraData.getSerializable("req"));
            uniPacket.setServantName("QC.readGroupNickServer.readGroupNickObj");
            int i17 = f286139d;
            f286139d = i17 + 1;
            uniPacket.setRequestId(i17);
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("profilelogic.readUserInfo")) {
            uniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
            uniPacket.setFuncName("ReadUserProfile");
            int i18 = f286139d;
            f286139d = i18 + 1;
            uniPacket.setRequestId(i18);
            uniPacket.put("stReq", (readUserInfoReq) toServiceMsg.extraData.getSerializable("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("profilelogic.setUserProfile")) {
            uniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
            uniPacket.setFuncName("SetUserProfile");
            int i19 = f286139d;
            f286139d = i19 + 1;
            uniPacket.setRequestId(i19);
            uniPacket.put("stReq", (setUserProfileReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("profilelogic.setUserFlag")) {
            uniPacket.setServantName("QC.ProfileLogicServer.ProfileLogicObj");
            uniPacket.setFuncName("SetUserFlag");
            int i26 = f286139d;
            f286139d = i26 + 1;
            uniPacket.setRequestId(i26);
            uniPacket.put("stReq", (setUserFlagReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("GroupCare.getMessageRemindInfo")) {
            uniPacket.setServantName("GROUP.GroupCareServer.GroupCareObj");
            uniPacket.setFuncName("getMessageRemindInfo");
            int i27 = f286139d;
            f286139d = i27 + 1;
            uniPacket.setRequestId(i27);
            uniPacket.put("stReq", (MessageRemindReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getFontRecommend")) {
            uniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
            uniPacket.setFuncName("getFontRecommend");
            int i28 = f286139d;
            f286139d = i28 + 1;
            uniPacket.setRequestId(i28);
            uniPacket.put("req", (FontRecommendReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.getBubbleRecommend")) {
            uniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
            uniPacket.setFuncName("getBubbleRecommend");
            int i29 = f286139d;
            f286139d = i29 + 1;
            uniPacket.setRequestId(i29);
            uniPacket.put("req", (BubbleRecommendReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("QCUniBusinessLogin.check")) {
            uniPacket.setServantName("QC.UniBusinessLoginServer.UniBusinessLoginObj");
            uniPacket.setFuncName("UniLoginCheck");
            int i36 = f286139d;
            f286139d = i36 + 1;
            uniPacket.setRequestId(i36);
            uniPacket.put("stReq", (UniLoginCheckReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("FontBubbleRecommend.setFontBubble")) {
            uniPacket.setServantName("QC.FontBubbleRecommendServer.FontBubbleRecommendObj");
            uniPacket.setFuncName("setFontBubble");
            int i37 = f286139d;
            f286139d = i37 + 1;
            uniPacket.setRequestId(i37);
            uniPacket.put("req", (SetFontBubbleReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("RoamWrap.GetRoamToast")) {
            uniPacket.setServantName("MQQ.RoamWrapServer.RoamWrapObj");
            uniPacket.setFuncName("GetRoamToast");
            int i38 = f286139d;
            f286139d = i38 + 1;
            uniPacket.setRequestId(i38);
            uniPacket.put("stReq", (GetRoamToastReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if (toServiceMsg.getServiceCmd().equals("Face.setFace")) {
            uniPacket.setServantName("QC.FaceServer.FaceObj");
            uniPacket.setFuncName("setFace");
            int i39 = f286139d;
            f286139d = i39 + 1;
            uniPacket.setRequestId(i39);
            uniPacket.put("req", (FaceReq) toServiceMsg.extraData.get("req"));
            return true;
        }
        if ("QCUniBusinessLogic.uniSet".equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
            uniPacket.setFuncName("uniSet");
            uniPacket.put("stReq", toServiceMsg.extraData.getSerializable("req"));
            return true;
        }
        if ("QCUniBusinessLogic.uniGet".equals(toServiceMsg.getServiceCmd())) {
            uniPacket.setServantName("QC.UniBusinessLogicServer.UniBusinessLogicObj");
            uniPacket.setFuncName("uniGet");
            uniPacket.put("stReq", toServiceMsg.extraData.getSerializable("req"));
            return true;
        }
        if (!f286140e.containsKey(IJce.Util.reqSeq(toServiceMsg))) {
            return false;
        }
        IJce iJce = f286140e.get(IJce.Util.reqSeq(toServiceMsg));
        int i46 = f286139d;
        f286139d = i46 + 1;
        iJce.encode(toServiceMsg, uniPacket, i46);
        return true;
    }
}

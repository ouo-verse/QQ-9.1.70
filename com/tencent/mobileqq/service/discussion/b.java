package com.tencent.mobileqq.service.discussion;

import QQService.AddDiscussMemberInfo;
import QQService.DiscussReqHeader;
import QQService.MemberAttrInfo;
import QQService.ReqAddDiscussMember;
import QQService.ReqChangeDiscussName;
import QQService.ReqCreateDiscuss;
import QQService.ReqGetDiscussInfo;
import QQService.ReqGetDiscussInteRemark;
import QQService.ReqJoinDiscuss;
import QQService.ReqQuitDiscuss;
import QQService.ReqSetDiscussAttr;
import QQService.ReqSetDiscussFlag;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f286101a;

    /* renamed from: b, reason: collision with root package name */
    private DiscussReqHeader f286102b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286101a = 0;
        DiscussReqHeader discussReqHeader = new DiscussReqHeader();
        this.f286102b = discussReqHeader;
        discussReqHeader.Version = 0;
    }

    private boolean a(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqAddDiscussMember");
        ReqAddDiscussMember reqAddDiscussMember = new ReqAddDiscussMember();
        reqAddDiscussMember.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        ArrayList<AddDiscussMemberInfo> arrayList = new ArrayList<>();
        long[] longArray = toServiceMsg.extraData.getLongArray("uin");
        int[] intArray = toServiceMsg.extraData.getIntArray("type");
        long[] longArray2 = toServiceMsg.extraData.getLongArray("refUin");
        String[] stringArray = toServiceMsg.extraData.getStringArray("refStr");
        int length = longArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            AddDiscussMemberInfo addDiscussMemberInfo = new AddDiscussMemberInfo();
            addDiscussMemberInfo.Uin = longArray[i3];
            addDiscussMemberInfo.Type = intArray[i3];
            addDiscussMemberInfo.RefUin = longArray2[i3];
            addDiscussMemberInfo.RefStr = stringArray[i3];
            arrayList.add(addDiscussMemberInfo);
        }
        reqAddDiscussMember.Members = arrayList;
        uniPacket.put("ReqAddDiscussMember", reqAddDiscussMember);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean b(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqChangeDiscussName");
        ReqChangeDiscussName reqChangeDiscussName = new ReqChangeDiscussName();
        reqChangeDiscussName.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        reqChangeDiscussName.NewName = toServiceMsg.extraData.getString("newName");
        uniPacket.put("ReqChangeDiscussName", reqChangeDiscussName);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean c(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqCreateDiscuss");
        ReqCreateDiscuss reqCreateDiscuss = new ReqCreateDiscuss();
        reqCreateDiscuss.Name = toServiceMsg.extraData.getString("name");
        ArrayList<AddDiscussMemberInfo> arrayList = new ArrayList<>();
        long[] longArray = toServiceMsg.extraData.getLongArray("uin");
        int[] intArray = toServiceMsg.extraData.getIntArray("type");
        long[] longArray2 = toServiceMsg.extraData.getLongArray("refUin");
        String[] stringArray = toServiceMsg.extraData.getStringArray("refStr");
        int i3 = toServiceMsg.extraData.getInt("from");
        int length = longArray.length;
        for (int i16 = 0; i16 < length; i16++) {
            AddDiscussMemberInfo addDiscussMemberInfo = new AddDiscussMemberInfo();
            addDiscussMemberInfo.Uin = longArray[i16];
            addDiscussMemberInfo.Type = intArray[i16];
            addDiscussMemberInfo.RefUin = longArray2[i16];
            addDiscussMemberInfo.RefStr = stringArray[i16];
            arrayList.add(addDiscussMemberInfo);
        }
        reqCreateDiscuss.Members = arrayList;
        reqCreateDiscuss.Refer = i3;
        uniPacket.put("ReqCreateDiscuss", reqCreateDiscuss);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean d(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        int i3;
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqGetDiscussInfo");
        ReqGetDiscussInfo reqGetDiscussInfo = new ReqGetDiscussInfo();
        Map<Long, Integer> map = (Map) toServiceMsg.getAttribute("inteRemarkUinMap");
        reqGetDiscussInfo.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        reqGetDiscussInfo.InteRemarkTimeStamp = toServiceMsg.extraData.getLong("InteRemarkTimeStamp", 0L);
        if (map != null) {
            reqGetDiscussInfo.UinList = map;
        }
        reqGetDiscussInfo.InfoSeq = toServiceMsg.extraData.getLong("infoSeq", 0L);
        reqGetDiscussInfo.Signature = toServiceMsg.extraData.getString("signature");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createGetDiscussInfoBuffer reqUIn =");
            sb5.append(reqGetDiscussInfo.DiscussUin);
            sb5.append(",inteRemarktime =");
            sb5.append(reqGetDiscussInfo.InteRemarkTimeStamp);
            sb5.append(",uinList size ");
            Map<Long, Integer> map2 = reqGetDiscussInfo.UinList;
            if (map2 != null) {
                i3 = map2.size();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            sb5.append(", signature=");
            sb5.append(reqGetDiscussInfo.Signature);
            QLog.d("DiscussionSender", 2, sb5.toString());
        }
        uniPacket.put("ReqGetDiscussInfo", reqGetDiscussInfo);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean e(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqGetDiscussInteRemark");
        ReqGetDiscussInteRemark reqGetDiscussInteRemark = new ReqGetDiscussInteRemark();
        reqGetDiscussInteRemark.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        reqGetDiscussInteRemark.UinList = (ArrayList) toServiceMsg.getAttribute("inteRemarkUinList");
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionSender", 2, "createGetDiscussInteRemarkBuffer reqUIn =" + reqGetDiscussInteRemark.DiscussUin + " uinList size " + reqGetDiscussInteRemark.UinList.size());
        }
        uniPacket.put("ReqGetDiscussInteRemark", reqGetDiscussInteRemark);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqJoinDiscuss");
        ReqJoinDiscuss reqJoinDiscuss = new ReqJoinDiscuss();
        reqJoinDiscuss.Signature = toServiceMsg.extraData.getString("signature");
        reqJoinDiscuss.From = toServiceMsg.extraData.getInt("addDisSource");
        uniPacket.put("ReqJoinDiscuss", reqJoinDiscuss);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqQuitDiscuss");
        ReqQuitDiscuss reqQuitDiscuss = new ReqQuitDiscuss();
        reqQuitDiscuss.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        uniPacket.put("ReqQuitDiscuss", reqQuitDiscuss);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqSetDiscussAttr");
        ReqSetDiscussAttr reqSetDiscussAttr = new ReqSetDiscussAttr();
        reqSetDiscussAttr.Attr = new HashMap();
        reqSetDiscussAttr.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        int[] intArray = toServiceMsg.extraData.getIntArray("infoType");
        int[] intArray2 = toServiceMsg.extraData.getIntArray("attrType");
        int length = intArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            MemberAttrInfo memberAttrInfo = new MemberAttrInfo();
            memberAttrInfo.Value = intArray2[i3];
            memberAttrInfo.StrValue = "";
            reqSetDiscussAttr.Attr.put(Integer.valueOf(intArray[i3]), memberAttrInfo);
        }
        uniPacket.put("ReqSetDiscussAttr", reqSetDiscussAttr);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    private boolean i(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("QQServiceDiscussSvc");
        uniPacket.setFuncName("ReqSetDiscussFlag");
        ReqSetDiscussFlag reqSetDiscussFlag = new ReqSetDiscussFlag();
        reqSetDiscussFlag.DiscussUin = toServiceMsg.extraData.getLong("discussUin");
        reqSetDiscussFlag.Flag = toServiceMsg.extraData.getByte("flag");
        uniPacket.put("ReqSetDiscussFlag", reqSetDiscussFlag);
        uniPacket.put("DiscussReqHeader", this.f286102b);
        return true;
    }

    public boolean j(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionSender", 2, "~~~create wup buffer cmd: " + serviceCmd);
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(serviceCmd)) {
            return a(toServiceMsg, uniPacket);
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(serviceCmd)) {
            return b(toServiceMsg, uniPacket);
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(serviceCmd)) {
            return c(toServiceMsg, uniPacket);
        }
        if (!"OidbSvc.0x58a".equalsIgnoreCase(serviceCmd)) {
            if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(serviceCmd)) {
                return d(toServiceMsg, uniPacket);
            }
            if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(serviceCmd)) {
                return g(toServiceMsg, uniPacket);
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(serviceCmd)) {
                return h(toServiceMsg, uniPacket);
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(serviceCmd)) {
                return i(toServiceMsg, uniPacket);
            }
            if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(serviceCmd)) {
                return e(toServiceMsg, uniPacket);
            }
            if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(serviceCmd)) {
                return f(toServiceMsg, uniPacket);
            }
            return false;
        }
        return false;
    }
}

package com.tencent.mobileqq.emotionintegrate;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f205298a;

        /* renamed from: b, reason: collision with root package name */
        public String f205299b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<ServerAddr> f205300c;

        /* renamed from: d, reason: collision with root package name */
        public String f205301d;

        /* renamed from: e, reason: collision with root package name */
        public String f205302e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            ArrayList<ServerAddr> arrayList = this.f205300c;
            if (arrayList != null && arrayList.size() > 0) {
                ServerAddr serverAddr = this.f205300c.get(0);
                sb5.append("http://");
                sb5.append(serverAddr.mIp);
                if (serverAddr.port != 80) {
                    sb5.append(":");
                    sb5.append(serverAddr.port);
                }
                sb5.append("/");
            } else {
                String str = this.f205302e;
                if (str != null) {
                    if (!str.startsWith("http://")) {
                        sb5.append("http://");
                    }
                    sb5.append(this.f205302e);
                    if (!this.f205302e.endsWith("/")) {
                        sb5.append("/");
                    }
                }
            }
            sb5.append(this.f205301d);
            return sb5.toString();
        }

        public void b(RichProto.RichProtoResp.ShortVideoDownResp shortVideoDownResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) shortVideoDownResp);
                return;
            }
            if (w.a()) {
                ArrayList<ServerAddr> arrayList = shortVideoDownResp.mIpList;
                this.f205300c = arrayList;
                if (arrayList != null) {
                    arrayList.size();
                }
            } else {
                ArrayList<ServerAddr> arrayList2 = shortVideoDownResp.mIpv6List;
                this.f205300c = arrayList2;
                if (arrayList2 != null) {
                    arrayList2.size();
                }
            }
            int i3 = 0;
            if (shortVideoDownResp.result == 0) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onBusiProtoResp() cdn ---- mIpListSize:");
                    ArrayList<ServerAddr> arrayList3 = this.f205300c;
                    if (arrayList3 != null) {
                        i3 = arrayList3.size();
                    }
                    sb5.append(i3);
                    sb5.append(" mHostType:");
                    sb5.append(shortVideoDownResp.mHostType);
                    sb5.append(" domain:");
                    sb5.append(shortVideoDownResp.mDomain);
                    sb5.append(" url:");
                    sb5.append(shortVideoDownResp.mUrl);
                    QLog.d("FileIdToUrl", 2, sb5.toString());
                    QLog.d("FileIdToUrl", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(shortVideoDownResp.md5));
                }
                this.f205301d = shortVideoDownResp.mUrl;
                this.f205298a = true;
                return;
            }
            this.f205298a = false;
            int i16 = shortVideoDownResp.errCode;
            if (-5100026 == i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FileIdToUrl", 2, "onBusiProtoResp()---- \u5b89\u5168\u6253\u51fb");
                }
                HardCodeUtil.qqStr(R.string.f212475nm);
            } else {
                if (-9527 == i16 && (shortVideoDownResp.errStr.equals("H_400_-5103017") || shortVideoDownResp.errStr.equals("H_400_-5103059"))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FileIdToUrl", 2, "onBusiProtoResp()---- \u89c6\u9891\u6587\u4ef6\u8fc7\u671ferrCode=" + shortVideoDownResp.errCode);
                    }
                    HardCodeUtil.qqStr(R.string.f212485nn);
                    return;
                }
                HardCodeUtil.qqStr(R.string.f212465nl);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return c();
    }

    public static void b(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16, String str3, int i17, RichProtoProc.RichProtoCallback richProtoCallback) {
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.ShortVideoDownReq shortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
        shortVideoDownReq.seq = i17;
        if (QLog.isColorLevel()) {
            QLog.d("FileIdToUrl", 2, "getUrl sequence: " + shortVideoDownReq.seq);
        }
        shortVideoDownReq.selfUin = str3;
        String currentUin = qQAppInterface.getCurrentUin();
        shortVideoDownReq.peerUin = currentUin;
        shortVideoDownReq.secondUin = str3;
        shortVideoDownReq.uinType = i3;
        shortVideoDownReq.agentType = 0;
        if (i3 == 0) {
            shortVideoDownReq.chatType = 0;
        } else if (1 == i3) {
            shortVideoDownReq.chatType = 1;
        } else if (3000 == i3) {
            shortVideoDownReq.chatType = 2;
        } else {
            shortVideoDownReq.chatType = 3;
        }
        if (i3 != 0 && 1008 != i3) {
            shortVideoDownReq.troopUin = currentUin;
        } else {
            shortVideoDownReq.troopUin = null;
        }
        shortVideoDownReq.clientType = 2;
        shortVideoDownReq.fileId = str;
        shortVideoDownReq.md5 = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(str2);
        shortVideoDownReq.busiType = 1022;
        shortVideoDownReq.subBusiType = 0;
        shortVideoDownReq.fileType = i16;
        shortVideoDownReq.downType = 1;
        shortVideoDownReq.sceneType = 1;
        richProtoReq.callback = richProtoCallback;
        richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_DW;
        richProtoReq.reqs.add(shortVideoDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) qQAppInterface.getRuntimeService(IProtoReqManager.class, "");
        RichProtoProc.procRichProtoReq(richProtoReq);
    }

    private static boolean c() {
        return true;
    }
}

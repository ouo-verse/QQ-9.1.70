package com.tencent.qidian.controller;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.protohandler.NearbyPeoplePicUpHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BigDataGetIpHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private boolean E;
    private Object F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f342814d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f342815e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f342816f;

    /* renamed from: h, reason: collision with root package name */
    private String[] f342817h;

    /* renamed from: i, reason: collision with root package name */
    private Object f342818i;

    /* renamed from: m, reason: collision with root package name */
    private int f342819m;

    public BigDataGetIpHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f342814d = null;
        this.f342815e = null;
        this.f342816f = null;
        this.f342817h = null;
        this.f342818i = new Object();
        this.f342819m = 0;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new Object();
        this.G = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[Catch: all -> 0x000f, TryCatch #1 {all -> 0x000f, blocks: (B:34:0x0008, B:36:0x000b, B:9:0x0014, B:11:0x0017, B:13:0x001c, B:15:0x001f, B:17:0x0026, B:19:0x0029, B:20:0x002f, B:22:0x0035, B:23:0x0059), top: B:33:0x0008, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void G2(byte[] bArr, byte[] bArr2, String[] strArr, String[] strArr2) {
        boolean z16;
        synchronized (this.f342818i) {
            boolean z17 = true;
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        this.f342814d = bArr;
                        z16 = true;
                        if (bArr2 != null && bArr2.length > 0) {
                            this.f342815e = bArr2;
                            z16 = true;
                        }
                        if (strArr != null && strArr.length > 0) {
                            this.f342819m = 0;
                            this.f342816f = strArr;
                            z16 = true;
                        }
                        if (strArr2 == null && strArr2.length > 0) {
                            this.f342819m = 0;
                            this.f342817h = strArr2;
                        } else {
                            z17 = z16;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BigDataGetIpHandler", 2, "saveSrvParam | changed = " + z17 + " | usingIndex = " + this.f342819m);
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            z16 = false;
            if (bArr2 != null) {
                this.f342815e = bArr2;
                z16 = true;
            }
            if (strArr != null) {
                this.f342819m = 0;
                this.f342816f = strArr;
                z16 = true;
            }
            if (strArr2 == null) {
            }
            z17 = z16;
            if (QLog.isColorLevel()) {
            }
        }
    }

    public static String H2(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("BigDataGetIpHandler", 1, "spliceIpv6Url: " + e16.toString());
            return null;
        }
    }

    private static String I2(int i3, int i16) {
        return J2((i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255), i16);
    }

    private static String J2(String str, int i3) {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("http://");
        stringBuffer.append(str);
        if (i3 != 80) {
            stringBuffer.append(":");
            stringBuffer.append(i3);
        }
        stringBuffer.append("/");
        return stringBuffer.toString();
    }

    public boolean D2(int i3, MessageMicro<?> messageMicro, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), messageMicro, Integer.valueOf(i16), obj)).booleanValue();
        }
        synchronized (this.F) {
            if (this.E) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.G > 30000) {
                this.D = 0;
            }
            if (this.D > 5) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 2, "req get ip too frequently");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BigDataGetIpHandler", 2, "req get ip list");
            }
            try {
                long parseLong = Long.parseLong(this.appRuntime.getAccount());
                if (parseLong <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BigDataGetIpHandler", 2, "uin illegal");
                    }
                    return false;
                }
                this.G = currentTimeMillis;
                this.D++;
                this.E = true;
                subcmd0x501.SubCmd0x501ReqBody subCmd0x501ReqBody = new subcmd0x501.SubCmd0x501ReqBody();
                subCmd0x501ReqBody.uint64_uin.set(parseLong);
                subCmd0x501ReqBody.uint32_idc_id.set(0);
                subCmd0x501ReqBody.uint32_appid.set(16);
                subCmd0x501ReqBody.uint32_login_sig_type.set(1);
                subCmd0x501ReqBody.uint32_request_flag.set(3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(1);
                subCmd0x501ReqBody.rpt_uint32_service_types.set(arrayList);
                subcmd0x501.ReqBody reqBody = new subcmd0x501.ReqBody();
                reqBody.msg_subcmd_0x501_req_body.set(subCmd0x501ReqBody);
                ToServiceMsg createToServiceMsg = createToServiceMsg(NearbyPeoplePicUpHandler.CMD_GET_IP_LIST);
                createToServiceMsg.putWupBuffer(reqBody.toByteArray());
                createToServiceMsg.extraData.putInt("big_data_cmd", i3);
                createToServiceMsg.extraData.putInt("big_data_sub_cmd", i16);
                int i17 = this.C;
                this.C = i17 + 1;
                createToServiceMsg.extraData.putInt("big_data_cmd_seq", i17);
                sendPbReq(createToServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 1, "getIPList " + i3 + " handler: " + getClass().getSimpleName() + " reqSeq = " + this.C + " curSeq = " + i17);
                }
                return true;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 2, "req get ip list case long fail");
                }
                return false;
            }
        }
    }

    public String E2() {
        String[] strArr;
        boolean z16;
        String[] strArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        synchronized (this.f342818i) {
            int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
            if (QLog.isColorLevel()) {
                QLog.d("BigDataGetIpHandler", 2, "getSrvUrl | ipStackType = " + activeNetIpFamily);
            }
            if ((activeNetIpFamily == 3 || activeNetIpFamily == 2) && (strArr = this.f342817h) != null && strArr.length > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                strArr2 = this.f342817h;
            } else {
                strArr2 = this.f342816f;
            }
            if (strArr2 != null && strArr2.length != 0) {
                this.f342819m %= strArr2.length;
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 2, "getSrvUrl | usingIndex = " + this.f342819m + " | count = " + strArr2.length + " | result = " + strArr2[this.f342819m]);
                }
                return strArr2[this.f342819m];
            }
            QLog.d("BigDataGetIpHandler", 1, "getSrvUrl: ips == null || ips.length != 0, usingIpv6 = " + z16);
            return null;
        }
    }

    protected void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        byte[] bArr;
        byte[] bArr2;
        String[] strArr;
        String[] strArr2;
        List<subcmd0x501.SubCmd0x501Rspbody.Ip6Addr> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        synchronized (this.F) {
            this.E = false;
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = toServiceMsg.extraData.getInt("big_data_cmd", -1);
        toServiceMsg.extraData.getInt("big_data_sub_cmd", -1);
        int i16 = toServiceMsg.extraData.getInt("big_data_cmd_seq", -1);
        if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 1, "handleGetIPList " + i3 + " handler: " + getClass().getSimpleName() + " reqSeq = " + i16);
        }
        if (z16) {
            try {
                if (obj != null) {
                    subcmd0x501.RspBody rspBody = new subcmd0x501.RspBody();
                    rspBody.mergeFrom((byte[]) obj);
                    subcmd0x501.SubCmd0x501Rspbody subCmd0x501Rspbody = rspBody.msg_subcmd_0x501_rsp_body.get();
                    ByteStringMicro byteStringMicro = subCmd0x501Rspbody.bytes_session_key.get();
                    if (byteStringMicro != null && byteStringMicro.toByteArray().length > 0) {
                        bArr = byteStringMicro.toByteArray();
                    } else {
                        bArr = null;
                    }
                    ByteStringMicro byteStringMicro2 = subCmd0x501Rspbody.bytes_httpconn_sig_session.get();
                    if (byteStringMicro2 != null && byteStringMicro2.toByteArray().length > 0) {
                        bArr2 = byteStringMicro2.toByteArray();
                    } else {
                        bArr2 = null;
                    }
                    List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> list2 = subCmd0x501Rspbody.rpt_msg_httpconn_addrs.get();
                    if (list2 != null && list2.size() != 0) {
                        for (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs srvAddrs : list2) {
                            if (srvAddrs.uint32_service_type.get() == 1) {
                                List<subcmd0x501.SubCmd0x501Rspbody.IpAddr> list3 = srvAddrs.rpt_msg_addrs.get();
                                if (list3 != null && list3.size() > 0) {
                                    strArr2 = new String[list3.size()];
                                    for (int i17 = 0; i17 < list3.size(); i17++) {
                                        subcmd0x501.SubCmd0x501Rspbody.IpAddr ipAddr = list3.get(i17);
                                        strArr2[i17] = I2(ipAddr.uint32_ip.get(), ipAddr.uint32_port.get());
                                    }
                                } else {
                                    strArr2 = null;
                                }
                                if (srvAddrs.rpt_msg_addrs_v6.has() && (list = srvAddrs.rpt_msg_addrs_v6.get()) != null && list.size() > 0) {
                                    strArr = new String[list.size()];
                                    for (int i18 = 0; i18 < list.size(); i18++) {
                                        subcmd0x501.SubCmd0x501Rspbody.Ip6Addr ip6Addr = list.get(i18);
                                        String H2 = H2(ip6Addr.bytes_ip6.get().toByteArray());
                                        if (H2 != null) {
                                            strArr[i18] = J2("[" + H2 + "]", ip6Addr.uint32_port.get());
                                        } else {
                                            QLog.e("BigDataGetIpHandler", 1, "handleGetIPList: ip6 == null");
                                        }
                                    }
                                } else {
                                    strArr = null;
                                }
                                G2(bArr, bArr2, strArr2, strArr);
                                notifyUI(2001, true, null);
                                return;
                            }
                        }
                    }
                    strArr = null;
                    strArr2 = null;
                    G2(bArr, bArr2, strArr2, strArr);
                    notifyUI(2001, true, null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 1, "handleRefreshGetAllTags fail, because data is null");
                }
                notifyUI(2001, false, null);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataGetIpHandler", 1, "handleGetIPList fail, because exception", e16);
                }
                e16.printStackTrace();
                notifyUI(2001, false, null);
                return;
            }
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res is null");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res code: " + fromServiceMsg.getResultCode());
        }
        notifyUI(2001, false, null);
    }

    public byte[] getSrvKey() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        synchronized (this.f342818i) {
            bArr = this.f342814d;
        }
        return bArr;
    }

    public byte[] getSrvSig() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        synchronized (this.f342818i) {
            bArr = this.f342815e;
        }
        return bArr;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if (NearbyPeoplePicUpHandler.CMD_GET_IP_LIST.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("BigDataGetIpHandler", 2, "CMD_GET_IP_LIST");
            }
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public BigDataGetIpHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f342814d = null;
        this.f342815e = null;
        this.f342816f = null;
        this.f342817h = null;
        this.f342818i = new Object();
        this.f342819m = 0;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new Object();
        this.G = 0L;
    }
}

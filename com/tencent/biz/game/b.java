package com.tencent.biz.game;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import OnlinePushPack.SvcRespPushMsg;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x42.Submsgtype0x42$GameStatusSync;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected Context f78554a;

    /* renamed from: b, reason: collision with root package name */
    protected String f78555b;

    /* renamed from: c, reason: collision with root package name */
    protected InterfaceC0792b f78556c;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<a> f78557d;

    /* renamed from: e, reason: collision with root package name */
    protected String f78558e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f78559f = "";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        public int f78560a;

        /* renamed from: b, reason: collision with root package name */
        public long f78561b;

        a() {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.game.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0792b {
        void a(int i3, String str);

        void b(int i3, SvcRespPushMsg svcRespPushMsg);
    }

    public void a() {
        this.f78556c = null;
        ArrayList<a> arrayList = this.f78557d;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f78557d.clear();
            }
            this.f78557d = null;
        }
    }

    public String b(String str) {
        if (!TextUtils.isEmpty(this.f78558e) && this.f78558e.equals(str)) {
            return this.f78559f;
        }
        return "";
    }

    public void c(String str, String str2, AppRuntime appRuntime, Context context, InterfaceC0792b interfaceC0792b) {
        this.f78558e = str;
        this.f78559f = str2;
        this.f78554a = context;
        this.f78556c = interfaceC0792b;
        String processName = MsfSdkUtils.getProcessName(context);
        this.f78555b = processName;
        if (processName.equals("com.tencent.mobileqq:MSF")) {
            return;
        }
        d(appRuntime);
    }

    public void d(AppRuntime appRuntime) {
        if (appRuntime.isLogin()) {
            appRuntime.setCmdCallbacker();
        } else if (QLog.isColorLevel()) {
            QLog.d("MSFToWebViewConnector", 2, "not login");
        }
    }

    public void e(Intent intent, FromServiceMsg fromServiceMsg) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (!TextUtils.isEmpty(serviceCmd) && serviceCmd.equals("OnlinePush.ReqPush.GameStatusPush")) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            if (wupBuffer == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSFToWebViewConnector", 2, "data is null");
                    return;
                }
                return;
            }
            SvcReqPushMsg svcReqPushMsg = new SvcReqPushMsg();
            boolean z16 = true;
            UniPacket uniPacket = new UniPacket(true);
            try {
                uniPacket.setEncodeName("utf-8");
                uniPacket.decode(wupBuffer);
                SvcReqPushMsg svcReqPushMsg2 = (SvcReqPushMsg) uniPacket.getByClass("req", svcReqPushMsg);
                if (this.f78557d == null) {
                    this.f78557d = new ArrayList<>();
                }
                int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
                ArrayList<a> arrayList = this.f78557d;
                if (arrayList != null) {
                    synchronized (arrayList) {
                        Iterator<a> it = this.f78557d.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                a next = it.next();
                                if (next.f78560a == requestSsoSeq && next.f78561b == svcReqPushMsg2.lUin) {
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                    }
                } else {
                    z16 = false;
                }
                ArrayList<a> arrayList2 = this.f78557d;
                if (arrayList2 != null) {
                    synchronized (arrayList2) {
                        if (z16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSFToWebViewConnector", 2, "duplicate msg ssoSeq=" + requestSsoSeq);
                            }
                            return;
                        }
                        if (this.f78557d.size() < 60) {
                            a aVar = new a();
                            aVar.f78560a = requestSsoSeq;
                            aVar.f78561b = svcReqPushMsg2.lUin;
                            this.f78557d.add(aVar);
                            if (QLog.isColorLevel()) {
                                QLog.d("MSFToWebViewConnector", 2, "add msg ssqSeq=" + requestSsoSeq);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSFToWebViewConnector", 2, "remove first cache msg");
                            }
                            this.f78557d.remove(0);
                        }
                    }
                }
                ArrayList<DelMsgInfo> arrayList3 = new ArrayList<>();
                ArrayList<MsgInfo> arrayList4 = svcReqPushMsg2.vMsgInfos;
                if (arrayList4 != null && arrayList4.size() > 0) {
                    Iterator<MsgInfo> it5 = arrayList4.iterator();
                    while (it5.hasNext()) {
                        MsgInfo next2 = it5.next();
                        if (528 == next2.shMsgType) {
                            DelMsgInfo delMsgInfo = new DelMsgInfo();
                            delMsgInfo.lFromUin = next2.lFromUin;
                            delMsgInfo.shMsgSeq = next2.shMsgSeq;
                            delMsgInfo.uMsgTime = next2.uMsgTime;
                            delMsgInfo.vMsgCookies = next2.vMsgCookies;
                            arrayList3.add(delMsgInfo);
                            try {
                                JceInputStream jceInputStream = new JceInputStream(next2.vMsg);
                                jceInputStream.setServerEncoding("utf-8");
                                MsgType0x210 msgType0x210 = new MsgType0x210();
                                msgType0x210.readFrom(jceInputStream);
                                if (msgType0x210.uSubMsgType == 66 && msgType0x210.vProtobuf != null) {
                                    Submsgtype0x42$GameStatusSync submsgtype0x42$GameStatusSync = new Submsgtype0x42$GameStatusSync();
                                    submsgtype0x42$GameStatusSync.mergeFrom(msgType0x210.vProtobuf);
                                    int i3 = submsgtype0x42$GameStatusSync.uint32_game_appid.get();
                                    ByteStringMicro byteStringMicro = submsgtype0x42$GameStatusSync.bytes_data.get();
                                    if (this.f78556c != null && byteStringMicro != null) {
                                        this.f78556c.a(i3, new String(byteStringMicro.toByteArray()));
                                    } else if (QLog.isColorLevel()) {
                                        QLog.d("MSFToWebViewConnector", 2, "no regist lisener or data is null");
                                    }
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSFToWebViewConnector", 2, e16.getMessage());
                                }
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("MSFToWebViewConnector", 2, "msgtype is not notify!");
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("MSFToWebViewConnector", 2, "msgInfo is null or size=0");
                }
                if (arrayList3.size() > 0) {
                    SvcRespPushMsg svcRespPushMsg = new SvcRespPushMsg();
                    int requestSsoSeq2 = fromServiceMsg.getRequestSsoSeq();
                    svcRespPushMsg.lUin = svcReqPushMsg2.lUin;
                    svcRespPushMsg.svrip = svcReqPushMsg2.svrip;
                    svcRespPushMsg.vDelInfos = arrayList3;
                    InterfaceC0792b interfaceC0792b = this.f78556c;
                    if (interfaceC0792b != null) {
                        interfaceC0792b.b(requestSsoSeq2, svcRespPushMsg);
                        return;
                    }
                    return;
                }
                return;
            } catch (RuntimeException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSFToWebViewConnector", 2, e17.getMessage(), e17);
                    return;
                }
                return;
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSFToWebViewConnector", 2, e18.getMessage(), e18);
                    return;
                }
                return;
            }
        }
        if (serviceCmd != null && QLog.isColorLevel()) {
            QLog.d("MSFToWebViewConnector", 2, "receive cmd=" + serviceCmd);
        }
    }
}

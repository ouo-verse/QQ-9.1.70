package com.tencent.av;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.at;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.avcore.netchannel.INetChannel;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.avcore.rtc.node.report.data.NodeModel$EndStatusCode;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.NewIntent;

/* loaded from: classes3.dex */
public class QavChannelProxy extends AbstractNetChannel implements INetChannelCallback, INetChannel {

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<Long, String> f72835g;

    /* renamed from: a, reason: collision with root package name */
    private BaseVideoAppInterface f72836a;

    /* renamed from: b, reason: collision with root package name */
    public int f72837b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f72838c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f72839d = 0;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.av.core.c f72840e = null;

    /* renamed from: f, reason: collision with root package name */
    private a f72841f;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();

        void b();

        void c(String str, long j3);

        void d();
    }

    static {
        HashMap<Long, String> hashMap = new HashMap<>();
        f72835g = hashMap;
        hashMap.put(512L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom");
        hashMap.put(513L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom");
        hashMap.put(515L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom");
        hashMap.put(516L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser");
        hashMap.put(514L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom");
        hashMap.put(517L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync");
        hashMap.put(518L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS");
        hashMap.put(519L, "trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap");
        hashMap.put(520L, "trpc.qqrtc.open_utils.OpenUtils.SsoGetSign");
        hashMap.put(1L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoCreateRoom");
        hashMap.put(4L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoInviteUser");
        hashMap.put(6L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoRefuseInvite");
        hashMap.put(8L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoIgnoreInvite");
        hashMap.put(1001L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoAcceptInvite");
        hashMap.put(Long.valueOf(Constant.FROM_ID_START_ACTIVITY), "trpc.qqrtc.av_appsvr.AvAppsvr.SsoLogOut");
        hashMap.put(12L, "trpc.qqrtc.av_appsvr.AvAppsvr.SsoQueryInfo");
        hashMap.put(24L, "trpc.qqrtc.av_appsvr.SharpQuality.SsoSdkInfoReport");
    }

    public QavChannelProxy(a aVar) {
        this.f72841f = aVar;
    }

    private void j() {
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.d();
        }
    }

    private void q(String str, byte[] bArr) {
        if (this.f72836a == null) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("QavNetChannel", 1, "sendSSOMultiVideoMsg, ssoCmd[" + str + "], seq[" + d16 + "]");
        }
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("reqType", 100);
        newIntent.putExtra("sso_cmd", str);
        newIntent.putExtra("wup_buffer", bArr);
        o(newIntent);
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel
    public void SendSharpVideoMsgBySSOChannel(int i3, long j3, byte[] bArr) {
        if (this.f72836a == null) {
            return;
        }
        String str = f72835g.get(Long.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            QLog.d("QavNetChannel", 1, "SendSharpVideoMsgBySSOChannel failed by cmd:=" + i3);
            return;
        }
        if ("trpc.qqrtc.av_appsvr.AvAppsvr.SsoInviteUser" == str && n.e().f() != null) {
            String r16 = n.e().f().r("onInviteSend");
            long currentTimeMillis = System.currentTimeMillis() - n.e().f().f73083u;
            if (currentTimeMillis > 5 && currentTimeMillis < 10000) {
                com.tencent.avcore.rtc.node.report.utils.b.y(r16, currentTimeMillis);
            }
            com.tencent.avcore.rtc.node.report.utils.b.v(r16, NodeModel$EndStatusCode.K_NORMAL.ordinal(), NodeModel$NodeEndReason.K_NORMAL.ordinal());
        }
        s.f(bArr);
        com.tencent.av.core.c cVar = this.f72840e;
        if (cVar == null) {
            ReportController.o(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
            r(true, str, this.f72836a.getCurrentAccountUin(), j3, bArr);
        } else {
            cVar.b(bArr, j3);
        }
    }

    public void b() {
        QLog.i("QavNetChannel", 1, "clearDeviceSharp, device: " + this.f72840e);
        if (this.f72840e != null) {
            this.f72840e = null;
        }
    }

    public void c() {
        this.f72838c = null;
        this.f72839d = 0;
    }

    public void d(String str) {
        if (this.f72836a != null && this.f72840e == null) {
            this.f72840e = new com.tencent.av.core.c(this, this.f72836a);
            n.e().f().f73067q = AppConstants.VALUE.UIN_TYPE_DEVICE;
            QLog.i("QavNetChannel", 1, "initDeviceSharp, device: " + this.f72840e + ", from: " + str);
        }
    }

    public boolean e() {
        if (this.f72840e != null) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        int currentTimeMillis = ((int) (System.currentTimeMillis() / 1000)) - this.f72839d;
        String str2 = this.f72838c;
        if (str2 != null && str != null && str2.equals(str) && currentTimeMillis < 3) {
            return true;
        }
        return false;
    }

    public void g(Bundle bundle) {
        this.f72838c = bundle.getString("fromUin");
        this.f72839d = (int) (System.currentTimeMillis() / 1000);
    }

    public void h() {
        if (this.f72840e != null) {
            ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).smartDeviceReportAccept();
        }
    }

    public void k(long j3) {
        if (this.f72836a == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "send0x265 --> Send 0x265 openId = " + j3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("reqType", 15);
        newIntent.putExtra("tinyid_list", arrayList);
        o(newIntent);
    }

    public void l(ArrayList<Long> arrayList) {
        if (this.f72836a == null) {
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
            newIntent.putExtra("reqType", 15);
            newIntent.putExtra("tinyid_list", arrayList);
            o(newIntent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "send0x265 --> tinyIDList is null Or size is 0");
        }
    }

    public void m(long j3, long j16, boolean z16) {
        if (this.f72836a == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("ver", (byte) 0);
        newIntent.putExtra("type", (byte) 1);
        newIntent.putExtra("selfuin", z16);
        newIntent.putExtra("groupuin", j3);
        newIntent.putExtra("groupcode", j16);
        newIntent.putExtra("reqType", 13);
        o(newIntent);
    }

    public void n(long j3, long j16, long j17) {
        if (this.f72836a == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("ver", (byte) 0);
        newIntent.putExtra("type", (byte) 1);
        newIntent.putExtra("selfuin", j3);
        newIntent.putExtra("groupuin", j16);
        newIntent.putExtra("groupcode", j17);
        newIntent.putExtra("reqType", 12);
        o(newIntent);
    }

    public void o(NewIntent newIntent) {
        BaseVideoAppInterface baseVideoAppInterface = this.f72836a;
        if (baseVideoAppInterface == null) {
            return;
        }
        try {
            baseVideoAppInterface.startServlet(newIntent);
        } catch (Exception e16) {
            QLog.w("QavNetChannel", 1, "sendMsg, Exception", e16);
        }
    }

    public void p(String str, long j3, long j16, byte[] bArr, boolean z16) {
        if (this.f72836a == null) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("QavNetChannel", 1, "sendMultiVideoMsg, cmsCmd[" + j16 + "], seq[" + d16 + "], isOpenSDK[" + z16 + "]");
        }
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("ver", (byte) 0);
        newIntent.putExtra("type", (byte) 1);
        newIntent.putExtra("cscmd", (short) j16);
        newIntent.putExtra("selfuin", com.tencent.av.utils.i.g(str));
        newIntent.putExtra("toUin", j3);
        newIntent.putExtra("vMsg", bArr);
        newIntent.putExtra("reqType", 8);
        at.f(newIntent, d16);
        o(newIntent);
    }

    void r(boolean z16, String str, String str2, long j3, byte[] bArr) {
        String str3;
        Object obj;
        if (this.f72836a != null && !TextUtils.isEmpty(str2) && j3 != 0) {
            boolean z17 = false;
            SessionInfo i3 = n.e().i(n.b(3, String.valueOf(j3), new int[0]));
            if (i3 != null) {
                str3 = i3.r("sendSharpMsg");
            } else {
                str3 = "";
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendSharpMsg selfUin: ");
                sb5.append(str2);
                sb5.append(", toUin: ");
                sb5.append(com.tencent.av.utils.i.a(j3));
                sb5.append(", uinType = ");
                if (i3 != null) {
                    obj = Integer.valueOf(i3.f73067q);
                } else {
                    obj = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                }
                sb5.append(obj);
                sb5.append(", useSSO = ");
                sb5.append(z16);
                sb5.append("traceId:=");
                sb5.append(str3);
                sb5.append(", cmd = ");
                sb5.append(str);
                sb5.append(", SessionExist:=");
                if (i3 != null) {
                    z17 = true;
                }
                sb5.append(z17);
                QLog.d("QavNetChannel", 2, sb5.toString());
            }
            NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
            if (z16) {
                newIntent.putExtra("reqType", 100);
                newIntent.putExtra("traceId", str3);
                newIntent.putExtra("sso_cmd", str);
                newIntent.putExtra("wup_buffer", bArr);
            } else {
                newIntent.putExtra("reqType", 4);
                newIntent.putExtra("selfuin", com.tencent.av.utils.i.g(str2));
                newIntent.putExtra("toUin", j3);
                newIntent.putExtra("vMsg", bArr);
            }
            ReportController.o(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
            o(newIntent);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveDeviceMsg(Bundle bundle) {
        byte[] byteArray;
        if (bundle == null || this.f72836a == null || (byteArray = bundle.getByteArray("buffer")) == null) {
            return;
        }
        if (this.f72840e == null) {
            ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).smartDeviceReportReceive();
        }
        d("receiveDeviceMsg");
        if (QLog.isColorLevel()) {
            QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
        }
        receiveSharpVideoCall(Long.valueOf(this.f72836a.getCurrentAccountUin()).longValue(), byteArray, null);
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoAck(Bundle bundle) {
        final byte[] byteArray = bundle.getByteArray("buffer");
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoAck buf=%s", byteArray));
        }
        j();
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.b();
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.av.QavChannelProxy.1
            @Override // java.lang.Runnable
            public void run() {
                QavChannelProxy.this.receiveMultiVideoMsg(2, byteArray, false);
            }
        });
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoMsg(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("buffer");
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoMsg buf=%s", byteArray));
        }
        j();
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.b();
        }
        receiveMultiVideoMsg(1, byteArray, false);
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveMultiVideoOfflineMsg(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoOfflineMsg data=%s", bundle));
        }
        j();
        a aVar = this.f72841f;
        if (aVar != null && aVar.a()) {
            return;
        }
        byte[] byteArray = bundle.getByteArray("buffer");
        a aVar2 = this.f72841f;
        if (aVar2 != null) {
            aVar2.b();
        }
        receiveMultiVideoMsg(3, byteArray, false);
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSSOMultiVideoAck(final int i3, final byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "receiveSSOMultiVideoAck");
        }
        j();
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.b();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.QavChannelProxy.2
            @Override // java.lang.Runnable
            public void run() {
                QavChannelProxy.this.receiveMultiVideoMsg(i3, bArr, false);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSSOMultiVideoMsg(int i3, byte[] bArr, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "receiveSSOMultiVideoMsg. cmd: " + i3 + ", isFromNTKernel: " + z16);
        }
        j();
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.b();
        }
        receiveMultiVideoMsg(i3, bArr, z16);
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoAck(Bundle bundle) {
        if (this.f72836a == null) {
            return;
        }
        j();
        byte receiveSharpVideoAck = receiveSharpVideoAck(Long.valueOf(this.f72836a.getCurrentAccountUin()).longValue(), bundle.getByteArray("buffer"), null);
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "receiveSharpVideoAck: result = " + ((int) receiveSharpVideoAck));
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoMsg(Bundle bundle) {
        if (this.f72836a == null) {
            return;
        }
        j();
        byte[] byteArray = bundle.getByteArray("buffer");
        String string = bundle.getString("fromUin");
        byte receiveSharpVideoCall = receiveSharpVideoCall(Long.valueOf(this.f72836a.getCurrentAccountUin()).longValue(), byteArray, null);
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: selfUin = " + this.f72836a.getCurrentAccountUin() + ", fromUin = " + string + ", result = " + ((int) receiveSharpVideoCall));
        }
        this.f72837b = 0;
        SessionInfo f16 = n.e().f();
        if (f16.f73067q == 1006 && !f16.G && !TextUtils.equals(string, this.f72836a.getCurrentAccountUin())) {
            f16.f73103z = string;
            if (QLog.isColorLevel()) {
                QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: CONTACT_STRANGER_FRIEND  peerUin = " + string);
            }
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveSharpVideoOfflineMsg(Bundle bundle) {
        if (this.f72836a == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, String.format("receiveSharpVideoOfflineMsg data=%s", bundle));
        }
        j();
        String currentAccountUin = this.f72836a.getCurrentAccountUin();
        String string = bundle.getString("traceId");
        byte[] byteArray = bundle.getByteArray("buffer");
        boolean z16 = bundle.getBoolean("isRequest");
        g(bundle);
        long j3 = bundle.getLong("msf_timestamp");
        String string2 = bundle.getString("fromUin");
        RtcNodeReportReceiverHelper.y(string, currentAccountUin, String.valueOf(string2), true, 0L);
        RtcNodeReportReceiverHelper.w(string, 2);
        a aVar = this.f72841f;
        if (aVar != null) {
            aVar.c(string2, j3);
        }
        QLog.d("QavNetChannel", 1, "quaReport --> receiveSharpVideoOfflineMsg msf_timestamp = " + j3);
        byte receiveSharpVideoCall = receiveSharpVideoCall(Long.valueOf(currentAccountUin).longValue(), byteArray, null);
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "receiveSharpVideoCall result: " + ((int) receiveSharpVideoCall) + ", buf.length: " + byteArray.length);
        }
        if (z16 && this.f72837b == -1) {
            this.f72837b = 1;
        }
    }

    void s(String str, String str2, byte[] bArr) {
        if (this.f72836a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("QavNetChannel", 2, "sendVideoConfigReqMsg: buf[2] = " + ((int) bArr[2]));
            }
            NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
            newIntent.putExtra("reqType", 3);
            newIntent.putExtra("selfuin", str);
            newIntent.putExtra("toUin", s.d(str2));
            newIntent.putExtra("vMsg", bArr);
            o(newIntent);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.IMavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendGetGatewayMsg() {
        if (this.f72836a == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavNetChannel", 2, "sendGetGatewayMsg");
        }
        NewIntent newIntent = new NewIntent(this.f72836a.getApplication(), ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
        newIntent.putExtra("reqType", 7);
        o(newIntent);
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendGetVideoConfig(byte[] bArr) {
        if (this.f72836a == null) {
            return;
        }
        s(this.f72836a.getCurrentAccountUin(), n.e().f().f73091w, bArr);
    }

    @Override // com.tencent.avcore.netchannel.IMavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendMultiVideoMsg(long j3, long j16, byte[] bArr, boolean z16) {
        if (this.f72836a == null) {
            return;
        }
        HashMap<Long, String> hashMap = f72835g;
        if (hashMap.containsKey(Long.valueOf(j16))) {
            q(hashMap.get(Long.valueOf(j16)), bArr);
        } else {
            p(this.f72836a.getCurrentAccountUin(), j3, j16, bArr, z16);
        }
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel
    public void sendSharpVideoMsgByJCEChannel(long j3, byte[] bArr) {
        if (this.f72836a == null) {
            return;
        }
        s.f(bArr);
        com.tencent.av.core.c cVar = this.f72840e;
        if (cVar == null) {
            ReportController.o(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
            r(false, "", this.f72836a.getCurrentAccountUin(), j3, bArr);
        } else {
            cVar.b(bArr, j3);
        }
    }

    public void t(BaseVideoAppInterface baseVideoAppInterface) {
        this.f72836a = baseVideoAppInterface;
    }

    public void i(byte[] bArr) {
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveOpenImAck(byte[] bArr) {
    }

    @Override // com.tencent.avcore.netchannel.INetChannelCallback
    public void receiveVideoConfig(Bundle bundle) {
    }

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendLogReportMsg(long j3, byte[] bArr) {
    }

    @Override // com.tencent.avcore.netchannel.IDavNetChannel, com.tencent.avcore.netchannel.INetChannel
    public void sendSharpVideoMsg(long j3, byte[] bArr) {
    }
}

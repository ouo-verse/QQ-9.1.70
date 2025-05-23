package com.tencent.qav.channel;

import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<Long, String> f342358c;

    /* renamed from: a, reason: collision with root package name */
    private b f342359a;

    /* renamed from: b, reason: collision with root package name */
    private g f342360b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33507);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        HashMap<Long, String> hashMap = new HashMap<>();
        f342358c = hashMap;
        hashMap.put(512L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom");
        hashMap.put(513L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom");
        hashMap.put(515L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom");
        hashMap.put(516L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser");
        hashMap.put(514L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom");
        hashMap.put(517L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync");
        hashMap.put(518L, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS");
        hashMap.put(519L, "trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap");
        hashMap.put(520L, "trpc.qqrtc.open_utils.OpenUtils.SsoGetSign");
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Bundle b(byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("buffer", bArr);
        return bundle;
    }

    private boolean d(int i3) {
        boolean z16;
        g gVar = this.f342360b;
        if (gVar != null) {
            z16 = gVar.a(i3);
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoChannelBase", 2, "isMultiVideoMsgSupport support: " + z16);
        }
        return z16;
    }

    private boolean e(int i3) {
        g gVar = this.f342360b;
        if (gVar != null) {
            return gVar.b(i3);
        }
        return true;
    }

    private void r(MultiVideoMsg multiVideoMsg) {
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("MultiVideo");
        uniPacket.setFuncName("MultiVideos2cack");
        uniPacket.put("MultiVideoMsg", multiVideoMsg);
        s(uniPacket.encode());
    }

    private void v(SharpVideoMsg sharpVideoMsg) {
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("SharpSvr");
        uniPacket.setFuncName("s2cack");
        uniPacket.put("SharpVideoMsg", sharpVideoMsg);
        w(uniPacket.encode());
    }

    @Override // com.tencent.qav.channel.d
    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f342359a = bVar;
        }
    }

    protected abstract long c();

    public void f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        b bVar = this.f342359a;
        if (bVar != null) {
            bVar.receiveGatewayMsg(str, i3);
        }
    }

    public void g(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr);
            return;
        }
        if (this.f342359a != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            MultiVideoMsg multiVideoMsg = (MultiVideoMsg) uniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
            com.tencent.qav.log.a.a("VideoChannelBase", String.format("receiveMultiVideoAck type=0x%X csCmd=0x%X", Byte.valueOf(multiVideoMsg.type), Short.valueOf(multiVideoMsg.csCmd)));
            if (d(multiVideoMsg.type)) {
                this.f342359a.receiveMultiVideoAck(b(multiVideoMsg.video_buff));
            }
        }
    }

    public void h(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
            return;
        }
        if (this.f342359a != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            MultiVideoMsg multiVideoMsg = (MultiVideoMsg) uniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
            com.tencent.qav.log.a.a("VideoChannelBase", String.format("receiveMultiVideoMsg type=0x%X csCmd=0x%X", Byte.valueOf(multiVideoMsg.type), Short.valueOf(multiVideoMsg.csCmd)));
            if (d(multiVideoMsg.type)) {
                r(multiVideoMsg);
                this.f342359a.receiveMultiVideoMsg(b(multiVideoMsg.video_buff));
            }
        }
    }

    public void i(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bArr);
            return;
        }
        com.tencent.qav.log.a.a("VideoChannelBase", "receiveOpenImAck");
        b bVar = this.f342359a;
        if (bVar != null) {
            bVar.receiveOpenImAck(bArr);
        }
    }

    public void j(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) bArr);
            return;
        }
        b bVar = this.f342359a;
        if (bVar != null) {
            bVar.receiveSSOMultiVideoAck(i3, bArr);
        }
    }

    public void k(int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoChannelBase", 2, "receiveSSOMultiVideoMsg type: " + i3 + " cmd: " + i16);
        }
        if (this.f342359a != null && d(i3)) {
            this.f342359a.receiveSSOMultiVideoMsg(i16, bArr, false);
        }
    }

    public void l(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
            return;
        }
        if (this.f342359a != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            SharpVideoMsg sharpVideoMsg = (SharpVideoMsg) uniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
            if (e(sharpVideoMsg.type)) {
                this.f342359a.receiveSharpVideoAck(b(sharpVideoMsg.video_buff));
            }
        }
    }

    public void m(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
            return;
        }
        if (this.f342359a != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            SharpVideoMsg sharpVideoMsg = (SharpVideoMsg) uniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
            if (e(sharpVideoMsg.type)) {
                v(sharpVideoMsg);
                this.f342359a.receiveSharpVideoMsg(b(sharpVideoMsg.video_buff));
            }
        }
    }

    public void n(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr);
            return;
        }
        if (this.f342359a != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            this.f342359a.receiveVideoConfig(b(((VideoCallMsg) uniPacket.getByClass("VideoCallMsg", new VideoCallMsg())).vMsg));
        }
    }

    protected abstract void o();

    protected abstract void p(byte[] bArr);

    protected abstract void q(long j3, byte[] bArr);

    protected abstract void s(byte[] bArr);

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendGetGatewayMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            o();
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendGetVideoConfig(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            return;
        }
        long c16 = c();
        VideoCallMsg videoCallMsg = new VideoCallMsg();
        videoCallMsg.ver = (byte) 1;
        videoCallMsg.type = (byte) 1;
        videoCallMsg.lUin = c16;
        videoCallMsg.uDateTime = (int) (System.currentTimeMillis() / 1000);
        videoCallMsg.vMsg = bArr;
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("VideoSvc");
        uniPacket.setFuncName("SendVideoMsg");
        uniPacket.put("VideoCallMsg", videoCallMsg);
        p(uniPacket.encode());
    }

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendLogReportMsg(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), bArr);
        } else {
            q(j3, bArr);
        }
    }

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendMultiVideoMsg(long j3, long j16, byte[] bArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16), bArr, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            com.tencent.qav.log.a.a("VideoChannelBase", String.format("sendMultiVideoMsg isOpenSDK=%s", Boolean.valueOf(z16)));
            u("videohubRelay2OpenSSO.openim.pbvideoapp", bArr);
            return;
        }
        HashMap<Long, String> hashMap = f342358c;
        if (hashMap.containsKey(Long.valueOf(j16))) {
            u(hashMap.get(Long.valueOf(j16)), bArr);
            return;
        }
        long c16 = c();
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j3));
        MultiVideoMsg multiVideoMsg = new MultiVideoMsg();
        multiVideoMsg.ver = (byte) 0;
        multiVideoMsg.type = (byte) 1;
        multiVideoMsg.csCmd = (short) j16;
        multiVideoMsg.from_uin = c16;
        multiVideoMsg.to_uin = arrayList;
        multiVideoMsg.video_buff = bArr;
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("MultiVideo");
        uniPacket.setFuncName("MultiVideoMsg");
        uniPacket.put("MultiVideoMsg", multiVideoMsg);
        t(uniPacket.encode());
    }

    @Override // com.tencent.avcore.netchannel.INetChannel
    public void sendSharpVideoMsg(long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), bArr);
            return;
        }
        long c16 = c();
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j3));
        SharpVideoMsg sharpVideoMsg = new SharpVideoMsg();
        sharpVideoMsg.ver = (byte) 1;
        sharpVideoMsg.type = (byte) 1;
        sharpVideoMsg.from_uin = c16;
        sharpVideoMsg.to_uin = arrayList;
        sharpVideoMsg.video_buff = bArr;
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("SharpSvr");
        uniPacket.setFuncName("c2s");
        uniPacket.put("SharpVideoMsg", sharpVideoMsg);
        x(uniPacket.encode());
    }

    protected abstract void t(byte[] bArr);

    protected abstract void u(String str, byte[] bArr);

    protected abstract void w(byte[] bArr);

    protected abstract void x(byte[] bArr);

    public void y(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
        } else {
            this.f342360b = gVar;
        }
    }
}

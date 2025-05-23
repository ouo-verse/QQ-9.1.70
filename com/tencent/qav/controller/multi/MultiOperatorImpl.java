package com.tencent.qav.controller.multi;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.utils.ad;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.GetSignResponse;
import com.tencent.avcore.jni.data.MavCommonPBMsg;
import com.tencent.avcore.jni.data.OpenSDKEnterRoomParam;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.channel.d;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MultiOperatorImpl extends b implements a, CallingStateMonitor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected final AudioManager f342369f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f342370g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f342371h;

    /* renamed from: i, reason: collision with root package name */
    protected int f342372i;

    /* renamed from: j, reason: collision with root package name */
    protected com.tencent.qav.a f342373j;

    /* renamed from: k, reason: collision with root package name */
    protected Map<Long, QavDef$MultiUserInfo> f342374k;

    /* renamed from: l, reason: collision with root package name */
    protected volatile boolean f342375l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f342376m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f342377n;

    /* renamed from: o, reason: collision with root package name */
    private Runnable f342378o;

    public MultiOperatorImpl(Context context, long j3, d dVar, boolean z16, int i3, int i16, boolean z17) {
        super(context, j3, dVar, z16, i3, i16, z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), dVar, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        this.f342376m = false;
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", context, Long.valueOf(j3), dVar));
        this.f342369f = (AudioManager) this.f342379a.getSystemService("audio");
        this.f342374k = new HashMap();
        CallingStateMonitor.k().o(this);
    }

    private int H(boolean z16) {
        QLog.d("MultiOperatorImpl", 1, String.format("setLocalAudioEnable enable=%s", Boolean.valueOf(z16)));
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            if (z16) {
                return qQGAudioCtrl.startAudioSend(true);
            }
            return qQGAudioCtrl.stopAudioSend(true);
        }
        return -1;
    }

    private void J(boolean z16) {
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", Boolean.valueOf(z16)));
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            if (z16) {
                qQGAudioCtrl.startAudioRecv();
            } else {
                qQGAudioCtrl.stopAudioRecv();
            }
        }
    }

    private void N() {
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.requestMemPosInfoList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, qavDef$MultiUserInfo, Boolean.valueOf(z16));
        } else {
            com.tencent.qav.observer.b.f().d(c.class, 5, qavDef$MultiUserInfo, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) qavDef$MultiUserInfo);
        } else {
            com.tencent.qav.observer.b.f().d(c.class, 3, qavDef$MultiUserInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) qavDef$MultiUserInfo);
        } else {
            com.tencent.qav.observer.b.f().d(c.class, 4, qavDef$MultiUserInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) qavDef$MultiUserInfo);
            return;
        }
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            map.put(Long.valueOf(qavDef$MultiUserInfo.mUin), qavDef$MultiUserInfo);
        }
    }

    public void E(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) str);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.registerOpenSdkApp(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        Runnable runnable = this.f342378o;
        if (runnable != null) {
            com.tencent.qav.thread.a.e(runnable);
            this.f342378o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QavDef$MultiUserInfo G(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (QavDef$MultiUserInfo) iPatchRedirector.redirect((short) 42, (Object) this, j3);
        }
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            return map.remove(Long.valueOf(j3));
        }
        return null;
    }

    public void I(OpenSDKEnterRoomParam openSDKEnterRoomParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) openSDKEnterRoomParam);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.setOpenSDKEnterRoomParam(openSDKEnterRoomParam);
        }
    }

    public void K(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), str, str2);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.spearAddParamByRole(i3, str, str2);
        }
    }

    public void L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.spearClear(i3);
        }
    }

    public void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.unregisterOpenSdkApp(i3);
        }
    }

    @Override // com.tencent.av.gaudio.b
    public void b(long j3, ArrayList<AVUserInfo> arrayList) {
        long j16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), arrayList);
            return;
        }
        com.tencent.qav.a aVar = this.f342373j;
        if (aVar == null) {
            return;
        }
        if (aVar.f342343a == 11) {
            Iterator<AVUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AVUserInfo next = it.next();
                try {
                    j16 = Long.parseLong(next.account);
                } catch (NumberFormatException e16) {
                    com.tencent.qav.log.a.c("MultiOperatorImpl", "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                    j16 = 0;
                }
                QavDef$MultiUserInfo u16 = u(j16);
                if (u16 == null) {
                    u16 = new QavDef$MultiUserInfo();
                    u16.mUin = j16;
                    u16.mMicOn = true;
                    D(u16);
                }
                if (TextUtils.isEmpty(u16.mOpenId)) {
                    u16.mOpenId = next.openId;
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    B(u16);
                    if (!u16.mMicOn) {
                        A(u16, false);
                    }
                }
            }
        }
        if (this.f342377n) {
            List<QavDef$MultiUserInfo> v3 = v();
            com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", Long.valueOf(j3), v3));
            com.tencent.qav.observer.b.f().d(c.class, 7, v3);
            this.f342377n = false;
        }
    }

    @Override // com.tencent.qav.monitor.CallingStateMonitor.c
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            s(1, z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x01dd, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:8:0x0010, B:12:0x001c, B:14:0x0021, B:17:0x002c, B:19:0x0051, B:23:0x005d, B:27:0x007f, B:29:0x0083, B:32:0x008f, B:34:0x00a1, B:36:0x00a7, B:37:0x01ac, B:39:0x01c3, B:40:0x01c6, B:52:0x00d5, B:55:0x00fa, B:58:0x013d, B:59:0x0163, B:60:0x0188, B:62:0x01d1), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[Catch: all -> 0x01dd, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:8:0x0010, B:12:0x001c, B:14:0x0021, B:17:0x002c, B:19:0x0051, B:23:0x005d, B:27:0x007f, B:29:0x0083, B:32:0x008f, B:34:0x00a1, B:36:0x00a7, B:37:0x01ac, B:39:0x01c3, B:40:0x01c6, B:52:0x00d5, B:55:0x00fa, B:58:0x013d, B:59:0x0163, B:60:0x0188, B:62:0x01d1), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int e(com.tencent.qav.a aVar) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).intValue();
        }
        int i16 = -1;
        if (this.f342379a == null) {
            com.tencent.qav.log.a.b("MultiOperatorImpl", "enterRoom failed for context is null.");
            return -1;
        }
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("enterRoom param=%s", aVar));
        boolean m3 = CallingStateMonitor.k().m();
        if (!CallingStateMonitor.k().l() && !ad.b(this.f342379a)) {
            z16 = false;
            com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", Boolean.valueOf(m3), Boolean.valueOf(z16)));
            if (!m3 && !z16) {
                if (!this.f342375l) {
                    com.tencent.qav.log.a.b("MultiOperatorImpl", "enterRoom duplicate call.");
                    return -3;
                }
                com.tencent.qav.controller.a.e(this.f342382d);
                com.tencent.qav.controller.a.f(this.f342382d, this.f342379a, this.f342380b);
                QQGAudioCtrl qQGAudioCtrl = this.f342381c;
                if (qQGAudioCtrl != null) {
                    this.f342373j = aVar;
                    int i17 = aVar.f342349g;
                    if (i17 == 1) {
                        i3 = qQGAudioCtrl.startCommonGAudio(aVar.f342343a, aVar.f342344b, aVar.f342345c, aVar.f342346d, this.f342380b, aVar.f342348f, i17, aVar.f342350h, 0);
                    } else {
                        if (i17 != 2 && i17 != 4 && 7 != i17) {
                            if (i17 == 5) {
                                i3 = qQGAudioCtrl.startCommonGAudio(aVar.f342343a, aVar.f342344b, aVar.f342345c, aVar.f342346d, this.f342380b, aVar.f342348f, i17, aVar.f342350h, 0);
                            } else if (i17 == 6) {
                                QLog.d("MultiOperatorImpl", 2, "enterRoom: param: " + aVar.toString());
                                i3 = this.f342381c.startCommonGAudio(aVar.f342343a, aVar.f342344b, aVar.f342345c, aVar.f342346d, this.f342380b, aVar.f342348f, aVar.f342349g, aVar.f342350h, 0);
                            } else if (i17 == 8) {
                                i3 = qQGAudioCtrl.commonRequest(aVar.f342343a, aVar.f342346d, aVar.f342344b, aVar.f342345c, i17, 0, 8, aVar.f342348f, i17, aVar.f342350h, aVar.f342351i);
                            } else {
                                i3 = qQGAudioCtrl.commonRequest(aVar.f342343a, aVar.f342346d, aVar.f342344b, aVar.f342345c, i17, 0, 8, "", i17, aVar.f342350h, aVar.f342351i);
                            }
                        }
                        i3 = qQGAudioCtrl.commonRequest(aVar.f342343a, aVar.f342346d, aVar.f342344b, aVar.f342345c, i17, 0, 8, "", i17, aVar.f342350h, aVar.f342351i);
                    }
                    com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("enterRoom result=%s", Integer.valueOf(i3)));
                    if (i3 == 0) {
                        r();
                    }
                    this.f342375l = true;
                    this.f342376m = false;
                } else {
                    i3 = -1;
                }
                if (i3 == 0) {
                    i16 = 0;
                }
                return i16;
            }
            com.tencent.qav.log.a.b("MultiOperatorImpl", "enterRoom device take up.");
            return -2;
        }
        z16 = true;
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", Boolean.valueOf(m3), Boolean.valueOf(z16)));
        if (!m3) {
            if (!this.f342375l) {
            }
        }
        com.tencent.qav.log.a.b("MultiOperatorImpl", "enterRoom device take up.");
        return -2;
    }

    @Override // com.tencent.qav.controller.multi.a
    public int enableLocalAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, z16)).intValue();
        }
        this.f342370g = z16;
        return H(z16);
    }

    @Override // com.tencent.qav.controller.multi.a
    public void enableRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            J(z16);
            this.f342371h = z16;
        }
    }

    public synchronized void exitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.qav.log.a.a("MultiOperatorImpl", "exitRoom");
        this.f342373j = null;
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            map.clear();
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.quitRoom(0);
            F();
            this.f342375l = false;
        }
    }

    @Override // com.tencent.qav.controller.multi.a
    public int getAudioRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f342372i;
    }

    @Override // com.tencent.qav.controller.multi.a
    public String getNetWorkQualityRTT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            try {
                return qQGAudioCtrl.getNetWorkQualityRTT();
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return null;
    }

    @Override // com.tencent.qav.controller.multi.a
    public boolean isLocalAudioEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f342370g;
    }

    @Override // com.tencent.av.gaudio.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        }
    }

    @Override // com.tencent.qav.monitor.CallingStateMonitor.c
    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
        } else {
            s(2, z16);
        }
    }

    @Override // com.tencent.qav.controller.multi.b
    public synchronized void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        CallingStateMonitor.k().o(null);
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            map.clear();
            this.f342374k = null;
        }
        super.l();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCreateRoomSuc(int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
            return;
        }
        QLog.i("MultiOperatorImpl", 1, String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)));
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)));
        x();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onEnterSuc(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QLog.i("MultiOperatorImpl", 1, String.format("onEnterSuc relationType=%s groupId=%s multiAvType=%s", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemberMicChanged(String str, int i3, int i16, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        boolean z17 = !z16;
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", str, Boolean.valueOf(z17)));
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c("MultiOperatorImpl", "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        QavDef$MultiUserInfo u16 = u(j3);
        if (u16 != null) {
            u16.mMicOn = !z16;
            if (!TextUtils.isEmpty(u16.mOpenId) || this.f342373j.f342343a != 11) {
                A(u16, z17);
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioSDKError(int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        com.tencent.qav.log.a.b("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17)));
        exitRoom();
        F();
        if (i16 == 15) {
            y(3);
        } else {
            y(2);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGetSignRespond(GetSignResponse getSignResponse, long j3, int i3, int i16, long j16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, getSignResponse, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
            return;
        }
        QLog.d("MultiOperatorImpl", 4, "onGetSignResponse");
        if (getSignResponse != null) {
            z(getSignResponse.ret, getSignResponse.f77478msg, getSignResponse.sign);
        } else {
            QLog.e("MultiOperatorImpl", 2, "onGetSignRespond: response is null");
            z(-1L, "", "");
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGetUinOpenIdRespond(UinOpenIdResponse uinOpenIdResponse, long j3, int i3, int i16, long j16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, uinOpenIdResponse, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupVideoClosed(int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17)));
        exitRoom();
        F();
        y(2);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onMAVMemberInOrOut(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int... iArr) {
        long j17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, aVUserInfo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), iArr);
            return;
        }
        QLog.i("MultiOperatorImpl", 1, "onMAVMemberInOrOut userInfo.account: " + aVUserInfo.account + "  mSelfUin:" + this.f342380b + " opType:" + i3);
        if (this.f342373j == null) {
            return;
        }
        try {
            j17 = Long.parseLong(aVUserInfo.account);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c("MultiOperatorImpl", "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j17 = 0;
        }
        if (i3 == 70) {
            com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s userInfo=%s", aVUserInfo.account, Long.valueOf(j3), aVUserInfo.toString()));
            if (j17 == this.f342380b) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                F();
                com.tencent.qav.observer.b.f().d(c.class, 1, new Object[0]);
            }
            QavDef$MultiUserInfo u16 = u(j17);
            if (u16 == null && !z16) {
                QavDef$MultiUserInfo qavDef$MultiUserInfo = new QavDef$MultiUserInfo();
                qavDef$MultiUserInfo.mUin = j17;
                if (!TextUtils.isEmpty(aVUserInfo.openId)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MultiOperatorImpl", 2, "onMemberInOrOut openId: " + aVUserInfo.openId);
                    }
                    qavDef$MultiUserInfo.mOpenId = aVUserInfo.openId;
                } else if (QLog.isColorLevel()) {
                    QLog.d("MultiOperatorImpl", 2, "onMemberInOrOut openId is empty");
                }
                qavDef$MultiUserInfo.mMicOn = true;
                D(qavDef$MultiUserInfo);
                com.tencent.qav.a aVar = this.f342373j;
                if (aVar != null && aVar.f342343a == 11) {
                    if (TextUtils.isEmpty(aVUserInfo.openId)) {
                        N();
                        return;
                    } else {
                        B(qavDef$MultiUserInfo);
                        return;
                    }
                }
                B(qavDef$MultiUserInfo);
                return;
            }
            if (z16) {
                u16 = new QavDef$MultiUserInfo();
                u16.mUin = this.f342380b;
                if (!TextUtils.isEmpty(aVUserInfo.openId)) {
                    u16.mOpenId = aVUserInfo.openId;
                } else {
                    u16.mOpenId = this.f342373j.f342348f;
                }
                u16.mMicOn = true;
                D(u16);
            }
            B(u16);
            return;
        }
        if (i3 == 71) {
            com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s userInfo=%s", aVUserInfo.account, Long.valueOf(j3), aVUserInfo.toString()));
            QavDef$MultiUserInfo G = G(j17);
            if (G != null) {
                C(G);
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
        boolean z16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (i3 == 42 || i3 == 43) {
            if (i3 == 42) {
                z16 = true;
            } else {
                z16 = false;
            }
            for (String str : strArr) {
                try {
                    j17 = Long.parseLong(str);
                } catch (NumberFormatException e16) {
                    com.tencent.qav.log.a.c("MultiOperatorImpl", "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                    j17 = 0;
                }
                QavDef$MultiUserInfo u16 = u(j17);
                if (u16 != null && (!TextUtils.isEmpty(u16.mOpenId) || this.f342373j.f342343a != 11)) {
                    com.tencent.qav.observer.b.f().d(c.class, 6, u16, Boolean.valueOf(z16), Integer.valueOf(i18));
                }
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onNotifyBusinessExtInfo(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, aVUserInfo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onNotifyCommonTips(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3, (Object) bArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRecvCommonChannelMsg(MavCommonPBMsg.MavCommonChannelInfo mavCommonChannelInfo, long j3, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, mavCommonChannelInfo, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onSelfAudioVolumeChange(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, j3);
            return;
        }
        QavDef$MultiUserInfo u16 = u(this.f342380b);
        if (u16 != null) {
            if (!TextUtils.isEmpty(u16.mOpenId) || this.f342373j.f342343a != 11) {
                com.tencent.qav.observer.b.f().d(c.class, 6, u16, Boolean.TRUE, Integer.valueOf((int) j3));
            }
        }
    }

    public void q(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) str);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.changeAvRole(i3, str);
        }
    }

    protected void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        } else if (this.f342378o == null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.qav.controller.multi.MultiOperatorImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiOperatorImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MultiOperatorImpl.this.exitRoom();
                    MultiOperatorImpl.this.y(1);
                    MultiOperatorImpl.this.f342378o = null;
                }
            };
            this.f342378o = runnable;
            com.tencent.qav.thread.a.a(runnable, 30000L);
        }
    }

    protected void s(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            com.tencent.qav.log.a.a("MultiOperatorImpl", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s]", Integer.valueOf(i3), Boolean.valueOf(this.f342375l)));
            if (this.f342375l) {
                exitRoom();
                y(4);
            }
        }
    }

    public void setAudioRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        try {
            if (i3 == 0) {
                this.f342369f.stopBluetoothSco();
                this.f342369f.setBluetoothScoOn(false);
                this.f342369f.setSpeakerphoneOn(false);
                this.f342369f.setMode(3);
                this.f342372i = i3;
            } else if (i3 == 1) {
                this.f342369f.stopBluetoothSco();
                this.f342369f.setBluetoothScoOn(false);
                this.f342369f.setSpeakerphoneOn(true);
                this.f342369f.setMode(3);
                this.f342372i = i3;
            } else if (i3 == 2) {
                this.f342369f.startBluetoothSco();
                this.f342369f.setBluetoothScoOn(true);
                this.f342369f.setSpeakerphoneOn(false);
                this.f342369f.setMode(3);
                this.f342372i = i3;
            }
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("MultiOperatorImpl", "setAudioRoute fail.", e16);
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, z16);
            return;
        }
        QQGAudioCtrl qQGAudioCtrl = this.f342381c;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.enableAIDenoise(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QavDef$MultiUserInfo u(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (QavDef$MultiUserInfo) iPatchRedirector.redirect((short) 40, (Object) this, j3);
        }
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            return map.get(Long.valueOf(j3));
        }
        return null;
    }

    @Override // com.tencent.qav.controller.multi.a
    public synchronized void updateRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qav.log.a.a("MultiOperatorImpl", "updateRoomInfo");
        N();
        this.f342377n = true;
    }

    public List<QavDef$MultiUserInfo> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (List) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        Map<Long, QavDef$MultiUserInfo> map = this.f342374k;
        if (map != null) {
            Collection<QavDef$MultiUserInfo> values = map.values();
            if (!values.isEmpty()) {
                return new ArrayList(values);
            }
        }
        return null;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f342371h;
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            com.tencent.qav.observer.b.f().d(c.class, 0, new Object[0]);
        }
    }

    protected void y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            com.tencent.qav.log.a.b("MultiOperatorImpl", String.format("notifyError errorType=%s", Integer.valueOf(i3)));
            com.tencent.qav.observer.b.f().d(c.class, 2, Integer.valueOf(i3));
        }
    }

    protected void z(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Long.valueOf(j3), str, str2);
            return;
        }
        QLog.d("MultiOperatorImpl", 4, "notifyGetSignResponse ret: " + j3 + " msg: " + str + " sign " + str2);
        com.tencent.qav.observer.b.f().d(c.class, 18, Long.valueOf(j3), str, str2);
    }

    public MultiOperatorImpl(Context context, long j3, d dVar) {
        this(context, j3, dVar, true, -1, -1, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3), dVar);
    }
}

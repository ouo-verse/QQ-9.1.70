package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQavMultiObserverProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.channel.g;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.PushManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String f213732d;

    /* renamed from: a, reason: collision with root package name */
    private IQavMultiObserverProxy f213733a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.a f213734b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.qav.controller.multi.c f213735c;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.qav.channel.g
        public boolean a(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
            }
            if (i3 - 32 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.qav.log.a.a(c.f213732d, String.format("isMultiVideoMsgSupport type=0x%X support=%s", Integer.valueOf(i3), Boolean.valueOf(z16)));
            return z16;
        }

        @Override // com.tencent.qav.channel.g
        public boolean b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.qav.controller.multi.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onAudioEngineReady();
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void d(Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) l3);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onCloseMicBySelf(l3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i(c.f213732d, 1, "onCreateSuc group video");
            if (c.this.f213733a != null) {
                c.this.f213733a.onCreateSuc();
            }
            c.this.f213734b.h();
        }

        @Override // com.tencent.qav.controller.multi.c
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(c.f213732d, 1, "onEnterRoom success!");
            if (c.this.f213733a != null) {
                c.this.f213733a.onEnterRoom();
            }
            c.this.f213734b.h();
        }

        @Override // com.tencent.qav.controller.multi.c
        public void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onError(i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void h(long j3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), str, str2);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onGetSignResponse(j3, str, str2);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void i(boolean z16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onGoOffStageRet(z16, j3, i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void j(boolean z16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onGoOnStageRet(z16, j3, i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void k(boolean z16, long j3, long j16, int i3, long j17, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), Integer.valueOf(i16));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onMemberVideoInOrOut(z16, j3, j16, i3, j17, i16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void l(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onMultiVideoChatMembersInfoChange(j3, strArr, i3, i16, j16, i17, i18);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onOpenMicFail();
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onSelfVolumeUpdate(i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void o(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, i3);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onStartRemoteVideoRequestResult(i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, z16);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onSystemCallStateChanged(z16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void q(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, qavDef$MultiUserInfo, Boolean.valueOf(z16));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserAudioAvailable(d.a(qavDef$MultiUserInfo), z16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                QLog.i(c.f213732d, 1, "onUserEnter userInfo: " + qavDef$MultiUserInfo);
                if (c.this.f213733a != null) {
                    c.this.f213733a.onUserEnter(d.a(qavDef$MultiUserInfo));
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qavDef$MultiUserInfo);
        }

        @Override // com.tencent.qav.controller.multi.c
        public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) qavDef$MultiUserInfo);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserExit(d.a(qavDef$MultiUserInfo));
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void t(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Integer.valueOf(i3));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserFirstVideoFrameIn(j3, i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void u(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, qavDef$MultiUserInfo, Boolean.valueOf(z16));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserSpeaking(d.a(qavDef$MultiUserInfo), z16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void v(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, qavDef$MultiUserInfo, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserSpeaking(d.a(qavDef$MultiUserInfo), z16, i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void w(List<QavDef$MultiUserInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserUpdate(d.b(list));
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void x(long j3, int i3, long j16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16));
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onUserVideoSrcChange(j3, i3, j16, i16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void y(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, z16);
            } else if (c.this.f213733a != null) {
                c.this.f213733a.onVideoChatCallStateChanged(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f213732d = com.tencent.mobileqq.groupvideo.config.a.a() + "GroupVideoQavSdk";
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f213735c = new b();
        }
    }

    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((PushManager) peekAppRuntime.getManager(4)).registProxyMessagePush(AppSetting.f(), MobileQQ.sMobileQQ.getQQProcessName(), "", "MultiVideo.c2sack", "MultiVideo.s2c");
        com.tencent.qav.log.a.f(new com.tencent.qav.log.c());
        com.tencent.qav.channel.c z16 = com.tencent.qav.channel.c.z();
        z16.A(peekAppRuntime);
        z16.y(new a());
        com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.b bVar = new com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.b(MobileQQ.sMobileQQ, j3, z16);
        com.tencent.qav.controller.a aVar = new com.tencent.qav.controller.a(MobileQQ.sMobileQQ, bVar);
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.f(aVar);
        b16.d(MobileQQ.sMobileQQ.getApplicationContext(), j3, z16);
        b16.a(this.f213735c);
        this.f213734b = new com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.a(bVar);
    }

    public void e(IQavMultiObserverProxy iQavMultiObserverProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQavMultiObserverProxy);
        } else {
            this.f213733a = iQavMultiObserverProxy;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.a aVar = this.f213734b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qav.b.b().g();
        com.tencent.qav.b.b().e(this.f213735c);
        ((PushManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(4)).unregistProxyMessagePush(AppSetting.f(), MobileQQ.sMobileQQ.getQQProcessName());
        this.f213734b.i();
    }
}

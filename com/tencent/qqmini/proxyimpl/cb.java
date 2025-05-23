package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;

/* compiled from: P */
@ProxyService(proxy = VoIPProxy.class)
/* loaded from: classes34.dex */
public class cb extends VoIPProxy {

    /* renamed from: a, reason: collision with root package name */
    private VoIPProxy.VoIPListener f347884a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.qav.controller.multi.c f347885b = new b();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b extends com.tencent.qav.controller.multi.c {
        b() {
        }

        @Override // com.tencent.qav.controller.multi.c
        public void f() {
            if (cb.this.f347884a != null) {
                cb.this.f347884a.onEnterRoom();
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void g(int i3) {
            if (cb.this.f347884a != null) {
                cb.this.f347884a.onError(i3);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void q(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            VoIPProxy.MultiUserInfo multiUserInfo;
            if (cb.this.f347884a != null) {
                if (qavDef$MultiUserInfo != null) {
                    multiUserInfo = new VoIPProxy.MultiUserInfo();
                    multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
                    multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
                    multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
                } else {
                    multiUserInfo = null;
                }
                cb.this.f347884a.onUserAudioAvailable(multiUserInfo, z16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            VoIPProxy.MultiUserInfo multiUserInfo;
            if (cb.this.f347884a != null) {
                if (qavDef$MultiUserInfo != null) {
                    multiUserInfo = new VoIPProxy.MultiUserInfo();
                    multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
                    multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
                    multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
                } else {
                    multiUserInfo = null;
                }
                cb.this.f347884a.onUserEnter(multiUserInfo);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            VoIPProxy.MultiUserInfo multiUserInfo;
            if (cb.this.f347884a != null) {
                if (qavDef$MultiUserInfo != null) {
                    multiUserInfo = new VoIPProxy.MultiUserInfo();
                    multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
                    multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
                    multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
                } else {
                    multiUserInfo = null;
                }
                cb.this.f347884a.onUserExit(multiUserInfo);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void u(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            VoIPProxy.MultiUserInfo multiUserInfo;
            if (cb.this.f347884a != null) {
                if (qavDef$MultiUserInfo != null) {
                    multiUserInfo = new VoIPProxy.MultiUserInfo();
                    multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
                    multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
                    multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
                } else {
                    multiUserInfo = null;
                }
                cb.this.f347884a.onUserSpeaking(multiUserInfo, z16);
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void w(List<QavDef$MultiUserInfo> list) {
            ArrayList arrayList;
            if (cb.this.f347884a != null) {
                if (list != null) {
                    arrayList = new ArrayList();
                    for (QavDef$MultiUserInfo qavDef$MultiUserInfo : list) {
                        if (qavDef$MultiUserInfo != null) {
                            VoIPProxy.MultiUserInfo multiUserInfo = new VoIPProxy.MultiUserInfo();
                            multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
                            multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
                            multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
                            arrayList.add(multiUserInfo);
                        }
                    }
                } else {
                    arrayList = null;
                }
                cb.this.f347884a.onUserUpdate(arrayList);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public int enableLocalAudio(boolean z16) {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 == null) {
            return -1;
        }
        c16.enableLocalAudio(z16);
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public int enableRemoteAudio(boolean z16) {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 == null) {
            return -1;
        }
        c16.enableRemoteAudio(!z16);
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public void exitRoom() {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.exitRoom();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public void init(long j3, VoIPProxy.VoIPListener voIPListener) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        ((PushManager) runtime.getManager(4)).registProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName(), "", "MultiVideo.c2sack", "MultiVideo.s2c");
        com.tencent.qav.log.a.f(new com.tencent.qav.log.c());
        com.tencent.qav.channel.c z16 = com.tencent.qav.channel.c.z();
        z16.A(runtime);
        z16.y(new a());
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.d(BaseApplicationImpl.getApplication().getApplicationContext(), j3, z16);
        this.f347884a = voIPListener;
        b16.a(this.f347885b);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public int joinRoom(long j3, long j16, String str, byte[] bArr) {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 == null) {
            return -4;
        }
        com.tencent.qav.a aVar = new com.tencent.qav.a();
        aVar.f342343a = 11;
        aVar.f342344b = 14;
        aVar.f342345c = 1;
        aVar.f342346d = j16;
        aVar.f342347e = j3;
        aVar.f342348f = str;
        aVar.f342349g = 1;
        aVar.f342350h = bArr;
        return c16.e(aVar);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public void setAudioRoute(int i3) {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.setAudioRoute(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public void unInit() {
        b();
        this.f347884a = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
    public void updateRoomInfo() {
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.updateRoomInfo();
        }
    }

    private void b() {
        QLog.i("VoIPProxyImpl", 1, "qavDeInitSDK");
        ((PushManager) BaseApplicationImpl.getApplication().getRuntime().getManager(4)).unregistProxyMessagePush(AppSetting.f(), BaseApplicationImpl.getApplication().getQQProcessName());
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.e(this.f347885b);
        b16.g();
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements com.tencent.qav.channel.g {
        a() {
        }

        @Override // com.tencent.qav.channel.g
        public boolean b(int i3) {
            return false;
        }

        @Override // com.tencent.qav.channel.g
        public boolean a(int i3) {
            boolean z16 = i3 + (-32) == 1;
            com.tencent.qav.log.a.a("VoIPProxyImpl", String.format("isMultiVideoMsgSupport type=0x%X support=%s", Integer.valueOf(i3), Boolean.valueOf(z16)));
            return z16;
        }
    }
}

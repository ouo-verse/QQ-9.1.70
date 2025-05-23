package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.qqlive.sso.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f270862d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ExitRoomCallback f270863e;

        a(int i3, ExitRoomCallback exitRoomCallback) {
            this.f270862d = i3;
            this.f270863e = exitRoomCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) exitRoomCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.f
        public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callLeaveLiveReq receive, type:" + i3 + ", success:" + z16 + ", seq:" + this.f270862d);
            }
            try {
                com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                ExitRoomCallback exitRoomCallback = this.f270863e;
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(0, "");
                }
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, receive handle error, seq:" + this.f270862d, th5);
                ExitRoomCallback exitRoomCallback2 = this.f270863e;
                if (exitRoomCallback2 != null) {
                    exitRoomCallback2.onComplete(-1, th5.getMessage());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends com.tencent.mobileqq.qqlive.sso.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f270864d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ExitRoomCallback f270865e;

        b(int i3, ExitRoomCallback exitRoomCallback) {
            this.f270864d = i3;
            this.f270865e = exitRoomCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) exitRoomCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.f
        public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callShutLiveReq, receive, type:" + i3 + ", success:" + z16 + ", seq:" + this.f270864d);
            }
            try {
                com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                nt3.d c16 = nt3.d.c(hVar.e());
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveAnchor_Exit", 1, "callShutLiveReq, result: " + c16.f421274a + ", " + c16.f421275b + ", seq:" + this.f270864d);
                }
                ExitRoomCallback exitRoomCallback = this.f270865e;
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(0, "");
                }
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callShutLiveReq handle error, seq: " + this.f270864d, th5);
                ExitRoomCallback exitRoomCallback2 = this.f270865e;
                if (exitRoomCallback2 != null) {
                    exitRoomCallback2.onComplete(-1, th5.getMessage());
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.room.helper.c$c, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8353c extends com.tencent.mobileqq.qqlive.sso.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f270866d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ExitRoomCallback f270867e;

        C8353c(int i3, ExitRoomCallback exitRoomCallback) {
            this.f270866d = i3;
            this.f270867e = exitRoomCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) exitRoomCallback);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sso.f
        public void onReceive(int i3, boolean z16, com.tencent.mobileqq.qqlive.sso.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callEndNewReq, type:" + i3 + ", success:" + z16 + ", seq:" + this.f270866d);
            }
            pt3.b bVar = null;
            try {
                com.tencent.mobileqq.qqlive.anchor.util.a.a(i3, z16, hVar);
                bVar = pt3.b.c(hVar.e());
                if (QLog.isColorLevel()) {
                    QLog.d("QQLiveAnchor_Exit", 1, "callEndNewReq, result: " + bVar.f427119a + ", seq:" + this.f270866d);
                }
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callEndNewReq handle error, seq:" + this.f270866d, th5);
            }
            if (bVar == null) {
                ExitRoomCallback exitRoomCallback = this.f270867e;
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(5108, "response is null");
                    return;
                }
                return;
            }
            ExitRoomCallback exitRoomCallback2 = this.f270867e;
            if (exitRoomCallback2 != null) {
                exitRoomCallback2.onComplete(bVar.f427119a, "");
            }
        }
    }

    public static void a(IQQLiveSDK iQQLiveSDK, String str, pt3.a aVar, ExitRoomCallback exitRoomCallback) {
        boolean z16;
        if (iQQLiveSDK != null && aVar != null && exitRoomCallback != null) {
            int hashCode = aVar.hashCode();
            com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) iQQLiveSDK.getExtModule("sso_module");
            if (cVar == null) {
                QLog.e("QQLiveAnchor_Exit", 1, "callEndNewReq, ssoModule is null, seq:" + hashCode);
                exitRoomCallback.onComplete(-1, "ssoModule is null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callEndNewReq, start, seq:" + hashCode);
            }
            try {
                cVar.f("trpc.qlive.media_logic4opensdk.MediaLogic", "EndNew", MessageNano.toByteArray(aVar), new C8353c(hashCode, exitRoomCallback));
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callEndNewReq error, seq:" + hashCode, th5);
                exitRoomCallback.onComplete(-1, th5.getMessage());
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("callEndNewReq, params is null, liveSDK's null=");
        boolean z17 = false;
        if (iQQLiveSDK == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", callback's null=");
        if (exitRoomCallback == null) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.e("QQLiveAnchor_Exit", 1, sb5.toString());
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(-1, "params null");
        }
    }

    public static void b(IQQLiveSDK iQQLiveSDK, String str, jt3.a aVar, ExitRoomCallback exitRoomCallback) {
        boolean z16;
        if (iQQLiveSDK != null && aVar != null) {
            int hashCode = aVar.hashCode();
            com.tencent.mobileqq.qqlive.sso.c cVar = (com.tencent.mobileqq.qqlive.sso.c) iQQLiveSDK.getExtModule("sso_module");
            if (cVar == null) {
                QLog.e("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, ssoModule is null, seq:" + hashCode);
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(-1, "ssoModule is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, start, seq:" + hashCode);
            }
            try {
                cVar.f("trpc.qlive.ilive_room_broadcast_svr.RoomBroadcast", "LeaveLiveRoom", MessageNano.toByteArray(aVar), new a(hashCode, exitRoomCallback));
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callLeaveLiveReq, error, seq:" + hashCode, th5);
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(-1, th5.getMessage());
                    return;
                }
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("callLeaveLiveReq, params is null, liveSdk's null=");
        if (iQQLiveSDK == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.e("QQLiveAnchor_Exit", 1, sb5.toString());
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(-1, "liveSDK is null");
        }
    }

    public static void c(IQQLiveSDK iQQLiveSDK, String str, nt3.c cVar, ExitRoomCallback exitRoomCallback) {
        boolean z16;
        if (iQQLiveSDK != null && cVar != null) {
            int hashCode = cVar.hashCode();
            com.tencent.mobileqq.qqlive.sso.c cVar2 = (com.tencent.mobileqq.qqlive.sso.c) iQQLiveSDK.getExtModule("sso_module");
            if (cVar2 == null) {
                QLog.e("QQLiveAnchor_Exit", 1, "callShutLiveReq, ssoModule is null, seq:" + hashCode);
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(-1, "ssoModule is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_Exit", 1, "callShutLiveReq, start, seq:" + hashCode);
            }
            try {
                cVar2.f("trpc.qlive.ilive_room_play.RoomPlay", "ShutLive", MessageNano.toByteArray(cVar), new b(hashCode, exitRoomCallback));
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_Exit", 1, "callShutLiveReq, error, seq:" + hashCode, th5);
                if (exitRoomCallback != null) {
                    exitRoomCallback.onComplete(-1, th5.getMessage());
                    return;
                }
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("callShutLiveReq, param is null, liveSDK's null=");
        if (iQQLiveSDK == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.e("QQLiveAnchor_Exit", 1, sb5.toString());
        if (exitRoomCallback != null) {
            exitRoomCallback.onComplete(-1, "liveSdk is null");
        }
    }
}

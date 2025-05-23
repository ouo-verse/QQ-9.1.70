package com.tencent.mobileqq.qqlive.anchor.room;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPush;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.common.QQLiveEventMsg;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ak implements IQQLiveAnchorRoomThirdPushCallback, IQQLiveAnchorRoomCallbackRegister {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected CopyOnWriteArrayList<IQQLiveAnchorRoomCallback> f270810d;

    /* renamed from: e, reason: collision with root package name */
    protected CopyOnWriteArrayList<IQQLiveAnchorRoomThirdPush> f270811e;

    public ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270810d = new CopyOnWriteArrayList<>();
            this.f270811e = new CopyOnWriteArrayList<>();
        }
    }

    private boolean I() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(AnchorLiveSystemInfo anchorLiveSystemInfo) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onAnchorLiveNetStatus(anchorLiveSystemInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onCheckPermission(qQLiveAnchorDataCheckPermission);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onEnter(qQLiveAnchorDataEnter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onEnterRoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(QQLiveErrorMsg qQLiveErrorMsg) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onError(qQLiveErrorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(QQLiveEventMsg qQLiveEventMsg) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onEvent(qQLiveEventMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(QQLiveAnchorDataAuth qQLiveAnchorDataAuth) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onFaceAuth(qQLiveAnchorDataAuth);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onFastResumeResult(qQLiveAnchorDataFastResume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
        Iterator<IQQLiveAnchorRoomThirdPush> it = this.f270811e.iterator();
        while (it.hasNext()) {
            it.next().onGetPullInfo(qQLiveAnchorDataPullInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
        Iterator<IQQLiveAnchorRoomThirdPush> it = this.f270811e.iterator();
        while (it.hasNext()) {
            it.next().onGetPushInfo(qQLiveAnchorDataPushInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(QQLiveAnchorDataInit qQLiveAnchorDataInit) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onInit(qQLiveAnchorDataInit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(QQLiveAnchorDataBase qQLiveAnchorDataBase) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onLiveError(qQLiveAnchorDataBase);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onLiveStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onPrepare(qQLiveAnchorDataPrepare);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onPublishStream(qQLiveAnchorDataPublishStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserEnterRoom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(String str, int i3) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserLeaveRoom(str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(int i3, String str) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureError(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i3) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onScreenCapturePause(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(QQLiveAnchorDataSet qQLiveAnchorDataSet) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onSet(qQLiveAnchorDataSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartCheckPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartEnter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartFaceAuth();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartFastResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            IQQLiveAnchorRoomCallback next = it.next();
            if (next instanceof IQQLiveAnchorRoomThirdPushCallback) {
                ((IQQLiveAnchorRoomThirdPushCallback) next).onStartGetPullInfo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0() {
        Iterator<IQQLiveAnchorRoomThirdPush> it = this.f270811e.iterator();
        while (it.hasNext()) {
            it.next().onStartGetPushInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartPrepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartPublishStream();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStartSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(QQLiveAnchorRoomState qQLiveAnchorRoomState, QQLiveAnchorRoomState qQLiveAnchorRoomState2) {
        Iterator<IQQLiveAnchorRoomCallback> it = this.f270810d.iterator();
        while (it.hasNext()) {
            it.next().onStateChange(qQLiveAnchorRoomState, qQLiveAnchorRoomState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
        Iterator<IQQLiveAnchorRoomThirdPush> it = this.f270811e.iterator();
        while (it.hasNext()) {
            it.next().onThirdPushChecked(qQLiveAnchorDataThirdPushCheck);
        }
    }

    private void r0(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (I()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
    public void onAnchorLiveNetStatus(final AnchorLiveSystemInfo anchorLiveSystemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) anchorLiveSystemInfo);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.c
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.J(anchorLiveSystemInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCheckPermission
    public void onCheckPermission(final QQLiveAnchorDataCheckPermission qQLiveAnchorDataCheckPermission) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) qQLiveAnchorDataCheckPermission);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.K(qQLiveAnchorDataCheckPermission);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
    public void onEnter(final QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataEnter);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.f
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.L(qQLiveAnchorDataEnter);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
    public void onEnterRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.t
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.M();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onError(final QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) qQLiveErrorMsg);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.af
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.N(qQLiveErrorMsg);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onEvent(final QQLiveEventMsg qQLiveEventMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qQLiveEventMsg);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.O(qQLiveEventMsg);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomExit
    public void onExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.y
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.P();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onFaceAuth(final QQLiveAnchorDataAuth qQLiveAnchorDataAuth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQLiveAnchorDataAuth);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.aj
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.Q(qQLiveAnchorDataAuth);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomFastResume
    public void onFastResumeResult(final QQLiveAnchorDataFastResume qQLiveAnchorDataFastResume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) qQLiveAnchorDataFastResume);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.p
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.R(qQLiveAnchorDataFastResume);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
    public void onGetPullInfo(final QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) qQLiveAnchorDataPullInfo);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.w
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.S(qQLiveAnchorDataPullInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
    public void onGetPushInfo(final QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) qQLiveAnchorDataPushInfo);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.n
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.T(qQLiveAnchorDataPushInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
    public void onInit(final QQLiveAnchorDataInit qQLiveAnchorDataInit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) qQLiveAnchorDataInit);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.U(qQLiveAnchorDataInit);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomLive
    public void onLiveError(final QQLiveAnchorDataBase qQLiveAnchorDataBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) qQLiveAnchorDataBase);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.o
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.V(qQLiveAnchorDataBase);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomLive
    public void onLiveStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.k
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.W();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onPrepare(final QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQLiveAnchorDataPrepare);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.x
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.X(qQLiveAnchorDataPrepare);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
    public void onPublishStream(final QQLiveAnchorDataPublishStream qQLiveAnchorDataPublishStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQLiveAnchorDataPublishStream);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.e
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.Y(qQLiveAnchorDataPublishStream);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
    public void onRemoteUserEnterRoom(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.Z(str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomRemote
    public void onRemoteUserLeaveRoom(final String str, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, i3);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.d
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.a0(str, i3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
    public void onScreenCaptureError(final int i3, final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3, (Object) str);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.h
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.b0(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
    public void onScreenCapturePause(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.z
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.c0(i3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream
    public void onScreenCaptureStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.d0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
    public void onSet(final QQLiveAnchorDataSet qQLiveAnchorDataSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQLiveAnchorDataSet);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ai
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.e0(qQLiveAnchorDataSet);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCheckPermission
    public void onStartCheckPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.f0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomEnter
    public void onStartEnter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.j
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.g0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onStartFaceAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.h0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomFastResume
    public void onStartFastResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.i
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.i0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
    public void onStartGetPullInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.s
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.j0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPushUrl
    public void onStartGetPushInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.l
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.k0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomInit
    public void onStartInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.g
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.l0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
    public void onStartPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.q
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.m0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPublish
    public void onStartPublishStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.v
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.n0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomSet
    public void onStartSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.u
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.o0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
    public void onStateChange(final QQLiveAnchorRoomState qQLiveAnchorRoomState, final QQLiveAnchorRoomState qQLiveAnchorRoomState2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qQLiveAnchorRoomState, (Object) qQLiveAnchorRoomState2);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.r
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.p0(qQLiveAnchorRoomState, qQLiveAnchorRoomState2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
    public void onThirdPushChecked(final QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) qQLiveAnchorDataThirdPushCheck);
        } else {
            r0(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.m
                @Override // java.lang.Runnable
                public final void run() {
                    ak.this.q0(qQLiveAnchorDataThirdPushCheck);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void registerAnchorCallback(IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iQQLiveAnchorRoomCallback);
        } else if (!this.f270810d.contains(iQQLiveAnchorRoomCallback)) {
            this.f270810d.add(iQQLiveAnchorRoomCallback);
            if (iQQLiveAnchorRoomCallback instanceof IQQLiveAnchorRoomThirdPush) {
                this.f270811e.add((IQQLiveAnchorRoomThirdPush) iQQLiveAnchorRoomCallback);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void unRegisterAllAnchorCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.f270810d.clear();
            this.f270811e.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister
    public void unRegisterAnchorCallback(IQQLiveAnchorRoomCallback iQQLiveAnchorRoomCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) iQQLiveAnchorRoomCallback);
            return;
        }
        this.f270810d.remove(iQQLiveAnchorRoomCallback);
        if (iQQLiveAnchorRoomCallback instanceof IQQLiveAnchorRoomThirdPush) {
            this.f270811e.remove((IQQLiveAnchorRoomThirdPush) iQQLiveAnchorRoomCallback);
        }
    }
}

package com.tencent.mobileqq.qqlive.trtc.room.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.engine.b;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCEngineApiImpl implements ITRTCEngineApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TRTCEngineApiImpl";
    private ITRTCRoomListener roomListener;
    private final List<ITRTCRoomListener> roomListenerList;
    private b trtcEngine;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements ITRTCRoomListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TRTCEngineApiImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onEnterRoom(j3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onEvent(i3, i16, str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onExitRoom(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onExitRoom(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalAudioFrameSent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onFirstLocalAudioFrameSent();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalVideoFrameSent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onFirstLocalVideoFrameSent(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserEnterRoom(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onRemoteUserEnterRoom(str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onRemoteUserLeaveRoom(str, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onSwitchRoom(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            Iterator it = TRTCEngineApiImpl.this.roomListenerList.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onSwitchRoom(i3, str);
            }
        }
    }

    public TRTCEngineApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.roomListenerList = new CopyOnWriteArrayList();
        }
    }

    private void createRoomListener() {
        this.roomListener = new a();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void addRoomListener(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iTRTCRoomListener);
            return;
        }
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
            return;
        }
        if (iTRTCRoomListener == null) {
            QLog.e(TAG, 1, "addRoomListener,listener can't be null\uff0cif you want to clear room listener,use clearRoomListener instead");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.room.a m3 = this.trtcEngine.m();
        if (m3 == null) {
            QLog.w(TAG, 1, "roomCtrl null !");
            return;
        }
        if (this.roomListener == null) {
            QLog.i(TAG, 1, "set init RoomListener");
            createRoomListener();
            m3.b(this.roomListener);
        }
        if (!this.roomListenerList.contains(iTRTCRoomListener)) {
            this.roomListenerList.add(iTRTCRoomListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void clearRoomListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.room.a m3 = this.trtcEngine.m();
        if (m3 == null) {
            return;
        }
        this.roomListenerList.clear();
        m3.b(null);
        this.roomListener = null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void destroyEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
        } else {
            this.trtcEngine.a();
            this.trtcEngine = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b audioSource = getAudioSource(true);
        if (audioSource != null) {
            audioSource.enableAudioVolumeEvaluation(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void enterRoom(String str, long j3, int i3, int i16, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str2, str3);
        } else if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
        } else {
            this.trtcEngine.m().enterRoom(new QQLiveRoomParams.Builder().setRoomId(j3).setUserId(str).setRoleType(i16).setUserSig(str2).setScene(i3).setStreamId(str3).build());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void exitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
        } else {
            this.trtcEngine.m().exitRoom();
        }
    }

    public com.tencent.mobileqq.qqlive.trtc.audio.b getAudioSource(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.mobileqq.qqlive.trtc.audio.b) iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b bVar = null;
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
            return null;
        }
        try {
            bVar = (com.tencent.mobileqq.qqlive.trtc.audio.b) this.trtcEngine.i(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.toString());
        }
        if (bVar == null) {
            if (z16) {
                com.tencent.mobileqq.qqlive.trtc.audio.b bVar2 = (com.tencent.mobileqq.qqlive.trtc.audio.b) this.trtcEngine.k(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
                this.trtcEngine.c(bVar2);
                return bVar2;
            }
            QLog.e(TAG, 1, "failed to get audio source! isNeedCreate is false!");
            return bVar;
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void initEngine(Context context, String str, TRTCInitCallback tRTCInitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, tRTCInitCallback);
            return;
        }
        if (isEngineReady()) {
            QLog.e(TAG, 1, "already init engine!");
            if (tRTCInitCallback != null) {
                tRTCInitCallback.onInitEvent(2, 0);
                return;
            }
            return;
        }
        if (this.trtcEngine == null) {
            this.trtcEngine = new b();
        }
        this.trtcEngine.initEngine(context, str, tRTCInitCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public boolean isEngineReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        b bVar = this.trtcEngine;
        if (bVar != null && bVar.getEngineState() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void muteAllRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "muteAllRemoteAudio, trtcEngine null or not ready !");
            return;
        }
        b bVar = this.trtcEngine;
        if (bVar != null) {
            bVar.muteAllRemoteAudio(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void removeRoomListener(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iTRTCRoomListener);
        } else {
            this.roomListenerList.remove(iTRTCRoomListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void setTRTCRemoteListener(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iTRTCRemoteListener);
            return;
        }
        b bVar = this.trtcEngine;
        if (bVar != null) {
            bVar.f(iTRTCRemoteListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void stopAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b audioSource = getAudioSource(false);
        if (audioSource != null) {
            audioSource.d();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCEngineApi
    public void enterRoom(QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQLiveRoomParams);
        } else if (!isEngineReady()) {
            QLog.e(TAG, 1, "trtcEngine null or not ready !");
        } else {
            this.trtcEngine.m().enterRoom(qQLiveRoomParams);
        }
    }
}

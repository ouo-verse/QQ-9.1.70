package com.tencent.mobileqq.qqlive.trtc.room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements com.tencent.mobileqq.qqlive.trtc.room.a, com.tencent.mobileqq.qqlive.trtc.ipc.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ITRTCRoomListener f273374a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class a implements ITRTCRoomListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private Bundle a(int i3, int i16, String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("Key_TRTC_EventID", i3);
            bundle2.putInt("Key_TRTC_ErrCode", i16);
            if (!TextUtils.isEmpty(str)) {
                bundle2.putString("Key_TRTC_ErrMsg", str);
            }
            if (bundle != null) {
                bundle2.putBundle("Key_TRTC_Extra", bundle);
            }
            return bundle2;
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onEnterRoom " + j3 + ", msg: " + str);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onEnterRoom", a(0, (int) j3, str, null));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onEvent, event " + i3 + ", code: " + i16 + ", msg: " + str);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onEvent", a(i3, i16, str, bundle));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onExitRoom(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onExitRoom " + i3);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onExitRoom", a(0, i3, "", null));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalAudioFrameSent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onFirstLocalAudioFrameSent ");
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onFirstLocalAudioFrameSent", null);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalVideoFrameSent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onFirstLocalVideoFrameSent, streamType " + i3);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onFirstLocalVideoFrameSent", a(0, i3, "message", null));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserEnterRoom(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onRemoteUserEnterRoom " + str);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onRemoteUserEnterRoom", a(0, 0, str, null));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onRemoteUserLeaveRoom " + str + ", reason: " + i3);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onRemoteUserLeaveRoom", a(0, i3, str, null));
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onSwitchRoom(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TRTCFakeRoomCtrl", 2, "onSwitchRoom " + i3 + ", msg: " + str);
            }
            TRTCClientIPCModule.d("Action_Server_Room_Callback_onSwitchRoom", a(0, i3, str, null));
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            TRTCServerIPCModule.h().l(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void a(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveRoomParams);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("Key_trtc_room_params", qQLiveRoomParams);
        TRTCServerIPCModule.g("Action_Client_Room_Switch_Room", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void b(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iTRTCRoomListener);
        } else {
            this.f273374a = iTRTCRoomListener;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TRTCServerIPCModule.g("Action_Client_Room_Destroy_Room", null, null);
        this.f273374a = null;
        TRTCServerIPCModule.h().o(this);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void enterRoom(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveRoomParams);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("Key_trtc_room_params", qQLiveRoomParams);
        TRTCServerIPCModule.g("Action_Client_Room_Enter_Room", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void exitRoom() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            TRTCServerIPCModule.g("Action_Client_Room_Exit_Room", null, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean h(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (bundle != null) {
            bundle.setClassLoader(QQLiveRoomParams.class.getClassLoader());
        }
        QQLiveRoomParams qQLiveRoomParams = null;
        if ("Action_Client_Room_Enter_Room".equals(str)) {
            if (bundle != null) {
                qQLiveRoomParams = (QQLiveRoomParams) bundle.getParcelable("Key_trtc_room_params");
            }
            if (qQLiveRoomParams != null) {
                com.tencent.mobileqq.qqlive.trtc.b.r().b(new a());
                com.tencent.mobileqq.qqlive.trtc.b.r().l(qQLiveRoomParams);
            }
        } else if ("Action_Client_Room_Exit_Room".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.b.r().m();
        } else if ("Action_Client_Room_Switch_Room".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.room.a s16 = com.tencent.mobileqq.qqlive.trtc.b.r().s();
            if (s16 != null) {
                if (bundle != null) {
                    qQLiveRoomParams = (QQLiveRoomParams) bundle.getParcelable("Key_trtc_room_params");
                }
                s16.a(qQLiveRoomParams);
            }
        } else if ("Action_Client_Room_Destroy_Room".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.room.a s17 = com.tencent.mobileqq.qqlive.trtc.b.r().s();
            if (s17 != null) {
                s17.destroy();
            }
        } else {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean k(String str, Bundle bundle) {
        Bundle bundle2;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (this.f273374a == null) {
            return false;
        }
        String str2 = "";
        if (bundle != null) {
            i3 = bundle.getInt("Key_TRTC_ErrCode", 0);
            i16 = bundle.getInt("Key_TRTC_EventID", 0);
            str2 = bundle.getString("Key_TRTC_ErrMsg", "");
            bundle2 = bundle.getBundle("Key_TRTC_Extra");
        } else {
            bundle2 = null;
            i3 = 0;
            i16 = 0;
        }
        if ("Action_Server_Room_Callback_onEnterRoom".equals(str)) {
            this.f273374a.onEnterRoom(i3, str2);
        } else if ("Action_Server_Room_Callback_onExitRoom".equals(str)) {
            this.f273374a.onExitRoom(i3);
        } else if ("Action_Server_Room_Callback_onSwitchRoom".equals(str)) {
            this.f273374a.onSwitchRoom(i3, str2);
        } else if ("Action_Server_Room_Callback_onRemoteUserEnterRoom".equals(str)) {
            this.f273374a.onRemoteUserEnterRoom(str2);
        } else if ("Action_Server_Room_Callback_onRemoteUserLeaveRoom".equals(str)) {
            this.f273374a.onRemoteUserLeaveRoom(str2, i3);
        } else if ("Action_Server_Room_Callback_onFirstLocalVideoFrameSent".equals(str)) {
            this.f273374a.onFirstLocalVideoFrameSent(i3);
        } else if ("Action_Server_Room_Callback_onFirstLocalAudioFrameSent".equals(str)) {
            this.f273374a.onFirstLocalAudioFrameSent();
        } else {
            if (!"Action_Server_Room_Callback_onEvent".equals(str)) {
                return false;
            }
            this.f273374a.onEvent(i16, i3, str2, bundle2);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) qQLiveRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void stopAllRemoteVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void stopRemoteVideo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
    }
}

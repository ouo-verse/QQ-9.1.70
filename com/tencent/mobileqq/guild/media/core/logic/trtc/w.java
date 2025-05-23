package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Surface;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class w extends QIPCModule {

    /* renamed from: f, reason: collision with root package name */
    private static final w f228600f = new w("TRTCAudioRoomClientQIPCModule");

    /* renamed from: d, reason: collision with root package name */
    private final TRTCAudioRoomLocalNew f228601d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f228602e;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements EIPCOnGetConnectionListener {
        a() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            if ("com.tencent.mobileqq".equals(eIPCConnection.procName)) {
                QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "onConnectBind.");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            if ("com.tencent.mobileqq".equals(eIPCConnection.procName)) {
                QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "onConnectUnbind.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements EIPClientConnectListener {
        b() {
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "connectFailed.");
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "connectSuccess.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements ITRTCAudioRoom.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f228605a;

        c(int i3) {
            this.f228605a = i3;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public void onCallback(int i3, String str) {
            QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handlePrepareRoom onCallback.");
            Bundle bundle = new Bundle();
            bundle.putInt("PREPARE_ROOM_CODE", i3);
            w.this.callbackResult(this.f228605a, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements ITRTCAudioRoom.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f228607a;

        d(int i3) {
            this.f228607a = i3;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public void onCallback(int i3, String str) {
            w.this.callbackResult(this.f228607a, EIPCResult.createResult(i3, null));
        }
    }

    public w(String str) {
        super(str);
        TRTCAudioRoomLocalNew T = TRTCAudioRoomLocalNew.T();
        this.f228601d = T;
        this.f228602e = false;
        T.F(new com.tencent.mobileqq.guild.media.core.logic.trtc.a());
    }

    public static w b() {
        return f228600f;
    }

    private void c(Bundle bundle, int i3) {
        QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handleEnableAudioRecord");
        this.f228601d.i(bundle.getBoolean("AUDIO_IS_OPEN"));
    }

    private void d(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleEnterRoom: appScene:" + bundle.getInt("ROOM_TYPE") + ", sdkAppId:" + bundle.getInt("SDK_APP_ID") + ", privateMapKey:" + bundle.getString("PRIVATE_MAP_KEY") + ", roomId:" + bundle.getString("ROOM_ID") + ", userId:" + bundle.getString(CommonConstant.RETKEY.USERID) + ", userSig" + bundle.getString("USER_SIG") + ", userRole" + bundle.getInt("USER_ROLE"));
    }

    private void e(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleExitRoom: ");
        this.f228601d.I(new d(i3));
    }

    private void f(Bundle bundle, int i3) {
        this.f228601d.muteRemoteAudio(bundle.getString(CommonConstant.RETKEY.USERID), bundle.getBoolean("USER_REMOTE_MUTE"));
    }

    private EIPCResult g(Bundle bundle, int i3) {
        QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handlePing.");
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private EIPCResult h(Bundle bundle, int i3) {
        QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handlePrepareRoom.");
        this.f228601d.r(BaseApplication.getContext(), bundle.getString("TRTC_SO_PATH"), new c(i3));
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private void i(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleRouteAudioToEarpiece: ");
        this.f228601d.B();
    }

    private void j(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleRouteAudioToSpeaker: ");
        this.f228601d.d();
    }

    private void k(Bundle bundle, int i3) {
        this.f228601d.b(bundle.getInt("AUDIO_MODE", 2));
    }

    private void l(Bundle bundle, int i3) {
        this.f228601d.X((Intent) bundle.getParcelable("CREATE_SCREEN_CAPTURE_INTENT"));
    }

    private void m(Bundle bundle, int i3) {
        this.f228601d.setRemoteAudioVolume(bundle.getString(CommonConstant.RETKEY.USERID), bundle.getInt("USER_VOLUME", 100));
    }

    private void n(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleStartMicrophone: ");
        this.f228601d.K();
    }

    private void o(Bundle bundle, int i3) {
        QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handleStartScreenShare");
        this.f228601d.A();
    }

    private void p(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "handleStopMicrophone: ");
        this.f228601d.a();
    }

    private void q(Bundle bundle, int i3) {
        QLog.d("QGMC.TRTCAudioRoomClientQIPCModule", 4, "handleStopScreenShare");
        this.f228601d.o();
    }

    private void r(Bundle bundle, int i3) {
        this.f228601d.Y();
    }

    private void s(Bundle bundle, int i3) {
        this.f228601d.Z();
    }

    private void t(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 4, "startShowVideo");
        this.f228601d.w(bundle.getString("TINY_ID"), (Surface) bundle.getParcelable("RENDER_SURFACE"));
    }

    private void u(Bundle bundle, int i3) {
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 4, "stopShowVideo" + bundle);
        this.f228601d.e(bundle.getString("TINY_ID"));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if ("PING".equals(str)) {
            return g(bundle, i3);
        }
        if ("PREPARE_ROOM".equals(str)) {
            return h(bundle, i3);
        }
        if ("ENTER_ROOM".equals(str)) {
            d(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("EXIT_ROOM".equals(str)) {
            e(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("START_MICROPHONE".equals(str)) {
            n(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("STOP_MICROPHONE".equals(str)) {
            p(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("ROUTE_AUDIO_TO_SPEAKER".equals(str)) {
            j(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("ROUTE_AUDIO_TO_EARPIECE".equals(str)) {
            i(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("MUTE_REMOTE_AUDIO".equals(str)) {
            f(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("SWITCH_TO_ANCHOR".equals(str)) {
            r(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("SWITCH_TO_AUDIENCE".equals(str)) {
            s(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("SET_AUDIO_MODE".equals(str)) {
            k(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("SET_REMOTE_VOLUME".equals(str)) {
            m(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("START_SCREEN_SHARE".equals(str)) {
            o(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("STOP_SCREEN_SHARE".equals(str)) {
            q(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("ENABLE_AUDIO_RECORD".equals(str)) {
            c(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("START_SHOW_VIDEO".equals(str)) {
            t(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("STOP_SHOW_VIDEO".equals(str)) {
            u(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        if ("HANDLE_FOREGROUND_SERVICE".equals(str)) {
            return EIPCResult.createSuccessResult(null);
        }
        if ("SET_CAPTURE_INTENT".equals(str)) {
            l(bundle, i3);
            return EIPCResult.createSuccessResult(null);
        }
        return EIPCResult.UNKNOW_RESULT;
    }

    public void register() {
        if (this.f228602e || !Constants.Process.QQ_GUILD_AV_PROCESS.equals(MobileQQ.processName)) {
            return;
        }
        QLog.i("QGMC.TRTCAudioRoomClientQIPCModule", 1, "register.");
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(new a());
        QIPCClientHelper.getInstance().getClient().connect(new b());
        this.f228602e = true;
    }
}

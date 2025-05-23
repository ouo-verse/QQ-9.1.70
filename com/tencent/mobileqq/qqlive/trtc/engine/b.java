package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCAuxiliaryEffect;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveMixUserConfig;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.i;
import com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl;
import com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource;
import com.tencent.mobileqq.qqlive.utils.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements com.tencent.mobileqq.qqlive.trtc.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TRTCCloud f273291a;

    /* renamed from: b, reason: collision with root package name */
    private e f273292b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f273293c;

    /* renamed from: d, reason: collision with root package name */
    private c f273294d;

    /* renamed from: e, reason: collision with root package name */
    private int f273295e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.video.source.a f273296f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.audio.a f273297g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.render.a f273298h;

    /* renamed from: i, reason: collision with root package name */
    private TRTCRoomCtrl f273299i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a f273300j;

    /* renamed from: k, reason: collision with root package name */
    private IRTCMusicAccompany f273301k;

    /* renamed from: l, reason: collision with root package name */
    private Looper f273302l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f273303m;

    /* renamed from: n, reason: collision with root package name */
    private IAegisLogApi f273304n;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements TRTCCloudListener.TRTCVideoFrameListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public void onGLContextCreated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.e("QQLiveTRTCEngine", 1, "setVideoPreProcess, onGLContextCreated");
            if (b.this.f273300j != null) {
                b.this.f273300j.onGLContextCreated();
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public void onGLContextDestory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.e("QQLiveTRTCEngine", 1, "setVideoPreProcess, onGLContextDestroy");
            if (b.this.f273300j != null) {
                b.this.f273300j.b();
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) tRTCVideoFrame, (Object) tRTCVideoFrame2)).intValue();
            }
            if (b.this.f273300j != null) {
                return b.this.f273300j.a(new com.tencent.mobileqq.qqlive.trtc.video.videoprocess.b(tRTCVideoFrame), new com.tencent.mobileqq.qqlive.trtc.video.videoprocess.b(tRTCVideoFrame2));
            }
            return 0;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273292b = new e();
        this.f273295e = 0;
        this.f273304n = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    private TRTCCloudDef.TRTCMixUser p(QQLiveMixUserConfig qQLiveMixUserConfig) {
        TRTCCloudDef.TRTCMixUser tRTCMixUser = new TRTCCloudDef.TRTCMixUser();
        tRTCMixUser.userId = qQLiveMixUserConfig.userId;
        tRTCMixUser.roomId = qQLiveMixUserConfig.roomId;
        tRTCMixUser.f381674x = qQLiveMixUserConfig.f271216x;
        tRTCMixUser.f381675y = qQLiveMixUserConfig.f271217y;
        tRTCMixUser.width = qQLiveMixUserConfig.width;
        tRTCMixUser.height = qQLiveMixUserConfig.height;
        tRTCMixUser.zOrder = qQLiveMixUserConfig.zOrder;
        tRTCMixUser.streamType = qQLiveMixUserConfig.streamType;
        tRTCMixUser.pureAudio = qQLiveMixUserConfig.pureAudio;
        tRTCMixUser.inputType = qQLiveMixUserConfig.inputType;
        return tRTCMixUser;
    }

    private TRTCCloudDef.TRTCTranscodingConfig q(QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        tRTCTranscodingConfig.appId = qQLiveTranscodingConfig.appId;
        tRTCTranscodingConfig.bizId = qQLiveTranscodingConfig.bizId;
        tRTCTranscodingConfig.mode = qQLiveTranscodingConfig.mode;
        tRTCTranscodingConfig.videoWidth = qQLiveTranscodingConfig.videoWidth;
        tRTCTranscodingConfig.videoHeight = qQLiveTranscodingConfig.videoHeight;
        tRTCTranscodingConfig.videoBitrate = qQLiveTranscodingConfig.videoBitRate;
        tRTCTranscodingConfig.videoFramerate = qQLiveTranscodingConfig.videoFrameRate;
        tRTCTranscodingConfig.videoGOP = qQLiveTranscodingConfig.videoGOP;
        tRTCTranscodingConfig.backgroundColor = qQLiveTranscodingConfig.backgroundColor;
        tRTCTranscodingConfig.backgroundImage = qQLiveTranscodingConfig.backgroundImage;
        tRTCTranscodingConfig.audioSampleRate = qQLiveTranscodingConfig.audioSampleRate;
        tRTCTranscodingConfig.audioBitrate = qQLiveTranscodingConfig.audioBitRate;
        tRTCTranscodingConfig.audioChannels = qQLiveTranscodingConfig.audioChannels;
        tRTCTranscodingConfig.streamId = qQLiveTranscodingConfig.streamId;
        ArrayList<QQLiveMixUserConfig> arrayList = qQLiveTranscodingConfig.mixUsers;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<TRTCCloudDef.TRTCMixUser> arrayList2 = new ArrayList<>();
            Iterator<QQLiveMixUserConfig> it = qQLiveTranscodingConfig.mixUsers.iterator();
            while (it.hasNext()) {
                arrayList2.add(p(it.next()));
            }
            tRTCTranscodingConfig.mixUsers = arrayList2;
        }
        return tRTCTranscodingConfig;
    }

    private void s(IRTCAuxiliaryEffect iRTCAuxiliaryEffect) {
        if (iRTCAuxiliaryEffect != null && (iRTCAuxiliaryEffect instanceof ui2.b)) {
            ui2.b bVar = (ui2.b) iRTCAuxiliaryEffect;
            bVar.b(this.f273294d);
            bVar.a(this.f273303m);
        }
    }

    private boolean t() {
        if (this.f273295e == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Context context, String str, TRTCInitCallback tRTCInitCallback, boolean z16, String str2, String str3) {
        int i3;
        QLog.i("QQLiveTRTCEngine", 1, "initEngine onLoadResult isSuccess:" + z16);
        if (z16) {
            QLog.d("QQLiveTRTCEngine", 4, "onLoadResult succeeded");
            QLog.i("QQLiveTRTCEngine", 1, "setLibraryPath: " + str3);
            QLog.i("QQLiveTRTCEngine", 1, "setLibraryPath file list: " + Arrays.toString(new File(str3).list()));
            TXLiveBase.setLibraryPath(str3);
            v(context, str);
            i3 = 0;
        } else {
            x(3);
            QLog.i("QQLiveTRTCEngine", 1, "SoLoadManager.onLoadResult TRTC failed! ");
            i3 = -1;
        }
        if (tRTCInitCallback != null) {
            tRTCInitCallback.onInitEvent(getEngineState(), i3);
        }
    }

    private int v(Context context, String str) {
        if (context == null) {
            this.f273295e = 3;
            QLog.e("QQLiveTRTCEngine", 1, "initEngine: context is null!");
            return QQLiveError.RTC_ERR_INVALID_ARGUMENT;
        }
        if (t()) {
            QLog.i("QQLiveTRTCEngine", 1, "Engine already init success!");
            return 0;
        }
        this.f273293c = new WeakReference<>(context.getApplicationContext());
        Looper looper = this.f273302l;
        if (looper != null && looper.getThread().isAlive()) {
            this.f273303m = new Handler(this.f273302l);
        } else {
            this.f273303m = new Handler(Looper.getMainLooper());
        }
        p.a();
        this.f273291a = TRTCCloud.sharedInstance(context);
        c cVar = new c();
        this.f273294d = cVar;
        cVar.f273308c = str;
        cVar.f273307b = this.f273293c;
        cVar.f273306a = this.f273291a;
        this.f273298h = new TRTCRenderCtrl(cVar);
        TRTCRoomCtrl tRTCRoomCtrl = new TRTCRoomCtrl(this.f273294d);
        this.f273299i = tRTCRoomCtrl;
        tRTCRoomCtrl.d(this.f273303m);
        this.f273292b.N(this.f273299i);
        this.f273291a.setListener(this.f273292b);
        this.f273295e = 2;
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveTRTCEngine", 2, "initEngine successful!");
        }
        return 0;
    }

    private void z() {
        if (!((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).isHevcEncodeEnable()) {
            QLog.i("QQLiveTRTCEngine", 1, "[enableHevcEncode] hevc disabled");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DTConstants.TAG.API, V2TXLiveProperty.kV2EnableHevcEncode);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", 1);
            jSONObject.put("params", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            QLog.i("QQLiveTRTCEngine", 1, "[enableHevcEncode] json=" + jSONObject3);
            this.f273291a.callExperimentalAPI(jSONObject3);
        } catch (JSONException e16) {
            QLog.e("QQLiveTRTCEngine", 1, "[enableHevcEncode] failed ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            r();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public com.tencent.mobileqq.qqlive.trtc.render.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.qqlive.trtc.render.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f273298h;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void c(@Nullable com.tencent.mobileqq.qqlive.trtc.audio.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQLiveTRTCEngine", 2, "setAudioSource: " + aVar);
        }
        com.tencent.mobileqq.qqlive.trtc.audio.a aVar2 = this.f273297g;
        if (aVar == aVar2) {
            QLog.w("QQLiveTRTCEngine", 1, "setAudioSource: ignore. set the same audio source.");
            return;
        }
        if (aVar2 != null) {
            aVar2.destroy();
        }
        this.f273297g = aVar;
        if (aVar != null) {
            aVar.c(this.f273294d);
            this.f273297g.a(this.f273303m);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void closeMixTranscoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud != null) {
            tRTCCloud.setMixTranscodingConfig(null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void connectRemote(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.f273291a == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roomId", j3);
            jSONObject.put("userId", String.valueOf(j16));
            this.f273291a.ConnectOtherRoom(jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("QQLiveTRTCEngine", 1, "connectRemote json error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        QLog.i("QQLiveTRTCEngine", 1, "[createMusicAccompany]");
        IRTCMusicAccompany iRTCMusicAccompany = this.f273301k;
        if (iRTCMusicAccompany != null) {
            return iRTCMusicAccompany;
        }
        i iVar = new i();
        this.f273301k = iVar;
        iVar.c();
        s(this.f273301k);
        return this.f273301k;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f273294d;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.DisconnectOtherRoom();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void e(String str, TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, (Object) tXCloudVideoView);
        } else {
            this.f273291a.startRemoteView(str, 0, tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void enableCustomVideoCapture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            if (this.f273291a == null) {
                return;
            }
            z();
            this.f273291a.enableCustomVideoCapture(0, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void f(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iTRTCRemoteListener);
            return;
        }
        e eVar = this.f273292b;
        if (eVar != null) {
            eVar.M(iTRTCRemoteListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T g(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cls);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQLiveTRTCEngine", 2, "create TRTC video source, class name:" + cls.getSimpleName());
        }
        if (cls.equals(com.tencent.mobileqq.qqlive.trtc.video.source.camera.a.class)) {
            return new com.tencent.mobileqq.qqlive.trtc.video.source.camera.b();
        }
        if (cls.equals(com.tencent.mobileqq.qqlive.trtc.video.source.screen.c.class)) {
            return new TRTCScreenCaptureSource();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public int getAudioPlayOutVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return 0;
        }
        return tRTCCloud.getAudioPlayoutVolume();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public int getEngineState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f273295e;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void h(com.tencent.mobileqq.qqlive.trtc.video.source.screen.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) dVar);
            return;
        }
        e eVar = this.f273292b;
        if (eVar != null && dVar != null) {
            eVar.P(dVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T i(@NonNull Class<T> cls) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls);
        }
        if (t()) {
            if (cls.isInstance(this.f273297g)) {
                return (T) this.f273297g;
            }
            throw new IllegalArgumentException("no audio source of the specified type");
        }
        throw new IllegalStateException("getCurrentAudioSource: not init.");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void initEngine(@NonNull final Context context, @NonNull final String str, final TRTCInitCallback tRTCInitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, tRTCInitCallback);
            return;
        }
        if (t()) {
            if (d().f273308c.equals(str)) {
                QLog.d("QQLiveTRTCEngine", 1, "already init appId " + str);
                if (tRTCInitCallback != null) {
                    tRTCInitCallback.onInitEvent(getEngineState(), 0);
                    return;
                }
                return;
            }
            QLog.w("QQLiveTRTCEngine", 1, "init different appId!");
            r();
        }
        y(Looper.getMainLooper());
        x(1);
        QLog.i("QQLiveTRTCEngine", 1, "initEngine doing!");
        SoLoad.load("QQ\u76f4\u64ad", SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.mobileqq.qqlive.trtc.engine.a
            @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
            public final void onLoad(boolean z16, String str2, String str3) {
                b.this.u(context, str, tRTCInitCallback, z16, str2, str3);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    @Nullable
    public <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T j(@NonNull Class<T> cls) throws IllegalStateException, IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        if (t()) {
            if (this.f273296f == null) {
                QLog.w("QQLiveTRTCEngine", 1, "getCurrentVideoSource: video source not set.");
            }
            if (!cls.isInstance(this.f273296f)) {
                QLog.w("QQLiveTRTCEngine", 1, "getCurrentVideoSource: cls type different. " + cls.toString());
                return null;
            }
            return (T) this.f273296f;
        }
        throw new IllegalStateException("getCurrentVideoSource: not init.");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    @Nullable
    public <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T k(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
        }
        QLog.i("QQLiveTRTCEngine", 2, "create TRTC audio source, class name:" + cls.getSimpleName());
        if (cls.equals(com.tencent.mobileqq.qqlive.trtc.audio.b.class)) {
            QLog.i("QQLiveTRTCEngine", 2, "create audio source.");
            return new com.tencent.mobileqq.qqlive.trtc.audio.c();
        }
        QLog.e("QQLiveTRTCEngine", 1, "not support effect type.");
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.source.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQLiveTRTCEngine", 2, "setVideoSource: " + aVar);
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar2 = this.f273296f;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.destroy();
        }
        this.f273296f = aVar;
        if (aVar != null) {
            aVar.c(this.f273294d);
            this.f273296f.a(this.f273303m);
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar3 = this.f273296f;
        if (aVar3 instanceof com.tencent.mobileqq.qqlive.trtc.video.source.screen.c) {
            com.tencent.mobileqq.qqlive.trtc.video.source.screen.b bVar = (com.tencent.mobileqq.qqlive.trtc.video.source.screen.b) aVar3;
            e eVar = this.f273292b;
            if (eVar != null) {
                eVar.O(bVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public com.tencent.mobileqq.qqlive.trtc.room.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.qqlive.trtc.room.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f273299i;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void muteAllRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.muteAllRemoteAudio(z16);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void muteRemoteAudio(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Boolean.valueOf(z16));
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.muteRemoteAudio(str, z16);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void openMixTranscoding(@NonNull QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) qQLiveTranscodingConfig);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud != null && qQLiveTranscodingConfig != null) {
            tRTCCloud.setMixTranscodingConfig(q(qQLiveTranscodingConfig));
        }
    }

    public synchronized void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        QLog.i("QQLiveTRTCEngine", 1, "now destroy TRTC Engine!");
        TRTCRoomCtrl tRTCRoomCtrl = this.f273299i;
        if (tRTCRoomCtrl != null) {
            tRTCRoomCtrl.destroy();
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar = this.f273296f;
        if (aVar != null) {
            aVar.destroy();
        }
        com.tencent.mobileqq.qqlive.trtc.audio.a aVar2 = this.f273297g;
        if (aVar2 != null) {
            aVar2.destroy();
        }
        com.tencent.mobileqq.qqlive.trtc.render.a aVar3 = this.f273298h;
        if (aVar3 != null) {
            aVar3.destroy();
        }
        if (this.f273300j != null) {
            this.f273300j.b();
            this.f273300j = null;
        }
        IRTCMusicAccompany iRTCMusicAccompany = this.f273301k;
        if (iRTCMusicAccompany != null) {
            ((ui2.b) iRTCMusicAccompany).c();
            this.f273301k = null;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud != null) {
            tRTCCloud.setListener(null);
            this.f273292b = null;
            this.f273291a = null;
            TRTCCloud.destroySharedInstance();
        }
        this.f273294d = null;
        this.f273295e = 0;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setAudioPlayOutVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.setAudioPlayoutVolume(i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setNetworkQosPreferenceParam(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) aVar);
            return;
        }
        if (this.f273291a == null) {
            QLog.e("QQLiveTRTCEngine", 2, "setNetworkQosPreferenceParam trtcCloud is null!");
            return;
        }
        if (aVar == null) {
            QLog.e("QQLiveTRTCEngine", 2, "setNetworkQosPreferenceParam trtcCloud is null!");
            return;
        }
        TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
        tRTCNetworkQosParam.preference = aVar.a();
        this.f273291a.setNetworkQosParam(tRTCNetworkQosParam);
        QLog.e("QQLiveTRTCEngine", 2, "setNetworkQosPreferenceParam change! new QosPrefence:" + aVar.a());
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setRemoteAudioVolume(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, i3);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.setRemoteAudioVolume(str, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setVideoPreProcess(com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (aVar == null) {
            QLog.e("QQLiveTRTCEngine", 1, "setVideoPreProcess null");
            if (tRTCCloud != null) {
                tRTCCloud.setLocalVideoProcessListener(2, 3, null);
                return;
            }
            return;
        }
        if (this.f273300j == aVar) {
            QLog.e("QQLiveTRTCEngine", 1, "setVideoPreProcess already set!");
            return;
        }
        this.f273300j = aVar;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.setLocalVideoProcessListener(2, 3, new a());
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void stopRemoteView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.f273291a.stopRemoteView(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void switchRole(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.f273291a.switchRole(com.tencent.mobileqq.qqlive.trtc.utils.a.b(i3));
        }
    }

    public void w(TRTCCloudListener tRTCCloudListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) tRTCCloudListener);
            return;
        }
        TRTCCloud tRTCCloud = this.f273291a;
        if (tRTCCloud != null) {
            this.f273292b = null;
            tRTCCloud.setListener(tRTCCloudListener);
        }
    }

    public synchronized void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f273295e = i3;
        }
    }

    public boolean y(Looper looper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) looper)).booleanValue();
        }
        if (this.f273295e != 0) {
            return false;
        }
        this.f273302l = looper;
        return true;
    }
}

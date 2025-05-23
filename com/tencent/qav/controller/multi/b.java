package com.tencent.qav.controller.multi;

import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.util.QavABTestHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.nt.qav.reporter.QavReporter;
import com.tencent.qav.channel.d;
import com.tencent.qav.channel.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b implements com.tencent.av.gaudio.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Context f342379a;

    /* renamed from: b, reason: collision with root package name */
    protected long f342380b;

    /* renamed from: c, reason: collision with root package name */
    protected QQGAudioCtrl f342381c;

    /* renamed from: d, reason: collision with root package name */
    protected d f342382d;

    /* renamed from: e, reason: collision with root package name */
    protected e f342383e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements QavABTestHelper.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.avcore.util.QavABTestHelper.a
        public QavABTestHelper.b a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QavABTestHelper.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            QavABTestHelper.b bVar = new QavABTestHelper.b();
            try {
                bVar.f77542a = Long.parseLong(yt.b.c(str));
            } catch (NumberFormatException unused) {
                bVar.f77542a = 0L;
            }
            bVar.f77543b = str;
            bVar.f77544c = yt.b.b(str);
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qav.controller.multi.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9292b implements QavReporter.a {
        static IPatchRedirector $redirector_;

        C9292b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.nt.qav.reporter.QavReporter.a
        public void a(String str, String str2, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, hashMap);
            } else {
                QQBeaconReport.reportWithAppKey(str, "", str2, true, hashMap, true);
            }
        }
    }

    public b(Context context, long j3, d dVar, boolean z16, int i3, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), dVar, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        this.f342379a = context;
        this.f342380b = j3;
        this.f342382d = dVar;
        this.f342383e = new e(context, dVar);
        n(z16, i3, i16, z17);
    }

    private void n(boolean z16, int i3, int i16, boolean z17) {
        com.tencent.qav.log.a.a("MultiOperatorBase", "initGAudioCtrl enableAINS:" + z16);
        try {
            if (this.f342381c == null) {
                QQGAudioCtrl gAudioCtrlInstance = QQGAudioCtrl.getGAudioCtrlInstance();
                this.f342381c = gAudioCtrlInstance;
                if (gAudioCtrlInstance != null) {
                    int b16 = com.tencent.qav.controller.a.b();
                    this.f342381c.setCallback(this);
                    this.f342381c.setNetChannel(this.f342383e);
                    this.f342381c.setAppId(AppSetting.f());
                    this.f342381c.init(this.f342379a, this.f342380b, -1, z16, i3, i16, z17);
                    this.f342381c.setApType(b16);
                    ClientLogReport.instance().init(this.f342379a, AppSetting.f());
                    GAClientLogReport.instance();
                    QavABTestHelper.getInstance().setABTest(new a());
                    QQBeaconReport.start();
                    QavReporter.getInstance().setReport(new C9292b());
                } else {
                    com.tencent.qav.log.a.b("MultiOperatorBase", "initGAudioCtrl create instance fail.");
                }
            }
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("MultiOperatorBase", "initGAudioCtrl  fail.", e16);
            this.f342381c = null;
        }
    }

    private void o() {
        com.tencent.qav.log.a.a("MultiOperatorBase", "unInitGAudioCtrl");
        try {
            QQGAudioCtrl qQGAudioCtrl = this.f342381c;
            if (qQGAudioCtrl != null) {
                qQGAudioCtrl.setCallback(null);
                this.f342381c.uninit();
                this.f342381c = null;
            }
        } catch (Exception e16) {
            com.tencent.qav.log.a.c("MultiOperatorBase", "unInitGAudioCtrl  fail.", e16);
        }
    }

    @Override // com.tencent.av.gaudio.b
    public long a(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.av.gaudio.b
    public boolean d(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
    }

    @Override // com.tencent.av.gaudio.b
    public void g(long j3, long j16, ArrayList<com.tencent.av.gaudio.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Long.valueOf(j3), Long.valueOf(j16), arrayList);
        }
    }

    @Override // com.tencent.av.gaudio.b
    public void h(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.av.gaudio.b
    public void i(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Long.valueOf(j3), Long.valueOf(j16), str);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f342379a = null;
        this.f342380b = 0L;
        this.f342382d = null;
        o();
    }

    public QQGAudioCtrl m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQGAudioCtrl) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f342381c;
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCameraSettingNotify(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onChangeAuthority(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onChangeRole(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCheckScreenShareAvailable(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) bArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onDetectAudioDataIssue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onDoubleVideoMeetingInvite(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onFpsChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioInvite(int i3, long j3, String str, String[] strArr, boolean z16, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Long.valueOf(j3), str, strArr, Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioInviteResp(MavInviteData mavInviteData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) mavInviteData);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioKickOut(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemAllUpdate(long j3, ArrayList<AVUserInfo> arrayList, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            return;
        }
        iPatchRedirector.redirect((short) 40, this, Long.valueOf(j3), arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMicSetByAdmin(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioRoomDestroy(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioRoomMicModeChanged(long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioSetMicFailed(int i3, ArrayList<AVUserInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) arrayList);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioTerminalEnterRoom(int i3, long j3, int... iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Long.valueOf(j3), iArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioUserAudioSuspectNoisy(long j3, boolean z16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Boolean.valueOf(z16), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGVideoDownloadChannelCtlChanged(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) bArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOffStageResult(int i3, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOnStageResult(int i3, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaSwitchVideoResult(int i3, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGeneralRawChannelData(long j3, int i3, int i16, long j16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), bArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupChatModeChange(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupSecurityLimit(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Long.valueOf(j16), str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onHowling() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onInitAIDenoiseStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onKickOutFail(long j3, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onKickOutSuc(long j3, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onOpenMicFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onPPTInOrOut(long j3, long j16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRecSharePushEncParam(int i3, long j3, RecordParam recordParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Integer.valueOf(i3), Long.valueOf(j3), recordParam);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRemoteVideoDataComeIn(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onSetMicBySelf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onShareOpsCallback(int i3, int i16, int i17, long j3, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18), Integer.valueOf(i19));
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onVideoSrcChange(int i3, int i16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void setEncodeDecodePtr(long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QLog.w("MultiOperatorBase", 1, "setEncodeDecodePtr, sessionType[2], clean[" + z16 + "], isRemote[" + z17 + "], isMultiEngine[true], seq[" + j3 + "]");
        if (this.f342381c != null) {
            NtrtcVideoRender.getInstance().setEngineFlag(true);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemAllUpdate(long j3, String[] strArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            return;
        }
        iPatchRedirector.redirect((short) 41, this, Long.valueOf(j3), strArr, Integer.valueOf(i3), Integer.valueOf(i16));
    }
}

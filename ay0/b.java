package ay0;

import android.os.Bundle;
import ay0.a;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends TRTCCloudListener {

    /* renamed from: a, reason: collision with root package name */
    private final ay0.a f27207a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f27209b;

        a(String str, boolean z16) {
            this.f27208a = str;
            this.f27209b = z16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserSubStreamAvailable(this.f27208a, this.f27209b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class aa implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27211a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27212b;

        aa(int i3, int i16) {
            this.f27211a = i3;
            this.f27212b = i16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onAudioEffectFinished(this.f27211a, this.f27212b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ab implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27214a;

        ab(int i3) {
            this.f27214a = i3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onExitRoom(this.f27214a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ac implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27216a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27217b;

        ac(int i3, String str) {
            this.f27216a = i3;
            this.f27217b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSwitchRole(this.f27216a, this.f27217b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ad implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27219a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27220b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27221c;

        ad(String str, int i3, String str2) {
            this.f27219a = str;
            this.f27220b = i3;
            this.f27221c = str2;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectOtherRoom(this.f27219a, this.f27220b, this.f27221c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ae implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27224b;

        ae(int i3, String str) {
            this.f27223a = i3;
            this.f27224b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onDisConnectOtherRoom(this.f27223a, this.f27224b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class af implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27226a;

        af(String str) {
            this.f27226a = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRemoteUserEnterRoom(this.f27226a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ag implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27229b;

        ag(String str, int i3) {
            this.f27228a = str;
            this.f27229b = i3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRemoteUserLeaveRoom(this.f27228a, this.f27229b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class ah implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27231a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f27232b;

        ah(String str, boolean z16) {
            this.f27231a = str;
            this.f27232b = z16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserVideoAvailable(this.f27231a, this.f27232b);
        }
    }

    /* compiled from: P */
    /* renamed from: ay0.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0077b implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27234a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f27235b;

        C0077b(String str, boolean z16) {
            this.f27234a = str;
            this.f27235b = z16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserAudioAvailable(this.f27234a, this.f27235b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27237a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27238b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f27239c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f27240d;

        c(String str, int i3, int i16, int i17) {
            this.f27237a = str;
            this.f27238b = i3;
            this.f27239c = i16;
            this.f27240d = i17;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onFirstVideoFrame(this.f27237a, this.f27238b, this.f27239c, this.f27240d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class d implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27242a;

        d(String str) {
            this.f27242a = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onFirstAudioFrame(this.f27242a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class e implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27244a;

        e(int i3) {
            this.f27244a = i3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSendFirstLocalVideoFrame(this.f27244a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class f implements a.InterfaceC0076a {
        f() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSendFirstLocalAudioFrame();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class g implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27247a;

        g(String str) {
            this.f27247a = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserEnter(this.f27247a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class h implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27249a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27250b;

        h(String str, int i3) {
            this.f27249a = str;
            this.f27250b = i3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserExit(this.f27249a, this.f27250b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class i implements a.InterfaceC0076a {
        i() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectionLost();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class j implements a.InterfaceC0076a {
        j() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onTryToReconnect();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class k implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27254a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27255b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f27256c;

        k(int i3, String str, Bundle bundle) {
            this.f27254a = i3;
            this.f27255b = str;
            this.f27256c = bundle;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onError(this.f27254a, this.f27255b, this.f27256c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class l implements a.InterfaceC0076a {
        l() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onConnectionRecovery();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class m implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TRTCCloudDef.TRTCSpeedTestResult f27259a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27260b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f27261c;

        m(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i3, int i16) {
            this.f27259a = tRTCSpeedTestResult;
            this.f27260b = i3;
            this.f27261c = i16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSpeedTest(this.f27259a, this.f27260b, this.f27261c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class n implements a.InterfaceC0076a {
        n() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onCameraDidReady();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class o implements a.InterfaceC0076a {
        o() {
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onMicDidReady();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class p implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27265a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27266b;

        p(int i3, int i16) {
            this.f27265a = i3;
            this.f27266b = i16;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onAudioRouteChanged(this.f27265a, this.f27266b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class q implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f27268a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27269b;

        q(ArrayList arrayList, int i3) {
            this.f27268a = arrayList;
            this.f27269b = i3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onUserVoiceVolume(this.f27268a, this.f27269b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class r implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27271a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27272b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f27273c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f27274d;

        r(String str, int i3, int i16, byte[] bArr) {
            this.f27271a = str;
            this.f27272b = i3;
            this.f27273c = i16;
            this.f27274d = bArr;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRecvCustomCmdMsg(this.f27271a, this.f27272b, this.f27273c, this.f27274d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class s implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27276a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27277b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f27278c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f27279d;

        s(String str, int i3, int i16, int i17) {
            this.f27276a = str;
            this.f27277b = i3;
            this.f27278c = i16;
            this.f27279d = i17;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onMissCustomCmdMsg(this.f27276a, this.f27277b, this.f27278c, this.f27279d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class t implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f27282b;

        t(String str, byte[] bArr) {
            this.f27281a = str;
            this.f27282b = bArr;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onRecvSEIMsg(this.f27281a, this.f27282b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class u implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27284a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27285b;

        u(int i3, String str) {
            this.f27284a = i3;
            this.f27285b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStartPublishing(this.f27284a, this.f27285b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class v implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f27287a;

        v(long j3) {
            this.f27287a = j3;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onEnterRoom(this.f27287a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class w implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27290b;

        w(int i3, String str) {
            this.f27289a = i3;
            this.f27290b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStopPublishing(this.f27289a, this.f27290b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class x implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27293b;

        x(int i3, String str) {
            this.f27292a = i3;
            this.f27293b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStartPublishCDNStream(this.f27292a, this.f27293b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class y implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27296b;

        y(int i3, String str) {
            this.f27295a = i3;
            this.f27296b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onStopPublishCDNStream(this.f27295a, this.f27296b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class z implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27299b;

        z(int i3, String str) {
            this.f27298a = i3;
            this.f27299b = str;
        }

        @Override // ay0.a.InterfaceC0076a
        public void a(TRTCCloudListener tRTCCloudListener) {
            tRTCCloudListener.onSetMixTranscodingConfig(this.f27298a, this.f27299b);
        }
    }

    public b(ay0.a aVar) {
        this.f27207a = aVar;
    }

    private void L(String str, Object... objArr) {
        ay0.c.a(str, objArr);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioEffectFinished(int i3, int i16) {
        L("onAudioEffectFinished", Integer.valueOf(i3), Integer.valueOf(i16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new aa(i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onAudioRouteChanged(int i3, int i16) {
        L("onAudioRouteChanged", Integer.valueOf(i3), Integer.valueOf(i16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new p(i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onCameraDidReady() {
        L("onCameraDidReady", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new n());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(String str, int i3, String str2) {
        L("onConnectOtherRoom", str, Integer.valueOf(i3), str2);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ad(str, i3, str2));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        L("onConnectionLost", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new i());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        L("onConnectionRecovery", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new l());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onDisConnectOtherRoom(int i3, String str) {
        L("onDisConnectOtherRoom", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ae(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        L("onEnterRoom", "\u8017\u65f6:" + j3 + "ms");
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new v(j3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i3, String str, Bundle bundle) {
        L("onError", Integer.valueOf(i3), str, bundle);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new k(i3, str, bundle));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        L("onExitRoom", Integer.valueOf(i3));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ab(i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstAudioFrame(String str) {
        L("onFirstAudioFrame", str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new d(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        L("onFirstVideoFrame", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new c(str, i3, i16, i17));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMicDidReady() {
        L("onMicDidReady", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new o());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onMissCustomCmdMsg(String str, int i3, int i16, int i17) {
        L("onMissCustomCmdMsg", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new s(str, i3, i16, i17));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvCustomCmdMsg(String str, int i3, int i16, byte[] bArr) {
        L("onRecvCustomCmdMsg", Integer.valueOf(i3), Integer.valueOf(i16), bArr);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new r(str, i3, i16, bArr));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        L("onRecvSEIMsg", bArr);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new t(str, bArr));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(String str) {
        L("onRemoteUserEnterRoom", str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new af(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        L("onRemoteUserLeaveRoom", str, Integer.valueOf(i3));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ag(str, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalAudioFrame() {
        L("onSendFirstLocalAudioFrame", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new f());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSendFirstLocalVideoFrame(int i3) {
        L("onSendFirstLocalVideoFrame", Integer.valueOf(i3));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new e(i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSetMixTranscodingConfig(int i3, String str) {
        L("onSetMixTranscodingConfig", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new z(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i3, int i16) {
        L("onSpeedTest", tRTCSpeedTestResult, Integer.valueOf(i3), Integer.valueOf(i16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new m(tRTCSpeedTestResult, i3, i16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishCDNStream(int i3, String str) {
        L("onStartPublishCDNStream", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new x(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStartPublishing(int i3, String str) {
        L("onStartPublishing", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new u(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishCDNStream(int i3, String str) {
        L("onStopPublishCDNStream", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new y(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStopPublishing(int i3, String str) {
        L("onStopPublishing", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new w(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSwitchRole(int i3, String str) {
        L("onSwitchRole", Integer.valueOf(i3), str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ac(i3, str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        L("onTryToReconnect", new Object[0]);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new j());
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z16) {
        L("onUserAudioAvailable", str, Boolean.valueOf(z16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new C0077b(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserEnter(String str) {
        L("onUserEnter", str);
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new g(str));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserExit(String str, int i3) {
        L("onUserExit", str, Integer.valueOf(i3));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new h(str, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserSubStreamAvailable(String str, boolean z16) {
        L("onUserSubStreamAvailable", str, Boolean.valueOf(z16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new a(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(String str, boolean z16) {
        L("onUserVideoAvailable", str, Boolean.valueOf(z16));
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new ah(str, z16));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i3) {
        ay0.a aVar = this.f27207a;
        if (aVar != null) {
            aVar.L(new q(arrayList, i3));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i3, String str, Bundle bundle) {
    }
}

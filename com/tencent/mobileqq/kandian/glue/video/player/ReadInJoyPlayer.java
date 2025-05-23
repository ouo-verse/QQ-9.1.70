package com.tencent.mobileqq.kandian.glue.video.player;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.g;
import com.tencent.mobileqq.kandian.base.video.player.LitePlayer;
import com.tencent.mobileqq.kandian.base.video.player.f;
import com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import r52.b;
import r52.c;

/* loaded from: classes33.dex */
public class ReadInJoyPlayer extends LitePlayer implements f62.a, ReadinjoyPlayerReporter.e, f {
    private final String I;
    public ReadinjoyPlayerReporter J;
    private String K;
    private String L;
    private int M;
    private int N;
    private TextView O;

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ReadInJoyPlayer this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.t0();
        }
    }

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer$3, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ReadInJoyPlayer this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.O != null) {
                this.this$0.O.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f240049a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f240050b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f240051c;

        a(String str, long j3, int i3) {
            this.f240049a = str;
            this.f240050b = j3;
            this.f240051c = i3;
        }
    }

    public ReadInJoyPlayer(int i3) {
        this(i3, null, false, false);
    }

    private boolean l0(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(this.K);
        boolean isEmpty2 = TextUtils.isEmpty(this.L);
        return (!isEmpty || !isEmpty2) && (isEmpty || this.K.equals(str)) && (isEmpty2 || this.L.equals(str2));
    }

    private boolean m0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(".m3u8") || lowerCase.contains(".m3u8?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(c cVar, String str, long j3, int i3) {
        if (cVar.f430755b.equals(str) && l0(str, "")) {
            if (cVar.f430763j == 2) {
                L(202, 108, 0, "vid2url failed, video deleted");
                return;
            }
            if (TextUtils.isEmpty(cVar.f430754a)) {
                L(202, 107, 0, "vid2url failed, get null");
                return;
            }
            if (m0(cVar.f430754a) && u0()) {
                QLog.d(this.I, 1, "hls video fix video type: " + cVar.f430754a);
                cVar.f430771l = 1;
            }
            int i16 = cVar.f430771l == 1 ? 102 : 101;
            String str2 = cVar.f430754a;
            this.L = str2;
            d0(cVar.f430755b, str2, cVar.f430760g, cVar.f430757d, i16, j3, i3);
            this.f239110u.H = cVar.f430756c ? 1 : 0;
            this.J.k(cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.I, 2, "vid2url\u6362\u56de\u6765\u540e\uff0c\u5f53\u524d\u89c6\u9891\u5df2\u7ecf\u4e0d\u518d\u64ad\u653e\uff0cvid:" + cVar.f430755b + " url:" + cVar.f430754a);
        }
    }

    private void q0(String str, long j3, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b0(str, 101, j3, i3);
    }

    private boolean u0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SHARE_HLS_VIDEO_TYPE_FIX, true);
    }

    @Override // f62.a
    public void f(f62.b bVar) {
        this.J.p(bVar);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.LitePlayer, f62.a
    public void i(f fVar) {
        super.i(fVar);
    }

    @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.e
    public void l(q52.b bVar) {
        bVar.f428388c = this.M;
        bVar.E = getVideoWidth();
        bVar.F = getVideoHeight();
    }

    public void o0(int i3, String str, String str2, long j3, int i16, String str3) {
        this.K = str;
        this.L = str2;
        this.M = i3;
        this.N = i16;
        if (QLog.isColorLevel()) {
            QLog.d(this.I, 2, "openByBusiType: vid=" + str + ", url=" + str2 + ", busiType=" + i3);
        }
        this.f239112w = false;
        K(this.J);
        i(this);
        if (com.tencent.mobileqq.kandian.base.video.player.a.a(i3)) {
            r0(str, j3);
            return;
        }
        if (i3 == 2 || (i3 == 6 && !TextUtils.isEmpty(str))) {
            s0(str, j3, i16, str3);
        } else if (i3 == 5) {
            this.f239112w = true;
            n0(str, j3, i16);
        } else {
            q0(str2, j3, i16);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onProgressChanged(long j3) {
        g.a(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                ReadInJoyPlayer.this.t0();
            }
        });
    }

    public ReadInJoyPlayer(int i3, String str, boolean z16, boolean z17) {
        super(BaseApplication.getContext(), str, z16, z17);
        this.I = "ReadInjoyPlayer<" + Integer.toHexString(hashCode()) + ">";
        this.J = new ReadinjoyPlayerReporter(i3, this);
    }

    private void s0(String str, long j3, int i3, String str2) {
        if (str == null) {
            return;
        }
        b.a().f(str, str2, new a(str, j3, i3));
    }

    private void r0(String str, long j3) {
        if (str == null) {
            return;
        }
        e0(str, 1, j3);
    }

    @Override // f62.a
    public void k(int i3, String str, String str2, long j3, int i16) {
        o0(i3, str, str2, j3, i16, null);
    }

    private void n0(String str, long j3, int i3) {
        if (str == null) {
            return;
        }
        c0(str, str, 101, j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void beforeVideoStart() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onBufferEnd() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onBufferStart() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onCompletion() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onFirstFrameRendered() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoOpen() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoPause() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoPrepared() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoRestart() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoStart() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoStop() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoEnd(int i3) {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoError(int i3, int i16, String str) {
    }
}

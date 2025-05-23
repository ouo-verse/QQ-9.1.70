package kt3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kt3.b;
import pw2.n;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i implements b {

    /* renamed from: a, reason: collision with root package name */
    private final b f412987a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f412988b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f412989c = false;

    /* renamed from: d, reason: collision with root package name */
    private List<QAdVideoItem> f412990d;

    /* renamed from: e, reason: collision with root package name */
    private b.InterfaceC10678b f412991e;

    /* renamed from: f, reason: collision with root package name */
    private final b.InterfaceC10678b f412992f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements b.InterfaceC10678b {
        a() {
        }

        @Override // kt3.b.InterfaceC10678b
        public void onEvent(int i3, int i16, int i17, Object obj) {
            n.e("QAdMediaPlayerWrapper", "onEvent: what=" + i3);
            i.this.j(i3);
            b.InterfaceC10678b interfaceC10678b = i.this.f412991e;
            if (interfaceC10678b != null) {
                interfaceC10678b.onEvent(i3, i16, i17, obj);
            }
        }
    }

    public i(@NonNull b bVar) {
        a aVar = new a();
        this.f412992f = aVar;
        this.f412987a = bVar;
        bVar.g(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3) {
        if (i3 == 0 || i3 == 3) {
            n.e("QAdMediaPlayerWrapper", "onEvent: \u64ad\u653e\u5668\u7ed3\u675f\uff0c\u91cd\u7f6eisPausing\u548cisPlaying\u72b6\u6001");
            this.f412989c = false;
            this.f412988b = false;
        }
        if (i3 == 1) {
            n.e("QAdMediaPlayerWrapper", "onEvent: \u64ad\u653e\u5668\u5c31\u7eea");
            k();
        }
    }

    private void k() {
        boolean z16;
        List<QAdVideoItem> list = this.f412990d;
        if (list == null) {
            return;
        }
        Iterator<QAdVideoItem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().e()) {
                    z16 = false;
                    break;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            this.f412992f.onEvent(4, 0, 0, "QAdMediaPlayerWrapper");
        }
    }

    @Override // kt3.b
    public void a(IQAdPlayerView iQAdPlayerView) {
        this.f412987a.a(iQAdPlayerView);
    }

    @Override // kt3.b
    public void b() {
        n.e("QAdMediaPlayerWrapper", "seekToNextVideo");
        try {
            this.f412987a.b();
        } catch (IllegalStateException e16) {
            n.b("QAdMediaPlayerWrapper", "seekToNextVideo exception=" + e16.getMessage());
        }
    }

    @Override // kt3.b
    public void c(long j3) {
        try {
            this.f412987a.c(j3);
        } catch (IllegalStateException e16) {
            n.b("QAdMediaPlayerWrapper", "seekToAccuratePos e" + e16.getMessage());
        }
    }

    @Override // kt3.b
    public void d(List<QAdVideoItem> list, long j3) {
        String str;
        n.e("QAdMediaPlayerWrapper", "openPlayer");
        this.f412990d = list;
        try {
            this.f412987a.d(list, j3);
            str = "";
        } catch (IOException e16) {
            str = "openPlayer IOException e" + e16.getMessage();
        } catch (IllegalArgumentException e17) {
            str = "openPlayer IllegalArgumentException e" + e17.getMessage();
        } catch (IllegalStateException e18) {
            str = "openPlayer IllegalStateException e" + e18.getMessage();
        }
        if (!TextUtils.isEmpty(str)) {
            n.b("QAdMediaPlayerWrapper", str);
            this.f412992f.onEvent(3, 0, 0, str);
        }
    }

    @Override // kt3.b
    public void e(QAdUserInfo qAdUserInfo) {
        this.f412987a.e(qAdUserInfo);
    }

    @Override // kt3.b
    public long f() {
        return this.f412987a.f();
    }

    @Override // kt3.b
    public void g(b.InterfaceC10678b interfaceC10678b) {
        n.e("QAdMediaPlayerWrapper", "setQAdMediaPlayerCallback");
        this.f412991e = interfaceC10678b;
    }

    @Override // kt3.b
    public long getCurrentPositionMs() {
        return this.f412987a.getCurrentPositionMs();
    }

    @Override // kt3.b
    public boolean isPlaying() {
        return this.f412988b;
    }

    @Override // kt3.b
    public void pause() throws IllegalStateException {
        n.e("QAdMediaPlayerWrapper", "pause");
        try {
            this.f412987a.pause();
            this.f412988b = false;
            this.f412989c = true;
        } catch (IllegalStateException e16) {
            n.b("QAdMediaPlayerWrapper", "pause e=" + e16.getMessage());
        }
    }

    @Override // kt3.b
    public void release() {
        n.e("QAdMediaPlayerWrapper", "release");
        this.f412987a.release();
    }

    @Override // kt3.b
    public void setAudioGainRatio(float f16) {
        this.f412987a.setAudioGainRatio(f16);
    }

    @Override // kt3.b
    public boolean setLoopPlay(boolean z16) {
        return this.f412987a.setLoopPlay(z16);
    }

    @Override // kt3.b
    public boolean setOutputMute(boolean z16) {
        return this.f412987a.setOutputMute(z16);
    }

    @Override // kt3.b
    public void start() throws IllegalStateException {
        n.e("QAdMediaPlayerWrapper", "start");
        try {
            this.f412987a.start();
            this.f412988b = true;
            this.f412989c = false;
        } catch (IllegalStateException e16) {
            n.b("QAdMediaPlayerWrapper", "start e=" + e16.getMessage());
            this.f412992f.onEvent(3, 0, 0, "QAdMediaPlayerWrapperstart");
        }
    }

    @Override // kt3.b
    public void stop() throws IllegalStateException {
        n.e("QAdMediaPlayerWrapper", "stop");
        try {
            this.f412987a.stop();
            this.f412988b = false;
            this.f412989c = false;
        } catch (IllegalStateException e16) {
            n.b("QAdMediaPlayerWrapper", "stop e=" + e16.getMessage());
        }
    }
}

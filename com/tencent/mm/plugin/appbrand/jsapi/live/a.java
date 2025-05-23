package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends TXCloudVideoView {

    /* renamed from: h, reason: collision with root package name */
    private static final String f152097h = "MicroMsg.AppBrandLivePlayerView";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final com.tencent.luggage.wxa.xd.d f152098a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.luggage.wxa.ff.a f152099b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC7059a f152100c;

    /* renamed from: d, reason: collision with root package name */
    private c f152101d;

    /* renamed from: e, reason: collision with root package name */
    private int f152102e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f152103f;

    /* renamed from: g, reason: collision with root package name */
    private b f152104g;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC7059a {
        void enterFullScreen(int i3);

        boolean isFullScreen();

        void quitFullScreen();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void onLivePlayerExit();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void onFullScreenChange(boolean z16, int i3);
    }

    public a(@NonNull com.tencent.luggage.wxa.xd.d dVar, Context context) {
        super(context);
        this.f152098a = dVar;
        a(context);
    }

    public void a(Bundle bundle) {
        h initLivePlayer = this.f152099b.initLivePlayer(this, bundle);
        w.d(f152097h, "onInsert code:%d info:%s", Integer.valueOf(initLivePlayer.f126108a), initLivePlayer.f126109b);
    }

    public void b(Bundle bundle) {
        this.f152103f = bundle.getBoolean("needEvent", this.f152103f);
        h updateLivePlayer = this.f152099b.updateLivePlayer(bundle);
        w.d(f152097h, "onUpdate code:%d info:%s", Integer.valueOf(updateLivePlayer.f126108a), updateLivePlayer.f126109b);
    }

    public void c() {
        h enterForeground = this.f152099b.enterForeground();
        w.d(f152097h, "onForeground code:%d info:%s", Integer.valueOf(enterForeground.f126108a), enterForeground.f126109b);
    }

    public boolean d() {
        w.d(f152097h, "quitFullScreen");
        InterfaceC7059a interfaceC7059a = this.f152100c;
        if (interfaceC7059a == null) {
            w.f(f152097h, "quitFullScreen mFullScreenDelegate null");
            return false;
        }
        if (!interfaceC7059a.isFullScreen()) {
            w.d(f152097h, "quitFullScreen already quit full screen");
            return true;
        }
        this.f152100c.quitFullScreen();
        return true;
    }

    public boolean a(String str, JSONObject jSONObject) {
        h operateLivePlayer = this.f152099b.operateLivePlayer(str, jSONObject);
        w.d(f152097h, "onOperate code:%d info:%s", Integer.valueOf(operateLivePlayer.f126108a), operateLivePlayer.f126109b);
        return operateLivePlayer.f126108a == 0;
    }

    public void b(boolean z16) {
        this.f152103f = z16;
    }

    public void b() {
        w.d(f152097h, "onExitFullScreen");
        a(false);
    }

    public void a() {
        h uninitLivePlayer = this.f152099b.uninitLivePlayer();
        w.d(f152097h, "onDestroy code:%d info:%s", Integer.valueOf(uninitLivePlayer.f126108a), uninitLivePlayer.f126109b);
        b bVar = this.f152104g;
        if (bVar != null) {
            bVar.onLivePlayerExit();
        }
    }

    public void a(@NonNull e.d dVar) {
        h enterBackground = this.f152099b.enterBackground(this.f152098a, dVar);
        w.d(f152097h, "onBackground code:%d info:%s", Integer.valueOf(enterBackground.f126108a), enterBackground.f126109b);
    }

    public void a(ITXLivePlayListener iTXLivePlayListener) {
        this.f152099b.setPlayListener(iTXLivePlayListener);
    }

    public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.f152099b.setAudioVolumeListener(iTXAudioVolumeEvaluationListener);
    }

    public void a(InterfaceC7059a interfaceC7059a) {
        this.f152100c = interfaceC7059a;
    }

    public void a(c cVar) {
        this.f152101d = cVar;
    }

    public boolean a(int i3) {
        w.d(f152097h, "enterFullScreen direction:%s", Integer.valueOf(i3));
        InterfaceC7059a interfaceC7059a = this.f152100c;
        if (interfaceC7059a == null) {
            w.f(f152097h, "enterFullScreen mFullScreenDelegate null");
            return false;
        }
        if (interfaceC7059a.isFullScreen()) {
            w.d(f152097h, "enterFullScreen already full screen");
            return true;
        }
        this.f152100c.enterFullScreen(i3);
        this.f152102e = i3;
        a(true);
        return true;
    }

    private void a(boolean z16) {
        c cVar;
        if (!this.f152103f || (cVar = this.f152101d) == null) {
            return;
        }
        cVar.onFullScreenChange(z16, this.f152102e);
    }

    private void a(Context context) {
        this.f152099b = new TXLivePlayerJSAdapter(context);
    }

    public void a(b bVar) {
        this.f152104g = bVar;
    }

    public void a(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.f152099b.setSnapshotListener(iTXSnapshotListener);
    }
}

package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.base.ad.e.b;
import com.qq.e.comm.plugin.base.media.video.GDTVideoView;
import com.qq.e.comm.plugin.base.media.video.b;
import com.qq.e.comm.plugin.base.media.video.i;
import com.qq.e.comm.plugin.base.widget.EndCardController;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.j;
import com.qq.e.comm.plugin.k.m;
import com.qq.e.comm.plugin.k.o;
import com.qq.e.comm.plugin.k.p;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.nativ.MediaView;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g implements com.qq.e.comm.plugin.b.a, b.a, com.qq.e.comm.plugin.base.widget.c, com.qq.e.comm.plugin.m.b {
    private com.qq.e.comm.plugin.base.media.video.a A;
    private JSONObject B;
    private long C;
    private ImageView D;
    private String E;
    private boolean G;
    private int H;
    private long I;
    private long K;
    private boolean L;
    private long N;
    private int Q;

    /* renamed from: a, reason: collision with root package name */
    public MediaView f38703a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f38704b;

    /* renamed from: c, reason: collision with root package name */
    public com.qq.e.comm.plugin.base.media.video.b f38705c;

    /* renamed from: d, reason: collision with root package name */
    public volatile GDTVideoView f38706d;

    /* renamed from: e, reason: collision with root package name */
    public com.qq.e.comm.plugin.base.widget.a f38707e;

    /* renamed from: f, reason: collision with root package name */
    public com.qq.e.comm.plugin.base.widget.d f38708f;

    /* renamed from: g, reason: collision with root package name */
    public EndCardController f38709g;

    /* renamed from: h, reason: collision with root package name */
    int f38710h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f38711i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f38712j;

    /* renamed from: l, reason: collision with root package name */
    public String f38714l;

    /* renamed from: s, reason: collision with root package name */
    public int f38721s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f38723u;

    /* renamed from: v, reason: collision with root package name */
    public ViewGroup.LayoutParams f38724v;

    /* renamed from: w, reason: collision with root package name */
    public RelativeLayout.LayoutParams f38725w;

    /* renamed from: x, reason: collision with root package name */
    private Activity f38726x;

    /* renamed from: y, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.f f38727y;

    /* renamed from: z, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.c f38728z;

    /* renamed from: k, reason: collision with root package name */
    public int f38713k = 1;
    private a F = new a(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    public com.qq.e.comm.plugin.stat.b f38715m = new com.qq.e.comm.plugin.stat.b();

    /* renamed from: n, reason: collision with root package name */
    public com.qq.e.comm.plugin.stat.c f38716n = new com.qq.e.comm.plugin.stat.c();

    /* renamed from: o, reason: collision with root package name */
    public int f38717o = 1;

    /* renamed from: p, reason: collision with root package name */
    public int f38718p = 11;

    /* renamed from: q, reason: collision with root package name */
    public int f38719q = 1;

    /* renamed from: r, reason: collision with root package name */
    public int f38720r = 3;

    /* renamed from: t, reason: collision with root package name */
    public boolean f38722t = false;
    private boolean J = false;
    private boolean M = true;
    private volatile boolean O = false;
    private volatile boolean P = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            g gVar = g.this;
                            gVar.f38717o = 2;
                            gVar.f38713k = 5;
                            gVar.i();
                            return;
                        }
                        return;
                    }
                    g gVar2 = g.this;
                    gVar2.f38713k = 4;
                    if (gVar2.B != null) {
                        g gVar3 = g.this;
                        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_VIDEO_PLAY_START, 0, z.a(gVar3.f38715m, gVar3.B, g.this.C));
                    }
                    g.this.E();
                    return;
                }
                com.qq.e.comm.plugin.base.widget.a aVar = g.this.f38707e;
                if (aVar != null) {
                    aVar.setVisibility(8);
                }
                com.qq.e.comm.plugin.base.media.video.b bVar = g.this.f38705c;
                if (bVar != null) {
                    bVar.c();
                    return;
                }
                return;
            }
            com.qq.e.comm.plugin.base.widget.a aVar2 = g.this.f38707e;
            if (aVar2 != null) {
                aVar2.a(message.arg1);
                if (message.arg1 == 100) {
                    g.this.f38707e.setVisibility(8);
                }
            }
        }
    }

    public g(Activity activity, com.qq.e.comm.plugin.base.ad.model.f fVar) {
        this.L = false;
        if (activity != null && fVar != null) {
            this.f38726x = activity;
            this.f38727y = fVar;
            this.f38728z = new com.qq.e.comm.plugin.base.ad.c();
            this.f38716n.a("posId", this.f38727y.s());
            this.f38716n.a("cl", this.f38727y.f());
            this.f38715m.a(this.f38727y.s());
            this.f38715m.b(this.f38727y.f());
            this.f38715m.c(this.f38727y.y());
            if (this.f38727y.isAppAd()) {
                ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).addStatusListener(com.qq.e.comm.plugin.k.d.c(this.f38727y.v()).b(), this);
            }
            this.f38709g = new EndCardController(this.f38727y, this.f38715m, this.f38716n);
            this.L = fVar.d();
        }
    }

    private void A() {
        this.D = new ImageView(this.f38726x);
        this.D.setImageBitmap(am.a("iVBORw0KGgoAAAANSUhEUgAAADgAAAAeCAYAAAB5c901AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAMtSURBVHgB3ZhNSBtBFMffpo1KFOsXiVeD4kEkJ0lBg4f0IqTtQUXao+TiKd7EtMe2Hi0IgiYFTyp+4FWhIlJEctHa2CpizCGkJCHkoxhLSGH7XuLCEkwy6+5G3B+87GzmY/PfefPmTTgoYECzoDWi6eHxE0H7hXbDQUGcDbQhTEwO7dsTKMzcM9AepK1Rhx/toF3yArWMXrZAi8VSv729/er8/HwS7snw8LBRKHMcB16v17q+vm6nsUEmsgWenJxkrFarvbu72764uGiV0pfEbGxs2NG+nJ2dTd5+xzkcjtcjIyOusbExM8jkKWvDmZmZ3s7OTuNddel0OtbU1GQeHR1929zc3FBqDKzfFd+TmIGBATsW+a2trV1QAdomHCwNLy4uXF1dXS9ABqjnpagM5IbonvmZi0ajfqGupaXFrNfr61Op1FU2m80UjxMIBPz9/f0rwADzDAocHh4uh8PhGMgEXdA4NDT0Rrg3mUy9xW3IK+7qm0wmmZ8vWeD+/v7p9PS0H2SArmpcWlr6ZDAYTAcHByuzs7NfhTqdTgcLCwvv0dU7PB7Ph52dnWBx/8vLywzrsyQLlAu5JgaPXkEcrsFlcT0K5Obm5q6xyMfj8ZvNzU1Z3lJ1gTzPw+rqqh+vn+kq3iIIegFCEde8sbheDIv4qgtE9zStra15qYzrsGxbrJ8s04bHOmclkQ8xg7w4YsoZimUtMgusqalpAAXATT2G5oYqwSywrq4unzbh278GBaC1hpnP856eng4p/UKhUAyDFHNSIHkG9/b2ZO+BBAkcHBy0Sk0ezGbzD7woK5B+DO1LuVwuQ7knKAzudZ7j4+NguTZtbW31TqfzHUiESaDL5cpnFIlE4gqUhz86Ogq63e6ygYeiLwoEqTCdJjDvy6+TSCSihkBVYZpBm81GGT/4fD4lwnsx3MTEhHN8fLys69fW1t7rbFhRIB06hUR4fn7+FFSgVFKtBBUFUlChnLG1tdWoRoAhSiXVYvr6+tqnpqY+gkSYz4M0k2oJVBNmgY8ViqI50DAk8A9olwgJ/A7anEXS9JP+3v6H9huN9hlFTgwPDAlLofnQ/v4HG4sVxLvjTAEAAAAASUVORK5CYII="));
        this.D.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.f38726x, 28), ak.a(this.f38726x, 15));
        layoutParams.gravity = 83;
        layoutParams.bottomMargin = ak.a(this.f38726x, 10);
        layoutParams.leftMargin = ak.a(this.f38726x, 10);
        this.f38703a.addView(this.D, layoutParams);
        this.D.setVisibility(8);
    }

    private void B() {
        this.f38726x.finish();
    }

    private void C() {
        if (e()) {
            GDTLogger.d("VideoController video exists! no need report");
            this.P = false;
            this.f38713k = 4;
            E();
            return;
        }
        if (this.f38713k == 1) {
            h();
            com.qq.e.comm.plugin.base.media.video.b bVar = this.f38705c;
            if (bVar != null) {
                bVar.d();
            }
            f();
        }
    }

    private void D() {
        Intent intent;
        Bundle extras;
        ResultReceiver resultReceiver;
        Activity activity = this.f38726x;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null && (extras = intent.getExtras()) != null && this.f38706d != null && (resultReceiver = (ResultReceiver) extras.getParcelable("key_result_receiver")) != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_landing_page_video_paused", !this.f38706d.c());
            resultReceiver.send(-1, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.qq.e.comm.plugin.base.media.video.b bVar;
        if (!w() && (bVar = this.f38705c) != null) {
            bVar.a(0, true);
            GDTLogger.e("can't play now, auto = " + m.a() + ", curr = " + GDTADManager.getInstance().getDeviceStatus().getNetworkType().getNameValue());
            return;
        }
        this.f38717o = 0;
        g();
    }

    private void F() {
        if (this.f38706d != null && !j.a(this.f38714l)) {
            this.P = false;
            this.f38706d.a(this.f38714l);
            return;
        }
        if (this.f38706d != null && !j.a(this.E)) {
            if (ay.a(this.E)) {
                boolean a16 = p.a(this.f38706d, this.E, this);
                this.M = a16;
                if (!a16) {
                    C();
                    return;
                }
                return;
            }
            this.f38706d.a(this.E);
            return;
        }
        C();
    }

    private void G() {
        this.f38720r = 3;
        i();
    }

    public void g() {
        if (!TextUtils.isEmpty(this.f38714l)) {
            File file = new File(this.f38714l);
            this.E = file.exists() ? file.getAbsolutePath() : null;
        } else {
            File b16 = ai.b(this.f38727y.x());
            if (b16 != null && b16.exists()) {
                this.E = b16.getAbsolutePath();
            } else if (this.L) {
                this.E = this.f38727y.x();
            } else {
                this.E = null;
            }
        }
        if (TextUtils.isEmpty(this.E)) {
            GDTLogger.e("Video path is null.");
            return;
        }
        if (this.f38705c != null) {
            this.F.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.3
                @Override // java.lang.Runnable
                public void run() {
                    com.qq.e.comm.plugin.base.media.video.b bVar = g.this.f38705c;
                    if (bVar != null) {
                        bVar.d();
                    }
                }
            });
        }
        if (this.f38706d != null) {
            if (!this.E.equals(this.f38706d.n())) {
                F();
            }
            this.f38706d.a();
        }
    }

    public void h() {
        MediaView mediaView = this.f38703a;
        if (mediaView == null) {
            return;
        }
        mediaView.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.4
            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                if (gVar.f38703a == null) {
                    return;
                }
                try {
                    com.qq.e.comm.plugin.base.widget.a aVar = gVar.f38707e;
                    if (aVar == null) {
                        gVar.f38707e = new com.qq.e.comm.plugin.base.widget.a(g.this.f38703a.getContext());
                    } else {
                        ViewParent parent = aVar.getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(g.this.f38707e);
                        }
                    }
                    g.this.f38707e.setVisibility(0);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(g.this.f38703a.getContext().getApplicationContext(), 46), ak.a(g.this.f38703a.getContext().getApplicationContext(), 46));
                    layoutParams.gravity = 17;
                    g gVar2 = g.this;
                    gVar2.f38703a.addView(gVar2.f38707e, layoutParams);
                } catch (Throwable th5) {
                    GDTLogger.d(th5.getMessage());
                }
            }
        });
    }

    public void i() {
        int i3;
        int i16;
        if (this.f38703a == null) {
            GDTLogger.d("\u672a\u7ed1\u5b9aMediaView\u7ec4\u4ef6\uff0c\u4e0d\u4e0a\u62a5\u89c6\u9891\u64ad\u653e\u6548\u679c\uff01");
            return;
        }
        com.qq.e.comm.plugin.base.ad.model.a aVar = new com.qq.e.comm.plugin.base.ad.model.a(this.f38727y.u(), com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD, this.f38727y.s());
        if (this.f38717o == 0) {
            i3 = u();
        } else {
            i3 = 0;
        }
        if (this.f38717o == 0) {
            i16 = this.f38721s;
        } else {
            i16 = 0;
        }
        GDTLogger.d("VideoController VideoPlayReport finishType=" + this.f38720r + "== playScene ==" + this.f38719q);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("VideoController VideoPlayReport currentPosition=");
        sb5.append(i3);
        GDTLogger.d(sb5.toString());
        GDTLogger.d("VideoController VideoPlayReport duration=" + i16);
        com.qq.e.comm.plugin.base.ad.e.b.a(this.f38720r, this.f38719q, this.f38718p, this.f38717o, i3, i16, this.H, this.f38727y.ae(), aVar, new b.a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.5
            @Override // com.qq.e.comm.plugin.base.ad.e.b.a
            public void a() {
                GDTLogger.d("NativeAd report video info success");
                if (StringUtil.isEmpty(g.this.f38727y.o())) {
                    return;
                }
                af.a(g.this.f38727y.o());
            }

            @Override // com.qq.e.comm.plugin.base.ad.e.b.a
            public void a(int i17) {
                GDTLogger.e("NativeAd report video info error");
            }
        });
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void j() {
        GDTLogger.d("onVideoReady");
        boolean z16 = false;
        this.f38717o = 0;
        if (this.f38703a != null && this.f38706d != null) {
            this.f38721s = this.f38706d.e();
            GDTLogger.d("duration = " + this.f38721s);
        }
        com.qq.e.comm.plugin.base.widget.a aVar = this.f38707e;
        if (aVar != null) {
            aVar.setVisibility(8);
        }
        if (!this.O && this.P) {
            if (this.L && this.M) {
                z16 = true;
            }
            p.a(z16, (int) (System.currentTimeMillis() - this.N), 2);
            this.O = true;
        } else {
            GDTLogger.d("VideoController,videoReady to report info, no need report");
        }
        y();
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void k() {
        GDTLogger.d("onVideoStart");
        this.f38712j = false;
        if (this.f38706d != null && this.f38706d.j() && this.f38706d.m()) {
            this.f38718p = 14;
        }
        this.f38728z.a(System.currentTimeMillis());
        this.f38709g.d();
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void l() {
        GDTLogger.d("onVideoComplete");
        this.G = true;
        this.f38709g.c();
        this.f38720r = 3;
        G();
        this.f38712j = true;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void m() {
        GDTLogger.d("onVideoError");
        this.f38717o = 3;
        i();
        y();
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void n() {
        GDTLogger.d("onVideoPause");
        this.f38720r = 1;
        i();
        a(u());
        D();
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void o() {
        GDTLogger.d("onVideoResume");
        D();
        if (this.G) {
            return;
        }
        this.f38709g.d();
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void p() {
        GDTLogger.d("onEnterFSButtonClicked");
        com.qq.e.comm.plugin.base.media.video.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.b.a
    public void q() {
        GDTLogger.d("onCloseButtonClicked");
        g(3);
        com.qq.e.comm.plugin.base.media.video.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
        }
    }

    public com.qq.e.comm.plugin.base.ad.c r() {
        return this.f38728z;
    }

    public void s() {
        GDTLogger.d("VideoController destroy");
        this.f38711i = true;
        if (this.f38706d != null) {
            this.f38706d.k();
            this.f38706d = null;
        }
        MediaView mediaView = this.f38703a;
        if (mediaView != null) {
            mediaView.removeAllViews();
            this.f38703a = null;
        }
        com.qq.e.comm.plugin.base.media.video.b bVar = this.f38705c;
        if (bVar != null) {
            bVar.j();
            this.f38705c.removeAllViews();
            this.f38705c = null;
        }
        if (this.f38707e != null) {
            this.f38707e = null;
        }
        this.f38726x = null;
    }

    public void t() {
        a(u());
        g();
        if (this.f38727y.isAppAd() && this.f38709g != null) {
            String b16 = com.qq.e.comm.plugin.k.d.c(this.f38727y.v()).b();
            this.f38709g.a(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(b16), ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getProgress(b16));
        }
    }

    public int u() {
        if (this.f38706d != null) {
            return this.f38706d.f();
        }
        return 0;
    }

    public void v() {
        this.A = null;
    }

    public boolean w() {
        int a16 = m.a();
        if ((a16 == 0 && NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType()) || a16 == 1) {
            return true;
        }
        return false;
    }

    public boolean x() {
        int i3;
        int J = this.f38727y.J();
        int I = this.f38727y.I();
        if (J != 0 && I != 0) {
            return false;
        }
        if (J == 0 && I == 0) {
            i3 = 3;
        } else if (J == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        StatTracer.trackEvent(30282, i3, this.f38715m, this.f38716n);
        return true;
    }

    public void y() {
        com.qq.e.comm.plugin.base.widget.a aVar;
        if (this.f38703a != null && (aVar = this.f38707e) != null) {
            aVar.setVisibility(8);
            this.f38703a.removeView(this.f38707e);
        }
    }

    public MediaView z() {
        return this.f38703a;
    }

    private void e(boolean z16) {
        VideoOption a16 = a(this.f38726x.getIntent());
        this.f38703a.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (this.f38706d == null) {
            this.f38706d = new GDTVideoView(this.f38726x.getApplicationContext(), this.L, z16 && this.L && this.f38727y.am() > 0.0d && this.f38727y.am() < 1.0d, z16 ? ai.f() : ai.g());
            this.f38706d.a(true);
            this.f38706d.setFitsSystemWindows(true);
            this.f38706d.setKeepScreenOn(true);
            this.f38706d.setLayoutParams(layoutParams);
            if (SDKStatus.getSDKVersionCode() >= 13) {
                this.f38706d.a(this.f38727y.J(), this.f38727y.I());
                x();
            }
        } else {
            ViewParent parent = this.f38706d.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f38706d);
            }
        }
        com.qq.e.comm.plugin.base.media.video.b bVar = this.f38705c;
        if (bVar == null) {
            com.qq.e.comm.plugin.base.media.video.b bVar2 = new com.qq.e.comm.plugin.base.media.video.b(this.f38726x.getApplicationContext(), 1, this.f38727y.h(), a16 == null || a16.isNeedProgressBar(), a16 == null || a16.isNeedCoverImage());
            this.f38705c = bVar2;
            bVar2.setFitsSystemWindows(true);
            this.f38705c.setKeepScreenOn(true);
        } else {
            ViewParent parent2 = bVar.getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(this.f38705c);
            }
        }
        this.f38706d.a(this.f38705c);
        i.a(false);
        this.f38705c.a(this);
        this.f38705c.a(true, false);
        this.f38705c.a(true);
        this.f38705c.a(3000, true);
        this.f38709g.a(this.f38726x.getApplicationContext(), this.f38703a, this, 2);
        this.f38708f = this.f38709g.a();
        if (this.f38706d != null && this.f38705c != null) {
            ViewParent parent3 = this.f38706d.getParent();
            if (parent3 != null) {
                ((ViewGroup) parent3).removeView(this.f38706d);
            }
            ViewParent parent4 = this.f38705c.getParent();
            if (parent4 != null) {
                ((ViewGroup) parent4).removeView(this.f38705c);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            this.f38703a.addView(this.f38706d, 0, layoutParams2);
            this.f38703a.addView(this.f38705c, 1, layoutParams2);
            com.qq.e.comm.plugin.base.media.a.a.a(this.f38703a, this.f38727y.h());
            this.f38705c.b(false);
            if (this.J) {
                this.f38706d.h();
            } else {
                this.f38706d.i();
            }
            this.f38706d.a(false);
            this.f38722t = true;
            C();
            GDTLogger.e("seek to :" + this.K);
            this.f38706d.a((int) this.K);
            return;
        }
        GDTLogger.e("NativeAdVideoController don't provide necessary widget");
        StatTracer.trackEvent(30242, 0, this.f38715m, this.f38716n);
        B();
    }

    public void b(int i3) {
        this.Q = i3;
    }

    public void c(int i3) {
        this.f38719q = i3;
        com.qq.e.comm.plugin.base.media.video.b bVar = this.f38705c;
        if (bVar != null) {
            bVar.a(i3);
            this.f38705c.g();
            this.f38705c.f();
            this.f38705c.h();
        }
    }

    public String d() {
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38727y;
        if (fVar != null) {
            if (!TextUtils.isEmpty(fVar.y())) {
                return "native_video_current_time_receive".concat(this.f38727y.y());
            }
            if (!TextUtils.isEmpty(this.f38727y.f())) {
                return "native_video_current_time_receive".concat(this.f38727y.f());
            }
        }
        return "native_video_current_time_receive";
    }

    public void f() {
        final long currentTimeMillis = System.currentTimeMillis();
        this.N = currentTimeMillis;
        if (this.L && this.M) {
            E();
            return;
        }
        GDTLogger.d("VideoController use downloadingWithPlay failed and no preload and no video cached, need to report");
        this.P = true;
        File g16 = ai.g();
        if (g16 == null) {
            return;
        }
        com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(new h.a().c(this.f38727y.x()).a(ai.a(this.f38727y.x())).a(g16).a(), this.f38727y.x(), o.a(o.a()), new com.qq.e.comm.plugin.i.a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.2
            @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
            public void a() {
                GDTLogger.d("onStarted");
                g.this.f38713k = 2;
            }

            @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
            public void b() {
                GDTLogger.d("onConnecting");
            }

            @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
            public void c() {
                GDTLogger.i("onPaused");
                g.this.f38713k = 3;
            }

            @Override // com.qq.e.comm.plugin.i.a
            public void b(boolean z16) {
                GDTLogger.i("onCanceled");
                g gVar = g.this;
                gVar.f38713k = 5;
                gVar.F.sendEmptyMessage(2);
            }

            @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
            public void a(long j3, boolean z16) {
                g.this.I = j3;
                GDTLogger.d("onConnected isRangeSupport: " + z16 + ", total: " + j3);
            }

            @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
            public void a(long j3, long j16, int i3) {
                GDTLogger.d("downloading[" + g.this.f38727y.g() + "] video ---> Progress: " + i3 + "%");
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.arg1 = i3;
                g.this.F.sendMessage(obtain);
            }

            @Override // com.qq.e.comm.plugin.i.a
            public void a(boolean z16) {
                GDTLogger.d("onCompleted");
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                GDTLogger.d("download time: " + currentTimeMillis2 + "ms");
                GDTLogger.d("download speed: " + (g.this.I / currentTimeMillis2) + "kb/s");
                if (g.this.f38711i) {
                    GDTLogger.i("download complete after destroyed");
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 3;
                g.this.F.sendMessage(obtain);
            }

            @Override // com.qq.e.comm.plugin.i.a
            public void a(com.qq.e.comm.plugin.i.d dVar, boolean z16) {
                GDTLogger.e("Download Failed, code: " + dVar.a() + ", msg: " + dVar.b());
                Message obtain = Message.obtain();
                obtain.what = 4;
                g.this.F.sendMessage(obtain);
                g.this.F.sendEmptyMessage(2);
            }
        });
    }

    public void a(int i3) {
        GDTLogger.d("setVideoPlayStartTime:" + i3);
        this.H = i3;
    }

    public ViewGroup b() {
        return this.f38704b;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.b.a
    public void b(boolean z16) {
        GDTLogger.d("onPlayPauseButtonClicked mMediaStatus: " + this.f38710h);
        if (z16) {
            this.f38720r = 1;
        } else {
            this.f38718p = 12;
            this.H = this.f38706d.f();
        }
        com.qq.e.comm.plugin.base.media.video.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void a(JSONObject jSONObject, long j3) {
        this.B = jSONObject;
        this.C = j3;
    }

    public int a() {
        return this.Q;
    }

    public void d(int i3) {
        EndCardController endCardController = this.f38709g;
        if (endCardController != null) {
            endCardController.a(i3);
            if (this.f38712j) {
                this.f38709g.c();
            }
        }
    }

    public void a(boolean z16) {
        MediaView mediaView = new MediaView(this.f38726x);
        this.f38703a = mediaView;
        mediaView.setBackgroundColor(-16777216);
        d(true);
        this.f38725w = new RelativeLayout.LayoutParams(-1, ak.b(this.f38726x));
        this.f38724v = new RelativeLayout.LayoutParams(-1, this.Q);
        this.f38703a.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                MediaView mediaView2;
                ViewGroup.LayoutParams layoutParams;
                g gVar = g.this;
                if (gVar.f38719q == 7 && (mediaView2 = gVar.f38703a) != null && (layoutParams = gVar.f38724v) != null) {
                    mediaView2.setLayoutParams(layoutParams);
                }
            }
        });
        View a16 = a(this.f38726x);
        if (a16 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) a16;
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(i3);
                if (viewGroup2 instanceof ScrollView) {
                    View childAt = viewGroup2.getChildAt(0);
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup3 = (ViewGroup) childAt;
                        this.f38704b = viewGroup3;
                        ((RelativeLayout) viewGroup3).addView(this.f38703a, this.f38725w);
                    }
                } else {
                    i3++;
                }
            }
            e(z16);
            A();
            return;
        }
        GDTLogger.e("VideoController init error");
    }

    public void c() {
        if (this.f38706d != null) {
            this.f38706d.b();
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.b.a
    public void c(boolean z16) {
        ResultReceiver resultReceiver;
        if (this.A != null) {
            Activity activity = this.f38726x;
            Intent intent = activity != null ? activity.getIntent() : null;
            if (intent == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null && (resultReceiver = (ResultReceiver) extras.getParcelable("key_result_receiver")) != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_landing_page_video_muted", z16);
                resultReceiver.send(-1, bundle);
            }
            this.A.a(z16);
        }
    }

    public void d(boolean z16) {
        MediaView mediaView = this.f38703a;
        if (mediaView != null) {
            if (z16) {
                mediaView.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.g.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        if (g.this.f38706d != null) {
                            GDTLogger.d("mediaView cliked");
                            g.this.f38706d.l();
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            } else {
                mediaView.setOnClickListener(null);
            }
        }
    }

    public void f(int i3) {
        this.f38718p = i3;
    }

    public void g(int i3) {
        this.f38720r = i3;
    }

    private static View a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup == null) {
            return null;
        }
        return ((FrameLayout) viewGroup.findViewById(R.id.content)).getChildAt(0);
    }

    private VideoOption a(Intent intent) {
        VideoOption videoOption = null;
        if (intent == null) {
            return null;
        }
        this.K = intent.getLongExtra("detailPagePlayTime", 0L);
        this.J = intent.getBooleanExtra("detailPageMuted", false);
        this.f38714l = intent.getStringExtra("detailPageVideoPath");
        if (!intent.getBooleanExtra("none_option", false)) {
            VideoOption.Builder builder = new VideoOption.Builder();
            builder.setDetailPageMuted(intent.getBooleanExtra("detail_page_muted", false));
            builder.setNeedCoverImage(intent.getBooleanExtra("need_cover", true));
            builder.setNeedProgressBar(intent.getBooleanExtra("need_progress", true));
            builder.setEnableUserControl(intent.getBooleanExtra("enable_user_control", true));
            builder.setEndCardBtnColor(intent.getStringExtra("endCardBtnColor"));
            builder.setEndCardOpening(intent.getBooleanExtra("isEndCardOpening", true));
            builder.setEndCardBtnRadius(intent.getIntExtra("endCardBtnRadius", 0));
            videoOption = builder.build();
        }
        this.f38709g.a(videoOption);
        return videoOption;
    }

    public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.e.a aVar) {
        EndCardController endCardController = this.f38709g;
        if (endCardController != null) {
            endCardController.a(aVar);
        }
    }

    public void a(com.qq.e.comm.plugin.base.media.video.a aVar) {
        this.A = aVar;
    }

    public boolean e() {
        if (!TextUtils.isEmpty(this.f38714l)) {
            return new File(this.f38714l).exists();
        }
        File b16 = ai.b(this.f38727y.x());
        return (j.a(this.f38727y.x()) || b16 == null || !b16.exists()) ? false : true;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.d
    public void e(int i3) {
        a(i3);
    }
}

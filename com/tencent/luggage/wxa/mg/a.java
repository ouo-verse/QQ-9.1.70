package com.tencent.luggage.wxa.mg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.dh.a;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.p004if.r;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends RelativeLayout {
    public ImageView C;
    public ImageView D;
    public ImageView E;
    public FrameLayout F;
    public String G;
    public int H;
    public String I;
    public com.tencent.luggage.wxa.xd.d J;
    public boolean K;
    public boolean L;
    public com.tencent.luggage.wxa.vg.b M;
    public boolean N;
    public boolean O;
    public com.tencent.luggage.wxa.dh.a P;
    public p Q;
    public boolean R;
    public boolean S;
    public double T;
    public int U;
    public String V;
    public boolean W;

    /* renamed from: a, reason: collision with root package name */
    public int f134479a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f134480a0;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f134481b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f134482b0;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.mg.g f134483c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f134484c0;

    /* renamed from: d, reason: collision with root package name */
    public TextView f134485d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f134486d0;

    /* renamed from: e, reason: collision with root package name */
    public DanmuView f134487e;

    /* renamed from: e0, reason: collision with root package name */
    public int f134488e0;

    /* renamed from: f, reason: collision with root package name */
    public g.a f134489f;

    /* renamed from: f0, reason: collision with root package name */
    public String f134490f0;

    /* renamed from: g, reason: collision with root package name */
    public View f134491g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f134492g0;

    /* renamed from: h, reason: collision with root package name */
    public View f134493h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f134494h0;

    /* renamed from: i, reason: collision with root package name */
    public TextView f134495i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f134496i0;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f134497j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f134498j0;

    /* renamed from: k, reason: collision with root package name */
    public AppBrandDotPercentIndicator f134499k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f134500k0;

    /* renamed from: l, reason: collision with root package name */
    public TextView f134501l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f134502l0;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f134503m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f134504m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f134505n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f134506o0;

    /* renamed from: p0, reason: collision with root package name */
    public e0 f134507p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f134508q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f134509r0;

    /* renamed from: s0, reason: collision with root package name */
    public g.c f134510s0;

    /* renamed from: t0, reason: collision with root package name */
    public com.tencent.luggage.wxa.mg.k f134511t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f134512u0;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6473a implements g.i {
        public C6473a() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.i
        public int a() {
            return a.this.f134483c.getCacheTimeSec();
        }

        @Override // com.tencent.luggage.wxa.mg.g.i
        public int b() {
            return a.this.f134483c.getVideoDurationSec();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.setMute(!r2.f134492g0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.a(false, aVar.f134479a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements g.f {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.f
        public void a(boolean z16) {
            a.this.x();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements g.e {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.e
        public void a(int i3, int i16) {
            if (i16 <= 0) {
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 > i16) {
                i3 = i16;
            }
            int width = (i3 * a.this.E.getWidth()) / i16;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.D.getLayoutParams();
            layoutParams.width = width;
            a.this.D.setLayoutParams(layoutParams);
            a.this.D.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements e0.a {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            int i3;
            int cacheTimeSec = a.this.getCacheTimeSec();
            int duration = a.this.getDuration();
            if (duration != 0 && (i3 = (int) ((cacheTimeSec * 100.0f) / duration)) != a.this.f134508q0) {
                a.this.f134508q0 = i3;
                if (a.this.M != null) {
                    a.this.M.a(i3, duration);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f134520a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.mg.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6474a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f134522a;

            public RunnableC6474a(Bitmap bitmap) {
                this.f134522a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap = this.f134522a;
                if (bitmap != null && !bitmap.isRecycled()) {
                    a.this.C.setImageBitmap(this.f134522a);
                }
            }
        }

        public h(String str) {
            this.f134520a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.a(new RunnableC6474a(com.tencent.luggage.wxa.tn.d.a(this.f134520a, 1)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements g.InterfaceC6475g {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.InterfaceC6475g
        public void a(View view, boolean z16) {
            if (z16) {
                if (a.this.f134483c.isPlaying()) {
                    a.this.f134487e.p();
                } else {
                    a.this.f134487e.m();
                }
            } else {
                a.this.f134487e.i();
            }
            if (a.this.M != null) {
                a.this.M.a(a.this.H, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements a.d {
        public j() {
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void a() {
            a.this.a("onSingleTap", new Object[0]);
            if (!a.this.L || a.this.f134491g.getVisibility() == 0) {
                return;
            }
            a.this.f134489f.a();
            if (a.this.f134494h0) {
                a.this.e();
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public int b(int i3, float f16) {
            if (!a.this.b()) {
                return 0;
            }
            a.this.b("onDragProgress:" + i3 + "/" + f16, new Object[0]);
            int videoDurationSec = a.this.f134483c.getVideoDurationSec();
            int a16 = com.tencent.luggage.wxa.ch.b.a(f16, (float) a.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
            String a17 = com.tencent.luggage.wxa.mg.n.a(((long) videoDurationSec) * 1000);
            a.this.f134485d.setText(com.tencent.luggage.wxa.mg.n.a(a16 * 1000) + "/" + a17);
            a.this.f134489f.a(a16);
            if (a.this.f134489f.j()) {
                a.this.f134489f.b();
            }
            return a16;
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void c() {
            a.this.a("onDoubleTap", new Object[0]);
            if (a.this.f134496i0) {
                if (a.this.f134483c.isPlaying()) {
                    a.this.p();
                } else {
                    a.this.t();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public boolean d() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void e() {
            if (!a.this.b()) {
                return;
            }
            a.this.f134485d.setVisibility(0);
            a.this.e();
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public boolean f() {
            return a.this.a();
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public boolean g() {
            return a.this.a();
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public int getCurrentPosition() {
            return a.this.f134483c.getCurrPosSec();
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void d(float f16) {
            if (g()) {
                a.this.a("onAdjustVolume:" + f16, new Object[0]);
                a.this.f134499k.setPercent(f16);
                a.this.f134501l.setText(R.string.f16385249);
                a.this.f134503m.setImageResource(R.drawable.mno);
                a.this.f134497j.setVisibility(0);
                a.this.e();
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void a(int i3, float f16) {
            if (a.this.b()) {
                a.this.f134485d.setVisibility(8);
                a.this.s();
                a.this.b("onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i3), Integer.valueOf(a.this.f134483c.getCurrPosSec()), Float.valueOf(f16));
                a.this.a(i3);
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void c(float f16) {
            if (f()) {
                a.this.f134497j.setVisibility(8);
                a.this.s();
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void b(float f16) {
            if (f()) {
                a.this.a("onAdjustBrightness:" + f16, new Object[0]);
                a.this.f134499k.setPercent(f16);
                a.this.f134501l.setText(R.string.f16384248);
                a.this.f134503m.setImageResource(R.drawable.mnm);
                a.this.f134497j.setVisibility(0);
                a.this.e();
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public void a(float f16) {
            if (g()) {
                a.this.f134497j.setVisibility(8);
                a.this.s();
            }
        }

        @Override // com.tencent.luggage.wxa.dh.a.d
        public boolean b() {
            return a.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements com.tencent.luggage.wxa.ug.c {
        public l() {
        }

        @Override // com.tencent.luggage.wxa.ug.c
        public int a() {
            return a.this.f134483c.getCurrPosSec();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16 = !a.this.j();
            a aVar = a.this;
            aVar.a(z16, aVar.f134479a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements g.d {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.d
        public void a() {
            a.this.b("onSeekPre", new Object[0]);
        }

        @Override // com.tencent.luggage.wxa.mg.g.d
        public void a(int i3) {
            a.this.a(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f134483c.isPlaying()) {
                a.this.p();
            } else {
                a.this.t();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface p {
        void enterFullScreen(int i3);

        boolean isFullScreen();

        void quitFullScreen();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, View view) {
        super(context);
        this.f134479a = -1;
        this.f134502l0 = false;
        this.f134504m0 = true;
        this.f134505n0 = false;
        this.f134506o0 = false;
        this.f134508q0 = 0;
        this.f134509r0 = -16777216;
        this.f134511t0 = null;
        this.f134483c = (com.tencent.luggage.wxa.mg.g) view;
        a(context);
        this.f134481b.addView(view);
    }

    private void setCover(String str) {
        if (w0.c(str)) {
            return;
        }
        if (!w0.c(this.V)) {
            b("setCover mCoverUrl not null", new Object[0]);
        } else {
            com.tencent.luggage.wxa.tk.l.a().d(new h(str));
        }
    }

    public int getCacheTimeSec() {
        com.tencent.luggage.wxa.mg.g gVar = this.f134483c;
        if (gVar != null) {
            return gVar.getCacheTimeSec();
        }
        return 0;
    }

    public com.tencent.luggage.wxa.vg.b getCallback() {
        return this.M;
    }

    public String getCookieData() {
        return this.G;
    }

    public int getCurrPosMs() {
        return this.f134483c.getCurrPosMs();
    }

    public int getCurrPosSec() {
        return this.f134483c.getCurrPosSec();
    }

    public int getDuration() {
        int i3 = this.U;
        if (i3 <= 0) {
            return this.f134483c.getVideoDurationSec();
        }
        return i3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (r()) {
            com.tencent.luggage.wxa.dh.a aVar = this.P;
            if (aVar != null) {
                aVar.a(motionEvent);
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && this.L && this.f134491g.getVisibility() != 0) {
            this.f134489f.a();
            if (this.f134494h0) {
                e();
            }
        }
        if (this.W) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoPauseIfNavigate(boolean z16) {
        this.f134498j0 = z16;
    }

    public void setAutoPauseIfOpenNative(boolean z16) {
        this.f134500k0 = z16;
    }

    public void setAutoPlay(boolean z16) {
        b("setAutoPlay %b", Boolean.valueOf(z16));
        this.K = z16;
    }

    public void setCallback(com.tencent.luggage.wxa.vg.b bVar) {
        this.M = bVar;
    }

    public void setComponent(com.tencent.luggage.wxa.xd.d dVar) {
        this.J = dVar;
        this.I = dVar.getAppId();
        com.tencent.luggage.wxa.mg.g gVar = this.f134483c;
        if (gVar instanceof com.tencent.luggage.wxa.mg.b) {
            ((com.tencent.luggage.wxa.mg.b) gVar).setHostComponent(dVar);
        }
    }

    public void setConsumeTouchEvent(boolean z16) {
        b("setConsumeTouchEvent game=%s", Boolean.valueOf(z16));
        this.W = z16;
    }

    public void setCookieData(String str) {
        this.G = str;
    }

    public void setDanmakuEnable(boolean z16) {
        b("setDanmakuEnable %b", Boolean.valueOf(z16));
        this.f134489f.setDanmakuBtnOpen(z16);
    }

    public void setDanmakuItemList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        b("setDanmakuItemList length=%d", Integer.valueOf(jSONArray.length()));
        if (this.f134487e == null) {
            c("setDanmakuItemList mDanmakuView null", new Object[0]);
            f();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            com.tencent.luggage.wxa.ug.d a16 = a(jSONArray.optJSONObject(i3));
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        this.f134487e.b((List) arrayList, true);
    }

    public void setDuration(int i3) {
        if (i3 <= 0) {
            b("setDuration error duration=%d", Integer.valueOf(i3));
        } else {
            this.f134495i.setText(a(i3));
            this.U = i3;
        }
    }

    public void setEnablePlayGesture(boolean z16) {
        b("setEnablePlayGesture %b", Boolean.valueOf(z16));
        this.f134496i0 = z16;
    }

    public void setFullScreenDelegate(p pVar) {
        this.Q = pVar;
    }

    public void setFullScreenDirection(int i3) {
        b("setFullScreenDirection %d", Integer.valueOf(i3));
        this.f134479a = i3;
    }

    public void setFullScreenState(boolean z16) {
        if (z16) {
            this.f134489f.e();
        } else {
            this.f134489f.quitFullScreen();
        }
    }

    public void setIMMVideoViewCallback(g.c cVar) {
        this.f134510s0 = cVar;
    }

    public void setInitialTime(double d16) {
        b("setInitialTime %s", Double.valueOf(d16));
        this.T = d16;
    }

    public void setIsEnableBottomProgressBar(boolean z16) {
        this.f134504m0 = z16;
    }

    public void setIsShowBasicControls(boolean z16) {
        b("setIsShowBasicControls %b", Boolean.valueOf(z16));
        this.L = z16;
        g.a aVar = this.f134489f;
        if (aVar != null) {
            if (z16) {
                aVar.i();
            } else {
                aVar.n();
            }
        }
    }

    public void setLoop(boolean z16) {
        b("setLoop %b", Boolean.valueOf(z16));
        this.S = z16;
    }

    public void setMinBufferDuration(long j3) {
        com.tencent.luggage.wxa.mg.g gVar = this.f134483c;
        if (gVar != null) {
            gVar.setMinBufferDuration(j3);
        }
    }

    public void setMute(boolean z16) {
        b("setMute %b", Boolean.valueOf(z16));
        this.f134492g0 = z16;
        this.f134483c.setMute(z16);
        this.f134489f.setMuteBtnState(z16);
    }

    public void setObjectFit(String str) {
        b("setObjectFit %s", str);
        if (CanvasView.CUSTOM_ACTION_FILL.equalsIgnoreCase(str)) {
            this.f134483c.setScaleType(g.h.FILL);
            this.C.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.f134483c.setScaleType(g.h.COVER);
            this.C.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            this.f134483c.setScaleType(g.h.CONTAIN);
            this.C.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void setPageGesture(boolean z16) {
        b("setPageGesture %b", Boolean.valueOf(z16));
        this.N = z16;
    }

    public void setPageGestureInFullscreen(boolean z16) {
        b("setPageGestureInFullscreen %b", Boolean.valueOf(z16));
        this.O = z16;
    }

    public void setPlayBtnPosition(String str) {
        b("setPlayBtnPosition %s", str);
        if (!w0.c(str) && str.equalsIgnoreCase("center")) {
            this.f134489f.setPlayBtnInCenterPosition(true);
        } else {
            this.f134489f.setPlayBtnInCenterPosition(false);
        }
    }

    public void setShowCenterPlayBtn(boolean z16) {
        int i3;
        g.a aVar;
        int i16 = 0;
        b("setShowCenterPlayBtn %b", Boolean.valueOf(z16));
        this.f134486d0 = z16;
        View view = this.f134491g;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.f134493h;
        if (!z16) {
            i16 = 8;
        }
        view2.setVisibility(i16);
        if (this.f134486d0 && (aVar = this.f134489f) != null) {
            aVar.n();
        }
    }

    public void setShowControlProgress(boolean z16) {
        boolean z17 = true;
        b("setShowControlProgress %b", Boolean.valueOf(z16));
        g.a aVar = this.f134489f;
        if (!z16 || k()) {
            z17 = false;
        }
        aVar.setShowControlProgress(z17);
    }

    public void setShowDanmakuBtn(boolean z16) {
        b("setShowDanmakuBtn %b", Boolean.valueOf(z16));
        if (z16) {
            if (this.f134487e == null) {
                f();
            }
            this.f134489f.setDanmakuBtnOnClickListener(new i());
        }
        this.f134489f.setShowDanmakuBtn(z16);
    }

    public void setShowFullScreenBtn(boolean z16) {
        b("setShowFullScreenBtn %b", Boolean.valueOf(z16));
        this.f134489f.setShowFullScreenBtn(z16);
    }

    public void setShowMuteBtn(boolean z16) {
        b("showMuteBtn %b", Boolean.valueOf(z16));
        this.f134489f.setShowMuteBtn(z16);
    }

    public void setShowPlayBtn(boolean z16) {
        b("setShowPlayBtn %b", Boolean.valueOf(z16));
        this.f134489f.setShowPlayBtn(z16);
    }

    public void setShowPoster(boolean z16) {
        int i3 = 0;
        b("setShowPoster %b", Boolean.valueOf(z16));
        View view = this.f134491g;
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void setShowProgress(boolean z16) {
        boolean z17 = true;
        b("setShowProgress %b", Boolean.valueOf(z16));
        this.f134482b0 = z16;
        g.a aVar = this.f134489f;
        if ((!z16 && !this.f134484c0) || k()) {
            z17 = false;
        }
        aVar.setShowProgress(z17);
    }

    public void setShowProgressBarInControlMode(boolean z16) {
        boolean z17 = true;
        b("setShowProgressInControlMode %b", Boolean.valueOf(z16));
        this.f134484c0 = z16;
        g.a aVar = this.f134489f;
        if ((!this.f134482b0 && !z16) || k()) {
            z17 = false;
        }
        aVar.setShowProgress(z17);
    }

    public void setTitle(String str) {
        b("setTitle %s", str);
        this.f134489f.setTitle(str);
    }

    public void setVideoContext(@NonNull com.tencent.luggage.wxa.mg.k kVar) {
        this.f134511t0 = kVar;
        com.tencent.luggage.wxa.mg.g gVar = this.f134483c;
        if (gVar != null) {
            gVar.setVideoContext(kVar);
        }
    }

    public void setVideoPlayerId(int i3) {
        this.H = i3;
    }

    public void setVideoSource(int i3) {
        b("setVideoSource %d", Integer.valueOf(i3));
        this.f134488e0 = i3;
    }

    public boolean d() {
        return this.M != null;
    }

    public final void e() {
        this.f134489f.d();
    }

    public final void f() {
        DanmuView danmuView = (DanmuView) findViewById(R.id.a3x);
        this.f134487e = danmuView;
        danmuView.setDanmuViewCallBack(new l());
        this.f134487e.b(0.0f, 0.8f);
        this.f134487e.setMaxRunningPerRow(5);
        this.f134487e.setPickItemInterval(200);
        this.f134487e.i();
        Object obj = this.f134483c;
        if (obj == null || ((View) obj).getHeight() <= 0) {
            return;
        }
        this.f134487e.setMaxRow((int) (((int) (this.f134487e.getYOffset() * ((View) this.f134483c).getHeight())) / com.tencent.luggage.wxa.ug.b.a(getContext())));
    }

    public final void g() {
        this.P = new com.tencent.luggage.wxa.dh.a(getContext(), this, new j());
    }

    public final void h() {
        this.f134483c.setIMMVideoViewCallback(new k());
    }

    public final boolean i() {
        return this.f134491g.getVisibility() == 0;
    }

    public boolean j() {
        p pVar = this.Q;
        if (pVar == null) {
            c("isInFullScreen mFullScreenDelegate null", new Object[0]);
            return false;
        }
        return pVar.isFullScreen();
    }

    public final boolean k() {
        return this.R || this.f134483c.i();
    }

    public void l() {
        b("onExitFullScreen", new Object[0]);
        if (this.f134489f.c()) {
            this.f134489f.quitFullScreen();
        }
        a(false);
    }

    public void m() {
        b("onUIDestroy", new Object[0]);
        c();
    }

    public void n() {
        this.f134483c.f();
    }

    public void o() {
        b("onUIResume", new Object[0]);
        if (this.f134502l0) {
            b("onUIResume, should skip ui resume", new Object[0]);
            this.f134502l0 = false;
        } else {
            this.f134483c.d();
        }
    }

    public void p() {
        b("pause", new Object[0]);
        if (!this.f134505n0) {
            b("pause, video not prepared", new Object[0]);
            this.f134506o0 = false;
        } else {
            if (!this.f134483c.isPlaying()) {
                b("pause, video not playing", new Object[0]);
                return;
            }
            this.f134483c.pause();
            if (this.f134487e == null || !this.f134489f.l()) {
                return;
            }
            this.f134487e.m();
        }
    }

    public final void q() {
        com.tencent.luggage.wxa.mg.g gVar = this.f134483c;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final boolean r() {
        if (this.f134496i0) {
            return true;
        }
        boolean b16 = b();
        if (a()) {
            return b16;
        }
        return false;
    }

    public final void s() {
        this.f134489f.g();
    }

    public void t() {
        b("start", new Object[0]);
        if (!this.f134505n0) {
            b("start, video not prepared", new Object[0]);
            this.f134506o0 = true;
        } else {
            b("start, video prepared, reset control flag", new Object[0]);
            this.f134506o0 = false;
        }
        if (this.f134483c.isPlaying()) {
            b("start, video is playing", new Object[0]);
            return;
        }
        if (this.L) {
            this.f134489f.k();
        }
        this.f134491g.setVisibility(8);
        this.f134483c.start();
        if (this.f134487e == null || !this.f134489f.l()) {
            return;
        }
        this.f134487e.p();
    }

    public final void u() {
        if (this.f134507p0 == null) {
            this.f134507p0 = new e0(new f(), true);
        }
        this.f134507p0.a(500L);
    }

    public void v() {
        b("stop", new Object[0]);
        if (!this.f134505n0) {
            b("stop, video not prepared", new Object[0]);
            this.f134506o0 = false;
        } else {
            if (!this.f134483c.isPlaying()) {
                b("stop, video not playing", new Object[0]);
                return;
            }
            this.f134483c.stop();
            this.f134489f.m();
            DanmuView danmuView = this.f134487e;
            if (danmuView != null) {
                danmuView.i();
            }
        }
    }

    public final void w() {
        e0 e0Var = this.f134507p0;
        if (e0Var != null) {
            e0Var.f();
        }
    }

    public final void x() {
        boolean f16 = this.f134489f.f();
        if (this.L && this.f134482b0 && this.f134504m0 && !f16 && !k() && !i()) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    public void c() {
        b("clean", new Object[0]);
        v();
        this.f134483c.g();
        DanmuView danmuView = this.f134487e;
        if (danmuView != null) {
            danmuView.b();
        }
        this.f134489f.onDestroy();
        w();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements g.c {
        public k() {
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void a(String str, String str2, String str3, int i3, int i16) {
            a.this.b("onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i3), Integer.valueOf(i16));
            if (a.this.M != null) {
                a.this.M.a(str3, i3, i16);
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.a(str, str2, str3, i3, i16);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void b(String str, String str2) {
            a.this.b("onVideoPause", new Object[0]);
            if (a.this.M != null) {
                a.this.M.h();
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.b(str, str2);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void c(String str, String str2) {
            a aVar = a.this;
            aVar.b("onVideoPlay, isLive:%b", Boolean.valueOf(aVar.k()));
            if (a.this.U <= 0 && !a.this.k()) {
                TextView textView = a.this.f134495i;
                a aVar2 = a.this;
                textView.setText(aVar2.a(aVar2.f134483c.getVideoDurationSec()));
            }
            a aVar3 = a.this;
            aVar3.c(aVar3.k());
            if (a.this.L) {
                a.this.x();
            }
            if (a.this.M != null) {
                a.this.M.i();
            }
            if (a.this.J != null && com.tencent.luggage.wxa.mg.o.a(a.this.J.getAppId())) {
                a.this.b("onVideoPlay, send play event", new Object[0]);
                new com.tencent.luggage.wxa.vg.a().c();
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.c(str, str2);
            }
            if (a.this.f134491g != null) {
                a.this.f134491g.setVisibility(8);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void d(String str, String str2) {
            a.this.b("onVideoWaiting", new Object[0]);
            if (a.this.M != null) {
                a.this.M.k();
            }
            a.this.f134494h0 = true;
            a.this.e();
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.d(str, str2);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void e(String str, String str2) {
            a.this.f134494h0 = false;
            a.this.s();
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.e(str, str2);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void f(String str, String str2) {
            a.this.b("onVideoEnded", new Object[0]);
            a.this.w();
            a.this.f134485d.setVisibility(8);
            a.this.f134489f.setIsPlay(false);
            if (a.this.f134489f.j() && a.this.f134489f.h()) {
                a.this.f134489f.n();
            }
            if (a.this.F.getVisibility() == 0) {
                a.this.F.setVisibility(8);
            }
            if (!a.this.k() && a.this.f134486d0) {
                if (a.this.U <= 0) {
                    TextView textView = a.this.f134495i;
                    a aVar = a.this;
                    textView.setText(aVar.a(aVar.f134483c.getVideoDurationSec()));
                }
                a.this.f134493h.setVisibility(0);
                a.this.f134491g.setVisibility(0);
            } else {
                a.this.f134493h.setVisibility(8);
                a.this.f134491g.setVisibility(8);
            }
            if (a.this.M != null) {
                a.this.M.g();
            }
            if (a.this.S) {
                a.this.a(0.0d, true);
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.f(str, str2);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void a(String str, String str2) {
            a.this.b("onPrepared", new Object[0]);
            a.this.f134508q0 = 0;
            a.this.u();
            a.this.f134505n0 = true;
            if (a.this.f134506o0) {
                a.this.t();
            }
            a.this.P.b();
            if (a.this.M != null) {
                a.this.M.j();
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.a(str, str2);
            }
        }

        @Override // com.tencent.luggage.wxa.mg.g.c
        public void a(String str, String str2, int i3, int i16) {
            a.this.b("onGetVideoSize width=%d height=%d", Integer.valueOf(i3), Integer.valueOf(i16));
            if (a.this.f134479a == -1) {
                a.this.f134479a = i3 < i16 ? 0 : 90;
                a aVar = a.this;
                aVar.b("onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(aVar.f134479a));
            }
            if (a.this.M != null) {
                a.this.M.a(i3, i16, a.this.getDuration());
            }
            if (a.this.f134510s0 != null) {
                a.this.f134510s0.a(str, str2, i3, i16);
            }
        }
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.dyt, this);
        setBackgroundColor(this.f134509r0);
        this.f134481b = (RelativeLayout) findViewById(R.id.kvb);
        this.f134485d = (TextView) findViewById(R.id.g1f);
        this.f134491g = findViewById(R.id.u_o);
        this.f134493h = findViewById(R.id.f164926ua4);
        this.f134495i = (TextView) findViewById(R.id.ua_);
        this.f134497j = (LinearLayout) findViewById(R.id.f164045se2);
        this.f134499k = (AppBrandDotPercentIndicator) findViewById(R.id.f164046se3);
        this.f134501l = (TextView) findViewById(R.id.f164043se0);
        this.f134503m = (ImageView) findViewById(R.id.f164044se1);
        this.C = (ImageView) findViewById(R.id.bat);
        this.D = (ImageView) findViewById(R.id.f25820bv);
        this.E = (ImageView) findViewById(R.id.f25810bu);
        this.F = (FrameLayout) findViewById(R.id.f25830bw);
        this.f134499k.setDotsNum(8);
        ((ImageView) findViewById(R.id.f164925ua3)).setOnClickListener(new g());
        g();
        h();
    }

    public void b(String str, String str2) {
        b("setCover:%s", str);
        if (w0.c(str)) {
            return;
        }
        this.V = str;
        AppBrandSimpleImageLoader.instance().attach(this.C, str, (Drawable) null, (AppBrandSimpleImageLoader.j) null);
    }

    public void b(boolean z16) {
        b("enableProgressGesture %b", Boolean.valueOf(z16));
        this.f134480a0 = z16;
    }

    public final String b(int i3) {
        if (i3 < 10) {
            return "0" + i3;
        }
        return i3 + "";
    }

    public final void c(boolean z16) {
        b("updateLiveUI isLive:%b", Boolean.valueOf(z16));
        this.f134489f.setShowProgress((this.f134482b0 || this.f134484c0) && !z16);
    }

    public final boolean b() {
        return (!this.f134480a0 || this.f134483c.i() || i()) ? false : true;
    }

    public final void c(String str, Object... objArr) {
        w.h("MicroMsg.Video.AppBrandVideoView", this.f134511t0 + " " + str, objArr);
    }

    public final void b(String str, Object... objArr) {
        w.d("MicroMsg.Video.AppBrandVideoView", this.f134511t0 + " " + str, objArr);
    }

    public void a(e.d dVar) {
        b("onUIPause, type:%s", dVar);
        r a16 = com.tencent.luggage.wxa.p004if.g.f130201b.a(this.f134498j0, this.f134500k0);
        b("onUIPause, autoPauseStrategy: %s", a16);
        if (!a16.a(this.J, dVar)) {
            b("onUIPause, should skip ui pause", new Object[0]);
            this.f134502l0 = true;
        } else {
            n();
        }
    }

    public void a(String str, boolean z16, int i3) {
        com.tencent.luggage.wxa.xd.d dVar = this.J;
        if (dVar != null && dVar.getFileSystem() != null && this.J.getFileSystem().accept(str)) {
            v absoluteFile = this.J.getFileSystem().getAbsoluteFile(str);
            if (absoluteFile == null) {
                str = null;
            } else {
                str = "file://" + absoluteFile.g();
            }
        }
        b("setVideoPath path=%s isLive=%s", str, Boolean.valueOf(z16));
        if (w0.c(str)) {
            return;
        }
        v();
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.mg.j.class));
        this.R = z16;
        this.f134490f0 = str;
        this.f134483c.setVideoSource(this.f134488e0);
        this.f134483c.a(z16, str, i3);
        double d16 = this.T;
        if (d16 > 0.0d) {
            this.f134483c.a(d16, this.K);
        }
        if (this.f134488e0 == 1) {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.mg.j.class));
        }
        if (this.K) {
            b("setVideoPath autoPlay true", new Object[0]);
            t();
        } else {
            b("setVideoPath autoPlay false", new Object[0]);
            q();
        }
        setCover(str);
    }

    public void a(double d16) {
        a(d16, false);
    }

    public void a(double d16, boolean z16) {
        int currPosSec = this.f134483c.getCurrPosSec();
        b("seek to position=%s current=%d isLive=%b", Double.valueOf(d16), Integer.valueOf(currPosSec), Boolean.valueOf(this.R));
        if (k()) {
            return;
        }
        this.f134491g.setVisibility(8);
        if (z16) {
            this.f134483c.a(d16, z16);
        } else {
            this.f134483c.a(d16);
        }
        DanmuView danmuView = this.f134487e;
        if (danmuView == null || currPosSec <= d16) {
            return;
        }
        danmuView.a((int) d16);
    }

    public boolean a(String str, String str2) {
        if (this.f134487e == null) {
            c(" addDanmaku mDanmakuView null", new Object[0]);
            f();
        }
        int a16 = com.tencent.luggage.wxa.tk.g.a(str2);
        if (a16 == 0) {
            a16 = -1;
        }
        this.f134487e.a(new com.tencent.luggage.wxa.ug.a(getContext(), new SpannableString(str), a16, 0, 3.0f, this.f134483c.getCurrPosSec()));
        return true;
    }

    public final com.tencent.luggage.wxa.ug.d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("time", 0);
        String optString = jSONObject.optString("text", "");
        int a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("color", ""));
        if (a16 == 0) {
            a16 = -1;
        }
        return new com.tencent.luggage.wxa.ug.a(getContext(), new SpannableString(optString), a16, 0, 3.0f, optInt);
    }

    public void a(boolean z16, int i3) {
        b("operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z16), Integer.valueOf(i3));
        if (this.Q == null) {
            c("operateFullScreen mFullScreenDelegate null", new Object[0]);
            return;
        }
        if (z16 == j()) {
            b("operateFullScreen current same", new Object[0]);
            return;
        }
        if (i3 == -1) {
            i3 = this.f134479a;
            if (i3 == -1) {
                i3 = 90;
            }
            b("operateFullScreen target direction:%d", Integer.valueOf(i3));
        }
        if (z16) {
            this.f134512u0 = i3;
            this.Q.enterFullScreen(i3);
            this.f134489f.e();
            a(true);
            return;
        }
        this.Q.quitFullScreen();
        this.f134489f.quitFullScreen();
    }

    public boolean a(float f16) {
        b("setPlaybackRate %s", Float.valueOf(f16));
        return this.f134483c.a(f16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(g.a aVar) {
        this.f134489f = aVar;
        if ((aVar instanceof View) && aVar != 0) {
            View view = (View) aVar;
            if (view.getId() != -1) {
                view.setId(R.id.sta);
            }
        }
        this.f134489f.n();
        this.f134489f.setFullScreenBtnOnClickListener(new m());
        this.f134489f.setIplaySeekCallback(new n());
        this.f134489f.setOnPlayButtonClickListener(new o());
        this.f134489f.setStatePorter(new C6473a());
        this.f134489f.setMuteBtnOnClickListener(new b());
        this.f134489f.setExitFullScreenBtnOnClickListener(new c());
        this.f134489f.a(new d());
        this.f134489f.setOnUpdateProgressLenListener(new e());
    }

    public final String a(int i3) {
        return b(i3 / 60) + ":" + b(i3 % 60);
    }

    public final void a(boolean z16) {
        com.tencent.luggage.wxa.vg.b bVar = this.M;
        if (bVar == null) {
            return;
        }
        bVar.a(this.H, z16, this.f134512u0);
    }

    public final boolean a() {
        return !i() && ((!j() && this.N) || (j() && this.O));
    }

    public final void a(String str, Object... objArr) {
        w.a("MicroMsg.Video.AppBrandVideoView", this.f134511t0 + " " + str, objArr);
    }
}

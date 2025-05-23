package fo3;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.now.pkgame.b;
import com.tencent.now.pkgame.pkgame.animation.AnimationView;
import com.tencent.now.pkgame.pkgame.event.NormalLinkMicEvent;
import com.tencent.now.pkgame.pkgame.event.PKLinkMicEvent;
import com.tencent.now.pkgame.pkgame.pkresultview.PkResultView;
import com.tencent.now.pkgame.pkgame.pktimer.PkTimerView;
import com.tencent.now.pkgame.pkgame.pktoprank.PkTopRankView;
import com.tencent.now.pkgame.pkgame.scorebar.view.WholeScoreBarView;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import hn3.LinkScreenAnchorInfo;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import or4.g;
import or4.j;
import or4.k;
import or4.l;
import qo3.SeiConfig;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements LifecycleOwner, ViewModelStoreOwner, com.tencent.now.pkgame.linkandpkobserver.a {
    private FrameLayout C;
    private List<lo3.a> D;
    private com.tencent.now.pkgame.pkgame.pklib.model.e E;
    private FrameLayout F;
    private fo3.b G;
    private long M;
    private com.tencent.now.pkgame.linkandpkobserver.b R;
    private do3.b S;
    private f T;
    private com.tencent.now.pkgame.b V;
    private com.tencent.now.pkgame.a W;

    /* renamed from: h, reason: collision with root package name */
    private Context f400189h;

    /* renamed from: i, reason: collision with root package name */
    private long f400190i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f400191m;

    /* renamed from: d, reason: collision with root package name */
    private ViewModelStore f400186d = new ViewModelStore();

    /* renamed from: e, reason: collision with root package name */
    private LifecycleRegistry f400187e = new LifecycleRegistry(this);

    /* renamed from: f, reason: collision with root package name */
    private ViewModelProvider f400188f = new ViewModelProvider(this);
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private go3.a N = new go3.a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    private int P = -1;
    private c Q = new c();
    private com.tencent.now.pkgame.linkandpkobserver.audience.b U = new com.tencent.now.pkgame.linkandpkobserver.audience.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ko3.c<g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f400192a;

        a(long j3) {
            this.f400192a = j3;
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(g gVar) {
            l lVar;
            boolean z16 = false;
            if (gVar != null && e.this.I) {
                j jVar = gVar.f423493h;
                if (jVar != null && (lVar = jVar.f423499b) != null) {
                    int i3 = lVar.f423519a;
                    int i16 = jVar.f423500c.f423475a;
                    e.this.P = i16;
                    k[] kVarArr = gVar.f423489d;
                    if (kVarArr != null && kVarArr.length > 0) {
                        z16 = true;
                    }
                    AegisLogger.i("PK_Biz|PkGameLogic", "checkLinkMicBiz", "LinkMicBusId: " + i16 + ", isLinkMic: " + z16);
                    if (z16) {
                        com.tencent.now.linkscreengame.model.a aVar = com.tencent.now.linkscreengame.model.a.f338500a;
                        if (aVar.b(i3, i16)) {
                            LinkScreenAnchorInfo a16 = aVar.a(this.f400192a, gVar);
                            if (e.this.S != null) {
                                e.this.K = true;
                                fo3.a aVar2 = new fo3.a(e.this.f400189h, a16, e.this.E.n(), e.this.E.p());
                                e eVar = e.this;
                                eVar.T = f.m(eVar.f400189h, e.this.N.b(), e.this.N.d(), e.this.F.getHeight(), e.this.F.getWidth(), e.this.f400191m);
                                e.this.S.h(a16, e.this.G, aVar2, e.this.U, e.this.T);
                                if (e.this.W != null) {
                                    e.this.W.b(e.this.T.a());
                                }
                            }
                            e.this.P();
                            return;
                        }
                        if ((i16 != 0 && 3 != i16) || !e.this.N.e() || e.this.L) {
                            return;
                        }
                        e eVar2 = e.this;
                        eVar2.L = eVar2.N.e();
                        SimpleEventBus.getInstance().dispatchEvent(new NormalLinkMicEvent(i16, e.this.N));
                        return;
                    }
                    return;
                }
                AegisLogger.e("PK_Biz|PkGameLogic", "checkLinkMicBiz", "linkConfig or model is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("data is null: ");
            if (gVar == null) {
                z16 = true;
            }
            sb5.append(z16);
            sb5.append(", mHasEnterRoom: ");
            sb5.append(e.this.I);
            AegisLogger.e("PK_Biz|PkGameLogic", "checkLinkMicBiz", sb5.toString());
        }

        @Override // ko3.c
        public void fail(int i3, String str) {
            AegisLogger.e("PK_Biz|PkGameLogic", "getLinkMicInfo", "fail, code: " + i3 + ", msg: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements b.InterfaceC9249b {
        b() {
        }

        @Override // com.tencent.now.pkgame.b.InterfaceC9249b
        public void a(boolean z16, int i3, long j3) {
            if (!e.this.S.f()) {
                AegisLogger.e("PK_Biz|PkGameLogic", "checkPKInfo", "\u4e0d\u5728\u8fde\u5c4f\u72b6\u6001\uff0c\u4e0d\u5c55\u793aPK\u754c\u9762\u3002");
                return;
            }
            if (z16 && e.this.D.size() == 0) {
                AegisLogger.i("PK_Biz|PkGameLogic", "initPkViews, pkType: " + i3);
                e.this.E.x(i3);
                e.this.I(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private View f400195d;

        /* renamed from: e, reason: collision with root package name */
        private int f400196e;

        /* renamed from: f, reason: collision with root package name */
        private int f400197f;

        c() {
        }

        public void a(View view) {
            this.f400195d = view;
            this.f400196e = view.getWidth();
            this.f400197f = view.getHeight();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.f400195d.getWidth();
            int height = this.f400195d.getHeight();
            if (this.f400196e != width || this.f400197f != height) {
                AegisLogger.i("PK_Biz|PkGameLogic", "LayoutChange originWidth:" + this.f400196e + ", originHeight:" + this.f400197f + ", width:" + width + ", height:" + height);
                this.f400196e = width;
                this.f400197f = height;
                e.this.J = false;
                e.this.K = false;
                e.this.T();
                e.this.P();
            }
        }
    }

    public e(com.tencent.now.pkgame.a aVar) {
        this.W = aVar;
    }

    private void A() {
        FrameLayout frameLayout = this.C;
        if (frameLayout != null && this.F != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.width = this.F.getMeasuredWidth();
            if (this.F.getMeasuredWidth() <= 0) {
                return;
            }
            layoutParams.height = -1;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
            }
            this.C.setLayoutParams(layoutParams);
            this.S.g(layoutParams);
        }
    }

    private void B(long j3, long j16) {
        if (!this.K && SystemClock.elapsedRealtime() - this.M >= 5000) {
            this.M = SystemClock.elapsedRealtime();
            AegisLogger.i("PK_Biz|PkGameLogic", "start checkLinkMicBiz roomId: " + j3 + ", anchorId: " + j16);
            this.E.k(j3, j16, new a(j16));
        }
    }

    private void C(long j3, long j16) {
        if (this.D.size() > 0) {
            return;
        }
        this.V.f(j3, j16, new b());
    }

    private void D(Context context, Pos pos, i iVar, int i3, int i16) {
        AegisLogger.i("PK_Biz|PkGameLogic", "\u5f00\u59cb\u8fde\u9ea6, pos:" + pos + ", videoSize:" + iVar + ", liveViewHeight:" + i3 + ",liveViewWidth=" + i16);
        this.f400187e.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f400187e.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        G(context, pos, iVar, i3, i16);
    }

    private void E() {
        if (this.f400187e.getCurrentState() != Lifecycle.State.INITIALIZED) {
            this.f400187e.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        this.E.j().e();
        this.E.t(!this.H);
        F();
    }

    private void F() {
        this.C.removeAllViews();
        this.D.clear();
    }

    private void G(Context context, Pos pos, i iVar, int i3, int i16) {
        this.C.getLayoutParams().width = i16;
        f m3 = f.m(context, pos, iVar, i3, i16, this.f400191m);
        AnimationView d16 = m3.d(context, this.f400188f, new LifecycleOwner() { // from class: fo3.d
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return e.this.getLifecycle();
            }
        });
        WholeScoreBarView l3 = m3.l(context, this.f400188f, new LifecycleOwner() { // from class: fo3.d
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return e.this.getLifecycle();
            }
        });
        PkTimerView g16 = m3.g(this.f400188f, new LifecycleOwner() { // from class: fo3.d
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return e.this.getLifecycle();
            }
        });
        PkTopRankView h16 = m3.h(context, this.f400188f, new LifecycleOwner() { // from class: fo3.d
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return e.this.getLifecycle();
            }
        });
        PkResultView f16 = m3.f(context, this.f400188f, new LifecycleOwner() { // from class: fo3.d
            @Override // androidx.lifecycle.LifecycleOwner
            public final Lifecycle getLifecycle() {
                return e.this.getLifecycle();
            }
        });
        z(d16);
        z(g16);
        z(l3);
        z(h16);
        z(f16);
        this.E.r();
    }

    private void H() {
        if (L()) {
            return;
        }
        D(this.f400189h, this.N.b(), this.N.d(), this.F.getHeight(), this.F.getWidth());
        SimpleEventBus.getInstance().dispatchEvent(new PKLinkMicEvent(8, this.N));
        this.Q.a(this.F);
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i3) {
        this.J = true;
        T();
    }

    private boolean L() {
        List<lo3.a> list = this.D;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        do3.b bVar = this.S;
        if (bVar == null) {
            return;
        }
        if (this.H && this.I && this.K) {
            bVar.i();
            return;
        }
        bVar.d();
        com.tencent.now.pkgame.a aVar = this.W;
        if (aVar != null) {
            aVar.a();
        }
        this.K = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        AegisLogger.i("PK_Biz|PkGameLogic", "onPkLogic mIsInPage=" + this.H + " mIsInRoom=" + this.I + " mIsInLinkScreen=" + this.K + " mIsInPk=" + this.J);
        if (this.H && this.I && this.K && this.J) {
            H();
        } else {
            U();
        }
    }

    private void U() {
        if (!L()) {
            return;
        }
        this.J = false;
        E();
        SimpleEventBus.getInstance().dispatchEvent(new PKLinkMicEvent(-1, null));
        this.F.getViewTreeObserver().removeOnGlobalLayoutListener(this.Q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(lo3.a aVar) {
        if (aVar.J() != null) {
            aVar.J().R1(this.E);
        }
        this.C.addView((View) aVar);
        this.D.add(aVar);
    }

    public boolean J() {
        return this.I;
    }

    public boolean K() {
        com.tencent.now.pkgame.pkgame.pklib.model.e eVar = this.E;
        if (eVar != null && eVar.i() != null) {
            return this.E.i().b();
        }
        return false;
    }

    public boolean M() {
        return this.E.i().c();
    }

    public void N() {
        AegisLogger.i("PK_Biz|PkGameLogic", "onEnterRoom, roomId: " + this.f400190i);
        this.I = true;
        this.E.u(this.G.getAnchorId());
        this.E.w(this.f400190i);
        this.E.j().b();
        com.tencent.now.pkgame.linkandpkobserver.b a16 = new com.tencent.now.pkgame.linkandpkobserver.c().a(this.f400189h, this.f400191m, this.f400190i, this.G.getAnchorId(), this.U);
        this.R = a16;
        a16.a(this.E);
        this.R.c(this);
        A();
        T();
    }

    public void O(VideoSeiInfo videoSeiInfo) {
        if (this.I && !this.f400191m && (this.R instanceof com.tencent.now.pkgame.linkandpkobserver.audience.a)) {
            this.U.g(videoSeiInfo, this.f400190i);
            this.N = this.U.getLinkMicBean();
        }
    }

    public void Q(boolean z16) {
        A();
    }

    public void R(Context context, fo3.b bVar) {
        AegisLogger.i("PK_Biz|PkGameLogic", "onPageIn, hashCode:" + hashCode() + ", isHighDevice:" + DeviceInfoUtils.isHighPerfDevice());
        this.H = true;
        com.tencent.now.pkgame.pkgame.animation.f.f338957a.d();
        if (this.f400187e.getCurrentState() == Lifecycle.State.INITIALIZED) {
            this.f400187e.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
        this.f400189h = context;
        this.G = bVar;
        com.tencent.now.pkgame.pkgame.pklib.model.e eVar = new com.tencent.now.pkgame.pkgame.pklib.model.e(bVar.getRoomId());
        this.E = eVar;
        eVar.y(bVar.a());
        this.E.z(bVar.c());
        this.D = new ArrayList();
        FrameLayout b16 = bVar.b();
        b16.removeAllViews();
        this.C = new FrameLayout(context);
        this.C.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.C.removeAllViews();
        this.V = new com.tencent.now.pkgame.b();
        this.f400190i = bVar.getRoomId();
        this.f400191m = bVar.d();
        this.F = bVar.e();
        this.S = new do3.b(this.f400189h, this.f400190i, this.f400191m, b16);
        b16.addView(this.C);
        T();
    }

    public void S() {
        AegisLogger.i("PK_Biz|PkGameLogic", "onPageOut, hashCode:" + hashCode());
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = false;
        this.K = false;
        this.P = -1;
        if (this.f400187e.getCurrentState() != Lifecycle.State.INITIALIZED) {
            this.f400187e.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        com.tencent.now.pkgame.pkgame.pklib.model.e eVar = this.E;
        if (eVar != null) {
            eVar.j().c();
        }
        com.tencent.now.pkgame.linkandpkobserver.b bVar = this.R;
        if (bVar != null) {
            bVar.b();
        }
        T();
        P();
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.a
    public void a() {
        AegisLogger.i("PK_Biz|PkGameLogic", "IObserverResult onLinkMicOff, roomId:" + this.f400190i);
        this.N = new go3.a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        this.K = false;
        this.P = -1;
        T();
        P();
        if (this.L) {
            this.L = false;
            SimpleEventBus.getInstance().dispatchEvent(new NormalLinkMicEvent(-1, null));
        }
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.a
    public void b(SeiConfig seiConfig) {
        B(this.f400190i, this.G.getAnchorId());
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.a
    public void d() {
        AegisLogger.i("PK_Biz|PkGameLogic", "IObserverResult onPKEnd, roomId:" + this.f400190i);
        this.J = false;
        T();
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.a
    public void e(int i3, @Nullable e55.c cVar, long j3, int i16) {
        AegisLogger.i("PK_Biz|PkGameLogic", "IObserverResult onPKStart, pkAnchorNick:" + cVar.f395737c);
        C(this.f400190i, this.E.h());
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f400187e;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        return this.f400186d;
    }
}

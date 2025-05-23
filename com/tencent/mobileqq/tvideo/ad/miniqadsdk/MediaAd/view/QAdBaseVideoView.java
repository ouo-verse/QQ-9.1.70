package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.AdConstants$ViewState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.QAdInsideAdConstance$DetailViewType;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdVideoAdDetailView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoTitle;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class QAdBaseVideoView extends FrameLayout implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.a {
    protected xu2.a C;
    private AdInsideVideoRequest D;
    protected AdInsideVideoItem E;
    protected InsideVideoSkipAdInfo F;
    private int G;
    protected int H;
    protected boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private AdConstants$ViewState N;
    private int P;
    protected boolean Q;
    protected QAdStandardClickReportInfo.ClickExtraInfo R;
    protected int S;
    private Handler T;
    protected Map<String, View> U;
    protected int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f303683a0;

    /* renamed from: b0, reason: collision with root package name */
    private final View.OnClickListener f303684b0;

    /* renamed from: c0, reason: collision with root package name */
    private View.OnClickListener f303685c0;

    /* renamed from: d, reason: collision with root package name */
    protected View f303686d;

    /* renamed from: d0, reason: collision with root package name */
    private float f303687d0;

    /* renamed from: e, reason: collision with root package name */
    protected QAdBaseCountDownView f303688e;

    /* renamed from: e0, reason: collision with root package name */
    private float f303689e0;

    /* renamed from: f, reason: collision with root package name */
    protected View f303690f;

    /* renamed from: f0, reason: collision with root package name */
    private float f303691f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f303692g0;

    /* renamed from: h, reason: collision with root package name */
    protected FrameLayout f303693h;

    /* renamed from: h0, reason: collision with root package name */
    private long f303694h0;

    /* renamed from: i, reason: collision with root package name */
    protected QAdBaseVideoAdDetailView f303695i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f303696m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public enum SkipCause {
        USER_SKIP,
        USER_RETURN,
        REQUEST_TIMEOUT,
        APP_CLOSE,
        PLAY_FAILED,
        PLAY_STUCK,
        FORCE_SKIP,
        OTHER_REASON
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QAdBaseVideoView.this.G()) {
                n.e("[MediaAd]QAdBaseVideoView", "isFullScreenClickableAd=false");
            } else {
                QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
                if (!qAdBaseVideoView.I) {
                    n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
                } else {
                    qAdBaseVideoView.R(1014);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
            if (!qAdBaseVideoView.I) {
                n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
            } else {
                qAdBaseVideoView.E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.h
                    @Override // pw2.f
                    public final void invoke(Object obj) {
                        ((xu2.a) obj).f();
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
            if (!qAdBaseVideoView.I) {
                n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
            } else {
                qAdBaseVideoView.E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.i
                    @Override // pw2.f
                    public final void invoke(Object obj) {
                        ((xu2.a) obj).e();
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
            if (!qAdBaseVideoView.I) {
                n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
            } else {
                qAdBaseVideoView.E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.j
                    @Override // pw2.f
                    public final void invoke(Object obj) {
                        ((xu2.a) obj).a();
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
            if (!qAdBaseVideoView.I) {
                n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
            } else {
                qAdBaseVideoView.R(1021);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QAdBaseVideoView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        return yu2.b.D(this.E);
    }

    private boolean I() {
        if (System.currentTimeMillis() - this.f303694h0 > 50) {
            if (this.f303691f0 > 20.0f || this.f303692g0 > 20.0f) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean K(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f303691f0 += Math.abs(motionEvent.getX() - this.f303687d0);
                    this.f303692g0 += Math.abs(motionEvent.getY() - this.f303689e0);
                    this.f303687d0 = motionEvent.getX();
                    this.f303689e0 = motionEvent.getY();
                }
            } else {
                return I();
            }
        } else {
            this.f303687d0 = motionEvent.getX();
            this.f303689e0 = motionEvent.getY();
            this.f303691f0 = 0.0f;
            this.f303692g0 = 0.0f;
            this.f303694h0 = System.currentTimeMillis();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.I) {
            n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
        } else {
            E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.f
                @Override // pw2.f
                public final void invoke(Object obj) {
                    ((xu2.a) obj).b();
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.I) {
            n.h("[MediaAd]QAdBaseVideoView", "doClick failed because mIsEnableClick is false !");
        } else {
            E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.g
                @Override // pw2.f
                public final void invoke(Object obj) {
                    ((xu2.a) obj).c();
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(int i3, xu2.a aVar) {
        Q();
        aVar.d(this.R, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        n.a("[MediaAd]QAdBaseVideoView", "remove");
        synchronized (this) {
            QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView = this.f303695i;
            if (qAdBaseVideoAdDetailView != null) {
                qAdBaseVideoAdDetailView.b();
            }
        }
        if (getParent() != null) {
            removeAllViews();
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void W() {
        n.a("[MediaAd]QAdBaseVideoView", "[CLICK]QAdPrerollView");
        setOnClickListener(new a());
    }

    private void c0() {
        if (this.f303695i == null) {
            return;
        }
        n.a("[MediaAd]QAdBaseVideoView", "[DetailView] UPDATE");
        AdInsideVideoItem adInsideVideoItem = this.E;
        if (adInsideVideoItem != null) {
            this.f303695i.t(adInsideVideoItem);
        }
        this.f303695i.setOnClickListener(new f());
    }

    private void d0() {
        TextView r16 = r();
        if (r16 == null) {
            return;
        }
        String q16 = q();
        if (!TextUtils.isEmpty(q16)) {
            r16.setText(q16);
            r16.setVisibility(0);
        } else {
            r16.setVisibility(8);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void h0() {
        n.a("[MediaAd]QAdBaseVideoView", "[RIGHTBOTTOM] UPDATE");
        c0();
        g0();
        View view = this.f303690f;
        if (view != null) {
            view.setOnTouchListener(new e());
        }
    }

    private void i0(AdInsideVideoItem adInsideVideoItem, int i3, int i16) {
        int i17;
        if (yu2.b.X(adInsideVideoItem)) {
            i17 = (int) Math.round(((adInsideVideoItem.videoPoster.skipAdDuration * 1000) - s(adInsideVideoItem, i3, i16)) / 1000.0d);
        } else {
            i17 = -1;
        }
        if (i17 > 0) {
            this.Q = false;
        } else {
            this.Q = true;
            i17 = 0;
        }
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.p(yu2.b.X(this.E), i17);
        }
    }

    private boolean o(MotionEvent motionEvent) {
        if (K(motionEvent)) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    private String q() {
        AdInsideVideoPoster adInsideVideoPoster;
        AdInsideVideoTitle adInsideVideoTitle;
        AdInsideVideoItem adInsideVideoItem = this.E;
        if (adInsideVideoItem != null && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && (adInsideVideoTitle = adInsideVideoPoster.titleInfo) != null) {
            return adInsideVideoTitle.dspName;
        }
        return null;
    }

    private int s(AdInsideVideoItem adInsideVideoItem, int i3, int i16) {
        if (yu2.b.L(adInsideVideoItem) && yu2.b.M(adInsideVideoItem)) {
            return i16;
        }
        return i3;
    }

    private void v(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            requestDisallowInterceptTouchEvent(false);
        }
    }

    public void A(InsideVideoSkipAdInfo insideVideoSkipAdInfo, AdInsideVideoItem adInsideVideoItem) {
        this.F = insideVideoSkipAdInfo;
    }

    public void B(@QAdInsideAdConstance$DetailViewType int i3) {
        if (this.f303693h == null) {
            return;
        }
        QAdVideoAdDetailView qAdVideoAdDetailView = new QAdVideoAdDetailView(this.f303696m);
        n.a("[MediaAd]QAdBaseVideoView", "switchDetailView \u5207\u6362\u884c\u52a8\u6309\u94ae\uff0c" + QAdVideoAdDetailView.class.getSimpleName());
        qAdVideoAdDetailView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f303693h.addView(qAdVideoAdDetailView);
        this.f303695i = qAdVideoAdDetailView;
        k0(QAdVrReport.ElementID.AD_ACTION_BTN, qAdVideoAdDetailView);
        c0();
        g0();
    }

    protected void C() {
        HashMap hashMap = new HashMap();
        this.U = hashMap;
        hashMap.put(QAdVrReport.ElementID.AD_ACTION_BTN, this.f303695i);
        this.U.put(QAdVrReport.ElementID.AD_POSTER, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(Context context) {
        W();
    }

    protected final void E(@NonNull pw2.f<xu2.a> fVar) {
        xu2.a aVar = this.C;
        if (aVar != null) {
            fVar.invoke(aVar);
        }
    }

    public boolean F() {
        Context context = this.f303696m;
        if (context != null && y.k(context)) {
            return true;
        }
        return false;
    }

    @MainThread
    public boolean H() {
        return y.k(this.f303696m);
    }

    public void J(boolean z16) {
        this.M = z16;
    }

    public boolean L() {
        return this.Q;
    }

    protected void Q() {
        QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo = this.R;
        if (clickExtraInfo != null) {
            clickExtraInfo.width = getMeasuredWidth();
            this.R.height = getMeasuredHeight();
        }
    }

    protected void R(final int i3) {
        E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.d
            @Override // pw2.f
            public final void invoke(Object obj) {
                QAdBaseVideoView.this.O(i3, (xu2.a) obj);
            }
        });
    }

    public void T() {
        n.a("[MediaAd]QAdBaseVideoView", "remove");
        this.N = AdConstants$ViewState.REMOVED;
        this.T.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                QAdBaseVideoView.this.U();
            }
        });
    }

    public void V() {
        d0();
    }

    public void X() {
        QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView = this.f303695i;
        if (qAdBaseVideoAdDetailView != null && !qAdBaseVideoAdDetailView.isShown() && this.K == -1) {
            n.a("[MediaAd]QAdBaseVideoView", "[DetailView] SHOW");
            this.f303695i.setVisibility(0);
            AdInsideVideoItem adInsideVideoItem = this.E;
            if (adInsideVideoItem != null) {
                this.f303695i.t(adInsideVideoItem);
            }
        }
    }

    public void Y() {
        QAdBaseCountDownView qAdBaseCountDownView;
        AdInsideVideoItem adInsideVideoItem = this.E;
        if (adInsideVideoItem != null && (qAdBaseCountDownView = this.f303688e) != null) {
            qAdBaseCountDownView.k(adInsideVideoItem.videoPoster, adInsideVideoItem.adSubType, this.L, this.M);
        }
    }

    public void Z(int i3, int i16, int i17) {
        AdInsideVideoItem adInsideVideoItem = this.E;
        if (adInsideVideoItem != null && adInsideVideoItem.videoPoster != null && this.L && this.K != 1 && !this.Q) {
            i0(adInsideVideoItem, i3, i16);
        }
        if (i17 >= 0 && i17 < this.G) {
            this.G = i17;
            QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
            if (qAdBaseCountDownView != null) {
                qAdBaseCountDownView.j(i17);
            }
        }
        this.S = i16;
    }

    protected void a0() {
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.setWarnerOnClickListener(new b());
            this.f303688e.setSkipTipOnClickListener(new c());
            this.f303688e.setonVipTipClickListener(this.f303684b0);
            this.f303688e.setMultiTrueViewLeftTipListener(this.f303685c0);
            this.f303688e.setEnterVipOnClickListener(new d());
            this.f303688e.setCanShowSkipCountDown(this.L);
        }
        Y();
    }

    public void b0(int i3) {
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.o(Math.max(0, i3));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (this.R == null) {
            this.R = new QAdStandardClickReportInfo.ClickExtraInfo();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.R.upX = ((int) motionEvent.getRawX()) - i3;
                this.R.upY = ((int) motionEvent.getRawY()) - i16;
                this.R.playTime = this.S;
            }
        } else {
            this.R.downX = ((int) motionEvent.getRawX()) - i3;
            this.R.downY = ((int) motionEvent.getRawY()) - i16;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void j0() {
        d0();
        a0();
        h0();
        e0();
    }

    protected void k0(@Nullable String str, @Nullable View view) {
        Map<String, View> map;
        if (!TextUtils.isEmpty(str) && view != null && (map = this.U) != null) {
            map.put(str, view);
        }
    }

    public void l(ViewGroup viewGroup) {
        if (viewGroup != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            setFocusable(true);
            requestFocus();
            viewGroup.addView(this, layoutParams);
        }
    }

    public void m() {
        n.a("[MediaAd]QAdBaseVideoView", "close");
        AdConstants$ViewState adConstants$ViewState = this.N;
        AdConstants$ViewState adConstants$ViewState2 = AdConstants$ViewState.CLOSED;
        if (adConstants$ViewState != adConstants$ViewState2) {
            n.a("[MediaAd]QAdBaseVideoView", AudioContext.State.CLOSED);
            this.T.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.5
                @Override // java.lang.Runnable
                public void run() {
                    QAdBaseVideoView.this.U();
                }
            });
            this.N = adConstants$ViewState2;
        }
    }

    public void n() {
        this.T.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                QAdBaseVideoView.this.N = AdConstants$ViewState.DESTROYED;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(final int i3, final int i16, final int i17, final int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        pw2.g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                int g16 = y.g(QAdBaseVideoView.this.getContext());
                boolean H = QAdBaseVideoView.this.H();
                n.a("[MediaAd]QAdBaseVideoView", "onSizeChanged orientation: " + g16 + ", size w: " + i3 + ", h: " + i16 + ", oldw: " + i17 + ", oldh: " + i18 + ", width: " + QAdBaseVideoView.this.getWidth() + ", height: " + QAdBaseVideoView.this.getHeight() + ", maxHeight: " + QAdBaseVideoView.this.W + ", isFull=" + H);
                if (!H) {
                    QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
                    qAdBaseVideoView.W = Math.max(qAdBaseVideoView.W, QAdBaseVideoView.this.getHeight());
                }
            }
        });
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f303696m == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.J) {
            return o(motionEvent);
        }
        v(motionEvent);
        if (!G()) {
            return true;
        }
        return o(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(final int i3) {
        super.onWindowVisibilityChanged(i3);
        E(new pw2.f() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.e
            @Override // pw2.f
            public final void invoke(Object obj) {
                ((xu2.a) obj).onWindowVisibilityChanged(i3);
            }
        });
    }

    public View p() {
        return this.f303688e;
    }

    protected abstract TextView r();

    public void setAdItem(AdInsideVideoItem adInsideVideoItem) {
        this.E = adInsideVideoItem;
        this.P = 0;
        QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView = this.f303695i;
        if (qAdBaseVideoAdDetailView != null) {
            qAdBaseVideoAdDetailView.i();
        }
        pw2.g.a(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                QAdBaseVideoView qAdBaseVideoView = QAdBaseVideoView.this;
                qAdBaseVideoView.setClickable(qAdBaseVideoView.G());
                QAdBaseVideoView qAdBaseVideoView2 = QAdBaseVideoView.this;
                QAdBaseCountDownView qAdBaseCountDownView = qAdBaseVideoView2.f303688e;
                if (qAdBaseCountDownView != null) {
                    AdInsideVideoItem adInsideVideoItem2 = qAdBaseVideoView2.E;
                    qAdBaseCountDownView.k(adInsideVideoItem2.videoPoster, adInsideVideoItem2.adSubType, qAdBaseVideoView2.L, QAdBaseVideoView.this.M);
                    QAdBaseVideoView.this.Q = false;
                }
                n.a("[MediaAd]QAdBaseVideoView", "setAdItem orientation: " + y.g(QAdBaseVideoView.this.getContext()) + ", isFull=" + QAdBaseVideoView.this.H());
            }
        });
    }

    public void setAdType(int i3) {
        this.V = i3;
    }

    public void setAdUIListener(xu2.a aVar) {
        this.C = aVar;
    }

    public void setCanShowSkipCountDown(boolean z16) {
        this.L = z16;
    }

    public void setCurrentAdIndex(int i3) {
        this.H = i3;
    }

    public void setEnableClick(boolean z16) {
        this.I = z16;
    }

    public void setEnableScroll(boolean z16) {
        this.J = z16;
    }

    public void setIsPortraitEpisode(boolean z16) {
        this.f303683a0 = z16;
    }

    public void setPicInPicState(int i3) {
        this.K = i3;
    }

    public void setRequest(AdInsideVideoRequest adInsideVideoRequest) {
        this.D = adInsideVideoRequest;
    }

    public Map<String, View> t() {
        return this.U;
    }

    public AdConstants$ViewState u() {
        return this.N;
    }

    public void w(boolean z16) {
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.d(z16);
        }
    }

    public void x() {
        n.a("[MediaAd]QAdBaseVideoView", "[DetailView] HIDE");
        QAdBaseVideoAdDetailView qAdBaseVideoAdDetailView = this.f303695i;
        if (qAdBaseVideoAdDetailView == null) {
            return;
        }
        qAdBaseVideoAdDetailView.setVisibility(8);
    }

    public void y() {
        this.L = false;
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.p(false, 0);
        }
    }

    public void z() {
        this.T.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                QAdBaseVideoView.this.U();
            }
        });
    }

    public QAdBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = Integer.MAX_VALUE;
        this.I = true;
        this.J = false;
        this.K = -1;
        this.N = AdConstants$ViewState.DEFAULT;
        this.T = new Handler(Looper.getMainLooper());
        this.V = -1;
        this.W = 0;
        this.f303683a0 = false;
        this.f303684b0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QAdBaseVideoView.this.M(view);
            }
        };
        this.f303685c0 = new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QAdBaseVideoView.this.N(view);
            }
        };
        D(context);
        C();
    }

    protected void e0() {
    }

    protected void g0() {
    }

    public void S(QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo) {
    }

    public void f0(long j3, long j16) {
    }
}

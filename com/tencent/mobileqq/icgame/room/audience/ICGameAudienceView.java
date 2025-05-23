package com.tencent.mobileqq.icgame.room.audience;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.icgame.common.webview.HalfTranslucentBrowserActivity;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.audience.event.RoomCloseEvent;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager;
import com.tencent.icgame.game.liveroom.impl.room.profile.LivingOperateHelper;
import com.tencent.icgame.game.liveroom.impl.room.util.h;
import com.tencent.icgame.game.liveroom.impl.room.util.i;
import com.tencent.icgame.game.ui.widget.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomAndRePreloadEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.room.audience.ICGameAudienceView;
import com.tencent.mobileqq.icgame.room.component.ICGameAudienceViewModel;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.p;
import com.tencent.mobileqq.icgame.room.end.EndLiveEvent;
import com.tencent.mobileqq.icgame.room.likeowner.TouchEvent;
import com.tencent.mobileqq.icgame.room.report.ReportHelper;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateView;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.util.InputMethodUtil;
import fu0.EnterRoomConfig;
import java.util.ArrayList;
import mqq.app.Foreground;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ICGameAudienceView extends RelativeLayout implements SimpleEventReceiver {
    private FrameLayout C;
    private Context D;
    private String E;
    private boolean F;
    private boolean G;
    private long H;
    private LiveRoomExtraInfo I;
    private boolean J;
    private LiveInfo K;
    private p L;
    private ICGameAudienceViewModel M;
    private h22.a N;
    private k22.e P;

    /* renamed from: d, reason: collision with root package name */
    private fu0.c f237419d;

    /* renamed from: e, reason: collision with root package name */
    private IAudienceRoom f237420e;

    /* renamed from: f, reason: collision with root package name */
    private b32.e f237421f;

    /* renamed from: h, reason: collision with root package name */
    private View f237422h;

    /* renamed from: i, reason: collision with root package name */
    private View f237423i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f237424m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends b32.b {
        a() {
        }

        @Override // b32.e
        public void onRoomClose(@NonNull QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            y32.d.D(qQLiveRoomStatusInfo);
            InputMethodUtil.hide(ICGameAudienceView.this);
            if (ICGameAudienceView.this.K != null && ICGameAudienceView.this.K.anchorInfo != null && ICGameAudienceView.this.K.anchorInfo.uid == qQLiveRoomStatusInfo.uin) {
                ICGameAudienceView.this.f0();
            } else {
                y32.d.E();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements IResultListener<EndPageRealTimeInfo> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            rt0.a.f("ICGameAudienceView", "audienceExitRoom.onSuccess", "exit room success");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            rt0.a.c("ICGameAudienceView", "audienceExitRoom.onError", "exit room failed, errCode=" + i3 + ", errMsg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements IResultListener<Boolean> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            rt0.a.f("ICGameAudienceView", "initQQLiveSDK.onSuccess", "destroyed = " + ICGameAudienceView.this.F);
            if (!ICGameAudienceView.this.F) {
                ICGameAudienceView.this.y();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            rt0.a.f("ICGameAudienceView", "initQQLiveSDK.onError", "code " + i3 + ", msg " + str);
            f.b("\u6570\u636e\u83b7\u53d6\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements IResultListener<LiveInfo> {
        d() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(LiveInfo liveInfo) {
            LiveWatchMediaInfo liveWatchMediaInfo;
            if (ICGameAudienceView.this.F) {
                y32.d.u(ICGameAudienceView.this.H);
                ICGameAudienceView.this.f237419d.r(ICGameAudienceView.this.H, null);
                return;
            }
            if (((fu0.c) qx0.a.b(fu0.c.class)).b3() != ICGameAudienceView.this.H) {
                return;
            }
            if (liveInfo != null) {
                ICGameAudienceView.this.N.n(liveInfo);
            }
            ICGameAudienceView.this.K = liveInfo;
            ICGameAudienceView.this.j0();
            ReportHelper.INSTANCE.reportQQLiveVideoFormat(ICGameAudienceView.this.H, ICGameAudienceView.this.E, false);
            if (TextUtils.isEmpty(ICGameAudienceView.this.E) && liveInfo != null && (liveWatchMediaInfo = liveInfo.watchMediaInfo) != null) {
                ICGameAudienceView.this.E = liveWatchMediaInfo.mRtmpUrl;
            }
            y32.d.v();
            if (!ICGameAudienceView.this.P(liveInfo)) {
                xw0.b.f448881a.x(false, ICGameAudienceView.this.H, ICGameAudienceView.this.I);
                ICGameAudienceView.this.f237419d.y0(ICGameAudienceView.this.I);
                ICGameAudienceView iCGameAudienceView = ICGameAudienceView.this;
                iCGameAudienceView.Y(iCGameAudienceView.H);
                return;
            }
            y32.d.w();
            ICGameAudienceView iCGameAudienceView2 = ICGameAudienceView.this;
            iCGameAudienceView2.f237420e = iCGameAudienceView2.f237419d.N(ICGameAudienceView.this.H);
            ICGameAudienceView.this.f0();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            y32.d.x(i3, str);
            ReportHelper.INSTANCE.saveEnterRoomEndTimeAndReport(ICGameAudienceView.this.H, System.currentTimeMillis(), i3, str);
            if (ICGameAudienceView.this.F) {
                y32.d.y();
                return;
            }
            if (i3 == 1004) {
                ICGameAudienceView.this.f237419d.r(ICGameAudienceView.this.H, null);
                f.b("\u7ba1\u7406\u5458\u5f00\u653e\u6743\u9650\u540e\uff0c\u624d\u80fd\u8fdb\u5165\u623f\u95f4\u54c8\u3002");
                return;
            }
            if (i3 == -12201) {
                if (TextUtils.isEmpty(str)) {
                    f.b(ICGameAudienceView.this.getResources().getString(R.string.zvp));
                } else {
                    f.b(str);
                }
                Activity C = ICGameAudienceView.this.C();
                if (C != null) {
                    C.finish();
                    return;
                }
                return;
            }
            f.b("\u6682\u65f6\u672a\u80fd\u8fdb\u623f");
            y32.d.z(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements IResultListener<EndPageRealTimeInfo> {
        e() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            y32.d.G(ICGameAudienceView.this.H);
            ICGameAudienceView.this.h0(endPageRealTimeInfo);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            y32.d.H(ICGameAudienceView.this.H, i3, str);
            ICGameAudienceView.this.h0(null);
        }
    }

    public ICGameAudienceView(@NonNull Context context) {
        super(context);
        this.f237419d = (fu0.c) qx0.a.b(fu0.c.class);
        this.E = "";
        this.F = false;
        this.G = false;
        this.K = null;
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Activity C() {
        Activity a16 = s42.a.a(this);
        if (a16 == null && (getContext() instanceof Activity)) {
            return (Activity) getContext();
        }
        return a16;
    }

    private void I(boolean z16) {
        if (z16 && !com.tencent.icgame.game.liveroom.impl.room.util.b.b(getContext(), getWidth(), getHeight())) {
            this.f237423i.setVisibility(8);
        } else {
            this.f237423i.setVisibility(0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void J() {
        boolean z16;
        this.f237419d = (fu0.c) qx0.a.b(fu0.c.class);
        y32.d.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init, isLandscape : ");
        if (getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        rt0.a.e("ICGameAudienceView", sb5.toString());
        LayoutInflater.from(getContext()).inflate(R.layout.fah, this);
        this.f237422h = findViewById(R.id.ttn);
        this.f237423i = findViewById(R.id.f88244wj);
        this.f237424m = (LinearLayout) findViewById(R.id.f165361vo2);
        this.C = (FrameLayout) findViewById(R.id.vo8);
        M();
    }

    private void K() {
        setOnTouchListener(new View.OnTouchListener() { // from class: y32.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Q;
                Q = ICGameAudienceView.this.Q(view, motionEvent);
                return Q;
            }
        });
    }

    private void L() {
        this.f237419d.W1(new c());
    }

    private void M() {
        this.f237421f = new a();
    }

    private boolean N() {
        return gv0.b.f403419a.a(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(LiveInfo liveInfo) {
        LiveWatchMediaInfo liveWatchMediaInfo;
        if (liveInfo == null || (liveWatchMediaInfo = liveInfo.watchMediaInfo) == null || liveWatchMediaInfo.mVideoStatus != LiveVideoStatus.Stop) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q(View view, MotionEvent motionEvent) {
        if (this.N.p()) {
            this.M.w0(new TouchEvent(motionEvent));
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Configuration configuration) {
        this.M.w0(new ConfigurationChangeEvent(configuration));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(long j3) {
        y32.d.n(j3);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        v(this.D, j3, this.I);
        IAudienceRoom N = this.f237419d.N(j3);
        this.f237420e = N;
        if (N == null) {
            y32.d.o(j3);
            return;
        }
        if (N.getRoomLiveInfo() != null) {
            this.N.n(this.f237420e.getRoomLiveInfo());
        }
        this.f237420e.registerRoomStatusListener(this.f237421f);
        LiveRoomExtraInfo liveRoomExtraInfo = this.I;
        if (liveRoomExtraInfo != null) {
            this.f237420e.setExtraData(liveRoomExtraInfo.E);
        }
        K();
        this.M.P1(null, true);
        this.M.w0(new EnterRoomSuccessEvent(j3));
        if (!this.J) {
            com.tencent.icgame.game.liveroom.impl.room.floatwindow.b bVar = com.tencent.icgame.game.liveroom.impl.room.floatwindow.b.f115282a;
            bVar.c(j3);
            if (this.I != null) {
                bVar.b(!r4.e());
            }
        }
    }

    private void Z(long j3) {
        y32.d.p(j3);
        IAudienceRoom iAudienceRoom = this.f237420e;
        if (iAudienceRoom != null) {
            iAudienceRoom.unRegisterRoomStatusListener(this.f237421f);
            this.f237420e.unRegisterMessageSmooth();
        }
        LivingOperateHelper.f115476a.f();
        if (Foreground.getTopActivity() instanceof HalfTranslucentBrowserActivity) {
            Foreground.getTopActivity().finish();
        }
        this.M.w0(new ExitRoomEvent(j3));
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f.f();
    }

    private void a0(AudienceFloatCloseEvent audienceFloatCloseEvent) {
        if (this.H != audienceFloatCloseEvent.getRoomId()) {
            y32.d.q();
            return;
        }
        y32.d.r();
        QQLiveFloatWindowManager.f115256a.p();
        this.f237419d.r(this.H, null);
        this.N.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        SimpleEventBus.getInstance().dispatchEvent(new RoomCloseEvent(this.H));
        Z(this.H);
        this.M.w0(new ov0.b());
        y32.d.F(this.H);
        if (this.G) {
            i0(false);
        }
        this.f237419d.r(this.H, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(EndPageRealTimeInfo endPageRealTimeInfo) {
        this.M.w0(new EndLiveEvent(endPageRealTimeInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        rt0.a.e("ICGameAudienceView", "enter room return gameid is " + this.K.getGameID() + " extraInfo.gameId is " + this.I.f114883h);
        t();
        if (this.K.getGameID() > 0) {
            this.I.f114883h = (int) this.K.getGameID();
        }
        this.N.f(this.I);
    }

    private void t() {
        int i3 = this.I.f114883h;
        if (i3 > 0 && i3 != this.K.getGameID()) {
            rt0.a.c("ICGameAudienceView", "GameId.Error", "\u8fdb\u623f\u4e32gameid: " + this.I.f114883h + "\u4e0e\u8fdb\u623f\u534f\u8baegameid: " + this.K.getGameID() + "\u4e0d\u4e00\u81f4!");
        }
    }

    private void u() {
        this.f237419d.r(this.H, new b());
    }

    private void v(Context context, long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        ((ru0.a) qx0.a.b(ru0.a.class)).i(context, this, "pg_icgame_audience", xw0.b.f448881a.f(j3, liveRoomExtraInfo));
        VideoReport.setPageContentId(this, String.valueOf(j3));
    }

    @NonNull
    private IcgRoomPlayerConfig w() {
        return new IcgRoomPlayerConfig(this.H, 0, this.I.a("streamtype", StreamType.NONE.value), h.a(2, true, this.E, this.I), i.a(this.I));
    }

    private void x() {
        Context context = this.D;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        IcgRoomPlayerConfig w3 = w();
        long j3 = this.H;
        int roomType = this.N.getRoomType();
        boolean N = N();
        EnterRoomInfo.VideoDefinition videoDefinition = EnterRoomInfo.VideoDefinition.ORIGIN;
        LiveRoomExtraInfo liveRoomExtraInfo = this.I;
        this.f237419d.g0(new EnterRoomConfig(j3, roomType, N, videoDefinition, null, liveRoomExtraInfo.I, liveRoomExtraInfo.E, liveRoomExtraInfo.b("share_token")), w3, new d());
    }

    public LinearLayout A() {
        return this.f237424m;
    }

    public FrameLayout B() {
        return this.C;
    }

    public FrameLayout D() {
        return (FrameLayout) findViewById(R.id.f235706s);
    }

    public View E() {
        return findViewById(R.id.zfl);
    }

    public FrameLayout F() {
        return (FrameLayout) findViewById(R.id.f235806t);
    }

    public FrameLayout G() {
        return (FrameLayout) findViewById(R.id.f235906u);
    }

    public TouchDelegateView H() {
        return (TouchDelegateView) findViewById(R.id.f100555st);
    }

    public boolean O() {
        if (this.G) {
            p pVar = this.L;
            if (pVar != null && pVar.a()) {
                return true;
            }
            return false;
        }
        View findViewById = findViewById(R.id.u2z);
        if (findViewById == null) {
            return false;
        }
        View findViewById2 = findViewById.findViewById(R.id.vog);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void S() {
        y32.d.e(this.H);
    }

    public void T() {
        y32.d.f(this.H);
    }

    public void U() {
        y32.d.g(this.H);
    }

    public void V() {
        y32.d.h(this.H);
    }

    public void W() {
        y32.d.i(this.H);
    }

    public boolean X() {
        y32.d.j(this.H);
        if (!this.G) {
            return false;
        }
        i0(false);
        return true;
    }

    public void b0(long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        y32.d.t(j3);
        ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies();
        this.H = j3;
        x();
        this.f237419d.T0(j3);
        this.I = liveRoomExtraInfo;
        if (this.f237419d.H(j3)) {
            Y(j3);
        } else {
            L();
        }
    }

    public void c0(long j3, boolean z16, boolean z17) {
        y32.d.A(j3, z16, z17);
        x();
        if (z17) {
            u();
        }
        Z(j3);
        rx0.a.h("is_click_anchor_info_card_avatar", false);
        if (!z16) {
            this.M.w0(new ExitRoomAndRePreloadEvent(j3));
        }
    }

    public void d0(long j3, @Nullable String str, LiveRoomExtraInfo liveRoomExtraInfo) {
        y32.d.B(j3, str, liveRoomExtraInfo);
        this.H = j3;
        this.I = liveRoomExtraInfo;
        this.E = com.tencent.icgame.game.liveroom.impl.room.definition.b.j(j3, str, liveRoomExtraInfo);
        this.J = this.N.getIntent().getBooleanExtra("open_from_float_window", false);
    }

    public void e0() {
        y32.d.C(this.H);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AudienceFloatCloseEvent.class);
        return arrayList;
    }

    public void i0(boolean z16) {
        y32.d.J(this.H, z16);
        k22.e eVar = this.P;
        if (eVar != null) {
            eVar.a(z16);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(final Configuration configuration) {
        boolean z16;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("ICGameAudienceView", 1, this.H + " onConfigurationChanged isLandScape = " + this.G + ", oriLandscape = " + z16);
        requestLayout();
        post(new Runnable() { // from class: y32.b
            @Override // java.lang.Runnable
            public final void run() {
                ICGameAudienceView.this.R(configuration);
            }
        });
        if (this.G == z16) {
            return;
        }
        this.G = z16;
        y32.d.k(this.H, z16);
        I(z16);
    }

    public void onDestroy() {
        this.F = true;
        y32.d.l(this.H);
        this.f237419d.U(this.H, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        IAudienceRoom iAudienceRoom = this.f237420e;
        if (iAudienceRoom != null) {
            iAudienceRoom.unRegisterRoomStatusListener(this.f237421f);
        }
        y32.d.m(this.H);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AudienceFloatCloseEvent) {
            a0((AudienceFloatCloseEvent) simpleBaseEvent);
        }
    }

    public void setActivityContext(Context context) {
        this.D = context;
    }

    public void setHorizontalCtrlService(p pVar) {
        this.L = pVar;
    }

    public void setQQLiveRoomService(h22.a aVar) {
        this.N = aVar;
    }

    public void setSwitchScreenService(k22.e eVar) {
        this.P = eVar;
    }

    public void setViewModel(ICGameAudienceViewModel iCGameAudienceViewModel) {
        this.M = iCGameAudienceViewModel;
    }

    public View z() {
        return this.f237422h;
    }

    public ICGameAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f237419d = (fu0.c) qx0.a.b(fu0.c.class);
        this.E = "";
        this.F = false;
        this.G = false;
        this.K = null;
        J();
    }

    public ICGameAudienceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f237419d = (fu0.c) qx0.a.b(fu0.c.class);
        this.E = "";
        this.F = false;
        this.G = false;
        this.K = null;
        J();
    }

    public void g0() {
    }
}

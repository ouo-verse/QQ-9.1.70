package com.tencent.timi.game.team.impl.team;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.av.utils.ba;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.component.chat.message.n;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.team.impl.chat.TeamChatView;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.input.TeamOperateView;
import com.tencent.timi.game.team.impl.title.TeamTitleView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.w;
import fm4.p;
import fm4.q;
import fm4.t;
import fm4.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomGameConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSmobaConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamContainerView extends FrameLayout implements fm4.f {
    private RelativeLayout C;
    private URLImageView D;
    private FrameLayout E;
    private RoundCornerImageView F;
    private View G;
    private TeamGiftBannerView H;
    private long I;
    private int J;
    private int K;
    private YesGameInfoOuterClass$GameConfigInfo L;
    private YoloRoomOuterClass$YoloRoomInfo M;
    private TeamInfoEx N;
    private List<com.tencent.timi.game.team.impl.main.a> P;
    private i Q;
    private CommonOuterClass$QQUserId R;
    private Activity S;
    private ViewDragHelper T;
    private float U;
    private int V;
    private TimiGiftController W;

    /* renamed from: a0, reason: collision with root package name */
    private View.OnClickListener f379690a0;

    /* renamed from: b0, reason: collision with root package name */
    private q f379691b0;

    /* renamed from: c0, reason: collision with root package name */
    private p f379692c0;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f379693d;

    /* renamed from: d0, reason: collision with root package name */
    private t f379694d0;

    /* renamed from: e, reason: collision with root package name */
    public TeamChatView f379695e;

    /* renamed from: f, reason: collision with root package name */
    private TeamTitleView f379696f;

    /* renamed from: h, reason: collision with root package name */
    private TeamPlayerListView f379697h;

    /* renamed from: i, reason: collision with root package name */
    private TeamOperateView f379698i;

    /* renamed from: m, reason: collision with root package name */
    private View f379699m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d extends ViewDragHelper.Callback {
        d() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull @NotNull View view, int i3, int i16) {
            return Math.max(i3, 0);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull @NotNull View view) {
            return TeamContainerView.this.V;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i3) {
            super.onViewDragStateChanged(i3);
            if (i3 == 0 && TeamContainerView.this.T.getCapturedView() != null && TeamContainerView.this.T.getCapturedView().getTop() > 0 && TeamContainerView.this.Q != null) {
                TeamContainerView.this.Q.c();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull @NotNull View view, int i3, int i16, int i17, int i18) {
            if (TeamContainerView.this.Q != null) {
                TeamContainerView.this.Q.b(i16 / TeamContainerView.this.V);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f16, float f17) {
            boolean z16;
            int top = view.getTop();
            if (TeamContainerView.this.Q != null) {
                z16 = TeamContainerView.this.Q.a();
            } else {
                z16 = false;
            }
            if (!z16) {
                if (top <= TeamContainerView.this.U) {
                    TeamContainerView.this.T.settleCapturedViewAt(0, 0);
                } else {
                    TeamContainerView.this.T.settleCapturedViewAt(0, TeamContainerView.this.V);
                }
            }
            TeamContainerView.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i3) {
            if (view.getId() == R.id.f9289594) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TeamContainerView.this.f379690a0 != null) {
                TeamContainerView.this.f379690a0.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements n {
        f() {
        }

        @Override // com.tencent.timi.game.component.chat.message.n
        public void a(@NotNull CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            if (o.a()) {
                return;
            }
            boolean a26 = ((sm4.a) mm4.b.b(sm4.a.class)).a2(TeamContainerView.this.I);
            TimiGameBaseActivity c16 = vf4.a.c();
            if (c16 != null) {
                com.tencent.timi.game.team.impl.team.c.f379747a.h(c16, commonOuterClass$QQUserId, a26, TeamContainerView.this.I);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements u {
        g() {
        }

        @Override // fm4.u
        public void j(boolean z16) {
            TeamContainerView.this.L(((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamContainerView.this.I).n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements nl4.a {
        h() {
        }

        @Override // nl4.a
        public void a(boolean z16) {
            l.i("TeamContainerView", "checkMicPermission onChecked - " + z16);
            if (!z16) {
                ((fm4.g) mm4.b.b(fm4.g.class)).A(TeamContainerView.this.I).O(null, 2, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface i {
        boolean a();

        void b(float f16);

        void c();
    }

    public TeamContainerView(Context context) {
        super(context);
        this.P = new ArrayList();
        this.R = new CommonOuterClass$QQUserId();
        this.f379691b0 = new a();
        this.f379692c0 = new b();
        this.f379694d0 = new c();
        if (context instanceof Activity) {
            this.S = (Activity) context;
        }
    }

    private void E() {
        l.h("TeamContainerView", 1, "refreshViewMode type:" + this.N.getType());
        if (this.N.getType() == 0) {
            setToNormalMode();
        } else {
            this.H.d(this.M.game_data_info.common_game_data_info.gift_config.get());
            setToGiftMode();
        }
    }

    private void F() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).y(this.f379691b0);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).l(this.f379692c0);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).j(this.f379694d0);
    }

    private void H(boolean z16) {
        String str;
        String str2;
        int i3;
        int i16;
        if (z16 && !TextUtils.isEmpty(this.L.team_room_info.bg_top_area_gift.get())) {
            str = this.L.team_room_info.bg_top_area_gift.get();
        } else {
            str = this.L.team_room_info.chat_info.head_bg.get();
        }
        if (!TextUtils.isEmpty(str)) {
            RoundCornerImageView roundCornerImageView = this.F;
            if (z16) {
                i16 = R.drawable.lrv;
            } else {
                i16 = R.drawable.lru;
            }
            com.tencent.timi.game.team.impl.b.f(roundCornerImageView, str, i16);
        } else {
            ArrayList arrayList = new ArrayList();
            if (arrayList.size() == 0) {
                if (z16) {
                    arrayList.add("#FFD594");
                    arrayList.add("#FFFFFF");
                    arrayList.add("#FFFFFF");
                } else {
                    arrayList.add("#FCF9F5");
                    arrayList.add("#F3F1EA");
                }
            }
            this.F.setImageDrawable(null);
            com.tencent.timi.game.team.impl.b.e(this.F, arrayList, -1, ba.dp2px(getContext(), 15.0f), ba.dp2px(getContext(), 15.0f), 0.0f, 0.0f);
        }
        if (z16 && !TextUtils.isEmpty(this.L.team_room_info.icon_title_gift_handle_slider.get())) {
            str2 = this.L.team_room_info.icon_title_gift_handle_slider.get();
        } else {
            str2 = this.L.team_room_info.icon_title_handle_slider.get();
        }
        URLImageView uRLImageView = this.D;
        if (z16) {
            i3 = R.drawable.lte;
        } else {
            i3 = R.drawable.ltd;
        }
        com.tencent.timi.game.team.impl.b.f(uRLImageView, str2, i3);
    }

    private void I() {
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).Q(this.f379691b0);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).V(this.f379692c0);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(p()).t(this.f379694d0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        this.f379698i.a().a(list, ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).R(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).M(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).C(), ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).U());
    }

    private void K() {
        Iterator<com.tencent.timi.game.team.impl.main.a> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().i(this.M, this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        this.f379698i.c().b(o(this.I, list));
        this.f379698i.d().a();
    }

    public static int o(long j3, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
        int i3;
        boolean b16 = ((fm4.g) mm4.b.b(fm4.g.class)).m0(j3).b();
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                yoloRoomOuterClass$YoloRoomSpeakingPosInfo = it.next();
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, E)) {
                    break;
                }
            } else {
                yoloRoomOuterClass$YoloRoomSpeakingPosInfo = null;
                break;
            }
        }
        int i16 = 1;
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo != null) {
            i3 = yoloRoomOuterClass$YoloRoomSpeakingPosInfo.voice_switch.get();
        } else {
            i3 = 1;
        }
        if (i3 != 3) {
            if (!b16) {
                i16 = 2;
            }
            if (i16 != i3) {
                l.e("GangupRoomMainPageLogic", "getFinalSelfVoiceSwitchType status is not equal! finalSwitchType = " + i16 + ", selfSwitchType = " + i3);
            }
            return i16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        this.f379697h.R(list);
        if (i3 == 1) {
            if (((sm4.a) mm4.b.b(sm4.a.class)).a2(this.I) && ((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
                com.tencent.timi.game.room.impl.util.g.f379335a.e(this.M.tim_group_id.get(), yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.get(), this.M.room_id.get());
            }
            this.f379697h.I();
        }
    }

    private void r() {
        View.inflate(getContext(), R.layout.hwk, this);
    }

    private void s() {
        HashMap hashMap = new HashMap();
        hashMap.put("yes_game_id", String.valueOf(this.K));
        hashMap.put("yes_user_from", String.valueOf(this.M.room_data_info.create_from.get()));
        ((ug4.b) mm4.b.b(ug4.b.class)).b(this, "pg_yes_smoba_team", hashMap);
        r();
        x();
        u();
        F();
    }

    private void t() {
        this.f379695e.q(this.M, this.R, this.J);
        this.f379695e.setMessageListener(new f());
    }

    private void u() {
        w();
        this.P.add(this.f379696f);
        this.P.add(this.f379697h);
        this.P.add(this.f379698i);
        Iterator<com.tencent.timi.game.team.impl.main.a> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().A(this.M, this.N, this.R);
        }
        J(((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).n());
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.I).H(new g());
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo L = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).L(((ll4.a) mm4.b.b(ll4.a.class)).E());
        if (L != null && L.voice_switch.get() == 1) {
            ((nl4.c) mm4.b.b(nl4.c.class)).k2(new h());
        }
        if (L != null && L.leave_status.get() == 1) {
            ((fm4.g) mm4.b.b(fm4.g.class)).A(this.I).X(false, null, null);
        }
        w.d(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.TeamContainerView.9
            @Override // java.lang.Runnable
            public void run() {
                cn4.a.a((Activity) TeamContainerView.this.getContext(), TeamContainerView.this.I, TeamContainerView.this.K, true, "TeamContainerView-initData");
            }
        }, 500L);
    }

    private void v(int i3, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i16, TeamInfoEx teamInfoEx) {
        this.K = i3;
        this.J = i16;
        this.M = yoloRoomOuterClass$YoloRoomInfo;
        this.N = teamInfoEx;
        this.I = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        this.R = E;
        E.user_from.set(this.M.room_data_info.create_from.get());
        if (this.M.room_data_info.create_from.get() == 2) {
            this.R.guild_id.set(this.M.room_data_info.guild_id.get());
        }
        this.L = ((ag4.h) mm4.b.b(ag4.h.class)).l1(this.K);
    }

    private void w() {
        boolean z16;
        YoloRoomOuterClass$YoloRoomSmobaConf yoloRoomOuterClass$YoloRoomSmobaConf;
        WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf;
        YoloRoomOuterClass$YoloRoomConf Y = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.I).Y();
        if (Y == null) {
            return;
        }
        if (this.K == 101 && (yoloRoomOuterClass$YoloRoomSmobaConf = Y.yolo_room_smoba_conf) != null && (wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf = yoloRoomOuterClass$YoloRoomSmobaConf.yolo_smoba_room_conf) != null) {
            wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf.room_background_img_v2.get();
            z16 = Y.yolo_room_smoba_conf.yolo_smoba_room_conf.is_use_voice.get();
        } else {
            YoloRoomOuterClass$YoloRoomGameConf yoloRoomOuterClass$YoloRoomGameConf = Y.yolo_room_game_conf;
            if (yoloRoomOuterClass$YoloRoomGameConf != null) {
                yoloRoomOuterClass$YoloRoomGameConf.room_background_img_v2.get();
                z16 = Y.yolo_room_game_conf.is_use_voice.get();
            } else {
                z16 = false;
            }
        }
        this.f379695e.setChatViewBackground(((ag4.h) mm4.b.b(ag4.h.class)).l1(this.K).team_room_info.chat_info.bg_hue.get(), -659729);
        this.f379698i.setVoiceEnable(z16);
        this.f379697h.setVoiceEnable(z16);
    }

    private void x() {
        this.f379695e = (TeamChatView) findViewById(R.id.f93225_0);
        this.f379696f = (TeamTitleView) findViewById(R.id.f93305_8);
        this.f379697h = (TeamPlayerListView) findViewById(R.id.f93255_3);
        this.f379698i = this.f379695e.getTeamOperationView();
        this.f379699m = findViewById(R.id.f165362vo3);
        this.C = (RelativeLayout) findViewById(R.id.f9289594);
        this.D = (URLImageView) findViewById(R.id.f93235_1);
        this.E = (FrameLayout) findViewById(R.id.f93245_2);
        this.D.setOnClickListener(new e());
        this.F = (RoundCornerImageView) findViewById(R.id.f99485px);
        this.G = findViewById(R.id.f99475pw);
        this.H = (TeamGiftBannerView) findViewById(R.id.vob);
        setClipChildren(false);
        float dp2px = ba.dp2px(getContext(), 12.0f);
        this.F.setRadius(dp2px, dp2px, 0.0f, 0.0f);
        t();
        E();
    }

    private void y() {
        this.T = ViewDragHelper.create(this, new d());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity activity = this.S;
        if (activity != null) {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i3 = displayMetrics.heightPixels;
            this.V = i3;
            this.U = i3 * 0.3f;
        }
    }

    public boolean A() {
        TeamChatView teamChatView = this.f379695e;
        if (teamChatView != null && teamChatView.D()) {
            return true;
        }
        return false;
    }

    public void B() {
        y();
        this.f379695e.G();
        if (!(getContext() instanceof QBaseActivity)) {
            l.e("TeamContainerView", "context not match");
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) getContext();
        TimiGiftController timiGiftController = this.W;
        if (timiGiftController != null) {
            timiGiftController.s(false);
        }
        TimiGiftController a16 = new com.tencent.timi.game.gift.impl.timi.a(qBaseActivity).b(10003).e(this.I).f(this.R).c(2).d(qBaseActivity).a(this.C);
        this.W = a16;
        a16.F(this.f379699m);
        this.f379695e.z(this.W);
        this.f379697h.M(this.W);
    }

    public void C() {
        l.i("TeamContainerView", "onPageHide()");
        this.f379695e.E();
        ((fm4.g) mm4.b.b(fm4.g.class)).t1(this.I, this);
        I();
    }

    public void D() {
        TeamChatView teamChatView = this.f379695e;
        if (teamChatView != null) {
            teamChatView.I();
        }
    }

    public void G() {
        ViewDragHelper viewDragHelper = this.T;
        if (viewDragHelper != null) {
            viewDragHelper.settleCapturedViewAt(0, 0);
        }
    }

    public void M(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, TeamInfoEx teamInfoEx) {
        this.M = yoloRoomOuterClass$YoloRoomInfo;
        this.N = teamInfoEx;
        K();
        E();
    }

    @Override // fm4.f
    public Object O() {
        return null;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.T;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // fm4.f
    public String getPageName() {
        return TeamContainerView.class.getSimpleName();
    }

    public void m() {
        this.f379695e.t();
    }

    public void n(final ChooseLaneEvent chooseLaneEvent) {
        final TeamLaneStateView L = this.f379697h.L();
        if (L == null) {
            return;
        }
        if (this.f379693d == null) {
            ImageView imageView = new ImageView(getContext());
            this.f379693d = imageView;
            imageView.setAlpha(0.6f);
            addView(this.f379693d, new FrameLayout.LayoutParams(fh4.b.b(28), fh4.b.b(28)));
        }
        getLocationOnScreen(new int[2]);
        this.f379693d.setTranslationX(chooseLaneEvent.getX() - r4[0]);
        this.f379693d.setTranslationY(chooseLaneEvent.getY() - r4[1]);
        this.f379693d.setImageResource(chooseLaneEvent.getResId());
        float translationX = this.f379693d.getTranslationX();
        float translationY = this.f379693d.getTranslationY();
        L.getLocationOnScreen(new int[2]);
        long duration = chooseLaneEvent.getDuration();
        new ObjectAnimator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f379693d, "translationX", translationX, (r9[0] - r4[0]) + ((L.getWidth() - fh4.b.b(28)) / 2));
        ofFloat.setInterpolator(new ss.b(0.165f, 0.84f, 0.44f, 1.0f));
        ofFloat.setDuration(duration).start();
        new ObjectAnimator();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f379693d, "translationY", translationY, (r9[1] - r4[1]) + ((L.getHeight() - fh4.b.b(28)) / 2));
        ofFloat2.setInterpolator(new ss.b(0.165f, 0.84f, 0.44f, 1.0f));
        ofFloat2.setDuration(duration).start();
        this.f379693d.setScaleX(1.0f);
        this.f379693d.setScaleY(1.0f);
        new ObjectAnimator();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f379693d, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ofFloat3.setInterpolator(new ss.b(0.755f, 0.05f, 0.855f, 0.06f));
        long j3 = 200;
        ofFloat3.setDuration(j3);
        long j16 = duration - j3;
        ofFloat3.setStartDelay(j16);
        ofFloat3.start();
        new ObjectAnimator();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f379693d, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        ofFloat4.setInterpolator(new ss.b(0.755f, 0.05f, 0.855f, 0.06f));
        ofFloat4.setDuration(j3);
        ofFloat4.setStartDelay(j16);
        ofFloat4.setDuration(j3).start();
        w.d(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.TeamContainerView.10
            @Override // java.lang.Runnable
            public void run() {
                L.setStateWithAnim(ym4.a.e(chooseLaneEvent.getLaneId(), true));
            }
        }, duration);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (this.T == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        if (!this.T.isViewUnder(this.f379696f, x16, y16) && !this.T.isViewUnder(this.f379697h, x16, y16) && !this.T.isViewUnder(this.E, x16, y16)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return this.T.shouldInterceptTouchEvent(motionEvent);
        }
        this.T.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.T;
        if (viewDragHelper == null) {
            return super.onTouchEvent(motionEvent);
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public long p() {
        return this.I;
    }

    public void setOnCollectClickListener(View.OnClickListener onClickListener) {
        this.f379690a0 = onClickListener;
        this.f379696f.setOnCollectClickListener(onClickListener);
    }

    public void setOnDragChangeListener(i iVar) {
        this.Q = iVar;
    }

    public void setToGiftMode() {
        this.H.setVisibility(0);
        H(true);
        this.f379696f.o(true, this.L);
    }

    public void setToNormalMode() {
        this.H.setVisibility(8);
        H(false);
        this.f379696f.o(false, this.L);
    }

    public boolean z() {
        return this.f379695e.A();
    }

    public TeamContainerView(Context context, int i3, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i16, TeamInfoEx teamInfoEx) {
        this(context);
        v(i3, yoloRoomOuterClass$YoloRoomInfo, i16, teamInfoEx);
        s();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements q {
        a() {
        }

        @Override // fm4.q
        public void e(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.q(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
        }

        @Override // fm4.q
        public void i(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
            if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, ((ll4.a) mm4.b.b(ll4.a.class)).E())) {
                TeamContainerView.this.L(list);
            }
        }

        @Override // fm4.q
        public void k(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
            TeamContainerView.this.J(list);
        }

        @Override // fm4.q
        public void m(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i3) {
            TeamContainerView.this.f379697h.R(list);
        }

        @Override // fm4.q
        public void n(int i3, String str) {
            if (!TextUtils.isEmpty(str)) {
                com.tencent.timi.game.ui.widget.f.c(str);
            }
        }

        @Override // fm4.q
        public void o(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
            TeamContainerView.this.J(list);
        }

        @Override // fm4.q
        public void p(List<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> list) {
            TeamContainerView.this.f379696f.d();
        }

        @Override // fm4.q
        public void q(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            TeamContainerView.this.f379696f.d();
            TeamContainerView.this.f379697h.Q(commonOuterClass$QQUserId);
            TeamContainerView.this.J(((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamContainerView.this.I).n());
        }

        @Override // fm4.q
        public void s(boolean z16, int i3, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo) {
            TeamContainerView.this.f379697h.R(((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamContainerView.this.I).n());
            TeamContainerView.this.J(((fm4.g) mm4.b.b(fm4.g.class)).K0(TeamContainerView.this.I).n());
            if (z16) {
                TeamContainerView.this.f379697h.I();
            }
        }

        @Override // fm4.q
        public void w(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
        }

        @Override // fm4.q
        public void x(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
            TeamContainerView.this.J(list);
        }

        @Override // fm4.q
        public void z(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamContainerView.this.f379697h.R(list);
        }

        @Override // fm4.q
        public void b(int i3) {
        }

        @Override // fm4.q
        public void c(boolean z16) {
        }

        @Override // fm4.q
        public void v(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        }

        @Override // fm4.q
        public void y(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        }

        @Override // fm4.q
        public void u(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
        }

        @Override // fm4.q
        public void d(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16) {
        }

        @Override // fm4.q
        public void r(String str, int i3, YoloRoomOuterClass$YoloBattleOBStatusChangeAction yoloRoomOuterClass$YoloBattleOBStatusChangeAction) {
        }

        @Override // fm4.q
        public void t(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, long j3, long j16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements p {
        b() {
        }

        @Override // fm4.p
        public void a(ConcurrentHashMap<String, Integer> concurrentHashMap) {
            TeamContainerView.this.f379697h.P(concurrentHashMap);
        }

        @Override // fm4.p
        public void h(sn4.a aVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements t {
        c() {
        }

        @Override // fm4.t
        public void l(long j3, int i3) {
            l.i("TeamContainerView", "YoloRoomLifecycleListener - onExitRoom: " + j3);
            if (j3 != 0) {
                ((sm4.a) mm4.b.b(sm4.a.class)).u3(TeamContainerView.this.getContext());
            }
        }

        @Override // fm4.t
        public void f(long j3, int i3) {
        }
    }
}

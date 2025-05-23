package com.tencent.timi.game.team.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.team.impl.chat.TeamChatView;
import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.event.TeamExitEvent;
import com.tencent.timi.game.team.impl.floating.TeamFloatingView;
import com.tencent.timi.game.team.impl.team.TeamContainerView;
import com.tencent.timi.game.team.impl.team.TeamInfoEx;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.u;
import fm4.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import yn4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamActivity extends TimiGameBaseActivity implements View.OnClickListener, com.tencent.timi.game.component.chat.at.d, SimpleEventReceiver {

    /* renamed from: c0, reason: collision with root package name */
    private View f379351c0;

    /* renamed from: d0, reason: collision with root package name */
    private WorldScaleLayout f379352d0;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f379353e0;

    /* renamed from: f0, reason: collision with root package name */
    private TeamContainerView f379354f0;

    /* renamed from: g0, reason: collision with root package name */
    private ValueAnimator f379355g0;

    /* renamed from: h0, reason: collision with root package name */
    private ValueAnimator f379356h0;

    /* renamed from: i0, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379357i0;

    /* renamed from: j0, reason: collision with root package name */
    private TeamInfoEx f379358j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f379359k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f379360l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f379361m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f379362n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    private k f379363o0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f379368d;

        a(float f16) {
            this.f379368d = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            TeamActivity.this.f379354f0.setTranslationY(this.f379368d);
            TeamActivity.d3(TeamActivity.this.f379353e0, 0.0f);
            TeamActivity.this.V2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TeamActivity.this.f379354f0.setTranslationY(this.f379368d);
            TeamActivity.d3(TeamActivity.this.f379353e0, 0.0f);
            TeamActivity.this.V2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TeamActivity.this.f379354f0.setTranslationY(0.0f);
            TeamActivity.d3(TeamActivity.this.f379353e0, 1.0f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends k {
        c() {
        }

        @Override // fm4.k, fm4.q
        public void o(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            TeamActivity.this.i3(list);
        }

        @Override // fm4.k, fm4.q
        public void s(boolean z16, int i3, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo) {
            TeamActivity.this.W2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamActivity.this.U2(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements TeamContainerView.i {
        e() {
        }

        @Override // com.tencent.timi.game.team.impl.team.TeamContainerView.i
        public boolean a() {
            if (!com.tencent.timi.game.utils.g.c(TeamActivity.this)) {
                com.tencent.timi.game.team.impl.main.f.f(vf4.a.b(), TeamActivity.this.f379354f0.p());
                TeamActivity.this.f379354f0.G();
                return true;
            }
            return false;
        }

        @Override // com.tencent.timi.game.team.impl.team.TeamContainerView.i
        public void b(float f16) {
            TeamActivity.d3(TeamActivity.this.f379353e0, 1.0f - f16);
        }

        @Override // com.tencent.timi.game.team.impl.team.TeamContainerView.i
        public void c() {
            TeamActivity.this.finish();
            l.i("TeamActivity", "drag event : onCollect");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float height = TeamActivity.this.f379354f0.getHeight();
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TeamActivity.this.f379354f0.setTranslationY(height * floatValue);
            TeamActivity.d3(TeamActivity.this.f379353e0, 1.0f - floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            TeamActivity.this.g3();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TeamActivity.this.g3();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TeamActivity.this.f379354f0.setTranslationY(TeamActivity.this.f379354f0.getHeight());
            if (TeamActivity.this.f379353e0 != null) {
                TeamActivity.d3(TeamActivity.this.f379353e0, 0.0f);
                TeamActivity.this.f379353e0.setVisibility(0);
            }
            TeamActivity.this.f379354f0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f379377d;

        h(float f16) {
            this.f379377d = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TeamActivity.this.f379354f0.setTranslationY(this.f379377d * floatValue);
            TeamActivity.d3(TeamActivity.this.f379353e0, 1.0f - floatValue);
        }
    }

    private void T2() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.f9290595);
        this.f379354f0 = new TeamContainerView(this, this.f379359k0, this.f379357i0, this.f379360l0, this.f379358j0);
        if (ah.o0()) {
            this.f379354f0.setLayerType(0, null);
        }
        this.f379354f0.setOnCollectClickListener(new d());
        this.f379354f0.setOnDragChangeListener(new e());
        this.f379353e0.addView(this.f379354f0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(boolean z16) {
        if (com.tencent.timi.game.utils.g.c(this)) {
            if (z16) {
                this.f379352d0.g();
                return;
            } else {
                f3();
                return;
            }
        }
        com.tencent.timi.game.team.impl.main.f.f(vf4.a.b(), this.f379354f0.p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        TeamContainerView teamContainerView = this.f379354f0;
        if (teamContainerView != null && !this.f379362n0) {
            this.f379362n0 = true;
            teamContainerView.C();
        }
        TeamFloatingView.INSTANCE.d(false);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.f379357i0.room_id.get()).Q(this.f379363o0);
        cn4.a.b();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379357i0;
        l.h("TeamActivity", 1, "handleRoomInfoUpdate currentRoomInfo:" + yoloRoomOuterClass$YoloRoomInfo);
        if (yoloRoomOuterClass$YoloRoomInfo == null) {
            return;
        }
        long j3 = yoloRoomOuterClass$YoloRoomInfo.room_id.get();
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomInfo();
        l.h("TeamActivity", 1, "handleRoomInfoUpdate, roomId:" + j3 + ", newRoomInfo:" + roomInfo);
        this.f379357i0 = roomInfo;
        this.f379358j0 = new TeamInfoEx();
        if (this.f379357i0.game_data_info.common_game_data_info.gift_config.has()) {
            this.f379358j0.a(1);
        }
        this.f379354f0.M(this.f379357i0, this.f379358j0);
    }

    public static void Y2() {
        l.i("TeamActivity", "hideActivity");
        SimpleEventBus.getInstance().dispatchEvent(new TeamExitEvent());
    }

    private void Z2() {
        this.mActNeedImmersive = false;
        u.e(getWindow());
    }

    private void b3() {
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("open_from", 0);
            this.f379360l0 = intExtra;
            this.f379361m0 = intExtra;
            if (intExtra == 5) {
                this.f379360l0 = 4;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra(AegisLogger.ROOM_INFO);
            if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                try {
                    this.f379357i0 = new YoloRoomOuterClass$YoloRoomInfo().mergeFrom(byteArrayExtra);
                    this.f379359k0 = ((fm4.g) mm4.b.b(fm4.g.class)).t2(this.f379357i0);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                this.f379358j0 = new TeamInfoEx();
                if (this.f379357i0.game_data_info.common_game_data_info.gift_config.has()) {
                    this.f379358j0.a(1);
                }
            }
        }
    }

    private void c3() {
        this.f379351c0.setOnClickListener(this);
        this.f379352d0.setWorldScaleListener(new AnonymousClass3());
        ((fm4.g) mm4.b.b(fm4.g.class)).k(this.f379357i0.room_id.get()).y(this.f379363o0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d3(View view, float f16) {
        Drawable background;
        if (view != null && (background = view.getBackground()) != null) {
            background.setAlpha((int) (f16 * 255.0f));
        }
    }

    private void e3() {
        RelativeLayout relativeLayout = this.f379353e0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.f379354f0.setVisibility(4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f379355g0 = ofFloat;
        ofFloat.setInterpolator(b.f.f450693a);
        this.f379355g0.setDuration(500L);
        this.f379355g0.addUpdateListener(new f());
        this.f379355g0.addListener(new g());
        this.f379354f0.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.TeamActivity.8
            @Override // java.lang.Runnable
            public void run() {
                TeamActivity.this.f379355g0.start();
            }
        });
    }

    private void f3() {
        if (this.f379354f0 == null) {
            l.e("TeamActivity", "showHideAnimation error: mTeamContainerView == null");
            finish();
            return;
        }
        if (this.f379355g0 != null) {
            l.e("TeamActivity", "showHideAnimation error: showAnim.cancel");
            this.f379355g0.cancel();
        }
        if (this.f379356h0 != null) {
            l.e("TeamActivity", "showHideAnimation error: hideAnim != null");
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f379356h0 = ofFloat;
        ofFloat.setInterpolator(b.f.f450694b);
        float height = this.f379354f0.getHeight();
        this.f379356h0.setDuration(500L);
        this.f379356h0.addUpdateListener(new h(height));
        this.f379356h0.addListener(new a(height));
        this.f379356h0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        RelativeLayout relativeLayout = this.f379353e0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.f379354f0.setVisibility(0);
        this.f379354f0.setTranslationY(0.0f);
        this.f379354f0.setTranslationX(0.0f);
        d3(this.f379353e0, 1.0f);
        this.f379354f0.B();
    }

    public static void h3(Context context, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3) {
        l.i("TeamActivity", "startActivity - " + i3);
        Intent intent = new Intent(context, (Class<?>) TeamActivity.class);
        intent.putExtra(AegisLogger.ROOM_INFO, yoloRoomOuterClass$YoloRoomInfo.toByteArray());
        intent.putExtra("open_from", i3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
        Iterator<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> it = list.iterator();
        if (it.hasNext()) {
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo next = it.next();
            if (ll4.b.a(next.user_id, ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379357i0.room_id.get()).R())) {
                ((bo4.d) mm4.b.b(bo4.d.class)).l0(next.user_id, new b(next));
            }
        }
    }

    private void initData() {
        wn4.a aVar = wn4.a.f445988a;
        aVar.e("https://cdn.yes.qq.com/client_business/tg_team_wave.pag", null);
        aVar.e("https://cdn.yes.qq.com/client_business/tg_smoba_icon.pag", null);
        j3();
    }

    private void initView() {
        this.f379351c0 = findViewById(R.id.f9290595);
        this.f379353e0 = (RelativeLayout) findViewById(R.id.f93465_n);
        T2();
        this.f379352d0 = (WorldScaleLayout) findViewById(R.id.f93825am);
    }

    private void j3() {
        ((bo4.d) mm4.b.b(bo4.d.class)).c1(((ll4.a) mm4.b.b(ll4.a.class)).E(), null);
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    public TimiBaseInputView F() {
        TeamChatView teamChatView;
        TeamContainerView teamContainerView = this.f379354f0;
        if (teamContainerView != null && (teamChatView = teamContainerView.f379695e) != null) {
            return teamChatView.F();
        }
        return null;
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    public EditText H() {
        TeamChatView teamChatView;
        TeamContainerView teamContainerView = this.f379354f0;
        if (teamContainerView != null && (teamChatView = teamContainerView.f379695e) != null) {
            return teamChatView.H();
        }
        return null;
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 1185) {
            an4.a.f26353a.e(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        l.i("TeamActivity", "dismissWithPermission from back Pressed");
        U2(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        wm4.a.b();
        SimpleEventBus.getInstance().registerReceiver(this);
        Z2();
        boolean doOnCreate = super.doOnCreate(bundle);
        b3();
        if (this.f379357i0 == null) {
            l.e("TeamActivity", "start team Activity failed, room info is null");
            finish();
            return doOnCreate;
        }
        l.h("TeamActivity", 1, "doOnCreate- gameId=" + this.f379359k0 + ", roomId=" + this.f379357i0.room_id.get() + " - " + this.f379357i0.introduce.get());
        if (((ag4.h) mm4.b.b(ag4.h.class)).l1(this.f379359k0).style_mode.get() == 0) {
            u.e(getWindow());
        } else {
            u.d(getWindow());
        }
        setContentView(R.layout.hws);
        ((hn4.a) mm4.b.b(hn4.a.class)).H1(findViewById(android.R.id.content));
        initView();
        c3();
        initData();
        TeamFloatingView.Companion companion = TeamFloatingView.INSTANCE;
        companion.c(false);
        companion.d(true);
        i3(((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379357i0.room_id.get()).n());
        HashMap hashMap = new HashMap();
        hashMap.put("yes_game_id", String.valueOf(this.f379359k0));
        hashMap.put("yes_user_from", String.valueOf(this.f379357i0.room_data_info.create_from.get()));
        ((ug4.b) mm4.b.b(ug4.b.class)).b(this, "pg_yes_smoba_team", hashMap);
        wm4.a.c();
        wm4.a.d();
        wm4.a.e();
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        l.i("TeamActivity", "TeamActivity has destroyed");
        super.doOnDestroy();
        V2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            TeamContainerView teamContainerView = this.f379354f0;
            if (teamContainerView == null) {
                return super.doOnKeyDown(i3, keyEvent);
            }
            if (teamContainerView.z()) {
                this.f379354f0.m();
                return true;
            }
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        TeamContainerView teamContainerView = this.f379354f0;
        if (teamContainerView != null) {
            teamContainerView.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        if (this.f379353e0.getVisibility() == 4) {
            if (this.f379361m0 == 4) {
                this.f379352d0.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.TeamActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TeamActivity.this.f379352d0.h();
                    }
                });
            } else {
                ((fm4.g) mm4.b.b(fm4.g.class)).B1(this.f379357i0.room_id.get(), this.f379354f0);
                e3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        if (!QBaseActivity.mAppForground && !isFinishing() && com.tencent.timi.game.utils.g.c(BaseApplication.context)) {
            finish();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TeamExitEvent.class);
        arrayList.add(ChooseLaneEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (this.f379354f0.A()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f9290595) {
            TeamContainerView teamContainerView = this.f379354f0;
            if (teamContainerView != null && teamContainerView.z()) {
                this.f379354f0.m();
            } else {
                U2(true);
                l.i("TeamActivity", "dismissWithPermission from mask click");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TeamExitEvent) {
            f3();
        }
        if (simpleBaseEvent instanceof ChooseLaneEvent) {
            this.f379354f0.n((ChooseLaneEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.TeamActivity$3, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class AnonymousClass3 implements WorldScaleLayout.c {
        AnonymousClass3() {
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void a() {
            uh4.b c16 = uh4.a.INSTANCE.a().c(TeamActivity.this.f379357i0.room_id.get() + "");
            TeamActivity.this.f379352d0.t(c16.getCenterX(), c16.getCenterY(), c16.getSize(), c16.getPreDrawBitmap());
            TeamActivity.this.g3();
            TeamActivity.this.f379352d0.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.TeamActivity.3.2
                @Override // java.lang.Runnable
                public void run() {
                    ((fm4.g) mm4.b.b(fm4.g.class)).B1(TeamActivity.this.f379357i0.room_id.get(), TeamActivity.this.f379354f0);
                }
            });
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void c() {
            uh4.b c16 = uh4.a.INSTANCE.a().c(TeamActivity.this.f379357i0.room_id.get() + "");
            TeamActivity.this.f379352d0.t(c16.getCenterX(), c16.getCenterY(), c16.getSize(), c16.getPreDrawBitmap());
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void d() {
            TeamActivity.this.overridePendingTransition(0, 0);
            TeamActivity.this.V2();
            TeamActivity.this.overridePendingTransition(0, 0);
            TeamActivity.this.f379352d0.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.TeamActivity.3.1
                @Override // java.lang.Runnable
                public void run() {
                    TeamActivity.this.f379352d0.setVisibility(8);
                    TeamActivity.this.f379352d0.post(new Runnable() { // from class: com.tencent.timi.game.team.impl.TeamActivity.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TeamActivity.this.overridePendingTransition(0, 0);
                            TeamActivity.this.finish();
                        }
                    });
                }
            });
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomSpeakingPosInfo f379370a;

        b(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo) {
            this.f379370a = yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            TeamActivity.this.f379352d0.p(uh4.b.INSTANCE.b(), iUserInfo.f(this.f379370a.user_id));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}

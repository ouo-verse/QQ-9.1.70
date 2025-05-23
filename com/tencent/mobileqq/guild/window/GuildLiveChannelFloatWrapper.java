package com.tencent.mobileqq.guild.window;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.widget.ShowDialogInActivityFragment;
import com.tencent.mobileqq.guild.media.widget.aw;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GuildLiveChannelFloatWrapper extends com.tencent.mobileqq.guild.window.c implements gh2.a {
    public static final int FLOAT_WINDOW_DEFAULT_HEIGHT_SIZE;
    public static final int FLOAT_WINDOW_DEFAULT_SIZE;
    public static final float FLOAT_WINDOW_SIZE_SCALE = 1.7777778f;
    public static final int GUILD_LIVE_ORIENTATION_HORIZONTAL = 2;
    public static final int GUILD_LIVE_ORIENTATION_VERTICAL = 1;
    private View F;
    private ViewGroup G;
    protected TextView H;
    s I;
    private Observer<View> J;
    private Observer<Boolean> K;
    private com.tencent.mobileqq.guild.live.livemanager.h L;
    protected boolean M;
    private QQCustomDialog N;
    private Application.ActivityLifecycleCallbacks P;
    public gh2.c mFullScreenViewClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Observer<View> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(View view) {
            GuildLiveChannelFloatWrapper.this.X0(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null) {
                GuildLiveChannelFloatWrapper.this.W0(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class e implements aw {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(DialogInterface dialogInterface, int i3) {
            HashMap hashMap = new HashMap();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            hashMap.put("live_room_type", String.valueOf(gLiveChannelCore.s().getLiveType()));
            com.tencent.mobileqq.guild.performance.report.l.f("live_room_live_end_dialog_end", hashMap);
            GuildLiveChannelFloatWrapper.this.S0("float anchor click end live, type:" + gLiveChannelCore.s().getLiveType());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Activity activity, DialogInterface dialogInterface) {
            GuildLiveChannelFloatWrapper.this.c1(false);
            activity.finish();
            GuildLiveChannelFloatWrapper.this.N = null;
        }

        @Override // com.tencent.mobileqq.guild.media.widget.aw
        public void dismiss() {
            if (GuildLiveChannelFloatWrapper.this.N != null && GuildLiveChannelFloatWrapper.this.N.isShowing()) {
                GuildLiveChannelFloatWrapper.this.N.dismiss();
            }
            GuildLiveChannelFloatWrapper.this.N = null;
        }

        @Override // com.tencent.mobileqq.guild.media.widget.aw
        public void show(@NonNull final Activity activity) {
            String str;
            String string = activity.getString(R.string.f147650xg);
            if (GLiveChannelCore.f226698a.r().d()) {
                str = activity.getString(R.string.f147630xe);
            } else {
                str = null;
            }
            String str2 = str;
            String string2 = activity.getString(R.string.f140850f3);
            String string3 = activity.getString(R.string.f147640xf);
            GuildLiveChannelFloatWrapper.this.N = DialogUtil.createCustomDialog(activity, 230, string, str2, string2, string3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildLiveChannelFloatWrapper.e.this.d(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.window.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.mobileqq.guild.performance.report.l.c("live_room_live_end_dialog_cancel");
                }
            });
            GuildLiveChannelFloatWrapper.this.N.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.window.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GuildLiveChannelFloatWrapper.e.this.f(activity, dialogInterface);
                }
            });
            GuildLiveChannelFloatWrapper.this.N.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class f implements s.c {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardClosed() {
            QLog.d("GuildLiveChannelFloatWrapper", 4, "onSoftKeyboardClosed");
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int i3) {
            QLog.d("GuildLiveChannelFloatWrapper", 4, "onSoftKeyboardOpened resetFloatWindowScale");
            if (GuildLiveChannelFloatWrapper.this.C()) {
                GuildLiveChannelFloatWrapper.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(api = 21)
    /* loaded from: classes7.dex */
    public static class g extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private final float f236670a;

        public g(float f16) {
            this.f236670a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int max = Math.max(view.getWidth(), rect.width());
            int max2 = Math.max(view.getHeight(), rect.height());
            int i3 = rect.left;
            int i16 = rect.top;
            rect.set(i3, i16, max + i3, max2 + i16);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f236670a);
        }
    }

    static {
        int pxToDp = (((ViewUtils.pxToDp(bv.b(BaseApplication.getContext())) - 65) - 15) - 14) - 10;
        int pxToDp2 = ViewUtils.pxToDp(bv.a(BaseApplication.getContext()));
        if (((int) (pxToDp / 1.7777778f)) > pxToDp2) {
            int i3 = (int) (pxToDp2 / 1.7777778f);
            FLOAT_WINDOW_DEFAULT_SIZE = i3;
            FLOAT_WINDOW_DEFAULT_HEIGHT_SIZE = i3;
        } else {
            FLOAT_WINDOW_DEFAULT_SIZE = pxToDp;
            FLOAT_WINDOW_DEFAULT_HEIGHT_SIZE = pxToDp;
        }
    }

    public GuildLiveChannelFloatWrapper(Context context) {
        super(context);
        this.M = false;
        this.P = new a();
        J0("GuildLiveChannelFloatWrapper");
    }

    private void Q0(View view) {
        QLog.e("GuildLiveChannelFloatWrapper", 1, "addAndShowLiveView:");
        if (this.F == null) {
            return;
        }
        com.tencent.mobileqq.guild.live.livemanager.player.m K = GLiveChannelCore.f226698a.t().K();
        if (K != null) {
            K.disableViewCallback();
        }
        ((ViewGroup) this.F).removeAllViews();
        E(view);
        view.setId(R.id.f165564wo4);
        ((ViewGroup) this.F).addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (K != null) {
            K.enableViewCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str) {
        GLiveChannelCore.f226698a.b(str);
        GuildFloatWindowManager.f236656d.g(GuildLiveChannelFloatWrapper.class.getName());
        com.tencent.mobileqq.qqfloatingwindow.b.d();
    }

    private void U0() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("float click close btn, type:");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        sb5.append(gLiveChannelCore.s().getLiveType());
        String sb6 = sb5.toString();
        QLog.e("GuildLiveChannelFloatWrapper", 1, sb6);
        if (gLiveChannelCore.r().c()) {
            QLog.e("GuildLiveChannelFloatWrapper", 1, "isEnterSdkAudienceRoom, exit channel.");
            S0(sb6);
            return;
        }
        c1(true);
        if (((Boolean) e12.d.b(gLiveChannelCore.t().D(), Boolean.FALSE)).booleanValue()) {
            if (R0()) {
                QLog.e("GuildLiveChannelFloatWrapper", 1, "handleCloseClickEvent: app foreground, anchor show close dialog.");
                f1();
                return;
            } else {
                QLog.e("GuildLiveChannelFloatWrapper", 1, "handleCloseClickEvent: app background, anchor do noting.");
                c1(false);
                return;
            }
        }
        QLog.e("GuildLiveChannelFloatWrapper", 1, "handleCloseClickEvent: viewer close float window.");
        S0(sb6);
        c1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(String str) {
        GuildFloatWindowManager.f236656d.g(GuildLiveChannelFloatWrapper.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(View view) {
        if (view != null) {
            Q0(view);
        } else {
            a1();
            g1();
        }
    }

    private void Y0() {
        c1(true);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        com.tencent.mobileqq.guild.live.livemanager.player.m K = gLiveChannelCore.t().K();
        if (K != null) {
            K.disableViewCallback();
        }
        if (this.mGuildInfo != null && this.mChannelInfo != null) {
            GLiveChannelStartParams s16 = gLiveChannelCore.s();
            o02.a.f(2);
            o02.a.e(s16.getBundle(), 2);
            gq1.c.e(s16);
            return;
        }
        QLog.i("GuildLiveChannelFloatWrapper", 1, "openGuildLiveChannel: guild info or channel info is null.");
    }

    private void a1() {
        QLog.e("GuildLiveChannelFloatWrapper", 1, "resetFloatWindow: ");
        if (!C()) {
            QLog.e("GuildLiveChannelFloatWrapper", 1, "resetFloatWindow: has not zoomed, return.");
            return;
        }
        H();
        int dip2px = ViewUtils.dip2px(FLOAT_WINDOW_DEFAULT_SIZE);
        n0(dip2px, (int) (dip2px / 1.7777778f));
        m0(1);
        H();
        D();
        this.G = T0(v());
        FrameLayout frameLayout = new FrameLayout(v());
        frameLayout.setId(R.id.wmg);
        frameLayout.setBackgroundColor(-16777216);
        initWidgetWrapper(frameLayout);
    }

    private void b1() {
        QLog.i(getTag(), 1, "resetLiveVideoView");
        View view = this.F;
        if (view == null) {
            return;
        }
        E(view);
        View findViewById = this.F.findViewById(R.id.f165564wo4);
        if (findViewById != null) {
            E(findViewById);
            findViewById.setOutlineProvider(null);
            findViewById.setClipToOutline(false);
        }
        this.F = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(Activity activity) {
        if (MediaChannelUtils.f228046a.s(activity)) {
            QLog.d("GuildLiveChannelFloatWrapper", 4, "activity is finishing return");
            return;
        }
        s sVar = new s(activity.getWindow().getDecorView());
        this.I = sVar;
        sVar.g(new f());
    }

    private void e1(int i3) {
        View view = this.F;
        if (view != null) {
            float f16 = i3;
            view.setOutlineProvider(new g(f16));
            this.F.setClipToOutline(true);
            View findViewById = this.F.findViewById(R.id.f165564wo4);
            if (findViewById != null) {
                findViewById.setOutlineProvider(new g(f16));
                findViewById.setClipToOutline(true);
            }
        }
    }

    private void f1() {
        ShowDialogInActivityFragment.rh(new e());
    }

    private void h1() {
        d0();
        Z(1.0f);
    }

    private void k1() {
        if (t()) {
            return;
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.window.c
    public void A0() {
        b1();
        j1();
        s sVar = this.I;
        if (sVar != null) {
            sVar.j();
            this.I = null;
        }
        BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.P);
        c1(false);
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a
    public void B(Context context) {
        super.B(context);
        O(this);
        TextView textView = (TextView) A(tp1.a.f());
        this.H = textView;
        textView.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFloatCloseBtn.getLayoutParams();
        layoutParams.addRule(10, -1);
        layoutParams.topMargin += ViewUtils.dip2px(8.0f);
        layoutParams.rightMargin += ViewUtils.dip2px(8.0f);
        this.mFloatCloseBtn.setLayoutParams(layoutParams);
        this.G = T0(context);
    }

    public boolean R0() {
        boolean i3 = GuildFloatWindowManager.f236656d.i();
        QLog.e("GuildLiveChannelFloatWrapper", 1, "checkAndForegroundApp: app foreground[" + i3 + "]");
        if (!i3) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(BaseApplication.getContext(), 0, new Bundle());
        }
        return i3;
    }

    protected ViewGroup T0(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.guild_live_float_container_bg);
        int dip2px = ViewUtils.dip2px(5.0f);
        frameLayout.setPadding(dip2px, dip2px, dip2px, dip2px);
        frameLayout.setOutlineProvider(new g(ViewUtils.dip2px(12.0f)));
        frameLayout.setClipToOutline(true);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(boolean z16) {
        int i3 = 1;
        QLog.e("GuildLiveChannelFloatWrapper", 1, "handleLiveOrientationChanged: isLand[" + z16 + "]");
        if (!z16) {
            i3 = 2;
        }
        if (q() != i3) {
            H();
            m0(i3);
            H();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void Y(gh2.c cVar) {
        this.mFullScreenViewClickListener = cVar;
    }

    protected void Z0() {
        if (this.J == null) {
            this.J = new b();
        }
        if (this.K == null) {
            this.K = new c();
        }
        if (this.L == null) {
            this.L = new d();
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.t().z().observeForever(this.J);
        gLiveChannelCore.t().J().observeForever(this.K);
        gLiveChannelCore.g().J(this.L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c1(boolean z16) {
        this.M = z16;
    }

    protected void g1() {
        QLog.e("GuildLiveChannelFloatWrapper", 1, "showDefaultNoLive: ");
        View view = this.F;
        if (view == null) {
            return;
        }
        ((ViewGroup) view).removeAllViews();
        TextView textView = (TextView) this.F.findViewById(R.id.wmk);
        if (textView == null) {
            TextView textView2 = new TextView(this.F.getContext());
            textView2.setId(R.id.wmk);
            textView = textView2;
        }
        textView.setText(HardCodeUtil.qqStr(R.string.f148290z7));
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ((ViewGroup) this.F).addView(textView, layoutParams);
    }

    public void i1() {
        Context v3 = v();
        if (v3 != null && !((Boolean) com.tencent.mobileqq.utils.p.b(v3, "", AppConstants.Preferences.KEY_FLOAT_VIDEO_HAS_SHOW_TIPS, Boolean.FALSE)).booleanValue()) {
            i0(true, this.H);
            com.tencent.mobileqq.utils.p.g(v3, "", true, AppConstants.Preferences.KEY_FLOAT_VIDEO_HAS_SHOW_TIPS, Boolean.TRUE);
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildLiveChannelFloatWrapper guildLiveChannelFloatWrapper = GuildLiveChannelFloatWrapper.this;
                    guildLiveChannelFloatWrapper.i0(false, guildLiveChannelFloatWrapper.H);
                }
            }, 3000L);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(View view) {
        QLog.i(getTag(), 1, "initWidgetWrapper:");
        View view2 = this.F;
        if (view2 != null) {
            E(view2);
        }
        this.F = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int dip2px = ViewUtils.dip2px(1.0f);
        layoutParams.setMargins(dip2px, dip2px, dip2px, dip2px);
        this.G.addView(this.F, layoutParams);
        D();
        E(this.G);
        h(this.G, new FrameLayout.LayoutParams(-1, -1));
        F();
        f(new FrameLayout.LayoutParams(-1, -1));
        if (this.G.findViewById(R.id.f165564wo4) == null) {
            g1();
        }
        e1(ViewUtils.dip2px(12.0f));
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a
    public int j(FloatingScreenParams floatingScreenParams, View view) {
        int j3 = super.j(floatingScreenParams, view);
        com.tencent.mobileqq.qqfloatingwindow.b.q();
        if (j3 == 0 && floatingScreenParams != null && floatingScreenParams.getCanZoom()) {
            i1();
        }
        d1(QBaseActivity.sTopActivity);
        Z0();
        BaseApplication.getContext().registerActivityLifecycleCallbacks(this.P);
        return j3;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void j0(gh2.d dVar) {
        super.j0(dVar);
    }

    protected void j1() {
        if (this.J != null) {
            GLiveChannelCore.f226698a.t().z().removeObserver(this.J);
            this.J = null;
        }
        if (this.K != null) {
            GLiveChannelCore.f226698a.t().J().removeObserver(this.K);
            this.K = null;
        }
        if (this.L != null) {
            GLiveChannelCore.f226698a.g().H0(this.L);
            this.L = null;
        }
    }

    @Override // gh2.a
    public void onBackPressed() {
        quitWindowFloat(3);
        com.tencent.mobileqq.qqfloatingwindow.b.g();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.M) {
            QLog.i("GuildLiveChannelFloatWrapper", 1, "onClick: action processing.");
        } else {
            int id5 = view.getId();
            if (id5 == tp1.a.d()) {
                U0();
            } else if (id5 == tp1.a.e()) {
                Y0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int i3, int i16) {
        Q(R.drawable.guild_floating_container_bg_small);
        int dip2px = ViewUtils.dip2px(12.0f);
        super.setRoundCorners(dip2px, dip2px);
        e1(dip2px);
    }

    @Override // com.tencent.mobileqq.guild.window.c
    protected Pair<String, String> u0() {
        return new Pair<>("qqfs_floating_center_x", "qqfs_floating_center_y");
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        U(true);
        N(true);
        h1();
        k1();
    }

    @Override // com.tencent.mobileqq.guild.window.c
    protected void y0() {
        QLog.i(getTag(), 1, "onForceClose: force close live room.");
        GLiveChannelCore.f226698a.b("onForceClose: force close live room.");
        GuildFloatWindowManager.f236656d.g(GuildLiveChannelFloatWrapper.class.getName());
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            s sVar = GuildLiveChannelFloatWrapper.this.I;
            if (sVar != null) {
                sVar.j();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            GuildLiveChannelFloatWrapper.this.d1(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements com.tencent.mobileqq.guild.live.livemanager.h {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.h
        public void onAutoExitRoomPage(@Nullable String str, String str2) {
            GuildLiveChannelFloatWrapper.this.V0(str);
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.h
        public boolean onLiveRoomStatusOpenEvent() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.h
        public void onEndLiveEvent(@NonNull sq1.b bVar) {
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void X(IFullScreenEnterListener iFullScreenEnterListener) {
    }
}

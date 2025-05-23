package com.tencent.mobileqq.matchfriend.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gh2.f;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends com.tencent.mobileqq.qqfloatingwindow.a {
    public static final String CLASS_NAME = "com.tencent.mobileqq.matchfriend.widget.a";
    public static final float DIP_ICON_SIZE = 64.0f;
    public static final String TAG = "MatchFriendFloatingWrapper";

    /* renamed from: e, reason: collision with root package name */
    private MatchFriendSmallScreen f245672e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f245673f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.matchfriend.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class C8020a implements f {
        C8020a() {
        }

        @Override // gh2.f
        public void d(boolean z16) {
            QLog.i(a.TAG, 1, "onWindowShow: canPlay[" + z16 + "]");
            if (a.this.t() || a.this.u() == 0) {
                return;
            }
            a.this.U(true);
        }

        @Override // gh2.f
        public void e() {
            QLog.i(a.TAG, 1, "onWindowResume:");
            if (a.this.t() || a.this.u() == 0) {
                return;
            }
            a.this.U(true);
        }

        @Override // gh2.f
        public void a() {
            QLog.i(a.TAG, 1, "onWindowHide:");
            a.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            QLog.i(a.TAG, 1, "onWindowDismiss:");
        }

        @Override // gh2.f
        public void c() {
            QLog.i(a.TAG, 1, "onWindowPause:");
            a.this.U(false);
        }
    }

    public a(Context context) {
        super(context);
        this.f245673f = false;
    }

    private Point p0() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4);
        return new Point(sharedPreferences.getInt("qq_match_friend_small_screen_center_x", 0), sharedPreferences.getInt("qq_match_friend_small_screen_center_y", 0));
    }

    private void q0() {
        QLog.i(TAG, 1, "saveFloatCenter: x[" + r() + "] y[" + s() + "]");
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4).edit();
        edit.putInt("qq_match_friend_small_screen_center_x", r());
        edit.putInt("qq_match_friend_small_screen_center_y", s());
        edit.commit();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(-1, new C8020a());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void initWidgetWrapper(View view) {
        D();
        E(view);
        h(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(FloatingScreenParams floatingScreenParams, View view) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4);
        int i3 = sharedPreferences.getInt("qq_match_friend_small_screen_center_x", Integer.MIN_VALUE);
        int i16 = sharedPreferences.getInt("qq_match_friend_small_screen_center_y", Integer.MIN_VALUE);
        if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
            floatingScreenParams.setFloatingCenterX(i3);
            floatingScreenParams.setFloatingCenterY(i16);
        }
        if (view instanceof MatchFriendSmallScreen) {
            MatchFriendSmallScreen matchFriendSmallScreen = (MatchFriendSmallScreen) view;
            this.f245672e = matchFriendSmallScreen;
            matchFriendSmallScreen.m();
        }
        this.f245673f = true;
        int j3 = super.j(floatingScreenParams, view);
        I();
        if (!this.f245672e.k()) {
            U(false);
        }
        return j3;
    }

    public Rect o0() {
        int screenWidth = ViewUtils.getScreenWidth() / 2;
        int screenHeight = ViewUtils.getScreenHeight() / 2;
        int r16 = r();
        int s16 = s();
        if (r16 == 0 && s16 == 0) {
            Point p06 = p0();
            int i3 = p06.x;
            s16 = p06.y;
            r16 = i3;
        }
        Rect rect = new Rect();
        int dip2px = ViewUtils.dip2px(32.0f);
        int dip2px2 = ViewUtils.dip2px(32.0f);
        int i16 = screenHeight + s16;
        rect.top = i16 - dip2px2;
        int i17 = screenWidth + r16;
        rect.left = i17 - dip2px;
        rect.right = i17 + dip2px;
        rect.bottom = i16 + dip2px2;
        return rect;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int i3) {
        q0();
        MatchFriendSmallScreen matchFriendSmallScreen = this.f245672e;
        if (matchFriendSmallScreen != null) {
            matchFriendSmallScreen.n();
        }
        this.f245673f = false;
        super.quitWindowFloat(i3);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        U(true);
        T(0, 0, 0, 0);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int i3, int i16) {
    }
}

package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import sr1.h;
import sr1.j;
import sr1.k;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMainFrameLayout extends FrameLayout {
    public static final int I = ViewUtils.dip2px(10.0f);
    private boolean C;
    private ViewGroup D;
    private i E;
    private h F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private float f227302d;

    /* renamed from: e, reason: collision with root package name */
    private float f227303e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f227304f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f227305h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f227306i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f227307m;

    public GuildMainFrameLayout(@NonNull Context context) {
        super(context);
        this.f227302d = 0.0f;
        this.f227303e = 0.0f;
        this.f227304f = false;
        this.f227305h = false;
        this.f227306i = false;
        this.f227307m = false;
        this.C = false;
        this.G = false;
        this.H = false;
    }

    private boolean a() {
        if (this.E.Z0().t() == 0) {
            return false;
        }
        return true;
    }

    private void c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        motionEvent.setAction(3);
        this.F.f().dispatchTouchEvent(motionEvent);
        motionEvent.setAction(action);
    }

    private void d(MotionEvent motionEvent) {
        if (this.H) {
            this.H = false;
            c(motionEvent);
        }
    }

    private boolean e(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = this.F.f().dispatchTouchEvent(motionEvent);
        if (!this.H && dispatchTouchEvent) {
            this.H = true;
        }
        return dispatchTouchEvent;
    }

    private boolean f(MotionEvent motionEvent) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "isBusiIntercept ACTION_DOWN mIsBusiIntercept " + this.f227306i);
        }
        this.f227306i = false;
        return false;
    }

    private boolean g(MotionEvent motionEvent) {
        int i3;
        if (this.f227306i) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "handleBusiInterceptActionMove mIsBusiIntercept true");
            }
            return true;
        }
        if (motionEvent.getRawX() > this.f227302d) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int f16 = this.F.i().f();
        if (m(motionEvent) && this.F.h().i(f16, i3)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "handleBusiInterceptActionMove allowActionMove");
            }
            this.f227306i = true;
        }
        return this.f227306i;
    }

    private boolean h(MotionEvent motionEvent) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "handleBusiInterceptActionUp mIsBusiIntercept = " + this.f227306i);
        }
        return this.f227306i;
    }

    private boolean i(MotionEvent motionEvent) {
        boolean j3 = this.F.h().j(motionEvent);
        this.f227305h = j3;
        return j3;
    }

    private boolean j(MotionEvent motionEvent) {
        return this.f227305h;
    }

    private boolean k(MotionEvent motionEvent) {
        return this.f227305h;
    }

    private boolean l(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!onTouchEvent && AppSetting.t(getContext())) {
            return e(motionEvent);
        }
        return onTouchEvent;
    }

    private boolean m(MotionEvent motionEvent) {
        char c16;
        float translationX = this.D.getTranslationX();
        float o16 = this.F.i().o();
        float m3 = this.F.i().m();
        if (motionEvent.getRawX() > this.f227302d) {
            c16 = 1;
        } else {
            c16 = 2;
        }
        if ((translationX == o16 && c16 == 2) || (translationX == m3 && c16 == 1)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "isAllowActionMove false translationX =  " + translationX);
            }
            return false;
        }
        if (Math.abs(motionEvent.getRawX() - this.f227302d) > Math.abs(motionEvent.getRawY() - this.f227303e) * 3.0f && Math.abs(motionEvent.getRawX() - this.f227302d) > I) {
            return true;
        }
        return false;
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return g(motionEvent);
                }
            }
            return h(motionEvent);
        }
        return f(motionEvent);
    }

    private boolean o(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return j(motionEvent);
                }
            }
            return k(motionEvent);
        }
        return i(motionEvent);
    }

    private boolean p(MotionEvent motionEvent) {
        if (!a()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "isCurMainFrameLayoutIntercept aioIsShowing false");
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                } else {
                    return u(motionEvent);
                }
            }
            return s(motionEvent);
        }
        return t(motionEvent);
    }

    private boolean q() {
        if (this.F != null && !this.C && !QQGuildUIUtil.A(getContext())) {
            return false;
        }
        return true;
    }

    private boolean s(MotionEvent motionEvent) {
        QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEventCancelOrUp mIsIntercept = " + this.f227304f);
        this.F.e().r(motionEvent);
        return false;
    }

    private boolean t(MotionEvent motionEvent) {
        QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEventDown false");
        this.f227302d = motionEvent.getRawX();
        this.f227303e = motionEvent.getRawY();
        this.f227304f = false;
        this.F.e().r(motionEvent);
        return false;
    }

    private boolean u(MotionEvent motionEvent) {
        if (this.f227304f) {
            return true;
        }
        if (m(motionEvent)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEventMove isAllowActionMove true");
            }
            this.f227304f = true;
        } else if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEventMove mIsIntercept = " + this.f227304f);
        }
        return this.f227304f;
    }

    private void v() {
        QLog.i("Guild.MF.GuildMainFrameLayout", 2, "setDrawerFrameEnable false");
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
    }

    public void b(i iVar, h hVar) {
        this.E = iVar;
        this.F = hVar;
        this.D = hVar.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (q()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.H = false;
            this.f227307m = false;
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.f227307m) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "dispatchTouchEvent onTouchEvent UP || Cancel");
            this.F.e().r(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            v();
        }
        if (q()) {
            this.G = false;
            return false;
        }
        if (o(motionEvent)) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEvent isChildIntercept event = " + motionEvent.getAction());
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            this.G = onInterceptTouchEvent;
            return onInterceptTouchEvent;
        }
        if (n(motionEvent)) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onInterceptTouchEvent isBusiIntercept true event = " + motionEvent.getAction());
            this.G = true;
            return true;
        }
        boolean p16 = p(motionEvent);
        this.G = p16;
        return p16;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (q()) {
            return super.onTouchEvent(motionEvent);
        }
        boolean t16 = AppSetting.t(getContext());
        if (t16 && !this.G) {
            onInterceptTouchEvent(motionEvent);
        }
        if (t16 && this.f227305h) {
            return e(motionEvent);
        }
        if (this.f227306i) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onTouchEvent mIsBusiIntercept true");
            return l(motionEvent);
        }
        if (t16 && !this.f227304f && e(motionEvent)) {
            return true;
        }
        d(motionEvent);
        k e16 = this.F.e();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return l(motionEvent);
                    }
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onTouchEvent ACTION_MOVE");
                    }
                    if (!a()) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onTouchEvent aioIsShowing false");
                        }
                        j i3 = this.F.i();
                        i3.v(i3.m());
                        return true;
                    }
                    return e16.r(motionEvent);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onTouchEvent ACTION_UP || ACTION_CANCEL mIsIntercept = false");
            }
            this.f227304f = false;
            return e16.r(motionEvent);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.GuildMainFrameLayout", 2, "onTouchEvent ACTION_DOWN");
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        super.requestDisallowInterceptTouchEvent(z16);
        this.f227307m = z16;
        QLog.d("Guild.MF.GuildMainFrameLayout", 2, "requestDisallowInterceptTouchEvent mIsDisallowIntercept = " + this.f227307m);
    }

    public void setInterceptTouchDisabled(boolean z16) {
        this.C = z16;
    }

    public GuildMainFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f227302d = 0.0f;
        this.f227303e = 0.0f;
        this.f227304f = false;
        this.f227305h = false;
        this.f227306i = false;
        this.f227307m = false;
        this.C = false;
        this.G = false;
        this.H = false;
    }

    public GuildMainFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f227302d = 0.0f;
        this.f227303e = 0.0f;
        this.f227304f = false;
        this.f227305h = false;
        this.f227306i = false;
        this.f227307m = false;
        this.C = false;
        this.G = false;
        this.H = false;
    }

    public void r() {
    }
}

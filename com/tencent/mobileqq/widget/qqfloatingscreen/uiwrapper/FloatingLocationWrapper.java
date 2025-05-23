package com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.e;
import com.tencent.mobileqq.location.i;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import gh2.b;
import gh2.f;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FloatingLocationWrapper extends com.tencent.mobileqq.qqfloatingwindow.a implements b, i {
    public static final String CLASS_NAME = "com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper";
    public static final int WAIT_ACTIVITY_ANIM_END_MILLIS = 500;

    public FloatingLocationWrapper(Context context) {
        super(context);
        p0();
    }

    private void p0() {
        R(this);
        e.a(MobileQQ.sMobileQQ.waitAppRuntime(null)).setThemeChangedListener(this);
    }

    private void q0() {
        View A = A(R.id.m2t);
        if (A == null) {
            return;
        }
        A.setContentDescription("\u4f4d\u7f6e\u5171\u4eab\u60ac\u6d6e\u7a97");
        if (ThemeImageWrapper.isNightMode()) {
            A.setBackgroundColor(Color.parseColor("#4D000000"));
        } else {
            A.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(Context context) {
        super.B(context);
        K("\u5173\u95ed\u4f4d\u7f6e\u5171\u4eab\u60ac\u6d6e\u7a97");
        q0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void J(FloatingScreenParams floatingScreenParams) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4);
        int i3 = sharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", Integer.MIN_VALUE);
        int i16 = sharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", Integer.MIN_VALUE);
        if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
            floatingScreenParams.setFloatingCenterX(i3);
            floatingScreenParams.setFloatingCenterY(i16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatingLocationWrapper", 2, "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i3), " centerY: ", Integer.valueOf(i16));
        }
    }

    @Override // gh2.b
    public boolean d(int i3, int i16, int i17) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(1, new a());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(final FloatingScreenParams floatingScreenParams, final View view) {
        if (floatingScreenParams == null) {
            if (v() != null) {
                floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(false).build();
            } else {
                return 2;
            }
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                FloatingLocationWrapper.this.initWidgetWrapper(view);
                FloatingLocationWrapper.this.setRoundCorners(floatingScreenParams.getInnerRoundCorner(), floatingScreenParams.getOuterRoundCorner());
                FloatingLocationWrapper.this.G();
                FloatingLocationWrapper.this.k(floatingScreenParams);
                FloatingLocationWrapper.this.updateFloatingView();
                FloatingLocationWrapper.this.initStatusReceiver();
            }
        }, 500L);
        return 0;
    }

    @Override // gh2.b
    public void onDragEnd() {
        ReportController.o(null, "CliOper", "", "", "0X800A977", "0X800A977", 0, 0, "", "0", "0", "");
    }

    @Override // com.tencent.mobileqq.location.i
    public void onThemeChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("FloatingLocationWrapper", 2, "onThemeChanged: invoked. ", " TAG: ", "FloatingLocationWrapper");
        }
        q0();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                FloatingLocationWrapper.super.quitWindowFloat(i3);
                FloatingLocationWrapper.this.r0();
            }
        });
    }

    public void r0() {
        if (!t()) {
            boolean p16 = p();
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(FloatingScreenParams.QQFS_SP_NAME, 4).edit();
            int r16 = r();
            int s16 = s();
            edit.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", r16);
            edit.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", s16);
            edit.apply();
            if (QLog.isColorLevel()) {
                QLog.d("FloatingLocationWrapper", 2, "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(r16), " centerY: ", Integer.valueOf(s16), " isSmallFloating: ", Boolean.valueOf(p16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements f {
        a() {
        }

        @Override // gh2.f
        public void a() {
            FloatingLocationWrapper.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            FloatingLocationWrapper.this.quitWindowFloat(5);
        }

        @Override // gh2.f
        public void d(boolean z16) {
            FloatingLocationWrapper.this.U(true);
        }

        @Override // gh2.f
        public /* synthetic */ void e() {
            gh2.e.a(this);
        }

        @Override // gh2.f
        public void c() {
        }
    }

    @Override // gh2.b
    public void e(int i3, int i16) {
    }
}

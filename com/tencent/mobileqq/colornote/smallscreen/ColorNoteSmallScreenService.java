package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast;
import com.tencent.mobileqq.colornote.smallscreen.SkinnableServiceProcesser;
import com.tencent.mobileqq.colornote.smallscreen.t;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSmallScreenService extends AppService implements da1.a, com.tencent.mobileqq.colornote.list.h, ColorNoteSmallScreenFullToast.a, SkinnableServiceProcesser.a, p {
    static boolean U = true;
    private static s<l> V = new s<>();
    MqqHandler C;
    SkinnableServiceProcesser F;
    int G;
    int H;
    BaseColorNoteSmallScreenRelativeLayout I;
    g J;
    LinearLayout K;
    ColorNoteSmallScreenFullToast L;
    View M;
    private com.tencent.mobileqq.colornote.list.e P;

    /* renamed from: d, reason: collision with root package name */
    boolean f201643d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f201644e = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f201645f = true;

    /* renamed from: h, reason: collision with root package name */
    boolean f201646h = true;

    /* renamed from: i, reason: collision with root package name */
    boolean f201647i = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f201648m = true;
    Runnable D = null;
    Runnable E = null;
    private BroadcastReceiver Q = new a();
    boolean R = false;
    Application.ActivityLifecycleCallbacks S = new b();
    private t T = new t(new d());
    List<ColorNote> N = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class OnOpChangedRunnable implements Runnable {
        OnOpChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16 = ColorNoteSmallScreenService.this.f201643d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class OnSelectMemberActivityIsResumeChangedRunnable implements Runnable {
        OnSelectMemberActivityIsResumeChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isDevelopLevel()) {
                QLog.w("ColorNoteSmallScreenService", 1, "OnSelectMemberActivityIsResumeChangedRunnable");
            }
            ColorNoteSmallScreenService.this.M();
            ColorNoteSmallScreenService colorNoteSmallScreenService = ColorNoteSmallScreenService.this;
            if (!colorNoteSmallScreenService.f201645f) {
                colorNoteSmallScreenService.a();
                ColorNoteSmallScreenService.this.L.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        private boolean a(String str, boolean z16) {
            boolean z17;
            if (str != null && str.contains(ProcessConstant.OPEN_SDK)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                ColorNoteSmallScreenService colorNoteSmallScreenService = ColorNoteSmallScreenService.this;
                colorNoteSmallScreenService.f201645f = true;
                colorNoteSmallScreenService.f201647i = false;
                return z16;
            }
            if (((IColorNoteDataService) ((AppService) ColorNoteSmallScreenService.this).app.getRuntimeService(IColorNoteDataService.class, "all")).getCurrentColorNoteCount() > 0) {
                ColorNoteSmallScreenService.this.f201647i = true;
            } else {
                ColorNoteSmallScreenService colorNoteSmallScreenService2 = ColorNoteSmallScreenService.this;
                colorNoteSmallScreenService2.f201645f = true;
                colorNoteSmallScreenService2.f201647i = false;
            }
            return false;
        }

        private void b(Intent intent) {
            int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_FROM, -1);
            if (QLog.isDevelopLevel()) {
                QLog.d("ColorNoteSmallScreenService", 4, "mReceiver from : " + intExtra);
            }
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra == 3) {
                        List<ColorNote> y16 = ColorNoteSmallScreenService.this.y();
                        if (y16 != null && y16.size() != 0) {
                            ColorNoteSmallScreenService.this.G = y16.size();
                            ColorNoteSmallScreenService.this.I.o(y16);
                            if (com.tencent.mobileqq.colornote.data.a.n(y16)) {
                                ColorNoteSmallScreenService.this.T.b();
                            }
                            if (QLog.isColorLevel()) {
                                com.tencent.mobileqq.colornote.data.a.b("ColorNoteSmallScreenService", "[onReceive->FromType_UpdateData]\n[visibleColorNotes]: " + ColorNoteSmallScreenService.this.G + "\n" + com.tencent.mobileqq.colornote.data.a.B(y16));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (intExtra == 5) {
                        List y17 = ColorNoteSmallScreenService.this.y();
                        if (!com.tencent.mobileqq.colornote.e.d(((AppService) ColorNoteSmallScreenService.this).app)) {
                            if ((y17.size() == 1 && com.tencent.mobileqq.colornote.data.a.w((ColorNote) y17.get(0))) || y17.size() == 0) {
                                ColorNoteSmallScreenService.this.M();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (intExtra == 6) {
                        boolean booleanExtra = intent.getBooleanExtra("param_custom_night_mode", false);
                        ColorNoteSmallScreenService.this.I.setCustomNightMode(booleanExtra);
                        com.tencent.mobileqq.colornote.data.a.b("ColorNoteSmallScreenService", "[onReceive->FromType_CustomNightMode]\n[setCustomNightMode]: " + booleanExtra);
                        return;
                    }
                    return;
                }
                ColorNoteSmallScreenService.U = intent.getBooleanExtra("param_shoule_show_smallscreen", true);
                if (QLog.isDevelopLevel()) {
                    QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : FromType_BusinessLimit mShouldShow = " + ColorNoteSmallScreenService.U);
                    return;
                }
                return;
            }
            ColorNoteSmallScreenService.this.f201646h = intent.getBooleanExtra("param_not_in_colornote_list", true);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean z16 = true;
            String str = null;
            try {
                str = intent.getStringExtra("process_name");
                if (QLog.isDevelopLevel()) {
                    QLog.w("ColorNoteSmallScreenService", 4, "mReceiver action : " + action + ", process_name :" + str);
                }
            } catch (Exception e16) {
                QLog.e("ColorNoteSmallScreenService", 1, "action: " + action, e16);
            }
            try {
                ColorNoteSmallScreenService colorNoteSmallScreenService = ColorNoteSmallScreenService.this;
                if (colorNoteSmallScreenService.E != null) {
                    colorNoteSmallScreenService.z().removeCallbacks(ColorNoteSmallScreenService.this.E);
                    if (action.equals("action_update_cn_smallscreen_state")) {
                        b(intent);
                    } else if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(action)) {
                        ColorNoteSmallScreenService colorNoteSmallScreenService2 = ColorNoteSmallScreenService.this;
                        colorNoteSmallScreenService2.f201645f = false;
                        colorNoteSmallScreenService2.f201647i = false;
                    } else if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action)) {
                        z16 = a(str, true);
                    }
                }
                if (z16) {
                    ColorNoteSmallScreenService.this.z().removeCallbacks(ColorNoteSmallScreenService.this.E);
                    ColorNoteSmallScreenService.this.z().postDelayed(ColorNoteSmallScreenService.this.E, 200L);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteSmallScreenService", 2, "mReceiver fail", th5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    static {
        try {
            Iterator<Class<? extends l>> it = com.tencent.mobileqq.colornote.smallscreen.a.f201672a.iterator();
            while (it.hasNext()) {
                V.c(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("ColorNoteSmallScreenService", 1, "[static]", e16);
        }
    }

    private void B(Intent intent, int i3, int i16) {
        if (intent != null && intent.getIntExtra("key_upcoming_notify", -1) == 2) {
            Serializable serializableExtra = intent.getSerializableExtra("key_upcoming_color_note");
            if (QLog.isDevelopLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "handleOtherCommand() is called. colorNote = " + serializableExtra);
            }
            if (serializableExtra instanceof ColorNote) {
                ColorNote colorNote = (ColorNote) serializableExtra;
                if (colorNote.getServiceType() == 17235968) {
                    this.T.b();
                    F(colorNote);
                    this.I.o(((IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes());
                    ((m) this.I).a();
                }
            }
        }
    }

    private void C(Intent intent) {
        if (intent != null && intent.getIntExtra("key_upcoming_notify", -1) == 2) {
            this.T.b();
            ReportController.o(null, "dc00898", "", "", "0X800AE85", "0X800AE85", 0, 0, "", "", "", "");
        }
    }

    private void D() {
        com.tencent.mobileqq.colornote.list.e eVar = this.P;
        if (eVar != null && eVar.isShowing()) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ColorNoteSmallScreenService.this.P != null && ColorNoteSmallScreenService.this.P.isShowing()) {
                        ColorNoteSmallScreenService.this.P.refresh();
                    }
                }
            }, 200L);
        }
    }

    private void F(ColorNote colorNote) {
        if (colorNote != null && colorNote.getServiceType() == 17235968) {
            this.N.add(colorNote);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "add note: " + colorNote.toString());
            }
            if (AppSetting.f99565y) {
                com.tencent.mobileqq.util.c.a(this.M, HardCodeUtil.qqStr(R.string.f237397gy) + com.tencent.mobileqq.colornote.data.a.g(colorNote));
            }
        }
    }

    private boolean G() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_update_cn_smallscreen_state");
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        try {
            registerReceiver(this.Q, intentFilter);
            return true;
        } catch (Throwable th5) {
            try {
                QLog.e("ColorNoteSmallScreenService", 1, "previously registered, try again", th5);
                unregisterReceiver(this.Q);
                registerReceiver(this.Q, intentFilter);
                return true;
            } catch (Throwable th6) {
                QLog.e("ColorNoteSmallScreenService", 1, "try again failed", th6);
                return false;
            }
        }
    }

    private void H() {
        if (!this.R) {
            getApplication().registerActivityLifecycleCallbacks(this.S);
            this.R = true;
        }
    }

    private void I() {
        LinearLayout linearLayout = this.K;
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
        }
        this.I.setShouldMaxRootView(false);
        this.I.n();
        this.I.p();
        this.J.g();
    }

    private void J(AppRuntime appRuntime, Point point, int i3) {
        boolean z16;
        if (appRuntime == null) {
            return;
        }
        ColorNoteSmallScreenUtil.u(point.x + (this.I.i() / 2), point.y + (this.I.h() / 2));
        SharedPreferences.Editor edit = ColorNoteSmallScreenUtil.b(this, appRuntime.getCurrentUin()).edit();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        edit.putBoolean("colornote_windows_land", z16);
        edit.putInt("colornote_windows_x", point.x);
        edit.putInt("colornote_windows_y", point.y);
        edit.apply();
        Intent intent = new Intent();
        intent.setAction("key_float_window_position");
        intent.putExtra("key_float_window_position_x", point.x);
        intent.putExtra("key_float_window_position_y", point.y);
        sendBroadcast(intent);
    }

    static void K(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = android.R.id.inbox_text1;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
    }

    public static void L(boolean z16, int i3) {
        U = z16;
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenService", 2, "from: " + i3 + ", should show: " + z16);
        }
    }

    private void N(Point point, boolean z16) {
        boolean z17;
        int i3 = point.x;
        int i16 = point.y;
        if (this.P == null) {
            if (ia1.a.c()) {
                this.P = new com.tencent.mobileqq.colornote.list.c(this, this);
            } else {
                this.P = new com.tencent.mobileqq.colornote.list.b(this, this);
            }
        }
        if (this.P.isShowing()) {
            this.P.refresh(y());
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.flags = 16777984;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        com.tencent.mobileqq.colornote.list.e eVar = this.P;
        AppRuntime appRuntime = this.app;
        if (i3 <= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        eVar.Pf(appRuntime, z17, i16, this.I.h() + i16);
        View root = this.P.getRoot();
        LiuHaiUtils.setLpEnableNotch(layoutParams);
        try {
            this.J.d().addView(root, layoutParams);
            this.f201646h = false;
            if (QLog.isDevelopLevel()) {
                QLog.w("ColorNoteSmallScreenService", 1, "showList");
            }
            M();
            this.T.d();
        } catch (Exception e16) {
            QLog.e("ColorNoteSmallScreenService", 1, "[showList] error ", e16);
        }
    }

    private void O() {
        if (this.R) {
            getApplication().unregisterActivityLifecycleCallbacks(this.S);
            this.R = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ArrayList arrayList = new ArrayList(A());
        if (arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                E((ColorNote) it.next());
            }
        }
        IColorNoteDataService iColorNoteDataService = (IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all");
        iColorNoteDataService.clearAllUpcomingMindFlag();
        this.I.o(iColorNoteDataService.getVisiableColorNotes());
    }

    private void x(int i3, boolean z16) {
        int i16;
        int i17;
        int i18;
        int i19;
        boolean c16 = ia1.a.c();
        if (!QQTheme.isNowThemeIsNight() && !z16) {
            if (i3 <= 0) {
                BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout = this.I;
                if (c16) {
                    i19 = R.drawable.jhc;
                } else {
                    i19 = R.drawable.hjf;
                }
                baseColorNoteSmallScreenRelativeLayout.setBackgroundResource(i19);
                return;
            }
            BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout2 = this.I;
            if (c16) {
                i18 = R.drawable.jhj;
            } else {
                i18 = R.drawable.hjh;
            }
            baseColorNoteSmallScreenRelativeLayout2.setBackgroundResource(i18);
            return;
        }
        if (i3 <= 0) {
            BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout3 = this.I;
            if (c16) {
                i17 = R.drawable.jhd;
            } else {
                i17 = R.drawable.hjc;
            }
            baseColorNoteSmallScreenRelativeLayout3.setBackgroundResource(i17);
            return;
        }
        BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout4 = this.I;
        if (c16) {
            i16 = R.drawable.jhk;
        } else {
            i16 = R.drawable.hje;
        }
        baseColorNoteSmallScreenRelativeLayout4.setBackgroundResource(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ColorNote> y() {
        List<ColorNote> visiableColorNotes = ((IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
        if (visiableColorNotes == null) {
            visiableColorNotes = null;
        }
        if (visiableColorNotes == null) {
            return new ArrayList();
        }
        return visiableColorNotes;
    }

    public List<ColorNote> A() {
        return this.N;
    }

    public void E(ColorNote colorNote) {
        List<ColorNote> list = this.N;
        if (list != null) {
            list.remove(colorNote);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "remove note: " + colorNote.toString());
            }
        }
    }

    void M() {
        boolean z16;
        boolean z17;
        if (!this.f201643d && this.I != null && this.J != null) {
            boolean d16 = com.tencent.mobileqq.colornote.smallscreen.b.d(this.app.getApp());
            if (this.I.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (d16 && U && this.f201645f && this.f201646h && this.f201648m) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + z16 + ", isOpEnable = " + d16 + ", mShouldShow = " + U + ", mIsAppOnForeground = " + this.f201645f + ", mIsNotInColorNoteList = " + this.f201646h + ", Toast IsVisible = " + this.J.b());
            if (QLog.isColorLevel()) {
                QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + this.I.c() + "], mScreenWidth[" + this.I.g() + "], mScreenHeight[" + this.I.f() + "]");
            }
            if (z17) {
                if (!this.J.b()) {
                    this.J.e();
                }
                IColorNoteDataService iColorNoteDataService = (IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all");
                List<ColorNote> visiableColorNotes = iColorNoteDataService.getVisiableColorNotes();
                this.G = visiableColorNotes.size();
                this.I.o(visiableColorNotes);
                if (QLog.isColorLevel()) {
                    QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.G + ", sumcount = " + iColorNoteDataService.getCurrentColorNoteCount());
                }
                if (this.G > 0) {
                    this.I.q();
                    this.I.setVisibility(0);
                } else {
                    this.I.setVisibility(8);
                }
                String format = String.format(getResources().getString(R.string.im8), Integer.valueOf(this.G));
                String h16 = com.tencent.mobileqq.colornote.data.a.h(visiableColorNotes);
                this.M.setContentDescription(format + h16);
                return;
            }
            if (z16) {
                this.I.setVisibility(8);
                I();
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.list.h
    public void a() {
        try {
            com.tencent.mobileqq.colornote.list.e eVar = this.P;
            if (eVar != null) {
                eVar.v7(false);
                this.J.d().removeViewImmediate(this.P.getRoot());
            }
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ColorNoteSmallScreenService", 2, e16, new Object[0]);
            }
        }
        this.f201646h = true;
        if (QLog.isDevelopLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "onHideList");
        }
        this.T.c();
        M();
    }

    @Override // da1.a
    public void c(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        LinearLayout.LayoutParams layoutParams;
        g gVar = this.J;
        WindowManager.LayoutParams c16 = gVar.c();
        LinearLayout linearLayout = this.K;
        if (linearLayout != null) {
            layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b89);
        if (i3 <= 0) {
            c16.x = i3;
            c16.y = i16;
            c16.width = i17 - i3;
            c16.height = i18 - i16;
            if (layoutParams != null) {
                layoutParams.width = (int) (dimensionPixelSize + i19);
            }
            gVar.g();
            if (z16) {
                if (this.I.b()) {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.b5x) / 2;
                }
                this.L.a(i17 - this.H, i16);
                return;
            }
            return;
        }
        c16.x = i3;
        c16.y = i16;
        c16.width = i17 - i3;
        c16.height = i18 - i16;
        if (layoutParams != null) {
            layoutParams.width = (int) (dimensionPixelSize * 2.0f);
        }
        gVar.g();
        if (z16) {
            this.L.a(this.H + i3, i16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "longpress width = " + c16.width + " left = " + i3 + ", right = " + i17 + "offset = " + i19 + ", getMeasuredWidth = " + this.I.getMeasuredWidth());
        }
    }

    @Override // da1.a
    public int d(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout) {
        return this.J.c().y;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast.a
    public void f() {
        if (QLog.isColorLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
        }
        IColorNoteDataService iColorNoteDataService = (IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all");
        ReportController.o(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, iColorNoteDataService.getCurrentColorNoteCount() + "", "", "", "");
        List<ColorNote> colorNotes = iColorNoteDataService.getColorNotes(false);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        boolean z16 = false;
        for (ColorNote colorNote : colorNotes) {
            arrayList.add(colorNote.getServiceType() + "");
            arrayList2.add(colorNote.getSubType());
            if (colorNote.getServiceType() == 16973824 || colorNote.getServiceType() == 17367040) {
                z16 = true;
            }
        }
        Intent intent = new Intent("key_delete_item_call");
        intent.putStringArrayListExtra("key_color_note_servicetype_list", arrayList);
        intent.putStringArrayListExtra("key_color_note_suptype_list", arrayList2);
        ((IColorNoteHelper) this.app.getRuntimeService(IColorNoteHelper.class, "all")).deleteAllColorNote(this.app, null);
        ColorNoteSmallScreenUtil.h(this);
        QQToast.makeText(BaseApplication.getContext(), 0, "\u5f69\u7b7e\u5df2\u53d6\u6d88", 1).show();
        if (z16) {
            ((IQQPlayer) QRoute.api(IQQPlayer.class)).stopPlayMusic(this);
        }
        intent.putExtra("extra_can_add_colornote", iColorNoteDataService.canAddColorNote());
        sendBroadcast(intent);
    }

    @Override // da1.a
    public int g(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout) {
        return this.J.c().x;
    }

    @Override // da1.a
    public void h(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout, int i3, int i16, int i17, int i18) {
        g gVar = this.J;
        WindowManager.LayoutParams c16 = gVar.c();
        c16.x = i3;
        c16.y = i16;
        c16.width = i17 - i3;
        c16.height = i18 - i16;
        c16.windowAnimations = 0;
        gVar.g();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.p
    public int j() {
        return this.T.a();
    }

    @Override // da1.a
    public void k(Point point, int i3) {
        J(this.app, point, i3);
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast.a
    public void l() {
        if (QLog.isColorLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "onBackevent");
        }
        n();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast.a
    public void n() {
        if (QLog.isColorLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "onFullClick");
        }
        LinearLayout linearLayout = this.K;
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            if (this.I.k()) {
                layoutParams.rightMargin = x.c(getBaseContext(), 8.0f);
            } else {
                layoutParams.leftMargin = x.c(getBaseContext(), 8.0f);
            }
        }
        this.I.setShouldMaxRootView(false);
        this.I.m();
        this.I.n();
        this.I.p();
        this.J.g();
    }

    @Override // mqq.app.AppService
    public void onAccountChanged() {
        super.onAccountChanged();
        ia1.a.b();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!ia1.a.c()) {
            return;
        }
        QLog.i("ColorNoteSmallScreenService", 2, "onConfigurationChanged orientation:" + configuration.orientation);
        int i3 = configuration.orientation;
        getResources().getConfiguration();
        boolean z16 = true;
        if (i3 != 1) {
            int i16 = configuration.orientation;
            getResources().getConfiguration();
            if (i16 == 2) {
                z16 = false;
            }
        }
        if (this.f201648m != z16) {
            this.f201648m = z16;
            M();
            D();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x005f A[ADDED_TO_REGION] */
    @Override // mqq.app.AppService, android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        LayoutInflater layoutInflater;
        float f16;
        int i3;
        super.onCreate();
        try {
            layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + e16);
            }
            layoutInflater = null;
            this.f201644e = com.tencent.mobileqq.colornote.smallscreen.b.d(BaseApplication.getContext());
            boolean G = G();
            H();
            if (!this.f201644e) {
            }
            if (QLog.isColorLevel()) {
            }
            ColorNoteSmallScreenUtil.h(this);
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + e17);
            }
            layoutInflater = null;
            this.f201644e = com.tencent.mobileqq.colornote.smallscreen.b.d(BaseApplication.getContext());
            boolean G2 = G();
            H();
            if (!this.f201644e) {
            }
            if (QLog.isColorLevel()) {
            }
            ColorNoteSmallScreenUtil.h(this);
        }
        this.f201644e = com.tencent.mobileqq.colornote.smallscreen.b.d(BaseApplication.getContext());
        boolean G22 = G();
        H();
        if (!this.f201644e && layoutInflater != null && G22) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
            }
            V.b(this);
            boolean c16 = ia1.a.c();
            try {
                if (c16) {
                    this.I = (BaseColorNoteSmallScreenRelativeLayout) ty4.b.e(BaseApplication.getContext(), R.layout.color_note_smallscreen_new, "color_note_smallscreen_new", null);
                } else {
                    this.I = (BaseColorNoteSmallScreenRelativeLayout) ty4.b.e(BaseApplication.getContext(), R.layout.color_note_smallscreen_layout, "color_note_smallscreen_layout", null);
                }
                this.I.j();
                View findViewById = this.I.findViewById(R.id.cgl);
                this.M = findViewById;
                findViewById.bringToFront();
                this.M.setOnTouchListener(new c());
                this.I.k();
                this.K = (LinearLayout) this.I.findViewById(R.id.f166890m91);
                this.J = new g(this, this.I);
                this.I.setFloatListener(this);
                K(this.J.c());
                SharedPreferences b16 = ColorNoteSmallScreenUtil.b(this, this.app.getCurrentUin());
                int i16 = b16.getInt("colornote_windows_x", -1);
                int i17 = b16.getInt("colornote_windows_y", -1);
                int[] iArr = new int[2];
                BaseColorNoteSmallScreenRelativeLayout.e(this, iArr);
                int i18 = iArr[0];
                int i19 = iArr[1];
                if (c16) {
                    f16 = 1.0f;
                } else {
                    f16 = 8.0f;
                }
                this.H = Utils.n(f16, getResources());
                if ((i16 == -1 && i17 == -1) || i16 > i18 || i17 > i19 || i17 < ImmersiveUtils.getStatusBarHeight(getBaseContext())) {
                    if (c16) {
                        i3 = R.dimen.c75;
                    } else {
                        i3 = R.dimen.b5x;
                    }
                    i16 = (i18 - getResources().getDimensionPixelSize(i3)) + this.H;
                    i17 = i19 / 2;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + i16 + ", " + i17 + "]");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setCurPosition mScreenWidth = ");
                    sb5.append(i18);
                    QLog.d("ColorNoteSmallScreenService", 2, sb5.toString());
                    QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + i19);
                }
                this.I.setCurPosition(new Point(i16, i17));
                ColorNoteSmallScreenUtil.u((this.I.i() / 2) + i16, i17 + (this.I.h() / 2));
                try {
                    List<ColorNote> visiableColorNotes = ((IColorNoteDataService) this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
                    this.G = visiableColorNotes.size();
                    this.I.o(visiableColorNotes);
                    String h16 = com.tencent.mobileqq.colornote.data.a.h(visiableColorNotes);
                    String format = String.format(getResources().getString(R.string.im8), Integer.valueOf(this.G));
                    this.M.setContentDescription(format + h16);
                    AccessibilityUtil.n(this.M, true);
                    if (com.tencent.mobileqq.colornote.data.a.n(visiableColorNotes)) {
                        this.T.b();
                    }
                } catch (RuntimeException e18) {
                    QLog.e("ColorNoteSmallScreenService", 1, "onCreate error and hide color note small screen:", e18);
                    ColorNoteSmallScreenUtil.h(this);
                }
                this.I.setUpcomingController(this);
                x(i16, BaseColorNoteSmallScreenRelativeLayout.d());
                this.L = new ColorNoteSmallScreenFullToast(this, this);
                if (this.E == null) {
                    this.E = new OnSelectMemberActivityIsResumeChangedRunnable();
                }
                this.F = new SkinnableServiceProcesser(this, this);
                this.f201643d = false;
                this.f201645f = ColorNoteSmallScreenUtil.j(this);
                M();
                if (this.D == null) {
                    this.D = new OnOpChangedRunnable();
                }
                z().postDelayed(this.D, 1000L);
                this.I.l();
                ea1.c a16 = ColorNoteRecentConfigProcessor.a();
                if (a16 != null && a16.a()) {
                    com.tencent.mobileqq.colornote.e.h(this.app, true);
                    return;
                } else {
                    com.tencent.mobileqq.colornote.e.h(this.app, false);
                    return;
                }
            } catch (Exception e19) {
                QLog.e("ColorNoteSmallScreenService", 1, "onCreate inflate layout exception", e19);
                ColorNoteSmallScreenUtil.h(this);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("ColorNoteSmallScreenService", 2, "onCreate mIsOpEnable " + this.f201644e + ", broadcast: " + G22);
        }
        ColorNoteSmallScreenUtil.h(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        g gVar;
        super.onDestroy();
        this.f201643d = true;
        try {
            unregisterReceiver(this.Q);
            O();
        } catch (RuntimeException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.w("ColorNoteSmallScreenService", 1, "unregisterReceiver", e16);
            }
        }
        SkinnableServiceProcesser skinnableServiceProcesser = this.F;
        if (skinnableServiceProcesser != null) {
            skinnableServiceProcesser.a();
        }
        if (this.I != null && (gVar = this.J) != null) {
            gVar.f();
        }
        if (this.D != null) {
            z().removeCallbacks(this.D);
        }
    }

    @Override // da1.a
    public boolean onLongClick() {
        if (QLog.isColorLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "smallscreen longclick");
        }
        ReportController.o(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
        this.L.b();
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.SkinnableServiceProcesser.a
    public void onPostThemeChanged() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (QLog.isDevelopLevel()) {
            QLog.w("ColorNoteSmallScreenService", 1, "onPostThemeChanged");
        }
        Point c16 = this.I.c();
        boolean d16 = BaseColorNoteSmallScreenRelativeLayout.d();
        boolean c17 = ia1.a.c();
        if (!QQTheme.isNowThemeIsNight() && !d16) {
            if (c16.x <= 0) {
                BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout = this.I;
                if (c17) {
                    i18 = R.drawable.jhc;
                } else {
                    i18 = R.drawable.hjf;
                }
                baseColorNoteSmallScreenRelativeLayout.setBackgroundResource(i18);
            } else {
                BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout2 = this.I;
                if (c17) {
                    i17 = R.drawable.jhj;
                } else {
                    i17 = R.drawable.hjh;
                }
                baseColorNoteSmallScreenRelativeLayout2.setBackgroundResource(i17);
            }
        } else if (c16.x <= 0) {
            BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout3 = this.I;
            if (c17) {
                i16 = R.drawable.jhd;
            } else {
                i16 = R.drawable.hjc;
            }
            baseColorNoteSmallScreenRelativeLayout3.setBackgroundResource(i16);
        } else {
            BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout4 = this.I;
            if (c17) {
                i3 = R.drawable.jhk;
            } else {
                i3 = R.drawable.hje;
            }
            baseColorNoteSmallScreenRelativeLayout4.setBackgroundResource(i3);
        }
        com.tencent.mobileqq.colornote.list.e eVar = this.P;
        if (eVar != null) {
            eVar.onPostThemeChanged();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (intent != null && intent.getIntExtra("KEY_CMD_SHOW_LIST", 0) == 1 && this.I != null) {
            C(intent);
            N(this.I.c(), intent.getBooleanExtra("KEY_SHOW_LIST_LAND", true));
        }
        B(intent, i3, i16);
        super.onStartCommand(intent, i3, i16);
        return 2;
    }

    @Override // da1.a
    public boolean q(Point point, boolean z16) {
        int i3;
        N(point, z16);
        this.T.d();
        ReportController.o(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
        if (com.tencent.mobileqq.colornote.data.a.n(this.N)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", i3, 0, "", "", "", "");
        return true;
    }

    public MqqHandler z() {
        if (this.C == null) {
            this.C = ThreadManager.getUIHandler();
        }
        return this.C;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements t.a {
        d() {
        }

        @Override // com.tencent.mobileqq.colornote.smallscreen.t.a
        public void a(int i3) {
            if (ColorNoteSmallScreenService.this.P != null && ColorNoteSmallScreenService.this.P.isShowing()) {
                ColorNoteSmallScreenService.this.P.refresh();
                ColorNoteSmallScreenService.this.T.d();
                return;
            }
            ColorNoteSmallScreenFullToast colorNoteSmallScreenFullToast = ColorNoteSmallScreenService.this.L;
            if (colorNoteSmallScreenFullToast != null && colorNoteSmallScreenFullToast.f201559h) {
                colorNoteSmallScreenFullToast.onClick(colorNoteSmallScreenFullToast);
            }
        }

        @Override // com.tencent.mobileqq.colornote.smallscreen.t.a
        public void b() {
            ColorNoteSmallScreenService.this.P();
            ColorNoteSmallScreenService.this.I.l();
        }

        @Override // com.tencent.mobileqq.colornote.smallscreen.t.a
        public void c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "onActivityDestroyed: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "onActivityResumed: " + activity.getClass().getName());
            }
            ColorNoteSmallScreenService colorNoteSmallScreenService = ColorNoteSmallScreenService.this;
            if (colorNoteSmallScreenService.f201647i) {
                colorNoteSmallScreenService.f201647i = false;
                colorNoteSmallScreenService.f201645f = true;
                colorNoteSmallScreenService.z().removeCallbacks(ColorNoteSmallScreenService.this.E);
                ColorNoteSmallScreenService.this.z().postDelayed(ColorNoteSmallScreenService.this.E, 200L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "onActivityStarted: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenService", 2, "onActivityStopped: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    @Override // da1.a
    public void p(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout) {
    }
}

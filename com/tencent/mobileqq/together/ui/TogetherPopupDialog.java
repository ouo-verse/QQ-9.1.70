package com.tencent.mobileqq.together.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.bi;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.i;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$UserBirth;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tr2.b;
import tr2.g;

/* loaded from: classes9.dex */
public class TogetherPopupDialog extends PopupWindow implements View.OnClickListener, AtPanelTouchController.a {
    private static final int N = ViewUtils.dpToPx(35.0f);
    private ViewPager2 C;
    private LinearLayout D;
    private String E;
    FrameLayout F;
    com.tencent.mobileqq.together.clockin.d G;
    Animation H;
    LinearLayout I;
    private Handler J;
    private CarouselRunnable K;
    tr2.d L;
    View.OnClickListener M;

    /* renamed from: d, reason: collision with root package name */
    protected ViewGroup f293394d;

    /* renamed from: e, reason: collision with root package name */
    TogetherPanelTouchController f293395e;

    /* renamed from: f, reason: collision with root package name */
    ScrollView f293396f;

    /* renamed from: h, reason: collision with root package name */
    View f293397h;

    /* renamed from: i, reason: collision with root package name */
    com.tencent.mobileqq.together.ui.b f293398i;

    /* renamed from: m, reason: collision with root package name */
    Activity f293399m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class CarouselRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f293402d;

        /* renamed from: e, reason: collision with root package name */
        private int f293403e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<ViewPager2> f293404f;

        public CarouselRunnable(ViewPager2 viewPager2) {
            this.f293404f = new WeakReference<>(viewPager2);
        }

        public void a(int i3, int i16) {
            this.f293402d = i3;
            this.f293403e = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            ViewPager2 viewPager2 = this.f293404f.get();
            int i16 = this.f293403e;
            if (i16 > 1 && viewPager2 != null) {
                int i17 = this.f293402d;
                if (i17 == i16 - 1) {
                    i3 = 0;
                } else {
                    i3 = i17 + 1;
                }
                viewPager2.setCurrentItem(i3, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f293405b;

        a(i iVar) {
            this.f293405b = iVar;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            TogetherPopupDialog togetherPopupDialog = TogetherPopupDialog.this;
            boolean z16 = true;
            if (this.f293405b.getNUM_BACKGOURND_ICON() <= 1) {
                z16 = false;
            }
            togetherPopupDialog.B(z16, i3, this.f293405b.getNUM_BACKGOURND_ICON());
            TogetherPopupDialog.this.J.removeCallbacks(TogetherPopupDialog.this.K);
            TogetherPopupDialog.this.K.a(i3, this.f293405b.getNUM_BACKGOURND_ICON());
            TogetherPopupDialog.this.J.postDelayed(TogetherPopupDialog.this.K, 5000L);
        }
    }

    /* loaded from: classes9.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            switch (((tr2.c) view.getTag()).f437177a) {
                case 1001:
                    TogetherPopupDialog.this.w();
                    break;
                case 1002:
                    TogetherPopupDialog.this.A();
                    break;
                case 1003:
                    TogetherPopupDialog.this.z();
                    break;
                case 1004:
                    TogetherPopupDialog.this.y();
                    break;
                case 1005:
                    TogetherPopupDialog.this.x();
                    break;
            }
            TogetherPopupDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TogetherPopupDialog(String str, Activity activity, View view, int i3, int i16) {
        super(view, i3, i16);
        this.J = new Handler(Looper.getMainLooper());
        this.L = new tr2.d() { // from class: com.tencent.mobileqq.together.ui.TogetherPopupDialog.1
            @Override // tr2.d
            protected void a() {
                com.tencent.mobileqq.together.clockin.d dVar = TogetherPopupDialog.this.G;
                if (dVar == null) {
                    return;
                }
                if (dVar.n()) {
                    if (TogetherPopupDialog.this.J != null) {
                        TogetherPopupDialog.this.J.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.together.ui.TogetherPopupDialog.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TogetherPopupDialog togetherPopupDialog = TogetherPopupDialog.this;
                                com.tencent.mobileqq.together.ui.b bVar = togetherPopupDialog.f293398i;
                                if (bVar != null && togetherPopupDialog.F != null) {
                                    bVar.f();
                                    TogetherPopupDialog.this.F.bringToFront();
                                }
                            }
                        }, 5000L);
                        return;
                    }
                    return;
                }
                TogetherPopupDialog togetherPopupDialog = TogetherPopupDialog.this;
                com.tencent.mobileqq.together.ui.b bVar = togetherPopupDialog.f293398i;
                if (bVar != null && togetherPopupDialog.F != null) {
                    bVar.f();
                    TogetherPopupDialog.this.F.bringToFront();
                }
            }
        };
        this.M = new b();
        this.f293399m = activity;
        this.E = str;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPopupDialog", 2, "TogetherPopupDialog create, this:" + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z16, int i3, int i16) {
        if (z16 && i16 >= 2) {
            if (this.D.getChildCount() != i16) {
                this.D.removeAllViews();
                for (int i17 = 0; i17 < i16; i17++) {
                    ImageView imageView = new ImageView(this.f293399m);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    layoutParams.setMargins(ViewUtils.dpToPx(1.0f), 0, ViewUtils.dpToPx(1.0f), 0);
                    imageView.setLayoutParams(layoutParams);
                    this.D.addView(imageView);
                }
            }
            for (int i18 = 0; i18 < i16; i18++) {
                ImageView imageView2 = (ImageView) this.D.getChildAt(i18);
                if (i18 == i3) {
                    imageView2.setImageDrawable(ResourcesCompat.getDrawable(this.f293399m.getResources(), R.drawable.ob6, null));
                } else {
                    imageView2.setImageDrawable(ResourcesCompat.getDrawable(this.f293399m.getResources(), R.drawable.ob7, null));
                }
            }
            this.D.setVisibility(0);
            return;
        }
        this.D.setVisibility(8);
    }

    private void h(int i3) {
        if (this.f293399m != null && this.f293394d != null) {
            float screenHeight = ViewUtils.getScreenHeight();
            if (i3 / screenHeight < 1.0f - (l(this.f293399m) / screenHeight)) {
                this.f293394d.setPadding(0, 0, 0, 0);
            } else {
                this.f293394d.setPadding(0, 0, 0, N);
            }
        }
    }

    public static TogetherPopupDialog i(String str, Activity activity, int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPopupDialog", 2, "TogetherPopupDialog build, troopUin:" + str + ", source:" + i17);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.cbk, (ViewGroup) null);
        TogetherPopupDialog togetherPopupDialog = new TogetherPopupDialog(str, activity, inflate, i3, i16);
        togetherPopupDialog.o(togetherPopupDialog, activity, 1, i17);
        j(togetherPopupDialog);
        inflate.findViewById(R.id.ebu).setBackgroundColor(inflate.getResources().getColor(R.color.skin_aio_at_white));
        inflate.setOnClickListener(togetherPopupDialog);
        ((RelativeLayout) inflate.findViewById(R.id.lyp)).setOnClickListener(togetherPopupDialog);
        if (AppSetting.f99565y) {
            t(togetherPopupDialog);
        }
        return togetherPopupDialog;
    }

    private static void j(PopupWindow popupWindow) {
        popupWindow.setInputMethodMode(1);
        popupWindow.setSoftInputMode(16);
        popupWindow.setFocusable(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.argb(127, 0, 0, 0)));
    }

    @RequiresApi(api = 17)
    public static int l(Context context) {
        try {
            context.getResources();
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            defaultDisplay.getRealMetrics(displayMetrics2);
            if (displayMetrics.heightPixels != displayMetrics2.heightPixels) {
                return m(context.getResources());
            }
        } catch (Throwable th5) {
            QLog.e("TogetherPopupDialog", 1, th5, new Object[0]);
        }
        return 0;
    }

    private static int m(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private QQAppInterface n() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) peekAppRuntime;
    }

    private View o(TogetherPopupDialog togetherPopupDialog, Activity activity, int i3, int i16) {
        boolean z16;
        View contentView = togetherPopupDialog.getContentView();
        contentView.findViewById(R.id.mb7).setOnClickListener(this);
        contentView.findViewById(R.id.mb7).setContentDescription(this.f293399m.getString(R.string.f23224741));
        this.f293397h = contentView.findViewById(R.id.axk);
        QQAppInterface n3 = n();
        if (n3 == null) {
            return contentView;
        }
        RelativeLayout relativeLayout = (RelativeLayout) contentView.findViewById(R.id.lyp);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) contentView.findViewById(R.id.f80264b0);
        FrameLayout frameLayout = (FrameLayout) contentView.findViewById(R.id.f164819tz2);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        if (this.G == null) {
            com.tencent.mobileqq.together.clockin.c cVar = new com.tencent.mobileqq.together.clockin.c();
            cVar.f293338a = this.E;
            this.G = new com.tencent.mobileqq.together.clockin.d(n3, this.f293399m, cVar, this.F, relativeLayout, lottieAnimationView, i16);
        }
        this.D = (LinearLayout) contentView.findViewById(R.id.t3q);
        List<GroupGiftBirth$UserBirth> o16 = TroopBirthGiftHelper.INSTANCE.o(this.E);
        ViewPager2 viewPager2 = (ViewPager2) contentView.findViewById(R.id.t3p);
        this.C = viewPager2;
        viewPager2.setOrientation(0);
        b.h n16 = tr2.b.q(n3).n();
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        if (n16 == null && o16.isEmpty()) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = ViewUtils.dip2px(150.0f);
        }
        this.C.setLayoutParams(layoutParams);
        i iVar = new i(this, activity, o16, n16, this.E);
        this.C.setOverScrollMode(2);
        this.C.setAdapter(iVar);
        this.K = new CarouselRunnable(this.C);
        this.C.registerOnPageChangeCallback(new a(iVar));
        if (iVar.getNUM_BACKGOURND_ICON() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        B(z16, 0, iVar.getNUM_BACKGOURND_ICON());
        LinearLayout linearLayout = (LinearLayout) contentView.findViewById(R.id.f99315pg);
        this.I = linearLayout;
        this.f293398i = new com.tencent.mobileqq.together.ui.b(this.f293399m, this.M, linearLayout);
        ua1.b a16 = ua1.c.f438640a.a();
        if (!((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuildSwitchOpen(this.E)) {
            if (a16 != null && a16.mEntryItems.size() > 0) {
                this.f293398i.e(a16.mEntryItems);
            } else {
                this.f293398i.e(tr2.c.a());
            }
        }
        this.f293394d = (ViewGroup) contentView.findViewById(R.id.ebu);
        this.f293396f = (ScrollView) contentView.findViewById(R.id.u8j);
        this.f293395e = (TogetherPanelTouchController) contentView.findViewById(R.id.content);
        int i17 = UIUtils.i(this.f293399m);
        h(i17);
        u(i17);
        r();
        this.f293395e.setMode(i3);
        this.f293395e.setDisableMinScrollY(true);
        this.f293395e.setHeadView(relativeLayout);
        this.f293395e.setAtPanelTouchListener(togetherPopupDialog);
        this.F.bringToFront();
        n3.addObserver(this.L);
        return contentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = i18 - i16;
        if (i28 - i26 != i29) {
            h(i29);
            u(i29);
        }
    }

    private void r() {
        this.f293395e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.together.ui.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                TogetherPopupDialog.this.q(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    public static void t(PopupWindow popupWindow) {
        for (Method method : PopupWindow.class.getMethods()) {
            if (method.getName().equals("setTouchModal")) {
                try {
                    method.invoke(popupWindow, Boolean.FALSE);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    private void u(int i3) {
        int statusBarHeight = ((i3 - ImmersiveUtils.getStatusBarHeight(this.f293399m)) - l(this.f293399m)) - ViewUtils.dpToPx(36.0f);
        boolean z16 = false;
        int max = Math.max(statusBarHeight, 0);
        this.f293394d.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.j(this.f293399m), 1073741824), View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
        int measuredHeight = this.f293394d.getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f293394d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(this.f293394d.getMeasuredWidth(), measuredHeight);
        }
        layoutParams.height = Math.min(measuredHeight, max);
        this.f293394d.setLayoutParams(layoutParams);
        TogetherPanelTouchController togetherPanelTouchController = this.f293395e;
        if (measuredHeight >= max) {
            z16 = true;
        }
        togetherPanelTouchController.setControlLitTongue(z16);
    }

    void A() {
        TroopInfo B;
        bi biVar = new bi();
        if (biVar.f202613b == null) {
            QQToast.makeText(this.f293399m, 0, R.string.boo, 0).show();
            return;
        }
        QQAppInterface n3 = n();
        if (n3 == null || (B = ((TroopManager) n3.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.E)) == null) {
            return;
        }
        tr2.b bVar = (tr2.b) n3.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean B2 = bVar.B(2, 1, n3.getCurrentUin());
        Bundle e16 = g.e(true, B.isTroopOwner(n3.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, this.E, 0);
        int d16 = biVar.f202613b.d();
        if (d16 != 0) {
            if (d16 != 1) {
                if (bVar.f(this.f293399m, 2, B.troopuin, 0)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TogetherPopupDialog", 2, "start serviceType=", 2, " fail because of other together business exist, from=", 0);
                    }
                } else {
                    g.j(n3, biVar.f202613b.b(), biVar.f202613b.c(), biVar.f202613b.a(), e16, 1);
                }
            } else if (B2) {
                bVar.D(this.f293399m, B.troopuin, 1, 2, 0, e16);
            } else {
                bVar.S(this.f293399m, B.troopuin, 1, 2, 0, e16);
            }
        } else {
            QQToast.makeText(this.f293399m, 0, R.string.boo, 0).show();
        }
        ReportController.o(n3, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, this.E, "", "" + TroopUtils.c(n3, this.E), "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_via", "5");
        g(hashMap);
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void b(int i3) {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        com.tencent.mobileqq.together.ui.b bVar = this.f293398i;
        if (bVar != null) {
            bVar.c();
        }
        Handler handler = this.J;
        if (handler != null) {
            handler.removeCallbacks(this.K);
        }
    }

    public void g(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        QQAppInterface n3 = n();
        if (this.f293399m != null && n3 != null && !TextUtils.isEmpty(n3.getCurrentAccountUin())) {
            hashMap.put("A8", n3.getCurrentAccountUin());
        }
        if (!TextUtils.isEmpty(this.E)) {
            hashMap.put("qq_group_num", this.E);
        }
    }

    public void k() {
        if (this.G != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (this.G.m()) {
                hashMap.put("op_via", "2");
            } else {
                hashMap.put("op_via", "1");
            }
            g(hashMap);
            ClockReportUtil.a("click#aio_icon", hashMap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.mb7) {
            dismiss();
        } else if (view.getId() != R.id.f164819tz2) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(String str) {
        TroopInfo B;
        QQAppInterface n3 = n();
        if (n3 == null || (B = ((TroopManager) n3.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.E)) == null) {
            return;
        }
        tr2.b bVar = (tr2.b) n3.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        Bundle e16 = g.e(true, B.isTroopOwner(n3.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, this.E, 0);
        if (bVar.f(this.f293399m, 2, B.troopuin, 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherPopupDialog", 2, "start serviceType=", 2, " fail because of other together business exist, from=", 0);
                return;
            }
            return;
        }
        g.j(n3, 1, str, null, e16, 1);
    }

    public void s() {
        tr2.d dVar;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherPopupDialog", 2, "onDestroy, this:" + this);
        }
        com.tencent.mobileqq.together.clockin.d dVar2 = this.G;
        if (dVar2 != null) {
            dVar2.e();
            this.G = null;
        }
        QQAppInterface n3 = n();
        if (this.f293399m != null && n3 != null && (dVar = this.L) != null) {
            n3.removeObserver(dVar);
            this.L = null;
        }
        com.tencent.mobileqq.together.ui.b bVar = this.f293398i;
        if (bVar != null) {
            bVar.b();
            this.f293398i = null;
        }
        Handler handler = this.J;
        if (handler != null) {
            handler.removeCallbacks(this.K);
        }
    }

    public void v() {
        this.f293395e.scrollTo(0, 0);
        Animation animation = this.H;
        if (animation != null && !animation.hasEnded()) {
            return;
        }
        if (this.H == null) {
            this.H = AnimationUtils.loadAnimation(this.f293399m, R.anim.f154454a3);
        }
        View view = this.f293397h;
        if (view != null) {
            view.startAnimation(this.H);
        }
        com.tencent.mobileqq.together.ui.b bVar = this.f293398i;
        if (bVar != null) {
            bVar.d();
        }
        this.J.removeCallbacks(this.K);
        this.J.postDelayed(this.K, 5000L);
    }

    void w() {
        QQAppInterface n3 = n();
        if (n3 == null) {
            return;
        }
        com.tencent.mobileqq.listentogether.g.b(n3, this.f293399m, 1, this.E, 0);
        ReportController.o(n3, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, this.E, "", "" + TroopUtils.c(n3, this.E), "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_via", "4");
        g(hashMap);
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    void x() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_via", "7");
        g(hashMap);
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    void y() {
        boolean isOwnerOrAdmin;
        String str;
        QQAppInterface n3 = n();
        if (n3 == null) {
            return;
        }
        try {
            String str2 = this.E;
            String str3 = "mqqapi://microapp/open?url=" + URLEncoder.encode("https://m.q.qq.com/a/p/1108291530?via=2010_1&referer=2010&s=" + URLEncoder.encode("pages/index/index?mode=qun&gid=" + str2, "UTF-8"), "UTF-8");
            if (QLog.isColorLevel()) {
                QLog.d("TogetherPopupDialog", 2, "handleMiniAIOEntry : " + str3);
            }
            TroopInfo k3 = ((TroopManager) n3.getManager(QQManagerFactory.TROOP_MANAGER)).k(str2);
            if (k3 == null) {
                isOwnerOrAdmin = false;
            } else {
                isOwnerOrAdmin = k3.isOwnerOrAdmin();
            }
            long parseLong = Long.parseLong(str2);
            if (k3 == null) {
                str = "";
            } else {
                str = k3.troopname;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f293399m, str3, 2010, new EntryModel(1, parseLong, str, isOwnerOrAdmin), null);
        } catch (Exception e16) {
            QLog.e("TogetherPopupDialog", 1, e16, new Object[0]);
        }
        ReportController.o(n3, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, this.E, "", "" + TroopUtils.c(n3, this.E), "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_via", "8");
        g(hashMap);
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    void z() {
        QQAppInterface n3 = n();
        if (n3 == null) {
            return;
        }
        new Bundle();
        TroopInfo B = ((TroopManager) n3.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.E);
        if (B == null) {
            return;
        }
        tr2.b bVar = (tr2.b) n3.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        boolean B2 = bVar.B(4, 1, this.E);
        Bundle e16 = g.e(B2, B.isTroopOwner(n3.getCurrentAccountUin()), B.isOwnerOrAdmin(), B.troopowneruin, this.E, 0);
        if (B2) {
            bVar.D(this.f293399m, this.E, 1, 4, 0, e16);
        } else {
            bVar.S(this.f293399m, this.E, 1, 4, 0, e16);
        }
        ReportController.o(n3, "dc00899", "Grp_AIO", "", "hi_tab", "clk_sing", 0, 0, this.E, "", "" + TroopUtils.c(n3, this.E), "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_via", "6");
        g(hashMap);
        ClockReportUtil.a("click#aio_front_panel", hashMap);
    }

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void a(boolean z16) {
    }

    @Override // com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.a
    public void scrollToTop() {
    }
}

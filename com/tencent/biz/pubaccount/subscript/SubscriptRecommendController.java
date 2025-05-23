package com.tencent.biz.pubaccount.subscript;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes4.dex */
public class SubscriptRecommendController {

    /* renamed from: c, reason: collision with root package name */
    com.tencent.biz.pubaccount.subscript.e f80045c;

    /* renamed from: d, reason: collision with root package name */
    HorizontalListView f80046d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<Activity> f80047e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f80048f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.biz.pubaccount.subscript.c f80049g;

    /* renamed from: j, reason: collision with root package name */
    private int f80052j;

    /* renamed from: a, reason: collision with root package name */
    ViewStub f80043a = null;

    /* renamed from: b, reason: collision with root package name */
    public View f80044b = null;

    /* renamed from: h, reason: collision with root package name */
    ImageButton f80050h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f80051i = true;

    /* renamed from: k, reason: collision with root package name */
    public int f80053k = 0;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.biz.pubaccount.subscript.b f80054l = new a();

    /* renamed from: m, reason: collision with root package name */
    private IPublicAccountObserver f80055m = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);

    /* renamed from: n, reason: collision with root package name */
    private IPublicAccountObserver.c f80056n = new b();

    /* renamed from: o, reason: collision with root package name */
    int f80057o = 0;

    /* renamed from: p, reason: collision with root package name */
    int f80058p = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends com.tencent.biz.pubaccount.subscript.b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.subscript.b
        protected void a(boolean z16, List<com.tencent.biz.pubaccount.subscript.d> list) {
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptObserver", 2, "onGetRecommendList isSuccess: " + z16 + " | data: " + list + " | isShowRecommend: " + SubscriptRecommendController.this.f80051i);
            }
            if (z16 && SubscriptRecommendController.this.f80051i) {
                if (list != null && !list.isEmpty()) {
                    SubscriptRecommendController.this.v(list);
                    MqqHandler handler = SubscriptRecommendController.this.f80048f.getHandler(SubscriptFeedsActivity.class);
                    if (handler != null && SubscriptRecommendController.this.f80047e.get() != null && (SubscriptRecommendController.this.f80047e.get() instanceof SubscriptFeedsActivity)) {
                        handler.sendEmptyMessage(1004);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubscriptObserver", 2, "onGetRecommendList data is null or empty");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends IPublicAccountObserver.c {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(int i3, Object obj) {
            if (i3 == 0) {
                SubscriptRecommendController.this.D();
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(int i3, Object obj) {
            if (i3 == 0) {
                SubscriptRecommendController.this.D();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements ViewStub.OnInflateListener {
        c() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
            subscriptRecommendController.f80044b = view;
            subscriptRecommendController.A();
        }
    }

    public SubscriptRecommendController(Activity activity, QQAppInterface qQAppInterface, com.tencent.biz.pubaccount.subscript.c cVar) {
        this.f80052j = 0;
        this.f80047e = new WeakReference<>(activity);
        this.f80048f = qQAppInterface;
        this.f80049g = cVar;
        this.f80052j = (int) activity.getResources().getDimension(R.dimen.aae);
        q();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.3
            @Override // java.lang.Runnable
            public void run() {
                SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
                subscriptRecommendController.f80051i = SubscriptRecommendController.p(subscriptRecommendController.f80048f);
                if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).showPubAccUin(SubscriptRecommendController.this.f80048f)) {
                    SubscriptRecommendController.this.f80051i = true;
                }
            }
        });
        this.f80055m.setOnCallback(this.f80056n);
    }

    private void C() {
        QQAppInterface qQAppInterface = this.f80048f;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f80055m.getBusinessObserver());
            this.f80048f.removeObserver(this.f80054l);
        }
    }

    public static void F(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.SUBSCRIBE_DISCOVERY_BTN, z16);
        edit.commit();
    }

    public static void G(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.IS_SHOW_SUBSCRIBE_FOLDER_RED_DOT + qQAppInterface.getCurrentAccountUin(), z16);
        edit.commit();
    }

    public static void H(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.IS_SHOW_SUBSCRIBE_RED_DOT + qQAppInterface.getCurrentAccountUin(), z16);
        edit.commit();
    }

    public static void I(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt(AppConstants.Preferences.SUBSCRIBE_VERSION + qQAppInterface.getCurrentAccountUin(), i3);
        edit.commit();
    }

    public static void J(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND_VERSION + qQAppInterface.getCurrentAccountUin(), i3);
        edit.commit();
    }

    public static void K(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt(AppConstants.Preferences.SUBSCRIPT_INNER_RECOMMEND_VERSION + qQAppInterface.getCurrentAccountUin(), i3);
        edit.commit();
    }

    public static boolean e(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.SUBSCRIBE_DISCOVERY_BTN, true);
    }

    public static String f(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getString(AppConstants.Preferences.PA_SUBSCRIBE_CONFIG_MSG + qQAppInterface.getCurrentAccountUin(), "");
    }

    public static int g(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.SUBSCRIBE_VERSION + qQAppInterface.getCurrentAccountUin(), 0);
    }

    public static String h(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getString(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND_URL, "");
    }

    public static int i(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND_VERSION + qQAppInterface.getCurrentAccountUin(), -1);
    }

    public static int j(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.SUBSCRIPT_INNER_RECOMMEND_VERSION + qQAppInterface.getCurrentAccountUin(), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        WeakReference<Activity> weakReference;
        if (this.f80044b != null && this.f80043a != null && (weakReference = this.f80047e) != null && weakReference.get() != null && this.f80044b.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f80047e.get(), R.anim.f154866ef);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new f());
            t(0);
            this.f80044b.startAnimation(loadAnimation);
        }
    }

    public static boolean m(QQAppInterface qQAppInterface) {
        if (qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt(AppConstants.Preferences.PA_SUBSCRIBE_CONFIG_SHOW + qQAppInterface.getCurrentAccountUin(), 1) == 0) {
            return false;
        }
        return true;
    }

    public static boolean n(QQAppInterface qQAppInterface) {
        if (!qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.IS_SHOW_SUBSCRIBE_RED_DOT + qQAppInterface.getCurrentAccountUin(), true) || !e(qQAppInterface)) {
            return false;
        }
        return true;
    }

    public static boolean o(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND, false);
    }

    public static boolean p(QQAppInterface qQAppInterface) {
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (!sharedPreferences.getBoolean(AppConstants.Preferences.SUBSCRIPT_INNER_RECOMMEND, false) || sharedPreferences.getBoolean(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND, false)) {
            return false;
        }
        return true;
    }

    private void q() {
        QQAppInterface qQAppInterface = this.f80048f;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f80054l);
            this.f80048f.addObserver(this.f80055m.getBusinessObserver());
        }
    }

    public static void u(QQAppInterface qQAppInterface, int i3, String str) {
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(currentAccountUin, 0).edit();
        edit.putBoolean(AppConstants.Preferences.IS_SHOW_SUBSCRIBE_RED_DOT + currentAccountUin, true);
        edit.putBoolean(AppConstants.Preferences.IS_SHOW_SUBSCRIBE_FOLDER_RED_DOT + currentAccountUin, true);
        edit.putInt(AppConstants.Preferences.PA_SUBSCRIBE_CONFIG_SHOW + currentAccountUin, i3);
        edit.putString(AppConstants.Preferences.PA_SUBSCRIBE_CONFIG_MSG + currentAccountUin, str);
        edit.commit();
        TroopBarAssistantManager n3 = TroopBarAssistantManager.n();
        n3.U(qQAppInterface, false);
        n3.Q(qQAppInterface, true);
        n3.T(qQAppInterface, true);
        n3.O(qQAppInterface, true);
        n3.C(qQAppInterface);
    }

    public static boolean w(AppInterface appInterface, boolean z16, String str) {
        SharedPreferences.Editor edit = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 4).edit();
        edit.putBoolean(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND, z16);
        edit.putString(AppConstants.Preferences.SUBSCRIPT_FULL_RECOMMEND_URL, str);
        return edit.commit();
    }

    public static void x(QQAppInterface qQAppInterface, boolean z16) {
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putBoolean(AppConstants.Preferences.SUBSCRIPT_INNER_RECOMMEND, z16);
        edit.commit();
    }

    void A() {
        WeakReference<Activity> weakReference;
        if (this.f80044b != null && this.f80043a != null && (weakReference = this.f80047e) != null && weakReference.get() != null && this.f80044b.getVisibility() != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f80047e.get(), R.anim.f154867eg);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new e());
            this.f80043a.setVisibility(0);
            this.f80044b.setVisibility(0);
            this.f80044b.startAnimation(loadAnimation);
        }
    }

    public void B(View view) {
        this.f80053k = 3;
        this.f80044b = view;
        view.setVisibility(0);
    }

    public void D() {
        com.tencent.biz.pubaccount.subscript.e eVar = this.f80045c;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        } else if (QLog.isColorLevel()) {
            QLog.d("SubscriptRecommendController", 2, "scriptRecommendAdapter is null");
        }
    }

    void E(String str) {
        QQAppInterface qQAppInterface = this.f80048f;
        if (qQAppInterface != null) {
            ((SubscriptHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER)).E2(str);
        }
    }

    @TargetApi(9)
    public void c() {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean isInNightMode = ThemeUtil.isInNightMode(this.f80048f);
        Resources resources = this.f80047e.get().getResources();
        if (isInNightMode) {
            i3 = R.color.f157571th;
        } else {
            i3 = R.color.f157562t8;
        }
        this.f80044b.setBackgroundColor(resources.getColor(i3));
        this.f80044b.setOnClickListener(new d());
        ImageView imageView = (ImageView) this.f80044b.findViewById(R.id.j7b);
        if (imageView != null) {
            if (ThemeUtil.isInNightMode(this.f80048f)) {
                i18 = R.color.ahq;
            } else {
                i18 = R.color.a08;
            }
            imageView.setBackgroundResource(i18);
        }
        TextView textView = (TextView) this.f80044b.findViewById(R.id.title);
        if (isInNightMode) {
            i16 = R.color.f157561t7;
        } else {
            i16 = R.color.f157560t6;
        }
        textView.setTextColor(resources.getColor(i16));
        if (this.f80046d == null) {
            HorizontalListView horizontalListView = (HorizontalListView) this.f80044b.findViewById(R.id.f166827ii1);
            this.f80046d = horizontalListView;
            horizontalListView.setDividerWidth((int) resources.getDimension(R.dimen.aaf));
            this.f80046d.setAdapter((ListAdapter) this.f80045c);
            this.f80046d.setOverScrollMode(2);
        }
        if (this.f80050h == null) {
            ImageButton imageButton = (ImageButton) this.f80044b.findViewById(R.id.close);
            this.f80050h = imageButton;
            if (!isInNightMode) {
                i17 = R.drawable.a2v;
            } else {
                i17 = R.drawable.du9;
            }
            imageButton.setImageResource(i17);
            this.f80050h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MqqHandler handler;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ReportController.o(SubscriptRecommendController.this.f80048f, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005733", "0X8005733", 0, 0, "", "", "", "");
                    ReportController.o(SubscriptRecommendController.this.f80048f, "CliOper", "", "", "0X8006430", "0X8006430", 0, 0, "", "", "", "");
                    SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
                    subscriptRecommendController.f80051i = false;
                    subscriptRecommendController.f80050h.setEnabled(false);
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SubscriptRecommendController.x(SubscriptRecommendController.this.f80048f, false);
                        }
                    });
                    SubscriptRecommendController subscriptRecommendController2 = SubscriptRecommendController.this;
                    int i19 = subscriptRecommendController2.f80053k;
                    if (i19 == 1) {
                        subscriptRecommendController2.k();
                    } else if (i19 == 3 && (handler = subscriptRecommendController2.f80048f.getHandler(SubscriptFeedsActivity.class)) != null && SubscriptRecommendController.this.f80047e.get() != null && (SubscriptRecommendController.this.f80047e.get() instanceof SubscriptFeedsActivity)) {
                        handler.sendEmptyMessage(1006);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
    }

    public void d() {
        C();
        com.tencent.biz.pubaccount.subscript.e eVar = this.f80045c;
        if (eVar != null) {
            eVar.e();
        }
    }

    public boolean l() {
        Activity activity = this.f80047e.get();
        if (activity == null) {
            return false;
        }
        View findViewById = activity.findViewById(R.id.bwi);
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        int dimension = ((int) activity.getResources().getDimension(R.dimen.title_bar_height)) + ((int) activity.getResources().getDimension(R.dimen.f159598b01)) + this.f80052j;
        int height2 = findViewById.getHeight();
        int width2 = findViewById.getWidth();
        int statusBarHeight = (height - dimension) - ImmersiveUtils.getStatusBarHeight(activity);
        if (width >= width2 && statusBarHeight >= height2) {
            return false;
        }
        return true;
    }

    public void r() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.9
            @Override // java.lang.Runnable
            public void run() {
                SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
                if (subscriptRecommendController.f80051i) {
                    SubscriptRecommendController.this.E(subscriptRecommendController.f80048f.getCurrentAccountUin());
                }
            }
        });
    }

    public void s() {
        Activity activity;
        if (!l() || (activity = this.f80047e.get()) == null) {
            return;
        }
        int c16 = x.c(activity, 100.0f);
        ImageView imageView = (ImageView) activity.findViewById(R.id.g4a);
        this.f80057o = imageView.getHeight();
        this.f80058p = imageView.getWidth();
        imageView.setLayoutParams(new LinearLayout.LayoutParams(c16, c16));
    }

    void t(int i3) {
        View findViewById;
        WeakReference<Activity> weakReference = this.f80047e;
        if (weakReference != null && weakReference.get() != null && (findViewById = this.f80047e.get().findViewById(R.id.eap)) != null) {
            findViewById.setPadding(0, 0, 0, i3);
        }
    }

    void v(List<com.tencent.biz.pubaccount.subscript.d> list) {
        WeakReference<Activity> weakReference = this.f80047e;
        if (weakReference != null && weakReference.get() != null) {
            if (this.f80045c == null) {
                this.f80045c = new com.tencent.biz.pubaccount.subscript.e(this.f80047e.get(), this.f80048f, this.f80049g);
            }
            this.f80045c.d();
            this.f80045c.c(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.f80053k = 1;
        WeakReference<Activity> weakReference = this.f80047e;
        if (weakReference != null && weakReference.get() != null) {
            if (this.f80043a == null) {
                WeakReference<Activity> weakReference2 = this.f80047e;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ViewStub viewStub = (ViewStub) this.f80047e.get().findViewById(R.id.ii6);
                    this.f80043a = viewStub;
                    if (viewStub != null) {
                        viewStub.setOnInflateListener(new c());
                        this.f80044b = this.f80043a.inflate();
                        c();
                        D();
                    }
                }
            } else {
                A();
                t(this.f80052j);
            }
            ReportController.o(this.f80048f, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
        }
    }

    public void z() {
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
            subscriptRecommendController.t(subscriptRecommendController.f80052j);
            SubscriptRecommendController.this.s();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SubscriptRecommendController.this.f80043a.setVisibility(8);
            SubscriptRecommendController.this.f80044b.setVisibility(8);
            ((ViewGroup) SubscriptRecommendController.this.f80044b.getParent()).removeView(SubscriptRecommendController.this.f80044b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            SubscriptRecommendController subscriptRecommendController = SubscriptRecommendController.this;
            if (subscriptRecommendController.f80057o > 0 && subscriptRecommendController.f80058p > 0) {
                ImageView imageView = (ImageView) subscriptRecommendController.f80047e.get().findViewById(R.id.g4a);
                SubscriptRecommendController subscriptRecommendController2 = SubscriptRecommendController.this;
                imageView.setLayoutParams(new LinearLayout.LayoutParams(subscriptRecommendController2.f80058p, subscriptRecommendController2.f80057o));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

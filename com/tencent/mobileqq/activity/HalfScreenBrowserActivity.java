package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.HalfScreenBrowserFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IHalfScreenBrowserApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010*\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010!\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/activity/HalfScreenBrowserActivity;", "Lcom/tencent/mobileqq/activity/QQBrowserActivity;", "Lcom/tencent/mobileqq/webview/util/i;", "Lcom/tencent/mobileqq/webview/util/h;", "", "Q2", "L2", "initView", "N2", "M2", "R2", "Landroid/view/View;", "J2", "T2", "", "isShowNext", "S2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreate", "hasFocus", "onWindowFocusChanged", "doOnBackPressed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "J0", "i2", "a0", "Landroid/view/View;", "webContainerView", "b0", "backgroundView", "", "c0", "I", "backgroundColorId", "", "d0", UserInfo.SEX_FEMALE, "webViewHeight", "e0", "webContainerViewHeight", "f0", "webViewBgRes", "g0", "webViewScaleDensity", "", "h0", "Ljava/lang/String;", "webViewBgColor", "i0", "businessId", "<init>", "()V", "j0", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class HalfScreenBrowserActivity extends QQBrowserActivity implements com.tencent.mobileqq.webview.util.i, com.tencent.mobileqq.webview.util.h {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View webContainerView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View backgroundView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int backgroundColorId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float webViewHeight;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int webContainerViewHeight;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int webViewBgRes;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private float webViewScaleDensity;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String webViewBgColor;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int businessId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/HalfScreenBrowserActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.HalfScreenBrowserActivity$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36124);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HalfScreenBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.backgroundColorId = R.color.by;
        this.webContainerViewHeight = ImmersiveUtils.getScreenHeight();
        this.webViewBgColor = "";
        this.businessId = -1;
    }

    private final View J2() {
        if (this.backgroundView == null) {
            View view = new View(getApplicationContext());
            this.backgroundView = view;
            view.setBackgroundColor(getResources().getColor(this.backgroundColorId));
            View view2 = this.backgroundView;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.db
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        HalfScreenBrowserActivity.K2(HalfScreenBrowserActivity.this, view3);
                    }
                });
            }
            View view3 = this.backgroundView;
            if (view3 != null) {
                view3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
        }
        return this.backgroundView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(HalfScreenBrowserActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S2(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L2() {
        overridePendingTransition(0, 0);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    }

    private final void M2() {
        View findViewById = findViewById(R.id.ae8);
        int i3 = this.backgroundColorId;
        if (i3 != 0 && findViewById != null) {
            findViewById.setBackgroundResource(i3);
        }
    }

    private final void N2() {
        View findViewById = findViewById(R.id.b9v);
        this.webContainerView = findViewById;
        if (findViewById == null) {
            return;
        }
        if (getApplication().getResources().getDisplayMetrics() == null) {
            QLog.e("HalfScreenBrowserActivity", 1, "doOnCreate dm is null");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.webContainerViewHeight);
        layoutParams.gravity = 80;
        View view = this.webContainerView;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        View view2 = this.webContainerView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.webContainerView;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.cz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    HalfScreenBrowserActivity.P2(view4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q2() {
        com.tencent.mobileqq.webview.util.e eVar = com.tencent.mobileqq.webview.util.e.f314868a;
        eVar.e(this);
        eVar.g(true);
        eVar.h(BaseApplication.getContext());
    }

    private final void R2() {
        ViewParent viewParent;
        View view = this.webContainerView;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof FrameLayout) {
            ((FrameLayout) viewParent).addView(J2(), 0);
        }
    }

    private final void S2(boolean isShowNext) {
        if (!(getCurrentWebViewFragment() instanceof com.tencent.mobileqq.webview.util.h)) {
            finish();
            return;
        }
        b.f currentWebViewFragment = getCurrentWebViewFragment();
        Intrinsics.checkNotNull(currentWebViewFragment, "null cannot be cast to non-null type com.tencent.mobileqq.webview.util.IHalfScreenBrowserActionListener");
        ((com.tencent.mobileqq.webview.util.h) currentWebViewFragment).i2(isShowNext);
    }

    private final void T2() {
        View view = this.webContainerView;
        if (view != null && view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.activity.da
                @Override // java.lang.Runnable
                public final void run() {
                    HalfScreenBrowserActivity.U2(HalfScreenBrowserActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(HalfScreenBrowserActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.webContainerView;
        if (view != null && view != null) {
            view.setVisibility(0);
        }
    }

    private final void initView() {
        N2();
        M2();
        R2();
    }

    @Override // com.tencent.mobileqq.webview.util.i
    public void J0(boolean isShowNext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isShowNext);
        } else {
            QLog.i("HalfScreenBrowserActivity", 1, "onHalfScreenBrowserDestroy");
            S2(isShowNext);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            S2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        Q2();
        this.mFragmentClass = com.tencent.mobileqq.webview.util.f.f314875a.g(getIntent().getExtras());
        this.webViewHeight = getIntent().getFloatExtra("webViewHeightRatio", 0.0f);
        this.webContainerViewHeight = getIntent().getIntExtra("webViewFullHeight", ImmersiveUtils.getScreenHeight());
        this.webViewBgRes = getIntent().getIntExtra("webViewBgRes", 0);
        this.backgroundColorId = getIntent().getIntExtra("backgroundColorId", R.color.by);
        this.webViewScaleDensity = getIntent().getFloatExtra("webViewScaleDensity", 0.0f);
        this.businessId = getIntent().getIntExtra("businessId", -1);
        L2();
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        initView();
        T2();
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.webview.util.h
    public void i2(boolean isShowNext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isShowNext);
            return;
        }
        View view = this.webContainerView;
        if (view != null) {
            view.setVisibility(8);
        }
        doFinish();
        QLog.d("HalfScreenBrowserActivity", 1, "onDismissWithAnimation");
        if (isShowNext) {
            QLog.i("HalfScreenBrowserActivity", 1, "show next dialog");
            com.tencent.mobileqq.webview.util.e.f314868a.d();
        } else {
            com.tencent.mobileqq.webview.util.e.f314868a.c();
            ((IHalfScreenBrowserApi) QRoute.api(IHalfScreenBrowserApi.class)).webViewClose(this.businessId);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            com.tencent.mobileqq.webview.util.e.f314868a.j(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, hasFocus);
            return;
        }
        super.onWindowFocusChanged(hasFocus);
        if (!(getCurrentWebViewFragment() instanceof HalfScreenBrowserFragment) || !hasFocus) {
            return;
        }
        QLog.d("HalfScreenBrowserActivity", 1, "set actionListener, is Focus " + hasFocus);
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        Intrinsics.checkNotNull(currentWebViewFragment, "null cannot be cast to non-null type com.tencent.mobileqq.HalfScreenBrowserFragment");
        ((HalfScreenBrowserFragment) currentWebViewFragment).yh(this);
    }
}

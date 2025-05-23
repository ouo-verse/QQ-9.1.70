package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.qrcode.activity.UnlockPCQuickVerifyActivity;
import com.tencent.biz.qrcode.logindev.pclock.LockPCServiceHandler;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qrcode/activity/UnlockPCQuickVerifyActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Landroid/content/Intent;", "intent", "", "initData", "initUI", "L2", "M2", "K2", "I2", "initBackground", "N2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnResume", "doOnNewIntent", "doOnPause", "onPostThemeChanged", "finish", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "a0", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "", "b0", "Ljava/lang/String;", "mDeviceName", "", "c0", "Ljava/lang/Integer;", "mInstanceId", "d0", "mPlatformId", "<init>", "()V", "e0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class UnlockPCQuickVerifyActivity extends QBaseActivity {

    /* renamed from: f0, reason: collision with root package name */
    @NotNull
    private static final a.b f94824f0 = new a.b(0.7f, 0.5f, 0.3f, 0.5f, 0.0f);

    /* renamed from: g0, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f94825g0;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f94826h0;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPolarLightView polarLightView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mDeviceName;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mInstanceId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mPlatformId;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qrcode/activity/UnlockPCQuickVerifyActivity$b", "Lcom/tencent/biz/qrcode/logindev/pclock/g;", "", "retCode", "", "errorMsg", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements com.tencent.biz.qrcode.logindev.pclock.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rd0.g f94831a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UnlockPCQuickVerifyActivity f94832b;

        b(rd0.g gVar, UnlockPCQuickVerifyActivity unlockPCQuickVerifyActivity) {
            this.f94831a = gVar;
            this.f94832b = unlockPCQuickVerifyActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(UnlockPCQuickVerifyActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                QQToast.makeText(topActivity, this$0.getString(R.string.f21706600), 0).show();
            }
        }

        @Override // com.tencent.biz.qrcode.logindev.pclock.g
        public void onResult(int retCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.d("UnlockPCQuickVerifyActivity", 1, "unlock PC onResult retCode " + retCode + ", errorMsg: " + errorMsg);
            if (retCode != 0) {
                rd0.g gVar = this.f94831a;
                Intrinsics.checkNotNull(this.f94832b.mInstanceId);
                gVar.s(r4.intValue(), 2);
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final UnlockPCQuickVerifyActivity unlockPCQuickVerifyActivity = this.f94832b;
                uIHandler.post(new Runnable() { // from class: com.tencent.biz.qrcode.activity.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnlockPCQuickVerifyActivity.b.b(UnlockPCQuickVerifyActivity.this);
                    }
                });
            }
        }
    }

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#FFEEB4")), Integer.valueOf(Color.parseColor("#FABCFF")), Integer.valueOf(Color.parseColor("#BAB8FF")), Integer.valueOf(Color.parseColor("#BDCFFF")), Integer.valueOf(Color.parseColor("#A3F0FF")), Integer.valueOf(Color.parseColor("#F3FFF6"))});
        f94825g0 = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#094789")), Integer.valueOf(Color.parseColor("#393BB8")), Integer.valueOf(Color.parseColor("#623982")), Integer.valueOf(Color.parseColor("#733E71")), Integer.valueOf(Color.parseColor("#804956")), Integer.valueOf(Color.parseColor("#80674A"))});
        f94826h0 = listOf2;
    }

    private final void I2() {
        findViewById(R.id.tzh).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.activity.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnlockPCQuickVerifyActivity.J2(UnlockPCQuickVerifyActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(UnlockPCQuickVerifyActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("UnlockPCQuickVerifyActivity", 1, "cancel unlock PC ");
        this$0.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K2() {
        String str;
        if (!TextUtils.isEmpty(this.mDeviceName)) {
            str = this.mDeviceName;
        } else {
            str = "\u7535\u8111";
        }
        ((TextView) findViewById(R.id.f114196so)).setText("\u5728 " + str + " \u8bbe\u5907\u4e0a\u89e3\u9501");
    }

    private final void L2() {
        ImageView imageView = (ImageView) findViewById(R.id.f114216sq);
        Integer num = this.mPlatformId;
        if (num != null && num.intValue() == 1029) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.qui_equipment_mac));
        }
    }

    private final void M2() {
        String str;
        Integer num = this.mPlatformId;
        if (num != null && num.intValue() == 1029) {
            str = Global.TRACKING_MAC;
        } else if (num != null && num.intValue() == 1024) {
            str = "Windows";
        } else if (num != null && num.intValue() == 1031) {
            str = "Linux";
        } else if (num != null && num.intValue() == 1035) {
            str = "Harmony";
        } else {
            str = "\u7535\u8111";
        }
        ((TextView) findViewById(R.id.f114226sr)).setText("\u89e3\u9501 " + str + " QQ");
    }

    private final void N2() {
        ((QUIButton) findViewById(R.id.tdr)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnlockPCQuickVerifyActivity.P2(UnlockPCQuickVerifyActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(UnlockPCQuickVerifyActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("UnlockPCQuickVerifyActivity", 2, "start unlock pc");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        ReportController.y(qQAppInterface, "0X800C5C9");
        if (!NetworkUtil.isNetworkAvailable(this$0)) {
            QQToast.makeText(this$0, this$0.getString(R.string.f21707601), 0).show();
        } else {
            Manager manager = qQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.qrcode.logindev.LoginDevicesManager");
            rd0.g gVar = (rd0.g) manager;
            BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOCK_PC);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.biz.qrcode.logindev.pclock.LockPCServiceHandler");
            LockPCServiceHandler lockPCServiceHandler = (LockPCServiceHandler) businessHandler;
            Integer num = this$0.mInstanceId;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this$0.mInstanceId;
                Intrinsics.checkNotNull(num2);
                lockPCServiceHandler.D2(false, num2.intValue(), new b(gVar, this$0));
                gVar.s(intValue, 1);
            }
            this$0.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initBackground() {
        ViewGroup.LayoutParams layoutParams;
        PolarImageRender polarImageRender;
        PolarImageRender polarImageRender2;
        PolarImageRender polarImageRender3;
        PolarImageRender polarImageRender4;
        PolarImageRender polarImageRender5;
        Drawable drawable = getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f642335o);
        if (QQTheme.isVasTheme()) {
            viewGroup.setBackground(drawable);
            return;
        }
        QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) findViewById(R.id.f26270d3);
        this.polarLightView = qUIPolarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.setVisibility(0);
        }
        QUIPolarLightView qUIPolarLightView2 = this.polarLightView;
        PolarImageRender polarImageRender6 = null;
        if (qUIPolarLightView2 != null) {
            layoutParams = qUIPolarLightView2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = (int) (ViewUtils.getScreenHeight() * 0.6d);
        }
        QUIPolarLightView qUIPolarLightView3 = this.polarLightView;
        if (qUIPolarLightView3 != null) {
            polarImageRender = qUIPolarLightView3.getPolarLightRender();
        } else {
            polarImageRender = null;
        }
        if (polarImageRender != null) {
            polarImageRender.p(0.025f);
        }
        QUIPolarLightView qUIPolarLightView4 = this.polarLightView;
        if (qUIPolarLightView4 != null) {
            polarImageRender2 = qUIPolarLightView4.getPolarLightRender();
        } else {
            polarImageRender2 = null;
        }
        if (polarImageRender2 != null) {
            polarImageRender2.r(0.5f);
        }
        QUIPolarLightView qUIPolarLightView5 = this.polarLightView;
        if (qUIPolarLightView5 != null) {
            polarImageRender3 = qUIPolarLightView5.getPolarLightRender();
        } else {
            polarImageRender3 = null;
        }
        if (polarImageRender3 != null) {
            polarImageRender3.q(f94824f0);
        }
        if (QQTheme.isNowThemeIsNight()) {
            QUIPolarLightView qUIPolarLightView6 = this.polarLightView;
            if (qUIPolarLightView6 != null) {
                polarImageRender5 = qUIPolarLightView6.getPolarLightRender();
            } else {
                polarImageRender5 = null;
            }
            if (polarImageRender5 != null) {
                polarImageRender5.s(f94826h0);
            }
        } else {
            QUIPolarLightView qUIPolarLightView7 = this.polarLightView;
            if (qUIPolarLightView7 != null) {
                polarImageRender4 = qUIPolarLightView7.getPolarLightRender();
            } else {
                polarImageRender4 = null;
            }
            if (polarImageRender4 != null) {
                polarImageRender4.s(f94825g0);
            }
        }
        QUIPolarLightView qUIPolarLightView8 = this.polarLightView;
        if (qUIPolarLightView8 != null) {
            polarImageRender6 = qUIPolarLightView8.getPolarLightRender();
        }
        if (polarImageRender6 != null) {
            polarImageRender6.q(f94824f0);
        }
    }

    private final void initData(Intent intent) {
        this.mInstanceId = Integer.valueOf(intent.getIntExtra("instanceId", 0));
        this.mDeviceName = intent.getStringExtra("deviceName");
        this.mPlatformId = Integer.valueOf(intent.getIntExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, 0));
    }

    private final void initUI() {
        setContentView(R.layout.hby);
        initBackground();
        L2();
        M2();
        K2();
        I2();
        N2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        setTheme(R.style.f173949nq);
        super.doOnCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        initData(intent);
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(@Nullable Intent intent) {
        super.doOnNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            initData(intent);
        }
        L2();
        M2();
        K2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReportController.y((QQAppInterface) peekAppRuntime, "0X800C5C8");
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.m();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.f154458a7);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        initBackground();
    }
}

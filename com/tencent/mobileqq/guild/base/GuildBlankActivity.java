package com.tencent.mobileqq.guild.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildNavigationBarImmersiveHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildBlankActivity extends QBaseActivity {

    /* renamed from: e0, reason: collision with root package name */
    public static String f214673e0 = "standalone_channel_param";

    /* renamed from: f0, reason: collision with root package name */
    private static int f214674f0 = 300;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f214675a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f214676b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f214677c0 = true;

    /* renamed from: d0, reason: collision with root package name */
    private final i.a f214678d0 = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements i.a {
        a() {
        }

        @Override // com.tencent.mobileqq.pad.i.a
        public void a(boolean z16) {
            GuildBlankActivity.this.f214675a0 = !z16;
        }

        @Override // com.tencent.mobileqq.pad.i.a
        public void onStart() {
            GuildBlankActivity.this.f214675a0 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {
        public static void a(Context context, JumpGuildParam jumpGuildParam) {
            Intent intent = new Intent();
            intent.setClass(context, GuildBlankActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.addFlags(603979776);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra(GuildBlankActivity.f214673e0, (Parcelable) jumpGuildParam);
            GuildJumpDebugUtils.a("Guild.jump.", "GuildBlankActivity.Launcher::open() intent = ", intent);
            context.startActivity(intent);
        }
    }

    private boolean H2() {
        AppRuntime Q0 = ch.Q0();
        if (Q0 == null || ((IKernelService) Q0.getRuntimeService(IKernelService.class, "")).getWrapperSession() == null) {
            return false;
        }
        return true;
    }

    private void I2() {
        GuildNavigationBarImmersiveHelper.f235359a.J(getWindow());
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2() {
        if (!getActivity().isFinishing()) {
            finish();
        }
    }

    private void K2(Context context, JumpGuildParam jumpGuildParam) {
        QLog.d("GuildBlankActivity", 1, "openChannelOnDefault: params[" + jumpGuildParam.toString() + "]");
        int D = ch.D(jumpGuildParam.getChannelId());
        if (jumpGuildParam.isGuest() && D == 6) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(context, jumpGuildParam);
            finish();
            return;
        }
        this.f214675a0 = false;
        i.a(this.f214678d0);
        boolean L2 = L2(context, jumpGuildParam);
        i.d(this.f214678d0);
        if (!L2 || this.f214675a0) {
            if (GuildSplitViewUtils.f235370a.n(context)) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.base.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildBlankActivity.this.J2();
                    }
                }, 500L);
            } else {
                finish();
            }
        }
        QLog.i("GuildBlankActivity", 1, "openChannelOnDefault: openSuccess[" + L2 + "]");
    }

    private boolean L2(Context context, JumpGuildParam jumpGuildParam) {
        if (jumpGuildParam.isDirectMessage()) {
            return ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).loadGuildDirectMessageAio(context, jumpGuildParam, 3);
        }
        return ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).loadGuildChannelWithFullGuild(context, jumpGuildParam);
    }

    private void setUpOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
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
    public void doOnSaveInstanceState(Bundle bundle) {
        super.doOnSaveInstanceState(bundle);
        QLog.i("GuildBlankActivity", 1, "doOnSaveInstanceState");
        bundle.putBoolean("FIRST_INIT", this.f214677c0);
        bundle.putBoolean("SHOULD_CLOSE_ON_RESUME", this.f214676b0);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        QLog.i("GuildBlankActivity", 1, "onCreate: " + this.f214677c0);
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        requestWindowFeature(getIntent());
        setUpOrientation();
        super.onCreate(bundle);
        I2();
        if (bundle != null) {
            this.f214677c0 = bundle.getBoolean("FIRST_INIT", false);
        }
        if (!H2()) {
            QLog.e("GuildBlankActivity", 1, "onCreate: sdk is not ready");
            finish();
            return;
        }
        JumpGuildParam jumpGuildParam = (JumpGuildParam) getIntent().getParcelableExtra(f214673e0);
        if (jumpGuildParam != null) {
            if (this.f214677c0) {
                K2(this, jumpGuildParam);
            }
        } else {
            finish();
        }
        if (bundle != null) {
            QLog.i("GuildBlankActivity", 1, "onCreate: restore shouldClose");
            this.f214676b0 = bundle.getBoolean("SHOULD_CLOSE_ON_RESUME", false);
        } else {
            this.f214676b0 = false;
        }
        this.f214677c0 = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        QLog.i("GuildBlankActivity", 1, "onCreateView");
        if (ImmersiveUtils.isSupporImmersive() != 0) {
            ImmersiveUtils.setTranslucentStatus(getWindow());
        }
        return super.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        QLog.i("GuildBlankActivity", 1, "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        JumpGuildParam jumpGuildParam = (JumpGuildParam) getIntent().getParcelableExtra(f214673e0);
        if (jumpGuildParam != null) {
            K2(this, jumpGuildParam);
        } else {
            QLog.w("GuildBlankActivity", 1, "onNewIntent: param is null");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        QLog.w("GuildBlankActivity", 1, "onResume should finish:" + this.f214676b0);
        super.onResume();
        if (this.f214676b0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.base.GuildBlankActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildBlankActivity.this.finish();
                }
            }, f214674f0);
        } else {
            this.f214676b0 = true;
            final WeakReference weakReference = new WeakReference(this);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.base.GuildBlankActivity.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null && !activity.isFinishing() && QBaseActivity.sTopActivity == activity) {
                        QLog.i("GuildBlankActivity", 1, "onResume: finish, after start feed");
                        activity.finish();
                    }
                }
            }, 2000L);
        }
        TraceUtils.n("Guild.Jump.ShowPage.GuildBlankActivity");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        super.requestWindowFeature(intent);
        if (intent.hasExtra("public_fragment_window_feature")) {
            requestWindowFeature(intent.getIntExtra("public_fragment_window_feature", 0));
        }
    }
}

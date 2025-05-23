package com.tencent.qqnt.aio.localactivity;

import ae0.a;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.activity.AIODelegate;
import com.tencent.qqnt.aio.activity.j;
import com.tencent.qqnt.aio.e;
import com.tencent.qqnt.aio.palette.b;
import com.tencent.qqnt.aio.palette.c;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0014J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0000H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010!\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010!\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0016J9\u0010(\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0%\"\u0004\u0018\u00010&H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010+\u001a\u00020*J\u0010\u0010-\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001J\b\u0010/\u001a\u00020.H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010#2\u0006\u00100\u001a\u00020&H\u0016R\u0016\u00104\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/qqnt/aio/localactivity/AIOLocalActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/qqnt/aio/e;", "", "setCustomColorPalette", "clearCustomTheme", "M2", "L2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnStart", "doOnResume", "doOnPause", "doOnStop", "doOnDestroy", "Landroid/content/Intent;", "intent", "doOnNewIntent", "", "requestCode", "requestCode2", "data", "doOnActivityResult", "dispatchOnActivityResult", "doOnBackPressed", "J2", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "sendMessage", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "options", "", "caller", "", "", "permissions", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "Lcom/tencent/qqnt/aio/activity/j;", "I2", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "K2", "Landroid/content/res/Resources;", "getResources", "name", "getSystemService", "a0", "Ljava/lang/String;", "mQuiProfileId", "b0", "Landroid/content/res/Resources;", "mQuiProfileResources", "Landroid/view/LayoutInflater;", "c0", "Landroid/view/LayoutInflater;", "mQuiProfileLayoutInflater", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "d0", "Lkotlin/Lazy;", "getMDelegate", "()Lcom/tencent/qqnt/aio/activity/AIODelegate;", "mDelegate", "e0", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mHostActivity", "<init>", "()V", "f0", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOLocalActivity extends QBaseActivity implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f351191g0;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f351192h0;

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f351193i0;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mQuiProfileId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Resources mQuiProfileResources;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LayoutInflater mQuiProfileLayoutInflater;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDelegate;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity mHostActivity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/localactivity/AIOLocalActivity$a;", "", "", "parentCheckSwitch$delegate", "Lkotlin/Lazy;", "e", "()Z", "parentCheckSwitch", "mobileQQResumedActivitySwitch$delegate", "d", "mobileQQResumedActivitySwitch", "topActivitySetSwitch$delegate", "f", "topActivitySetSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.localactivity.AIOLocalActivity$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) AIOLocalActivity.f351192h0.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean e() {
            return ((Boolean) AIOLocalActivity.f351191g0.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f() {
            return ((Boolean) AIOLocalActivity.f351193i0.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        Lazy<Boolean> lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27855);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOLocalActivity$Companion$parentCheckSwitch$2.INSTANCE);
        f351191g0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOLocalActivity$Companion$mobileQQResumedActivitySwitch$2.INSTANCE);
        f351192h0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOLocalActivity$Companion$topActivitySetSwitch$2.INSTANCE);
        f351193i0 = lazy3;
    }

    public AIOLocalActivity() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mQuiProfileId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIODelegate>() { // from class: com.tencent.qqnt.aio.localactivity.AIOLocalActivity$mDelegate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLocalActivity.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIODelegate invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AIODelegate(AIOLocalActivity.this, "AIOLocalActivity") : (AIODelegate) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mDelegate = lazy;
    }

    private final void L2() {
        QBaseActivity qBaseActivity;
        if (INSTANCE.f() && (qBaseActivity = this.mHostActivity) != null) {
            QBaseActivity.sTopActivity = qBaseActivity;
            QLog.i("AIOLocalActivity", 1, "[setTopActivity]: topActivity is " + qBaseActivity);
        }
    }

    private final void M2() {
        if (!INSTANCE.d()) {
            return;
        }
        List<WeakReference<AppActivity>> list = MobileQQ.sMobileQQ.appActivities;
        if (list != null) {
            list.remove(new WeakReference(this));
        }
        QLog.i("AIOLocalActivity", 1, "[updateGlobalResumeActivity]: resumedActivity is " + MobileQQ.sMobileQQ.getResumeActivity());
    }

    private final void clearCustomTheme() {
        boolean z16;
        if (this.mQuiProfileId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            c.f351747a.a(this, this.mQuiProfileId);
            this.mQuiProfileId = "";
            this.mQuiProfileResources = null;
            this.mQuiProfileLayoutInflater = null;
        }
        getIntent().removeExtra("key_open_color_palette");
    }

    private final AIODelegate getMDelegate() {
        return (AIODelegate) this.mDelegate.getValue();
    }

    private final void setCustomColorPalette() {
        clearCustomTheme();
        Pair<String, a> a16 = b.f351744a.a(new com.tencent.qqnt.aio.palette.a(getIntent().getIntExtra("key_chat_type", 0), getIntent().getExtras()));
        if (a16 != null) {
            String first = a16.getFirst();
            this.mQuiProfileId = first;
            c.f351747a.b(this, first, a16.getSecond());
            getIntent().putExtra("key_open_color_palette", true);
        }
    }

    @NotNull
    public final j I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (j) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return getMDelegate();
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    /* renamed from: J2, reason: merged with bridge method [inline-methods] */
    public AIOLocalActivity getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AIOLocalActivity) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this;
    }

    public final void K2(@Nullable QBaseActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
        } else {
            this.mHostActivity = activity;
            L2();
        }
    }

    public final void dispatchOnActivityResult(int requestCode, int requestCode2, @Nullable Intent data) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(requestCode), Integer.valueOf(requestCode2), data);
            return;
        }
        if (data != null) {
            bundle = data.getExtras();
        } else {
            bundle = null;
        }
        QLog.i("AIOLocalActivity", 4, "[dispatchOnActivityResult]: requestCode=" + requestCode + ", requestCode2=" + requestCode2 + ", data is " + bundle);
        onActivityResult(requestCode, requestCode2, data);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int requestCode2, @Nullable Intent data) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(requestCode2), data);
            return;
        }
        super.doOnActivityResult(requestCode, requestCode2, data);
        if (data != null) {
            bundle = data.getExtras();
        } else {
            bundle = null;
        }
        QLog.i("AIOLocalActivity", 4, "[doOnActivityResult]: requestCode=" + requestCode + ", requestCode2=" + requestCode2 + ", data is " + bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (!getMDelegate().c()) {
            getMDelegate().a(new ExternalCommIntent("close_aio", new Bundle()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        if (getParent() == null && INSTANCE.e()) {
            finish();
            QLog.i("AIOLocalActivity", 1, "[doOnCreate]: parent is null, finish");
            return false;
        }
        this.mActNeedImmersive = false;
        setCustomColorPalette();
        super.doOnCreate(savedInstanceState);
        QLog.i("AIOLocalActivity", 1, "[doOnCreate]: activity is " + this + ", data is " + com.tencent.qqnt.aio.utils.b.a(getIntent().getExtras()));
        setContentView(getMDelegate().show());
        M2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnDestroy();
        clearCustomTheme();
        this.mHostActivity = null;
        QLog.i("AIOLocalActivity", 1, "[doOnDestroy]: activity is " + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.doOnNewIntent(intent);
        setIntent(intent);
        setCustomColorPalette();
        QLog.i("AIOLocalActivity", 1, "[doOnNewIntent]: activity is " + this + " , data is " + com.tencent.qqnt.aio.utils.b.a(intent.getExtras()));
        getMDelegate().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        QLog.i("AIOLocalActivity", 1, "[doOnPause]: activity is " + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        QLog.i("AIOLocalActivity", 1, "[doOnResume]: activity is " + this);
        L2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnStart();
        QLog.i("AIOLocalActivity", 1, "[doOnStart]: activity is " + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("AIOLocalActivity", 1, "[doOnStop]: activity is " + this);
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public AIOContact getAIOContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AIOContact) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return getMDelegate().getAIOContact();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Resources) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (this.mQuiProfileId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.mQuiProfileResources == null) {
            this.mQuiProfileResources = new QUIProfileResources(super.getResources(), this, this.mQuiProfileId);
        }
        Resources resources = this.mQuiProfileResources;
        if (resources == null) {
            Resources resources2 = super.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "super.getResources()");
            return resources2;
        }
        return resources;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return iPatchRedirector.redirect((short) 21, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.mQuiProfileId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                if (this.mQuiProfileLayoutInflater == null) {
                    this.mQuiProfileLayoutInflater = new QUIProfileLayoutInflater((LayoutInflater) systemService, this, this.mQuiProfileId);
                }
                return this.mQuiProfileLayoutInflater;
            }
        }
        return super.getSystemService(name);
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return e.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return e.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, mqq.app.IPermissionRequester
    public void requestPermissions(@Nullable Object caller, int requestCode, @NotNull String... permissions) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, caller, Integer.valueOf(requestCode), permissions);
            return;
        }
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        QBaseActivity qBaseActivity = this.mHostActivity;
        if (qBaseActivity != null) {
            qBaseActivity.requestPermissions(caller, requestCode, (String[]) Arrays.copyOf(permissions, permissions.length));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("AIOLocalActivity", 1, "[requestPermissions]: hostActivity is " + this.mHostActivity + ", caller is " + caller + ", requestCode is " + requestCode);
        }
    }

    @Override // com.tencent.qqnt.aio.e
    public void sendMessage(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            getMDelegate().a(msgIntent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(@Nullable Intent intent, int requestCode) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) intent, requestCode);
            return;
        }
        QBaseActivity qBaseActivity = this.mHostActivity;
        if (qBaseActivity != null) {
            qBaseActivity.startActivityForResult(intent, requestCode);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("AIOLocalActivity", 1, "[startActivityForResult]: hostActivity is " + this.mHostActivity + ", requestCode is " + requestCode);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(@Nullable Intent intent, int requestCode, @Nullable Bundle options) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, intent, Integer.valueOf(requestCode), options);
            return;
        }
        QBaseActivity qBaseActivity = this.mHostActivity;
        if (qBaseActivity != null) {
            qBaseActivity.startActivityForResult(intent, requestCode, options);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("AIOLocalActivity", 1, "[startActivityForResult]: hostActivity is " + this.mHostActivity + ", requestCode is " + requestCode + ", options is " + options);
        }
    }
}

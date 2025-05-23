package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOConvertApi;
import com.tencent.qqnt.aio.utils.AIOLocalActivitySwitch;
import com.tencent.qqnt.scaleaio.api.IScaleAIOApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u534a\u5c4fAIO\u9875\u9762", path = "/base/main/scaleaio")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0014R\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/activity/ScaleAIOActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "", "setCustomColorPalette", "clearCustomTheme", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "finish", "doOnDestroy", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "isWrapContent", "mQuiProfileId", "Ljava/lang/String;", "mQuiProfileResources", "Landroid/content/res/Resources;", "Landroid/view/LayoutInflater;", "mQuiProfileLayoutInflater", "Landroid/view/LayoutInflater;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ScaleAIOActivity extends QPublicFragmentActivity {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ScaleAIOActivity";

    @NotNull
    private String mQuiProfileId;

    @Nullable
    private LayoutInflater mQuiProfileLayoutInflater;

    @Nullable
    private Resources mQuiProfileResources;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/ScaleAIOActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.ScaleAIOActivity$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29994);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ScaleAIOActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mQuiProfileId = "";
        }
    }

    private final void clearCustomTheme() {
        boolean z16;
        if (this.mQuiProfileId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.qqnt.aio.palette.c.f351747a.a(this, this.mQuiProfileId);
            this.mQuiProfileId = "";
            this.mQuiProfileResources = null;
            this.mQuiProfileLayoutInflater = null;
        }
        getIntent().removeExtra("key_open_color_palette");
    }

    private final void setCustomColorPalette() {
        clearCustomTheme();
        if (!AIOLocalActivitySwitch.f352244a.a()) {
            return;
        }
        Pair<String, ae0.a> a16 = com.tencent.qqnt.aio.palette.b.f351744a.a(new com.tencent.qqnt.aio.palette.a(getIntent().getIntExtra("key_chat_type", 0), getIntent().getExtras()));
        if (a16 != null) {
            String first = a16.getFirst();
            this.mQuiProfileId = first;
            com.tencent.qqnt.aio.palette.c.f351747a.b(this, first, a16.getSecond());
            getIntent().putExtra("key_open_color_palette", true);
        }
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        if (getIntent().getBooleanExtra("key_is_backto_scale_chat", false)) {
            i3 = 0;
        } else {
            i3 = R.anim.f154440l8;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        IAIOConvertApi iAIOConvertApi = (IAIOConvertApi) companion.a(IAIOConvertApi.class);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        iAIOConvertApi.handleAIOIntent(intent);
        setCustomColorPalette();
        overridePendingTransition(i3, 0);
        getIntent().putExtra("public_fragment_class", ((IScaleAIOApi) companion.a(IScaleAIOApi.class)).getScaleAIOFragmentClassName());
        super.doOnCreate(savedInstanceState);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        clearCustomTheme();
        QLog.i(TAG, 1, "[doOnDestory]");
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.finish();
        com.tencent.qqnt.aio.utils.o.f352309a.a(this);
        if (getIntent().getBooleanExtra("key_is_scale_chat", true)) {
            overridePendingTransition(0, R.anim.f154441l9);
        } else {
            overridePendingTransition(0, R.anim.f154436l4);
        }
        QLog.e(TAG, 1, QLog.getStackTraceString(new Throwable("finishScaleAIO")));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Resources) iPatchRedirector.redirect((short) 5, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) name);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

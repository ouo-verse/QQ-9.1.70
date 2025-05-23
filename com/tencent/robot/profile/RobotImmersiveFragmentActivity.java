package com.tencent.robot.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QUIProfileConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w24.RobotColorPalette;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/profile/RobotImmersiveFragmentActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "", "setCustomColorPalette", "clearCustomTheme", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "Landroid/content/Intent;", "intent", "doOnNewIntent", "doOnDestroy", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "a0", "Ljava/lang/String;", "mQuiProfileId", "b0", "Landroid/content/res/Resources;", "mQuiProfileResources", "Landroid/view/LayoutInflater;", "c0", "Landroid/view/LayoutInflater;", "mQuiProfileLayoutInflater", "<init>", "()V", "d0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotImmersiveFragmentActivity extends QPublicFragmentActivity {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mQuiProfileId = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Resources mQuiProfileResources;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LayoutInflater mQuiProfileLayoutInflater;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J6\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tJ.\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/RobotImmersiveFragmentActivity$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "cls", "", "requestCode", "", "b", "Landroid/content/Context;", "context", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.RobotImmersiveFragmentActivity$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable Intent intent, @Nullable Class<? extends QPublicBaseFragment> cls) {
            QPublicFragmentActivity.b.b(context, intent, RobotImmersiveFragmentActivity.class, cls);
        }

        public final void b(@Nullable Activity activity, @Nullable Intent intent, @Nullable Class<? extends QPublicBaseFragment> cls, int requestCode) {
            QPublicFragmentActivity.b.e(activity, intent, RobotImmersiveFragmentActivity.class, cls, requestCode);
        }

        Companion() {
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
        Intent intent = getIntent();
        if (intent != null) {
            intent.removeExtra("key_open_color_palette");
        }
    }

    private final void setCustomColorPalette() {
        if (isDestroyed()) {
            QLog.w("RobotImmersiveFragmentActivity", 1, "setCustomColorPalette isDestroyed");
            return;
        }
        if (getIntent() == null) {
            return;
        }
        clearCustomTheme();
        RobotColorPalette d16 = w24.c.f444463a.d(getIntent().getExtras(), QUIProfileConstants.PROFILE_ID_ROBOT_PROFILE);
        String profileId = d16.getProfileId();
        this.mQuiProfileId = profileId;
        com.tencent.qqnt.aio.palette.c.f351747a.b(this, profileId, d16.getColorPalette());
        getIntent().putExtra("key_open_color_palette", true);
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
        return super.doOnCreate(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        clearCustomTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.doOnNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        boolean z16;
        boolean z17 = true;
        if (this.mQuiProfileId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            setCustomColorPalette();
        }
        if (this.mQuiProfileId.length() <= 0) {
            z17 = false;
        }
        if (z17 && this.mQuiProfileResources == null) {
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
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            boolean z17 = true;
            if (this.mQuiProfileId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                setCustomColorPalette();
            }
            if (this.mQuiProfileId.length() <= 0) {
                z17 = false;
            }
            if (z17 && this.mQuiProfileLayoutInflater == null) {
                Object systemService = super.getSystemService(name);
                if (systemService instanceof LayoutInflater) {
                    this.mQuiProfileLayoutInflater = new QUIProfileLayoutInflater((LayoutInflater) systemService, this, this.mQuiProfileId);
                }
            }
            LayoutInflater layoutInflater = this.mQuiProfileLayoutInflater;
            if (layoutInflater == null) {
                return super.getSystemService(name);
            }
            return layoutInflater;
        }
        return super.getSystemService(name);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.activity.AIODelegate;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.base.BaseActivity;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts.e;

/* compiled from: P */
@RoutePage(desc = "AIO\u9875\u9762", path = "/base/main/aio")
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0001,\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010!\u001a\u00020\u0017H\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/activity/AIOActivity;", "Lcom/tencent/qqnt/base/BaseActivity;", "Lcom/tencent/qqnt/aio/e;", "Lts/e$a;", "", "setExitAnim", "setEnterAnim", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "onEnterAnimationComplete", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "finish", "getContext", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "attachViewTree", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "sendMessage", "", "hasFocus", "onWindowFocusChanged", "isAttach", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isScale", "Lcom/tencent/qqnt/aio/activity/AIODelegate;", "mDelegate$delegate", "Lkotlin/Lazy;", "getMDelegate", "()Lcom/tencent/qqnt/aio/activity/AIODelegate;", "mDelegate", "mIsScale$delegate", "getMIsScale", "()Z", "mIsScale", "com/tencent/mobileqq/activity/AIOActivity$b", "mCloseAIOAction", "Lcom/tencent/mobileqq/activity/AIOActivity$b;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AIOActivity extends BaseActivity implements com.tencent.qqnt.aio.e, e.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOActivity";

    @NotNull
    private final b mCloseAIOAction;

    /* renamed from: mDelegate$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDelegate;

    /* renamed from: mIsScale$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mIsScale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/AIOActivity$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.AIOActivity$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/AIOActivity$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOActivity.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i(AIOActivity.TAG, 1, "[mCloseAIOAction]: close AIO");
            com.tencent.mobileqq.aio.utils.b.f194119a.d(AIOActivity.this.getMDelegate().getAIORootView(), data);
            AIOActivity.this.finish();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOActivity() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIODelegate>() { // from class: com.tencent.mobileqq.activity.AIOActivity$mDelegate$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOActivity.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIODelegate invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIODelegate) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIODelegate aIODelegate = new AIODelegate(AIOActivity.this, "AIOActivity");
                    aIODelegate.e0(AIOActivity.this);
                    return aIODelegate;
                }
            });
            this.mDelegate = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.activity.AIOActivity$mIsScale$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOActivity.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Boolean.valueOf(AIOActivity.this.getIntent().getBooleanExtra("key_is_scale_chat", false)) : (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mIsScale = lazy2;
            this.mCloseAIOAction = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIODelegate getMDelegate() {
        return (AIODelegate) this.mDelegate.getValue();
    }

    private final boolean getMIsScale() {
        return ((Boolean) this.mIsScale.getValue()).booleanValue();
    }

    private final void setEnterAnim() {
        int i3;
        if (getMIsScale()) {
            i3 = R.anim.f154424l;
        } else {
            i3 = R.anim.f154476ii;
        }
        overridePendingTransition(i3, 0);
    }

    private final void setExitAnim() {
        int i3;
        if (getMIsScale()) {
            i3 = R.anim.f154423k;
        } else {
            i3 = R.anim.f154478lt;
        }
        overridePendingTransition(0, i3);
    }

    @Override // ts.e.a
    public void attachViewTree() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            getMDelegate().c0("close_aio", this.mCloseAIOAction);
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.finish();
        setExitAnim();
        getMDelegate().n0("close_aio", this.mCloseAIOAction);
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public AIOContact getAIOContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AIOContact) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return getMDelegate().getAIOContact();
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public AIOActivity getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this : (AIOActivity) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.qqnt.base.BaseActivity
    public void initViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (!isFinishing() && !isDestroyed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return getMIsScale();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1001 && data != null) {
            data.getLongExtra("key_navigate_msgid", 0L);
            long longExtra = data.getLongExtra("key_navigate_msgseq", 0L);
            if (longExtra > 0) {
                getMDelegate().a(new MsgNavigationEvent.NavigateBySeqEvent("other", longExtra, 0L, false, null, true, false, null, 220, null));
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!getMDelegate().c()) {
            com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
            View aIORootView = getMDelegate().getAIORootView();
            Bundle bundle = new Bundle();
            bundle.putString("aio_disappear_type", "2");
            Unit unit = Unit.INSTANCE;
            bVar.d(aIORootView, bundle);
            super.onBackPressed();
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setTo(getResources().getDisplayMetrics());
        FontSettingManager.customMetrics = displayMetrics;
        super.onCreate(savedInstanceState);
        setContentView(getMDelegate().K(getMIsScale()));
        RFWImmersiveUtils.setTransparentStatusBar(getWindow());
        RFWImmersiveUtils.setImmersiveLayout(getWindow(), false);
        getMDelegate().T();
        getMDelegate().show();
        setEnterAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            getMDelegate().X();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onEnterAnimationComplete();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "send refresh avatar pendant event");
        }
        ((IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class)).onAIOAnimationEnd(this, IAIOAnimationApi.AnimationScene.AIO_ENTER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            ((IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class)).onAIOAnimationStart(this, IAIOAnimationApi.AnimationScene.AIO_ENTER);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, hasFocus);
        } else {
            getMDelegate().S();
        }
    }

    @Override // com.tencent.qqnt.aio.e
    public void sendMessage(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            getMDelegate().a(msgIntent);
        }
    }
}

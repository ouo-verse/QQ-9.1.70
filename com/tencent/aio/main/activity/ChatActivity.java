package com.tencent.aio.main.activity;

import android.R;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aio.main.fragment.ChatFragment;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/main/activity/ChatActivity;", "Landroidx/fragment/app/FragmentActivity;", "", "F2", "H2", "", Constants.MMCCID, "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "onCreate", "onBackPressed", "Lcom/tencent/aio/main/fragment/ChatFragment;", "a0", "Lcom/tencent/aio/main/fragment/ChatFragment;", "mFragment", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatActivity extends FragmentActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ChatFragment mFragment;

    public ChatActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final void F2() {
        Bundle bundleExtra = getIntent().getBundleExtra("aio_bundle");
        if (bundleExtra != null) {
            this.mFragment = ChatFragment.INSTANCE.a(bundleExtra);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            ChatFragment chatFragment = this.mFragment;
            if (chatFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            }
            beginTransaction.add(R.id.content, chatFragment, ChatFragment.class.getName()).commitAllowingStateLoss();
        }
    }

    private final int G2() {
        return 9216;
    }

    private final void H2() {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Window window2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "window");
        View decorView2 = window2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
        decorView.setSystemUiVisibility(decorView2.getSystemUiVisibility() | G2());
        Window window3 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window3, "window");
        window3.setStatusBarColor(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            ChatFragment chatFragment = this.mFragment;
            if (chatFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFragment");
            }
            if (!chatFragment.getProvider$sdk_debug().onBackPressed()) {
                super.onBackPressed();
                return;
            }
            return;
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) savedInstanceState);
            return;
        }
        H2();
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        F2();
    }
}

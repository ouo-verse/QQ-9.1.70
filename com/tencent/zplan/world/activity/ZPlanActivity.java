package com.tencent.zplan.world.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.UE4;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import com.tencent.zplan.engine.service.c;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.manager.b;
import dy4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zx4.d;

@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\f*\u0001F\b\u0016\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0011\u0012\b\b\u0002\u0010K\u001a\u00020$\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J/\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0006H\u0014J\b\u0010\u001d\u001a\u00020\u0006H\u0014J\b\u0010\u001e\u001a\u00020\u0006H\u0014J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0014J\u001a\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J \u0010+\u001a\u00020$2\u0006\u0010*\u001a\u00020)2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020)2\u0006\u0010#\u001a\u00020,H\u0016J\u0012\u0010/\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010,H\u0016J\b\u00100\u001a\u0004\u0018\u00010\u0004J\b\u00102\u001a\u0004\u0018\u000101R\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010>R\u0016\u0010E\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0017\u0010K\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bK\u0010L\u00a8\u0006Q"}, d2 = {"Lcom/tencent/zplan/world/activity/ZPlanActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/view/View$OnKeyListener;", "Landroid/view/View$OnTouchListener;", "Landroid/widget/FrameLayout;", "root", "", "L2", "J2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "onSaveInstanceState", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "finish", "onRestart", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/View;", "v", "onKey", "Landroid/view/MotionEvent;", "onTouch", "ev", "dispatchTouchEvent", "getRootView", "Ldy4/a;", "K2", "a0", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "b0", "Ldy4/a;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Landroid/os/Handler;", "c0", "Landroid/os/Handler;", "uiHandler", "d0", "Z", "renderReady", "e0", "renderInit", "f0", "renderPause", "g0", "renderDestroy", "com/tencent/zplan/world/activity/ZPlanActivity$engineInitListener$1", "h0", "Lcom/tencent/zplan/world/activity/ZPlanActivity$engineInitListener$1;", "engineInitListener", "i0", "isGame", "()Z", "<init>", "(Z)V", "j0", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class ZPlanActivity extends FragmentActivity implements View.OnKeyListener, View.OnTouchListener {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout rootView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private a render;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Handler uiHandler;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderReady;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderInit;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderPause;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean renderDestroy;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final ZPlanActivity$engineInitListener$1 engineInitListener;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final boolean isGame;

    public ZPlanActivity() {
        this(false, 1, null);
    }

    private final void J2() {
        c.INSTANCE.b(this.engineInitListener);
        if (this.renderReady) {
            a aVar = this.render;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
            }
            aVar.destroy();
        }
        this.renderDestroy = true;
        this.renderReady = false;
        this.renderInit = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L2(FrameLayout root) {
        boolean z16;
        d dVar;
        boolean z17;
        a aVar;
        a aVar2;
        boolean z18;
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanActivity", "initRender");
        if (GameActivityBase.singleton != null) {
            zLog.k("ZPlanActivity", "initRender renderInit is " + this.renderInit + ", renderDestroy is " + this.renderDestroy);
            if (!this.renderInit && !this.renderDestroy) {
                if (!this.isGame) {
                    d dVar2 = (d) mx4.a.f417748a.a(d.class);
                    if (dVar2 != null) {
                        z18 = dVar2.k();
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z16 = false;
                        zLog.k("ZPlanActivity", "initRender gameInMainWorld : " + z16);
                        dVar = (d) mx4.a.f417748a.a(d.class);
                        if (dVar == null) {
                            z17 = dVar.j();
                        } else {
                            z17 = false;
                        }
                        this.renderInit = true;
                        this.render = b.f386323a.c(this, z16);
                        this.renderReady = true;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        aVar = this.render;
                        if (aVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
                        }
                        root.addView(aVar.b(this, this, true, true, z17), 0, layoutParams);
                        UE4.setImmersiveMode(true);
                        if (this.renderReady && !this.renderPause) {
                            aVar2 = this.render;
                            if (aVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
                            }
                            aVar2.resume();
                        }
                        if (!this.renderDestroy) {
                            J2();
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                zLog.k("ZPlanActivity", "initRender gameInMainWorld : " + z16);
                dVar = (d) mx4.a.f417748a.a(d.class);
                if (dVar == null) {
                }
                this.renderInit = true;
                this.render = b.f386323a.c(this, z16);
                this.renderReady = true;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                aVar = this.render;
                if (aVar == null) {
                }
                root.addView(aVar.b(this, this, true, true, z17), 0, layoutParams2);
                UE4.setImmersiveMode(true);
                if (this.renderReady) {
                    aVar2 = this.render;
                    if (aVar2 == null) {
                    }
                    aVar2.resume();
                }
                if (!this.renderDestroy) {
                }
            }
        }
    }

    @Nullable
    public final a K2() {
        if (this.renderReady) {
            a aVar = this.render;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
                return aVar;
            }
            return aVar;
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, ev5, false, true);
        try {
            z16 = super.dispatchTouchEvent(ev5);
        } catch (Throwable unused) {
            z16 = false;
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, ev5, z16, false);
        return z16;
    }

    @Override // android.app.Activity
    public void finish() {
        ZLog.f386189b.k("ZPlanActivity", "finish");
        super.finish();
        this.renderPause = true;
        J2();
    }

    @Nullable
    public final FrameLayout getRootView() {
        return this.rootView;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onConfigurationChanged newConfig is ");
        sb5.append(newConfig);
        sb5.append(", orientation: ");
        sb5.append(newConfig.orientation);
        sb5.append(", bPortrait: ");
        boolean z16 = true;
        if (newConfig.orientation != 1) {
            z16 = false;
        }
        sb5.append(z16);
        zLog.k("ZPlanActivity", sb5.toString());
        super.onConfigurationChanged(newConfig);
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onConfigurationChanged(newConfig);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, newConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ZLog.f386189b.k("ZPlanActivity", "onCreate");
        super.onCreate(savedInstanceState);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.rootView = frameLayout;
        setContentView(frameLayout, layoutParams);
        c.INSTANCE.a(this.engineInitListener);
        L2(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ZLog.f386189b.k("ZPlanActivity", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        this.renderPause = true;
        J2();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(@NotNull View v3, int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        UE4.inputEvent(event);
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent newIntent) {
        ZLog.f386189b.k("ZPlanActivity", "onNewIntent");
        super.onNewIntent(newIntent);
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onNewIntent(newIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ZLog.f386189b.k("ZPlanActivity", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        if (this.renderReady) {
            a aVar = this.render;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
            }
            aVar.pause();
        }
        this.renderPause = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        ZLog.f386189b.k("ZPlanActivity", "onRequestPermissionsResult requestCode: " + requestCode);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        ZLog.f386189b.k("ZPlanActivity", "onRestart");
        super.onRestart();
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onRestart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ZLog.f386189b.k("ZPlanActivity", "onResume");
        super.onResume();
        if (this.renderReady) {
            a aVar = this.render;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ChildProcessServiceWrapper.PROCESS_TYPE_RENDER);
            }
            aVar.resume();
        }
        this.renderPause = false;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState, @NotNull PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        ZLog.f386189b.k("ZPlanActivity", "onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);
        GameActivity Get = GameActivity.Get();
        if (Get != null) {
            Get.onSaveInstanceState(outState, outPersistentState);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        UE4.inputEvent(event);
        return true;
    }

    public ZPlanActivity(boolean z16) {
        this.isGame = z16;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.engineInitListener = new ZPlanActivity$engineInitListener$1(this);
    }

    public /* synthetic */ ZPlanActivity(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}

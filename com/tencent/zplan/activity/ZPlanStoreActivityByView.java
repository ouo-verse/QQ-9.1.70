package com.tencent.zplan.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.UE4;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.zplan.common.utils.b;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.c;
import com.tencent.zplan.engine.service.d;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.view.ZPlanLoadingView;
import com.tencent.zplan.world.view.NormalRenderTextureView;
import com.tencent.zplan.world.view.a;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tx4.a;

@Deprecated(level = DeprecationLevel.ERROR, message = "Use ZPlanActivity instead")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0004J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\b\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/zplan/activity/ZPlanStoreActivityByView;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/tencent/zplan/view/ZPlanLoadingView$a;", "", "K2", "L2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "J2", "I2", "M2", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onCloseClick", "", "a0", "Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "b0", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/zplan/world/view/NormalRenderTextureView;", "c0", "Lcom/tencent/zplan/world/view/NormalRenderTextureView;", "textureView", "Lcom/tencent/zplan/view/ZPlanLoadingView;", "d0", "Lcom/tencent/zplan/view/ZPlanLoadingView;", "loadingPageView", "", "e0", "Z", "isEngineInited", "Ltx4/a;", "f0", "Ltx4/a;", "engineLoadingListener", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "g0", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "initListener", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "h0", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "firstFrameListener", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class ZPlanStoreActivityByView extends FragmentActivity implements ZPlanLoadingView.a {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private NormalRenderTextureView textureView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ZPlanLoadingView loadingPageView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isEngineInited;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "[zplan]_ZPlanStoreActivityByView";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final a engineLoadingListener = new ZPlanStoreActivityByView$engineLoadingListener$1(this);

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final GameActivityThunk.CMShowEngineInitFinishListener initListener = new ZPlanStoreActivityByView$initListener$1(this);

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final GameActivityThunk.CMShowEngineFirstFrameListener firstFrameListener = new ZPlanStoreActivityByView$firstFrameListener$1(this);

    private final void K2() {
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "this.baseContext");
        ZPlanLoadingView zPlanLoadingView = new ZPlanLoadingView(baseContext);
        this.loadingPageView = zPlanLoadingView;
        zPlanLoadingView.setCloseListener(this);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        View decorView = window.getDecorView();
        if (decorView != null) {
            ((ViewGroup) decorView).addView(this.loadingPageView);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2() {
        if (this.loadingPageView != null) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            View decorView = window.getDecorView();
            if (decorView != null) {
                ((ViewGroup) decorView).removeView(this.loadingPageView);
                this.loadingPageView = null;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void I2() {
        if (!this.isEngineInited || this.textureView != null) {
            return;
        }
        ZLog.f386189b.k(this.TAG, "addTextureView");
        this.textureView = new NormalRenderTextureView(this, true, false, 4, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.rootView;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.addView(this.textureView, layoutParams);
        UE4.enterAvatarShow(1);
    }

    @NotNull
    protected final View J2() {
        this.rootView = new FrameLayout(this);
        I2();
        ViewGroup viewGroup = this.rootView;
        Intrinsics.checkNotNull(viewGroup);
        return viewGroup;
    }

    public final void M2() {
        if (this.rootView != null && this.textureView != null) {
            ZLog.f386189b.k(this.TAG, "removeTextureView");
            ViewGroup viewGroup = this.rootView;
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.removeView(this.textureView);
            this.textureView = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.zplan.view.ZPlanLoadingView.a
    public void onCloseClick() {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        b bVar = b.f385287a;
        setContentView(J2(), new FrameLayout.LayoutParams(bVar.b(this), bVar.a(this)));
        super.onCreate(savedInstanceState);
        K2();
        d.f385635c.j();
        ZPlanServiceHelper.I.D0(this.engineLoadingListener);
        ZPlanLuaBridge.INSTANCE.registerPlugin(com.tencent.zplan.luabridge.plugins.a.f385727e);
        c.INSTANCE.a(this.initListener);
        com.tencent.zplan.engine.service.b.INSTANCE.a(this.firstFrameListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ZLog.f386189b.k(this.TAG, "onDestroy ");
        NormalRenderTextureView normalRenderTextureView = this.textureView;
        if (normalRenderTextureView != null) {
            normalRenderTextureView.onDestroy();
        }
        M2();
        ZPlanServiceHelper.I.Z0(this.engineLoadingListener);
        c.INSTANCE.b(this.initListener);
        com.tencent.zplan.engine.service.b.INSTANCE.b(this.firstFrameListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ZLog.f386189b.k(this.TAG, "onPause ");
        NormalRenderTextureView normalRenderTextureView = this.textureView;
        if (normalRenderTextureView != null) {
            normalRenderTextureView.onPause(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ZLog.f386189b.k(this.TAG, "onResume ");
        NormalRenderTextureView normalRenderTextureView = this.textureView;
        if (normalRenderTextureView != null) {
            a.C10078a.a(normalRenderTextureView, this, false, 2, null);
        }
    }
}

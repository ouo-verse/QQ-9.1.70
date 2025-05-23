package com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeWrapper;", "Lcom/tencent/mobileqq/app/lifecycle/DefaultBaseActivityLifecycleCallback;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeListener;", "", "onShakeComplete", "e", "g", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", HippyTextInputController.COMMAND_IS_FOCUSED, "doOnWindowFocusChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "params", h.F, "Z", "isRegistered", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "i", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "shakeSensor", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "<init>", "(Landroid/content/Context;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;Lkotlin/jvm/functions/Function0;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class VasAdvShakeWrapper extends DefaultBaseActivityLifecycleCallback implements LifecycleObserver, GdtShakeSensor.OnShakeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onShakeComplete;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GdtShakeSensor.Params params;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRegistered;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GdtShakeSensor shakeSensor;

    /* JADX WARN: Multi-variable type inference failed */
    public VasAdvShakeWrapper(Context context, qq_ad_get.QQAdGetRsp.AdInfo adInfo, Function0<Unit> onShakeComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onShakeComplete, "onShakeComplete");
        this.context = context;
        this.onShakeComplete = onShakeComplete;
        this.params = new GdtShakeSensor.Params(adInfo);
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
        if (context instanceof QBaseActivity) {
            ((QBaseActivity) context).registerActivityLifecycleCallbacks(this);
        }
        e();
    }

    public final void e() {
        if (this.isRegistered) {
            return;
        }
        QLog.d("VasAdvShakeWrapper", 2, "register");
        GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
        gdtShakeSensor.setShakeFactor(this.params);
        gdtShakeSensor.setShakeListener(new WeakReference<>(this));
        gdtShakeSensor.register(this.context);
        this.shakeSensor = gdtShakeSensor;
        this.isRegistered = true;
    }

    public final void f() {
        Object obj = this.context;
        if (obj instanceof LifecycleOwner) {
            ((LifecycleOwner) obj).getLifecycle().removeObserver(this);
        }
        Context context = this.context;
        if (context instanceof QBaseActivity) {
            ((QBaseActivity) context).unregisterActivityLifecycleCallbacks(this);
        }
        g();
    }

    public final void g() {
        if (this.isRegistered) {
            QLog.d("VasAdvShakeWrapper", 2, "unregister");
            GdtShakeSensor gdtShakeSensor = this.shakeSensor;
            if (gdtShakeSensor != null) {
                gdtShakeSensor.unregister(this.context);
            }
            this.shakeSensor = null;
            this.isRegistered = false;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        f();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        g();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        e();
    }

    @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
    public void onShakeComplete() {
        QLog.d("VasAdvShakeWrapper", 1, "onShakeComplete");
        this.onShakeComplete.invoke();
        GdtShakeSensor gdtShakeSensor = this.shakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
        g();
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnWindowFocusChanged(Activity activity, boolean isFocused) {
        if (isFocused) {
            e();
        } else {
            g();
        }
    }
}

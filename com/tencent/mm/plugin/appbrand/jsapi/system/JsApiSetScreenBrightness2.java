package com.tencent.mm.plugin.appbrand.jsapi.system;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.qc.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.a;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.mm.plugin.appbrand.jsapi.system.JsApiSetScreenBrightness2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiSetScreenBrightness2;", "Lcom/tencent/luggage/wxa/xd/a;", "Lcom/tencent/luggage/wxa/xd/d;", MosaicConstants$JsProperty.PROP_ENV, "Lorg/json/JSONObject;", "data", "", "callbackId", "", "invoke", "", "a", UserInfo.SEX_FEMALE, "currentBrightness", "Landroidx/lifecycle/LifecycleObserver;", "b", "Landroidx/lifecycle/LifecycleObserver;", "appLifecycleListener", "<init>", "()V", "c", "Companion", "luggage-commons-jsapi-default-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class JsApiSetScreenBrightness2 extends a {
    public static final int CTRL_INDEX = 229;

    @NotNull
    public static final String NAME = "setScreenBrightness";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float currentBrightness = Float.NaN;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public LifecycleObserver appLifecycleListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u001a\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiSetScreenBrightness2$Companion;", "", "Landroid/app/Activity;", "", "brightness", "", "a", "Lcom/tencent/luggage/wxa/xd/d;", "(Lcom/tencent/luggage/wxa/xd/d;)Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "CTRL_INDEX", "I", "MAGIC_OVERRIDE_NONE", UserInfo.SEX_FEMALE, "", "NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "luggage-commons-jsapi-default-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Activity a(d dVar) {
            return com.tencent.luggage.wxa.bo.a.a(dVar.getContext());
        }

        public final void a(Activity activity, float f16) {
            WindowManager.LayoutParams attributes;
            Window window = activity.getWindow();
            if (window == null || (attributes = window.getAttributes()) == null) {
                return;
            }
            if (Float.compare(-1.0f, f16) == 0) {
                attributes.screenBrightness = -1.0f;
            } else {
                attributes.screenBrightness = Math.max(f16, 0.01f);
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(final d env, final JSONObject data, final int callbackId) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mm.plugin.appbrand.jsapi.system.JsApiSetScreenBrightness2$invoke$logI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                w.d("Luggage.JsApiSetScreenBrightness2", "invoke(appId:" + d.this.getAppId() + ", callbackId:" + callbackId + ") " + message);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                a(str);
                return Unit.INSTANCE;
            }
        };
        env.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.system.JsApiSetScreenBrightness2$invoke$1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0075, code lost:
            
                r1 = (r0 = com.tencent.mm.plugin.appbrand.jsapi.system.JsApiSetScreenBrightness2.INSTANCE).a(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0068, code lost:
            
                if (java.lang.Float.compare(-1.0f, r0) != 0) goto L22;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                float f16;
                float f17;
                float f18;
                LifecycleObserver lifecycleObserver;
                JsApiSetScreenBrightness2.Companion companion;
                Activity a16;
                float f19;
                float f26;
                Function1.this.invoke("data:" + data + ", appState:" + env.getAppState());
                this.currentBrightness = (float) data.optDouble("value", Double.NaN);
                f16 = this.currentBrightness;
                if (!Float.isNaN(f16)) {
                    f17 = this.currentBrightness;
                    if (f17 <= 1.0f) {
                        f18 = this.currentBrightness;
                        if (f18 < 0.0f) {
                            f26 = this.currentBrightness;
                        }
                        if (b.FOREGROUND == env.getAppState() && a16 != null) {
                            f19 = this.currentBrightness;
                            companion.a(a16, f19);
                        }
                        lifecycleObserver = this.appLifecycleListener;
                        if (lifecycleObserver == null && env.getLifecycleOwner() != null) {
                            final JsApiSetScreenBrightness2 jsApiSetScreenBrightness2 = this;
                            final Function1 function12 = Function1.this;
                            final d dVar = env;
                            LifecycleObserver lifecycleObserver2 = new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.jsapi.system.JsApiSetScreenBrightness2$invoke$1.1
                                @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                                public final void onPaused() {
                                    Activity a17;
                                    Function1.this.invoke("onPaused, restore to BRIGHTNESS_OVERRIDE_NONE");
                                    JsApiSetScreenBrightness2.Companion companion2 = JsApiSetScreenBrightness2.INSTANCE;
                                    a17 = companion2.a(dVar);
                                    if (a17 != null) {
                                        companion2.a(a17, -1.0f);
                                    }
                                }

                                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                                public final void onResumed() {
                                    float f27;
                                    float f28;
                                    Activity a17;
                                    float f29;
                                    f27 = jsApiSetScreenBrightness2.currentBrightness;
                                    if (!Float.isNaN(f27)) {
                                        Function1 function13 = Function1.this;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("onResumed, restore to ");
                                        f28 = jsApiSetScreenBrightness2.currentBrightness;
                                        sb5.append(f28);
                                        function13.invoke(sb5.toString());
                                        JsApiSetScreenBrightness2.Companion companion2 = JsApiSetScreenBrightness2.INSTANCE;
                                        a17 = companion2.a(dVar);
                                        if (a17 != null) {
                                            f29 = jsApiSetScreenBrightness2.currentBrightness;
                                            companion2.a(a17, f29);
                                        }
                                    }
                                }
                            };
                            LifecycleOwner lifecycleOwner = env.getLifecycleOwner();
                            Intrinsics.checkNotNull(lifecycleOwner);
                            lifecycleOwner.getLifecycle().addObserver(lifecycleObserver2);
                            jsApiSetScreenBrightness2.appLifecycleListener = lifecycleObserver2;
                        }
                        env.a(callbackId, this.makeReturnJson(e.f121305a));
                        return;
                    }
                }
                env.a(callbackId, this.makeReturnJson("fail: value invalid"));
            }
        });
    }
}

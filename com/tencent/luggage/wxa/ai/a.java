package com.tencent.luggage.wxa.ai;

import com.tencent.luggage.wxa.b8.p;
import com.tencent.luggage.wxa.b8.q;
import com.tencent.luggage.wxa.b8.r;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0007\u0007\b\u001c!\"#$B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0016H\u0016R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/luggage/wxa/ai/a;", "Lcom/tencent/luggage/wxa/j8/a;", "Lcom/tencent/luggage/wxa/xd/k0;", "event", "Lorg/json/JSONObject;", "data", "", "a", "b", "onVideoPlay", "onVideoPause", "onVideoEnded", "onVideoWaiting", "", "percent", "currentPosition", "duration", "Lcom/tencent/luggage/wxa/z7/c;", "invokeContext", "", "isSuccess", "state", "", "I", "mLastUpdatePos", "Ljava/lang/String;", "mEventData", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "c", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "mInvokeContext", "<init>", "()V", "d", "e", "f", "g", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.j8.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f121424e = "MicroMsg.SameLayer.AppBrandVideoCastEventHandler";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mLastUpdatePos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mEventData = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppBrandInvokeContext mInvokeContext;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6008a f121428a = new C6008a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_END;
        private static final int CTRL_INDEX = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6008a {
            public C6008a() {
            }

            public /* synthetic */ C6008a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6009a f121429a = new C6009a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_PAUSE;
        private static final int CTRL_INDEX = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6009a {
            public C6009a() {
            }

            public /* synthetic */ C6009a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6010a f121430a = new C6010a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_PLAY;
        private static final int CTRL_INDEX = 541;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6010a {
            public C6010a() {
            }

            public /* synthetic */ C6010a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6011a f121431a = new C6011a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_PROGRESS;
        private static final int CTRL_INDEX = 547;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6011a {
            public C6011a() {
            }

            public /* synthetic */ C6011a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6012a f121432a = new C6012a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_TIME_UPDATE;
        private static final int CTRL_INDEX = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6012a {
            public C6012a() {
            }

            public /* synthetic */ C6012a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends k0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6013a f121433a = new C6013a(null);

        @NotNull
        private static final String NAME = EmbeddedVideoJsPlugin.VIDEO_EVENT_WAITING;
        private static final int CTRL_INDEX = 540;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.a$g$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6013a {
            public C6013a() {
            }

            public /* synthetic */ C6013a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a(int percent) {
        w.d(f121424e, "onVideoProgress: " + percent);
        try {
            JSONObject b16 = b();
            b16.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, percent);
            b16.put("type", "DLNA");
            a(new e(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoProgress fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void b(boolean isSuccess) {
        String str = isSuccess ? "success" : "fail";
        w.d(f121424e, "onXWebDLNACastingStateChange: status = " + str);
        try {
            JSONObject b16 = b();
            b16.put("status", str);
            a(new r(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "onXWebDLNACastingStateChange fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void onVideoEnded() {
        w.d(f121424e, "onVideoEnded: ");
        try {
            JSONObject b16 = b();
            b16.put("type", "DLNA");
            a(new b(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoEnded fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void onVideoPause() {
        w.d(f121424e, "onVideoPause: ");
        try {
            JSONObject b16 = b();
            b16.put("type", "DLNA");
            a(new c(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoPause fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void onVideoPlay() {
        try {
            this.mLastUpdatePos = 0;
            JSONObject b16 = b();
            b16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            b16.put("type", "DLNA");
            a(new d(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoPlay fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void onVideoWaiting() {
        try {
            JSONObject b16 = b();
            b16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            b16.put("type", "DLNA");
            a(new g(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoWaiting fail", e16);
        }
    }

    private final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.mEventData);
        return jSONObject;
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a(int currentPosition, int duration) {
        w.d(f121424e, "onVideoTimeUpdate: currentPosition = " + currentPosition + " duration = " + duration);
        try {
            if (Math.abs(currentPosition - this.mLastUpdatePos) < 250) {
                return;
            }
            this.mLastUpdatePos = currentPosition;
            double d16 = 1000;
            double doubleValue = new BigDecimal((currentPosition * 1.0d) / d16).setScale(3, 4).doubleValue();
            JSONObject b16 = b();
            b16.put("type", "DLNA");
            b16.put("position", doubleValue);
            b16.put("duration", (duration * 1.0d) / d16);
            a(new f(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebVideoTimeUpdate fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a(@NotNull com.tencent.luggage.wxa.z7.c invokeContext) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        if (invokeContext instanceof AppBrandInvokeContext) {
            this.mInvokeContext = (AppBrandInvokeContext) invokeContext;
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a(boolean state) {
        w.d(f121424e, "onXWebCastingUserSelect: ");
        try {
            JSONObject b16 = b();
            b16.put("type", "DLNA");
            b16.put("state", state ? "success" : "fail");
            a(new q(), b16);
        } catch (JSONException e16) {
            w.b(f121424e, "OnXWebCastingUserSelect fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a() {
        try {
            a(new p(), b());
        } catch (JSONException e16) {
            w.b(f121424e, "onXWebCastingInterrupt fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.a
    public void a(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventData = data;
    }

    private final void a(k0 event, JSONObject data) {
        if (event != null) {
            if (!(event instanceof f) && !(event instanceof e)) {
                w.d(f121424e, "dispatch event:%s, data:%s", event.getName(), data.toString());
            }
            k0 data2 = event.setData(data.toString());
            AppBrandInvokeContext appBrandInvokeContext = this.mInvokeContext;
            if (appBrandInvokeContext != null) {
                Intrinsics.checkNotNull(appBrandInvokeContext);
                com.tencent.luggage.wxa.xd.d e16 = appBrandInvokeContext.e();
                if (e16 != null) {
                    if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                        com.tencent.luggage.wxa.ic.l lVar = (com.tencent.luggage.wxa.ic.l) e16;
                        Intrinsics.checkNotNull(data2);
                        lVar.a(data2, (int[]) null);
                        v J = lVar.J();
                        if (J != null) {
                            J.a(data2, (int[]) null);
                            return;
                        }
                        return;
                    }
                    if (e16 instanceof v) {
                        Intrinsics.checkNotNull(data2);
                        ((v) e16).a(data2, (int[]) null);
                    } else {
                        e16.a(data2, (int[]) null);
                    }
                }
            }
        }
    }
}

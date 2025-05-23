package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/EventId;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public @interface EventId {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f304293g;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/EventId$a;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTERMINAL_REQUEST_SDK_DYNAMIC", "(Ljava/lang/String;)V", "TERMINAL_REQUEST_SDK_DYNAMIC", "b", "setDYNAMIC_ENGINE_CREATE", "DYNAMIC_ENGINE_CREATE", "c", "setDYNAMIC_ENGINE_INITIATE", "DYNAMIC_ENGINE_INITIATE", "d", "setDYNAMIC_VIEW_CREATE", "DYNAMIC_VIEW_CREATE", "e", "setDYNAMIC_JS_LOAD", "DYNAMIC_JS_LOAD", "setDYNAMIC_VIEW_DISPLAY", "DYNAMIC_VIEW_DISPLAY", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.EventId$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* renamed from: g, reason: collision with root package name */
        static final /* synthetic */ Companion f304293g = new Companion();

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String TERMINAL_REQUEST_SDK_DYNAMIC = "terminal_requestSDK_dynamic";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String DYNAMIC_ENGINE_CREATE = "dynamic_engine_create";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String DYNAMIC_ENGINE_INITIATE = "dynamic_engine_initiate";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String DYNAMIC_VIEW_CREATE = "dynamic_view_create";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String DYNAMIC_JS_LOAD = "dynamic_js_load";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String DYNAMIC_VIEW_DISPLAY = "dynamic_view_display";

        Companion() {
        }

        @NotNull
        public final String a() {
            return DYNAMIC_ENGINE_CREATE;
        }

        @NotNull
        public final String b() {
            return DYNAMIC_ENGINE_INITIATE;
        }

        @NotNull
        public final String c() {
            return DYNAMIC_JS_LOAD;
        }

        @NotNull
        public final String d() {
            return DYNAMIC_VIEW_CREATE;
        }

        @NotNull
        public final String e() {
            return DYNAMIC_VIEW_DISPLAY;
        }

        @NotNull
        public final String f() {
            return TERMINAL_REQUEST_SDK_DYNAMIC;
        }
    }
}

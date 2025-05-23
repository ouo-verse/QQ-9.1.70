package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/b;", "Li01/e;", "", "params", "", "a", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/b$a;", "", "Landroid/content/Context;", "context", "", "a", "", "METHOD_ANNOUNCE_FOR_ACCESSIBILITY", "Ljava/lang/String;", "MODULE_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.b$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@Nullable Context context) {
            if (context == null) {
                return false;
            }
            try {
                Object systemService = context.getSystemService("accessibility");
                if (systemService != null) {
                    AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
                    if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                        return false;
                    }
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            } catch (Throwable unused) {
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(String params) {
        Integer intOrNull;
        if (!INSTANCE.a(getContext())) {
            return;
        }
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString(HippyHeaderListViewController.VIEW_TAG);
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"viewTag\")");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            String optString2 = k06.optString("announceText");
            View viewWithTag = viewWithTag(intValue);
            if (viewWithTag != null) {
                viewWithTag.announceForAccessibility(optString2);
            }
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.hashCode() == 285219214 && method.equals("announceForAccessibility")) {
            a(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}

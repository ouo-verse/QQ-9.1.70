package com.tencent.kuikly.core.render.android.expand.module;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRTurboDisplayModule;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "", "d", "Z", "getFirstScreenTurboDisplay", "()Z", "a", "(Z)V", "firstScreenTurboDisplay", "<init>", "()V", "e", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayModule extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean firstScreenTurboDisplay;

    public final void a(boolean z16) {
        this.firstScreenTurboDisplay = z16;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        com.tencent.kuikly.core.render.android.d O0;
        ViewGroup view;
        com.tencent.kuikly.core.render.android.d O02;
        ViewGroup view2;
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1207265522) {
            if (hashCode != -790125860) {
                if (hashCode == 229400208 && method.equals("setCurrentUIAsFirstScreenForNextLaunch")) {
                    com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
                    if (aVar == null || (O02 = aVar.O0()) == null || (view2 = O02.getView()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(view2.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRTurboDisplayModule$call$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.tencent.kuikly.core.render.android.a aVar2 = KRTurboDisplayModule.this.get_kuiklyRenderContext();
                            if (aVar2 != null) {
                                com.tencent.kuikly.core.render.android.turbo.b.b(aVar2);
                            }
                        }
                    }));
                }
            } else if (method.equals("closeTurboDisplay")) {
                com.tencent.kuikly.core.render.android.a aVar2 = get_kuiklyRenderContext();
                if (aVar2 == null || (O0 = aVar2.O0()) == null || (view = O0.getView()) == null) {
                    return null;
                }
                return Boolean.valueOf(view.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRTurboDisplayModule$call$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.kuikly.core.render.android.a aVar3 = KRTurboDisplayModule.this.get_kuiklyRenderContext();
                        if (aVar3 != null) {
                            com.tencent.kuikly.core.render.android.turbo.b.a(aVar3);
                        }
                    }
                }));
            }
        } else if (method.equals("isTurboDisplay")) {
            if (this.firstScreenTurboDisplay) {
                return "1";
            }
            return "0";
        }
        return super.call(method, params, callback);
    }
}

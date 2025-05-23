package com.tencent.kuikly.core.render.android.expand.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000ej\u0002`\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR8\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000ej\u0002`\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "callbackId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.kuikly.core.render.android.expand.module.a, reason: from toString */
/* loaded from: classes7.dex */
final /* data */ class HRCallbackWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callbackId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<Object, Unit> callback;

    public HRCallbackWrapper(@NotNull String callbackId, @NotNull Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbackId = callbackId;
        this.callback = callback;
    }

    @NotNull
    public final Function1<Object, Unit> a() {
        return this.callback;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCallbackId() {
        return this.callbackId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof HRCallbackWrapper) {
                HRCallbackWrapper hRCallbackWrapper = (HRCallbackWrapper) other;
                if (!Intrinsics.areEqual(this.callbackId, hRCallbackWrapper.callbackId) || !Intrinsics.areEqual(this.callback, hRCallbackWrapper.callback)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.callbackId;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Function1<Object, Unit> function1 = this.callback;
        if (function1 != null) {
            i16 = function1.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "HRCallbackWrapper(callbackId=" + this.callbackId + ", callback=" + this.callback + ")";
    }
}

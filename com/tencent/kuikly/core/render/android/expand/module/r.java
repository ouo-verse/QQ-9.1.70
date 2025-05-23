package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.tdf.module.TDFModulePromise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\fBi\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012\u0012+\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR9\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R9\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/r;", "Lcom/tencent/tdf/module/TDFModulePromise;", "", "getCallId", "", "isCallback", "", "result", "", "resolve", "error", "reject", "a", "Ljava/lang/String;", "callId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "b", "Lkotlin/jvm/functions/Function1;", "successCallback", "c", "errorCallback", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class r implements TDFModulePromise {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String callId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function1<Object, Unit> successCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1<Object, Unit> errorCallback;

    public r(@NotNull String callId, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        this.callId = callId;
        this.successCallback = function1;
        this.errorCallback = function12;
    }

    @Override // com.tencent.tdf.module.TDFModulePromise
    @NotNull
    public String getCallId() {
        return this.callId;
    }

    @Override // com.tencent.tdf.module.TDFModulePromise
    public boolean isCallback() {
        return !Intrinsics.areEqual(this.callId, "-1");
    }

    @Override // com.tencent.tdf.module.TDFModulePromise
    public void reject(@Nullable Object error) {
        String str;
        Function1<Object, Unit> function1 = this.errorCallback;
        if (function1 != null) {
            if (error != null) {
                str = com.tencent.kuikly.core.render.android.css.ktx.b.O(error);
            } else {
                str = null;
            }
            function1.invoke(str);
        }
    }

    @Override // com.tencent.tdf.module.TDFModulePromise
    public void resolve(@Nullable Object result) {
        String str;
        Function1<Object, Unit> function1 = this.successCallback;
        if (function1 != null) {
            if (result != null) {
                str = com.tencent.kuikly.core.render.android.css.ktx.b.O(result);
            } else {
                str = null;
            }
            function1.invoke(str);
        }
    }
}

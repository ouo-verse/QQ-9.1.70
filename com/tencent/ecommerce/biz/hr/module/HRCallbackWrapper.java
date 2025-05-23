package com.tencent.ecommerce.biz.hr.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012'\u0010\u0014\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR5\u0010\u0014\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "callbackId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "b", "Lkotlin/jvm/functions/Function1;", "callback", "c", "Z", "crossProcess", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.hr.module.i, reason: from toString */
/* loaded from: classes31.dex */
final /* data */ class HRCallbackWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String callbackId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Function1<Object, Unit> callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean crossProcess;

    public HRCallbackWrapper(String str, Function1<Object, Unit> function1, boolean z16) {
        this.callbackId = str;
        this.callback = function1;
        this.crossProcess = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.callbackId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Function1<Object, Unit> function1 = this.callback;
        int hashCode2 = (hashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
        boolean z16 = this.crossProcess;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "HRCallbackWrapper(callbackId=" + this.callbackId + ", callback=" + this.callback + ", crossProcess=" + this.crossProcess + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HRCallbackWrapper)) {
            return false;
        }
        HRCallbackWrapper hRCallbackWrapper = (HRCallbackWrapper) other;
        return Intrinsics.areEqual(this.callbackId, hRCallbackWrapper.callbackId) && Intrinsics.areEqual(this.callback, hRCallbackWrapper.callback) && this.crossProcess == hRCallbackWrapper.crossProcess;
    }
}

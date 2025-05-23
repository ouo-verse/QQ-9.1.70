package com.tencent.qmethod.monitor.base.defaultImpl;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
final class ATTAExceptionListener$onException$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f343496d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Throwable f343497e;

    @Override // java.lang.Runnable
    public final void run() {
        String joinToString$default;
        try {
            or3.a aVar = or3.a.f423465b;
            JSONArray jSONArray = new JSONArray();
            String str = this.f343496d;
            String message = this.f343497e.getMessage();
            if (message == null) {
                message = "";
            }
            StackTraceElement[] stackTrace = this.f343497e.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "exception.stackTrace");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(stackTrace, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            jSONArray.mo162put(or3.a.c(aVar, "appState", "exception", str, message, joinToString$default, null, 32, null));
            aVar.a(jSONArray);
        } catch (Throwable unused) {
        }
    }
}

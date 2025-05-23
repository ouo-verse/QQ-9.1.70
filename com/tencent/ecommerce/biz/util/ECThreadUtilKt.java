package com.tencent.ecommerce.biz.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0014\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\f"}, d2 = {"Lkotlin/Function0;", "", "runnable", "c", "", "delay", "block", "b", "a", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECThreadUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f104858a = new Handler(Looper.getMainLooper());

    public static final void a(Function0<Unit> function0) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getThreadPool().execOnSubThread(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.ecommerce.biz.util.ECThreadUtilKt$sam$java_lang_Runnable$0] */
    public static final void b(long j3, final Function0<Unit> function0) {
        Handler handler = f104858a;
        if (function0 != null) {
            function0 = new Runnable() { // from class: com.tencent.ecommerce.biz.util.ECThreadUtilKt$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            };
        }
        handler.postDelayed((Runnable) function0, j3);
    }

    public static final void c(final Function0<Unit> function0) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
        } else {
            f104858a.post(new Runnable() { // from class: com.tencent.ecommerce.biz.util.ECThreadUtilKt$uiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function0.this.invoke();
                }
            });
        }
    }
}

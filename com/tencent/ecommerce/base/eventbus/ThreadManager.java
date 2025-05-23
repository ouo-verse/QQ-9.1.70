package com.tencent.ecommerce.base.eventbus;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/ThreadManager;", "", "", "b", "Lkotlin/Function0;", "", "block", "c", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "mainHandler", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ThreadManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mainHandler;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadManager f100693b = new ThreadManager();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.ecommerce.base.eventbus.ThreadManager$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        mainHandler = lazy;
    }

    ThreadManager() {
    }

    private final Handler a() {
        return (Handler) mainHandler.getValue();
    }

    private final boolean b() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.ecommerce.base.eventbus.ThreadManager$sam$java_lang_Runnable$0] */
    public final void c(final Function0<Unit> block) {
        if (b()) {
            block.invoke();
            return;
        }
        Handler a16 = a();
        if (block != null) {
            block = new Runnable() { // from class: com.tencent.ecommerce.base.eventbus.ThreadManager$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            };
        }
        a16.post((Runnable) block);
    }
}

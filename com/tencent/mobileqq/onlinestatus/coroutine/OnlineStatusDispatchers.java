package com.tencent.mobileqq.onlinestatus.coroutine;

import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/coroutine/OnlineStatusDispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Main", "c", "Normal", "d", "getFile", "File", "e", "getNetwork", "Network", "f", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusDispatchers {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OnlineStatusDispatchers f255840a = new OnlineStatusDispatchers();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Main;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Normal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy File;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Network;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy DB;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers$Main$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new a());
            }
        });
        Main = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers$Normal$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new b(16));
            }
        });
        Normal = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers$File$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new b(64));
            }
        });
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers$Network$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new b(128));
            }
        });
        Network = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers$DB$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new b(32));
            }
        });
        DB = lazy5;
    }

    OnlineStatusDispatchers() {
    }

    @NotNull
    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) Main.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        return (CoroutineDispatcher) Normal.getValue();
    }
}

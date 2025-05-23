package com.tencent.mobileqq.wink;

import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/WinkCoroutineScopes;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "d", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "c", "Network", "File", "e", "a", QZoneAppCtrlUploadFileLogic.DB_PATH, "f", "UI", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCoroutineScopes {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkCoroutineScopes f317652a = new WinkCoroutineScopes();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Normal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy Network;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy File;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy DB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy UI;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.wink.WinkCoroutineScopes$Normal$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new h(16));
            }
        });
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.wink.WinkCoroutineScopes$Network$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new h(128));
            }
        });
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.wink.WinkCoroutineScopes$File$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new h(64));
            }
        });
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.wink.WinkCoroutineScopes$DB$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new h(32));
            }
        });
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.wink.WinkCoroutineScopes$UI$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new i());
            }
        });
        UI = lazy5;
    }

    WinkCoroutineScopes() {
    }

    @NotNull
    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) DB.getValue();
    }

    @NotNull
    public final CoroutineDispatcher b() {
        return (CoroutineDispatcher) File.getValue();
    }

    @NotNull
    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) Network.getValue();
    }

    @NotNull
    public final CoroutineDispatcher d() {
        return (CoroutineDispatcher) Normal.getValue();
    }

    @NotNull
    public final CoroutineDispatcher e() {
        return (CoroutineDispatcher) UI.getValue();
    }
}

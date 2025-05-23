package com.qzone.publish.business.publishqueue.intimate;

import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/QZoneCoroutineScopes;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "getNormal", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Normal", "c", "a", "Network", "d", "getFile", "File", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "f", "getUI", "UI", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneCoroutineScopes {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneCoroutineScopes f51155a = new QZoneCoroutineScopes();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy Normal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy Network;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy File;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy DB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy UI;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes$Normal$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new e(16));
            }
        });
        Normal = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes$Network$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new e(128));
            }
        });
        Network = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes$File$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new e(64));
            }
        });
        File = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes$DB$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new e(32));
            }
        });
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes$UI$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new f());
            }
        });
        UI = lazy5;
    }

    QZoneCoroutineScopes() {
    }

    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) Network.getValue();
    }
}

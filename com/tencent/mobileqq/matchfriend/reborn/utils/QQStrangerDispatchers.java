package com.tencent.mobileqq.matchfriend.reborn.utils;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/QQStrangerDispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlin/Lazy;", "getNORMAL", "()Lkotlinx/coroutines/CoroutineDispatcher;", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "c", "a", "NET", "d", "getFILE", "FILE", "e", "getDB", QZoneAppCtrlUploadFileLogic.DB_PATH, "Lkotlinx/coroutines/MainCoroutineDispatcher;", "f", "getUI", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "UI", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerDispatchers {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerDispatchers f245457a = new QQStrangerDispatchers();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy NORMAL;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy NET;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy FILE;

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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers$NORMAL$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new s(16));
            }
        });
        NORMAL = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers$NET$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new s(128));
            }
        });
        NET = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers$FILE$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new s(64));
            }
        });
        FILE = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers$DB$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return ExecutorsKt.from(new s(32));
            }
        });
        DB = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<MainCoroutineDispatcher>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerDispatchers$UI$2
            @Override // kotlin.jvm.functions.Function0
            public final MainCoroutineDispatcher invoke() {
                return Dispatchers.getMain();
            }
        });
        UI = lazy5;
    }

    QQStrangerDispatchers() {
    }

    public final CoroutineDispatcher a() {
        return (CoroutineDispatcher) NET.getValue();
    }
}

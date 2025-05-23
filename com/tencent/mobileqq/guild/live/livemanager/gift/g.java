package com.tencent.mobileqq.guild.live.livemanager.gift;

import android.util.LruCache;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.ca;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/gift/g;", "", "", "uid", "tinyId", "", "c", "d", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/util/LruCache;", "b", "Landroid/util/LruCache;", "uid2TinyIdCache", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f226846a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<Long, Long> uid2TinyIdCache = new LruCache<>(500);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022F\u0010\u0007\u001aB\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003* \u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Ljava/util/HashMap;", "", "uid2TinyId", "", "a", "(ILjava/lang/String;Ljava/util/HashMap;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ca {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f226848a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Long> f226849b;

        /* JADX WARN: Multi-variable type inference failed */
        a(long j3, CancellableContinuation<? super Long> cancellableContinuation) {
            this.f226848a = j3;
            this.f226849b = cancellableContinuation;
        }

        @Override // vh2.ca
        public final void a(int i3, String str, HashMap<Long, Long> hashMap) {
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "queryTinyIdByLiveUID error, " + i3 + "-" + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGL.GuildLiveUidTinyId", 1, (String) it.next(), null);
                }
            } else if (hashMap.containsKey(Long.valueOf(this.f226848a))) {
                g gVar = g.f226846a;
                long j3 = this.f226848a;
                Long l3 = hashMap.get(Long.valueOf(j3));
                Intrinsics.checkNotNull(l3);
                gVar.c(j3, l3.longValue());
            }
            if (!this.f226849b.isActive()) {
                return;
            }
            CancellableContinuation<Long> cancellableContinuation = this.f226849b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(hashMap.get(Long.valueOf(this.f226848a))));
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long uid, long tinyId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGL.GuildLiveUidTinyId", 2, "addUid2TinyIdCache, uid:" + uid + ", tinyId:" + tinyId);
        }
        uid2TinyIdCache.put(Long.valueOf(uid), Long.valueOf(tinyId));
    }

    @Nullable
    public final Object d(long j3, @NotNull Continuation<? super Long> continuation) {
        Continuation intercepted;
        List<String> mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (j3 <= 0) {
            Logger.f235387a.d().w("QGL.GuildLiveUidTinyId", 1, "getTinyId, uid is " + j3);
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
        } else {
            Long l3 = (Long) uid2TinyIdCache.get(Boxing.boxLong(j3));
            if (l3 != null) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(l3));
            } else {
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(String.valueOf(j3));
                iGPSService.queryTinyIdByLiveUID(mutableListOf, new a(j3, cancellableContinuationImpl));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

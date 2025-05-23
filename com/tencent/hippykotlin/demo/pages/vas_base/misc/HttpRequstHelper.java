package com.tencent.hippykotlin.demo.pages.vas_base.misc;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.HttpRequstHelper;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.HashMap;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HttpRequstHelper {
    public static final HttpRequstHelper INSTANCE = new HttpRequstHelper();
    public static final HashMap<String, CacheInfo> pskCache = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class CacheInfo {
        public final String psKey;
        public long time;

        public CacheInfo(long j3, String str) {
            this.time = j3;
            this.psKey = str;
        }
    }

    public final Object getPSK(final String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        CacheInfo cacheInfo = pskCache.get(str);
        c cVar = c.f117352a;
        final long currentTimeStamp = ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).currentTimeStamp();
        if (cacheInfo == null || cacheInfo.time <= currentTimeStamp) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getPSkey(str, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.HttpRequstHelper$getPSK$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    Intrinsics.checkNotNull(eVar2);
                    String p16 = eVar2.p("p_skey");
                    if (p16.length() > 0) {
                        HttpRequstHelper.pskCache.put(str, new HttpRequstHelper.CacheInfo(currentTimeStamp + 5000, p16));
                    }
                    safeContinuation.resumeWith(Result.m476constructorimpl(p16));
                    return Unit.INSTANCE;
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        cacheInfo.time = currentTimeStamp + 5000;
        return cacheInfo.psKey;
    }
}

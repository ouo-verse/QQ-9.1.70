package com.tencent.mobileqq.vas.social.config;

import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.SquareRuntime;
import com.tencent.state.square.api.ISquareAvatarUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J#\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/VasSquareAvatarUtils;", "Lcom/tencent/state/square/api/ISquareAvatarUtils;", "Lkotlinx/coroutines/CoroutineScope;", "", "uin", "Lkotlinx/coroutines/Deferred;", "Lorg/json/JSONObject;", "b", "", "forceUpdate", "getAvatarInfo", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "clean", "Lkotlinx/coroutines/CoroutineDispatcher;", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineContext", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "avatarInfoFutureMap", "<init>", "()V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasSquareAvatarUtils implements ISquareAvatarUtils, CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineContext = Dispatchers.getIO();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Long, Deferred<JSONObject>> avatarInfoFutureMap = new ConcurrentHashMap<>();

    @Override // kotlinx.coroutines.CoroutineScope
    /* renamed from: a, reason: from getter */
    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.tencent.state.square.api.ISquareAvatarUtils
    public void clean() {
        ((IAvatarService) QRoute.api(IAvatarService.class)).cleanup();
        QLog.d("VasSquareAvatarUtils", 1, "clean");
        try {
            try {
                if (JobKt.isActive(getCoroutineContext())) {
                    CoroutineScopeKt.cancel$default(this, null, 1, null);
                }
            } catch (Exception e16) {
                QLog.e("VasSquareAvatarUtils", 1, "clean, e=" + e16);
            }
        } finally {
            this.avatarInfoFutureMap.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.state.square.api.ISquareAvatarUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAvatarInfo(long j3, boolean z16, Continuation<? super JSONObject> continuation) {
        VasSquareAvatarUtils$getAvatarInfo$1 vasSquareAvatarUtils$getAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        VasSquareAvatarUtils vasSquareAvatarUtils;
        Deferred<JSONObject> putIfAbsent;
        JSONObject jSONObject;
        if (continuation instanceof VasSquareAvatarUtils$getAvatarInfo$1) {
            vasSquareAvatarUtils$getAvatarInfo$1 = (VasSquareAvatarUtils$getAvatarInfo$1) continuation;
            int i16 = vasSquareAvatarUtils$getAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                vasSquareAvatarUtils$getAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = vasSquareAvatarUtils$getAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = vasSquareAvatarUtils$getAvatarInfo$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        JSONObject jSONObject2 = (JSONObject) obj;
                        return jSONObject2 != null ? new JSONObject() : jSONObject2;
                    }
                    if (i3 == 2) {
                        j3 = vasSquareAvatarUtils$getAvatarInfo$1.J$0;
                        vasSquareAvatarUtils = (VasSquareAvatarUtils) vasSquareAvatarUtils$getAvatarInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            return jSONObject;
                        }
                        QLog.e("VasSquareAvatarUtils", 1, "getAvatarInfo, result == null");
                        JSONObject jSONObject3 = new JSONObject();
                        vasSquareAvatarUtils.avatarInfoFutureMap.remove(Boxing.boxLong(j3));
                        return jSONObject3;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                    IAvatarService iAvatarService = (IAvatarService) QRoute.api(IAvatarService.class);
                    vasSquareAvatarUtils$getAvatarInfo$1.label = 1;
                    obj = iAvatarService.reqAvatarInfo(j3, vasSquareAvatarUtils$getAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    JSONObject jSONObject22 = (JSONObject) obj;
                    if (jSONObject22 != null) {
                    }
                } else {
                    QLog.d("VasSquareAvatarUtils", 1, "getAvatarInfo, uin=" + j3 + " cacheHit=" + this.avatarInfoFutureMap.containsKey(Boxing.boxLong(j3)) + " forceUpdate=" + z16);
                    if (z16) {
                        this.avatarInfoFutureMap.remove(Boxing.boxLong(j3));
                    }
                    ConcurrentHashMap<Long, Deferred<JSONObject>> concurrentHashMap = this.avatarInfoFutureMap;
                    Long boxLong = Boxing.boxLong(j3);
                    Deferred<JSONObject> deferred = concurrentHashMap.get(boxLong);
                    if (deferred == null && (putIfAbsent = concurrentHashMap.putIfAbsent(boxLong, (deferred = b(j3)))) != null) {
                        deferred = putIfAbsent;
                    }
                    vasSquareAvatarUtils$getAvatarInfo$1.L$0 = this;
                    vasSquareAvatarUtils$getAvatarInfo$1.J$0 = j3;
                    vasSquareAvatarUtils$getAvatarInfo$1.label = 2;
                    obj = deferred.await(vasSquareAvatarUtils$getAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vasSquareAvatarUtils = this;
                    jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                    }
                }
            }
        }
        vasSquareAvatarUtils$getAvatarInfo$1 = new VasSquareAvatarUtils$getAvatarInfo$1(this, continuation);
        Object obj2 = vasSquareAvatarUtils$getAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = vasSquareAvatarUtils$getAvatarInfo$1.label;
        if (i3 == 0) {
        }
    }

    private final Deferred<JSONObject> b(long uin) {
        Deferred<JSONObject> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(this, null, null, new VasSquareAvatarUtils$requestAvatarInfoAsync$1(uin, null), 3, null);
        return async$default;
    }
}

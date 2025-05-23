package com.tencent.sqshow.zootopia.friendsdressup.filament;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b'\u0010(J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpAvatarHelper;", "", "", "uin", "Lorg/json/JSONObject;", tl.h.F, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "j", "i", "(Ljava/lang/Long;)V", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/a;", "callback", "g", "Landroidx/lifecycle/LifecycleCoroutineScope;", "a", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Lwk0/a;", "b", "Lwk0/a;", "filamentNativeApp", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "c", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;", "scene", "", "Lkotlinx/coroutines/Deferred;", "d", "Ljava/util/Map;", "avatarInfoFutureMap", "Ljava/util/concurrent/atomic/AtomicLong;", "e", "Ljava/util/concurrent/atomic/AtomicLong;", "atomicUin", "Luk0/e;", "f", "Luk0/e;", "mListener", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lwk0/a;Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpBusinessScene;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendsDressUpAvatarHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final wk0.a filamentNativeApp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final FriendsDressUpBusinessScene scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, Deferred<JSONObject>> avatarInfoFutureMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicLong atomicUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private uk0.e mListener;

    public FriendsDressUpAvatarHelper(LifecycleCoroutineScope lifecycleScope, wk0.a filamentNativeApp, FriendsDressUpBusinessScene scene) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(filamentNativeApp, "filamentNativeApp");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.lifecycleScope = lifecycleScope;
        this.filamentNativeApp = filamentNativeApp;
        this.scene = scene;
        this.avatarInfoFutureMap = new LinkedHashMap();
        this.atomicUin = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(long j3, Continuation<? super JSONObject> continuation) {
        FriendsDressUpAvatarHelper$getAvatarInfo$1 friendsDressUpAvatarHelper$getAvatarInfo$1;
        Object coroutine_suspended;
        int i3;
        FriendsDressUpAvatarHelper friendsDressUpAvatarHelper;
        JSONObject jSONObject;
        if (continuation instanceof FriendsDressUpAvatarHelper$getAvatarInfo$1) {
            friendsDressUpAvatarHelper$getAvatarInfo$1 = (FriendsDressUpAvatarHelper$getAvatarInfo$1) continuation;
            int i16 = friendsDressUpAvatarHelper$getAvatarInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                friendsDressUpAvatarHelper$getAvatarInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = friendsDressUpAvatarHelper$getAvatarInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = friendsDressUpAvatarHelper$getAvatarInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean containsKey = this.avatarInfoFutureMap.containsKey(Boxing.boxLong(j3));
                    com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "getAvatarInfo, cacheHit=" + containsKey);
                    if (!containsKey) {
                        j(j3);
                    }
                    Deferred<JSONObject> deferred = this.avatarInfoFutureMap.get(Boxing.boxLong(j3));
                    Intrinsics.checkNotNull(deferred);
                    friendsDressUpAvatarHelper$getAvatarInfo$1.L$0 = this;
                    friendsDressUpAvatarHelper$getAvatarInfo$1.J$0 = j3;
                    friendsDressUpAvatarHelper$getAvatarInfo$1.label = 1;
                    obj = deferred.await(friendsDressUpAvatarHelper$getAvatarInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    friendsDressUpAvatarHelper = this;
                } else if (i3 == 1) {
                    j3 = friendsDressUpAvatarHelper$getAvatarInfo$1.J$0;
                    friendsDressUpAvatarHelper = (FriendsDressUpAvatarHelper) friendsDressUpAvatarHelper$getAvatarInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    return jSONObject;
                }
                QLog.e("FilamentAvatarHelper", 1, "getAvatarInfo, result == null");
                JSONObject jSONObject2 = new JSONObject();
                friendsDressUpAvatarHelper.avatarInfoFutureMap.remove(Boxing.boxLong(j3));
                return jSONObject2;
            }
        }
        friendsDressUpAvatarHelper$getAvatarInfo$1 = new FriendsDressUpAvatarHelper$getAvatarInfo$1(this, continuation);
        Object obj2 = friendsDressUpAvatarHelper$getAvatarInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = friendsDressUpAvatarHelper$getAvatarInfo$1.label;
        if (i3 != 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject == null) {
        }
    }

    private final void j(long uin) {
        Deferred<JSONObject> async$default;
        Long valueOf = Long.valueOf(uin);
        Map<Long, Deferred<JSONObject>> map = this.avatarInfoFutureMap;
        async$default = BuildersKt__Builders_commonKt.async$default(this.lifecycleScope, null, null, new FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1(uin, null), 3, null);
        map.put(valueOf, async$default);
    }

    public final void g(long uin, a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.a();
        this.atomicUin.set(uin);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FriendsDressUpAvatarHelper$changeAvatarDress$1(this, uin, callback, null), 3, null);
    }

    public final void i(Long uin) {
        if (uin != null) {
            long longValue = uin.longValue();
            if (this.avatarInfoFutureMap.containsKey(Long.valueOf(longValue))) {
                return;
            }
            j(longValue);
        }
    }
}

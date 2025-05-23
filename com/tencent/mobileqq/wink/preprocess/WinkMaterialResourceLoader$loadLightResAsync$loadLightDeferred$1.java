package com.tencent.mobileqq.wink.preprocess;

import android.os.SystemClock;
import com.tencent.mobileqq.wink.dailysign.ResLoadException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1", f = "WinkMaterialResourceLoader.kt", i = {0, 1, 1}, l = {131, 136}, m = "invokeSuspend", n = {"startTime", "waitResult", "startTime"}, s = {"J$0", "L$0", "J$0"})
/* loaded from: classes21.dex */
public final class WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HashMap<String, Long> $costMap;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1(HashMap<String, Long> hashMap, Continuation<? super WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1> continuation) {
        super(2, continuation);
        this.$costMap = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1(this.$costMap, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        long j16;
        Pair pair;
        long j17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        j16 = this.J$0;
                        pair = (Pair) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        HashMap<String, Long> hashMap = this.$costMap;
                        if (!((Boolean) pair.getSecond()).booleanValue()) {
                            j17 = 1;
                        } else {
                            j17 = 0;
                        }
                        hashMap.put("needDownloadSo", Boxing.boxLong(j17));
                        this.$costMap.put("downLoadSoTime", Boxing.boxLong(SystemClock.elapsedRealtime() - j16));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
                this.J$0 = elapsedRealtime;
                this.label = 1;
                obj = winkMaterialResourceLoader.e(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = elapsedRealtime;
            }
            Pair pair2 = (Pair) obj;
            if (((Boolean) pair2.getFirst()).booleanValue()) {
                WinkMaterialResourceLoader winkMaterialResourceLoader2 = WinkMaterialResourceLoader.f325333a;
                this.L$0 = pair2;
                this.J$0 = j3;
                this.label = 2;
                if (winkMaterialResourceLoader2.f(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j16 = j3;
                pair = pair2;
                HashMap<String, Long> hashMap2 = this.$costMap;
                if (!((Boolean) pair.getSecond()).booleanValue()) {
                }
                hashMap2.put("needDownloadSo", Boxing.boxLong(j17));
                this.$costMap.put("downLoadSoTime", Boxing.boxLong(SystemClock.elapsedRealtime() - j16));
                return Unit.INSTANCE;
            }
            throw new ResLoadException(2, new Exception("wait Camera Res Ready timeout"));
        } catch (Exception e16) {
            throw new ResLoadException(2, e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMaterialResourceLoader$loadLightResAsync$loadLightDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

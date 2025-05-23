package com.tencent.mobileqq.wink.schema;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckUserInfo$2", f = "WinkSchemaPreCheck.kt", i = {0}, l = {PlayerResources.ViewId.NEXT_VIDEO_COUNT_DOWN_TIP}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckUserInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckUserInfo$2(ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckUserInfo$2> continuation) {
        super(2, continuation);
        this.$keyAttrs = concurrentHashMap;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preCheckUserInfo$2(this.$keyAttrs, this.$costCollector, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                j3 = this.J$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            CoroutineDispatcher c16 = WinkCoroutineScopes.f317652a.c();
            WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1 winkSchemaPreCheck$preCheckUserInfo$2$userInfo$1 = new WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1(null);
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = BuildersKt.withContext(c16, winkSchemaPreCheck$preCheckUserInfo$2$userInfo$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
        }
        WinkUserInfo winkUserInfo = (WinkUserInfo) obj;
        if (winkUserInfo != null) {
            WinkSchemaPreCheck.f326271a.y(this.$keyAttrs, winkUserInfo);
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            this.$costCollector.put(ITVKPlayerEventListener.KEY_USER_INFO, Boxing.boxLong(currentTimeMillis2));
            w53.b.f("TAG_WinkSchemaPreCheck", "preCheckUserInfo finish. cost " + currentTimeMillis2);
            return Boxing.boxBoolean(true);
        }
        w53.b.c("TAG_WinkSchemaPreCheck", "preCheckUserInfo get userInfo failed. cost " + (System.currentTimeMillis() - j3));
        return Boxing.boxBoolean(false);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckUserInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

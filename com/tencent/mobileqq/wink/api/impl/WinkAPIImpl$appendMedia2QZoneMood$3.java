package com.tencent.mobileqq.wink.api.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.api.impl.WinkAPIImpl$appendMedia2QZoneMood$3", f = "WinkAPIImpl.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAPIImpl$appendMedia2QZoneMood$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $i;
    final /* synthetic */ JSONArray $videoJsonArray;
    int label;
    final /* synthetic */ WinkAPIImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAPIImpl$appendMedia2QZoneMood$3(WinkAPIImpl winkAPIImpl, JSONArray jSONArray, int i3, Continuation<? super WinkAPIImpl$appendMedia2QZoneMood$3> continuation) {
        super(2, continuation);
        this.this$0 = winkAPIImpl;
        this.$videoJsonArray = jSONArray;
        this.$i = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAPIImpl$appendMedia2QZoneMood$3(this.this$0, this.$videoJsonArray, this.$i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkAPIImpl winkAPIImpl = this.this$0;
            String optString = this.$videoJsonArray.optJSONObject(this.$i).optString("localpath");
            Intrinsics.checkNotNullExpressionValue(optString, "videoJsonArray.optJSONOb\u2026i).optString(\"localpath\")");
            this.label = 1;
            obj = winkAPIImpl.moveQZoneVideoRes(optString, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WinkAPIImpl$appendMedia2QZoneMood$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

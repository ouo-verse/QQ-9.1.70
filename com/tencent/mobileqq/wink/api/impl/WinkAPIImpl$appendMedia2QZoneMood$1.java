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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.api.impl.WinkAPIImpl$appendMedia2QZoneMood$1", f = "WinkAPIImpl.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAPIImpl$appendMedia2QZoneMood$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $i;
    final /* synthetic */ JSONArray $jsonArray;
    int label;
    final /* synthetic */ WinkAPIImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAPIImpl$appendMedia2QZoneMood$1(WinkAPIImpl winkAPIImpl, JSONArray jSONArray, int i3, Continuation<? super WinkAPIImpl$appendMedia2QZoneMood$1> continuation) {
        super(2, continuation);
        this.this$0 = winkAPIImpl;
        this.$jsonArray = jSONArray;
        this.$i = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAPIImpl$appendMedia2QZoneMood$1(this.this$0, this.$jsonArray, this.$i, continuation);
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
            String string = this.$jsonArray.getJSONObject(this.$i).getString("url");
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getJSONObject(i).getString(\"url\")");
            this.label = 1;
            obj = winkAPIImpl.downloadQZoneImageRes(string, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WinkAPIImpl$appendMedia2QZoneMood$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

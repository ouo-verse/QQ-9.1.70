package com.tencent.mobileqq.wink.schema;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1", f = "WinkSchemaPreCheck.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1(ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1> continuation) {
        super(2, continuation);
        this.$keyAttrs = concurrentHashMap;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1(this.$keyAttrs, this.$costCollector, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$keyAttrs.get(QCircleScheme.AttrQQPublish.NEED_USER_INFO), "1")) {
                WinkSchemaPreCheck winkSchemaPreCheck = WinkSchemaPreCheck.f326271a;
                ConcurrentHashMap<String, String> concurrentHashMap = this.$keyAttrs;
                HashMap<String, Object> hashMap = this.$costCollector;
                this.label = 1;
                obj = winkSchemaPreCheck.G(concurrentHashMap, hashMap, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z16);
        }
        z16 = ((Boolean) obj).booleanValue();
        return Boxing.boxBoolean(z16);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

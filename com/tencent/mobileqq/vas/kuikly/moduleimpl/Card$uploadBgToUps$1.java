package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.mobileqq.vas.api.IDiyCardBgUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.kuikly.moduleimpl.Card$uploadBgToUps$1", f = "Card.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class Card$uploadBgToUps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ String $params;
    int label;
    final /* synthetic */ Card this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Card$uploadBgToUps$1(String str, Card card, Function1<Object, Unit> function1, Continuation<? super Card$uploadBgToUps$1> continuation) {
        super(2, continuation);
        this.$params = str;
        this.this$0 = card;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new Card$uploadBgToUps$1(this.$params, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IDiyCardBgUtils b16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                String filePath = new JSONObject(this.$params).optString("filePath");
                b16 = this.this$0.b();
                Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                this.label = 1;
                obj = b16.uploadBackgroundToUps(filePath, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            Function1<Object, Unit> function1 = this.$callback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", true);
                if (str == null) {
                    str = "";
                }
                jSONObject.put("url", str);
                function1.invoke(jSONObject.toString());
            }
        } catch (Exception e16) {
            QLog.e("Card", 1, "uploadBackgroundToUps failure: " + e16.getMessage());
            Function1<Object, Unit> function12 = this.$callback;
            if (function12 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret", false);
                function12.invoke(jSONObject2.toString());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Card$uploadBgToUps$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

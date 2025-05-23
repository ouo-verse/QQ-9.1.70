package com.tencent.mobileqq.wink.api.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.api.impl.ClipServiceBinder$doClipForward$1$bitmapPairs$1", f = "ClipServiceBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class ClipServiceBinder$doClipForward$1$bitmapPairs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends Bitmap>[]>, Object> {
    final /* synthetic */ List<Pair<String, String>> $downloadResults;
    int label;
    final /* synthetic */ ClipServiceBinder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipServiceBinder$doClipForward$1$bitmapPairs$1(List<Pair<String, String>> list, ClipServiceBinder clipServiceBinder, Continuation<? super ClipServiceBinder$doClipForward$1$bitmapPairs$1> continuation) {
        super(2, continuation);
        this.$downloadResults = list;
        this.this$0 = clipServiceBinder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ClipServiceBinder$doClipForward$1$bitmapPairs$1(this.$downloadResults, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends String, ? extends Bitmap>[]> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<String, Bitmap>[]>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Pair B1;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Pair<String, String>> list = this.$downloadResults;
            ClipServiceBinder clipServiceBinder = this.this$0;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                B1 = clipServiceBinder.B1((Pair) it.next());
                if (B1 != null) {
                    arrayList.add(B1);
                }
            }
            Object[] array = arrayList.toArray(new Pair[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return array;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<String, Bitmap>[]> continuation) {
        return ((ClipServiceBinder$doClipForward$1$bitmapPairs$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

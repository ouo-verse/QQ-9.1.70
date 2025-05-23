package com.tencent.guild.api.marketface.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/widget/Toast;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl$showTip$2", f = "MarketFaceApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class MarketFaceApiImpl$showTip$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Toast>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $tips;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$showTip$2(String str, Context context, Continuation<? super MarketFaceApiImpl$showTip$2> continuation) {
        super(2, continuation);
        this.$tips = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MarketFaceApiImpl$showTip$2(this.$tips, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i(com.tencent.qqnt.emotion.adapter.api.impl.MarketFaceApiImpl.TAG, 1, "withContext ThreadName=" + Thread.currentThread().getName() + " tips=" + this.$tips);
            return QQToast.makeText(this.$context.getApplicationContext(), this.$tips, 0).show(this.$context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Toast> continuation) {
        return ((MarketFaceApiImpl$showTip$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

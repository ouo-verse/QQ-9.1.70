package com.tencent.mobileqq.onlinestatus.processor;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2", f = "URLColorThemeProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $color$inlined;
    final /* synthetic */ URLDrawable $drawable$inlined;
    int label;
    final /* synthetic */ URLColorThemeProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2(Continuation continuation, URLColorThemeProcessor uRLColorThemeProcessor, Integer num, URLDrawable uRLDrawable) {
        super(2, continuation);
        this.this$0 = uRLColorThemeProcessor;
        this.$color$inlined = num;
        this.$drawable$inlined = uRLDrawable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2(continuation, this.this$0, this.$color$inlined, this.$drawable$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        URLColorThemeProcessor.a aVar;
        String str2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.mImageLoadingState = ImageLoadingState.SUCCESS;
            str = this.this$0.mCurrentUrlStr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("#%08X", Arrays.copyOf(new Object[]{this.$color$inlined}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("URLColorThemeProcessor", 1, "Success to load image: { url: " + str + " , color: " + format + " }");
            aVar = this.this$0.mOnGetColorListener;
            if (aVar != null) {
                str2 = this.this$0.mCurrentUrlStr;
                aVar.c(true, str2, this.$drawable$inlined, this.$color$inlined.intValue());
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

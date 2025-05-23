package com.tencent.mobileqq.onlinestatus.processor;

import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers;
import com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusImmersiveThemeUtilsKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor$onDrawableSuccessLoad$1", f = "URLColorThemeProcessor.kt", i = {}, l = {225, 233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class URLColorThemeProcessor$onDrawableSuccessLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ URLDrawable $drawable;
    int label;
    final /* synthetic */ URLColorThemeProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLColorThemeProcessor$onDrawableSuccessLoad$1(URLDrawable uRLDrawable, URLColorThemeProcessor uRLColorThemeProcessor, Continuation<? super URLColorThemeProcessor$onDrawableSuccessLoad$1> continuation) {
        super(2, continuation);
        this.$drawable = uRLDrawable;
        this.this$0 = uRLColorThemeProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new URLColorThemeProcessor$onDrawableSuccessLoad$1(this.$drawable, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        URLColorThemeProcessor.a aVar;
        String str3;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1 && i16 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            String url = this.$drawable.getURL().toString();
            Intrinsics.checkNotNullExpressionValue(url, "drawable.url.toString()");
            Integer a16 = OnlineStatusImmersiveThemeUtilsKt.a(url);
            if (a16 == null) {
                URLDrawable uRLDrawable = this.$drawable;
                i3 = this.this$0.mDefaultColor;
                a16 = OnlineStatusImmersiveThemeUtilsKt.b(uRLDrawable, 100, 100, i3);
            }
            if (a16 != null) {
                OnlineStatusImmersiveThemeUtilsKt.d(url, a16.intValue());
            }
            str = this.this$0.mCurrentUrlStr;
            if (!Intrinsics.areEqual(url, str)) {
                return Unit.INSTANCE;
            }
            if (a16 == null) {
                QLog.e("URLColorThemeProcessor", 1, "Failed to get color!!!");
                URLColorThemeProcessor uRLColorThemeProcessor = this.this$0;
                if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                    CoroutineDispatcher a17 = OnlineStatusDispatchers.f255840a.a();
                    URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1 uRLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1 = new URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1(null, uRLColorThemeProcessor);
                    this.label = 1;
                    if (BuildersKt.withContext(a17, uRLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    uRLColorThemeProcessor.k();
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                URLColorThemeProcessor uRLColorThemeProcessor2 = this.this$0;
                URLDrawable uRLDrawable2 = this.$drawable;
                if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                    uRLColorThemeProcessor2.mImageLoadingState = ImageLoadingState.SUCCESS;
                    str2 = uRLColorThemeProcessor2.mCurrentUrlStr;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("#%08X", Arrays.copyOf(new Object[]{a16}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QLog.d("URLColorThemeProcessor", 1, "Success to load image: { url: " + str2 + " , color: " + format + " }");
                    aVar = uRLColorThemeProcessor2.mOnGetColorListener;
                    if (aVar != null) {
                        str3 = uRLColorThemeProcessor2.mCurrentUrlStr;
                        aVar.c(true, str3, uRLDrawable2, a16.intValue());
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    CoroutineDispatcher a18 = OnlineStatusDispatchers.f255840a.a();
                    URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2 uRLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2 = new URLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2(null, uRLColorThemeProcessor2, a16, uRLDrawable2);
                    this.label = 2;
                    if (BuildersKt.withContext(a18, uRLColorThemeProcessor$onDrawableSuccessLoad$1$invokeSuspend$$inlined$runOnUI$2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((URLColorThemeProcessor$onDrawableSuccessLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

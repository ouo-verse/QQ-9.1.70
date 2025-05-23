package com.tencent.mobileqq.qqlive.sail.ui.background;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.background.BackgroundViewModel$fetchBlurBackground$1", f = "BackgroundViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class BackgroundViewModel$fetchBlurBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ BackgroundViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundViewModel$fetchBlurBackground$1(String str, BackgroundViewModel backgroundViewModel, Continuation<? super BackgroundViewModel$fetchBlurBackground$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = backgroundViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, backgroundViewModel, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new BackgroundViewModel$fetchBlurBackground$1(this.$url, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Bitmap a26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                    Option option = Option.obtain().setUrl(this.$url).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setSupportRecycler(true).disableHardwareDecode().setRequestWidth(ViewUtils.getScreenWidth()).setRequestHeight(ViewUtils.getScreenHeight());
                    BackgroundViewModel backgroundViewModel = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(option, "option");
                    this.label = 1;
                    obj = backgroundViewModel.S1(option, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                com.tencent.mobileqq.qqlive.widget.util.a aVar = com.tencent.mobileqq.qqlive.widget.util.a.f274061a;
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                a26 = this.this$0.a2(aVar.a(context, (Bitmap) obj, 25.0f, 2, 1));
                if (a26 != null) {
                    this.this$0.Q1(new a(new BitmapDrawable(BaseApplication.context.getResources(), a26), null, null, 1, null, 16, null));
                }
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|BackgroundViewModel", "getBlurBitmap", "failed, ", e16);
            } catch (OutOfMemoryError e17) {
                AegisLogger.INSTANCE.e("Audience|BackgroundViewModel", "getBlurBitmap", "oom, ", e17);
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((BackgroundViewModel$fetchBlurBackground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

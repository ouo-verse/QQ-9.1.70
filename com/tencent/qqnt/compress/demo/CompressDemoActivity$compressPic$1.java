package com.tencent.qqnt.compress.demo;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.compress.pic.impl.Compress;
import java.io.File;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.compress.demo.CompressDemoActivity$compressPic$1", f = "CompressDemoActivity.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
public final class CompressDemoActivity$compressPic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ File $imageFile;
    int label;
    final /* synthetic */ CompressDemoActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompressDemoActivity$compressPic$1(CompressDemoActivity compressDemoActivity, File file, Continuation<? super CompressDemoActivity$compressPic$1> continuation) {
        super(2, continuation);
        this.this$0 = compressDemoActivity;
        this.$imageFile = file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, compressDemoActivity, file, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new CompressDemoActivity$compressPic$1(this.this$0, this.$imageFile, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        rw3.a aVar;
        rw3.a aVar2;
        rw3.a aVar3;
        rw3.a aVar4;
        File file;
        String V2;
        String V22;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                Compress compress = Compress.f355729a;
                CompressDemoActivity compressDemoActivity = this.this$0;
                File file2 = this.$imageFile;
                this.label = 1;
                obj = Compress.d(compress, compressDemoActivity, file2, null, null, this, 12, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            File file3 = (File) obj;
            aVar = this.this$0.binding;
            File file4 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.f432636d.setImageBitmap(com.tencent.qqnt.compress.pic.impl.util.a.f355759a.c(file3));
            aVar2 = this.this$0.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            TextView textView = aVar2.f432637e;
            aVar3 = this.this$0.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            CharSequence text = aVar3.f432637e.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.compressPicPath.text");
            textView.setText(text.subSequence(0, 8).toString() + file3.getAbsolutePath());
            aVar4 = this.this$0.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            TextView textView2 = aVar4.f432634b;
            CompressDemoActivity compressDemoActivity2 = this.this$0;
            file = compressDemoActivity2.originPic;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("originPic");
            } else {
                file4 = file;
            }
            V2 = compressDemoActivity2.V2(file4);
            V22 = this.this$0.V2(file3);
            textView2.setText("\u538b\u7f29\u524d  " + V2 + "\n\u538b\u7f29\u540e  " + V22);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((CompressDemoActivity$compressPic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

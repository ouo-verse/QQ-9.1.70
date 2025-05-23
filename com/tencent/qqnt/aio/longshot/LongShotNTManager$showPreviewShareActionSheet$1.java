package com.tencent.qqnt.aio.longshot;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.longshot.LongShotNTManager$showPreviewShareActionSheet$1", f = "LongShotNTManager.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class LongShotNTManager$showPreviewShareActionSheet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ com.tencent.qqnt.aio.adapter.api.c $exit;
    final /* synthetic */ boolean $exitOnDismiss;
    final /* synthetic */ String $path;
    final /* synthetic */ String $subBusiness;
    int label;
    final /* synthetic */ LongShotNTManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongShotNTManager$showPreviewShareActionSheet$1(LongShotNTManager longShotNTManager, String str, Activity activity, boolean z16, com.tencent.qqnt.aio.adapter.api.c cVar, String str2, Continuation<? super LongShotNTManager$showPreviewShareActionSheet$1> continuation) {
        super(2, continuation);
        this.this$0 = longShotNTManager;
        this.$path = str;
        this.$activity = activity;
        this.$exitOnDismiss = z16;
        this.$exit = cVar;
        this.$subBusiness = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, longShotNTManager, str, activity, Boolean.valueOf(z16), cVar, str2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LongShotNTManager$showPreviewShareActionSheet$1(this.this$0, this.$path, this.$activity, this.$exitOnDismiss, this.$exit, this.$subBusiness, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
                LongShotNTManager longShotNTManager = this.this$0;
                String str = this.$path;
                this.label = 1;
                obj = longShotNTManager.s(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.this$0.m(this.$activity, bitmap, this.$path, this.$exitOnDismiss, this.$exit, this.$subBusiness);
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LongShotNTManager$showPreviewShareActionSheet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

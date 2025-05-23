package com.tencent.mobileqq.qqlive.sail.ui.background;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.background.BackgroundViewModel$fetchRoomSkinBackground$1", f = "BackgroundViewModel.kt", i = {0, 1}, l = {131, 132}, m = "invokeSuspend", n = {"bottomJob", "topDrawable"}, s = {"L$0", "L$0"})
/* loaded from: classes17.dex */
public final class BackgroundViewModel$fetchRoomSkinBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $bottomUrl;
    final /* synthetic */ String $topUrl;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackgroundViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundViewModel$fetchRoomSkinBackground$1(BackgroundViewModel backgroundViewModel, String str, String str2, Continuation<? super BackgroundViewModel$fetchRoomSkinBackground$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundViewModel;
        this.$topUrl = str;
        this.$bottomUrl = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, backgroundViewModel, str, str2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        BackgroundViewModel$fetchRoomSkinBackground$1 backgroundViewModel$fetchRoomSkinBackground$1 = new BackgroundViewModel$fetchRoomSkinBackground$1(this.this$0, this.$topUrl, this.$bottomUrl, continuation);
        backgroundViewModel$fetchRoomSkinBackground$1.L$0 = obj;
        return backgroundViewModel$fetchRoomSkinBackground$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        BitmapDrawable bitmapDrawable3 = (BitmapDrawable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        bitmapDrawable = bitmapDrawable3;
                        bitmapDrawable2 = (BitmapDrawable) obj;
                        if (bitmapDrawable != null && bitmapDrawable2 != null) {
                            this.this$0.Q1(new a(null, bitmapDrawable, bitmapDrawable2, 2, ImageView.ScaleType.MATRIX));
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                deferred = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new BackgroundViewModel$fetchRoomSkinBackground$1$topJob$1(this.this$0, this.$topUrl, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new BackgroundViewModel$fetchRoomSkinBackground$1$bottomJob$1(this.this$0, this.$bottomUrl, null), 3, null);
                this.L$0 = async$default2;
                this.label = 1;
                Object await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = async$default2;
                obj = await;
            }
            BitmapDrawable bitmapDrawable4 = (BitmapDrawable) obj;
            this.L$0 = bitmapDrawable4;
            this.label = 2;
            Object await2 = deferred.await(this);
            if (await2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bitmapDrawable = bitmapDrawable4;
            obj = await2;
            bitmapDrawable2 = (BitmapDrawable) obj;
            if (bitmapDrawable != null) {
                this.this$0.Q1(new a(null, bitmapDrawable, bitmapDrawable2, 2, ImageView.ScaleType.MATRIX));
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((BackgroundViewModel$fetchRoomSkinBackground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

package com.tencent.mobileqq.wink.aiavatar.view;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.eh;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView$setImageBitmap$1", f = "WinkAvatarImageView.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAvatarImageView$setImageBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bm;
    int label;
    final /* synthetic */ WinkAvatarImageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView$setImageBitmap$1$1", f = "WinkAvatarImageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarImageView$setImageBitmap$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bm;
        final /* synthetic */ Bitmap $scaledBitmap;
        int label;
        final /* synthetic */ WinkAvatarImageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WinkAvatarImageView winkAvatarImageView, Bitmap bitmap, Bitmap bitmap2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = winkAvatarImageView;
            this.$scaledBitmap = bitmap;
            this.$bm = bitmap2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$scaledBitmap, this.$bm, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.blurBimap = this.$scaledBitmap;
                super/*androidx.appcompat.widget.AppCompatImageView*/.setImageBitmap(this.$bm);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAvatarImageView$setImageBitmap$1(Bitmap bitmap, WinkAvatarImageView winkAvatarImageView, Continuation<? super WinkAvatarImageView$setImageBitmap$1> continuation) {
        super(2, continuation);
        this.$bm = bitmap;
        this.this$0 = winkAvatarImageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAvatarImageView$setImageBitmap$1(this.$bm, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Bitmap bitmap;
        float f16;
        float f17;
        float f18;
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
                float width = this.$bm.getWidth();
                f16 = this.this$0.blurImageScaleFactor;
                int i16 = (int) (width * f16);
                float height = this.$bm.getHeight();
                f17 = this.this$0.blurImageScaleFactor;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.$bm, i16, (int) (height * f17), true);
                f18 = this.this$0.blurRadius;
                eh.a(createScaledBitmap, (int) f18);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, createScaledBitmap, this.$bm, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th5) {
            w53.b.d("WinkAvatarImageView", "setImageBitmap", th5);
            bitmap = this.this$0.blurBimap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.this$0.blurBimap = null;
            super/*androidx.appcompat.widget.AppCompatImageView*/.setImageBitmap(this.$bm);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAvatarImageView$setImageBitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

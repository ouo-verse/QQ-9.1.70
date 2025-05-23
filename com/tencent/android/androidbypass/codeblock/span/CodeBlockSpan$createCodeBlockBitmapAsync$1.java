package com.tencent.android.androidbypass.codeblock.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan$createCodeBlockBitmapAsync$1", f = "CodeBlockSpan.kt", i = {0, 0}, l = {244}, m = "invokeSuspend", n = {"$this$launch", MimeHelper.IMAGE_SUBTYPE_BITMAP}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class CodeBlockSpan$createCodeBlockBitmapAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $height;
    final /* synthetic */ CharSequence $text;
    final /* synthetic */ int $width;
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CodeBlockSpan this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan$createCodeBlockBitmapAsync$1$1", f = "CodeBlockSpan.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan$createCodeBlockBitmapAsync$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Ref.ObjectRef $bitmap;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef objectRef, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = objectRef;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, CodeBlockSpan$createCodeBlockBitmapAsync$1.this, objectRef, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
            }
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$bitmap, completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.tencent.android.androidbypass.codeblock.span.plugin.center.a n3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (CoroutineScopeKt.isActive(this.p$) && ((Bitmap) this.$bitmap.element) != null) {
                        Canvas canvas = new Canvas((Bitmap) this.$bitmap.element);
                        n3 = CodeBlockSpan$createCodeBlockBitmapAsync$1.this.this$0.n();
                        CodeBlockSpan$createCodeBlockBitmapAsync$1 codeBlockSpan$createCodeBlockBitmapAsync$1 = CodeBlockSpan$createCodeBlockBitmapAsync$1.this;
                        n3.c(canvas, codeBlockSpan$createCodeBlockBitmapAsync$1.$width, codeBlockSpan$createCodeBlockBitmapAsync$1.$height, codeBlockSpan$createCodeBlockBitmapAsync$1.$text);
                        canvas.setBitmap(null);
                        CodeBlockSpan$createCodeBlockBitmapAsync$1.this.this$0.codeBlockBitmap = (Bitmap) this.$bitmap.element;
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeBlockSpan$createCodeBlockBitmapAsync$1(CodeBlockSpan codeBlockSpan, int i3, int i16, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.this$0 = codeBlockSpan;
        this.$width = i3;
        this.$height = i16;
        this.$text = charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, codeBlockSpan, Integer.valueOf(i3), Integer.valueOf(i16), charSequence, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        CodeBlockSpan$createCodeBlockBitmapAsync$1 codeBlockSpan$createCodeBlockBitmapAsync$1 = new CodeBlockSpan$createCodeBlockBitmapAsync$1(this.this$0, this.$width, this.$height, this.$text, completion);
        codeBlockSpan$createCodeBlockBitmapAsync$1.p$ = (CoroutineScope) obj;
        return codeBlockSpan$createCodeBlockBitmapAsync$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((CodeBlockSpan$createCodeBlockBitmapAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [T, android.graphics.Bitmap] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
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
                CoroutineScope coroutineScope = this.p$;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = null;
                try {
                    objectRef.element = Bitmap.createBitmap(this.$width, this.$height, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    com.tencent.android.androidbypass.config.a.f72049a.e("CodeBlockSpan", "createBitmap outOfMemoryError !");
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, null);
                this.L$0 = coroutineScope;
                this.L$1 = objectRef;
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}

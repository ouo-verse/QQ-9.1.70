package com.tencent.guild.aio.msglist.text;

import android.content.Context;
import android.view.View;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.msglist.text.a;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$handleLottie$1", f = "GuildTextContentComponentVM.kt", i = {}, l = {89, 90, 106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildTextContentComponentVM$handleLottie$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ a.C1206a $intent;
    int label;
    final /* synthetic */ GuildTextContentComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$handleLottie$1$1", f = "GuildTextContentComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$handleLottie$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ a.C1206a $intent;
        final /* synthetic */ View $lottieView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a.C1206a c1206a, View view, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$intent = c1206a;
            this.$lottieView = view;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$intent, this.$lottieView, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$intent.getBubbleView().removeAllViews();
                View view = this.$lottieView;
                if (view != null) {
                    a.C1206a c1206a = this.$intent;
                    Context context = this.$context;
                    c1206a.getBubbleView().addView(view);
                    view.setContentDescription(context.getString(R.string.f1385609w) + c1206a.getFaceElement().faceText);
                    return Unit.INSTANCE;
                }
                return null;
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
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$handleLottie$1$2", f = "GuildTextContentComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$handleLottie$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ a.C1206a $intent;
        final /* synthetic */ View $lottieView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(a.C1206a c1206a, View view, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$intent = c1206a;
            this.$lottieView = view;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$intent, this.$lottieView, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$intent.getBubbleView().removeAllViews();
                View view = this.$lottieView;
                if (view != null) {
                    a.C1206a c1206a = this.$intent;
                    Context context = this.$context;
                    c1206a.getBubbleView().addView(view);
                    view.setContentDescription(context.getString(R.string.f1385609w) + c1206a.getFaceElement().faceText);
                    return Unit.INSTANCE;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTextContentComponentVM$handleLottie$1(GuildTextContentComponentVM guildTextContentComponentVM, a.C1206a c1206a, Context context, Continuation<? super GuildTextContentComponentVM$handleLottie$1> continuation) {
        super(2, continuation);
        this.this$0 = guildTextContentComponentVM;
        this.$intent = c1206a;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildTextContentComponentVM$handleLottie$1(this.this$0, this.$intent, this.$context, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        boolean z17;
        Object createRandomLottieAnimView;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception e16) {
            QLog.e("GuildTextContentComponentVM", 1, String.valueOf(e16));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.alreadyRead = true;
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            createRandomLottieAnimView = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            String name = Thread.currentThread().getName();
            z16 = this.this$0.alreadyRead;
            QLog.i("GuildTextContentComponentVM", 1, "vmScope ThreadName=" + name + " alreadyRead=" + z16);
            if (((IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class)).isAniStickerRandom(this.$intent.getEmoFaceId())) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                String b16 = com.tencent.guild.aio.util.a.b(g16);
                AIOParam g17 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                Contact contact = new Contact(4, b16, com.tencent.guild.aio.util.a.g(g17));
                IRandomLottieProxyApi iRandomLottieProxyApi = (IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class);
                Context context = this.$context;
                FaceElement faceElement = this.$intent.getFaceElement();
                int emoFaceId = this.$intent.getEmoFaceId();
                z17 = this.this$0.alreadyRead;
                long msgSeq = this.$intent.getMsgSeq();
                this.label = 1;
                createRandomLottieAnimView = iRandomLottieProxyApi.createRandomLottieAnimView(context, faceElement, emoFaceId, z17, msgSeq, contact, this);
                if (createRandomLottieAnimView == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                View createLottieAnimView = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).createLottieAnimView(this.$context, this.$intent.getFaceElement(), this.$intent.getEmoFaceId(), null);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$intent, createLottieAnimView, this.$context, null);
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        MainCoroutineDispatcher main2 = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$intent, (View) createRandomLottieAnimView, this.$context, null);
        this.label = 2;
        if (BuildersKt.withContext(main2, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.alreadyRead = true;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildTextContentComponentVM$handleLottie$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

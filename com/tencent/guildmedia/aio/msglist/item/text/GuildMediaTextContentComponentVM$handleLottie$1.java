package com.tencent.guildmedia.aio.msglist.item.text;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
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
@DebugMetadata(c = "com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponentVM$handleLottie$1", f = "GuildMediaTextContentComponentVM.kt", i = {}, l = {55, 75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMediaTextContentComponentVM$handleLottie$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ b $intent;
    int label;
    final /* synthetic */ GuildMediaTextContentComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/ViewGroup$LayoutParams;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponentVM$handleLottie$1$1", f = "GuildMediaTextContentComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextContentComponentVM$handleLottie$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewGroup.LayoutParams>, Object> {
        final /* synthetic */ b $intent;
        final /* synthetic */ View $lottieView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(View view, b bVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lottieView = view;
            this.$intent = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$lottieView, this.$intent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i3;
            int i16;
            ViewGroup parentView;
            int i17;
            int i18;
            int i19;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                View view = this.$lottieView;
                if (view != null) {
                    b bVar = this.$intent;
                    if (view.getParent() == null && (parentView = bVar.getParentView()) != null) {
                        i17 = GuildMediaTextContentComponentVM.f113118i;
                        i18 = GuildMediaTextContentComponentVM.f113118i;
                        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i17, i18);
                        i19 = GuildMediaTextContentComponentVM.f113119m;
                        marginLayoutParams.topMargin = i19;
                        Unit unit = Unit.INSTANCE;
                        parentView.addView(view, marginLayoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    i3 = GuildMediaTextContentComponentVM.f113118i;
                    layoutParams.width = i3;
                    i16 = GuildMediaTextContentComponentVM.f113118i;
                    layoutParams.height = i16;
                    return layoutParams;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ViewGroup.LayoutParams> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaTextContentComponentVM$handleLottie$1(b bVar, GuildMediaTextContentComponentVM guildMediaTextContentComponentVM, Context context, Continuation<? super GuildMediaTextContentComponentVM$handleLottie$1> continuation) {
        super(2, continuation);
        this.$intent = bVar;
        this.this$0 = guildMediaTextContentComponentVM;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaTextContentComponentVM$handleLottie$1(this.$intent, this.this$0, this.$context, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        int i16;
        View createLottieAnimViewForMedia;
        Object createRandomLottieAnimViewForMedia;
        MainCoroutineDispatcher main;
        AnonymousClass1 anonymousClass1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        try {
        } catch (Exception e16) {
            QLog.e("GMediaTextItemVM", 1, String.valueOf(e16));
        }
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            createRandomLottieAnimViewForMedia = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            i3 = GuildMediaTextContentComponentVM.f113118i;
            i16 = GuildMediaTextContentComponentVM.f113118i;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
            if (((IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class)).isAniStickerRandom(this.$intent.getEmoFaceId())) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                String b16 = com.tencent.guild.aio.util.a.b(g16);
                AIOParam g17 = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                Contact contact = new Contact(4, b16, com.tencent.guild.aio.util.a.g(g17));
                IRandomLottieProxyApi iRandomLottieProxyApi = (IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class);
                Context context = this.$context;
                ViewGroup parentView = this.$intent.getParentView();
                FaceElement faceElement = this.$intent.getFaceElement();
                int emoFaceId = this.$intent.getEmoFaceId();
                long msgSeq = this.$intent.getMsgSeq();
                this.label = 1;
                createRandomLottieAnimViewForMedia = iRandomLottieProxyApi.createRandomLottieAnimViewForMedia(context, parentView, faceElement, emoFaceId, false, msgSeq, contact, layoutParams, this);
                if (createRandomLottieAnimViewForMedia == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                createLottieAnimViewForMedia = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).createLottieAnimViewForMedia(this.$context, this.$intent.getParentView(), this.$intent.getEmoFaceId(), layoutParams, null);
                main = Dispatchers.getMain();
                anonymousClass1 = new AnonymousClass1(createLottieAnimViewForMedia, this.$intent, null);
                this.label = 2;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        createLottieAnimViewForMedia = (View) createRandomLottieAnimViewForMedia;
        main = Dispatchers.getMain();
        anonymousClass1 = new AnonymousClass1(createLottieAnimViewForMedia, this.$intent, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaTextContentComponentVM$handleLottie$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

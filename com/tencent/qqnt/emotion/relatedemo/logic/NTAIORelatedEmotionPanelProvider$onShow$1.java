package com.tencent.qqnt.emotion.relatedemo.logic;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.relatedemo.ui.NTRelatedEmotionPanel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider$onShow$1", f = "NTAIORelatedEmotionPanelProvider.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
final class NTAIORelatedEmotionPanelProvider$onShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ NTAIORelatedEmotionPanelProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider$onShow$1$1", f = "NTAIORelatedEmotionPanelProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider$onShow$1$1, reason: invalid class name */
    /* loaded from: classes24.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ URLDrawable $drawable;
        int label;
        final /* synthetic */ NTAIORelatedEmotionPanelProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NTAIORelatedEmotionPanelProvider nTAIORelatedEmotionPanelProvider, URLDrawable uRLDrawable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = nTAIORelatedEmotionPanelProvider;
            this.$drawable = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, nTAIORelatedEmotionPanelProvider, uRLDrawable, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$drawable, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            NTRelatedEmotionPanel nTRelatedEmotionPanel;
            com.tencent.aio.api.runtime.a aVar;
            AIOMsgItem aIOMsgItem;
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    nTRelatedEmotionPanel = this.this$0.mEmotionSearchPanelNT;
                    if (nTRelatedEmotionPanel != null) {
                        aVar = this.this$0.mAIOContext;
                        AIOMsgItem aIOMsgItem2 = null;
                        if (aVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                            aVar = null;
                        }
                        aIOMsgItem = this.this$0.mMsgItem;
                        if (aIOMsgItem == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMsgItem");
                        } else {
                            aIOMsgItem2 = aIOMsgItem;
                        }
                        URLDrawable uRLDrawable = this.$drawable;
                        i3 = this.this$0.mBottomLayoutHeight;
                        i16 = this.this$0.mMaxPanelHeight;
                        nTRelatedEmotionPanel.s(aVar, aIOMsgItem2, uRLDrawable, i3 + i16);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIORelatedEmotionPanelProvider$onShow$1(NTAIORelatedEmotionPanelProvider nTAIORelatedEmotionPanelProvider, Continuation<? super NTAIORelatedEmotionPanelProvider$onShow$1> continuation) {
        super(2, continuation);
        this.this$0 = nTAIORelatedEmotionPanelProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTAIORelatedEmotionPanelProvider, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NTAIORelatedEmotionPanelProvider$onShow$1(this.this$0, continuation);
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
                NTAIORelatedEmotionPanelProvider nTAIORelatedEmotionPanelProvider = this.this$0;
                this.label = 1;
                obj = nTAIORelatedEmotionPanelProvider.n(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            URLDrawable uRLDrawable = (URLDrawable) obj;
            if (uRLDrawable != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("AIORelatedEmotionPanelProvider", 4, "panelProvider showEmotionSearchWindow");
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this.this$0, uRLDrawable, null), 3, null);
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NTAIORelatedEmotionPanelProvider$onShow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

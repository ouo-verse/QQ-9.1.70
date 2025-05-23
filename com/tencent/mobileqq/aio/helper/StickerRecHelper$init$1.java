package com.tencent.mobileqq.aio.helper;

import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.helper.StickerRecHelper$init$1", f = "StickerRecHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class StickerRecHelper$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ StickerRecHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.helper.StickerRecHelper$init$1$1", f = "StickerRecHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.helper.StickerRecHelper$init$1$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Ref.ObjectRef<View> $containerView;
        final /* synthetic */ Ref.ObjectRef<View> $inputBar;
        int label;
        final /* synthetic */ StickerRecHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StickerRecHelper stickerRecHelper, Ref.ObjectRef<View> objectRef, Ref.ObjectRef<View> objectRef2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = stickerRecHelper;
            this.$containerView = objectRef;
            this.$inputBar = objectRef2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, stickerRecHelper, objectRef, objectRef2, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$containerView, this.$inputBar, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar;
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.a aVar;
            Fragment fragment;
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.a aVar2;
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.a aVar3;
            Fragment fragment2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    bVar = this.this$0.mViewModel;
                    if (bVar != null) {
                        aVar = this.this$0.mViewBinder;
                        if (aVar != null) {
                            fragment = this.this$0.mOwner;
                            if (fragment != null) {
                                try {
                                    this.this$0.H();
                                    aVar2 = this.this$0.mViewBinder;
                                    if (aVar2 != null) {
                                        fragment2 = this.this$0.mOwner;
                                        aVar2.b(fragment2);
                                    }
                                    aVar3 = this.this$0.mViewBinder;
                                    if (aVar3 != null) {
                                        aVar3.c((ConstraintLayout) this.$containerView.element, (EditText) this.$inputBar.element);
                                    }
                                } catch (Throwable th5) {
                                    QLog.e("StickerRecHelper", 1, "doOnResume initUI error! ", th5);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                    QLog.e("StickerRecHelper", 1, "doOnResume initUI error, init params is null!");
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
    public StickerRecHelper$init$1(StickerRecHelper stickerRecHelper, Continuation<? super StickerRecHelper$init$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerRecHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) stickerRecHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new StickerRecHelper$init$1(this.this$0, continuation);
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, android.view.View] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.main.businesshelper.b bVar2;
        com.tencent.aio.main.businesshelper.b bVar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                try {
                    bVar = this.this$0.mParam;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mParam");
                        bVar = null;
                    }
                    objectRef.element = bVar.a().c().requireActivity().findViewById(R.id.shh);
                    bVar2 = this.this$0.mParam;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mParam");
                        bVar2 = null;
                    }
                    ?? findViewById = bVar2.a().c().requireActivity().findViewById(R.id.input);
                    objectRef2.element = findViewById;
                    if ((objectRef.element instanceof ConstraintLayout) && (findViewById instanceof EditText)) {
                        this.this$0.enableAsyncAnalyze = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("enable_emotion_recommend_multi_thread");
                        ((IStickerRecManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IStickerRecManager.class, "all")).pullWords();
                        this.this$0.D();
                        bVar3 = this.this$0.mParam;
                        if (bVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mParam");
                            bVar3 = null;
                        }
                        LifecycleOwner d16 = bVar3.a().d();
                        Intrinsics.checkNotNullExpressionValue(d16, "mParam.aioContext.lifecycleOwner");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, objectRef, objectRef2, null), 2, null);
                        return Unit.INSTANCE;
                    }
                    QLog.e("StickerRecHelper", 1, "doOnResume initUI error, containerView or inputBar is invalidate!");
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    QLog.e("StickerRecHelper", 1, "doOnResume initUI error! ", th5);
                    return Unit.INSTANCE;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((StickerRecHelper$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

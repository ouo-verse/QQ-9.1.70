package com.tencent.aelight.camera.ae.flashshow.ui;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.event.QFSAggregationUpdateEvent;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2", f = "AEFlashShowMaterialPanel.kt", i = {}, l = {440, 451}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AEMaterialMetaData $it;
    int label;
    final /* synthetic */ AEFlashShowMaterialPanel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2$1", f = "AEFlashShowMaterialPanel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $toast;
        int label;
        final /* synthetic */ AEFlashShowMaterialPanel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AEFlashShowMaterialPanel aEFlashShowMaterialPanel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aEFlashShowMaterialPanel;
            this.$toast = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$toast, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.this$0.mContentView;
                QQToast.makeText(aEFlashShowMaterialProviderView != null ? aEFlashShowMaterialProviderView.getContext() : null, this.$toast, 0).show();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2(AEFlashShowMaterialPanel aEFlashShowMaterialPanel, AEMaterialMetaData aEMaterialMetaData, Continuation<? super AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2> continuation) {
        super(2, continuation);
        this.this$0 = aEFlashShowMaterialPanel;
        this.$it = aEMaterialMetaData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2(this.this$0, this.$it, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z16;
        AEFlashShowMaterialManager mTemplateManager;
        String str;
        MainCoroutineDispatcher main;
        AnonymousClass1 anonymousClass1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.this$0.mContentView;
            if (aEFlashShowMaterialProviderView != null && (mTemplateManager = aEFlashShowMaterialProviderView.getMTemplateManager()) != null) {
                AEMaterialMetaData aEMaterialMetaData = this.$it;
                this.label = 1;
                obj = mTemplateManager.r(aEMaterialMetaData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                z16 = false;
                if (!z16) {
                    str = "\u5df2\u6536\u85cf";
                } else {
                    str = "\u6536\u85cf\u5931\u8d25";
                }
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str2 = this.$it.f69050id;
                Intrinsics.checkNotNullExpressionValue(str2, "it.id");
                simpleEventBus.dispatchEvent(new QFSAggregationUpdateEvent(str2, "meterial", z16), true);
                main = Dispatchers.getMain();
                anonymousClass1 = new AnonymousClass1(this.this$0, str, null);
                this.label = 2;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        z16 = ((Boolean) obj).booleanValue();
        if (!z16) {
        }
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        String str22 = this.$it.f69050id;
        Intrinsics.checkNotNullExpressionValue(str22, "it.id");
        simpleEventBus2.dispatchEvent(new QFSAggregationUpdateEvent(str22, "meterial", z16), true);
        main = Dispatchers.getMain();
        anonymousClass1 = new AnonymousClass1(this.this$0, str, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

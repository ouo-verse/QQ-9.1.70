package com.tencent.mobileqq.wink.magicstudio.view;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$initObserver$1", f = "ImageCreateStylePart.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class ImageCreateStylePart$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageCreateStylePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<List<? extends com.tencent.mobileqq.wink.magicstudio.model.f>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageCreateStylePart f323911d;

        public a(ImageCreateStylePart imageCreateStylePart) {
            this.f323911d = imageCreateStylePart;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
        
            r0 = r1.f323911d.styleAdapter;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(List<? extends com.tencent.mobileqq.wink.magicstudio.model.f> list, @NotNull Continuation<? super Unit> continuation) {
            StyleAdapter styleAdapter;
            RecyclerView recyclerView;
            StyleAdapter styleAdapter2;
            List<? extends com.tencent.mobileqq.wink.magicstudio.model.f> list2 = list;
            w53.b.a("ImageCreationFragment", "styleData");
            styleAdapter = this.f323911d.styleAdapter;
            if (styleAdapter != 0) {
                styleAdapter.n0(list2);
            }
            ArrayList<String> N2 = this.f323911d.getVm().N2();
            if (N2 != null && styleAdapter2 != null) {
                styleAdapter2.o0(N2);
            }
            Iterator<? extends com.tencent.mobileqq.wink.magicstudio.model.f> it = list2.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getSelected()) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                recyclerView = this.f323911d.styleList;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("styleList");
                    recyclerView = null;
                }
                recyclerView.scrollToPosition(i3);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCreateStylePart$initObserver$1(ImageCreateStylePart imageCreateStylePart, Continuation<? super ImageCreateStylePart$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = imageCreateStylePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageCreateStylePart$initObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            StateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> V2 = this.this$0.getVm().V2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (V2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageCreateStylePart$initObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

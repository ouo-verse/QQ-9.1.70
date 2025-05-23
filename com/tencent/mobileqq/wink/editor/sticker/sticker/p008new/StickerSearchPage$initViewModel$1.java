package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.d;
import com.tencent.videocut.utils.j;
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
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerSearchPage$initViewModel$1", f = "StickerSearchPage.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class StickerSearchPage$initViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StickerSearchPage this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ StickerSearchPage f321837d;

        public a(StickerSearchPage stickerSearchPage) {
            this.f321837d = stickerSearchPage;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(d dVar, @NotNull Continuation<? super Unit> continuation) {
            View u16;
            View u17;
            RecyclerView t16;
            d dVar2 = dVar;
            if (dVar2 instanceof d.SearchToggle) {
                d.SearchToggle searchToggle = (d.SearchToggle) dVar2;
                this.f321837d.M(searchToggle.getOpen(), searchToggle.getAnim());
            } else if (Intrinsics.areEqual(dVar2, d.e.f321871a)) {
                this.f321837d.A().setText("");
            } else if (Intrinsics.areEqual(dVar2, d.f.f321872a)) {
                u17 = this.f321837d.u();
                u17.setVisibility(0);
                j.f384247a.a(this.f321837d.A());
                t16 = this.f321837d.t();
                t16.scrollToPosition(0);
            } else if (Intrinsics.areEqual(dVar2, d.C9037d.f321870a)) {
                u16 = this.f321837d.u();
                u16.setVisibility(8);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSearchPage$initViewModel$1(StickerSearchPage stickerSearchPage, Continuation<? super StickerSearchPage$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerSearchPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StickerSearchPage$initViewModel$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkEditorStickerViewModel winkEditorStickerViewModel;
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
            winkEditorStickerViewModel = this.this$0.viewModel;
            SharedFlow<d> p26 = winkEditorStickerViewModel.p2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (p26.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StickerSearchPage$initViewModel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

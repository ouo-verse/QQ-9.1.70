package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f324266d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f324267e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ FlowCollector f324268f;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1", f = "WinkNewAlbumMediaScanProcessor.kt", i = {0}, l = {137}, m = "emit", n = {"this"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1(List list, int i3, FlowCollector flowCollector) {
        this.f324266d = list;
        this.f324267e = i3;
        this.f324268f = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        List list;
        WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1<T> winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1 = (WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.f324266d.add(t16);
                    if (this.f324266d.size() == this.f324267e) {
                        FlowCollector flowCollector = this.f324268f;
                        list = CollectionsKt___CollectionsKt.toList(this.f324266d);
                        anonymousClass1.L$0 = this;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(list, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1 = this;
                    }
                    return Unit.INSTANCE;
                }
                winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1.f324266d.clear();
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1.f324266d.clear();
        return Unit.INSTANCE;
    }
}

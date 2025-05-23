package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes28.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator<T> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i3, int i16, Iterator<? extends T> it, boolean z16, boolean z17, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i3;
        this.$step = i16;
        this.$iterator = it;
        this.$reuseBuffer = z16;
        this.$partialWindows = z17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x014c -> B:12:0x014f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x011e -> B:30:0x0121). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00a7 -> B:50:0x0059). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int coerceAtMost;
        RingBuffer ringBuffer;
        Iterator<T> it;
        SequenceScope sequenceScope;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$1;
        SequenceScope sequenceScope2;
        int i3;
        ArrayList arrayList;
        Iterator<T> it5;
        int i16;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$12;
        RingBuffer ringBuffer2;
        SequenceScope sequenceScope3;
        RandomAccess arrayList2;
        RandomAccess arrayList3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ringBuffer2 = (RingBuffer) this.L$1;
                            sequenceScope3 = (SequenceScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            slidingWindowKt$windowedIterator$1 = this;
                            ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                            if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                                if (slidingWindowKt$windowedIterator$1.$reuseBuffer) {
                                    arrayList3 = ringBuffer2;
                                } else {
                                    arrayList3 = new ArrayList(ringBuffer2);
                                }
                                slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                                slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                                slidingWindowKt$windowedIterator$1.L$2 = null;
                                slidingWindowKt$windowedIterator$1.label = 4;
                                if (sequenceScope3.yield(arrayList3, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                                if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                                    if (!ringBuffer2.isEmpty()) {
                                        slidingWindowKt$windowedIterator$1.L$0 = null;
                                        slidingWindowKt$windowedIterator$1.L$1 = null;
                                        slidingWindowKt$windowedIterator$1.L$2 = null;
                                        slidingWindowKt$windowedIterator$1.label = 5;
                                        if (sequenceScope3.yield(ringBuffer2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    } else {
                        it = (Iterator) this.L$2;
                        ringBuffer = (RingBuffer) this.L$1;
                        sequenceScope = (SequenceScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        slidingWindowKt$windowedIterator$1 = this;
                        ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                        while (it.hasNext()) {
                            ringBuffer.add((RingBuffer) it.next());
                            if (ringBuffer.isFull()) {
                                int size = ringBuffer.size();
                                int i18 = slidingWindowKt$windowedIterator$1.$size;
                                if (size < i18) {
                                    ringBuffer = ringBuffer.expanded(i18);
                                } else {
                                    if (slidingWindowKt$windowedIterator$1.$reuseBuffer) {
                                        arrayList2 = ringBuffer;
                                    } else {
                                        arrayList2 = new ArrayList(ringBuffer);
                                    }
                                    slidingWindowKt$windowedIterator$1.L$0 = sequenceScope;
                                    slidingWindowKt$windowedIterator$1.L$1 = ringBuffer;
                                    slidingWindowKt$windowedIterator$1.L$2 = it;
                                    slidingWindowKt$windowedIterator$1.label = 3;
                                    if (sequenceScope.yield(arrayList2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                                    while (it.hasNext()) {
                                    }
                                }
                            }
                        }
                        if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                            ringBuffer2 = ringBuffer;
                            sequenceScope3 = sequenceScope;
                            if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i16 = this.I$0;
            it5 = (Iterator) this.L$2;
            arrayList = (ArrayList) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            slidingWindowKt$windowedIterator$12 = this;
            i3 = i16;
            if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                arrayList.clear();
            } else {
                arrayList = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
            }
            i16 = i3;
            while (it5.hasNext()) {
                T next = it5.next();
                if (i3 > 0) {
                    i3--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                        slidingWindowKt$windowedIterator$12.L$0 = sequenceScope2;
                        slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                        slidingWindowKt$windowedIterator$12.L$2 = it5;
                        slidingWindowKt$windowedIterator$12.I$0 = i16;
                        slidingWindowKt$windowedIterator$12.label = 1;
                        if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i16;
                        if (!slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                        }
                        i16 = i3;
                        while (it5.hasNext()) {
                        }
                    }
                }
            }
            if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.$size, 1024);
        int i19 = this.$step - this.$size;
        if (i19 >= 0) {
            sequenceScope2 = sequenceScope4;
            i3 = 0;
            arrayList = new ArrayList(coerceAtMost);
            it5 = this.$iterator;
            i16 = i19;
            slidingWindowKt$windowedIterator$12 = this;
            while (it5.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        ringBuffer = new RingBuffer(coerceAtMost);
        it = this.$iterator;
        sequenceScope = sequenceScope4;
        slidingWindowKt$windowedIterator$1 = this;
        while (it.hasNext()) {
        }
        if (slidingWindowKt$windowedIterator$1.$partialWindows) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super List<? extends T>> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

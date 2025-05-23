package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class AwaitKt {
    @Nullable
    public static final <T> Object awaitAll(@NotNull Deferred<? extends T>[] deferredArr, @NotNull Continuation<? super List<? extends T>> continuation) {
        List emptyList;
        if (!(deferredArr.length == 0)) {
            return new AwaitAll(deferredArr).await(continuation);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:10:0x0057). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(@NotNull Job[] jobArr, @NotNull Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        Object coroutine_suspended;
        int i3;
        Job[] jobArr2;
        int i16;
        int i17;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            int i18 = awaitKt$joinAll$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label = i18 - Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = awaitKt$joinAll$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int length = jobArr.length;
                    jobArr2 = jobArr;
                    i16 = 0;
                    i17 = length;
                    if (i16 < i17) {
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i16 = awaitKt$joinAll$1.I$1;
                    i17 = awaitKt$joinAll$1.I$0;
                    Job[] jobArr3 = (Job[]) awaitKt$joinAll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jobArr2 = jobArr3;
                    i16++;
                    if (i16 < i17) {
                        Job job = jobArr2[i16];
                        awaitKt$joinAll$1.L$0 = jobArr2;
                        awaitKt$joinAll$1.I$0 = i17;
                        awaitKt$joinAll$1.I$1 = i16;
                        awaitKt$joinAll$1.label = 1;
                        if (job.join(awaitKt$joinAll$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i16++;
                        if (i16 < i17) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        Object obj2 = awaitKt$joinAll$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = awaitKt$joinAll$1.label;
        if (i3 != 0) {
        }
    }

    @Nullable
    public static final <T> Object awaitAll(@NotNull Collection<? extends Deferred<? extends T>> collection, @NotNull Continuation<? super List<? extends T>> continuation) {
        List emptyList;
        if (collection.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Object[] array = collection.toArray(new Deferred[0]);
        if (array != null) {
            return new AwaitAll((Deferred[]) array).await(continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(@NotNull Collection<? extends Job> collection, @NotNull Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        Object coroutine_suspended;
        int i3;
        Iterator it;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            int i16 = awaitKt$joinAll$3.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label = i16 - Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = awaitKt$joinAll$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    it = collection.iterator();
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) awaitKt$joinAll$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    Job job = (Job) it.next();
                    awaitKt$joinAll$3.L$0 = it;
                    awaitKt$joinAll$3.label = 1;
                    if (job.join(awaitKt$joinAll$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        Object obj2 = awaitKt$joinAll$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = awaitKt$joinAll$3.label;
        if (i3 != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}

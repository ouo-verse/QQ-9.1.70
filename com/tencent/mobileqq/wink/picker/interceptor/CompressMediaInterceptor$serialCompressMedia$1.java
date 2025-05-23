package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.CompressMediaInterceptor$serialCompressMedia$1", f = "CompressMediaInterceptor.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
/* loaded from: classes21.dex */
public final class CompressMediaInterceptor$serialCompressMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicBoolean $isRunning;
    final /* synthetic */ List<LocalMediaInfo> $media;
    final /* synthetic */ Function2<Integer, Float, Unit> $onProgressChanged;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CompressMediaInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CompressMediaInterceptor$serialCompressMedia$1(List<? extends LocalMediaInfo> list, CompressMediaInterceptor compressMediaInterceptor, AtomicBoolean atomicBoolean, Function2<? super Integer, ? super Float, Unit> function2, Continuation<? super CompressMediaInterceptor$serialCompressMedia$1> continuation) {
        super(2, continuation);
        this.$media = list;
        this.this$0 = compressMediaInterceptor;
        this.$isRunning = atomicBoolean;
        this.$onProgressChanged = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CompressMediaInterceptor$serialCompressMedia$1(this.$media, this.this$0, this.$isRunning, this.$onProgressChanged, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:6:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:5:0x0071). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0077 -> B:6:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0079 -> B:6:0x007e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        AtomicBoolean atomicBoolean;
        CompressMediaInterceptor$serialCompressMedia$1 compressMediaInterceptor$serialCompressMedia$1;
        Iterator it;
        Function2<Integer, Float, Unit> function2;
        CountDownLatch countDownLatch;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = this.I$0;
                it = (Iterator) this.L$2;
                Function2<Integer, Float, Unit> function22 = (Function2) this.L$1;
                atomicBoolean = (AtomicBoolean) this.L$0;
                ResultKt.throwOnFailure(obj);
                int i18 = i17;
                compressMediaInterceptor$serialCompressMedia$1 = this;
                function2 = function22;
                i3 = i18;
                if (it.hasNext()) {
                    Object next = it.next();
                    i18 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
                    if (atomicBoolean.get()) {
                        if (e93.i.I(localMediaInfo)) {
                            MediaCompressUtils mediaCompressUtils = MediaCompressUtils.f325262a;
                            compressMediaInterceptor$serialCompressMedia$1.L$0 = atomicBoolean;
                            compressMediaInterceptor$serialCompressMedia$1.L$1 = function2;
                            compressMediaInterceptor$serialCompressMedia$1.L$2 = it;
                            compressMediaInterceptor$serialCompressMedia$1.I$0 = i18;
                            compressMediaInterceptor$serialCompressMedia$1.label = 1;
                            if (mediaCompressUtils.l(i3, localMediaInfo, function2, compressMediaInterceptor$serialCompressMedia$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function22 = function2;
                            function2 = function22;
                        } else if (e93.i.G(localMediaInfo)) {
                            MediaCompressUtils.f325262a.j(i3, localMediaInfo, true, function2);
                        }
                    }
                    i3 = i18;
                    if (it.hasNext()) {
                        countDownLatch = compressMediaInterceptor$serialCompressMedia$1.this$0.syncLatch;
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            List<LocalMediaInfo> list = this.$media;
            AtomicBoolean atomicBoolean2 = this.$isRunning;
            Function2<Integer, Float, Unit> function23 = this.$onProgressChanged;
            i3 = 0;
            atomicBoolean = atomicBoolean2;
            compressMediaInterceptor$serialCompressMedia$1 = this;
            it = list.iterator();
            function2 = function23;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CompressMediaInterceptor$serialCompressMedia$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$startHandleMediaList$2", f = "MemoryAlbumGenerator.kt", i = {0}, l = {209, 215}, m = "invokeSuspend", n = {"$this$supervisorScope"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$startHandleMediaList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<LocalMediaInfo> $mediaList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$startHandleMediaList$2(List<LocalMediaInfo> list, Continuation<? super MemoryAlbumGenerator$startHandleMediaList$2> continuation) {
        super(2, continuation);
        this.$mediaList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MemoryAlbumGenerator$startHandleMediaList$2 memoryAlbumGenerator$startHandleMediaList$2 = new MemoryAlbumGenerator$startHandleMediaList$2(this.$mediaList, continuation);
        memoryAlbumGenerator$startHandleMediaList$2.L$0 = obj;
        return memoryAlbumGenerator$startHandleMediaList$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        CoroutineScope coroutineScope;
        Object Y;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception e16) {
            MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
            w53.b.c(memoryAlbumGenerator.c(), "generateAlbums error " + e16.getMessage());
            memoryAlbumGenerator.b0();
            z16 = false;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    z16 = ((Boolean) obj).booleanValue();
                    return Boxing.boxBoolean(z16);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            MemoryAlbumGenerator memoryAlbumGenerator2 = MemoryAlbumGenerator.f326501a;
            List<LocalMediaInfo> list = this.$mediaList;
            this.L$0 = coroutineScope;
            this.label = 1;
            Y = memoryAlbumGenerator2.Y(list, this);
            if (Y == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MemoryAlbumGenerator$startHandleMediaList$2$deferred1$1(null), 3, null);
        this.L$0 = null;
        this.label = 2;
        obj = async$default.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        z16 = ((Boolean) obj).booleanValue();
        return Boxing.boxBoolean(z16);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((MemoryAlbumGenerator$startHandleMediaList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

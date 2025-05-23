package com.tencent.mobileqq.wink.newalbum.director.datasource;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$onNewAlbumProduced$2", f = "WinkAlbumDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAlbumDataSource$onNewAlbumProduced$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkNewMemoryAlbumResult $newAlbumResult;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAlbumDataSource$onNewAlbumProduced$2(WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, Continuation<? super WinkAlbumDataSource$onNewAlbumProduced$2> continuation) {
        super(2, continuation);
        this.$newAlbumResult = winkNewMemoryAlbumResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAlbumDataSource$onNewAlbumProduced$2(this.$newAlbumResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        List list2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = this.$newAlbumResult;
            list = WinkAlbumDataSource.newAlbumSourceDataList;
            list.add(winkNewMemoryAlbumResult);
            list2 = WinkAlbumDataSource._allAlbumDataTypeDataList;
            list2.add(b.a(winkNewMemoryAlbumResult, WinkAlbumItemType.DATA_TYPE_NEW_ALBUM));
            WinkAlbumDataSource.f324204a.B();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAlbumDataSource$onNewAlbumProduced$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

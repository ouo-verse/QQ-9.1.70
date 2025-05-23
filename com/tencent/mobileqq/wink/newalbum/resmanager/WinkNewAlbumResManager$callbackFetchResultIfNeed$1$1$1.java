package com.tencent.mobileqq.wink.newalbum.resmanager;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1", f = "WinkNewAlbumResManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkNewAlbumResFetchResult $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1(WinkNewAlbumResFetchResult winkNewAlbumResFetchResult, Continuation<? super WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1> continuation) {
        super(2, continuation);
        this.$result = winkNewAlbumResFetchResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1(this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Set<a> fetchResultCallbackList;
        Set set;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            fetchResultCallbackList = WinkNewAlbumResManager.fetchResultCallbackList;
            Intrinsics.checkNotNullExpressionValue(fetchResultCallbackList, "fetchResultCallbackList");
            WinkNewAlbumResFetchResult winkNewAlbumResFetchResult = this.$result;
            for (a aVar : fetchResultCallbackList) {
                QLog.d("WinkNewAlbum_WinkNewAlbumResManager", 1, "callbackFetchResultIfNeed, callback:" + aVar);
                if (aVar != null) {
                    aVar.a(winkNewAlbumResFetchResult);
                }
            }
            set = WinkNewAlbumResManager.fetchResultCallbackList;
            set.clear();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumResManager$callbackFetchResultIfNeed$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

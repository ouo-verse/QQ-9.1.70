package com.tencent.mobileqq.wink.db.memoryalbumdb;

import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Ls53/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.db.memoryalbumdb.WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1", f = "WinkMemoryAlbumDBHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends s53.a>>, Object> {
    final /* synthetic */ WinkMemoryAlbumConfig $config;
    final /* synthetic */ b $winkMemoryAlbumSQLiteDAO;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1(b bVar, WinkMemoryAlbumConfig winkMemoryAlbumConfig, Continuation<? super WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1> continuation) {
        super(2, continuation);
        this.$winkMemoryAlbumSQLiteDAO = bVar;
        this.$config = winkMemoryAlbumConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1(this.$winkMemoryAlbumSQLiteDAO, this.$config, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends s53.a>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<s53.a>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$winkMemoryAlbumSQLiteDAO.d(this.$config);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<s53.a>> continuation) {
        return ((WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

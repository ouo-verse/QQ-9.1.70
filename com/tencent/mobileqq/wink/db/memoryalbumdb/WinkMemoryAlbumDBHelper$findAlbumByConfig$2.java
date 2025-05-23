package com.tencent.mobileqq.wink.db.memoryalbumdb;

import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Ls53/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.db.memoryalbumdb.WinkMemoryAlbumDBHelper$findAlbumByConfig$2", f = "WinkMemoryAlbumDBHelper.kt", i = {0}, l = {65}, m = "invokeSuspend", n = {"winkMemoryAlbumSQLiteDAO"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkMemoryAlbumDBHelper$findAlbumByConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends s53.a>>, Object> {
    final /* synthetic */ WinkMemoryAlbumConfig $config;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemoryAlbumDBHelper$findAlbumByConfig$2(WinkMemoryAlbumConfig winkMemoryAlbumConfig, Continuation<? super WinkMemoryAlbumDBHelper$findAlbumByConfig$2> continuation) {
        super(2, continuation);
        this.$config = winkMemoryAlbumConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMemoryAlbumDBHelper$findAlbumByConfig$2(this.$config, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends s53.a>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<s53.a>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                bVar = (b) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            b bVar2 = new b(BaseApplication.getContext());
            CoroutineDispatcher a16 = WinkCoroutineScopes.f317652a.a();
            WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1 winkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1 = new WinkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1(bVar2, this.$config, null);
            this.L$0 = bVar2;
            this.label = 1;
            obj = BuildersKt.withContext(a16, winkMemoryAlbumDBHelper$findAlbumByConfig$2$albums$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
        }
        List list = (List) obj;
        bVar.a();
        return list;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<s53.a>> continuation) {
        return ((WinkMemoryAlbumDBHelper$findAlbumByConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

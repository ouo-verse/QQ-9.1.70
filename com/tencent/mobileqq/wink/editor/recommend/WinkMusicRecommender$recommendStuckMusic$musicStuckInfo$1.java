package com.tencent.mobileqq.wink.editor.recommend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.recommend.WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1", f = "WinkMusicRecommender.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends QQCircleSmartMatchMusic$MusicStuckPointInfo>>, Object> {
    final /* synthetic */ List<QQCircleSmartMatchMusic$MusicInfo> $musicInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1(List<QQCircleSmartMatchMusic$MusicInfo> list, Continuation<? super WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1> continuation) {
        super(2, continuation);
        this.$musicInfo = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1(this.$musicInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends QQCircleSmartMatchMusic$MusicStuckPointInfo>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<QQCircleSmartMatchMusic$MusicStuckPointInfo>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
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
            WinkMusicRecommender winkMusicRecommender = WinkMusicRecommender.f321453a;
            List<QQCircleSmartMatchMusic$MusicInfo> list = this.$musicInfo;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((QQCircleSmartMatchMusic$MusicInfo) it.next()).songInfo.MID.get());
            }
            this.label = 1;
            obj = winkMusicRecommender.f(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<QQCircleSmartMatchMusic$MusicStuckPointInfo>> continuation) {
        return ((WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

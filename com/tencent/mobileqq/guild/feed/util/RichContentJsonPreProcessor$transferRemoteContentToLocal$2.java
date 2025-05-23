package com.tencent.mobileqq.guild.feed.util;

import com.tencent.libra.request.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/mobileqq/guild/feed/util/DownloadToLocalResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$transferRemoteContentToLocal$2", f = "RichContentJsonPreProcessor.kt", i = {0}, l = {398}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class RichContentJsonPreProcessor$transferRemoteContentToLocal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<Integer, ? extends Option>>, Object> {
    final /* synthetic */ Sequence<Pair<Integer, String>> $images;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichContentJsonPreProcessor$transferRemoteContentToLocal$2(Sequence<Pair<Integer, String>> sequence, Continuation<? super RichContentJsonPreProcessor$transferRemoteContentToLocal$2> continuation) {
        super(2, continuation);
        this.$images = sequence;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RichContentJsonPreProcessor$transferRemoteContentToLocal$2 richContentJsonPreProcessor$transferRemoteContentToLocal$2 = new RichContentJsonPreProcessor$transferRemoteContentToLocal$2(this.$images, continuation);
        richContentJsonPreProcessor$transferRemoteContentToLocal$2.L$0 = obj;
        return richContentJsonPreProcessor$transferRemoteContentToLocal$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0057  */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x006c -> B:5:0x0072). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Sequence map;
        List list;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Iterator it;
        RichContentJsonPreProcessor$transferRemoteContentToLocal$2 richContentJsonPreProcessor$transferRemoteContentToLocal$2;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ?? r16 = (Collection) this.L$2;
                Iterator it5 = (Iterator) this.L$1;
                ?? r56 = (Collection) this.L$0;
                ResultKt.throwOnFailure(obj);
                Iterator it6 = it5;
                ArrayList arrayList2 = r16;
                Object obj2 = coroutine_suspended;
                RichContentJsonPreProcessor$transferRemoteContentToLocal$2 richContentJsonPreProcessor$transferRemoteContentToLocal$22 = this;
                ArrayList arrayList3 = r56;
                arrayList2.add((Pair) obj);
                richContentJsonPreProcessor$transferRemoteContentToLocal$2 = richContentJsonPreProcessor$transferRemoteContentToLocal$22;
                coroutine_suspended = obj2;
                arrayList = arrayList3;
                it = it6;
                if (it.hasNext()) {
                    Deferred deferred = (Deferred) it.next();
                    richContentJsonPreProcessor$transferRemoteContentToLocal$2.L$0 = arrayList;
                    richContentJsonPreProcessor$transferRemoteContentToLocal$2.L$1 = it;
                    richContentJsonPreProcessor$transferRemoteContentToLocal$2.L$2 = arrayList;
                    richContentJsonPreProcessor$transferRemoteContentToLocal$2.label = 1;
                    Object await = deferred.await(richContentJsonPreProcessor$transferRemoteContentToLocal$2);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it6 = it;
                    arrayList2 = arrayList;
                    obj2 = coroutine_suspended;
                    richContentJsonPreProcessor$transferRemoteContentToLocal$22 = richContentJsonPreProcessor$transferRemoteContentToLocal$2;
                    obj = await;
                    arrayList3 = arrayList2;
                    arrayList2.add((Pair) obj);
                    richContentJsonPreProcessor$transferRemoteContentToLocal$2 = richContentJsonPreProcessor$transferRemoteContentToLocal$22;
                    coroutine_suspended = obj2;
                    arrayList = arrayList3;
                    it = it6;
                    if (it.hasNext()) {
                        ArrayList<Pair> arrayList4 = arrayList;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
                        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                        for (Pair pair : arrayList4) {
                            linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        }
                        return linkedHashMap;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            map = SequencesKt___SequencesKt.map(this.$images, new Function1<Pair<? extends Integer, ? extends String>, Deferred<? extends Pair<? extends Integer, ? extends Option>>>() { // from class: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$transferRemoteContentToLocal$2.1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/mobileqq/guild/feed/util/DownloadToLocalResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$transferRemoteContentToLocal$2$1$1", f = "RichContentJsonPreProcessor.kt", i = {}, l = {394}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$transferRemoteContentToLocal$2$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes13.dex */
                public static final class C77801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends Option>>, Object> {
                    final /* synthetic */ int $index;
                    final /* synthetic */ String $picUrl;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C77801(int i3, String str, Continuation<? super C77801> continuation) {
                        super(2, continuation);
                        this.$index = i3;
                        this.$picUrl = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C77801(this.$index, this.$picUrl, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends Option>> continuation) {
                        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, ? extends Option>>) continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        Object f16;
                        Integer num;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                num = (Integer) this.L$0;
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            Integer boxInt = Boxing.boxInt(this.$index);
                            RichContentJsonPreProcessor richContentJsonPreProcessor = RichContentJsonPreProcessor.f223806a;
                            String str = this.$picUrl;
                            this.L$0 = boxInt;
                            this.label = 1;
                            f16 = richContentJsonPreProcessor.f(str, this);
                            if (f16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            num = boxInt;
                            obj = f16;
                        }
                        return TuplesKt.to(num, obj);
                    }

                    @Nullable
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<Integer, ? extends Option>> continuation) {
                        return ((C77801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Deferred<? extends Pair<? extends Integer, ? extends Option>> invoke(Pair<? extends Integer, ? extends String> pair2) {
                    return invoke2((Pair<Integer, String>) pair2);
                }

                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Deferred<Pair<Integer, Option>> invoke2(@NotNull Pair<Integer, String> pair2) {
                    Deferred<Pair<Integer, Option>> async$default;
                    Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
                    async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope.this, ae.a().b(), null, new C77801(pair2.component1().intValue(), pair2.component2(), null), 2, null);
                    return async$default;
                }
            });
            list = SequencesKt___SequencesKt.toList(map);
            List list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            it = list2.iterator();
            richContentJsonPreProcessor$transferRemoteContentToLocal$2 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Map<Integer, ? extends Option>> continuation) {
        return ((RichContentJsonPreProcessor$transferRemoteContentToLocal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

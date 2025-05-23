package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchChatAsync$1", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NTFtsMessageSearchEngine$searchChatAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstPage;
    final /* synthetic */ String $keyword;
    final /* synthetic */ on2.d<ep2.d> $listener;
    final /* synthetic */ int $pageLimit;
    final /* synthetic */ int $queryId;
    final /* synthetic */ Flow<SearchChatsKeywordsResult> $resultFlow;
    final /* synthetic */ ArrayList<String> $splitKeywords;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NTFtsMessageSearchEngine this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<SearchChatsKeywordsResult> {
        final /* synthetic */ ArrayList C;
        final /* synthetic */ int D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f283309d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f283310e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ on2.d f283311f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f283312h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f283313i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ NTFtsMessageSearchEngine f283314m;

        public a(int i3, boolean z16, on2.d dVar, String str, CoroutineScope coroutineScope, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList arrayList, int i16) {
            this.f283309d = i3;
            this.f283310e = z16;
            this.f283311f = dVar;
            this.f283312h = str;
            this.f283313i = coroutineScope;
            this.f283314m = nTFtsMessageSearchEngine;
            this.C = arrayList;
            this.D = i16;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(SearchChatsKeywordsResult searchChatsKeywordsResult, @NotNull Continuation<? super Unit> continuation) {
            int collectionSizeOrDefault;
            y bVar;
            boolean k3;
            SearchChatsKeywordsResult searchChatsKeywordsResult2 = searchChatsKeywordsResult;
            ArrayList<SearchChatSummaryItem> arrayList = searchChatsKeywordsResult2.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.resultItems");
            ArrayList<SearchChatSummaryItem> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                k3 = this.f283314m.k(((SearchChatSummaryItem) obj).chatType);
                if (k3) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (SearchChatSummaryItem it : arrayList2) {
                if (it.chatType == 105) {
                    AppInterface d16 = this.f283314m.d();
                    String str = this.f283312h;
                    ArrayList arrayList4 = this.C;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    bVar = new vn2.c(d16, str, null, arrayList4, null, it, this.f283309d);
                } else {
                    AppInterface d17 = this.f283314m.d();
                    String str2 = this.f283312h;
                    String str3 = it.realKeywords;
                    ArrayList arrayList5 = this.C;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    int i3 = this.f283309d;
                    String str4 = it.recallReason;
                    Intrinsics.checkNotNullExpressionValue(str4, "it.recallReason");
                    bVar = new vn2.b(d17, str2, str3, arrayList5, null, it, i3, str4);
                }
                arrayList3.add(bVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("NTFtsMessageSearchEngine", 1, "receive search result, data size=" + arrayList3.size() + " queryId:" + this.f283309d + " isFirst:" + this.f283310e);
            }
            on2.d dVar = this.f283311f;
            if (dVar != null) {
                pn2.b bVar2 = new pn2.b(this.f283312h, 1);
                bVar2.f426499b = new Bundle();
                if (arrayList3.size() >= this.D) {
                    bVar2.f426499b.putInt("queryId", this.f283309d);
                }
                bVar2.f426499b.putBoolean("extra_has_more", searchChatsKeywordsResult2.hasMore);
                bVar2.f426499b.putBoolean("extra_is_first_page", this.f283310e);
                Unit unit = Unit.INSTANCE;
                dVar.onFinish(arrayList3, bVar2);
            }
            CoroutineScopeKt.cancel$default(this.f283313i, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchChatAsync$1(Flow<SearchChatsKeywordsResult> flow, int i3, boolean z16, on2.d<ep2.d> dVar, String str, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList<String> arrayList, int i16, Continuation<? super NTFtsMessageSearchEngine$searchChatAsync$1> continuation) {
        super(2, continuation);
        this.$resultFlow = flow;
        this.$queryId = i3;
        this.$isFirstPage = z16;
        this.$listener = dVar;
        this.$keyword = str;
        this.this$0 = nTFtsMessageSearchEngine;
        this.$splitKeywords = arrayList;
        this.$pageLimit = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTFtsMessageSearchEngine$searchChatAsync$1 nTFtsMessageSearchEngine$searchChatAsync$1 = new NTFtsMessageSearchEngine$searchChatAsync$1(this.$resultFlow, this.$queryId, this.$isFirstPage, this.$listener, this.$keyword, this.this$0, this.$splitKeywords, this.$pageLimit, continuation);
        nTFtsMessageSearchEngine$searchChatAsync$1.L$0 = obj;
        return nTFtsMessageSearchEngine$searchChatAsync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Flow<SearchChatsKeywordsResult> flow = this.$resultFlow;
            final int i16 = this.$queryId;
            Flow<SearchChatsKeywordsResult> flow2 = new Flow<SearchChatsKeywordsResult>() { // from class: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchChatAsync$1$invokeSuspend$$inlined$filter$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchChatAsync$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass2 implements FlowCollector<SearchChatsKeywordsResult> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f283285d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f283286e;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchChatAsync$1$invokeSuspend$$inlined$filter$1$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchChatAsync$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: classes18.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, int i3) {
                        this.f283285d = flowCollector;
                        this.f283286e = i3;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(SearchChatsKeywordsResult searchChatsKeywordsResult, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
                        boolean z16;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i16 = anonymousClass1.label;
                            if ((i16 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                Object obj = anonymousClass1.result;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i3 = anonymousClass1.label;
                                if (i3 == 0) {
                                    if (i3 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    FlowCollector flowCollector = this.f283285d;
                                    if (searchChatsKeywordsResult.searchId == this.f283286e) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(searchChatsKeywordsResult, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj2 = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i3 = anonymousClass1.label;
                        if (i3 == 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super SearchChatsKeywordsResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i16), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            a aVar = new a(this.$queryId, this.$isFirstPage, this.$listener, this.$keyword, coroutineScope, this.this$0, this.$splitKeywords, this.$pageLimit);
            this.label = 1;
            if (flow2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NTFtsMessageSearchEngine$searchChatAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchDetailAsync$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NTFtsMessageSearchEngine$searchDetailAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $aioTitle;
    final /* synthetic */ int $chatType;
    final /* synthetic */ String $keyword;
    final /* synthetic */ on2.d<ep2.c> $listener;
    final /* synthetic */ String $originalKeyword;
    final /* synthetic */ int $pageLimit;
    final /* synthetic */ int $queryId;
    final /* synthetic */ Flow<SearchMsgKeywordsResult> $resultFlow;
    final /* synthetic */ ArrayList<String> $splitKeywords;
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NTFtsMessageSearchEngine this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<SearchMsgKeywordsResult> {
        final /* synthetic */ String C;
        final /* synthetic */ int D;
        final /* synthetic */ String E;
        final /* synthetic */ int F;
        final /* synthetic */ int G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ on2.d f283315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f283316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f283317f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ NTFtsMessageSearchEngine f283318h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList f283319i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f283320m;

        public a(on2.d dVar, String str, CoroutineScope coroutineScope, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList arrayList, String str2, String str3, int i3, String str4, int i16, int i17) {
            this.f283315d = dVar;
            this.f283316e = str;
            this.f283317f = coroutineScope;
            this.f283318h = nTFtsMessageSearchEngine;
            this.f283319i = arrayList;
            this.f283320m = str2;
            this.C = str3;
            this.D = i3;
            this.E = str4;
            this.F = i16;
            this.G = i17;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(SearchMsgKeywordsResult searchMsgKeywordsResult, @NotNull Continuation<? super Unit> continuation) {
            int collectionSizeOrDefault;
            y jVar;
            SearchMsgKeywordsResult searchMsgKeywordsResult2 = searchMsgKeywordsResult;
            ArrayList<SearchMsgItem> arrayList = searchMsgKeywordsResult2.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.resultItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                SearchMsgItem it5 = (SearchMsgItem) it.next();
                MsgRecord msgRecord = it5.msgRecord;
                if (msgRecord == null || msgRecord.chatType != 105) {
                    z16 = false;
                }
                String str = "";
                if (z16) {
                    AppInterface app = this.f283318h.d();
                    Intrinsics.checkNotNullExpressionValue(app, "app");
                    String keyword = this.f283316e;
                    Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                    String str2 = this.f283316e;
                    ArrayList arrayList3 = this.f283319i;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    String str3 = this.f283320m;
                    String str4 = this.C;
                    if (str4 != null) {
                        str = str4;
                    }
                    jVar = new k(app, str2, arrayList3, it5, str3, str, this.D);
                } else {
                    AppInterface app2 = this.f283318h.d();
                    Intrinsics.checkNotNullExpressionValue(app2, "app");
                    String keyword2 = this.f283316e;
                    Intrinsics.checkNotNullExpressionValue(keyword2, "keyword");
                    String str5 = this.f283316e;
                    String originalKeyword = this.E;
                    Intrinsics.checkNotNullExpressionValue(originalKeyword, "originalKeyword");
                    String str6 = this.E;
                    ArrayList arrayList4 = this.f283319i;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    String str7 = this.f283320m;
                    String str8 = this.C;
                    if (str8 != null) {
                        str = str8;
                    }
                    jVar = new j(app2, str5, str6, arrayList4, it5, str7, str, this.D);
                }
                arrayList2.add(jVar);
            }
            QLog.d("NTFtsMessageSearchEngine", 1, "receive search result, data size=" + arrayList2.size() + " hasMore:" + searchMsgKeywordsResult2.hasMore);
            on2.d dVar = this.f283315d;
            pn2.b bVar = new pn2.b(this.f283316e, 1);
            bVar.f426499b = new Bundle();
            if (arrayList2.size() >= this.F) {
                bVar.f426499b.putInt("queryId", this.G);
            }
            bVar.f426499b.putBoolean("extra_has_more", searchMsgKeywordsResult2.hasMore);
            Unit unit = Unit.INSTANCE;
            dVar.onFinish(arrayList2, bVar);
            CoroutineScopeKt.cancel$default(this.f283317f, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchDetailAsync$2(Flow<SearchMsgKeywordsResult> flow, int i3, on2.d<ep2.c> dVar, String str, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList<String> arrayList, String str2, String str3, int i16, String str4, int i17, Continuation<? super NTFtsMessageSearchEngine$searchDetailAsync$2> continuation) {
        super(2, continuation);
        this.$resultFlow = flow;
        this.$queryId = i3;
        this.$listener = dVar;
        this.$keyword = str;
        this.this$0 = nTFtsMessageSearchEngine;
        this.$splitKeywords = arrayList;
        this.$uid = str2;
        this.$aioTitle = str3;
        this.$chatType = i16;
        this.$originalKeyword = str4;
        this.$pageLimit = i17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTFtsMessageSearchEngine$searchDetailAsync$2 nTFtsMessageSearchEngine$searchDetailAsync$2 = new NTFtsMessageSearchEngine$searchDetailAsync$2(this.$resultFlow, this.$queryId, this.$listener, this.$keyword, this.this$0, this.$splitKeywords, this.$uid, this.$aioTitle, this.$chatType, this.$originalKeyword, this.$pageLimit, continuation);
        nTFtsMessageSearchEngine$searchDetailAsync$2.L$0 = obj;
        return nTFtsMessageSearchEngine$searchDetailAsync$2;
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
            final Flow<SearchMsgKeywordsResult> flow = this.$resultFlow;
            final int i16 = this.$queryId;
            Flow flowOn = FlowKt.flowOn(new Flow<SearchMsgKeywordsResult>() { // from class: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchDetailAsync$2$invokeSuspend$$inlined$filter$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchDetailAsync$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass2 implements FlowCollector<SearchMsgKeywordsResult> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f283289d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f283290e;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchDetailAsync$2$invokeSuspend$$inlined$filter$1$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchDetailAsync$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                        this.f283289d = flowCollector;
                        this.f283290e = i3;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(SearchMsgKeywordsResult searchMsgKeywordsResult, @NotNull Continuation continuation) {
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
                                    FlowCollector flowCollector = this.f283289d;
                                    if (searchMsgKeywordsResult.searchId == this.f283290e) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(searchMsgKeywordsResult, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(@NotNull FlowCollector<? super SearchMsgKeywordsResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i16), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }, Dispatchers.getDefault());
            a aVar = new a(this.$listener, this.$keyword, coroutineScope, this.this$0, this.$splitKeywords, this.$uid, this.$aioTitle, this.$chatType, this.$originalKeyword, this.$pageLimit, this.$queryId);
            this.label = 1;
            if (flowOn.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NTFtsMessageSearchEngine$searchDetailAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

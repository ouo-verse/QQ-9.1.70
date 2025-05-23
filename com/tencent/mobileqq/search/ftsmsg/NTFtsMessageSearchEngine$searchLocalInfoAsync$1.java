package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoType;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchLocalInfoAsync$1", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NTFtsMessageSearchEngine$searchLocalInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ on2.d<ep2.d> $listener;
    final /* synthetic */ int $queryId;
    final /* synthetic */ Flow<SearchLocalInfoResult> $resultFlow;
    final /* synthetic */ ArrayList<String> $splitKeywords;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NTFtsMessageSearchEngine this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<SearchLocalInfoResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f283321d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f283322e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ on2.d f283323f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f283324h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ NTFtsMessageSearchEngine f283325i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ArrayList f283326m;

        public a(String str, int i3, on2.d dVar, CoroutineScope coroutineScope, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList arrayList) {
            this.f283321d = str;
            this.f283322e = i3;
            this.f283323f = dVar;
            this.f283324h = coroutineScope;
            this.f283325i = nTFtsMessageSearchEngine;
            this.f283326m = arrayList;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(SearchLocalInfoResult searchLocalInfoResult, @NotNull Continuation<? super Unit> continuation) {
            ArrayList arrayList;
            Integer num;
            int collectionSizeOrDefault;
            y bVar;
            ArrayList<SearchChatSummaryItem> chatsSummary = searchLocalInfoResult.chatsSummary;
            if (chatsSummary != null) {
                Intrinsics.checkNotNullExpressionValue(chatsSummary, "chatsSummary");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(chatsSummary, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                for (SearchChatSummaryItem it : chatsSummary) {
                    if (it.chatType == 105) {
                        AppInterface d16 = this.f283325i.d();
                        String str = this.f283321d;
                        ArrayList arrayList2 = this.f283326m;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        bVar = new vn2.c(d16, str, null, arrayList2, null, it, this.f283322e);
                    } else {
                        AppInterface d17 = this.f283325i.d();
                        String str2 = this.f283321d;
                        ArrayList arrayList3 = this.f283326m;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        int i3 = this.f283322e;
                        String str3 = it.recallReason;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.recallReason");
                        bVar = new vn2.b(d17, str2, null, arrayList3, null, it, i3, str3);
                    }
                    arrayList.add(bVar);
                }
            } else {
                arrayList = null;
            }
            if (QLog.isColorLevel()) {
                String str4 = this.f283321d;
                if (arrayList != null) {
                    num = Boxing.boxInt(arrayList.size());
                } else {
                    num = null;
                }
                QLog.d("NTFtsMessageSearchEngine", 1, "[searchLocalInfoAsync] receive search result, keyword:" + str4 + " data size=" + num + " queryId:" + this.f283322e);
            }
            on2.d dVar = this.f283323f;
            if (dVar != null) {
                pn2.b bVar2 = new pn2.b(this.f283321d, 1);
                Bundle bundle = new Bundle();
                bVar2.f426499b = bundle;
                bundle.putBoolean("extra_has_more", false);
                bVar2.f426499b.putBoolean("extra_is_first_page", true);
                Unit unit = Unit.INSTANCE;
                dVar.onFinish(arrayList, bVar2);
            }
            CoroutineScopeKt.cancel$default(this.f283324h, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchLocalInfoAsync$1(Flow<SearchLocalInfoResult> flow, int i3, String str, on2.d<ep2.d> dVar, NTFtsMessageSearchEngine nTFtsMessageSearchEngine, ArrayList<String> arrayList, Continuation<? super NTFtsMessageSearchEngine$searchLocalInfoAsync$1> continuation) {
        super(2, continuation);
        this.$resultFlow = flow;
        this.$queryId = i3;
        this.$keyword = str;
        this.$listener = dVar;
        this.this$0 = nTFtsMessageSearchEngine;
        this.$splitKeywords = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTFtsMessageSearchEngine$searchLocalInfoAsync$1 nTFtsMessageSearchEngine$searchLocalInfoAsync$1 = new NTFtsMessageSearchEngine$searchLocalInfoAsync$1(this.$resultFlow, this.$queryId, this.$keyword, this.$listener, this.this$0, this.$splitKeywords, continuation);
        nTFtsMessageSearchEngine$searchLocalInfoAsync$1.L$0 = obj;
        return nTFtsMessageSearchEngine$searchLocalInfoAsync$1;
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
            final Flow<SearchLocalInfoResult> flow = this.$resultFlow;
            final int i16 = this.$queryId;
            Flow<SearchLocalInfoResult> flow2 = new Flow<SearchLocalInfoResult>() { // from class: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchLocalInfoAsync$1$invokeSuspend$$inlined$filter$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchLocalInfoAsync$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass2 implements FlowCollector<SearchLocalInfoResult> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f283293d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f283294e;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchLocalInfoAsync$1$invokeSuspend$$inlined$filter$1$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchLocalInfoAsync$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                        this.f283293d = flowCollector;
                        this.f283294e = i3;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(SearchLocalInfoResult searchLocalInfoResult, @NotNull Continuation continuation) {
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
                                    FlowCollector flowCollector = this.f283293d;
                                    SearchLocalInfoResult searchLocalInfoResult2 = searchLocalInfoResult;
                                    if (searchLocalInfoResult2.f359215id == this.f283294e && searchLocalInfoResult2.type == SearchLocalInfoType.KSEARCHLOCALINFOTYPEMSG) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(searchLocalInfoResult, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(@NotNull FlowCollector<? super SearchLocalInfoResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i16), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            a aVar = new a(this.$keyword, this.$queryId, this.$listener, coroutineScope, this.this$0, this.$splitKeywords);
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
        return ((NTFtsMessageSearchEngine$searchLocalInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

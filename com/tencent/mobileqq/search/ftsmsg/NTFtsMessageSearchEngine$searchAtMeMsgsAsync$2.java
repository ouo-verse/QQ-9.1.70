package com.tencent.mobileqq.search.ftsmsg;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {691}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstPage;
    final /* synthetic */ String $keyword;
    final /* synthetic */ on2.d<ep2.d> $listener;
    final /* synthetic */ Ref.ObjectRef<String> $peerId;
    final /* synthetic */ int $queryId;
    final /* synthetic */ Flow<SearchAtMeMsgsResult> $resultFlow;
    final /* synthetic */ ArrayList<String> $splitKeywords;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<SearchAtMeMsgsResult> {
        final /* synthetic */ Ref.ObjectRef C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f283303d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f283304e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ on2.d f283305f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f283306h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f283307i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ArrayList f283308m;

        public a(int i3, boolean z16, on2.d dVar, String str, CoroutineScope coroutineScope, ArrayList arrayList, Ref.ObjectRef objectRef) {
            this.f283303d = i3;
            this.f283304e = z16;
            this.f283305f = dVar;
            this.f283306h = str;
            this.f283307i = coroutineScope;
            this.f283308m = arrayList;
            this.C = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(SearchAtMeMsgsResult searchAtMeMsgsResult, @NotNull Continuation<? super Unit> continuation) {
            int collectionSizeOrDefault;
            SearchAtMeMsgsResult searchAtMeMsgsResult2 = searchAtMeMsgsResult;
            ArrayList<SearchAtMeMsgsItem> arrayList = searchAtMeMsgsResult2.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.resultItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (true) {
                QQAppInterface qQAppInterface = null;
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                SearchAtMeMsgsItem item = (SearchAtMeMsgsItem) it.next();
                String str = searchAtMeMsgsResult2.selfGroupCardName;
                if (str.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime instanceof QQAppInterface) {
                        qQAppInterface = (QQAppInterface) peekAppRuntime;
                    }
                    if (qQAppInterface != null) {
                        str = ac.G(qQAppInterface, qQAppInterface.getAccount());
                        Intrinsics.checkNotNullExpressionValue(str, "getFriendNickName(this, account)");
                    } else {
                        str = "";
                    }
                }
                String selfGroupCardName = str;
                String str2 = this.f283306h;
                ArrayList arrayList3 = this.f283308m;
                Intrinsics.checkNotNullExpressionValue(selfGroupCardName, "selfGroupCardName");
                String str3 = (String) this.C.element;
                Intrinsics.checkNotNullExpressionValue(item, "item");
                arrayList2.add(new i(str2, null, arrayList3, null, selfGroupCardName, str3, item));
            }
            if (QLog.isColorLevel()) {
                QLog.d("NTFtsMessageSearchEngine", 1, "receive search result, data size=" + arrayList2.size() + " queryId:" + this.f283303d + " isFirst:" + this.f283304e);
            }
            on2.d dVar = this.f283305f;
            if (dVar != null) {
                pn2.b bVar = new pn2.b(this.f283306h, 1);
                Bundle bundle = new Bundle();
                bVar.f426499b = bundle;
                bundle.putInt("queryId", this.f283303d);
                bVar.f426499b.putBoolean("extra_has_more", searchAtMeMsgsResult2.hasMore);
                bVar.f426499b.putBoolean("extra_is_first_page", this.f283304e);
                Unit unit = Unit.INSTANCE;
                dVar.onFinish(arrayList2, bVar);
            }
            CoroutineScopeKt.cancel$default(this.f283307i, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2(Flow<SearchAtMeMsgsResult> flow, int i3, boolean z16, on2.d<ep2.d> dVar, String str, ArrayList<String> arrayList, Ref.ObjectRef<String> objectRef, Continuation<? super NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2> continuation) {
        super(2, continuation);
        this.$resultFlow = flow;
        this.$queryId = i3;
        this.$isFirstPage = z16;
        this.$listener = dVar;
        this.$keyword = str;
        this.$splitKeywords = arrayList;
        this.$peerId = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2 nTFtsMessageSearchEngine$searchAtMeMsgsAsync$2 = new NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2(this.$resultFlow, this.$queryId, this.$isFirstPage, this.$listener, this.$keyword, this.$splitKeywords, this.$peerId, continuation);
        nTFtsMessageSearchEngine$searchAtMeMsgsAsync$2.L$0 = obj;
        return nTFtsMessageSearchEngine$searchAtMeMsgsAsync$2;
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
            final Flow<SearchAtMeMsgsResult> flow = this.$resultFlow;
            final int i16 = this.$queryId;
            Flow<SearchAtMeMsgsResult> flow2 = new Flow<SearchAtMeMsgsResult>() { // from class: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2$invokeSuspend$$inlined$filter$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass2 implements FlowCollector<SearchAtMeMsgsResult> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f283281d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f283282e;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2$invokeSuspend$$inlined$filter$1$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                        this.f283281d = flowCollector;
                        this.f283282e = i3;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(SearchAtMeMsgsResult searchAtMeMsgsResult, @NotNull Continuation continuation) {
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
                                    FlowCollector flowCollector = this.f283281d;
                                    if (searchAtMeMsgsResult.searchId == this.f283282e) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(searchAtMeMsgsResult, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(@NotNull FlowCollector<? super SearchAtMeMsgsResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, i16), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            a aVar = new a(this.$queryId, this.$isFirstPage, this.$listener, this.$keyword, coroutineScope, this.$splitKeywords, this.$peerId);
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
        return ((NTFtsMessageSearchEngine$searchAtMeMsgsAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

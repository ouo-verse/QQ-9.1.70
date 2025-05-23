package com.tencent.sqshow.zootopia.friendsdressup.datasrouce;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zb3.FriendsRespData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$innerFriendDressUp$1", f = "DataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DataSource$innerFriendDressUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d<FriendsRespData> $callback;
    final /* synthetic */ long $friendUin;
    int label;
    final /* synthetic */ DataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataSource$innerFriendDressUp$1(d<FriendsRespData> dVar, DataSource dataSource, long j3, Continuation<? super DataSource$innerFriendDressUp$1> continuation) {
        super(2, continuation);
        this.$callback = dVar;
        this.this$0 = dataSource;
        this.$friendUin = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataSource$innerFriendDressUp$1(this.$callback, this.this$0, this.$friendUin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        e eVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback.z();
            this.this$0.sessionID = System.currentTimeMillis();
            final DataSource dataSource = this.this$0;
            final d<FriendsRespData> dVar = this.$callback;
            dataSource.hostCallBack = new e<FriendsRespData>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$innerFriendDressUp$1.1
                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(final FriendsRespData result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    final DataSource dataSource2 = DataSource.this;
                    final d<FriendsRespData> dVar2 = dVar;
                    dataSource2.p(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$innerFriendDressUp$1$1$onResultSuccess$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FriendsRespData A;
                            FriendsRespData o16;
                            com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", " innerFirstPage onResultSuccess  " + FriendsRespData.this);
                            d<FriendsRespData> dVar3 = dVar2;
                            DataSource dataSource3 = dataSource2;
                            A = dataSource3.A(FriendsRespData.this);
                            o16 = dataSource3.o(A);
                            dVar3.onResultSuccess(o16);
                            dVar2.y();
                        }
                    });
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(final int error, final String message) {
                    final DataSource dataSource2 = DataSource.this;
                    final d<FriendsRespData> dVar2 = dVar;
                    dataSource2.p(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$innerFriendDressUp$1$1$onResultFailure$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", " innerFirstPage onResultFailure  " + error + "  " + message);
                            dataSource2.y(false);
                            dVar2.onResultFailure(error, message);
                            dVar2.y();
                        }
                    });
                }
            };
            y84.d dVar2 = y84.d.f449567a;
            long j3 = this.$friendUin;
            eVar = this.this$0.hostCallBack;
            Intrinsics.checkNotNull(eVar);
            dVar2.f(j3, new b(eVar));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataSource$innerFriendDressUp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

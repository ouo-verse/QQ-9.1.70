package com.tencent.mobileqq.wink.preview.viewmodel;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.preview.WinkSharePreviewException;
import com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1", f = "WinkBasePreviewShareViewModel.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkBasePreviewShareViewModel$requestAndProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $urls;
    int label;
    final /* synthetic */ WinkBasePreviewShareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1$1", f = "WinkBasePreviewShareViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {154, 155, 164}, m = "invokeSuspend", n = {"needDownLoadSo", "needDownLoadTemplate", "mateDeferred", "assertData", "startTime", "needDownLoadSo", "needDownLoadTemplate", "assertData", "startTime", "needDownLoadSo", "needDownLoadTemplate", "assertData", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $urls;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ WinkBasePreviewShareViewModel this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1$1$1", f = "WinkBasePreviewShareViewModel.kt", i = {}, l = {131, 131}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel$requestAndProcessData$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C90771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ Deferred<Pair<MetaMaterial, Long>> $mateDeferred;
            Object L$0;
            int label;
            final /* synthetic */ WinkBasePreviewShareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C90771(WinkBasePreviewShareViewModel winkBasePreviewShareViewModel, Deferred<Pair<MetaMaterial, Long>> deferred, Continuation<? super C90771> continuation) {
                super(2, continuation);
                this.this$0 = winkBasePreviewShareViewModel;
                this.$mateDeferred = deferred;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C90771(this.this$0, this.$mateDeferred, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                WinkBasePreviewShareDataSource S1;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    S1 = (WinkBasePreviewShareDataSource) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    S1 = this.this$0.S1();
                    Deferred<Pair<MetaMaterial, Long>> deferred = this.$mateDeferred;
                    this.L$0 = S1;
                    this.label = 1;
                    obj = deferred.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) ((Pair) obj).getFirst();
                this.L$0 = null;
                this.label = 2;
                obj = S1.b(metaMaterial, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
                return ((C90771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WinkBasePreviewShareViewModel winkBasePreviewShareViewModel, List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = winkBasePreviewShareViewModel;
            this.$urls = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$urls, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0152 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0153  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            Deferred async$default;
            MutableLiveData mutableLiveData2;
            Object await;
            Ref.BooleanRef booleanRef;
            WinkBasePreviewShareViewModel winkBasePreviewShareViewModel;
            Ref.BooleanRef booleanRef2;
            long j3;
            Map<String, String> map;
            MutableLiveData mutableLiveData3;
            Deferred async$default2;
            MutableLiveData mutableLiveData4;
            Object await2;
            Ref.BooleanRef booleanRef3;
            Ref.BooleanRef booleanRef4;
            Map<String, String> map2;
            WinkBasePreviewShareViewModel winkBasePreviewShareViewModel2;
            Deferred deferred;
            MutableLiveData mutableLiveData5;
            Object await3;
            Pair pair;
            Map<String, String> map3;
            Ref.BooleanRef booleanRef5;
            WinkBasePreviewShareViewModel.PreviewData R1;
            WinkBasePreviewShareViewModel.PreviewData R12;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                j3 = this.J$0;
                                winkBasePreviewShareViewModel = (WinkBasePreviewShareViewModel) this.L$4;
                                mutableLiveData3 = (MutableLiveData) this.L$3;
                                Map<String, String> map4 = (Map) this.L$2;
                                Ref.BooleanRef booleanRef6 = (Ref.BooleanRef) this.L$1;
                                Ref.BooleanRef booleanRef7 = (Ref.BooleanRef) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                booleanRef = booleanRef7;
                                booleanRef2 = booleanRef6;
                                map = map4;
                                await = obj;
                                R12 = winkBasePreviewShareViewModel.R1(null, (Pair) await, map, TuplesKt.to(Boxing.boxBoolean(booleanRef.element), Boxing.boxBoolean(booleanRef2.element)));
                                mutableLiveData3.setValue(Result.m475boximpl(Result.m476constructorimpl(R12)));
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j3 = this.J$0;
                            pair = (Pair) this.L$5;
                            winkBasePreviewShareViewModel2 = (WinkBasePreviewShareViewModel) this.L$4;
                            mutableLiveData5 = (MutableLiveData) this.L$3;
                            map3 = (Map) this.L$2;
                            booleanRef5 = (Ref.BooleanRef) this.L$1;
                            Ref.BooleanRef booleanRef8 = (Ref.BooleanRef) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            booleanRef3 = booleanRef8;
                            await3 = obj;
                            R1 = winkBasePreviewShareViewModel2.R1(pair, (Pair) await3, map3, TuplesKt.to(Boxing.boxBoolean(booleanRef3.element), Boxing.boxBoolean(booleanRef5.element)));
                            mutableLiveData5.setValue(Result.m475boximpl(Result.m476constructorimpl(R1)));
                        }
                    } else {
                        long j16 = this.J$0;
                        winkBasePreviewShareViewModel2 = (WinkBasePreviewShareViewModel) this.L$5;
                        MutableLiveData mutableLiveData6 = (MutableLiveData) this.L$4;
                        map2 = (Map) this.L$3;
                        deferred = (Deferred) this.L$2;
                        booleanRef4 = (Ref.BooleanRef) this.L$1;
                        booleanRef3 = (Ref.BooleanRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        await2 = obj;
                        mutableLiveData5 = mutableLiveData6;
                        j3 = j16;
                        Pair pair2 = (Pair) await2;
                        this.L$0 = booleanRef3;
                        this.L$1 = booleanRef4;
                        this.L$2 = map2;
                        this.L$3 = mutableLiveData5;
                        this.L$4 = winkBasePreviewShareViewModel2;
                        this.L$5 = pair2;
                        this.J$0 = j3;
                        this.label = 2;
                        await3 = deferred.await(this);
                        if (await3 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pair = pair2;
                        map3 = map2;
                        booleanRef5 = booleanRef4;
                        R1 = winkBasePreviewShareViewModel2.R1(pair, (Pair) await3, map3, TuplesKt.to(Boxing.boxBoolean(booleanRef3.element), Boxing.boxBoolean(booleanRef5.element)));
                        mutableLiveData5.setValue(Result.m475boximpl(Result.m476constructorimpl(R1)));
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Ref.BooleanRef booleanRef9 = new Ref.BooleanRef();
                    WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
                    BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkBasePreviewShareViewModel$requestAndProcessData$1$1$loadLightDeferred$1(this.this$0, booleanRef9, null), 2, null);
                    Ref.BooleanRef booleanRef10 = new Ref.BooleanRef();
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkBasePreviewShareViewModel$requestAndProcessData$1$1$mateDeferred$1(this.this$0, booleanRef10, null), 3, null);
                    BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C90771(this.this$0, async$default, null), 3, null);
                    try {
                        Map<String, String> o16 = this.this$0.S1().o();
                        if (this.$urls == null || !(!r8.isEmpty())) {
                            mutableLiveData2 = this.this$0._prepared;
                            Result.Companion companion = Result.INSTANCE;
                            WinkBasePreviewShareViewModel winkBasePreviewShareViewModel3 = this.this$0;
                            this.L$0 = booleanRef9;
                            this.L$1 = booleanRef10;
                            this.L$2 = o16;
                            this.L$3 = mutableLiveData2;
                            this.L$4 = winkBasePreviewShareViewModel3;
                            this.J$0 = elapsedRealtime;
                            this.label = 3;
                            await = async$default.await(this);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            booleanRef = booleanRef9;
                            winkBasePreviewShareViewModel = winkBasePreviewShareViewModel3;
                            booleanRef2 = booleanRef10;
                            j3 = elapsedRealtime;
                            map = o16;
                            mutableLiveData3 = mutableLiveData2;
                            R12 = winkBasePreviewShareViewModel.R1(null, (Pair) await, map, TuplesKt.to(Boxing.boxBoolean(booleanRef.element), Boxing.boxBoolean(booleanRef2.element)));
                            mutableLiveData3.setValue(Result.m475boximpl(Result.m476constructorimpl(R12)));
                        } else {
                            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkBasePreviewShareViewModel$requestAndProcessData$1$1$downloadDeferred$1(this.this$0, this.$urls, async$default, null), 2, null);
                            mutableLiveData4 = this.this$0._prepared;
                            Result.Companion companion2 = Result.INSTANCE;
                            WinkBasePreviewShareViewModel winkBasePreviewShareViewModel4 = this.this$0;
                            this.L$0 = booleanRef9;
                            this.L$1 = booleanRef10;
                            this.L$2 = async$default;
                            this.L$3 = o16;
                            this.L$4 = mutableLiveData4;
                            this.L$5 = winkBasePreviewShareViewModel4;
                            this.J$0 = elapsedRealtime;
                            this.label = 1;
                            await2 = async$default2.await(this);
                            if (await2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            booleanRef3 = booleanRef9;
                            booleanRef4 = booleanRef10;
                            j3 = elapsedRealtime;
                            map2 = o16;
                            winkBasePreviewShareViewModel2 = winkBasePreviewShareViewModel4;
                            deferred = async$default;
                            mutableLiveData5 = mutableLiveData4;
                            Pair pair22 = (Pair) await2;
                            this.L$0 = booleanRef3;
                            this.L$1 = booleanRef4;
                            this.L$2 = map2;
                            this.L$3 = mutableLiveData5;
                            this.L$4 = winkBasePreviewShareViewModel2;
                            this.L$5 = pair22;
                            this.J$0 = j3;
                            this.label = 2;
                            await3 = deferred.await(this);
                            if (await3 != coroutine_suspended) {
                            }
                        }
                    } catch (Exception e16) {
                        throw new WinkSharePreviewException(1, e16);
                    }
                }
                w53.b.a("WinkBasePreviewShareViewModel", "on download finish cost = " + (System.currentTimeMillis() - j3));
            } catch (Throwable th5) {
                w53.b.d("WinkBasePreviewShareViewModel", "requestAndProcessData fail", th5);
                mutableLiveData = this.this$0._prepared;
                Result.Companion companion3 = Result.INSTANCE;
                mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(th5))));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewShareViewModel$requestAndProcessData$1(WinkBasePreviewShareViewModel winkBasePreviewShareViewModel, List<String> list, Continuation<? super WinkBasePreviewShareViewModel$requestAndProcessData$1> continuation) {
        super(2, continuation);
        this.this$0 = winkBasePreviewShareViewModel;
        this.$urls = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkBasePreviewShareViewModel$requestAndProcessData$1(this.this$0, this.$urls, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$urls, null);
            this.label = 1;
            if (SupervisorKt.supervisorScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkBasePreviewShareViewModel$requestAndProcessData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

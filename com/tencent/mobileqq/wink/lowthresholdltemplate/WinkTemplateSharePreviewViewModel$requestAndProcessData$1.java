package com.tencent.mobileqq.wink.lowthresholdltemplate;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1", f = "WinkTemplateSharePreviewViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkTemplateSharePreviewViewModel$requestAndProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $publish;
    final /* synthetic */ String $publishContent;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ WinkTemplateSharePreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1", f = "WinkTemplateSharePreviewViewModel.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {151, 153, 157}, m = "invokeSuspend", n = {"needDownLoadSo", "needDownLoadTemplate", "createPreviewDataDeferred", "needDownLoadSo", "needDownLoadTemplate", "needDownLoadSo", "needDownLoadTemplate"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $publish;
        final /* synthetic */ String $publishContent;
        final /* synthetic */ long $startTime;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ WinkTemplateSharePreviewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z16, WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel, String str, long j3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$publish = z16;
            this.this$0 = winkTemplateSharePreviewViewModel;
            this.$publishContent = str;
            this.$startTime = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$publish, this.this$0, this.$publishContent, this.$startTime, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x010c A[RETURN] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Throwable th5;
            Ref.BooleanRef booleanRef;
            Ref.BooleanRef booleanRef2;
            MutableLiveData mutableLiveData;
            Deferred async$default;
            Deferred async$default2;
            Deferred async$default3;
            Deferred async$default4;
            Ref.BooleanRef booleanRef3;
            MutableLiveData mutableLiveData2;
            Object await;
            MutableLiveData mutableLiveData3;
            Object await2;
            Ref.BooleanRef booleanRef4;
            Ref.BooleanRef booleanRef5;
            Object await3;
            Ref.BooleanRef booleanRef6;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r26 = this.label;
            ?? r36 = 3;
            ?? r37 = 3;
            try {
                try {
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th5 = th7;
                booleanRef = r26;
                booleanRef2 = r36;
            }
            if (r26 != 0) {
                if (r26 != 1) {
                    if (r26 != 2) {
                        if (r26 == 3) {
                            mutableLiveData3 = (MutableLiveData) this.L$2;
                            Ref.BooleanRef booleanRef7 = (Ref.BooleanRef) this.L$1;
                            Ref.BooleanRef booleanRef8 = (Ref.BooleanRef) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            booleanRef3 = booleanRef7;
                            await = obj;
                            booleanRef6 = booleanRef8;
                            mutableLiveData3.setValue(Result.m475boximpl(Result.m476constructorimpl(await)));
                            r26 = booleanRef3;
                            r36 = booleanRef6;
                            w53.b.f("WinkTemplateShareDataSource", "requestAndProcessData finish cost = " + (System.currentTimeMillis() - this.$startTime));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.BooleanRef booleanRef9 = (Ref.BooleanRef) this.L$1;
                    Ref.BooleanRef booleanRef10 = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    booleanRef4 = booleanRef10;
                    booleanRef5 = booleanRef9;
                    await3 = obj;
                    this.this$0.g2(this.$publishContent, ((a) await3).getWinkEditDataWrapper());
                    r26 = booleanRef5;
                    r36 = booleanRef4;
                    w53.b.f("WinkTemplateShareDataSource", "requestAndProcessData finish cost = " + (System.currentTimeMillis() - this.$startTime));
                    return Unit.INSTANCE;
                }
                async$default4 = (Deferred) this.L$2;
                booleanRef5 = (Ref.BooleanRef) this.L$1;
                Ref.BooleanRef booleanRef11 = (Ref.BooleanRef) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    booleanRef4 = booleanRef11;
                    await2 = obj;
                    try {
                        WinkEditorResourceManager.a1().i0(((a) await2).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
                        this.L$0 = booleanRef4;
                        this.L$1 = booleanRef5;
                        this.L$2 = null;
                        this.label = 2;
                        await3 = async$default4.await(this);
                        if (await3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.g2(this.$publishContent, ((a) await3).getWinkEditDataWrapper());
                        r26 = booleanRef5;
                        r36 = booleanRef4;
                        w53.b.f("WinkTemplateShareDataSource", "requestAndProcessData finish cost = " + (System.currentTimeMillis() - this.$startTime));
                    } catch (Throwable th8) {
                        th5 = th8;
                        booleanRef = booleanRef5;
                        booleanRef2 = booleanRef4;
                        w53.b.d(this.this$0.getTAG(), "requestAndProcessData fail", th5);
                        mutableLiveData = this.this$0._prepared;
                        Result.Companion companion = Result.INSTANCE;
                        mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(th5))));
                        this.this$0.h2(false, this.$startTime, th5, -1L, -1L, -1L, booleanRef2.element, booleanRef.element);
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th9) {
                    th5 = th9;
                    booleanRef = booleanRef5;
                    booleanRef2 = booleanRef11;
                    w53.b.d(this.this$0.getTAG(), "requestAndProcessData fail", th5);
                    mutableLiveData = this.this$0._prepared;
                    Result.Companion companion2 = Result.INSTANCE;
                    mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(th5))));
                    this.this$0.h2(false, this.$startTime, th5, -1L, -1L, -1L, booleanRef2.element, booleanRef.element);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.BooleanRef booleanRef12 = new Ref.BooleanRef();
            WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$loadLightDeferred$1(this.this$0, booleanRef12, null), 2, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1(this.this$0, null), 2, null);
            Ref.BooleanRef booleanRef13 = new Ref.BooleanRef();
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1(this.this$0, booleanRef13, null), 3, null);
            r37 = booleanRef12;
            async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(this.this$0, this.$startTime, async$default, async$default2, async$default3, booleanRef12, booleanRef13, null), 2, null);
            try {
            } catch (Throwable th10) {
                th = th10;
                th5 = th;
                booleanRef = booleanRef13;
                booleanRef2 = r37;
                w53.b.d(this.this$0.getTAG(), "requestAndProcessData fail", th5);
                mutableLiveData = this.this$0._prepared;
                Result.Companion companion22 = Result.INSTANCE;
                mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(th5))));
                this.this$0.h2(false, this.$startTime, th5, -1L, -1L, -1L, booleanRef2.element, booleanRef.element);
                return Unit.INSTANCE;
            }
            if (this.$publish) {
                this.L$0 = r37;
                this.L$1 = booleanRef13;
                this.L$2 = async$default4;
                this.label = 1;
                await2 = async$default4.await(this);
                if (await2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef4 = r37;
                booleanRef5 = booleanRef13;
                WinkEditorResourceManager.a1().i0(((a) await2).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
                this.L$0 = booleanRef4;
                this.L$1 = booleanRef5;
                this.L$2 = null;
                this.label = 2;
                await3 = async$default4.await(this);
                if (await3 == coroutine_suspended) {
                }
                this.this$0.g2(this.$publishContent, ((a) await3).getWinkEditDataWrapper());
                r26 = booleanRef5;
                r36 = booleanRef4;
                w53.b.f("WinkTemplateShareDataSource", "requestAndProcessData finish cost = " + (System.currentTimeMillis() - this.$startTime));
                return Unit.INSTANCE;
            }
            booleanRef3 = booleanRef13;
            mutableLiveData2 = this.this$0._prepared;
            Result.Companion companion3 = Result.INSTANCE;
            this.L$0 = r37;
            this.L$1 = booleanRef3;
            this.L$2 = mutableLiveData2;
            this.label = 3;
            await = async$default4.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData3 = mutableLiveData2;
            booleanRef6 = r37;
            mutableLiveData3.setValue(Result.m475boximpl(Result.m476constructorimpl(await)));
            r26 = booleanRef3;
            r36 = booleanRef6;
            w53.b.f("WinkTemplateShareDataSource", "requestAndProcessData finish cost = " + (System.currentTimeMillis() - this.$startTime));
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
    public WinkTemplateSharePreviewViewModel$requestAndProcessData$1(boolean z16, WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel, String str, long j3, Continuation<? super WinkTemplateSharePreviewViewModel$requestAndProcessData$1> continuation) {
        super(2, continuation);
        this.$publish = z16;
        this.this$0 = winkTemplateSharePreviewViewModel;
        this.$publishContent = str;
        this.$startTime = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkTemplateSharePreviewViewModel$requestAndProcessData$1(this.$publish, this.this$0, this.$publishContent, this.$startTime, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$publish, this.this$0, this.$publishContent, this.$startTime, null);
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
        return ((WinkTemplateSharePreviewViewModel$requestAndProcessData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

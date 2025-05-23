package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper;
import com.tencent.mobileqq.zplan.servlet.p;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1", f = "ZPlanUGCDyeingPublishHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZPlanUGCDyeingPublishHelper.a $callback;
    final /* synthetic */ String $resourcePath;
    final /* synthetic */ zv4.a $ugcItem;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1(String str, zv4.a aVar, ZPlanUGCDyeingPublishHelper.a aVar2, Continuation<? super ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1> continuation) {
        super(2, continuation);
        this.$resourcePath = str;
        this.$ugcItem = aVar;
        this.$callback = aVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1(this.$resourcePath, this.$ugcItem, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        zv4.b bVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = ZPlanUGCDyeingPublishHelper.cosData;
            bVar.a();
            ZPlanUGCDyeingPublishHelper zPlanUGCDyeingPublishHelper = ZPlanUGCDyeingPublishHelper.f330232a;
            String str = this.$resourcePath;
            String valueOf = String.valueOf(this.$ugcItem.f453555c);
            final ZPlanUGCDyeingPublishHelper.a aVar = this.$callback;
            final zv4.a aVar2 = this.$ugcItem;
            zPlanUGCDyeingPublishHelper.g(str, valueOf, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1.1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1$1$1", f = "ZPlanUGCDyeingPublishHelper.kt", i = {0}, l = {48}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
                /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes35.dex */
                public static final class C91321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ZPlanUGCDyeingPublishHelper.a $callback;
                    final /* synthetic */ zv4.a $ugcItem;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1$1$1$1", f = "ZPlanUGCDyeingPublishHelper.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes35.dex */
                    public static final class C91331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ZPlanUGCDyeingPublishHelper.a $callback;
                        final /* synthetic */ zv4.a $ugcItem;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C91331(zv4.a aVar, ZPlanUGCDyeingPublishHelper.a aVar2, Continuation<? super C91331> continuation) {
                            super(2, continuation);
                            this.$ugcItem = aVar;
                            this.$callback = aVar2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C91331(this.$ugcItem, this.$callback, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended;
                            String str;
                            zv4.b bVar;
                            String str2;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i3 = this.label;
                            if (i3 == 0) {
                                ResultKt.throwOnFailure(obj);
                                str = ZPlanUGCDyeingPublishHelper.TAG;
                                QLog.d(str, 1, "requestCreateUGCItem begin");
                                zv4.a aVar = this.$ugcItem;
                                bVar = ZPlanUGCDyeingPublishHelper.cosData;
                                aVar.f453562j = bVar;
                                p pVar = p.f335428a;
                                zv4.a aVar2 = this.$ugcItem;
                                this.label = 1;
                                if (pVar.d(aVar2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str2 = ZPlanUGCDyeingPublishHelper.TAG;
                            QLog.d(str2, 1, "requestCreateUGCItem success");
                            ZPlanUGCDyeingPublishHelper.a aVar3 = this.$callback;
                            if (aVar3 == null) {
                                return null;
                            }
                            aVar3.onSuccess();
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C91331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C91321(ZPlanUGCDyeingPublishHelper.a aVar, zv4.a aVar2, Continuation<? super C91321> continuation) {
                        super(2, continuation);
                        this.$callback = aVar;
                        this.$ugcItem = aVar2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C91321 c91321 = new C91321(this.$callback, this.$ugcItem, continuation);
                        c91321.L$0 = obj;
                        return c91321;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        String str;
                        String str2;
                        String str3;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        try {
                            if (i3 == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                C91331 c91331 = new C91331(this.$ugcItem, this.$callback, null);
                                this.L$0 = coroutineScope;
                                this.label = 1;
                                obj = TimeoutKt.withTimeoutOrNull(10000L, c91331, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            if (((Unit) obj) == null) {
                                ZPlanUGCDyeingPublishHelper.a aVar = this.$callback;
                                str3 = ZPlanUGCDyeingPublishHelper.TAG;
                                QLog.e(str3, 1, "requestCreateUGCItem timed out.");
                                if (aVar != null) {
                                    aVar.onFailed(WadlProxyConsts.PARAM_TIME_OUT);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        } catch (TimeoutCancellationException unused) {
                            str2 = ZPlanUGCDyeingPublishHelper.TAG;
                            QLog.e(str2, 1, "publishDyeingUGC timed out.");
                            ZPlanUGCDyeingPublishHelper.a aVar2 = this.$callback;
                            if (aVar2 != null) {
                                aVar2.onFailed(WadlProxyConsts.PARAM_TIME_OUT);
                            }
                        } catch (Exception e16) {
                            String obj2 = e16.toString();
                            str = ZPlanUGCDyeingPublishHelper.TAG;
                            QLog.e(str, 1, obj2);
                            ZPlanUGCDyeingPublishHelper.a aVar3 = this.$callback;
                            if (aVar3 != null) {
                                aVar3.onFailed(obj2);
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C91321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    String str2;
                    String str3;
                    if (z16) {
                        str2 = ZPlanUGCDyeingPublishHelper.TAG;
                        QLog.d(str2, 1, "uploadResourceFiles success");
                        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
                        if (f16 != null) {
                            str3 = ZPlanUGCDyeingPublishHelper.TAG;
                            CorountineFunKt.e(f16, str3 + "_requestCreateUGCItem", null, null, null, new C91321(ZPlanUGCDyeingPublishHelper.a.this, aVar2, null), 14, null);
                            return;
                        }
                        return;
                    }
                    ZPlanUGCDyeingPublishHelper.a aVar3 = ZPlanUGCDyeingPublishHelper.a.this;
                    if (aVar3 != null) {
                        aVar3.onFailed("uploadResourceFiles failed!!!");
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

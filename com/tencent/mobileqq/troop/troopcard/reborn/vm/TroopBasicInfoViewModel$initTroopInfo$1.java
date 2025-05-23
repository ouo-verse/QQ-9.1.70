package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.TroopCardRepo;
import com.tencent.mobileqq.troop.troopcard.reborn.repo.a;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.TroopMemberDistributionUIModelKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$RspBody;
import tencent.trpcprotocol.QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1", f = "TroopBasicInfoViewModel.kt", i = {0}, l = {tlv_t183.CMD_183}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes19.dex */
public final class TroopBasicInfoViewModel$initTroopInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $blockedOrDelete;
    final /* synthetic */ com.tencent.mobileqq.troop.data.v $troopInfoWrapper;
    final /* synthetic */ String $troopUin;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TroopBasicInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$1", f = "TroopBasicInfoViewModel.kt", i = {}, l = {MsgConstant.KRMFILETHUMBSIZE384}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String $troopUin;
        Object L$0;
        int label;
        final /* synthetic */ TroopBasicInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TroopBasicInfoViewModel troopBasicInfoViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = troopBasicInfoViewModel;
            this.$troopUin = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopBasicInfoViewModel, str, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$troopUin, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            TroopCardRepo troopCardRepo;
            TroopBasicInfoViewModel troopBasicInfoViewModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        troopBasicInfoViewModel = (TroopBasicInfoViewModel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.this$0;
                    troopCardRepo = troopBasicInfoViewModel2.repo;
                    String str = this.$troopUin;
                    this.L$0 = troopBasicInfoViewModel2;
                    this.label = 1;
                    Object A = troopCardRepo.A(str, this);
                    if (A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    troopBasicInfoViewModel = troopBasicInfoViewModel2;
                    obj = A;
                }
                troopBasicInfoViewModel.N2((a.e) obj, this.$troopUin);
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$2", f = "TroopBasicInfoViewModel.kt", i = {}, l = {QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE, 394}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String $troopUin;
        Object L$0;
        int label;
        final /* synthetic */ TroopBasicInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TroopBasicInfoViewModel troopBasicInfoViewModel, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = troopBasicInfoViewModel;
            this.$troopUin = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopBasicInfoViewModel, str, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.this$0, this.$troopUin, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            TroopCardRepo troopCardRepo;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            mutableLiveData3 = (MutableLiveData) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutableLiveData3.setValue(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableLiveData2 = (MutableLiveData) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    mutableLiveData = this.this$0._troopMemDistributionLiveData;
                    troopCardRepo = this.this$0.repo;
                    String str = this.$troopUin;
                    this.L$0 = mutableLiveData;
                    this.label = 1;
                    Object m3 = troopCardRepo.m(str, this);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData2 = mutableLiveData;
                    obj = m3;
                }
                this.L$0 = mutableLiveData2;
                this.label = 2;
                obj = TroopMemberDistributionUIModelKt.c((troop_member_distribute$RspBody) obj, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData3 = mutableLiveData2;
                mutableLiveData3.setValue(obj);
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$3", f = "TroopBasicInfoViewModel.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$3, reason: invalid class name */
    /* loaded from: classes19.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String $troopUin;
        Object L$0;
        int label;
        final /* synthetic */ TroopBasicInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TroopBasicInfoViewModel troopBasicInfoViewModel, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = troopBasicInfoViewModel;
            this.$troopUin = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopBasicInfoViewModel, str, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass3(this.this$0, this.$troopUin, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            TroopCardRepo troopCardRepo;
            MutableLiveData mutableLiveData2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        mutableLiveData2 = (MutableLiveData) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    mutableLiveData = this.this$0._troopLiveStatus;
                    troopCardRepo = this.this$0.repo;
                    String str = this.$troopUin;
                    this.L$0 = mutableLiveData;
                    this.label = 1;
                    Object l3 = troopCardRepo.l(str, this);
                    if (l3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData2 = mutableLiveData;
                    obj = l3;
                }
                mutableLiveData2.setValue(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.m.a((QunVideohubForwardProxyPB$GetCurrentLiveInfoRsp) obj));
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$4", f = "TroopBasicInfoViewModel.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel$initTroopInfo$1$4, reason: invalid class name */
    /* loaded from: classes19.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String $troopUin;
        int label;
        final /* synthetic */ TroopBasicInfoViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TroopBasicInfoViewModel troopBasicInfoViewModel, String str, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = troopBasicInfoViewModel;
            this.$troopUin = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopBasicInfoViewModel, str, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass4(this.this$0, this.$troopUin, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            TroopCardRepo troopCardRepo;
            TroopInfo troopInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                    troopCardRepo = this.this$0.repo;
                    String str = this.$troopUin;
                    this.label = 1;
                    obj = troopCardRepo.B(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                String str2 = (String) obj;
                com.tencent.mobileqq.troop.data.v vVar = (com.tencent.mobileqq.troop.data.v) this.this$0._troopInfoLiveData.getValue();
                com.tencent.mobileqq.troop.data.v vVar2 = null;
                if (vVar != null) {
                    troopInfo = vVar.i();
                } else {
                    troopInfo = null;
                }
                if (troopInfo != null) {
                    troopInfo.mTags = str2;
                    MutableLiveData mutableLiveData = this.this$0._troopInfoLiveData;
                    com.tencent.mobileqq.troop.data.v vVar3 = (com.tencent.mobileqq.troop.data.v) this.this$0._troopInfoLiveData.getValue();
                    if (vVar3 != null) {
                        vVar2 = com.tencent.mobileqq.troop.data.v.b(vVar3, troopInfo, false, null, 0, 0, null, 0, 0, null, 510, null);
                    }
                    mutableLiveData.setValue(vVar2);
                }
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBasicInfoViewModel$initTroopInfo$1(boolean z16, TroopBasicInfoViewModel troopBasicInfoViewModel, com.tencent.mobileqq.troop.data.v vVar, String str, Continuation<? super TroopBasicInfoViewModel$initTroopInfo$1> continuation) {
        super(2, continuation);
        this.$blockedOrDelete = z16;
        this.this$0 = troopBasicInfoViewModel;
        this.$troopInfoWrapper = vVar;
        this.$troopUin = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), troopBasicInfoViewModel, vVar, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TroopBasicInfoViewModel$initTroopInfo$1 troopBasicInfoViewModel$initTroopInfo$1 = new TroopBasicInfoViewModel$initTroopInfo$1(this.$blockedOrDelete, this.this$0, this.$troopInfoWrapper, this.$troopUin, continuation);
        troopBasicInfoViewModel$initTroopInfo$1.L$0 = obj;
        return troopBasicInfoViewModel$initTroopInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Object p26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                if (!this.$blockedOrDelete) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, this.$troopUin, null), 3, null);
                }
                TroopBasicInfoViewModel troopBasicInfoViewModel = this.this$0;
                com.tencent.mobileqq.troop.data.v vVar = this.$troopInfoWrapper;
                this.L$0 = coroutineScope;
                this.label = 1;
                p26 = troopBasicInfoViewModel.p2(vVar, this);
                if (p26 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!this.$blockedOrDelete) {
                CoroutineScope coroutineScope3 = coroutineScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass2(this.this$0, this.$troopUin, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass3(this.this$0, this.$troopUin, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass4(this.this$0, this.$troopUin, null), 3, null);
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopBasicInfoViewModel$initTroopInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

package com.tencent.mobileqq.troop.homework.clockin.template.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/c;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.template.model.HWClockInTemplateRepo$loadData$1", f = "HWClockInTemplateRepo.kt", i = {}, l = {39, 44, 61}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInTemplateRepo$loadData$1 extends SuspendLambda implements Function2<ProducerScope<? super c>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $isMore;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInTemplateRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInTemplateRepo$loadData$1(HWClockInTemplateRepo hWClockInTemplateRepo, boolean z16, Continuation<? super HWClockInTemplateRepo$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInTemplateRepo;
        this.$isMore = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInTemplateRepo, Boolean.valueOf(z16), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWClockInTemplateRepo hWClockInTemplateRepo, int i3, ProducerScope producerScope, int i16, String errMsg, GroupSchoolTemplateListRsp groupSchoolTemplateListRsp) {
        Integer num;
        Boolean bool;
        List g16;
        ArrayList<GroupSchoolTemplateData> arrayList;
        boolean z16 = false;
        hWClockInTemplateRepo.isLoading = false;
        if (groupSchoolTemplateListRsp != null && (arrayList = groupSchoolTemplateListRsp.datas) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        if (groupSchoolTemplateListRsp != null) {
            bool = Boolean.valueOf(groupSchoolTemplateListRsp.isEnd);
        } else {
            bool = null;
        }
        QLog.i("HW.ClockIn.TEMPLATE.HWClockInTemplateRepo", 1, "loadData, " + i16 + "-" + errMsg + "-" + num + "-" + bool + ", isActive:" + CoroutineScopeKt.isActive(producerScope));
        if (i16 == 0) {
            hWClockInTemplateRepo.curPage = i3;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        g16 = hWClockInTemplateRepo.g(groupSchoolTemplateListRsp);
        if (groupSchoolTemplateListRsp != null) {
            z16 = groupSchoolTemplateListRsp.isEnd;
        }
        producerScope.mo2003trySendJP2dKIU(new c(i16, errMsg, g16, !z16));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInTemplateRepo$loadData$1 hWClockInTemplateRepo$loadData$1 = new HWClockInTemplateRepo$loadData$1(this.this$0, this.$isMore, continuation);
        hWClockInTemplateRepo$loadData$1.L$0 = obj;
        return hWClockInTemplateRepo$loadData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        final int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i18 = this.label;
            if (i18 != 0) {
                if (i18 != 1) {
                    if (i18 != 2) {
                        if (i18 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            z16 = this.this$0.isLoading;
            if (z16) {
                producerScope.mo2003trySendJP2dKIU(c.INSTANCE.b());
                AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (!NetworkUtil.isNetworkAvailable()) {
                producerScope.mo2003trySendJP2dKIU(c.INSTANCE.a());
                AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
                this.label = 2;
                if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (this.$isMore) {
                i17 = this.this$0.curPage;
                i3 = i17 + 1;
            } else {
                i3 = 1;
            }
            i16 = this.this$0.pageSize;
            GroupSchoolTemplateListReq groupSchoolTemplateListReq = new GroupSchoolTemplateListReq(i3, i16, 2);
            QLog.i("HW.ClockIn.TEMPLATE.HWClockInTemplateRepo", 1, "loadData req, isMore:" + this.$isMore + "-reqPage:" + i3);
            r g16 = bg.f302144a.g();
            if (g16 != null) {
                final HWClockInTemplateRepo hWClockInTemplateRepo = this.this$0;
                g16.getGroupSchoolTemplateList(groupSchoolTemplateListReq, new IGetGroupSchoolTemplateListCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.template.model.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback
                    public final void onResult(int i19, String str, GroupSchoolTemplateListRsp groupSchoolTemplateListRsp) {
                        HWClockInTemplateRepo$loadData$1.b(HWClockInTemplateRepo.this, i3, producerScope, i19, str, groupSchoolTemplateListRsp);
                    }
                });
            }
            this.this$0.isLoading = true;
            AnonymousClass5 anonymousClass5 = AnonymousClass5.INSTANCE;
            this.label = 3;
            if (ProduceKt.awaitClose(producerScope, anonymousClass5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super c> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInTemplateRepo$loadData$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}

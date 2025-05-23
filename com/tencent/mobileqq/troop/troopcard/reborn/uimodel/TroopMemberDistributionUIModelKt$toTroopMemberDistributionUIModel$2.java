package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$RspBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/p;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.uimodel.TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2", f = "TroopMemberDistributionUIModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super p>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ troop_member_distribute$RspBody $rspBody;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2(troop_member_distribute$RspBody troop_member_distribute_rspbody, Continuation<? super TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2> continuation) {
        super(2, continuation);
        this.$rspBody = troop_member_distribute_rspbody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troop_member_distribute_rspbody, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2(this.$rspBody, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        int collectionSizeOrDefault;
        List filterNotNull;
        o b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int i3 = this.$rspBody.uint32_result.get();
                if (i3 != 0) {
                    QLog.e("TroopMemberDistributionUIModel", 1, "toTroopMemberDistributionUIModel failed, result = " + i3);
                    return null;
                }
                int i16 = this.$rspBody.uint32_group_member.get();
                if (i16 <= 0) {
                    QLog.e("TroopMemberDistributionUIModel", 1, "toTroopMemberDistributionUIModel failed, member = " + i16);
                    return null;
                }
                List<troop_member_distribute$OStatisticInfo> dataList = this.$rspBody.rpt_msg_statistic.get();
                List<troop_member_distribute$OStatisticInfo> list = dataList;
                int i17 = 0;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && dataList.size() >= 4) {
                    Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                    List<troop_member_distribute$OStatisticInfo> list2 = dataList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Object obj2 : list2) {
                        int i18 = i17 + 1;
                        if (i17 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        troop_member_distribute$OStatisticInfo statisticInfo = (troop_member_distribute$OStatisticInfo) obj2;
                        Intrinsics.checkNotNullExpressionValue(statisticInfo, "statisticInfo");
                        b16 = TroopMemberDistributionUIModelKt.b(statisticInfo, i17);
                        arrayList.add(b16);
                        i17 = i18;
                    }
                    filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
                    if (filterNotNull.size() != 4) {
                        QLog.e("TroopMemberDistributionUIModel", 1, "toTroopMemberDistributionUIModel failed, parsed size not 4");
                        return null;
                    }
                    return new p(i16, filterNotNull);
                }
                QLog.e("TroopMemberDistributionUIModel", 1, "toTroopMemberDistributionUIModel failed, dataSize = " + dataList.size());
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super p> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}

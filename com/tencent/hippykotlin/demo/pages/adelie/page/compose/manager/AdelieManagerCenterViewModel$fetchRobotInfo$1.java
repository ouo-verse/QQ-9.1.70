package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import h25.ab;
import h25.ac;
import h25.ad;
import h25.al;
import h25.am;
import h25.an;
import h25.g;
import h25.t;
import h25.u;
import h25.v;
import h25.w;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchRobotInfo$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$fetchRobotInfo$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $botUid;
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public int label;
    public final /* synthetic */ AdelieManagerCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieManagerCenterViewModel$fetchRobotInfo$1(String str, Function1<? super Boolean, Unit> function1, AdelieManagerCenterViewModel adelieManagerCenterViewModel, Continuation<? super AdelieManagerCenterViewModel$fetchRobotInfo$1> continuation) {
        super(2, continuation);
        this.$botUid = str;
        this.$callback = function1;
        this.this$0 = adelieManagerCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$fetchRobotInfo$1(this.$botUid, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$fetchRobotInfo$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0287, code lost:
    
        if (r3 != null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ac, code lost:
    
        if (r7 != null) goto L178;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        ab abVar;
        u uVar;
        String str2;
        al alVar;
        al alVar2;
        an anVar;
        al alVar3;
        an anVar2;
        String str3;
        al alVar4;
        an anVar3;
        String str4;
        String str5;
        al alVar5;
        List<t> list;
        Object firstOrNull;
        al alVar6;
        List<t> list2;
        Object firstOrNull2;
        List<u> list3;
        Object firstOrNull3;
        al alVar7;
        al alVar8;
        am amVar;
        w wVar;
        al alVar9;
        am amVar2;
        w wVar2;
        al alVar10;
        am amVar3;
        w wVar3;
        al alVar11;
        am amVar4;
        v vVar;
        al alVar12;
        am amVar5;
        v vVar2;
        al alVar13;
        am amVar6;
        v vVar3;
        al alVar14;
        am amVar7;
        v vVar4;
        al alVar15;
        am amVar8;
        v vVar5;
        al alVar16;
        am amVar9;
        v vVar6;
        al alVar17;
        al alVar18;
        al alVar19;
        al alVar20;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final String str6 = this.$botUid;
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37341, new Function0<ac>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$fetchRobotInfo$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ac invoke() {
                    return new ac(str6);
                }
            }, new Function1<byte[], ad>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$fetchRobotInfo$3
                @Override // kotlin.jvm.functions.Function1
                public final ad invoke(byte[] bArr) {
                    return (ad) i.b(new ad(null, null, 3, null), bArr);
                }
            }, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        Function1<Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(Boxing.boxBoolean(oIDBResponse.success));
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchRobotInfo, success: ");
        m3.append(oIDBResponse.success);
        m3.append(", code: ");
        m3.append(oIDBResponse.code);
        m3.append(", msg: ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, oIDBResponse.f114186msg, kLog, "AdelieManagerCenterViewModel");
        if (!oIDBResponse.success) {
            this.this$0.pageState._state.setValue(AdelieManagerCenterViewModel.PageState.ERROR);
            return Unit.INSTANCE;
        }
        this.this$0.pageState._state.setValue(AdelieManagerCenterViewModel.PageState.SUCCESS);
        StateHolder<String> stateHolder = this.this$0.avatarUrl;
        ad adVar = (ad) oIDBResponse.rsp;
        g gVar = null;
        stateHolder._state.setValue((adVar == null || (alVar20 = adVar.f404136d) == null) ? null : alVar20.f404161f);
        StateHolder<String> stateHolder2 = this.this$0.nickName;
        ad adVar2 = (ad) oIDBResponse.rsp;
        stateHolder2._state.setValue((adVar2 == null || (alVar19 = adVar2.f404136d) == null) ? null : alVar19.f404160e);
        AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.this$0;
        ad adVar3 = (ad) oIDBResponse.rsp;
        adelieManagerCenterViewModel.robotUin = (adVar3 == null || (alVar18 = adVar3.f404136d) == null) ? 0L : alVar18.f404159d;
        String str7 = "";
        if (adVar3 == null || (alVar17 = adVar3.f404136d) == null || (str = alVar17.f404163i) == null) {
            str = "";
        }
        adelieManagerCenterViewModel.robotUid = str;
        long j3 = -1;
        adelieManagerCenterViewModel.friendCount._state.setValue(Boxing.boxLong((adVar3 == null || (alVar16 = adVar3.f404136d) == null || (amVar9 = alVar16.f404164m) == null || (vVar6 = amVar9.f404165d) == null) ? -1L : vVar6.f404245d));
        StateHolder<Long> stateHolder3 = this.this$0.msgCount;
        ad adVar4 = (ad) oIDBResponse.rsp;
        stateHolder3._state.setValue(Boxing.boxLong((adVar4 == null || (alVar15 = adVar4.f404136d) == null || (amVar8 = alVar15.f404164m) == null || (vVar5 = amVar8.f404165d) == null) ? -1L : vVar5.f404246e));
        StateHolder<Long> stateHolder4 = this.this$0.visitorCount;
        ad adVar5 = (ad) oIDBResponse.rsp;
        stateHolder4._state.setValue(Boxing.boxLong((adVar5 == null || (alVar14 = adVar5.f404136d) == null || (amVar7 = alVar14.f404164m) == null || (vVar4 = amVar7.f404165d) == null) ? -1L : vVar4.f404247f));
        StateHolder<Long> stateHolder5 = this.this$0.last7DaysFriendCount;
        ad adVar6 = (ad) oIDBResponse.rsp;
        stateHolder5._state.setValue(Boxing.boxLong((adVar6 == null || (alVar13 = adVar6.f404136d) == null || (amVar6 = alVar13.f404164m) == null || (vVar3 = amVar6.f404166e) == null) ? -1L : vVar3.f404245d));
        StateHolder<Long> stateHolder6 = this.this$0.last7DaysMsgCount;
        ad adVar7 = (ad) oIDBResponse.rsp;
        stateHolder6._state.setValue(Boxing.boxLong((adVar7 == null || (alVar12 = adVar7.f404136d) == null || (amVar5 = alVar12.f404164m) == null || (vVar2 = amVar5.f404166e) == null) ? -1L : vVar2.f404246e));
        StateHolder<Long> stateHolder7 = this.this$0.last7DaysVisitorCount;
        ad adVar8 = (ad) oIDBResponse.rsp;
        if (adVar8 != null && (alVar11 = adVar8.f404136d) != null && (amVar4 = alVar11.f404164m) != null && (vVar = amVar4.f404166e) != null) {
            j3 = vVar.f404247f;
        }
        stateHolder7._state.setValue(Boxing.boxLong(j3));
        StateHolder<Float> stateHolder8 = this.this$0.last7DaysFriendGrowthRate;
        ad adVar9 = (ad) oIDBResponse.rsp;
        float f16 = Float.NaN;
        stateHolder8._state.setValue(Boxing.boxFloat((adVar9 == null || (alVar10 = adVar9.f404136d) == null || (amVar3 = alVar10.f404164m) == null || (wVar3 = amVar3.f404167f) == null) ? Float.NaN : wVar3.f404248d));
        StateHolder<Float> stateHolder9 = this.this$0.last7DaysMsgGrowthRate;
        ad adVar10 = (ad) oIDBResponse.rsp;
        stateHolder9._state.setValue(Boxing.boxFloat((adVar10 == null || (alVar9 = adVar10.f404136d) == null || (amVar2 = alVar9.f404164m) == null || (wVar2 = amVar2.f404167f) == null) ? Float.NaN : wVar2.f404249e));
        StateHolder<Float> stateHolder10 = this.this$0.last7DaysVisitorGrowthRate;
        ad adVar11 = (ad) oIDBResponse.rsp;
        if (adVar11 != null && (alVar8 = adVar11.f404136d) != null && (amVar = alVar8.f404164m) != null && (wVar = amVar.f404167f) != null) {
            f16 = wVar.f404250f;
        }
        stateHolder10._state.setValue(Boxing.boxFloat(f16));
        StateHolder<ab> stateHolder11 = this.this$0.qZoneInfo;
        ad adVar12 = (ad) oIDBResponse.rsp;
        if (adVar12 == null || (alVar7 = adVar12.f404136d) == null || (abVar = alVar7.F) == null) {
            abVar = null;
        }
        stateHolder11._state.setValue(abVar);
        AdelieManagerCenterViewModel adelieManagerCenterViewModel2 = this.this$0;
        ad adVar13 = (ad) oIDBResponse.rsp;
        if (adVar13 == null || (list3 = adVar13.f404137e) == null) {
            uVar = null;
        } else {
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
            uVar = (u) firstOrNull3;
        }
        adelieManagerCenterViewModel2.userIdentityInfo = uVar;
        AdelieManagerCenterViewModel adelieManagerCenterViewModel3 = this.this$0;
        StateHolder<Boolean> stateHolder12 = adelieManagerCenterViewModel3.troopSettingEnable;
        u uVar2 = adelieManagerCenterViewModel3.userIdentityInfo;
        stateHolder12._state.setValue(Boxing.boxBoolean(uVar2 != null && uVar2.f404241d == 2));
        if (Intrinsics.areEqual(this.this$0.troopSettingEnable._state.getValue(), Boxing.boxBoolean(true))) {
            AdelieManagerCenterViewModel adelieManagerCenterViewModel4 = this.this$0;
            ad adVar14 = (ad) oIDBResponse.rsp;
            if (adVar14 != null && (alVar6 = adVar14.f404136d) != null && (list2 = alVar6.D) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                t tVar = (t) firstOrNull2;
                if (tVar != null) {
                    str4 = Boxing.boxLong(tVar.f404238d).toString();
                }
            }
            str4 = "";
            ad adVar15 = (ad) oIDBResponse.rsp;
            if (adVar15 != null && (alVar5 = adVar15.f404136d) != null && (list = alVar5.D) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                t tVar2 = (t) firstOrNull;
                if (tVar2 != null) {
                    a aVar = tVar2.f404239e;
                    if (aVar != null) {
                        byte[] bArr = aVar.f30291a;
                        if (bArr != null) {
                            str5 = StringsKt__StringsJVMKt.decodeToString(bArr);
                        }
                    }
                }
            }
            str5 = "";
            adelieManagerCenterViewModel4.updateTroopInfo(str4, str5);
        }
        StateHolder<String> stateHolder13 = this.this$0.recycleTips;
        ad adVar16 = (ad) oIDBResponse.rsp;
        if (adVar16 == null || (alVar4 = adVar16.f404136d) == null || (anVar3 = alVar4.E) == null || (str2 = anVar3.f404171h) == null) {
            str2 = "";
        }
        stateHolder13._state.setValue(str2);
        StateHolder<String> stateHolder14 = this.this$0.recycleTimeMark;
        ad adVar17 = (ad) oIDBResponse.rsp;
        if (adVar17 != null && (alVar3 = adVar17.f404136d) != null && (anVar2 = alVar3.E) != null && (str3 = anVar2.f404170f) != null) {
            str7 = str3;
        }
        stateHolder14._state.setValue(str7);
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchRobotInfo,  recyclemark: ");
        ad adVar18 = (ad) oIDBResponse.rsp;
        m16.append((adVar18 == null || (alVar2 = adVar18.f404136d) == null || (anVar = alVar2.E) == null) ? null : anVar.f404169e);
        m16.append(TokenParser.SP);
        kLog.i("AdelieManagerCenterViewModel", m16.toString());
        ad adVar19 = (ad) oIDBResponse.rsp;
        if (adVar19 != null && (alVar = adVar19.f404136d) != null) {
            gVar = alVar.G;
        }
        if (gVar != null) {
            AdelieManagerCenterViewModel adelieManagerCenterViewModel5 = this.this$0;
            adelieManagerCenterViewModel5.robotControlInfo._state.setValue(gVar);
            if (gVar.f404204e == 7) {
                adelieManagerCenterViewModel5.showRejectDialog._state.setValue(Boxing.boxBoolean(true));
            }
        }
        return Unit.INSTANCE;
    }
}

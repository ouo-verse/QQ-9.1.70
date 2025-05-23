package com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallFlowerViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallFlowerViewModel$fetchFlowerTaskList$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageData;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$Companion$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$QQNetworkEngineOIDBRequest;
import com.tencent.kuikly.core.log.KLog;
import e25.i;
import e25.j;
import e25.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallGrowthManualViewModel {
    public SnapshotStateList<i> flowerTaskList = SnapshotStateKt.mutableStateListOf();
    public final LoveWallFlowerViewModel flowerViewModel;
    public final Function0<Unit> onExit;
    public SnapshotStateList<GrowthRuleInfo> ruleInfos;
    public MutableState<Boolean> showTip;
    public MutableState<String> tip;

    public LoveWallGrowthManualViewModel(LoveWallHomepageData loveWallHomepageData, Function0<Unit> function0) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<String> mutableStateOf$default2;
        this.onExit = function0;
        this.flowerViewModel = new LoveWallFlowerViewModel(Long.parseLong(loveWallHomepageData.getPeerUin()));
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.showTip = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.tip = mutableStateOf$default2;
        this.ruleInfos = SnapshotStateKt.mutableStateListOf();
        fetchFlowerTaskList();
        this.ruleInfos.add(new GrowthRuleInfo());
        this.ruleInfos.add(new GrowthRuleInfo());
        this.ruleInfos.add(new GrowthRuleInfo());
    }

    public final void fetchFlowerTaskList() {
        LoveWallFlowerViewModel loveWallFlowerViewModel = this.flowerViewModel;
        final Function1<List<? extends i>, Unit> function1 = new Function1<List<? extends i>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewModel$fetchFlowerTaskList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends i> list) {
                LoveWallGrowthManualViewModel.this.flowerTaskList.addAll(list);
                return Unit.INSTANCE;
            }
        };
        j jVar = new j(loveWallFlowerViewModel.peerUin);
        LoveWallFlowerViewModel$fetchFlowerTaskList$1 loveWallFlowerViewModel$fetchFlowerTaskList$1 = new Function1<byte[], k>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallFlowerViewModel$fetchFlowerTaskList$1
            @Override // kotlin.jvm.functions.Function1
            public final k invoke(byte[] bArr) {
                return (k) c45.i.b(new k(null, 1, null), bArr);
            }
        };
        Function1<OIDBResponse<k>, Unit> function12 = new Function1<OIDBResponse<k>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallFlowerViewModel$fetchFlowerTaskList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<k> oIDBResponse) {
                OIDBResponse<k> oIDBResponse2 = oIDBResponse;
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch flower list fail. Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallFlowerViewModel", m3.toString());
                    Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                } else {
                    k kVar = oIDBResponse2.rsp;
                    if (kVar == null) {
                        KLog.INSTANCE.e("LoveWallFlowerViewModel", "fetch flower list fail. Error: response is null}");
                        Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                    } else {
                        Function1<List<i>, Unit> function13 = function1;
                        Intrinsics.checkNotNull(kVar);
                        function13.invoke(kVar.f395485d);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37749, jVar, loveWallFlowerViewModel$fetchFlowerTaskList$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function12));
    }
}

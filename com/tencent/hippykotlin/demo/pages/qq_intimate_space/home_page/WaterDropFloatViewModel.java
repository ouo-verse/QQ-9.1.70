package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import c45.i;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$requestCollectWater$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$Companion$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf.QQNetworkEngine$QQNetworkEngineOIDBRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.activity.b;
import e25.aj;
import e25.c;
import e25.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class WaterDropFloatViewModel {
    public MutableState<Integer> collectAnimationCount;
    public final LoveWallHomepageViewModel homepageViewModel;
    public List<Float> waterDropPointYList = new ArrayList();
    public List<Integer> leftPointYIndexList = new ArrayList();
    public List<Integer> rightPointYIndexList = new ArrayList();
    public final SnapshotStateMap<Integer, WaterDropViewModel> waterDropViewModels = SnapshotStateKt.mutableStateMapOf();
    public SnapshotStateList<CollectAnimation> collectAnimations = SnapshotStateKt.mutableStateListOf();

    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    public WaterDropFloatViewModel(LoveWallHomepageViewModel loveWallHomepageViewModel) {
        MutableState<Integer> mutableStateOf$default;
        this.homepageViewModel = loveWallHomepageViewModel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.collectAnimationCount = mutableStateOf$default;
        float statusBarHeight = b.a().getPageData().getStatusBarHeight() + 44.0f + 9.0f + 66.0f + 20.0f;
        statusBarHeight = b.a().getPageData().l() < (246.0f + statusBarHeight) + 187.0f ? statusBarHeight - 20.0f : statusBarHeight;
        int ceil = (int) Math.ceil(((b.a().getPageData().l() - statusBarHeight) - 187.0f) / 123.0f);
        int i3 = 1;
        if (1 > ceil) {
            return;
        }
        while (true) {
            this.waterDropPointYList.add(Float.valueOf(((i3 - 1) * 123.0f) + statusBarHeight));
            if (i3 == ceil) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void collectWater(final aj ajVar) {
        final List listOf;
        List mutableList;
        final long j3 = ajVar.f395463i;
        if (j3 <= 0) {
            j3 = ajVar.f395462h;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<aj> it = this.homepageViewModel.waterTaskList.iterator();
        while (it.hasNext()) {
            aj next = it.next();
            if (ajVar.f395459d == next.f395459d) {
                next.C = true;
                next.f395463i = 0L;
            }
            arrayList.add(next);
        }
        this.homepageViewModel.waterTaskList.clear();
        this.homepageViewModel.waterTaskList.addAll(arrayList);
        LoveWallHomepageViewModel loveWallHomepageViewModel = this.homepageViewModel;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(ajVar.f395459d));
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropFloatViewModel$collectWater$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("collect water success: "), aj.this.f395459d, KLog.INSTANCE, "LoveWallHomepage");
                WaterDropViewModel waterDropViewModel = this.waterDropViewModels.get(Integer.valueOf(aj.this.f395459d));
                boolean z16 = false;
                if (waterDropViewModel != null && waterDropViewModel.triangleDirection.getValue().ordinal() == 0) {
                    z16 = true;
                }
                SnapshotStateList<CollectAnimation> snapshotStateList = this.collectAnimations;
                String valueOf = String.valueOf(Mqq.INSTANCE.getUtil().currentTime());
                final WaterDropFloatViewModel waterDropFloatViewModel = this;
                final aj ajVar2 = aj.this;
                final long j16 = j3;
                snapshotStateList.add(new CollectAnimation(valueOf, z16, false, false, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropFloatViewModel$collectWater$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        WaterDropFloatViewModel.this.homepageViewModel.showToast(ajVar2.f395461f + "\u83b7\u5f97" + j16 + "g\u6c34\u6ef4");
                        WaterDropFloatViewModel.this.homepageViewModel.fetchWaterInfo(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.WaterDropFloatViewModel.collectWater.2.2.1
                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }));
                return Unit.INSTANCE;
            }
        };
        LoveWallWaterViewModel loveWallWaterViewModel = loveWallHomepageViewModel.waterViewModel;
        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$requestCollectWater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                function0.invoke();
                return Unit.INSTANCE;
            }
        };
        long j16 = loveWallWaterViewModel.uin;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
        c cVar = new c(j16, mutableList);
        LoveWallWaterViewModel$requestCollectWater$1 loveWallWaterViewModel$requestCollectWater$1 = new Function1<byte[], d>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$requestCollectWater$1
            @Override // kotlin.jvm.functions.Function1
            public final d invoke(byte[] bArr) {
                return (d) i.b(new d(), bArr);
            }
        };
        Function1<OIDBResponse<d>, Unit> function1 = new Function1<OIDBResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallWaterViewModel$requestCollectWater$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<d> oIDBResponse) {
                OIDBResponse<d> oIDBResponse2 = oIDBResponse;
                if (!oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("collect fail, waterIdList: ");
                    m3.append(listOf);
                    m3.append(". Error: ");
                    m3.append(oIDBResponse2.f114186msg);
                    m3.append(", errorCode: ");
                    m3.append(oIDBResponse2.code);
                    kLog.e("LoveWallWaterViewModel", m3.toString());
                    Mqq.INSTANCE.getUi().showErrorTips(ImageTaskConst.ErrorDesciption.IMAGE_TASK_LOCAL_RET_CODE_NETWORK_FAIL_DESC);
                } else {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new QQNetworkEngine$QQNetworkEngineOIDBRequest(37748, cVar, loveWallWaterViewModel$requestCollectWater$1), false, new QQNetworkEngine$Companion$sendOIDBRequest$1(function1));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    public final Float getLeftWaterDropPointY(int i3) {
        if (this.waterDropPointYList.size() <= i3) {
            return null;
        }
        if (!this.leftPointYIndexList.contains(Integer.valueOf(i3))) {
            this.leftPointYIndexList.add(Integer.valueOf(i3));
        }
        return (Float) this.waterDropPointYList.get(i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    public final Float getRightWaterDropPointY(int i3) {
        if (this.waterDropPointYList.size() <= i3) {
            return null;
        }
        if (!this.rightPointYIndexList.contains(Integer.valueOf(i3))) {
            this.rightPointYIndexList.add(Integer.valueOf(i3));
        }
        return (Float) this.waterDropPointYList.get(i3);
    }
}

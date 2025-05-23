package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c45.a;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.t;
import h25.af;
import h25.al;
import h25.at;
import h25.d;
import h25.u;
import h25.y;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterViewModel {
    public volatile boolean hasFetchServerData;
    public boolean hasLocalCache;
    public MutableState<Boolean> isRequesting;
    public a rspCookie;
    public String rspDataVersion;
    public MutableState<Boolean> rspHasMore;
    public final e requestScope = e.f117232d;
    public final StateHolder<PageState> pageState = new StateHolder<>(PageState.INIT);
    public final StateHolder<CreateCenterBanner> bannerInfo = new StateHolder<>(null, 1, null);
    public final StateHolder<y> dataInfo = new StateHolder<>(null, 1, null);
    public final StateHolder<d> activityInfo = new StateHolder<>(null, 1, null);
    public StateHolder<u> identityInfo = new StateHolder<>(null, 1, null);
    public final ListStateHolder<al> robotInfoList = new ListStateHolder<>();
    public final ListStateHolder<AdelieRedDotModule$Companion$RedDotInfo> redDotList = new ListStateHolder<>();
    public String recycleTips = "";
    public final AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");

    public AdelieCreativeCenterViewModel() {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isRequesting = mutableStateOf$default;
        this.rspCookie = a.f30290b;
        this.rspDataVersion = "";
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.rspHasMore = mutableStateOf$default2;
    }

    public final void fetchRedDotData() {
        AdelieRedDotModule adelieRedDotModule = (AdelieRedDotModule) c.f117352a.g().acquireModule("AdelieRedDotModule");
        this.redDotList.updateValueList(AdelieRedDotModule.getRedDotInfoListFromCache$default(adelieRedDotModule));
        BuildersKt.e(this.requestScope, null, null, new AdelieCreativeCenterViewModel$fetchRedDotData$1(adelieRedDotModule, this, null), 3, null);
        updateTurboDisplayIfNeeded();
    }

    public final void fetchServerData(boolean z16, Function1<? super Boolean, Unit> function1) {
        if (this.isRequesting.getValue().booleanValue()) {
            KLog.INSTANCE.i("AdelieCreativeCenterViewModel", "fetchServerData isRequesting, return");
            return;
        }
        if (!z16) {
            this.rspCookie = a.f30290b;
            this.rspDataVersion = "";
            this.rspHasMore.setValue(Boolean.TRUE);
        } else if (!this.rspHasMore.getValue().booleanValue()) {
            KLog.INSTANCE.i("AdelieCreativeCenterViewModel", "fetchServerData no more data, return");
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        BuildersKt.e(this.requestScope, null, null, new AdelieCreativeCenterViewModel$fetchServerData$1(this, z16, function1, null), 3, null);
    }

    public final void parsePspData(af afVar, boolean z16) {
        Object firstOrNull;
        Unit unit;
        List<al> list;
        String str;
        this.dataInfo._state.setValue(afVar.f404142e);
        this.activityInfo._state.setValue(afVar.D);
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) afVar.f404143f);
        u uVar = (u) firstOrNull;
        if (uVar != null) {
            this.identityInfo._state.setValue(uVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.identityInfo._state.setValue(null);
        }
        if (z16) {
            list = CollectionsKt___CollectionsKt.plus((Collection) this.robotInfoList._stateList, (Iterable) afVar.f404141d);
        } else {
            list = afVar.f404141d;
        }
        this.robotInfoList.updateValueList(list);
        at atVar = afVar.E;
        if (atVar == null || (str = atVar.f404182d) == null) {
            str = "\u521b\u5efa\u540e\u957f\u65f6\u95f4\u65e0\u4e92\u52a8\u6d88\n\u606f\uff0c\u5e73\u53f0\u4f1a\u8fdb\u884c\u6536\u56de";
        }
        this.recycleTips = str;
        this.rspCookie = afVar.f404144h;
        this.rspDataVersion = afVar.f404146m;
        this.rspHasMore.setValue(Boolean.valueOf(afVar.f404145i));
    }

    public final void updateTurboDisplayIfNeeded() {
        t tVar = (t) c.f117352a.g().acquireModule("KRTurboDisplayModule");
        KLog.INSTANCE.i("AdelieCreativeCenterViewModel", "update turbo display");
        tVar.b();
    }
}

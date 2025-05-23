package com.tencent.hippykotlin.demo.pages.nearby.main.control.title;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPMainTitleViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainTitleViewModel.class, "aioMsgUnreadCount", "getAioMsgUnreadCount()I", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPMainTitleViewModel.class, "scoreInfoList", "getScoreInfoList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainTitleViewModel.class, "curMapTheme", "getCurMapTheme()Lkuikly/com/tencent/trpcprotocol/lplan/common/map/MapTheme;", 0)};
    public final ReadWriteProperty aioMsgUnreadCount$delegate = c.a(-1);
    public final ReadWriteProperty scoreInfoList$delegate = c.b();
    public final ReadWriteProperty curMapTheme$delegate = c.a(new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null));

    public final int getAioMsgUnreadCount() {
        return ((Number) this.aioMsgUnreadCount$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final f getCurMapTheme() {
        return (f) this.curMapTheme$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void onBackIconClick() {
        if (NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getVmStore()).onBackPress()) {
            return;
        }
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        b g16 = cVar.g();
        NBPMainPager nBPMainPager = g16 instanceof NBPMainPager ? (NBPMainPager) g16 : null;
        if (nBPMainPager != null) {
            nBPMainPager.pgStayTime = (Utils.INSTANCE.currentBridgeModule().currentTimeStamp() - nBPMainPager.pgInStart) + nBPMainPager.pgStayTime;
        }
        if (nBPMainPager != null) {
            nBPMainPager.updatePageAutoReportParams();
        }
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        ((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).closePage(true);
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_return");
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapThemeChanged(f fVar) {
        String sb5;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("changed map theme: name:");
        m3.append(fVar.f421850e);
        m3.append(", ");
        if (fVar.H) {
            sb5 = "is city theme, hide id info";
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("id=");
            m16.append(fVar.f421849d);
            sb5 = m16.toString();
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, sb5, kLog, "NBPMainTitleViewModel");
        this.curMapTheme$delegate.setValue(this, $$delegatedProperties[2], fVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel$observeMsgUnreadChange$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                NBPMainTitleViewModel nBPMainTitleViewModel = NBPMainTitleViewModel.this;
                nBPMainTitleViewModel.aioMsgUnreadCount$delegate.setValue(nBPMainTitleViewModel, NBPMainTitleViewModel.$$delegatedProperties[0], Integer.valueOf(intValue));
                return Unit.INSTANCE;
            }
        };
        companion.getClass();
        companion.toNative(true, "observeMsgUnreadChange", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$observeMsgUnreadChange$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                function1.invoke(Integer.valueOf(eVar2 != null ? eVar2.j("count") : 0));
                return Unit.INSTANCE;
            }
        }, false);
    }

    public final String unreadMsgCount() {
        if (getAioMsgUnreadCount() == -1) {
            return "";
        }
        int unreadInteractiveMsgCount = NBPViewModelStoreKt.getMsgNotifyViewModel(NBPMainKtxKt.getVmStore()).getUnreadInteractiveMsgCount() + getAioMsgUnreadCount();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("unreadMsgCount: aioMsgUnreadCount:");
        m3.append(getAioMsgUnreadCount());
        m3.append(", unreadInteractiveMsgCount = ");
        m3.append(NBPViewModelStoreKt.getMsgNotifyViewModel(NBPMainKtxKt.getVmStore()).getUnreadInteractiveMsgCount());
        kLog.d("NBPMainTitleViewModel", m3.toString());
        if (unreadInteractiveMsgCount > 99) {
            return "99+";
        }
        if (unreadInteractiveMsgCount <= 0) {
            return "";
        }
        return String.valueOf(unreadInteractiveMsgCount);
    }
}

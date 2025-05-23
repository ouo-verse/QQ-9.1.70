package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify;

import c01.c;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import u25.d;

/* loaded from: classes31.dex */
public final class NBPNotifyViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPNotifyViewModel.class, "unreadInteractiveMsgCount", "getUnreadInteractiveMsgCount()I", 0)};
    public boolean hadEntryMap;
    public final ReadWriteProperty unreadInteractiveMsgCount$delegate = c.a(0);

    public final void fetchUnreadMsg() {
        KLog.INSTANCE.i("NBPNotifyViewModel", "start fetch unread msg");
        NBPInteractiveGetUnreadMsgRequest nBPInteractiveGetUnreadMsgRequest = new NBPInteractiveGetUnreadMsgRequest();
        Function1<PbResponse<d>, Unit> function1 = new Function1<PbResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify.NBPNotifyViewModel$fetchUnreadMsg$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<d> pbResponse) {
                PbResponse<d> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getUnreadMsg from api: ");
                m3.append(pbResponse2.f114187msg);
                m3.append(", code: ");
                m3.append(pbResponse2.code);
                m3.append(", unreadCount: ");
                d dVar = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, dVar != null ? Integer.valueOf(dVar.f438165e) : null, kLog, "NBPNotifyViewModel");
                d dVar2 = pbResponse2.rsp;
                int i3 = dVar2 != null ? dVar2.f438165e : 0;
                NBPNotifyViewModel.this.updateInteractiveMsgCount(i3);
                Utils.INSTANCE.cacheModule("").setInt(NearbyProUtilsKt.getInteractiveNumCacheKey(), Integer.valueOf(i3));
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.like_svr.Like.SsoGetUnreadMsg");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPInteractiveGetUnreadMsgRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }

    public final int getUnreadInteractiveMsgCount() {
        return ((Number) this.unreadInteractiveMsgCount$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onEnterMap() {
        KLog.INSTANCE.i("NBPNotifyViewModel", "on enter map");
        this.hadEntryMap = true;
        fetchUnreadMsg();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        KLog.INSTANCE.i("NBPNotifyViewModel", "on page did appear");
        if (this.hadEntryMap) {
            fetchUnreadMsg();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        setInteractiveCacheNum("pageCreate");
    }

    public final void setInteractiveCacheNum(String str) {
        Unit unit;
        Integer num = Utils.INSTANCE.cacheModule("").getInt(NearbyProUtilsKt.getInteractiveNumCacheKey());
        if (num != null) {
            int intValue = num.intValue();
            KLog.INSTANCE.i("NBPNotifyViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("getUnreadMsg form cache: ", intValue, "\uff0c from=", str));
            updateInteractiveMsgCount(intValue);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("getUnreadMsg form cache: isNUll=0\uff0c from=", str, KLog.INSTANCE, "NBPNotifyViewModel");
            updateInteractiveMsgCount(0);
        }
    }

    public final void updateInteractiveMsgCount(int i3) {
        if (getUnreadInteractiveMsgCount() != i3) {
            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m(WidgetCacheConstellationData.NUM, i3);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "NEARBY_INTERACTIVE_MSG_COUNT_CHANGED_EVENT_FROM_KOTLIN", m3, false, 4, null);
        }
        this.unreadInteractiveMsgCount$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterVM;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.MiddlePageShareConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.PosterDataHolder;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.moodPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPBasePosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NBPPoiPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public class NBPBaseShareVM<T> implements PosterDataHolder<T> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "currentPoster", "getCurrentPoster()Lcom/tencent/hippykotlin/demo/pages/nearby/common_share/posterView/NBPBasePosterView;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "posterConfig", "getPosterConfig()Lcom/tencent/hippykotlin/demo/pages/nearby/main/theme/NBPThemePosterConfig;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "middlePosterConfig", "getMiddlePosterConfig()Lcom/tencent/hippykotlin/demo/pages/nearby/base/data/MiddlePageShareConfig;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "moodPosterConfig", "getMoodPosterConfig()Lcom/tencent/hippykotlin/demo/pages/nearby/base/data/moodPosterData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isPreparing", "isPreparing()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isDataReady", "isDataReady()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isQRCodeRendering", "isQRCodeRendering()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isMainViewRendered", "isMainViewRendered()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isQQArkViewRendered", "isQQArkViewRendered()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isWXArkViewRendered", "isWXArkViewRendered()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isPageClosed", "isPageClosed()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "posterContainerHeight", "getPosterContainerHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "posterContainerWidth", "getPosterContainerWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPBaseShareVM.class, "isLoadingIndicatorEnabled", "isLoadingIndicatorEnabled()Z", 0)};
    public int appId;
    public String feedId;
    public final ReadWriteProperty isDataReady$delegate;
    public final ReadWriteProperty isMainViewRendered$delegate;
    public final ReadWriteProperty isPageClosed$delegate;
    public final ReadWriteProperty isPreparing$delegate;
    public final ReadWriteProperty isQQArkViewRendered$delegate;
    public final ReadWriteProperty isQRCodeRendering$delegate;
    public final ReadWriteProperty isWXArkViewRendered$delegate;
    public String mapThemeId;
    public boolean poiCanceled;
    public final ReadWriteProperty posterContainerHeight$delegate;
    public final ReadWriteProperty posterContainerWidth$delegate;
    public T posterData;
    public aa<NearbyFeedPosterView> shareFeedMainViewRef;
    public AsyncTaskTracker<Unit> shareMainViewReadyToCapture;
    public Integer shareMainViewTag;
    public aa<NBPPoiPosterView> shareMiddleMainViewRef;
    public Integer shareQQArkViewTag;
    public Integer shareWXArkViewTag;
    public int shareType = 4;
    public final ReadWriteProperty currentPoster$delegate = c.a(new NBPBasePosterView());
    public final ReadWriteProperty posterConfig$delegate = c.a(new NBPThemePosterConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null));
    public final ReadWriteProperty middlePosterConfig$delegate = c.a(new MiddlePageShareConfig((String) null, (String) null, (String) null, (String) null, 31));
    public final ReadWriteProperty moodPosterConfig$delegate = c.a(new moodPosterData(0, null, null, null, null, null, 511));

    public final int getAppId() {
        return this.appId;
    }

    public final e getDTElementParams(e eVar) {
        e dTPageParam = getDTPageParam();
        e eVar2 = new e();
        eVar2.t("nearby_kl_appid", this.appId);
        eVar2.t("come_from", this.shareType);
        eVar2.v("feed_id", this.feedId);
        Unit unit = Unit.INSTANCE;
        dTPageParam.v("cur_pg", eVar2);
        dTPageParam.v("dt_eid", "em_nearby_kl_share_way");
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            dTPageParam.v(next, eVar.e(next));
        }
        return dTPageParam;
    }

    public final e getDTPageParam() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_kl_share_float");
        nearbyDTBaseParams.t("nearby_kl_appid", this.appId);
        nearbyDTBaseParams.t("come_from", this.shareType);
        nearbyDTBaseParams.v("feed_id", this.feedId);
        return nearbyDTBaseParams;
    }

    public final NBPThemePosterConfig getPosterConfig() {
        return (NBPThemePosterConfig) this.posterConfig$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final float getPosterContainerHeight() {
        return ((Number) this.posterContainerHeight$delegate.getValue(this, $$delegatedProperties[11])).floatValue();
    }

    public T getPosterData() {
        T t16 = this.posterData;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("posterData");
        return (T) Unit.INSTANCE;
    }

    public final boolean isDataReady() {
        return ((Boolean) this.isDataReady$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
    }

    public final boolean isMainViewRendered() {
        return ((Boolean) this.isMainViewRendered$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
    }

    public final boolean isPageClosed() {
        return ((Boolean) this.isPageClosed$delegate.getValue(this, $$delegatedProperties[10])).booleanValue();
    }

    public final boolean isQQArkViewRendered() {
        return ((Boolean) this.isQQArkViewRendered$delegate.getValue(this, $$delegatedProperties[8])).booleanValue();
    }

    public final boolean isQRCodeRendering() {
        return ((Boolean) this.isQRCodeRendering$delegate.getValue(this, $$delegatedProperties[6])).booleanValue();
    }

    public final boolean isWXArkViewRendered() {
        return ((Boolean) this.isWXArkViewRendered$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public final void reportElementClick(int i3) {
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("share_source", i3);
        Unit unit = Unit.INSTANCE;
        e dTElementParams = getDTElementParams(m3);
        dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTElementParams);
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("reportPageExposure: ", z16, KLog.INSTANCE, "NearbyFeedShareViewModel");
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTPageParam = getDTPageParam();
        dTPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTPageParam);
    }

    public final void setCurrentPoster(NBPBasePosterView nBPBasePosterView) {
        this.currentPoster$delegate.setValue(this, $$delegatedProperties[0], nBPBasePosterView);
    }

    public final void setDataReady() {
        this.isDataReady$delegate.setValue(this, $$delegatedProperties[5], Boolean.TRUE);
    }

    public final void setMainViewRendered() {
        this.isMainViewRendered$delegate.setValue(this, $$delegatedProperties[7], Boolean.TRUE);
    }

    public void setPosterData(T t16) {
        this.posterData = t16;
    }

    public final void setPreparing(boolean z16) {
        this.isPreparing$delegate.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z16));
    }

    public final void setQQArkViewRendered() {
        this.isQQArkViewRendered$delegate.setValue(this, $$delegatedProperties[8], Boolean.TRUE);
    }

    public final void setWXArkViewRendered() {
        this.isWXArkViewRendered$delegate.setValue(this, $$delegatedProperties[9], Boolean.TRUE);
    }

    public NBPBaseShareVM(int i3) {
        this.appId = i3;
        Boolean bool = Boolean.FALSE;
        this.isPreparing$delegate = c.a(bool);
        this.isDataReady$delegate = c.a(bool);
        this.isQRCodeRendering$delegate = c.a(bool);
        this.isMainViewRendered$delegate = c.a(bool);
        this.isQQArkViewRendered$delegate = c.a(bool);
        this.isWXArkViewRendered$delegate = c.a(bool);
        this.isPageClosed$delegate = c.a(bool);
        Float valueOf = Float.valueOf(0.0f);
        this.posterContainerHeight$delegate = c.a(valueOf);
        this.posterContainerWidth$delegate = c.a(valueOf);
        c.a(bool);
        this.shareMainViewReadyToCapture = new AsyncTaskTracker<>();
        this.mapThemeId = "";
        this.feedId = "";
    }
}

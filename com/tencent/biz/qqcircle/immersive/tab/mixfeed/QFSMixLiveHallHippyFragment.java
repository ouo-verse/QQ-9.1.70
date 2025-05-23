package com.tencent.biz.qqcircle.immersive.tab.mixfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixLiveHallHippyFragment;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveHEVCAbility;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.timi.game.api.strategy.IPlayerStrategy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\u0017\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/tab/mixfeed/QFSMixLiveHallHippyFragment;", "Lcom/tencent/hippy/qq/fragment/QCircleCommonHippyFragment;", "", "isPreload", "isPredraw", "", "registerDaTongReportPageId", "Fh", "", "getDaTongPageId", "Hh", "Lorg/json/JSONObject;", "jsInitData", "doBussinessInitData", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "msg", "onLoadHippyError", "onLoadHippySuccess", "onLowMemory", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", "tabInfo", "D", "I", "subTabIndex", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "E", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/timi/game/api/strategy/IPlayerStrategy$NetworkListener;", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/api/strategy/IPlayerStrategy$NetworkListener;", "networkListener", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;I)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMixLiveHallHippyFragment extends QCircleCommonHippyFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QCircleTabInfo tabInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private final int subTabIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final IPlayerStrategy.NetworkListener networkListener;

    public QFSMixLiveHallHippyFragment(@NotNull QCircleTabInfo tabInfo, int i3) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        this.tabInfo = tabInfo;
        this.subTabIndex = i3;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        this.networkListener = new IPlayerStrategy.NetworkListener() { // from class: v60.b
            @Override // com.tencent.timi.game.api.strategy.IPlayerStrategy.NetworkListener
            public final void onNetworkChange(boolean z16, boolean z17) {
                QFSMixLiveHallHippyFragment.Gh(QFSMixLiveHallHippyFragment.this, z16, z17);
            }
        };
    }

    private final boolean Fh() {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = this.tabInfo.mTab;
        if (qQCircleFeedBase$StTabInfo == null || qQCircleFeedBase$StTabInfo.defaultSubTabindex.get() != this.subTabIndex) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(QFSMixLiveHallHippyFragment this$0, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hh();
    }

    private final void Hh() {
        if (this.mHippyQQEngine == null) {
            return;
        }
        boolean isWeakNetwork = ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).isWeakNetwork();
        boolean isPreloadEnable = ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).isPreloadEnable();
        this.aegisLogger.i("unknown|QFSMixLiveHallHippyFragment", 1, "\u901a\u77e5Hippy\u7f51\u7edc\u53d8\u5316 NETWORK_STATE_CHANGE isWeakNet:" + isWeakNetwork + " isPreload:" + isPreloadEnable);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean("weak_network", isWeakNetwork);
        hippyMap.pushBoolean("preload_enable", isPreloadEnable);
        this.mHippyQQEngine.sendEvent("NetworkStateChange", hippyMap);
    }

    private final String getDaTongPageId() {
        boolean z16;
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = this.tabInfo.mTab;
        if (qQCircleFeedBase$StTabInfo != null) {
            int size = qQCircleFeedBase$StTabInfo.subTabInfo.size();
            int i3 = this.subTabIndex;
            if (size > i3) {
                String dtPgId = this.tabInfo.mTab.subTabInfo.get(i3).dtPgID.get();
                if (dtPgId != null && dtPgId.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Intrinsics.checkNotNullExpressionValue(dtPgId, "dtPgId");
                    return dtPgId;
                }
                return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_LIVE_PAGE;
            }
            return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_LIVE_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_LIVE_PAGE;
    }

    private final boolean isPredraw() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            return hippyQQPreloadEngine.isPredraw();
        }
        return false;
    }

    private final boolean isPreload() {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyQQEngine;
        if (hippyQQPreloadEngine != null) {
            return hippyQQPreloadEngine.isPreloaded();
        }
        return false;
    }

    private final void registerDaTongReportPageId() {
        String str;
        if (getFragmentContentView() == null) {
            QLog.d("unknown|QFSMixLiveHallHippyFragment", 1, "registerDaTongReportPageId, fragmentContentView is null ");
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getFragmentContentView(), getDaTongPageId());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Fh()) {
            str = "1";
        } else {
            str = "2";
        }
        linkedHashMap.put("ext15_string", str);
        VideoReport.setPageParams(getFragmentContentView(), new QCircleDTParamBuilder().buildPageParams("unknown|QFSMixLiveHallHippyFragment", linkedHashMap));
        VideoReport.setElementDynamicParams(getFragmentContentView(), new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(getFragmentContentView(), new QCircleDTParamBuilder().buildDynamicParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
    @NotNull
    public JSONObject doBussinessInitData(@Nullable JSONObject jsInitData) {
        int i3;
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        try {
            QRouteApi api = QRoute.api(IQQLiveCookieStrategyApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQLiveCookieStrategyApi::class.java)");
            for (Map.Entry<String, String> entry : IQQLiveCookieStrategyApi.DefaultImpls.getCookieStrategy$default((IQQLiveCookieStrategyApi) api, null, 1, null).buildSync().entrySet()) {
                doBussinessInitData.put(entry.getKey(), entry.getValue());
            }
            if (((IQQIvLiveHallApi) QRoute.api(IQQIvLiveHallApi.class)).isTestEnv(getContext())) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            doBussinessInitData.put(MosaicConstants$JsProperty.PROP_ENV, i3);
            doBussinessInitData.put("deviceinfo", ((IQQLiveHEVCAbility) QRoute.api(IQQLiveHEVCAbility.class)).getDeviceInfo());
        } catch (Throwable th5) {
            QLog.e("unknown|QFSMixLiveHallHippyFragment", 1, th5, new Object[0]);
        }
        return doBussinessInitData;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies();
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup.LayoutParams layoutParams = this.mHippyContainer.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = cx.a(50.0f);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
    public void onLoadHippyError(int statusCode, @Nullable String msg2) {
        super.onLoadHippyError(statusCode, msg2);
        this.aegisLogger.e("unknown|QFSMixLiveHallHippyFragment", 1, "onLoadHippyError:statusCode=" + statusCode + ",msg=" + msg2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment
    public void onLoadHippySuccess() {
        super.onLoadHippySuccess();
        this.aegisLogger.i("unknown|QFSMixLiveHallHippyFragment", 1, "onLoadHippySuccess:isPreload=" + isPreload() + ",isPredraw=" + isPredraw());
        Hh();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.aegisLogger.i("unknown|QFSMixLiveHallHippyFragment", 1, "onLowMemory");
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.aegisLogger.i("unknown|QFSMixLiveHallHippyFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).removeNetworkListener(this.networkListener);
        ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).onLiveHallHippyPause();
        super.onPause();
    }

    @Override // com.tencent.hippy.qq.fragment.QCircleCommonHippyFragment, com.tencent.hippy.qq.fragment.QCircleBaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.aegisLogger.i("unknown|QFSMixLiveHallHippyFragment", 1, "onResume");
        super.onResume();
        ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).onLiveHallHippyResume();
        ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).addNetworkListener(this.networkListener);
        registerDaTongReportPageId();
    }
}

package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupGame;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$GetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$SetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$ShowQuickAuthorizeRsp;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ElegantProfileGameCardComponent extends BaseProfileTroopMemGameInfoComponent implements View.OnClickListener, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {
    private static final String BUNDLE_NAME = "gamecenter_game_card";
    private static final String EVENT_PROFILE_FRAME_CHANGE = "ProfileCardGameKuilkyFrameChangeNotify";
    private static final String EVENT_PROFILE_SET_TAB_URL = "ProfileCardGameKuilkyCardInfoUpdateNotify";
    private static final String KEY_IS_SHOW_GAMECARD_QUICK_AUTH = "key_is_show_gamecard_quic_auth";
    private static final String KUIKLY_PAGE_NAME = "ProfileCardGameInfoPage";
    private static final String TAG = "ElegantProfileGameCardComponent";
    private TextView authTipsView;
    private boolean bShowQuickAuth;
    private int cardInfoState;
    private boolean hasReportExposure;
    private boolean isKuiklyError;
    private boolean isRefreshTroopMemberCardInfo;
    private volatile boolean isTroopMemberGameCardOpened;
    BroadcastReceiver kuiklyBroadcastReceiver;
    private String kuiklyGameAppId;
    private LinearLayout kuiklyRootLayout;
    private boolean lastShowFlag;
    private boolean lastShowQuickAuth;
    public com.tencent.mobileqq.troop.troopgame.api.b mTroopGameObserver;
    private QUIBadge quiBadge;
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g renderLogicView;
    private View renderView;
    private LinearLayout titleView;

    public ElegantProfileGameCardComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.lastShowFlag = false;
        this.lastShowQuickAuth = false;
        this.cardInfoState = -1;
        this.hasReportExposure = false;
        this.isRefreshTroopMemberCardInfo = true;
        this.mTroopGameObserver = new com.tencent.mobileqq.troop.troopgame.api.b() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent.1
            @Override // com.tencent.mobileqq.troop.troopgame.api.b
            protected void onGetGameInfoCardSwitch(boolean z16, String str, QqCardSvrPB$GetSwitchRsp qqCardSvrPB$GetSwitchRsp) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetGameInfoCardSwitch isSuccess uin=");
                sb5.append(str);
                sb5.append(",switchStatus=");
                sb5.append(qqCardSvrPB$GetSwitchRsp != null ? qqCardSvrPB$GetSwitchRsp.status.get() : -1);
                QLog.d(ElegantProfileGameCardComponent.TAG, 1, sb5.toString());
                if (!z16 || ((AbsComponent) ElegantProfileGameCardComponent.this).mData == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileGameCardComponent.this).mData).allInOne == null || qqCardSvrPB$GetSwitchRsp == null) {
                    return;
                }
                ElegantProfileGameCardComponent.this.cardInfoState = qqCardSvrPB$GetSwitchRsp.status.get();
                if (ElegantProfileGameCardComponent.this.isHost() && ElegantProfileGameCardComponent.this.cardInfoState != 1 && ElegantProfileGameCardComponent.this.cardInfoState != 2 && !ElegantProfileGameCardComponent.this.isShowQuickAuth()) {
                    ElegantProfileGameCardComponent.this.requestGameInfoQuickAuth();
                } else {
                    ElegantProfileGameCardComponent.this.updateData("onGetMyGameInfoCardSwitch");
                }
            }

            @Override // com.tencent.mobileqq.troop.troopgame.api.b
            protected void onGetMyGameInfoQuickAuth(boolean z16, QqCardSvrPB$ShowQuickAuthorizeRsp qqCardSvrPB$ShowQuickAuthorizeRsp) {
                Object obj;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetMyGameInfoQuickAuth isSuccess=");
                sb5.append(z16);
                sb5.append(",switchStatus=");
                if (qqCardSvrPB$ShowQuickAuthorizeRsp != null) {
                    obj = Boolean.valueOf(qqCardSvrPB$ShowQuickAuthorizeRsp.should_show.get());
                } else {
                    obj = -1;
                }
                sb5.append(obj);
                QLog.d(ElegantProfileGameCardComponent.TAG, 1, sb5.toString());
                if (!z16 || ((AbsComponent) ElegantProfileGameCardComponent.this).mData == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileGameCardComponent.this).mData).allInOne == null || qqCardSvrPB$ShowQuickAuthorizeRsp == null) {
                    return;
                }
                ElegantProfileGameCardComponent.this.bShowQuickAuth = qqCardSvrPB$ShowQuickAuthorizeRsp.should_show.get();
                ElegantProfileGameCardComponent.this.updateData("onGetMyGameInfoQuickAuth");
                if (ElegantProfileGameCardComponent.this.bShowQuickAuth) {
                    p03.a.m(((AbsComponent) ElegantProfileGameCardComponent.this).mApp.getCurrentUin()).h(ElegantProfileGameCardComponent.KEY_IS_SHOW_GAMECARD_QUICK_AUTH, true);
                }
            }

            @Override // com.tencent.mobileqq.troop.troopgame.api.b
            protected void onSetMyGameInfoCardSwitch(boolean z16, QqCardSvrPB$SetSwitchRsp qqCardSvrPB$SetSwitchRsp) {
                QLog.d(ElegantProfileGameCardComponent.TAG, 1, "onSetMyGameInfoCardSwitch isSuccess=" + z16);
                if (!z16 || ((AbsComponent) ElegantProfileGameCardComponent.this).mData == null || ((ProfileCardInfo) ((AbsComponent) ElegantProfileGameCardComponent.this).mData).allInOne == null || qqCardSvrPB$SetSwitchRsp == null || !ElegantProfileGameCardComponent.this.isHost()) {
                    return;
                }
                ElegantProfileGameCardComponent.this.hideQuickAuthTips();
                ElegantProfileGameCardComponent.this.cardInfoState = qqCardSvrPB$SetSwitchRsp.status.get();
                ElegantProfileGameCardComponent.this.updateData("onSetMyGameInfoCardSwitch");
            }
        };
        this.kuiklyBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdMetricTag.EVENT_NAME);
                if (ElegantProfileGameCardComponent.EVENT_PROFILE_SET_TAB_URL.equals(stringExtra)) {
                    String stringExtra2 = intent.getStringExtra("data");
                    QLog.d(ElegantProfileGameCardComponent.TAG, 1, "onReceive eventName=" + stringExtra + ",jsonData=" + stringExtra2);
                    try {
                        if (TextUtils.isEmpty(stringExtra2)) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(stringExtra2);
                        ElegantProfileGameCardComponent.this.isKuiklyError = jSONObject.optBoolean("getGameInfoError", false);
                        String optString = jSONObject.optString("gamecenterMytabUrl", "");
                        ElegantProfileGameCardComponent.this.kuiklyGameAppId = jSONObject.optString("gameAppId", "");
                        QLog.d(ElegantProfileGameCardComponent.TAG, 1, "onReceive eventName=" + stringExtra + ",isKuiklyError=" + ElegantProfileGameCardComponent.this.isKuiklyError + JefsClass.INDEX_URL + optString);
                        if (!TextUtils.isEmpty(optString)) {
                            ElegantProfileGameCardComponent.this.titleView.setTag(optString);
                        }
                        if (ElegantProfileGameCardComponent.this.isKuiklyError) {
                            ElegantProfileGameCardComponent.this.hideViewContainer();
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        QLog.e(ElegantProfileGameCardComponent.TAG, 1, "onReceive eventName=" + stringExtra + ",data exception", e16);
                        return;
                    }
                }
                if (ElegantProfileGameCardComponent.EVENT_PROFILE_FRAME_CHANGE.equals(stringExtra)) {
                    String stringExtra3 = intent.getStringExtra("data");
                    QLog.d(ElegantProfileGameCardComponent.TAG, 1, "onReceive eventName=" + stringExtra + ",jsonData=" + stringExtra3);
                    try {
                        if (TextUtils.isEmpty(stringExtra3)) {
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject(stringExtra3);
                        int realHeight = ElegantProfileGameCardComponent.this.getRealHeight(Math.ceil(jSONObject2.optDouble("width", 0.0d)), Math.ceil(jSONObject2.optDouble("height", 0.0d)));
                        if (realHeight <= 0 || ElegantProfileGameCardComponent.this.renderView == null) {
                            return;
                        }
                        ElegantProfileGameCardComponent.this.renderView.setLayoutParams(new LinearLayout.LayoutParams(-1, realHeight));
                    } catch (JSONException e17) {
                        QLog.e(ElegantProfileGameCardComponent.TAG, 1, "onReceive eventName=" + stringExtra + ",data exception", e17);
                    }
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getAppIdOfTroopGameCard() {
        TroopInfo k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin);
        if (k3 == null) {
            QLog.d(TAG, 2, "getAppIdOfTroopGameCard troopInfo is null");
            return "";
        }
        if (StudyModeManager.t()) {
            QLog.d(TAG, 2, "getAppIdOfTroopGameCard is studyMode");
            return "";
        }
        if (!((ITroopGameApi) QRoute.api(ITroopGameApi.class)).enableShowGameCard(k3)) {
            QLog.d(TAG, 2, "getAppIdOfTroopGameCard disable");
            return "";
        }
        ArrayList<GroupGame> arrayList = k3.groupGameList.gameInfos;
        ArrayList<Integer> arrayList2 = k3.selectedGameId;
        for (GroupGame groupGame : arrayList) {
            if (groupGame.notAllowSelected != 1 && arrayList2.contains(Integer.valueOf(groupGame.gameId))) {
                return groupGame.gameInfo.getAppId();
            }
        }
        return "";
    }

    private String getCurrentUin() {
        String currentUin;
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            currentUin = "";
        } else {
            currentUin = appInterface.getCurrentUin();
        }
        return currentUin == null ? "" : currentUin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight(double d16, double d17) {
        View view;
        QLog.d(TAG, 1, "getRealHeight newWidth=" + d16 + ",newHeight=" + d17);
        if (d17 >= 1.0d && d16 >= 1.0d && (view = this.renderView) != null) {
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth <= 0) {
                return 0;
            }
            double d18 = d17 / d16;
            int i3 = (int) (measuredWidth * d18);
            QLog.d(TAG, 1, "getRealHeight renderViewWidth=" + measuredWidth + ",rate=" + d18 + ",realHeight=" + i3);
            return i3;
        }
        QLog.w(TAG, 1, "getRealHeight fail, params invalid");
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, VIEW] */
    private void initView() {
        ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.cyo, (ViewGroup) null);
        this.mViewContainer = inflate;
        this.kuiklyRootLayout = (LinearLayout) inflate.findViewById(R.id.ouh);
        LinearLayout linearLayout = (LinearLayout) ((View) this.mViewContainer).findViewById(R.id.oun);
        this.titleView = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.oti);
        this.authTipsView = textView;
        textView.setOnClickListener(this);
        this.quiBadge = (QUIBadge) ((View) this.mViewContainer).findViewById(R.id.owq);
        boolean equals = this.mApp.getCurrentUin().equals(getProfileCardUin());
        TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.ouj);
        if (equals) {
            textView2.setText(R.string.f169711x61);
        } else {
            textView2.setText(R.string.f169712x62);
        }
        ((View) this.mViewContainer).setVisibility(8);
        this.isForceHide = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowQuickAuth() {
        boolean b16 = p03.a.m(this.mApp.getCurrentUin()).b(KEY_IS_SHOW_GAMECARD_QUICK_AUTH);
        QLog.d(TAG, 2, "isShowQuickAuth isShow=" + b16);
        return b16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isTroopGameCard() {
        DATA data = this.mData;
        return data != 0 && ((ProfileCardInfo) data).isTroopMemberCard;
    }

    private void jumpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        if (HttpUtil.isValidUrl(str)) {
            intent.putExtra("url", str);
            RouteUtils.startActivity(this.mActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        try {
            intent.setData(Uri.parse(str));
            RouteUtils.startActivity(this.mActivity, intent, RouterConstants.UI_ROUTER_JUMP);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideQuickAuthTips$5() {
        TextView textView = this.authTipsView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        QUIBadge qUIBadge = this.quiBadge;
        if (qUIBadge != null) {
            qUIBadge.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$hideViewContainer$2() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setVisibility(8);
        }
        this.isForceHide = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetTroopMemberInfoForGameCard$1() {
        updateData("onGetTroopMemberInfoForGameCard");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showQuickAuthTips$4() {
        TextView textView = this.authTipsView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        QUIBadge qUIBadge = this.quiBadge;
        if (qUIBadge != null) {
            qUIBadge.setVisibility(0);
            this.quiBadge.setRedDot();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showViewContainer$3() {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setVisibility(0);
        }
        this.isForceHide = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onGetTroopGameCardState() {
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            QLog.d(TAG, 1, "onGetTroopGameCardState fetch TroopMemberExtInfo");
            ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
            DATA data2 = this.mData;
            iTroopMemberListRepoApi.fetchTroopMemberInfoWithExtInfo(((ProfileCardInfo) data2).troopUin, ((ProfileCardInfo) data2).allInOne.uin, false, this.mActivity, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.c
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    ElegantProfileGameCardComponent.this.onGetTroopMemberInfoForGameCard(troopMemberInfo);
                }
            });
            return;
        }
        QLog.e(TAG, 2, "onGetTroopGameCardState mData is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetTroopMemberInfoForGameCard(TroopMemberInfo troopMemberInfo) {
        this.isTroopMemberGameCardOpened = isGameCardOpened(troopMemberInfo);
        QLog.i(TAG, 2, "onGetTroopMemberInfoForGameCard state:" + this.isTroopMemberGameCardOpened);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.g
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileGameCardComponent.this.lambda$onGetTroopMemberInfoForGameCard$1();
            }
        });
    }

    private void reportExposure() {
        String str;
        AppInterface appInterface = this.mApp;
        if (appInterface == null || this.hasReportExposure) {
            return;
        }
        boolean equals = appInterface.getCurrentUin().equals(getProfileCardUin());
        IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        if (equals) {
            str = "1";
        } else {
            str = "2";
        }
        iGameMsgHelperApi.reportForGameMsg("GAME_INFO", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "8939", "893907", "208848", "", "", "8", str);
        this.hasReportExposure = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void reportGameCard() {
        DATA data = this.mData;
        if (data != 0 && !((ProfileCardInfo) data).isTroopMemberCard && ProfileUtils.isVisible((View) this.mViewContainer) && !this.hasReport) {
            ReportController.o(this.mApp, "dc00898", "", "", "0X800B5EF", "0X800B5EF", 0, 0, "0", "0", "", "");
            this.hasReport = true;
        }
        reportExposure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestGameInfoQuickAuth() {
        com.tencent.mobileqq.troop.troopgame.api.a aVar = (com.tencent.mobileqq.troop.troopgame.api.a) this.mApp.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
        if (aVar != null) {
            QLog.d(TAG, 2, "requestGameInfoQuickAuth");
            aVar.u();
        }
    }

    private void requestGameInfoSwitch() {
        com.tencent.mobileqq.troop.troopgame.api.a aVar = (com.tencent.mobileqq.troop.troopgame.api.a) this.mApp.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
        if (aVar != null) {
            QLog.d(TAG, 2, "requestGameInfoSwitch");
            aVar.T0(getProfileCardUin());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestTroopGameCardInfo() {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForGameCard(((ProfileCardInfo) this.mData).troopUin, "ElegantProfileGameCardComponent.requestTroopGameCardInfo", this.mActivity, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent.3
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, TroopInfo troopInfo) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetTroopGameCardInfo isSuccess=");
                sb5.append(bool);
                sb5.append(",selectedGameId=");
                sb5.append(troopInfo != null ? troopInfo.selectedGameId : "null");
                QLog.d(ElegantProfileGameCardComponent.TAG, 1, sb5.toString());
                ElegantProfileGameCardComponent.this.updateData("onGetTroopGameCardInfo");
                return null;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestTroopMemberGameCardState() {
        if (this.mApp == null) {
            QLog.e(TAG, 2, "requestTroopMemberGameCardState mApp is null");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.mActivity)) {
            QLog.d(TAG, 2, "requestTroopMemberGameCardState Network is unavailable");
            return;
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null) {
            QLog.d(TAG, 2, "requestTroopMemberGameCardState start");
            ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
            DATA data2 = this.mData;
            iTroopMemberExtInfoRepoApi.fetchTroopMemberGameInfo(((ProfileCardInfo) data2).troopUin, ((ProfileCardInfo) data2).allInOne.uin, this.mActivity, new Function1() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$requestTroopMemberGameCardState$0;
                    lambda$requestTroopMemberGameCardState$0 = ElegantProfileGameCardComponent.this.lambda$requestTroopMemberGameCardState$0((Boolean) obj);
                    return lambda$requestTroopMemberGameCardState$0;
                }
            });
            return;
        }
        QLog.d(TAG, 2, "requestTroopMemberGameCardState mData is null");
    }

    private void requestTroopMemberGameCardSwitch() {
        String appIdOfTroopGameCard = getAppIdOfTroopGameCard();
        QLog.d(TAG, 1, "requestTroopMemberGameCardSwitch appId", appIdOfTroopGameCard);
        if (!TextUtils.isEmpty(appIdOfTroopGameCard)) {
            requestTroopMemberGameCardState();
        } else {
            QLog.d(TAG, 2, "requestTroopMemberGameCardSwitch no game selected");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1049;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_GAME_INFO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean getShowCardFlag() {
        TroopInfo k3;
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).allInOne != null && this.mApp != null) {
            if (((ProfileCardInfo) data).isTroopMemberCard) {
                if (!this.isTroopMemberGameCardOpened || (k3 = ((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).k(((ProfileCardInfo) this.mData).troopUin)) == null) {
                    return false;
                }
                return k3.isTroopGameCardEnabledV2();
            }
            int i3 = this.cardInfoState;
            return i3 == 1 || (i3 == 2 && isHost());
        }
        QLog.w(TAG, 1, "getShowCardFlag params invalid");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent
    public boolean makeOrRefreshEntry(ProfileCardInfo profileCardInfo) {
        if (this.mActivity != null && profileCardInfo != null && profileCardInfo.allInOne != null && this.mViewContainer != 0 && !this.isKuiklyError) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).isTroopMemberCard) {
                if (this.isRefreshTroopMemberCardInfo) {
                    this.isRefreshTroopMemberCardInfo = false;
                    requestTroopMemberGameCardSwitch();
                    return false;
                }
            } else {
                if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) data).allInOne)) {
                    QLog.d(TAG, 1, "makeOrRefreshEntry break, isPaTypeStrangerInContact");
                    return false;
                }
                if (StudyModeManager.t()) {
                    QLog.d(TAG, 2, "makeOrRefreshEntry is studyMode");
                    return false;
                }
                if (!this.mConfigHelper.isSwitchEnable(14)) {
                    QLog.d(TAG, 1, "makeOrRefreshEntry switch_game_info is off");
                    return false;
                }
            }
            if (!((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.PROFILE_GAMEINFO_CARD_SETTING_SWITCH, true)) {
                QLog.d(TAG, 1, "makeOrRefreshEntry isSwitchOn is off");
                return false;
            }
            boolean showCardFlag = getShowCardFlag();
            QLog.w(TAG, 2, "makeOrRefreshEntry lastShowFlag=" + this.lastShowFlag + ", realShowCardFlag=" + showCardFlag + ",bShowQuickAuth=" + this.bShowQuickAuth);
            if (showCardFlag == this.lastShowFlag && this.lastShowQuickAuth == this.bShowQuickAuth) {
                return false;
            }
            this.lastShowFlag = showCardFlag;
            this.lastShowQuickAuth = this.bShowQuickAuth;
            if (showCardFlag) {
                showViewContainer();
                addKuiklyItem();
                return true;
            }
            removeKuiklyItem();
            if (!isHost()) {
                hideViewContainer();
            } else if (this.bShowQuickAuth) {
                showViewContainer();
                showQuickAuthTips();
            } else {
                hideViewContainer();
            }
            return false;
        }
        QLog.d(TAG, 1, "makeOrRefreshEntry params error");
        hideViewContainer();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object obj;
        int id5 = view.getId();
        if (id5 == R.id.oti) {
            com.tencent.mobileqq.troop.troopgame.api.a aVar = (com.tencent.mobileqq.troop.troopgame.api.a) this.mApp.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
            if (aVar != null) {
                QLog.d(TAG, 2, "requestGameInfoSwitch");
                aVar.g2(1);
                return;
            }
            return;
        }
        if (id5 != R.id.oun) {
            return;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String) || this.mActivity == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = "1";
        hashMap.put(2, "1");
        hashMap.put(4, "20");
        if (!isTroopGameCard()) {
            obj = "1";
        } else {
            obj = "2";
        }
        hashMap.put(25, obj);
        if (!getCurrentUin().equals(getProfileCardUin())) {
            str = "2";
        }
        hashMap.put(26, str);
        hashMap.put(27, getProfileCardUin());
        hl0.a.c(this.mApp, "9636", "929194", this.kuiklyGameAppId, "963601", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
        jumpUrl((String) tag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        QLog.d(TAG, 1, "onCreate");
        this.mApp.addObserver(this.mTroopGameObserver);
        initView();
        if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
            requestTroopGameCardInfo();
        } else {
            requestGameInfoSwitch();
        }
        reportExposure();
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.troopgame.BaseProfileTroopMemGameInfoComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        com.tencent.mobileqq.troop.troopgame.api.b bVar;
        QLog.d(TAG, 1, "onDestroy mApp=" + this.mApp + ",removeObserver=" + this.mTroopGameObserver + ",renderLogicView=" + this.renderLogicView);
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (bVar = this.mTroopGameObserver) != null) {
            appInterface.removeObserver(bVar);
            this.mTroopGameObserver = null;
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.kuiklyBroadcastReceiver);
        } catch (Exception unused) {
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
        if (gVar != null) {
            gVar.onDetach();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPageLoadComplete isSucceed=");
        sb5.append(z16);
        sb5.append(",errorReason=");
        if (errorReason != null) {
            str = errorReason.name();
        } else {
            str = "";
        }
        sb5.append(str);
        QLog.i(TAG, 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addKuiklyItem() {
        QLog.d(TAG, 2, "addKuiklyItem");
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).allInOne == null || this.renderLogicView != null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            MobileQQ.sMobileQQ.registerReceiver(this.kuiklyBroadcastReceiver, intentFilter);
            String profileCardUin = getProfileCardUin();
            HashMap hashMap = new HashMap();
            hashMap.put("showUin", profileCardUin);
            hashMap.put("troopUin", ((ProfileCardInfo) this.mData).troopUin);
            if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                hashMap.put("gameAppId", getAppIdOfTroopGameCard());
            }
            hashMap.put("bundle_name", BUNDLE_NAME);
            hashMap.put(KuiklyLaunchParams.PARAM_MODAL_MODE, Boolean.TRUE);
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(BaseApplication.getContext(), this);
            this.renderLogicView = createKuiklyRenderView;
            View view = (View) createKuiklyRenderView;
            this.renderView = view;
            this.kuiklyRootLayout.addView(view);
            this.renderLogicView.b(KUIKLY_PAGE_NAME, hashMap, null);
            this.renderLogicView.onResume();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "addKuiklyItem registerReceiver fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideQuickAuthTips() {
        QLog.d(TAG, 2, "hideQuickAuthTips");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            TextView textView = this.authTipsView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            QUIBadge qUIBadge = this.quiBadge;
            if (qUIBadge != null) {
                qUIBadge.setVisibility(8);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.b
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileGameCardComponent.this.lambda$hideQuickAuthTips$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void hideViewContainer() {
        QLog.d(TAG, 2, "hideViewContainer");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            VIEW view = this.mViewContainer;
            if (view != 0) {
                ((View) view).setVisibility(8);
            }
            this.isForceHide = true;
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.f
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileGameCardComponent.this.lambda$hideViewContainer$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$requestTroopMemberGameCardState$0(Boolean bool) {
        QLog.d(TAG, 1, "fetchTroopMemberGameInfo isSuccess=", bool);
        if (!bool.booleanValue()) {
            return null;
        }
        onGetTroopGameCardState();
        return null;
    }

    private void removeKuiklyItem() {
        QLog.d(TAG, 2, "removeKuiklyItem");
        try {
            Object obj = this.renderLogicView;
            if (obj != null) {
                LinearLayout linearLayout = this.kuiklyRootLayout;
                if (linearLayout != null) {
                    linearLayout.removeView((View) obj);
                }
                this.renderLogicView.onDetach();
            }
            this.renderLogicView = null;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.kuiklyBroadcastReceiver);
        } catch (Exception unused) {
        }
    }

    private void showQuickAuthTips() {
        QLog.d(TAG, 2, "showQuickAuthTips");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            TextView textView = this.authTipsView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            QUIBadge qUIBadge = this.quiBadge;
            if (qUIBadge != null) {
                qUIBadge.setVisibility(0);
                this.quiBadge.setRedDot();
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.e
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileGameCardComponent.this.lambda$showQuickAuthTips$4();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showViewContainer() {
        QLog.d(TAG, 2, "showViewContainer");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            VIEW view = this.mViewContainer;
            if (view != 0) {
                ((View) view).setVisibility(0);
            }
            this.isForceHide = false;
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.d
            @Override // java.lang.Runnable
            public final void run() {
                ElegantProfileGameCardComponent.this.lambda$showViewContainer$3();
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        this.hasReport = false;
        super.onResume();
        QLog.d(TAG, 1, "onResume renderLogicView=" + this.renderLogicView);
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    private boolean isGameCardOpened(TroopMemberInfo troopMemberInfo) {
        TroopMemberInfoExt troopMemberInfoExt;
        return (troopMemberInfo == null || (troopMemberInfoExt = troopMemberInfo.extInfo) == null || (troopMemberInfoExt.flagEx3 & 16) != 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 0 && ProfileUtils.isVisible((View) this.mViewContainer)) {
            ((View) this.mViewContainer).post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent.4
                @Override // java.lang.Runnable
                public void run() {
                    ElegantProfileGameCardComponent.this.reportGameCard();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
    }
}

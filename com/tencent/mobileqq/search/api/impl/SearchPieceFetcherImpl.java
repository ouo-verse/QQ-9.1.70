package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.t;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pic.aa;
import com.tencent.mobileqq.profile.l;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ag;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes18.dex */
public class SearchPieceFetcherImpl implements ISearchPieceFetcher {
    private static final String TAG = "SearchPieceFetcherImpl";

    private static t getGlobalSearchConfig() {
        t tVar = (t) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100519");
        if (tVar == null || !tVar.b()) {
            return (t) am.s().x(414);
        }
        return tVar;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean bEnableFtsTroop() {
        return w.c();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int enterChatWin(Context context, AppInterface appInterface, String str, int i3, String str2, boolean z16) {
        return RecentUtil.s(context, (QQAppInterface) appInterface, str, i3, str2, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void enterTroopTmpChatWin(Context context, String str, String str2, int i3, String str3, boolean z16, Bundle bundle, Intent[] intentArr) {
        RecentUtil.x(context, str, str2, i3, str3, z16, bundle, intentArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean filterQidianMasterSearch(AppInterface appInterface, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, int i3) {
        return QidianManager.m(dVar, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getBuddyName(AppInterface appInterface, String str, boolean z16) {
        return ac.g(appInterface, str, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getBuddyNickName(AppRuntime appRuntime, String str, boolean z16) {
        return ac.h(appRuntime, str, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getCurrKeyword() {
        return UniteSearchActivity.f282690h0;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public DownloadParams.DecodeHandler getDecodeHandler() {
        return com.tencent.mobileqq.urldrawable.a.f306322b;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public Pair<Integer, Integer> getFaceTypeAndResId(AppInterface appInterface, int i3, String str) {
        return i.n((QQAppInterface) appInterface, i3, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int getFromForHistoryCode() {
        return UniteSearchActivity.f282684b0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r3 != 3) goto L12;
     */
    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getJumpUrl(Context context, String str, String str2) {
        int i3 = 0;
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(context)) {
            int i16 = ((UniteSearchActivity) context).G2().source;
            int i17 = 1;
            if (i16 != 1) {
                i17 = 2;
                if (i16 != 2) {
                    i17 = 3;
                }
            }
            i3 = i17;
        }
        if (TextUtils.isEmpty(str2)) {
            return w.g(str, i3, VipFunCallConstants.KEY_GROUP);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int getMostUseConstantsReportContact() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getRealTroopName(AppInterface appInterface, String str, boolean z16) {
        return ac.W(appInterface, str, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getSearchPlanReportString() {
        return com.tencent.mobileqq.search.report.b.c();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int getShoppingAccount() {
        return 36;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public List<ag> getTroopAssistantSearchInfos(AppInterface appInterface) {
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getTroopName(AppInterface appInterface, String str, boolean z16) {
        return ac.g0(appInterface, str, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public Bundle getTroopProfileExtra(String str, int i3) {
        return TroopInfoActivity.getTroopProfileExtra(str, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public String getUinByPhoneNum(AppInterface appInterface, String str) {
        return ac.m0(appInterface, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public byte[] inflateConfigString(byte[] bArr) {
        return com.tencent.mobileqq.olympic.utils.a.d(bArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean isQQAppInterface(AppRuntime appRuntime) {
        return appRuntime instanceof QQAppInterface;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean isQidianMaster(byte b16) {
        return QidianManager.O(b16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean isRobotUin(String str) {
        return SearchUtil.w(str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean isUinInAssist(String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public boolean isUniteSearchActivity(Context context) {
        return context instanceof UniteSearchActivity;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void joinFriendProfileIntentWithTroopMemberCardIntent(Context context, AppInterface appInterface, Intent intent, int i3) {
        l.c(context, (QQAppInterface) appInterface, intent, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void jumpQQBrowserActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void lanuchFTSEntitySearchDetailActivity(Context context, String str, String str2, CharSequence charSequence, List<? extends FTSEntity> list, int i3, String str3, int i16, int i17) {
        FTSEntitySearchDetailActivity.I2(context, str, str2, charSequence, list, i3, str3, i16, i17);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void markEnterAioFromSearch() {
        RecentUtil.f185176a = true;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void onClickReportHelper(Intent intent) {
        RecentUtil.k0(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void openRobotProfileCard(Context context, String str, String str2) {
        k.o(context, str, str2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void refreshFavList(Activity activity, String str, long j3) {
        QfavHelper.y(activity, str, j3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void saveCurrentSearchKeyword(AppInterface appInterface, String str) {
        com.tencent.mobileqq.search.ac.o((QQAppInterface) appInterface, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int searchBitUsedBefore() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setContactSearchRecentAndHistoryWithoutFriend(Context context, AppInterface appInterface, String str, String str2, String str3, View view) {
        RecentUtil.f185176a = true;
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        RecentUtil.s(context, qQAppInterface, str, 0, str2, false);
        SearchUtils.c1(str3, 20, 1, view);
        com.tencent.mobileqq.search.ac.o(qQAppInterface, str3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setContactSearchRecentAndHistroy(Context context, AppInterface appInterface, String str, String str2, String str3, View view) {
        RecentUtil.f185176a = true;
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        RecentUtil.s(context, qQAppInterface, str, 0, str2, false);
        SearchUtils.c1(str3, 20, 1, view);
        com.tencent.mobileqq.search.ac.o(qQAppInterface, str3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setGlobalSearchConfNeedSeparate() {
        t globalSearchConfig = getGlobalSearchConfig();
        if (globalSearchConfig != null) {
            SearchConfig.needSeparate = globalSearchConfig.a();
            if (QLog.isColorLevel()) {
                QLog.i("SearchConfigManager", 2, "need separate:" + SearchConfig.needSeparate);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setRecentUtilEnterFromExts(long j3) {
        RecentUtil.f185178c = j3;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setRecentUtilIsEnterFromSearch(Boolean bool) {
        RecentUtil.f185176a = bool.booleanValue();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void setStructMsgPicPreDelegateSwitch(int i3) {
        aa.f(i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startActivateFriendsForModelTroop(Context context) {
        Intent intent = new Intent(context, (Class<?>) ActivateFriendActivity.class);
        intent.putExtra("af_key_from", 5);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startBySearchMoreActivity(Context context, String str, int i3, int i16, int i17, String str2, String str3, String str4) {
        FTSEntitySearchFragment.wh(context, "@\u6211", i3, i16, i17, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startDataLinePCForModelTroop(Context context) {
        Intent intent = new Intent(context, (Class<?>) LiteActivity.class);
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
        ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).onClickReportHelper(intent);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startECShopAssistForModelTroop(AppInterface appInterface, Context context) {
        Intent intent = new Intent(context, (Class<?>) EcshopWebActivity.class);
        intent.putExtra("from_search", true);
        intent.setFlags(67108864);
        EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) appInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (ecShopAssistantManager != null) {
            ecShopAssistantManager.b(intent, context, -1);
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startRecommendContactForModelTroop(Context context) {
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(context, null, 0);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startServiceAccountFolderForModelTroop(Context context) {
        com.tencent.biz.subscribe.d.j(context, 9005, null);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startSubAccountAssistantForModelTroop(AppInterface appInterface, Context context, String str, int i3) {
        ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).forwardTo(appInterface, context, str);
        ((QQAppInterface) appInterface).getMessageFacade().O0(str, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startTroopBarAssistForModelTroop(AppInterface appInterface, Context context) {
        TroopBarAssistantManager n3 = TroopBarAssistantManager.n();
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        n3.P(qQAppInterface, false);
        n3.O(qQAppInterface, false);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startTroopNotificationForModelTroop(AppInterface appInterface, Context context) {
        ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationFragment(new Intent());
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public int enterChatWin(Context context, AppInterface appInterface, String str, int i3, String str2, boolean z16, Bundle bundle, Intent[] intentArr) {
        return RecentUtil.u(context, (QQAppInterface) appInterface, str, i3, str2, z16, bundle, intentArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void initAssistTroopCache(AppInterface appInterface) {
    }

    @Override // com.tencent.mobileqq.search.api.ISearchPieceFetcher
    public void startTroopAssistantForModelTroop(Context context) {
    }
}

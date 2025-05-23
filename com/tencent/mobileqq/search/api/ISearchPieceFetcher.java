package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.ag;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchPieceFetcher extends QRouteApi {
    boolean bEnableFtsTroop();

    int enterChatWin(Context context, AppInterface appInterface, String str, int i3, String str2, boolean z16);

    int enterChatWin(Context context, AppInterface appInterface, String str, int i3, String str2, boolean z16, Bundle bundle, Intent[] intentArr);

    void enterTroopTmpChatWin(Context context, String str, String str2, int i3, String str3, boolean z16, Bundle bundle, Intent[] intentArr);

    boolean filterQidianMasterSearch(AppInterface appInterface, d dVar, int i3);

    String getBuddyName(AppInterface appInterface, String str, boolean z16);

    String getBuddyNickName(AppRuntime appRuntime, String str, boolean z16);

    String getCurrKeyword();

    DownloadParams.DecodeHandler getDecodeHandler();

    Pair<Integer, Integer> getFaceTypeAndResId(AppInterface appInterface, int i3, String str);

    int getFromForHistoryCode();

    String getJumpUrl(Context context, String str, String str2);

    int getMostUseConstantsReportContact();

    String getRealTroopName(AppInterface appInterface, String str, boolean z16);

    String getSearchPlanReportString();

    int getShoppingAccount();

    List<ag> getTroopAssistantSearchInfos(AppInterface appInterface);

    String getTroopName(AppInterface appInterface, String str, boolean z16);

    Bundle getTroopProfileExtra(String str, int i3);

    String getUinByPhoneNum(AppInterface appInterface, String str);

    byte[] inflateConfigString(byte[] bArr);

    void initAssistTroopCache(AppInterface appInterface);

    boolean isQQAppInterface(AppRuntime appRuntime);

    boolean isQidianMaster(byte b16);

    boolean isRobotUin(String str);

    boolean isUinInAssist(String str);

    boolean isUniteSearchActivity(Context context);

    void joinFriendProfileIntentWithTroopMemberCardIntent(Context context, AppInterface appInterface, Intent intent, int i3);

    void jumpQQBrowserActivity(Context context, String str);

    void lanuchFTSEntitySearchDetailActivity(Context context, String str, String str2, CharSequence charSequence, List<? extends FTSEntity> list, int i3, String str3, int i16, int i17);

    void markEnterAioFromSearch();

    void onClickReportHelper(Intent intent);

    void openRobotProfileCard(Context context, String str, String str2);

    void refreshFavList(Activity activity, String str, long j3);

    void saveCurrentSearchKeyword(AppInterface appInterface, String str);

    int searchBitUsedBefore();

    void setContactSearchRecentAndHistoryWithoutFriend(Context context, AppInterface appInterface, String str, String str2, String str3, View view);

    void setContactSearchRecentAndHistroy(Context context, AppInterface appInterface, String str, String str2, String str3, View view);

    void setGlobalSearchConfNeedSeparate();

    void setRecentUtilEnterFromExts(long j3);

    void setRecentUtilIsEnterFromSearch(Boolean bool);

    void setStructMsgPicPreDelegateSwitch(int i3);

    void startActivateFriendsForModelTroop(Context context);

    void startBySearchMoreActivity(Context context, String str, int i3, int i16, int i17, String str2, String str3, String str4);

    void startDataLinePCForModelTroop(Context context);

    void startECShopAssistForModelTroop(AppInterface appInterface, Context context);

    void startRecommendContactForModelTroop(Context context);

    void startServiceAccountFolderForModelTroop(Context context);

    void startSubAccountAssistantForModelTroop(AppInterface appInterface, Context context, String str, int i3);

    void startTroopAssistantForModelTroop(Context context);

    void startTroopBarAssistForModelTroop(AppInterface appInterface, Context context);

    void startTroopNotificationForModelTroop(AppInterface appInterface, Context context);
}

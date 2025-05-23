package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopUtilApi extends QRouteApi {
    public static final String GAME_H5_SELECT_GAME_APPID = "GAME_H5_SELECT_GAME_APPID";
    public static final int GAME_SELECT_SEARCH_TYPE_ACTION = 2;
    public static final int GAME_SELECT_SEARCH_TYPE_CLICK = 3;
    public static final int GAME_SELECT_SEARCH_TYPE_INIT = 1;
    public static final String HIDDEN_CHAT_DISABLE_OPEN_ON_STUDY_MODE = "QQ_hidden_session_disable_open";
    public static final int TYPE_GUEST_VISTOR = 2;

    int QAVHrMeeting_hrExtra(long j3);

    void addLocalSetTopDataIgnore(AppRuntime appRuntime, String str);

    void clearTroopShortCutBarAppRedPoint(AppRuntime appRuntime, String str, long j3);

    void configTroopCmdReportObj(ToServiceMsg toServiceMsg, String str);

    void configTroopCmdReportObj(ToServiceMsg toServiceMsg, String str, String str2);

    Serializable createTroopCmdReportObj(String str, String str2, String str3);

    void doReqGameFriends(AppInterface appInterface, String str, Activity activity);

    void doTroopCmdReport(ToServiceMsg toServiceMsg, int i3, int i16);

    void doTroopCmdReport(Serializable serializable, int i3, int i16);

    void fetchNewTroopHeadUinList(String str);

    void fetchRobotShareInfo(AppRuntime appRuntime, String str, a aVar);

    void fetchTroopMemberInfoByUins(String str, List<String> list, boolean z16, Object obj, String str2, com.tencent.mobileqq.troop.d dVar);

    void fetchTroopMemberInfoFromDB(String str, String str2, Object obj, String str3, com.tencent.mobileqq.troop.c cVar);

    void fetchTroopMemberList(String str, boolean z16, Object obj, String str2, com.tencent.mobileqq.troop.d dVar);

    void fetchTroopMemberListUseWeakRef(String str, boolean z16, String str2, WeakReference<com.tencent.mobileqq.troop.d> weakReference);

    void fillResultRecordLevelIcon(ArrayList<com.tencent.mobileqq.troop.b> arrayList);

    void forwardRobotCard(Context context, String str, String str2);

    void forwardRobotList(Context context, String str);

    String fuzzyLog(String str);

    Bundle getForwardRobotCardBundle(Context context, String str, String str2);

    Bundle getForwardRobotListBundle(Context context, String str);

    String getNoFriendRemark(String str);

    String getQQGameTroopManager_TASK_NAME_MEMBER_StringValue();

    Class<? extends QPublicBaseFragment> getTroopManageClass();

    Object getTroopMemberFromCacheOrFetchAsync(String str, String str2, Object obj, String str3, com.tencent.mobileqq.troop.c cVar);

    @Deprecated
    Object getTroopMemberInfoSync(String str, String str2, Object obj, String str3);

    void handleGameClockData(AppInterface appInterface);

    boolean hasSetTroopHead(String str);

    boolean hasSetTroopHeadFromDb(String str, boolean z16);

    boolean hasUnReadRepeatTroopNotification(String str);

    void initTaskSet(AppInterface appInterface);

    boolean isColorSpan(CharacterStyle characterStyle);

    boolean isDiscToTroopEnabled();

    boolean isFilterUpdateInRecent(String str, int i3, long j3);

    boolean isGameClockBusiness(Activity activity);

    boolean isInviteOrJoinTroopParam(Object obj);

    boolean isLocalSetTopDataIgnoreContain(AppRuntime appRuntime, String str);

    boolean isNeedReqGameInfo(Activity activity);

    boolean isStudyMode();

    boolean isTroopGuildPushMsg(Object obj);

    boolean isUsingCameraOnVideo(AppRuntime appRuntime);

    void joinRecommendTroop(Context context, Object obj, int i3);

    void joinTroop(Context context, com.tencent.mobileqq.troop.g gVar, com.tencent.mobileqq.troop.f fVar);

    void joinTroopSafely(Context context, String str, int i3, String str2, String str3);

    void jumpRecmmendTroopFrag(@Nullable Context context);

    void notifyTopBanner(AppInterface appInterface, String str, int i3, String str2);

    void notifyTroopCenter(AppInterface appInterface, long j3, int i3, String str);

    void onClickEnterAddFriendAndTroop();

    void onDestroyForQQGameTroopManager(AppInterface appInterface);

    void onLuckyCharInfoChanged();

    void onOnlineRsp(AppInterface appInterface, List<String> list);

    void onSearchBarDone(AppInterface appInterface, Activity activity, List<com.tencent.mobileqq.troop.b> list, int i3, String str, String str2);

    void onTroopFlameDataUpdate(String str, GroupExtFlameData groupExtFlameData);

    void onTroopMemberHonorInfoChanged(String str, String str2, String str3, byte b16);

    void openRecommendTroop(Context context, Object obj, int i3, int i16);

    void openSearchTabPageFromTroopSquare(AppInterface appInterface, Activity activity, String str);

    void openTroopInfoActivity(Context context, Bundle bundle, int i3);

    void openTroopInfoActivity(Context context, String str);

    void openTroopSearchHistoryPageFromTroopSquare(Activity activity);

    void popBack(Activity activity);

    boolean qAVHrMeeting_isHRConf(long j3);

    boolean qAVHrMeeting_isNoRight(int i3);

    boolean qAVHrMeeting_isPSTNConf(long j3);

    void recordDiscussToTroopOp(String str, String str2, long j3, long j16);

    void report(String str, Map<String, Object> map);

    void reportFinishClick(String str, ArrayList<com.tencent.mobileqq.troop.b> arrayList, String str2);

    void reportNotificationConfig(Context context);

    void reportRobotProfile(@NonNull QBaseActivity qBaseActivity, @NonNull String str, @NonNull String str2, boolean z16);

    void reqGameInfoWhenIdle(AppInterface appInterface, Object obj, Activity activity);

    void sendReadConfirm(AppRuntime appRuntime, String str);

    void smallScreenUtils_getTrace(String str);

    void sortAndPreloadIfNeed(AppInterface appInterface, String str);

    void updateGameView(AppInterface appInterface, Activity activity, Object obj, TextView textView, ImageView imageView, TextView textView2);

    void updateNewTroopNameTimeStamp(String str, long j3, String str2);

    void updateTroopInfoAvatarId(String str, int i3, String str2);

    void updateTroopInfoPicListJson(String str, String str2, String str3);

    void updateTroopTypeAndSpecialClass(String str, Integer num, Integer num2, String str2);
}

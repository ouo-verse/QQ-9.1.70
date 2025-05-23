package com.tencent.mobileqq.troop.utils.api;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import dt2.c;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopUtilsApi extends QRouteApi {
    public static final int MEMBER_HAS_CARD_HAS_ADD_BTN = 3;
    public static final int MEMBER_HAS_CARD_NO_ADD_BTN = 1;
    public static final int MEMBER_NO_CARD_HAS_ADD_BTN = 2;
    public static final int MEMBER_NO_CARD_NO_ADD_BTN = 0;
    public static final String SP_KEY_TROOP_INFO_EDIT_RED_SHOW_TAG = "red_tag_";
    public static final String SP_TROOP_INFO_EDIT_RED_SHOW = "sp_troop_info_edit_red_show_";
    public static final String TROOP_MANAGE_CHANNEL_ID = "troop_manage_channel_id";
    public static final String TROOP_MANAGE_EDIT_CURRENT_UIN = "troop_manager_edit_current_uin";
    public static final String TROOP_MANAGE_GUILD_FEED_PERMISSION = "troop_manage_guild_feed_permission";
    public static final String TROOP_MANAGE_GUILD_FEED_SWITCH = "troop_manage_guild_feed_switch";
    public static final String TROOP_MANAGE_GUILD_ID = "troop_manage_guild_id";
    public static final String TROOP_MANAGE_IS_GUILD = "troop_manage_is_guild";
    public static final int TYPE_GUEST_VISTOR = 2;
    public static final int TYPE_HOST_VISTOR = 1;
    public static final int TYPE_UNKNOW = -1;
    public static final String VISTOR_TYPE = "vistor_type";

    @Deprecated
    void calJoinTroop(TroopInfoData troopInfoData, int i3, int i16, int i17);

    void calJoinTroop(String str, int i3, int i16, int i17, int i18, int i19);

    void checkApiState(AppRuntime appRuntime, Context context, String str, e.a aVar, int i3, Bundle bundle);

    boolean checkIsShowCacheAppInfos(AppRuntime appRuntime, String str, ArrayList<TroopAppInfo> arrayList);

    String constructParams(Bundle bundle, Bundle bundle2);

    c createAndShowCapsuleDialog(Context context, String str, AppDetail appDetail, Boolean bool);

    EntryModel createEntryModel(TroopInfo troopInfo, String str);

    int dp2px(float f16, Resources resources);

    String encrypt(String str);

    String getDateString(long j3);

    String getDateString(Context context, long j3);

    int getExposureSource();

    int getExposureSourceReportVal();

    int getMaxWidthForNameInTroopMemberListActivity(int i3);

    int getSpecialCareRingRoamingSetting(AppRuntime appRuntime);

    int getTroopGeneralSettingRing(AppRuntime appRuntime);

    int getTroopGeneralSettingVibrate(AppRuntime appRuntime);

    boolean getTroopInfoEditRedShow(AppRuntime appRuntime, String str, int i3);

    GroupMsgMask getTroopMask(AppRuntime appRuntime, String str);

    @Deprecated(since = "\u5386\u53f2\u903b\u8f91\u4f1a\u8f6c\u6362\u4e00\u4e0bmask\u4e3a\u7279\u5b9a\u7684int\u503c\uff0c\u610f\u4e49\u4e0d\u660e\uff0c\u4e0d\u8981\u518d\u7528\u4e86")
    int getTroopMaskPriority(String str);

    Intent getTroopMemberListActivityLaunchIntent(Context context, String str, int i3);

    void goToAppealForTempBlock(Context context, String str);

    void handleJoinTroopFailed(Context context, int i3);

    TroopInfo initTroopInfo(AppRuntime appRuntime, TroopInfoData troopInfoData, Context context);

    TroopInfoData initTroopInfoData(Bundle bundle, Context context);

    boolean isEmptyRedPointSP(String str);

    boolean isShowKingTeamRedPoint(boolean z16, String str);

    boolean isShowRedPoint(boolean z16, String str);

    boolean isTroopAdmin(AppRuntime appRuntime, String str, String str2);

    boolean isTroopEditInfoRedExist(AppRuntime appRuntime, String str, boolean[] zArr, int[] iArr);

    boolean isTroopMark(AppRuntime appRuntime, Message message);

    boolean isTroopMark(AppRuntime appRuntime, String str, int i3);

    boolean isTroopOwnerOrAdmin(AppRuntime appRuntime, String str, String str2);

    boolean isTroopTagNeedRedDot(long j3);

    boolean isUpdateBeforeSomeVersion(Context context, String str);

    void joinGroupOneStep(AppRuntime appRuntime, Context context, Intent intent, e.a aVar);

    void notifyUser(Context context, int i3, int i16, int i17);

    void preloadWebProcess(AppRuntime appRuntime);

    int readPictureDegree(String str);

    String replaceSpecialTag(String str, long j3, int i3, TroopInfoData troopInfoData, AppRuntime appRuntime, boolean z16);

    void reportQunMiniApp(oidb_0xe83$AppInfo oidb_0xe83_appinfo, String str, String str2);

    void reportTroopFeaturePageImp(String str);

    void setExposureSource(int i3);

    void setRedPointSP(String str);

    void setSpecialCareRingRoamingSetting(AppRuntime appRuntime, int i3);

    void setTroopGeneralSettingRing(AppRuntime appRuntime, int i3);

    void setTroopGeneralSettingVibrate(AppRuntime appRuntime, int i3);

    void setTroopInfoEditRedShow(AppRuntime appRuntime, String str, int i3, boolean z16);

    boolean skipSecurityPush();

    long stringToLong(String str);

    JSONArray toJSONArray(Object obj) throws JSONException;

    void updateRedPoint(boolean z16, TextView textView);

    void updateRedPoint(boolean z16, String str, boolean z17, boolean z18, TextView textView);

    Object wrap(Object obj);
}

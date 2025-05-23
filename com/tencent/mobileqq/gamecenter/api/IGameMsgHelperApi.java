package com.tencent.mobileqq.gamecenter.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GameDetail;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameMsgHelperApi extends QRouteApi {
    public static final String HIPPY_SCHEMA_URL = "mqqapi://hippy/open?bundleName%3DQQGameCenter%26url%3Dhttps%253A%252F%252Fstatic.gamecenter.qq.com%252Fxgame-hippy%252Fdist%252Fhome%252Fandroid%252Fmain.js%253Fpage%253Dmsg%2526isPredrawWhenClosed%253Dtrue%2526isAnimated%253Dtrue%2526isTrasparent%253Dfalse%2526isStatusBarDarkFont%253Dtrue%2526version%253D1%2526src_type%253Dweb%2526adtag%253DlockScreen";
    public static final String HIPPY_URL = "https://speed.gamecenter.qq.com/pushgame/v1/home-spa/msg?_wv=18950115&_wwv=393&page=msg&adtag=";
    public static final String PREFIX = "[\u6e38\u620f\u597d\u53cb]";
    public static final String SESSION_SETTING_URL = "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
    public static final String SESSION_URL = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
    public static final String SP_KEY_AIO_GAME_ENTRY_SHOWN = "sp_aio_game_entry_shown";
    public static final String SP_KEY_CLEAN_TIME = "sp_top_clean_time";
    public static final String SP_KEY_GAME_MSG_UNREAD_COUNT = "game_msg_unread_count";
    public static final String SP_KEY_GAME_SESSION_SHOWN = "sp_game_session_shown";
    public static final String SP_KEY_LAST_GAME_SESSION_CLICKED = "sp_last_game_session_clicked";
    public static final String SP_KEY_TOP_TIME = "sp_top_last_time";
    public static final String[] S_EMOJI_LIST = {"\u1f579", "\u1f3ae", "\u1f50a", "\u1f509", "\u1f508", "\u1f4e2", "\u2709", "\u1f4e8", "\u1f4e7", "\u1f4e9", "\u1f48c", "\u1f4ea", "\u1f4eb", "\u1f4ec", "\u1f4ee", "\u1f388", "\u1f4cd"};
    public static final int TYPE_FROM_CLICK_ENTER_AIO = 1;
    public static final int TYPE_FROM_LS_ARRIVAL = 10006;
    public static final int TYPE_FROM_LS_CLICK = 10004;
    public static final int TYPE_FROM_LS_EXPOSURE = 10005;
    public static final int TYPE_FROM_MSG_TAB_ARRIVAL = 10003;
    public static final int TYPE_FROM_MSG_TAB_CLICK = 10001;
    public static final int TYPE_FROM_MSG_TAB_EXPOSURE = 10002;

    boolean checkMesssageIsValid(MessageRecord messageRecord);

    e createGameMsgBoxHeaderManager(Context context);

    Dialog createProfileGuideDailg(Context context, String str);

    void delGameSession(String str);

    void destroyGamePriorityView();

    @Deprecated
    void enterGameMsgChatPie(Context context, String str, String str2, String str3, int i3);

    void enterGameMsgChatPie(AppInterface appInterface, Context context, String str);

    void enterGameMsgChatPie(AppInterface appInterface, Context context, String str, int i3);

    boolean getAIOGameEntryShown(String str);

    List<GameMsgMgrSvr$GameDetail> getGameListOfMsgBox();

    Drawable getGameMsgAvatarDrawable(AppInterface appInterface, String str);

    Bitmap getGameRoleBitmap(Message message, AppInterface appInterface);

    Bitmap getGameRoleBitmapNt(RecentContactInfo recentContactInfo, AppInterface appInterface);

    String getGameRoleNickName(MessageRecord messageRecord, AppInterface appInterface);

    String getGameRoleNickName(String str, AppInterface appInterface);

    String getGameRoleNickNameNt(RecentContactInfo recentContactInfo, AppInterface appInterface);

    boolean getGameSessionShown(String str);

    URLDrawable getGameUsrDrawable(Context context, AppInterface appInterface, String str);

    @Deprecated
    MessageRecord getLastGameMsg(AppRuntime appRuntime, String str);

    long getLastGameSessionClicked(String str);

    long getLastTopReqMsgTime(AppInterface appInterface);

    CharSequence getMsgDescp(AppInterface appInterface, RecentBaseData recentBaseData, CharSequence charSequence);

    String getMsgDescp(AppInterface appInterface, MessageRecord messageRecord, CharSequence charSequence);

    String getMsgDescpNt(AppInterface appInterface, RecentContactInfo recentContactInfo, CharSequence charSequence);

    String getNetWorkTypeStr();

    @Deprecated
    Drawable getRecentGameMsgDrawable(AppInterface appInterface, String str);

    String getTimeString(long j3);

    String getUnreadStr(int i3);

    boolean handleGameMsgRecentUserSummery(AppInterface appInterface, Message message, int i3, MsgSummary msgSummary);

    boolean isFastClick(@NonNull String str);

    boolean isIgnoreGameMsg(AppInterface appInterface, int i3);

    boolean isPubAccountReceiveMsg(AppInterface appInterface);

    boolean isShowMsg(AppInterface appInterface, String str);

    boolean isToday(long j3);

    void notifyC2COrGroupAIODestroy();

    void openGameMsgSessionPage(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str);

    void openGameMsgSessionPageFromToolProcess(Context context, GameCenterSessionInfo gameCenterSessionInfo, String str, String str2);

    void openGameMsgSettingPage(Context context, String str);

    void report(int i3, int i16);

    void report(AppInterface appInterface, String str, int i3, int i16);

    void reportClickMsgBoxEntry883(long j3);

    void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12);

    void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14);

    void reportForGameMsg(String str, String str2, String str3, String str4, String str5, String str6, String str7, HashMap<String, String> hashMap);

    void reportForGameMsg865WithTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    void reportForGameMsg865WithTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    void reportForGameMsgInSubThread(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void reportForGameMsgNew(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map);

    void requestGameListOfMsgBox();

    void setAIOGameEntryShown(String str, boolean z16);

    void setGameSessionShown(String str, boolean z16);

    void setLastCleanReqMsgTime(String str, long j3);

    void setLastGameSessionClicked(String str, long j3);

    void showGamePriorityView(gd1.a aVar, Activity activity, ArrayList<com.tencent.mobileqq.gamecenter.data.g> arrayList, String str, String str2);

    void startGame(Context context, String str, gd1.a aVar);
}

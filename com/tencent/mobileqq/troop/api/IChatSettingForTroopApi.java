package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.k;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface IChatSettingForTroopApi extends QRouteApi {
    public static final int APPID_EC_WINDOW = 102061052;
    public static final int APPID_HW_CLOCKIN = 102083361;
    public static final int APPID_HW_NOTICE = 102075478;
    public static final int APPID_MULTI_TROOP_MANAGE = 1109863013;
    public static final int APPID_TEACHERMESSAGE = 101847770;
    public static final int APPID_TOGETHEHIGH = 101872203;
    public static final int APPID_TOGETHERLISTEN = 101761547;
    public static final int APPID_TOGETHERSING = 101817424;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;
    }

    void StoryReportor(Activity activity);

    void StoryReportorReportEvent(String str, String str2, int i3, int i16, String... strArr);

    void TroopNameEntry(Object obj, Activity activity, boolean z16, int i3, int i16);

    Object actionSheetHelperCreateDialog(Context context, View view);

    void addRecentTroopItemIntoRecentMsgList(AppRuntime appRuntime, String str);

    boolean appOnClick_Special(AppRuntime appRuntime, Activity activity, long j3, Object obj, Object obj2);

    void bnrReport(AppInterface appInterface, int i3);

    boolean canShowAppShortCutBar(AppRuntime appRuntime, String str, Boolean bool, int i3);

    void clearTroopAssistTipTime(AppRuntime appRuntime, String str);

    Dialog createQuestionDialog(Context context);

    Intent getChatActivityIntent(Activity activity);

    Intent getJumpActionIntent(Activity activity);

    void getOpenID(AppInterface appInterface, String str);

    String getQzoneHelperQunPhotoDataHasChange();

    void getReportMsgIfNull(@Nullable String str, String str2, String str3, int i3, @Nullable Bundle bundle, Function1<String, Unit> function1);

    SpannableString getSpannableStringFromColorNickText(CharSequence charSequence, int i3);

    Intent getSplashActivityIntent(Activity activity);

    Object getStrOpenIDFromCacheAndDB(AppInterface appInterface, String str);

    Intent getTroopNameEntryIntentForFragment(Object obj, Activity activity, boolean z16, int i3, int i16);

    Bundle getTroopProfileExtra(String str, int i3);

    Intent getTroopTagViewIntent(Activity activity);

    String getUrlFromIndividuationUrlHelper_entryEffect();

    String getUrlFromIndividuationUrlHelper_keyWord();

    void gotoSettingOrShare(Activity activity);

    void handleARKAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent);

    void handleAppClick1101236949(Object obj, Activity activity);

    void handleAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent);

    void handleTroopAppManageShortcutBar(AppRuntime appRuntime, String str, Object obj);

    boolean hasKeywords(String str);

    void hiddenChatShowGuideDialog(AppRuntime appRuntime, Activity activity);

    void hideJuhua(Object obj, String str);

    void initKeyword(AppRuntime appRuntime, String str, boolean z16, Object obj);

    void initTroopShareUtility(Activity activity, QBaseFragment qBaseFragment, Object obj, AppRuntime appRuntime, Bundle bundle);

    void initTroopShareUtility(Activity activity, Object obj, AppRuntime appRuntime);

    void inviteMember(Activity activity, String str, boolean z16, ArrayList<String> arrayList, int i3);

    boolean isGrayTroopForTroopAssociations(String str, int i3, long j3);

    boolean isGroupEntranceSwitchOn();

    boolean isShowingAppShortCutBar(AppRuntime appRuntime, String str);

    void jump2PayJoinTroopWeb(Context context, String str, String str2);

    boolean keyWordIsEnable();

    void launcherTroopShortcutFragment(Activity activity, String str);

    void markNewMemberIndexAndUinDailyFromPush(String str, String str2);

    void messageNotificationSettingFragmentLaunch(Activity activity, Intent intent);

    boolean needAnswerQuestion(String str);

    void newReportTask(AppRuntime appRuntime, String str, int i3);

    void newTroopShareUtility(Activity activity, Object obj);

    void notifyTroopMaskChanged(String str, GroupMsgMask groupMsgMask);

    void openAddTroopWeb(Activity activity, String str, String str2);

    void openTroopAssociationWebPage(Context context, String str);

    void openTroopInfoActivity(Context context, Bundle bundle, int i3);

    void openTroopManageForResult(Activity activity, Intent intent, boolean z16, int i3);

    void openTroopmemberCard(AppRuntime appRuntime, Context context, String str, String str2, int i3, int i16, Bundle bundle);

    void preDownloadRing(int i3);

    void preloadQunAlbum(AppRuntime appRuntime, String str);

    void queryKeywordEntryStatus(AppRuntime appRuntime, String str, a aVar);

    void refreshAppShortCutBarAppList(AppRuntime appRuntime, String str, int i3);

    void reportClockTroopAppShowOrClick(Object obj, boolean z16);

    void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7);

    void reportDC00087(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6);

    void requestForPubAccountInfo(AppRuntime appRuntime, long j3, int i3, Handler handler);

    void sendBroadcastQunMsgUnreadCount(Activity activity, int i3);

    void setAppIcon(Context context, ImageView imageView, String str, float f16, boolean z16);

    void setAppShortCutBarSwitch(AppRuntime appRuntime, String str, int i3, boolean z16);

    void setBooleanForQVipConfigManager_keyWordGuideClicked(AppRuntime appRuntime);

    void setColorText(TextView textView, Spannable spannable, int i3);

    void setColorText(AppRuntime appRuntime, TextView textView, Spannable spannable);

    void setStringForQVipConfigManager_keyWordExpireList(AppRuntime appRuntime, String str, String str2);

    void startActivityForTroop(Activity activity, String str, int i3);

    void startChatBackgroundSettingActivity(Activity activity, AppRuntime appRuntime, String str, int i3);

    void startFansTroopIdolPage(Context context, String str, int i3, int i16);

    void startFansTroopIdolRank(Context context, String str, int i3);

    void startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2);

    Intent startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    void startJumpAccountLogin(Activity activity, Object obj);

    void startModifyHomeworkTroopNickname(Context context, String str, String str2, String str3);

    void startModifyLocationActivityForResult(Activity activity, String str, String str2, int i3);

    void startTroop2DCode();

    void startTroopMemberCard(Activity activity, AppRuntime appRuntime, k kVar, int i3);

    void startTroopRemarkActivity(Activity activity, String str, String str2, String str3, String str4, int i3);

    boolean troopNoticeFreezed(Activity activity, Object obj);

    void troopShareUtilityDestroy();

    void updateEntryItem(AppRuntime appRuntime, View view, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z16, String str, String str2);

    void updateHiddenChat(AppRuntime appRuntime, Object obj);

    void updateTroopMemberCard(String str, String str2, MessageMicro messageMicro);
}

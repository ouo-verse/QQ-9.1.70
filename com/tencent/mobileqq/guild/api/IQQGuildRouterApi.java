package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.u;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.quickshare.ShareParam;
import com.tencent.mobileqq.guild.share.GuildMiniAppShareData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import vh2.v;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGuildRouterApi extends QRouteApi {
    public static final String SELECT_MEMBER_LIST = "select_member_list";
    public static final String SELECT_MEMBER_NAME_LIST = "select_member_name_list";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface ChannelFilterResultCallback {
        void onChannelFilterCancel();

        void onChannelFilterSuccess(List<String> list, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface MiniAppJoinGuildDialogCallback {
        void onGuildCardClick();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface OnGuildPicShareFinish {
        void onFinished(int i3);
    }

    void addGuildByAuthSig(Context context, String str, String str2, int i3);

    void addGuildByParam(Context context, JumpGuildParam jumpGuildParam, String str, Runnable runnable);

    void addGuildByShareUrl(Context context, String str);

    void createBoardChannel(FragmentManager fragmentManager, String str, String str2, long j3);

    void createLiveChannel(FragmentManager fragmentManager, String str, String str2, long j3);

    void createTextChannel(FragmentManager fragmentManager, String str, String str2, String str3, long j3);

    void createVoiceChannel(FragmentManager fragmentManager, String str, String str2, long j3);

    void forceFetchGuildInfo(String str, v vVar);

    int getChannelEnterSource();

    @Nullable
    Bundle getExtrasForQQBrowserActivity(String str);

    JumpGuildParam.JoinInfoParam getJoinParamFromInAioIntent(Intent intent);

    u getMediaChannelSelfUserInfo();

    u getMediaChannelUserInfo(String str);

    Class getQQGuildSelectChannelFragmentClass();

    GuildAppReportSourceInfo getReportSourceInfoFromInAioIntent(Intent intent);

    Intent getScheduleChannelIntent(Context context, LaunchGuildChatPieParam launchGuildChatPieParam);

    String getSourceGuildId(Intent intent);

    boolean hasGuildInfoCache(String str);

    boolean isChannelExist(String str);

    boolean isChannelGray(String str);

    boolean isGuest(String str);

    boolean isGuildShareUrl(String str);

    boolean isGuildShortUrl(String str);

    boolean isShowGuildTab();

    boolean isShowGuildTabCached();

    void jumpDirectMsgAio(Context context, Bundle bundle);

    void jumpGuildByBusinessType(Context context, String str, String str2, String str3, int i3, Bundle bundle);

    void jumpGuildFormSearch(String str, String str2, int i3, @Nullable Bundle bundle);

    void jumpGuildOnFullStandalone(Context context, JumpGuildParam jumpGuildParam);

    void onRecallMsg(GuildSpeakParamsInfo guildSpeakParamsInfo, String str, String str2, int i3);

    void openChannelSharePanel(Activity activity, GuildMiniAppShareData guildMiniAppShareData);

    void openChannelSharePanel(Activity activity, GuildMiniAppShareData guildMiniAppShareData, ActionSheet.OnDismissListener onDismissListener);

    void openChannelSharePanel(Activity activity, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, GuildSharePageSource guildSharePageSource);

    void openClientManagePage(Context context, String str, String str2);

    void openCreateGuildChannel(Context context, AppInterface appInterface, String str, String str2, String str3, long j3);

    void openCreateGuildChannelByFragmentManager(FragmentManager fragmentManager, String str, String str2, long j3);

    void openGuildChannelCreateCategorySetting(Context context, AppInterface appInterface, String str, int i3);

    void openGuildChannelDetailFragment(AppInterface appInterface, Context context, String str, String str2, int i3);

    void openGuildChannelInfoSetting(AppInterface appInterface, Context context, String str, String str2, int i3);

    void openGuildChannelListSetting(Context context, String str, int i3);

    void openGuildChannelManage(Context context, String str, int i3);

    void openGuildChannelModifyCategorySetting(Context context, AppInterface appInterface, String str, String str2, long j3);

    Fragment openGuildChatPieMenuDialog(com.tencent.mobileqq.guild.emoj.b bVar, AppRuntime appRuntime, QBaseActivity qBaseActivity, com.tencent.mobileqq.utils.dialogutils.a aVar, ChatMessage chatMessage, wt1.g gVar, com.tencent.mobileqq.guild.emoj.f fVar);

    void openGuildClientListSettingFragment(Activity activity, @NonNull String str, @NonNull String str2);

    void openGuildDirectMessageDetailFragment(Context context, String str, String str2, String str3, String str4, int i3, boolean z16);

    void openGuildEmojiDetailDialog(Activity activity, GuildEmojiDetailsData guildEmojiDetailsData);

    void openGuildFoundAndJoinSetting(Context context, String str, boolean z16);

    void openGuildInTab(Context context, String str, String str2, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo);

    void openGuildInfoSetting(Context context, IGProGuildInfo iGProGuildInfo, int i3, int i16);

    void openGuildJoinQuestionAnswer(Context context, String str, GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion, int i3);

    void openGuildJoinSetting(Context context, String str);

    void openGuildJoinTest(Context context, String str, GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion, int i3);

    void openGuildMediaChannelDetailFragment(AppInterface appInterface, Context context, String str, String str2, int i3);

    void openGuildMediaThirdAppProfileCard(Activity activity, String str, String str2, String str3);

    void openGuildProfile(Context context, String str, String str2, int i3);

    void openGuildProfileDialog(Activity activity, GuildProfileData guildProfileData);

    void openGuildQuickShareDialog(FragmentManager fragmentManager, ShareParam shareParam);

    void openGuildThirdAppSetting(Context context, String str);

    void openGuildUserProfile(Context context, String str, String str2, int i3, int i16);

    void openJoinGuildDialogFromMiniApp(GuildMiniAppShareData guildMiniAppShareData, MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback);

    void openMuteAllSetting(Activity activity, String str);

    void openMuteUserSetting(Activity activity, String str, String str2, String str3, int i3);

    void openPrivateLetterThresholdManageFragment(Context context, String str);

    void openQQGuildRoleGroupDetailFragment(String str, int i3, String str2, int i16);

    Fragment openQQGuildSelectChannelDialogFragment(FragmentActivity fragmentActivity, @NonNull String str, vy1.a aVar);

    void openResendDialog(FragmentActivity fragmentActivity, String str, View.OnClickListener onClickListener);

    void openRobotCommonGuildFragment(Activity activity, String str, String str2, String str3, String str4, int i3, int i16);

    void openRobotExplorationDialog(FragmentActivity fragmentActivity, String str);

    void openRobotList(Activity activity, String str);

    void openRobotList(Activity activity, String str, ArrayList<String> arrayList);

    void openRobotListAndOpenRobotProfileByRobotUin(Activity activity, String str, String str2);

    void openRobotProfileCard(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z16);

    void openSingleMemberExcludeSelfSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3);

    void openSingleMemberSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3);

    void openSingleMemberSelector(Activity activity, AppInterface appInterface, String str, String str2, int i3, ts.a aVar, ActivityResultCallback<ActivityResult> activityResultCallback);

    void openSingleMemberSelectorForAudioLiveOnline(QBaseFragment qBaseFragment, String str, String str2, List<RoleGroupUserUIData> list, int i3);

    void openSpeakRuleManageSetting(Context context, String str);

    void openSpeakRuleSetting(Context context, String str);

    void openSpeakingThresholdManageFragment(Context context, String str);

    void openStandaloneFacadeDialog(Context context, String str, String str2);

    void openStandaloneFacadeDialog(Context context, String str, String str2, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo);

    void openStandaloneFacadeDialog(Context context, String str, String str2, JumpGuildParam.JoinInfoParam joinInfoParam, GuildAppReportSourceInfo guildAppReportSourceInfo, String str3);

    void savePendingJumpChannel(String str, int i3);

    void setChannelEnterSource(int i3);

    void setGuildPginSource(String str);

    void setShowGuildTab(boolean z16);

    boolean shouldInterceptQQBrowserDelegationActivity(Activity activity, String str, Intent intent);

    boolean showNavigateTitle(String str);

    void showSharePicActionSheet(Activity activity, Bitmap bitmap, String str, GuildSharePageSource guildSharePageSource, String str2, String str3, OnGuildPicShareFinish onGuildPicShareFinish);

    Pair<String, Integer> takePendingJumpChannel();

    int tryGetJumpChannelStatusCode(QPublicBaseFragment qPublicBaseFragment);

    void updateGuildTabStatus();
}

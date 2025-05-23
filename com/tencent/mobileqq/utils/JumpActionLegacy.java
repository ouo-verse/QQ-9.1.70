package com.tencent.mobileqq.utils;

import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.o;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopFragment;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.ReportHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.parse.JumpParseConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.business.OpenSdkD55Processor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PushBannerReportLog;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameShareLinkReporter;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.haoliyou.util.JumpIntentCheckHelper;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgCenterSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqecommerce.biz.router.api.IECommerceJumpAction;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqnews.api.IQQNewsCommApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.recommend.api.ITroopFindNewEntranceApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.report.OpenSdkShareReporterProxy;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.b;
import com.tencent.open.agent.report.c;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianWebViewFragment;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.Pair;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.xweb.FileReaderHelper;
import com.tenpay.sdk.Cgi;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class JumpActionLegacy extends ax {
    private static final boolean Y = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("parse_qzone_schema_param_no_url_decode", true);
    private static final String[] Z = {"com.tencent.mobileqq"};
    public final QQAppInterface Q;
    public p R;
    public QQProgressDialog S;
    private q T;
    private com.tencent.mobileqq.app.cl U;
    private Dialog V;
    com.tencent.qidian.controller.a W;
    public ChatActivityUtils.u X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (JumpActionLegacy.this.V != null && JumpActionLegacy.this.V.isShowing()) {
                JumpActionLegacy.this.V.dismiss();
            }
            JumpActionLegacy.this.Q3();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (JumpActionLegacy.this.V != null && JumpActionLegacy.this.V.isShowing()) {
                JumpActionLegacy.this.V.dismiss();
            }
            ((QBaseActivity) JumpActionLegacy.this.f307437b).finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c extends com.tencent.qidian.controller.a {
        c() {
        }

        @Override // com.tencent.qidian.controller.a
        protected void a(boolean z16, HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                return;
            }
            Object obj = hashMap.get("ranKey");
            if (obj != null && this.f342853d != ((Integer) obj).intValue()) {
                return;
            }
            JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
            jumpActionLegacy.Q.removeObserver(jumpActionLegacy.W);
            if (z16) {
                String str = (String) hashMap.get("key_ext_uin");
                String str2 = (String) hashMap.get("key_sigt");
                String str3 = (String) hashMap.get("key_return_root");
                Intent intent = new Intent();
                if (!TextUtils.isEmpty(str3) && !str3.equals("NO")) {
                    intent.setComponent(SplashActivity.getAliasComponent(JumpActionLegacy.this.f307437b));
                    intent.putExtra("open_chatfragment", true);
                } else {
                    intent.setComponent(new ComponentName(JumpActionLegacy.this.f307437b, (Class<?>) ChatActivity.class));
                }
                intent.addFlags(67108864);
                int intValue = ((Integer) hashMap.get("key_aio_type")).intValue();
                if (str != null) {
                    if (str2 != null) {
                        intent.putExtra("sigt", HexUtil.hexStr2Bytes(str2));
                    }
                    if (intValue == 1) {
                        if (o(str)) {
                            intent.putExtra("uintype", 0);
                            intent.putExtra("uinname", ac.G(JumpActionLegacy.this.Q, str));
                            if (QLog.isColorLevel()) {
                                QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_FRIEND");
                            }
                        } else {
                            intent.putExtra("uintype", 1025);
                            intent.putExtra(AppConstants.Key.KEY_FROM_WPA_FOR_CRM, true);
                            if (QLog.isColorLevel()) {
                                QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
                            }
                        }
                    } else {
                        intent.putExtra("uintype", 1024);
                        intent.putExtra("chat_subType", 1);
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_MASTER");
                        }
                    }
                    intent.putExtra("uin", str);
                    JumpActionLegacy.this.f307437b.startActivity(intent);
                }
            }
        }

        @Override // com.tencent.qidian.controller.a
        protected void c(boolean z16, HashMap<String, Object> hashMap) {
            int i3;
            JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
            jumpActionLegacy.Q.removeObserver(jumpActionLegacy.W);
            if (hashMap != null) {
                if (z16) {
                    i3 = ((Integer) hashMap.get("key_aio_type")).intValue();
                } else {
                    i3 = 2;
                }
                String str = (String) hashMap.get("key_sigt");
                String str2 = (String) hashMap.get("uin");
                String str3 = (String) hashMap.get("key_return_root");
                Intent intent = new Intent();
                if (!TextUtils.isEmpty(str3) && !str3.equals("NO")) {
                    intent.setComponent(SplashActivity.getAliasComponent(JumpActionLegacy.this.f307437b));
                    intent.putExtra("open_chatfragment", true);
                } else {
                    intent.setComponent(new ComponentName(JumpActionLegacy.this.f307437b, (Class<?>) ChatActivity.class));
                }
                intent.addFlags(67108864);
                if (str != null && str2 != null) {
                    intent.putExtra("sigt", HexUtil.hexStr2Bytes(str));
                }
                intent.putExtra("key_peerId", ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2));
                intent.putExtra("key_peerUin", Long.valueOf(str2));
                if (i3 == 1) {
                    if (o(str2)) {
                        intent.putExtra("uintype", 0);
                        intent.putExtra("uinname", ac.G(JumpActionLegacy.this.Q, str2));
                        intent.putExtra(AppConstants.Key.QIDIAN_IS_FRIEND, true);
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_FRIEND");
                        }
                    } else {
                        intent.putExtra("uintype", 1025);
                        intent.putExtra(AppConstants.Key.KEY_FROM_WPA_FOR_CRM, true);
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
                        }
                    }
                } else {
                    intent.putExtra("uintype", 1024);
                    if (o(str2)) {
                        intent.putExtra("uinname", ac.G(JumpActionLegacy.this.Q, str2));
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "onCorpUinWpaReport !AIO_TYPE_EXT UIN_TYPE_FRIEND");
                        }
                        intent.putExtra(AppConstants.Key.QIDIAN_IS_FRIEND, true);
                    } else {
                        intent.putExtra("chat_subType", 1);
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_MASTER");
                        }
                    }
                }
                intent.putExtra(AppConstants.Key.QIDIAN_TYPE, 16);
                intent.putExtra("uin", str2);
                JumpActionLegacy.this.f307437b.startActivity(intent);
            }
        }

        @Override // com.tencent.qidian.controller.a
        protected void d(boolean z16, HashMap<String, Object> hashMap) {
            JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
            jumpActionLegacy.Q.removeObserver(jumpActionLegacy.W);
            if (z16 && hashMap != null) {
                JumpActionLegacy.this.f307441f.put("uin", (String) hashMap.get("cipher_text"));
                if (JumpActionLegacy.this.f307441f.containsKey("isPrivate")) {
                    JumpActionLegacy.this.f307441f.remove("isPrivate");
                }
                JumpActionLegacy.this.t2();
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.h1y), 0).show();
        }

        boolean o(String str) {
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "JumpAction.QidianBusinessObserver");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f306993d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f306994e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f306995f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f306996h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f306997i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f306998m;

        d(String str, String str2, String str3, String str4, String str5, String str6) {
            this.f306993d = str;
            this.f306994e = str2;
            this.f306995f = str3;
            this.f306996h = str4;
            this.f306997i = str5;
            this.f306998m = str6;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_CONNECT_MINI_D55", z16);
            JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
            if (jumpActionLegacy.G) {
                jumpActionLegacy.G = false;
                jumpActionLegacy.s3();
            }
            JumpActionLegacy jumpActionLegacy2 = JumpActionLegacy.this;
            if (jumpActionLegacy2.F) {
                QQToast.makeText(jumpActionLegacy2.f307437b, 1, R.string.izn, 1).show();
                Intent aliasIntent = SplashActivity.getAliasIntent(JumpActionLegacy.this.f307437b);
                aliasIntent.addFlags(67108864);
                aliasIntent.addFlags(268435456);
                JumpActionLegacy.this.f307437b.startActivity(aliasIntent);
                JumpActionLegacy.this.x0();
                return;
            }
            Handler handler = jumpActionLegacy2.E;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Intent L3 = JumpActionLegacy.this.L3();
            if (i3 == 0) {
                ReportController.o(JumpActionLegacy.this.Q, "dc01160", "", "", ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_SUCCESS, ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_SUCCESS, 0, 0, "", "", this.f306993d, this.f306994e);
                L3.putExtra("mini_app_id", this.f306994e);
                L3.putExtra(AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH, this.f306995f);
                L3.putExtra(AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE, this.f306996h);
            } else if (i3 == 25501) {
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "Account not the same");
                }
                ReportController.o(JumpActionLegacy.this.Q, "dc01160", "", "", ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_SUCCESS, ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_SUCCESS, 0, 0, "", "", this.f306993d, this.f306994e);
                L3.putExtra("mini_app_id", this.f306994e);
                L3.putExtra(AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH, this.f306995f);
                L3.putExtra(AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE, this.f306996h);
                L3.putExtra("openid", this.f306997i);
                L3.putExtra("appid", this.f306993d);
                L3.putExtra(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN, true);
            } else {
                String sSOErrorStringWithData = ForwardMiniAppThirdPartyHelper.getSSOErrorStringWithData(bArr);
                ReportController.o(JumpActionLegacy.this.Q, "dc01160", "", "", ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_FAIL, ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_FAIL, 0, i3, "", "", this.f306993d, this.f306994e);
                if (i3 == 25601) {
                    L3.putExtra(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_NOT_BIND, true);
                    L3.putExtra(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_NOT_BIND_APP_NAME, this.f306998m);
                }
                L3.putExtra(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE, true);
                L3.putExtra(AppConstants.Key.PULL_MINI_APP_NOT_PRIVILEGE_STRING, sSOErrorStringWithData);
            }
            JumpActionLegacy.this.f307437b.startActivity(L3);
            JumpActionLegacy.this.x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f306999d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307000e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f307001f;

        e(String str, String str2, String str3) {
            this.f306999d = str;
            this.f307000e = str2;
            this.f307001f = str3;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            char c16;
            boolean z17;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_GO_TO_CHAT_D55", z16);
            JumpActionLegacy.this.s3();
            JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
            if (jumpActionLegacy.F) {
                ReportController.o(jumpActionLegacy.Q, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", jumpActionLegacy.f307437b.getString(R.string.izn), "");
                QQToast.makeText(JumpActionLegacy.this.f307437b, 1, R.string.izn, 1).show();
                Intent aliasIntent = SplashActivity.getAliasIntent(JumpActionLegacy.this.f307437b);
                aliasIntent.addFlags(67108864);
                aliasIntent.addFlags(268435456);
                JumpActionLegacy.this.f307437b.startActivity(aliasIntent);
                JumpActionLegacy.this.x0();
                return;
            }
            Handler handler = jumpActionLegacy.E;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (i3 == 0) {
                c16 = 0;
            } else if (i3 == 25501) {
                c16 = 1;
            } else {
                c16 = 2;
            }
            if (c16 <= 1) {
                String str = JumpActionLegacy.this.f307441f.get("uin");
                if (str != null && str.length() >= 5 && !SearchBaseActivity.f180756o0.matcher(str).matches()) {
                    boolean c06 = ((FriendsManager) JumpActionLegacy.this.Q.getManager(QQManagerFactory.FRIENDS_MANAGER)).c0(str);
                    String F = ac.F(JumpActionLegacy.this.Q, str);
                    if (c06 && c16 == 0) {
                        Intent aliasIntent2 = SplashActivity.getAliasIntent(JumpActionLegacy.this.f307437b);
                        aliasIntent2.putExtra("uin", str);
                        aliasIntent2.putExtra("uintype", 0);
                        aliasIntent2.putExtra("openid", this.f306999d);
                        aliasIntent2.putExtra("appid", this.f307000e);
                        aliasIntent2.putExtra(AppConstants.Key.THRIPARTY_PULL_AIO, true);
                        Intent m3 = BaseAIOUtils.m(aliasIntent2, new int[]{2});
                        m3.putExtra(AppConstants.Key.PULL_AIO_AUDIO, this.f307001f.equals("audio_chat"));
                        m3.putExtra(AppConstants.Key.PULL_AIO_VIDEO, this.f307001f.equals("video_chat"));
                        if (F != null) {
                            m3.putExtra("uinname", F);
                        }
                        JumpActionLegacy.this.f307437b.startActivity(m3);
                    } else {
                        if (c16 == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean(AppConstants.Key.PULL_SHOULD_SHOW_OPEN_ID_DIFF_MAIN, z17);
                        bundle2.putString("uin", str);
                        bundle2.putInt("uintype", 0);
                        if (F != null) {
                            bundle2.putString("uinname", F);
                        }
                        bundle2.putString("openid", this.f306999d);
                        bundle2.putString("appid", this.f307000e);
                        ReportController.o(JumpActionLegacy.this.Q, "dc01160", "", "", "0X800A40F", "0X800A40F", 0, 0, "", "", "", "");
                        if (c06) {
                            bundle2.putBoolean(AppConstants.Key.THRIPARTY_PULL_AIO, true);
                            bundle2.putBoolean(AppConstants.Key.PULL_AIO_AUDIO, this.f307001f.equals("audio_chat"));
                            bundle2.putBoolean(AppConstants.Key.PULL_AIO_VIDEO, this.f307001f.equals("video_chat"));
                        } else {
                            bundle2.putInt(SplashActivity.FRAGMENT_ID, 1);
                            bundle2.putBoolean(AppConstants.Key.PULL_ADD_FRIEND_TIP, true);
                        }
                        JumpActionLegacy.this.Z3(bundle2);
                        JumpActionLegacy.this.x0();
                        return;
                    }
                } else {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.izl, 1).show();
                    JumpActionLegacy jumpActionLegacy2 = JumpActionLegacy.this;
                    ReportController.o(jumpActionLegacy2.Q, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", jumpActionLegacy2.f307437b.getString(R.string.izo), "");
                    JumpActionLegacy.this.x0();
                    return;
                }
            } else {
                String sSOErrorStringWithData = ForwardMiniAppThirdPartyHelper.getSSOErrorStringWithData(bArr);
                ReportController.u(JumpActionLegacy.this.Q, "inter", "skip", "inter_fail", "", 1, "", sSOErrorStringWithData, "", "", "", "", "", "", "");
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(AppConstants.Key.PULL_APP_NOT_PRIVILEGE, true);
                bundle3.putString(AppConstants.Key.PULL_APP_NOT_PRIVILEGE_STRING, sSOErrorStringWithData);
                JumpActionLegacy.this.Z3(bundle3);
            }
            JumpActionLegacy.this.x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements o {
        f() {
        }

        @Override // com.tencent.mobileqq.utils.JumpActionLegacy.o
        public boolean callback() {
            return JumpActionLegacy.this.G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g implements DialogInterface.OnDismissListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (JumpActionLegacy.this.B0().getLoginActivityClass().isInstance(JumpActionLegacy.this.f307437b)) {
                ((Activity) JumpActionLegacy.this.f307437b).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h implements DialogInterface.OnDismissListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (JumpActionLegacy.this.B0().getLoginActivityClass().isInstance(JumpActionLegacy.this.f307437b)) {
                ((Activity) JumpActionLegacy.this.f307437b).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class j implements o.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlessManager f307007a;

        j(BlessManager blessManager) {
            this.f307007a = blessManager;
        }

        @Override // com.tencent.mobileqq.activity.bless.o.a
        public void a() {
            QQToast.makeText(JumpActionLegacy.this.f307437b, 0, HardCodeUtil.qqStr(R.string.niy), 0).show();
        }

        @Override // com.tencent.mobileqq.activity.bless.o.a
        public void b() {
            this.f307007a.B0(JumpActionLegacy.this.f307437b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class k implements o {
        k() {
        }

        @Override // com.tencent.mobileqq.utils.JumpActionLegacy.o
        public boolean callback() {
            return JumpActionLegacy.this.J1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class l implements ArkAppMgr.IGetAppPathByNameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f307010a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f307011b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f307012c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f307013d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307014e;

        l(QQProgressDialog qQProgressDialog, String str, String str2, String str3, String str4) {
            this.f307010a = qQProgressDialog;
            this.f307011b = str;
            this.f307012c = str2;
            this.f307013d = str3;
            this.f307014e = str4;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            String str2;
            boolean z16;
            String str3;
            QQProgressDialog qQProgressDialog = this.f307010a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f307010a.dismiss();
            }
            if (appPathInfo != null && i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", appPathInfo.path);
                }
                String str4 = this.f307011b;
                String str5 = null;
                if (TextUtils.isEmpty(str4)) {
                    String applicationLauncher = ArkAppCacheMgr.getApplicationLauncher(appPathInfo.path);
                    if (!TextUtils.isEmpty(applicationLauncher) && (applicationLauncher.startsWith("http://") || applicationLauncher.startsWith("https://"))) {
                        str5 = applicationLauncher;
                        str2 = str4;
                        z16 = false;
                        str3 = this.f307012c;
                        if (TextUtils.isEmpty(str3)) {
                            str3 = "{}";
                        }
                        String str6 = str3;
                        if (!z16) {
                            com.tencent.mobileqq.ark.g.b(null, this.f307013d, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
                            Context context = JumpActionLegacy.this.f307437b;
                            if (context != null) {
                                ArkFullScreenAppActivity.W2(context, this.f307013d, str2, this.f307014e, Constants.DEFAULT_MIN_APP_VERSION, str6, com.tencent.mobileqq.ark.f.c(), null, 1);
                                return;
                            }
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
                        intent.putExtra("param_force_internal_browser", true);
                        intent.putExtra("url", str5);
                        intent.putExtra("injectrecommend", false);
                        intent.putExtra("browserType", 3);
                        if (!TextUtils.isEmpty(this.f307013d)) {
                            intent.putExtra(AppConstants.Key.H5_ARK_APP_NAME, this.f307013d);
                            intent.putExtra(AppConstants.Key.H5_ARK_BIZ_SRC, this.f307014e);
                            String appPathFromLocal = ArkAppMgr.getInstance().getAppPathFromLocal(this.f307013d, this.f307014e);
                            if (!TextUtils.isEmpty(appPathFromLocal)) {
                                intent.putExtra(AppConstants.Key.H5_ARK_APP_PATH, appPathFromLocal);
                                String applicationDesc = ArkAppCacheMgr.getApplicationDesc(this.f307013d);
                                if (!TextUtils.isEmpty(applicationDesc)) {
                                    intent.putExtra(AppConstants.Key.H5_ARK_APP_DESCRIPTION, applicationDesc);
                                }
                            }
                        }
                        d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
                        if (arkAIKeyWordConfig != null) {
                            String b16 = arkAIKeyWordConfig.b();
                            if (!TextUtils.isEmpty(b16)) {
                                intent.putExtra(AppConstants.Key.H5_ARK_CHECK_CONFIG, b16);
                            }
                        }
                        intent.addFlags(603979776);
                        Context context2 = JumpActionLegacy.this.f307437b;
                        if (context2 != null) {
                            context2.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    str2 = applicationLauncher;
                } else {
                    str2 = str4;
                }
                z16 = true;
                str3 = this.f307012c;
                if (TextUtils.isEmpty(str3)) {
                }
                String str62 = str3;
                if (!z16) {
                }
            } else {
                QQToast.makeText(JumpActionLegacy.this.f307437b, R.string.f170433qp, 0).show();
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class m implements o {
        m() {
        }

        @Override // com.tencent.mobileqq.utils.JumpActionLegacy.o
        public boolean callback() {
            return JumpActionLegacy.this.G2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class n implements IKernelGetUinInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f307017a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f307018b;

        n(String str, String str2) {
            this.f307017a = str;
            this.f307018b = str2;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
        public void onResult(HashMap<String, Long> hashMap) {
            if (hashMap != null && !hashMap.isEmpty()) {
                JumpActionLegacy.this.j3(String.valueOf(hashMap.get(this.f307017a)), this.f307018b);
            } else {
                QLog.e("JumpAction", 1, "handleServerUserProfileAndActionFriend is error! getUinFromUid is invalid!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface o {
        boolean callback();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class p extends com.tencent.mobileqq.avatar.observer.a {

        /* renamed from: d, reason: collision with root package name */
        private final ax f307020d;

        public p(ax axVar) {
            this.f307020d = axVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            Hashtable<String, Long> hashtable;
            if (z16 && (hashtable = JumpActionLegacy.this.f307456u) != null && hashtable.containsKey(str)) {
                JumpActionLegacy.this.f307456u.remove(str);
                if (JumpActionLegacy.this.f307456u.size() == 0) {
                    JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                    jumpActionLegacy.Q.removeObserver(jumpActionLegacy.R);
                }
                JumpActionLegacy.this.f307437b.sendBroadcast(new Intent(JumpActionLegacy.this.f307441f.get("callback_name"), Uri.parse(JumpActionLegacy.this.D0() + "&uin=" + str)), "com.tencent.msg.permission.pushnotify");
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "download head " + str + " success. Send broadcast to " + JumpActionLegacy.this.f307441f.get("callback_name"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class q extends Handler {
        q() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (JumpActionLegacy.this.U != null) {
                JumpActionLegacy.this.U.a();
                JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                jumpActionLegacy.Q.removeObserver(jumpActionLegacy.U);
            }
            if (message.arg1 != 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "msf return error ");
                }
                JumpActionLegacy.this.X3(1);
                return;
            }
            Object obj = message.obj;
            if (obj instanceof RespCheckChangePwdAuth) {
                RespCheckChangePwdAuth respCheckChangePwdAuth = (RespCheckChangePwdAuth) obj;
                if (respCheckChangePwdAuth.retCode == 0) {
                    JumpActionLegacy.this.R3();
                    return;
                } else if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "server return error, errorCode: " + respCheckChangePwdAuth.retCode + " errorMsg: " + respCheckChangePwdAuth.retMsg);
                }
            }
            JumpActionLegacy.this.X3(1);
        }
    }

    public JumpActionLegacy(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        this.R = new p(this);
        this.W = new c();
        this.X = new i();
        this.Q = qQAppInterface;
    }

    private boolean A1() {
        final String str;
        try {
            String str2 = "";
            if (!this.f307441f.containsKey("groupCode")) {
                str = "";
            } else {
                str = this.f307441f.get("groupCode");
            }
            if (this.f307441f.containsKey("groupMemberUin")) {
                str2 = this.f307441f.get("groupMemberUin");
            }
            if ((MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) && this.f307437b != null) {
                final ArrayList arrayList = new ArrayList();
                arrayList.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2));
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(str, str2, "JumpAction", new Function1() { // from class: com.tencent.mobileqq.utils.az
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit H3;
                        H3 = JumpActionLegacy.this.H3(arrayList, str, (TroopMemberNickInfo) obj);
                        return H3;
                    }
                });
                return true;
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("JumpAction", 2, e16.toString());
            }
            return false;
        }
    }

    private boolean A2() {
        int i3;
        String str = this.f307441f.get("uin");
        try {
            i3 = Integer.parseInt(this.f307441f.get("account_flag"));
        } catch (Exception unused) {
            i3 = -1;
        }
        int i16 = i3;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoShowPublicAccountCard uin: " + str + " | accountFlag: " + i16 + " | current uin: " + this.Q.getCurrentAccountUin());
        }
        if (str == null || "".equals(str) || this.Q.getCurrentAccountUin().equals(str) || str.length() < 5) {
            return false;
        }
        if (l()) {
            if (this.f307437b instanceof Activity) {
                new ProfileParams.b().c(new ProfileParams.CurLoginUsr(this.f307441f.get("open_id"), this.f307441f.get("share_uin"))).d(this.f307441f.get("app_name")).e(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH)).g(this.f307441f.get("uin")).b(i16).f(this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE));
                return false;
            }
        } else {
            if (Boolean.valueOf(((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()).booleanValue() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin("JumpAction", Long.parseLong(str)) != null) {
                Intent intent = new Intent();
                intent.putExtra("uin", str);
                intent.putExtra("chatPage", false);
                ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(this.f307437b, intent);
                return true;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("source", 117);
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent2, this.Q, this.f307437b, str, i16);
            ((IPublicAccountHandler) QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.Q, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_5", "addpage_hot");
        }
        return true;
    }

    private boolean A3(@Nullable String str, @Nullable String str2) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102409", false) || TextUtils.isEmpty(str) || !"4".equals(str2)) {
            return false;
        }
        return true;
    }

    private boolean B1(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 13);
        bundle.putString("viewParam", str);
        if (str2 != null) {
            bundle.putString("entry", str2);
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) JumpActivity.class);
        intent.putExtra("srvBundle", bundle);
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + str2));
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean B2() {
        String str = this.f307441f.get("uin");
        if (str != null && !"".equals(str) && str.length() >= 5) {
            Bundle b16 = com.tencent.mobileqq.troop.utils.aq.b(str, 14);
            if (this.f307441f.containsKey("appid")) {
                b16.putString("appid", this.f307441f.get("appid"));
            }
            if (this.f307441f.containsKey("openid")) {
                b16.putString("openid", ax.E(ax.M));
            }
            if (this.f307441f.containsKey("openkey")) {
                b16.putString("openkey", this.f307441f.get("openkey"));
            }
            if (this.f307441f.containsKey("is_from_game")) {
                b16.putString("is_from_game", this.f307441f.get("is_from_game"));
            }
            if (this.f307441f.containsKey("guild_id")) {
                b16.putString("guild_id", this.f307441f.get("guild_id"));
            }
            if (this.f307441f.containsKey("zone_id")) {
                b16.putString("zone_id", this.f307441f.get("zone_id"));
            }
            if (this.f307441f.containsKey("role_id")) {
                b16.putString("role_id", this.f307441f.get("role_id"));
            }
            if (this.f307441f.containsKey("gc")) {
                b16.putString("gc", this.f307441f.get("gc"));
            }
            TroopUtils.I(this.f307437b, b16, 2);
            return true;
        }
        return false;
    }

    private boolean B3() {
        if (this.Q == null) {
            return false;
        }
        Intent intent = new Intent();
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.PAGE_DIALOG);
        intent.addFlags(805306368);
        QZoneHelper.launchQZone((Activity) this.f307437b, this.Q.getCurrentAccountUin(), intent, -1);
        return true;
    }

    private String C0() {
        String str = Build.VERSION.RELEASE;
        String model = DeviceInfoMonitor.getModel();
        String imei = QQDeviceInfo.getIMEI("0db4c4");
        String imsi = QQDeviceInfo.getIMSI("0db4c4");
        Display defaultDisplay = ((Activity) this.f307437b).getWindowManager().getDefaultDisplay();
        int height = defaultDisplay.getHeight();
        return str + "|" + model + "|" + imei + "|" + (defaultDisplay.getWidth() + "*" + height) + "|" + imsi + "|" + this.Q.getAppid() + "|";
    }

    private boolean C1() {
        Intent intent = new Intent(this.f307437b, (Class<?>) ContactBindedActivity.class);
        intent.putExtra(AppConstants.Key.KEY_FROM_BABYQ, true);
        this.f307437b.startActivity(intent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0207 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean C2() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        try {
            str22 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
            try {
                str2 = this.f307441f.get("troopcode");
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                str7 = str22;
                str = "";
                str2 = str;
                str3 = str2;
            } catch (NullPointerException e17) {
                e = e17;
                str7 = str22;
                str = "";
                str2 = str;
                str3 = str2;
            }
        } catch (UnsupportedEncodingException e18) {
            e = e18;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
        } catch (NullPointerException e19) {
            e = e19;
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
        }
        try {
            str3 = this.f307441f.get("uin");
            try {
                str4 = this.f307441f.get("troopuin");
            } catch (UnsupportedEncodingException e26) {
                e = e26;
                str7 = str22;
                str = "";
                str4 = str;
                str5 = str4;
                str6 = str5;
                str8 = str6;
                str9 = str8;
                e.printStackTrace();
                str10 = "email";
                str11 = str4;
                str12 = str5;
                str13 = str9;
                str14 = str2;
                str15 = str;
                str16 = str7;
                str17 = "";
                String str23 = str8;
                str18 = "tel";
                str19 = str6;
                str20 = str3;
                str21 = str23;
                String str24 = str13;
                if (!TextUtils.isEmpty(str20)) {
                }
            } catch (NullPointerException e27) {
                e = e27;
                str7 = str22;
                str = "";
                str4 = str;
                str5 = str4;
                str6 = str5;
                str8 = str6;
                str9 = str8;
                e.printStackTrace();
                str10 = "email";
                str11 = str4;
                str12 = str5;
                str13 = str9;
                str14 = str2;
                str15 = str;
                str16 = str7;
                str17 = "";
                String str232 = str8;
                str18 = "tel";
                str19 = str6;
                str20 = str3;
                str21 = str232;
                String str242 = str13;
                if (!TextUtils.isEmpty(str20)) {
                }
            }
            try {
                str5 = URLDecoder.decode(this.f307441f.get("nick"), "utf-8");
                try {
                    str6 = URLDecoder.decode(this.f307441f.get("sex"), "utf-8");
                    str7 = str22;
                } catch (UnsupportedEncodingException e28) {
                    e = e28;
                    str7 = str22;
                    str = "";
                    str6 = str;
                    str8 = str6;
                    str9 = str8;
                    e.printStackTrace();
                    str10 = "email";
                    str11 = str4;
                    str12 = str5;
                    str13 = str9;
                    str14 = str2;
                    str15 = str;
                    str16 = str7;
                    str17 = "";
                    String str2322 = str8;
                    str18 = "tel";
                    str19 = str6;
                    str20 = str3;
                    str21 = str2322;
                    String str2422 = str13;
                    if (!TextUtils.isEmpty(str20)) {
                    }
                } catch (NullPointerException e29) {
                    e = e29;
                    str7 = str22;
                    str = "";
                    str6 = str;
                    str8 = str6;
                    str9 = str8;
                    e.printStackTrace();
                    str10 = "email";
                    str11 = str4;
                    str12 = str5;
                    str13 = str9;
                    str14 = str2;
                    str15 = str;
                    str16 = str7;
                    str17 = "";
                    String str23222 = str8;
                    str18 = "tel";
                    str19 = str6;
                    str20 = str3;
                    str21 = str23222;
                    String str24222 = str13;
                    if (!TextUtils.isEmpty(str20)) {
                    }
                }
                try {
                    String decode = URLDecoder.decode(this.f307441f.get("troopnick"), "utf-8");
                    try {
                        str8 = URLDecoder.decode(this.f307441f.get("job"), "utf-8");
                        try {
                            str9 = URLDecoder.decode(this.f307441f.get("tel"), "utf-8");
                        } catch (UnsupportedEncodingException e36) {
                            e = e36;
                            str9 = "";
                        } catch (NullPointerException e37) {
                            e = e37;
                            str9 = "";
                        }
                        try {
                            str16 = str7;
                            str17 = URLDecoder.decode(this.f307441f.get("email"), "utf-8");
                            str11 = str4;
                            str13 = str9;
                            str10 = "email";
                            str12 = str5;
                            str14 = str2;
                            str15 = decode;
                            str18 = "tel";
                            str19 = str6;
                            str20 = str3;
                            str21 = str8;
                        } catch (UnsupportedEncodingException e38) {
                            e = e38;
                            str = decode;
                            e.printStackTrace();
                            str10 = "email";
                            str11 = str4;
                            str12 = str5;
                            str13 = str9;
                            str14 = str2;
                            str15 = str;
                            str16 = str7;
                            str17 = "";
                            String str232222 = str8;
                            str18 = "tel";
                            str19 = str6;
                            str20 = str3;
                            str21 = str232222;
                            String str242222 = str13;
                            if (!TextUtils.isEmpty(str20)) {
                            }
                        } catch (NullPointerException e39) {
                            e = e39;
                            str = decode;
                            e.printStackTrace();
                            str10 = "email";
                            str11 = str4;
                            str12 = str5;
                            str13 = str9;
                            str14 = str2;
                            str15 = str;
                            str16 = str7;
                            str17 = "";
                            String str2322222 = str8;
                            str18 = "tel";
                            str19 = str6;
                            str20 = str3;
                            str21 = str2322222;
                            String str2422222 = str13;
                            if (!TextUtils.isEmpty(str20)) {
                            }
                        }
                    } catch (UnsupportedEncodingException e46) {
                        e = e46;
                        str8 = "";
                        str9 = str8;
                    } catch (NullPointerException e47) {
                        e = e47;
                        str8 = "";
                        str9 = str8;
                    }
                } catch (UnsupportedEncodingException e48) {
                    e = e48;
                    str = "";
                    str8 = str;
                    str9 = str8;
                    e.printStackTrace();
                    str10 = "email";
                    str11 = str4;
                    str12 = str5;
                    str13 = str9;
                    str14 = str2;
                    str15 = str;
                    str16 = str7;
                    str17 = "";
                    String str23222222 = str8;
                    str18 = "tel";
                    str19 = str6;
                    str20 = str3;
                    str21 = str23222222;
                    String str24222222 = str13;
                    if (!TextUtils.isEmpty(str20)) {
                    }
                } catch (NullPointerException e49) {
                    e = e49;
                    str = "";
                    str8 = str;
                    str9 = str8;
                    e.printStackTrace();
                    str10 = "email";
                    str11 = str4;
                    str12 = str5;
                    str13 = str9;
                    str14 = str2;
                    str15 = str;
                    str16 = str7;
                    str17 = "";
                    String str232222222 = str8;
                    str18 = "tel";
                    str19 = str6;
                    str20 = str3;
                    str21 = str232222222;
                    String str242222222 = str13;
                    if (!TextUtils.isEmpty(str20)) {
                    }
                }
            } catch (UnsupportedEncodingException e56) {
                e = e56;
                str7 = str22;
                str = "";
                str5 = str;
                str6 = str5;
                str8 = str6;
                str9 = str8;
                e.printStackTrace();
                str10 = "email";
                str11 = str4;
                str12 = str5;
                str13 = str9;
                str14 = str2;
                str15 = str;
                str16 = str7;
                str17 = "";
                String str2322222222 = str8;
                str18 = "tel";
                str19 = str6;
                str20 = str3;
                str21 = str2322222222;
                String str2422222222 = str13;
                if (!TextUtils.isEmpty(str20)) {
                }
            } catch (NullPointerException e57) {
                e = e57;
                str7 = str22;
                str = "";
                str5 = str;
                str6 = str5;
                str8 = str6;
                str9 = str8;
                e.printStackTrace();
                str10 = "email";
                str11 = str4;
                str12 = str5;
                str13 = str9;
                str14 = str2;
                str15 = str;
                str16 = str7;
                str17 = "";
                String str23222222222 = str8;
                str18 = "tel";
                str19 = str6;
                str20 = str3;
                str21 = str23222222222;
                String str24222222222 = str13;
                if (!TextUtils.isEmpty(str20)) {
                }
            }
        } catch (UnsupportedEncodingException e58) {
            e = e58;
            str7 = str22;
            str = "";
            str3 = str;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str8 = str6;
            str9 = str8;
            e.printStackTrace();
            str10 = "email";
            str11 = str4;
            str12 = str5;
            str13 = str9;
            str14 = str2;
            str15 = str;
            str16 = str7;
            str17 = "";
            String str232222222222 = str8;
            str18 = "tel";
            str19 = str6;
            str20 = str3;
            str21 = str232222222222;
            String str242222222222 = str13;
            return !TextUtils.isEmpty(str20) ? false : false;
        } catch (NullPointerException e59) {
            e = e59;
            str7 = str22;
            str = "";
            str3 = str;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str8 = str6;
            str9 = str8;
            e.printStackTrace();
            str10 = "email";
            str11 = str4;
            str12 = str5;
            str13 = str9;
            str14 = str2;
            str15 = str;
            str16 = str7;
            str17 = "";
            String str2322222222222 = str8;
            str18 = "tel";
            str19 = str6;
            str20 = str3;
            str21 = str2322222222222;
            String str2422222222222 = str13;
            if (!TextUtils.isEmpty(str20)) {
            }
        }
        String str24222222222222 = str13;
        if (!TextUtils.isEmpty(str20) && !TextUtils.isEmpty(str14)) {
            if (this.f307437b != null) {
                String str25 = str21;
                Intent intent = new Intent(this.f307437b, ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass());
                intent.putExtra("troopUin", str14);
                intent.putExtra("memberUin", "" + str20);
                if ("web".equals(str16)) {
                    intent.putExtra("fromFlag", 0);
                } else {
                    intent.putExtra("fromFlag", 6);
                }
                Bundle bundle = new Bundle();
                bundle.putString("troopcode", str11);
                bundle.putString("nick", str12);
                bundle.putString("sex", str19);
                bundle.putString("troopnick", str15);
                bundle.putString("job", str25);
                bundle.putString(str18, str24222222222222);
                bundle.putString(str10, str17);
                intent.putExtra("params", bundle);
                this.f307437b.startActivity(intent);
            }
            ReportController.o(this.Q, "CliOper", "", "", "0X8005B36", "0X8005B36", 0, 0, "", "", "", "");
            return true;
        }
    }

    private boolean C3() {
        String str;
        String str2;
        String str3;
        Intent intent;
        com.tencent.mobileqq.intervideo.yiqikan.h hVar = (com.tencent.mobileqq.intervideo.yiqikan.h) this.Q.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
        Context context = this.f307437b;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            str = intent.getDataString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f307438c;
        }
        NewTogetherRoomMessageData newTogetherRoomMessageData = new NewTogetherRoomMessageData();
        String str4 = "0";
        if (!this.f307441f.containsKey("room_type")) {
            str2 = "0";
        } else {
            str2 = this.f307441f.get("room_type");
        }
        newTogetherRoomMessageData.f238446f = Integer.parseInt(str2);
        if (!this.f307441f.containsKey("group_uin")) {
            str3 = "0";
        } else {
            str3 = this.f307441f.get("group_uin");
        }
        newTogetherRoomMessageData.f238444d = str3;
        if (this.f307441f.containsKey("group_owner_uin")) {
            str4 = this.f307441f.get("group_owner_uin");
        }
        newTogetherRoomMessageData.f238445e = str4;
        newTogetherRoomMessageData.F = str;
        newTogetherRoomMessageData.G = this.f307441f.get("cover_url");
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("roomid");
        String queryParameter2 = parse.getQueryParameter("room_show_number");
        String queryParameter3 = parse.getQueryParameter("fromid");
        String queryParameter4 = parse.getQueryParameter("room_group_code");
        if (!TextUtils.isEmpty(queryParameter)) {
            newTogetherRoomMessageData.f238447h = Integer.parseInt(queryParameter);
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            newTogetherRoomMessageData.f238448i = Integer.parseInt(queryParameter2);
        }
        if (!TextUtils.isEmpty(queryParameter3)) {
            newTogetherRoomMessageData.H = queryParameter3;
        }
        if (!TextUtils.isEmpty(queryParameter4)) {
            newTogetherRoomMessageData.f238449m = queryParameter4;
        }
        hVar.l(newTogetherRoomMessageData);
        return true;
    }

    private boolean D1() {
        if ("webview".equals(this.f307443h)) {
            this.f307441f.get("bus_type");
            this.f307437b.startActivity(new Intent(this.f307437b, (Class<?>) JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra(ISchemeApi.KEY_IOS_SRC_TYPE, this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE)).putExtra("callback_type", this.f307441f.get("callback_type")).putExtra("callback_name", this.f307441f.get("callback_name")));
        }
        return true;
    }

    private boolean D2() {
        String str = this.f307441f.get("troopuin");
        String str2 = this.f307441f.get("uin");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.tencent.mobileqq.profile.l.d(this.Q, this.f307437b, str, str2, 9, -1);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D3(long j3, String str, String str2, String str3, String str4, String str5, com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
        boolean z16 = false;
        if (eVar != null && eVar.b() != null && !eVar.b().isEmpty()) {
            z16 = ((Boolean) eVar.b().get(0)).booleanValue();
        }
        QLog.i("JumpAction", 1, "[goToChat] time:" + (System.currentTimeMillis() - j3) + " isFriend:" + z16 + " uid:" + str + " uin:" + str2 + " data:" + eVar);
        if (z16) {
            f4(str2, str3, str4, str5);
        }
    }

    private int E0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        if (!str.equals("1")) {
            return 69;
        }
        return 65;
    }

    private boolean E1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E3(Intent intent) {
        this.f307437b.startActivity(intent);
    }

    private int F0() {
        if (!TextUtils.isEmpty(this.f307441f.get(MosaicConstants$JsProperty.PROP_ENV))) {
            return Integer.valueOf(this.f307441f.get(MosaicConstants$JsProperty.PROP_ENV)).intValue();
        }
        return 0;
    }

    private boolean F1() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Jumpaction", 2, " source:" + this.f307438c + "  serverName:" + this.f307439d + "  hostName:" + this.f307440e);
        }
        if (this.f307440e.equals("index")) {
            Intent intent = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
            intent.putExtra("goto_type", 1);
            this.f307437b.startActivity(intent);
        } else if (this.f307440e.equals("detail")) {
            if (!TextUtils.isEmpty(this.f307438c)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Common.s());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append("qapp_center_detail.htm");
                String sb6 = sb5.toString();
                if (new File(sb6).exists()) {
                    str = "file:///" + sb6;
                } else {
                    str = Common.e() + str2 + "qapp_center_detail.htm";
                }
                Intent intent2 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle = new Bundle();
                String queryParameter = Uri.parse(this.f307438c).getQueryParameter("param");
                bundle.putString("APP_URL", str);
                bundle.putString("APP_PARAMS", ContainerUtils.FIELD_DELIMITER + queryParameter);
                bundle.putInt("goto_type", 2);
                intent2.putExtras(bundle);
                intent2.putExtra("adapter_action", "action_app_detail");
                this.f307437b.startActivity(intent2);
            }
        } else if (this.f307440e.equals("webview")) {
            if (!TextUtils.isEmpty(this.f307438c)) {
                Intent intent3 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("APP_URL", Uri.parse(this.f307438c).getQueryParameter("url"));
                bundle2.putInt("goto_type", 3);
                intent3.putExtras(bundle2);
                this.f307437b.startActivity(intent3);
            }
        } else if (this.f307440e.equals("local") && !TextUtils.isEmpty(this.f307438c)) {
            Uri parse = Uri.parse(this.f307438c);
            String queryParameter2 = parse.getQueryParameter("title");
            String[] h16 = Common.h(parse.getQueryParameter("url"));
            if (h16.length > 1) {
                String str3 = h16[0];
                if (str3.startsWith("file://") && (str3.contains(Common.s()) || str3.contains("android_asset/Page/system/"))) {
                    String str4 = h16[1];
                    Intent intent4 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("APP_URL", str3);
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        arrayList.add(queryParameter2);
                    }
                    bundle3.putStringArrayList("titleName", arrayList);
                    if (str4 != null && str4.length() > 0) {
                        bundle3.putString("APP_PARAMS", str4);
                    }
                    bundle3.putInt("goto_type", 4);
                    intent4.putExtras(bundle3);
                    this.f307437b.startActivity(intent4);
                }
            }
        }
        return true;
    }

    private boolean F2() {
        String e16;
        try {
            Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
            if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e())) {
                e16 = "https://docs.qq.com/desktop/m/index.html?_from=1";
            } else {
                e16 = TencentDocConvertConfigProcessor.a().e();
            }
            this.f307437b.startActivity(intent.putExtra("url", e16));
            return true;
        } catch (Exception e17) {
            e17.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F3(String str, boolean z16, boolean z17, List list) {
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str);
        intent.putExtra("param_type", 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, this.f307437b.getString(R.string.f171378ek0));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, this.f307437b.getString(R.string.dpe));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_IS_TROOP_ADMIN, z16);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 100);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((TroopMemberInfo) it.next()).memberuin);
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.f307437b, intent);
    }

    private String G0(String str) {
        try {
            return Uri.parse(str).getQueryParameter("request_from");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G1() {
        String str;
        String str2;
        int i3;
        String str3;
        long j3;
        int i16;
        int i17;
        String str4;
        String str5;
        String str6;
        String str7;
        String[] strArr;
        ReportController.o(this.Q, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
        }
        this.f307441f.get("file_type");
        String E = ax.E(this.f307441f.get("file_data"));
        String E2 = ax.E(this.f307441f.get("title"));
        String E3 = ax.E(this.f307441f.get("description"));
        ax.E(this.f307441f.get("previewimagedata"));
        String E4 = ax.E(this.f307441f.get("url"));
        String E5 = ax.E(this.f307441f.get("image_url"));
        if (!TextUtils.isEmpty(this.f307444i)) {
            str = ax.E(this.f307441f.get("app_name"));
        } else {
            str = null;
        }
        String E6 = ax.E(this.f307441f.get("audioUrl"));
        String E7 = ax.E(this.f307441f.get("open_id"));
        String E8 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE));
        String E9 = ax.E(this.f307441f.get("share_uin"));
        String str8 = this.f307441f.get(AppConstants.Key.SHARE_REQ_SHARE_JFROM);
        String E10 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_STR));
        try {
            i3 = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT))).intValue();
            str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
                sb5.append("gotoQfavShareMsg|parse extflags exp: extflag=");
                sb5.append(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT));
                QLog.e(ProcessConstant.QQFAV, 2, sb5.toString());
            } else {
                str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
            }
            i3 = 0;
        }
        long j16 = 0;
        try {
            long longValue = Long.valueOf(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH)).longValue();
            str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
            j3 = longValue;
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
                sb6.append("gotoQfavShareMsg|parse appid exp: appid=");
                sb6.append(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH));
                QLog.e(ProcessConstant.QQFAV, 2, sb6.toString());
            } else {
                str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
            }
            j3 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", E2);
        bundle.putString("desc", E3);
        bundle.putString("image_url", E);
        bundle.putString("detail_url", E4);
        bundle.putLong("req_share_id", j3);
        bundle.putString("pkg_name", this.f307444i);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, E5);
        bundle.putString("app_name", str);
        bundle.putString("open_id", E7);
        bundle.putString("share_uin", E9);
        bundle.putString(AppConstants.Key.SHARE_REQ_SHARE_JFROM, str8);
        bundle.putString(str2, E10);
        bundle.putInt(str3, i3);
        bundle.putInt("forward_type", 11);
        boolean z16 = true;
        try {
            i17 = Integer.valueOf(E8).intValue();
            str4 = AppConstants.Key.SHARE_REQ_TYPE;
            i16 = 2;
        } catch (NumberFormatException unused3) {
            if (QLog.isColorLevel()) {
                i16 = 2;
                QLog.e(ProcessConstant.QQFAV, 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + E8);
            } else {
                i16 = 2;
            }
            i17 = 1;
            str4 = AppConstants.Key.SHARE_REQ_TYPE;
        }
        bundle.putInt(str4, i17);
        if (i16 == i17) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, E6);
            if (TextUtils.isEmpty(E2) && TextUtils.isEmpty(E3)) {
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("title", String.format(this.f307437b.getString(R.string.ezx), str));
                } else {
                    bundle.putString("title", this.f307437b.getString(R.string.ezy));
                }
            }
        } else if (6 == i17) {
            if (TextUtils.isEmpty(E2)) {
                E2 = "";
            }
            if (!TextUtils.isEmpty(E3)) {
                if (!TextUtils.isEmpty(E2)) {
                    E3 = E2 + "\n" + E3;
                }
            } else {
                E3 = E2;
            }
            bundle.putString(AppConstants.Key.FORWARD_TEXT, E3);
            bundle.putBoolean("isFromShare", true);
            bundle.putBoolean("key_sdk_share_pure_text", true);
        } else if (5 == i17) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(E)) {
                String[] split = E.split(";");
                int i18 = 0;
                String str9 = null;
                String str10 = null;
                while (i18 < split.length) {
                    try {
                        str7 = URLDecoder.decode(split[i18], "UTF-8");
                    } catch (UnsupportedEncodingException unused4) {
                        if (QLog.isColorLevel()) {
                            QLog.e(ProcessConstant.QQFAV, 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + split[i18]);
                        }
                        str7 = "";
                    }
                    if (!TextUtils.isEmpty(str7)) {
                        if (str7.startsWith("/") && JumpActionSdkShareHelper.a(str7) && new File(str7).exists()) {
                            arrayList.add(str7);
                            if (TextUtils.isEmpty(str9)) {
                                str9 = str7;
                            }
                        } else if (str7.startsWith("http")) {
                            arrayList.add(str7);
                            if (TextUtils.isEmpty(str10)) {
                                str10 = str7;
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        StringBuilder sb7 = new StringBuilder();
                        strArr = split;
                        sb7.append("gotoQfavShareMsg|file path invalid. path=");
                        sb7.append(str7);
                        QLog.e(ProcessConstant.QQFAV, 2, sb7.toString());
                        i18++;
                        split = strArr;
                    }
                    strArr = split;
                    i18++;
                    split = strArr;
                }
                str5 = str9;
                str6 = str10;
            } else {
                str5 = null;
                str6 = null;
            }
            bundle.putString("image_url", str5);
            bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str6);
            bundle.putString("title", null);
            bundle.putString("desc", null);
            if (1 == arrayList.size()) {
                if (TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    bundle.putString("image_url", str6);
                    str5 = str6;
                }
                if (FileManagerUtil.getFileType(str5) == 0) {
                    bundle.putInt(str4, 5);
                } else {
                    bundle.putString(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.niu) + FileManagerUtil.getFileName(str5) + HardCodeUtil.qqStr(R.string.niv) + com.tencent.mobileqq.filemanager.util.q.g(com.tencent.mobileqq.filemanager.util.q.m(str5)) + "\u3002");
                    bundle.putBoolean("qdshare_file", true);
                    bundle.putBoolean("isFromShare", true);
                    bundle.putBoolean("key_sdk_share_pure_text", true);
                    bundle.putInt(str4, 6);
                }
                z16 = true;
            } else if (FileManagerUtil.getFileType(str5) == 0) {
                bundle.putString("title", arrayList.size() + this.f307437b.getString(R.string.clo));
                bundle.putString("qqfav_extra_multi_pic_path_list", E);
                z16 = true;
                bundle.putBoolean("qqfav_extra_multi_pic", true);
                bundle.putInt(str4, 1);
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    j16 += com.tencent.mobileqq.filemanager.util.q.m((String) it.next());
                }
                bundle.putString(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.f172125nj1) + FileManagerUtil.getFileName(str5) + HardCodeUtil.qqStr(R.string.nip) + arrayList.size() + HardCodeUtil.qqStr(R.string.f172126nj2) + com.tencent.mobileqq.filemanager.util.q.g(j16));
                bundle.putString("qqfav_extra_multi_pic_path_list", E);
                z16 = true;
                bundle.putBoolean("qdshare_file", true);
                bundle.putBoolean("isFromShare", true);
                bundle.putBoolean("key_sdk_share_pure_text", true);
                bundle.putInt(str4, 6);
            }
        } else if (1 != i17) {
            return false;
        }
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = z16;
        Intent intent = new Intent(this.f307437b, (Class<?>) LiteActivity.class);
        bundle.putBoolean("MigSdkShareNotDone", z16);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        this.f307437b.startActivity(intent);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G2() {
        String str;
        String str2;
        long j3;
        String E = ax.E(this.f307441f.get("title"));
        String E2 = ax.E(this.f307441f.get("description"));
        if (!TextUtils.isEmpty(this.f307444i)) {
            str = ax.E(this.f307441f.get("app_name"));
        } else {
            str = null;
        }
        String str3 = this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
        try {
            str2 = URLDecoder.decode(ax.E(this.f307441f.get("file_data")), "UTF-8");
        } catch (Exception unused) {
            str2 = "";
        }
        String E3 = ax.E(this.f307441f.get("troopbar_id"));
        try {
            j3 = Long.parseLong(str3);
        } catch (Exception unused2) {
            j3 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("share_from_app", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("share_img_list", str2);
            jSONObject2.put("share_title", E);
            jSONObject2.put(WinkDaTongReportConstant.ElementParamKey.SHARE_CONTENT, E2);
            jSONObject2.put("share_app_name", str);
            jSONObject2.put("share_app_id", j3);
            jSONObject.put("share_info", jSONObject2);
            jSONObject.put("bid", E3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + e16.toString());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G3(Intent intent) {
        IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
        Context context = BaseActivity.sTopActivity;
        if (context == null) {
            context = this.f307437b;
        }
        iAddFriendApi.launchAddFriend(context, intent);
    }

    private boolean H0() {
        int i3;
        String str = this.f307441f.get("roomcode");
        String str2 = this.f307441f.get("fromid");
        String str3 = this.f307441f.get("isgroupcode");
        String str4 = this.f307441f.get("backtype");
        String str5 = this.f307441f.get(QCircleSchemeAttr.WebView.OPEN_TYPE);
        String str6 = this.f307441f.get("extra");
        com.tencent.mobileqq.intervideo.groupvideo.h hVar = (com.tencent.mobileqq.intervideo.groupvideo.h) this.Q.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
        try {
            i3 = Integer.parseInt(str3);
        } catch (Exception unused) {
            i3 = 1;
        }
        QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str + ",fromId:" + str2 + " isGroupCode:" + str3);
        hVar.e(this.f307437b, str, this.Q.getCurrentUin(), i3, "download", str2, str4, str5, str6);
        return true;
    }

    private boolean H1() {
        if (this.f307440e.equals("jump")) {
            String str = this.f307441f.get("options");
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f307437b, RouterConstants.UI_ROUTER_VIPCOMIC);
            activityURIRequest.extra().putString("options", str);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            return true;
        }
        return false;
    }

    private boolean H2() {
        String str;
        String str2 = this.f307441f.get("groupcode");
        try {
            str = URLDecoder.decode(this.f307441f.get(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("JumpAction", 1, "gotoTroopInviteStatusFragment error: " + e16.getMessage());
            str = "";
        }
        String str3 = str;
        try {
            long parseLong = Long.parseLong(this.f307441f.get(AppConstants.Key.COLUMN_MSG_SEQ));
            String str4 = this.f307441f.get("senderuin");
            TroopInviteStatusFragment.zh(this.Q, this.f307437b, str2, str3, this.f307441f.get("receiveruin"), parseLong, str4, ac.Q(this.Q, str4, 0));
            return true;
        } catch (NumberFormatException e17) {
            QLog.e("JumpAction", 1, "gotoTroopInviteStatusFragment error: " + e17.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit H3(ArrayList arrayList, String str, TroopMemberNickInfo troopMemberNickInfo) {
        QRoute.createNavigator(this.f307437b, "/base/chathistory/main").withInt("nt_chat_history_chatType", 2).withString("frameKey", ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).getTroopMemberHistoryFragmentClassName()).withStringList("key_troop_member_uids", arrayList).withString("nt_chat_history_peerId", str).withString("key_troop_member_nick", troopMemberNickInfo.getShowName()).request();
        return null;
    }

    private boolean I0() {
        String str;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f307437b, 0, R.layout.f167664dn, 17);
        qQProgressDialog.setMessage(this.f307437b.getString(R.string.f170468s3));
        qQProgressDialog.getWindow().setDimAmount(0.0f);
        qQProgressDialog.show();
        qQProgressDialog.setCanceledOnTouchOutside(true);
        String str2 = this.f307441f.get("app");
        if (TextUtils.isEmpty(str2) && QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
        }
        String str3 = this.f307441f.get(PublicAccountMessageUtilImpl.META_NAME);
        String str4 = this.f307441f.get("view");
        if (this.f307441f.containsKey(QQCustomArkDialogUtil.BIZ_SRC)) {
            str = this.f307441f.get(QQCustomArkDialogUtil.BIZ_SRC);
        } else {
            str = "";
        }
        String str5 = str;
        ArkAppMgr.getInstance().getAppPathByName(str2, Constants.DEFAULT_MIN_APP_VERSION, str5, new l(qQProgressDialog, str4, str3, str2, str5));
        return true;
    }

    private boolean I1() {
        Context context = this.f307437b;
        if ((context instanceof SplashActivity) || (context instanceof ChatActivity)) {
            BaseActivity baseActivity = (BaseActivity) context;
            String str = this.f307441f.get("page_id");
            if (str != null) {
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = this.Q.getCurrentAccountUin();
                userInfo.nickname = this.Q.getCurrentNickname();
                String str2 = this.f307441f.get("url");
                SessionInfo m3 = baseActivity.getChatFragment().qh().m();
                if (m3 != null && !TextUtils.isEmpty(m3.f179557e)) {
                    ((com.tencent.mobileqq.troop.troopphoto.api.a) this.Q.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER)).t(m3.f179557e, true);
                }
                if (str.equalsIgnoreCase("11")) {
                    QZoneHelper.forwardToQunAlbumDetail((Activity) this.f307437b, userInfo, str2, QZoneHelper.QZoneAppConstants.REFER_QQ_CHAT_QZONE_NEWEST_FEED, -1);
                    return false;
                }
                if (str.equalsIgnoreCase("12")) {
                    String h16 = baseActivity.getChatFragment().qh().h();
                    String y06 = y0(str2);
                    if (TextUtils.isEmpty(y06)) {
                        QQToast.makeText(this.f307437b, "\u7f3a\u5c11\u76f8\u518cid", 1).show();
                        return false;
                    }
                    QZoneHelper.forwardToTroopAlbumViewPhoto((Activity) this.f307437b, userInfo, h16, y06, str2, QZoneHelper.QZoneAppConstants.REFER_QQ_CHAT_QZONE_NEWEST_FEED, -1);
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean I2() {
        boolean z16;
        TroopInfo k3;
        String str = this.f307441f.get("groupcode");
        if (str != null && !"".equals(str) && str.length() >= 5) {
            if (this.f307437b instanceof Activity) {
                TroopManager troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (k3 = troopManager.k(str)) != null && k3.isOwnerOrAdmin()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
                    }
                    return false;
                }
                Intent intent = new Intent();
                intent.putExtra("uin", this.Q.getCurrentAccountUin());
                intent.putExtra("troop_uin", str);
                intent.putExtra(AppConstants.Key.KEY_IS_UPDATE_BEFORE_805, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.f307437b, "8.0.5"));
                intent.putExtra("troop_manage_from_jump_action", true);
                QPublicFragmentActivity.startForResult((Activity) this.f307437b, intent, com.tencent.mobileqq.troopmanage.base.b.c(), -1);
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "gotoGroupManager " + str);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I3(Bundle bundle, Intent intent) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).forwardShareWithTryCatch(this.f307437b, this.f307441f, bundle, intent);
    }

    private boolean J0() {
        this.f307441f.get("fromid");
        com.tencent.mobileqq.intervideo.groupvideo.h hVar = (com.tencent.mobileqq.intervideo.groupvideo.h) this.Q.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
        QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
        hVar.c(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x049d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J1() {
        String str;
        String str2;
        int i3;
        String str3;
        long j3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i16;
        String str8;
        int i17;
        int i18;
        String str9;
        String str10;
        boolean z16;
        boolean z17;
        String str11;
        String str12;
        this.f307441f.get("file_type");
        String E = ax.E(this.f307441f.get("file_data"));
        String E2 = ax.E(this.f307441f.get("title"));
        String E3 = ax.E(this.f307441f.get("description"));
        ax.E(this.f307441f.get("previewimagedata"));
        String E4 = ax.E(this.f307441f.get("url"));
        String E5 = ax.E(this.f307441f.get("image_url"));
        if (!TextUtils.isEmpty(this.f307444i)) {
            str = ax.E(this.f307441f.get("app_name"));
        } else {
            str = null;
        }
        String E6 = ax.E(this.f307441f.get("audioUrl"));
        String E7 = ax.E(this.f307441f.get("open_id"));
        String E8 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE));
        String E9 = ax.E(this.f307441f.get("share_uin"));
        String str13 = this.f307441f.get(AppConstants.Key.SHARE_REQ_SHARE_JFROM);
        String E10 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_STR));
        try {
            i3 = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT))).intValue();
            str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
                sb5.append("gotoQfavShareMsg|parse extflags exp: extflag=");
                sb5.append(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT));
                QLog.e(ProcessConstant.QQFAV, 2, sb5.toString());
            } else {
                str2 = AppConstants.Key.SHARE_REQ_EXT_STR;
            }
            i3 = 0;
        }
        try {
            long longValue = Long.valueOf(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH)).longValue();
            str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
            j3 = longValue;
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
                sb6.append("gotoQfavShareMsg|parse appid exp: appid=");
                sb6.append(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH));
                QLog.e(ProcessConstant.QQFAV, 2, sb6.toString());
            } else {
                str3 = AppConstants.Key.SHARE_REQ_EXT_INT;
            }
            j3 = 0;
        }
        QQAppInterface qQAppInterface = this.Q;
        int i19 = (int) j3;
        int i26 = i3;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
            str5 = str4;
        } else {
            str4 = str;
            str5 = "";
        }
        if (TextUtils.isEmpty(this.f307444i)) {
            str6 = str5;
        } else {
            str6 = this.f307444i;
        }
        cooperation.qqfav.d.d(qQAppInterface, "User_SdkShare", i19, 0, 0, 0, str4, str6);
        Bundle bundle = new Bundle();
        bundle.putString("title", E2);
        bundle.putString("desc", E3);
        bundle.putString("image_url", E);
        bundle.putString("detail_url", E4);
        bundle.putLong("req_share_id", j3);
        bundle.putString("pkg_name", this.f307444i);
        bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, E5);
        bundle.putString("app_name", str);
        bundle.putString("open_id", E7);
        bundle.putString("share_uin", E9);
        bundle.putString(AppConstants.Key.SHARE_REQ_SHARE_JFROM, str13);
        bundle.putString(str2, E10);
        bundle.putInt(str3, i26);
        bundle.putInt("forward_type", 11);
        try {
            i17 = Integer.valueOf(E8).intValue();
            str8 = AppConstants.Key.SHARE_REQ_TYPE;
            str7 = ProcessConstant.QQFAV;
            i16 = 2;
        } catch (NumberFormatException unused3) {
            if (QLog.isColorLevel()) {
                String str14 = "gotoQfavShareMsg|parse reqtype exp: reqType=" + E8;
                str7 = ProcessConstant.QQFAV;
                i16 = 2;
                QLog.e(str7, 2, str14);
            } else {
                str7 = ProcessConstant.QQFAV;
                i16 = 2;
            }
            str8 = AppConstants.Key.SHARE_REQ_TYPE;
            i17 = 1;
        }
        bundle.putInt(str8, i17);
        if (i16 == i17) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, E6);
            if (TextUtils.isEmpty(E2) && TextUtils.isEmpty(E3)) {
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("title", String.format(this.f307437b.getString(R.string.ezx), str));
                } else {
                    bundle.putString("title", this.f307437b.getString(R.string.ezy));
                }
            }
            i18 = i26;
        } else {
            i18 = i26;
            if (6 == i17) {
                bundle.putBoolean("key_sdk_share_pure_text", true);
                if (!TextUtils.isEmpty(E2)) {
                    str12 = E2;
                } else {
                    str12 = str5;
                }
                if (!TextUtils.isEmpty(E3)) {
                    if (TextUtils.isEmpty(str12)) {
                        str12 = E3;
                    } else {
                        str12 = str12 + "\n" + E3;
                    }
                }
                bundle.putString(AppConstants.Key.FORWARD_TEXT, str12);
                bundle.putString("qqfav_extra_richmedia_title", E2);
                bundle.putString("qqfav_extra_mixed_msg", E3);
            } else {
                if (5 == i17) {
                    bundle.putBoolean("qqfav_extra_pic_share", true);
                    bundle.putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty(E3));
                    bundle.putString("qqfav_extra_richmedia_title", E2);
                    bundle.putString("qqfav_extra_mixed_msg", E3);
                    String str15 = str5;
                    bundle.putString("desc", str15);
                    if (TextUtils.isEmpty(E2) && !TextUtils.isEmpty(E3)) {
                        E2 = E3.replace("\u0014", str15);
                        bundle.putString("title", E2);
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!TextUtils.isEmpty(E)) {
                        String[] split = E.split(";");
                        str10 = null;
                        String str16 = null;
                        for (int i27 = 0; i27 < split.length; i27++) {
                            try {
                                str11 = URLDecoder.decode(split[i27], "UTF-8");
                            } catch (UnsupportedEncodingException unused4) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(str7, 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + split[i27]);
                                }
                                str11 = str15;
                            }
                            if (!TextUtils.isEmpty(str11)) {
                                if (str11.startsWith("/") && JumpActionSdkShareHelper.a(str11) && new File(str11).exists()) {
                                    arrayList.add(str11);
                                    if (TextUtils.isEmpty(str10)) {
                                        str10 = str11;
                                    }
                                } else if (str11.startsWith("http")) {
                                    arrayList.add(str11);
                                    if (TextUtils.isEmpty(str16)) {
                                        str16 = str11;
                                    }
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.e(str7, 2, "gotoQfavShareMsg|file path invalid. path=" + str11);
                            }
                        }
                        str9 = str16;
                    } else {
                        str9 = null;
                        str10 = null;
                    }
                    if (arrayList.isEmpty()) {
                        QfavUtil.Q(this.f307437b, R.string.ezv, 1);
                        if (QLog.isColorLevel()) {
                            QLog.e(str7, 2, "gotoQfavShareMsg|image type.no image path");
                            return false;
                        }
                        return false;
                    }
                    bundle.putString("image_url", str10);
                    bundle.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str9);
                    bundle.putStringArrayList("qqfav_extra_multi_pic_path_list", arrayList);
                    if (1 == arrayList.size()) {
                        if (TextUtils.isEmpty(E2)) {
                            bundle.putInt(str8, 5);
                            if (TextUtils.isEmpty(str10) && !TextUtils.isEmpty(str9)) {
                                bundle.putString("image_url", str9);
                            }
                            z16 = true;
                        } else {
                            bundle.putInt(str8, 1);
                            z16 = true;
                        }
                    } else {
                        if (TextUtils.isEmpty(E2)) {
                            bundle.putString("title", arrayList.size() + this.f307437b.getString(R.string.clo));
                        }
                        z16 = true;
                        bundle.putBoolean("qqfav_extra_multi_pic", true);
                        bundle.putInt(str8, 1);
                    }
                    z17 = z16;
                    com.tencent.mobileqq.phonecontact.constant.b.f258441a = z17;
                    Intent intent = new Intent(this.f307437b, (Class<?>) DirectForwardActivity.class);
                    intent.putExtra("toUin", AppConstants.FAVORITES_UIN);
                    intent.putExtra("uinType", 0);
                    if (z17 != i18) {
                        intent.putExtra("qqfav_extra_from_system_share", z17);
                    } else {
                        intent.putExtra("qqfav_extra_from_sdk_share", z17);
                    }
                    intent.putExtras(bundle);
                    ForwardBaseOption.startForwardActivity(this.f307437b, intent, (Class<?>) DirectForwardActivity.class);
                    return z17;
                }
                if (1 == i17) {
                    if (TextUtils.isEmpty(E2) && TextUtils.isEmpty(E3)) {
                        if (!TextUtils.isEmpty(str)) {
                            bundle.putString("title", String.format(this.f307437b.getString(R.string.ezx), str));
                        } else {
                            bundle.putString("title", this.f307437b.getString(R.string.ezy));
                        }
                    }
                    if (TextUtils.isEmpty(E4) && QLog.isColorLevel()) {
                        QLog.i(str7, 2, "gotoQfavShareMsg|link type. no detail url");
                    }
                } else {
                    QfavUtil.Q(this.f307437b, R.string.ezv, 1);
                    if (QLog.isColorLevel()) {
                        QLog.e(str7, 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i17);
                        return false;
                    }
                    return false;
                }
            }
        }
        z17 = true;
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = z17;
        Intent intent2 = new Intent(this.f307437b, (Class<?>) DirectForwardActivity.class);
        intent2.putExtra("toUin", AppConstants.FAVORITES_UIN);
        intent2.putExtra("uinType", 0);
        if (z17 != i18) {
        }
        intent2.putExtras(bundle);
        ForwardBaseOption.startForwardActivity(this.f307437b, intent2, (Class<?>) DirectForwardActivity.class);
        return z17;
    }

    private boolean J2() {
        String str;
        if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
            return false;
        }
        if (this.f307441f.containsKey("params")) {
            str = this.f307441f.get("params");
        } else {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0)));
            String optString = jSONObject.optString("keyword");
            JSONArray optJSONArray = jSONObject.optJSONArray("groupmask");
            long[] jArr = new long[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                jArr[i3] = optJSONArray.optLong(i3);
            }
            ActiveEntitySearchActivity.c3(this.f307437b, optString, jSONObject.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_NAME), jArr);
        } catch (JSONException unused) {
            QLog.e("JumpActionQ.uniteSearch.", 2, "\u53c2\u6570\u89e3\u6790\u6210json\u9519\u8bef.  params=" + str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J3(Intent intent) {
        RouteUtils.startActivity(Foreground.getTopActivity(), intent, RouterConstants.UI_ROUTER_WX_SHARE);
    }

    private boolean K0() {
        String str = this.f307441f.get("guin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
        int i3 = 0;
        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
            String str2 = this.f307441f.get("type");
            if (AbstractImageDownloader.TAG_GROUP.equals(str2)) {
                TroopUtils.T(this.Q, (Activity) this.f307437b, str);
            } else if ("group_album".equals(str2)) {
                String str3 = this.f307441f.get("gname");
                try {
                    i3 = Integer.parseInt(this.f307441f.get("unreadnum"));
                } catch (NumberFormatException unused) {
                }
                TroopUtils.l(this.Q, (Activity) this.f307437b, str, str3, i3);
            } else if (!"group_story".equals(str2)) {
                if (!"bulk_send_message".equals(str2)) {
                    return false;
                }
                String str4 = this.f307441f.get("gc");
                Bundle bundle = new Bundle();
                bundle.putString("extra.GROUP_UIN", str4);
                bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.j6l));
                BulkSendMessageFragment.th((Activity) this.f307437b, bundle);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, "illegal goToTroopProfileApp jumpAction. troopUin=", str);
        }
        return false;
    }

    private boolean K1(String str) {
        String str2;
        String str3;
        String str4;
        boolean z16 = false;
        if (str != null) {
            String str5 = "";
            if ("".equals(str) || this.Q.getCurrentAccountUin().equals(str) || str.length() < 5) {
                return false;
            }
            String str6 = this.f307441f.get("visitid");
            if (TextUtils.isEmpty(str6)) {
                return false;
            }
            if (this.f307441f.get("kfuin") == null) {
                str2 = "";
            } else {
                str2 = this.f307441f.get("kfuin");
            }
            if (this.f307441f.get("extuin") == null) {
                str3 = "";
            } else {
                str3 = this.f307441f.get("extuin");
            }
            if (this.f307441f.get("name") == null) {
                str4 = "";
            } else {
                str4 = ax.E(this.f307441f.get("name").replace(" ", Marker.ANY_NON_NULL_MARKER));
            }
            QidianHandler qidianHandler = (QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
            if (this.f307441f.get("cspecialflag") != null) {
                str5 = this.f307441f.get("cspecialflag");
            }
            if (!TextUtils.isEmpty(str5)) {
                z16 = QidianManager.O(Integer.valueOf(str5).intValue());
            }
            qidianHandler.A3(str6, this.Q.getCurrentAccountUin(), str2, str3, str, z16);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (!str.equals(this.Q.getCurrentAccountUin()) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "JumpAction")) {
                ProfileCardInfo profileCardInfo = new ProfileCardInfo();
                if (CrmUtils.r(this.Q, str)) {
                    profileCardInfo.allInOne = new AllInOne(str, 125);
                } else {
                    profileCardInfo.allInOne = new AllInOne(str, 1);
                }
                String[] strArr = new String[8];
                profileCardInfo.nameArray = strArr;
                strArr[4] = str4;
                ProfileBottomContainer.enterChat(this.Q, (QBaseActivity) this.f307437b, profileCardInfo);
            } else {
                IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                Context context = this.f307437b;
                Intent startAddFriend = iAddFriendApi.startAddFriend(context, 1, str, null, BuddySource.DEFAULT, 0, str4, null, null, context.getString(R.string.button_back), null);
                startAddFriend.putExtra("webImVisitId", str6);
                startAddFriend.putExtra("webim_qd_ext", true);
                if (BaseActivity.sTopActivity == null) {
                    startAddFriend.putExtra("need_jumpto_splash", true);
                }
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, startAddFriend);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:11|(1:13)|14|(2:15|16)|(8:20|21|22|(1:29)|(1:33)|34|35|(1:94)(10:40|41|42|43|(1:87)(1:47)|48|(7:50|(1:52)|53|(1:55)(1:64)|56|(1:58)|59)(2:65|(3:67|(1:72)|71)(6:73|(1:75)(1:86)|76|(1:85)(1:80)|81|(1:83)(1:84)))|(1:61)|62|63))|100|22|(3:25|27|29)|(2:31|33)|34|35|(2:37|95)(1:96)) */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x013a, code lost:
    
        r6 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean K2() {
        boolean z16;
        int i3;
        boolean z17;
        String s16;
        boolean z18;
        String str;
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat");
        }
        String str4 = this.f307441f.get(CloudStorageServlet.REQUEST_TYPE);
        if (str4 != null && "forward_to_tab".equals(str4)) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(Conversation.TAB_INDEX, 1);
            aliasIntent.setFlags(335544320);
            this.f307437b.startActivity(aliasIntent);
            return true;
        }
        String str5 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String str6 = this.f307441f.get("version");
        String str7 = this.f307441f.get("uinType");
        String str8 = this.f307441f.get("uin");
        String str9 = this.f307441f.get("phone");
        String str10 = this.f307441f.get("extraUin");
        String str11 = this.f307441f.get(AdParam.ACTID);
        String str12 = this.f307441f.get("mp_ext_params");
        String str13 = this.f307441f.get("avatar_chat");
        String str14 = this.f307441f.get(IProfileCardConst.KEY_FROM_TYPE);
        if (TextUtils.isEmpty(str14)) {
            str14 = "0";
        }
        String str15 = str14;
        try {
        } catch (NumberFormatException unused) {
            QLog.e("JumpAction", 2, "gotoVideoChat parse avatarChat exception");
        }
        if (!TextUtils.isEmpty(str13) && Integer.parseInt(str13) == 1) {
            this.f307441f.put("inviteScene", "2");
            this.f307441f.put("isAvatarFromH5", "1");
            z16 = true;
            if (str11 != null && str4 != null && str4.equals("audio") && QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoVideoChat actId : " + str11);
            }
            if (str12 != null && QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoVideoChat mp_ext_params : " + str12);
            }
            int i16 = Integer.parseInt(str6);
            if (str5 == null && str5.equals("web") && i16 > 0) {
                try {
                    i3 = Integer.valueOf(str7).intValue();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "gotoVideoChat", e16);
                    }
                    i3 = 0;
                }
                int s17 = com.tencent.av.r.s(i3, false, 1);
                if (str4 != null && str4.equals("audio")) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (s17 == 1006) {
                    if (!str9.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        str9 = Marker.ANY_NON_NULL_MARKER + str9;
                    }
                    PhoneContact queryContactByCodeNumber = ((IPhoneContactService) this.Q.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(str9);
                    if (queryContactByCodeNumber != null) {
                        str3 = queryContactByCodeNumber.name;
                    } else {
                        str3 = str9;
                    }
                    if (TextUtils.isEmpty(str8)) {
                        str8 = str9;
                    }
                    str = str3;
                    str2 = str8;
                    z18 = true;
                } else if (s17 == 1011) {
                    String str16 = this.f307441f.get("nickName");
                    if (TextUtils.isEmpty(str16) || str8.equals(str16)) {
                        str16 = this.f307437b.getResources().getString(R.string.f171254dh1);
                    }
                    str = str16;
                    str2 = str8;
                    z17 = true;
                    z18 = false;
                } else {
                    int w3 = ac.w(s17);
                    if (w3 == -1) {
                        s16 = ac.R(this.Q, str8, s17);
                    } else {
                        s16 = ac.s(this.Q, str8, str10, w3, 0);
                    }
                    if (!TextUtils.isEmpty(s16) && !str8.equals(s16)) {
                        z18 = true;
                    } else {
                        z18 = true;
                        s16 = ac.g(this.Q, str8, true);
                    }
                    if (TextUtils.isEmpty(s16)) {
                        str2 = str8;
                        str = str2;
                    } else {
                        str = s16;
                        str2 = str8;
                    }
                }
                if (z16) {
                    ReportController.o(this.Q, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, str15, "", "", "");
                }
                return ChatActivityUtils.j0(this.Q, this.f307437b, s17, str2, str, str9, z17, str10, z18, true, this.X, "from_internal", this.f307441f);
            }
            return false;
        }
        z16 = false;
        if (str11 != null) {
            QLog.d("JumpAction", 2, "gotoVideoChat actId : " + str11);
        }
        if (str12 != null) {
            QLog.d("JumpAction", 2, "gotoVideoChat mp_ext_params : " + str12);
        }
        int i162 = Integer.parseInt(str6);
        return str5 == null ? false : false;
    }

    private boolean K3() {
        ((IWXMiniProgramHelper) QRoute.api(IWXMiniProgramHelper.class)).launchMiniProgram(this.f307441f, this.f307438c);
        return true;
    }

    private boolean L1() {
        QQProxyForQlink.P(this.f307437b, 9, null);
        return true;
    }

    private boolean L2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent L3() {
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
        aliasIntent.putExtra(AppConstants.Key.THRIPARTY_PREPARE_MINI_APP, true);
        aliasIntent.addFlags(67108864);
        aliasIntent.addFlags(268435456);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        return aliasIntent;
    }

    private boolean M0() {
        String str;
        long parseLong;
        AllInOne allInOne;
        try {
            str = this.f307441f.get("uin");
            parseLong = Long.parseLong(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard exception : %s", e16.toString()));
            }
        }
        if (parseLong < 10000) {
            if (QLog.isColorLevel()) {
                QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", Long.valueOf(parseLong)));
            }
            return false;
        }
        String str2 = this.f307441f.get("name");
        String str3 = this.f307441f.get("source");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "JumpAction");
        if (Utils.p(str, this.Q.getCurrentAccountUin())) {
            allInOne = new AllInOne(str, 0);
        } else if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "JumpAction")) {
            allInOne = new AllInOne(str, 1);
            allInOne.nickname = friendsSimpleInfoWithUid.p();
            allInOne.remark = friendsSimpleInfoWithUid.r();
        } else {
            allInOne = new AllInOne(str, 95);
            allInOne.nickname = str2;
        }
        ProfileUtils.openProfileCard(this.f307437b, allInOne);
        if (QLog.isDevelopLevel()) {
            QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", Utils.U(str), Utils.U(str2), str3));
        }
        return false;
    }

    private boolean M1(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 13);
        bundle2.putString("viewParam", str);
        if (str2 != null) {
            bundle2.putString("entry", str2);
        }
        if (bundle != null) {
            bundle2.putBundle("extra_pay_data", bundle);
        }
        QWalletPayBridge.launchForeground((Activity) this.f307437b, bundle2);
        return true;
    }

    private boolean M2() {
        if (p0()) {
            try {
                QLog.i("JumpAction", 1, "gotoWtQuickLogin fromHistory");
                this.f307437b.startActivity(InstalledAppListMonitor.getLaunchIntentForPackage(this.f307437b.getPackageManager(), MobileQQ.PACKAGE_NAME));
                return true;
            } catch (Exception e16) {
                QLog.e("JumpAction", 1, "gotoWtQuickLogin exception", e16);
            }
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) AgentActivity.class);
        Bundle bundle = new Bundle();
        for (String str : this.f307441f.keySet()) {
            bundle.putString(str, this.f307441f.get(str));
        }
        intent.putExtra("key_params", bundle);
        intent.putExtra("key_action", "action_ptlogin_login");
        this.f307437b.startActivity(intent);
        return true;
    }

    private void M3(Intent intent) {
        if (!this.f307441f.containsKey("source")) {
            return;
        }
        try {
            intent.putExtra("data_report_source", Integer.parseInt(this.f307441f.get("source")));
        } catch (Exception unused) {
            QLog.w("JumpAction", 2, "no source, ingore it");
        }
    }

    private boolean N1(int i3) {
        if (!(this.f307437b instanceof QBaseActivity)) {
            return false;
        }
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchQWalletAct((QBaseActivity) this.f307437b, this.Q, true, i3);
        return true;
    }

    private void N2(AllInOne allInOne) {
        int i3;
        int i16;
        String str = this.f307441f.get("addfriend_sourceid");
        String str2 = this.f307441f.get("addfriend_subsourceid");
        if (str != null && str2 != null) {
            try {
                i3 = Integer.parseInt(str);
                try {
                    i16 = Integer.parseInt(str2);
                } catch (Exception e16) {
                    e = e16;
                    QLog.i("JumpAction", 1, "gotoShowPSLCard parse add friend param error.", e);
                    i16 = -1;
                    if (i3 != -1) {
                        allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, i3);
                        allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, i16);
                    }
                    String str3 = this.f307441f.get("alghrithm");
                    String str4 = this.f307441f.get("reason");
                    allInOne.extras.putByteArray("recommend_algh_id", Base64.decode(str3, 0));
                    allInOne.extras.putString("recommend_reason", new String(Base64.decode(str4, 0)));
                }
            } catch (Exception e17) {
                e = e17;
                i3 = -1;
            }
            if (i3 != -1 && i16 != -1) {
                allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, i3);
                allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, i16);
            }
        }
        String str32 = this.f307441f.get("alghrithm");
        String str42 = this.f307441f.get("reason");
        try {
            allInOne.extras.putByteArray("recommend_algh_id", Base64.decode(str32, 0));
            allInOne.extras.putString("recommend_reason", new String(Base64.decode(str42, 0)));
        } catch (Exception e18) {
            QLog.e("JumpAction", 1, "handleAllInOneExtras error:" + e18);
        }
    }

    private boolean N3() {
        if (this.f307437b == null) {
            return false;
        }
        return ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(this.f307437b);
    }

    private boolean O0() {
        String str;
        Intent intent = new Intent(this.f307437b, (Class<?>) BindGroupActivity.class);
        intent.putExtra("uin", this.Q.getCurrentAccountUin());
        Bundle bundle = new Bundle();
        for (String str2 : this.f307441f.keySet()) {
            if (!str2.equals(ISchemeApi.KEY_IOS_SRC_TYPE)) {
                str = ax.E(this.f307441f.get(str2));
            } else {
                str = this.f307441f.get(str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(str2, str);
            }
        }
        bundle.putString("pkg_name", this.f307444i);
        intent.putExtra("key_params", bundle);
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean O1() {
        String str;
        if (!(this.f307437b instanceof QBaseActivity)) {
            return false;
        }
        if (this.f307441f.containsKey("uin")) {
            str = this.f307441f.get("uin");
        } else {
            str = "";
        }
        if (!str.equals(this.Q.getCurrentAccountUin())) {
            c4();
        } else {
            Q3();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:260:0x064b A[Catch: ActivityNotFoundException -> 0x076f, TRY_ENTER, TryCatch #6 {ActivityNotFoundException -> 0x076f, blocks: (B:3:0x000e, B:5:0x002c, B:6:0x0032, B:9:0x0040, B:10:0x0069, B:12:0x0076, B:15:0x008a, B:19:0x00aa, B:26:0x00ba, B:29:0x00c5, B:31:0x00ce, B:33:0x00d4, B:34:0x00de, B:36:0x00e7, B:38:0x00ed, B:40:0x00f9, B:41:0x0103, B:42:0x0107, B:44:0x0110, B:46:0x0116, B:47:0x0120, B:49:0x0129, B:51:0x012f, B:52:0x013b, B:54:0x0144, B:56:0x014a, B:58:0x0158, B:59:0x0175, B:61:0x017e, B:64:0x0188, B:67:0x0193, B:70:0x01a0, B:77:0x01bd, B:79:0x01c3, B:84:0x01cb, B:86:0x01cf, B:89:0x01dd, B:91:0x01e3, B:93:0x01e9, B:99:0x01f9, B:100:0x020b, B:102:0x0211, B:104:0x0222, B:105:0x022a, B:107:0x0232, B:108:0x023a, B:110:0x0242, B:111:0x024a, B:113:0x0258, B:115:0x025d, B:118:0x02ae, B:120:0x02b4, B:123:0x02c2, B:125:0x02e4, B:128:0x02f3, B:130:0x02f9, B:144:0x039d, B:145:0x03a2, B:148:0x03ab, B:150:0x03b1, B:152:0x03ba, B:154:0x03c0, B:156:0x03c9, B:158:0x03d1, B:160:0x03d5, B:162:0x03e5, B:163:0x0402, B:172:0x040c, B:173:0x042c, B:165:0x0448, B:167:0x0452, B:169:0x0458, B:170:0x0460, B:176:0x041d, B:178:0x0423, B:180:0x0442, B:181:0x0468, B:183:0x046e, B:185:0x0474, B:187:0x047d, B:189:0x0483, B:233:0x0498, B:192:0x049f, B:194:0x04b9, B:196:0x04c3, B:197:0x04de, B:199:0x04e6, B:200:0x04fd, B:202:0x0506, B:203:0x0518, B:206:0x0529, B:208:0x0533, B:212:0x0542, B:214:0x0559, B:216:0x056e, B:219:0x0591, B:221:0x05a7, B:222:0x05a2, B:223:0x05b0, B:225:0x05b6, B:234:0x05bf, B:236:0x05c5, B:237:0x05cd, B:239:0x05d6, B:240:0x05de, B:242:0x05e7, B:245:0x0607, B:254:0x0632, B:257:0x063e, B:260:0x064b, B:261:0x067d, B:263:0x068f, B:266:0x0697, B:268:0x06a0, B:270:0x06a7, B:272:0x06ad, B:273:0x06b5, B:274:0x06c0, B:276:0x06c6, B:278:0x06d3, B:279:0x06e3, B:280:0x070c, B:282:0x0715, B:284:0x071f, B:286:0x0728, B:288:0x0740, B:289:0x06dc, B:290:0x06e9, B:292:0x06f9, B:294:0x06ff, B:295:0x0706, B:296:0x0656, B:298:0x065f, B:300:0x0668, B:302:0x0671, B:248:0x074c, B:316:0x0298, B:319:0x075e, B:321:0x0764, B:95:0x01f3, B:133:0x0302, B:135:0x030a, B:137:0x0310, B:140:0x034a, B:141:0x0382, B:310:0x0265, B:312:0x026b, B:315:0x0280, B:229:0x0491), top: B:2:0x000e, inners: #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x068f A[Catch: ActivityNotFoundException -> 0x076f, TryCatch #6 {ActivityNotFoundException -> 0x076f, blocks: (B:3:0x000e, B:5:0x002c, B:6:0x0032, B:9:0x0040, B:10:0x0069, B:12:0x0076, B:15:0x008a, B:19:0x00aa, B:26:0x00ba, B:29:0x00c5, B:31:0x00ce, B:33:0x00d4, B:34:0x00de, B:36:0x00e7, B:38:0x00ed, B:40:0x00f9, B:41:0x0103, B:42:0x0107, B:44:0x0110, B:46:0x0116, B:47:0x0120, B:49:0x0129, B:51:0x012f, B:52:0x013b, B:54:0x0144, B:56:0x014a, B:58:0x0158, B:59:0x0175, B:61:0x017e, B:64:0x0188, B:67:0x0193, B:70:0x01a0, B:77:0x01bd, B:79:0x01c3, B:84:0x01cb, B:86:0x01cf, B:89:0x01dd, B:91:0x01e3, B:93:0x01e9, B:99:0x01f9, B:100:0x020b, B:102:0x0211, B:104:0x0222, B:105:0x022a, B:107:0x0232, B:108:0x023a, B:110:0x0242, B:111:0x024a, B:113:0x0258, B:115:0x025d, B:118:0x02ae, B:120:0x02b4, B:123:0x02c2, B:125:0x02e4, B:128:0x02f3, B:130:0x02f9, B:144:0x039d, B:145:0x03a2, B:148:0x03ab, B:150:0x03b1, B:152:0x03ba, B:154:0x03c0, B:156:0x03c9, B:158:0x03d1, B:160:0x03d5, B:162:0x03e5, B:163:0x0402, B:172:0x040c, B:173:0x042c, B:165:0x0448, B:167:0x0452, B:169:0x0458, B:170:0x0460, B:176:0x041d, B:178:0x0423, B:180:0x0442, B:181:0x0468, B:183:0x046e, B:185:0x0474, B:187:0x047d, B:189:0x0483, B:233:0x0498, B:192:0x049f, B:194:0x04b9, B:196:0x04c3, B:197:0x04de, B:199:0x04e6, B:200:0x04fd, B:202:0x0506, B:203:0x0518, B:206:0x0529, B:208:0x0533, B:212:0x0542, B:214:0x0559, B:216:0x056e, B:219:0x0591, B:221:0x05a7, B:222:0x05a2, B:223:0x05b0, B:225:0x05b6, B:234:0x05bf, B:236:0x05c5, B:237:0x05cd, B:239:0x05d6, B:240:0x05de, B:242:0x05e7, B:245:0x0607, B:254:0x0632, B:257:0x063e, B:260:0x064b, B:261:0x067d, B:263:0x068f, B:266:0x0697, B:268:0x06a0, B:270:0x06a7, B:272:0x06ad, B:273:0x06b5, B:274:0x06c0, B:276:0x06c6, B:278:0x06d3, B:279:0x06e3, B:280:0x070c, B:282:0x0715, B:284:0x071f, B:286:0x0728, B:288:0x0740, B:289:0x06dc, B:290:0x06e9, B:292:0x06f9, B:294:0x06ff, B:295:0x0706, B:296:0x0656, B:298:0x065f, B:300:0x0668, B:302:0x0671, B:248:0x074c, B:316:0x0298, B:319:0x075e, B:321:0x0764, B:95:0x01f3, B:133:0x0302, B:135:0x030a, B:137:0x0310, B:140:0x034a, B:141:0x0382, B:310:0x0265, B:312:0x026b, B:315:0x0280, B:229:0x0491), top: B:2:0x000e, inners: #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0715 A[Catch: ActivityNotFoundException -> 0x076f, TryCatch #6 {ActivityNotFoundException -> 0x076f, blocks: (B:3:0x000e, B:5:0x002c, B:6:0x0032, B:9:0x0040, B:10:0x0069, B:12:0x0076, B:15:0x008a, B:19:0x00aa, B:26:0x00ba, B:29:0x00c5, B:31:0x00ce, B:33:0x00d4, B:34:0x00de, B:36:0x00e7, B:38:0x00ed, B:40:0x00f9, B:41:0x0103, B:42:0x0107, B:44:0x0110, B:46:0x0116, B:47:0x0120, B:49:0x0129, B:51:0x012f, B:52:0x013b, B:54:0x0144, B:56:0x014a, B:58:0x0158, B:59:0x0175, B:61:0x017e, B:64:0x0188, B:67:0x0193, B:70:0x01a0, B:77:0x01bd, B:79:0x01c3, B:84:0x01cb, B:86:0x01cf, B:89:0x01dd, B:91:0x01e3, B:93:0x01e9, B:99:0x01f9, B:100:0x020b, B:102:0x0211, B:104:0x0222, B:105:0x022a, B:107:0x0232, B:108:0x023a, B:110:0x0242, B:111:0x024a, B:113:0x0258, B:115:0x025d, B:118:0x02ae, B:120:0x02b4, B:123:0x02c2, B:125:0x02e4, B:128:0x02f3, B:130:0x02f9, B:144:0x039d, B:145:0x03a2, B:148:0x03ab, B:150:0x03b1, B:152:0x03ba, B:154:0x03c0, B:156:0x03c9, B:158:0x03d1, B:160:0x03d5, B:162:0x03e5, B:163:0x0402, B:172:0x040c, B:173:0x042c, B:165:0x0448, B:167:0x0452, B:169:0x0458, B:170:0x0460, B:176:0x041d, B:178:0x0423, B:180:0x0442, B:181:0x0468, B:183:0x046e, B:185:0x0474, B:187:0x047d, B:189:0x0483, B:233:0x0498, B:192:0x049f, B:194:0x04b9, B:196:0x04c3, B:197:0x04de, B:199:0x04e6, B:200:0x04fd, B:202:0x0506, B:203:0x0518, B:206:0x0529, B:208:0x0533, B:212:0x0542, B:214:0x0559, B:216:0x056e, B:219:0x0591, B:221:0x05a7, B:222:0x05a2, B:223:0x05b0, B:225:0x05b6, B:234:0x05bf, B:236:0x05c5, B:237:0x05cd, B:239:0x05d6, B:240:0x05de, B:242:0x05e7, B:245:0x0607, B:254:0x0632, B:257:0x063e, B:260:0x064b, B:261:0x067d, B:263:0x068f, B:266:0x0697, B:268:0x06a0, B:270:0x06a7, B:272:0x06ad, B:273:0x06b5, B:274:0x06c0, B:276:0x06c6, B:278:0x06d3, B:279:0x06e3, B:280:0x070c, B:282:0x0715, B:284:0x071f, B:286:0x0728, B:288:0x0740, B:289:0x06dc, B:290:0x06e9, B:292:0x06f9, B:294:0x06ff, B:295:0x0706, B:296:0x0656, B:298:0x065f, B:300:0x0668, B:302:0x0671, B:248:0x074c, B:316:0x0298, B:319:0x075e, B:321:0x0764, B:95:0x01f3, B:133:0x0302, B:135:0x030a, B:137:0x0310, B:140:0x034a, B:141:0x0382, B:310:0x0265, B:312:0x026b, B:315:0x0280, B:229:0x0491), top: B:2:0x000e, inners: #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06e9 A[Catch: ActivityNotFoundException -> 0x076f, TryCatch #6 {ActivityNotFoundException -> 0x076f, blocks: (B:3:0x000e, B:5:0x002c, B:6:0x0032, B:9:0x0040, B:10:0x0069, B:12:0x0076, B:15:0x008a, B:19:0x00aa, B:26:0x00ba, B:29:0x00c5, B:31:0x00ce, B:33:0x00d4, B:34:0x00de, B:36:0x00e7, B:38:0x00ed, B:40:0x00f9, B:41:0x0103, B:42:0x0107, B:44:0x0110, B:46:0x0116, B:47:0x0120, B:49:0x0129, B:51:0x012f, B:52:0x013b, B:54:0x0144, B:56:0x014a, B:58:0x0158, B:59:0x0175, B:61:0x017e, B:64:0x0188, B:67:0x0193, B:70:0x01a0, B:77:0x01bd, B:79:0x01c3, B:84:0x01cb, B:86:0x01cf, B:89:0x01dd, B:91:0x01e3, B:93:0x01e9, B:99:0x01f9, B:100:0x020b, B:102:0x0211, B:104:0x0222, B:105:0x022a, B:107:0x0232, B:108:0x023a, B:110:0x0242, B:111:0x024a, B:113:0x0258, B:115:0x025d, B:118:0x02ae, B:120:0x02b4, B:123:0x02c2, B:125:0x02e4, B:128:0x02f3, B:130:0x02f9, B:144:0x039d, B:145:0x03a2, B:148:0x03ab, B:150:0x03b1, B:152:0x03ba, B:154:0x03c0, B:156:0x03c9, B:158:0x03d1, B:160:0x03d5, B:162:0x03e5, B:163:0x0402, B:172:0x040c, B:173:0x042c, B:165:0x0448, B:167:0x0452, B:169:0x0458, B:170:0x0460, B:176:0x041d, B:178:0x0423, B:180:0x0442, B:181:0x0468, B:183:0x046e, B:185:0x0474, B:187:0x047d, B:189:0x0483, B:233:0x0498, B:192:0x049f, B:194:0x04b9, B:196:0x04c3, B:197:0x04de, B:199:0x04e6, B:200:0x04fd, B:202:0x0506, B:203:0x0518, B:206:0x0529, B:208:0x0533, B:212:0x0542, B:214:0x0559, B:216:0x056e, B:219:0x0591, B:221:0x05a7, B:222:0x05a2, B:223:0x05b0, B:225:0x05b6, B:234:0x05bf, B:236:0x05c5, B:237:0x05cd, B:239:0x05d6, B:240:0x05de, B:242:0x05e7, B:245:0x0607, B:254:0x0632, B:257:0x063e, B:260:0x064b, B:261:0x067d, B:263:0x068f, B:266:0x0697, B:268:0x06a0, B:270:0x06a7, B:272:0x06ad, B:273:0x06b5, B:274:0x06c0, B:276:0x06c6, B:278:0x06d3, B:279:0x06e3, B:280:0x070c, B:282:0x0715, B:284:0x071f, B:286:0x0728, B:288:0x0740, B:289:0x06dc, B:290:0x06e9, B:292:0x06f9, B:294:0x06ff, B:295:0x0706, B:296:0x0656, B:298:0x065f, B:300:0x0668, B:302:0x0671, B:248:0x074c, B:316:0x0298, B:319:0x075e, B:321:0x0764, B:95:0x01f3, B:133:0x0302, B:135:0x030a, B:137:0x0310, B:140:0x034a, B:141:0x0382, B:310:0x0265, B:312:0x026b, B:315:0x0280, B:229:0x0491), top: B:2:0x000e, inners: #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0656 A[Catch: ActivityNotFoundException -> 0x076f, TryCatch #6 {ActivityNotFoundException -> 0x076f, blocks: (B:3:0x000e, B:5:0x002c, B:6:0x0032, B:9:0x0040, B:10:0x0069, B:12:0x0076, B:15:0x008a, B:19:0x00aa, B:26:0x00ba, B:29:0x00c5, B:31:0x00ce, B:33:0x00d4, B:34:0x00de, B:36:0x00e7, B:38:0x00ed, B:40:0x00f9, B:41:0x0103, B:42:0x0107, B:44:0x0110, B:46:0x0116, B:47:0x0120, B:49:0x0129, B:51:0x012f, B:52:0x013b, B:54:0x0144, B:56:0x014a, B:58:0x0158, B:59:0x0175, B:61:0x017e, B:64:0x0188, B:67:0x0193, B:70:0x01a0, B:77:0x01bd, B:79:0x01c3, B:84:0x01cb, B:86:0x01cf, B:89:0x01dd, B:91:0x01e3, B:93:0x01e9, B:99:0x01f9, B:100:0x020b, B:102:0x0211, B:104:0x0222, B:105:0x022a, B:107:0x0232, B:108:0x023a, B:110:0x0242, B:111:0x024a, B:113:0x0258, B:115:0x025d, B:118:0x02ae, B:120:0x02b4, B:123:0x02c2, B:125:0x02e4, B:128:0x02f3, B:130:0x02f9, B:144:0x039d, B:145:0x03a2, B:148:0x03ab, B:150:0x03b1, B:152:0x03ba, B:154:0x03c0, B:156:0x03c9, B:158:0x03d1, B:160:0x03d5, B:162:0x03e5, B:163:0x0402, B:172:0x040c, B:173:0x042c, B:165:0x0448, B:167:0x0452, B:169:0x0458, B:170:0x0460, B:176:0x041d, B:178:0x0423, B:180:0x0442, B:181:0x0468, B:183:0x046e, B:185:0x0474, B:187:0x047d, B:189:0x0483, B:233:0x0498, B:192:0x049f, B:194:0x04b9, B:196:0x04c3, B:197:0x04de, B:199:0x04e6, B:200:0x04fd, B:202:0x0506, B:203:0x0518, B:206:0x0529, B:208:0x0533, B:212:0x0542, B:214:0x0559, B:216:0x056e, B:219:0x0591, B:221:0x05a7, B:222:0x05a2, B:223:0x05b0, B:225:0x05b6, B:234:0x05bf, B:236:0x05c5, B:237:0x05cd, B:239:0x05d6, B:240:0x05de, B:242:0x05e7, B:245:0x0607, B:254:0x0632, B:257:0x063e, B:260:0x064b, B:261:0x067d, B:263:0x068f, B:266:0x0697, B:268:0x06a0, B:270:0x06a7, B:272:0x06ad, B:273:0x06b5, B:274:0x06c0, B:276:0x06c6, B:278:0x06d3, B:279:0x06e3, B:280:0x070c, B:282:0x0715, B:284:0x071f, B:286:0x0728, B:288:0x0740, B:289:0x06dc, B:290:0x06e9, B:292:0x06f9, B:294:0x06ff, B:295:0x0706, B:296:0x0656, B:298:0x065f, B:300:0x0668, B:302:0x0671, B:248:0x074c, B:316:0x0298, B:319:0x075e, B:321:0x0764, B:95:0x01f3, B:133:0x0302, B:135:0x030a, B:137:0x0310, B:140:0x034a, B:141:0x0382, B:310:0x0265, B:312:0x026b, B:315:0x0280, B:229:0x0491), top: B:2:0x000e, inners: #1, #3, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean O2() {
        Intent intent;
        String str;
        String str2;
        boolean z16;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z17;
        String str8;
        boolean z18;
        int parseInt;
        boolean z19;
        boolean z26;
        String str9;
        String str10 = "cspecialflag";
        try {
            intent = new Intent("android.intent.action.MAIN");
            k4(intent);
            Set<Map.Entry<String, String>> entrySet = this.f307441f.entrySet();
            String f16 = f("download_sourceid");
            if (!TextUtils.isEmpty(f16)) {
                intent.putExtra("big_brother_source_key", f16);
            }
            boolean isEmpty = TextUtils.isEmpty(f("from_leba"));
            String str11 = QCircleScheme.AttrDetail.HAS_RED_DOT;
            if (!isEmpty) {
                intent.putExtra("plugin_start_time", System.nanoTime());
                intent.putExtra("click_start_time", System.currentTimeMillis());
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent.putExtra("is_from_leba", true);
                intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, this.f307450o);
            }
            Iterator<Map.Entry<String, String>> it = entrySet.iterator();
            String str12 = "";
            str = null;
            str2 = null;
            z16 = false;
            str3 = null;
            while (true) {
                str4 = str12;
                str5 = "1";
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                Iterator<Map.Entry<String, String>> it5 = it;
                String key = next.getKey();
                String str13 = str10;
                String value = next.getValue();
                if (key != null && value != null) {
                    String str14 = str11;
                    if ("pkg".equals(key)) {
                        str = value;
                    } else if ("cmp".equals(key)) {
                        str2 = value;
                    } else if ("plg_account".equals(key)) {
                        if ("1".equals(value)) {
                            intent.putExtra("account", this.Q.getCurrentAccountUin());
                        }
                    } else if ("plg_nickname".equals(key)) {
                        if ("1".equals(value)) {
                            String currentNickname = this.Q.getCurrentNickname();
                            if (StringUtil.isEmpty(currentNickname)) {
                                QQAppInterface qQAppInterface = this.Q;
                                currentNickname = ac.f(qQAppInterface, qQAppInterface.getCurrentAccountUin());
                            }
                            intent.putExtra("nickname", currentNickname);
                        }
                    } else if ("plg_vkey".equals(key)) {
                        if ("1".equals(value)) {
                            intent.putExtra("vkey", this.Q.getvKeyStr());
                        }
                    } else if ("plg_launchtime".equals(key)) {
                        if ("1".equals(value)) {
                            intent.putExtra(QZoneHelper.Constants.KEY_LAUNCH_TIME, System.currentTimeMillis());
                        }
                    } else if ("plg_newflag".equals(key)) {
                        if ("1".equals(value)) {
                            intent.putExtra("newflag", this.f307448m);
                            if (QLog.isColorLevel()) {
                                QLog.d("Jumpaction", 2, "handleAppForward.newflag=" + this.f307448m);
                            }
                        }
                    } else {
                        if ("plg_type".equals(key)) {
                            if ("1".equals(value)) {
                                str12 = str4;
                                z16 = true;
                                str11 = str14;
                            }
                        } else if (RFixConstants.APK_PATH.equals(key)) {
                            str12 = value;
                            str11 = str14;
                        } else if (ISchemeApi.KEY_IOS_SRC_TYPE.equals(key)) {
                            str3 = value;
                        } else {
                            intent.putExtra(key, value);
                        }
                        str10 = str13;
                        it = it5;
                    }
                    str12 = str4;
                    str11 = str14;
                    str10 = str13;
                    it = it5;
                }
                str11 = str11;
                str12 = str4;
                str10 = str13;
                it = it5;
            }
            str6 = str10;
            str7 = str11;
        } catch (ActivityNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
        if (str != null && str2 != null && !"".equals(str) && !"".equals(str2)) {
            if (this.f307442g && bf.h().i(this.f307437b, str, str2)) {
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                for (String str15 : Z) {
                    if (str.equals(str15)) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (!z17) {
                str8 = null;
                intent.putExtra("vkey", (String) null);
                intent.putExtra("sid", (String) null);
                intent.putExtra("nickname", (String) null);
                intent.putExtra("account", (String) null);
            } else {
                str8 = null;
            }
            if (str2.startsWith("com.qzone")) {
                intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_QQ_ACTIVE_FEED);
                if (!TextUtils.isEmpty(this.f307452q)) {
                    intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_QZOEN_FEEDS_KEY, this.f307452q);
                }
                if (!TextUtils.isEmpty(this.f307453r)) {
                    intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_QZOEN_FEEDS_TIME, this.f307453r);
                }
                if (!TextUtils.isEmpty(this.f307454s)) {
                    intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_QZOEN_FEEDS_INDEX, this.f307454s);
                }
                intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_QZOEN_FEEDS_DIGITAL_REDDOT, this.f307455t);
                if (QZoneLoginReportHelper.needAddLoginFromLebaTab(intent, str2)) {
                    QZoneLoginReportHelper.setLoginFromLebaTab(intent);
                }
            }
            if (!z16) {
                if (str2.startsWith("com.qzone")) {
                    try {
                        if (QZoneConfigHelper.K0()) {
                            ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZonePage(this.f307437b, str2, intent, this.Q.getCurrentAccountUin());
                        } else {
                            QzonePluginProxyActivity.setActivityNameToIntent(intent, str2);
                            intent.addFlags(536870912);
                            QzonePluginProxyActivity.launchPluingActivityForResult((Activity) this.f307437b, this.Q.getCurrentAccountUin(), intent, -1);
                        }
                    } catch (Exception unused) {
                        Intent intent2 = new Intent(this.f307437b, (Class<?>) TranslucentActivity.class);
                        intent2.addFlags(268435456);
                        intent2.putExtras(intent);
                        this.f307437b.startActivity(intent2);
                    }
                } else if (str2.endsWith("NearbyTroopsActivity")) {
                    com.tencent.mobileqq.troop.data.f.f(this.f307437b, this.Q);
                    if (this.f307450o) {
                        str5 = "0";
                    }
                    ReportController.o(this.Q, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", str5);
                } else if (str2.endsWith("PoiMapActivity")) {
                    Context context = this.f307437b;
                    if (!(context instanceof BaseActivity)) {
                        QLog.e("JumpAction", 1, "context is not instanceof BaseActivity");
                        return false;
                    }
                    try {
                        ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                        if (chatFragment != null && chatFragment.qh() != null) {
                            chatFragment.qh().a();
                            int i3 = chatFragment.qh().f25589n.f179555d;
                            intent.putExtra("uin", this.Q.getCurrentAccountUin());
                            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
                            String stringExtra = intent.getStringExtra(QCircleSchemeAttr.Polymerize.LAT);
                            String stringExtra2 = intent.getStringExtra("lon");
                            String stringExtra3 = intent.getStringExtra("loc");
                            if (stringExtra != null && stringExtra2 != null) {
                                intent.putExtra("url", bo.f307494a.a() + Double.valueOf(stringExtra) + "," + Double.valueOf(stringExtra2) + "&iwloc=A&hl=zh-CN (" + stringExtra3 + ")");
                            }
                            intent.setClassName(this.f307437b.getPackageName(), str2);
                            ((QBaseActivity) this.f307437b).startActivityForResult(intent, 18);
                            com.tencent.biz.widgets.d.d("see_location");
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equalsIgnoreCase("com.tencent.biz.coupon.CouponActivity") && str.equalsIgnoreCase("com.tencent.mobileqq")) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BusinessInfoCheckUpdate.AppInfo appInfo = this.A;
                    if (appInfo != null && appInfo.type.get() > 0 && this.f307448m) {
                        stringBuffer.append("isRedLight=1");
                        if (this.A.type.has()) {
                            stringBuffer.append("&redType=" + this.A.type.get());
                        }
                        if (this.A.buffer.has()) {
                            try {
                                str9 = URLEncoder.encode(this.A.buffer.get(), "UTF-8");
                            } catch (UnsupportedEncodingException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("JumpAction", 2, e18.getMessage());
                                }
                                str9 = str8;
                            }
                            stringBuffer.append("&couponBuffer=" + str9);
                        }
                    } else {
                        stringBuffer.append("isRedLight=0");
                    }
                    String f17 = f("url");
                    if (!TextUtils.isEmpty(f17) && com.tencent.biz.qrcode.util.h.K(f17)) {
                        f17 = HtmlOffline.b(f17, stringBuffer.toString());
                    }
                    e4(f17, str, str2, intent);
                    x3(str2);
                } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity") && str.equalsIgnoreCase("com.tencent.mobileqq")) {
                    String f18 = f("url");
                    String str16 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
                    if (!TextUtils.isEmpty(f18)) {
                        try {
                            str16 = URLDecoder.decode(f18);
                        } catch (Exception e19) {
                            QLog.e("JumpAction", 1, "enter GameCenter e:", e19);
                        }
                    }
                    String str17 = "st=" + System.currentTimeMillis();
                    if (this.Q != null && AuthorizeConfig.y().l(str16)) {
                        str17 = str17 + "&uin=" + this.Q.getCurrentAccountUin();
                    }
                    if (!TextUtils.isEmpty(this.f307449n)) {
                        str17 = str17 + ContainerUtils.FIELD_DELIMITER + this.f307449n;
                    }
                    if (str16.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < 0) {
                        str17 = str17 + "&plat=qq&_wv=5127";
                    }
                    String b16 = HtmlOffline.b(str16, str17);
                    if (!TextUtils.isEmpty(f("from_leba"))) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    IGameCenterRedPointConfigApi iGameCenterRedPointConfigApi = (IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class);
                    if (z19 && iGameCenterRedPointConfigApi.jumpGameCenterByRedPoint(this.f307437b, this.f307448m)) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (!z26) {
                        iGameCenterRedPointConfigApi.reportGameDynamicClick(this.A, b16, this.f307451p);
                        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).openGameCenterByKuikly(this.f307437b, b16, z19)) {
                            int canOpenHippyByModuleName = ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).canOpenHippyByModuleName(HippyQQConstants.ModuleName.QQ_GAME_CENTER);
                            if (QLog.isColorLevel()) {
                                QLog.i("JumpAction", 2, "open QQGameCenter checkCode:" + canOpenHippyByModuleName + " isFromLeba:" + z19);
                            }
                            if (canOpenHippyByModuleName == 0 && z19) {
                                ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).openQQGameCenterByHippy(this.f307437b, b16, TabPreloadItem.TAB_NAME_DYNAMIC);
                            } else {
                                e4(b16, str, str2, intent);
                            }
                            if (z19) {
                                HippyReporter.getInstance().reportGameCenterHippy(canOpenHippyByModuleName, this.f307448m);
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, "enter gameCenter");
                    }
                } else {
                    if (str2.endsWith("NearbyTroopsActivity")) {
                        intent.putExtra("from", 15);
                    }
                    if (str2.endsWith("JoinGroupTransitActivity")) {
                        intent.putExtra("source_scheme", this.f307438c);
                    }
                    if (str2.endsWith("VipComicJumpActivity")) {
                        intent.putExtra(str7, this.f307450o | this.f307448m);
                        if (((IQQComicUtil) QRoute.api(IQQComicUtil.class)).initPluginBeforeEnter(this.Q, (Activity) this.f307437b, intent)) {
                            return true;
                        }
                    }
                    if (str.equals(BaseApplication.getContext().getPackageName())) {
                        try {
                            z18 = PluginProxyActivity.class.isAssignableFrom(BaseApplication.getContext().getClassLoader().loadClass(str2));
                        } catch (Exception unused2) {
                            z18 = false;
                        }
                        if (z18) {
                            return false;
                        }
                        String stringExtra4 = intent.getStringExtra(str6);
                        if (stringExtra4 != null) {
                            try {
                                parseInt = Integer.parseInt(stringExtra4);
                            } catch (Exception unused3) {
                            }
                            if (!str2.equalsIgnoreCase("com.tencent.biz.eqq.EnterpriseDetailActivity")) {
                                str2 = ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class);
                            } else if (str2.equalsIgnoreCase("com.tencent.biz.troopbar.TroopBarDetailActivity") || PublicAccountDetailActivityImpl.TAG.equals(str2) || "com.tencent.biz.pubaccount.AccountDetailActivity".equals(str2)) {
                                str2 = ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountDetailActivity.class);
                            }
                            if (!((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountDetailActivity.class).equals(str2)) {
                                if (P2()) {
                                    return true;
                                }
                                String stringExtra5 = intent.getStringExtra("account_type");
                                if (stringExtra5 != null && Integer.parseInt(stringExtra5) == 2) {
                                    if (QidianManager.O(parseInt)) {
                                        intent.putExtra(str6, parseInt);
                                        str2 = "com.tencent.qidian.QidianProfileCardActivity";
                                    } else {
                                        str2 = ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class);
                                    }
                                }
                                if (!TextUtils.isEmpty(str3) && str3.toLowerCase().equals("app")) {
                                    intent.putExtra("source", 117);
                                } else {
                                    intent.putExtra("source", 2);
                                }
                                intent.addFlags(67108864);
                            } else if (((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class).equals(str2)) {
                                if (QidianManager.O(parseInt)) {
                                    str2 = "com.tencent.qidian.QidianProfileCardActivity";
                                    intent.putExtra(str6, parseInt);
                                }
                            } else {
                                intent.addCategory("android.intent.category.LAUNCHER");
                                intent.addFlags(268435456);
                            }
                            if ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(str2)) {
                                String stringExtra6 = intent.getStringExtra("url");
                                if (!TextUtils.isEmpty(stringExtra6) && !stringExtra6.startsWith("http")) {
                                    QLog.e("JumpAction", 1, "unsupport protocol: " + stringExtra6);
                                    return false;
                                }
                            }
                            intent.setClassName(str, str2);
                            this.f307437b.startActivity(intent);
                            x3(str2);
                        }
                        parseInt = 0;
                        if (!str2.equalsIgnoreCase("com.tencent.biz.eqq.EnterpriseDetailActivity")) {
                        }
                        if (!((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountDetailActivity.class).equals(str2)) {
                        }
                        if ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(str2)) {
                        }
                        intent.setClassName(str, str2);
                        this.f307437b.startActivity(intent);
                        x3(str2);
                    } else {
                        intent.setClassName(str, str2);
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.addFlags(268435456);
                        this.f307437b.startActivity(intent);
                    }
                }
                e16.printStackTrace();
                return false;
            }
            if (z16 && !TextUtils.isEmpty(str4)) {
                return q3(intent, str2, str4);
            }
            return true;
        }
        return false;
    }

    private void O3(long j3) {
        b.a e16 = OpenSdkShareReporterProxy.e(j3);
        OpenSdkShareReporterProxy.f(j3, this.f307441f);
        OpenSdkShareReporterProxy.d().c(e16);
    }

    private boolean P0() {
        int i3;
        String str;
        try {
            if (this.f307441f.containsKey("kSrouce")) {
                str = this.f307441f.get("from");
            } else {
                str = "22";
            }
            i3 = Integer.parseInt(str);
        } catch (Exception unused) {
            QLog.i("JumpAction", 1, "gotoBindNumberActivity from value format wrong");
            i3 = 22;
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) BindNumberActivity.class);
        intent.putExtra("kSrouce", i3);
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean P1() {
        String str;
        String str2;
        if (this.f307438c == null) {
            return false;
        }
        if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.f307444i, this.f307438c)) {
            QLog.e("JumpAction", 1, "has no right to handle this schema");
            return false;
        }
        if (this.f307438c.startsWith("mqzone")) {
            str = this.f307438c;
        } else if (this.f307438c.startsWith("mqqzone")) {
            str = "mqzone" + this.f307438c.substring(7);
        } else {
            if (this.f307438c.contains("schema=")) {
                if (this.f307438c.contains("%")) {
                    str2 = URLUtil.getArgumentsFromURL(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                } else if (Y) {
                    str2 = URLUtil.getArgusFromURLWithoutDecode(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                } else {
                    str2 = URLUtil.getArgumentsFromURL(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        str = new String(Base64.decode(str2, 0), "utf-8");
                    } catch (Exception e16) {
                        QLog.e("JumpAction", 1, e16, new Object[0]);
                    }
                }
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("cmd", "Schema");
            intent.putExtra(QZoneDTLoginReporter.SCHEMA, str);
            if (z3(str)) {
                ((IWSManager) QRoute.api(IWSManager.class)).enterTrendsTabWs(this.f307437b, "from_trends_tab", this.f307450o, this.A, intent);
            } else {
                QZoneHelper.forwardToQzoneTransluentActivity((Activity) this.f307437b, QZoneHelper.UserInfo.getInstance(), intent);
            }
        } else {
            QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
        }
        return true;
    }

    private boolean P2() {
        IPublicAccountDetail findAccountDetailInfo;
        if (!AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT.equals(this.f307441f.get("uin")) || (findAccountDetailInfo = ((IPublicAccountDataManager) this.Q.getRuntimeService(IPublicAccountDataManager.class, "")).findAccountDetailInfo(AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT)) == null || findAccountDetailInfo.getFollowType() != 1) {
            return false;
        }
        ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(this.f307437b, new GuildPublicAccountParams(6));
        return true;
    }

    private void P3() {
        String f16 = f("buddyuin");
        if (!f16.isEmpty()) {
            long parseLong = Long.parseLong(f16);
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + parseLong);
            }
            TroopWithCommonFriendsFragment.Ih(f16);
            TroopWithCommonFriendsFragment.zh(this.f307437b, 1);
            ReportController.o(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
        }
    }

    private boolean Q0() {
        int i3;
        String str;
        String str2;
        String str3;
        TroopManager troopManager;
        FriendsManager friendsManager;
        String str4;
        String str5;
        QQAppInterface qQAppInterface;
        String j3;
        int i16;
        String str6;
        String str7;
        String str8;
        byte[] bArr;
        int i17;
        int i18;
        QQAppInterface qQAppInterface2;
        QQAppInterface qQAppInterface3;
        int i19;
        String str9;
        String str10;
        Intent intent;
        String F;
        final String str11 = this.f307441f.get("uin");
        String E = ax.E(this.f307441f.get("attach_content"));
        final String str12 = this.f307441f.get("chat_type");
        String str13 = this.f307441f.get(QCircleSchemeAttr.WebView.OPEN_TYPE);
        String str14 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        this.f307441f.get("sigt");
        String str15 = this.f307441f.get(PreloadTRTCPlayerParams.KEY_SIG);
        String str16 = this.f307441f.get("show_break_ice");
        String E2 = ax.E(this.f307441f.get("gray_text"));
        String E3 = ax.E(this.f307441f.get("open_id"));
        String E4 = ax.E(this.f307441f.get("app_id"));
        String E5 = ax.E(this.f307441f.get(TagName.APP_PKG_NAME));
        final String str17 = this.f307441f.get("reply_content");
        final String str18 = this.f307441f.get("reply_time");
        if (QLog.isColorLevel()) {
            i3 = 3;
            QLog.i("JumpAction", 2, String.format("gotoChat [uin,type,replyContent,replyTime]=[%s,%s,%s,%s]", str11, str12, str17, str18));
        } else {
            i3 = 3;
        }
        String str19 = this.f307441f.get(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
        String str20 = this.f307441f.get("params");
        if (str20 != null && QLog.isDevelopLevel()) {
            str = str19;
            str2 = str20;
            QLog.d("JumpAction", 4, str20 + "");
        } else {
            str = str19;
            str2 = str20;
        }
        QQAppInterface qQAppInterface4 = this.Q;
        byte[] bArr2 = null;
        if (qQAppInterface4 != null) {
            FriendsManager friendsManager2 = (FriendsManager) qQAppInterface4.getManager(QQManagerFactory.FRIENDS_MANAGER);
            troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER);
            friendsManager = friendsManager2;
            str3 = E;
        } else {
            str3 = E;
            troopManager = null;
            friendsManager = null;
        }
        FriendsManager friendsManager3 = friendsManager;
        String str21 = "wpa";
        if ("c2c".equals(str12)) {
            if (str11 != null && str11.length() >= 5) {
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("async_get_is_friend_flag_9080_127290151", true)) {
                    F = ac.F(this.Q, str11);
                    if ("chat".equals(str13)) {
                        final long currentTimeMillis = System.currentTimeMillis();
                        final String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str11);
                        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "MessageNotification", new hx3.b() { // from class: com.tencent.mobileqq.utils.ba
                            @Override // hx3.b
                            public final void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                                JumpActionLegacy.this.D3(currentTimeMillis, uidFromUin, str11, str17, str18, str12, eVar);
                            }
                        });
                        return true;
                    }
                    QLog.w("JumpAction", 1, "[goToChat] " + str13 + " is not supported by chat type c2c");
                } else if (com.tencent.qqnt.contact.friends.b.f355778a.c(str11, "JumpAction")) {
                    F = ac.F(this.Q, str11);
                    if ("chat".equals(str13)) {
                        Intent intent2 = new Intent(this.f307437b, (Class<?>) ChatActivity.class);
                        intent2.putExtra("uin", str11);
                        intent2.putExtra("uintype", 0);
                        if (F != null) {
                            intent2.putExtra("uinname", F);
                        }
                        if (!TextUtils.isEmpty(str17)) {
                            intent2.putExtra(AppConstants.Key.KEY_AIO_REPLY_CONTENT, str17);
                            intent2.putExtra(AppConstants.Key.KEY_AIO_REPLY_TIME, str18);
                        }
                        intent2.addFlags(67108864);
                        this.f307437b.startActivity(intent2);
                        ReportController.o(this.Q, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
                        return true;
                    }
                } else {
                    QLog.i("JumpAction", 1, "[goToChat]: isFriend false, type is " + str12 + " uin is " + str11);
                    return false;
                }
                str4 = "";
                str5 = "JumpAction";
                bArr = null;
                str8 = null;
                str7 = F;
                i17 = 0;
            } else {
                return false;
            }
        } else if ("discuss".equals(str12)) {
            if (str11 != null && str11.length() >= 6) {
                str4 = "";
                str5 = "JumpAction";
                str8 = null;
                str7 = this.f307441f.get("discuss_info");
                i17 = 3000;
                bArr = null;
            } else {
                return false;
            }
        } else {
            if (VipFunCallConstants.KEY_GROUP.equals(str12)) {
                if (str11 == null || str11.length() < 6) {
                    return false;
                }
                if (troopManager == null) {
                    QLog.e("JumpAction", 1, "[goToChat]: troopManager is null");
                    return false;
                }
                TroopInfo k3 = troopManager.k(str11);
                if (k3 != null) {
                    str9 = k3.getTroopDisplayName();
                    if ("chat".equals(str13)) {
                        if (this.f307437b == null) {
                            return false;
                        }
                        Intent intent3 = new Intent(this.f307437b, (Class<?>) ChatActivity.class);
                        intent3.putExtra("key_peerId", str11);
                        intent3.putExtra("key_chat_type", 2);
                        if (str9 != null) {
                            intent3.putExtra("key_chat_name", str9);
                        }
                        o0(intent3);
                        this.f307437b.startActivity(intent3);
                        return true;
                    }
                    i19 = 1;
                } else {
                    QLog.i("JumpAction", 1, "[goToChat]: not find troopInfo, uin is " + str11);
                    return false;
                }
            } else if (IRobotUtilApi.MMKV_SCENE_ID.equals(str12)) {
                if (str11 != null && !"".equals(str11)) {
                    str4 = "";
                    str5 = "JumpAction";
                    bArr = null;
                    str8 = null;
                    str7 = ac.G(this.Q, str11);
                    i17 = 1001;
                } else {
                    return false;
                }
            } else if (str21.equals(str12)) {
                if (str11 != null && str11.length() >= 5 && (qQAppInterface3 = this.Q) != null && !str11.equals(qQAppInterface3.getCurrentAccountUin())) {
                    if (friendsManager3 != null && friendsManager3.c0(str11)) {
                        str9 = ac.G(this.Q, str11);
                        i19 = 0;
                    } else {
                        i19 = 1005;
                        str9 = null;
                    }
                    W3(str11);
                    str21 = str21;
                } else {
                    return false;
                }
            } else {
                if ("crm".equals(str12)) {
                    boolean W2 = W2();
                    String str22 = this.f307441f.get("uid");
                    if (!TextUtils.isEmpty(str22) && !TextUtils.isEmpty(str11)) {
                        com.tencent.relation.common.utils.h.d().i(str11, str22);
                    }
                    if (!W2) {
                        W2 = V2();
                    }
                    if (!W2) {
                        W2 = U2();
                    }
                    if (!W2) {
                        return Q2();
                    }
                    return W2;
                }
                if ("lbs".equals(str12) || "date".equals(str12)) {
                    str4 = "";
                    str5 = "JumpAction";
                    if (str11 != null && str11.length() >= 5 && (qQAppInterface = this.Q) != null && !str11.equals(qQAppInterface.getCurrentAccountUin())) {
                        if (friendsManager3 != null && friendsManager3.c0(str11)) {
                            j3 = ac.G(this.Q, str11);
                            str6 = null;
                            i16 = 0;
                        } else if ("lbs".equals(str12)) {
                            j3 = ac.j(this.Q, str11);
                            str6 = AppConstants.Key.KYE_RICH_ACCOST_SIG;
                            i16 = 1001;
                        } else {
                            j3 = ac.j(this.Q, str11);
                            i16 = 1010;
                            str6 = AppConstants.Key.KYE_RICH_DATE_SIG;
                        }
                        if (str6 != null && str15 != null) {
                            bArr2 = HexUtil.hexStr2Bytes(str15);
                        }
                        str7 = j3;
                        str8 = str6;
                        str21 = str21;
                        bArr = bArr2;
                        i17 = i16;
                    } else {
                        return false;
                    }
                } else {
                    if (SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(str12)) {
                        if (str11 != null && str11.length() >= 6) {
                            int i26 = i3;
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.Q, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str11, "0X800589E", "0X800589E", 0, 0, str11, "", "", "", false);
                            if ("2747277822".equals(str11) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()) {
                                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(this.f307437b, 4, this.f307441f);
                            } else if ("3593944551".equals(str11) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isCustomGameMallPubAccount()) {
                                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameMallPubAccount(this.f307437b, 4);
                            } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(str11)) {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(this.f307437b);
                            } else if (IPublicAccountUtil.UIN_FOR_SHOP.equals(str11)) {
                                ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(this.f307437b);
                            } else if (qb2.a.f428781a.equals(str11)) {
                                if (!qb2.b.e(this.f307437b, str11, i26)) {
                                    ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).openPublicAccountCommonAIO(this.f307437b, str11);
                                }
                            } else if (AppConstants.QQ_VIP_UIN.equals(str11)) {
                                s23.a.j(this.f307437b, "search");
                            } else if (AppConstants.QQ_YELLOW_VIP_UIN.equals(str11)) {
                                y33.b.f449310a.d(this.f307437b, "search");
                            } else if (((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).isVipRead(str11)) {
                                ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).startVipReadFragment(this.f307437b);
                            } else {
                                if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherPA(str11) && ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivityBySearch(this.f307437b, this.Q)) {
                                    QLog.i("JumpAction", 1, "gotoChat startNewWeatherWebPageActivity");
                                    return true;
                                }
                                if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isHealthUin(str11) && (qQAppInterface2 = this.Q) != null) {
                                    IQQHealthService iQQHealthService = (IQQHealthService) qQAppInterface2.getRuntimeService(IQQHealthService.class);
                                    if (iQQHealthService != null) {
                                        QLog.i("JumpAction", 1, "health search redirect aio to mainPage is" + iQQHealthService.redirectAIOToMainPage(this.f307437b, 164));
                                    }
                                } else if (!((IQQComicConfigApi) QRoute.api(IQQComicConfigApi.class)).launchIfMatched(str11, this.f307437b, 1005, this.Q) && !((IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class)).startQQNewsPAIfMatched(this.f307437b, str11)) {
                                    if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str11)) {
                                        ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).launchQCircleFromPublicAccount(this.Q, this.f307437b, QCirclePublicAccountLauncherSource.SEARCH);
                                    } else if (AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN.equals(str11) && this.Q != null) {
                                        ((IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class)).launchMainPage(this.Q, this.f307437b, EcommerceMsgCenterSource.SEARCH);
                                    } else if (AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT.equals(str11)) {
                                        ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(this.f307437b, new GuildPublicAccountParams(2));
                                    } else if (AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN.equals(str11)) {
                                        ((IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class)).launchSmallHomeMainPageFromPublicAccount(this.Q, this.f307437b, "search");
                                    } else if (AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN.equals(str11)) {
                                        ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountPage(this.Q, this.f307437b, "");
                                    } else if (AppConstants.VALUE.UIN_QZONE.equals(str11)) {
                                        ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(this.f307437b);
                                    } else {
                                        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).openPublicAccountCommonAIO(this.f307437b, str11);
                                    }
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                    if ("qd_account".equals(str12)) {
                        if (str11 == null || str11.length() < 6) {
                            return false;
                        }
                        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f307437b), new int[]{2});
                        m3.putExtra("uin", str11);
                        m3.putExtra("uintype", 1008);
                        String str23 = this.f307441f.get("key");
                        String str24 = this.f307441f.get("kfuin");
                        String str25 = this.f307441f.get("assign_type");
                        String str26 = this.f307441f.get("assign_key");
                        String str27 = this.f307441f.get("ext");
                        String str28 = this.f307441f.get("rkey");
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "QD_ACCOUNT_TYPE " + str24 + " " + str25 + " " + str26 + " " + str27 + " " + str28);
                        }
                        if (!TextUtils.isEmpty(str23) && !TextUtils.isEmpty(str24)) {
                            m3.putExtra("qd_wpa_key", str23);
                            m3.putExtra("qd_kfuin", str24);
                            if (!TextUtils.isEmpty(str25)) {
                                m3.putExtra("assign_type", str25);
                            }
                            if (!TextUtils.isEmpty(str26)) {
                                m3.putExtra("assign_key", str26);
                            }
                            if (!TextUtils.isEmpty(str27)) {
                                m3.putExtra("assign_ext", str27);
                            }
                            if (!TextUtils.isEmpty(str28)) {
                                m3.putExtra("rkey", str28);
                            }
                            this.f307437b.startActivity(m3);
                            return true;
                        }
                        return false;
                    }
                    if (!"thirdparty2c".equals(str12) && !"audio_chat".equals(str12) && !"video_chat".equals(str12)) {
                        return false;
                    }
                    if (!NetworkUtil.isNetSupport(this.f307437b)) {
                        QQToast.makeText(this.f307437b, 1, R.string.izc, 1).show();
                        Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
                        aliasIntent.addFlags(67108864);
                        aliasIntent.addFlags(268435456);
                        this.f307437b.startActivity(aliasIntent);
                        return true;
                    }
                    if (!TextUtils.isEmpty(E3)) {
                        Handler handler = new Handler();
                        this.E = handler;
                        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.16
                            @Override // java.lang.Runnable
                            public void run() {
                                JumpActionLegacy.this.F = true;
                            }
                        }, 20000L);
                        try {
                            if ("thirdparty2c".equals(str12)) {
                                i18 = 18;
                            } else {
                                if (!"audio_chat".equals(str12) && !"video_chat".equals(str12)) {
                                    i18 = 10000;
                                }
                                i18 = 19;
                            }
                            int i27 = i18;
                            ForwardStatisticsReporter.m("KEY_STAGE_2_GO_TO_CHAT_D55");
                            this.Q.getMsgHandler().M2(true, E3, false, 0L, Long.valueOf(E4).longValue(), 1, i27, E5, false, 0L, new e(E3, E4, str12));
                            return false;
                        } catch (Exception unused) {
                            return true;
                        }
                    }
                    return true;
                }
            }
            str5 = "JumpAction";
            bArr = null;
            str8 = null;
            str7 = str9;
            i17 = i19;
            str4 = "";
        }
        if ("scalechat".equals(str13)) {
            final boolean z16 = !"false".equals(this.f307441f.get("clearPrevious"));
            if ("push".equals(str14)) {
                final Bundle bundle = new Bundle();
                Context context = this.f307437b;
                if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
                    str10 = intent.getStringExtra("key_from");
                    if (!TextUtils.isEmpty(str10)) {
                        bundle.putString("key_from", str10);
                    }
                } else {
                    str10 = str4;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(str5, 4, "gotoScaleChat, pushFrom " + str10);
                }
                final int i28 = i17;
                final String str29 = str7;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.18
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.activity.aio.l.a0(JumpActionLegacy.this.f307437b, str11, i28, str29, bundle, 0, z16);
                    }
                });
                return true;
            }
            com.tencent.mobileqq.activity.aio.l.a0(this.f307437b, str11, i17, str7, null, 0, z16);
            return true;
        }
        String str30 = str4;
        Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f307437b), new int[]{2});
        m16.putExtra("uin", str11);
        m16.putExtra("uintype", i17);
        if (str7 != null) {
            m16.putExtra("uinname", str7);
        }
        if (str3 != null) {
            m16.putExtra("input_text", str3);
        }
        if (!TextUtils.isEmpty(str17)) {
            m16.putExtra(AppConstants.Key.KEY_AIO_REPLY_CONTENT, str17);
            m16.putExtra(AppConstants.Key.KEY_AIO_REPLY_TIME, str18);
        }
        if (bArr != null && bArr.length > 0) {
            m16.putExtra(str8, bArr);
        }
        if (!TextUtils.isEmpty(str16)) {
            m16.putExtra(AppConstants.Key.KEY_AIO_BREAK_ICE, str16);
            m16.putExtra(AppConstants.Key.KEY_GRAY_TEXT, E2);
            QLog.i(str5, 1, "aio show break ice:" + str16 + ", gray_text:" + E2);
        }
        if (this.f307441f.containsKey(AppConstants.Key.KEY_SHOW_SEARCH_EMOJI)) {
            m16.putExtra(AppConstants.Key.KEY_SHOW_SEARCH_EMOJI, true);
            String str31 = this.f307441f.get(AppConstants.Key.KEY_SHOW_SEARCH_EMOJI);
            String str32 = this.f307441f.get("default_search_select");
            m16.putExtra(AppConstants.Key.KEY_SEARCH_EMOJI_TEXT, str31);
            if (!TextUtils.isEmpty(str32)) {
                try {
                    m16.putExtra(AppConstants.Key.KEY_SEARCH_EMOJI_DEFAULT_SELECT, Integer.parseInt(str32));
                } catch (NumberFormatException e16) {
                    QLog.e(str5, 1, "aio show search emoji, parse default select index error.", e16);
                }
            }
            QLog.d(str5, 1, "aio show search emoji: ", str31, ", defaultSelect: ", str32);
        }
        if (VipFunCallConstants.KEY_GROUP.equals(str12) && this.f307441f.containsKey(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE)) {
            o0(m16);
        }
        if (str2 != null) {
            String str33 = str2;
            if (!str30.equals(str33)) {
                if (str11 != null && !str30.equals(str11)) {
                    String str34 = this.f307441f.get("callback_type");
                    String E6 = ax.E(this.f307441f.get("thirdAppDisplayName"));
                    String str35 = this.f307441f.get("appid");
                    if (str34 != null && !str30.equals(str34)) {
                        m16.putExtra("callback_type", str34);
                    }
                    if (E6 != null && !str30.equals(E6)) {
                        m16.putExtra("thirdAppDisplayName", E6);
                    }
                    if (str35 != null && !str30.equals(str35)) {
                        m16.putExtra("appid", str35);
                    }
                    j4(m16, str33);
                    ReportController.o(this.Q, "CliOper", "", str11, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
                    if ("webview".equals(this.f307443h)) {
                        m16.putExtra("from", this.f307443h);
                        int i29 = ax.K;
                        if (i29 > 3) {
                            QQToast.makeText(this.f307437b, HardCodeUtil.qqStr(R.string.nio), 1).show();
                            return true;
                        }
                        ax.K = i29 + 1;
                        ReportController.o(this.Q, "CliOper", "", str11, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(this.Q, "CliOper", "", str11, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
                    }
                } else {
                    return false;
                }
            }
        }
        if (str != null) {
            m16.putExtra(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, str);
        }
        if (str21.equals(str12)) {
            ((QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).w3(str11, m16);
        } else {
            this.f307437b.startActivity(m16);
        }
        return true;
    }

    private boolean Q1() {
        String str;
        if (this.Q.getCurrentUin().equals(this.f307441f.get(ShortVideoConstants.FROM_UIN))) {
            String str2 = this.f307441f.get("uin");
            String str3 = this.f307441f.get(QZoneHelper.INTENT_EXTINFO);
            if (TextUtils.isEmpty(str3)) {
                str = "mqzone://arouse/homepage?redpocket=1&uin=" + str2;
            } else {
                str = "mqzone://arouse/homepage?redpocket=1&uin=" + str2 + "&extinfo=" + str3;
            }
            Intent intent = new Intent();
            intent.putExtra("cmd", "Schema");
            intent.putExtra(QZoneDTLoginReporter.SCHEMA, str);
            QZoneHelper.forwardToQzoneTransluentActivity((Activity) this.f307437b, QZoneHelper.UserInfo.getInstance(), intent);
        } else {
            this.f307441f.get("uin");
            String str4 = this.f307441f.get(AppConstants.Key.SHARE_REQ_SHARE_JFROM);
            if (!TextUtils.isEmpty(str4) && str4.equals("login")) {
                QQToast.makeText(this.f307437b, HardCodeUtil.qqStr(R.string.niq), 1).show();
            } else {
                QQToast.makeText(this.f307437b, HardCodeUtil.qqStr(R.string.f172124nj0), 1).show();
                String str5 = this.f307438c;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                String str6 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                if (str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > -1) {
                    str6 = ContainerUtils.FIELD_DELIMITER;
                }
                sb5.append(str6);
                String str7 = sb5.toString() + "jfrom=login";
                Intent intent2 = new Intent();
                intent2.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, str7);
                intent2.putExtra("pkg_name", "com.tencent.mobileqq");
                intent2.putExtras(intent2);
                intent2.setFlags(268435456);
                if (VersionUtils.isHoneycomb()) {
                    intent2.addFlags(32768);
                }
                RouteUtils.startActivity(this.f307437b, intent2, RouterConstants.UI_ROUTER_LOGIN);
            }
        }
        return true;
    }

    private boolean Q2() {
        String str = this.f307441f.get("uin");
        if (str != null && str.length() >= 5 && !str.equals(this.Q.getCurrentAccountUin())) {
            String E = ax.E(this.f307441f.get("attach_content"));
            String str2 = this.f307441f.get("sigt");
            String str3 = this.f307441f.get(PreloadTRTCPlayerParams.KEY_SIG);
            String str4 = this.f307441f.get("shouldReturnToRoot");
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(str4) && !str4.equals("NO")) {
                intent.setComponent(SplashActivity.getAliasComponent(this.f307437b));
                intent.putExtra("open_chatfragment", true);
            } else {
                intent.setComponent(new ComponentName(this.f307437b, (Class<?>) ChatActivity.class));
            }
            intent.addFlags(67108864);
            int m3 = CrmUtils.m(this.Q, str);
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + m3);
            }
            intent.putExtra(AppConstants.Key.KEY_FROM_WPA_FOR_CRM, true);
            intent.putExtra("uin", str);
            intent.putExtra("uintype", m3);
            if (m3 == 0) {
                String G = ac.G(this.Q, str);
                if (G != null) {
                    intent.putExtra("uinname", G);
                }
            } else if (m3 == 1024) {
                intent.putExtra("chat_subType", 1);
            }
            if (E != null) {
                intent.putExtra("input_text", E);
            }
            if (str3 != null) {
                this.Q.getMsgCache().h(str, HexUtil.hexStr2Bytes(str3));
            }
            if (str2 != null) {
                intent.putExtra("sigt", HexUtil.hexStr2Bytes(str2));
            }
            this.f307437b.startActivity(intent);
            QQAppInterface qQAppInterface = this.Q;
            ReportController.o(qQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, qQAppInterface.getCurrentAccountUin(), str, "", "");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (!this.f307441f.containsKey("packageName")) {
            str = "";
        } else {
            str = this.f307441f.get("packageName");
        }
        if (!this.f307441f.containsKey("signareMode")) {
            str2 = "";
        } else {
            str2 = this.f307441f.get("signareMode");
        }
        if (!this.f307441f.containsKey("appid")) {
            str3 = "";
        } else {
            str3 = this.f307441f.get("appid");
        }
        if (!this.f307441f.containsKey(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)) {
            str4 = "";
        } else {
            str4 = this.f307441f.get(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
        }
        if (!this.f307441f.containsKey("resetWordMode")) {
            str5 = "";
        } else {
            str5 = this.f307441f.get("resetWordMode");
        }
        if (this.f307441f.containsKey("offerid")) {
            str6 = this.f307441f.get("offerid");
        }
        String str7 = str6;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "packageName : " + str + " signatureMode :" + str2 + " appid : " + str3 + " timestamp : " + str4 + " resetWordMode : " + str5 + " offerId : " + str7);
        }
        ((QWalletAuthHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).D2(new ReqCheckChangePwdAuth(str, str2, str3, str4, str5, str7));
        q qVar = new q();
        this.T = qVar;
        com.tencent.mobileqq.app.cl clVar = new com.tencent.mobileqq.app.cl(qVar);
        this.U = clVar;
        this.Q.addObserver(clVar);
    }

    private boolean R0() {
        TroopManager troopManager;
        String str = this.f307441f.get("uin");
        if (str == null || str.length() < 6 || (troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER)) == null) {
            return false;
        }
        TroopInfo k3 = troopManager.k(str);
        if (k3 != null) {
            String troopDisplayName = k3.getTroopDisplayName();
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(this.f307437b));
            Intent m3 = BaseAIOUtils.m(intent, new int[]{2});
            m3.putExtra("uin", str);
            m3.putExtra("uintype", 1);
            if (troopDisplayName != null) {
                m3.putExtra("uinname", troopDisplayName);
            }
            this.f307437b.startActivity(m3);
            return true;
        }
        return t2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R1(boolean z16) {
        long j3;
        String str;
        String str2;
        String str3;
        int i3;
        String str4;
        c.QzoneShareContent qzoneShareContent;
        String str5;
        Bundle bundle = new Bundle();
        try {
            j3 = Long.valueOf(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH)).longValue();
        } catch (Exception unused) {
            j3 = 0;
        }
        if (j3 <= 0) {
            return false;
        }
        String E = ax.E(this.f307441f.get("open_id"));
        String E2 = ax.E(this.f307441f.get("share_uin"));
        String E3 = ax.E(this.f307441f.get("share_qzone_ext_str"));
        bundle.putString("open_id", E);
        bundle.putString("share_uin", E2);
        if (!TextUtils.isEmpty(E3)) {
            bundle.putString(QZoneShareManager.QZONE_SHARE_EXTSTRING, E3);
            try {
                JSONObject jSONObject = new JSONObject(E3);
                String optString = jSONObject.optString("tagTitle");
                String optString2 = jSONObject.optString("thirdPartyAppId");
                String optString3 = jSONObject.optString("thirdPartyUrl");
                if (!TextUtils.isEmpty(optString)) {
                    bundle.putParcelable(QZoneShareManager.QZONE_SHARE_EVENT_TAG, PublishEventTag.assembleFakeTag(optString, "0"));
                }
                if (!TextUtils.isEmpty(optString2)) {
                    bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, optString2);
                    if (!TextUtils.isEmpty(optString3)) {
                        bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, optString3);
                    }
                }
                QLog.i("JumpAction", 1, "gotoQzonePublishMood tagTitle:" + optString + "thirdPartyAppId:" + optString2 + "thirdPartyUrl:" + optString3);
            } catch (Exception e16) {
                QLog.e("JumpAction", 1, "gotoQzonePublishMood parse exception:", e16);
            }
        }
        int intValue = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE))).intValue();
        if (intValue != 3) {
            str = "";
            str2 = "images";
            str3 = E3;
            i3 = 4;
            if (intValue == 4) {
                String E4 = ax.E(this.f307441f.get("videoPath"));
                try {
                    bundle.putLong(ShortVideoConstants.FILE_SEND_DURATION, Long.valueOf(ax.E(this.f307441f.get("videoDuration"))).longValue());
                } catch (Exception unused2) {
                }
                try {
                    bundle.putLong(PeakConstants.VIDEO_SIZE, Long.valueOf(ax.E(this.f307441f.get(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE))).longValue());
                } catch (Exception unused3) {
                }
                String E5 = ax.E(this.f307441f.get("description"));
                bundle.putBoolean(PeakConstants.IS_VIDEO_SELECTED, true);
                bundle.putInt(PeakConstants.VIDEO_TYPE, 1);
                bundle.putString("file_send_path", E4);
                bundle.putBoolean(PeakConstants.VIDEO_NEED_PROCESS, false);
                bundle.putString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, E5);
                qzoneShareContent = new c.QzoneShareContent(j3, "", E5, E4);
                str4 = "8";
            } else {
                str4 = str;
                qzoneShareContent = null;
            }
        } else {
            String E6 = ax.E(this.f307441f.get("description"));
            String E7 = ax.E(this.f307441f.get("image_url"));
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(E7)) {
                for (String str6 : E7.split(";")) {
                    arrayList.add(URLDecoder.decode(str6));
                }
            }
            bundle.putStringArrayList("images", arrayList);
            bundle.putString("summary", E6);
            str = "";
            str3 = E3;
            i3 = 4;
            str2 = "images";
            str4 = "7";
            qzoneShareContent = new c.QzoneShareContent(j3, "", E6, E7);
        }
        String E8 = ax.E(this.f307441f.get("app_name"));
        bundle.putString("app_name", E8);
        if (!TextUtils.isEmpty(this.f307444i)) {
            bundle.putString(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, String.valueOf(j3));
        }
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, intValue);
        bundle.putLong("req_share_id", j3);
        bundle.putString("pkg_name", this.f307444i);
        bundle.putBoolean("key_need_save_draft", false);
        bundle.putBoolean(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, z16);
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
        QZoneShareManager.publishToQzone(this.Q, this.f307437b, bundle, new g());
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = "1";
        reportInfo.subactionType = "0";
        reportInfo.tabletype = i3;
        reportInfo.sourceType = "5";
        reportInfo.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "5");
        hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str2);
        if (stringArrayList != null && stringArrayList.size() > 9) {
            reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_UPLOADPHOTO;
            hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_UPLOADPHOTO);
        } else {
            reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_PUBLISHMOOD;
            hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_PUBLISHMOOD);
        }
        QZoneClickReport.startReportImediately(this.Q.getAccount(), reportInfo);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.Q.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
        ReportCenter.f().n(this.Q.getAccount(), "", j3 + str, "11", "12", "0", str4, "", "4", false);
        if (qzoneShareContent == null) {
            str5 = E8;
            qzoneShareContent = new c.QzoneShareContent(j3, "", str3, "");
        } else {
            str5 = E8;
        }
        com.tencent.open.agent.report.c.a(qzoneShareContent);
        QZoneLoginReportHelper.reportLoginFromThirdSharePublish(j3, str5);
        return true;
    }

    private void R2() {
        try {
            if ("head".equals(this.f307440e)) {
                if (this.R == null) {
                    this.R = new p(this);
                }
                if (this.f307456u == null) {
                    this.f307456u = new Hashtable<>();
                }
                this.Q.addObserver(this.R);
                long currentTimeMillis = System.currentTimeMillis();
                String[] split = this.f307441f.get("uin").split(",");
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) e().getRuntimeService(IQQAvatarHandlerService.class, "");
                for (String str : split) {
                    iQQAvatarHandlerService.getCustomHead(str);
                    this.f307456u.put(str, Long.valueOf(currentTimeMillis));
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("JumpAction", 2, "handleMQQService error " + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R3() {
        int i3;
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.Q.getCurrentAccountUin());
            jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "pswManage");
            if (!PayBridgeActivity.tenpay((Activity) this.f307437b, jSONObject.toString(), 5, "")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            X3(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            X3(1);
        }
    }

    private boolean S0() {
        String str;
        int i3;
        if (!this.f307441f.containsKey("interest_type")) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
            }
            return false;
        }
        String str2 = this.f307441f.get("interest_type");
        if (!this.f307441f.containsKey("from")) {
            str = "";
        } else {
            str = this.f307441f.get("from");
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = " + str2);
        }
        try {
            i3 = Integer.valueOf(str2).intValue();
        } catch (Exception unused) {
            i3 = 0;
        }
        if ("interesttag_selector".equals(this.f307440e)) {
            try {
                Intent intent = new Intent();
                intent.putExtra("is_from_judge", true);
                intent.putExtra("interest_tag_type", i3);
                intent.putExtra("from_where", "web_to_choose_tag");
                if ("10002".equals(str)) {
                    intent.addFlags(268435456);
                }
                RouteUtils.startActivity(this.f307437b, intent, "/nearby/choose/interesttag");
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "", e16);
                }
            }
        }
        return false;
    }

    private boolean S1() {
        int intValue = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE))).intValue();
        if (intValue == 3) {
            final String E = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_IMAGE_URI));
            if (!TextUtils.isEmpty(E)) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.20
                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuffer stringBuffer = new StringBuffer();
                        String[] split = E.split(";");
                        for (int i3 = 0; i3 < split.length; i3++) {
                            String decode = URLDecoder.decode(split[i3]);
                            if (!TextUtils.isEmpty(decode)) {
                                Pair<Boolean, String> safeSaveFileUriToFile = FileUtils.safeSaveFileUriToFile(JumpActionLegacy.this.f307437b, decode, "opensdk_tmp");
                                if (!safeSaveFileUriToFile.first.booleanValue()) {
                                    Context context = JumpActionLegacy.this.f307437b;
                                    if (context instanceof JumpActivity) {
                                        ((JumpActivity) context).finish();
                                        return;
                                    }
                                    return;
                                }
                                String str = safeSaveFileUriToFile.second;
                                if (!TextUtils.isEmpty(str)) {
                                    stringBuffer.append(URLEncoder.encode(str));
                                    if (i3 != split.length - 1) {
                                        stringBuffer.append(";");
                                    }
                                }
                            }
                        }
                        try {
                            JumpActionLegacy.this.f307441f.put("image_url", new String(PluginBaseInfoHelper.Base64Helper.encode(stringBuffer.toString().getBytes("UTF-8"), 0)));
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e("JumpAction", 1, "gotoQzonePublishMoodCheck  exception:", e16);
                        }
                        JumpActionLegacy.this.R1(false);
                    }
                });
            } else {
                R1(true);
            }
        } else if (intValue == 4) {
            final String E2 = ax.E(this.f307441f.get("videoUri"));
            if (!TextUtils.isEmpty(E2)) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.21
                    @Override // java.lang.Runnable
                    public void run() {
                        Pair<Boolean, String> safeSaveFileUriToFile = FileUtils.safeSaveFileUriToFile(JumpActionLegacy.this.f307437b, E2, "opensdk_tmp");
                        if (!safeSaveFileUriToFile.first.booleanValue()) {
                            Context context = JumpActionLegacy.this.f307437b;
                            if (context instanceof JumpActivity) {
                                ((JumpActivity) context).finish();
                                return;
                            }
                            return;
                        }
                        String str = safeSaveFileUriToFile.second;
                        try {
                            String str2 = "";
                            if (TextUtils.isEmpty(str)) {
                                QLog.e("JumpAction", 1, "QZoneShareManager.QZONE_SHARE_TYPE_VIDEO, shareFilePath is empty.");
                            } else {
                                str2 = new String(PluginBaseInfoHelper.Base64Helper.encode(str.getBytes("UTF-8"), 0));
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                JumpActionLegacy.this.f307441f.put("videoPath", str2);
                            }
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e("JumpAction", 1, "gotoQzonePublishMoodCheck exception:", e16);
                        }
                        JumpActionLegacy.this.R1(false);
                    }
                });
            } else {
                R1(true);
            }
        }
        return true;
    }

    private boolean S2() {
        Intent intent;
        String str = this.f307441f.get("url");
        if (TextUtils.isEmpty(str)) {
            str = this.f307438c;
        }
        String str2 = this.f307441f.get("attr_original_url");
        Context context = this.f307437b;
        boolean z16 = false;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            z16 = intent.getBooleanExtra("fromQrcode", false);
        }
        ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).startQRJumpActivity(this.f307437b, str, str2, z16);
        return true;
    }

    public static String S3(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                str3 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (str.contains(str2)) {
                return str.replace(str2, str3);
            }
            return str.replace(str2.toUpperCase(), str3);
        }
        return str;
    }

    private boolean T1() {
        if (this.f307437b instanceof Activity) {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = this.Q.getCurrentAccountUin();
            userInfo.nickname = this.Q.getCurrentNickname();
            QZoneHelper.forwardToPublishQueue((Activity) this.f307437b, userInfo, -1);
            return true;
        }
        return false;
    }

    private boolean T2() {
        int i3;
        try {
            i3 = Integer.parseInt(this.f307440e);
        } catch (NumberFormatException e16) {
            QLog.e("JumpAction", 1, "handleQfavHelperAction error:" + e16.getMessage());
            i3 = -1;
        }
        if (i3 != 2) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, BaseApplicationImpl.getApplication().getApplicationContext().getString(R.string.button_back));
        return QfavHelper.i((Activity) this.f307437b, this.Q.getAccount(), intent, -1, false);
    }

    private void T3() {
        QLog.i("JumpAction", 1, "doAction, IECommerceJumpAction.handleScheme: ,action_name:" + this.f307440e + ",from:" + this.f307443h + ",source:" + this.f307438c + ",attrs: " + this.f307441f);
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.Q.getCurrentUin())) {
            hashMap.put("detailEventUin", this.Q.getCurrentUin());
        }
        hashMap.put("action_name", this.f307440e);
        hashMap.put("from", this.f307443h);
        hashMap.put("source", this.f307438c);
        HashMap<String, String> hashMap2 = this.f307441f;
        if (hashMap2 != null) {
            hashMap.put(Node.ATTRS_ATTR, String.valueOf(hashMap2));
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "IECommerceJumpAction_handleScheme", true, 0L, 0L, hashMap, "", false);
    }

    private boolean U0() {
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(this.f307437b));
        intent.setFlags(67108864);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        String str = this.f307441f.get("from");
        intent.putExtra("from", str);
        this.f307437b.startActivity(intent);
        if ("10003".equals(str)) {
            ReportController.o(this.Q, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
        } else if ("10004".equals(str)) {
            ReportController.o(this.Q, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        } else if ("10009".equals(str)) {
            QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
        }
        return true;
    }

    private boolean U1(final String str) {
        final String E = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_IMAGE_URI));
        if (TextUtils.isEmpty(E)) {
            E = ax.E(this.f307441f.get("file_uri"));
        }
        if (!TextUtils.isEmpty(E)) {
            this.f307458w = false;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.23
                @Override // java.lang.Runnable
                public void run() {
                    JumpActionLegacy.this.r0(E, str);
                }
            });
            return false;
        }
        return V1(str, true);
    }

    private boolean U2() {
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("sigt");
        String str3 = this.f307441f.get("wpaType");
        String str4 = this.f307441f.get("assignId");
        String str5 = this.f307441f.get("QidianKfUin");
        String str6 = this.f307441f.get("shouldReturnToRoot");
        boolean z16 = false;
        if (str != null && str2 != null && str3 != null && str4 != null && str5 != null) {
            try {
                this.Q.addObserver(this.W);
                ((QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).G2(str5, str2, str, str3, str4, str6);
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "handleQidianCorpWPA");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, e16.getMessage());
                }
            }
        }
        return z16;
    }

    private void U3(int i3, int i16) {
        String str;
        int i17;
        String str2 = "";
        if (!this.f307441f.containsKey("qidian")) {
            str = "";
        } else {
            str = this.f307441f.get("qidian");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                i17 = Integer.valueOf(str).intValue();
            } catch (Exception unused) {
                i17 = 0;
            }
            if (i17 == 1) {
                if (this.f307441f.containsKey("jsondata")) {
                    str2 = this.f307441f.get("jsondata");
                }
                ((QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).u3(str2, i3, i16);
            }
        }
    }

    private boolean V0() {
        QLog.i("JumpAction", 1, "[gotoCreateTroop] ");
        if (this.f307441f.get("back_title") == null) {
            HardCodeUtil.qqStr(R.string.f171898lr0);
        }
        ITroopCreateService iTroopCreateService = (ITroopCreateService) this.Q.getRuntimeService(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            iTroopCreateService.startCreateTroopSession((QBaseActivity) this.f307437b, 0);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean V1(String str, boolean z16) {
        int i3;
        int i16;
        long j3;
        String str2;
        int i17;
        int i18;
        String str3;
        int i19;
        String str4;
        String str5;
        String str6;
        String str7;
        long j16;
        String E = ax.E(this.f307441f.get("title"));
        String E2 = ax.E(this.f307441f.get("description"));
        String E3 = ax.E(this.f307441f.get("url"));
        String E4 = ax.E(this.f307441f.get("app_name"));
        String E5 = ax.E(this.f307441f.get("image_url"));
        String E6 = ax.E(this.f307441f.get("audioUrl"));
        String E7 = ax.E(this.f307441f.get("open_id"));
        String E8 = ax.E(this.f307441f.get("share_uin"));
        String str8 = this.f307441f.get(AppConstants.Key.SHARE_REQ_SHARE_JFROM);
        String E9 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE));
        String E10 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_STR));
        String E11 = ax.E(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID));
        String E12 = ax.E(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH));
        if (this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) != null) {
            i3 = Integer.valueOf(ax.E(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE))).intValue();
        } else {
            i3 = 3;
        }
        try {
            i16 = i3;
        } catch (Exception unused) {
            i16 = i3;
        }
        try {
            j3 = Long.valueOf(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH)).longValue();
        } catch (Exception unused2) {
            j3 = 0;
            if (j3 > 0) {
            }
        }
        if (j3 > 0) {
            return false;
        }
        try {
            i17 = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT))).intValue();
            str2 = AppConstants.Key.SHARE_REQ_EXT_INT;
        } catch (NumberFormatException unused3) {
            if (QLog.isColorLevel()) {
                str2 = AppConstants.Key.SHARE_REQ_EXT_INT;
                QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
            } else {
                str2 = AppConstants.Key.SHARE_REQ_EXT_INT;
            }
            i17 = 0;
        }
        try {
            i18 = Integer.valueOf(E9).intValue();
        } catch (NumberFormatException unused4) {
            if (QLog.isColorLevel()) {
                QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
            }
            i18 = 1;
        }
        if (E5 == null) {
            str3 = ax.E(this.f307441f.get("file_data"));
        } else {
            str3 = E5;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str3)) {
            String[] split = str3.split(";");
            i19 = i18;
            str4 = str3;
            for (String str9 : split) {
                arrayList.add(URLDecoder.decode(str9));
            }
        } else {
            i19 = i18;
            str4 = str3;
        }
        if (arrayList.size() > 0) {
            str5 = arrayList.get(0);
        } else {
            str5 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", E);
        bundle.putString("desc", E2);
        bundle.putString("app_name", E4);
        bundle.putLong("req_share_id", j3);
        bundle.putString("detail_url", E3);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putString("pkg_name", this.f307444i);
        bundle.putString("open_id", E7);
        bundle.putString("share_uin", E8);
        bundle.putString(AppConstants.Key.SHARE_REQ_SHARE_JFROM, str8);
        bundle.putString(AppConstants.Key.SHARE_REQ_EXT_STR, E10);
        bundle.putInt(str2, i17);
        bundle.putString(QZoneShareManager.QZONE_SHARE_ACTION, str);
        bundle.putInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, 4);
        bundle.putBoolean(AppConstants.Key.SHARE_REQ_THIRDPART, true);
        if (!TextUtils.isEmpty(E11) && !TextUtils.isEmpty(E12)) {
            bundle.putBoolean(AppConstants.Key.IS_SHARE_MINI_PROGRAM_MSG, true);
            bundle.putString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_APP_ID, E11);
            bundle.putString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_APP_PATH, E12);
            bundle.putInt(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_VER_TYPE, i16);
            bundle.putString(AppConstants.Key.SHARE_REQ_MINI_PROGRAM_IMAGE_URL, str5);
        }
        int i26 = i19;
        if (i26 == 2) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, E6);
        }
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, i26);
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
        h hVar = new h();
        bundle.putBoolean(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, z16);
        if (i26 == 5 && (i17 & 1) != 0) {
            QZoneShareManager.jumpToQzoneShare(this.Q, this.f307437b, bundle, hVar, 23);
        } else {
            QZoneShareManager.jumpToQzoneShare(this.Q, this.f307437b, bundle, hVar);
        }
        if (i26 == 1) {
            str7 = "1";
        } else {
            if (i26 == 2) {
                str6 = "3";
            } else if (i26 == 5) {
                str6 = "2";
            } else {
                str6 = "4";
            }
            str7 = str6;
        }
        try {
            j16 = j3;
            try {
                ReportCenter.f().o(this.Q.getAccount(), E7, String.valueOf(j3), "11", "12", "0", str7, "0", "0", false, true);
            } catch (Exception unused5) {
            }
        } catch (Exception unused6) {
            j16 = j3;
        }
        com.tencent.open.agent.report.c.a(new c.QzoneShareContent(j16, E3, E, str4));
        QZoneLoginReportHelper.reportLoginFromThirdPartyShare(j16, E4);
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = "1";
        reportInfo.subactionType = "0";
        reportInfo.tabletype = 4;
        reportInfo.sourceType = "5";
        reportInfo.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP;
        reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED;
        QZoneClickReport.startReportImediately(this.Q.getAccount(), reportInfo);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "5");
        hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP);
        hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.Q.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
        if (!this.f307458w) {
            Context context = this.f307437b;
            if (context instanceof JumpActivity) {
                ((JumpActivity) context).finish();
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c4 A[Catch: Exception -> 0x014e, TRY_LEAVE, TryCatch #1 {Exception -> 0x014e, blocks: (B:59:0x00ad, B:61:0x00c4, B:90:0x00a3), top: B:89:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean V2() {
        int i3;
        boolean z16;
        Intent intent;
        String str;
        boolean z17;
        int i16;
        boolean z18;
        String str2 = this.f307441f.get("wpaType");
        String str3 = this.f307441f.get("assignId");
        String str4 = this.f307441f.get("QidianSigT");
        String str5 = this.f307441f.get("QidianKfUin");
        String str6 = this.f307441f.get("rkey");
        String str7 = this.f307441f.get("shouldReturnToRoot");
        String str8 = this.f307441f.get("uid");
        if (str2 != null && str3 != null && str4 != null && str5 != null) {
            try {
                try {
                    if (str2.equals("2")) {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType = 2");
                            }
                            intent = new Intent();
                        } catch (Exception e16) {
                            e = e16;
                            z16 = false;
                            i3 = 2;
                        }
                        try {
                            if (!TextUtils.isEmpty(str7) && !str7.equals("NO")) {
                                intent.setComponent(SplashActivity.getAliasComponent(this.f307437b));
                                intent.putExtra("open_chatfragment", true);
                                intent.addFlags(67108864);
                                String str9 = this.f307441f.get("sigt");
                                str = this.f307441f.get("uin");
                                if (str == null) {
                                    if (str.length() >= 5 && !str.equals(this.Q.getCurrentAccountUin())) {
                                        if (str9 != null) {
                                            intent.putExtra("sigt", HexUtil.hexStr2Bytes(str9));
                                        }
                                        if (TextUtils.isEmpty(str8)) {
                                            str8 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                                        }
                                        if (str8 != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(str8, "JumpAction")) {
                                            intent.putExtra("uintype", 0);
                                            intent.putExtra("uinname", ac.G(this.Q, str));
                                            intent.putExtra(AppConstants.Key.QIDIAN_IS_FRIEND, true);
                                            z17 = true;
                                        } else {
                                            intent.putExtra("uintype", 1025);
                                            z17 = true;
                                            intent.putExtra(AppConstants.Key.KEY_FROM_WPA_FOR_CRM, true);
                                        }
                                        intent.putExtra(AppConstants.Key.QIDIAN_TYPE, 4);
                                        intent.putExtra("uin", str);
                                        intent.putExtra("key_peerId", str8);
                                        intent.putExtra("key_peerUin", str);
                                        this.f307437b.startActivity(intent);
                                    }
                                    return false;
                                }
                                z17 = true;
                                i16 = 2;
                            }
                            intent.setComponent(new ComponentName(this.f307437b, (Class<?>) ChatActivity.class));
                            intent.addFlags(67108864);
                            String str92 = this.f307441f.get("sigt");
                            str = this.f307441f.get("uin");
                            if (str == null) {
                            }
                            i16 = 2;
                        } catch (Exception e17) {
                            e = e17;
                            z16 = false;
                            i3 = 2;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        z17 = true;
                        if (QLog.isColorLevel()) {
                            i16 = 2;
                            try {
                                QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
                            } catch (Exception e18) {
                                e = e18;
                                z16 = false;
                                i3 = 2;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } else {
                            i16 = 2;
                        }
                        try {
                            this.Q.addObserver(this.W);
                        } catch (Exception e19) {
                            e = e19;
                            i3 = i16;
                            z16 = false;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                    z18 = z17;
                    i3 = i16;
                    try {
                        ((QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).v3(str5, str2, str4, str3, str6, str7, this.W.f342853d);
                    } catch (Exception e26) {
                        e = e26;
                        z16 = false;
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    i3 = 2;
                }
            } catch (Exception e28) {
                e = e28;
                i3 = 2;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", i3, "wpaType: " + str2 + "assignId: " + str3 + "qidianSigt: " + str4 + "qidianUin: " + str5);
                }
                return z18;
            } catch (Exception e29) {
                e = e29;
                z16 = z18;
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", i3, e.getMessage());
                    return z16;
                }
                return z16;
            }
        }
        return false;
    }

    private void V3(long j3, String str, int i3) {
        String str2;
        if (i3 == 1) {
            str2 = "1";
        } else if (i3 == 5) {
            str2 = "2";
        } else if (i3 == 2) {
            str2 = "3";
        } else {
            str2 = "4";
        }
        ReportCenter.f().o(this.Q.getAccount(), str, String.valueOf(j3), "102", "80", "0", str2, "0", "0", false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean W0() {
        int parseInt;
        QLog.i("JumpAction", 1, "[gotoCreateTroopBySelectMember] ");
        String str = this.f307441f.get("selected_uin");
        String str2 = this.f307441f.get("from");
        if (!TextUtils.isEmpty(str2)) {
            try {
                parseInt = Integer.parseInt(str2);
            } catch (NumberFormatException e16) {
                QLog.w("JumpAction", 1, "[gotoCreateTroopBySelectMember] NumberFormatException: " + e16);
            }
            Intent intent = new Intent();
            intent.putExtra("param_type", 3000);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, parseInt);
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 29);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, (100 - arrayList.size()) - 1);
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.f307437b, intent);
            return true;
        }
        parseInt = 47;
        Intent intent2 = new Intent();
        intent2.putExtra("param_type", 3000);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_FROM, parseInt);
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
        }
        intent2.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList2);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 29);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, true);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_MAX, (100 - arrayList2.size()) - 1);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.f307437b, intent2);
        return true;
    }

    private boolean W1() {
        QZoneShareManager.shareToQZoneForRedPocket(this.f307437b, this.Q.getCurrentUin(), null, 0, this.Q.getCurrentNickname(), QUA.getQUA3());
        return true;
    }

    private boolean W2() {
        String str = this.f307441f.get(Const.BUNDLE_KEY_REQUEST);
        if (str != null && str.equals("videochat")) {
            String str2 = this.f307441f.get("uin");
            String str3 = this.f307441f.get("sigt");
            String str4 = this.f307441f.get("nickname");
            String str5 = this.f307441f.get(CloudStorageServlet.REQUEST_TYPE);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) {
                Intent intent = new Intent("com.tencent.mobileqq.qidian.openactionsheet");
                Bundle bundle = new Bundle();
                bundle.putString(CloudStorageServlet.REQUEST_TYPE, str5);
                bundle.putString("nickname", str4);
                bundle.putString("uin", str2);
                bundle.putString("sigt", str3);
                intent.putExtras(bundle);
                this.f307437b.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
                return true;
            }
        }
        return false;
    }

    private void W3(String str) {
        String str2 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        if ("app".equals(str2)) {
            ReportController.o(this.Q, "CliOper", "", str, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
        } else if ("web".equals(str2)) {
            ReportController.o(this.Q, "CliOper", "", str, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        } else if ("scan".equals(str2)) {
            ReportController.o(this.Q, "CliOper", "", str, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
        }
    }

    private boolean X0() {
        String str = this.f307441f.get(FileReaderHelper.TXT_EXT);
        if (str != null && str.length() > 0) {
            str = ax.E(str);
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.qqnt.mycomputer.utils.c.f359781a.f(str, AppConstants.DATALINE_PC_UIN, false, null);
        }
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
        Context context = this.f307437b;
        iAIOStarterApi.navigateToAIO(context, 8, PeerUid.DATALINE_PC_UID, context.getResources().getString(R.string.c5f), 0L, null);
        return true;
    }

    private boolean X1() {
        boolean z16;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoRandomVideoChat");
        }
        this.f307441f.get("chat_type");
        String str = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String str2 = this.f307441f.get(CloudStorageServlet.REQUEST_TYPE);
        String str3 = this.f307441f.get("version");
        this.f307441f.put("session_name", ax.E(this.f307441f.get("session_name")));
        if (str2 != null && str2.equals("audio")) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            i3 = Integer.parseInt(str3);
        } catch (NumberFormatException unused) {
            i3 = 0;
        }
        if (str == null || !str.equals("web") || i3 <= 0) {
            return false;
        }
        return ChatActivityUtils.j0(this.Q, this.f307437b, 1011, null, null, null, z16, null, false, true, this.X, "from_internal", this.f307441f);
    }

    private boolean X2() {
        String str;
        String str2 = null;
        if (this.f307441f.containsKey("app")) {
            str = this.f307441f.get("app");
        } else {
            str = null;
        }
        if (this.f307441f.containsKey("type")) {
            str2 = this.f307441f.get("type");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((AppletsFolderManager) this.Q.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).v(this.f307437b, str, str2);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3(int i3) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("midas://open_modify_status?status=" + i3));
        if (InstalledAppListMonitor.queryIntentActivities(this.f307437b.getPackageManager(), intent, 0).size() > 0) {
            this.f307437b.startActivity(intent);
        }
        ((QBaseActivity) this.f307437b).finish();
    }

    private boolean Y0() {
        return true;
    }

    private boolean Y1() {
        if (this.f307437b != null) {
            if (((ITroopFindNewEntranceApi) QRoute.api(ITroopFindNewEntranceApi.class)).canShowNewEntrance()) {
                Intent intent = new Intent();
                intent.putExtra("first_classific", this.f307441f.get("first_classific"));
                QPublicFragmentActivity.start(this.f307437b, intent, RecommendTroopFragment.class);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_index_key", 1);
                bundle.putString("jump_action", "find_group");
                bundle.putString("first_classific", this.f307441f.get("first_classific"));
                ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(this.f307437b, 0, 0, LaunchMode.standard, bundle);
            }
            return true;
        }
        return false;
    }

    private boolean Y2() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "enter jiankang");
        }
        if (this.Q == null) {
            QLog.e("JumpAction", 1, "app is null");
            return false;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.5
            @Override // java.lang.Runnable
            public void run() {
                IWebProcessPreload iWebProcessPreload;
                QQAppInterface qQAppInterface = JumpActionLegacy.this.Q;
                if (qQAppInterface == null) {
                    return;
                }
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                if (!TextUtils.isEmpty(currentAccountUin) && (iWebProcessPreload = (IWebProcessPreload) QRoute.api(IWebProcessPreload.class)) != null) {
                    iWebProcessPreload.setBusinessClickTimeMills(currentAccountUin, WidgetCacheConstellationData.HEALTH);
                }
            }
        }, 5, null, true);
        String E = ax.E(this.f307441f.get("url_prefix"));
        if (E == null || ((!E.startsWith("http://") && !E.startsWith("https://")) || (!com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("qq.com") && !com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase(Cgi.DOMAIN_YUN_SERVER) && !com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase(Cgi.TENPAY_DOMAIN) && !com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("wanggou.com")))) {
            return false;
        }
        if (E.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) <= 0) {
            E = E + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        StringBuilder sb5 = new StringBuilder(E);
        sb5.append("&client=androidQQ");
        sb5.append("&uin=");
        sb5.append(this.Q.getCurrentAccountUin());
        sb5.append("&version=");
        sb5.append(AppSetting.f99554n);
        sb5.append("&system=");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append("&device=");
        sb5.append(Build.DEVICE);
        sb5.append("&density=");
        sb5.append(ThemeUtil.getThemeDensity(this.Q.getApplication().getApplicationContext()));
        sb5.append("&platformId=2");
        sb5.append("&_lv=0");
        sb5.append("&hasRedDot=");
        if (this.f307450o) {
            str = "1";
        } else {
            str = "0";
        }
        sb5.append(str);
        sb5.append("&adtag=mvip.gongneng.anroid.health.nativet");
        this.Q.getApp().getSharedPreferences(this.Q.getAccount(), 0);
        sb5.append("&lati=");
        sb5.append(0);
        sb5.append("&logi=");
        sb5.append(0);
        sb5.append("&netType=" + NetworkUtil.getSystemNetwork(this.Q.getApp().getApplicationContext()));
        sb5.append("&model=" + ah.s());
        Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", sb5.toString());
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.f307437b.startActivity(intent);
        return true;
    }

    private void Y3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f307441f.put("file_data", new String(PluginBaseInfoHelper.Base64Helper.encode(str.getBytes("UTF-8"), 0)));
        } catch (UnsupportedEncodingException unused) {
            QLog.e("JumpAction", 1, "saveShareImagePath UnsupportedEncodingException");
        }
    }

    private boolean Z0() {
        return true;
    }

    private boolean Z1() {
        ReportController.o(this.Q, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, this.f307441f.get("appid"), "", "", "");
        QBaseActivity qBaseActivity = (QBaseActivity) this.f307437b;
        if (qBaseActivity == null) {
            return false;
        }
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).doRegister(qBaseActivity, 7);
        return true;
    }

    private boolean Z2() {
        String E = ax.E(this.f307441f.get("url"));
        if (!TextUtils.isEmpty(this.f307441f.get("appid")) && !TextUtils.isEmpty(this.f307441f.get("openid"))) {
            ReportController.o(this.Q, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", this.f307441f.get("appid"), "");
            Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", E);
            this.f307437b.startActivity(intent);
            return true;
        }
        QLog.e("JumpAction", 1, "identification with illegal params");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z3(Bundle bundle) {
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
        aliasIntent.putExtras(bundle);
        aliasIntent.putExtra(AppConstants.Key.THRIPARTY_PULL_MAIN, true);
        aliasIntent.addFlags(67108864);
        aliasIntent.addFlags(268435456);
        this.f307437b.startActivity(aliasIntent);
    }

    private boolean a1() {
        Intent intent = new Intent(this.f307437b, (Class<?>) JoinDiscussionActivity.class);
        String str = this.f307441f.get(PreloadTRTCPlayerParams.KEY_SIG);
        intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, str);
        if (TextUtils.isEmpty(str)) {
            intent.putExtra("innerSig", this.f307441f.get("k"));
        }
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean a2() {
        int parseInt;
        String str = this.f307441f.get("troopUin");
        String str2 = this.f307441f.get("evilUin");
        String str3 = this.f307441f.get("selfUin");
        String str4 = this.f307441f.get("scene");
        if (str4 != null) {
            try {
                parseInt = Integer.parseInt(str4);
            } catch (Exception unused) {
            }
            NewReportPlugin.T((QBaseActivity) this.f307437b, str2, str, str3, parseInt, null);
            return true;
        }
        parseInt = 20008;
        NewReportPlugin.T((QBaseActivity) this.f307437b, str2, str, str3, parseInt, null);
        return true;
    }

    private boolean a3() {
        boolean z16;
        HashMap<String, String> hashMap = this.f307441f;
        if (hashMap != null && hashMap.containsKey(PreloadingFragment.KEY_APPID) && !this.f307441f.containsKey("fakeUrl")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return MiniAppLauncher.launchMiniAppByScheme(this.f307437b, this.f307441f);
        }
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.f307437b, this.f307441f, 2016, null, null);
    }

    private void a4(Bundle bundle, int i3) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(js.a.f410904d.b()));
        hashSet.add(Integer.valueOf(js.a.f410917q.b()));
        hashSet.add(Integer.valueOf(js.a.f410923w.b()));
        hashSet.add(Integer.valueOf(js.a.f410926z.b()));
        hashSet.add(Integer.valueOf(js.a.f410905e.b()));
        hashSet.add(Integer.valueOf(js.a.f410924x.b()));
        hashSet.add(Integer.valueOf(js.a.f410906f.b()));
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Integer.valueOf(js.a.f410910j.b()));
        hashSet2.add(Integer.valueOf(js.a.f410920t.b()));
        hashSet2.add(Integer.valueOf(js.a.f410921u.b()));
        hashSet2.add(Integer.valueOf(js.a.f410918r.b()));
        hashSet2.add(Integer.valueOf(js.a.f410922v.b()));
        hashSet2.add(Integer.valueOf(js.a.f410925y.b()));
        if (hashSet.contains(Integer.valueOf(i3))) {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
        } else if (hashSet2.contains(Integer.valueOf(i3))) {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 2);
        } else {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:(1:94)|95|(2:97|(4:99|(1:101)(2:104|(2:106|(2:108|(1:110)(1:111))(1:112))(1:113))|102|103))(2:169|(2:171|(5:175|(1:177)(1:192)|(2:179|(2:181|(2:183|(1:185)(1:186))(1:189))(1:190))(1:191)|187|188))(2:193|(9:195|(1:197)|198|(1:202)|203|204|205|206|207)(4:211|(2:213|(1:215))|115|(15:126|(1:168)(7:130|(1:132)(1:167)|133|(1:135)|136|(1:138)(1:166)|139)|140|(1:142)|143|(1:145)|146|(1:150)|151|152|153|154|(1:156)|157|(2:159|160)(2:161|162))(4:119|(1:123)|124|125))))|114|115|(1:117)|126|(1:128)|168|140|(0)|143|(0)|146|(2:148|150)|151|152|153|154|(0)|157|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0702, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0703, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0739  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b1() {
        boolean z16;
        String str;
        int parseInt;
        String str2;
        String str3;
        String str4;
        String stringBuffer;
        final Intent putExtra;
        Bundle extrasForQQBrowserActivity;
        String str5;
        String str6;
        String str7;
        ax c16;
        System.currentTimeMillis();
        String E = ax.E(this.f307441f.get("url_prefix"));
        if (E != null) {
            if (E.startsWith("http://") || E.startsWith("https://")) {
                if (com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("qq.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase(Cgi.DOMAIN_YUN_SERVER) || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase(Cgi.TENPAY_DOMAIN) || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("wanggou.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("tencent.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("jd.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("qcloud.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("webank.com") || com.tencent.mobileqq.webview.util.s.i(E).equalsIgnoreCase("qqumall.com")) {
                    ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).reportIfNeed(this.f307438c);
                    if (((this.f307437b instanceof Activity) && ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).handleHttpUrl((Activity) this.f307437b, this.f307438c)) || p3()) {
                        return true;
                    }
                    if (E.startsWith("https://jiazhang.qq.com/wap/com/") || E.startsWith("https://test.jiazhang.qq.com/wap/com/")) {
                        if (this.f307441f.containsKey("openid") && !TextUtils.isEmpty(this.f307441f.get("openid")) && this.f307441f.containsKey("appid") && !TextUtils.isEmpty(this.f307441f.get("appid"))) {
                            ReportController.o(this.Q, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", this.f307441f.get("appid"), "");
                        } else {
                            QLog.e("JumpAction", 1, "empty params");
                            return false;
                        }
                    }
                    IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
                    if (iWeatherCommApi.isWeatherArkPageUrl(E)) {
                        iWeatherCommApi.startNewWeatherWebPageActivityByFollowState(this.f307437b, this.Q, 4, E);
                        return true;
                    }
                    if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isHealthDomain(E)) {
                        return ((IQQHealthService) this.Q.getRuntimeService(IQQHealthService.class)).redirectAIOToMainPage(QBaseActivity.sTopActivity, 161);
                    }
                    if (com.tencent.mobileqq.webview.util.s.h(E, 2).equalsIgnoreCase("xsj.qq.com")) {
                        Map<String, String> arguments = URLUtil.getArguments(E.substring(E.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1));
                        if (arguments.containsKey("qqecommerce_activity_scheme") && arguments.containsKey("min_version")) {
                            String str8 = arguments.get("min_version");
                            String str9 = arguments.get("qqecommerce_activity_scheme");
                            String subVersion = com.tencent.util.AppSetting.getSubVersion();
                            if (!TextUtils.isEmpty(str8) && str8.compareToIgnoreCase(subVersion) <= 0 && (c16 = bi.c(this.Q, BaseApplicationImpl.getApplication(), ax.E(str9))) != null) {
                                c16.b();
                                return true;
                            }
                        }
                    }
                    this.f307441f.get("style");
                    String E2 = ax.E(this.f307441f.get("title"));
                    String str10 = this.f307441f.get("plg_auth");
                    String str11 = this.f307441f.get("plg_nld");
                    String str12 = this.f307441f.get("plg_dev");
                    String str13 = this.f307441f.get("plg_usr");
                    String str14 = this.f307441f.get("plg_vkey");
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(E);
                    if (stringBuffer2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < 0) {
                        stringBuffer2.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    } else if (stringBuffer2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < stringBuffer2.length() - 1) {
                        if (stringBuffer2.indexOf(ContainerUtils.FIELD_DELIMITER) < 0) {
                            stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        } else if (stringBuffer2.lastIndexOf(ContainerUtils.FIELD_DELIMITER) < stringBuffer2.length() - 1) {
                            stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        }
                    }
                    Cryptor cryptor = new Cryptor();
                    if ("1".equals(str10)) {
                        stringBuffer2.append("plg_auth=1");
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ("1".equals(str12)) {
                        stringBuffer2.append("plg_dev=1");
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        stringBuffer2.append("MOBINFO=");
                        stringBuffer2.append(HexUtil.bytes2HexStr(cryptor.encrypt(C0().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        z16 = true;
                    }
                    if ("1".equals(str13)) {
                        stringBuffer2.append("plg_usr=1");
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        stringBuffer2.append("USER=");
                        stringBuffer2.append(HexUtil.bytes2HexStr(cryptor.encrypt(HardCodeUtil.qqStr(R.string.f172127nj3).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        z16 = true;
                    }
                    if ("1".equals(str14) && (str7 = this.Q.getvKeyStr()) != null) {
                        stringBuffer2.append("plg_vkey=1");
                        stringBuffer2.append("&mqqvkey=");
                        stringBuffer2.append(str7);
                        stringBuffer2.append(ContainerUtils.FIELD_DELIMITER);
                        z16 = true;
                    }
                    String str15 = this.f307447l;
                    if (str15 != null && str15.length() > 0) {
                        stringBuffer2.append(this.f307447l + ContainerUtils.FIELD_DELIMITER);
                    }
                    String f16 = f("download_sourceid");
                    if ("1".equals(str11)) {
                        stringBuffer2.append("plg_nld=1");
                        Intent putExtra2 = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class).putExtra("url", stringBuffer2.toString());
                        putExtra2.putExtra("key_isReadModeEnabled", true);
                        if (E2 != null && !E2.equals("")) {
                            putExtra2.putExtra("title", E2);
                        }
                        putExtra2.putExtra("reportNldFormPlugin", true);
                        putExtra2.putExtra("uin", this.Q.getCurrentAccountUin());
                        this.f307437b.startActivity(putExtra2);
                        return true;
                    }
                    if (z16) {
                        stringBuffer2.deleteCharAt(stringBuffer2.lastIndexOf(ContainerUtils.FIELD_DELIMITER));
                    }
                    String stringBuffer3 = stringBuffer2.toString();
                    if (stringBuffer3.startsWith("http://story.now.qq.com/mobile/transfer_q.html")) {
                        Map<String, String> arguments2 = URLUtil.getArguments(stringBuffer3.substring(stringBuffer3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1));
                        if (!TextUtils.isEmpty(arguments2.get("storysharefrom"))) {
                            this.f307441f.putAll(arguments2);
                            if (this.f307441f.get("type") == null) {
                                this.f307440e = "opencontent";
                            } else {
                                int parseInt2 = Integer.parseInt(this.f307441f.get("type"));
                                if (parseInt2 != 0) {
                                    if (parseInt2 != 1) {
                                        if (parseInt2 != 2) {
                                            return true;
                                        }
                                        this.f307440e = "opentopic";
                                    } else {
                                        this.f307440e = "openVideo";
                                    }
                                } else {
                                    this.f307440e = "opencontent";
                                }
                            }
                            return s0();
                        }
                    } else if (stringBuffer3.startsWith("http://story.now.qq.com/mobile/transfer_q2.html")) {
                        Map<String, String> arguments3 = URLUtil.getArguments(stringBuffer3.substring(stringBuffer3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1));
                        this.f307441f.putAll(arguments3);
                        String str16 = arguments3.get("contentType");
                        if (str16 == null || str16.equals("0")) {
                            if (this.f307441f.get("actionnamekey") != null) {
                                parseInt = Integer.parseInt(this.f307441f.get("actionnamekey"));
                            } else {
                                parseInt = Integer.parseInt(this.f307441f.get("type"));
                            }
                            if (parseInt != 0) {
                                if (parseInt != 1) {
                                    if (parseInt != 2) {
                                        if (parseInt != 3) {
                                            return true;
                                        }
                                        this.f307440e = "infoCard";
                                    } else {
                                        this.f307440e = "opentopic";
                                    }
                                } else {
                                    this.f307440e = "openVideo";
                                }
                            } else {
                                this.f307440e = "opencontent";
                            }
                            return s0();
                        }
                    } else {
                        if (!stringBuffer3.contains("lbs.qidian.qq.com/authorize/voiceShow")) {
                            str = "title";
                            if (this.f307437b instanceof Activity) {
                                Bundle bundle = new Bundle();
                                bundle.putString("uin", this.Q.getCurrentAccountUin());
                                if (com.tencent.mobileqq.miniapp.util.a.b((Activity) this.f307437b, stringBuffer3, bundle)) {
                                    return true;
                                }
                            }
                            str2 = this.f307444i;
                            if (str2 == null && str2.trim().equalsIgnoreCase("com.tx.android.txnews.new")) {
                                Intent putExtra3 = new Intent(this.f307437b, (Class<?>) QQBrowserDelegationActivity.class).putExtra("url", stringBuffer2.toString());
                                putExtra3.putExtra("key_isReadModeEnabled", true);
                                putExtra3.putExtra("uin", this.Q.getCurrentAccountUin());
                                if (E2 != null && !E2.equals("")) {
                                    putExtra3.putExtra(str, E2);
                                }
                                putExtra3.putExtra("uin", this.Q.getCurrentAccountUin());
                                putExtra3.putExtra("param_force_internal_browser", false);
                                putExtra3.putExtra("key_isReadModeEnabled", true);
                                putExtra3.putExtra("injectrecommend", true);
                                this.f307437b.startActivity(putExtra3);
                                return true;
                            }
                            str3 = this.f307444i;
                            if (str3 != null || !str3.trim().equalsIgnoreCase("com.qq.yijianfankui")) {
                                str4 = "leba_resid";
                            } else {
                                stringBuffer2.append("&version=" + AppSetting.f99554n);
                                stringBuffer2.append("&appid=" + AppSetting.f());
                                stringBuffer2.append("&QUA=" + QUA.getQUA3());
                                stringBuffer2.append("&adtag=" + AppSetting.f99542b);
                                String model = DeviceInfoMonitor.getModel();
                                if (model == null) {
                                    str5 = "";
                                } else {
                                    str5 = model.replaceAll(" ", "_");
                                }
                                int qzonePatchTag = StatisticCollector.getQzonePatchTag();
                                if (qzonePatchTag > 0) {
                                    str5 = str5 + "_qzpatch" + qzonePatchTag;
                                }
                                String str17 = Build.MANUFACTURER;
                                if (str17 == null) {
                                    str6 = "";
                                } else {
                                    str6 = str17.replaceAll(" ", "_");
                                }
                                stringBuffer2.append("&model=");
                                stringBuffer2.append(str5);
                                stringBuffer2.append("&manufacture=");
                                stringBuffer2.append(str6);
                                stringBuffer2.append("&cpunum=");
                                stringBuffer2.append(ah.n());
                                stringBuffer2.append("&cpurate=");
                                str4 = "leba_resid";
                                stringBuffer2.append(ah.l());
                                stringBuffer2.append("&mem=");
                                stringBuffer2.append((com.tencent.mobileqq.utils.m.c() / 1024) / 1024);
                                stringBuffer2.append("&w=");
                                stringBuffer2.append(ah.x());
                                stringBuffer2.append("&h=");
                                stringBuffer2.append(ah.w());
                            }
                            stringBuffer = stringBuffer2.toString();
                            if (stringBuffer.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                                stringBuffer = stringBuffer.substring(0, stringBuffer.length() - 1);
                            }
                            putExtra = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class).putExtra("url", stringBuffer);
                            extrasForQQBrowserActivity = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getExtrasForQQBrowserActivity(stringBuffer);
                            if (extrasForQQBrowserActivity != null) {
                                putExtra.putExtras(extrasForQQBrowserActivity);
                            }
                            putExtra.putExtra("key_isReadModeEnabled", true);
                            putExtra.putExtra("uin", this.Q.getCurrentAccountUin());
                            if (E2 != null && !E2.equals("")) {
                                putExtra.putExtra(str, E2);
                            }
                            putExtra.putExtra("uin", this.Q.getCurrentAccountUin());
                            putExtra.putExtra("plugin_start_time", System.nanoTime());
                            putExtra.putExtra("click_start_time", System.currentTimeMillis());
                            putExtra.putExtra("startOpenPageTime", System.currentTimeMillis());
                            putExtra.putExtra(str4, Long.parseLong(f(str4)));
                            putExtra.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, this.f307450o);
                            putExtra.putExtra("is_from_leba", true);
                            if (!TextUtils.isEmpty(f16)) {
                                putExtra.putExtra("big_brother_source_key", f16);
                            }
                            if (!u3()) {
                                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.ay
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        JumpActionLegacy.this.E3(putExtra);
                                    }
                                }, 50L);
                                return true;
                            }
                            this.f307437b.startActivity(putExtra);
                            return true;
                        }
                        String stringBuffer4 = stringBuffer2.toString();
                        if (stringBuffer4.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                            stringBuffer4 = stringBuffer4.substring(0, stringBuffer4.length() - 1);
                        }
                        Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", stringBuffer4);
                        intent.putExtra("fragment_class", QidianWebViewFragment.class.getCanonicalName());
                        intent.putExtra("key_isReadModeEnabled", true);
                        intent.putExtra("uin", this.Q.getCurrentAccountUin());
                        if (E2 != null && !E2.equals("")) {
                            intent.putExtra("title", E2);
                        }
                        intent.putExtra("uin", this.Q.getCurrentAccountUin());
                        intent.putExtra("plugin_start_time", System.nanoTime());
                        intent.putExtra("click_start_time", System.currentTimeMillis());
                        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                        try {
                            intent.putExtra("leba_resid", Long.parseLong(f("leba_resid")));
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, this.f307450o);
                        intent.putExtra("is_from_leba", true);
                        this.f307437b.startActivity(intent);
                        return true;
                    }
                    str = "title";
                    str2 = this.f307444i;
                    if (str2 == null) {
                    }
                    str3 = this.f307444i;
                    if (str3 != null) {
                    }
                    str4 = "leba_resid";
                    stringBuffer = stringBuffer2.toString();
                    if (stringBuffer.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                    }
                    putExtra = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class).putExtra("url", stringBuffer);
                    extrasForQQBrowserActivity = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getExtrasForQQBrowserActivity(stringBuffer);
                    if (extrasForQQBrowserActivity != null) {
                    }
                    putExtra.putExtra("key_isReadModeEnabled", true);
                    putExtra.putExtra("uin", this.Q.getCurrentAccountUin());
                    if (E2 != null) {
                        putExtra.putExtra(str, E2);
                    }
                    putExtra.putExtra("uin", this.Q.getCurrentAccountUin());
                    putExtra.putExtra("plugin_start_time", System.nanoTime());
                    putExtra.putExtra("click_start_time", System.currentTimeMillis());
                    putExtra.putExtra("startOpenPageTime", System.currentTimeMillis());
                    putExtra.putExtra(str4, Long.parseLong(f(str4)));
                    putExtra.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, this.f307450o);
                    putExtra.putExtra("is_from_leba", true);
                    if (!TextUtils.isEmpty(f16)) {
                    }
                    if (!u3()) {
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean b2() {
        return true;
    }

    private void b3() {
        JSONObject optJSONObject;
        if (this.f307441f.containsKey("params")) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(this.f307441f.get("params")));
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "urlParamObj: " + jSONObject);
                }
                if (jSONObject.optInt("view_type", 0) == 0 && (optJSONObject = jSONObject.optJSONObject("params")) != null) {
                    ReminderListFragment.launch(this.f307437b, optJSONObject.optString("notice_time"));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + e16);
                }
            }
        }
    }

    private Intent b4(Bundle bundle) {
        Intent intent = new Intent();
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK, true);
        return intent;
    }

    private boolean c1() {
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            return true;
        }
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c2() {
        String E = ax.E(this.f307441f.get("set_uri"));
        QLog.d("JumpAction", 1, "-->gotoSDKSetAvator setUri=", E);
        if (!TextUtils.isEmpty(E)) {
            return w0(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.7
                @Override // java.lang.Runnable
                public void run() {
                    JumpActionLegacy.this.c2();
                }
            }, E, "set_uri", "set_path");
        }
        String E2 = ax.E(this.f307441f.get("app_name"));
        String str = this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
        String E3 = ax.E(this.f307441f.get("open_id"));
        String E4 = ax.E(this.f307441f.get("set_path"));
        String E5 = ax.E(this.f307441f.get("sdk_version"));
        ((Activity) this.f307437b).getIntent().getIntExtra("key_request_code", 0);
        AllInOne allInOne = new AllInOne(this.Q.getCurrentAccountUin(), 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_from_sdk_set_avatar", true);
        bundle.putString("key_from_sdk_set_avatar_path", E4);
        bundle.putString("pkg_name", this.f307444i);
        if (!TextUtils.isEmpty(E2)) {
            bundle.putString("key_from_sdk_set_avatar_appname", E2);
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("key_from_sdk_set_avatar_share_id", str);
        }
        if (!TextUtils.isEmpty(E3)) {
            bundle.putString("key_from_sdk_set_avatar_open_id", E3);
        }
        if (!TextUtils.isEmpty(E5)) {
            bundle.putString("sdk_version", E5);
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoSDKSetAvator:sdk appName=" + E2 + " shareId=" + str + ", openId =" + E3 + ", setPath =" + E4 + ", sdkVersion =" + E5);
        }
        ProfileActivity.H2(this.f307437b, allInOne, bundle);
        return true;
    }

    private void c3() {
        String str;
        if (this.f307441f.containsKey(ZPlanPublishSource.FROM_SCHEME) && this.f307441f.containsKey("msgid") && this.f307441f.containsKey("busiid")) {
            String str2 = this.f307441f.get("msgid");
            String str3 = this.f307441f.get("busiid");
            String str4 = this.f307441f.get(ZPlanPublishSource.FROM_SCHEME);
            if (this.f307441f.containsKey("domain")) {
                str = this.f307441f.get("domain");
            } else {
                str = "";
            }
            QQNotifySettingFragment.Gh(this.f307437b, str2, str3, str4, str);
        }
    }

    private void c4() {
        Context context = this.f307437b;
        Dialog createTipDialog = DialogUtil.createTipDialog(context, R.string.bgk, context.getString(R.string.bgf), R.string.bgh, R.string.bgg, new a(), new b());
        this.V = createTipDialog;
        createTipDialog.show();
    }

    private boolean d1() {
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            return true;
        }
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.ci5, 1).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d2() {
        String E = ax.E(this.f307441f.get("video_uri"));
        QLog.d("JumpAction", 1, "-->gotoSDKSetDynamicAvatar videoUri=", E);
        if (!TextUtils.isEmpty(E)) {
            return w0(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.8
                @Override // java.lang.Runnable
                public void run() {
                    JumpActionLegacy.this.d2();
                }
            }, E, "video_uri", QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH);
        }
        String E2 = ax.E(this.f307441f.get("app_name"));
        String str = this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
        String E3 = ax.E(this.f307441f.get("open_id"));
        String E4 = ax.E(this.f307441f.get(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH));
        String E5 = ax.E(this.f307441f.get("sdk_version"));
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "[gotoSDKSetDynamicAvatar] appName=", E2);
        }
        ReportController.o(this.Q, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str, "", "", "");
        Intent intent = new Intent(this.f307437b, (Class<?>) SelectCoverActivity.class);
        intent.putExtra("param_source", 3);
        intent.putExtra("param_from_newer_guide", false);
        intent.putExtra("key_video_file_path", E4);
        intent.putExtra("pkg_name", this.f307444i);
        intent.putExtra("app_name", E2);
        intent.putExtra(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH, str);
        intent.putExtra("open_id", E3);
        intent.putExtra("sdk_version", E5);
        intent.addFlags(335544320);
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean d3() {
        if (!TextUtils.isEmpty(this.f307441f.get("appid"))) {
            ax.L = this.f307441f.get("appid");
        }
        if (!TextUtils.isEmpty(this.f307441f.get("openid"))) {
            ax.M = this.f307441f.get("openid");
        }
        if (!TextUtils.isEmpty(this.f307441f.get("openkey"))) {
            ax.O = this.f307441f.get("openkey");
        }
        if ("true".equals(this.f307441f.get("is_from_game"))) {
            return B2();
        }
        return S2();
    }

    private boolean e1() {
        boolean z16;
        TroopInfo k3;
        String str = this.f307441f.get("uin");
        if (str != null && !"".equals(str) && str.length() >= 5) {
            if (this.f307437b instanceof Activity) {
                TroopManager troopManager = (TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (k3 = troopManager.k(str)) != null && k3.isOwnerOrAdmin()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
                    }
                    return false;
                }
                Intent intent = new Intent();
                intent.putExtra("uin", this.Q.getCurrentAccountUin());
                intent.putExtra("troop_uin", str);
                intent.putExtra(AppConstants.Key.KEY_IS_UPDATE_BEFORE_805, ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this.f307437b, "8.0.5"));
                QPublicFragmentActivity.startForResult((Activity) this.f307437b, intent, com.tencent.mobileqq.troopmanage.base.b.c(), -1);
                if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "gotoGroupManager " + str);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
            }
        }
        return false;
    }

    private boolean e2() {
        String E = ax.E(this.f307441f.get("app_name"));
        String str = this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
        String E2 = ax.E(this.f307441f.get("open_id"));
        String E3 = ax.E(this.f307441f.get("set_uri_list"));
        String E4 = ax.E(this.f307441f.get("sdk_version"));
        String str2 = this.f307441f.get("ppsts");
        if (TextUtils.isEmpty(this.f307444i)) {
            String b16 = com.tencent.open.agent.util.m.b(new String[]{E, str, E2, E4, E3}, str2);
            this.f307444i = b16;
            QLog.d("JumpAction", 1, "getDecryptPkgName ppsts=", str2, "pkgName=", b16);
        }
        ArrayList<? extends Parcelable> parcelableArrayListExtra = ((Activity) this.f307437b).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f307437b, RouterConstants.UI_ROUTE_FAV_EMOSM_ACTVITY);
        activityURIRequest.setFlags(335544320);
        activityURIRequest.extra().putBoolean("key_from_sdk_set_emotion", true);
        activityURIRequest.extra().putParcelableArrayList("key_from_sdk_set_emotion_uri", parcelableArrayListExtra);
        activityURIRequest.extra().putString("pkg_name", this.f307444i);
        if (!TextUtils.isEmpty(E)) {
            activityURIRequest.extra().putString("key_from_sdk_set_emotion_appname", E);
        }
        if (!TextUtils.isEmpty(str)) {
            activityURIRequest.extra().putString("key_from_sdk_set_emotion_share_id", str);
        }
        if (!TextUtils.isEmpty(E2)) {
            activityURIRequest.extra().putString("key_from_sdk_set_emotion_open_id", E2);
        }
        if (!TextUtils.isEmpty(E3)) {
            activityURIRequest.extra().putString("key_from_sdk_set_emotion_uri_list", E3);
        }
        if (!TextUtils.isEmpty(E4)) {
            activityURIRequest.extra().putString("sdk_version", E4);
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoSDKSetEmotion:sdk appName=" + E + " shareId=" + str + ", openId =" + E2 + ", setPathList =" + E3);
        }
        QRoute.startUri(activityURIRequest);
        return true;
    }

    private boolean e3() {
        String str;
        if (this.f307441f.containsKey("entry")) {
            str = this.f307441f.get("entry");
        } else {
            str = null;
        }
        String str2 = this.f307441f.get("view");
        if (!"1".equals(str2) && !"2".equals(str2) && !"3".equals(str2) && !"4".equals(str2) && !"5".equals(str2) && !"6".equals(str2) && !"7".equals(str2) && !"9".equals(str2) && !"10".equals(str2) && !"11".equals(str2)) {
            if ("8".equals(str2)) {
                return B1(str2, str);
            }
            return false;
        }
        Bundle bundle = new Bundle();
        if (this.f307441f.containsKey("tokenid")) {
            bundle.putString("tokenid", this.f307441f.get("tokenid"));
        }
        if (this.f307441f.containsKey("data")) {
            bundle.putString("data", this.f307441f.get("data"));
        }
        return M1(str2, str, bundle);
    }

    private void e4(String str, String str2, String str3, Intent intent) {
        intent.putExtra("url", str);
        intent.setClassName(str2, str3);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.f307437b.startActivity(intent);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:3|(14:5|6|(1:8)(1:110)|9|(1:11)(1:109)|12|(1:14)(1:108)|15|16|(1:19)|20|(1:105)(27:23|(4:25|(6:28|(2:30|(3:32|33|34))(1:37)|35|36|34|26)|38|39)(1:104)|40|(24:100|101|43|(22:95|96|97|46|(1:48)(1:94)|49|(1:51)(1:93)|52|53|54|(11:56|57|(1:59)(1:89)|60|(1:62)(1:88)|63|(1:65)(1:87)|(1:69)|70|(4:72|(1:82)(1:76)|77|(1:81))|83)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(2:67|69)|70|(0)|83)|45|46|(0)(0)|49|(0)(0)|52|53|54|(0)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|70|(0)|83)|42|43|(0)|45|46|(0)(0)|49|(0)(0)|52|53|54|(0)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|70|(0)|83)|84|85))|111|6|(0)(0)|9|(0)(0)|12|(0)(0)|15|16|(1:19)|20|(0)|105|84|85) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:23|(4:25|(6:28|(2:30|(3:32|33|34))(1:37)|35|36|34|26)|38|39)(1:104)|40|(24:100|101|43|(22:95|96|97|46|(1:48)(1:94)|49|(1:51)(1:93)|52|53|54|(11:56|57|(1:59)(1:89)|60|(1:62)(1:88)|63|(1:65)(1:87)|(1:69)|70|(4:72|(1:82)(1:76)|77|(1:81))|83)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(2:67|69)|70|(0)|83)|45|46|(0)(0)|49|(0)(0)|52|53|54|(0)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|70|(0)|83)|42|43|(0)|45|46|(0)(0)|49|(0)(0)|52|53|54|(0)|90|57|(0)(0)|60|(0)(0)|63|(0)(0)|(0)|70|(0)|83) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x008a, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f2() {
        boolean z16;
        String str;
        String str2;
        String str3;
        int i3;
        long j3;
        String str4;
        String str5;
        long longValue;
        int i16;
        long j16;
        String str6;
        long longValue2;
        String str7;
        ARGlobalConfigManager aRGlobalConfigManager;
        String str8;
        boolean z17;
        boolean z18;
        String str9;
        boolean z19;
        String str10;
        long currentTimeMillis = System.currentTimeMillis();
        boolean d16 = ARDeviceController.b().d();
        ARGlobalConfigManager aRGlobalConfigManager2 = (ARGlobalConfigManager) this.Q.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
        if (aRGlobalConfigManager2 != null) {
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + aRGlobalConfigManager2.h());
            if (aRGlobalConfigManager2.i()) {
                z16 = true;
                String str11 = "";
                if (this.f307441f.containsKey("from")) {
                    str = "";
                } else {
                    str = this.f307441f.get("from");
                }
                if (this.f307441f.containsKey("args")) {
                    str2 = "";
                } else {
                    str2 = this.f307441f.get("args");
                }
                String str12 = "0";
                if (this.f307441f.containsKey("disablecloud")) {
                    str3 = "0";
                } else {
                    str3 = this.f307441f.get("disablecloud");
                }
                i3 = Integer.parseInt(str3);
                if (i3 != 1 && i3 != 0) {
                    i3 = 1;
                }
                QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + d16 + ",effectinfo is " + z16 + ",from url is " + str + ",args is" + str2 + ",cloudSwitch is " + i3);
                if (!d16 && z16) {
                    Intent intent = new Intent();
                    intent.putExtra("from", "web-ar");
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    intent.addFlags(65536);
                    intent.addFlags(536870912);
                    intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
                    intent.putExtra(ScanTorchActivity.KEY_URL_FROM_WEB_SWITCH, i3);
                    intent.putExtra(ScanTorchActivity.KEY_JUMP_FROM_WEB, true);
                    if (!QLog.isDevelopLevel()) {
                        str4 = "";
                        str5 = "0";
                    } else {
                        Iterator<Map.Entry<String, String>> it = this.f307441f.entrySet().iterator();
                        String str13 = "";
                        while (it.hasNext()) {
                            Map.Entry<String, String> next = it.next();
                            Iterator<Map.Entry<String, String>> it5 = it;
                            String str14 = str11;
                            if (next.getValue() != null) {
                                str10 = str12;
                                if (next.getValue().length() > 20) {
                                    str13 = str13 + next.getKey() + "[" + next.getValue().substring(0, 20) + "]\n";
                                    it = it5;
                                    str11 = str14;
                                    str12 = str10;
                                }
                            } else {
                                str10 = str12;
                            }
                            str13 = str13 + next.getKey() + "[" + next.getValue() + "]\n";
                            it = it5;
                            str11 = str14;
                            str12 = str10;
                        }
                        str4 = str11;
                        str5 = str12;
                        QLog.w("JumpAction", 1, "gotoScannerActivity, \n" + str13 + "]");
                    }
                    Bundle bundle = new Bundle();
                    String str15 = this.f307441f.get("PromotionType");
                    if (!TextUtils.isEmpty(str15)) {
                        try {
                            longValue = Long.valueOf(str15).longValue();
                        } catch (Exception unused) {
                        }
                        i16 = i3;
                        j16 = longValue;
                        str6 = this.f307441f.get("RecoglizeMask");
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                j3 = currentTimeMillis;
                                longValue2 = Long.valueOf(str6).longValue();
                            } catch (Exception unused2) {
                            }
                            String str16 = str;
                            if (!this.f307441f.containsKey("H5Source")) {
                                aRGlobalConfigManager = aRGlobalConfigManager2;
                                str7 = str4;
                            } else {
                                str7 = this.f307441f.get("H5Source");
                                aRGlobalConfigManager = aRGlobalConfigManager2;
                            }
                            if (this.f307441f.containsKey("enableQR")) {
                                str8 = this.f307441f.get("enableQR");
                            } else {
                                str8 = str5;
                            }
                            if (Long.valueOf(str8).longValue() != 0) {
                                z17 = false;
                                bundle.putLong("PromotionType", j16);
                                bundle.putLong("RecoglizeMask", longValue2);
                                if (i16 == 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                bundle.putBoolean("disablecloud", z18);
                                bundle.putString("H5Source", str7);
                                if (!this.f307441f.containsKey("version")) {
                                    str9 = this.f307441f.get("version");
                                } else {
                                    str9 = str5;
                                }
                                bundle.putString("version", str9);
                                bundle.putBoolean("enableQR", z17);
                                if (j16 == 0) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19 && this.f307441f.containsKey("PromotionDescription")) {
                                    bundle.putString("PromotionDescription", this.f307441f.get("PromotionDescription"));
                                }
                                bundle.putBoolean("is_from_h5_entry", true);
                                intent.putExtra("web_invoke_params", bundle);
                                QQAudioHelper.l("JumpAction", bundle);
                                QLog.w("JumpAction", 1, "PromotionInfo test , \n" + bundle.toString() + "]");
                                if (aRGlobalConfigManager != null) {
                                    if (aRGlobalConfigManager.h() != null && !TextUtils.isEmpty(aRGlobalConfigManager.h().H)) {
                                        intent.putExtra(ScanTorchActivity.KEY_ICON_TEXT, aRGlobalConfigManager.h().H);
                                    } else {
                                        intent.putExtra(ScanTorchActivity.KEY_ICON_TEXT, "QQ-AR");
                                    }
                                    if (aRGlobalConfigManager.h() != null && aRGlobalConfigManager.h().F != null) {
                                        intent.putExtra("icon_url", aRGlobalConfigManager.h().F);
                                    }
                                }
                                RouteUtils.startActivity(this.f307437b, intent, "/qrscan/scanner");
                                ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str16, "", "");
                            }
                            z17 = true;
                            bundle.putLong("PromotionType", j16);
                            bundle.putLong("RecoglizeMask", longValue2);
                            if (i16 == 0) {
                            }
                            bundle.putBoolean("disablecloud", z18);
                            bundle.putString("H5Source", str7);
                            if (!this.f307441f.containsKey("version")) {
                            }
                            bundle.putString("version", str9);
                            bundle.putBoolean("enableQR", z17);
                            if (j16 == 0) {
                            }
                            if (z19) {
                                bundle.putString("PromotionDescription", this.f307441f.get("PromotionDescription"));
                            }
                            bundle.putBoolean("is_from_h5_entry", true);
                            intent.putExtra("web_invoke_params", bundle);
                            QQAudioHelper.l("JumpAction", bundle);
                            QLog.w("JumpAction", 1, "PromotionInfo test , \n" + bundle.toString() + "]");
                            if (aRGlobalConfigManager != null) {
                            }
                            RouteUtils.startActivity(this.f307437b, intent, "/qrscan/scanner");
                            ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str16, "", "");
                        }
                        j3 = currentTimeMillis;
                        longValue2 = 0;
                        String str162 = str;
                        if (!this.f307441f.containsKey("H5Source")) {
                        }
                        if (this.f307441f.containsKey("enableQR")) {
                        }
                        if (Long.valueOf(str8).longValue() != 0) {
                        }
                        z17 = true;
                        bundle.putLong("PromotionType", j16);
                        bundle.putLong("RecoglizeMask", longValue2);
                        if (i16 == 0) {
                        }
                        bundle.putBoolean("disablecloud", z18);
                        bundle.putString("H5Source", str7);
                        if (!this.f307441f.containsKey("version")) {
                        }
                        bundle.putString("version", str9);
                        bundle.putBoolean("enableQR", z17);
                        if (j16 == 0) {
                        }
                        if (z19) {
                        }
                        bundle.putBoolean("is_from_h5_entry", true);
                        intent.putExtra("web_invoke_params", bundle);
                        QQAudioHelper.l("JumpAction", bundle);
                        QLog.w("JumpAction", 1, "PromotionInfo test , \n" + bundle.toString() + "]");
                        if (aRGlobalConfigManager != null) {
                        }
                        RouteUtils.startActivity(this.f307437b, intent, "/qrscan/scanner");
                        ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str162, "", "");
                    }
                    longValue = 1;
                    i16 = i3;
                    j16 = longValue;
                    str6 = this.f307441f.get("RecoglizeMask");
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    j3 = currentTimeMillis;
                    longValue2 = 0;
                    String str1622 = str;
                    if (!this.f307441f.containsKey("H5Source")) {
                    }
                    if (this.f307441f.containsKey("enableQR")) {
                    }
                    if (Long.valueOf(str8).longValue() != 0) {
                    }
                    z17 = true;
                    bundle.putLong("PromotionType", j16);
                    bundle.putLong("RecoglizeMask", longValue2);
                    if (i16 == 0) {
                    }
                    bundle.putBoolean("disablecloud", z18);
                    bundle.putString("H5Source", str7);
                    if (!this.f307441f.containsKey("version")) {
                    }
                    bundle.putString("version", str9);
                    bundle.putBoolean("enableQR", z17);
                    if (j16 == 0) {
                    }
                    if (z19) {
                    }
                    bundle.putBoolean("is_from_h5_entry", true);
                    intent.putExtra("web_invoke_params", bundle);
                    QQAudioHelper.l("JumpAction", bundle);
                    QLog.w("JumpAction", 1, "PromotionInfo test , \n" + bundle.toString() + "]");
                    if (aRGlobalConfigManager != null) {
                    }
                    RouteUtils.startActivity(this.f307437b, intent, "/qrscan/scanner");
                    ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str1622, "", "");
                } else {
                    j3 = currentTimeMillis;
                    String str17 = str;
                    StringBuilder sb5 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                    sb5.append("&from=");
                    sb5.append(str17);
                    sb5.append("&args=");
                    sb5.append(v0(str2));
                    QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + sb5.toString());
                    Intent intent2 = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("uin", this.Q.getCurrentUin());
                    intent2.putExtra("url", sb5.toString());
                    this.f307437b.startActivity(intent2);
                    ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str17, "", "");
                }
                QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - j3));
                return true;
            }
        }
        z16 = false;
        String str112 = "";
        if (this.f307441f.containsKey("from")) {
        }
        if (this.f307441f.containsKey("args")) {
        }
        String str122 = "0";
        if (this.f307441f.containsKey("disablecloud")) {
        }
        i3 = Integer.parseInt(str3);
        if (i3 != 1) {
            i3 = 1;
        }
        QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + d16 + ",effectinfo is " + z16 + ",from url is " + str + ",args is" + str2 + ",cloudSwitch is " + i3);
        if (!d16) {
        }
        j3 = currentTimeMillis;
        String str172 = str;
        StringBuilder sb52 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
        sb52.append("&from=");
        sb52.append(str172);
        sb52.append("&args=");
        sb52.append(v0(str2));
        QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + sb52.toString());
        Intent intent22 = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
        intent22.putExtra("uin", this.Q.getCurrentUin());
        intent22.putExtra("url", sb52.toString());
        this.f307437b.startActivity(intent22);
        ReportController.o(this.Q, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str172, "", "");
        QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - j3));
        return true;
    }

    private boolean f3() {
        if (this.f307440e.equals("publish")) {
            return S1();
        }
        if (this.f307440e.equals("writemood")) {
            return L2();
        }
        if (this.f307440e.equals("to_publish_queue")) {
            return T1();
        }
        if (this.f307440e.equals("open_homepage")) {
            return z1();
        }
        if (this.f307440e.equals("groupalbum")) {
            return I1();
        }
        if (this.f307440e.equals("to_friend_feeds")) {
            return o();
        }
        if (this.f307440e.equals("to_qzone_dialog")) {
            return B3();
        }
        if (this.f307440e.equals("to_redpocket_share")) {
            return W1();
        }
        if (this.f307440e.equals("open_redpocket")) {
            return Q1();
        }
        if (this.f307440e.equals("qzone_schema")) {
            return P1();
        }
        if (this.f307440e.equals("shareLogToQQ")) {
            return m2();
        }
        if (this.f307440e.equals("qzone_publicaccount")) {
            return N3();
        }
        return false;
    }

    private void f4(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(this.f307437b, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 0);
        String F = ac.F(this.Q, str);
        if (F != null) {
            intent.putExtra("uinname", F);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(AppConstants.Key.KEY_AIO_REPLY_CONTENT, str2);
            intent.putExtra(AppConstants.Key.KEY_AIO_REPLY_TIME, str3);
        }
        intent.addFlags(67108864);
        this.f307437b.startActivity(intent);
        ReportController.o(this.Q, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
        QLog.i("JumpAction", 1, "[startChatActivityForFriend] uin:" + str + " uin_name:" + F + " chat_type:" + str4);
    }

    private boolean g1() {
        return true;
    }

    private boolean g2() {
        return true;
    }

    private boolean g3() {
        if (this.f307440e.equals("emoji")) {
            EmojiHomeUiPlugin.openEmojiHomePage((Activity) this.f307437b, this.Q.getAccount(), 7);
            return true;
        }
        if (this.f307440e.equals("emoji_detail")) {
            EmojiHomeUiPlugin.openEmojiDetailPage((Activity) this.f307437b, this.Q.getAccount(), 4, f("detailid"));
            return true;
        }
        if (this.f307440e.equals("emoji_author")) {
            EmojiHomeUiPlugin.openEmojiAuthorPage((Activity) this.f307437b, this.Q.getAccount(), 5, f("authorid"));
            return true;
        }
        if (this.f307440e.equals("bubble")) {
            Context context = this.f307437b;
            VasWebviewUtil.openQQBrowserWithoutAD(context, IndividuationUrlHelper.getMarketUrl(context, "bubble", IndividuationUrlHelper.AdTag.INDIVIDUATION_BUBBLE_ADTAG), 64L, null, false, -1);
            return true;
        }
        if (this.f307440e.equals("theme")) {
            if (BaseApplicationImpl.IS_SUPPORT_THEME && Utils.B()) {
                Context context2 = this.f307437b;
                VasWebviewUtil.openQQBrowserWithoutAD(context2, IndividuationUrlHelper.getMarketUrl(context2, "theme", IndividuationUrlHelper.AdTag.INDIVIDUATION_THEME_ADTAG), 32L, null, false, -1);
                return true;
            }
            return false;
        }
        if (this.f307440e.equals("font")) {
            if (((FontManager) this.Q.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).s() && Utils.B()) {
                Context context3 = this.f307437b;
                VasWebviewUtil.openQQBrowserWithoutAD(context3, IndividuationUrlHelper.getMarketUrl(context3, "font", ""), 4096L, null, false, -1);
                return true;
            }
            return false;
        }
        if (this.f307440e.equals(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
            if (Utils.B()) {
                AvatarPendantUtil.g(this.Q, this.f307437b);
            }
            return true;
        }
        if (this.f307440e.equals(IndividuationPlugin.BusinessName)) {
            VasWebviewUtil.openIndividuationIndex(this.f307437b);
            return true;
        }
        return false;
    }

    private boolean g4() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_STORY_VIDEO_SETTING, QzoneConfig.SECONDARY_JUMP_HYWS_SCHEME_ENABLE, 0) == 0 && BaseApplication.getContext() != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.fuq, 0).show();
                }
            });
            return false;
        }
        QLog.e("JumpAction", 1, "qqstory is deleted!!");
        return false;
    }

    private boolean h1() {
        String str;
        if (this.f307441f.containsKey("hotnamecode")) {
            str = this.f307441f.get("hotnamecode");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.nit), 1).show();
            return false;
        }
        NearbyTransitActivity.J2(this.f307437b, str, 1, this.f307441f);
        return true;
    }

    private boolean h2() {
        PublicFragmentActivity.start(this.f307437b, new Intent(), SearchMightKnowFragment.class);
        return true;
    }

    private boolean h3() {
        String str = this.f307441f.get("bid");
        String str2 = this.f307441f.get("sourceUrl");
        if (this.f307440e.equals("web")) {
            try {
                String decode = URLDecoder.decode(this.f307441f.get("url"));
                Bundle bundle = new Bundle();
                bundle.putString("url", decode);
                bundle.putString("uin", this.Q.getCurrentAccountUin());
                bundle.putBoolean("hide_operation_bar", true);
                bundle.putBoolean(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f307437b, IPublicAccountBrowser.ROUTE_NAME);
                activityURIRequest.extra().putAll(bundle);
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            } catch (Exception unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("JumpAction", 4, "URLDecoder.decode error");
                }
                return false;
            }
        }
        if (str != null && str2 != null) {
            ReportController.n(this.Q, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str, com.tencent.mobileqq.webview.util.s.d(str2, new String[0]), "", "");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h4(String str) {
        QLog.d("JumpAction", 1, "urlDecode imageUri=" + str);
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("JumpAction", 1, "UnsupportedEncodingException", e16);
            return URLDecoder.decode(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i1() {
        boolean z16;
        boolean z17;
        Context context;
        int i3 = 0;
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.nearby.l.b("JumpAction", "gotoHotchatNewYearScene");
        }
        try {
            if (this.f307441f.containsKey("trigger_anim")) {
                z17 = Boolean.parseBoolean(this.f307441f.get("trigger_anim"));
            } else {
                z17 = false;
            }
            try {
                if (this.f307441f.containsKey("from")) {
                    i3 = Integer.parseInt(this.f307441f.get("from"));
                }
            } catch (Exception e16) {
                z16 = z17;
                e = e16;
                e.printStackTrace();
                z17 = z16;
                Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
                aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
                aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                aliasIntent.setFlags(67108864);
                if (this.f307441f.containsKey("from")) {
                }
                if (this.f307441f.containsKey("trigger_anim")) {
                }
                context = this.f307437b;
                if (!(context instanceof SplashActivity)) {
                }
                return true;
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        Intent aliasIntent2 = SplashActivity.getAliasIntent(this.f307437b);
        aliasIntent2.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent2.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent2.setFlags(67108864);
        if (this.f307441f.containsKey("from")) {
            aliasIntent2.putExtra("from", i3);
        }
        if (this.f307441f.containsKey("trigger_anim")) {
            aliasIntent2.putExtra("trigger_anim", z17);
        }
        context = this.f307437b;
        if (!(context instanceof SplashActivity)) {
            aliasIntent2.putExtra(SplashActivity.SWITCH_ANIM, true);
            ((SplashActivity) context).openMainFragment(aliasIntent2);
        } else {
            context.startActivity(aliasIntent2);
            Context context2 = this.f307437b;
            if (context2 instanceof Activity) {
                ((Activity) context2).finish();
            }
        }
        return true;
    }

    private boolean i2() {
        if ("webview".equals(this.f307443h)) {
            ax.E(this.f307441f.get("title"));
            this.f307437b.startActivity(new Intent(this.f307437b, (Class<?>) JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra(ISchemeApi.KEY_IOS_SRC_TYPE, this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE)).putExtra("callback_type", this.f307441f.get("callback_type")).putExtra("callback_name", this.f307441f.get("callback_name")));
        }
        return true;
    }

    private void i3() {
        QLog.i("JumpAction", 1, "[handleServerUserProfileAndActionFriend] start");
        String str = this.f307441f.get("uin");
        String str2 = this.f307441f.get("peer_uid");
        if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(str)) {
            j3(str, str2);
            return;
        }
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
        if (!TextUtils.isEmpty(uinFromUid)) {
            j3(uinFromUid, str2);
        } else {
            k3(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i4(String str) {
        QLog.d("JumpAction", 1, "urlEncode filePath=" + str);
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.e("JumpAction", 1, "UnsupportedEncodingException", e16);
            return URLEncoder.encode(str);
        }
    }

    private boolean j1() {
        StringBuilder sb5 = new StringBuilder(this.f307441f.get("url"));
        sb5.append("?a=1");
        for (String str : this.f307441f.keySet()) {
            if (!"url".equals(str)) {
                try {
                    String encode = URLEncoder.encode(this.f307441f.get(str), "UTF-8");
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(str);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(encode);
                } catch (UnsupportedEncodingException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("JumpAction", 1, e16, new Object[0]);
                    }
                }
            }
        }
        String sb6 = sb5.toString();
        if (QLog.isDevelopLevel()) {
            QLog.e("JumpAction", 4, "gotoHuayang url==" + sb6);
        }
        Context context = this.f307437b;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.setFlags(536870912);
        intent.putExtra("url", sb6);
        context.startActivity(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(String str, @Nullable String str2) {
        AllInOne allInOne = new AllInOne(str, 111);
        if ("1".equals(this.f307441f.get("source"))) {
            allInOne.profileEntryType = 118;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 25);
        } else if ("2".equals(this.f307441f.get("source"))) {
            allInOne.profileEntryType = 121;
        } else if (A3(str2, this.f307441f.get("source"))) {
            QLog.i("JumpAction", 1, "[handleServerUserProfileAndActionFriend] troop stranger");
            allInOne.f260789pa = 21;
            allInOne.profileEntryType = 999;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 1);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 11);
            allInOne.extras.putString("troopUin", str2);
            allInOne.troopCode = str2;
        }
        ProfileUtils.openProfileCard(this.f307437b, allInOne);
    }

    private void j4(Intent intent, String str) {
        int parseInt;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "wpaParamsParse---Start");
        }
        boolean z16 = false;
        if (this.f307441f.get("paramencrypted_type") == null) {
            parseInt = 0;
        } else {
            parseInt = Integer.parseInt(this.f307441f.get("paramencrypted_type"));
        }
        intent.putExtra("from3rdApp", true);
        try {
            if (parseInt == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "params must be decrypted");
                }
                byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(new Cryptor().decrypt(HexUtil.hexStr2Bytes(str), "Hf7K(s*js12LiskW".getBytes()), 0);
                if (decode != null) {
                    jSONObject = new JSONObject(new String(decode));
                    if (jSONObject.has(TtmlNode.TAG_LAYOUT) && jSONObject.getString(TtmlNode.TAG_LAYOUT) != null) {
                        z16 = true;
                    }
                    intent.putExtra("showFirstStructMsg", z16);
                } else {
                    jSONObject = null;
                }
            } else {
                intent.putExtra("fromSencondhandCommunity", true);
                jSONObject = new JSONObject(str);
                intent.putExtra(QCircleRelationGroupRequest.GROUP_ID, jSONObject.getString(QCircleRelationGroupRequest.GROUP_ID));
            }
            if (jSONObject != null) {
                byte[] z17 = ChatActivityUtils.z(jSONObject);
                intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, z17);
                if (z17 != null && parseInt == 1) {
                    ReportController.o(this.Q, "CliOper", "", this.f307441f.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
                }
            }
        } catch (JSONException unused) {
            if (QLog.isDevelopLevel()) {
                QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
            }
        }
    }

    private void k0(Bundle bundle, String str, int i3, String str2) {
        String E = ax.E(this.f307441f.get(str));
        if (!TextUtils.isEmpty(E)) {
            if (E.getBytes().length <= i3) {
                bundle.putString(str2, E);
                QLog.i("JumpAction", 1, "addShareGameParam: has " + str);
                return;
            }
            QLog.i("JumpAction", 1, "addShareGameParam: too large " + str);
        }
    }

    private boolean k2() {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SEND_HONG_BAO, 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + this.f307441f.get("hb_id") + ", send_uin=" + this.f307441f.get("send_uin") + ", hong_bao_type=" + this.f307441f.get("hb_type") + ", hong_bao_summary=" + this.f307441f.get("hb_summary"));
        }
        Intent intent = new Intent();
        intent.putExtra("hb_id", this.f307441f.get("hb_id"));
        intent.putExtra("send_uin", this.f307441f.get("send_uin"));
        intent.putExtra("hb_type", this.f307441f.get("hb_type"));
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, this.f307441f.get("hb_summary"));
        intent.putExtra("forward_type", 17);
        ForwardBaseOption.startForwardActivity(this.f307437b, intent);
        return true;
    }

    private void k3(String str, @Nullable String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("JumpAction", 1, "handleServerUserProfileAndActionFriend is error! appRuntime is invalid!");
            return;
        }
        com.tencent.qqnt.kernel.api.ag uixConvertService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getUixConvertService();
        if (uixConvertService == null) {
            QLog.e("JumpAction", 1, "handleServerUserProfileAndActionFriend is error! uixConvertService is invalid!");
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(str);
        uixConvertService.getUin(hashSet, new n(str, str2));
    }

    private void k4(Intent intent) {
        if (intent != null && !TextUtils.isEmpty(this.f307449n)) {
            intent.putExtra("redTouch", this.f307449n);
        } else if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
        }
    }

    private void l0(Bundle bundle, HashMap<String, String> hashMap, int i3, int i16) {
        String str;
        boolean z16;
        String[] strArr = {"file_data", "description", "url", "image_url", "share_uin", AppConstants.Key.SHARE_REQ_EXT_STR};
        String[] strArr2 = {"image_url", "desc", "detail_url", AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, "share_uin", AppConstants.Key.SHARE_REQ_EXT_STR};
        boolean z17 = false;
        for (int i17 = 0; i17 < 6; i17++) {
            bundle.putString(strArr2[i17], ax.E(hashMap.get(strArr[i17])));
        }
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, i3);
        bundle.putInt(AppConstants.Key.SHARE_REQ_EXT_INT, i16);
        if (!TextUtils.isEmpty(this.f307444i)) {
            str = ax.E(hashMap.get("app_name"));
        } else {
            str = null;
        }
        bundle.putString("app_name", str);
        bundle.putString(AppConstants.Key.SHARE_REQ_SHARE_JFROM, hashMap.get(AppConstants.Key.SHARE_REQ_SHARE_JFROM));
        bundle.putString(AppConstants.Key.SHARE_REQ_CHANNEL_SRC, hashMap.get(AppConstants.Key.SHARE_REQ_CHANNEL_SRC));
        k0(bundle, AppConstants.Key.SHARE_REQ_GAME_TAG_NAME, 128, AppConstants.Key.SHARE_REQ_GAME_TAG_NAME);
        k0(bundle, AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT, 256, AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT);
        String E = ax.E(hashMap.get("title"));
        bundle.putString("title", E);
        if (E == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            bundle.putString(AppConstants.Key.SHARE_BRIEF, this.f307437b.getString(R.string.f171308dy0, str));
        } else {
            bundle.putString(AppConstants.Key.SHARE_BRIEF, this.f307437b.getString(R.string.f171308dy0, E));
        }
        bundle.putInt("forward_type", 11);
        bundle.putString("pkg_name", this.f307444i);
        if (i3 == 5 && com.tencent.mobileqq.forward.x.l()) {
            bundle.putBoolean("is_ark_display_share", true);
            bundle.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_SDK, true);
        }
        if (i3 == 2) {
            bundle.putString(AppConstants.Key.SHARE_REQ_AUDIO_URL, ax.E(hashMap.get("audioUrl")));
        }
        bundle.putBoolean("k_dataline", false);
        bundle.putBoolean("k_favorites", true);
        bundle.putBoolean(ForwardRecentActivity.KEY_SHOW_CANCEL_BUTTON, true);
        bundle.putInt("emoInputType", 2);
        if ((i16 & 2) == 0 && !"com.qzone".equals(this.f307444i)) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("k_qzone", z16);
        if (z16 && (i16 & 1) != 0) {
            z17 = true;
        }
        bundle.putBoolean("k_send", z17);
        bundle.putInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, 4);
        String E2 = ax.E(hashMap.get("sdk_version"));
        if (!TextUtils.isEmpty(E2)) {
            bundle.putString("sdk_version", E2);
        }
    }

    private boolean l2() {
        Intent intent = ((Activity) this.f307437b).getIntent();
        String stringExtra = intent.getStringExtra("uin");
        if (Utils.G(stringExtra)) {
            Intent intent2 = new Intent();
            intent2.putExtra("uin", stringExtra);
            intent2.putExtra("uintype", intent.getIntExtra("uintype", -1));
            long j3 = 0;
            try {
                if (!TextUtils.isEmpty(f(AppConstants.Key.MSG_UNISEQ))) {
                    j3 = Long.valueOf(f(AppConstants.Key.MSG_UNISEQ)).longValue();
                }
            } catch (Exception unused) {
                QLog.i("JumpAction", 1, "NumberFormatException uniseq:" + f(AppConstants.Key.MSG_UNISEQ));
            }
            String w16 = this.Q.getMessageFacade().w1(stringExtra, ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, j3);
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoSetAvator path:" + w16 + "msg uniseq:" + j3);
            }
            int min = Math.min(482, ProfileCardUtil.A((Activity) this.f307437b));
            intent2.putExtra("Business_Origin", 100);
            intent2.putExtra("open_chatfragment", true);
            intent2.putExtra("open_chat_from_avator", true);
            PhotoUtils.startPhotoEdit(intent2, (Activity) this.f307437b, SplashActivity.getAliasName(), min, min, 1080, 1080, w16, FaceUtil.getUploadAvatarTempPath());
            ReportController.o(this.Q, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
        }
        return true;
    }

    private boolean l3(Map<String, String> map) {
        if (map != null && !map.isEmpty() && map.containsKey(MiniAppPlugin.ATTR_PAGE_TYPE) && "desktop".equals(map.get(MiniAppPlugin.ATTR_PAGE_TYPE))) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).openDesktopWxAuthFragment();
            return true;
        }
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).openWxBindingPage();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (!this.f307458w && !((IMiniAppService) QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.f307441f)) {
            Context context = this.f307437b;
            if (context instanceof JumpActivity) {
                ((JumpActivity) context).finish();
            }
        }
        Context context2 = this.f307437b;
        if ((context2 instanceof GesturePWDUnlockActivity) && this.f307459x) {
            ((GesturePWDUnlockActivity) context2).finish();
        }
    }

    private boolean m2() {
        QQToast.makeText(this.f307437b, HardCodeUtil.qqStr(R.string.nis), 1).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m3(String str) {
        String saveFileUriToFile = FileUtils.saveFileUriToFile(this.f307437b, str, "opensdk_tmp");
        Y3(saveFileUriToFile);
        QLog.d("JumpAction", 1, "handleShareUri savePath=" + saveFileUriToFile);
        return saveFileUriToFile;
    }

    private void n0(Bundle bundle) {
        Context context = this.f307437b;
        if ((context instanceof JumpActivity) && !AppSetting.o(context) && ((JumpActivity) this.f307437b).getRequestedOrientation() == 1) {
            bundle.putInt(ForwardRecentActivity.KEY_REQUEST_ORIENTATION, 1);
        }
    }

    private boolean n1() {
        long j3;
        String str;
        final Intent startAddFriend;
        boolean z16;
        if (BaseActivity.sTopActivity == null) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "SplashActivity.sTopActivity == null");
            }
            u0();
        }
        String E = ax.E(this.f307441f.get("open_id"));
        String E2 = ax.E(this.f307441f.get("fopen_id"));
        String E3 = ax.E(this.f307441f.get("friend_label"));
        String E4 = ax.E(this.f307441f.get("add_msg"));
        String E5 = ax.E(this.f307441f.get("app_name"));
        String str2 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String E6 = ax.E(this.f307441f.get("is_from_game"));
        try {
            j3 = Long.valueOf(this.f307441f.get("app_id")).longValue();
        } catch (Exception unused) {
            j3 = 0;
        }
        if (j3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + j3);
            }
            return false;
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).setsOpenId(E);
        if ("true".equals(E6)) {
            str = ISchemeApi.KEY_IOS_SRC_TYPE;
            startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend((Activity) this.f307437b, 3, E2, "" + j3, 3090, 0, E3, E4, null, "", E5);
        } else {
            str = ISchemeApi.KEY_IOS_SRC_TYPE;
            startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend((Activity) this.f307437b, 3, E2, "" + j3, 3016, 0, E3, E4, null, "", E5);
        }
        startAddFriend.putExtra(str, str2);
        startAddFriend.putExtra("pkg_name", this.f307444i);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("launchAddFriend SplashActivity.sTopActivity == null ");
            if (BaseActivity.sTopActivity == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("JumpAction", 2, sb5.toString());
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.bc
            @Override // java.lang.Runnable
            public final void run() {
                JumpActionLegacy.this.G3(startAddFriend);
            }
        }, 50L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n2() {
        int i3;
        int Y2 = ForwardUtils.Y(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT)));
        if (Y2 == 1) {
            U1("shareToQQ");
            return true;
        }
        long Z2 = ForwardUtils.Z(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH));
        O3(Z2);
        if (Z2 <= 0) {
            QLog.d("StructMsg", 1, "gotoShareMsg appid = ", Long.valueOf(Z2));
            return false;
        }
        try {
            i3 = Integer.valueOf(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE))).intValue();
        } catch (NumberFormatException unused) {
            QLog.d("QQShare", 1, "NumberFormatException req_type = 1");
            i3 = 148;
        }
        String E = ax.E(this.f307441f.get("open_id"));
        V3(Z2, E, i3);
        final Bundle bundle = new Bundle();
        String E2 = ax.E(this.f307441f.get("share_to_qq_ark_info"));
        final Intent t36 = t3(E2, bundle, Z2);
        if (t36 == null) {
            QLog.d("JumpAction", 1, "gotoShareMsg: intent is null");
            return true;
        }
        String str = this.f307441f.get("file_type");
        if ("news".equals(str) || "audio".equals(str)) {
            l0(bundle, this.f307441f, i3, Y2);
            bundle.putLong("req_share_id", Z2);
            bundle.putString("open_id", E);
            bundle.putString(AppConstants.Key.SHARE_REQ_ARK_INFO, E2);
            boolean a16 = OpenSdkD55Processor.a();
            bundle.putBoolean("enable_d55", a16);
            if (a16) {
                ((com.tencent.mobileqq.forward.u) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SDK_SHARE)).c().c(E, Z2, this.f307444i);
            }
            n0(bundle);
            if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.f307441f)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.bb
                    @Override // java.lang.Runnable
                    public final void run() {
                        JumpActionLegacy.this.I3(bundle, t36);
                    }
                });
                return true;
            }
            t36.putExtras(bundle);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
            t36.addFlags(335544320);
            if (ForwardSdkShareOption.b0()) {
                t36.addFlags(8388608);
            }
            ForwardBaseOption.startForwardActivity(this.f307437b, t36);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(String str) {
        QLog.d("JumpAction", 1, "handleShareWebpOrHeif");
        com.tencent.mobileqq.qqalbum.a aVar = new com.tencent.mobileqq.qqalbum.a();
        aVar.f262095a = str;
        String str2 = System.currentTimeMillis() + ".jpg";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f307437b.getExternalFilesDir(null));
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("opensdk_tmp");
        sb5.append(str3);
        sb5.append(str2);
        aVar.f262096b = sb5.toString();
        if (((IPicToJpg) QRoute.api(IPicToJpg.class)).picToJpg(aVar)) {
            Y3(aVar.f262096b);
            QLog.d("JumpAction", 1, "handleShareWebpOrHeif success");
        }
    }

    private void o0(Intent intent) {
        HashMap<String, String> hashMap;
        if (intent != null && (hashMap = this.f307441f) != null && !hashMap.isEmpty()) {
            for (String str : this.f307441f.keySet()) {
                if (str.equals("key_from") || str.equals(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE)) {
                    intent.putExtra(str, this.f307441f.get(str));
                }
                if (str.equals("recall_id")) {
                    intent.putExtra(str, this.f307441f.get(str));
                }
            }
        }
    }

    private boolean o1() {
        Intent intent = new Intent(this.f307437b, (Class<?>) RecommendFriendActivity.class);
        intent.putExtra("EntranceId", 7);
        intent.putExtra(AppConstants.Key.KEY_FROM_BABYQ, true);
        this.f307437b.startActivity(intent);
        ReportController.o(this.Q, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
        return true;
    }

    private boolean o2() {
        boolean z16;
        if (JumpIntentCheckHelper.filterLaunchedFromHistory(this.f307437b)) {
            QLog.i("JumpAction", 1, "gotoShareMsgCheck: filter launched from history");
            return true;
        }
        ForwardStatisticsReporter.a();
        ForwardStatisticsReporter.m("KEY_STAGE_1_TOTAL");
        String str = this.f307441f.get("file_type");
        String E = ax.E(this.f307441f.get("file_data"));
        String E2 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_TYPE));
        final String E3 = ax.E(this.f307441f.get("file_uri"));
        String E4 = ax.E(this.f307441f.get("third_sd"));
        long Z2 = ForwardUtils.Z(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH));
        int Y2 = ForwardUtils.Y(ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_EXT_INT)));
        boolean b16 = BaseForwardUtil.b(this.f307437b);
        String valueOf = String.valueOf(b16);
        QLog.d("JumpAction", 1, "gotoShareMsgCheck appID:", Long.valueOf(Z2), ",file_type:", str, ",reqType=", E2, ",third_sd=", E4, ",qq_sd=", Boolean.valueOf(b16), ",file_data=", E, ",file_uri=", E3);
        if (Y2 == 1) {
            U1("shareToQQ");
            return true;
        }
        if (Z2 <= 0) {
            QLog.d("JumpAction", 1, "gotoShareMsgCheck appid = ", Long.valueOf(Z2));
            return false;
        }
        final HashMap hashMap = new HashMap(4);
        hashMap.put("KEY_SHARE_TYPE", E2);
        hashMap.put("KEY_FILE_TYPE", str);
        hashMap.put("KEY_THIRD_SD", E4);
        hashMap.put("KEY_QQ_SD", valueOf);
        boolean b17 = JumpActionSdkShareHelper.b();
        final boolean z17 = !TextUtils.isEmpty(E3);
        final String E5 = ax.E(this.f307441f.get("file_data"));
        final int parseInt = Integer.parseInt(E2);
        if (b17 && v3(E5, parseInt)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z17 && !z16) {
            ForwardStatisticsReporter.l("KEY_STAGE_1_SAVE_IMAGE", 0L, hashMap, false);
            return n2();
        }
        this.f307458w = false;
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean z18 = z16;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.19
            @Override // java.lang.Runnable
            public void run() {
                String str2 = E5;
                if (z17) {
                    if (FileUtils.checkIsValidUri(E3)) {
                        str2 = JumpActionLegacy.this.m3(E3);
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_share_uri_trans_jpg_switch", true)) {
                            boolean v3 = JumpActionLegacy.this.v3(str2, parseInt);
                            QLog.e("JumpAction", 1, "gotoShareMsgCheck uri needTransJpg: " + v3);
                            if (v3) {
                                JumpActionLegacy.this.n3(str2);
                            }
                        }
                    } else {
                        QLog.e("JumpAction", 1, "gotoShareMsgCheck uri check fail");
                        Context context = JumpActionLegacy.this.f307437b;
                        if (context instanceof JumpActivity) {
                            ((JumpActivity) context).finish();
                            return;
                        }
                        return;
                    }
                }
                if (z18) {
                    JumpActionLegacy.this.n3(str2);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ForwardStatisticsReporter.l("KEY_STAGE_1_SAVE_IMAGE", currentTimeMillis2, hashMap, true);
                QLog.i("JumpAction", 1, "gotoShareMsgCheck cost=" + currentTimeMillis2);
                JumpActionLegacy.this.n2();
                if (!JumpActionLegacy.this.f307458w && !((IMiniAppService) QRoute.api(IMiniAppService.class)).isSharingMiniProgram(JumpActionLegacy.this.f307441f)) {
                    Context context2 = JumpActionLegacy.this.f307437b;
                    if (context2 instanceof JumpActivity) {
                        ((JumpActivity) context2).finish();
                    }
                }
                JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                Context context3 = jumpActionLegacy.f307437b;
                if ((context3 instanceof GesturePWDUnlockActivity) && jumpActionLegacy.f307459x) {
                    ((GesturePWDUnlockActivity) context3).finish();
                }
            }
        }, 64, null, false);
        return false;
    }

    private void o3() {
        String f16 = f("payurl");
        if (!TextUtils.isEmpty(f16)) {
            String str = new String(Base64.decode(f16, 0));
            if (!TextUtils.isEmpty(str)) {
                QLog.e("JumpAction", 1, "payurl is call to launch");
                VasH5PayUtil.openH5PayByURL(this.f307437b, str);
                return;
            } else {
                QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + f16);
                return;
            }
        }
        QLog.e("JumpAction", 1, "payurl is null");
    }

    private boolean p0() {
        Intent intent;
        Context context = this.f307437b;
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return false;
        }
        try {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(AgentActivity.CONFIG_ENTRY_FILTER_INTENT_SWITCH, true);
            QLog.i("JumpAction", 2, "checkLaunchFromHistory switch: " + isSwitchOn);
            if (isSwitchOn) {
                if ((intent.getFlags() & 1048576) == 0) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.e("JumpAction", 1, "checkLaunchFromHistory exception", e16);
        }
        return false;
    }

    private boolean p2(final o oVar) {
        String E = ax.E(this.f307441f.get("image_url"));
        final String E2 = ax.E(this.f307441f.get(AppConstants.Key.SHARE_REQ_IMAGE_URI));
        String E3 = ax.E(this.f307441f.get("file_data"));
        final String E4 = ax.E(this.f307441f.get("file_uri"));
        if (!TextUtils.isEmpty(E) && !TextUtils.isEmpty(E2)) {
            QLog.d("JumpAction", 1, "imageUrl=", E, ", imageUri=", E2);
            this.f307458w = false;
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.27
                @Override // java.lang.Runnable
                public void run() {
                    Pair<Boolean, String> safeSaveFileUriToFile = FileUtils.safeSaveFileUriToFile(JumpActionLegacy.this.f307437b, E2, "opensdk_tmp");
                    if (!safeSaveFileUriToFile.first.booleanValue()) {
                        Context context = JumpActionLegacy.this.f307437b;
                        if (context instanceof JumpActivity) {
                            ((JumpActivity) context).finish();
                            return;
                        }
                        return;
                    }
                    String str = safeSaveFileUriToFile.second;
                    QLog.d("JumpAction", 1, "gotoShareMsgCheck save file to:", str, ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JumpActionLegacy.this.f307441f.put("image_url", new String(PluginBaseInfoHelper.Base64Helper.encode(str.getBytes("UTF-8"), 0)));
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e("JumpAction", 1, "gotoShareMsgCheck put exception:", e16);
                        }
                    }
                    oVar.callback();
                    JumpActionLegacy.this.m0();
                }
            });
            return false;
        }
        if (!TextUtils.isEmpty(E4) && !TextUtils.isEmpty(E3)) {
            QLog.d("JumpAction", 1, "fileUri=", E4, ", fileData=", E3);
            this.f307458w = false;
            final long currentTimeMillis2 = System.currentTimeMillis();
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.28
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb5 = new StringBuilder();
                    for (String str : E4.split(";")) {
                        String h46 = JumpActionLegacy.this.h4(str);
                        QLog.d("JumpAction", 1, "gotoShareMsgCheck path=", h46);
                        if (!TextUtils.isEmpty(h46)) {
                            if (!h46.startsWith("http")) {
                                Pair<Boolean, String> safeSaveFileUriToFile = FileUtils.safeSaveFileUriToFile(JumpActionLegacy.this.f307437b, h46, "opensdk_tmp");
                                if (!safeSaveFileUriToFile.first.booleanValue()) {
                                    Context context = JumpActionLegacy.this.f307437b;
                                    if (context instanceof JumpActivity) {
                                        ((JumpActivity) context).finish();
                                        return;
                                    }
                                    return;
                                }
                                h46 = safeSaveFileUriToFile.second;
                                QLog.d("JumpAction", 1, "gotoShareMsgCheck save file to:", h46, ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            }
                            sb5.append(JumpActionLegacy.this.i4(h46));
                            sb5.append(";");
                        }
                    }
                    if (sb5.length() > 0) {
                        sb5.deleteCharAt(sb5.length() - 1);
                        try {
                            JumpActionLegacy.this.f307441f.put("file_data", new String(PluginBaseInfoHelper.Base64Helper.encode(sb5.toString().getBytes("UTF-8"), 0)));
                        } catch (UnsupportedEncodingException e16) {
                            QLog.e("JumpAction", 1, "gotoShareMsgCheck put exception:", e16);
                        }
                    }
                    oVar.callback();
                    JumpActionLegacy.this.m0();
                }
            });
            return false;
        }
        return oVar.callback();
    }

    private boolean p3() {
        if (!u3()) {
            return false;
        }
        u0();
        if (!this.f307460y || ((QBaseActivity) this.f307437b) == null) {
            return false;
        }
        String str = this.f307441f.get("uin");
        final Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, this.f307438c);
        intent.putExtra("pkg_name", this.f307444i);
        intent.putExtra(AppConstants.Key.SHARE_REQ_WX_UIN_FROM_WX, str);
        QLog.i("JumpAction", 2, "gotoWxShareSplashActivity usingSplashBackground=" + this.f307461z);
        intent.putExtra(AppConstants.Key.SHARE_REQ_WX_USING_SPLASH_BACKGROUND, this.f307461z);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.be
            @Override // java.lang.Runnable
            public final void run() {
                JumpActionLegacy.J3(intent);
            }
        }, 50L);
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v7 */
    private boolean q0() {
        ?? r112;
        boolean z16;
        String str;
        String str2 = this.f307441f.get("app_type");
        String str3 = this.f307441f.get("mini_app_id");
        String str4 = this.f307441f.get("src_id");
        String E = ax.E(this.f307441f.get("app_id"));
        String E2 = ax.E(this.f307441f.get(AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH));
        String E3 = ax.E(this.f307441f.get(AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE));
        String E4 = ax.E(this.f307441f.get("app_name"));
        String E5 = ax.E(this.f307441f.get("open_id"));
        ReportController.o(this.Q, "dc01160", "", "", ForwardMiniAppThirdPartyHelper.THIRD_PARTY_TRY_PULL_UP_MINI_APP, ForwardMiniAppThirdPartyHelper.THIRD_PARTY_TRY_PULL_UP_MINI_APP, 0, 0, "", "", E, str3);
        if (TextUtils.isEmpty(this.f307444i)) {
            ReportController.o(this.Q, "dc01160", "", "", ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_FAIL, ForwardMiniAppThirdPartyHelper.THIRD_PARTY_PULL_UP_MINI_APP_FAIL, 0, 0, "", "", E, str3);
            QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
            return true;
        }
        if (!"mini_program_or_game".equals(str2)) {
            return true;
        }
        if (!NetworkUtil.isNetSupport(this.f307437b)) {
            QQToast.makeText(this.f307437b, 1, R.string.izp, 1).show();
            Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
            aliasIntent.addFlags(67108864);
            aliasIntent.addFlags(268435456);
            this.f307437b.startActivity(aliasIntent);
            return true;
        }
        Handler handler = new Handler();
        this.E = handler;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.13
            @Override // java.lang.Runnable
            public void run() {
                JumpActionLegacy.this.F = true;
            }
        }, 20000L);
        this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.14
            @Override // java.lang.Runnable
            public void run() {
                JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                if (jumpActionLegacy.G) {
                    jumpActionLegacy.d4(R.string.vta);
                }
            }
        }, 500L);
        try {
            this.G = true;
            if (!TextUtils.isEmpty(E5)) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.m("KEY_STAGE_2_CONNECT_MINI_D55");
            MessageHandler msgHandler = this.Q.getMsgHandler();
            if (E5 == null) {
                str = "";
            } else {
                str = E5;
            }
            r112 = 1;
            try {
                msgHandler.M2(z16, str, true, Long.valueOf(str3).longValue(), Long.valueOf(E).longValue(), 1, Integer.valueOf(str4).intValue(), this.f307444i, false, 0L, new d(E, str3, E2, E3, E5, E4));
                return false;
            } catch (Exception e16) {
                e = e16;
                if (this.G) {
                    this.G = false;
                    s3();
                }
                QLog.e("JumpAction", (int) r112, "checkAppSignAndOpenidDiff exception: " + e.getMessage());
                return r112;
            }
        } catch (Exception e17) {
            e = e17;
            r112 = 1;
        }
    }

    private void q1() {
        String str = this.f307440e;
        if (str != null && (str.equals("forward_msg_list") || this.f307440e.equals("open_conversation"))) {
            int i3 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
            try {
                long parseLong = Long.parseLong(this.f307441f.get("third_open_conversation_sceneid"));
                ReportController.o(this.Q, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, parseLong + "", "", "", "");
            } catch (Exception e16) {
                QLog.e("JumpAction", 1, "sceneid must be a numeric string, errorMsg: " + e16.toString());
            }
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(this.f307437b));
            intent.setFlags(335544320);
            intent.putExtra("tab_index", i3);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            this.f307437b.startActivity(intent);
            return;
        }
        QLog.e("JumpAction", 1, "action_name doesnt match: " + this.f307440e);
    }

    private boolean q2() {
        String str = this.f307441f.get("card_type");
        if (str != null && VipFunCallConstants.KEY_GROUP.equals(str)) {
            U3(10010, F0());
            return t2();
        }
        if ("groupsearchsetting".equalsIgnoreCase(str)) {
            return ((ITroopSettingApi) QRoute.api(ITroopSettingApi.class)).handleShowSearchWayInAIO(this.f307437b, this.f307441f.get("uin"));
        }
        if ("groupmanager".equalsIgnoreCase(str)) {
            return e1();
        }
        if (SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(str)) {
            U3(10003, F0());
            return A2();
        }
        if ("troopmember".equals(str)) {
            return C2();
        }
        if ("crm".equals(str)) {
            return s2();
        }
        if (ProcessConstant.NEARBY.equals(str)) {
            return t1();
        }
        if ("allpeoplevote".equals(str)) {
            return M0();
        }
        if ("troopmemberfromhb".equals(str)) {
            return D2();
        }
        if ("groupsetting".equals(str)) {
            return u2();
        }
        U3(10002, F0());
        return y2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e7, code lost:
    
        if ("0".equals(r4.getJSONObject("param").getJSONObject(r8.A.missions.get(0)).getString("_red_ext_type")) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q3(Intent intent, String str, String str2) {
        int i3;
        if (!intent.hasExtra("click_start_time")) {
            intent.putExtra("click_start_time", System.currentTimeMillis());
        }
        intent.putExtra("is_from_webview", "webview".equals(this.f307443h));
        BusinessInfoCheckUpdate.AppInfo appInfo = this.A;
        if (appInfo != null && this.f307450o && appInfo.uiAppId.get() == 769) {
            int i16 = this.A.push_red_ts.get();
            int i17 = 0;
            try {
                i3 = Integer.parseInt(this.f307441f.get("redtouch_click_timestamp"));
            } catch (Exception e16) {
                e16.printStackTrace();
                i3 = 0;
            }
            SharedPreferences sharedPreferences = this.Q.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
            int i18 = sharedPreferences.getInt("reader_zone_appinfo_last_pull_timestamp_" + this.Q.getCurrentAccountUin(), 0);
            sharedPreferences.edit().putInt("reader_zone_appinfo_last_pull_timestamp_" + this.Q.getCurrentAccountUin(), 0).commit();
            if (this.A.buffer.has()) {
                try {
                    JSONObject jSONObject = new JSONObject(this.A.buffer.get());
                    if (this.A.missions.has() && !this.A.missions.isEmpty()) {
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            i17 = 1;
            intent.putExtra("redtouch_type", i17);
            intent.putExtra("redtouch_push_ts", i16);
            intent.putExtra("redtouch_pull_ts", i18);
            intent.putExtra("redtouch_click_ts", i3);
            if (this.A.missions.has() && !this.A.missions.isEmpty()) {
                intent.putStringArrayListExtra("redtouch_taskid", new ArrayList<>(this.A.missions.get()));
            }
        }
        intent.putExtra(PluginStatic.PARAM_UIN, this.Q.getCurrentAccountUin());
        intent.putExtra("load_from_third_app", true);
        intent.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, true);
        intent.putExtra("current_qr_uin", this.Q.getCurrentAccountUin());
        intent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
        k4(intent);
        intent.setClassName(this.f307437b, str);
        try {
            this.f307437b.startActivity(intent);
            if (!PluginProxyActivity.READER_ID.equals(str2)) {
                ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).preloadQWallet(this.Q);
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.26
                    @Override // java.lang.Runnable
                    public void run() {
                        IWebProcessPreload iWebProcessPreload;
                        QQAppInterface qQAppInterface = JumpActionLegacy.this.Q;
                        if (qQAppInterface == null) {
                            return;
                        }
                        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                        if (!TextUtils.isEmpty(currentAccountUin) && (iWebProcessPreload = (IWebProcessPreload) QRoute.api(IWebProcessPreload.class)) != null) {
                            iWebProcessPreload.setBusinessClickTimeMills(currentAccountUin, "reader");
                        }
                    }
                }, 5, null, true);
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String str, String str2) {
        String[] strArr;
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split(";");
        String E = ax.E(this.f307441f.get("image_url"));
        if (E != null) {
            strArr = E.split(";");
        } else {
            strArr = null;
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            String decode = URLDecoder.decode(split[i3]);
            if (!TextUtils.isEmpty(decode)) {
                Pair<Boolean, String> safeSaveFileUriToFile = FileUtils.safeSaveFileUriToFile(this.f307437b, decode, "opensdk_tmp");
                if (!safeSaveFileUriToFile.first.booleanValue()) {
                    Context context = this.f307437b;
                    if (context instanceof JumpActivity) {
                        ((JumpActivity) context).finish();
                        return;
                    }
                    return;
                }
                String str3 = safeSaveFileUriToFile.second;
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(URLEncoder.encode(str3));
                } else if (strArr != null && i3 < strArr.length) {
                    stringBuffer.append(strArr[i3]);
                }
                if (i3 != split.length - 1) {
                    stringBuffer.append(";");
                }
            }
        }
        try {
            this.f307441f.put("image_url", new String(PluginBaseInfoHelper.Base64Helper.encode(stringBuffer.toString().getBytes("UTF-8"), 0)));
        } catch (UnsupportedEncodingException e16) {
            QLog.i("JumpAction", 1, "gotoShareMsgCheck put exception:", e16);
        }
        V1(str2, false);
        Context context2 = this.f307437b;
        if ((context2 instanceof GesturePWDUnlockActivity) && this.f307459x) {
            ((GesturePWDUnlockActivity) context2).finish();
        }
    }

    private boolean r1() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
        }
        String str = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String str2 = this.f307441f.get("version");
        String str3 = this.f307441f.get("chat_type");
        String str4 = this.f307441f.get("relation_id");
        String str5 = this.f307441f.get(CloudStorageServlet.REQUEST_TYPE);
        String str6 = this.f307441f.get(AdParam.ACTID);
        String str7 = this.f307441f.get("mp_ext_params");
        HashMap hashMap = new HashMap();
        if (str5 != null && str5.equals("video")) {
            hashMap.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, "true");
        }
        if (str7 != null) {
            hashMap.put("mp_ext_params", str7);
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoMultiVoiceChat mp_ext_params : " + str7);
            }
        }
        if (str6 != null && str5 != null) {
            hashMap.put(AdParam.ACTID, str6);
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoMultiVoiceChat actId : " + str6);
            }
        }
        if (str != null && str.equals("web") && str2 != null && str2.equals("1") && str4 != null && str3 != null) {
            if (str3.equals("discussgroup")) {
                if (str4.equals("0")) {
                    Intent intent = new Intent();
                    intent.putExtra("param_type", 3000);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1003);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, this.f307437b.getString(R.string.conversation_options_multiaudio));
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, this.f307437b.getString(R.string.ano));
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, this.f307437b.getString(R.string.anp));
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
                    intent.setFlags(603979776);
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((QBaseActivity) this.f307437b, intent, 1);
                    return true;
                }
                return ChatActivityUtils.d0(this.Q, this.f307437b, 3000, str4, true, true, this.X, hashMap);
            }
            if (str3.equals("single")) {
                Intent intent2 = new Intent();
                intent2.putExtra("forward_type", 13);
                intent2.putExtra("fromWebXman", true);
                ForwardBaseOption.startForwardActivityForResult((QBaseActivity) this.f307437b, intent2, 2);
                return true;
            }
            if (str3.equals(VipFunCallConstants.KEY_GROUP)) {
                if (str4.equals("0")) {
                    return true;
                }
                String str8 = this.f307441f.get("jump_from");
                if (!"gvideo".equals(str8) && !"gvideo_h5".equals(str8)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return ChatActivityUtils.d0(this.Q, this.f307437b, 1, str4, true, z16, this.X, this.f307441f);
            }
        }
        return false;
    }

    private boolean r2() {
        int i3;
        String str = this.f307441f.get("from_type");
        if (!TextUtils.isEmpty(str) && w3(str)) {
            i3 = Integer.valueOf(str).intValue();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "gotoShowContactsTab " + i3);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
        aliasIntent.setFlags(67108864);
        aliasIntent.putExtra("jumpFromType", i3);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183040c);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        this.f307437b.startActivity(aliasIntent);
        return true;
    }

    private void r3() {
        if (this.f307441f.containsKey("msgid")) {
            QQReminderJumpFragment.ph(this.f307437b, this.f307441f.get("msgid"));
        }
    }

    private boolean s0() {
        boolean booleanValue = ((Boolean) ((com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10)).j("key_share_encrypt_flag", Boolean.FALSE)).booleanValue();
        if (TextUtils.isEmpty(this.f307441f.get("token")) && !TextUtils.equals(this.f307440e, "publish") && booleanValue) {
            this.f307440e = "open";
            od0.a.a(this.f307441f);
        }
        g4();
        return true;
    }

    private boolean s2() {
        String str = this.f307441f.get("uin");
        if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.Q.getCurrentAccountUin());
        }
        if (str == null || "".equals(str) || this.Q.getCurrentAccountUin().equals(str) || str.length() < 5) {
            return false;
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(null, this.Q, this.f307437b, str, -7);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:3|(2:5|(20:9|(18:11|12|(1:14)|15|16|17|(1:19)|20|(1:22)|23|(1:25)|26|27|(2:41|42)|29|(2:34|35)|31|32)|53|12|(0)|15|16|17|(0)|20|(0)|23|(0)|26|27|(0)|29|(0)|31|32))(1:55)|54|53|12|(0)|15|16|17|(0)|20|(0)|23|(0)|26|27|(0)|29|(0)|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0202, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0207, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0209, code lost:
    
        com.tencent.qphone.base.util.QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0173 A[Catch: Exception -> 0x0202, TryCatch #2 {Exception -> 0x0202, blocks: (B:17:0x0155, B:20:0x016b, B:22:0x0173, B:23:0x01eb, B:26:0x01fb), top: B:16:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean t0() {
        Class cls;
        String str;
        String str2;
        int b16;
        String substring;
        int indexOf;
        if ("takevideo".equals(this.f307440e)) {
            String str3 = this.f307441f.get(IAECameraUnit.WIDGET_NAME);
            String str4 = this.f307441f.get("from");
            String str5 = this.f307441f.get("activity_id");
            String str6 = this.f307441f.get("shareto");
            String str7 = this.f307441f.get("cmode");
            String str8 = this.f307441f.get(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            String str9 = this.f307441f.get("cake_id");
            String str10 = this.f307441f.get("nick");
            String str11 = this.f307441f.get("preview");
            String str12 = this.f307441f.get("toUin");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.f307438c)) {
                cls = IAECameraPrefsUtil.class;
                int indexOf2 = this.f307438c.indexOf("widgetinfo=");
                if (indexOf2 >= 0 && (indexOf = (substring = this.f307438c.substring(indexOf2 + 11)).indexOf("&cmode=")) >= 0) {
                    str = str9;
                    if (substring.startsWith("http")) {
                        str2 = substring.substring(0, indexOf);
                        ms.a.f("JumpAction", "parseUrl=" + str2);
                        if (!TextUtils.isEmpty(str3)) {
                            bundle.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, str3);
                        }
                        Bundle handleWidgetInfo = ((IJumpUtil) QRoute.api(IJumpUtil.class)).handleWidgetInfo(bundle, str2);
                        ms.a.f("JumpAction", "jumpActionUrl\u3010widgetid\u3011:" + str3 + "\u3010from\u3011:" + str4 + "\u3010activity_id\u3011:" + str5 + "\u3010shareto\u3011:" + str6 + "\u3010cmode\u3011:" + str7 + "\u3010" + PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM + "\u3011:" + str2);
                        b16 = js.a.f(str4).b();
                        a4(handleWidgetInfo, b16);
                        if (b16 == js.a.f410917q.b()) {
                            str5 = "qzone_takesame";
                        }
                        if (b16 == js.a.M.b()) {
                            str7 = AECameraConstants.AECAMERA_MODE_ARCAKE;
                            handleWidgetInfo.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, null);
                            String str13 = str;
                            handleWidgetInfo.putString(IAECameraUnit.KEY_ARCAKE_ID, str13);
                            ((IAECameraPrefsUtil) QRoute.api(cls)).putString(IAECameraPrefsUtil.KEY_ARCAKE_ID, str13, 4);
                            ((IAECameraPrefsUtil) QRoute.api(cls)).putString(IAECameraPrefsUtil.KEY_ARCAKE_NICK, str10, 4);
                            ((IAECameraPrefsUtil) QRoute.api(cls)).putString(IAECameraPrefsUtil.KEY_ARCAKE_PREVIEW, str11, 4);
                            ((IAECameraPrefsUtil) QRoute.api(cls)).putString(IAECameraPrefsUtil.KEY_ARCAKE_TOUIN, str12, 4);
                            ms.a.f("JumpAction", "arcake arCakeID : " + str13 + "fromnick : " + str10 + " preview " + str11 + " toNickUin " + str12);
                        }
                        if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isAddPlayShowEntry(b16)) {
                            str7 = AECameraConstants.AECAMERA_MODE_NO_GIF_MODE;
                        }
                        handleWidgetInfo.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
                        if (!TextUtils.isEmpty(str5)) {
                            try {
                                handleWidgetInfo.putString(AECameraConstants.VIDEO_STORY_ACTIVITY_ID, str5);
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + e16.getMessage());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            try {
                                handleWidgetInfo.putInt(AECameraConstants.AECAMERA_MODE, ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).switchModeToInt(str7));
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + e17.getMessage());
                                }
                            }
                        }
                        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity) this.f307437b, 120, handleWidgetInfo);
                        return true;
                    }
                    str2 = str8;
                    if (!TextUtils.isEmpty(str3)) {
                    }
                    Bundle handleWidgetInfo2 = ((IJumpUtil) QRoute.api(IJumpUtil.class)).handleWidgetInfo(bundle, str2);
                    ms.a.f("JumpAction", "jumpActionUrl\u3010widgetid\u3011:" + str3 + "\u3010from\u3011:" + str4 + "\u3010activity_id\u3011:" + str5 + "\u3010shareto\u3011:" + str6 + "\u3010cmode\u3011:" + str7 + "\u3010" + PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM + "\u3011:" + str2);
                    b16 = js.a.f(str4).b();
                    a4(handleWidgetInfo2, b16);
                    if (b16 == js.a.f410917q.b()) {
                    }
                    if (b16 == js.a.M.b()) {
                    }
                    if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isAddPlayShowEntry(b16)) {
                    }
                    handleWidgetInfo2.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    if (!TextUtils.isEmpty(str7)) {
                    }
                    ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity) this.f307437b, 120, handleWidgetInfo2);
                    return true;
                }
            } else {
                cls = IAECameraPrefsUtil.class;
            }
            str = str9;
            str2 = str8;
            if (!TextUtils.isEmpty(str3)) {
            }
            Bundle handleWidgetInfo22 = ((IJumpUtil) QRoute.api(IJumpUtil.class)).handleWidgetInfo(bundle, str2);
            ms.a.f("JumpAction", "jumpActionUrl\u3010widgetid\u3011:" + str3 + "\u3010from\u3011:" + str4 + "\u3010activity_id\u3011:" + str5 + "\u3010shareto\u3011:" + str6 + "\u3010cmode\u3011:" + str7 + "\u3010" + PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM + "\u3011:" + str2);
            b16 = js.a.f(str4).b();
            a4(handleWidgetInfo22, b16);
            if (b16 == js.a.f410917q.b()) {
            }
            if (b16 == js.a.M.b()) {
            }
            if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isAddPlayShowEntry(b16)) {
            }
            handleWidgetInfo22.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
            if (!TextUtils.isEmpty(str5)) {
            }
            if (!TextUtils.isEmpty(str7)) {
            }
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity) this.f307437b, 120, handleWidgetInfo22);
            return true;
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:3)(1:179)|4|(1:6)(1:178)|7|(1:9)(1:177)|10|(1:176)(1:14)|15|(10:172|173|18|(7:168|169|21|22|(1:24)(1:166)|25|(19:27|28|29|30|(1:32)(1:162)|33|34|35|(1:37)(1:159)|38|40|41|42|43|44|(1:46)(1:154)|47|48|(2:57|(18:104|(1:106)(2:149|(1:151)(1:152))|107|(6:109|(1:111)(1:147)|112|(1:114)(1:146)|115|(2:117|(2:119|120)(1:121))(1:122))(1:148)|123|(1:125)(1:145)|126|(1:128)|129|(1:131)|132|(1:134)|135|(1:139)|140|(1:142)|143|144)(2:61|(2:63|(1:65)(4:66|(1:68)(2:71|(1:73)(1:74))|69|70))(4:75|(1:77)(1:103)|78|(12:85|(1:87)|88|(1:90)(1:102)|91|(1:93)|94|(1:96)|97|(1:99)|100|101)(1:84))))(1:55))(38:164|29|30|(0)(0)|33|34|35|(0)(0)|38|40|41|42|43|44|(0)(0)|47|48|(0)|57|(1:59)|104|(0)(0)|107|(0)(0)|123|(0)(0)|126|(0)|129|(0)|132|(0)|135|(2:137|139)|140|(0)|143|144))|20|21|22|(0)(0)|25|(0)(0))|17|18|(0)|20|21|22|(0)(0)|25|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00d2 A[Catch: Exception -> 0x00db, TRY_LEAVE, TryCatch #2 {Exception -> 0x00db, blocks: (B:22:0x00b3, B:24:0x00be, B:25:0x00cb, B:164:0x00d2), top: B:21:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be A[Catch: Exception -> 0x00db, TryCatch #2 {Exception -> 0x00db, blocks: (B:22:0x00b3, B:24:0x00be, B:25:0x00cb, B:164:0x00d2), top: B:21:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8 A[Catch: Exception -> 0x00fa, TryCatch #3 {Exception -> 0x00fa, blocks: (B:30:0x00dd, B:32:0x00e8, B:33:0x00f5), top: B:29:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106 A[Catch: Exception -> 0x011c, TryCatch #0 {Exception -> 0x011c, blocks: (B:35:0x00fb, B:37:0x0106, B:38:0x0113), top: B:34:0x00fb }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a A[Catch: Exception -> 0x0144, TryCatch #5 {Exception -> 0x0144, blocks: (B:44:0x0121, B:46:0x012a, B:47:0x0139), top: B:43:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean t1() {
        String str;
        int i3;
        String str2;
        boolean z16;
        long longValue;
        int intValue;
        long j3;
        int i16;
        int i17;
        String str3;
        int i18;
        Intent intent;
        String str4;
        QQAppInterface qQAppInterface;
        String str5;
        int i19;
        boolean z17;
        int i26;
        String str6;
        String str7;
        String str8;
        int i27;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        if (!this.f307441f.containsKey("source_id")) {
            str = "";
        } else {
            str = this.f307441f.get("source_id");
        }
        if (this.f307441f.containsKey("source")) {
            i3 = Integer.parseInt(this.f307441f.get("source"));
        } else {
            i3 = 1;
        }
        if (!this.f307441f.containsKey("reportsource")) {
            str2 = "";
        } else {
            str2 = this.f307441f.get("reportsource");
        }
        if (this.f307441f.containsKey("from_now_plugin") && "1".equals(this.f307441f.get("from_now_plugin"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f307441f.containsKey("now_id")) {
            try {
                longValue = Long.valueOf(this.f307441f.get("now_id")).longValue();
            } catch (Exception unused) {
                QLog.i("JumpAction", 1, "illegal now_id");
            }
            if (this.f307441f.containsKey("now_user_type")) {
                try {
                    intValue = Integer.valueOf(this.f307441f.get("now_user_type")).intValue();
                } catch (Exception unused2) {
                    QLog.i("JumpAction", 1, "illegal now_user_type");
                }
                if (!this.f307441f.containsKey("tinnyid")) {
                    str13 = "";
                } else {
                    str13 = this.f307441f.get("tinnyid");
                }
                if (!TextUtils.isEmpty(str13)) {
                    j3 = Long.valueOf(str13).longValue();
                    if (this.f307441f.containsKey("from")) {
                    }
                    i16 = Integer.parseInt(str12);
                    if (this.f307441f.containsKey("mode")) {
                    }
                    i17 = Integer.valueOf(str11).intValue();
                    str3 = "";
                    if (!this.f307441f.containsKey("refresh")) {
                    }
                    i18 = Integer.valueOf(str10).intValue();
                    if (i17 == 1) {
                    }
                    intent = new Intent();
                    intent.putExtra("refresh_flag", i18);
                    intent.putExtra("is_from_now_plugin", z16);
                    intent.putExtra("now_id", longValue);
                    intent.putExtra("now_id_type", intValue);
                    intent.putExtra("new_source", i3);
                    M3(intent);
                    str4 = str;
                    if (i17 == 1) {
                    }
                    qQAppInterface = this.Q;
                    if (qQAppInterface != null) {
                    }
                    if (Utils.p(str4, "1001")) {
                    }
                    z17 = false;
                    AllInOne allInOne = new AllInOne(str5, 0);
                    if (i16 == i19) {
                    }
                    if (i16 == 2) {
                    }
                    if (i16 == 3) {
                    }
                    if (i16 >= 7) {
                    }
                    intent.putExtra("param_mode", i17);
                    intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
                    if (!TextUtils.isEmpty(str4)) {
                        z17 = true;
                    }
                    intent.putExtra("param_from_interest_test", z17);
                    if (10002 == i16) {
                    }
                    intent.putExtra("param_tiny_id", j3);
                    RouteUtils.startActivity(this.f307437b, intent, "/nearby/people/profile");
                    return true;
                }
                j3 = 0;
                try {
                    if (this.f307441f.containsKey("from")) {
                        str12 = "";
                    } else {
                        str12 = this.f307441f.get("from");
                    }
                    i16 = Integer.parseInt(str12);
                } catch (Exception unused3) {
                    i16 = 0;
                }
                try {
                    if (this.f307441f.containsKey("mode")) {
                        str11 = "";
                    } else {
                        str11 = this.f307441f.get("mode");
                    }
                    i17 = Integer.valueOf(str11).intValue();
                } catch (Exception unused4) {
                    i17 = -1;
                }
                try {
                    str3 = "";
                } catch (Exception unused5) {
                    str3 = "";
                }
                try {
                    if (!this.f307441f.containsKey("refresh")) {
                        str10 = this.f307441f.get("refresh");
                    } else {
                        str10 = "0";
                    }
                    i18 = Integer.valueOf(str10).intValue();
                } catch (Exception unused6) {
                    i18 = 0;
                    if (i17 == 1) {
                    }
                    intent = new Intent();
                    intent.putExtra("refresh_flag", i18);
                    intent.putExtra("is_from_now_plugin", z16);
                    intent.putExtra("now_id", longValue);
                    intent.putExtra("now_id_type", intValue);
                    intent.putExtra("new_source", i3);
                    M3(intent);
                    str4 = str;
                    if (i17 == 1) {
                    }
                    qQAppInterface = this.Q;
                    if (qQAppInterface != null) {
                    }
                    if (Utils.p(str4, "1001")) {
                    }
                    z17 = false;
                    AllInOne allInOne2 = new AllInOne(str5, 0);
                    if (i16 == i19) {
                    }
                    if (i16 == 2) {
                    }
                    if (i16 == 3) {
                    }
                    if (i16 >= 7) {
                    }
                    intent.putExtra("param_mode", i17);
                    intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne2);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    intent.putExtra("param_from_interest_test", z17);
                    if (10002 == i16) {
                    }
                    intent.putExtra("param_tiny_id", j3);
                    RouteUtils.startActivity(this.f307437b, intent, "/nearby/people/profile");
                    return true;
                }
                if (i17 == 1 && i17 != 2 && i17 != 3 && i17 != 4) {
                    return false;
                }
                intent = new Intent();
                intent.putExtra("refresh_flag", i18);
                intent.putExtra("is_from_now_plugin", z16);
                intent.putExtra("now_id", longValue);
                intent.putExtra("now_id_type", intValue);
                intent.putExtra("new_source", i3);
                M3(intent);
                str4 = str;
                if (i17 == 1 && i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 4) {
                            return true;
                        }
                        QQAppInterface qQAppInterface2 = this.Q;
                        if (qQAppInterface2 != null) {
                            str9 = qQAppInterface2.getAccount();
                        } else {
                            AppInterface appInterface = this.H;
                            if (appInterface != null) {
                                str9 = appInterface.getAccount();
                            } else {
                                str9 = str3;
                            }
                        }
                        Parcelable allInOne3 = new AllInOne(str9, 0);
                        intent.putExtra("is_from_web", true);
                        intent.putExtra("param_mode", i17);
                        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne3);
                        intent.addFlags(268435456);
                        intent.putExtra("param_tiny_id", j3);
                        RouteUtils.startActivity(this.f307437b, intent, "/nearby/people/profile");
                        return true;
                    }
                    if (this.f307441f.containsKey("uin")) {
                        str8 = this.f307441f.get("uin");
                    } else {
                        str8 = str3;
                    }
                    if (j3 == 0 && TextUtils.isEmpty(str8) && longValue == 0) {
                        return false;
                    }
                    intent.putExtra("param_mode", 3);
                    intent.putExtra("param_tiny_id", j3);
                    if (10002 == i16) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("is_from_web", true);
                    intent.putExtra("NEARBY_MSG_REPORT_SOURCE", str2);
                    AllInOne allInOne4 = new AllInOne(str8, 19);
                    if (i16 == 1) {
                        intent.putExtra("frome_where", 12);
                        allInOne4.f260789pa = 86;
                        i27 = 268435456;
                        intent.addFlags(268435456);
                    } else {
                        i27 = 268435456;
                    }
                    if (i16 == 2) {
                        allInOne4.f260789pa = 87;
                        intent.addFlags(i27);
                    }
                    if (i16 == 3) {
                        allInOne4.f260789pa = 88;
                        intent.addFlags(i27);
                    }
                    if (i16 >= 7) {
                        intent.putExtra("frome_where", i16);
                        allInOne4.f260789pa = 86;
                        intent.addFlags(i27);
                    }
                    intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne4);
                    RouteUtils.startActivity(this.f307437b, intent, "/nearby/people/profile");
                    return true;
                }
                qQAppInterface = this.Q;
                if (qQAppInterface != null) {
                    str5 = qQAppInterface.getAccount();
                } else {
                    AppInterface appInterface2 = this.H;
                    if (appInterface2 != null) {
                        str5 = appInterface2.getAccount();
                    } else {
                        str5 = str3;
                    }
                }
                if (Utils.p(str4, "1001")) {
                    if (this.f307441f.containsKey("uid")) {
                        str6 = this.f307441f.get("uid");
                    } else {
                        str6 = str3;
                    }
                    if (this.f307441f.containsKey("PUSH_CONTENT")) {
                        str7 = this.f307441f.get("PUSH_CONTENT");
                    } else {
                        str7 = str3;
                    }
                    if (!Utils.p(str6, str5)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("JumpAction", 2, "gotoNearybyProfile,return caused by different uid");
                            return true;
                        }
                        return true;
                    }
                    i19 = 1;
                    intent.putExtra("PUSH_CONTENT", str7);
                    intent.putExtra("frome_where", -1);
                    intent.addFlags(67108864);
                } else {
                    i19 = 1;
                    intent.putExtra("is_from_web", true);
                }
                z17 = false;
                AllInOne allInOne22 = new AllInOne(str5, 0);
                if (i16 == i19) {
                    intent.putExtra("frome_where", 12);
                    allInOne22.f260789pa = 86;
                    i26 = 268435456;
                    intent.addFlags(268435456);
                } else {
                    i26 = 268435456;
                }
                if (i16 == 2) {
                    allInOne22.f260789pa = 87;
                    intent.addFlags(i26);
                }
                if (i16 == 3) {
                    allInOne22.f260789pa = 88;
                    intent.addFlags(i26);
                }
                if (i16 >= 7) {
                    intent.putExtra("frome_where", i16);
                    allInOne22.f260789pa = 86;
                    intent.addFlags(i26);
                }
                intent.putExtra("param_mode", i17);
                intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne22);
                if (!TextUtils.isEmpty(str4) && str4.equals("1000")) {
                    z17 = true;
                }
                intent.putExtra("param_from_interest_test", z17);
                if (10002 == i16) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("param_tiny_id", j3);
                RouteUtils.startActivity(this.f307437b, intent, "/nearby/people/profile");
                return true;
            }
            intValue = 0;
            if (!this.f307441f.containsKey("tinnyid")) {
            }
            if (!TextUtils.isEmpty(str13)) {
            }
        }
        longValue = 0;
        if (this.f307441f.containsKey("now_user_type")) {
        }
        intValue = 0;
        if (!this.f307441f.containsKey("tinnyid")) {
        }
        if (!TextUtils.isEmpty(str13)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean t2() {
        boolean z16;
        String str;
        Bundle b16;
        int parseInt;
        String str2;
        String str3;
        boolean z17;
        String str4 = this.f307441f.get("uin");
        if (this.f307441f.containsKey("isPrivate")) {
            try {
                String str5 = this.f307441f.get("isPrivate");
                if (str5 != null && !TextUtils.isEmpty(str5) && Integer.parseInt(str5) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.Q.addObserver(this.W);
                    ((QidianHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).H2(str4);
                    return true;
                }
            } catch (Exception e16) {
                QLog.e("JumpAction", 1, "gotoShowGroupCard [private troop] exception: ", e16.toString());
            }
        }
        if (str4 != null) {
            String str6 = "";
            if (!"".equals(str4) && str4.length() >= 5) {
                if (!this.f307441f.containsKey("jump_from")) {
                    str = "";
                } else {
                    str = this.f307441f.get("jump_from");
                }
                if (this.f307441f.containsKey("source_id")) {
                    str6 = this.f307441f.get("source_id");
                }
                if ("QRJumpActivity".equalsIgnoreCase(str)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 14);
                } else {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 5);
                }
                if ("d2g".equals(str)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 16);
                    b16.putInt("D2GType", 2);
                }
                String str7 = this.f307441f.get("jump_from_group_search");
                if (str7 != null && !TextUtils.isEmpty(str7)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, Integer.parseInt(str7));
                }
                if ("h5".equalsIgnoreCase(str)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 22);
                } else if ("groupprofile".equalsIgnoreCase(str)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 22);
                    b16.putBoolean("troop_info_from_troopsetting", true);
                }
                if ("webapi".equalsIgnoreCase(str)) {
                    if ("3_40002".equalsIgnoreCase(str6)) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, 40002);
                    } else {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, 40001);
                    }
                }
                if ("wegame".equalsIgnoreCase(str)) {
                    b16 = com.tencent.mobileqq.troop.utils.aq.b(str4, 1001);
                }
                String str8 = this.f307441f.get("wSourceSubID");
                try {
                    parseInt = Integer.parseInt(str8);
                    if (parseInt == 43) {
                        parseInt = 10002;
                    }
                    if (parseInt == 33) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM, 24);
                    } else if (parseInt == 37) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM, 30);
                    } else if (parseInt == 10008) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM, 102);
                    } else if (parseInt == 10013) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM, 106);
                    } else if (parseInt >= 30006 && parseInt <= 30020) {
                        b16.putInt(AppConstants.Key.TROOP_INFO_FROM, parseInt);
                    }
                    str2 = this.f307441f.get("sourceext");
                    str3 = this.f307441f.get("isexactsearch");
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                    }
                }
                if (str2 != null && str3 != null && !str2.isEmpty() && !str3.isEmpty()) {
                    int parseInt2 = Integer.parseInt(str2);
                    if (Integer.parseInt(str3) == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (parseInt2 != 1) {
                        if (parseInt2 != 2) {
                            if (parseInt2 != 3) {
                                if (parseInt2 != 4) {
                                    if (parseInt2 == 5) {
                                        if (z17) {
                                            parseInt = 30018;
                                        } else {
                                            parseInt = 30020;
                                        }
                                    }
                                } else if (z17) {
                                    parseInt = BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT;
                                } else {
                                    parseInt = 30016;
                                }
                            } else if (z17) {
                                parseInt = BaseConstants.ERR_SVR_FRIENDSHIP_COUNT_LIMIT;
                            } else {
                                parseInt = BaseConstants.ERR_SVR_FRIENDSHIP_PENDENCY_LIMIT;
                            }
                        } else {
                            if (!z17) {
                                parseInt = BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT;
                            }
                            parseInt = 30004;
                        }
                    } else if (z17) {
                        parseInt = 30004;
                    } else {
                        parseInt = 30006;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str8);
                    }
                    if (this.f307441f.containsKey("from_type") && !TextUtils.isEmpty(this.f307441f.get("from_type")) && Integer.parseInt(this.f307441f.get("from_type")) == 100) {
                        b16.putBoolean(AppConstants.Key.KEY_FROM_BABYQ, true);
                        ReportController.o(this.Q, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
                    }
                    b16.putString("authKey", this.f307441f.get("authKey"));
                    b16.putString("authSig", this.f307441f.get("authSig"));
                    b16.putString("keyword", this.f307441f.get("keyword"));
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, String.format("gotoShowGroupCard troop_authSig=%s", this.f307441f.get("authSig")));
                    }
                    if (this.f307441f.containsKey("appid")) {
                        b16.putString("appid", this.f307441f.get("appid"));
                    }
                    if (this.f307441f.containsKey("openid")) {
                        b16.putString("openid", this.f307441f.get("openid"));
                    }
                    if (this.f307441f.containsKey("trans_info")) {
                        b16.putString("trans_info", this.f307441f.get("trans_info"));
                    }
                    if (this.f307441f.containsKey("group_name")) {
                        b16.putString(AppConstants.Key.TROOP_INFO_NAME, this.f307441f.get("group_name"));
                    }
                    b16.putString("market_channel_source", this.f307441f.get("market_channel_source"));
                    b16.putString("sec_biz_id", this.f307441f.get("sec_biz_id"));
                    TroopUtils.I(this.f307437b, b16, 2);
                    return true;
                }
                b16.putInt(AppConstants.Key.TROOP_INFO_FROM_EX, parseInt);
                if (this.f307441f.containsKey("from_type")) {
                    b16.putBoolean(AppConstants.Key.KEY_FROM_BABYQ, true);
                    ReportController.o(this.Q, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
                }
                b16.putString("authKey", this.f307441f.get("authKey"));
                b16.putString("authSig", this.f307441f.get("authSig"));
                b16.putString("keyword", this.f307441f.get("keyword"));
                if (QLog.isColorLevel()) {
                }
                if (this.f307441f.containsKey("appid")) {
                }
                if (this.f307441f.containsKey("openid")) {
                }
                if (this.f307441f.containsKey("trans_info")) {
                }
                if (this.f307441f.containsKey("group_name")) {
                }
                b16.putString("market_channel_source", this.f307441f.get("market_channel_source"));
                b16.putString("sec_biz_id", this.f307441f.get("sec_biz_id"));
                TroopUtils.I(this.f307437b, b16, 2);
                return true;
            }
        }
        return false;
    }

    private Intent t3(String str, Bundle bundle, long j3) {
        bundle.putBoolean("is_ark_display_share", false);
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.ark.d.d("JumpAction", "gotoShareArkMsg, appInfo is empty");
            return b4(bundle);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("view");
            String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            String optString4 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString5 = jSONObject.optString(DownloadInfo.spKey_Config);
            String optString6 = jSONObject.optString("prompt");
            String optString7 = jSONObject.optString("desc");
            String optString8 = jSONObject.optString("ver");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4)) {
                bundle.putBoolean("is_ark_display_share", true);
                Intent K2 = ArkFullScreenAppActivity.K2(this.f307437b, optString2, optString, optString3, optString4, optString5, optString6, String.valueOf(j3), this.f307437b.getResources().getDisplayMetrics().scaledDensity, optString7, optString8);
                com.tencent.mobileqq.ark.d.d("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
                return K2;
            }
            com.tencent.mobileqq.ark.d.d("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
            return b4(bundle);
        } catch (JSONException e16) {
            com.tencent.mobileqq.ark.d.d("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", e16.getMessage()));
            return b4(bundle);
        }
    }

    private void u0() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        RouteUtils.startActivity(this.f307437b, intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    private boolean u2() {
        String str = this.f307441f.get("uin");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TroopUtils.L(this.Q, this.f307437b, str, this.f307441f.get("focus_item"));
        return true;
    }

    private boolean u3() {
        if ("weixin-share".equals(this.f307441f.get("from"))) {
            QLog.i("JumpAction", 2, "isFromWxShare");
            return true;
        }
        return false;
    }

    private String v0(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private boolean v2() {
        String str = this.f307441f.get("lon");
        String str2 = this.f307441f.get(QCircleSchemeAttr.Polymerize.LAT);
        if (str != null && str2 != null) {
            try {
                double parseInt = Integer.parseInt(str.trim()) / 1000000.0d;
                ax.E(this.f307441f.get("title"));
                String str3 = AppConstants.GOOGLEMAP_URL_HTTPS + (Integer.parseInt(str2.trim()) / 1000000.0d) + "," + parseInt + "&hl=zh-CN";
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str3));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                try {
                    this.f307437b.startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    this.f307437b.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str3)));
                    return true;
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v3(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            if ((i3 == 5 && "webp".equals(FileUtils.estimateFileType(str))) || ((IPicToJpg) QRoute.api(IPicToJpg.class)).isHeif(str)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean w0(final Runnable runnable, final String str, final String str2, final String str3) {
        this.f307458w = false;
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.9
            @Override // java.lang.Runnable
            public void run() {
                if (!FileUtils.checkIsValidUri(str)) {
                    QLog.e("JumpAction", 1, "-->executeOnSubThread unsafe uri: " + str);
                    Context context = JumpActionLegacy.this.f307437b;
                    if (context instanceof JumpActivity) {
                        ((JumpActivity) context).finish();
                        return;
                    }
                    return;
                }
                String saveFileUriToFile = FileUtils.saveFileUriToFile(JumpActionLegacy.this.f307437b, str, "opensdk_tmp");
                QLog.d("JumpAction", 1, "-->executeOnSubThread shareFilePath=", saveFileUriToFile, ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                JumpActionLegacy.this.f307441f.remove(str2);
                if (!TextUtils.isEmpty(saveFileUriToFile)) {
                    try {
                        JumpActionLegacy.this.f307441f.put(str3, new String(PluginBaseInfoHelper.Base64Helper.encode(saveFileUriToFile.getBytes("UTF-8"), 0)));
                    } catch (UnsupportedEncodingException e16) {
                        QLog.i("JumpAction", 1, "executeOnSubThread put exception:", e16);
                    }
                }
                runnable.run();
                JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                if (!jumpActionLegacy.f307458w) {
                    Context context2 = jumpActionLegacy.f307437b;
                    if (context2 instanceof JumpActivity) {
                        ((JumpActivity) context2).finish();
                    }
                }
            }
        });
        return true;
    }

    private boolean w1() {
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend((Activity) this.f307437b, 1, ax.E(this.f307441f.get("friendUin")), "", 3001, 11, "", "", null, "", ""));
        return true;
    }

    private boolean w2() {
        com.tencent.mobileqq.troop.data.f.f(this.f307437b, this.Q);
        return true;
    }

    public static boolean w3(String str) {
        return Pattern.compile("[0-9]+").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Context context = this.f307437b;
        if (context != null && (context instanceof JumpActivity)) {
            ((JumpActivity) context).finish();
        }
    }

    private boolean x1() {
        return true;
    }

    private boolean x2() {
        int i3;
        Intent intent = new Intent();
        String str = this.f307441f.get("from_type");
        if (!TextUtils.isEmpty(str) && w3(str)) {
            i3 = Integer.valueOf(str).intValue();
        } else {
            i3 = 0;
        }
        intent.putExtra("jumpFromType", i3);
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "gotoShowNewFriends " + i3);
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(this.f307437b, intent, 9);
        return true;
    }

    private void x3(String str) {
        if (str.equals(GameCenterActivity.class.getName()) || str.equals(((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountBrowser.class)) || str.equals(CouponActivity.class.getName())) {
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).preloadQWallet(this.Q);
        }
    }

    private String y0(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("i=")) {
            int indexOf = str.indexOf("i=");
            int indexOf2 = str.substring(indexOf).indexOf(38);
            if (indexOf2 <= 0) {
                indexOf2 = str.length() - indexOf;
            }
            return str.substring(indexOf + 2, indexOf + indexOf2);
        }
        return null;
    }

    private boolean y1() {
        try {
            String str = this.f307441f.get("openid");
            int parseInt = Integer.parseInt(this.f307441f.get("appid"));
            if (str == null) {
                return false;
            }
            Intent aliasIntent = SplashActivity.getAliasIntent(this.f307437b);
            aliasIntent.setFlags(335544320);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra("openid", str);
            aliasIntent.putExtra("appid", parseInt);
            aliasIntent.putExtra("source", this.f307438c);
            this.f307437b.startActivity(aliasIntent);
            return true;
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "Receive error appid number format");
            }
            return false;
        }
    }

    private boolean y2() {
        AllInOne allInOne;
        int i3;
        String str = this.f307441f.get("uin");
        if (Boolean.parseBoolean(this.f307441f.get("jump_add_friend"))) {
            return K1(str);
        }
        String str2 = this.f307441f.get("wpa");
        String str3 = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        boolean equals = "1".equals(this.f307441f.get("track_back"));
        boolean equals2 = "1".equals(this.f307441f.get("singleTop"));
        boolean equals3 = "1".equals(this.f307441f.get("group_video_open"));
        boolean equals4 = "1".equals(this.f307441f.get("blockSplit"));
        if ("internal_phone".equals(str3)) {
            ReportController.o(this.Q, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
            allInOne = new AllInOne(str, 53);
            allInOne.contactName = URLDecoder.decode(this.f307441f.get("nickname"));
            allInOne.profileEntryType = 105;
        } else if (str != null && !"".equals(str) && !this.Q.getCurrentAccountUin().equals(str)) {
            if (str.length() < 5) {
                return false;
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "JumpAction");
            if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "JumpAction")) {
                allInOne = new AllInOne(str, 1);
                allInOne.nickname = friendsSimpleInfoWithUid.p();
                allInOne.remark = friendsSimpleInfoWithUid.r();
            } else if (this.f307446k) {
                AllInOne allInOne2 = new AllInOne(str, 3);
                allInOne2.chatAbility = "1".equals(str2) ? 1 : 0;
                allInOne2.subSourceId = 11;
                allInOne = allInOne2;
            } else if (equals3) {
                allInOne = new AllInOne(str, 116);
            } else {
                allInOne = new AllInOne(str, 78);
                String str4 = this.f307441f.get("referee");
                if (!TextUtils.isEmpty(str4)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("flc_recommend_uin", str4);
                    allInOne.extras.putBundle("flc_extra_param", bundle);
                }
            }
            if (this.f307446k) {
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 6);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, E0(this.f307441f.get(ReportConstant.COSTREPORT_PREFIX)));
            } else if ("sharecard".equals(this.f307441f.get("source"))) {
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 10);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 101);
            } else if ("zplanMiniConnect".equals(this.f307441f.get("source"))) {
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 14);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 43);
            }
            N2(allInOne);
        } else {
            allInOne = new AllInOne(this.Q.getCurrentAccountUin(), 0);
            if (this.f307446k) {
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 6);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, E0(this.f307441f.get(ReportConstant.COSTREPORT_PREFIX)));
            }
        }
        Bundle bundle2 = new Bundle();
        String str5 = this.f307441f.get("from_type");
        if (!TextUtils.isEmpty(str5) && w3(str5)) {
            i3 = Integer.valueOf(str5).intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0 && this.f307441f.containsKey(AppConstants.Key.MSG_UNISEQ)) {
            String str6 = this.f307441f.get(AppConstants.Key.MSG_UNISEQ);
            if (i3 == 100 && Utils.G(str6)) {
                bundle2.putBoolean(AppConstants.Key.KEY_FROM_BABYQ, true);
                ReportController.o(this.Q, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
            }
        }
        if (this.f307441f.containsKey(ColorScreenJsPlugin.BUSINESS_NAME)) {
            allInOne.colorScreen = Integer.parseInt(this.f307441f.get(ColorScreenJsPlugin.BUSINESS_NAME));
        }
        bundle2.putBoolean(AppConstants.Key.KEY_NEED_TRACK_BACK, equals);
        bundle2.putBoolean("single_top", equals2);
        bundle2.putBoolean(AppConstants.Key.KEY_BLOCK_SPLIT, equals4);
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, String.format("gotoShowPSLCard [%d %b %b]", Integer.valueOf(i3), Boolean.valueOf(equals), Boolean.valueOf(equals2)));
        }
        ProfileActivity.J2(this.f307437b, allInOne, bundle2);
        return true;
    }

    private boolean y3(String str) {
        if (!"enterSocialSquare".equals(str) && !"squareArkInvite".equals(str) && !"squarePersonalCenter".equals(str) && !"enterLibrary".equals(str) && !"enterThemeSpace".equals(str) && !"enterChatLand".equals(str)) {
            return false;
        }
        return true;
    }

    private boolean z1() {
        String str = this.f307441f.get("uin");
        try {
            if (TextUtils.isEmpty(str)) {
                str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            }
            QZoneHelper.forwardToUserHome((Activity) this.f307437b, QZoneHelper.UserInfo.getInstance(), str, 0, 0, 0);
        } catch (Exception e16) {
            QLog.e("JumpAction", 1, e16, new Object[0]);
        }
        return true;
    }

    private boolean z2() {
        String str = this.f307441f.get("uin");
        int i3 = 0;
        if (str != null && !"".equals(str) && !this.Q.getCurrentAccountUin().equals(str)) {
            if (str.length() < 5) {
                return false;
            }
            i3 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "JumpAction") ? 1 : 2;
        }
        AllInOne allInOne = new AllInOne(str, i3);
        Intent intent = new Intent(this.f307437b, (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra("personality_label_allinone", allInOne);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 1);
        intent.putExtra("uin", str);
        if (!(this.f307437b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f307437b.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "gotoShowPersonalityLabel. uin:" + str);
        }
        return true;
    }

    private boolean z3(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/normalvideolayer") && TextUtils.equals(G0(str), "6")) {
            return true;
        }
        return false;
    }

    public boolean A0() {
        EnterpriseQQHandler enterpriseQQHandler;
        String str = this.f307441f.get("account_type");
        if (str != null && SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(str)) {
            int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(Integer.parseInt(this.f307441f.get("account_flag")));
            if (accountType == -3 || accountType == -4) {
                ((IPublicAccountHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getAIOHistoryMsg(this.f307441f.get("uin"), 0L, 1);
            }
        } else if (str != null && "crm".equals(str) && (enterpriseQQHandler = (EnterpriseQQHandler) this.Q.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER)) != null) {
            enterpriseQQHandler.D2(SystemClock.uptimeMillis());
        }
        return true;
    }

    protected ILoginRegisterApi B0() {
        return (ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class);
    }

    protected String D0() {
        return "mqqapi://" + this.f307439d + "/" + this.f307440e + "?src_type=" + this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
    }

    public boolean E2() {
        ((ISmallVideoFragmentUtil) QRoute.api(ISmallVideoFragmentUtil.class)).launch(this.f307437b, this.f307438c);
        return true;
    }

    public boolean L0() {
        Bundle bundle = new Bundle();
        int parseInt = Integer.parseInt(this.f307441f.get("des_type"));
        if (parseInt != 0 && parseInt != 1 && parseInt != 2) {
            parseInt = 0;
        }
        bundle.putInt("tab_index_key", parseInt);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(this.f307437b, 0, 0, LaunchMode.singleTop, bundle);
        return true;
    }

    public boolean N0() {
        ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingPage(this.f307437b, new Intent());
        return true;
    }

    public boolean T0() {
        Intent intent = new Intent(this.f307437b, (Class<?>) ConferenceFlyTicketActivity.class);
        String str = this.f307441f.get("confid");
        String str2 = this.f307441f.get("subject");
        String str3 = this.f307441f.get("confidshort");
        String str4 = this.f307441f.get("ticket");
        String str5 = this.f307441f.get("discid");
        String str6 = this.f307441f.get("confphone");
        String str7 = this.f307441f.get("businesstype");
        String str8 = this.f307441f.get("stask");
        String str9 = this.f307441f.get(QCircleAlphaUserReporter.KEY_USER);
        String str10 = this.f307441f.get("ticket_f");
        intent.putExtra("confid", str);
        intent.putExtra("subject", str2);
        intent.putExtra("ticket", str4);
        intent.putExtra("confidshort", str3);
        intent.putExtra("discid", str5);
        intent.putExtra("confphone", str6);
        intent.putExtra("businesstype", str7);
        intent.putExtra(QCircleAlphaUserReporter.KEY_USER, str9);
        intent.putExtra("stask", str8);
        intent.putExtra("ticket_f", str10);
        QQAudioHelper.p("start_ConferenceFlyTicketActivity");
        this.f307437b.startActivity(intent);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:875:0x0c0b, code lost:
    
        if ("ilive".equals(r27.f307439d) != false) goto L653;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0c96 A[Catch: Exception -> 0x0c55, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0c55, blocks: (B:323:0x0c45, B:325:0x0c50, B:329:0x0c63, B:331:0x0c6e, B:335:0x0c7b, B:337:0x0c86, B:341:0x0c96, B:345:0x0ca6, B:347:0x0cb1, B:351:0x0cc1, B:353:0x0ccc, B:355:0x0cd1, B:357:0x0cdc, B:362:0x0cef, B:364:0x0cf7, B:366:0x0cfc, B:368:0x0d07, B:375:0x0d24, B:377:0x0d2c, B:381:0x0d3c, B:383:0x0d47, B:387:0x0d5e, B:389:0x0d69, B:391:0x0d6f, B:393:0x0d8d, B:397:0x0da1, B:401:0x0db1, B:405:0x0dc1, B:407:0x0dc9, B:411:0x0dd9, B:413:0x0de1, B:415:0x0dee, B:421:0x0e02, B:423:0x0e0a, B:425:0x0e17, B:431:0x0e2b, B:435:0x0e46, B:439:0x0e63, B:443:0x0e7e, B:447:0x0e99, B:449:0x0eac, B:451:0x0eb4, B:452:0x0eb6, B:456:0x0ee0, B:460:0x0ef0, B:464:0x0f14, B:466:0x0f1a, B:471:0x0f32, B:473:0x0f3d, B:478:0x0f4f, B:480:0x0f57, B:490:0x0f7e, B:494:0x0f9c, B:500:0x0fbe, B:889:0x08d3, B:891:0x08db, B:701:0x08eb, B:703:0x08f3, B:707:0x0903, B:711:0x0913, B:713:0x091e, B:717:0x092b, B:719:0x0936, B:723:0x0946, B:725:0x0951, B:727:0x0956, B:729:0x0961, B:731:0x0966, B:733:0x0971, B:737:0x0981, B:739:0x098c, B:741:0x0991, B:743:0x099c, B:745:0x09a1, B:747:0x09ac, B:749:0x09b1, B:751:0x09bc, B:755:0x09cc, B:757:0x09d7, B:761:0x09e7, B:763:0x09f2, B:770:0x0a0f, B:772:0x0a1a, B:776:0x0a27, B:778:0x0a32, B:782:0x0a47, B:784:0x0a52, B:788:0x0a62, B:790:0x0a6d, B:794:0x0a7d, B:798:0x0a8d, B:802:0x0a9d, B:804:0x0aa8, B:808:0x0ab8, B:812:0x0ac8, B:816:0x0ad8, B:820:0x0ae8, B:824:0x0af8, B:826:0x0b03, B:830:0x0b39, B:832:0x0b44, B:836:0x0b54, B:838:0x0b5f, B:843:0x0b70, B:847:0x0b8a, B:849:0x0b95, B:853:0x0ba5, B:855:0x0bb0, B:858:0x0bbc, B:860:0x0bc7, B:862:0x0bd2, B:864:0x0bd7, B:866:0x0be2, B:868:0x0bed, B:870:0x0bf2, B:872:0x0bf7, B:874:0x0c02, B:876:0x0c0d, B:878:0x0c15, B:880:0x0c1a, B:882:0x0c25, B:886:0x0c35), top: B:888:0x08d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0c9b A[Catch: Exception -> 0x10da, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x10da, blocks: (B:321:0x0c3a, B:327:0x0c5b, B:333:0x0c73, B:339:0x0c8b, B:343:0x0c9b, B:349:0x0cb6, B:360:0x0ce4, B:370:0x0d0c, B:373:0x0d19, B:379:0x0d31, B:385:0x0d53, B:395:0x0d96, B:399:0x0da6, B:403:0x0db6, B:409:0x0dce, B:419:0x0df7, B:429:0x0e20, B:433:0x0e3b, B:437:0x0e58, B:441:0x0e73, B:445:0x0e8e, B:454:0x0ed5, B:458:0x0ee5, B:462:0x0f09, B:469:0x0f27, B:476:0x0f44, B:483:0x0f5e, B:486:0x0f69, B:488:0x0f71, B:492:0x0f8f, B:496:0x0fad, B:498:0x0fba, B:502:0x0fc2, B:504:0x0fd9, B:506:0x0fdd, B:508:0x0fe3, B:697:0x08cb, B:699:0x08e0, B:705:0x08f8, B:709:0x0908, B:715:0x0923, B:721:0x093b, B:735:0x0976, B:753:0x09c1, B:759:0x09dc, B:765:0x09f7, B:768:0x0a04, B:774:0x0a1f, B:780:0x0a3c, B:786:0x0a57, B:792:0x0a72, B:796:0x0a82, B:800:0x0a92, B:806:0x0aad, B:810:0x0abd, B:814:0x0acd, B:818:0x0add, B:822:0x0aed, B:828:0x0b2e, B:834:0x0b49, B:840:0x0b64, B:845:0x0b7f, B:851:0x0b9a, B:884:0x0c2a), top: B:696:0x08cb }] */
    /* JADX WARN: Removed duplicated region for block: B:529:0x1105  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x110b  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x1111  */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Class<com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity>, java.lang.Class] */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        String str;
        String str2;
        Exception exc;
        String str3;
        String str4;
        PBRepeatField<String> pBRepeatField;
        String str5;
        String str6;
        String str7;
        int i3;
        String str8 = "share";
        try {
            try {
                if ("com.qqfav".equals(this.f307439d)) {
                    return T2();
                }
                if ("urlopen".equals(this.f307439d) && OpenConstants.ApiName.PAY.equals(this.f307440e)) {
                    o3();
                }
                if ("qqidentifier".equals(this.f307439d) && "web".equals(this.f307440e)) {
                    return Z2();
                }
                if ("qsubscribe".equals(this.f307439d)) {
                    com.tencent.biz.subscribe.d.k((Activity) this.f307437b, this.f307440e, this.f307441f);
                    return true;
                }
                if ("qcircle".equals(this.f307439d)) {
                    com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(this.f307437b, this.f307440e, this.f307441f);
                    return true;
                }
                if ("qevent".equals(this.f307439d)) {
                    ((IFlockLauncher) QRoute.api(IFlockLauncher.class)).launchFlockBySchemeAction(this.f307437b, this.f307440e, this.f307441f);
                    return true;
                }
                if ("videostory".equals(this.f307439d)) {
                    return t0();
                }
                if (this.f307439d.equals("manage_troop") && this.f307440e.equals("main_page")) {
                    return I2();
                }
                if ("microapp".equals(this.f307439d) && "open".equals(this.f307440e)) {
                    return a3();
                }
                if ("miniapp".equals(this.f307439d) && "open".equals(this.f307440e)) {
                    return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f307437b, this.f307438c, 2016, null);
                }
                if ("miniapp".equals(this.f307439d) && "gamesearch".equals(this.f307440e)) {
                    ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).openMinGameSearchPage(this.f307437b, this.f307438c);
                    return true;
                }
                if ("miniapp".equals(this.f307439d) && "bindwx".equals(this.f307440e)) {
                    return l3(this.f307441f);
                }
                if ("zplan".equals(this.f307439d) && "enterAvatarScene".equals(this.f307440e)) {
                    return ((IZPlanApi) QRoute.api(IZPlanApi.class)).handleZPlanEnterAvatarSceneScheme(this.f307437b, this.f307438c, this.f307441f);
                }
                if ("zplan".equals(this.f307439d) && IndividuationPlugin.Method_OpenPage.equals(this.f307440e)) {
                    return ((IZPlanApi) QRoute.api(IZPlanApi.class)).handleZPlanOpenPageScheme(this.f307437b, this.f307438c, this.f307441f);
                }
                if ("zplan".equals(this.f307439d) && "thirdJump".equals(this.f307440e)) {
                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).handleZplanThirdScheme(this.f307437b, this.f307441f);
                    return true;
                }
                if ("zplan".equals(this.f307439d) && y3(this.f307440e)) {
                    ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).handleSquareScheme(this.f307437b, this.f307438c, this.f307440e, this.f307441f);
                    return true;
                }
                if ("zplan".equals(this.f307439d) && "openHomeConnected".equals(this.f307440e)) {
                    return ((IZPlanApi) QRoute.api(IZPlanApi.class)).handleZPlanEnterAvatarSceneScheme(this.f307437b, this.f307438c, this.f307441f);
                }
                if ("miniapp".equals(this.f307439d) && "notifyclose".equals(this.f307440e)) {
                    return X2();
                }
                if (QCircleDaTongConstant.ElementParamValue.WALLET.equals(this.f307439d) && "open".equals(this.f307440e) && "0".equals(this.f307441f.get("viewtype")) && !TextUtils.isEmpty(this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE)) && (this.f307441f.get("view") == null || "0".equals(this.f307441f.get("view")))) {
                    if (this.f307441f.containsKey(WadlProxyConsts.CHANNEL)) {
                        i3 = Integer.valueOf(this.f307441f.get(WadlProxyConsts.CHANNEL)).intValue();
                    } else {
                        i3 = 0;
                    }
                    return N1(i3);
                }
                if (QCircleDaTongConstant.ElementParamValue.WALLET.equals(this.f307439d) && "open".equals(this.f307440e) && "0".equals(this.f307441f.get("viewtype")) && !TextUtils.isEmpty(this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE))) {
                    return e3();
                }
                if ("wxminiapp".equals(this.f307439d) && "launch".equals(this.f307440e) && this.f307441f.containsKey(AudienceReportConst.USER_NAME) && !StringUtil.isEmpty(this.f307441f.get(AudienceReportConst.USER_NAME))) {
                    return K3();
                }
                if ("qqnotify".equals(this.f307439d)) {
                    if ("open".equals(this.f307440e)) {
                        b3();
                    } else if ("subscribe".equals(this.f307440e)) {
                        c3();
                    } else if ("jump".equals(this.f307440e)) {
                        r3();
                    }
                }
                if ("qqnotify".equals(this.f307439d) && "birth".equals(this.f307440e)) {
                    Intent intent = new Intent(this.f307437b, (Class<?>) ActivateFriendActivity.class);
                    intent.putExtra("af_key_from", 2);
                    this.f307437b.startActivity(intent);
                }
                if (this.f307439d.equals("ftssearch")) {
                    if (this.f307440e.equals("tab")) {
                        return J2();
                    }
                    if (this.f307440e.equals("openmixweb")) {
                        return p1();
                    }
                }
                if (this.f307439d.equals("wpa") && this.f307440e.equals("openid_to_uin")) {
                    return y1();
                }
                if (this.f307439d.equals("im") && this.f307440e.equals("chat")) {
                    return Q0();
                }
                if (this.f307439d.equals("wsgzh") && this.f307440e.equals("waterfall")) {
                    ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(this.f307437b, "from_search_rzh_ws", false);
                    return true;
                }
                if (this.f307439d.equals("wsgzh") && this.f307440e.equals("miniapp_player") && "openPlayer".equals(this.f307441f.get("action"))) {
                    return ((IWSManager) QRoute.api(IWSManager.class)).enterWSVerticalPlayerPageForMiniApp(this.f307437b, this.f307441f);
                }
                if (this.f307439d.equals("wsgzh") && this.f307440e.equals("wesee") && "operationh5".equals(this.f307441f.get("action"))) {
                    return ((IWSManager) QRoute.api(IWSManager.class)).enterWSOperationH5(this.f307437b, this.f307441f);
                }
                if (this.f307439d.equals("asyncmsg") && this.f307440e.equals("open_async_detail")) {
                    return x1();
                }
                if (this.f307439d.equals("connect_miniapp") && this.f307440e.equals("launch")) {
                    return q0();
                }
                if (this.f307439d.equals("im") && this.f307440e.equals("aioorprofile")) {
                    return R0();
                }
                if (this.f307439d.equals("qapp")) {
                    return F1();
                }
                if (this.f307439d.equals("lbs") && this.f307440e.equals("show_location")) {
                    return v2();
                }
                if (this.f307439d.equals("lbs") && this.f307440e.equals("select_location")) {
                    return i2();
                }
                if (IndividuationUrlHelper.UrlId.CARD_HOME.equals(this.f307439d) && "show_pslcard".equals(this.f307440e)) {
                    return q2();
                }
                if (this.f307439d.equals("personal_tag") && this.f307440e.equals("tag_list")) {
                    return z2();
                }
                if (this.f307439d.equals(JobDbManager.TBL_UPLOAD) && this.f307440e.equals("photo")) {
                    return D1();
                }
                if (this.f307439d.equals("forward") && this.f307440e.equals("url")) {
                    return b1();
                }
                if (this.f307439d.equals("forward") && this.f307440e.equals("invite_register")) {
                    return true;
                }
                if (this.f307439d.equals("gamesdk") && this.f307440e.equals("bind_group")) {
                    return O0();
                }
                if (this.f307439d.equals("share") && this.f307440e.equals("to_fri")) {
                    return o2();
                }
                if (this.f307439d.equals("share") && this.f307440e.equals("to_qqdataline")) {
                    return p2(new f());
                }
                if (this.f307439d.equals("gamesdk") && this.f307440e.equals(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND)) {
                    if (!TextUtils.isEmpty(this.f307441f.get("is_from_game"))) {
                        ax.N = ax.E(this.f307441f.get("is_from_game"));
                    }
                    return n1();
                }
                if (this.f307439d.equals("share") && this.f307440e.equals("to_qqfav")) {
                    return p2(new k());
                }
                if (this.f307439d.equals("share") && this.f307440e.equals("to_qzone")) {
                    return U1("shareToQzone");
                }
                if (this.f307439d.equals("qzone")) {
                    return f3();
                }
                if (this.f307439d.equals("mqq")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "handleMQQService");
                    }
                    R2();
                    str7 = str8;
                } else {
                    if (this.f307439d.equals("groupopenapp") && this.f307440e.equals("openapp")) {
                        return K0();
                    }
                    if (this.f307439d.equals("lightapp") && this.f307440e.equals("open")) {
                        return I0();
                    }
                    if (this.f307439d.endsWith("app")) {
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpAction", 2, "handleAppForward");
                        }
                        return O2();
                    }
                    if (this.f307439d.equals("qm") && this.f307440e.equals("qr")) {
                        return d3();
                    }
                    if (this.f307439d.equals("dc") && this.f307440e.equals("ft")) {
                        return a1();
                    }
                    if (VipFunCallConstants.KEY_GROUP.equals(this.f307439d)) {
                        if (this.f307440e.equals(ProcessConstant.NEARBY)) {
                            return w2();
                        }
                        if (this.f307440e.equals(OperateCustomButton.OPERATE_CREATE)) {
                            return V0();
                        }
                        if (this.f307440e.equals("create_by_select_member")) {
                            return W0();
                        }
                        if (this.f307440e.equals("report")) {
                            return a2();
                        }
                        if (this.f307440e.equals("find_group")) {
                            return Y1();
                        }
                        str7 = str8;
                        if (this.f307440e.equals("invite_join")) {
                            return H2();
                        }
                    } else {
                        if (this.f307439d.equals("shop")) {
                            return g3();
                        }
                        if ("profile".equals(this.f307439d) && QCircleDaTongConstant.ElementParamValue.AVATAR_EDIT.equals(this.f307440e)) {
                            return l2();
                        }
                        if ("profile".equals(this.f307439d) && "sdk_avatar_edit".equals(this.f307440e)) {
                            return c2();
                        }
                        if ("profile".equals(this.f307439d) && "sdk_dynamic_avatar_edit".equals(this.f307440e)) {
                            return d2();
                        }
                        if ("profile".equals(this.f307439d) && "sdk_face_collection".equals(this.f307440e)) {
                            return e2();
                        }
                        if ("profile".equals(this.f307439d) && "more_info_edit".equals(this.f307440e)) {
                            ?? r75 = FriendProfileMoreInfoActivity.class;
                            this.f307437b.startActivity(new Intent(this.f307437b, (Class<?>) r75));
                            str7 = r75;
                        } else if ("userprofile".equals(this.f307439d) && "friend_profile_card".equals(this.f307440e)) {
                            i3();
                            str7 = str8;
                        } else {
                            if ("contact".equals(this.f307439d) && "might_know".equals(this.f307440e)) {
                                return o1();
                            }
                            if ("contact".equals(this.f307439d) && "search_might_know".equals(this.f307440e)) {
                                return h2();
                            }
                            if ("contact".equals(this.f307439d) && "new_friends".equals(this.f307440e)) {
                                return x2();
                            }
                            if ("contact".equals(this.f307439d) && "contacts_tab".equals(this.f307440e)) {
                                return r2();
                            }
                            if ("contact".equals(this.f307439d) && "phone_recommend".equals(this.f307440e)) {
                                return C1();
                            }
                            if (this.f307439d.equals("healthcenter") && this.f307440e.equals("open")) {
                                return Y2();
                            }
                            if (this.f307439d.equals("ptlogin") && this.f307440e.equals("qlogin")) {
                                return M2();
                            }
                            if (!this.f307439d.equals("gav") || !this.f307440e.equals(Const.BUNDLE_KEY_REQUEST)) {
                                str3 = "";
                                try {
                                    if ("videochat".equals(this.f307439d)) {
                                        try {
                                            if (Const.BUNDLE_KEY_REQUEST.equals(this.f307440e)) {
                                                return K2();
                                            }
                                        } catch (Exception e16) {
                                            exc = e16;
                                            str2 = str3;
                                            QLog.e("JumpAction", 1, "doAction error:" + exc.getMessage());
                                            HashMap<String, String> hashMap = new HashMap<>(1);
                                            if (this.f307438c == null) {
                                            }
                                            if (this.f307439d == null) {
                                            }
                                            if (this.f307440e == null) {
                                            }
                                            hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_DOACTION_ERROR_INFO, "JumpActionsource:" + this.f307438c + "server_name:" + this.f307439d + "action_name:" + this.f307440e);
                                            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap, "", false);
                                            return false;
                                        }
                                    }
                                    if ("randomavchat".equals(this.f307439d) && Const.BUNDLE_KEY_REQUEST.equals(this.f307440e)) {
                                        return X1();
                                    }
                                    if (this.f307439d.equals("tribe")) {
                                        return h3();
                                    }
                                    if (this.f307439d.equals("qqdataline") && this.f307440e.equals("openqqdataline")) {
                                        return X0();
                                    }
                                    if (this.f307439d.equals(QCircleDaTongConstant.ElementParamValue.WALLET) && this.f307440e.equals("modify_pass")) {
                                        return O1();
                                    }
                                    if (this.f307439d.equals("dating")) {
                                        if (this.f307440e.equals("detail")) {
                                            return Y0();
                                        }
                                        if (this.f307440e.equals("publish")) {
                                            return E1();
                                        }
                                        str = str8;
                                        if (this.f307440e.equals("feed")) {
                                            return Z0();
                                        }
                                    } else if (this.f307439d.equals("nearby_entry")) {
                                        if (this.f307440e.equals("nearby_profile")) {
                                            return t1();
                                        }
                                        if (this.f307440e.equals("hotchat_list")) {
                                            return g1();
                                        }
                                        if (this.f307440e.equals("hotchat_room")) {
                                            return h1();
                                        }
                                        str = str8;
                                        if (this.f307440e.equals("visitor_list")) {
                                            return s1();
                                        }
                                    } else if (this.f307439d.equals(ProcessConstant.NEARBY)) {
                                        str = str8;
                                        if (this.f307440e.equals("reportFriend")) {
                                            return b2();
                                        }
                                    } else if (this.f307439d.equals("hotchat")) {
                                        str = str8;
                                        if (this.f307440e.equals("newyear_scene")) {
                                            return i1();
                                        }
                                    } else {
                                        if (this.f307439d.equals("freshnews_entry")) {
                                            return false;
                                        }
                                        if (this.f307439d.equals("qlink") && this.f307440e.equals("openqlink")) {
                                            return L1();
                                        }
                                        if (this.f307439d.equals("share") && this.f307440e.equals("to_troopbar")) {
                                            return p2(new m());
                                        }
                                        if (TenpayJumpActivity.TENPAY_SCHEME.equals(this.f307439d) && "sendHongBao".equals(this.f307440e)) {
                                            return k2();
                                        }
                                        if ("massbless".endsWith(this.f307439d) && "mainpage".equals(this.f307440e)) {
                                            return j2();
                                        }
                                        if (this.f307439d.equals("interesttag")) {
                                            return S0();
                                        }
                                        if (this.f307439d.equals("qqcomic")) {
                                            return H1();
                                        }
                                        if ("leba_plugin".equals(this.f307439d) && "set".equals(this.f307440e)) {
                                            return m1();
                                        }
                                        if (this.f307439d.equals("pa_relationship")) {
                                            return A0();
                                        }
                                        if (this.f307439d.equals("od")) {
                                            return v1();
                                        }
                                        if (this.f307439d.equals("odAddFriend")) {
                                            return w1();
                                        }
                                        if ("huayang".equals(this.f307439d)) {
                                            return j1();
                                        }
                                        if ("favorites".equals(this.f307439d)) {
                                            str = str8;
                                            if ("forward_favorites".equals(this.f307440e)) {
                                                Intent intent2 = new Intent();
                                                intent2.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, BaseApplicationImpl.getApplication().getApplicationContext().getString(R.string.button_back));
                                                return QfavHelper.i((Activity) this.f307437b, this.Q.getAccount(), intent2, -1, false);
                                            }
                                        } else if ("hongbao_share".equals(this.f307439d)) {
                                            str = str8;
                                            if ("hongbao_brush".equals(this.f307440e)) {
                                                return U0();
                                            }
                                        } else if ("general_ar".equals(this.f307439d)) {
                                            str = str8;
                                            if ("gotoScannerTorchActivity".equals(this.f307440e)) {
                                                return f2();
                                            }
                                        } else {
                                            if ("mqqavshare://".equals(this.f307439d)) {
                                                this.I = true;
                                                return ((IShareChatApi) QRoute.api(IShareChatApi.class)).jump(this);
                                            }
                                            if (TabDataHelper.SCENE_ASSISTANT_SETTING.equals(this.f307439d)) {
                                                str = str8;
                                                if ("ASSISTANT_SETTING".equals(this.f307440e)) {
                                                    return N0();
                                                }
                                            } else {
                                                if (!this.f307439d.equals("conf") && !this.f307439d.equals("confpstn") && !this.f307439d.equals("confhr")) {
                                                    if ("teamwork".equals(this.f307439d)) {
                                                        str = str8;
                                                        if ("opendoclist".equals(this.f307440e)) {
                                                            return F2();
                                                        }
                                                    } else {
                                                        if ("qstory".equals(this.f307439d)) {
                                                            if ("openNow".equals(this.f307440e)) {
                                                                return u1();
                                                            }
                                                            return s0();
                                                        }
                                                        if (!"now".equals(this.f307439d)) {
                                                            str = str8;
                                                        }
                                                        if ("openroom".equals(this.f307440e)) {
                                                            return u1();
                                                        }
                                                        str = str8;
                                                        if ("playmedia".equals(this.f307440e)) {
                                                            return E2();
                                                        }
                                                    }
                                                }
                                                str = str8;
                                                if (this.f307440e.equals("ft")) {
                                                    return T0();
                                                }
                                            }
                                        }
                                    }
                                    if (!this.f307439d.equals("schedule") && this.f307440e.equals(MiniChatConstants.MINI_APP_SHOW_DETAIL)) {
                                        return g2();
                                    }
                                    if (!this.f307439d.equals("contact") && this.f307440e.equals("add")) {
                                        return L0();
                                    }
                                    if (!this.f307439d.equals("profile") && this.f307440e.equals("setting")) {
                                        return k1();
                                    }
                                    if (!this.f307439d.equals("qqreg")) {
                                        return Z1();
                                    }
                                    if (this.f307439d.equals("troop_member_card") && this.f307440e.equals("open_member_recent_chat_view")) {
                                        return A1();
                                    }
                                    if (this.f307439d.equals("qwerewolf")) {
                                        if (this.f307440e.equals("openInvitationRoom")) {
                                            return d1();
                                        }
                                        if (this.f307440e.equals("enterGameRoom")) {
                                            return c1();
                                        }
                                    } else if (this.f307439d.equals(ProcessConstant.GROUPVIDEO)) {
                                        if (this.f307440e.equals("openroom")) {
                                            return H0();
                                        }
                                        if (this.f307440e.equals("preload")) {
                                            return J0();
                                        }
                                    } else {
                                        if (this.f307439d.equals("studyroom")) {
                                            return false;
                                        }
                                        if (this.f307439d.equals("invite_join_group")) {
                                            if (this.f307440e.equals("open")) {
                                                return l1();
                                            }
                                        } else {
                                            if ("troop_homework".equals(this.f307439d) && "publish".equals(this.f307440e)) {
                                                return f1(f("gc"));
                                            }
                                            if (this.f307439d.equals("nearby_videochat") && this.f307440e.equals("open_plugin")) {
                                                if (this.f307437b instanceof Activity) {
                                                    NearbyVideoChatProxyActivity.G2(this.Q, (Activity) this.f307437b, null, ((com.tencent.mobileqq.troop.utils.i) this.Q.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)).a(), null, 123987);
                                                    return true;
                                                }
                                                QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
                                                return false;
                                            }
                                            if ("page_router".equals(this.f307439d)) {
                                                q1();
                                                return true;
                                            }
                                            if ("msg_list".equals(this.f307439d)) {
                                                q1();
                                                return true;
                                            }
                                            if ("watchtogether".equals(this.f307439d)) {
                                                if (this.f307440e.equals("openroom")) {
                                                    return C3();
                                                }
                                            } else {
                                                if ("share_group".equals(this.f307439d)) {
                                                    if (this.f307440e.equals("open") && (str6 = this.f307441f.get("groupcode")) != null) {
                                                        TroopUtils.O(this.Q, this.f307437b, str6);
                                                        return true;
                                                    }
                                                    return true;
                                                }
                                                if ("edit_group".equals(this.f307439d)) {
                                                    if (this.f307440e.equals("open") && (str5 = this.f307441f.get("groupcode")) != null) {
                                                        TroopUtils.K(this.Q, this.f307437b, str5);
                                                        return true;
                                                    }
                                                    return true;
                                                }
                                                if ("weishiforqassistant".equals(this.f307439d)) {
                                                    ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(this.f307437b, "from_audio_assistant", true);
                                                    return true;
                                                }
                                                if ("qechatforqassistant".equals(this.f307439d)) {
                                                    ((IExpandEntrance) QRoute.api(IExpandEntrance.class)).enterExpand(this.f307437b, this.Q, 7);
                                                    return true;
                                                }
                                                if ("searchforqassistant".equals(this.f307439d)) {
                                                    UniteSearchActivity.I2(this.f307437b, f("searchkey"), 10004);
                                                    return true;
                                                }
                                                if ("settingsforqassistant".equals(this.f307439d)) {
                                                    ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(this.f307437b, null);
                                                    return true;
                                                }
                                                if ("confiessmsgforqassistant".equals(this.f307439d)) {
                                                    ConfessConfig g16 = ((ConfessManager) this.Q.getManager(QQManagerFactory.CONFESS_MANAGER)).g();
                                                    String str9 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
                                                    if (g16 != null && !TextUtils.isEmpty(g16.f202067k)) {
                                                        str9 = g16.f202067k;
                                                    }
                                                    Intent intent3 = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
                                                    intent3.putExtra("uin", this.Q.getCurrentAccountUin());
                                                    intent3.putExtra("url", str9);
                                                    this.f307437b.startActivity(intent3);
                                                    return true;
                                                }
                                                if ("qzoneforqassistant".equals(this.f307439d)) {
                                                    return o();
                                                }
                                                if ("weqzoneforqassistant".equals(this.f307439d)) {
                                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                                    hashMap2.put(UploadConstants.KEY_ENABLE_SPLASH, "0");
                                                    com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(this.f307437b, QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE, hashMap2);
                                                    return true;
                                                }
                                                if ("scanforqassistant".equals(this.f307439d)) {
                                                    Context context = this.f307437b;
                                                    if (context instanceof QBaseActivity) {
                                                        com.tencent.mobileqq.activity.recent.l.o((QBaseActivity) context, 0L, 0L, 0);
                                                        return true;
                                                    }
                                                    return true;
                                                }
                                                if ("bind_number".equals(this.f307439d)) {
                                                    if ("bind".equals(this.f307440e)) {
                                                        P0();
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                if ("commonBuddyGroup".equals(this.f307439d)) {
                                                    if ("open".equals(this.f307440e)) {
                                                        P3();
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                try {
                                                    if ("hippy".equals(this.f307439d)) {
                                                        if ("open".equals(this.f307440e)) {
                                                            if (HippyQQConstants.ModuleName.QQ_NEWS_PUBLICACCOUNT.equals(f("bundleName"))) {
                                                                return ((IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class)).startHippy(this.f307437b, this.f307441f);
                                                            }
                                                            if (HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT.equals(f("bundleName"))) {
                                                                return ((IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class)).startMiniGamePA(this.f307437b, this.f307441f);
                                                            }
                                                            if (HippyQQConstants.ModuleName.QQ_ERMAO_MALL.equals(f("bundleName")) && (this.f307450o || this.f307451p)) {
                                                                String str10 = this.f307441f.get("url");
                                                                String str11 = this.f307441f.get("ssrBundleUrl");
                                                                BusinessInfoCheckUpdate.AppInfo appInfo = this.A;
                                                                if (appInfo != null && (pBRepeatField = appInfo.missions) != null && pBRepeatField.get() != null) {
                                                                    String str12 = this.A.missions.get().get(0);
                                                                    StringBuilder sb5 = new StringBuilder();
                                                                    sb5.append(str3);
                                                                    sb5.append("mission=");
                                                                    sb5.append(str12);
                                                                    str4 = sb5.toString();
                                                                } else {
                                                                    str4 = str3;
                                                                }
                                                                if (!TextUtils.isEmpty(str4)) {
                                                                    String b16 = HtmlOffline.b(str10, str4);
                                                                    String b17 = HtmlOffline.b(str11, str4);
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d("JumpAction", 2, "url:" + b16 + "==> ssr:" + b17);
                                                                    }
                                                                    this.f307441f.put("url", b16);
                                                                    this.f307441f.put("ssrBundleUrl", b17);
                                                                }
                                                            }
                                                            if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).handleGameActScheme(this.f307441f, this.f307437b)) {
                                                                QLog.i("JumpAction", 1, "for act scheme.NOT open hippy.");
                                                                return false;
                                                            }
                                                            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).reportIfNeed(this.f307438c);
                                                            ((IGameShareLinkReporter) QRoute.api(IGameShareLinkReporter.class)).reportGameShareLink(this.f307438c);
                                                            return new OpenHippyInfo(this.f307441f).openHippy(this.f307437b);
                                                        }
                                                        if ("remoteDebug".equals(this.f307440e)) {
                                                            return new OpenHippyInfo(this.f307441f).openHippy(this.f307437b);
                                                        }
                                                        return false;
                                                    }
                                                    if (this.f307439d.equals("ecommerce")) {
                                                        T3();
                                                        return ((IECommerceJumpAction) QRoute.api(IECommerceJumpAction.class)).handleScheme(this.f307440e, this.f307441f, this.f307443h, this.f307438c);
                                                    }
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    exc = e;
                                                    str2 = str;
                                                    QLog.e("JumpAction", 1, "doAction error:" + exc.getMessage());
                                                    HashMap<String, String> hashMap3 = new HashMap<>(1);
                                                    if (this.f307438c == null) {
                                                    }
                                                    if (this.f307439d == null) {
                                                    }
                                                    if (this.f307440e == null) {
                                                    }
                                                    hashMap3.put(JumpParseConstants.KEY_JUMP_PARSER_DOACTION_ERROR_INFO, "JumpActionsource:" + this.f307438c + "server_name:" + this.f307439d + "action_name:" + this.f307440e);
                                                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap3, "", false);
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                    return false;
                                } catch (Exception e18) {
                                    e = e18;
                                    str = str3;
                                    exc = e;
                                    str2 = str;
                                    QLog.e("JumpAction", 1, "doAction error:" + exc.getMessage());
                                    HashMap<String, String> hashMap32 = new HashMap<>(1);
                                    if (this.f307438c == null) {
                                        this.f307438c = str2;
                                    }
                                    if (this.f307439d == null) {
                                        this.f307439d = str2;
                                    }
                                    if (this.f307440e == null) {
                                        this.f307440e = str2;
                                    }
                                    hashMap32.put(JumpParseConstants.KEY_JUMP_PARSER_DOACTION_ERROR_INFO, "JumpActionsource:" + this.f307438c + "server_name:" + this.f307439d + "action_name:" + this.f307440e);
                                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap32, "", false);
                                    return false;
                                }
                            }
                            return r1();
                        }
                    }
                }
                str3 = "";
                str = str7;
                if (!this.f307439d.equals("schedule")) {
                }
                if (!this.f307439d.equals("contact")) {
                }
                if (!this.f307439d.equals("profile")) {
                }
                if (!this.f307439d.equals("qqreg")) {
                }
            } catch (Exception e19) {
                exc = e19;
                str2 = "";
            }
        } catch (Exception e26) {
            e = e26;
            str = "";
        }
    }

    public void d4(int i3) {
        try {
            if (this.S == null) {
                Context context = this.f307437b;
                this.S = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
            this.S.setMessage(i3);
            if (!((JumpActivity) this.f307437b).isFinishing() && !this.S.isShowing()) {
                this.S.show();
            }
        } catch (Exception unused) {
        }
    }

    protected boolean f1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f307437b instanceof Activity) {
            ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).startPublishHomeWorkFragment((Activity) this.f307437b, null, str);
            ((Activity) this.f307437b).overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
            return true;
        }
        return true;
    }

    public boolean j2() {
        if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, "gotoSendBless");
        }
        BlessManager blessManager = (BlessManager) this.Q.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        blessManager.k0(new j(blessManager));
        return true;
    }

    public boolean k1() {
        Intent intent = new Intent(this.f307437b, (Class<?>) InterestSwitchEditActivity.class);
        intent.setFlags(67108864);
        this.f307437b.startActivity(intent);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean l() {
        if (this.f307439d.equals(IndividuationUrlHelper.UrlId.CARD_HOME) && this.f307440e.equals("show_pslcard") && SearchConfig.ENGINE_PUBLIC_ACCOUNT.equals(this.f307441f.get("card_type")) && "app".equals(this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE)) && !TextUtils.isEmpty(this.f307441f.get(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH))) {
            return true;
        }
        return false;
    }

    protected boolean l1() {
        final boolean z16;
        final String str = this.f307441f.get("groupcode");
        TroopInfo k3 = ((TroopManager) this.Q.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null) {
            String currentAccountUin = this.Q.getCurrentAccountUin();
            if (!k3.isTroopOwner(currentAccountUin) && !k3.isTroopAdmin(currentAccountUin)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!k3.mMemberInvitingFlag && !z16) {
                QLog.e("JumpAction", 1, "cannot invite join group");
            } else {
                ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, false, "JumpAction-gotoInviteJoinGroup", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.utils.bd
                    @Override // com.tencent.qqnt.troopmemberlist.f
                    public final void a(boolean z17, List list) {
                        JumpActionLegacy.this.F3(str, z16, z17, list);
                    }
                });
            }
        } else {
            QLog.e("JumpAction", 1, "troopInfo not found");
        }
        return true;
    }

    public boolean m1() {
        long j3;
        String str = this.f307441f.get("id");
        if (str == null) {
            return false;
        }
        try {
            j3 = Long.parseLong(str);
        } catch (Exception unused) {
            j3 = -1;
        }
        if (j3 == -1) {
            return false;
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) LebaSearchPluginManagerActivity.class);
        intent.putExtra("id", j3);
        this.f307437b.startActivity(intent);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean o() {
        String str;
        if (this.Q == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_SCHEME_ACTIVE_FEED);
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.FRIEND_FEED);
        intent.addFlags(805306368);
        String str2 = this.f307438c;
        if (str2 != null) {
            str = Uri.parse(str2).getQueryParameter("push_trans_channel");
        } else {
            str = null;
        }
        QZoneHelper.forwardToFriendFeed((Activity) this.f307437b, this.Q.getCurrentAccountUin(), intent, str, -1);
        LpReportInfo_dc02880.report(this.f307438c);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean p() {
        if (this.Q == null) {
            return false;
        }
        String S3 = S3(S3(S3(S3(S3(S3(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_WIDGET, "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.Q.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", QUA.getQUA3()), "{uin}", this.Q.getCurrentAccountUin()), "{UIN}", this.Q.getCurrentAccountUin());
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", S3);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.putExtra("articalChannelId", 5);
        if (com.tencent.mobileqq.webview.swift.ag.f314191a.containsKey("Qzone")) {
            intent.putExtra("insertPluginsArray", new String[]{"Qzone"});
        }
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
        intent.setData(Uri.parse(S3));
        intent.addFlags(268435456);
        intent.putExtra("needSkey", "true");
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("uin", this.Q.getCurrentAccountUin());
        this.f307437b.startActivity(intent);
        return true;
    }

    public boolean p1() {
        String str;
        Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
        if (this.f307441f.containsKey("url")) {
            this.f307441f.remove("url");
        }
        for (Map.Entry<String, String> entry : this.f307441f.entrySet()) {
            intent.putExtra(entry.getKey(), Uri.decode(entry.getValue()));
        }
        if (this.f307441f.containsKey("weburl")) {
            str = Uri.decode(this.f307441f.get("weburl"));
        } else {
            str = "";
        }
        if (!str.startsWith("https://sou.qq.com/") && !str.startsWith("https://sou.html5.qq.com/")) {
            return false;
        }
        intent.putExtra("url", str);
        intent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
        this.f307437b.startActivity(intent);
        if ((this.f307437b instanceof Activity) && !"1".equals(this.f307441f.get("openanimtype"))) {
            ((Activity) this.f307437b).overridePendingTransition(0, 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean q() {
        new BaseThread() { // from class: com.tencent.mobileqq.utils.JumpActionLegacy.31
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                String str = JumpActionLegacy.this.f307441f.get("version");
                JumpActionLegacy jumpActionLegacy = JumpActionLegacy.this;
                String D2 = ReportHandler.D2(jumpActionLegacy.f307439d, jumpActionLegacy.f307440e, str, "");
                EntityManager createEntityManager = JumpActionLegacy.this.Q.getEntityManagerFactory().createEntityManager();
                List<? extends Entity> query = createEntityManager.query(PushBannerReportLog.class);
                if (query != null && query.size() >= 9) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(D2, 1);
                    Iterator<? extends Entity> it = query.iterator();
                    while (it.hasNext()) {
                        PushBannerReportLog pushBannerReportLog = (PushBannerReportLog) it.next();
                        if (hashMap.containsKey(pushBannerReportLog.getLog())) {
                            hashMap.put(pushBannerReportLog.getLog(), Integer.valueOf(((Integer) hashMap.get(pushBannerReportLog.getLog())).intValue() + 1));
                        } else {
                            hashMap.put(pushBannerReportLog.getLog(), 1);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        arrayList.add(((String) entry.getKey()) + "|" + ((Integer) entry.getValue()));
                    }
                    ((ReportHandler) JumpActionLegacy.this.Q.getBusinessHandler(BusinessHandlerFactory.REPORT_HANDLER)).F2((String[]) arrayList.toArray(new String[arrayList.size()]));
                    createEntityManager.drop(PushBannerReportLog.class);
                    hashMap.clear();
                } else {
                    PushBannerReportLog pushBannerReportLog2 = new PushBannerReportLog();
                    pushBannerReportLog2.setLog(D2);
                    createEntityManager.persist(pushBannerReportLog2);
                }
                createEntityManager.close();
            }
        }.start();
        return b();
    }

    public boolean s1() {
        Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
        this.f307437b.startActivity(intent);
        return true;
    }

    public void s3() {
        QQProgressDialog qQProgressDialog = this.S;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.S.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public void t(BusinessInfoCheckUpdate.AppInfo appInfo) {
        this.A = appInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u1() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        long parseLong;
        String str21;
        boolean z16;
        String str22;
        Intent intent;
        Context context = this.f307437b;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            str = intent.getStringExtra("big_brother_source_key");
            str2 = intent.getDataString();
        } else {
            str = null;
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f307438c;
        }
        String str23 = str2;
        String str24 = "0";
        if (!this.f307441f.containsKey("roomid")) {
            str3 = "0";
        } else {
            str3 = this.f307441f.get("roomid");
        }
        if (!this.f307441f.containsKey("fromid")) {
            str4 = "";
        } else {
            str4 = this.f307441f.get("fromid");
        }
        if (!this.f307441f.containsKey("roomtype")) {
            str5 = "";
        } else {
            str5 = this.f307441f.get("roomtype");
        }
        if (!this.f307441f.containsKey("list_name")) {
            str6 = "";
        } else {
            str6 = this.f307441f.get("list_name");
        }
        if (this.f307441f.containsKey("first_jump_mode")) {
            str7 = this.f307441f.get("first_jump_mode");
        } else {
            str7 = "h5";
        }
        String str25 = str7;
        if (this.f307441f.containsKey("need_record")) {
            str8 = this.f307441f.get("need_record");
        } else {
            str8 = "1";
        }
        String str26 = str8;
        if (this.f307441f.containsKey("is_record")) {
            str9 = "0";
            str24 = this.f307441f.get("is_record");
        } else {
            str9 = "0";
        }
        if (this.f307441f.containsKey("enter_record_if_finish")) {
            str10 = this.f307441f.get("enter_record_if_finish");
        } else {
            str10 = "1";
        }
        String str27 = str;
        String str28 = str10;
        if (this.f307441f.containsKey("nowapp_ext")) {
            str11 = str6;
            str12 = this.f307441f.get("nowapp_ext");
        } else {
            str11 = str6;
            str12 = "";
        }
        if (this.f307441f.containsKey("nowplugin_ext")) {
            str13 = str4;
            str14 = this.f307441f.get("nowplugin_ext");
        } else {
            str13 = str4;
            str14 = "";
        }
        if (!this.f307441f.containsKey("h5_ext")) {
            str15 = "";
        } else {
            str15 = this.f307441f.get("h5_ext");
        }
        if (!this.f307441f.containsKey("shakespearetime")) {
            str16 = "";
        } else {
            str16 = this.f307441f.get("shakespearetime");
        }
        if (!this.f307441f.containsKey("msgurl")) {
            str17 = "";
        } else {
            str17 = ax.E(this.f307441f.get("msgurl"));
        }
        String str29 = str17;
        if (this.f307441f.containsKey("hostloading_percent")) {
            str18 = this.f307441f.get("hostloading_percent");
        } else {
            str18 = str9;
        }
        String str30 = str14;
        if (!this.f307441f.containsKey("enter_ts")) {
            str19 = "enter_ts";
        } else {
            try {
                str20 = "JumpAction";
                str19 = "enter_ts";
                parseLong = Long.parseLong(this.f307441f.get("enter_ts"));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                StringBuilder sb5 = new StringBuilder();
                str19 = "enter_ts";
                sb5.append("goNowRoom------NumberFormatException, e = ");
                sb5.append(e16.getMessage());
                QLog.e("JumpAction", 1, sb5.toString());
            }
            String str31 = str20;
            String str32 = this.f307441f.get("coverurl");
            long j3 = parseLong;
            String str33 = this.f307441f.get("extras");
            this.f307441f.get("bid");
            this.f307441f.get(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
            Bundle bundle = new Bundle();
            bundle.putString("coverurl", str32);
            bundle.putString("roomid", str3);
            bundle.putString("roomtype", str5);
            bundle.putString("extras_from_js", str33);
            bundle.putBoolean("can_use_h5_first", true);
            bundle.putString("first_jump_mode", str25);
            bundle.putString("is_record", str24);
            bundle.putString("enter_record_if_finish", str28);
            bundle.putString("nowapp_ext", str12);
            bundle.putString("nowplugin_ext", str30);
            bundle.putString("h5_ext", str15);
            bundle.putString("shakespearetime", str16);
            bundle.putString("fromid", str13);
            bundle.putString("url", str29);
            bundle.putString("listname", str11);
            bundle.putString("mqqScheme", str23);
            bundle.putLong(str19, j3);
            if (!TextUtils.isEmpty(str27)) {
                bundle.putString("big_brother_source_key", str27);
            }
            if (!TextUtils.isEmpty(str26) || !str9.equals(str26)) {
                str21 = "need_record";
                z16 = true;
            } else {
                z16 = false;
                str21 = "need_record";
            }
            bundle.putBoolean(str21, z16);
            if (this.f307441f.containsKey("topic")) {
                bundle.putString("topic", this.f307441f.get("topic"));
            }
            if (this.f307441f.containsKey("story_ext")) {
                bundle.putString("story_ext", this.f307441f.get("story_ext"));
            }
            if (this.f307441f.containsKey("startsrc")) {
                bundle.putString("startsrc", this.f307441f.get("startsrc"));
            }
            if (this.f307441f.containsKey("hostloading_percent")) {
                bundle.putInt("hostloading_percent", Integer.valueOf(str18).intValue());
            }
            if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, "\u65e0\u7f51\u7edc\u8fde\u63a5\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
                return false;
            }
            try {
                ((com.tencent.mobileqq.intervideo.now.dynamic.b) this.Q.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c(bundle);
                str22 = str31;
                try {
                    QLog.i(str22, 1, "enter now plugin use shadow");
                    return true;
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.e(str22, 2, e.toString());
                    }
                    return false;
                }
            } catch (Exception e18) {
                e = e18;
                str22 = str31;
            }
        }
        str20 = "JumpAction";
        parseLong = 0;
        String str312 = str20;
        String str322 = this.f307441f.get("coverurl");
        long j36 = parseLong;
        String str332 = this.f307441f.get("extras");
        this.f307441f.get("bid");
        this.f307441f.get(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
        Bundle bundle2 = new Bundle();
        bundle2.putString("coverurl", str322);
        bundle2.putString("roomid", str3);
        bundle2.putString("roomtype", str5);
        bundle2.putString("extras_from_js", str332);
        bundle2.putBoolean("can_use_h5_first", true);
        bundle2.putString("first_jump_mode", str25);
        bundle2.putString("is_record", str24);
        bundle2.putString("enter_record_if_finish", str28);
        bundle2.putString("nowapp_ext", str12);
        bundle2.putString("nowplugin_ext", str30);
        bundle2.putString("h5_ext", str15);
        bundle2.putString("shakespearetime", str16);
        bundle2.putString("fromid", str13);
        bundle2.putString("url", str29);
        bundle2.putString("listname", str11);
        bundle2.putString("mqqScheme", str23);
        bundle2.putLong(str19, j36);
        if (!TextUtils.isEmpty(str27)) {
        }
        if (!TextUtils.isEmpty(str26)) {
        }
        str21 = "need_record";
        z16 = true;
        bundle2.putBoolean(str21, z16);
        if (this.f307441f.containsKey("topic")) {
        }
        if (this.f307441f.containsKey("story_ext")) {
        }
        if (this.f307441f.containsKey("startsrc")) {
        }
        if (this.f307441f.containsKey("hostloading_percent")) {
        }
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(14:27|28|29|4|(2:22|23)|6|7|8|9|10|11|12|13|14)|3|4|(0)|6|7|8|9|10|11|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
    
        r0.printStackTrace();
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        r0.printStackTrace();
        r2 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean v1() {
        String decode;
        String str = this.f307441f.get("roomid");
        String str2 = this.f307441f.get("fromid");
        String str3 = "";
        if (!TextUtils.isEmpty(this.f307441f.get("vasname"))) {
            try {
                decode = URLDecoder.decode(this.f307441f.get("vasname"), "utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.f307441f.get("userdata"))) {
                try {
                    str3 = URLDecoder.decode(this.f307441f.get("vasname"), "utf-8");
                } catch (UnsupportedEncodingException e17) {
                    e17.printStackTrace();
                }
            }
            String str4 = str3;
            long j3 = Long.parseLong(str);
            long j16 = j3;
            int i3 = Integer.parseInt(str2);
            ((com.tencent.mobileqq.intervideo.od.d) this.Q.getManager(QQManagerFactory.ODPROXY_MGR)).b(this.f307437b, j16, "launcher", decode, str4, i3);
            return true;
        }
        decode = "";
        if (!TextUtils.isEmpty(this.f307441f.get("userdata"))) {
        }
        String str42 = str3;
        long j36 = Long.parseLong(str);
        long j162 = j36;
        int i36 = Integer.parseInt(str2);
        ((com.tencent.mobileqq.intervideo.od.d) this.Q.getManager(QQManagerFactory.ODPROXY_MGR)).b(this.f307437b, j162, "launcher", decode, str42, i36);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public QQAppInterface e() {
        return this.Q;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class i implements ChatActivityUtils.u {
        i() {
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            ((QBaseActivity) JumpActionLegacy.this.f307437b).finish();
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            ((QBaseActivity) JumpActionLegacy.this.f307437b).finish();
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
        }
    }
}

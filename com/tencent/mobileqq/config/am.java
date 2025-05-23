package com.tencent.mobileqq.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoDeclare;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.unitedconfig_android.api.IManageMigrate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.cr;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes10.dex */
public class am {

    /* renamed from: f, reason: collision with root package name */
    private static final Object[] f202292f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoDeclare(configPath = "AutoInjectYml/Foundation/QQManage/Inject_config_processor_map.yml", version = 2)
    public static HashMap<String, String> f202293g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQManage/Inject_config_old_servlet.yml", version = 1)
    public static k f202294h;

    /* renamed from: i, reason: collision with root package name */
    private static ArrayList f202295i;

    /* renamed from: a, reason: collision with root package name */
    private final String f202296a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, l> f202297b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, a> f202298c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Object f202299d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final Object f202300e = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f202301a;

        /* renamed from: b, reason: collision with root package name */
        public final int f202302b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f202303c;

        a(long j3, int i3, Object obj) {
            this.f202301a = j3;
            this.f202302b = i3;
            this.f202303c = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final am f202304a = new am();
    }

    static {
        ArrayList arrayList = new ArrayList();
        f202295i = arrayList;
        arrayList.add(za1.a.class);
        f202292f = new Object[128];
        int i3 = 0;
        while (true) {
            Object[] objArr = f202292f;
            if (i3 < objArr.length) {
                objArr[i3] = new Object();
                i3++;
            } else {
                HashMap<String, String> hashMap = new HashMap<>();
                f202293g = hashMap;
                hashMap.put("891", "com.tencent.biz.pubaccount.conf.PublicAccountLongClickConfProcessor");
                f202293g.put("877", "com.tencent.mobileqq.app.message.config.FileMonitorConfigProcessor");
                f202293g.put("875", "com.tencent.mobileqq.mini.qbox.QBoxConfProcessor");
                f202293g.put("874", "com.tencent.mobileqq.search.config.SearchEntrySortConfigProcessor");
                f202293g.put("863", "com.tencent.mobileqq.search.config.TnnGroupSearchResultConfigProcessor");
                f202293g.put("859", "com.tencent.mobileqq.stt.sub.config.VideoSubtitleConfProcessor");
                f202293g.put("858", "com.tencent.mobileqq.config.business.AvifDownloadConfProcessor");
                f202293g.put("852", "com.tencent.mobileqq.splashad.config.NormalSplashConfigProcessor");
                f202293g.put("854", "com.tencent.mobileqq.config.business.vas.zplan.VasZplanConfigProcessor");
                f202293g.put("847", "com.tencent.mobileqq.search.tnn.config.SearchTnnConfigProcessor");
                f202293g.put("844", "com.tencent.mobileqq.troop.creditlevel.config.TroopCreditLevelEntryConfigProcessor");
                f202293g.put("843", "com.tencent.mobileqq.config.business.zplan.SettingJoinGroupConfProcessor");
                f202293g.put("841", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("838", "com.tencent.mobileqq.guild.config.GuildNTDBConfigProcessor");
                f202293g.put("829", "com.tencent.mobileqq.webview.nightmask.NightMaskConfProcessor");
                f202293g.put("826", "com.tencent.mobileqq.persistence.DBMonitorConfigProcessor");
                f202293g.put("827", "com.tencent.mobileqq.qlink.config.QlinkConfigProcessor");
                f202293g.put("823", "com.tencent.mobileqq.tianjige.config.QQOpenTelemetryConfigProcessor");
                f202293g.put("820", "com.tencent.mobileqq.processkiller.config.ProcessExitConfigProcessor");
                f202293g.put("816", "com.tencent.mobileqq.statistics.BeaconChannelProcessor");
                f202293g.put("815", "com.tencent.mobileqq.springhb.config.SpringHbUrlCheckConfProcessor");
                f202293g.put("813", "com.tencent.mobileqq.config.business.WVFrequencyConfProcessor");
                f202293g.put("811", "com.tencent.mobileqq.config.business.WVBlacklistConfProcessor");
                f202293g.put("809", "com.tencent.mobileqq.config.business.zootopia.ZootopiaConfigProcessor");
                f202293g.put("808", "com.tencent.mobileqq.app.SharedExtProcessor");
                f202293g.put("807", "com.tencent.mobileqq.zplan.maintenance.ZPlanMaintInfoProcessor");
                f202293g.put("801", "com.tencent.mobileqq.perf.thread.config.ThreadConfigProcessor");
                f202293g.put("791", "com.tencent.mobileqq.guild.message.registerproxy.manage.GuildRegisterProxyConfigProcessor");
                f202293g.put("776", "com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor");
                f202293g.put("774", "com.tencent.mobileqq.manager.QSafeDialogProcessor");
                f202293g.put("772", "com.tencent.mobileqq.guild.media.pic.config.GuildPicDownloadConfigProcessor");
                f202293g.put("770", "com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor");
                f202293g.put("769", "com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor");
                f202293g.put("759", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("757", "com.tencent.mobileqq.config.business.TicketAuthorizeConfProcessor");
                f202293g.put("749", "com.tencent.mobileqq.search.config.GroupSearchResultConfigProcessor");
                f202293g.put("745", "com.tencent.mobileqq.config.business.AlbumConfProcessor");
                f202293g.put("742", "com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor");
                f202293g.put("737", "com.tencent.gamecenter.wadl.config.FloatingPermissionConfProcessor");
                f202293g.put("736", "com.tencent.qqperf.monitor.file.ExternalDirOperationConfigProcessor");
                f202293g.put("735", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("734", "com.tencent.mobileqq.vas.config.business.QVipHippyProcessor");
                f202293g.put("733", "com.tencent.mobileqq.guild.config.QQGuildConfProcessor");
                f202293g.put("732", "com.tencent.mobileqq.manager.QSafeConfigProcessor");
                f202293g.put("730", "com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor");
                f202293g.put("727", "com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor");
                f202293g.put("726", "com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor");
                f202293g.put("724", "com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor");
                f202293g.put("722", "com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor");
                f202293g.put("720", "com.tencent.mobileqq.config.business.QQGameTeamConfProcessor");
                f202293g.put("712", "com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfigProcessor");
                f202293g.put("711", "com.tencent.mobileqq.config.business.DtVideoReportConfProcessor");
                f202293g.put("706", "com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor");
                f202293g.put("701", "com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfigProcessor");
                f202293g.put("695", "com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor");
                f202293g.put("692", "com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor");
                f202293g.put("690", "com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor");
                f202293g.put("689", "cooperation.ilive.config.IliveManagerConfProcessor");
                f202293g.put("687", "com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigProcessor");
                f202293g.put("686", "com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfigProcessor");
                f202293g.put("685", "com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor");
                f202293g.put("678", "com.tencent.mobileqq.config.DeepCleanConfigProcessor");
                f202293g.put("676", "com.tencent.mobileqq.config.business.QQKouBeiYunYingConfProcessor");
                f202293g.put("675", "com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor");
                f202293g.put("672", "com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor");
                f202293g.put("670", "com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarConfProcessor");
                f202293g.put("669", "com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfigProcessor");
                f202293g.put("668", "com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfigProcessor");
                f202293g.put("667", "com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor");
                f202293g.put("665", "com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor");
                f202293g.put("663", "com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigProcessor");
                f202293g.put(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, "com.tencent.mobileqq.qqgamepub.config.GameCenterEnterConfProcessor");
                f202293g.put(QZoneClickReport.ClickReportConfig.ACTION_TYPE_TEMPLATE_SHUOSHUO_FEED, "com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor");
                f202293g.put("651", "com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountProocessor");
                f202293g.put("649", "com.tencent.mobileqq.config.VasUpdateConfProcessor");
                f202293g.put("648", "com.tencent.mobileqq.vas.config.business.qvip.QVipWatchWordProcessor");
                f202293g.put("645", "com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigProcessor");
                f202293g.put("637", "com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigProcessor");
                f202293g.put("634", "com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfigProcessor");
                f202293g.put("633", "com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor");
                f202293g.put("632", "com.tencent.mobileqq.config.business.OpenSdkFakeMsgProcessor");
                f202293g.put("627", "com.tencent.mobileqq.config.business.BrowserOpenConfProcessor");
                f202293g.put("626", "com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigProcessor");
                f202293g.put("625", "com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigProcessor");
                f202293g.put("623", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("616", "com.tencent.mobileqq.config.business.PicPreDownloadConfProcessor");
                f202293g.put("614", "com.tencent.mobileqq.leba.config.LebaQzoneStyleProcessor");
                f202293g.put("613", "com.tencent.mobileqq.config.business.OpenSdkD55Processor");
                f202293g.put("609", "com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfigProcessor");
                f202293g.put("606", "com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigProcessor");
                f202293g.put("598", "com.tencent.mobileqq.leba.config.LebaRedTouchSwitchProcessor");
                f202293g.put("597", "com.tencent.mobileqq.config.business.AppletNotificationConfProcessor");
                f202293g.put("595", "com.tencent.biz.videostory.config.processor.VSStickyNoteProcessor");
                f202293g.put("592", "com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor");
                f202293g.put("591", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("590", "com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfigProcessor");
                f202293g.put("589", "com.tencent.mobileqq.config.business.search.UinSearchConfProcessor");
                f202293g.put("587", "com.tencent.mobileqq.config.business.PhotoListPanelConfProcessor");
                f202293g.put("586", "com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor");
                f202293g.put("581", "com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor");
                f202293g.put("580", "com.tencent.mobileqq.vas.config.business.qvip.QVipPerfLevelProcessor");
                f202293g.put("579", "com.tencent.mobileqq.comment.config.ImmersiveConfProcessor");
                f202293g.put("576", "com.tencent.mobileqq.comment.config.DanmuConfProcessor");
                f202293g.put("573", "com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfProcessor");
                f202293g.put("567", "com.tencent.mobileqq.config.business.BroadcastConfProcessor");
                f202293g.put("557", "com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CUploadConfigProcessor");
                f202293g.put("556", "com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigProcessor");
                f202293g.put("555", "com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigProcessor");
                f202293g.put("554", "com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupUploadConfigProcessor");
                f202293g.put("552", "com.tencent.mobileqq.config.business.LocaleConfProcessor");
                f202293g.put("547", "com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor");
                f202293g.put("546", "com.tencent.mobileqq.config.business.QuickAuthorityConfProcessor");
                f202293g.put("545", "com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor");
                f202293g.put("537", "com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor");
                f202293g.put("534", "com.tencent.comic.config.QQComicConfProcessor");
                f202293g.put("530", "com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor");
                f202293g.put("529", "com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor");
                f202293g.put("526", "com.tencent.mobileqq.soload.config.SoLoaderConfProcessor");
                f202293g.put("496", "com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor$C2CPanelConfigProcessor");
                f202293g.put("493", "com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor");
                f202293g.put("490", "com.tencent.mobileqq.config.business.RelationVipGrayProcessor");
                f202293g.put(IGameCenterRedPointConfigApi.GAME_CENTER_RES_ID, "com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor");
                f202293g.put("474", "com.tencent.biz.videostory.config.processor.VSEntranceWidgetProcessor");
                f202293g.put("473", "com.tencent.biz.videostory.config.processor.VSEntranceStyleProcessor");
                f202293g.put("467", "com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor");
                f202293g.put("463", "com.tencent.biz.videostory.config.processor.VSSubscribeProcessor");
                f202293g.put("462", "com.tencent.mobileqq.config.business.tendoc.VideoDrawConfProcessor");
                f202293g.put("460", "com.tencent.mobileqq.troop.robot.TroopRobotConfProcessor");
                f202293g.put("456", "com.tencent.mobileqq.config.business.search.VerticalSearchConfProcessor");
                f202293g.put("454", "com.tencent.mobileqq.loginwelcome.WelcomeConfigProcessor");
                f202293g.put("452", "com.tencent.mobileqq.config.business.C2CLovePushGrayProcessor");
                f202293g.put("449", "com.tencent.mobileqq.config.business.qfile.QFileIPv6ConfigProcessor");
                f202293g.put("438", "com.tencent.mobileqq.activity.contacts.mayknow.ReportExposeConfigProcessor");
                f202293g.put("436", "com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfProcessor");
                f202293g.put("435", "com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor");
                f202293g.put("434", "com.tencent.mobileqq.config.business.search.SearchBusinessConfProcessor");
                f202293g.put("433", "com.tencent.mobileqq.config.business.search.SearchHotWordConfProcessor");
                f202293g.put("432", "com.tencent.mobileqq.config.business.search.SearchRichConfProcessor");
                f202293g.put("431", "com.tencent.av.ManageConfig.AVTestforEncDecConfig");
                f202293g.put("426", "com.tencent.mobileqq.config.business.OpenSdkConfProcessor");
                f202293g.put("425", "com.tencent.mobileqq.config.business.MiniAppConfProcessor");
                f202293g.put("424", "com.tencent.qqperf.monitor.crash.safemode.SafeModeProcessor");
                f202293g.put("419", "com.tencent.mobileqq.config.business.QConfLogProcessor");
                f202293g.put("414", "com.tencent.mobileqq.config.business.GlobalSearchConfProcessor");
                f202293g.put("411", "com.tencent.biz.videostory.config.processor.VSEntranceProcessor");
                f202293g.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, "com.tencent.biz.videostory.config.processor.VSWaterMarkProcessor");
                f202293g.put("396", "com.tencent.mobileqq.config.business.qfile.QFileCommonConfigProcessor");
                f202293g.put("382", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("370", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("367", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("361", "com.tencent.mobileqq.config.business.WVStatisticsConfProcessor");
                f202293g.put("359", "com.tencent.mobileqq.vas.config.business.qvip.VasFontSwitchProcessor");
                f202293g.put("310", "com.tencent.aelight.camera.aioeditor.config.QIMDoodleConfigProcessor");
                f202293g.put("309", "com.tencent.aelight.camera.aioeditor.config.QIMDynamicTextConfigProcessor");
                f202293g.put("307", "com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor");
                f202293g.put("306", "com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor");
                f202293g.put("305", "com.tencent.aelight.camera.aioeditor.config.QIMMusicConfigProcessor");
                f202293g.put("304", "com.tencent.aelight.camera.aioeditor.config.QIMPasterConfigProcessor");
                f202293g.put("298", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("292", "com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor");
                f202293g.put("287", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("276", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("272", "com.tencent.mobileqq.shortvideo.config.VideoCompressConfigProcessor");
                f202293g.put("263", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("252", "com.tencent.mobileqq.config.business.RedBagVideoResProcessor");
                f202293g.put("251", "com.tencent.mobileqq.config.business.PicCommonConfProcessor");
                f202293g.put("250", "com.tencent.mobileqq.ark.config.processor.ArkAIKeyWordSDKShareConfigProcessor");
                f202293g.put("249", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("216", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put(ThemeReporter.FROM_SERVER_SET_THEME, "com.tencent.mobileqq.config.business.WVWhiteListConfProcessor");
                f202293g.put("192", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("190", "com.tencent.mobileqq.search.searchlocal.config.SearchFunctionModuleProcessor");
                f202293g.put(QAdConfigDefine$CHID.SUBMARINE, "com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor");
                f202293g.put("176", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("172", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("168", "com.tencent.mobileqq.config.business.FlashChatConfProcessor");
                f202293g.put("132", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("106", "com.tencent.av.ManageConfig.QAVConfig");
                f202293g.put("95", "com.tencent.mobileqq.vas.config.business.qvip.PushOpenNotificationProcessor");
                f202293g.put("81", "com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfProcessor");
                f202293g.put("76", "com.tencent.mobileqq.vas.config.business.qvip.QVipKeywordsProcessor");
                f202293g.put("70", "com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfProcessor");
                f202293g.put("50", "com.tencent.mobileqq.search.config.SearchConfigProcessor");
                f202293g.put("35", "com.tencent.biz.pubaccount.conf.PaSubscribeRedDotProcessor");
                f202293g.put("32", "com.tencent.biz.pubaccount.conf.PublicAccountConfProcessor");
                f202293g.put("15", "com.tencent.mobileqq.transfile.HighwayConfProcessor");
                f202294h = new com.tencent.mobileqq.config.b();
                return;
            }
        }
    }

    am() {
        String sb5;
        File filesDir = MobileQQ.sMobileQQ.getFilesDir();
        filesDir = filesDir == null ? MobileQQ.sMobileQQ.getCacheDir() : filesDir;
        if (filesDir != null) {
            sb5 = filesDir.getParent();
        } else {
            StringBuilder sb6 = new StringBuilder();
            String str = File.separator;
            sb6.append(str);
            sb6.append("data");
            sb6.append(str);
            sb6.append("data");
            sb6.append(str);
            sb6.append(MobileQQ.sMobileQQ.getPackageName());
            sb5 = sb6.toString();
        }
        String str2 = sb5 + File.separator + "qstore";
        this.f202296a = str2;
        if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "QConfigManager constructor, rootPath=" + str2);
        }
        w();
        QLog.d("QConfigManager", 1, "initQAutoInject, mOldServletInjector: ", f202294h.getClass().getSimpleName(), ", mInjectProcessors: ", Integer.valueOf(f202293g.size()));
    }

    private <T> T A(l<T> lVar, int i3) {
        T migrateOldOrDefaultContent = lVar.migrateOldOrDefaultContent(i3);
        if (migrateOldOrDefaultContent == null) {
            return (T) aj.f(lVar.clazz());
        }
        return migrateOldOrDefaultContent;
    }

    private Object F(l lVar, ai[] aiVarArr, int i3) {
        try {
            return lVar.onParsed(aiVarArr);
        } catch (Exception e16) {
            an.b().c(lVar, i3, e16);
            return null;
        }
    }

    private String G(int i3) {
        return i3 + "_ids";
    }

    private String H(int i3, String str) {
        return i3 + "_" + str;
    }

    private String I(int i3) {
        return i3 + "_upgrade";
    }

    private String J(int i3, int i16) {
        return i3 + "_" + i16 + "_defualt";
    }

    private String K(int i3) {
        return String.valueOf(i3);
    }

    private long R(Long l3, boolean z16) {
        if (z16) {
            return l3.longValue();
        }
        return 0L;
    }

    private long S(String str, boolean z16) {
        if (!z16) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            QLog.e("QConfigManager", 1, "Can not parse uin - " + str);
            return 0L;
        }
    }

    private void T(l lVar, ai[] aiVarArr, long j3, String str) {
        if (!lVar.isNeedStoreLargeFile()) {
            MMKVOptionEntity r16 = r(j3);
            HashSet hashSet = new HashSet();
            for (ai aiVar : aiVarArr) {
                hashSet.add(String.valueOf(aiVar.f202267a));
                r16.encodeString(H(lVar.type(), String.valueOf(aiVar.f202267a)), aiVar.f202268b);
            }
            r16.encodeStringSet(G(lVar.type()), hashSet);
            r16.commitAsync();
            return;
        }
        cr.a(new File(str));
        for (ai aiVar2 : aiVarArr) {
            File i3 = cr.i(str, String.valueOf(aiVar2.f202267a));
            if (i3 != null && !cr.l(i3.getAbsolutePath(), aiVar2.f202268b)) {
                QLog.e("QConfigManager", 1, "writeToLocal fail, processor: ", Integer.valueOf(lVar.type()), ", conf content:", aiVar2.f202268b);
            }
        }
    }

    private void V(l lVar, Object obj, int i3, long j3, boolean z16) {
        if (obj == null) {
            return;
        }
        r(j3).encodeInt(K(lVar.type()), i3).encodeBool(J(lVar.type(), i3), z16).commitAsync();
        this.f202298c.put(Integer.valueOf(lVar.type()), new a(j3, i3, obj));
        lVar.onUpdate(obj);
    }

    private l a(String str) {
        l lVar;
        Exception e16;
        try {
            Class<?> cls = Class.forName(f202293g.get(str));
            if (!l.class.isAssignableFrom(cls)) {
                QLog.e(QConfigServlet.f202245e, 2, "genProcessor, not subclass of IQConfigProcessor, type=" + str);
                return null;
            }
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                lVar = (l) declaredConstructor.newInstance(new Object[0]);
                try {
                    lVar.onProcessorConstructed(Integer.parseInt(str));
                } catch (Exception e17) {
                    e16 = e17;
                    QLog.d("QConfigManager", 2, "genProcessor, type=" + str, " err:", e16.toString());
                    return lVar;
                }
            } catch (Exception e18) {
                lVar = null;
                e16 = e18;
            }
            return lVar;
        } catch (ClassNotFoundException unused) {
            QLog.e(QConfigServlet.f202245e, 2, "genProcessor, clazz=null, type=" + str);
            return null;
        }
    }

    protected static int[] b() {
        int size = f202293g.size();
        int[] iArr = new int[size];
        Iterator<String> it = f202293g.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = Integer.parseInt(it.next());
            i3++;
        }
        s();
        int[] c16 = f202294h.c();
        int[] iArr2 = new int[c16.length + size];
        System.arraycopy(c16, 0, iArr2, 0, c16.length);
        System.arraycopy(iArr, 0, iArr2, c16.length, size);
        return iArr2;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            if (waitAppRuntime != null) {
                str = waitAppRuntime.getAccount();
            }
            if (TextUtils.isEmpty(str)) {
                QLog.d("QConfigManager", 2, "getAllConfigs: uin=" + str);
            }
        }
        QConfigServlet.f202246f = str;
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
        newIntent.putParcelableArrayListExtra("k_cmd_type", aj.i(b()));
        newIntent.putExtra("key_uin", str);
        newIntent.putExtra("k_req_occasion", 0);
        newIntent.putExtra("key_is_all_config", true);
        MobileQQ.sMobileQQ.waitAppRuntime().startServlet(newIntent);
    }

    private String d(int i3, long j3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f202296a);
        String str = File.separator;
        sb5.append(str);
        sb5.append(j3);
        sb5.append(str);
        sb5.append("conf");
        sb5.append(str);
        sb5.append(i3);
        sb5.append(str);
        sb5.append(i16);
        return sb5.toString();
    }

    private int h(l lVar, int i3, long j3) {
        int decodeInt = r(j3).decodeInt(String.valueOf(i3), -1);
        if (decodeInt == -1) {
            return lVar.migrateOldVersion();
        }
        return decodeInt;
    }

    public static void i(ArrayList<QConReqExtraInfo> arrayList) {
        j(arrayList, MobileQQ.sMobileQQ.waitAppRuntime().getAccount());
    }

    public static void j(ArrayList<QConReqExtraInfo> arrayList, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            k(arrayList, str, false);
        }
    }

    public static void k(ArrayList<QConReqExtraInfo> arrayList, String str, boolean z16) {
        l e16;
        if (z16) {
            Iterator<QConReqExtraInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                QConReqExtraInfo next = it.next();
                if (s().Q(next.f202243d) && (e16 = s().e(next.f202243d)) != null && e16.isAccountRelated()) {
                    QLog.d("QConfigManager", 2, "getConfig: processor.isAccountRelated, withoutLogin=true");
                    z16 = false;
                }
            }
        }
        if (!z16 && TextUtils.isEmpty(str)) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            if (waitAppRuntime != null) {
                str = waitAppRuntime.getAccount();
            }
            if (TextUtils.isEmpty(str)) {
                QLog.d("QConfigManager", 2, "getConfig: withoutLogin=false, uin=null");
            }
        }
        QConfigServlet.f202246f = str;
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
        newIntent.putParcelableArrayListExtra("k_cmd_type", arrayList);
        if (!TextUtils.isEmpty(str)) {
            newIntent.putExtra("key_uin", str);
        }
        if (z16) {
            newIntent.setWithouLogin(z16);
        }
        MobileQQ.sMobileQQ.waitAppRuntime().startServlet(newIntent);
    }

    public static void l(int[] iArr, String str) {
        m(iArr, str, false);
    }

    public static void m(int[] iArr, String str, boolean z16) {
        k(aj.i(iArr), str, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void n(int[] iArr, String str, byte[] bArr, int i3) {
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
        newIntent.putParcelableArrayListExtra("k_cmd_type", aj.i(iArr));
        newIntent.putExtra("key_uin", str);
        newIntent.putExtra("key_is_page_req", true);
        if (bArr != null) {
            newIntent.putExtra("key_cookies", bArr);
        }
        newIntent.putExtra("key_is_all_config", true);
        newIntent.putExtra("key_page_req_count", i3);
        newIntent.putExtra("k_req_occasion", 0);
        MobileQQ.sMobileQQ.waitAppRuntime().startServlet(newIntent);
    }

    private ai[] o(int i3, long j3) {
        if (e(i3) == null) {
            return null;
        }
        File file = new File(d(i3, j3, f(i3, j3)));
        File[] listFiles = file.listFiles();
        if (!file.exists() || listFiles == null || listFiles.length == 0) {
            return null;
        }
        ai[] aiVarArr = new ai[listFiles.length];
        for (int i16 = 0; i16 < listFiles.length; i16++) {
            File file2 = listFiles[i16];
            aiVarArr[i16] = new ai(t(file2), cr.k(file2, i3));
        }
        return aiVarArr;
    }

    private ai[] p(int i3, long j3) {
        MMKVOptionEntity r16;
        Set<String> decodeStringSet;
        if (e(i3) == null || (decodeStringSet = (r16 = r(j3)).decodeStringSet(G(i3), null)) == null || decodeStringSet.isEmpty()) {
            return null;
        }
        ai[] aiVarArr = new ai[decodeStringSet.size()];
        int i16 = 0;
        for (String str : decodeStringSet) {
            aiVarArr[i16] = new ai(Integer.parseInt(str), r16.decodeString(H(i3, str), null));
            i16++;
        }
        return aiVarArr;
    }

    private String q(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("QConfigManager", 2, "getCookieNewFileDir, uin: ", str);
            }
            str = "9999";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f202296a);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        sb5.append("conf");
        sb5.append(str2);
        sb5.append("cookie_new");
        return sb5.toString();
    }

    private MMKVOptionEntity r(long j3) {
        return QMMKV.from(MobileQQ.sMobileQQ, j3 + "_" + QMMKVFile.SUFFIX_1);
    }

    public static am s() {
        return b.f202304a;
    }

    private int t(File file) {
        try {
            return Integer.parseInt(file.getName());
        } catch (NumberFormatException e16) {
            QLog.e("QConfigManager", 1, "getTaskIdFromFile, ", e16);
            return -1024;
        }
    }

    private void u(l lVar, ConfigurationService$Config configurationService$Config, long j3, String str, int i3) {
        Object z16;
        String stringUtf8;
        int size = configurationService$Config.msg_content_list.size();
        if (size == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "handleCompressedConf, contentSize==0, type=", Integer.valueOf(lVar.type()));
            }
            if (lVar.handleEmptyResp()) {
                V(lVar, lVar.migrateOldOrDefaultContent(1), i3, j3, true);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < size; i16++) {
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(i16);
            if (configurationService$Content != null && configurationService$Content.content.has()) {
                if (configurationService$Content.compress.get() == 1) {
                    byte[] e16 = aj.e(configurationService$Content.content.get().toByteArray());
                    if (e16 != null) {
                        stringUtf8 = new String(e16, StandardCharsets.UTF_8);
                    } else {
                        stringUtf8 = null;
                    }
                } else {
                    stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                }
                if (!TextUtils.isEmpty(stringUtf8)) {
                    arrayList.add(new ai(configurationService$Content.task_id.get(), stringUtf8));
                }
            }
        }
        int size2 = arrayList.size();
        ai[] aiVarArr = new ai[size2];
        arrayList.toArray(aiVarArr);
        Object F = F(lVar, aiVarArr, i3);
        if (F != null) {
            T(lVar, aiVarArr, j3, str);
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "handleNewConfig, parse success, size=" + size2);
            }
            z16 = F;
        } else {
            z16 = z(lVar, j3, i3);
        }
        V(lVar, z16, i3, j3, false);
    }

    private void v(l lVar, ConfigurationService$Config configurationService$Config, long j3, String str, int i3) {
        Object z16;
        if (configurationService$Config.content_list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "handleUncompressedConf, config.content_list.isEmpty(), type=", Integer.valueOf(lVar.type()));
            }
            if (lVar.handleEmptyResp()) {
                V(lVar, lVar.migrateOldOrDefaultContent(1), i3, j3, true);
                return;
            }
            return;
        }
        int size = configurationService$Config.content_list.size();
        ai[] aiVarArr = new ai[size];
        for (int i16 = 0; i16 < size; i16++) {
            aiVarArr[i16] = new ai(i16, configurationService$Config.content_list.get(i16));
        }
        Object F = F(lVar, aiVarArr, i3);
        if (F != null) {
            T(lVar, aiVarArr, j3, str);
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "handleOldConfig, parse success, size=" + size);
            }
            z16 = F;
        } else {
            z16 = z(lVar, j3, i3);
        }
        V(lVar, z16, i3, j3, false);
    }

    private Object z(l lVar, long j3, int i3) {
        Object x16 = x(lVar.type());
        if (x16 != null) {
            int type = lVar.type();
            int h16 = h(lVar, type, j3);
            if (lVar.isNeedStoreLargeFile()) {
                String d16 = d(type, j3, h16);
                String d17 = d(type, j3, i3);
                if (!TextUtils.equals(d17, d16)) {
                    cr.c(d16, d17, false);
                }
            }
        } else {
            x16 = lVar.migrateOldOrDefaultContent(0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "loadNewConfigFailBackport, version=" + i3 + ", type" + lVar.type() + ", conf=" + x16);
        }
        return x16;
    }

    public void B(long j3, int i3, String str) {
        C(j3, j3, i3, str);
    }

    public void C(long j3, long j16, int i3, String str) {
        MMKVOptionEntity r16;
        Set<String> decodeStringSet;
        String str2;
        l e16 = e(i3);
        if (e16 != null && (decodeStringSet = (r16 = r(j3)).decodeStringSet(G(i3), null)) != null && !decodeStringSet.isEmpty()) {
            ai[] aiVarArr = new ai[decodeStringSet.size()];
            int i16 = 0;
            for (String str3 : decodeStringSet) {
                aiVarArr[i16] = new ai(Integer.parseInt(str3), r16.decodeString(H(i3, str3), null));
                i16++;
            }
            ai migrateToFreesia = e16.migrateToFreesia(aiVarArr);
            if (migrateToFreesia != null) {
                IManageMigrate iManageMigrate = (IManageMigrate) QRoute.api(IManageMigrate.class);
                if (j16 == 0) {
                    str2 = TVKUpdateInfo.APP_ID;
                } else {
                    str2 = j16 + "";
                }
                iManageMigrate.migrate(str2, i3, str, migrateToFreesia.f202268b);
            }
        }
    }

    public boolean D(AppRuntime appRuntime, int i3) {
        l e16 = e(i3);
        if (e16 != null && e16.isNeedUpgradeReset()) {
            return !TextUtils.equals(AppSetting.l(), r(R(Long.valueOf(appRuntime.getLongAccountUin()), e16.isAccountRelated())).decodeString(I(i3), ""));
        }
        return false;
    }

    public void E(int i3, String str) {
        l e16 = e(i3);
        if (e16 == null) {
            return;
        }
        long S = S(str, e16.isAccountRelated());
        try {
            e16.onReqNoReceive();
            O(i3, S);
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "Handle noReceive operation exception, type=" + i3, e17);
            }
        }
    }

    public byte[] L(String str) {
        return cr.j(q(str));
    }

    public void M(int[] iArr) {
        for (int i3 : iArr) {
            if (!Q(i3)) {
                throw new IllegalStateException("QConfigManager has not support the config yet, type=" + i3);
            }
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        String account = waitAppRuntime.getAccount();
        QConfigServlet.f202246f = account;
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
        newIntent.putParcelableArrayListExtra("k_cmd_type", aj.i(iArr));
        newIntent.putExtra("key_uin", account);
        waitAppRuntime.startServlet(newIntent);
    }

    public void N(int i3, int i16, ConfigurationService$Config configurationService$Config, String str) {
        l e16 = e(i3);
        if (e16 == null) {
            return;
        }
        long S = S(str, e16.isAccountRelated());
        O(i3, S);
        int f16 = f(i3, S);
        if (f16 == i16) {
            return;
        }
        if (ak.b().e(i3, i16)) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "conf has been deleted by safemode, type=" + i3 + ", version=" + i16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "save config, ov=" + f16 + " to nv=" + i16 + ", type=" + i3);
        }
        String d16 = d(i3, S, i16);
        Object[] objArr = f202292f;
        synchronized (objArr[i3 % objArr.length]) {
            if (e16.isNeedStoreLargeFile() && !cr.b(d16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QConfigManager", 2, "create conf dir failed, dir=" + d16);
                }
                return;
            }
            if (e16.isNeedCompressed()) {
                u(e16, configurationService$Config, S, d16, i16);
            } else {
                v(e16, configurationService$Config, S, d16, i16);
            }
            ak.b().g(i3, S, e16.isNeedStoreLargeFile());
        }
    }

    public void O(int i3, long j3) {
        l e16 = e(i3);
        if (e16 != null && e16.isNeedUpgradeReset()) {
            long R = R(Long.valueOf(j3), e16.isAccountRelated());
            if (s().f(i3, R) != 0) {
                return;
            }
            r(R).encodeString(I(i3), AppSetting.l()).commitAsync();
        }
    }

    public void P(int i3, int i16) {
        long j3;
        AppRuntime waitAppRuntime;
        l e16 = e(i3);
        if (e16 != null && e16.isAccountRelated() && (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime()) != null) {
            j3 = S(waitAppRuntime.getAccount(), e16.isAccountRelated());
        } else {
            j3 = 0;
        }
        MMKVOptionEntity r16 = r(j3);
        int decodeInt = r16.decodeInt(String.valueOf(i3), -1);
        if (decodeInt != -1 && decodeInt != i16) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "setConfVersion t=" + i3 + " v=" + i16);
            }
            r16.encodeInt(K(i3), i16).commitAsync();
        }
    }

    public boolean Q(int i3) {
        return f202293g.containsKey(String.valueOf(i3));
    }

    public boolean U(String str, byte[] bArr) {
        return cr.n(bArr, q(str));
    }

    @Nullable
    public l e(int i3) {
        l lVar = this.f202297b.get(Integer.valueOf(i3));
        if (lVar != null) {
            return lVar;
        }
        synchronized (this.f202299d) {
            l lVar2 = this.f202297b.get(Integer.valueOf(i3));
            if (lVar2 != null) {
                return lVar2;
            }
            l a16 = a(String.valueOf(i3));
            if (a16 != null) {
                this.f202297b.put(Integer.valueOf(i3), a16);
            }
            if (a16 == null && QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "getConfProcess, Has no define process, type=", Integer.valueOf(i3));
            }
            return a16;
        }
    }

    public int f(int i3, long j3) {
        l e16 = e(i3);
        if (e16 == null) {
            return -1;
        }
        return h(e16, i3, R(Long.valueOf(j3), e16.isAccountRelated()));
    }

    public int g(int i3, String str) {
        l e16 = e(i3);
        if (e16 == null) {
            return -1;
        }
        return h(e16, i3, S(str, e16.isAccountRelated()));
    }

    @QAutoInitMethod
    void w() {
        f202294h = (k) com.tencent.mobileqq.qroute.utils.b.a(f202295i);
    }

    public <T> T x(int i3) {
        return (T) y(i3, true);
    }

    public <T> T y(int i3, boolean z16) {
        long j3;
        ai[] p16;
        String str;
        ai aiVar;
        T t16;
        T t17;
        String c16 = ae.c(i3);
        if (c16 != null) {
            return (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(c16);
        }
        l<?> e16 = e(i3);
        if (e16 == null) {
            return null;
        }
        if (e16.isAccountRelated()) {
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
                }
                return (T) A(e16, 1);
            }
            j3 = S(firstSimpleAccount.getUin(), e16.isAccountRelated());
        } else {
            j3 = 0;
        }
        MMKVOptionEntity r16 = r(j3);
        int decodeInt = r16.decodeInt(String.valueOf(i3), -1);
        if (decodeInt == -1) {
            return (T) A(e16, 0);
        }
        a aVar = this.f202298c.get(Integer.valueOf(i3));
        if (aVar != null && aVar.f202302b == decodeInt && aVar.f202301a == j3 && (t17 = (T) aVar.f202303c) != null) {
            return t17;
        }
        if (r16.decodeBool(J(e16.type(), decodeInt), false)) {
            if (QLog.isColorLevel()) {
                QLog.dAsync("QConfigManager", 1, "loadConObj: type=" + i3 + ", default=true, use migrateContent");
            }
            return (T) A(e16, 0);
        }
        if (!z16) {
            return null;
        }
        Object[] objArr = f202292f;
        synchronized (objArr[i3 % objArr.length]) {
            a aVar2 = this.f202298c.get(Integer.valueOf(i3));
            if (aVar2 != null && aVar2.f202302b == decodeInt && aVar2.f202301a == j3 && (t16 = (T) aVar2.f202303c) != null) {
                return t16;
            }
            if (e16.isNeedStoreLargeFile()) {
                p16 = o(i3, j3);
            } else {
                p16 = p(i3, j3);
            }
            if (p16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QConfigManager", 2, "loadConObj: type:", Integer.valueOf(i3), " --> get data from file or sp return null");
                }
                return (T) aj.f(e16.clazz());
            }
            try {
                T t18 = (T) e16.onParsed(p16);
                if (t18 == null) {
                    if (p16.length != 0 && (aiVar = p16[0]) != null) {
                        str = aiVar.f202268b;
                        QLog.e("QConfigManager", 1, "loadConObj: onParse return null, type=", Integer.valueOf(i3), ", confs[0]:", str);
                        return (T) aj.f(e16.clazz());
                    }
                    str = "null";
                    QLog.e("QConfigManager", 1, "loadConObj: onParse return null, type=", Integer.valueOf(i3), ", confs[0]:", str);
                    return (T) aj.f(e16.clazz());
                }
                this.f202298c.put(Integer.valueOf(i3), new a(j3, decodeInt, t18));
                if (QLog.isColorLevel()) {
                    QLog.d("QConfigManager", 1, "loadConObj: type=", Integer.valueOf(i3), ", parse config and return");
                }
                return t18;
            } catch (Exception e17) {
                an.b().c(e16, decodeInt, e17);
                return (T) aj.f(e16.clazz());
            }
        }
    }
}

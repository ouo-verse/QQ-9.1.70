package com.tencent.mobileqq.qipc;

import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.aelight.camera.entry.api.IAECameraLaunchServer;
import com.tencent.aelight.camera.favemoticon.api.IFavEmoticonIPCServerApi;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.aelight.camera.qipc.api.IAEEditorEffectIpc;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.avbiz.AVBizServerQIPCModule;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.qrcode.ipc.QRCodeIPCModule;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.adapter.f;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.miniaio.h;
import com.tencent.mobileqq.app.aa;
import com.tencent.mobileqq.app.as;
import com.tencent.mobileqq.app.cz;
import com.tencent.mobileqq.app.g;
import com.tencent.mobileqq.applets.d;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.campuscircle.b;
import com.tencent.mobileqq.colornote.c;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataIPC;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.filebrowser.ITBSToolApi;
import com.tencent.mobileqq.filemanager.app.k;
import com.tencent.mobileqq.filemanager.util.i;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gateway.localphone.ecdh.api.ILocalPhoneIPCApi;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoQIPCApi;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.webview.IGuildMediaOpenWebApi;
import com.tencent.mobileqq.highway.kernel.IpcSever;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendIPCServer;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.nearbypro.ipc.api.INBPIPCServerApi;
import com.tencent.mobileqq.pic.r;
import com.tencent.mobileqq.pluginsdk.QIPCServerModulePlugin;
import com.tencent.mobileqq.profilecard.api.IZanRankingApi;
import com.tencent.mobileqq.pskey.api.IPskeyIPCApi;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qqecommerce.biz.ipc.api.IECommerceIPCServerApi;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgift.api.ipc.IQQGiftIPCApi;
import com.tencent.mobileqq.qqlive.api.ITRTCIPCApi;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveIPCServerApi;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorIPCModuleApi;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletHomeApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;
import com.tencent.mobileqq.soso.location.SosoInterfaceModule;
import com.tencent.mobileqq.springhb.entry.SpringHbIPCModule;
import com.tencent.mobileqq.studymode.u;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bg;
import com.tencent.mobileqq.tianshu.api.IQQTianshuApi;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.transfile.InjectHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.api.ITroopQIPCModuleApi;
import com.tencent.mobileqq.troop.opensdkhandler.e;
import com.tencent.mobileqq.txc.log.api.ITxcActiveReportLogApi;
import com.tencent.mobileqq.utils.abtest.ABTLoginActModule;
import com.tencent.mobileqq.vas.VasCommonIPCModule;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vas.api.VasIPCModule;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniLibApi;
import com.tencent.mobileqq.wxmini.api.IWxRuntimeApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.open.OpenSdkQIPCModule;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qqnt.dns.NtDnsManager;
import com.tencent.qqnt.emotion.api.INTEmoticonPanelIpcService;
import com.tencent.timi.game.api.ipc.ITGIPCServerApi;
import cooperation.photoplus.PhotoPlusModule;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import h62.a;
import mqq.app.SecurityFileModule;

/* loaded from: classes16.dex */
public class QIPCServerModuleFactory {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QIPCServerModuleFactory";

    public QIPCServerModuleFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QIPCModule onCreateModule(String str) {
        if ("CommonModule".equals(str)) {
            return g.b();
        }
        if (InnerDns.NAME.equals(str)) {
            return NtDnsManager.f355947a.a();
        }
        if ("Module_DownloaderGetCodeServer".equals(str)) {
            return com.tencent.open.downloadnew.g.g().f();
        }
        if ("PhotoPlusModule".equals(str)) {
            return PhotoPlusModule.b();
        }
        if ("Module_VideoFeedsIPCServer".equals(str)) {
            return a.a().b();
        }
        if ("SignInModule".equals(str)) {
            return cz.b();
        }
        if ("QQComicIPCModule".equals(str)) {
            return ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).getIpcModule();
        }
        if ("QWalletIPCModule".equals(str)) {
            return ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletIPCModule();
        }
        if (WadlQIPCModule.NAME.equals(str)) {
            return WadlQIPCModule.getInstance();
        }
        if ("CampusCircleIpcServer_Model".equals(str)) {
            return b.b();
        }
        if (SosoInterfaceModule.NAME.equals(str)) {
            return SosoInterfaceModule.getInterface();
        }
        if ("REAL_NAME".equals(str)) {
            return com.tencent.mobileqq.realname.b.b();
        }
        if ("QzoneVideoSoDownloadModule".equals(str)) {
            return QZoneHelper.getQzoneVideoSoDownloadModule();
        }
        if ("QzoneIPCModule".equals(str)) {
            return QzoneIPCModule.getInstance();
        }
        if ("SpringHbIPCModule".equals(str)) {
            return SpringHbIPCModule.c();
        }
        if ("Module_VideoPlayIPCServer".equals(str)) {
            return dr2.b.a().b();
        }
        if ("VideoSubtitleQIPC".equals(str)) {
            return com.tencent.mobileqq.stt.sub.api.b.b();
        }
        if ("gdt_ipc_sync_module_client_to_server".equals(str)) {
            return f.d.b();
        }
        if ("gdt_ipc_async_module_client_to_server".equals(str)) {
            return f.c.b();
        }
        if ("VasFontIPCModule".equals(str)) {
            return VasFontIPCModule.f();
        }
        if (IEmoticonPanelIpcService.EMOTICON_IPC_NAME.equals(str)) {
            return ((IEmoticonPanelIpcService) QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(str);
        }
        if ("VasApngIPCModule".equals(str)) {
            return an.h();
        }
        if (ThemeIPCModule.NAME.equals(str)) {
            return ThemeIPCModule.getInstance();
        }
        if (VasIPCModule.NAME.equals(str)) {
            return VasIPCModule.getInstance();
        }
        if (QuickUpdateIPCModule.NAME.equals(str)) {
            return QuickUpdateIPCModule.getInstance();
        }
        if (HardCoderManager.HardCoderIPCModule.NAME.equals(str)) {
            return HardCoderManager.HardCoderIPCModule.getInstance();
        }
        if ("TeamWorkModule".equals(str)) {
            return bg.b();
        }
        if ("ChooseImageIPCModule".equals(str)) {
            return j91.a.g();
        }
        if (IArkIPCService.NAME.equals(str)) {
            return ((IArkIPCService) QRoute.api(IArkIPCService.class)).getModule();
        }
        if ("IdentificationIpcServer_Model".equals(str)) {
            return ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).getIdentityIpcServer();
        }
        if ("MiniAppTransferModule".equals(str)) {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppTransferModule();
        }
        if ("MiniMsgIPCServer".equals(str)) {
            return h.v();
        }
        if ("ColorNoteIPCServer".equals(str)) {
            return c.k();
        }
        if ("JubaoIPCServer".equals(str)) {
            return com.tencent.mobileqq.jubao.b.b();
        }
        if (SecurityFileModule.NAME.equals(str)) {
            return SecurityFileModule.getInstance();
        }
        if (IAEEditorEffectIpc.NAME.equals(str)) {
            return ((IAEEditorEffectIpc) QRoute.api(IAEEditorEffectIpc.class)).getAEEditorEffectQIPCModule();
        }
        if ("PublicAccountModule".equals(str)) {
            return d.b();
        }
        if (IWeiyunUploadDownloadService.MODULE_NAME.equals(str)) {
            return ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).getIPCModule();
        }
        if ("Module_TDFileChangeNameQIPCModule".equals(str)) {
            return ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTDIPCModule();
        }
        if ("NetworkMonitorIPCModule".equals(str)) {
            return ty3.b.b();
        }
        if ("MiniAppBannerIPCModule".equals(str)) {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppBannerIPCModule();
        }
        if (IAECameraLaunchServer.NAME.equals(str)) {
            return ((IAECameraLaunchServer) QRoute.api(IAECameraLaunchServer.class)).getAECameraLaunchServerQIPCModule();
        }
        if ("VasCommonIPCModule".equals(str)) {
            return VasCommonIPCModule.b();
        }
        if ("ListenTogetherIPCModuleMainServer".equals(str)) {
            return ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).getListenTogetherIPCModuleMainServerIns();
        }
        if (((IZanRankingApi) QRoute.api(IZanRankingApi.class)).getZanRankingServerName().equals(str)) {
            return ((IZanRankingApi) QRoute.api(IZanRankingApi.class)).getZanRankingServerInstance();
        }
        if (IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME.equals(str)) {
            return ((IEmoticonPanelIpcService) QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(str);
        }
        if ("Module_CheckInServer".equals(str)) {
            return com.tencent.mobileqq.troopcheckin.b.c();
        }
        if (IPeakIpcModuleServer.NAME.equals(str)) {
            return ((IPeakIpcModuleServer) QRoute.api(IPeakIpcModuleServer.class)).getPeakIpcModuleServerModule();
        }
        if (IAECameraGetInfoServer.NAME.equals(str)) {
            return ((IAECameraGetInfoServer) QRoute.api(IAECameraGetInfoServer.class)).getAECameraGetInfoServerQIPCModule();
        }
        if ("FriendQIPCModule".equals(str)) {
            return as.b();
        }
        if ("ExtendFriendQIPCModule".equals(str)) {
            return aa.b();
        }
        if ("open_sdk_qipc_module".equals(str)) {
            return OpenSdkQIPCModule.c();
        }
        if ("weibo_qipc_module".equals(str)) {
            return com.tencent.mobileqq.wbapi.b.b();
        }
        if ("PicSTWXQIPCModule".equals(str)) {
            return r.b();
        }
        if ("DanmuDataIPCServer".equals(str)) {
            return ((IDanmuDataIPCServer) QRoute.api(IDanmuDataIPCServer.class)).getDanmuIPCServer();
        }
        if ("AioShareMusicIPCMainClient".equals(str)) {
            return com.tencent.aiosharemusic.a.d();
        }
        if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getQQGameIPCModuleName().equals(str)) {
            return ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getQQGameIPCModule();
        }
        if ("TogetherBusinessIPCModule".equals(str)) {
            return com.tencent.mobileqq.intervideo.yiqikan.d.b();
        }
        if (IQRScanIpcApi.MODULUE_MAIN.equals(str)) {
            return ((IQRScanIpcApi) QRoute.api(IQRScanIpcApi.class)).getModule(IQRScanIpcApi.MODULUE_MAIN);
        }
        if ("DeviceProtectQIPCModule".equals(str)) {
            return com.tencent.mobileqq.identification.b.b();
        }
        if ("MiniGamePublicAccountIPCModule".equals(str)) {
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniGamePublicAccountIPCModule();
        }
        if ("QfavMainQIPCModule".equals(str)) {
            return cooperation.qqfav.ipc.d.c();
        }
        if (VasLiveIPCModule.NAME.equals(str)) {
            return VasLiveIPCModule.getInstance();
        }
        if ("QRouteIPCModule".equals(str)) {
            return com.tencent.common.app.h.b();
        }
        if ("EcshopIPCModule".equals(str)) {
            return ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).getEcshopIPCModule();
        }
        if ("QQNotifyIPCModule".equals(str)) {
            return com.tencent.mobileqq.activity.activateFriend.aa.d();
        }
        if (IHippyIPC.NAME.equals(str)) {
            return ((IHippyIPC) QRoute.api(IHippyIPC.class)).getIPCModule();
        }
        if (IZPlanIPCHelper.MODULE_NAME.equals(str)) {
            return ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).getIPCModule();
        }
        if ("UniteDownloadIPCModule".equals(str)) {
            return com.tencent.mobileqq.download.unite.util.a.b();
        }
        if ("ExpandFlutterIPCServer".equals(str)) {
            return ((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getIPCServer();
        }
        if ("MatchFriendIpcServer".equals(str)) {
            return ((IMatchFriendIPCServer) QRoute.api(IMatchFriendIPCServer.class)).getFlutterIpcModule();
        }
        if ("MatchFriendVoiceChatIpcServer".equals(str)) {
            return ((IMatchFriendIPCServer) QRoute.api(IMatchFriendIPCServer.class)).getVoiceChatIpcModule();
        }
        if ("module_emoticon_mainpanel".equals(str)) {
            return ((IEmoticonPanelIpcService) QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(str);
        }
        if (INTEmoticonPanelIpcService.NT_EMOTICON_MAINPANEL_IPC_NAME.equals(str)) {
            return ((INTEmoticonPanelIpcService) QRoute.api(INTEmoticonPanelIpcService.class)).onCreateModule(str);
        }
        if (((IEmoticonDataIPC) QRoute.api(IEmoticonDataIPC.class)).getModuleName().equals(str)) {
            return ((IEmoticonDataIPC) QRoute.api(IEmoticonDataIPC.class)).getIPCModule();
        }
        if ("IntimateQIPCModule".equals(str)) {
            return com.tencent.mobileqq.intimate.c.b();
        }
        if ("AvatarServerIPCModule".equals(str)) {
            return com.tencent.mobileqq.avatar.ipc.a.e();
        }
        if (SoLoadIPCModule.NAME.equals(str)) {
            return SoLoadIPCModule.getInstance();
        }
        if (QIPCServerModulePlugin.MODULE_NAME.equals(str)) {
            return QIPCServerModulePlugin.getInstance();
        }
        if (IGuildIPCService.GUILD_NAME_IPC_NAME.equals(str)) {
            return ((IGuildIPCService) QRoute.api(IGuildIPCService.class)).onCreateModule(str);
        }
        if (AVBizServerQIPCModule.NAME.equals(str)) {
            return AVBizServerQIPCModule.getInstance();
        }
        if (IWSManager.IPC_MODULE_NAME.equals(str)) {
            return ((IWSManager) QRoute.api(IWSManager.class)).getIPCModule();
        }
        if (IQCircleIPCApi.MODULE_NAME.equals(str)) {
            return ((IQCircleIPCApi) QRoute.api(IQCircleIPCApi.class)).getIPCModule();
        }
        if ("QQLiveServerIPCModule".equals(str)) {
            return ((ITRTCIPCApi) QRoute.api(ITRTCIPCApi.class)).getServerIPCModule();
        }
        if ("QQGiftServerIPCModule".equals(str)) {
            return ((IQQGiftIPCApi) QRoute.api(IQQGiftIPCApi.class)).getServerIPCModule();
        }
        if ("StudyModeIpcServer_model".equals(str)) {
            return u.i();
        }
        if (IQQLiveSdkIPCServerApi.MODULE_NAME.equals(str)) {
            return ((IQQLiveSdkIPCServerApi) QRoute.api(IQQLiveSdkIPCServerApi.class)).getServerIPCModule();
        }
        if (ITGIPCServerApi.MODULE_NAME_LIVE.equals(str)) {
            return ((ITGIPCServerApi) QRoute.api(ITGIPCServerApi.class)).getLiveServerIPCModule();
        }
        if ("TGHallServerQIPCModule".equals(str)) {
            return ((ITGIPCServerApi) QRoute.api(ITGIPCServerApi.class)).getHallServerIPCModule();
        }
        if (IQQVideoEditApi.ZOOTOPIA_VIDEO_CUT_MODULE_NAME.equals(str)) {
            return ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).getZootopiaVideoCutIPCModule();
        }
        if ("FileDownIPCModule".equals(str)) {
            return i.b();
        }
        if (IWxMiniLibApi.WX_MINI_IPC_MODULE_NAME.equals(str)) {
            return ((IWxMiniLibApi) QRoute.api(IWxMiniLibApi.class)).getWxQIPCModule();
        }
        if ("QQLiveServerQIPCModule".equals(str)) {
            return ((IQQLiveIPCServerApi) QRoute.api(IQQLiveIPCServerApi.class)).getQQLiveServerIPCModule();
        }
        if ("TroopDocsShareActionModel".equals(str)) {
            return k.c();
        }
        if ("TencentVideoStatusQIPCModule".equals(str)) {
            return rc2.c.d();
        }
        if ("QavQIPCModule".equals(str)) {
            return ru.a.b();
        }
        if ("ZplanAvatarQIPCModule".equals(str)) {
            return bx.a.b();
        }
        if (ITimiQQIDApi.QQID_QIPC_SERVER_NAME.equals(str)) {
            return ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).getQQIDServerIPCModule();
        }
        if (IFavEmoticonIPCServerApi.MODULE_NAME_FAV_EMOTICON.equals(str)) {
            return ((IFavEmoticonIPCServerApi) QRoute.api(IFavEmoticonIPCServerApi.class)).getFavEmoticonIPCModule();
        }
        if ("minibox_qipc_module".equals(str)) {
            return ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).getMiniBoxIPCModule();
        }
        if ("EcommerceIPCModule".equals(str)) {
            return ((IECommerceIPCServerApi) QRoute.api(IECommerceIPCServerApi.class)).getEcommerceIPCModule();
        }
        if ("PskeyIPCModule".equals(str)) {
            return ((IPskeyIPCApi) QRoute.api(IPskeyIPCApi.class)).getPskeyIPCModule();
        }
        if ("LocalPhoneIPCModule".equals(str)) {
            return ((ILocalPhoneIPCApi) QRoute.api(ILocalPhoneIPCApi.class)).getLocalPhoneIPCModule();
        }
        if ("WeChatIPCModule".equals(str)) {
            return ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).getWXIPCModule();
        }
        if ("EmojiManagerServiceQIPC".equals(str)) {
            return ((IEmojiManagerServiceIPC) QRoute.api(IEmojiManagerServiceIPC.class)).createModule();
        }
        if (ABTLoginActModule.MODULE_NAME.equals(str)) {
            return ABTLoginActModule.getImpl();
        }
        if ("ECPluginIPCHelper".equals(str)) {
            return ((IECommerceIPCServerApi) QRoute.api(IECommerceIPCServerApi.class)).getPluginIPCModule();
        }
        if (IGameCenterQIPCModuleApi.NAME.equals(str)) {
            return ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).getQIPCModule();
        }
        if ("WebRemoteRenderIPCServer".equals(str)) {
            return RemoteWebRenderIPCServer.INSTANCE.a();
        }
        if ("GuildMediaWebIPCServer".equals(str)) {
            return ((IGuildMediaOpenWebApi) QRoute.api(IGuildMediaOpenWebApi.class)).getServerIPCModule();
        }
        if (ISoMonitorIPCModuleApi.NAME.equals(str)) {
            return ((ISoMonitorIPCModuleApi) QRoute.api(ISoMonitorIPCModuleApi.class)).getQIPCModule();
        }
        if ("MutualMarkIpcServer".equals(str)) {
            return ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getMutualMarkIpcServer();
        }
        if ("DownloadIPCMainClient".equals(str)) {
            return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getDownloadIpcServer();
        }
        if (IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME.equals(str)) {
            return ((IQWalletHomeApi) QRoute.api(IQWalletHomeApi.class)).getAdvIPCModule();
        }
        if ("TVideoIPCMainServer".equals(str)) {
            return yx2.b.b();
        }
        if (ITroopQIPCModuleApi.NAME.equals(str)) {
            return ((ITroopQIPCModuleApi) QRoute.api(ITroopQIPCModuleApi.class)).getTroopIPCModule();
        }
        if ("PerfMonitorIPCModule".equals(str)) {
            return com.tencent.mobileqq.perf.raftkit.dump.c.b();
        }
        if (ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME.equals(str)) {
            return ((ITDocWebIPCModuleApi) QRoute.api(ITDocWebIPCModuleApi.class)).getServerIPCModule();
        }
        if ("LoginIPCModule".equals(str)) {
            return ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).getLoginIPCModule();
        }
        if ("QRCodeIPCModule".equals(str)) {
            return QRCodeIPCModule.f94940d;
        }
        if ("BindGroupIPCModule".equals(str)) {
            return e.f298082d;
        }
        if (IQQTianshuApi.NAME.equals(str)) {
            return ((IQQTianshuApi) QRoute.api(IQQTianshuApi.class)).getTianshuIPCModule();
        }
        if (IGroupVideoQIPCApi.NAME.equals(str)) {
            return ((IGroupVideoQIPCApi) QRoute.api(IGroupVideoQIPCApi.class)).getTroopIPCModule();
        }
        if (IYunGameConstant.IPC_NAME.equals(str)) {
            return ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).getIPCModule();
        }
        if (ITxcActiveReportLogApi.NAME.equals(str)) {
            return ((ITxcActiveReportLogApi) QRoute.api(ITxcActiveReportLogApi.class)).getIPCModule();
        }
        if (IQWalletNickNameApi.IPC_MODULE_NAME.equals(str)) {
            return ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getIPCModule();
        }
        if ("BDHKernelEngine".equals(str)) {
            return new IpcSever(new InjectHelper());
        }
        if ("NearbyProIPCModule".equals(str)) {
            return ((INBPIPCServerApi) QRoute.api(INBPIPCServerApi.class)).getNBPIPCModule();
        }
        if ("TBSToolIPCModule".equals(str)) {
            return ((ITBSToolApi) QRoute.api(ITBSToolApi.class)).getTBSToolIPCModule();
        }
        if (ISharePanelApi.IPC_MODULE_ID.equals(str)) {
            return ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).getIPCModule();
        }
        if ("GdtWXMiniIPCModule".equals(str)) {
            return ((IGdtAPI) QRoute.api(IGdtAPI.class)).getGdtADIpcModule();
        }
        if ("wxa_qipc_module".equals(str)) {
            return ((IWxRuntimeApi) QRoute.api(IWxRuntimeApi.class)).getWxaIPCModule();
        }
        return null;
    }
}

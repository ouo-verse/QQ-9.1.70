package com.tencent.mobileqq.emosm.web;

import ConfigPush.FileStorageServerListInfo;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.summaryCardWzryInfo;
import Wallet.AuthCodeReq;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.etrump.mixlayout.VasShieldFont;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ark.ark;
import com.tencent.av.r;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.cl;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.ag;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MessengerService extends AppService implements IPCConstants {
    k G;
    cl H;
    public List<Bundle> I;
    Bundle J;
    CardObserver K;
    ProfileCardObserver L;
    VipSpecialCareHandler M;
    Bundle N;
    Bundle P;
    Handler Q;
    com.tencent.mobileqq.richstatus.h R;
    ar S;
    com.tencent.qidian.controller.a T;
    Bundle U;

    /* renamed from: e, reason: collision with root package name */
    private HandlerThread f204465e;

    /* renamed from: f, reason: collision with root package name */
    private IncomingHandler f204466f;

    /* renamed from: h, reason: collision with root package name */
    Messenger f204467h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f204468i;

    /* renamed from: d, reason: collision with root package name */
    Messenger f204464d = null;

    /* renamed from: m, reason: collision with root package name */
    public EmoticonPackageDownloadListener f204469m = new c();
    public EmojiStickerManager.d C = new d();
    ag D = new e();
    VipFunCallObserver E = new f();
    com.tencent.mobileqq.vip.k F = new g();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends ar {
        a() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetSigZanInfo(boolean z16, Object obj) {
            int i3;
            Bundle bundle = MessengerService.this.N;
            if (bundle != null) {
                bundle.putString("cmd", "ipc_signature_setlike");
                Bundle bundle2 = new Bundle();
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 101;
                }
                bundle2.putInt("result", i3);
                MessengerService.this.N.putBundle("response", bundle2);
                MessengerService messengerService = MessengerService.this;
                messengerService.J(messengerService.N);
                MessengerService.this.N = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b extends com.tencent.qidian.controller.a {
        b() {
        }

        @Override // com.tencent.qidian.controller.a
        protected void k(boolean z16, HashMap<String, Object> hashMap) {
            String str;
            String valueOf;
            int i3;
            try {
                QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) MessengerService.this).app;
                if (qQAppInterface != null) {
                    qQAppInterface.removeObserver(this);
                    if (z16 && hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("sigmsg") && hashMap.containsKey(CloudStorageServlet.REQUEST_TYPE) && hashMap.containsKey("uin")) {
                        byte[] bArr = (byte[]) hashMap.get("sigmsg");
                        String valueOf2 = String.valueOf(hashMap.get(CloudStorageServlet.REQUEST_TYPE));
                        String valueOf3 = String.valueOf(hashMap.get("uin"));
                        if (bArr != null) {
                            qQAppInterface.getMsgCache().h(valueOf3, bArr);
                        }
                        int m3 = CrmUtils.m(qQAppInterface, valueOf3);
                        if (m3 == 0) {
                            valueOf = ac.G(qQAppInterface, valueOf3);
                        } else {
                            if (!hashMap.containsKey("nickname")) {
                                str = "";
                                if (m3 == 1024 && m3 != 1025) {
                                    i3 = r.s(m3, false, 1);
                                } else {
                                    i3 = m3;
                                }
                                ChatActivityUtils.j0(qQAppInterface, qQAppInterface.getApp(), i3, valueOf3, str, "", valueOf2.equals("audio"), null, true, true, null, "from_internal", null);
                            }
                            valueOf = String.valueOf(hashMap.get("nickname"));
                        }
                        str = valueOf;
                        if (m3 == 1024) {
                        }
                        i3 = m3;
                        ChatActivityUtils.j0(qQAppInterface, qQAppInterface.getApp(), i3, valueOf3, str, "", valueOf2.equals("audio"), null, true, true, null, "from_internal", null);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MessengerService", 2, "onGetSigmsg ", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c extends EmoticonPackageDownloadListener {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
            int i16;
            if (MessengerService.this.f204464d != null) {
                try {
                    Message obtain = Message.obtain((Handler) null, 5);
                    int intValue = Integer.valueOf(emoticonPackage.epId).intValue();
                    if (i3 == 0) {
                        i16 = 0;
                    } else if (i3 == 11007) {
                        i16 = 2;
                    } else if (i3 == 11001) {
                        i16 = 1;
                    } else if (i3 == 11000) {
                        i16 = 6;
                    } else {
                        i16 = -1;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("packetid", intValue);
                    bundle.putInt("peoriodtype", 1);
                    bundle.putInt("resultcode", i16);
                    obtain.setData(bundle);
                    MessengerService.this.f204464d.send(obtain);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.emoji.web.MessengerService", 2, "resp to sever: ");
                    }
                } catch (RemoteException | Exception unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements EmojiStickerManager.d {
        d() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmojiStickerManager.d
        public void onResult(boolean z16) {
            if (MessengerService.this.f204464d != null) {
                EmojiStickerManager.k().f(MessengerService.this.f204464d, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class e extends ag {
        e() {
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            int i3;
            String str;
            if (MessengerService.this.J != null) {
                Bundle bundle = new Bundle();
                bundle.putString("url", null);
                if (teamWorkFileImportInfo != null) {
                    i3 = teamWorkFileImportInfo.T;
                } else {
                    i3 = 0;
                }
                bundle.putInt("retCode", i3);
                String str2 = "";
                if (teamWorkFileImportInfo == null) {
                    str = "";
                } else {
                    str = teamWorkFileImportInfo.U;
                }
                bundle.putString("errorStr", str);
                if (teamWorkFileImportInfo != null) {
                    str2 = teamWorkFileImportInfo.V;
                }
                bundle.putString("redirectUrl", str2);
                MessengerService.this.J.putBundle("response", bundle);
                MessengerService messengerService = MessengerService.this;
                messengerService.J(messengerService.J);
                MessengerService.this.J = null;
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
            }
            if (MessengerService.this.J != null) {
                Bundle bundle = new Bundle();
                bundle.putString("url", MessengerService.N(str));
                if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.J == 10) {
                    bundle.putBoolean("needRefresh", true);
                }
                MessengerService.this.J.putBundle("response", bundle);
                MessengerService messengerService = MessengerService.this;
                messengerService.J(messengerService.J);
                MessengerService.this.J = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class f extends VipFunCallObserver {
        f() {
        }

        @Override // com.tencent.mobileqq.vas.vipav.VipFunCallObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            try {
                Bundle bundle = (Bundle) obj;
                if (bundle == null) {
                    QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver.onUpdate dataBundle=null");
                    return;
                }
                int i16 = bundle.getInt("result", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.emoji.web.MessengerService", 2, "fcObserver.onUpdate ret=" + i16 + ", type=" + i3 + ", isSuccess=" + z16);
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Error type=" + i3);
                                }
                            }
                        }
                        if (MessengerService.this.f204464d != null) {
                            Message obtain = Message.obtain((Handler) null, 5);
                            obtain.setData(bundle);
                            MessengerService.this.f204464d.send(obtain);
                        }
                    }
                } else if (MessengerService.this.f204464d != null) {
                    Message obtain2 = Message.obtain((Handler) null, 5);
                    bundle.putInt("srcType", 7);
                    obtain2.setData(bundle);
                    MessengerService.this.f204464d.send(obtain2);
                }
                QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) MessengerService.this).app;
                if (qQAppInterface == null) {
                    return;
                }
                qQAppInterface.removeObserver(this);
            } catch (Exception e16) {
                QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Err:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class g extends com.tencent.mobileqq.vip.k {
        g() {
        }

        @Override // com.tencent.mobileqq.vip.k
        public void a(long j3, int i3, Bundle bundle) {
            if (MessengerService.this.f204464d != null) {
                try {
                    Message obtain = Message.obtain((Handler) null, 5);
                    bundle.putInt("type", 2);
                    bundle.putInt("id", (int) j3);
                    bundle.putInt("result", i3);
                    obtain.setData(bundle);
                    MessengerService.this.f204464d.send(obtain);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.emoji.web.MessengerService", 2, e16.getMessage());
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.vip.k
        public void b(Bundle bundle) {
            if (MessengerService.this.f204464d != null) {
                Message obtain = Message.obtain((Handler) null, 5);
                obtain.setData(bundle);
                try {
                    MessengerService.this.f204464d.send(obtain);
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.emoji.web.MessengerService", 2, e16.getMessage());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class h extends CardObserver {
        h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005a  */
        @Override // com.tencent.mobileqq.app.CardObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSetCardTemplateReturn(boolean z16, Object obj) {
            int i3;
            String str;
            String str2 = "";
            int i16 = 0;
            if (z16 && obj != null) {
                if (obj instanceof Card) {
                    str = "";
                    i3 = 0;
                } else if (obj instanceof Pair) {
                    Pair pair = (Pair) obj;
                    i16 = ((Integer) pair.first).intValue();
                    Object obj2 = pair.second;
                    str2 = ((SSummaryCardRsp) obj2).emsg;
                    i3 = ((SSummaryCardRsp) obj2).payType;
                    str = ((SSummaryCardRsp) obj2).aid;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i16);
                }
                if (MessengerService.this.J == null) {
                    Bundle bundle = new Bundle();
                    MessengerService.this.J.putString("cmd", "card_setSummaryCard");
                    bundle.putInt("result", i16);
                    bundle.putString("message", str2);
                    if (TextUtils.isEmpty(str)) {
                        bundle.putString("aid", str);
                    }
                    bundle.putInt("payType", i3);
                    MessengerService.this.J.putBundle("response", bundle);
                    MessengerService messengerService = MessengerService.this;
                    messengerService.J(messengerService.J);
                    MessengerService.this.J = null;
                    return;
                }
                return;
            }
            QLog.e("Q.emoji.web.MessengerService", 1, "onSetCardTemplateReturn fail isSuccess = " + z16 + "obj = " + obj);
            i3 = 0;
            i16 = -1;
            str = "";
            if (QLog.isColorLevel()) {
            }
            if (MessengerService.this.J == null) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class i extends ProfileCardObserver {
        i() {
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            int i3;
            long j3;
            List<Bundle> list;
            int i16;
            if (QLog.isColorLevel()) {
                QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
            }
            long j16 = 0;
            if (z16 && obj != null && (obj instanceof Card)) {
                Card card = (Card) obj;
                QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) MessengerService.this).app;
                if (qQAppInterface != null && Utils.p(qQAppInterface.getCurrentAccountUin(), card.uin) && ((i16 = card.templateRet) == 0 || i16 == 101107 || i16 == 101108)) {
                    j16 = card.lCurrentBgId;
                    j3 = card.lCurrentStyleId;
                    if (ProfileTemplateApi.isDiyTemplateStyleID(j3)) {
                        j16 = card.cardId;
                    }
                    i3 = 0;
                    Bundle bundle = new Bundle();
                    bundle.putLong("currentId", j16);
                    bundle.putLong("styleId", j3);
                    bundle.putInt("result", i3);
                    list = MessengerService.this.I;
                    if (list == null && list.size() > 0) {
                        Bundle remove = MessengerService.this.I.remove(0);
                        remove.putBundle("response", bundle);
                        MessengerService.this.J(remove);
                        return;
                    }
                }
            } else {
                QLog.e("Q.emoji.web.MessengerService", 1, "onCardDownload fail isSuccess = " + z16 + "data = " + obj);
            }
            i3 = -1;
            j3 = 0;
            Bundle bundle2 = new Bundle();
            bundle2.putLong("currentId", j16);
            bundle2.putLong("styleId", j3);
            bundle2.putInt("result", i3);
            list = MessengerService.this.I;
            if (list == null) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class j extends VipSpecialCareHandler {
        j() {
        }

        @Override // com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler
        public void i(Bundle bundle) {
            MessengerService.this.J(bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class k extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<MessengerService> f204547a;

        /* renamed from: b, reason: collision with root package name */
        protected Bundle f204548b;

        public k(MessengerService messengerService) {
            this.f204547a = new WeakReference<>(messengerService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<MessengerService> weakReference = this.f204547a;
            if (weakReference == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessengerService$QWalletOpenMsgHandler", 2, "handleMessage, mServiceWeakRef null");
                    return;
                }
                return;
            }
            MessengerService messengerService = weakReference.get();
            if (messengerService == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessengerService$QWalletOpenMsgHandler", 2, "handleMessage, service null");
                    return;
                }
                return;
            }
            int i3 = message.what;
            if (i3 != 4) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("qwallet.type", i3);
            boolean z16 = true;
            if (message.arg1 != 1) {
                z16 = false;
            }
            bundle.putBoolean("qwallet.isSuccess", z16);
            bundle.putSerializable("qwallet.data", (Serializable) message.obj);
            Bundle bundle2 = this.f204548b;
            if (bundle2 != null) {
                bundle2.putBundle("response", bundle);
                messengerService.J(this.f204548b);
            }
        }
    }

    public MessengerService() {
        k kVar = new k(this);
        this.G = kVar;
        this.H = new cl(kVar);
        this.I = Collections.synchronizedList(new ArrayList());
        this.J = null;
        this.K = new h();
        this.L = new i();
        this.M = new j();
        this.N = null;
        this.P = null;
        this.Q = new Handler(Looper.getMainLooper());
        this.R = new com.tencent.mobileqq.richstatus.h() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.9
            @Override // com.tencent.mobileqq.richstatus.h
            public void onChangeStatus(int i3, RichStatus richStatus, Object obj) {
                Bundle bundle = MessengerService.this.N;
                if (bundle != null) {
                    bundle.putString("cmd", "ipc_signature_setordelete");
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("result", i3);
                    bundle2.putBoolean("hasTipsInfo", false);
                    if (obj instanceof TipsInfo) {
                        TipsInfo tipsInfo = (TipsInfo) obj;
                        if (tipsInfo.type > 0) {
                            bundle2.putInt("result", tipsInfo.ret);
                            bundle2.putBoolean("hasTipsInfo", true);
                            bundle2.putInt("tips_type", tipsInfo.type);
                            bundle2.putString("tips_titleWording", tipsInfo.titleWording);
                            bundle2.putString("tips_wording", tipsInfo.wording);
                            bundle2.putString("tips_rightBtnWording", tipsInfo.rightBtnWording);
                            bundle2.putString("tips_leftBtnWording", tipsInfo.leftBtnWording);
                            bundle2.putString("tips_vipType", tipsInfo.vipType);
                            bundle2.putInt("tips_vipMonth", tipsInfo.vipMonth);
                            bundle2.putString("tips_url", tipsInfo.url);
                        }
                    }
                    MessengerService.this.N.putBundle("response", bundle2);
                    MessengerService messengerService = MessengerService.this;
                    messengerService.J(messengerService.N);
                    MessengerService.this.N = null;
                }
            }

            @Override // com.tencent.mobileqq.richstatus.h
            public void onGetSyncShuoShuo(int i3, boolean z16) {
                if (i3 == -1) {
                    Handler handler = MessengerService.this.Q;
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) MessengerService.this).app;
                                if (((AppService) MessengerService.this).app == null) {
                                    QLog.e("Q.emoji.web.MessengerService", 1, "onGetSyncShuoShuo toast error, app is null!");
                                } else {
                                    QQToast.makeText(qQAppInterface.getApplication(), HardCodeUtil.qqStr(R.string.o3v), 0).show(qQAppInterface.getApp().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (MessengerService.this.P != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SigImg2Zone", 4, "isSync: " + z16);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isSync", z16);
                    MessengerService.this.P.putBundle("response", bundle);
                    MessengerService messengerService = MessengerService.this;
                    messengerService.J(messengerService.P);
                    MessengerService.this.P = null;
                }
            }

            @Override // com.tencent.mobileqq.richstatus.h
            public void onSetSyncShuoShuo(int i3, boolean z16) {
            }
        };
        this.S = new a();
        this.T = new b();
        this.U = null;
    }

    public static Bundle F(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "[delGameSession]");
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).delGameSession(str);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        return bundle;
    }

    static void G(MessengerService messengerService) {
        MqqHandler handler;
        if (messengerService != null) {
            AppRuntime appRuntime = messengerService.app;
            if ((appRuntime instanceof QQAppInterface) && (handler = ((QQAppInterface) appRuntime).getHandler(Conversation.class)) != null) {
                handler.sendMessage(handler.obtainMessage(Conversation.MSG_BROWSER_BAR_HIDE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (this.app == null) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime == null) {
                QLog.d("Q.emoji.web.MessengerService", 1, "onCreate appRuntime is null!");
                return;
            }
            this.app = runtime.getAppRuntime(getModuleId());
        }
        K();
    }

    private void K() {
        AppRuntime appRuntime = this.app;
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            ((QQAppInterface) appRuntime).addObserver(this.M);
        } else if (appRuntime == null) {
            I("-->app is null");
        } else {
            I("-->app is not qqappinterface");
        }
    }

    public static Bundle L(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) qQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        iGameMsgManagerService.onGameSwitchChange(str, i3, i16);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        iGameMsgManagerService.notifySessionChangedBySwitch();
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String N(String str) {
        if (str == null) {
            return "";
        }
        if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
            return str + "&adtag=s_qq_file_inviteedit";
        }
        return str + "?adtag=s_qq_file_inviteedit";
    }

    void I(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, str);
        }
    }

    public void J(Bundle bundle) {
        if (this.f204464d != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 4);
                obtain.setData(bundle);
                this.f204464d.send(obtain);
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    void M(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this, (Class<?>) VipProfileCardPhotoHandlerActivity.class);
            intent.setFlags(268435456);
            if (str.equals("selectPhoto")) {
                intent.putExtra("action", "select_photo");
            } else if (str.equals("takePhoto")) {
                intent.putExtra("action", "take_photo");
            }
            startActivity(intent);
        }
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
        }
        Messenger messenger = this.f204467h;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppService
    public int onConfigRuntime() {
        if (this.f204468i) {
            return 1;
        }
        return super.onConfigRuntime();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService oncreate");
        }
        try {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emosm_web_config_runtime_aysnc_116046753", true);
            this.f204468i = isSwitchOn;
            QLog.d("Q.emoji.web.MessengerService", 1, "MessengerService onCreate mConfigRuntimeAsync=", Boolean.valueOf(isSwitchOn));
            super.onCreate();
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("Vas_MessengerServiceWorkerThread", -2);
            this.f204465e = newFreeHandlerThread;
            newFreeHandlerThread.start();
            this.f204466f = new IncomingHandler(this.f204465e.getLooper(), this);
            this.f204467h = new Messenger(this.f204466f);
            if (onConfigRuntime() == 1) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    this.app = peekAppRuntime.getAppRuntime(getModuleId());
                    K();
                    return;
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            MessengerService.this.H();
                        }
                    }, 16, null, false);
                    return;
                }
            }
            K();
        } catch (OutOfMemoryError e16) {
            QLog.e("MessengerService", 1, "onCreate OutOfMemoryError " + e16);
        } catch (Throwable th5) {
            QLog.e("Q.emoji.web.MessengerService", 1, "onCreate error! " + QLog.getStackTraceString(th5));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        StatusManager statusManager;
        if (this.f204466f != null) {
            AppRuntime appRuntime = this.app;
            if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
                if (iVasQuickUpdateService != null) {
                    iVasQuickUpdateService.removeCallBacker(this.f204466f.f204472a);
                }
            }
            this.f204466f.getLooper().quit();
            this.f204466f = null;
        }
        if (this.f204465e != null) {
            this.f204465e = null;
        }
        this.f204464d = null;
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
        }
        AppRuntime appRuntime2 = this.app;
        if (appRuntime2 != null && (appRuntime2 instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime2;
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) qQAppInterface.getRuntimeService(IEmojiManagerService.class);
            if (iEmojiManagerService != null) {
                iEmojiManagerService.getEmojiListenerManager().removeEmoticonPackageDownloadListener(this.f204469m);
            }
            cl clVar = this.H;
            if (clVar != null) {
                clVar.a();
                qQAppInterface.removeObserver(this.H);
                this.H = null;
            }
            this.G = null;
            CardObserver cardObserver = this.K;
            if (cardObserver != null) {
                qQAppInterface.removeObserver(cardObserver);
                this.K = null;
            }
            ProfileCardObserver profileCardObserver = this.L;
            if (profileCardObserver != null) {
                qQAppInterface.removeObserver(profileCardObserver);
                this.L = null;
            }
            VipFunCallObserver vipFunCallObserver = this.E;
            if (vipFunCallObserver != null) {
                qQAppInterface.removeObserver(vipFunCallObserver);
                this.E = null;
            }
            ag agVar = this.D;
            if (agVar != null) {
                qQAppInterface.removeObserver(agVar);
                this.D = null;
            }
            ((QQAppInterface) this.app).removeObserver(this.M);
            this.M.h();
            ar arVar = this.S;
            if (arVar != null) {
                qQAppInterface.removeObserver(arVar);
                this.S = null;
            }
            if (this.R != null && (statusManager = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)) != null) {
                statusManager.b0(this.R);
                this.R = null;
            }
            Handler handler = this.Q;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.Q = null;
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onUnbind");
        }
        return super.onUnbind(intent);
    }

    @TargetApi(11)
    static void E(MessengerService messengerService) {
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class IncomingHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        CallBacker f204472a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<MessengerService> f204473b;

        /* renamed from: c, reason: collision with root package name */
        private IBinder.DeathRecipient f204474c;

        /* renamed from: d, reason: collision with root package name */
        XhsShareHelper.e f204475d;

        /* renamed from: e, reason: collision with root package name */
        ThemeDiyStyleLogic.StyleCallBack f204476e;

        /* renamed from: f, reason: collision with root package name */
        com.tencent.mobileqq.profile.like.a f204477f;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a extends CallBacker {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MessengerService f204492a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f204493b;

            a(MessengerService messengerService, QQAppInterface qQAppInterface) {
                this.f204492a = messengerService;
                this.f204493b = qQAppInterface;
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
            public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
                if (j3 == 15 && VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                    if (this.f204492a.J != null) {
                        Bundle bundle = new Bundle();
                        this.f204492a.J.putString("cmd", "card_download_wzry_template");
                        bundle.putInt("result", i3);
                        bundle.putString("message", str3);
                        this.f204492a.J.putBundle("response", bundle);
                        MessengerService messengerService = this.f204492a;
                        messengerService.J(messengerService.J);
                        this.f204492a.J = null;
                    }
                    IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) this.f204493b.getRuntimeService(IVasQuickUpdateService.class, "");
                    if (iVasQuickUpdateService != null) {
                        iVasQuickUpdateService.removeCallBacker(this);
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class b extends com.tencent.mobileqq.loginregister.servlet.h {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f204495d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f204496e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ MessengerService f204497f;

            b(Bundle bundle, Bundle bundle2, MessengerService messengerService) {
                this.f204495d = bundle;
                this.f204496e = bundle2;
                this.f204497f = messengerService;
            }

            @Override // com.tencent.mobileqq.loginregister.servlet.h
            public void c(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
                boolean z16;
                if (i3 == 0 && devlockInfo != null) {
                    Bundle bundle = this.f204495d;
                    boolean z17 = false;
                    if (devlockInfo.AllowSet == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bundle.putBoolean(MessageRoamJsPlugin.SECURITYPHONENUMBER, z16);
                    Bundle bundle2 = this.f204495d;
                    if (devlockInfo.DevSetup == 1) {
                        z17 = true;
                    }
                    bundle2.putBoolean(MessageRoamJsPlugin.DEVLOCKISOPEN, z17);
                }
                this.f204496e.putBundle("response", this.f204495d);
                this.f204497f.J(this.f204496e);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class d implements IDownLoadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IFontManagerService f204501a;

            d(IFontManagerService iFontManagerService) {
                this.f204501a = iFontManagerService;
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                this.f204501a.onSoDownloadCompleted(1, updateListenerParams.mErrorCode);
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                this.f204501a.onSoDownloadCompleted(1, 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class e extends CallBacker {
            e() {
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
            public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
                Bundle bundle;
                MessengerService messengerService = IncomingHandler.this.f204473b.get();
                if (messengerService != null && j3 == 15 && str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                    Bundle bundle2 = new Bundle();
                    if (IncomingHandler.this.f204473b.get() != null && (bundle = messengerService.U) != null) {
                        bundle.putString("cmd", "card_download");
                        bundle2.putInt("result", i3);
                        bundle2.putString("message", str3);
                        messengerService.U.putBundle("response", bundle2);
                        messengerService.J(messengerService.U);
                        messengerService.U = null;
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class f implements MiniAppLaunchListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f204504a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessengerService f204505b;

            f(Bundle bundle, MessengerService messengerService) {
                this.f204504a = bundle;
                this.f204505b = messengerService;
            }

            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                if (bundle != null) {
                    Bundle bundle2 = new Bundle();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ret", bundle.getLong("retCode", 0L));
                        if (!z16) {
                            jSONObject.put("msg", bundle.getString("errMsg"));
                        }
                        bundle2.putString("result", jSONObject.toString());
                        this.f204504a.putBundle("response", bundle2);
                        this.f204505b.J(this.f204504a);
                    } catch (Throwable th5) {
                        QLog.e("launchMiniAppById", 1, "launchMiniAppById error,", th5);
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class g extends IPublicAccountObserver.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f204507a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessengerService f204508b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f204509c;

            g(Bundle bundle, MessengerService messengerService, boolean z16) {
                this.f204507a = bundle;
                this.f204508b = messengerService;
                this.f204509c = z16;
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onFollowPublicAccount(boolean z16, String str) {
                int i3;
                super.onFollowPublicAccount(z16, str);
                try {
                    Bundle bundle = new Bundle();
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    bundle.putInt("retCode", i3);
                    this.f204507a.putBundle("response", bundle);
                    this.f204508b.J(this.f204507a);
                    if (QLog.isColorLevel()) {
                        QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW success! isFollow: " + this.f204509c + "  uin: " + str);
                    }
                    Intent intent = new Intent("com.tencent.mobileqq.PublicAccountObserver");
                    intent.putExtra("action", "follow");
                    intent.putExtra("isSuccess", z16);
                    intent.putExtra("uin", str);
                    this.f204508b.getApplicationContext().sendBroadcast(intent);
                    SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, str));
                } catch (Throwable th5) {
                    QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(th5));
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
            public void onUnfollowPublicAccount(boolean z16, String str) {
                int i3;
                super.onUnfollowPublicAccount(z16, str);
                try {
                    Bundle bundle = new Bundle();
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    bundle.putInt("retCode", i3);
                    this.f204507a.putBundle("response", bundle);
                    this.f204508b.J(this.f204507a);
                    if (QLog.isColorLevel()) {
                        QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! isFollow: " + this.f204509c + "  uin: " + str);
                    }
                    Intent intent = new Intent("com.tencent.mobileqq.PublicAccountObserver");
                    intent.putExtra("action", "unFollow");
                    intent.putExtra("isSuccess", z16);
                    intent.putExtra("uin", str);
                    this.f204508b.getApplicationContext().sendBroadcast(intent);
                    SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, str));
                } catch (Throwable th5) {
                    QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(th5));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class h implements OnDeleteReminderFailListener {
            h() {
            }

            @Override // com.tencent.mobileqq.reminder.OnDeleteReminderFailListener
            public void onReminderDeleteFail() {
                QLog.i("MessengerService$IncomingHandler", 2, "@qqnotify delete faield ");
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class i implements XhsShareHelper.e {
            i() {
            }

            @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
            public void onError(@NonNull String str, int i3, @NonNull String str2, Throwable th5) {
                QLog.i("Q.emoji.web.MessengerService", 1, "shareToXhs onError. sessionId = " + str + " errorCode = " + i3 + " errorMessage = " + str2);
            }

            @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
            public void onSuccess(String str) {
                QLog.i("Q.emoji.web.MessengerService", 1, "shareToXhs success. sessionId = " + str);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class j implements ThemeDiyStyleLogic.StyleCallBack {
            j() {
            }

            @Override // com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack
            public int callback(int i3, int i16, Bundle bundle, ResData resData) {
                int i17;
                MessengerService messengerService = IncomingHandler.this.f204473b.get();
                if (messengerService != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("themeId", bundle.getString("themeId"));
                    if (i16 == 4) {
                        i17 = 0;
                    } else {
                        i17 = -2;
                    }
                    bundle2.putInt(ThemeConstants.THEME_STATUS, i17);
                    bundle.putBundle("response", bundle2);
                    messengerService.J(bundle);
                    return 1;
                }
                return 1;
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class k implements com.tencent.mobileqq.profile.like.a {
            k() {
            }

            @Override // com.tencent.mobileqq.profile.like.a
            public void a(int i3, int i16, String str, Bundle bundle) {
                MessengerService messengerService = IncomingHandler.this.f204473b.get();
                if (messengerService != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("id", i16);
                    bundle2.putInt("code", i3);
                    bundle2.putString("url", str);
                    bundle.putBundle("response", bundle2);
                    messengerService.J(bundle);
                    if (i3 == 0 && ((AppService) messengerService).app != null && (((AppService) messengerService).app instanceof QQAppInterface)) {
                        ((PraiseManager) ((QQAppInterface) ((AppService) messengerService).app).getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).g(i16, true, "from_praise_mall");
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class l implements IBinder.DeathRecipient {
            l() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                MessengerService messengerService;
                Messenger messenger;
                if (QLog.isColorLevel()) {
                    QLog.d("MessengerService$IncomingHandler", 2, "-->binder died");
                    WeakReference<MessengerService> weakReference = IncomingHandler.this.f204473b;
                    if (weakReference != null && weakReference.get() != null) {
                        MessengerService.G(IncomingHandler.this.f204473b.get());
                        MessengerService.E(IncomingHandler.this.f204473b.get());
                    }
                }
                WeakReference<MessengerService> weakReference2 = IncomingHandler.this.f204473b;
                if (weakReference2 != null && (messengerService = weakReference2.get()) != null && (messenger = messengerService.f204464d) != null) {
                    try {
                        messenger.getBinder().unlinkToDeath(IncomingHandler.this.f204474c, 0);
                    } catch (Exception e16) {
                        QLog.d("MessengerService$IncomingHandler", 1, "-->binder died unlink to death error=" + e16.toString());
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class m implements com.tencent.mobileqq.gamecenter.api.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f204516a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessengerService f204517b;

            m(Bundle bundle, MessengerService messengerService) {
                this.f204516a = bundle;
                this.f204517b = messengerService;
            }

            @Override // com.tencent.mobileqq.gamecenter.api.a
            public void a(int i3) {
                Bundle bundle = new Bundle();
                bundle.putInt("result", i3);
                this.f204516a.putBundle("response", bundle);
                this.f204517b.J(this.f204516a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class n implements com.tencent.mobileqq.gamecenter.api.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f204519a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessengerService f204520b;

            n(Bundle bundle, MessengerService messengerService) {
                this.f204519a = bundle;
                this.f204520b = messengerService;
            }

            @Override // com.tencent.mobileqq.gamecenter.api.a
            public void a(int i3) {
                Bundle bundle = new Bundle();
                bundle.putInt("result", i3);
                this.f204519a.putBundle("response", bundle);
                this.f204520b.J(this.f204519a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class o implements hx3.c<NTVasSimpleInfo> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f204522a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessengerService f204523b;

            o(Bundle bundle, MessengerService messengerService) {
                this.f204522a = bundle;
                this.f204523b = messengerService;
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<NTVasSimpleInfo> eVar) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("updateResult", true);
                this.f204522a.putBundle("response", bundle);
                this.f204523b.J(this.f204522a);
                VasWebviewUtil.reportVasStatus("AvatarPendant", "ChangeHead", "0", 0, 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class p implements BusinessObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f204525d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MessengerService f204526e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f204527f;

            p(Bundle bundle, MessengerService messengerService, Bundle bundle2) {
                this.f204525d = bundle;
                this.f204526e = messengerService;
                this.f204527f = bundle2;
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                if (z16 && obj != null) {
                    try {
                        if (obj instanceof List) {
                            List list = (List) obj;
                            if (!list.isEmpty()) {
                                this.f204525d.putString("diyText", ((BubbleDiyEntity) list.get(0)).diyText);
                                this.f204525d.putString("isDiy", "1");
                                this.f204525d.putString("tl", ((BubbleDiyEntity) list.get(0)).topLeftId);
                                this.f204525d.putString(ReportConstant.COSTREPORT_TRANS, ((BubbleDiyEntity) list.get(0)).topRightId);
                                this.f204525d.putString("bl", ((BubbleDiyEntity) list.get(0)).bottomLeftId);
                                this.f204525d.putString(TtmlNode.TAG_BR, ((BubbleDiyEntity) list.get(0)).bottomRightId);
                            }
                            this.f204526e.J(this.f204527f);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Q.emoji.web.MessengerService", 2, e16.getMessage());
                            return;
                        }
                        return;
                    }
                }
                this.f204525d.putString("diyText", "");
                this.f204526e.J(this.f204527f);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class q implements VasManager.CompleteListener<com.tencent.mobileqq.floatscr.a> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f204529d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ISVIPHandler f204530e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f204531f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Bundle f204532h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ MessengerService f204533i;

            q(int i3, ISVIPHandler iSVIPHandler, QQAppInterface qQAppInterface, Bundle bundle, MessengerService messengerService) {
                this.f204529d = i3;
                this.f204530e = iSVIPHandler;
                this.f204531f = qQAppInterface;
                this.f204532h = bundle;
                this.f204533i = messengerService;
            }

            @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onComplete(com.tencent.mobileqq.floatscr.a aVar, Object obj) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", this.f204529d);
                if (aVar == null && this.f204529d != 0) {
                    VasMonitorDT.reportErrCode("individual_v2_colorscreen_set_fail", "id:" + this.f204529d);
                    bundle.putInt("result", 1);
                } else {
                    bundle.putInt("result", 0);
                    this.f204530e.setColorScreenId(this.f204531f.getCurrentAccountUin(), this.f204529d);
                }
                this.f204532h.putBundle("response", bundle);
                this.f204533i.J(this.f204532h);
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class r extends BroadcastReceiver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MessengerService f204535a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f204536b;

            r(MessengerService messengerService, Bundle bundle) {
                this.f204535a = messengerService;
                this.f204536b = bundle;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action) && TextUtils.equals(action, NewIntent.ACTION_DEVLOCK_ROAM)) {
                    Context applicationContext = this.f204535a.getApplicationContext();
                    if (applicationContext != null) {
                        applicationContext.unregisterReceiver(this);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.emoji.web.MessengerService", 2, "openDevLock unregisterReceiver context: " + applicationContext);
                    }
                    this.f204536b.putBundle("response", new Bundle(intent.getExtras()));
                    this.f204535a.J(this.f204536b);
                }
            }
        }

        public IncomingHandler(Looper looper, MessengerService messengerService) {
            super(looper);
            this.f204472a = new e();
            this.f204474c = new l();
            this.f204475d = new i();
            this.f204476e = new j();
            this.f204477f = new k();
            this.f204473b = new WeakReference<>(messengerService);
        }

        private void c(Bundle bundle) {
            if (bundle == null) {
                QLog.i("Q.emoji.web.MessengerService", 1, "handleShareToXhs bundle null.");
                return;
            }
            String string = bundle.getString(QZoneSharePictureJsPlugin.SHARE_TO_XHS_FILE_PATH, "");
            if (TextUtils.isEmpty(string)) {
                QLog.i("Q.emoji.web.MessengerService", 1, "handleShareToXhs filePath empty.");
                return;
            }
            XhsShareHelper xhsShareHelper = new XhsShareHelper();
            XhsShareHelper.c cVar = new XhsShareHelper.c(null, null, string);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            xhsShareHelper.m("QQ_SHARE_TO_XHS_PIC", new mqq.util.WeakReference<>(BaseApplication.getContext()), new XhsShareHelper.b("", "", arrayList), new mqq.util.WeakReference<>(this.f204475d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Bundle bundle, MessengerService messengerService, String str) {
            bundle.putString("share_robot_card_ark_info", str);
            messengerService.J(bundle);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:795:0x178f. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:796:0x1792. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:1237:0x2928 A[Catch: all -> 0x2939, TryCatch #12 {all -> 0x2939, blocks: (B:1247:0x28fa, B:1249:0x2903, B:1250:0x2906, B:1252:0x290f, B:1235:0x291e, B:1237:0x2928, B:1238:0x292b, B:1240:0x2934, B:1296:0x287e, B:1298:0x2883), top: B:1196:0x25ff }] */
        /* JADX WARN: Removed duplicated region for block: B:1240:0x2934 A[Catch: all -> 0x2939, TRY_LEAVE, TryCatch #12 {all -> 0x2939, blocks: (B:1247:0x28fa, B:1249:0x2903, B:1250:0x2906, B:1252:0x290f, B:1235:0x291e, B:1237:0x2928, B:1238:0x292b, B:1240:0x2934, B:1296:0x287e, B:1298:0x2883), top: B:1196:0x25ff }] */
        /* JADX WARN: Removed duplicated region for block: B:1249:0x2903 A[Catch: all -> 0x2939, TryCatch #12 {all -> 0x2939, blocks: (B:1247:0x28fa, B:1249:0x2903, B:1250:0x2906, B:1252:0x290f, B:1235:0x291e, B:1237:0x2928, B:1238:0x292b, B:1240:0x2934, B:1296:0x287e, B:1298:0x2883), top: B:1196:0x25ff }] */
        /* JADX WARN: Removed duplicated region for block: B:1252:0x290f A[Catch: all -> 0x2939, TryCatch #12 {all -> 0x2939, blocks: (B:1247:0x28fa, B:1249:0x2903, B:1250:0x2906, B:1252:0x290f, B:1235:0x291e, B:1237:0x2928, B:1238:0x292b, B:1240:0x2934, B:1296:0x287e, B:1298:0x2883), top: B:1196:0x25ff }] */
        /* JADX WARN: Removed duplicated region for block: B:153:0x07de  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x087b  */
        /* JADX WARN: Removed duplicated region for block: B:178:0x087d  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x0817  */
        /* JADX WARN: Removed duplicated region for block: B:304:0x0592 A[Catch: OutOfMemoryError -> 0x07c2, IOException -> 0x07c5, all -> 0x0944, TryCatch #16 {all -> 0x0944, blocks: (B:105:0x0339, B:107:0x0347, B:109:0x034d, B:111:0x0353, B:113:0x035b, B:115:0x0372, B:117:0x037c, B:119:0x0386, B:121:0x0392, B:123:0x0398, B:125:0x03a8, B:128:0x03ba, B:130:0x03c0, B:392:0x03d5, B:394:0x040c, B:151:0x07d8, B:155:0x07e0, B:158:0x07ea, B:161:0x0844, B:164:0x087e, B:167:0x089c, B:177:0x08eb, B:174:0x092c, B:173:0x090e, B:195:0x081b, B:197:0x0823, B:198:0x082a, B:203:0x0834, B:204:0x083d, B:133:0x0443, B:261:0x0447, B:263:0x0452, B:265:0x0460, B:268:0x0469, B:270:0x0474, B:271:0x0487, B:273:0x048e, B:274:0x0492, B:293:0x0545, B:294:0x0548, B:314:0x0588, B:304:0x0592, B:306:0x0597, B:307:0x059a, B:340:0x04b8, B:343:0x04c4, B:345:0x04c7, B:346:0x04cb, B:361:0x05a3, B:363:0x05af, B:365:0x05cf, B:367:0x05db, B:372:0x05ef, B:374:0x0612, B:375:0x061a, B:377:0x0620, B:378:0x062e, B:380:0x0636, B:383:0x0647, B:384:0x064f, B:136:0x0678, B:138:0x067c, B:140:0x06ab, B:142:0x06b1, B:144:0x06b7, B:146:0x06bd, B:147:0x06c6, B:213:0x06e7, B:215:0x06ed, B:216:0x06f7, B:218:0x06fd, B:220:0x0705, B:224:0x0710, B:227:0x072d, B:228:0x0736, B:231:0x076e, B:234:0x0776, B:238:0x0788, B:240:0x0792, B:242:0x07a0, B:252:0x0729, B:422:0x0961, B:424:0x098a, B:426:0x0990, B:428:0x099d, B:429:0x09c1, B:432:0x09f6, B:433:0x09de, B:436:0x09e9, B:443:0x0a0f, B:446:0x0a42, B:448:0x0a4f, B:453:0x0a72, B:455:0x0a99, B:457:0x0a9f, B:458:0x0ac2, B:462:0x0ade, B:463:0x0ae7, B:465:0x0aed, B:466:0x0af0, B:471:0x0b01, B:473:0x0b13, B:474:0x0b3a, B:477:0x0b4b, B:479:0x0b6e, B:480:0x0b98, B:489:0x0bbb, B:494:0x0bee, B:498:0x0c17, B:500:0x0c4b, B:501:0x0c4e, B:627:0x1113, B:654:0x1211, B:655:0x122d, B:657:0x1233, B:658:0x1249, B:672:0x1265, B:675:0x1289, B:678:0x12c7, B:681:0x12da, B:684:0x12f1, B:686:0x1306, B:687:0x1327, B:689:0x1331, B:693:0x1344, B:696:0x1361, B:700:0x1391, B:703:0x13bf, B:705:0x1422, B:707:0x143c, B:709:0x1456, B:711:0x145f, B:713:0x147a, B:716:0x1484, B:718:0x148a, B:720:0x1490, B:721:0x14a4, B:723:0x14aa, B:727:0x1430, B:731:0x14e6, B:733:0x150e, B:735:0x1514, B:738:0x1537, B:740:0x153d, B:743:0x1553, B:745:0x1585, B:748:0x1590, B:750:0x1599, B:753:0x15b4, B:756:0x15bf, B:758:0x15c8, B:759:0x15d7, B:761:0x15e0, B:763:0x15f7, B:764:0x15fb, B:766:0x1601, B:767:0x162b, B:768:0x1631, B:771:0x1648, B:774:0x1694, B:776:0x16b4, B:777:0x1703, B:780:0x1724, B:782:0x173e, B:783:0x1762, B:787:0x1781, B:795:0x178f, B:796:0x1792, B:797:0x1795, B:799:0x179c, B:801:0x17a9, B:805:0x17c8, B:806:0x17e4, B:807:0x180b, B:810:0x1820, B:812:0x182b, B:813:0x1856, B:814:0x1866, B:815:0x1885, B:816:0x18a4, B:817:0x18c3, B:819:0x18c9, B:820:0x18da, B:823:0x18e8, B:825:0x18f3, B:826:0x18fc, B:1060:0x225d, B:1062:0x2263, B:1064:0x2270, B:1066:0x227e, B:1068:0x2286, B:1071:0x2296, B:1073:0x22a1, B:1076:0x22b1, B:1078:0x22b7, B:1081:0x22d8, B:1084:0x22f8, B:1087:0x230d, B:1089:0x2320, B:1094:0x2343, B:1097:0x235a, B:1099:0x2365, B:1102:0x2372, B:1104:0x238b, B:1105:0x239b, B:1106:0x2394, B:1110:0x23ac, B:1116:0x23bd, B:1117:0x23c1, B:1119:0x23c7, B:1112:0x23d3, B:1129:0x241d, B:1132:0x242b, B:1141:0x2475, B:1144:0x2484, B:1146:0x2492, B:1147:0x24bf, B:1149:0x24b5, B:1154:0x24dd, B:1166:0x2508, B:1169:0x255b, B:1172:0x256b, B:1175:0x2588, B:1178:0x25a5, B:1180:0x25ae, B:1181:0x25bc, B:1200:0x2604, B:1202:0x260e, B:1205:0x2620, B:1209:0x263e, B:1211:0x2644, B:1214:0x264e, B:1217:0x2657, B:1219:0x2663, B:1221:0x2673, B:1223:0x267d, B:1263:0x26f1, B:1267:0x2701, B:1269:0x275d, B:1271:0x2763, B:1273:0x276c, B:1277:0x2781, B:1278:0x278c, B:1280:0x2792, B:1285:0x2789, B:1313:0x27f0, B:1317:0x27f9, B:1319:0x27fe, B:1331:0x2811, B:1385:0x29b6, B:1387:0x29c0, B:1395:0x2a3d, B:1396:0x2a4c, B:1398:0x2a52, B:1401:0x2a63, B:1403:0x2a6b, B:1405:0x2a73, B:1407:0x2a7f, B:1408:0x2a82, B:1410:0x2a8a, B:1412:0x2a92, B:1413:0x2a97, B:1435:0x2ab8, B:1438:0x2ad7, B:1441:0x2ae4, B:1444:0x2aea, B:1447:0x2af2, B:1450:0x2aff, B:1452:0x2b1b, B:1455:0x2b23, B:1458:0x2b5a, B:1462:0x2b68, B:1478:0x2b98, B:1480:0x2b9e, B:1482:0x2bab, B:1484:0x2bbd, B:1488:0x2bcb, B:1491:0x2bd3, B:1494:0x2be4, B:1497:0x2be9, B:1513:0x2c40), top: B:102:0x0335, inners: #89 }] */
        /* JADX WARN: Removed duplicated region for block: B:306:0x0597 A[Catch: OutOfMemoryError -> 0x07c2, IOException -> 0x07c5, all -> 0x0944, TryCatch #16 {all -> 0x0944, blocks: (B:105:0x0339, B:107:0x0347, B:109:0x034d, B:111:0x0353, B:113:0x035b, B:115:0x0372, B:117:0x037c, B:119:0x0386, B:121:0x0392, B:123:0x0398, B:125:0x03a8, B:128:0x03ba, B:130:0x03c0, B:392:0x03d5, B:394:0x040c, B:151:0x07d8, B:155:0x07e0, B:158:0x07ea, B:161:0x0844, B:164:0x087e, B:167:0x089c, B:177:0x08eb, B:174:0x092c, B:173:0x090e, B:195:0x081b, B:197:0x0823, B:198:0x082a, B:203:0x0834, B:204:0x083d, B:133:0x0443, B:261:0x0447, B:263:0x0452, B:265:0x0460, B:268:0x0469, B:270:0x0474, B:271:0x0487, B:273:0x048e, B:274:0x0492, B:293:0x0545, B:294:0x0548, B:314:0x0588, B:304:0x0592, B:306:0x0597, B:307:0x059a, B:340:0x04b8, B:343:0x04c4, B:345:0x04c7, B:346:0x04cb, B:361:0x05a3, B:363:0x05af, B:365:0x05cf, B:367:0x05db, B:372:0x05ef, B:374:0x0612, B:375:0x061a, B:377:0x0620, B:378:0x062e, B:380:0x0636, B:383:0x0647, B:384:0x064f, B:136:0x0678, B:138:0x067c, B:140:0x06ab, B:142:0x06b1, B:144:0x06b7, B:146:0x06bd, B:147:0x06c6, B:213:0x06e7, B:215:0x06ed, B:216:0x06f7, B:218:0x06fd, B:220:0x0705, B:224:0x0710, B:227:0x072d, B:228:0x0736, B:231:0x076e, B:234:0x0776, B:238:0x0788, B:240:0x0792, B:242:0x07a0, B:252:0x0729, B:422:0x0961, B:424:0x098a, B:426:0x0990, B:428:0x099d, B:429:0x09c1, B:432:0x09f6, B:433:0x09de, B:436:0x09e9, B:443:0x0a0f, B:446:0x0a42, B:448:0x0a4f, B:453:0x0a72, B:455:0x0a99, B:457:0x0a9f, B:458:0x0ac2, B:462:0x0ade, B:463:0x0ae7, B:465:0x0aed, B:466:0x0af0, B:471:0x0b01, B:473:0x0b13, B:474:0x0b3a, B:477:0x0b4b, B:479:0x0b6e, B:480:0x0b98, B:489:0x0bbb, B:494:0x0bee, B:498:0x0c17, B:500:0x0c4b, B:501:0x0c4e, B:627:0x1113, B:654:0x1211, B:655:0x122d, B:657:0x1233, B:658:0x1249, B:672:0x1265, B:675:0x1289, B:678:0x12c7, B:681:0x12da, B:684:0x12f1, B:686:0x1306, B:687:0x1327, B:689:0x1331, B:693:0x1344, B:696:0x1361, B:700:0x1391, B:703:0x13bf, B:705:0x1422, B:707:0x143c, B:709:0x1456, B:711:0x145f, B:713:0x147a, B:716:0x1484, B:718:0x148a, B:720:0x1490, B:721:0x14a4, B:723:0x14aa, B:727:0x1430, B:731:0x14e6, B:733:0x150e, B:735:0x1514, B:738:0x1537, B:740:0x153d, B:743:0x1553, B:745:0x1585, B:748:0x1590, B:750:0x1599, B:753:0x15b4, B:756:0x15bf, B:758:0x15c8, B:759:0x15d7, B:761:0x15e0, B:763:0x15f7, B:764:0x15fb, B:766:0x1601, B:767:0x162b, B:768:0x1631, B:771:0x1648, B:774:0x1694, B:776:0x16b4, B:777:0x1703, B:780:0x1724, B:782:0x173e, B:783:0x1762, B:787:0x1781, B:795:0x178f, B:796:0x1792, B:797:0x1795, B:799:0x179c, B:801:0x17a9, B:805:0x17c8, B:806:0x17e4, B:807:0x180b, B:810:0x1820, B:812:0x182b, B:813:0x1856, B:814:0x1866, B:815:0x1885, B:816:0x18a4, B:817:0x18c3, B:819:0x18c9, B:820:0x18da, B:823:0x18e8, B:825:0x18f3, B:826:0x18fc, B:1060:0x225d, B:1062:0x2263, B:1064:0x2270, B:1066:0x227e, B:1068:0x2286, B:1071:0x2296, B:1073:0x22a1, B:1076:0x22b1, B:1078:0x22b7, B:1081:0x22d8, B:1084:0x22f8, B:1087:0x230d, B:1089:0x2320, B:1094:0x2343, B:1097:0x235a, B:1099:0x2365, B:1102:0x2372, B:1104:0x238b, B:1105:0x239b, B:1106:0x2394, B:1110:0x23ac, B:1116:0x23bd, B:1117:0x23c1, B:1119:0x23c7, B:1112:0x23d3, B:1129:0x241d, B:1132:0x242b, B:1141:0x2475, B:1144:0x2484, B:1146:0x2492, B:1147:0x24bf, B:1149:0x24b5, B:1154:0x24dd, B:1166:0x2508, B:1169:0x255b, B:1172:0x256b, B:1175:0x2588, B:1178:0x25a5, B:1180:0x25ae, B:1181:0x25bc, B:1200:0x2604, B:1202:0x260e, B:1205:0x2620, B:1209:0x263e, B:1211:0x2644, B:1214:0x264e, B:1217:0x2657, B:1219:0x2663, B:1221:0x2673, B:1223:0x267d, B:1263:0x26f1, B:1267:0x2701, B:1269:0x275d, B:1271:0x2763, B:1273:0x276c, B:1277:0x2781, B:1278:0x278c, B:1280:0x2792, B:1285:0x2789, B:1313:0x27f0, B:1317:0x27f9, B:1319:0x27fe, B:1331:0x2811, B:1385:0x29b6, B:1387:0x29c0, B:1395:0x2a3d, B:1396:0x2a4c, B:1398:0x2a52, B:1401:0x2a63, B:1403:0x2a6b, B:1405:0x2a73, B:1407:0x2a7f, B:1408:0x2a82, B:1410:0x2a8a, B:1412:0x2a92, B:1413:0x2a97, B:1435:0x2ab8, B:1438:0x2ad7, B:1441:0x2ae4, B:1444:0x2aea, B:1447:0x2af2, B:1450:0x2aff, B:1452:0x2b1b, B:1455:0x2b23, B:1458:0x2b5a, B:1462:0x2b68, B:1478:0x2b98, B:1480:0x2b9e, B:1482:0x2bab, B:1484:0x2bbd, B:1488:0x2bcb, B:1491:0x2bd3, B:1494:0x2be4, B:1497:0x2be9, B:1513:0x2c40), top: B:102:0x0335, inners: #89 }] */
        /* JADX WARN: Removed duplicated region for block: B:308:? A[Catch: OutOfMemoryError -> 0x07c2, IOException -> 0x07c5, all -> 0x0944, SYNTHETIC, TryCatch #16 {all -> 0x0944, blocks: (B:105:0x0339, B:107:0x0347, B:109:0x034d, B:111:0x0353, B:113:0x035b, B:115:0x0372, B:117:0x037c, B:119:0x0386, B:121:0x0392, B:123:0x0398, B:125:0x03a8, B:128:0x03ba, B:130:0x03c0, B:392:0x03d5, B:394:0x040c, B:151:0x07d8, B:155:0x07e0, B:158:0x07ea, B:161:0x0844, B:164:0x087e, B:167:0x089c, B:177:0x08eb, B:174:0x092c, B:173:0x090e, B:195:0x081b, B:197:0x0823, B:198:0x082a, B:203:0x0834, B:204:0x083d, B:133:0x0443, B:261:0x0447, B:263:0x0452, B:265:0x0460, B:268:0x0469, B:270:0x0474, B:271:0x0487, B:273:0x048e, B:274:0x0492, B:293:0x0545, B:294:0x0548, B:314:0x0588, B:304:0x0592, B:306:0x0597, B:307:0x059a, B:340:0x04b8, B:343:0x04c4, B:345:0x04c7, B:346:0x04cb, B:361:0x05a3, B:363:0x05af, B:365:0x05cf, B:367:0x05db, B:372:0x05ef, B:374:0x0612, B:375:0x061a, B:377:0x0620, B:378:0x062e, B:380:0x0636, B:383:0x0647, B:384:0x064f, B:136:0x0678, B:138:0x067c, B:140:0x06ab, B:142:0x06b1, B:144:0x06b7, B:146:0x06bd, B:147:0x06c6, B:213:0x06e7, B:215:0x06ed, B:216:0x06f7, B:218:0x06fd, B:220:0x0705, B:224:0x0710, B:227:0x072d, B:228:0x0736, B:231:0x076e, B:234:0x0776, B:238:0x0788, B:240:0x0792, B:242:0x07a0, B:252:0x0729, B:422:0x0961, B:424:0x098a, B:426:0x0990, B:428:0x099d, B:429:0x09c1, B:432:0x09f6, B:433:0x09de, B:436:0x09e9, B:443:0x0a0f, B:446:0x0a42, B:448:0x0a4f, B:453:0x0a72, B:455:0x0a99, B:457:0x0a9f, B:458:0x0ac2, B:462:0x0ade, B:463:0x0ae7, B:465:0x0aed, B:466:0x0af0, B:471:0x0b01, B:473:0x0b13, B:474:0x0b3a, B:477:0x0b4b, B:479:0x0b6e, B:480:0x0b98, B:489:0x0bbb, B:494:0x0bee, B:498:0x0c17, B:500:0x0c4b, B:501:0x0c4e, B:627:0x1113, B:654:0x1211, B:655:0x122d, B:657:0x1233, B:658:0x1249, B:672:0x1265, B:675:0x1289, B:678:0x12c7, B:681:0x12da, B:684:0x12f1, B:686:0x1306, B:687:0x1327, B:689:0x1331, B:693:0x1344, B:696:0x1361, B:700:0x1391, B:703:0x13bf, B:705:0x1422, B:707:0x143c, B:709:0x1456, B:711:0x145f, B:713:0x147a, B:716:0x1484, B:718:0x148a, B:720:0x1490, B:721:0x14a4, B:723:0x14aa, B:727:0x1430, B:731:0x14e6, B:733:0x150e, B:735:0x1514, B:738:0x1537, B:740:0x153d, B:743:0x1553, B:745:0x1585, B:748:0x1590, B:750:0x1599, B:753:0x15b4, B:756:0x15bf, B:758:0x15c8, B:759:0x15d7, B:761:0x15e0, B:763:0x15f7, B:764:0x15fb, B:766:0x1601, B:767:0x162b, B:768:0x1631, B:771:0x1648, B:774:0x1694, B:776:0x16b4, B:777:0x1703, B:780:0x1724, B:782:0x173e, B:783:0x1762, B:787:0x1781, B:795:0x178f, B:796:0x1792, B:797:0x1795, B:799:0x179c, B:801:0x17a9, B:805:0x17c8, B:806:0x17e4, B:807:0x180b, B:810:0x1820, B:812:0x182b, B:813:0x1856, B:814:0x1866, B:815:0x1885, B:816:0x18a4, B:817:0x18c3, B:819:0x18c9, B:820:0x18da, B:823:0x18e8, B:825:0x18f3, B:826:0x18fc, B:1060:0x225d, B:1062:0x2263, B:1064:0x2270, B:1066:0x227e, B:1068:0x2286, B:1071:0x2296, B:1073:0x22a1, B:1076:0x22b1, B:1078:0x22b7, B:1081:0x22d8, B:1084:0x22f8, B:1087:0x230d, B:1089:0x2320, B:1094:0x2343, B:1097:0x235a, B:1099:0x2365, B:1102:0x2372, B:1104:0x238b, B:1105:0x239b, B:1106:0x2394, B:1110:0x23ac, B:1116:0x23bd, B:1117:0x23c1, B:1119:0x23c7, B:1112:0x23d3, B:1129:0x241d, B:1132:0x242b, B:1141:0x2475, B:1144:0x2484, B:1146:0x2492, B:1147:0x24bf, B:1149:0x24b5, B:1154:0x24dd, B:1166:0x2508, B:1169:0x255b, B:1172:0x256b, B:1175:0x2588, B:1178:0x25a5, B:1180:0x25ae, B:1181:0x25bc, B:1200:0x2604, B:1202:0x260e, B:1205:0x2620, B:1209:0x263e, B:1211:0x2644, B:1214:0x264e, B:1217:0x2657, B:1219:0x2663, B:1221:0x2673, B:1223:0x267d, B:1263:0x26f1, B:1267:0x2701, B:1269:0x275d, B:1271:0x2763, B:1273:0x276c, B:1277:0x2781, B:1278:0x278c, B:1280:0x2792, B:1285:0x2789, B:1313:0x27f0, B:1317:0x27f9, B:1319:0x27fe, B:1331:0x2811, B:1385:0x29b6, B:1387:0x29c0, B:1395:0x2a3d, B:1396:0x2a4c, B:1398:0x2a52, B:1401:0x2a63, B:1403:0x2a6b, B:1405:0x2a73, B:1407:0x2a7f, B:1408:0x2a82, B:1410:0x2a8a, B:1412:0x2a92, B:1413:0x2a97, B:1435:0x2ab8, B:1438:0x2ad7, B:1441:0x2ae4, B:1444:0x2aea, B:1447:0x2af2, B:1450:0x2aff, B:1452:0x2b1b, B:1455:0x2b23, B:1458:0x2b5a, B:1462:0x2b68, B:1478:0x2b98, B:1480:0x2b9e, B:1482:0x2bab, B:1484:0x2bbd, B:1488:0x2bcb, B:1491:0x2bd3, B:1494:0x2be4, B:1497:0x2be9, B:1513:0x2c40), top: B:102:0x0335, inners: #89 }] */
        /* JADX WARN: Removed duplicated region for block: B:314:0x0588 A[Catch: OutOfMemoryError -> 0x07c2, IOException -> 0x07c5, all -> 0x0944, TRY_ENTER, TryCatch #16 {all -> 0x0944, blocks: (B:105:0x0339, B:107:0x0347, B:109:0x034d, B:111:0x0353, B:113:0x035b, B:115:0x0372, B:117:0x037c, B:119:0x0386, B:121:0x0392, B:123:0x0398, B:125:0x03a8, B:128:0x03ba, B:130:0x03c0, B:392:0x03d5, B:394:0x040c, B:151:0x07d8, B:155:0x07e0, B:158:0x07ea, B:161:0x0844, B:164:0x087e, B:167:0x089c, B:177:0x08eb, B:174:0x092c, B:173:0x090e, B:195:0x081b, B:197:0x0823, B:198:0x082a, B:203:0x0834, B:204:0x083d, B:133:0x0443, B:261:0x0447, B:263:0x0452, B:265:0x0460, B:268:0x0469, B:270:0x0474, B:271:0x0487, B:273:0x048e, B:274:0x0492, B:293:0x0545, B:294:0x0548, B:314:0x0588, B:304:0x0592, B:306:0x0597, B:307:0x059a, B:340:0x04b8, B:343:0x04c4, B:345:0x04c7, B:346:0x04cb, B:361:0x05a3, B:363:0x05af, B:365:0x05cf, B:367:0x05db, B:372:0x05ef, B:374:0x0612, B:375:0x061a, B:377:0x0620, B:378:0x062e, B:380:0x0636, B:383:0x0647, B:384:0x064f, B:136:0x0678, B:138:0x067c, B:140:0x06ab, B:142:0x06b1, B:144:0x06b7, B:146:0x06bd, B:147:0x06c6, B:213:0x06e7, B:215:0x06ed, B:216:0x06f7, B:218:0x06fd, B:220:0x0705, B:224:0x0710, B:227:0x072d, B:228:0x0736, B:231:0x076e, B:234:0x0776, B:238:0x0788, B:240:0x0792, B:242:0x07a0, B:252:0x0729, B:422:0x0961, B:424:0x098a, B:426:0x0990, B:428:0x099d, B:429:0x09c1, B:432:0x09f6, B:433:0x09de, B:436:0x09e9, B:443:0x0a0f, B:446:0x0a42, B:448:0x0a4f, B:453:0x0a72, B:455:0x0a99, B:457:0x0a9f, B:458:0x0ac2, B:462:0x0ade, B:463:0x0ae7, B:465:0x0aed, B:466:0x0af0, B:471:0x0b01, B:473:0x0b13, B:474:0x0b3a, B:477:0x0b4b, B:479:0x0b6e, B:480:0x0b98, B:489:0x0bbb, B:494:0x0bee, B:498:0x0c17, B:500:0x0c4b, B:501:0x0c4e, B:627:0x1113, B:654:0x1211, B:655:0x122d, B:657:0x1233, B:658:0x1249, B:672:0x1265, B:675:0x1289, B:678:0x12c7, B:681:0x12da, B:684:0x12f1, B:686:0x1306, B:687:0x1327, B:689:0x1331, B:693:0x1344, B:696:0x1361, B:700:0x1391, B:703:0x13bf, B:705:0x1422, B:707:0x143c, B:709:0x1456, B:711:0x145f, B:713:0x147a, B:716:0x1484, B:718:0x148a, B:720:0x1490, B:721:0x14a4, B:723:0x14aa, B:727:0x1430, B:731:0x14e6, B:733:0x150e, B:735:0x1514, B:738:0x1537, B:740:0x153d, B:743:0x1553, B:745:0x1585, B:748:0x1590, B:750:0x1599, B:753:0x15b4, B:756:0x15bf, B:758:0x15c8, B:759:0x15d7, B:761:0x15e0, B:763:0x15f7, B:764:0x15fb, B:766:0x1601, B:767:0x162b, B:768:0x1631, B:771:0x1648, B:774:0x1694, B:776:0x16b4, B:777:0x1703, B:780:0x1724, B:782:0x173e, B:783:0x1762, B:787:0x1781, B:795:0x178f, B:796:0x1792, B:797:0x1795, B:799:0x179c, B:801:0x17a9, B:805:0x17c8, B:806:0x17e4, B:807:0x180b, B:810:0x1820, B:812:0x182b, B:813:0x1856, B:814:0x1866, B:815:0x1885, B:816:0x18a4, B:817:0x18c3, B:819:0x18c9, B:820:0x18da, B:823:0x18e8, B:825:0x18f3, B:826:0x18fc, B:1060:0x225d, B:1062:0x2263, B:1064:0x2270, B:1066:0x227e, B:1068:0x2286, B:1071:0x2296, B:1073:0x22a1, B:1076:0x22b1, B:1078:0x22b7, B:1081:0x22d8, B:1084:0x22f8, B:1087:0x230d, B:1089:0x2320, B:1094:0x2343, B:1097:0x235a, B:1099:0x2365, B:1102:0x2372, B:1104:0x238b, B:1105:0x239b, B:1106:0x2394, B:1110:0x23ac, B:1116:0x23bd, B:1117:0x23c1, B:1119:0x23c7, B:1112:0x23d3, B:1129:0x241d, B:1132:0x242b, B:1141:0x2475, B:1144:0x2484, B:1146:0x2492, B:1147:0x24bf, B:1149:0x24b5, B:1154:0x24dd, B:1166:0x2508, B:1169:0x255b, B:1172:0x256b, B:1175:0x2588, B:1178:0x25a5, B:1180:0x25ae, B:1181:0x25bc, B:1200:0x2604, B:1202:0x260e, B:1205:0x2620, B:1209:0x263e, B:1211:0x2644, B:1214:0x264e, B:1217:0x2657, B:1219:0x2663, B:1221:0x2673, B:1223:0x267d, B:1263:0x26f1, B:1267:0x2701, B:1269:0x275d, B:1271:0x2763, B:1273:0x276c, B:1277:0x2781, B:1278:0x278c, B:1280:0x2792, B:1285:0x2789, B:1313:0x27f0, B:1317:0x27f9, B:1319:0x27fe, B:1331:0x2811, B:1385:0x29b6, B:1387:0x29c0, B:1395:0x2a3d, B:1396:0x2a4c, B:1398:0x2a52, B:1401:0x2a63, B:1403:0x2a6b, B:1405:0x2a73, B:1407:0x2a7f, B:1408:0x2a82, B:1410:0x2a8a, B:1412:0x2a92, B:1413:0x2a97, B:1435:0x2ab8, B:1438:0x2ad7, B:1441:0x2ae4, B:1444:0x2aea, B:1447:0x2af2, B:1450:0x2aff, B:1452:0x2b1b, B:1455:0x2b23, B:1458:0x2b5a, B:1462:0x2b68, B:1478:0x2b98, B:1480:0x2b9e, B:1482:0x2bab, B:1484:0x2bbd, B:1488:0x2bcb, B:1491:0x2bd3, B:1494:0x2be4, B:1497:0x2be9, B:1513:0x2c40), top: B:102:0x0335, inners: #89 }] */
        /* JADX WARN: Removed duplicated region for block: B:316:0x058d  */
        /* JADX WARN: Removed duplicated region for block: B:657:0x1233 A[Catch: all -> 0x0944, TryCatch #16 {all -> 0x0944, blocks: (B:105:0x0339, B:107:0x0347, B:109:0x034d, B:111:0x0353, B:113:0x035b, B:115:0x0372, B:117:0x037c, B:119:0x0386, B:121:0x0392, B:123:0x0398, B:125:0x03a8, B:128:0x03ba, B:130:0x03c0, B:392:0x03d5, B:394:0x040c, B:151:0x07d8, B:155:0x07e0, B:158:0x07ea, B:161:0x0844, B:164:0x087e, B:167:0x089c, B:177:0x08eb, B:174:0x092c, B:173:0x090e, B:195:0x081b, B:197:0x0823, B:198:0x082a, B:203:0x0834, B:204:0x083d, B:133:0x0443, B:261:0x0447, B:263:0x0452, B:265:0x0460, B:268:0x0469, B:270:0x0474, B:271:0x0487, B:273:0x048e, B:274:0x0492, B:293:0x0545, B:294:0x0548, B:314:0x0588, B:304:0x0592, B:306:0x0597, B:307:0x059a, B:340:0x04b8, B:343:0x04c4, B:345:0x04c7, B:346:0x04cb, B:361:0x05a3, B:363:0x05af, B:365:0x05cf, B:367:0x05db, B:372:0x05ef, B:374:0x0612, B:375:0x061a, B:377:0x0620, B:378:0x062e, B:380:0x0636, B:383:0x0647, B:384:0x064f, B:136:0x0678, B:138:0x067c, B:140:0x06ab, B:142:0x06b1, B:144:0x06b7, B:146:0x06bd, B:147:0x06c6, B:213:0x06e7, B:215:0x06ed, B:216:0x06f7, B:218:0x06fd, B:220:0x0705, B:224:0x0710, B:227:0x072d, B:228:0x0736, B:231:0x076e, B:234:0x0776, B:238:0x0788, B:240:0x0792, B:242:0x07a0, B:252:0x0729, B:422:0x0961, B:424:0x098a, B:426:0x0990, B:428:0x099d, B:429:0x09c1, B:432:0x09f6, B:433:0x09de, B:436:0x09e9, B:443:0x0a0f, B:446:0x0a42, B:448:0x0a4f, B:453:0x0a72, B:455:0x0a99, B:457:0x0a9f, B:458:0x0ac2, B:462:0x0ade, B:463:0x0ae7, B:465:0x0aed, B:466:0x0af0, B:471:0x0b01, B:473:0x0b13, B:474:0x0b3a, B:477:0x0b4b, B:479:0x0b6e, B:480:0x0b98, B:489:0x0bbb, B:494:0x0bee, B:498:0x0c17, B:500:0x0c4b, B:501:0x0c4e, B:627:0x1113, B:654:0x1211, B:655:0x122d, B:657:0x1233, B:658:0x1249, B:672:0x1265, B:675:0x1289, B:678:0x12c7, B:681:0x12da, B:684:0x12f1, B:686:0x1306, B:687:0x1327, B:689:0x1331, B:693:0x1344, B:696:0x1361, B:700:0x1391, B:703:0x13bf, B:705:0x1422, B:707:0x143c, B:709:0x1456, B:711:0x145f, B:713:0x147a, B:716:0x1484, B:718:0x148a, B:720:0x1490, B:721:0x14a4, B:723:0x14aa, B:727:0x1430, B:731:0x14e6, B:733:0x150e, B:735:0x1514, B:738:0x1537, B:740:0x153d, B:743:0x1553, B:745:0x1585, B:748:0x1590, B:750:0x1599, B:753:0x15b4, B:756:0x15bf, B:758:0x15c8, B:759:0x15d7, B:761:0x15e0, B:763:0x15f7, B:764:0x15fb, B:766:0x1601, B:767:0x162b, B:768:0x1631, B:771:0x1648, B:774:0x1694, B:776:0x16b4, B:777:0x1703, B:780:0x1724, B:782:0x173e, B:783:0x1762, B:787:0x1781, B:795:0x178f, B:796:0x1792, B:797:0x1795, B:799:0x179c, B:801:0x17a9, B:805:0x17c8, B:806:0x17e4, B:807:0x180b, B:810:0x1820, B:812:0x182b, B:813:0x1856, B:814:0x1866, B:815:0x1885, B:816:0x18a4, B:817:0x18c3, B:819:0x18c9, B:820:0x18da, B:823:0x18e8, B:825:0x18f3, B:826:0x18fc, B:1060:0x225d, B:1062:0x2263, B:1064:0x2270, B:1066:0x227e, B:1068:0x2286, B:1071:0x2296, B:1073:0x22a1, B:1076:0x22b1, B:1078:0x22b7, B:1081:0x22d8, B:1084:0x22f8, B:1087:0x230d, B:1089:0x2320, B:1094:0x2343, B:1097:0x235a, B:1099:0x2365, B:1102:0x2372, B:1104:0x238b, B:1105:0x239b, B:1106:0x2394, B:1110:0x23ac, B:1116:0x23bd, B:1117:0x23c1, B:1119:0x23c7, B:1112:0x23d3, B:1129:0x241d, B:1132:0x242b, B:1141:0x2475, B:1144:0x2484, B:1146:0x2492, B:1147:0x24bf, B:1149:0x24b5, B:1154:0x24dd, B:1166:0x2508, B:1169:0x255b, B:1172:0x256b, B:1175:0x2588, B:1178:0x25a5, B:1180:0x25ae, B:1181:0x25bc, B:1200:0x2604, B:1202:0x260e, B:1205:0x2620, B:1209:0x263e, B:1211:0x2644, B:1214:0x264e, B:1217:0x2657, B:1219:0x2663, B:1221:0x2673, B:1223:0x267d, B:1263:0x26f1, B:1267:0x2701, B:1269:0x275d, B:1271:0x2763, B:1273:0x276c, B:1277:0x2781, B:1278:0x278c, B:1280:0x2792, B:1285:0x2789, B:1313:0x27f0, B:1317:0x27f9, B:1319:0x27fe, B:1331:0x2811, B:1385:0x29b6, B:1387:0x29c0, B:1395:0x2a3d, B:1396:0x2a4c, B:1398:0x2a52, B:1401:0x2a63, B:1403:0x2a6b, B:1405:0x2a73, B:1407:0x2a7f, B:1408:0x2a82, B:1410:0x2a8a, B:1412:0x2a92, B:1413:0x2a97, B:1435:0x2ab8, B:1438:0x2ad7, B:1441:0x2ae4, B:1444:0x2aea, B:1447:0x2af2, B:1450:0x2aff, B:1452:0x2b1b, B:1455:0x2b23, B:1458:0x2b5a, B:1462:0x2b68, B:1478:0x2b98, B:1480:0x2b9e, B:1482:0x2bab, B:1484:0x2bbd, B:1488:0x2bcb, B:1491:0x2bd3, B:1494:0x2be4, B:1497:0x2be9, B:1513:0x2c40), top: B:102:0x0335, inners: #89 }] */
        /* JADX WARN: Removed duplicated region for block: B:854:0x3a72  */
        /* JADX WARN: Removed duplicated region for block: B:856:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:918:0x1c59 A[Catch: all -> 0x0ca3, TryCatch #65 {all -> 0x0ca3, blocks: (B:503:0x0c62, B:510:0x0c7b, B:512:0x0c86, B:516:0x0c99, B:519:0x0cb1, B:525:0x0d1e, B:527:0x0d39, B:529:0x0d44, B:530:0x0d47, B:535:0x0d50, B:1951:0x0d5f, B:540:0x0d97, B:542:0x0db0, B:544:0x0dc2, B:546:0x0dc8, B:547:0x0dcf, B:549:0x0dd5, B:551:0x0ddd, B:552:0x0e04, B:556:0x0e12, B:560:0x0e31, B:564:0x0e4f, B:566:0x0e68, B:567:0x0e87, B:571:0x0ea4, B:573:0x0ec4, B:576:0x0ee1, B:580:0x0f0f, B:590:0x0f1c, B:593:0x0f56, B:582:0x0f8a, B:584:0x0f97, B:587:0x0fc3, B:598:0x0f67, B:600:0x0f6d, B:606:0x0fe2, B:608:0x0ffd, B:609:0x1025, B:613:0x104f, B:615:0x109a, B:618:0x10a5, B:620:0x10ab, B:621:0x10b7, B:624:0x10df, B:839:0x19c0, B:840:0x19df, B:843:0x1a01, B:845:0x1a0b, B:846:0x1a10, B:847:0x19f7, B:848:0x1a1b, B:789:0x1a4d, B:792:0x1a64, B:860:0x1a7f, B:871:0x1ad5, B:874:0x1aee, B:876:0x1b0c, B:877:0x1b2a, B:881:0x1b82, B:885:0x1ba5, B:888:0x1bbc, B:892:0x1bcb, B:894:0x1bd9, B:896:0x1bdf, B:901:0x1bff, B:902:0x1c05, B:909:0x1c21, B:911:0x1c33, B:913:0x1c3b, B:916:0x1c45, B:918:0x1c59, B:920:0x1c5f, B:921:0x1c69, B:922:0x1cbf, B:924:0x1cca, B:925:0x1cd8, B:926:0x1cd2, B:930:0x1cf8, B:932:0x1d2c, B:933:0x1d33, B:935:0x1d39, B:936:0x1d97, B:937:0x1d6f, B:941:0x1db3, B:944:0x1dc8, B:947:0x1e0a, B:950:0x1e4f, B:953:0x1e70, B:955:0x1e85, B:957:0x1e8b, B:959:0x1e9d, B:960:0x1ea3, B:962:0x1ea9, B:964:0x1ec3, B:967:0x1ed4, B:977:0x1f0d, B:978:0x1f22, B:981:0x1f42, B:982:0x1f57, B:984:0x1f5f, B:985:0x1f74, B:987:0x1fa0, B:988:0x1fb5, B:991:0x1fd0, B:994:0x1fe1, B:997:0x2005, B:1000:0x2037, B:1003:0x2069, B:1008:0x2078, B:1010:0x2081, B:1006:0x209a, B:1019:0x2096, B:1022:0x20b1, B:1025:0x20d7, B:1028:0x20fd, B:1031:0x212f, B:1034:0x2181, B:1037:0x21a2, B:1040:0x21d1, B:1048:0x2212, B:1050:0x2218, B:1052:0x222b, B:1054:0x2231, B:1055:0x2242, B:1955:0x0d8a), top: B:496:0x0c15, inners: #71, #78, #82, #87, #99 }] */
        /* JADX WARN: Removed duplicated region for block: B:922:0x1cbf A[Catch: all -> 0x0ca3, TryCatch #65 {all -> 0x0ca3, blocks: (B:503:0x0c62, B:510:0x0c7b, B:512:0x0c86, B:516:0x0c99, B:519:0x0cb1, B:525:0x0d1e, B:527:0x0d39, B:529:0x0d44, B:530:0x0d47, B:535:0x0d50, B:1951:0x0d5f, B:540:0x0d97, B:542:0x0db0, B:544:0x0dc2, B:546:0x0dc8, B:547:0x0dcf, B:549:0x0dd5, B:551:0x0ddd, B:552:0x0e04, B:556:0x0e12, B:560:0x0e31, B:564:0x0e4f, B:566:0x0e68, B:567:0x0e87, B:571:0x0ea4, B:573:0x0ec4, B:576:0x0ee1, B:580:0x0f0f, B:590:0x0f1c, B:593:0x0f56, B:582:0x0f8a, B:584:0x0f97, B:587:0x0fc3, B:598:0x0f67, B:600:0x0f6d, B:606:0x0fe2, B:608:0x0ffd, B:609:0x1025, B:613:0x104f, B:615:0x109a, B:618:0x10a5, B:620:0x10ab, B:621:0x10b7, B:624:0x10df, B:839:0x19c0, B:840:0x19df, B:843:0x1a01, B:845:0x1a0b, B:846:0x1a10, B:847:0x19f7, B:848:0x1a1b, B:789:0x1a4d, B:792:0x1a64, B:860:0x1a7f, B:871:0x1ad5, B:874:0x1aee, B:876:0x1b0c, B:877:0x1b2a, B:881:0x1b82, B:885:0x1ba5, B:888:0x1bbc, B:892:0x1bcb, B:894:0x1bd9, B:896:0x1bdf, B:901:0x1bff, B:902:0x1c05, B:909:0x1c21, B:911:0x1c33, B:913:0x1c3b, B:916:0x1c45, B:918:0x1c59, B:920:0x1c5f, B:921:0x1c69, B:922:0x1cbf, B:924:0x1cca, B:925:0x1cd8, B:926:0x1cd2, B:930:0x1cf8, B:932:0x1d2c, B:933:0x1d33, B:935:0x1d39, B:936:0x1d97, B:937:0x1d6f, B:941:0x1db3, B:944:0x1dc8, B:947:0x1e0a, B:950:0x1e4f, B:953:0x1e70, B:955:0x1e85, B:957:0x1e8b, B:959:0x1e9d, B:960:0x1ea3, B:962:0x1ea9, B:964:0x1ec3, B:967:0x1ed4, B:977:0x1f0d, B:978:0x1f22, B:981:0x1f42, B:982:0x1f57, B:984:0x1f5f, B:985:0x1f74, B:987:0x1fa0, B:988:0x1fb5, B:991:0x1fd0, B:994:0x1fe1, B:997:0x2005, B:1000:0x2037, B:1003:0x2069, B:1008:0x2078, B:1010:0x2081, B:1006:0x209a, B:1019:0x2096, B:1022:0x20b1, B:1025:0x20d7, B:1028:0x20fd, B:1031:0x212f, B:1034:0x2181, B:1037:0x21a2, B:1040:0x21d1, B:1048:0x2212, B:1050:0x2218, B:1052:0x222b, B:1054:0x2231, B:1055:0x2242, B:1955:0x0d8a), top: B:496:0x0c15, inners: #71, #78, #82, #87, #99 }] */
        /* JADX WARN: Type inference failed for: r11v1, types: [com.tencent.common.app.business.BaseQQAppInterface, mqq.app.AppRuntime, com.tencent.common.app.AppInterface, com.tencent.mobileqq.app.QQAppInterface] */
        /* JADX WARN: Type inference failed for: r12v1, types: [android.content.Context, com.tencent.mobileqq.emosm.web.MessengerService, mqq.app.AppService] */
        /* JADX WARN: Type inference failed for: r12v10 */
        /* JADX WARN: Type inference failed for: r12v100 */
        /* JADX WARN: Type inference failed for: r12v101 */
        /* JADX WARN: Type inference failed for: r12v102 */
        /* JADX WARN: Type inference failed for: r12v109 */
        /* JADX WARN: Type inference failed for: r12v12 */
        /* JADX WARN: Type inference failed for: r12v13 */
        /* JADX WARN: Type inference failed for: r12v14 */
        /* JADX WARN: Type inference failed for: r12v16 */
        /* JADX WARN: Type inference failed for: r12v17, types: [com.tencent.mobileqq.emosm.web.MessengerService] */
        /* JADX WARN: Type inference failed for: r12v18, types: [com.tencent.mobileqq.emosm.web.MessengerService] */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v21 */
        /* JADX WARN: Type inference failed for: r12v22 */
        /* JADX WARN: Type inference failed for: r12v23 */
        /* JADX WARN: Type inference failed for: r12v24 */
        /* JADX WARN: Type inference failed for: r12v31 */
        /* JADX WARN: Type inference failed for: r12v32 */
        /* JADX WARN: Type inference failed for: r12v33, types: [com.tencent.mobileqq.emosm.web.MessengerService] */
        /* JADX WARN: Type inference failed for: r12v34, types: [android.content.Context, com.tencent.mobileqq.emosm.web.MessengerService] */
        /* JADX WARN: Type inference failed for: r12v42 */
        /* JADX WARN: Type inference failed for: r12v43 */
        /* JADX WARN: Type inference failed for: r12v44 */
        /* JADX WARN: Type inference failed for: r12v47 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v54, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r12v55 */
        /* JADX WARN: Type inference failed for: r12v57 */
        /* JADX WARN: Type inference failed for: r12v58 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v61 */
        /* JADX WARN: Type inference failed for: r12v97 */
        /* JADX WARN: Type inference failed for: r12v98 */
        /* JADX WARN: Type inference failed for: r12v99 */
        /* JADX WARN: Type inference failed for: r13v26 */
        /* JADX WARN: Type inference failed for: r13v27 */
        /* JADX WARN: Type inference failed for: r13v28 */
        /* JADX WARN: Type inference failed for: r13v29 */
        /* JADX WARN: Type inference failed for: r13v30 */
        /* JADX WARN: Type inference failed for: r13v31 */
        /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v51 */
        /* JADX WARN: Type inference failed for: r13v52 */
        /* JADX WARN: Type inference failed for: r15v112 */
        /* JADX WARN: Type inference failed for: r15v113 */
        /* JADX WARN: Type inference failed for: r15v114 */
        /* JADX WARN: Type inference failed for: r15v115 */
        /* JADX WARN: Type inference failed for: r15v116 */
        /* JADX WARN: Type inference failed for: r15v118 */
        /* JADX WARN: Type inference failed for: r15v119 */
        /* JADX WARN: Type inference failed for: r15v120 */
        /* JADX WARN: Type inference failed for: r15v38 */
        /* JADX WARN: Type inference failed for: r15v39 */
        /* JADX WARN: Type inference failed for: r15v40 */
        /* JADX WARN: Type inference failed for: r15v41 */
        /* JADX WARN: Type inference failed for: r15v46 */
        /* JADX WARN: Type inference failed for: r15v47 */
        /* JADX WARN: Type inference failed for: r15v53 */
        /* JADX WARN: Type inference failed for: r15v59 */
        /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r16v72, types: [com.tencent.mobileqq.app.ThemeHandler] */
        /* JADX WARN: Type inference failed for: r16v78, types: [com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi] */
        /* JADX WARN: Type inference failed for: r1v187, types: [com.tencent.mobileqq.loginwelcome.LoginWelcomeManager] */
        /* JADX WARN: Type inference failed for: r1v205, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r1v25, types: [android.os.Bundle, java.lang.Object, android.os.BaseBundle] */
        /* JADX WARN: Type inference failed for: r1v315, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v316, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v346, types: [com.tencent.mobileqq.phonelogin.a] */
        /* JADX WARN: Type inference failed for: r1v384, types: [com.tencent.mobileqq.vas.svip.api.ISVIPHandler] */
        /* JADX WARN: Type inference failed for: r1v445 */
        /* JADX WARN: Type inference failed for: r1v449 */
        /* JADX WARN: Type inference failed for: r1v456 */
        /* JADX WARN: Type inference failed for: r1v476 */
        /* JADX WARN: Type inference failed for: r1v539 */
        /* JADX WARN: Type inference failed for: r1v9, types: [com.tencent.mobileqq.equipmentlock.c] */
        /* JADX WARN: Type inference failed for: r1v93, types: [com.tencent.mobileqq.setting.api.ISettingApi] */
        /* JADX WARN: Type inference failed for: r2v214, types: [android.content.Intent] */
        /* JADX WARN: Type inference failed for: r2v322, types: [com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler] */
        /* JADX WARN: Type inference failed for: r2v349, types: [com.tencent.mobileqq.equipmentlock.EquipmentLockImpl] */
        /* JADX WARN: Type inference failed for: r2v368, types: [com.tencent.mobileqq.profile.ProfileCardManager] */
        /* JADX WARN: Type inference failed for: r2v505, types: [android.content.SharedPreferences] */
        /* JADX WARN: Type inference failed for: r2v528, types: [com.tencent.mobileqq.bubble.BubbleDiyFetcher] */
        /* JADX WARN: Type inference failed for: r2v562, types: [com.tencent.mobileqq.emoticon.api.IEmojiManagerService] */
        /* JADX WARN: Type inference failed for: r2v84, types: [com.tencent.mobileqq.vipav.VipSetFunCallHandler] */
        /* JADX WARN: Type inference failed for: r3v11, types: [com.tencent.mobileqq.emoticon.api.IEmojiManagerService] */
        /* JADX WARN: Type inference failed for: r3v199, types: [com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi] */
        /* JADX WARN: Type inference failed for: r3v204, types: [com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler] */
        /* JADX WARN: Type inference failed for: r3v388, types: [com.tencent.mobileqq.app.IndividualRedPacketManager] */
        /* JADX WARN: Type inference failed for: r3v426, types: [com.tencent.mobileqq.apollo.handler.b] */
        /* JADX WARN: Type inference failed for: r3v515, types: [com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService] */
        /* JADX WARN: Type inference failed for: r3v518, types: [com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService] */
        /* JADX WARN: Type inference failed for: r4v124, types: [com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService] */
        /* JADX WARN: Type inference failed for: r4v248, types: [com.tencent.mobileqq.app.IndividualRedPacketManager] */
        /* JADX WARN: Type inference failed for: r4v417, types: [com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService] */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v16, types: [boolean] */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18, types: [com.tencent.mobileqq.emosm.web.MessengerService$IncomingHandler] */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v225, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r5v258 */
        /* JADX WARN: Type inference failed for: r5v28, types: [com.tencent.mobileqq.emosm.web.MessengerService$IncomingHandler] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v64 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r6v4, types: [android.os.Bundle, java.lang.Object, android.os.BaseBundle] */
        /* JADX WARN: Type inference failed for: r6v48, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r6v69, types: [com.tencent.mobileqq.leba.ILebaHelperService] */
        /* JADX WARN: Type inference failed for: r7v52, types: [com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService] */
        /* JADX WARN: Type inference failed for: r9v23, types: [android.os.Bundle, android.os.BaseBundle] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            ?? r56;
            Throwable th5;
            String str;
            WeakReference<MessengerService> weakReference;
            String str2;
            IncomingHandler incomingHandler;
            AvatarHistoryNumProcessor avatarHistoryNumProcessor;
            String str3;
            JSONObject jSONObject;
            MessengerService messengerService;
            final Bundle bundle;
            String str4;
            JSONObject jSONObject2;
            String str5;
            Exception exc;
            final MessengerService messengerService2;
            String str6;
            final JSONObject jSONObject3;
            JSONObject jSONObject4;
            ArrayList arrayList;
            IncomingHandler incomingHandler2;
            String str7;
            String str8;
            String str9;
            Exception exc2;
            IncomingHandler incomingHandler3;
            MessengerService messengerService3;
            JSONException jSONException;
            String str10;
            ?? r122;
            String message2;
            ?? r123;
            String message3;
            String string;
            String str11;
            MessengerService messengerService4;
            int i3;
            ?? r124;
            IncomingHandler incomingHandler4;
            MessengerService messengerService5;
            JSONException e16;
            IncomingHandler incomingHandler5;
            ArrayList arrayList2;
            int i16;
            IncomingHandler incomingHandler6;
            final MessengerService messengerService6;
            IncomingHandler incomingHandler7;
            MessengerService messengerService7;
            int lastIndexOf;
            MessengerService messengerService8;
            MessengerService messengerService9;
            IncomingHandler incomingHandler8;
            List<CustomEmotionData> list;
            int i17;
            int i18;
            com.tencent.mobileqq.vipgift.b bVar;
            com.tencent.mobileqq.vipgift.a d16;
            int i19;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath;
            int i26;
            int i27;
            long j3;
            int i28;
            long j16;
            int i29;
            long j17;
            String str12;
            String str13;
            Exception exc3;
            IncomingHandler incomingHandler9;
            int i36;
            String str14;
            String str15;
            int i37;
            HashMap<String, com.tencent.mobileqq.bubble.g> hashMap;
            int i38;
            int i39;
            ChatFragment chatFragment;
            Bundle bundle2;
            ArrayList<? extends Parcelable> arrayList3;
            String str16;
            MessengerService messengerService10;
            ChatMessage chatMessage;
            List<Long> n3;
            String str17;
            IOException iOException;
            String str18;
            OutOfMemoryError outOfMemoryError;
            IEmoticonManagerService iEmoticonManagerService;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            ArrayList<? extends Parcelable> arrayList4;
            int i46;
            int i47;
            int i48;
            int i49;
            int i56;
            int i57;
            String[] strArr;
            Throwable th6;
            InputStream inputStream;
            Exception exc4;
            ByteArrayOutputStream byteArrayOutputStream;
            String str25;
            String str26;
            try {
                weakReference = this.f204473b;
                try {
                } catch (Throwable th7) {
                    th5 = th7;
                    str = "MessengerService$IncomingHandler";
                }
            } catch (Throwable th8) {
                th = th8;
                r56 = "MessengerService$IncomingHandler";
            }
            if (weakReference == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, mServiceWeakRef null");
                    return;
                }
                return;
            }
            final MessengerService messengerService11 = weakReference.get();
            if (messengerService11 != 0) {
                if (((AppService) messengerService11).app != null) {
                    if (message != null && (((AppService) messengerService11).app instanceof QQAppInterface)) {
                        final ?? r112 = (QQAppInterface) ((AppService) messengerService11).app;
                        if (r112 == 0) {
                            return;
                        }
                        ?? r36 = (IEmojiManagerService) r112.getRuntimeService(IEmojiManagerService.class);
                        int i58 = message.what;
                        try {
                        } catch (Throwable th9) {
                            th = th9;
                        }
                        if (i58 == 1) {
                            r56 = "MessengerService$IncomingHandler";
                            Messenger messenger = message.replyTo;
                            if (messenger != null) {
                                messengerService11.f204464d = messenger;
                                try {
                                    messenger.getBinder().linkToDeath(this.f204474c, 0);
                                } catch (RemoteException e17) {
                                    QLog.d((String) r56, 1, "-->link to death error=" + e17.toString());
                                } catch (Exception e18) {
                                    QLog.d((String) r56, 1, "-->link to death error=" + e18.toString());
                                }
                            }
                            if (r36 != 0) {
                                r36.getEmojiListenerManager().addEmoticonPackageDownloadListener(messengerService11.f204469m);
                            }
                            r112.getMsgHandler().n3().U(messengerService11.C);
                            com.tencent.mobileqq.equipmentlock.c.f().g(r112, messengerService11.f204464d);
                            return;
                        }
                        if (i58 == 2) {
                            r56 = "MessengerService$IncomingHandler";
                            if (r36 != 0) {
                                r36.getEmojiListenerManager().removeEmoticonPackageDownloadListener(messengerService11.f204469m);
                            }
                            com.tencent.mobileqq.equipmentlock.c.f();
                            com.tencent.mobileqq.equipmentlock.c.m();
                            Messenger messenger2 = messengerService11.f204464d;
                            if (messenger2 != null) {
                                try {
                                    messenger2.getBinder().unlinkToDeath(this.f204474c, 0);
                                } catch (Exception e19) {
                                    QLog.d((String) r56, 1, "-->unlink to death error=" + e19.toString());
                                }
                                messengerService11.f204464d = null;
                                return;
                            }
                            return;
                        }
                        r56 = 3;
                        r56 = 3;
                        if (i58 != 3) {
                            super.handleMessage(message);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.emoji.web.MessengerService", 2, "Received server req: ");
                            }
                            final ?? data = message.getData();
                            if (data != 0) {
                                try {
                                    String string2 = data.getString("cmd");
                                    ?? bundle3 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                    String str27 = "";
                                    String str28 = "response";
                                    if (string2.equals("ipc_cmd_gamecenter_get_session_info")) {
                                        data.putBundle("response", ((IGameMsgManagerService) r112.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterSessionInfo(r112, bundle3.getInt("dataType"), bundle3.getString(VirtualAppProxy.KEY_GAME_ID)));
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_get_request_info")) {
                                        data.putBundle("response", ((IGameMsgManagerService) r112.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterRequestInfo(r112, bundle3.getString(VirtualAppProxy.KEY_GAME_ID)));
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_get_unread_total")) {
                                        data.putBundle("response", ((IGameMsgManagerService) r112.getRuntimeService(IGameMsgManagerService.class, "")).getGameCenterUnreadTotal());
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_metadream_get_session_unread_info")) {
                                        data.putBundle("response", ((IMetaDreamService) r112.getRuntimeService(IMetaDreamService.class, "")).getMetaDreamUnreadMsgInfoBundle());
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_open_aio")) {
                                        data.putBundle("response", ((IGameMsgManagerService) r112.getRuntimeService(IGameMsgManagerService.class, "")).openGameCenterAIO(r112, bundle3.getString("sessionId")));
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_del_game_session")) {
                                        data.putBundle("response", MessengerService.F(r112, bundle3.getString("sessionList")));
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_open_qqplayer_aio")) {
                                        ((IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class)).openGameMsgAIO(r112, r112.getApp().getApplicationContext(), bundle3.getString("fromRoleId"), bundle3.getString("fromOpenId"), bundle3.getString("toRoleId"), bundle3.getString("toOpenId"), bundle3.getString("topGrayText"), bundle3.getString(PreloadTRTCPlayerParams.KEY_SIG), bundle3.getLong("gameAppId"), bundle3.getString("fromTinyId"), bundle3.getString("toTinyId"), bundle3.getInt("windowFlag"), bundle3.getInt("fromPage", 0), bundle3.getString(WadlProxyConsts.EXT_JSON, ""));
                                        Bundle bundle4 = new Bundle();
                                        bundle4.putInt("result", 0);
                                        data.putBundle("response", bundle4);
                                        messengerService11.J(data);
                                        if (QLog.isColorLevel()) {
                                            QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:" + string2 + ",data:" + bundle4);
                                        }
                                    } else if (string2.equals("ipc_cmd_gamecenter_send_ark_from_friend_chooser")) {
                                        ((IGameCenterArkMsgSenderApi) QRoute.api(IGameCenterArkMsgSenderApi.class)).invokeFriendChooserThenSendArkMsg(bundle3.getString(GameCenterAPIJavaScript.PARAMS_KEY_RED_PACK_PAY), new m(data, messengerService11));
                                    } else if (string2.equals("ipc_cmd_gamecenter_send_ark_from_aio")) {
                                        ((IGameCenterArkMsgSenderApi) QRoute.api(IGameCenterArkMsgSenderApi.class)).sendArkMsg(bundle3.getString(GameCenterAPIJavaScript.PARAMS_KEY_RED_PACK_PAY), new n(data, messengerService11));
                                    } else if (string2.equals("ipc_cmd_gamecenter_toggle_changed")) {
                                        data.putBundle("response", MessengerService.L(r112, bundle3.getString(VirtualAppProxy.KEY_GAME_ID), bundle3.getInt("switchType"), bundle3.getInt("value")));
                                        messengerService11.J(data);
                                    } else if (string2.equals("ipc_cmd_gamecenter_set_push_state")) {
                                        boolean z16 = bundle3.getBoolean("state");
                                        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) r112.getRuntimeService(IGameMsgManagerService.class, "");
                                        if (iGameMsgManagerService != null) {
                                            iGameMsgManagerService.setH5PushMsgState(z16);
                                        }
                                    } else {
                                        String str29 = "id";
                                        if (string2.equals("queryEmojiInfo")) {
                                            Bundle downloadProgress = r36.getDownloadProgress(bundle3);
                                            if (QLog.isColorLevel() && downloadProgress != null) {
                                                QLog.i("Q.emoji.web.MessengerService", 2, "qq queryEmojiInfo: result:" + downloadProgress.getInt("result") + ";id:" + downloadProgress.getInt("id") + ";status:" + downloadProgress.getInt("status") + ";progress:" + downloadProgress.getInt("progress") + ";pluginStatus:" + downloadProgress.getInt("pluginStatus") + ";pluginSize:" + downloadProgress.getLong("pluginSize"));
                                            }
                                            if (downloadProgress != null) {
                                                data.putBundle("response", downloadProgress);
                                            }
                                            messengerService11.J(data);
                                        } else {
                                            String str30 = "MessengerService";
                                            try {
                                            } catch (Throwable th10) {
                                                th5 = th10;
                                            }
                                            if (!string2.equals("queryEmojiStickerInfos")) {
                                                String str31 = "response";
                                                try {
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                }
                                                if (string2.equals("emojiStickerRecall")) {
                                                    if (bundle3 != 0) {
                                                        MessageRecord w06 = r112.getMessageFacade().w0(EmojiStickerManager.k().f204590a, EmojiStickerManager.k().f204591b, Long.valueOf(bundle3.getString("messageSeq")).longValue());
                                                        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                                                        if (w06 != null && w06.msgtype == -2058 && serverTimeMillis - (w06.time * 1000) < 120000) {
                                                            EmojiStickerManager.E = bundle3.getString("recallCallbackId");
                                                            EmojiStickerManager.F = bundle3.getInt("reCallKey");
                                                            EmojiStickerManager.D = true;
                                                            QQMessageFacade messageFacade = r112.getMessageFacade();
                                                            r112.getMsgCache().S1(true);
                                                            messageFacade.b2(w06);
                                                        } else {
                                                            Bundle bundle5 = new Bundle();
                                                            bundle5.putInt("result", -1);
                                                            bundle5.putString("QQ", r112.getCurrentUin());
                                                            if (EmojiStickerManager.k().f204591b == 0) {
                                                                i39 = 1;
                                                            } else if (EmojiStickerManager.k().f204591b == 1) {
                                                                i39 = 2;
                                                            } else {
                                                                i39 = EmojiStickerManager.k().f204591b == 3000 ? 3 : -1;
                                                            }
                                                            bundle5.putInt("chatType", i39);
                                                            data.putBundle(str31, bundle5);
                                                            messengerService11.J(data);
                                                        }
                                                    }
                                                } else if (string2.equals("ipc_plateofking_switch")) {
                                                    if (bundle3 != 0) {
                                                        int i59 = bundle3.getInt("status");
                                                        r112.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).edit().putBoolean("plate_of_king_display_switch_" + r112.getCurrentUin(), i59 == 1).apply();
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("MessengerService", 2, "IPC_CMD_PLATEOFKING_SWITCH status == " + i59);
                                                        }
                                                    }
                                                } else if (string2.equals("emojiStickerAddFavorites")) {
                                                    if (bundle3 != 0) {
                                                        MessageRecord w07 = r112.getMessageFacade().w0(EmojiStickerManager.k().f204590a, EmojiStickerManager.k().f204591b, Long.valueOf(bundle3.getString("messageSeq")).longValue());
                                                        if ((w07 instanceof MessageForPic) && w07.msgtype == -2058) {
                                                            MessageForPic messageForPic = (MessageForPic) w07;
                                                            URLDrawable drawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(messageForPic, 1), -1, -1, null, null, false);
                                                            drawable.setTag(messageForPic);
                                                            EmojiStickerManager.b(r112.getApp(), r112, drawable, messageForPic.frienduin, messageForPic.picExtraData, messengerService11, data);
                                                        } else {
                                                            Bundle bundle6 = new Bundle();
                                                            bundle6.putInt("result", -2);
                                                            data.putBundle(str31, bundle6);
                                                            messengerService11.J(data);
                                                        }
                                                    }
                                                } else if (string2.equals("queryEmojiInfos")) {
                                                    Bundle allDownloadProgress = r36.getAllDownloadProgress(bundle3 != 0 ? bundle3.getInt("sceneType") : 0);
                                                    if (allDownloadProgress != null) {
                                                        data.putBundle(str31, allDownloadProgress);
                                                    }
                                                    messengerService11.J(data);
                                                } else if (string2.equals("startDownloadEmoji")) {
                                                    Bundle startDownloadEmoji = ((IEmojiManagerService) r112.getRuntimeService(IEmojiManagerService.class)).startDownloadEmoji(bundle3);
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("Q.emoji.web.MessengerService", 2, "qq startDownloadEmoji: result:" + startDownloadEmoji.getInt("result") + ";messge:" + startDownloadEmoji.getString("message"));
                                                    }
                                                    data.putBundle(str31, startDownloadEmoji);
                                                    messengerService11.J(data);
                                                } else if (string2.equals("stopDownloadEmoji")) {
                                                    Bundle stopDownloadPacket = ((IEmojiManagerService) r112.getRuntimeService(IEmojiManagerService.class)).stopDownloadPacket(String.valueOf(bundle3.getInt("id")), bundle3.getInt("sceneType"));
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("Q.emoji.web.MessengerService", 2, "qq stopDownloadEmoji: result:" + stopDownloadPacket.getInt("result") + ";messge:" + stopDownloadPacket.getString("messge"));
                                                    }
                                                    data.putBundle(str31, stopDownloadPacket);
                                                    messengerService11.J(data);
                                                } else if (!"writeQFaceResult".equals(string2)) {
                                                    if ("getFaceFilePath".equals(string2)) {
                                                        String customFaceFilePath = r112.getCustomFaceFilePath(1, data.getBundle(Const.BUNDLE_KEY_REQUEST).getString("uin"), 0);
                                                        Bundle bundle7 = new Bundle();
                                                        bundle7.putString("faceFilePath", customFaceFilePath);
                                                        data.putBundle(str31, bundle7);
                                                        messengerService11.J(data);
                                                    } else if ("changeAvatar".equals(string2)) {
                                                        boolean h06 = ProfileCardUtil.h0(r112, data.getBundle(Const.BUNDLE_KEY_REQUEST).getString("path"), null);
                                                        Bundle bundle8 = new Bundle();
                                                        bundle8.putBoolean("updateResult", h06);
                                                        data.putBundle(str31, bundle8);
                                                        messengerService11.J(data);
                                                    } else {
                                                        ?? equals = "updatePendantId".equals(string2);
                                                        try {
                                                        } catch (Throwable th12) {
                                                            th5 = th12;
                                                        }
                                                        if (equals != 0) {
                                                            Bundle bundle9 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                            String string3 = bundle9.getString("uin");
                                                            long j18 = bundle9.getLong("pendantId");
                                                            boolean z17 = bundle9.getBoolean("is_diypendant");
                                                            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(string3), string3);
                                                            nTVasSimpleInfo.c();
                                                            if (!z17) {
                                                                nTVasSimpleInfo.pendantDiyId = 0;
                                                            }
                                                            nTVasSimpleInfo.pendantId = j18;
                                                            nTVasSimpleInfo.timestamp = System.currentTimeMillis();
                                                            IncomingHandler incomingHandler10 = this;
                                                            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "Q.emoji.web.MessengerService", new o(data, messengerService11));
                                                            incomingHandler9 = incomingHandler10;
                                                        } else {
                                                            equals = this;
                                                            try {
                                                            } catch (Throwable th13) {
                                                                th = th13;
                                                            }
                                                            if ("getPendantNumberPic".equals(string2)) {
                                                                try {
                                                                    new com.tencent.mobileqq.addon.a(new JSONObject(data.getBundle(Const.BUNDLE_KEY_REQUEST).getString("params")), data, equals.f204473b).invalidateSelf();
                                                                    incomingHandler9 = equals;
                                                                } catch (Exception e26) {
                                                                    QLog.e("MessengerService", 1, e26.getMessage());
                                                                    incomingHandler9 = equals;
                                                                }
                                                            } else if ("reportActionCount".equals(string2)) {
                                                                ISVIPHandler iSVIPHandler = (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                                                                ReportController.o(r112, "CliOper", "", "", bundle3.getString("optype"), bundle3.getString("opname"), 0, 1, iSVIPHandler.getSelfBubbleId() + "", ff.h(r112, r112.getCurrentAccountUin()), NetworkUtil.getNetworkType(r112.getApp()) + "", null);
                                                                incomingHandler9 = equals;
                                                            } else {
                                                                ?? r152 = "";
                                                                if (ColorRingJsPlugin.Method_SetUp.equals(string2)) {
                                                                    try {
                                                                        int i65 = bundle3.getInt("id", -1);
                                                                        int i66 = bundle3.getInt("voiceprintId", -1);
                                                                        ISVIPHandler iSVIPHandler2 = (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                                                                        Bundle bundle10 = new Bundle();
                                                                        if (i65 > -1) {
                                                                            iSVIPHandler2.setSelfBubbleId(i65);
                                                                            bundle10.putInt("id", i65);
                                                                            i38 = -1;
                                                                        } else {
                                                                            i38 = -1;
                                                                        }
                                                                        if (i66 > i38) {
                                                                            iSVIPHandler2.setSelfBubbleVoicePrintId(i66);
                                                                        }
                                                                        data.putBundle(str31, bundle10);
                                                                        messengerService11.J(data);
                                                                        incomingHandler9 = equals;
                                                                    } catch (Exception e27) {
                                                                        e27.printStackTrace();
                                                                        incomingHandler9 = equals;
                                                                    }
                                                                } else if ("diy_setup".equals(string2)) {
                                                                    try {
                                                                        int i67 = bundle3.getInt("id");
                                                                        int i68 = bundle3.getInt("textId");
                                                                        ISVIPHandler iSVIPHandler3 = (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                                                                        iSVIPHandler3.setSelfBubbleId(i67);
                                                                        iSVIPHandler3.setSelfBubbleDiyTextId(i68, true);
                                                                        Bundle bundle11 = new Bundle();
                                                                        bundle11.putInt("id", i67);
                                                                        data.putBundle(str31, bundle11);
                                                                        messengerService11.J(data);
                                                                        incomingHandler9 = equals;
                                                                    } catch (Exception e28) {
                                                                        e28.printStackTrace();
                                                                        incomingHandler9 = equals;
                                                                    }
                                                                } else if ("queryLocal".equals(string2)) {
                                                                    ISVIPHandler iSVIPHandler4 = (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                                                                    int selfBubbleId = iSVIPHandler4.getSelfBubbleId();
                                                                    Bundle bundle12 = new Bundle();
                                                                    bundle12.putInt("id", selfBubbleId);
                                                                    data.putBundle(str31, bundle12);
                                                                    int selfBubbleDiyTextId = (selfBubbleId <= 0 || (hashMap = BubbleDiyFetcher.m().f200571i.get(Integer.valueOf(selfBubbleId))) == null || hashMap.size() <= 0) ? 0 : iSVIPHandler4.getSelfBubbleDiyTextId();
                                                                    int selfBubbleVoicePrintId = iSVIPHandler4.getSelfBubbleVoicePrintId();
                                                                    if (selfBubbleVoicePrintId > 0) {
                                                                        bundle12.putInt("voiceprintId", selfBubbleVoicePrintId);
                                                                    }
                                                                    if (selfBubbleDiyTextId > 0) {
                                                                        BubbleDiyFetcher.m().h(r112, r112.getAccount() + "_" + selfBubbleDiyTextId, new p(bundle12, messengerService11, data));
                                                                        incomingHandler9 = equals;
                                                                    } else {
                                                                        messengerService11.J(data);
                                                                        incomingHandler9 = equals;
                                                                    }
                                                                } else if ("queryPraiseLocal".equals(string2)) {
                                                                    int f16 = PraiseManager.f(r112);
                                                                    Bundle bundle13 = new Bundle();
                                                                    bundle13.putInt("id", f16);
                                                                    data.putBundle(str31, bundle13);
                                                                    messengerService11.J(data);
                                                                    incomingHandler9 = equals;
                                                                } else {
                                                                    incomingHandler9 = equals;
                                                                    if (!"setupPraise".equals(string2)) {
                                                                        incomingHandler9 = equals;
                                                                        if ("stopdownload".equals(string2)) {
                                                                            if (bundle3 != 0) {
                                                                                Bundle bundle14 = new Bundle();
                                                                                String string4 = bundle3.getString("url");
                                                                                String string5 = bundle3.getString("themeId");
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d("Q.emoji.web.MessengerService", 2, "IPC_THEME_STOPDOWNLOAD, id:" + string5 + ", url:" + string4);
                                                                                }
                                                                                bundle14.putBoolean("processor", true);
                                                                                data.putBundle(str31, bundle14);
                                                                                messengerService11.J(data);
                                                                                incomingHandler9 = equals;
                                                                            }
                                                                        } else if ("reportTheme".equals(string2)) {
                                                                            String string6 = bundle3.getString("themeId");
                                                                            int i69 = bundle3.getInt("actionResult");
                                                                            int systemNetwork = NetworkUtil.getSystemNetwork(null);
                                                                            String string7 = bundle3.getString("actionName");
                                                                            if (!TextUtils.isEmpty(string7)) {
                                                                                long j19 = bundle3.getLong(PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME);
                                                                                int currentUserVipType = ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
                                                                                if (currentUserVipType == 2) {
                                                                                    currentUserVipType = 0;
                                                                                } else if (currentUserVipType == 3) {
                                                                                    currentUserVipType = 2;
                                                                                }
                                                                                ?? sb5 = new StringBuilder();
                                                                                sb5.append(r152);
                                                                                sb5.append(currentUserVipType);
                                                                                ReportController.o(r112, "CliOper", "", "", "theme_mall", string7, 0, i69, string6, sb5.toString(), String.valueOf(systemNetwork), String.valueOf(j19));
                                                                            }
                                                                            String string8 = bundle3.getString("statistic_key");
                                                                            if (!TextUtils.isEmpty(string8)) {
                                                                                try {
                                                                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                                                                    hashMap2.put("param_themeId", string6);
                                                                                    hashMap2.put(com.tencent.mobileqq.msf.core.c0.j.I0, String.valueOf(systemNetwork));
                                                                                    hashMap2.put("param_FailCode", bundle3.getString("param_FailCode"));
                                                                                    StatisticCollector.getInstance(r112.getApplication().getApplicationContext()).collectPerformance(r112.getAccount(), string8, i69 == 0, 1L, 0L, hashMap2, "", false);
                                                                                } catch (Exception e29) {
                                                                                    if (QLog.isColorLevel()) {
                                                                                        QLog.e(StatisticCollector.TAG, 2, "StatisticCollector Error:" + e29.getMessage());
                                                                                    }
                                                                                }
                                                                            }
                                                                            String string9 = bundle3.getString("from");
                                                                            incomingHandler9 = equals;
                                                                            if (!TextUtils.isEmpty(string9)) {
                                                                                int i75 = bundle3.getInt("step");
                                                                                int i76 = bundle3.getInt("code");
                                                                                String string10 = bundle3.getString("version");
                                                                                String string11 = bundle3.getString("path");
                                                                                String string12 = bundle3.getString("r5");
                                                                                ThemeReporter.reportTheme(r112, ThemeReporter.SUBACTION_THEME, string9, i75, systemNetwork, i76, string6, string10, string11, TextUtils.isEmpty(string12) ? r152 : string12);
                                                                                incomingHandler9 = equals;
                                                                            }
                                                                        } else if ("authTheme".equals(string2)) {
                                                                            incomingHandler9 = equals;
                                                                        } else if ("setSVTheme".equals(string2)) {
                                                                            String string13 = bundle3.getString("themeId");
                                                                            String string14 = bundle3.getString("version");
                                                                            String string15 = bundle3.getString("seriesID");
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.d("Q.emoji.web.MessengerService", 2, "IPC_THEME_SET_SERVER mesgSver themeId:" + string13 + ", version:" + string14 + ", seriesId:" + string15);
                                                                            }
                                                                            ((ThemeHandler) r112.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).T2(string13, string14, string15, data, equals.f204476e);
                                                                            incomingHandler9 = equals;
                                                                        } else if ("themeSwitchSucess".equals(string2)) {
                                                                            String string16 = bundle3.getString("themeId");
                                                                            ThemeUtil.setCurrentThemeIdVersion(r112, string16, "20000000");
                                                                            ThemeUtil.setWeekLoopTheme(r112, bundle3.getString("seriesID"), bundle3.getString("themeArray"), bundle3.getLong("startTime", 0L));
                                                                            ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) r112.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                                                                            String string17 = ThemeBackground.getSharedPreferences(r112.getApp(), r112.getAccount(), 0).getString(AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, "null");
                                                                            String o16 = chatBackgroundManager.o(null);
                                                                            if (string17 != null && !"null".equals(string17) && o16 != null && string17.equals(o16)) {
                                                                                chatBackgroundManager.z(r112.getAccount(), null, "null", -1);
                                                                            }
                                                                            ThemeReporter.reportTheme(r112, ThemeReporter.SUBACTION_THEME, "200", 155, NetworkUtil.getSystemNetwork(null), 31, string16, "20000000", ThemeReporter.PATH_DOWNLOAD, "");
                                                                            incomingHandler9 = equals;
                                                                        } else if ("weekLoopGetData".equals(string2)) {
                                                                            ?? uinThemePreferences = ThemeUtil.getUinThemePreferences(r112);
                                                                            String string18 = uinThemePreferences.getString("seriesID", r152);
                                                                            String string19 = uinThemePreferences.getString("themeArray", r152);
                                                                            Bundle bundle15 = new Bundle();
                                                                            bundle15.putString("seriesID", string18);
                                                                            bundle15.putString("themeArray", string19);
                                                                            data.putBundle(str31, bundle15);
                                                                            messengerService11.J(data);
                                                                            incomingHandler9 = equals;
                                                                        } else if ("themeQueryLocal".equals(string2)) {
                                                                            bundle3.getString("themeId");
                                                                            SharedPreferences themePreferences = ThemeUtil.getThemePreferences(r112.getApplication());
                                                                            JSONObject jSONObject5 = new JSONObject();
                                                                            String jSONObject6 = jSONObject5.toString();
                                                                            try {
                                                                                Map<String, ?> all = themePreferences.getAll();
                                                                                if (all != null) {
                                                                                    Pattern compile = Pattern.compile("[0-9]*");
                                                                                    for (String str32 : all.keySet()) {
                                                                                        if (compile.matcher(str32).matches()) {
                                                                                            String string20 = themePreferences.getString(str32, null);
                                                                                            if (!TextUtils.isEmpty(string20)) {
                                                                                                String[] split = string20.split(",");
                                                                                                if (split.length >= 5) {
                                                                                                    JSONObject jSONObject7 = new JSONObject();
                                                                                                    Long valueOf = Long.valueOf(Long.parseLong(split[4]));
                                                                                                    Long valueOf2 = Long.valueOf(Long.parseLong(split[5]));
                                                                                                    String str33 = split[6];
                                                                                                    if (valueOf.longValue() > 0) {
                                                                                                        str14 = jSONObject6;
                                                                                                        try {
                                                                                                            i37 = (int) Math.floor(((valueOf2.longValue() * 1.0d) / valueOf.longValue()) * 100.0d);
                                                                                                        } catch (Throwable th14) {
                                                                                                            th = th14;
                                                                                                            QLog.e("Q.emoji.web.MessengerService", 1, "queryLocal Exception\uff1a" + th.getMessage());
                                                                                                            str15 = str14;
                                                                                                            if (QLog.isColorLevel()) {
                                                                                                            }
                                                                                                            Bundle bundle16 = new Bundle();
                                                                                                            bundle16.putString("themeId", str15);
                                                                                                            data.putBundle(str31, bundle16);
                                                                                                            messengerService11.J(data);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else {
                                                                                                        str14 = jSONObject6;
                                                                                                        i37 = 0;
                                                                                                    }
                                                                                                    jSONObject7.put("progress", Math.min(100, i37));
                                                                                                    if ("5".equals(str33)) {
                                                                                                        str33 = "3";
                                                                                                    }
                                                                                                    jSONObject7.put("status", str33);
                                                                                                    jSONObject5.put(str32, jSONObject7);
                                                                                                } else {
                                                                                                    str14 = jSONObject6;
                                                                                                    QLog.e("Q.emoji.web.MessengerService", 1, "queryLocal error themeidStr=" + str32 + ", str=" + split);
                                                                                                }
                                                                                                jSONObject6 = str14;
                                                                                            }
                                                                                        }
                                                                                        str14 = jSONObject6;
                                                                                        jSONObject6 = str14;
                                                                                    }
                                                                                }
                                                                                str14 = jSONObject6;
                                                                                str15 = jSONObject5.toString();
                                                                            } catch (Throwable th15) {
                                                                                th = th15;
                                                                                str14 = jSONObject6;
                                                                            }
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.i("Q.emoji.web.MessengerService", 2, "queryLocal end themeidStr:" + str15);
                                                                            }
                                                                            Bundle bundle162 = new Bundle();
                                                                            bundle162.putString("themeId", str15);
                                                                            data.putBundle(str31, bundle162);
                                                                            messengerService11.J(data);
                                                                        } else if ("rpWebGetBitmap".equals(string2)) {
                                                                            ((IndividualRedPacketManager) r112.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER)).m(bundle3.getString("templateId"), bundle3.getString("content"), data, messengerService11);
                                                                        } else if ("businessNotifyContact".equals(string2)) {
                                                                            ReportController.o(r112, "dc00898", "", "", "0X80068B0", "0X80068B0", 0, 0, "", "", "", "");
                                                                            ((IPhoneContactService) r112.getRuntimeService(IPhoneContactService.class, r152)).checkUpdateBindStateAndListIgnoreBindState(true, false, 12);
                                                                        } else if ("rpWebSetFlags".equals(string2)) {
                                                                            int i77 = bundle3.getInt("iCanUseRed", -1);
                                                                            int i78 = bundle3.getInt("iRedDisable", -1);
                                                                            if (i77 >= 0 || i78 >= 0) {
                                                                                ((IndividualRedPacketManager) r112.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER)).Q(i77, i78, true);
                                                                            }
                                                                        } else if ("rpWebSetRedpacketInfo".equals(string2)) {
                                                                            int i79 = bundle3.getInt("iRedPacketId", -1);
                                                                            String string21 = bundle3.getString("sRedPackRemard");
                                                                            if (QLog.isColorLevel()) {
                                                                                QLog.d("MessengerService", 2, "IPC_RED_PACKET_WEB_SET_REDPACKETINFO iRedPacketId = " + i79 + ";sRedPackRemard = " + string21);
                                                                            }
                                                                            IndividualRedPacketManager individualRedPacketManager = (IndividualRedPacketManager) r112.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
                                                                            if (individualRedPacketManager != null) {
                                                                                individualRedPacketManager.R(i79, string21);
                                                                                individualRedPacketManager.C();
                                                                            }
                                                                        } else if ("rpWebInitTemplate".equals(string2)) {
                                                                            ((IndividualRedPacketManager) r112.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER)).e(bundle3.getString("templateId"), data, messengerService11);
                                                                        } else if ("getUserVipType".equals(string2)) {
                                                                            Bundle bundle17 = new Bundle();
                                                                            ISVIPHandler iSVIPHandler5 = (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                                                                            String string22 = bundle3.getString("uin");
                                                                            int currentUserVipType2 = iSVIPHandler5.getCurrentUserVipType();
                                                                            bundle17.putString("uin", string22);
                                                                            bundle17.putInt("type", currentUserVipType2);
                                                                            data.putBundle(str31, bundle17);
                                                                            messengerService11.J(data);
                                                                        } else {
                                                                            ?? r132 = "type";
                                                                            if ("notifyTroopUpgradeSuccess".equals(string2)) {
                                                                                r112.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER).notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS, true, new Object[]{bundle3.getString("groupId"), Integer.valueOf(bundle3.getInt(r132))});
                                                                            } else if ("chatbackground_setbg".equals(string2)) {
                                                                                String string23 = bundle3.getString("path");
                                                                                String string24 = bundle3.getString("friendUin");
                                                                                String string25 = bundle3.getString("from");
                                                                                String string26 = bundle3.getString("name");
                                                                                String string27 = bundle3.getString(VipFunCallConstants.KEY_FEET_TYPE);
                                                                                String string28 = bundle3.getString("id");
                                                                                Intent intent = (Intent) bundle3.getParcelable("intent");
                                                                                String string29 = bundle3.getString("url");
                                                                                ChatBackgroundManager chatBackgroundManager2 = (ChatBackgroundManager) r112.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
                                                                                chatBackgroundManager2.z(r112.getAccount(), string24, string23, intent.getExtras().getInt("uintype", 0));
                                                                                chatBackgroundManager2.a(intent);
                                                                                chatBackgroundManager2.r(r112.getApplication().getApplicationContext(), r112.getAccount());
                                                                                try {
                                                                                    i36 = Integer.valueOf(string27).intValue();
                                                                                } catch (Exception e36) {
                                                                                    e36.printStackTrace();
                                                                                    QLog.e("MessengerService", 1, "setbg exception ", e36);
                                                                                    i36 = 1;
                                                                                }
                                                                                ThemeBackground.setThemeBackgroundPic(r112.getApplication().getApplicationContext(), AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, r112.getAccount(), string23, string29, string28, string26, i36, null, false);
                                                                                if (string25 != null && string25.equals("chatbgJs")) {
                                                                                    Bundle bundle18 = new Bundle();
                                                                                    bundle18.putInt("result", 0);
                                                                                    data.putBundle(str31, bundle18);
                                                                                    v61.a b16 = v61.b.a().b();
                                                                                    data.putBoolean("existScaleAIO", b16 != null && b16.d());
                                                                                    messengerService11.J(data);
                                                                                }
                                                                                if (!TextUtils.isEmpty(string24)) {
                                                                                    Bundle bundle19 = new Bundle();
                                                                                    bundle19.putString("cmd", "chatbackground_setbg");
                                                                                    data.putBundle(str31, bundle19);
                                                                                    messengerService11.J(data);
                                                                                }
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d("MessengerService", 2, "setbgjumpAIO:", "sendToClient," + string25 + "," + string24);
                                                                                }
                                                                            } else {
                                                                                String str34 = "result";
                                                                                if ("ipc_h5magic_sendmsg".equals(string2)) {
                                                                                    bundle3.setClassLoader(SessionInfo.class.getClassLoader());
                                                                                    Emoticon emoticon = (Emoticon) bundle3.getSerializable("emoticon");
                                                                                    ChatActivityFacade.H0(r112, r112.getApplication().getApplicationContext(), (SessionInfo) bundle3.getParcelable("sessionInfo"), emoticon);
                                                                                    if (emoticon != null && QLog.isColorLevel()) {
                                                                                        QLog.d("MessengerService", 2, "send childEmoticon: childEmotcionEpid = " + emoticon.epId);
                                                                                    }
                                                                                } else if ("myIndividuationRedInfo".equals(string2)) {
                                                                                    String string30 = bundle3.getString("path");
                                                                                    if (string30 != null) {
                                                                                        ((IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152)).onRedTouchItemClick(string30);
                                                                                    }
                                                                                } else if ("redTouch_getRedInfo".equals(string2)) {
                                                                                    String string31 = bundle3.getString("path");
                                                                                    String string32 = bundle3.getString("callbackid");
                                                                                    IRedTouchManager iRedTouchManager = (IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152);
                                                                                    BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(string31);
                                                                                    RedAppInfo a16 = com.tencent.mobileqq.redtouch.g.a(appInfoByPath2);
                                                                                    Bundle bundle20 = new Bundle();
                                                                                    bundle20.putParcelable("redInfo", a16);
                                                                                    bundle20.putString("path", string31);
                                                                                    String string33 = bundle3.getString("subCmd");
                                                                                    if (string33 != null && !"redTouch_getIndividuationType".equals(string33)) {
                                                                                        if ("redTouch_reportRedTouch".equals(string33)) {
                                                                                            bundle20.putInt("isWithRedPoint", bundle3.getInt("isWithRedPoint"));
                                                                                            iRedTouchManager.onReportRedPointClickWithMissions(appInfoByPath2, bundle3.getInt("isWithRedPoint") == 1, bundle3.getStringArrayList("missions"));
                                                                                            return;
                                                                                        }
                                                                                        if ("redTouch_reportBusinessRedTouch".equals(string33)) {
                                                                                            bundle20.putString(ark.ARKMETADATA_JSON, bundle3.getString(ark.ARKMETADATA_JSON));
                                                                                        } else if ("redTouch_getAppInfo".equals(string33)) {
                                                                                            String string34 = bundle3.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
                                                                                            bundle20.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, string34);
                                                                                            String lastClickPath = RedTouchUtil.getLastClickPath(r112);
                                                                                            if (!TextUtils.isEmpty(string31)) {
                                                                                                string31.equals(lastClickPath);
                                                                                            }
                                                                                            if (QLog.isColorLevel()) {
                                                                                                QLog.i("MessengerService", 2, "getAppInfo: serial " + string34 + ";path = " + string31 + ";callback = " + string32);
                                                                                            }
                                                                                        } else {
                                                                                            "redTouch_getRedPointShowInfo_path".equals(string33);
                                                                                        }
                                                                                    }
                                                                                    bundle20.putString("subCmd", string33);
                                                                                    data.putBundle(str31, bundle20);
                                                                                    messengerService11.J(data);
                                                                                } else if ("redTouch_getAppInfo_report".equals(string2)) {
                                                                                    String string35 = bundle3.getString("ret");
                                                                                    String string36 = bundle3.getString("buffer");
                                                                                    String string37 = bundle3.getString("red");
                                                                                    String string38 = bundle3.getString("path");
                                                                                    String string39 = bundle3.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
                                                                                    String string40 = bundle3.getString("callback");
                                                                                    ArrayList<String> stringArrayList = bundle3.getStringArrayList("missions");
                                                                                    IRedTouchManager iRedTouchManager2 = (IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152);
                                                                                    iRedTouchManager2.getAndSetAppInfoJsReport(12, stringArrayList, string37, string35, string36, string39, string40, iRedTouchManager2.getAppIdByPath(string38));
                                                                                } else if ("redTouch_setAppInfo".equals(string2)) {
                                                                                    bundle3.setClassLoader(RedAppInfo.class.getClassLoader());
                                                                                    BusinessInfoCheckUpdate.AppInfo e37 = com.tencent.mobileqq.redtouch.g.e((RedAppInfo) bundle3.getParcelable("red"));
                                                                                    IRedTouchManager iRedTouchManager3 = (IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152);
                                                                                    if (e37 != null) {
                                                                                        ArrayList<String> arrayList5 = new ArrayList<>();
                                                                                        arrayList5.addAll(e37.missions.get());
                                                                                        String setAppInfoReportMsg = iRedTouchManager3.getSetAppInfoReportMsg(e37.path.get(), e37.buffer.get());
                                                                                        ?? sb6 = new StringBuilder();
                                                                                        sb6.append(e37.iNewFlag.get());
                                                                                        sb6.append(r152);
                                                                                        iRedTouchManager3.getAndSetAppInfoJsReport(13, arrayList5, sb6.toString(), "", setAppInfoReportMsg, "", "", iRedTouchManager3.getAppIdByPath(e37.path.get()));
                                                                                    }
                                                                                    int updateAppInfo = iRedTouchManager3.updateAppInfo(e37, false);
                                                                                    Bundle bundle21 = new Bundle();
                                                                                    bundle21.putInt("iret", updateAppInfo);
                                                                                    data.putBundle(str31, bundle21);
                                                                                    messengerService11.J(data);
                                                                                } else if ("redTouch_getRedPointShowInfo_set".equals(string2)) {
                                                                                    BusinessInfoCheckUpdate.RedTypeInfo redTouchInfoByAppSet = ((IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152)).getRedTouchInfoByAppSet(bundle3.getInt("setId"));
                                                                                    RedTypeInfo redTypeInfo = new RedTypeInfo();
                                                                                    if (redTouchInfoByAppSet != null) {
                                                                                        redTypeInfo.setRedContent(redTouchInfoByAppSet.red_content.get());
                                                                                        redTypeInfo.setRedDesc(redTouchInfoByAppSet.red_desc.get());
                                                                                        redTypeInfo.setRedPriority(redTouchInfoByAppSet.red_priority.get());
                                                                                        redTypeInfo.setRedType(redTouchInfoByAppSet.red_type.get());
                                                                                    }
                                                                                    Bundle bundle22 = new Bundle();
                                                                                    bundle22.putSerializable("redInfo", redTypeInfo);
                                                                                    data.putBundle(str31, bundle22);
                                                                                    messengerService11.J(data);
                                                                                } else {
                                                                                    HashMap<String, Integer> hashMap3 = IPCConstants.M3;
                                                                                    if (hashMap3.containsKey(string2)) {
                                                                                        int intValue = hashMap3.get(string2).intValue();
                                                                                        if (intValue != 8) {
                                                                                            try {
                                                                                                switch (intValue) {
                                                                                                    case 1:
                                                                                                        incomingHandler9 = this;
                                                                                                        int i85 = bundle3.getInt("id");
                                                                                                        ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfFontInfo(i85, bundle3.getInt(r132));
                                                                                                        Bundle bundle23 = new Bundle();
                                                                                                        bundle23.putInt("id", i85);
                                                                                                        bundle23.putInt(str34, 0);
                                                                                                        bundle23.putString("message", "success");
                                                                                                        data.putBundle(str31, bundle23);
                                                                                                        messengerService11.J(data);
                                                                                                        break;
                                                                                                    case 2:
                                                                                                        incomingHandler9 = this;
                                                                                                        int i86 = bundle3.getInt("id");
                                                                                                        JSONObject queryInfo = bundle3.getInt("fontOrhiboom", 0) != 0 ? null : ((IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152)).queryInfo(i86, bundle3.getInt(r132));
                                                                                                        Bundle bundle24 = new Bundle();
                                                                                                        bundle24.putInt("id", i86);
                                                                                                        String str35 = r152;
                                                                                                        if (queryInfo != null) {
                                                                                                            str35 = queryInfo.toString();
                                                                                                        }
                                                                                                        bundle24.putString(str34, str35);
                                                                                                        data.putBundle(str31, bundle24);
                                                                                                        messengerService11.J(data);
                                                                                                        break;
                                                                                                    case 3:
                                                                                                        incomingHandler9 = this;
                                                                                                        int i87 = bundle3.getInt("id");
                                                                                                        int i88 = bundle3.getInt(r132);
                                                                                                        String string41 = data.getString("callbackid");
                                                                                                        IFontManagerService iFontManagerService = (IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152);
                                                                                                        iFontManagerService.registerIPCDownloadListener(messengerService11.F);
                                                                                                        iFontManagerService.startDownload(i87, string41, i88);
                                                                                                        break;
                                                                                                    case 4:
                                                                                                        r132 = this;
                                                                                                        int i89 = bundle3.getInt("id");
                                                                                                        ((IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152)).stopDownload(i89);
                                                                                                        Bundle bundle25 = new Bundle();
                                                                                                        bundle25.putInt("id", i89);
                                                                                                        data.putBundle(str31, bundle25);
                                                                                                        messengerService11.J(data);
                                                                                                        incomingHandler9 = r132;
                                                                                                        break;
                                                                                                    case 5:
                                                                                                        r132 = this;
                                                                                                        int i95 = bundle3.getInt("id");
                                                                                                        String string42 = data.getString("callbackid");
                                                                                                        BubbleManager bubbleManager = (BubbleManager) r112.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
                                                                                                        bubbleManager.D0(messengerService11.F);
                                                                                                        bubbleManager.G0(i95, string42);
                                                                                                        incomingHandler9 = r132;
                                                                                                        break;
                                                                                                    case 6:
                                                                                                        r132 = this;
                                                                                                        int i96 = bundle3.getInt("id");
                                                                                                        JSONObject B0 = ((BubbleManager) r112.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).B0(i96);
                                                                                                        Bundle bundle26 = new Bundle();
                                                                                                        bundle26.putInt("id", i96);
                                                                                                        bundle26.putString(str34, B0.toString());
                                                                                                        data.putBundle(str31, bundle26);
                                                                                                        messengerService11.J(data);
                                                                                                        incomingHandler9 = r132;
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (intValue) {
                                                                                                            case 16:
                                                                                                                r132 = this;
                                                                                                                int colorScreenId = ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getColorScreenId(r112.getCurrentAccountUin());
                                                                                                                Bundle bundle27 = new Bundle();
                                                                                                                bundle27.putInt("id", colorScreenId);
                                                                                                                data.putBundle(str31, bundle27);
                                                                                                                messengerService11.J(data);
                                                                                                                incomingHandler9 = r132;
                                                                                                                break;
                                                                                                            case 17:
                                                                                                                int i97 = bundle3.getInt("id");
                                                                                                                IncomingHandler incomingHandler11 = this;
                                                                                                                q qVar = new q(i97, (ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER), r112, data, messengerService11);
                                                                                                                if (i97 > 0) {
                                                                                                                    VasUtil.getSignedService(r112).getColorScreen().a(i97, qVar);
                                                                                                                    r132 = incomingHandler11;
                                                                                                                } else {
                                                                                                                    qVar.onComplete(null, null);
                                                                                                                    r132 = incomingHandler11;
                                                                                                                }
                                                                                                                incomingHandler9 = r132;
                                                                                                                break;
                                                                                                            case 18:
                                                                                                                AuthorizeConfig.y().c0();
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            case 19:
                                                                                                                int i98 = bundle3.getInt("id");
                                                                                                                if (i98 >= 0) {
                                                                                                                    ((ao) r112.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f.i(r112.getCurrentAccountUin(), i98);
                                                                                                                }
                                                                                                                Bundle bundle28 = new Bundle();
                                                                                                                bundle28.putInt("id", i98);
                                                                                                                bundle28.putInt(str34, i98 >= 0 ? 0 : 1);
                                                                                                                data.putBundle(str31, bundle28);
                                                                                                                messengerService11.J(data);
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            case 20:
                                                                                                                boolean sendEmojiToAio = r36.sendEmojiToAio((Emoticon) bundle3.getSerializable("emoticon"));
                                                                                                                Bundle bundle29 = new Bundle();
                                                                                                                bundle29.putBoolean(str34, sendEmojiToAio);
                                                                                                                data.putBundle(str31, bundle29);
                                                                                                                messengerService11.J(data);
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            case 21:
                                                                                                                boolean isEmojiCollected = r36.isEmojiCollected((Emoticon) bundle3.getSerializable("emoticon"));
                                                                                                                Bundle bundle30 = new Bundle();
                                                                                                                bundle30.putBoolean(str34, isEmojiCollected);
                                                                                                                data.putBundle(str31, bundle30);
                                                                                                                messengerService11.J(data);
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            case 22:
                                                                                                                int collectEmoji = r36.collectEmoji((Emoticon) bundle3.getSerializable("emoticon"));
                                                                                                                Bundle bundle31 = new Bundle();
                                                                                                                bundle31.putInt(str34, collectEmoji);
                                                                                                                data.putBundle(str31, bundle31);
                                                                                                                messengerService11.J(data);
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            case 23:
                                                                                                                ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(110, true, bundle3);
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                            default:
                                                                                                                switch (intValue) {
                                                                                                                    case 4001:
                                                                                                                        ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setMagicFont(bundle3.getInt("magic_setup"));
                                                                                                                        Bundle bundle32 = new Bundle();
                                                                                                                        bundle32.putInt(str34, 0);
                                                                                                                        bundle32.putString("message", "success");
                                                                                                                        data.putBundle(str31, bundle32);
                                                                                                                        messengerService11.J(data);
                                                                                                                        break;
                                                                                                                    case 4002:
                                                                                                                        IFontManagerService iFontManagerService2 = (IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152);
                                                                                                                        Bundle bundle33 = new Bundle();
                                                                                                                        bundle33.putInt(str34, iFontManagerService2.getFounderFontAbility() ? 1 : 0);
                                                                                                                        data.putBundle(str31, bundle33);
                                                                                                                        messengerService11.J(data);
                                                                                                                        break;
                                                                                                                    case 4003:
                                                                                                                        int i99 = bundle3.getInt("fontEffectId");
                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                            QLog.i("font.effect.tag.MS", 2, "fontEffectId: " + i99);
                                                                                                                        }
                                                                                                                        if (i99 != 0 && 2000 != i99) {
                                                                                                                            Bundle bundle34 = new Bundle();
                                                                                                                            bundle34.putInt("ret", 0);
                                                                                                                            bundle34.putString("msg", "invalidate effect id.");
                                                                                                                            data.putBundle(str31, bundle34);
                                                                                                                            messengerService11.J(data);
                                                                                                                            break;
                                                                                                                        } else {
                                                                                                                            ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setFontEffect(i99);
                                                                                                                            Bundle bundle35 = new Bundle();
                                                                                                                            bundle35.putInt("ret", 1);
                                                                                                                            bundle35.putString("msg", "setup success.");
                                                                                                                            data.putBundle(str31, bundle35);
                                                                                                                            messengerService11.J(data);
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        break;
                                                                                                                }
                                                                                                                incomingHandler9 = this;
                                                                                                                break;
                                                                                                        }
                                                                                                }
                                                                                            } catch (Throwable th16) {
                                                                                                th5 = th16;
                                                                                            }
                                                                                        } else {
                                                                                            incomingHandler9 = this;
                                                                                            ((IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152)).setChatFontSwitchStatus(bundle3.getInt("action") == 1);
                                                                                            data.putBundle(str31, new Bundle());
                                                                                            messengerService11.J(data);
                                                                                        }
                                                                                    } else {
                                                                                        equals = this;
                                                                                        if ("qwallet_getAuthCode".equals(string2)) {
                                                                                            long j26 = bundle3.getLong("appId");
                                                                                            AuthCodeReq authCodeReq = new AuthCodeReq();
                                                                                            authCodeReq.uin = r112.getLongAccountUin();
                                                                                            authCodeReq.skey = r152;
                                                                                            ArrayList<Long> arrayList6 = new ArrayList<>();
                                                                                            authCodeReq.apps = arrayList6;
                                                                                            arrayList6.add(Long.valueOf(j26));
                                                                                            r112.addObserver(messengerService11.H);
                                                                                            messengerService11.G.f204548b = data;
                                                                                            ((QWalletAuthHandler) r112.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).E2(authCodeReq);
                                                                                            incomingHandler9 = equals;
                                                                                            if (QLog.isColorLevel()) {
                                                                                                try {
                                                                                                    QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CREATE_AUTHCODE cmd get");
                                                                                                    incomingHandler9 = equals;
                                                                                                } catch (Throwable th17) {
                                                                                                    th5 = th17;
                                                                                                    str = "MessengerService$IncomingHandler";
                                                                                                }
                                                                                            }
                                                                                        } else if ("openEquipmentLock".equals(string2)) {
                                                                                            com.tencent.mobileqq.equipmentlock.c.f().i(bundle3.getByteArray("sppkey"));
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("openDevLock".equals(string2)) {
                                                                                            r112.getApplication().getApplicationContext().registerReceiver(new r(messengerService11, data), new IntentFilter(NewIntent.ACTION_DEVLOCK_ROAM));
                                                                                            if (QLog.isColorLevel()) {
                                                                                                QLog.d("Q.emoji.web.MessengerService", 2, "openDevLock registerReceiver context: " + r112.getApplication().getApplicationContext());
                                                                                            }
                                                                                            Intent intent2 = new Intent();
                                                                                            intent2.setFlags(268435456);
                                                                                            intent2.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                                                                                            intent2.putExtra("open_devlock_from_roam", true);
                                                                                            intent2.putExtra("devlock_show_auth_dev_list", bundle3.getBoolean("devlock_show_auth_dev_list", true));
                                                                                            intent2.putExtra("devlock_guide_config", bundle3.getString("devlock_guide_config"));
                                                                                            intent2.putExtra("devlock_open_source", bundle3.getString("devlock_open_source"));
                                                                                            intent2.setData(Uri.parse("mqqdevlock://devlock/open?"));
                                                                                            messengerService11.startActivity(intent2);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("getNickName".equals(string2)) {
                                                                                            final ArrayList<String> stringArrayList2 = data.getBundle(Const.BUNDLE_KEY_REQUEST).getStringArrayList("uins");
                                                                                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.9
                                                                                                @Override // java.lang.Runnable
                                                                                                public void run() {
                                                                                                    Bundle bundle36 = new Bundle();
                                                                                                    HashMap hashMap4 = new HashMap();
                                                                                                    Iterator it = stringArrayList2.iterator();
                                                                                                    while (it.hasNext()) {
                                                                                                        String str36 = (String) it.next();
                                                                                                        hashMap4.put(str36, "");
                                                                                                        if (!TextUtils.isEmpty(str36)) {
                                                                                                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str36), "MessengerService");
                                                                                                            if (friendsSimpleInfoWithUid != null) {
                                                                                                                if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                                                                                                                    hashMap4.put(str36, friendsSimpleInfoWithUid.r());
                                                                                                                } else if (!TextUtils.isEmpty(friendsSimpleInfoWithUid.p())) {
                                                                                                                    hashMap4.put(str36, friendsSimpleInfoWithUid.p());
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    bundle36.putSerializable("friendsMap", hashMap4);
                                                                                                    data.putBundle("response", bundle36);
                                                                                                    messengerService11.J(data);
                                                                                                }
                                                                                            }, 5, null, false);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("setHasSetPwd".equals(string2)) {
                                                                                            com.tencent.mobileqq.phonelogin.a.a().d(r112, r112.getCurrentAccountUin(), true);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("getA2".equals(string2)) {
                                                                                            String string43 = bundle3.getString("uin");
                                                                                            WtloginManager wtloginManager = (WtloginManager) r112.getManager(1);
                                                                                            String str36 = r152;
                                                                                            if (wtloginManager != null) {
                                                                                                try {
                                                                                                    str13 = HexUtil.bytes2HexStr(WtloginHelper.GetTicketSig(wtloginManager.getLocalSig(string43, 16L), 64));
                                                                                                } catch (Exception e38) {
                                                                                                    exc3 = e38;
                                                                                                    str13 = r152;
                                                                                                }
                                                                                                try {
                                                                                                    if (QLog.isColorLevel()) {
                                                                                                        QLog.d("Q.emoji.web.MessengerService", 2, "a2 = " + str13);
                                                                                                    }
                                                                                                    str36 = str13;
                                                                                                } catch (Exception e39) {
                                                                                                    exc3 = e39;
                                                                                                    exc3.printStackTrace();
                                                                                                    Bundle bundle36 = new Bundle();
                                                                                                    bundle36.putString(NowProxyConstants.AccountInfoKey.A2, str13);
                                                                                                    data.putBundle(str31, bundle36);
                                                                                                    messengerService11.J(data);
                                                                                                    incomingHandler9 = equals;
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                            str13 = str36;
                                                                                            Bundle bundle362 = new Bundle();
                                                                                            bundle362.putString(NowProxyConstants.AccountInfoKey.A2, str13);
                                                                                            data.putBundle(str31, bundle362);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_getinfo".equals(string2)) {
                                                                                            Card r16 = ((FriendsManager) r112.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(r112.getCurrentAccountUin());
                                                                                            if (r16 != null) {
                                                                                                j16 = r16.lCurrentBgId;
                                                                                                if (j16 != -1) {
                                                                                                    j17 = r16.lCurrentStyleId;
                                                                                                    if (j17 != -1) {
                                                                                                        String str37 = r16.backgroundUrl;
                                                                                                        j3 = r16.cardId;
                                                                                                        str12 = str37;
                                                                                                        i28 = 0;
                                                                                                        i29 = -1;
                                                                                                        if (i28 != i29) {
                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                QLog.d("MessengerService.onCardDownload", 2, "start onCardDownload");
                                                                                                            }
                                                                                                            r112.addObserver(messengerService11.K);
                                                                                                            r112.addObserver(messengerService11.L);
                                                                                                            messengerService11.I.add(data);
                                                                                                            ((CardHandler) r112.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m3(r112.getCurrentAccountUin(), r112.getCurrentAccountUin(), 0, 0L, (byte) 1, 0L, 0L, null, "", ProfileUtils.getControl(new AllInOne(r112.getCurrentAccountUin(), 0), false), 10004, null, (byte) ea.x0(r112.getApplication(), r112.getCurrentAccountUin()));
                                                                                                            incomingHandler9 = equals;
                                                                                                        } else {
                                                                                                            Bundle bundle37 = new Bundle();
                                                                                                            if (ProfileTemplateApi.isDiyTemplateStyleID(j17)) {
                                                                                                                bundle37.putLong("currentId", j3);
                                                                                                            } else {
                                                                                                                bundle37.putLong("currentId", j16);
                                                                                                            }
                                                                                                            bundle37.putLong("styleId", j17);
                                                                                                            bundle37.putString("diy_url", str12);
                                                                                                            bundle37.putInt(str34, i28);
                                                                                                            data.putBundle(str31, bundle37);
                                                                                                            messengerService11.J(data);
                                                                                                            incomingHandler9 = equals;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            j3 = 0;
                                                                                            i28 = -1;
                                                                                            j16 = 0;
                                                                                            i29 = -1;
                                                                                            j17 = 0;
                                                                                            str12 = r152;
                                                                                            if (i28 != i29) {
                                                                                            }
                                                                                        } else if ("card_setSummaryCard".equals(string2)) {
                                                                                            messengerService11.J = data;
                                                                                            r112.addObserver(messengerService11.K);
                                                                                            r112.addObserver(messengerService11.L);
                                                                                            int i100 = data.getInt("styleId");
                                                                                            int i101 = data.getInt("bgId");
                                                                                            long j27 = data.getLong("cardId", 0L);
                                                                                            String string44 = data.getString("extInfo", null);
                                                                                            String string45 = data.getString("renderInfo", r152);
                                                                                            String a17 = i101 == 0 ? dr.a(string45) : null;
                                                                                            if (QLog.isColorLevel()) {
                                                                                                QLog.e("DIYProfileTemplate.", 1, "set [" + i100 + "]diy card(" + i101 + " url=" + a17 + ") :" + string45);
                                                                                            } else {
                                                                                                QLog.e("DIYProfileTemplate.", 1, "set [" + i100 + "]diy card(" + i101 + ")");
                                                                                            }
                                                                                            ProfileCardUtil.x0(r112, i100, i101, a17, 0L, string44, string45, j27);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_download_wzry_template".equals(string2)) {
                                                                                            messengerService11.J = data;
                                                                                            com.tencent.mobileqq.profile.p.a(new a(messengerService11, r112));
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_download".equals(string2)) {
                                                                                            messengerService11.U = data;
                                                                                            String str38 = VasUpdateConstants.SCID_CARD_PREFIX + data.getLong("bgId");
                                                                                            ((IVasQuickUpdateService) r112.getRuntimeService(IVasQuickUpdateService.class, r152)).addCallBacker(equals.f204472a);
                                                                                            ((ao) r112.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.k(r112, str38, equals.f204472a);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_query_download".equals(string2)) {
                                                                                            messengerService11.J = data;
                                                                                            int z18 = ((ao) r112.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.z(data.getLong("bgId"));
                                                                                            Bundle bundle38 = new Bundle();
                                                                                            messengerService11.J.putString("cmd", "card_query_download");
                                                                                            bundle38.putInt("progress", z18);
                                                                                            messengerService11.J.putBundle(str31, bundle38);
                                                                                            messengerService11.J(messengerService11.J);
                                                                                            messengerService11.J = null;
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_cancel_download".equals(string2)) {
                                                                                            messengerService11.J = data;
                                                                                            ((ao) r112.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.g(data.getLong("bgId"));
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_set_custom_honor".equals(string2)) {
                                                                                            JSONArray optJSONArray = new JSONObject(data.getString("honor_data")).optJSONArray("honourData");
                                                                                            incomingHandler9 = equals;
                                                                                            if (optJSONArray != null) {
                                                                                                incomingHandler9 = equals;
                                                                                                if (optJSONArray.length() > 0) {
                                                                                                    FriendsManager friendsManager = (FriendsManager) r112.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                                                                                    Card r17 = friendsManager.r(r112.getCurrentAccountUin());
                                                                                                    incomingHandler9 = equals;
                                                                                                    if (r17 != null) {
                                                                                                        ArrayList arrayList7 = new ArrayList();
                                                                                                        for (int i102 = 0; i102 < optJSONArray.length(); i102++) {
                                                                                                            JSONObject jSONObject8 = optJSONArray.getJSONObject(i102);
                                                                                                            arrayList7.add(new summaryCardWzryInfo(jSONObject8.optInt("id"), jSONObject8.optString(WidgetCacheConstellationData.NUM)));
                                                                                                        }
                                                                                                        r17.setWzryHonorInfo(arrayList7);
                                                                                                        friendsManager.p0(r17);
                                                                                                        incomingHandler9 = equals;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else if ("getRoam".equals(string2)) {
                                                                                            String str39 = "success";
                                                                                            SharedPreferences sharedPreferences = r112.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                                                                                            int i103 = sharedPreferences.getInt("message_roam_flag" + r112.getCurrentAccountUin(), -1);
                                                                                            if (i103 != 1 && i103 != 2 && i103 != 3 && i103 != 4 && i103 != 5) {
                                                                                                str39 = "messageRoamType is error , = " + i103;
                                                                                                messengerService11.I(str39);
                                                                                            }
                                                                                            int i104 = sharedPreferences.getInt("message_roam_is_set_password" + r112.getCurrentAccountUin(), -1);
                                                                                            if (i104 != 1 && i104 != 0) {
                                                                                                str39 = "isSetPassWord is error , = " + i104;
                                                                                                messengerService11.I(str39);
                                                                                            }
                                                                                            int p16 = ff.p(r112, null);
                                                                                            if (p16 == -1) {
                                                                                                str39 = "user type is error , = " + p16;
                                                                                                messengerService11.I(str39);
                                                                                            }
                                                                                            ?? bundle39 = new Bundle();
                                                                                            bundle39.putInt(r132, i103);
                                                                                            bundle39.putInt(MessageRoamJsPlugin.USERTYPE, p16);
                                                                                            bundle39.putInt(str34, 0);
                                                                                            bundle39.putString("errorMessage", str39);
                                                                                            bundle39.putInt(MessageRoamJsPlugin.ISSETPASSWORD, i104);
                                                                                            if (((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
                                                                                                bundle39.putBoolean(MessageRoamJsPlugin.SECURITYPHONENUMBER, true);
                                                                                                bundle39.putBoolean(MessageRoamJsPlugin.DEVLOCKISOPEN, true);
                                                                                                data.putBundle(str31, bundle39);
                                                                                                messengerService11.J(data);
                                                                                                incomingHandler9 = equals;
                                                                                            } else {
                                                                                                EquipmentLockImpl.o().f(r112, r112.getCurrentAccountUin(), new b(bundle39, data, messengerService11));
                                                                                                incomingHandler9 = equals;
                                                                                            }
                                                                                        } else if ("notifyGetMsgRoam".equals(string2)) {
                                                                                            bundle3.getString("pwd");
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("card_getVipInfo".equals(string2)) {
                                                                                            Bundle bundle40 = new Bundle();
                                                                                            bundle40.putString("vip_info", ff.h(r112, r112.getCurrentAccountUin()));
                                                                                            data.putBundle(str31, bundle40);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("openEmojiMall".equals(string2)) {
                                                                                            Bundle bundle41 = new Bundle();
                                                                                            int r18 = r112.getMessageFacade().r1();
                                                                                            String s16 = r112.getMessageFacade().s1();
                                                                                            bundle41.putInt("curChatType", r18);
                                                                                            bundle41.putString("curChatUin", s16);
                                                                                            data.putBundle(str31, bundle41);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("openEmojiDetail".equals(string2)) {
                                                                                            Bundle bundle42 = new Bundle();
                                                                                            int r19 = r112.getMessageFacade().r1();
                                                                                            String s17 = r112.getMessageFacade().s1();
                                                                                            bundle42.putInt("curChatType", r19);
                                                                                            bundle42.putString("curChatUin", s17);
                                                                                            data.putBundle(str31, bundle42);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("openProfileCard".equals(string2)) {
                                                                                            Bundle bundle43 = new Bundle();
                                                                                            IRedTouchManager iRedTouchManager4 = (IRedTouchManager) r112.getRuntimeService(IRedTouchManager.class, r152);
                                                                                            if (iRedTouchManager4 != null) {
                                                                                                try {
                                                                                                    appInfoByPath = iRedTouchManager4.getAppInfoByPath("100005.100012");
                                                                                                } catch (Exception e46) {
                                                                                                    e46.printStackTrace();
                                                                                                }
                                                                                                if (appInfoByPath != null) {
                                                                                                    if (1 == appInfoByPath.iNewFlag.get()) {
                                                                                                        i26 = 0;
                                                                                                        i27 = i26;
                                                                                                        bundle43.putInt(QAdRewardDefine$VideoParams.ISCACHE, i27);
                                                                                                        data.putBundle(str31, bundle43);
                                                                                                        messengerService11.J(data);
                                                                                                        incomingHandler9 = equals;
                                                                                                    }
                                                                                                }
                                                                                                i26 = 1;
                                                                                                i27 = i26;
                                                                                                bundle43.putInt(QAdRewardDefine$VideoParams.ISCACHE, i27);
                                                                                                data.putBundle(str31, bundle43);
                                                                                                messengerService11.J(data);
                                                                                                incomingHandler9 = equals;
                                                                                            }
                                                                                            i27 = 1;
                                                                                            bundle43.putInt(QAdRewardDefine$VideoParams.ISCACHE, i27);
                                                                                            data.putBundle(str31, bundle43);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("openFontSetting".equals(string2)) {
                                                                                            boolean chatFontAbility = ((IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152)).getChatFontAbility();
                                                                                            Bundle bundle44 = new Bundle();
                                                                                            bundle44.putBoolean("feature", chatFontAbility);
                                                                                            data.putBundle(str31, bundle44);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if (IndividuationPlugin.Method_IsSupportFont.equals(string2)) {
                                                                                            boolean chatFontAbility2 = ((IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152)).getChatFontAbility();
                                                                                            Bundle bundle45 = new Bundle();
                                                                                            bundle45.putBoolean("feature", chatFontAbility2);
                                                                                            data.putBundle(str31, bundle45);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("startDownloadColorRing".equals(string2)) {
                                                                                            int i105 = bundle3.getInt("id");
                                                                                            int i106 = bundle3.getInt("resourceType");
                                                                                            String string46 = bundle3.getString("colorType");
                                                                                            com.tencent.mobileqq.vas.h hVar = (com.tencent.mobileqq.vas.h) r112.getManager(QQManagerFactory.COLOR_RING_MANAGER);
                                                                                            hVar.f309446e = messengerService11.F;
                                                                                            hVar.g(i105, i106, true, 5, string46);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("colorRingSetup".equals(string2)) {
                                                                                            Long valueOf3 = Long.valueOf(bundle3.getLong("id"));
                                                                                            String account = r112.getAccount();
                                                                                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(account));
                                                                                            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
                                                                                            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, account);
                                                                                            aVar.m();
                                                                                            aVar.o(valueOf3.longValue());
                                                                                            aVar.h0(valueOf3.longValue());
                                                                                            iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "Q.emoji.web.MessengerService", null);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("stopDownloadColorRing".equals(string2)) {
                                                                                            ((com.tencent.mobileqq.vas.h) r112.getManager(QQManagerFactory.COLOR_RING_MANAGER)).h(bundle3.getInt("id"), bundle3.getInt("resourceType"));
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("reportColorRing".equals(string2)) {
                                                                                            String string47 = bundle3.getString("subAction");
                                                                                            String string48 = bundle3.getString("actionName");
                                                                                            long j28 = bundle3.getLong("id");
                                                                                            int i107 = bundle3.getInt(str34);
                                                                                            int currentUserVipType3 = ((ISVIPHandler) r112.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
                                                                                            int i108 = currentUserVipType3 == 2 ? 0 : currentUserVipType3 == 3 ? 2 : currentUserVipType3;
                                                                                            ?? sb7 = new StringBuilder();
                                                                                            sb7.append(r152);
                                                                                            sb7.append(i108);
                                                                                            String sb8 = sb7.toString();
                                                                                            ?? sb9 = new StringBuilder();
                                                                                            sb9.append(j28);
                                                                                            sb9.append(r152);
                                                                                            ReportController.o(r112, "CliOper", "", "", string47, string48, 0, i107, sb8, sb9.toString(), "", "");
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("close_version".equals(string2)) {
                                                                                            Bundle bundle46 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                            if (bundle46 != null) {
                                                                                                long j29 = bundle46.getLong("version", 0L);
                                                                                                com.tencent.mobileqq.vipgift.b bVar2 = (com.tencent.mobileqq.vipgift.b) r112.getManager(QQManagerFactory.VIP_GIF_MANAGER);
                                                                                                if (bVar2 != null && bVar2.l(j29)) {
                                                                                                    bVar2.i("0X8004B41", "3", "0", null);
                                                                                                    i19 = 0;
                                                                                                    Bundle bundle47 = new Bundle();
                                                                                                    bundle47.putInt(str34, i19);
                                                                                                    data.putBundle(str31, bundle47);
                                                                                                    messengerService11.J(data);
                                                                                                    incomingHandler9 = equals;
                                                                                                }
                                                                                            }
                                                                                            i19 = -1;
                                                                                            Bundle bundle472 = new Bundle();
                                                                                            bundle472.putInt(str34, i19);
                                                                                            data.putBundle(str31, bundle472);
                                                                                            messengerService11.J(data);
                                                                                            incomingHandler9 = equals;
                                                                                        } else if ("close_annimate".equals(string2)) {
                                                                                            Bundle bundle48 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                            if (bundle48 != null) {
                                                                                                long j36 = bundle48.getLong("Gif_msg_uniseq_key", 0L);
                                                                                                if (j36 != 0 && (d16 = (bVar = (com.tencent.mobileqq.vipgift.b) r112.getManager(QQManagerFactory.VIP_GIF_MANAGER)).d()) != null && d16.f313121f == 3) {
                                                                                                    bVar.j(4L, j36);
                                                                                                }
                                                                                            }
                                                                                        } else if ("special_care_set_ring".equals(string2)) {
                                                                                            Bundle bundle49 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                            Bundle bundle50 = new Bundle();
                                                                                            if (bundle49 != null) {
                                                                                                messengerService11.M.l(r112, string2, data, bundle50);
                                                                                            }
                                                                                        } else if ("special_care_get_ring".equals(string2)) {
                                                                                            Bundle bundle51 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                            if (bundle51 != null) {
                                                                                                int o17 = com.tencent.mobileqq.activity.specialcare.e.o(bundle51.getString("uin"), r112);
                                                                                                Bundle bundle52 = new Bundle();
                                                                                                bundle52.putInt("id", o17);
                                                                                                data.putBundle(str31, bundle52);
                                                                                                messengerService11.J(data);
                                                                                            }
                                                                                        } else if ("special_care_get_friend_count".equals(string2)) {
                                                                                            Bundle bundle53 = new Bundle();
                                                                                            bundle53.putInt("count", com.tencent.mobileqq.activity.specialcare.e.m(r112));
                                                                                            data.putBundle(str31, bundle53);
                                                                                            messengerService11.J(data);
                                                                                        } else if ("sepcial_care_delete_ring".equals(string2)) {
                                                                                            messengerService11.M.l(r112, string2, data, new Bundle());
                                                                                        } else if ("special_care_get_switch_state".equals(string2)) {
                                                                                            Bundle bundle54 = new Bundle();
                                                                                            int specialCareRingRoamingSetting = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(r112);
                                                                                            if (specialCareRingRoamingSetting == 0) {
                                                                                                int aLLGeneralSettingRing = r112.getALLGeneralSettingRing();
                                                                                                messengerService11.I("-->state follow,all sound switch state:" + aLLGeneralSettingRing);
                                                                                                specialCareRingRoamingSetting = aLLGeneralSettingRing == 0 ? 0 : 1;
                                                                                            }
                                                                                            bundle54.putInt("state", specialCareRingRoamingSetting);
                                                                                            data.putBundle(str31, bundle54);
                                                                                            messengerService11.J(data);
                                                                                        } else if ("is_special_friend".equals(string2)) {
                                                                                            Bundle bundle55 = new Bundle();
                                                                                            Bundle bundle56 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                            if (bundle56 != null) {
                                                                                                String string49 = bundle56.getString("friendUin");
                                                                                                if (com.tencent.mobileqq.activity.specialcare.e.r(r112.getCurrentAccountUin() + (string49 == null ? r152 : string49))) {
                                                                                                    bundle55.putInt("isSpecialFriend", 1);
                                                                                                } else {
                                                                                                    bundle55.putInt("isSpecialFriend", 0);
                                                                                                }
                                                                                                data.putBundle(str31, bundle55);
                                                                                                messengerService11.J(data);
                                                                                            }
                                                                                        } else if ("getDomainIpList".equals(string2)) {
                                                                                            ArrayList<FileStorageServerListInfo> allIpList = FMTSrvAddrProvider.getInstance().getAllIpList(15);
                                                                                            JSONArray jSONArray = new JSONArray();
                                                                                            if (allIpList != null) {
                                                                                                try {
                                                                                                    Iterator<FileStorageServerListInfo> it = allIpList.iterator();
                                                                                                    while (it.hasNext()) {
                                                                                                        jSONArray.mo162put(it.next().sIP);
                                                                                                    }
                                                                                                } catch (JSONException unused) {
                                                                                                }
                                                                                            }
                                                                                            Bundle bundle57 = new Bundle();
                                                                                            JSONObject jSONObject9 = new JSONObject();
                                                                                            jSONObject9.put(str34, 0);
                                                                                            jSONObject9.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                                                            jSONObject9.put("ips", jSONArray);
                                                                                            bundle57.putString(str34, jSONObject9.toString());
                                                                                            data.putBundle(str31, bundle57);
                                                                                            messengerService11.J(data);
                                                                                        } else {
                                                                                            if (!"selectPhoto".equals(string2) && !"takePhoto".equals(string2)) {
                                                                                                if ("gamecenter_delaydownload".equals(string2)) {
                                                                                                    GameCenterBroadcastReceiver.c();
                                                                                                } else if ("funcall_download".equals(string2)) {
                                                                                                    int i109 = bundle3.getInt("callId");
                                                                                                    com.tencent.mobileqq.vipav.a.c(r112, i109, bundle3, null, true);
                                                                                                    int i110 = bundle3.getInt(VipFunCallConstants.KEY_RING_ID);
                                                                                                    VipFunCallUtil.getResourceType();
                                                                                                    VasUtil.getService().getFunCallManager().downloadFCSuit(i109, i110, true, 6, messengerService11.F);
                                                                                                } else {
                                                                                                    if (!"funcall_set".equals(string2) && !"funcall_delete".equals(string2)) {
                                                                                                        if ("leba_item_set".equals(string2)) {
                                                                                                            int i111 = bundle3.getInt("path");
                                                                                                            boolean z19 = bundle3.getInt(r132) == 1;
                                                                                                            long serverTimeMillis2 = NetConnInfoCenter.getServerTimeMillis();
                                                                                                            ?? r65 = (ILebaHelperService) r112.getRuntimeService(ILebaHelperService.class, r152);
                                                                                                            if (r65 != 0) {
                                                                                                                r65.updateAppSetting(r112, i111, z19, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
                                                                                                                r65.setFlagUpdateFromH5();
                                                                                                                r65.netSetPluginState(String.valueOf(i111), z19, serverTimeMillis2);
                                                                                                                r65.notifySetPluginState(1, true, null);
                                                                                                            } else {
                                                                                                                QLog.d("IPC_LEBA_ITEM_SET", 1, "lebaHelperService == null");
                                                                                                            }
                                                                                                            Bundle bundle58 = new Bundle();
                                                                                                            bundle58.putInt("ret", 0);
                                                                                                            data.putBundle(str31, bundle58);
                                                                                                            messengerService11.J(data);
                                                                                                            return;
                                                                                                        }
                                                                                                        if ("leba_item_get".equals(string2)) {
                                                                                                            final int i112 = bundle3.getInt("path");
                                                                                                            try {
                                                                                                                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.12
                                                                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                                                                    @Override // java.lang.Runnable
                                                                                                                    public void run() {
                                                                                                                        List<com.tencent.mobileqq.leba.entity.n> list2;
                                                                                                                        int i113;
                                                                                                                        LebaPluginInfo lebaPluginInfo;
                                                                                                                        ILebaHelperService iLebaHelperService = (ILebaHelperService) r112.getRuntimeService(ILebaHelperService.class, "");
                                                                                                                        if (iLebaHelperService != null) {
                                                                                                                            list2 = iLebaHelperService.getLebaMgrList();
                                                                                                                            if (list2 == null || list2.isEmpty()) {
                                                                                                                                iLebaHelperService.reloadLebaItems(r112);
                                                                                                                                list2 = iLebaHelperService.getLebaMgrList();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            QLog.d("IPC_LEBA_ITEM_GET", 1, "lebaHelperService == null");
                                                                                                                            list2 = null;
                                                                                                                        }
                                                                                                                        if (list2 != null) {
                                                                                                                            for (com.tencent.mobileqq.leba.entity.n nVar : list2) {
                                                                                                                                if (nVar != null && (lebaPluginInfo = nVar.f240505b) != null && lebaPluginInfo.uiResId == i112) {
                                                                                                                                    i113 = nVar.d();
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                        i113 = 0;
                                                                                                                        Bundle bundle59 = new Bundle();
                                                                                                                        if (i113 != 0) {
                                                                                                                            bundle59.putInt("ret", 1);
                                                                                                                        } else {
                                                                                                                            bundle59.putInt("ret", 0);
                                                                                                                        }
                                                                                                                        bundle59.putInt("type", i113);
                                                                                                                        data.putBundle("response", bundle59);
                                                                                                                        messengerService11.J(data);
                                                                                                                    }
                                                                                                                }, 8, null, true);
                                                                                                                return;
                                                                                                            } catch (Throwable th18) {
                                                                                                                th5 = th18;
                                                                                                            }
                                                                                                        } else if ("QQVIPFunctionReport643".equals(string2)) {
                                                                                                            bundle3.getString("tag");
                                                                                                            String string50 = bundle3.getString("mainAction");
                                                                                                            String string51 = bundle3.getString("toUin");
                                                                                                            String string52 = bundle3.getString("subAction");
                                                                                                            String string53 = bundle3.getString("actionName");
                                                                                                            int i113 = bundle3.getInt("fromeType");
                                                                                                            int i114 = bundle3.getInt(str34);
                                                                                                            String[] stringArray = bundle3.getStringArray("reserves");
                                                                                                            ReportController.o(r112, "CliOper", string50, string51, string52, string53, i113, i114, stringArray[0], stringArray[1], stringArray[2], stringArray[3]);
                                                                                                        } else if ("checkRelation".equals(string2)) {
                                                                                                            String string54 = bundle3.getString("uin");
                                                                                                            FriendsManager friendsManager2 = (FriendsManager) r112.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                                                                                            if (string54 != null && friendsManager2 != null) {
                                                                                                                Bundle bundle59 = new Bundle();
                                                                                                                bundle59.putBoolean(str34, friendsManager2.c0(string54));
                                                                                                                data.putBundle(str31, bundle59);
                                                                                                                messengerService11.J(data);
                                                                                                            }
                                                                                                        } else if ("getFlowerVisibility".equals(string2)) {
                                                                                                            boolean f17 = NearbyProfileUtil.f(r112);
                                                                                                            Bundle bundle60 = new Bundle();
                                                                                                            bundle60.putBoolean(str34, f17);
                                                                                                            data.putBundle(str31, bundle60);
                                                                                                            messengerService11.J(data);
                                                                                                        } else if ("setFlowerVisibility".equals(string2)) {
                                                                                                            if (bundle3.containsKey("isVisible")) {
                                                                                                                NearbyProfileUtil.h(r112, bundle3.getBoolean("isVisible"));
                                                                                                                i18 = 0;
                                                                                                            } else {
                                                                                                                i18 = -1;
                                                                                                            }
                                                                                                            Bundle bundle61 = new Bundle();
                                                                                                            bundle61.putInt(str34, i18);
                                                                                                            data.putBundle(str31, bundle61);
                                                                                                            messengerService11.J(data);
                                                                                                        } else if (!"open_secmsg".equals(string2) && !"check_sec_group".equals(string2) && !"open_sec_group".equals(string2) && !"starBless".equals(string2)) {
                                                                                                            try {
                                                                                                                if (string2.equals("ipc_funnypic_add")) {
                                                                                                                    try {
                                                                                                                        string = bundle3.getString("jsonContent");
                                                                                                                    } catch (JSONException e47) {
                                                                                                                        e = e47;
                                                                                                                        incomingHandler2 = this;
                                                                                                                        str7 = str34;
                                                                                                                    } catch (Exception e48) {
                                                                                                                        e = e48;
                                                                                                                        incomingHandler2 = this;
                                                                                                                        str7 = str34;
                                                                                                                    }
                                                                                                                    if (!TextUtils.isEmpty(string)) {
                                                                                                                        JSONObject jSONObject10 = new JSONObject(string);
                                                                                                                        boolean z26 = jSONObject10.getInt("action") == 0;
                                                                                                                        JSONArray jSONArray2 = jSONObject10.getJSONArray("uids");
                                                                                                                        final IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class);
                                                                                                                        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
                                                                                                                        ArrayList arrayList8 = new ArrayList();
                                                                                                                        int i115 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                                                                                                                        if (emoticonDataList != null) {
                                                                                                                            i3 = 1;
                                                                                                                            int i116 = 0;
                                                                                                                            r124 = messengerService11;
                                                                                                                            while (i116 < emoticonDataList.size()) {
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        int i117 = emoticonDataList.get(i116).emoId;
                                                                                                                                        messengerService4 = r124;
                                                                                                                                        try {
                                                                                                                                            str11 = str34;
                                                                                                                                            try {
                                                                                                                                                if ("needDel".equals(emoticonDataList.get(i116).RomaingType)) {
                                                                                                                                                    list = emoticonDataList;
                                                                                                                                                } else {
                                                                                                                                                    int i118 = i115 - 1;
                                                                                                                                                    String str40 = emoticonDataList.get(i116).md5;
                                                                                                                                                    if (TextUtils.isEmpty(str40)) {
                                                                                                                                                        list = emoticonDataList;
                                                                                                                                                    } else {
                                                                                                                                                        list = emoticonDataList;
                                                                                                                                                        if (str40.length() > 8) {
                                                                                                                                                            StringBuilder sb10 = new StringBuilder();
                                                                                                                                                            sb10.append(FunnyPicHelperConstant.FUNYPIC_PREFIX);
                                                                                                                                                            i17 = i118;
                                                                                                                                                            sb10.append(str40.substring(0, 8).toLowerCase());
                                                                                                                                                            arrayList8.add(sb10.toString());
                                                                                                                                                            i115 = i17;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    i17 = i118;
                                                                                                                                                    i115 = i17;
                                                                                                                                                }
                                                                                                                                                if (i3 < i117) {
                                                                                                                                                    i3 = i117;
                                                                                                                                                }
                                                                                                                                                i116++;
                                                                                                                                                emoticonDataList = list;
                                                                                                                                                str34 = str11;
                                                                                                                                                r124 = messengerService4;
                                                                                                                                            } catch (JSONException e49) {
                                                                                                                                                r152 = this;
                                                                                                                                                jSONException = e49;
                                                                                                                                                str8 = "Q.emoji.web.MessengerService";
                                                                                                                                                str9 = "message";
                                                                                                                                                str10 = str11;
                                                                                                                                                r123 = messengerService4;
                                                                                                                                                data.putInt(str10, 1);
                                                                                                                                                message3 = jSONException.getMessage();
                                                                                                                                                if (message3 != null) {
                                                                                                                                                }
                                                                                                                                                r123.J(data);
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            } catch (Exception e56) {
                                                                                                                                                incomingHandler8 = this;
                                                                                                                                                exc2 = e56;
                                                                                                                                                str8 = "Q.emoji.web.MessengerService";
                                                                                                                                                str9 = "message";
                                                                                                                                                str7 = str11;
                                                                                                                                                messengerService9 = messengerService4;
                                                                                                                                                r122 = messengerService9;
                                                                                                                                                r152 = incomingHandler8;
                                                                                                                                                data.putInt(str7, 1);
                                                                                                                                                message2 = exc2.getMessage();
                                                                                                                                                if (message2 != null) {
                                                                                                                                                }
                                                                                                                                                r122.J(data);
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                        } catch (JSONException e57) {
                                                                                                                                            incomingHandler5 = this;
                                                                                                                                            jSONException = e57;
                                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                                            str9 = "message";
                                                                                                                                            messengerService8 = messengerService4;
                                                                                                                                            str10 = str34;
                                                                                                                                            messengerService7 = messengerService8;
                                                                                                                                            incomingHandler7 = incomingHandler5;
                                                                                                                                            r123 = messengerService7;
                                                                                                                                            r152 = incomingHandler7;
                                                                                                                                            data.putInt(str10, 1);
                                                                                                                                            message3 = jSONException.getMessage();
                                                                                                                                            if (message3 != null) {
                                                                                                                                            }
                                                                                                                                            r123.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        } catch (Exception e58) {
                                                                                                                                            incomingHandler8 = this;
                                                                                                                                            exc2 = e58;
                                                                                                                                            str7 = str34;
                                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                                            str9 = "message";
                                                                                                                                            messengerService9 = messengerService4;
                                                                                                                                            r122 = messengerService9;
                                                                                                                                            r152 = incomingHandler8;
                                                                                                                                            data.putInt(str7, 1);
                                                                                                                                            message2 = exc2.getMessage();
                                                                                                                                            if (message2 != null) {
                                                                                                                                            }
                                                                                                                                            r122.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    } catch (JSONException e59) {
                                                                                                                                        e16 = e59;
                                                                                                                                        incomingHandler5 = this;
                                                                                                                                        jSONException = e16;
                                                                                                                                        str8 = "Q.emoji.web.MessengerService";
                                                                                                                                        str9 = "message";
                                                                                                                                        messengerService8 = r124;
                                                                                                                                        str10 = str34;
                                                                                                                                        messengerService7 = messengerService8;
                                                                                                                                        incomingHandler7 = incomingHandler5;
                                                                                                                                        r123 = messengerService7;
                                                                                                                                        r152 = incomingHandler7;
                                                                                                                                        data.putInt(str10, 1);
                                                                                                                                        message3 = jSONException.getMessage();
                                                                                                                                        if (message3 != null) {
                                                                                                                                            data.putString(str9, message3);
                                                                                                                                        }
                                                                                                                                        r123.J(data);
                                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                                            QLog.i(str8, 2, message3);
                                                                                                                                        }
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                } catch (Exception e65) {
                                                                                                                                    e = e65;
                                                                                                                                    incomingHandler4 = this;
                                                                                                                                    exc2 = e;
                                                                                                                                    str7 = str34;
                                                                                                                                    messengerService5 = r124;
                                                                                                                                    str8 = "Q.emoji.web.MessengerService";
                                                                                                                                    str9 = "message";
                                                                                                                                    r122 = messengerService5;
                                                                                                                                    r152 = incomingHandler4;
                                                                                                                                    data.putInt(str7, 1);
                                                                                                                                    message2 = exc2.getMessage();
                                                                                                                                    if (message2 != null) {
                                                                                                                                        data.putString(str9, message2);
                                                                                                                                    }
                                                                                                                                    r122.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                        QLog.i(str8, 2, message2);
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            str11 = str34;
                                                                                                                            messengerService4 = r124;
                                                                                                                        } else {
                                                                                                                            str11 = str34;
                                                                                                                            messengerService4 = messengerService11;
                                                                                                                            i3 = 1;
                                                                                                                        }
                                                                                                                        try {
                                                                                                                            arrayList2 = new ArrayList();
                                                                                                                            int length = jSONArray2.length();
                                                                                                                            int i119 = length - i115;
                                                                                                                            int i120 = 0;
                                                                                                                            while (i120 < length) {
                                                                                                                                i3++;
                                                                                                                                JSONObject jSONObject11 = (JSONObject) jSONArray2.get(i120);
                                                                                                                                int i121 = jSONObject11.getInt("pkgid");
                                                                                                                                int i122 = length;
                                                                                                                                String string55 = jSONObject11.getString("uid");
                                                                                                                                CustomEmotionData customEmotionData = new CustomEmotionData();
                                                                                                                                JSONArray jSONArray3 = jSONArray2;
                                                                                                                                customEmotionData.uin = r112.getCurrentAccountUin();
                                                                                                                                StringBuilder sb11 = new StringBuilder();
                                                                                                                                int i123 = i119;
                                                                                                                                sb11.append(FunnyPicHelperConstant.FUNYPIC_PREFIX);
                                                                                                                                sb11.append(i121);
                                                                                                                                customEmotionData.eId = sb11.toString();
                                                                                                                                customEmotionData.emoId = i3;
                                                                                                                                customEmotionData.emoPath = r152;
                                                                                                                                customEmotionData.url = "https://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_item_" + i121 + "/" + string55;
                                                                                                                                if (z26) {
                                                                                                                                    if (!(!TextUtils.isEmpty(string55) && (lastIndexOf = string55.lastIndexOf(".")) > 0 && arrayList8.contains(string55.substring(0, lastIndexOf).toLowerCase()))) {
                                                                                                                                        iFavroamingDBManagerService.insertCustomEmotion(customEmotionData);
                                                                                                                                        arrayList2.add(customEmotionData);
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    arrayList2.add(customEmotionData);
                                                                                                                                }
                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                    QLog.d("Q.emoji.web.MessengerService", 2, "insert funnyPic eId->" + customEmotionData.eId + " emoPath->" + customEmotionData.emoPath + " exist->" + arrayList8.contains(customEmotionData.emoPath));
                                                                                                                                }
                                                                                                                                i120++;
                                                                                                                                length = i122;
                                                                                                                                jSONArray2 = jSONArray3;
                                                                                                                                i119 = i123;
                                                                                                                            }
                                                                                                                            i16 = i119;
                                                                                                                        } catch (JSONException e66) {
                                                                                                                            r152 = this;
                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                            str9 = "message";
                                                                                                                            r123 = messengerService4;
                                                                                                                            jSONException = e66;
                                                                                                                            str10 = str11;
                                                                                                                            data.putInt(str10, 1);
                                                                                                                            message3 = jSONException.getMessage();
                                                                                                                            if (message3 != null) {
                                                                                                                            }
                                                                                                                            r123.J(data);
                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } catch (Exception e67) {
                                                                                                                            e = e67;
                                                                                                                            incomingHandler2 = this;
                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                            str9 = "message";
                                                                                                                            str7 = str11;
                                                                                                                            messengerService11 = messengerService4;
                                                                                                                        }
                                                                                                                        try {
                                                                                                                            if (z26) {
                                                                                                                                try {
                                                                                                                                    if (arrayList2.isEmpty()) {
                                                                                                                                        str34 = str11;
                                                                                                                                        try {
                                                                                                                                            data.putInt(str34, 0);
                                                                                                                                            r124 = messengerService4;
                                                                                                                                            r124.J(data);
                                                                                                                                        } catch (JSONException e68) {
                                                                                                                                            e16 = e68;
                                                                                                                                            r124 = messengerService4;
                                                                                                                                            incomingHandler5 = this;
                                                                                                                                            jSONException = e16;
                                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                                            str9 = "message";
                                                                                                                                            messengerService8 = r124;
                                                                                                                                            str10 = str34;
                                                                                                                                            messengerService7 = messengerService8;
                                                                                                                                            incomingHandler7 = incomingHandler5;
                                                                                                                                            r123 = messengerService7;
                                                                                                                                            r152 = incomingHandler7;
                                                                                                                                            data.putInt(str10, 1);
                                                                                                                                            message3 = jSONException.getMessage();
                                                                                                                                            if (message3 != null) {
                                                                                                                                            }
                                                                                                                                            r123.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        } catch (Exception e69) {
                                                                                                                                            e = e69;
                                                                                                                                            r124 = messengerService4;
                                                                                                                                            incomingHandler4 = this;
                                                                                                                                            exc2 = e;
                                                                                                                                            str7 = str34;
                                                                                                                                            messengerService5 = r124;
                                                                                                                                            str8 = "Q.emoji.web.MessengerService";
                                                                                                                                            str9 = "message";
                                                                                                                                            r122 = messengerService5;
                                                                                                                                            r152 = incomingHandler4;
                                                                                                                                            data.putInt(str7, 1);
                                                                                                                                            message2 = exc2.getMessage();
                                                                                                                                            if (message2 != null) {
                                                                                                                                            }
                                                                                                                                            r122.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        String str41 = str11;
                                                                                                                                        messengerService6 = messengerService4;
                                                                                                                                        try {
                                                                                                                                            incomingHandler6 = this;
                                                                                                                                            str7 = str41;
                                                                                                                                            try {
                                                                                                                                                ((IFunnyPicHelperService) QRoute.api(IFunnyPicHelperService.class)).checkLoadEmotionPic(messengerService6.getApplicationContext(), arrayList2, r112, new IPicDownloadListener() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.13
                                                                                                                                                    /* JADX WARN: Removed duplicated region for block: B:6:0x0086 A[Catch: Exception -> 0x00a7, JSONException -> 0x00b6, TryCatch #2 {JSONException -> 0x00b6, Exception -> 0x00a7, blocks: (B:32:0x000a, B:34:0x0010, B:36:0x0016, B:38:0x001c, B:39:0x002c, B:40:0x004d, B:42:0x0053, B:4:0x0064, B:6:0x0086, B:7:0x008f, B:10:0x009d, B:12:0x00a3, B:44:0x0026, B:3:0x005f), top: B:31:0x000a }] */
                                                                                                                                                    @Override // com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener
                                                                                                                                                    /*
                                                                                                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                                                    */
                                                                                                                                                    public void onDone(List<CustomEmotionData> list2, List<CustomEmotionData> list3) {
                                                                                                                                                        MqqHandler handler;
                                                                                                                                                        IFavroamingManagerService iFavroamingManagerService;
                                                                                                                                                        int i124 = 0;
                                                                                                                                                        if (list3 != null) {
                                                                                                                                                            try {
                                                                                                                                                                if (!list3.isEmpty()) {
                                                                                                                                                                    int size = list3.size();
                                                                                                                                                                    if (list2 != null && !list2.isEmpty()) {
                                                                                                                                                                        i124 = list2.size();
                                                                                                                                                                        data.putInt("result", 2);
                                                                                                                                                                    } else {
                                                                                                                                                                        data.putInt("result", 1);
                                                                                                                                                                    }
                                                                                                                                                                    JSONObject jSONObject12 = new JSONObject();
                                                                                                                                                                    jSONObject12.put("succeedNum", i124);
                                                                                                                                                                    jSONObject12.put("failedNum", size);
                                                                                                                                                                    data.putString("data", jSONObject12.toString());
                                                                                                                                                                    Iterator<CustomEmotionData> it5 = list3.iterator();
                                                                                                                                                                    while (it5.hasNext()) {
                                                                                                                                                                        iFavroamingDBManagerService.deleteCustomEmotion(it5.next());
                                                                                                                                                                    }
                                                                                                                                                                    messengerService6.J(data);
                                                                                                                                                                    messengerService6.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
                                                                                                                                                                    handler = r112.getHandler(ChatActivity.class);
                                                                                                                                                                    if (handler != null) {
                                                                                                                                                                        handler.obtainMessage(10).sendToTarget();
                                                                                                                                                                    }
                                                                                                                                                                    iFavroamingManagerService = (IFavroamingManagerService) r112.getRuntimeService(IFavroamingManagerService.class);
                                                                                                                                                                    if (iFavroamingManagerService == null && list2 != null && !list2.isEmpty()) {
                                                                                                                                                                        iFavroamingManagerService.syncUpload(list2);
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            } catch (JSONException e75) {
                                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                                    QLog.i("Q.emoji.web.MessengerService", 2, e75.getMessage());
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                                return;
                                                                                                                                                            } catch (Exception e76) {
                                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                                    QLog.i("Q.emoji.web.MessengerService", 2, e76.getMessage());
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        data.putInt("result", 0);
                                                                                                                                                        messengerService6.J(data);
                                                                                                                                                        messengerService6.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
                                                                                                                                                        handler = r112.getHandler(ChatActivity.class);
                                                                                                                                                        if (handler != null) {
                                                                                                                                                        }
                                                                                                                                                        iFavroamingManagerService = (IFavroamingManagerService) r112.getRuntimeService(IFavroamingManagerService.class);
                                                                                                                                                        if (iFavroamingManagerService == null) {
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                });
                                                                                                                                                r152 = incomingHandler6;
                                                                                                                                            } catch (JSONException e75) {
                                                                                                                                                jSONException = e75;
                                                                                                                                                str8 = "Q.emoji.web.MessengerService";
                                                                                                                                                str9 = "message";
                                                                                                                                                messengerService3 = messengerService6;
                                                                                                                                                incomingHandler3 = incomingHandler6;
                                                                                                                                                str10 = str7;
                                                                                                                                                r123 = messengerService3;
                                                                                                                                                r152 = incomingHandler3;
                                                                                                                                                data.putInt(str10, 1);
                                                                                                                                                message3 = jSONException.getMessage();
                                                                                                                                                if (message3 != null) {
                                                                                                                                                }
                                                                                                                                                r123.J(data);
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            } catch (Exception e76) {
                                                                                                                                                e = e76;
                                                                                                                                                exc2 = e;
                                                                                                                                                messengerService5 = messengerService6;
                                                                                                                                                incomingHandler4 = incomingHandler6;
                                                                                                                                                str8 = "Q.emoji.web.MessengerService";
                                                                                                                                                str9 = "message";
                                                                                                                                                r122 = messengerService5;
                                                                                                                                                r152 = incomingHandler4;
                                                                                                                                                data.putInt(str7, 1);
                                                                                                                                                message2 = exc2.getMessage();
                                                                                                                                                if (message2 != null) {
                                                                                                                                                }
                                                                                                                                                r122.J(data);
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e77) {
                                                                                                                                            e = e77;
                                                                                                                                            incomingHandler6 = this;
                                                                                                                                            str7 = str41;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (JSONException e78) {
                                                                                                                                    incomingHandler7 = this;
                                                                                                                                    messengerService7 = messengerService4;
                                                                                                                                    jSONException = e78;
                                                                                                                                    str8 = "Q.emoji.web.MessengerService";
                                                                                                                                    str9 = "message";
                                                                                                                                    str10 = str11;
                                                                                                                                    r123 = messengerService7;
                                                                                                                                    r152 = incomingHandler7;
                                                                                                                                    data.putInt(str10, 1);
                                                                                                                                    message3 = jSONException.getMessage();
                                                                                                                                    if (message3 != null) {
                                                                                                                                    }
                                                                                                                                    r123.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                } catch (Exception e79) {
                                                                                                                                    e = e79;
                                                                                                                                    incomingHandler6 = this;
                                                                                                                                    str7 = str11;
                                                                                                                                    messengerService6 = messengerService4;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                incomingHandler2 = this;
                                                                                                                                str7 = str11;
                                                                                                                                messengerService11 = messengerService4;
                                                                                                                                try {
                                                                                                                                    str9 = "message";
                                                                                                                                    str8 = "Q.emoji.web.MessengerService";
                                                                                                                                } catch (JSONException e85) {
                                                                                                                                    e = e85;
                                                                                                                                    str8 = "Q.emoji.web.MessengerService";
                                                                                                                                    str9 = "message";
                                                                                                                                    jSONException = e;
                                                                                                                                    messengerService3 = messengerService11;
                                                                                                                                    incomingHandler3 = incomingHandler2;
                                                                                                                                    str10 = str7;
                                                                                                                                    r123 = messengerService3;
                                                                                                                                    r152 = incomingHandler3;
                                                                                                                                    data.putInt(str10, 1);
                                                                                                                                    message3 = jSONException.getMessage();
                                                                                                                                    if (message3 != null) {
                                                                                                                                    }
                                                                                                                                    r123.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                } catch (Exception e86) {
                                                                                                                                    e = e86;
                                                                                                                                    str8 = "Q.emoji.web.MessengerService";
                                                                                                                                    str9 = "message";
                                                                                                                                    exc2 = e;
                                                                                                                                    r122 = messengerService11;
                                                                                                                                    r152 = incomingHandler2;
                                                                                                                                    data.putInt(str7, 1);
                                                                                                                                    message2 = exc2.getMessage();
                                                                                                                                    if (message2 != null) {
                                                                                                                                    }
                                                                                                                                    r122.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                try {
                                                                                                                                    ((IFunnyPicHelperService) QRoute.api(IFunnyPicHelperService.class)).checkLoadEmotionPic(false, messengerService11.getApplicationContext(), arrayList2, r112, new IPicDownloadListener() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.14
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8 A[Catch: Exception -> 0x0175, JSONException -> 0x0185, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0185, blocks: (B:76:0x000d, B:78:0x0013, B:80:0x0019, B:82:0x001f, B:83:0x002f, B:5:0x0055, B:7:0x005b, B:10:0x0075, B:12:0x007b, B:15:0x0086, B:17:0x0097, B:19:0x00a7, B:21:0x00b2, B:25:0x00b7, B:28:0x00ce, B:29:0x00d2, B:31:0x00d8, B:84:0x0029, B:3:0x004d), top: B:75:0x000d }] */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:59:0x0114 A[Catch: JSONException -> 0x0172, Exception -> 0x0175, TryCatch #0 {JSONException -> 0x0172, blocks: (B:43:0x00e0, B:45:0x00ee, B:47:0x00f5, B:33:0x00f9, B:35:0x0105, B:37:0x010d, B:59:0x0114, B:60:0x0146, B:62:0x0161, B:66:0x016a), top: B:42:0x00e0 }] */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:60:0x0146 A[Catch: JSONException -> 0x0172, Exception -> 0x0175, TryCatch #0 {JSONException -> 0x0172, blocks: (B:43:0x00e0, B:45:0x00ee, B:47:0x00f5, B:33:0x00f9, B:35:0x0105, B:37:0x010d, B:59:0x0114, B:60:0x0146, B:62:0x0161, B:66:0x016a), top: B:42:0x00e0 }] */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:65:0x00b5  */
                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:9:0x0072  */
                                                                                                                                        @Override // com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener
                                                                                                                                        /*
                                                                                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                                        */
                                                                                                                                        public void onDone(List<CustomEmotionData> list2, List<CustomEmotionData> list3) {
                                                                                                                                            int size;
                                                                                                                                            int i124;
                                                                                                                                            List<CustomEmotionData> emoticonDataList2;
                                                                                                                                            int i125;
                                                                                                                                            int i126;
                                                                                                                                            int i127;
                                                                                                                                            int i128;
                                                                                                                                            int i129 = 2;
                                                                                                                                            boolean z27 = false;
                                                                                                                                            if (list3 != null) {
                                                                                                                                                try {
                                                                                                                                                    try {
                                                                                                                                                        if (!list3.isEmpty()) {
                                                                                                                                                            size = list3.size();
                                                                                                                                                            if (list2 != null && !list2.isEmpty()) {
                                                                                                                                                                i124 = list2.size();
                                                                                                                                                                data.putInt("result", 2);
                                                                                                                                                            } else {
                                                                                                                                                                data.putInt("result", 1);
                                                                                                                                                                i124 = 0;
                                                                                                                                                            }
                                                                                                                                                            JSONObject jSONObject12 = new JSONObject();
                                                                                                                                                            jSONObject12.put("succeedNum", i124);
                                                                                                                                                            jSONObject12.put("failedNum", size);
                                                                                                                                                            data.putString("data", jSONObject12.toString());
                                                                                                                                                            if (list2 != null && !list2.isEmpty()) {
                                                                                                                                                                IFavroamingDBManagerService iFavroamingDBManagerService2 = (IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class);
                                                                                                                                                                emoticonDataList2 = iFavroamingDBManagerService2.getEmoticonDataList();
                                                                                                                                                                i125 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                                                                                                                                                                HashSet hashSet = new HashSet();
                                                                                                                                                                if (emoticonDataList2 == null) {
                                                                                                                                                                    i126 = 0;
                                                                                                                                                                    i127 = 1;
                                                                                                                                                                    for (int i130 = 0; i130 < emoticonDataList2.size(); i130++) {
                                                                                                                                                                        int i131 = emoticonDataList2.get(i130).emoId;
                                                                                                                                                                        if (i127 < i131) {
                                                                                                                                                                            i127 = i131;
                                                                                                                                                                        }
                                                                                                                                                                        if (!"needDel".equals(emoticonDataList2.get(i130).RomaingType)) {
                                                                                                                                                                            i126++;
                                                                                                                                                                            if (!TextUtils.isEmpty(emoticonDataList2.get(i130).md5)) {
                                                                                                                                                                                hashSet.add(emoticonDataList2.get(i130).md5);
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    i126 = 0;
                                                                                                                                                                    i127 = 1;
                                                                                                                                                                }
                                                                                                                                                                int size2 = list2.size();
                                                                                                                                                                ArrayList<String> arrayList9 = new ArrayList<>();
                                                                                                                                                                ArrayList<String> arrayList10 = new ArrayList<>();
                                                                                                                                                                ArrayList<String> arrayList11 = new ArrayList<>();
                                                                                                                                                                i128 = size2 + i126;
                                                                                                                                                                if (i128 > i125) {
                                                                                                                                                                    z27 = true;
                                                                                                                                                                }
                                                                                                                                                                for (CustomEmotionData customEmotionData2 : list2) {
                                                                                                                                                                    if (z27) {
                                                                                                                                                                        try {
                                                                                                                                                                            arrayList9.add(customEmotionData2.eId);
                                                                                                                                                                            arrayList10.add(customEmotionData2.url);
                                                                                                                                                                            String str42 = customEmotionData2.md5;
                                                                                                                                                                            if (str42 == null) {
                                                                                                                                                                                arrayList11.add("");
                                                                                                                                                                            } else {
                                                                                                                                                                                arrayList11.add(str42);
                                                                                                                                                                            }
                                                                                                                                                                        } catch (JSONException e87) {
                                                                                                                                                                            e = e87;
                                                                                                                                                                            i129 = 2;
                                                                                                                                                                            if (!QLog.isColorLevel()) {
                                                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", i129, e.getMessage());
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        i127++;
                                                                                                                                                                        customEmotionData2.emoId = i127;
                                                                                                                                                                        if (!TextUtils.isEmpty(customEmotionData2.md5) && !hashSet.contains(customEmotionData2.md5)) {
                                                                                                                                                                            iFavroamingDBManagerService2.insertCustomEmotion(customEmotionData2);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    i129 = 2;
                                                                                                                                                                }
                                                                                                                                                                if (!z27) {
                                                                                                                                                                    data.putInt("extra_key_over_num", i128 - i125);
                                                                                                                                                                    data.putBoolean("openManagerActivity", true);
                                                                                                                                                                    data.putStringArrayList("extra_key_paths", arrayList10);
                                                                                                                                                                    data.putStringArrayList("extra_key_pkgids", arrayList9);
                                                                                                                                                                    data.putStringArrayList("extra_key_md5s", arrayList11);
                                                                                                                                                                    data.putInt("extra_key_faile_count", size);
                                                                                                                                                                } else {
                                                                                                                                                                    messengerService11.getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
                                                                                                                                                                    MqqHandler handler = r112.getHandler(ChatActivity.class);
                                                                                                                                                                    if (handler != null) {
                                                                                                                                                                        handler.obtainMessage(10).sendToTarget();
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            messengerService11.J(data);
                                                                                                                                                        }
                                                                                                                                                    } catch (Exception e88) {
                                                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                                                            QLog.i("Q.emoji.web.MessengerService", 2, e88.getMessage());
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                } catch (JSONException e89) {
                                                                                                                                                    e = e89;
                                                                                                                                                    if (!QLog.isColorLevel()) {
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            data.putInt("result", 0);
                                                                                                                                            size = 0;
                                                                                                                                            if (list2 != null) {
                                                                                                                                                IFavroamingDBManagerService iFavroamingDBManagerService22 = (IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class);
                                                                                                                                                emoticonDataList2 = iFavroamingDBManagerService22.getEmoticonDataList();
                                                                                                                                                i125 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                                                                                                                                                HashSet hashSet2 = new HashSet();
                                                                                                                                                if (emoticonDataList2 == null) {
                                                                                                                                                }
                                                                                                                                                int size22 = list2.size();
                                                                                                                                                ArrayList<String> arrayList92 = new ArrayList<>();
                                                                                                                                                ArrayList<String> arrayList102 = new ArrayList<>();
                                                                                                                                                ArrayList<String> arrayList112 = new ArrayList<>();
                                                                                                                                                i128 = size22 + i126;
                                                                                                                                                if (i128 > i125) {
                                                                                                                                                }
                                                                                                                                                while (r12.hasNext()) {
                                                                                                                                                }
                                                                                                                                                if (!z27) {
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            messengerService11.J(data);
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    r152 = incomingHandler2;
                                                                                                                                    if (i16 > 0) {
                                                                                                                                        ReportController.o(null, "CliOper", "", "", "0X8005C78", "0X8005C78", 0, 0, String.valueOf(i16), "", "", "");
                                                                                                                                        r152 = incomingHandler2;
                                                                                                                                    }
                                                                                                                                } catch (JSONException e87) {
                                                                                                                                    e = e87;
                                                                                                                                    jSONException = e;
                                                                                                                                    messengerService3 = messengerService11;
                                                                                                                                    incomingHandler3 = incomingHandler2;
                                                                                                                                    str10 = str7;
                                                                                                                                    r123 = messengerService3;
                                                                                                                                    r152 = incomingHandler3;
                                                                                                                                    data.putInt(str10, 1);
                                                                                                                                    message3 = jSONException.getMessage();
                                                                                                                                    if (message3 != null) {
                                                                                                                                    }
                                                                                                                                    r123.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                } catch (Exception e88) {
                                                                                                                                    e = e88;
                                                                                                                                    exc2 = e;
                                                                                                                                    r122 = messengerService11;
                                                                                                                                    r152 = incomingHandler2;
                                                                                                                                    data.putInt(str7, 1);
                                                                                                                                    message2 = exc2.getMessage();
                                                                                                                                    if (message2 != null) {
                                                                                                                                    }
                                                                                                                                    r122.J(data);
                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                    }
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            return;
                                                                                                                        } catch (Throwable th19) {
                                                                                                                            th5 = th19;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    r152 = this;
                                                                                                                    return;
                                                                                                                }
                                                                                                                try {
                                                                                                                    if (string2.equals("ipc_funnypic_query_info")) {
                                                                                                                        if (!TextUtils.isEmpty(bundle3.getString("jsonContent"))) {
                                                                                                                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.15
                                                                                                                                @Override // java.lang.Runnable
                                                                                                                                public void run() {
                                                                                                                                    r112.getEntityManagerFactory().createEntityManager();
                                                                                                                                    IFavroamingDBManagerService iFavroamingDBManagerService2 = (IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class);
                                                                                                                                    List<CustomEmotionData> emoticonDataList2 = iFavroamingDBManagerService2.getEmoticonDataList();
                                                                                                                                    int i124 = 0;
                                                                                                                                    if (emoticonDataList2 != null) {
                                                                                                                                        try {
                                                                                                                                            JSONArray jSONArray4 = new JSONArray();
                                                                                                                                            HashSet hashSet = new HashSet();
                                                                                                                                            int i125 = 0;
                                                                                                                                            for (CustomEmotionData customEmotionData2 : emoticonDataList2) {
                                                                                                                                                if (!"needDel".equals(customEmotionData2.RomaingType)) {
                                                                                                                                                    i125++;
                                                                                                                                                    if (!customEmotionData2.isMarkFace && TextUtils.isEmpty(customEmotionData2.md5) && !TextUtils.isEmpty(customEmotionData2.emoPath)) {
                                                                                                                                                        customEmotionData2.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(customEmotionData2.emoPath));
                                                                                                                                                        iFavroamingDBManagerService2.updateCustomEmotion(customEmotionData2);
                                                                                                                                                    }
                                                                                                                                                    if (!TextUtils.isEmpty(customEmotionData2.url) && customEmotionData2.url.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
                                                                                                                                                        String funnyPicName = FunnyPicHelperConstant.getFunnyPicName(customEmotionData2.url);
                                                                                                                                                        if (!TextUtils.isEmpty(funnyPicName) && funnyPicName.length() > 12) {
                                                                                                                                                            hashSet.add(funnyPicName.substring(i124, 12));
                                                                                                                                                        }
                                                                                                                                                    } else if (!TextUtils.isEmpty(customEmotionData2.md5) && customEmotionData2.md5.length() > 8) {
                                                                                                                                                        hashSet.add(FunnyPicHelperConstant.FUNYPIC_PREFIX + customEmotionData2.md5.substring(0, 8).toLowerCase());
                                                                                                                                                    }
                                                                                                                                                    i124 = 0;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            hashSet.addAll(FunnyPicHelperConstant.sloadingFunnyPics);
                                                                                                                                            Iterator it5 = hashSet.iterator();
                                                                                                                                            while (it5.hasNext()) {
                                                                                                                                                jSONArray4.mo162put((String) it5.next());
                                                                                                                                            }
                                                                                                                                            JSONObject jSONObject12 = new JSONObject();
                                                                                                                                            jSONObject12.put("remainNum", FavEmoConstant.FAV_LOCAL_MAX_COUNT - i125);
                                                                                                                                            jSONObject12.put("uid", jSONArray4);
                                                                                                                                            data.putInt("result", 0);
                                                                                                                                            data.putString("data", jSONObject12.toString());
                                                                                                                                            messengerService11.J(data);
                                                                                                                                            return;
                                                                                                                                        } catch (JSONException e89) {
                                                                                                                                            data.putInt("result", 1);
                                                                                                                                            String message4 = e89.getMessage();
                                                                                                                                            if (message4 != null) {
                                                                                                                                                data.putString("message", message4);
                                                                                                                                            }
                                                                                                                                            messengerService11.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", 2, e89.getMessage());
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        } catch (Exception e95) {
                                                                                                                                            data.putInt("result", 1);
                                                                                                                                            String message5 = e95.getMessage();
                                                                                                                                            if (message5 != null) {
                                                                                                                                                data.putString("message", message5);
                                                                                                                                            }
                                                                                                                                            messengerService11.J(data);
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", 2, message5);
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    try {
                                                                                                                                        JSONObject jSONObject13 = new JSONObject();
                                                                                                                                        jSONObject13.put("remainNum", FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                                                                                                                                        jSONObject13.put("uid", new JSONArray());
                                                                                                                                        data.putInt("result", 0);
                                                                                                                                        data.putString("data", jSONObject13.toString());
                                                                                                                                        messengerService11.J(data);
                                                                                                                                    } catch (Exception e96) {
                                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                                            QLog.i("Q.emoji.web.MessengerService", 2, e96.getMessage());
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }, 5, null, true);
                                                                                                                        } else {
                                                                                                                            try {
                                                                                                                                JSONObject jSONObject12 = new JSONObject();
                                                                                                                                jSONObject12.put("remainNum", FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                                                                                                                                jSONObject12.put("uid", new JSONArray());
                                                                                                                                data.putInt(str34, 0);
                                                                                                                                data.putString("data", jSONObject12.toString());
                                                                                                                                messengerService11.J(data);
                                                                                                                            } catch (Exception e89) {
                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                    QLog.i("Q.emoji.web.MessengerService", 2, e89.getMessage());
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    try {
                                                                                                                        if ("ipc_comic_emoticon_add_info".equals(string2)) {
                                                                                                                            JSONObject jSONObject13 = new JSONObject();
                                                                                                                            final JSONObject jSONObject14 = new JSONObject();
                                                                                                                            try {
                                                                                                                                JSONArray jSONArray4 = new JSONArray(bundle3.getString("listArray"));
                                                                                                                                final IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) r112.getRuntimeService(IVipComicMqqManagerService.class);
                                                                                                                                ArrayList arrayList9 = new ArrayList();
                                                                                                                                List<CustomEmotionData> emoticonList = iVipComicMqqManagerService.getEmoticonList(arrayList9);
                                                                                                                                int size = FavEmoConstant.FAV_LOCAL_MAX_COUNT - arrayList9.size();
                                                                                                                                jSONObject14.put("totalNum", FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                                                                                                                                jSONObject14.put("remainNum", size);
                                                                                                                                jSONObject14.put("succeedNum", 0);
                                                                                                                                jSONObject14.put("failedNum", jSONArray4.length());
                                                                                                                                try {
                                                                                                                                    if (jSONArray4.length() > size) {
                                                                                                                                        jSONObject13.put("code", 2);
                                                                                                                                        jSONObject13.put("message", "limit error");
                                                                                                                                        jSONObject13.put("data", jSONObject14);
                                                                                                                                        data.putString(str34, jSONObject13.toString());
                                                                                                                                        messengerService11.J(data);
                                                                                                                                    } else {
                                                                                                                                        str31 = "code";
                                                                                                                                        try {
                                                                                                                                            ArrayList arrayList10 = new ArrayList();
                                                                                                                                            ArrayList arrayList11 = new ArrayList();
                                                                                                                                            Iterator<CustomEmotionData> it5 = emoticonList.iterator();
                                                                                                                                            int i124 = 0;
                                                                                                                                            messengerService11 = messengerService11;
                                                                                                                                            while (it5.hasNext()) {
                                                                                                                                                Iterator<CustomEmotionData> it6 = it5;
                                                                                                                                                CustomEmotionData next = it5.next();
                                                                                                                                                int i125 = size;
                                                                                                                                                messengerService2 = messengerService11;
                                                                                                                                                try {
                                                                                                                                                    if (!"needDel".equals(next.RomaingType)) {
                                                                                                                                                        if (!TextUtils.isEmpty(next.md5)) {
                                                                                                                                                            String upperCase = next.md5.toUpperCase();
                                                                                                                                                            if (!arrayList11.contains(upperCase)) {
                                                                                                                                                                arrayList11.add(upperCase);
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (!TextUtils.isEmpty(next.emoPath) && !arrayList10.contains(next.emoPath)) {
                                                                                                                                                            arrayList10.add(next.emoPath);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    int i126 = next.emoId;
                                                                                                                                                    if (i124 < i126) {
                                                                                                                                                        i124 = i126;
                                                                                                                                                    }
                                                                                                                                                    it5 = it6;
                                                                                                                                                    size = i125;
                                                                                                                                                    messengerService11 = messengerService2;
                                                                                                                                                } catch (Exception e95) {
                                                                                                                                                    exc = e95;
                                                                                                                                                    str3 = str34;
                                                                                                                                                    jSONObject = jSONObject14;
                                                                                                                                                    bundle = data;
                                                                                                                                                    str4 = "message";
                                                                                                                                                    jSONObject2 = jSONObject13;
                                                                                                                                                    str2 = "MessengerService$IncomingHandler";
                                                                                                                                                    messengerService = messengerService2;
                                                                                                                                                    str5 = str31;
                                                                                                                                                    JSONObject jSONObject15 = jSONObject2;
                                                                                                                                                    try {
                                                                                                                                                        jSONObject15.put(str5, -1);
                                                                                                                                                        jSONObject15.put(str4, exc.getMessage());
                                                                                                                                                        jSONObject15.put("data", jSONObject);
                                                                                                                                                        Bundle bundle62 = bundle;
                                                                                                                                                        bundle62.putString(str3, jSONObject15.toString());
                                                                                                                                                        messengerService.J(bundle62);
                                                                                                                                                    } catch (JSONException e96) {
                                                                                                                                                        e96.printStackTrace();
                                                                                                                                                    }
                                                                                                                                                    exc.printStackTrace();
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            final int i127 = size;
                                                                                                                                            messengerService2 = messengerService11;
                                                                                                                                            try {
                                                                                                                                                ArrayList arrayList12 = new ArrayList(jSONArray4.length());
                                                                                                                                                final HashMap hashMap4 = new HashMap();
                                                                                                                                                final EntityManager createEntityManager = r112.getEntityManagerFactory().createEntityManager();
                                                                                                                                                int i128 = i124;
                                                                                                                                                ArrayList arrayList13 = new ArrayList();
                                                                                                                                                try {
                                                                                                                                                    final IFavroamingDBManagerService iFavroamingDBManagerService2 = (IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class);
                                                                                                                                                    bundle = data;
                                                                                                                                                    int i129 = 0;
                                                                                                                                                    while (i129 < jSONArray4.length()) {
                                                                                                                                                        try {
                                                                                                                                                            try {
                                                                                                                                                                jSONObject4 = (JSONObject) jSONArray4.get(i129);
                                                                                                                                                                str6 = str31;
                                                                                                                                                            } catch (Exception e97) {
                                                                                                                                                                exc = e97;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject13;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                str5 = str31;
                                                                                                                                                                JSONObject jSONObject152 = jSONObject2;
                                                                                                                                                                jSONObject152.put(str5, -1);
                                                                                                                                                                jSONObject152.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject152.put("data", jSONObject);
                                                                                                                                                                Bundle bundle622 = bundle;
                                                                                                                                                                bundle622.putString(str3, jSONObject152.toString());
                                                                                                                                                                messengerService.J(bundle622);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            try {
                                                                                                                                                                String upperCase2 = jSONObject4.getString("md5").toUpperCase();
                                                                                                                                                                jSONObject3 = jSONObject13;
                                                                                                                                                                try {
                                                                                                                                                                    VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
                                                                                                                                                                    vipComicFavorEmoStructMsgInfo.picMd5 = upperCase2;
                                                                                                                                                                    JSONArray jSONArray5 = jSONArray4;
                                                                                                                                                                    vipComicFavorEmoStructMsgInfo.actionData = jSONObject4.getString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
                                                                                                                                                                    if (!arrayList10.contains(iVipComicMqqManagerService.getFilePath(upperCase2)) && !arrayList11.contains(upperCase2)) {
                                                                                                                                                                        CustomEmotionData customEmotionData2 = new CustomEmotionData();
                                                                                                                                                                        arrayList = arrayList10;
                                                                                                                                                                        customEmotionData2.uin = r112.getCurrentAccountUin();
                                                                                                                                                                        customEmotionData2.eId = jSONObject4.optString("name");
                                                                                                                                                                        int i130 = i128 + 1;
                                                                                                                                                                        customEmotionData2.emoId = i130;
                                                                                                                                                                        i128 = i130;
                                                                                                                                                                        customEmotionData2.url = jSONObject4.getString("imgUrl");
                                                                                                                                                                        customEmotionData2.md5 = upperCase2;
                                                                                                                                                                        arrayList12.add(customEmotionData2);
                                                                                                                                                                        hashMap4.put(vipComicFavorEmoStructMsgInfo.picMd5, vipComicFavorEmoStructMsgInfo);
                                                                                                                                                                        iFavroamingDBManagerService2.insertCustomEmotion(customEmotionData2);
                                                                                                                                                                        createEntityManager.persist(vipComicFavorEmoStructMsgInfo);
                                                                                                                                                                        i129++;
                                                                                                                                                                        jSONObject13 = jSONObject3;
                                                                                                                                                                        str31 = str6;
                                                                                                                                                                        jSONArray4 = jSONArray5;
                                                                                                                                                                        arrayList10 = arrayList;
                                                                                                                                                                    }
                                                                                                                                                                    arrayList = arrayList10;
                                                                                                                                                                    if (!vipComicFavorEmoStructMsgInfo.equals(iVipComicMqqManagerService.getComicStructInfo(upperCase2))) {
                                                                                                                                                                        arrayList13.clear();
                                                                                                                                                                        arrayList13.add(vipComicFavorEmoStructMsgInfo);
                                                                                                                                                                        iVipComicMqqManagerService.setMyComicEmoticon(arrayList13, true);
                                                                                                                                                                    }
                                                                                                                                                                    i129++;
                                                                                                                                                                    jSONObject13 = jSONObject3;
                                                                                                                                                                    str31 = str6;
                                                                                                                                                                    jSONArray4 = jSONArray5;
                                                                                                                                                                    arrayList10 = arrayList;
                                                                                                                                                                } catch (Exception e98) {
                                                                                                                                                                    jSONObject2 = jSONObject3;
                                                                                                                                                                    exc = e98;
                                                                                                                                                                    jSONObject = jSONObject14;
                                                                                                                                                                    str5 = str6;
                                                                                                                                                                    str3 = str34;
                                                                                                                                                                    str4 = "message";
                                                                                                                                                                    str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                    messengerService = messengerService2;
                                                                                                                                                                    JSONObject jSONObject1522 = jSONObject2;
                                                                                                                                                                    jSONObject1522.put(str5, -1);
                                                                                                                                                                    jSONObject1522.put(str4, exc.getMessage());
                                                                                                                                                                    jSONObject1522.put("data", jSONObject);
                                                                                                                                                                    Bundle bundle6222 = bundle;
                                                                                                                                                                    bundle6222.putString(str3, jSONObject1522.toString());
                                                                                                                                                                    messengerService.J(bundle6222);
                                                                                                                                                                    exc.printStackTrace();
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            } catch (Exception e99) {
                                                                                                                                                                exc = e99;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject13;
                                                                                                                                                                str5 = str6;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                JSONObject jSONObject15222 = jSONObject2;
                                                                                                                                                                jSONObject15222.put(str5, -1);
                                                                                                                                                                jSONObject15222.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject15222.put("data", jSONObject);
                                                                                                                                                                Bundle bundle62222 = bundle;
                                                                                                                                                                bundle62222.putString(str3, jSONObject15222.toString());
                                                                                                                                                                messengerService.J(bundle62222);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                        } catch (Exception e100) {
                                                                                                                                                            e = e100;
                                                                                                                                                            jSONObject = jSONObject14;
                                                                                                                                                            jSONObject2 = jSONObject13;
                                                                                                                                                            str3 = str34;
                                                                                                                                                            str4 = "message";
                                                                                                                                                            str2 = "MessengerService$IncomingHandler";
                                                                                                                                                            messengerService = messengerService2;
                                                                                                                                                            str5 = str31;
                                                                                                                                                            exc = e;
                                                                                                                                                            JSONObject jSONObject152222 = jSONObject2;
                                                                                                                                                            jSONObject152222.put(str5, -1);
                                                                                                                                                            jSONObject152222.put(str4, exc.getMessage());
                                                                                                                                                            jSONObject152222.put("data", jSONObject);
                                                                                                                                                            Bundle bundle622222 = bundle;
                                                                                                                                                            bundle622222.putString(str3, jSONObject152222.toString());
                                                                                                                                                            messengerService.J(bundle622222);
                                                                                                                                                            exc.printStackTrace();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    JSONArray jSONArray6 = jSONArray4;
                                                                                                                                                    str6 = str31;
                                                                                                                                                    jSONObject3 = jSONObject13;
                                                                                                                                                    try {
                                                                                                                                                        if (arrayList12.isEmpty()) {
                                                                                                                                                            jSONObject14.put("failedNum", 0);
                                                                                                                                                            if (jSONArray6.length() > 0) {
                                                                                                                                                                jSONObject14.put("succeedNum", jSONArray6.length());
                                                                                                                                                                MqqHandler handler = r112.getHandler(ChatActivity.class);
                                                                                                                                                                if (handler != null) {
                                                                                                                                                                    handler.obtainMessage(10).sendToTarget();
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            str31 = str6;
                                                                                                                                                            try {
                                                                                                                                                                jSONObject3.put(str31, 0);
                                                                                                                                                            } catch (Exception e101) {
                                                                                                                                                                exc = e101;
                                                                                                                                                                str5 = str31;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject3;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                JSONObject jSONObject1522222 = jSONObject2;
                                                                                                                                                                jSONObject1522222.put(str5, -1);
                                                                                                                                                                jSONObject1522222.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject1522222.put("data", jSONObject);
                                                                                                                                                                Bundle bundle6222222 = bundle;
                                                                                                                                                                bundle6222222.putString(str3, jSONObject1522222.toString());
                                                                                                                                                                messengerService.J(bundle6222222);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            try {
                                                                                                                                                                jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                                                                                                                                jSONObject3.put("data", jSONObject14);
                                                                                                                                                                try {
                                                                                                                                                                    bundle.putString(str34, jSONObject3.toString());
                                                                                                                                                                } catch (Exception e102) {
                                                                                                                                                                    exc = e102;
                                                                                                                                                                    str3 = str34;
                                                                                                                                                                    jSONObject = jSONObject14;
                                                                                                                                                                    jSONObject2 = jSONObject3;
                                                                                                                                                                    str4 = "message";
                                                                                                                                                                    bundle = bundle;
                                                                                                                                                                    str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                    messengerService = messengerService2;
                                                                                                                                                                    str5 = str31;
                                                                                                                                                                    JSONObject jSONObject15222222 = jSONObject2;
                                                                                                                                                                    jSONObject15222222.put(str5, -1);
                                                                                                                                                                    jSONObject15222222.put(str4, exc.getMessage());
                                                                                                                                                                    jSONObject15222222.put("data", jSONObject);
                                                                                                                                                                    Bundle bundle62222222 = bundle;
                                                                                                                                                                    bundle62222222.putString(str3, jSONObject15222222.toString());
                                                                                                                                                                    messengerService.J(bundle62222222);
                                                                                                                                                                    exc.printStackTrace();
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            } catch (Exception e103) {
                                                                                                                                                                exc = e103;
                                                                                                                                                                str5 = str31;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject3;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                str3 = str34;
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                JSONObject jSONObject152222222 = jSONObject2;
                                                                                                                                                                jSONObject152222222.put(str5, -1);
                                                                                                                                                                jSONObject152222222.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject152222222.put("data", jSONObject);
                                                                                                                                                                Bundle bundle622222222 = bundle;
                                                                                                                                                                bundle622222222.putString(str3, jSONObject152222222.toString());
                                                                                                                                                                messengerService.J(bundle622222222);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            try {
                                                                                                                                                                messengerService2.J(bundle);
                                                                                                                                                            } catch (Exception e104) {
                                                                                                                                                                exc = e104;
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject3;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                bundle = bundle;
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                str5 = str31;
                                                                                                                                                                JSONObject jSONObject1522222222 = jSONObject2;
                                                                                                                                                                jSONObject1522222222.put(str5, -1);
                                                                                                                                                                jSONObject1522222222.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject1522222222.put("data", jSONObject);
                                                                                                                                                                Bundle bundle6222222222 = bundle;
                                                                                                                                                                bundle6222222222.putString(str3, jSONObject1522222222.toString());
                                                                                                                                                                messengerService.J(bundle6222222222);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str31 = str6;
                                                                                                                                                            try {
                                                                                                                                                                str4 = "message";
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                bundle = bundle;
                                                                                                                                                                str5 = str31;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject3;
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                try {
                                                                                                                                                                    iVipComicMqqManagerService.handleComicEmoticon(messengerService2.getApplicationContext(), arrayList12, hashMap4, new IPicDownloadListener() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.16
                                                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:13:0x008e A[Catch: Exception -> 0x0100, JSONException -> 0x010f, TryCatch #2 {JSONException -> 0x010f, Exception -> 0x0100, blocks: (B:60:0x0010, B:62:0x0016, B:5:0x0042, B:6:0x005d, B:8:0x007e, B:10:0x0084, B:11:0x0088, B:13:0x008e, B:16:0x00a5, B:22:0x00ad, B:24:0x00b3, B:25:0x00bc, B:27:0x00c2, B:30:0x00d4, B:35:0x00d8, B:37:0x00e7, B:38:0x00f0, B:40:0x00fc, B:3:0x002d), top: B:59:0x0010 }] */
                                                                                                                                                                        /* JADX WARN: Removed duplicated region for block: B:5:0x0042 A[Catch: Exception -> 0x0100, JSONException -> 0x010f, TryCatch #2 {JSONException -> 0x010f, Exception -> 0x0100, blocks: (B:60:0x0010, B:62:0x0016, B:5:0x0042, B:6:0x005d, B:8:0x007e, B:10:0x0084, B:11:0x0088, B:13:0x008e, B:16:0x00a5, B:22:0x00ad, B:24:0x00b3, B:25:0x00bc, B:27:0x00c2, B:30:0x00d4, B:35:0x00d8, B:37:0x00e7, B:38:0x00f0, B:40:0x00fc, B:3:0x002d), top: B:59:0x0010 }] */
                                                                                                                                                                        @Override // com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener
                                                                                                                                                                        /*
                                                                                                                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                                                                        */
                                                                                                                                                                        public void onDone(List<CustomEmotionData> list2, List<CustomEmotionData> list3) {
                                                                                                                                                                            if (list3 != null) {
                                                                                                                                                                                try {
                                                                                                                                                                                    if (!list3.isEmpty()) {
                                                                                                                                                                                        jSONObject3.put("code", 1);
                                                                                                                                                                                        jSONObject3.put("message", "not all success");
                                                                                                                                                                                        jSONObject14.put("failedNum", list3.size());
                                                                                                                                                                                        if (list2 != null) {
                                                                                                                                                                                            jSONObject14.put("succeedNum", list2.size());
                                                                                                                                                                                            jSONObject14.put("remainNum", i127 - list2.size());
                                                                                                                                                                                        }
                                                                                                                                                                                        jSONObject3.put("data", jSONObject14);
                                                                                                                                                                                        bundle.putString("result", jSONObject3.toString());
                                                                                                                                                                                        messengerService2.J(bundle);
                                                                                                                                                                                        if (list3 != null && !list3.isEmpty()) {
                                                                                                                                                                                            for (CustomEmotionData customEmotionData3 : list3) {
                                                                                                                                                                                                VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo2 = (VipComicFavorEmoStructMsgInfo) hashMap4.get(customEmotionData3.md5);
                                                                                                                                                                                                iFavroamingDBManagerService2.deleteCustomEmotion(customEmotionData3);
                                                                                                                                                                                                if (vipComicFavorEmoStructMsgInfo2 != null) {
                                                                                                                                                                                                    createEntityManager.remove(vipComicFavorEmoStructMsgInfo2);
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                        if (list2 == null && !list2.isEmpty()) {
                                                                                                                                                                                            ArrayList arrayList14 = new ArrayList();
                                                                                                                                                                                            Iterator<CustomEmotionData> it7 = list2.iterator();
                                                                                                                                                                                            while (it7.hasNext()) {
                                                                                                                                                                                                VipComicFavorEmoStructMsgInfo vipComicFavorEmoStructMsgInfo3 = (VipComicFavorEmoStructMsgInfo) hashMap4.get(it7.next().md5);
                                                                                                                                                                                                if (vipComicFavorEmoStructMsgInfo3 != null) {
                                                                                                                                                                                                    arrayList14.add(vipComicFavorEmoStructMsgInfo3);
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                            iVipComicMqqManagerService.setMyComicEmoticon(arrayList14, true);
                                                                                                                                                                                            MqqHandler handler2 = r112.getHandler(ChatActivity.class);
                                                                                                                                                                                            if (handler2 != null) {
                                                                                                                                                                                                handler2.obtainMessage(10).sendToTarget();
                                                                                                                                                                                            }
                                                                                                                                                                                            IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) r112.getRuntimeService(IFavroamingManagerService.class);
                                                                                                                                                                                            if (iFavroamingManagerService != null) {
                                                                                                                                                                                                iFavroamingManagerService.syncUpload(list2);
                                                                                                                                                                                                return;
                                                                                                                                                                                            }
                                                                                                                                                                                            return;
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (JSONException e105) {
                                                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                                                        QLog.i("Q.emoji.web.MessengerService", 2, e105.getMessage());
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    return;
                                                                                                                                                                                } catch (Exception e106) {
                                                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                                                        QLog.i("Q.emoji.web.MessengerService", 2, e106.getMessage());
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            jSONObject3.put("code", 0);
                                                                                                                                                                            jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                                                                                                                                            jSONObject14.put("failedNum", 0);
                                                                                                                                                                            if (list2 != null) {
                                                                                                                                                                            }
                                                                                                                                                                            jSONObject3.put("data", jSONObject14);
                                                                                                                                                                            bundle.putString("result", jSONObject3.toString());
                                                                                                                                                                            messengerService2.J(bundle);
                                                                                                                                                                            if (list3 != null) {
                                                                                                                                                                                while (r10.hasNext()) {
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            if (list2 == null) {
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    });
                                                                                                                                                                } catch (Exception e105) {
                                                                                                                                                                    e = e105;
                                                                                                                                                                    exc = e;
                                                                                                                                                                    JSONObject jSONObject15222222222 = jSONObject2;
                                                                                                                                                                    jSONObject15222222222.put(str5, -1);
                                                                                                                                                                    jSONObject15222222222.put(str4, exc.getMessage());
                                                                                                                                                                    jSONObject15222222222.put("data", jSONObject);
                                                                                                                                                                    Bundle bundle62222222222 = bundle;
                                                                                                                                                                    bundle62222222222.putString(str3, jSONObject15222222222.toString());
                                                                                                                                                                    messengerService.J(bundle62222222222);
                                                                                                                                                                    exc.printStackTrace();
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            } catch (Exception e106) {
                                                                                                                                                                e = e106;
                                                                                                                                                                messengerService = messengerService2;
                                                                                                                                                                str3 = str34;
                                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                                jSONObject2 = jSONObject3;
                                                                                                                                                                str4 = "message";
                                                                                                                                                                bundle = bundle;
                                                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                                                                str5 = str31;
                                                                                                                                                                exc = e;
                                                                                                                                                                JSONObject jSONObject152222222222 = jSONObject2;
                                                                                                                                                                jSONObject152222222222.put(str5, -1);
                                                                                                                                                                jSONObject152222222222.put(str4, exc.getMessage());
                                                                                                                                                                jSONObject152222222222.put("data", jSONObject);
                                                                                                                                                                Bundle bundle622222222222 = bundle;
                                                                                                                                                                bundle622222222222.putString(str3, jSONObject152222222222.toString());
                                                                                                                                                                messengerService.J(bundle622222222222);
                                                                                                                                                                exc.printStackTrace();
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    } catch (Exception e107) {
                                                                                                                                                        e = e107;
                                                                                                                                                        jSONObject2 = jSONObject3;
                                                                                                                                                        jSONObject = jSONObject14;
                                                                                                                                                        str5 = str6;
                                                                                                                                                        str3 = str34;
                                                                                                                                                        str4 = "message";
                                                                                                                                                        str2 = "MessengerService$IncomingHandler";
                                                                                                                                                        messengerService = messengerService2;
                                                                                                                                                    }
                                                                                                                                                } catch (Exception e108) {
                                                                                                                                                    e = e108;
                                                                                                                                                    jSONObject = jSONObject14;
                                                                                                                                                    bundle = data;
                                                                                                                                                    str4 = "message";
                                                                                                                                                    jSONObject2 = jSONObject13;
                                                                                                                                                    str3 = str34;
                                                                                                                                                }
                                                                                                                                            } catch (Exception e109) {
                                                                                                                                                e = e109;
                                                                                                                                                str3 = str34;
                                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                                bundle = data;
                                                                                                                                                str4 = "message";
                                                                                                                                                jSONObject2 = jSONObject13;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e110) {
                                                                                                                                            e = e110;
                                                                                                                                            str3 = str34;
                                                                                                                                            jSONObject = jSONObject14;
                                                                                                                                            messengerService = messengerService11;
                                                                                                                                            bundle = data;
                                                                                                                                            str4 = "message";
                                                                                                                                            jSONObject2 = jSONObject13;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Exception e111) {
                                                                                                                                    exc = e111;
                                                                                                                                    str3 = str34;
                                                                                                                                    jSONObject = jSONObject14;
                                                                                                                                    messengerService = messengerService11;
                                                                                                                                    bundle = data;
                                                                                                                                    str4 = "message";
                                                                                                                                    jSONObject2 = jSONObject13;
                                                                                                                                }
                                                                                                                            } catch (Exception e112) {
                                                                                                                                e = e112;
                                                                                                                                str3 = str34;
                                                                                                                                jSONObject = jSONObject14;
                                                                                                                                messengerService = messengerService11;
                                                                                                                                bundle = data;
                                                                                                                                str4 = "message";
                                                                                                                                jSONObject2 = jSONObject13;
                                                                                                                                str5 = "code";
                                                                                                                                str2 = "MessengerService$IncomingHandler";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str2 = "MessengerService$IncomingHandler";
                                                                                                                            try {
                                                                                                                                if ("ipc_comic_emoticon_query_info".equals(string2)) {
                                                                                                                                    ?? jSONObject16 = new JSONObject();
                                                                                                                                    JSONObject jSONObject17 = new JSONObject();
                                                                                                                                    try {
                                                                                                                                        IVipComicMqqManagerService iVipComicMqqManagerService2 = (IVipComicMqqManagerService) r112.getRuntimeService(IVipComicMqqManagerService.class);
                                                                                                                                        ArrayList arrayList14 = new ArrayList();
                                                                                                                                        iVipComicMqqManagerService2.getEmoticonList(arrayList14);
                                                                                                                                        int size2 = FavEmoConstant.FAV_LOCAL_MAX_COUNT - arrayList14.size();
                                                                                                                                        jSONObject17.put("totalNum", FavEmoConstant.FAV_LOCAL_MAX_COUNT);
                                                                                                                                        jSONObject17.put("remainNum", size2);
                                                                                                                                        Map<String, VipComicFavorEmoStructMsgInfo> comicStructInfoMap = iVipComicMqqManagerService2.getComicStructInfoMap();
                                                                                                                                        JSONArray jSONArray7 = new JSONArray();
                                                                                                                                        if (comicStructInfoMap != null) {
                                                                                                                                            for (CustomEmotionData customEmotionData3 : arrayList14) {
                                                                                                                                                if (!TextUtils.isEmpty(customEmotionData3.md5)) {
                                                                                                                                                    String upperCase3 = customEmotionData3.md5.toUpperCase();
                                                                                                                                                    if (comicStructInfoMap.get(upperCase3) != null) {
                                                                                                                                                        jSONArray7.mo162put(upperCase3);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        jSONObject17.put("list", jSONArray7);
                                                                                                                                        jSONObject16.put("code", 0);
                                                                                                                                        jSONObject16.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                                                                                                        jSONObject16.put("data", jSONObject17);
                                                                                                                                        data.putString(str34, jSONObject16.toString());
                                                                                                                                        messengerService11.J(data);
                                                                                                                                    } catch (Exception e113) {
                                                                                                                                        try {
                                                                                                                                            jSONObject16.put("code", -1);
                                                                                                                                            jSONObject16.put("message", e113.getMessage());
                                                                                                                                            jSONObject16.put("data", jSONObject17);
                                                                                                                                            data.putString(str34, jSONObject16.toString());
                                                                                                                                            messengerService11.J(data);
                                                                                                                                        } catch (JSONException e114) {
                                                                                                                                            e114.printStackTrace();
                                                                                                                                        }
                                                                                                                                        e113.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else if ("ipc_sync_fav_emoticon".equals(string2)) {
                                                                                                                                    JSONObject jSONObject18 = new JSONObject();
                                                                                                                                    try {
                                                                                                                                        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) r112.getRuntimeService(IFavroamingManagerService.class);
                                                                                                                                        lb1.a aVar2 = (lb1.a) r112.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER);
                                                                                                                                        if (iFavroamingManagerService != null && aVar2 != null) {
                                                                                                                                            iFavroamingManagerService.syncRoaming();
                                                                                                                                            aVar2.M();
                                                                                                                                            jSONObject18.put("code", 0);
                                                                                                                                            jSONObject18.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                                                                                                            data.putString(str34, jSONObject18.toString());
                                                                                                                                            messengerService11.J(data);
                                                                                                                                        } else {
                                                                                                                                            throw new RuntimeException("not in qq main process");
                                                                                                                                        }
                                                                                                                                    } catch (Exception e115) {
                                                                                                                                        try {
                                                                                                                                            jSONObject18.put("code", -1);
                                                                                                                                            jSONObject18.put("message", e115.getMessage());
                                                                                                                                            data.putString(str34, jSONObject18.toString());
                                                                                                                                            messengerService11.J(data);
                                                                                                                                        } catch (JSONException e116) {
                                                                                                                                            e116.printStackTrace();
                                                                                                                                        }
                                                                                                                                        e115.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else if ("ipc_video_isinstalled".equals(string2)) {
                                                                                                                                    Bundle bundle63 = new Bundle();
                                                                                                                                    bundle63.putBoolean("isInstalled", com.tencent.mobileqq.video.e.a(r112.getApp()));
                                                                                                                                    data.putBundle(str31, bundle63);
                                                                                                                                    messengerService11.J(data);
                                                                                                                                } else if (!"ipc_video_install_plugin".equals(string2)) {
                                                                                                                                    if ("ipc_jump_to_conversation".equals(string2)) {
                                                                                                                                        MqqHandler handler2 = r112.getHandler(Conversation.class);
                                                                                                                                        if (handler2 != null) {
                                                                                                                                            Message obtainMessage = handler2.obtainMessage(data.getInt("banner_msg"));
                                                                                                                                            Bundle bundle64 = new Bundle();
                                                                                                                                            bundle64.putCharSequence("tips", data.getCharSequence("banner_tips"));
                                                                                                                                            bundle64.putInt("icon", data.getInt("banner_icon"));
                                                                                                                                            bundle64.putInt("timeout", data.getInt("banner_timeout"));
                                                                                                                                            bundle64.putCharSequence(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, data.getCharSequence(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                                                                                                                                            bundle64.putCharSequence("action", data.getCharSequence("action"));
                                                                                                                                            bundle64.putCharSequence("category", data.getCharSequence("category"));
                                                                                                                                            bundle64.putInt(WadlProxyConsts.FLAGS, data.getInt(WadlProxyConsts.FLAGS, 0));
                                                                                                                                            obtainMessage.obj = bundle64;
                                                                                                                                            handler2.sendMessage(obtainMessage);
                                                                                                                                        }
                                                                                                                                    } else if ("ipc_qqbrowser_to_conversation".equals(string2)) {
                                                                                                                                        MqqHandler handler3 = r112.getHandler(Conversation.class);
                                                                                                                                        if (handler3 != null) {
                                                                                                                                            Message obtainMessage2 = handler3.obtainMessage(data.getInt("banner_msg"));
                                                                                                                                            obtainMessage2.obj = data.getBundle("barInfo");
                                                                                                                                            handler3.sendMessage(obtainMessage2);
                                                                                                                                        }
                                                                                                                                    } else if ("ipc_update_avatar".equals(string2)) {
                                                                                                                                        String string56 = bundle3.getString("path");
                                                                                                                                        ?? intent3 = new Intent();
                                                                                                                                        intent3.putExtras(bundle3);
                                                                                                                                        if (ProfileCardUtil.h0(r112, string56, intent3)) {
                                                                                                                                            QQToast.makeText(r112.getApp(), 2, R.string.hfd, 0).show();
                                                                                                                                        } else {
                                                                                                                                            QQToast.makeText(r112.getApp(), 1, R.string.hfc, 0).show();
                                                                                                                                        }
                                                                                                                                    } else if ("batchGetUserInfo".equals(string2)) {
                                                                                                                                        final String string57 = data.getBundle(Const.BUNDLE_KEY_REQUEST).getString("member_list");
                                                                                                                                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.17
                                                                                                                                            /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
                                                                                                                                            /* JADX WARN: Removed duplicated region for block: B:32:0x00fc A[Catch: JSONException -> 0x011e, TryCatch #8 {JSONException -> 0x011e, blocks: (B:3:0x0013, B:4:0x001c, B:6:0x0022, B:8:0x004d, B:10:0x005a, B:18:0x007c, B:24:0x00dd, B:26:0x00e3, B:28:0x0103, B:30:0x00ec, B:31:0x00f4, B:32:0x00fc, B:36:0x0082, B:57:0x00b0, B:64:0x00b9, B:63:0x00b6, B:48:0x009a, B:52:0x00a0, B:42:0x00aa, B:71:0x00ba, B:73:0x00c0, B:74:0x00c7, B:76:0x00cf), top: B:2:0x0013, inners: #3, #6, #7 }] */
                                                                                                                                            @Override // java.lang.Runnable
                                                                                                                                            /*
                                                                                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                                            */
                                                                                                                                            public void run() {
                                                                                                                                                int i131;
                                                                                                                                                String s18;
                                                                                                                                                Throwable th20;
                                                                                                                                                Bundle bundle65 = new Bundle();
                                                                                                                                                JSONArray jSONArray8 = new JSONArray();
                                                                                                                                                try {
                                                                                                                                                    JSONArray jSONArray9 = new JSONArray(string57);
                                                                                                                                                    int i132 = 0;
                                                                                                                                                    int i133 = 0;
                                                                                                                                                    while (i133 < jSONArray9.length()) {
                                                                                                                                                        JSONObject jSONObject19 = jSONArray9.getJSONObject(i133);
                                                                                                                                                        String string58 = jSONObject19.getString("uin");
                                                                                                                                                        int i134 = jSONObject19.getInt(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                                                                                                                                                        String string59 = jSONObject19.getString("extraUin");
                                                                                                                                                        String str42 = "";
                                                                                                                                                        File file = new File(r112.getCustomFaceFilePath(1, string58, i132));
                                                                                                                                                        if (file.exists()) {
                                                                                                                                                            i131 = i133;
                                                                                                                                                            long length2 = file.length();
                                                                                                                                                            if (length2 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
                                                                                                                                                                byte[] bArr = new byte[(int) length2];
                                                                                                                                                                FileInputStream fileInputStream = null;
                                                                                                                                                                try {
                                                                                                                                                                    try {
                                                                                                                                                                        FileInputStream fileInputStream2 = new FileInputStream(file);
                                                                                                                                                                        try {
                                                                                                                                                                            fileInputStream2.read(bArr);
                                                                                                                                                                            String str43 = "data:image/png;base64," + PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2);
                                                                                                                                                                            try {
                                                                                                                                                                                fileInputStream2.close();
                                                                                                                                                                            } catch (IOException e117) {
                                                                                                                                                                                e117.printStackTrace();
                                                                                                                                                                            }
                                                                                                                                                                            str42 = str43;
                                                                                                                                                                        } catch (FileNotFoundException e118) {
                                                                                                                                                                            e = e118;
                                                                                                                                                                            fileInputStream = fileInputStream2;
                                                                                                                                                                            e.printStackTrace();
                                                                                                                                                                            if (fileInputStream != null) {
                                                                                                                                                                                fileInputStream.close();
                                                                                                                                                                            }
                                                                                                                                                                            if (i134 != 0) {
                                                                                                                                                                            }
                                                                                                                                                                            JSONObject jSONObject20 = new JSONObject();
                                                                                                                                                                            jSONObject20.put("uin", string58);
                                                                                                                                                                            jSONObject20.put("nick", s18);
                                                                                                                                                                            jSONObject20.put("head", str42);
                                                                                                                                                                            jSONArray8.mo162put(jSONObject20);
                                                                                                                                                                            i133 = i131 + 1;
                                                                                                                                                                        } catch (IOException e119) {
                                                                                                                                                                            e = e119;
                                                                                                                                                                            fileInputStream = fileInputStream2;
                                                                                                                                                                            e.printStackTrace();
                                                                                                                                                                            if (fileInputStream != null) {
                                                                                                                                                                                try {
                                                                                                                                                                                    fileInputStream.close();
                                                                                                                                                                                } catch (IOException e120) {
                                                                                                                                                                                    e120.printStackTrace();
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            if (i134 != 0) {
                                                                                                                                                                            }
                                                                                                                                                                            JSONObject jSONObject202 = new JSONObject();
                                                                                                                                                                            jSONObject202.put("uin", string58);
                                                                                                                                                                            jSONObject202.put("nick", s18);
                                                                                                                                                                            jSONObject202.put("head", str42);
                                                                                                                                                                            jSONArray8.mo162put(jSONObject202);
                                                                                                                                                                            i133 = i131 + 1;
                                                                                                                                                                        } catch (Throwable th21) {
                                                                                                                                                                            th20 = th21;
                                                                                                                                                                            fileInputStream = fileInputStream2;
                                                                                                                                                                            if (fileInputStream != null) {
                                                                                                                                                                                try {
                                                                                                                                                                                    fileInputStream.close();
                                                                                                                                                                                    throw th20;
                                                                                                                                                                                } catch (IOException e121) {
                                                                                                                                                                                    e121.printStackTrace();
                                                                                                                                                                                    throw th20;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            throw th20;
                                                                                                                                                                        }
                                                                                                                                                                    } catch (FileNotFoundException e122) {
                                                                                                                                                                        e = e122;
                                                                                                                                                                    } catch (IOException e123) {
                                                                                                                                                                        e = e123;
                                                                                                                                                                    }
                                                                                                                                                                } catch (Throwable th22) {
                                                                                                                                                                    th20 = th22;
                                                                                                                                                                }
                                                                                                                                                            } else if (QLog.isColorLevel()) {
                                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", 2, "batchGetUserInfo head file size too large");
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            i131 = i133;
                                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", 2, "batchGetUserInfo head file not exist");
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (i134 != 0) {
                                                                                                                                                            if (i134 != 1) {
                                                                                                                                                                if (i134 != 3000) {
                                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                                        QLog.i("Q.emoji.web.MessengerService", 2, "batchGetUserInfo sessionType not supported");
                                                                                                                                                                    }
                                                                                                                                                                    s18 = string58;
                                                                                                                                                                    i132 = 0;
                                                                                                                                                                } else {
                                                                                                                                                                    i132 = 0;
                                                                                                                                                                    s18 = ac.s(r112, string58, string59, 2, 0);
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                i132 = 0;
                                                                                                                                                                s18 = ac.s(r112, string58, string59, 1, 0);
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            i132 = 0;
                                                                                                                                                            s18 = ac.s(r112, string58, string59, 0, 0);
                                                                                                                                                        }
                                                                                                                                                        JSONObject jSONObject2022 = new JSONObject();
                                                                                                                                                        jSONObject2022.put("uin", string58);
                                                                                                                                                        jSONObject2022.put("nick", s18);
                                                                                                                                                        jSONObject2022.put("head", str42);
                                                                                                                                                        jSONArray8.mo162put(jSONObject2022);
                                                                                                                                                        i133 = i131 + 1;
                                                                                                                                                    }
                                                                                                                                                } catch (JSONException unused2) {
                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                        QLog.i("Q.emoji.web.MessengerService", 2, "batchGetUserInfo parse member_list error");
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                bundle65.putString("result", jSONArray8.toString());
                                                                                                                                                data.putBundle("response", bundle65);
                                                                                                                                                messengerService11.J(data);
                                                                                                                                            }
                                                                                                                                        }, 5, null, false);
                                                                                                                                        messengerService11.J(data);
                                                                                                                                    } else if ("ipc_newer_guide".equals(string2)) {
                                                                                                                                        LoginWelcomeManager.o(r112).w(messengerService11, data);
                                                                                                                                    } else if ("ipc_should_refresh_cardinfo".equals(string2)) {
                                                                                                                                        com.tencent.mobileqq.nearby.b bVar3 = (com.tencent.mobileqq.nearby.b) r112.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                                                                                                                                        String string58 = bundle3.getString("targetuin");
                                                                                                                                        String string59 = bundle3.getString("tinyid");
                                                                                                                                        bVar3.c().put(r112.getCurrentUin() + r152, 1);
                                                                                                                                        if (!TextUtils.isEmpty(string58)) {
                                                                                                                                            bVar3.c().put(string58, 1);
                                                                                                                                        } else if (!TextUtils.isEmpty(string59)) {
                                                                                                                                            bVar3.c().put(string59, 1);
                                                                                                                                        }
                                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                                            QLog.i("IPC_SHOULD_REFRESH_CARDINFO", 2, "handle ipc msg: IPC_SHOULD_REFRESH_CARDINFO uin:" + string58 + ",tinyId=" + string59);
                                                                                                                                        }
                                                                                                                                    } else if ("ipc_cmd_preload_image".equals(string2)) {
                                                                                                                                        try {
                                                                                                                                            JSONArray jSONArray8 = new JSONArray(bundle3.getString("pic_url"));
                                                                                                                                            for (int i131 = 0; i131 < jSONArray8.length(); i131++) {
                                                                                                                                                String string60 = jSONArray8.getString(i131);
                                                                                                                                                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                                                                                                                                obtain.mMemoryCacheKeySuffix = "now";
                                                                                                                                                URLDrawable drawable2 = URLDrawable.getDrawable(string60, obtain);
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                    QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle ipc msg: IPC_CMD_PRELOAD_IMAGE url:" + string60);
                                                                                                                                                }
                                                                                                                                                drawable2.downloadImediatly(false);
                                                                                                                                                incomingHandler = this;
                                                                                                                                                try {
                                                                                                                                                    try {
                                                                                                                                                        drawable2.setURLDrawableListener(new c(string60));
                                                                                                                                                    } catch (Throwable th20) {
                                                                                                                                                        th5 = th20;
                                                                                                                                                        str = str2;
                                                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } catch (Exception e117) {
                                                                                                                                                    e = e117;
                                                                                                                                                    QLog.e("IPC_CMD_PRELOAD_IMAGE", 1, e, new Object[0]);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (Exception e118) {
                                                                                                                                            e = e118;
                                                                                                                                            incomingHandler = this;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                if ("ipc_preload_plugin_process".equals(string2)) {
                                                                                                                                                    String string61 = bundle3.getString("processId");
                                                                                                                                                    Bundle bundle65 = new Bundle();
                                                                                                                                                    if ("qqcomic".equals(string61)) {
                                                                                                                                                        IQQPluginPreloadService iQQPluginPreloadService = (IQQPluginPreloadService) r112.getRuntimeService(IQQPluginPreloadService.class);
                                                                                                                                                        if (iQQPluginPreloadService == null) {
                                                                                                                                                            bundle65.putInt("code", -1);
                                                                                                                                                            bundle65.putString("message", "feature not support.");
                                                                                                                                                        } else {
                                                                                                                                                            bundle65.putInt("code", 0);
                                                                                                                                                            bundle65.putString("message", "ok.");
                                                                                                                                                            iQQPluginPreloadService.preload(9999);
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        bundle65.putInt("code", 1);
                                                                                                                                                        bundle65.putString("message", "invalid process id.");
                                                                                                                                                    }
                                                                                                                                                    data.putBundle(str31, bundle65);
                                                                                                                                                    messengerService11.J(data);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_historyhead_refresh_numflag".equals(string2)) {
                                                                                                                                                    if (!bundle3.getBoolean("hasHistoryHeadDel", false) || (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, r112)) == null) {
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    avatarHistoryNumProcessor.a();
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_signature_setordelete")) {
                                                                                                                                                    messengerService11.N = data;
                                                                                                                                                    int i132 = bundle3.getInt("id");
                                                                                                                                                    String string62 = bundle3.getString("content");
                                                                                                                                                    String string63 = bundle3.getString("location");
                                                                                                                                                    String string64 = bundle3.getString(MessageForRichState.SIGN_MSG_TOPICS);
                                                                                                                                                    String string65 = bundle3.getString(MessageForRichState.SIGN_MSG_TOPICS_POS);
                                                                                                                                                    String string66 = bundle3.getString("action_id");
                                                                                                                                                    String string67 = bundle3.getString("action_text");
                                                                                                                                                    String string68 = bundle3.getString("data_id");
                                                                                                                                                    String string69 = bundle3.getString("data_text");
                                                                                                                                                    String string70 = bundle3.getString("sticker_info_json");
                                                                                                                                                    StatusManager statusManager = (StatusManager) r112.getManager(QQManagerFactory.STATUS_MANAGER);
                                                                                                                                                    statusManager.C(messengerService11.R);
                                                                                                                                                    RichStatus richStatus = new RichStatus(null);
                                                                                                                                                    richStatus.locationPosition = TextUtils.isEmpty(string62) ? 0 : 1;
                                                                                                                                                    richStatus.tplId = i132;
                                                                                                                                                    ArrayList<String> arrayList15 = new ArrayList<>();
                                                                                                                                                    richStatus.plainText = arrayList15;
                                                                                                                                                    arrayList15.add(null);
                                                                                                                                                    richStatus.plainText.add(null);
                                                                                                                                                    richStatus.plainText.set(0, string62);
                                                                                                                                                    richStatus.locationText = string63;
                                                                                                                                                    richStatus.actionId = (TextUtils.isEmpty(string66) || !TextUtils.isDigitsOnly(string66)) ? 0 : Integer.parseInt(string66);
                                                                                                                                                    richStatus.actionText = string67;
                                                                                                                                                    richStatus.dataId = (TextUtils.isEmpty(string68) || !TextUtils.isDigitsOnly(string68)) ? 0 : Integer.parseInt(string68);
                                                                                                                                                    richStatus.dataText = string69;
                                                                                                                                                    richStatus.topicFromJson(string64);
                                                                                                                                                    richStatus.topicPosFromJson(string65);
                                                                                                                                                    if (!TextUtils.isEmpty(string70)) {
                                                                                                                                                        if (richStatus.mStickerInfos == null) {
                                                                                                                                                            richStatus.mStickerInfos = new ArrayList<>();
                                                                                                                                                        }
                                                                                                                                                        JSONArray jSONArray9 = new JSONArray(string70);
                                                                                                                                                        for (int i133 = 0; i133 < jSONArray9.length(); i133++) {
                                                                                                                                                            JSONObject jSONObject19 = jSONArray9.getJSONObject(i133);
                                                                                                                                                            RichStatus.StickerInfo stickerInfo = new RichStatus.StickerInfo();
                                                                                                                                                            String optString = jSONObject19.optString("stickerId");
                                                                                                                                                            if (!TextUtils.isEmpty(optString) && TextUtils.isDigitsOnly(optString)) {
                                                                                                                                                                stickerInfo.f282152id = Integer.parseInt(optString);
                                                                                                                                                            }
                                                                                                                                                            stickerInfo.width = (float) jSONObject19.optDouble("width");
                                                                                                                                                            stickerInfo.height = (float) jSONObject19.optDouble("height");
                                                                                                                                                            stickerInfo.posX = (float) jSONObject19.optDouble("posX");
                                                                                                                                                            stickerInfo.posY = (float) jSONObject19.optDouble("posY");
                                                                                                                                                            richStatus.mStickerInfos.add(stickerInfo);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    statusManager.E(richStatus, 0);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_signature_setlike")) {
                                                                                                                                                    r112.addObserver(messengerService11.S);
                                                                                                                                                    messengerService11.N = data;
                                                                                                                                                    String string71 = bundle3.getString("feedsId");
                                                                                                                                                    String string72 = bundle3.getString("uin");
                                                                                                                                                    int i134 = bundle3.getInt("actionType");
                                                                                                                                                    QLog.d("MessageService", 1, "IPC_CMD_SIGNATURE_SETLIKE");
                                                                                                                                                    ((SignatureHandler) r112.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).d3(string72, string71, 255, i134);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_signature_get_sync_tag")) {
                                                                                                                                                    StatusManager statusManager2 = (StatusManager) r112.getManager(QQManagerFactory.STATUS_MANAGER);
                                                                                                                                                    if (statusManager2 != null) {
                                                                                                                                                        messengerService11.P = data;
                                                                                                                                                        statusManager2.C(messengerService11.R);
                                                                                                                                                        StatusServlet.e(r112);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_add_record_to_db")) {
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_qidian_video_chat")) {
                                                                                                                                                    if (bundle3.containsKey("uin") && bundle3.containsKey(CloudStorageServlet.REQUEST_TYPE) && bundle3.containsKey("sigt") && bundle3.containsKey("nickname")) {
                                                                                                                                                        r112.addObserver(messengerService11.T);
                                                                                                                                                        HashMap<String, String> hashMap5 = new HashMap<>();
                                                                                                                                                        hashMap5.put(CloudStorageServlet.REQUEST_TYPE, bundle3.getString(CloudStorageServlet.REQUEST_TYPE));
                                                                                                                                                        hashMap5.put("nickname", bundle3.getString("nickname"));
                                                                                                                                                        ((QidianHandler) r112.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).S2(bundle3.getString("uin"), bundle3.getString("sigt"), hashMap5);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_font_download_hy_so")) {
                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                        QLog.d(FontManagerConstants.TAG, 2, "IPC startdownload hy so");
                                                                                                                                                    }
                                                                                                                                                    IFontManagerService iFontManagerService3 = (IFontManagerService) r112.getRuntimeService(IFontManagerService.class, r152);
                                                                                                                                                    iFontManagerService3.registerIPCDownloadListener(messengerService11.F);
                                                                                                                                                    iFontManagerService3.setDownloadHYSoCallback(data.getString("callbackid"));
                                                                                                                                                    FontSoBusiness.instance.startDownloadSo(VasUpdateConstants.SCID_HYFONT_SO, new d(iFontManagerService3));
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_save_team_work")) {
                                                                                                                                                    bundle3.setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
                                                                                                                                                    String string73 = bundle3.getString("savedUrl");
                                                                                                                                                    int i135 = bundle3.getInt("editType");
                                                                                                                                                    TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) bundle3.get(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
                                                                                                                                                    if (teamWorkFileImportInfo != null) {
                                                                                                                                                        boolean p17 = !teamWorkFileImportInfo.P ? TencentDocConvertConfigProcessor.a().p() : true;
                                                                                                                                                        if (teamWorkFileImportInfo.K && p17) {
                                                                                                                                                            if (i135 == 1) {
                                                                                                                                                                HardCodeUtil.qqStr(R.string.o3o);
                                                                                                                                                            } else if (i135 == 2) {
                                                                                                                                                                HardCodeUtil.qqStr(R.string.f172187o45);
                                                                                                                                                            }
                                                                                                                                                            String format = String.format(r112.getApp().getString(R.string.hy6), "\"" + teamWorkFileImportInfo.f292074f + "\"");
                                                                                                                                                            MessageRecord d17 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS);
                                                                                                                                                            long K0 = com.tencent.mobileqq.service.message.e.K0();
                                                                                                                                                            String currentAccountUin = r112.getCurrentAccountUin();
                                                                                                                                                            String str42 = teamWorkFileImportInfo.f292072e;
                                                                                                                                                            d17.init(currentAccountUin, str42, str42, format, K0, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, teamWorkFileImportInfo.f292070d, K0);
                                                                                                                                                            d17.isread = true;
                                                                                                                                                            d17.saveExtInfoToExtStr(AppConstants.KEY_TEAM_WORK_EXT_INFO_NEW_URL, string73);
                                                                                                                                                            d17.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(teamWorkFileImportInfo.P));
                                                                                                                                                            if (teamWorkFileImportInfo.P) {
                                                                                                                                                                ReportController.o(r112, "dc00898", "", "", "0X8009074", "0X8009074", 0, 0, "", "", "", "");
                                                                                                                                                            } else {
                                                                                                                                                                ReportController.o(r112, "dc00898", "", "", "0X800906C", "0X800906C", 0, 0, "", "", "", "");
                                                                                                                                                            }
                                                                                                                                                            r112.getMessageFacade().c(d17, r112.getCurrentAccountUin());
                                                                                                                                                            ((ITeamWorkFileImportHandler) r112.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER)).removeFromConvertedMap(teamWorkFileImportInfo);
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        if (teamWorkFileImportInfo.L) {
                                                                                                                                                            if (i135 == 1) {
                                                                                                                                                                HardCodeUtil.qqStr(R.string.o3r);
                                                                                                                                                            } else if (i135 == 2) {
                                                                                                                                                                HardCodeUtil.qqStr(R.string.o3w);
                                                                                                                                                            }
                                                                                                                                                            String format2 = String.format(r112.getApp().getString(R.string.hy6), "\"" + teamWorkFileImportInfo.f292074f + "\"");
                                                                                                                                                            DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
                                                                                                                                                            long K02 = com.tencent.mobileqq.service.message.e.K0();
                                                                                                                                                            String currentAccountUin2 = r112.getCurrentAccountUin();
                                                                                                                                                            String str43 = teamWorkFileImportInfo.f292072e;
                                                                                                                                                            dataLineMsgRecord.init(currentAccountUin2, str43, str43, format2, K02, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS_DL, teamWorkFileImportInfo.f292070d, K02);
                                                                                                                                                            dataLineMsgRecord.isread = true;
                                                                                                                                                            dataLineMsgRecord.saveExtInfoToExtStr(AppConstants.KEY_TEAM_WORK_EXT_INFO_NEW_URL, string73);
                                                                                                                                                            dataLineMsgRecord.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(teamWorkFileImportInfo.P));
                                                                                                                                                            r112.getDataLineMsgProxy(teamWorkFileImportInfo.E).h(dataLineMsgRecord);
                                                                                                                                                            ((ITeamWorkFileImportHandler) r112.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER)).removeFromConvertedMap(teamWorkFileImportInfo);
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_cmd_get_team_work_url")) {
                                                                                                                                                    bundle3.setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
                                                                                                                                                    TeamWorkFileImportInfo teamWorkFileImportInfo2 = (TeamWorkFileImportInfo) bundle3.get(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
                                                                                                                                                    ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) r112.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
                                                                                                                                                    if (teamWorkFileImportInfo2 != null) {
                                                                                                                                                        String urlFromConvertedMap = iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo2);
                                                                                                                                                        if (urlFromConvertedMap == null) {
                                                                                                                                                            iTeamWorkFileImportHandler.setIsNeedToast(false);
                                                                                                                                                            messengerService11.J = data;
                                                                                                                                                            r112.addObserver(messengerService11.D);
                                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                                                QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService Observer added");
                                                                                                                                                            }
                                                                                                                                                            if (teamWorkFileImportInfo2.e() || teamWorkFileImportInfo2.b() || iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo2)) {
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo2);
                                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                                                QLog.i("teamConvert", 2, "start convert time [" + (System.currentTimeMillis() / 1000) + "]");
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        Bundle bundle66 = new Bundle();
                                                                                                                                                        bundle66.putString("url", MessengerService.N(urlFromConvertedMap));
                                                                                                                                                        if (teamWorkFileImportInfo2.J == 10) {
                                                                                                                                                            bundle66.putBoolean("needRefresh", true);
                                                                                                                                                        }
                                                                                                                                                        data.putBundle(str31, bundle66);
                                                                                                                                                        messengerService11.J(data);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_cmd_get_team_work_nedd_show_toast")) {
                                                                                                                                                    bundle3.setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
                                                                                                                                                    ((ITeamWorkFileImportHandler) r112.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER)).setIsNeedToast(bundle3.getBoolean("key_team_work_file_import_info_need_toast", false));
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_cmd_convert_team_work_url_2_doc")) {
                                                                                                                                                    bundle3.setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
                                                                                                                                                    TeamWorkFileImportInfo teamWorkFileImportInfo3 = (TeamWorkFileImportInfo) bundle3.get(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO);
                                                                                                                                                    if (teamWorkFileImportInfo3 != null) {
                                                                                                                                                        u.e(teamWorkFileImportInfo3, BaseApplication.getContext(), r112, teamWorkFileImportInfo3.J);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_open_settings")) {
                                                                                                                                                    String string74 = bundle3.getString("jumpTo", r152);
                                                                                                                                                    Intent intent4 = new Intent();
                                                                                                                                                    intent4.setFlags(268435456);
                                                                                                                                                    intent4.putExtra("jumpTo", string74);
                                                                                                                                                    ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingPage(messengerService11, intent4);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_is_sys_font")) {
                                                                                                                                                    int p18 = VasShieldFont.p();
                                                                                                                                                    Bundle bundle67 = new Bundle();
                                                                                                                                                    bundle67.putInt("isSysFont", p18);
                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                        QLog.d("VasShieldFont", 2, "handleMessage: ipc getSetting=" + p18);
                                                                                                                                                    }
                                                                                                                                                    data.putBundle(str31, bundle67);
                                                                                                                                                    messengerService11.J(data);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if (string2.equals("ipc_set_sys_font")) {
                                                                                                                                                    int i136 = bundle3.getInt("sysfont", -1);
                                                                                                                                                    boolean w3 = VasShieldFont.w(i136);
                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                        QLog.d("VasShieldFont", 2, "handleMessage: ipc setSetting=" + i136 + " ret=" + w3);
                                                                                                                                                    }
                                                                                                                                                    Bundle bundle68 = new Bundle();
                                                                                                                                                    bundle68.putInt("ret", w3 ? 0 : 1);
                                                                                                                                                    data.putBundle(str31, bundle68);
                                                                                                                                                    messengerService11.J(data);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_has_sys_color_font".equals(string2)) {
                                                                                                                                                    int q16 = VasShieldFont.q();
                                                                                                                                                    Bundle bundle69 = new Bundle();
                                                                                                                                                    bundle69.putInt("hasColor", q16);
                                                                                                                                                    data.putBundle(str31, bundle69);
                                                                                                                                                    messengerService11.J(data);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_start_miniapp".equals(string2)) {
                                                                                                                                                    String string75 = bundle3.getString("miniapp_appid");
                                                                                                                                                    String string76 = bundle3.getString("miniapp_via");
                                                                                                                                                    String string77 = bundle3.getString("miniapp_path");
                                                                                                                                                    String string78 = bundle3.getString("miniapp_platform_type");
                                                                                                                                                    String string79 = bundle3.getString("miniapp_en_version");
                                                                                                                                                    String str44 = "via=" + string76;
                                                                                                                                                    if ("wechat".equals(string78)) {
                                                                                                                                                        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(BaseApplication.getContext(), string75, string77, 1005);
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(BaseApplication.getContext(), string75, string77, null, string79, str44, 1005, new f(data, messengerService11));
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_invoke_robot_function".equals(string2)) {
                                                                                                                                                    Bundle bundle70 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                                                                                    if (bundle70.getInt("isrobotbuddy") == 1) {
                                                                                                                                                        String f18 = com.tencent.mobileqq.troop.utils.k.f(bundle70.getString("troopuin"));
                                                                                                                                                        Bundle bundle71 = new Bundle();
                                                                                                                                                        bundle71.putString(str34, f18);
                                                                                                                                                        data.putBundle(str31, bundle71);
                                                                                                                                                    } else {
                                                                                                                                                        Bundle bundle72 = new Bundle();
                                                                                                                                                        bundle72.putString(str34, "1");
                                                                                                                                                        data.putBundle(str31, bundle72);
                                                                                                                                                    }
                                                                                                                                                    messengerService11.J(data);
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_share_robot_card".equals(string2)) {
                                                                                                                                                    String string80 = data.getBundle(Const.BUNDLE_KEY_REQUEST).getString("robotuin");
                                                                                                                                                    boolean l3 = com.tencent.mobileqq.troop.utils.k.l(r112, string80);
                                                                                                                                                    Bundle bundle73 = new Bundle();
                                                                                                                                                    bundle73.putInt(str34, l3 ? 1 : 0);
                                                                                                                                                    data.putBundle(str31, bundle73);
                                                                                                                                                    com.tencent.mobileqq.troop.utils.k.g(r112, string80, new com.tencent.mobileqq.troop.api.a() { // from class: com.tencent.mobileqq.emosm.web.b
                                                                                                                                                        @Override // com.tencent.mobileqq.troop.api.a
                                                                                                                                                        public final void onResult(String str45) {
                                                                                                                                                            MessengerService.IncomingHandler.d(data, messengerService11, str45);
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_robot_member_change_function".equals(string2)) {
                                                                                                                                                    Bundle bundle74 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                                                                                    com.tencent.mobileqq.troop.utils.k.m(bundle74.getString("troopuin"), bundle74.getString("robotuin"), bundle74.getString("robotname"), Boolean.valueOf(bundle74.getBoolean("isadd")).booleanValue());
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_certified_account_web_plugin_follow".equals(string2)) {
                                                                                                                                                    Bundle bundle75 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                                                                                    boolean z27 = bundle75.getBoolean("isFollow");
                                                                                                                                                    String string81 = bundle75.getString("uin");
                                                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                                                        QLog.d(str2, 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW start! isFollow: " + z27 + "  uin: " + string81);
                                                                                                                                                    }
                                                                                                                                                    IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                                                                                                                                                    iPublicAccountObserver.setOnCallback(new g(data, messengerService11, z27));
                                                                                                                                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                                                                                                                                    if (runtime instanceof QQAppInterface) {
                                                                                                                                                        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                                                                                                                                                        if (z27) {
                                                                                                                                                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(qQAppInterface, BaseApplicationImpl.getApplication(), string81, iPublicAccountObserver, false, 0, true);
                                                                                                                                                            return;
                                                                                                                                                        } else {
                                                                                                                                                            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(qQAppInterface, BaseApplicationImpl.getApplication(), string81, false, iPublicAccountObserver, true);
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_is_qq_notify_all_notify".equals(string2)) {
                                                                                                                                                    Bundle bundle76 = data.getBundle(Const.BUNDLE_KEY_REQUEST);
                                                                                                                                                    if (bundle76 == null) {
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                    String string82 = bundle76.getString("msgid");
                                                                                                                                                    String string83 = bundle76.getString("busiid");
                                                                                                                                                    QLog.i(str2, 2, "@qqnotify ipc_cmd_is_qq_notify_all_notify enter ");
                                                                                                                                                    IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) r112.getRuntimeService(IQQReminderDataService.class, r152);
                                                                                                                                                    ReportController.o(r112, "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", string83, string82);
                                                                                                                                                    iQQReminderDataService.deleteReminderByMsgId(string82, new h());
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                if ("ipc_cmd_share_to_xhs_pic".equals(string2)) {
                                                                                                                                                    c(data.getBundle(Const.BUNDLE_KEY_REQUEST));
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            } catch (Throwable th21) {
                                                                                                                                                th = th21;
                                                                                                                                                th5 = th;
                                                                                                                                                str = str2;
                                                                                                                                                if (QLog.isColorLevel()) {
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th22) {
                                                                                                                                            th = th22;
                                                                                                                                            r56 = str2;
                                                                                                                                            th5 = th;
                                                                                                                                            str = r56;
                                                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (Throwable th23) {
                                                                                                                                th = th23;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th24) {
                                                                                                                        th = th24;
                                                                                                                        th5 = th;
                                                                                                                        str = str2;
                                                                                                                        if (QLog.isColorLevel()) {
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th25) {
                                                                                                                    th = th25;
                                                                                                                    r56 = "MessengerService$IncomingHandler";
                                                                                                                    th5 = th;
                                                                                                                    str = r56;
                                                                                                                    if (QLog.isColorLevel()) {
                                                                                                                    }
                                                                                                                }
                                                                                                            } catch (Throwable th26) {
                                                                                                                th5 = th26;
                                                                                                                str = str34;
                                                                                                            }
                                                                                                        }
                                                                                                        str = "MessengerService$IncomingHandler";
                                                                                                        if (QLog.isColorLevel()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        QLog.e(str, 2, "handle msg error =" + th5.toString());
                                                                                                        return;
                                                                                                    }
                                                                                                    bundle3.putInt("srcType", 7);
                                                                                                    int i137 = "funcall_set".equals(string2) ? 1 : 5;
                                                                                                    ?? r26 = (VipSetFunCallHandler) r112.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
                                                                                                    r112.addObserver(messengerService11.E);
                                                                                                    r26.Q2(i137, bundle3, true);
                                                                                                    return;
                                                                                                }
                                                                                            }
                                                                                            messengerService11.M(string2);
                                                                                            data.putBundle(str31, new Bundle());
                                                                                            messengerService11.J(data);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (bundle3 != 0) {
                                                                        ((com.tencent.mobileqq.apollo.handler.b) r112.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).o0(bundle3.getInt("id"), data, equals.f204477f);
                                                                        incomingHandler9 = equals;
                                                                    }
                                                                }
                                                            }
                                                            th5 = th12;
                                                            str = "MessengerService$IncomingHandler";
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                        }
                                                        return;
                                                    }
                                                }
                                            } else if (bundle3 != 0) {
                                                BaseActivity baseActivity = BaseActivity.sTopActivity;
                                                IEmoticonManagerService iEmoticonManagerService2 = (IEmoticonManagerService) r112.getRuntimeService(IEmoticonManagerService.class);
                                                if ((baseActivity instanceof BaseActivity) && (chatFragment = baseActivity.getChatFragment()) != null && chatFragment.qh() != null && chatFragment.qh().f25584i != null) {
                                                    ChatXListView chatXListView = chatFragment.qh().f25584i;
                                                    ListAdapter adapter = chatXListView.getAdapter();
                                                    ArrayList<? extends Parcelable> arrayList16 = new ArrayList<>();
                                                    if (EmojiStickerManager.C >= chatXListView.getFirstVisiblePosition() && chatXListView.getFirstVisiblePosition() <= chatXListView.getLastVisiblePosition()) {
                                                        Object item = adapter.getItem(EmojiStickerManager.C);
                                                        if ((item instanceof ChatMessage) && (n3 = EmojiStickerManager.k().n((chatMessage = (ChatMessage) item))) != null && !n3.isEmpty()) {
                                                            List<MessageRecord> x06 = r112.getMessageFacade().x0(chatMessage.frienduin, chatMessage.istroop, n3);
                                                            String currentUin = r112.getCurrentUin();
                                                            try {
                                                                try {
                                                                    Iterator<MessageRecord> it7 = x06.iterator();
                                                                    String str45 = "";
                                                                    String str46 = str45;
                                                                    String str47 = str46;
                                                                    String str48 = str47;
                                                                    String str49 = str48;
                                                                    String str50 = str49;
                                                                    int i138 = 1;
                                                                    int i139 = 0;
                                                                    data = data;
                                                                    messengerService11 = messengerService11;
                                                                    while (it7.hasNext()) {
                                                                        try {
                                                                            MessageRecord next2 = it7.next();
                                                                            Iterator<MessageRecord> it8 = it7;
                                                                            Bundle bundle77 = new Bundle();
                                                                            int i140 = i138;
                                                                            if (next2 instanceof MessageForMarketFace) {
                                                                                try {
                                                                                    IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) iEmoticonManagerService2.syncGetEmoticonInfo(((MessageForMarketFace) next2).mMarkFaceMessage);
                                                                                    String str51 = iPicEmoticonInfo.getEmoticon().epId;
                                                                                    iEmoticonManagerService = iEmoticonManagerService2;
                                                                                    String str52 = iPicEmoticonInfo.getEmoticon().eId;
                                                                                    String str53 = iPicEmoticonInfo.getEmoticon().name;
                                                                                    EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) r112.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(iPicEmoticonInfo.getEmoticon().epId);
                                                                                    bundle2 = data;
                                                                                    str19 = str27;
                                                                                    str16 = str28;
                                                                                    messengerService10 = messengerService11;
                                                                                    str20 = str51;
                                                                                    str21 = str52;
                                                                                    str22 = str49;
                                                                                    str23 = str50;
                                                                                    i138 = 1;
                                                                                    i139 = (syncFindEmoticonPackageById == null || syncFindEmoticonPackageById.status != 2) ? 2 : 1;
                                                                                    str24 = str53;
                                                                                } catch (IOException e119) {
                                                                                    iOException = e119;
                                                                                    bundle2 = data;
                                                                                    arrayList3 = arrayList16;
                                                                                    str16 = str28;
                                                                                    messengerService10 = messengerService11;
                                                                                    str17 = str30;
                                                                                    QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                    Bundle bundle78 = new Bundle();
                                                                                    bundle78.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                    Bundle bundle79 = bundle2;
                                                                                    bundle79.putBundle(str16, bundle78);
                                                                                    messengerService10.J(bundle79);
                                                                                    return;
                                                                                } catch (OutOfMemoryError e120) {
                                                                                    outOfMemoryError = e120;
                                                                                    bundle2 = data;
                                                                                    arrayList3 = arrayList16;
                                                                                    str16 = str28;
                                                                                    messengerService10 = messengerService11;
                                                                                    str18 = str30;
                                                                                    QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                    Bundle bundle782 = new Bundle();
                                                                                    bundle782.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                    Bundle bundle792 = bundle2;
                                                                                    bundle792.putBundle(str16, bundle782);
                                                                                    messengerService10.J(bundle792);
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                iEmoticonManagerService = iEmoticonManagerService2;
                                                                                if (next2 instanceof MessageForText) {
                                                                                    try {
                                                                                        MessageForText messageForText = (MessageForText) next2;
                                                                                        if (TextUtils.isEmpty(messageForText.f203106msg)) {
                                                                                            bundle2 = data;
                                                                                            str16 = str28;
                                                                                            messengerService10 = messengerService11;
                                                                                            i46 = i139;
                                                                                        } else {
                                                                                            Parcelable v3 = EmojiStickerManager.k().v(messageForText.f203106msg);
                                                                                            if (v3 instanceof SystemAndEmojiEmoticonInfo) {
                                                                                                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) v3;
                                                                                                int i141 = systemAndEmojiEmoticonInfo.emotionType;
                                                                                                i46 = i139;
                                                                                                if (i141 == 1) {
                                                                                                    int i142 = systemAndEmojiEmoticonInfo.code;
                                                                                                    bundle77.putInt("type", 3);
                                                                                                    String[] strArr2 = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                                                                                                    if (i142 < strArr2.length) {
                                                                                                        String str54 = strArr2[i142];
                                                                                                        str25 = str54.substring(str54.indexOf("/") + 1);
                                                                                                    } else {
                                                                                                        str25 = str27;
                                                                                                    }
                                                                                                    int[] iArr = EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE;
                                                                                                    str47 = str25;
                                                                                                    i48 = i142 < iArr.length ? iArr[i142] : -1;
                                                                                                    str49 = Uri.parse("android.resource://com.tencent.mobileqq/" + i48).toString();
                                                                                                    messengerService10 = messengerService11;
                                                                                                    i49 = -1;
                                                                                                    i47 = 3;
                                                                                                } else {
                                                                                                    if (i141 == 2) {
                                                                                                        try {
                                                                                                            bundle77.putInt("type", 4);
                                                                                                            i56 = systemAndEmojiEmoticonInfo.code;
                                                                                                            i57 = EmotcationConstants.FIRST_EMOJI_RES + i56;
                                                                                                            strArr = EmotcationConstants.EMOJI_CONTENT_DESC;
                                                                                                            messengerService10 = messengerService11;
                                                                                                        } catch (IOException e121) {
                                                                                                            e = e121;
                                                                                                            messengerService10 = messengerService11;
                                                                                                        } catch (OutOfMemoryError e122) {
                                                                                                            e = e122;
                                                                                                            messengerService10 = messengerService11;
                                                                                                        }
                                                                                                        try {
                                                                                                            String str55 = i56 < strArr.length ? strArr[i56] : str27;
                                                                                                            i47 = 4;
                                                                                                            str47 = str55;
                                                                                                            i48 = i57;
                                                                                                            str49 = Uri.parse("android.resource://com.tencent.mobileqq/" + i57).toString();
                                                                                                        } catch (IOException e123) {
                                                                                                            e = e123;
                                                                                                            iOException = e;
                                                                                                            bundle2 = data;
                                                                                                            arrayList3 = arrayList16;
                                                                                                            str16 = str28;
                                                                                                            str17 = str30;
                                                                                                            QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                                            Bundle bundle7822 = new Bundle();
                                                                                                            bundle7822.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                            Bundle bundle7922 = bundle2;
                                                                                                            bundle7922.putBundle(str16, bundle7822);
                                                                                                            messengerService10.J(bundle7922);
                                                                                                            return;
                                                                                                        } catch (OutOfMemoryError e124) {
                                                                                                            e = e124;
                                                                                                            outOfMemoryError = e;
                                                                                                            bundle2 = data;
                                                                                                            arrayList3 = arrayList16;
                                                                                                            str16 = str28;
                                                                                                            str18 = str30;
                                                                                                            QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                                            Bundle bundle78222 = new Bundle();
                                                                                                            bundle78222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                            Bundle bundle79222 = bundle2;
                                                                                                            bundle79222.putBundle(str16, bundle78222);
                                                                                                            messengerService10.J(bundle79222);
                                                                                                            return;
                                                                                                        }
                                                                                                    } else {
                                                                                                        messengerService10 = messengerService11;
                                                                                                        str47 = str27;
                                                                                                        str49 = str47;
                                                                                                        i47 = i140;
                                                                                                        i48 = -1;
                                                                                                    }
                                                                                                    i49 = -1;
                                                                                                }
                                                                                                if (i48 != i49) {
                                                                                                    try {
                                                                                                        inputStream = r112.getApp().getResources().openRawResource(i48);
                                                                                                    } catch (Exception e125) {
                                                                                                        bundle2 = data;
                                                                                                        str16 = str28;
                                                                                                        i140 = i47;
                                                                                                        exc4 = e125;
                                                                                                        inputStream = null;
                                                                                                    } catch (Throwable th27) {
                                                                                                        th6 = th27;
                                                                                                        inputStream = null;
                                                                                                    }
                                                                                                    try {
                                                                                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                                                                                        i140 = i47;
                                                                                                        try {
                                                                                                            byte[] bArr = new byte[10240];
                                                                                                            Bundle bundle80 = data;
                                                                                                            while (true) {
                                                                                                                bundle2 = bundle80;
                                                                                                                str16 = str28;
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        int read = inputStream.read(bArr, 0, 10240);
                                                                                                                        if (read <= 0) {
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        byteArrayOutputStream.write(bArr, 0, read);
                                                                                                                        bundle80 = bundle2;
                                                                                                                        str28 = str16;
                                                                                                                    } catch (Exception e126) {
                                                                                                                        e = e126;
                                                                                                                        exc4 = e;
                                                                                                                        QLog.e(str30, 1, exc4, new Object[0]);
                                                                                                                        if (inputStream != null) {
                                                                                                                            inputStream.close();
                                                                                                                        }
                                                                                                                        if (byteArrayOutputStream != null) {
                                                                                                                            byteArrayOutputStream.close();
                                                                                                                        }
                                                                                                                        str21 = str45;
                                                                                                                        str24 = str47;
                                                                                                                        str20 = str48;
                                                                                                                        str22 = str49;
                                                                                                                        i138 = i140;
                                                                                                                        i139 = i46;
                                                                                                                        str19 = str27;
                                                                                                                        str23 = str50;
                                                                                                                        if (com.tencent.biz.anonymous.a.m(next2)) {
                                                                                                                        }
                                                                                                                        String str56 = str46;
                                                                                                                        bundle77.putString(str29, str20);
                                                                                                                        bundle77.putString("subid", str21);
                                                                                                                        String str57 = currentUin;
                                                                                                                        String str58 = str29;
                                                                                                                        bundle77.putLong("time", next2.time * 1000);
                                                                                                                        bundle77.putString("name", str24);
                                                                                                                        bundle77.putInt("status", i139);
                                                                                                                        bundle77.putInt("type", i138);
                                                                                                                        bundle77.putString("nickName", str56);
                                                                                                                        bundle77.putInt("isSelf", next2.isSend() ? 1 : 0);
                                                                                                                        String str59 = str21;
                                                                                                                        bundle77.putString("hash", String.valueOf(next2.uniseq));
                                                                                                                        bundle77.putString("base64", str23);
                                                                                                                        bundle77.putString("url", str22);
                                                                                                                        arrayList3 = arrayList4;
                                                                                                                        try {
                                                                                                                            arrayList3.add(bundle77);
                                                                                                                            str50 = str23;
                                                                                                                            str48 = str20;
                                                                                                                            str49 = str22;
                                                                                                                            currentUin = str57;
                                                                                                                            str30 = str18;
                                                                                                                            it7 = it8;
                                                                                                                            str27 = str19;
                                                                                                                            messengerService11 = messengerService10;
                                                                                                                            str28 = str16;
                                                                                                                            str47 = str24;
                                                                                                                            str45 = str59;
                                                                                                                            str29 = str58;
                                                                                                                            iEmoticonManagerService2 = iEmoticonManagerService;
                                                                                                                            str46 = str56;
                                                                                                                            arrayList16 = arrayList3;
                                                                                                                            data = bundle2;
                                                                                                                        } catch (IOException e127) {
                                                                                                                            e = e127;
                                                                                                                            iOException = e;
                                                                                                                            str17 = str18;
                                                                                                                            QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                                                            Bundle bundle782222 = new Bundle();
                                                                                                                            bundle782222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                                            Bundle bundle792222 = bundle2;
                                                                                                                            bundle792222.putBundle(str16, bundle782222);
                                                                                                                            messengerService10.J(bundle792222);
                                                                                                                            return;
                                                                                                                        } catch (OutOfMemoryError e128) {
                                                                                                                            e = e128;
                                                                                                                            outOfMemoryError = e;
                                                                                                                            QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                                                            Bundle bundle7822222 = new Bundle();
                                                                                                                            bundle7822222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                                            Bundle bundle7922222 = bundle2;
                                                                                                                            bundle7922222.putBundle(str16, bundle7822222);
                                                                                                                            messengerService10.J(bundle7922222);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th28) {
                                                                                                                    th = th28;
                                                                                                                    th6 = th;
                                                                                                                    if (inputStream != null) {
                                                                                                                        inputStream.close();
                                                                                                                    }
                                                                                                                    if (byteArrayOutputStream == null) {
                                                                                                                        byteArrayOutputStream.close();
                                                                                                                        throw th6;
                                                                                                                    }
                                                                                                                    throw th6;
                                                                                                                }
                                                                                                            }
                                                                                                            str50 = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                                                                                                            try {
                                                                                                                inputStream.close();
                                                                                                            } catch (IOException e129) {
                                                                                                                e = e129;
                                                                                                                iOException = e;
                                                                                                                arrayList3 = arrayList16;
                                                                                                                str17 = str30;
                                                                                                                QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                                                Bundle bundle78222222 = new Bundle();
                                                                                                                bundle78222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                                Bundle bundle79222222 = bundle2;
                                                                                                                bundle79222222.putBundle(str16, bundle78222222);
                                                                                                                messengerService10.J(bundle79222222);
                                                                                                                return;
                                                                                                            } catch (OutOfMemoryError e130) {
                                                                                                                e = e130;
                                                                                                                outOfMemoryError = e;
                                                                                                                arrayList3 = arrayList16;
                                                                                                                str18 = str30;
                                                                                                                QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                                                Bundle bundle782222222 = new Bundle();
                                                                                                                bundle782222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                                                Bundle bundle792222222 = bundle2;
                                                                                                                bundle792222222.putBundle(str16, bundle782222222);
                                                                                                                messengerService10.J(bundle792222222);
                                                                                                                return;
                                                                                                            }
                                                                                                        } catch (Exception e131) {
                                                                                                            e = e131;
                                                                                                            bundle2 = data;
                                                                                                            str16 = str28;
                                                                                                        } catch (Throwable th29) {
                                                                                                            th = th29;
                                                                                                        }
                                                                                                    } catch (Exception e132) {
                                                                                                        bundle2 = data;
                                                                                                        str16 = str28;
                                                                                                        i140 = i47;
                                                                                                        exc4 = e132;
                                                                                                        byteArrayOutputStream = null;
                                                                                                        QLog.e(str30, 1, exc4, new Object[0]);
                                                                                                        if (inputStream != null) {
                                                                                                        }
                                                                                                        if (byteArrayOutputStream != null) {
                                                                                                        }
                                                                                                        str21 = str45;
                                                                                                        str24 = str47;
                                                                                                        str20 = str48;
                                                                                                        str22 = str49;
                                                                                                        i138 = i140;
                                                                                                        i139 = i46;
                                                                                                        str19 = str27;
                                                                                                        str23 = str50;
                                                                                                        if (com.tencent.biz.anonymous.a.m(next2)) {
                                                                                                        }
                                                                                                        String str562 = str46;
                                                                                                        bundle77.putString(str29, str20);
                                                                                                        bundle77.putString("subid", str21);
                                                                                                        String str572 = currentUin;
                                                                                                        String str582 = str29;
                                                                                                        bundle77.putLong("time", next2.time * 1000);
                                                                                                        bundle77.putString("name", str24);
                                                                                                        bundle77.putInt("status", i139);
                                                                                                        bundle77.putInt("type", i138);
                                                                                                        bundle77.putString("nickName", str562);
                                                                                                        bundle77.putInt("isSelf", next2.isSend() ? 1 : 0);
                                                                                                        String str592 = str21;
                                                                                                        bundle77.putString("hash", String.valueOf(next2.uniseq));
                                                                                                        bundle77.putString("base64", str23);
                                                                                                        bundle77.putString("url", str22);
                                                                                                        arrayList3 = arrayList4;
                                                                                                        arrayList3.add(bundle77);
                                                                                                        str50 = str23;
                                                                                                        str48 = str20;
                                                                                                        str49 = str22;
                                                                                                        currentUin = str572;
                                                                                                        str30 = str18;
                                                                                                        it7 = it8;
                                                                                                        str27 = str19;
                                                                                                        messengerService11 = messengerService10;
                                                                                                        str28 = str16;
                                                                                                        str47 = str24;
                                                                                                        str45 = str592;
                                                                                                        str29 = str582;
                                                                                                        iEmoticonManagerService2 = iEmoticonManagerService;
                                                                                                        str46 = str562;
                                                                                                        arrayList16 = arrayList3;
                                                                                                        data = bundle2;
                                                                                                    } catch (Throwable th30) {
                                                                                                        th6 = th30;
                                                                                                        byteArrayOutputStream = null;
                                                                                                        if (inputStream != null) {
                                                                                                        }
                                                                                                        if (byteArrayOutputStream == null) {
                                                                                                        }
                                                                                                    }
                                                                                                    byteArrayOutputStream.close();
                                                                                                } else {
                                                                                                    bundle2 = data;
                                                                                                    str16 = str28;
                                                                                                    i140 = i47;
                                                                                                }
                                                                                            } else {
                                                                                                bundle2 = data;
                                                                                                str16 = str28;
                                                                                                messengerService10 = messengerService11;
                                                                                                i46 = i139;
                                                                                                if (v3 instanceof ISmallEmoticonInfo) {
                                                                                                    IEmoticonManagerService iEmoticonManagerService3 = (IEmoticonManagerService) r112.getRuntimeService(IEmoticonManagerService.class);
                                                                                                    Emoticon syncFindEmoticonById = iEmoticonManagerService3.syncFindEmoticonById(((ISmallEmoticonInfo) v3).getEmoticon().epId, ((ISmallEmoticonInfo) v3).getEmoticon().eId);
                                                                                                    if (syncFindEmoticonById != null) {
                                                                                                        String str60 = syncFindEmoticonById.epId;
                                                                                                        String str61 = syncFindEmoticonById.eId;
                                                                                                        String str62 = syncFindEmoticonById.name;
                                                                                                        EmoticonPackage syncFindEmoticonPackageById2 = iEmoticonManagerService3.syncFindEmoticonPackageById(str60);
                                                                                                        i46 = (syncFindEmoticonPackageById2 == null || syncFindEmoticonPackageById2.status != 2) ? 2 : 1;
                                                                                                        str48 = str60;
                                                                                                        str47 = str62;
                                                                                                        str45 = str61;
                                                                                                        i140 = 2;
                                                                                                    } else {
                                                                                                        String str63 = ((ISmallEmoticonInfo) v3).getEmoticon().epId;
                                                                                                        String str64 = ((ISmallEmoticonInfo) v3).getEmoticon().eId;
                                                                                                        String qqStr = HardCodeUtil.qqStr(R.string.o3p);
                                                                                                        try {
                                                                                                            String str65 = new String(HexUtil.hexStr2Bytes(next2.getExtInfoFromExtStr("small_description")), "UTF-8");
                                                                                                            if (!TextUtils.isEmpty(str65)) {
                                                                                                                qqStr = str65.replace("[", str27).replace("]", str27);
                                                                                                            }
                                                                                                            str47 = qqStr;
                                                                                                            if (QLog.isColorLevel()) {
                                                                                                                QLog.e(str30, 1, "IPC_STICKER_CMD_QUERY_DETAILS, SmallEmoticonInfo emoticon == null");
                                                                                                            }
                                                                                                            str48 = str63;
                                                                                                            str45 = str64;
                                                                                                            i140 = 2;
                                                                                                            i46 = 2;
                                                                                                        } catch (UnsupportedEncodingException unused2) {
                                                                                                            throw new RuntimeException("UTF-8 not supported?");
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } catch (IOException e133) {
                                                                                        e = e133;
                                                                                        bundle2 = data;
                                                                                        str16 = str28;
                                                                                        messengerService10 = messengerService11;
                                                                                    } catch (OutOfMemoryError e134) {
                                                                                        e = e134;
                                                                                        bundle2 = data;
                                                                                        str16 = str28;
                                                                                        messengerService10 = messengerService11;
                                                                                    }
                                                                                } else {
                                                                                    bundle2 = data;
                                                                                    str16 = str28;
                                                                                    messengerService10 = messengerService11;
                                                                                    i46 = i139;
                                                                                    if (next2 instanceof MessageForPic) {
                                                                                        MessageForPic messageForPic2 = (MessageForPic) next2;
                                                                                        String url = URLDrawableHelper.getURL((MessageForPic) next2, 1, null).toString();
                                                                                        String qqStr2 = HardCodeUtil.qqStr(R.string.o46);
                                                                                        File file = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic) next2, 65537, null).toString());
                                                                                        File file2 = AbsDownloader.getFile(url);
                                                                                        if (file != null && file.exists()) {
                                                                                            str49 = (file2 == null || !file2.exists()) ? file.getAbsolutePath() : file2.getAbsolutePath();
                                                                                            str50 = PluginBaseInfoHelper.Base64Helper.encodeToString(FileUtils.getByte(file), 2);
                                                                                            if (EmojiStickerManager.j(r112, messageForPic2.path) != null) {
                                                                                                str19 = str27;
                                                                                                str21 = str45;
                                                                                                str24 = qqStr2;
                                                                                                str20 = str48;
                                                                                                str22 = str49;
                                                                                                str23 = str50;
                                                                                                i138 = 5;
                                                                                                i139 = 2;
                                                                                            } else {
                                                                                                File file3 = AbsDownloader.getFile(url);
                                                                                                String fileMd5 = file3 != null ? SecUtil.getFileMd5(file3.getAbsolutePath()) : null;
                                                                                                if (!TextUtils.isEmpty(fileMd5)) {
                                                                                                    String currentAccountUin3 = r112.getCurrentAccountUin();
                                                                                                    PicMessageExtraData picMessageExtraData = messageForPic2.picExtraData;
                                                                                                    if (picMessageExtraData != null && picMessageExtraData.isDiyDouTu()) {
                                                                                                        StringBuilder sb12 = new StringBuilder();
                                                                                                        sb12.append("_diydoutu@");
                                                                                                        sb12.append(TextUtils.isEmpty(messageForPic2.picExtraData.emojiId) ? "0" : messageForPic2.picExtraData.emojiId);
                                                                                                        str26 = sb12.toString();
                                                                                                    } else {
                                                                                                        str26 = str27;
                                                                                                    }
                                                                                                    String str66 = AppConstants.SDCARD_IMG_FAVORITE + DiySecureFileHelper.secureUin(currentAccountUin3) + fileMd5 + str26 + ".jpg";
                                                                                                    String bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(MD5.getFileMd5(str66));
                                                                                                    List<CustomEmotionData> emoticonDataList2 = ((IFavroamingDBManagerService) r112.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
                                                                                                    if (emoticonDataList2 != null) {
                                                                                                        for (int i143 = 0; i143 < emoticonDataList2.size(); i143++) {
                                                                                                            if (str66 != null && str66.equals(emoticonDataList2.get(i143).emoPath)) {
                                                                                                                i46 = 2;
                                                                                                            }
                                                                                                            if (bytes2HexStr != null && emoticonDataList2.get(i143).md5 != null && bytes2HexStr.equals(emoticonDataList2.get(i143).md5) && !"needDel".equals(emoticonDataList2.get(i143).RomaingType)) {
                                                                                                                i46 = 2;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        str21 = str45;
                                                                                        str24 = qqStr2;
                                                                                        str20 = str48;
                                                                                        str22 = str49;
                                                                                        i139 = i46;
                                                                                        i138 = 5;
                                                                                        str19 = str27;
                                                                                        str23 = str50;
                                                                                    }
                                                                                }
                                                                                str21 = str45;
                                                                                str24 = str47;
                                                                                str20 = str48;
                                                                                str22 = str49;
                                                                                i138 = i140;
                                                                                i139 = i46;
                                                                                str19 = str27;
                                                                                str23 = str50;
                                                                            }
                                                                            try {
                                                                                if (com.tencent.biz.anonymous.a.m(next2)) {
                                                                                    str18 = str30;
                                                                                    try {
                                                                                        StringBuilder sb13 = new StringBuilder();
                                                                                        arrayList4 = arrayList16;
                                                                                        try {
                                                                                            sb13.append(HardCodeUtil.qqStr(R.string.o3q));
                                                                                            sb13.append(com.tencent.biz.anonymous.a.e(next2).f78367c);
                                                                                            str46 = sb13.toString();
                                                                                        } catch (IOException e135) {
                                                                                            iOException = e135;
                                                                                            str17 = str18;
                                                                                            arrayList3 = arrayList4;
                                                                                            QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                            Bundle bundle7822222222 = new Bundle();
                                                                                            bundle7822222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                            Bundle bundle7922222222 = bundle2;
                                                                                            bundle7922222222.putBundle(str16, bundle7822222222);
                                                                                            messengerService10.J(bundle7922222222);
                                                                                            return;
                                                                                        } catch (OutOfMemoryError e136) {
                                                                                            outOfMemoryError = e136;
                                                                                            arrayList3 = arrayList4;
                                                                                            QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                            Bundle bundle78222222222 = new Bundle();
                                                                                            bundle78222222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                            Bundle bundle79222222222 = bundle2;
                                                                                            bundle79222222222.putBundle(str16, bundle78222222222);
                                                                                            messengerService10.J(bundle79222222222);
                                                                                            return;
                                                                                        }
                                                                                    } catch (IOException e137) {
                                                                                        iOException = e137;
                                                                                        arrayList3 = arrayList16;
                                                                                        str17 = str18;
                                                                                        QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                        Bundle bundle782222222222 = new Bundle();
                                                                                        bundle782222222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                        Bundle bundle792222222222 = bundle2;
                                                                                        bundle792222222222.putBundle(str16, bundle782222222222);
                                                                                        messengerService10.J(bundle792222222222);
                                                                                        return;
                                                                                    } catch (OutOfMemoryError e138) {
                                                                                        outOfMemoryError = e138;
                                                                                        arrayList3 = arrayList16;
                                                                                    }
                                                                                } else {
                                                                                    arrayList4 = arrayList16;
                                                                                    str18 = str30;
                                                                                    if (currentUin.equals(next2.senderuin)) {
                                                                                        str46 = r112.getCurrentNickname();
                                                                                    } else {
                                                                                        int i144 = next2.istroop;
                                                                                        if (i144 != 1) {
                                                                                            if (i144 == 3000) {
                                                                                                str46 = ac.n(r112, next2.frienduin, next2.senderuin);
                                                                                            } else {
                                                                                                str46 = ac.y(r112, next2.senderuin);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                String str5622 = str46;
                                                                                try {
                                                                                    bundle77.putString(str29, str20);
                                                                                    bundle77.putString("subid", str21);
                                                                                    String str5722 = currentUin;
                                                                                    String str5822 = str29;
                                                                                    bundle77.putLong("time", next2.time * 1000);
                                                                                    bundle77.putString("name", str24);
                                                                                    bundle77.putInt("status", i139);
                                                                                    bundle77.putInt("type", i138);
                                                                                    bundle77.putString("nickName", str5622);
                                                                                    bundle77.putInt("isSelf", next2.isSend() ? 1 : 0);
                                                                                    String str5922 = str21;
                                                                                    bundle77.putString("hash", String.valueOf(next2.uniseq));
                                                                                    bundle77.putString("base64", str23);
                                                                                    bundle77.putString("url", str22);
                                                                                    arrayList3 = arrayList4;
                                                                                    arrayList3.add(bundle77);
                                                                                    str50 = str23;
                                                                                    str48 = str20;
                                                                                    str49 = str22;
                                                                                    currentUin = str5722;
                                                                                    str30 = str18;
                                                                                    it7 = it8;
                                                                                    str27 = str19;
                                                                                    messengerService11 = messengerService10;
                                                                                    str28 = str16;
                                                                                    str47 = str24;
                                                                                    str45 = str5922;
                                                                                    str29 = str5822;
                                                                                    iEmoticonManagerService2 = iEmoticonManagerService;
                                                                                    str46 = str5622;
                                                                                    arrayList16 = arrayList3;
                                                                                    data = bundle2;
                                                                                } catch (IOException e139) {
                                                                                    e = e139;
                                                                                    arrayList3 = arrayList4;
                                                                                } catch (OutOfMemoryError e140) {
                                                                                    e = e140;
                                                                                    arrayList3 = arrayList4;
                                                                                }
                                                                            } catch (IOException e141) {
                                                                                e = e141;
                                                                                arrayList3 = arrayList16;
                                                                                iOException = e;
                                                                                str17 = str30;
                                                                                QLog.e(str17, 1, "IPC_STICKER_CMD_QUERY_DETAILS exception = " + iOException);
                                                                                Bundle bundle7822222222222 = new Bundle();
                                                                                bundle7822222222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                Bundle bundle7922222222222 = bundle2;
                                                                                bundle7922222222222.putBundle(str16, bundle7822222222222);
                                                                                messengerService10.J(bundle7922222222222);
                                                                                return;
                                                                            } catch (OutOfMemoryError e142) {
                                                                                e = e142;
                                                                                arrayList3 = arrayList16;
                                                                                str18 = str30;
                                                                                outOfMemoryError = e;
                                                                                QLog.e(str18, 1, "IPC_STICKER_CMD_QUERY_DETAILS OOM = " + outOfMemoryError);
                                                                                Bundle bundle78222222222222 = new Bundle();
                                                                                bundle78222222222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                                                Bundle bundle79222222222222 = bundle2;
                                                                                bundle79222222222222.putBundle(str16, bundle78222222222222);
                                                                                messengerService10.J(bundle79222222222222);
                                                                                return;
                                                                            }
                                                                        } catch (IOException e143) {
                                                                            e = e143;
                                                                            bundle2 = data;
                                                                            arrayList3 = arrayList16;
                                                                            str16 = str28;
                                                                            messengerService10 = messengerService11;
                                                                        }
                                                                    }
                                                                } catch (OutOfMemoryError e144) {
                                                                    e = e144;
                                                                    bundle2 = data;
                                                                    arrayList3 = arrayList16;
                                                                    str16 = str28;
                                                                    messengerService10 = messengerService11;
                                                                }
                                                            } catch (IOException e145) {
                                                                bundle2 = data;
                                                                arrayList3 = arrayList16;
                                                                str16 = "response";
                                                                messengerService10 = messengerService11;
                                                                str17 = "MessengerService";
                                                                iOException = e145;
                                                            }
                                                        }
                                                    }
                                                    bundle2 = data;
                                                    arrayList3 = arrayList16;
                                                    str16 = str28;
                                                    messengerService10 = messengerService11;
                                                    Bundle bundle782222222222222 = new Bundle();
                                                    bundle782222222222222.putParcelableArrayList("stickerInfos", arrayList3);
                                                    Bundle bundle792222222222222 = bundle2;
                                                    bundle792222222222222.putBundle(str16, bundle782222222222222);
                                                    messengerService10.J(bundle792222222222222);
                                                }
                                            }
                                            return;
                                        }
                                    }
                                } catch (Exception e146) {
                                    QLog.e("Q.emoji.web.MessengerService", 1, "bundle exception e = " + e146.getMessage());
                                    return;
                                }
                            }
                        }
                        return;
                        th = th9;
                        th5 = th;
                        str = r56;
                        if (QLog.isColorLevel()) {
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, service.app null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MessengerService$IncomingHandler", 2, "handleMessage, service null");
            }
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class c implements URLDrawable.URLDrawableListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f204499d;

            c(String str) {
                this.f204499d = str;
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
                if (QLog.isColorLevel()) {
                    QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url onLoadCanceled:" + this.f204499d);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url failed:" + this.f204499d);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                if (QLog.isColorLevel()) {
                    QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url down:" + this.f204499d);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            }
        }
    }
}

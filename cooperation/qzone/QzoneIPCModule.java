package cooperation.qzone;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.c;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.chat.h;
import com.tencent.mobileqq.config.business.NotificationBannerConfProcessor;
import com.tencent.mobileqq.config.business.ae;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.earlydownload.handler.m;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.pic.g;
import com.tencent.mobileqq.qcircle.api.requests.QCircleDoFollowRequest;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneEventApi;
import com.tencent.qzonehub.api.IQzoneMixApi;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.feed.CertifiedFakeFeed;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes28.dex */
public class QzoneIPCModule extends QIPCModule {
    public static final String ACTION_CLOSE_PUSH_SETTING_BANNER = "action_qzone_close_push_setting_banner";
    public static final String ACTION_EXTEND_FORBIDDEN = "action_extend_forbidden";
    public static final String ACTION_EXTEND_REPORT = "action_extend_report";
    public static final String ACTION_GET_THEMEID = "action_qzone_get_themeid";
    public static final String ACTION_IS_FLUTTER_EXTEND = "action_is_flutter_extend";
    public static final String ACTION_MINIGAME_GET_TIANSHU_APPINFO = "action_qzone_main_process_get_tianshu_appInfo";
    public static final String ACTION_MINIGAME_RED_DOT_CLICK = "action_qzone_game_tianshu_reddot_click";
    public static final String ACTION_MINIGAME_RED_DOT_EXPOSE = "action_qzone_game_tianshu_reddot_expose";
    public static final String ACTION_PRE_PULL_MINI_APP = "action_pre_pull_mini_app";
    public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE";
    public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE";
    public static final String ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE";
    public static final String ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH";
    public static final String ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST";
    public static final String ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED";
    public static final String ACTION_PUBLIC_ACCOUNT_UNFOLLOW = "cooperation.qzone.ACTION_PUBLIC_ACCOUNT_UNFOLLOW";
    public static final String ACTION_QCIRCLE_FAKE_FEED_DELETE = "cooperation.qzone.ACTION_QCIRCLE_FAKE_FEED_DELETE";
    public static final String ACTION_QCIRCLE_GET_TASK_LIST = "cooperation.qzone.ACTION_QCIRCLE_GET_TASK_LIST";
    public static final String ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_COMPLETE_REPORT";
    public static final String ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_FAKE_FEED_COMPOSITE_SUCCESS";
    public static final String ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO";
    public static final String ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_GET_RECOMMEND_TAG";
    public static final String ACTION_QCIRCLE_PUBLISH_REPORT = "cooperation.qzone.ACTION_QCIRCLE_PUBLISH_REPORT";
    public static final String ACTION_QCIRCLE_PULISH_FEED = "cooperation.qzone.ACTION_QCIRCLE_PULISH_FEED";
    public static final String ACTION_QCIRCLE_QUEUE_CHANGED = "cooperation.qzone.ACTION_QCIRCLE_QUEUE_CHANGED";
    public static final String ACTION_QQCIRCLE_FAKE_FEED_CREATE = "cooperation.qzone.ACTION_QQCIRCLE_FAKE_FEED_CREATE";
    public static final String ACTION_QZONE_FLOW_QQ_CIRCLE = "action_qzone_follow_qq_circle";
    public static final String ACTION_QZONE_MAIN_PROCESS_PROP_GET = "action_qzone_main_process_prop_get";
    public static final String ACTION_QZONE_MAIN_PROCESS_PROP_SET = "action_qzone_main_process_prop_set";
    public static final String ACTION_QZONE_PIC_PRE_SEND = "action_qzone_pic_pre_send";
    public static final String ACTION_QZONE_PRELOAD_CM_DATA = "action_qzone_preload_cm_data";
    public static final String ACTION_QZONE_SEND_EVENT = "action_qzone_send_event";
    public static final String ACTION_REGISTER_RED_DOT_OBSERVER = "action_qzone_main_process_register_red_dot_observer";
    public static final String ACTION_SAVE_CUSTOMEMOTION = "action_save_customenotion";
    public static final String ACTION_SHOW_PUSH_SETTING_BANNER = "action_qzone_show_push_setting_banner";
    public static final String ACTION_START_DOWNLOAD_VOICECHANGE_SO = "startDownloadVoicechangeSo";
    public static final String ACTION_UNREGISTER_RED_DOT_OBSERVER = "action_qzone_main_process_unregister_red_dot_observer";
    public static final String BUNDLE_KEY_FEED_BYTE_ARRAY = "bundle_key_feed_byte_array";
    public static final String EXPAND_KEY_FORBIDDEN_INFO = "expand_forbidden_info";
    public static final String MINIAPP_PRELOAD_ENTRY_PATH = "miniapp_preload_entry_path";
    public static final String MINIAPP_PRELOAD_ID = "miniapp_preload_id";
    public static final String MINIAPP_PRELOAD_LINK = "miniapp_preload_link";
    public static final String MINIAPP_PRELOAD_LINK_TYPE = "miniapp_preload_link_type";
    public static final String MINIAPP_PRELOAD_WITH_PACKAGE_AND_CACHE_PRELOAD = "miniapp_repload_with_package_and_cache_preload";
    public static final String NAME = "QzoneIPCModule";
    public static final String NAME_CLIENT_PUBACCOUNT = "PubAccountIPCModule";
    public static final String NAME_CLIENT_QQCIRCLE = "QQCirCleClientIPCModule";
    public static final String PIC_PATH = "pic_path";
    public static final String PREFS_NAME_QZ_MAIN_SETTING = "QZ_main_setting";
    public static final String RESULT_CODE = "resultCode";
    public static final String TAG = "QzoneIPCModule";
    public static final String TAG_QCIRCLE = "[QzoneIPCModule_upload2]QCircle";
    private static final IStickerRecManager.ImgUpdateListener qzoneImgUpdateListener = new IStickerRecManager.ImgUpdateListener() { // from class: cooperation.qzone.QzoneIPCModule.5
        @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener
        public void onImgUpdated(List<IStickerRecEmoticon> list, String str, String str2, int i3, String str3) {
            Object valueOf;
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("OnImgUpdated: empty data or text ");
                sb5.append(str);
                sb5.append(" ");
                if (list == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(list.size());
                }
                sb5.append(valueOf);
                QLog.i("QzoneIPCModule", 2, sb5.toString());
                return;
            }
            JSONObject parseSticker2Json = QzoneIPCModule.parseSticker2Json(list);
            if (parseSticker2Json == null) {
                QLog.i("QzoneIPCModule", 2, "OnImgUpdated: failed to parse img data");
            } else {
                QzoneIPCModule.getInstance().onGetStickerRecResp(str, parseSticker2Json.toString(), str2);
            }
        }
    };
    private static QzoneIPCModule sInstance;
    private final RedpointObserver redDotObserver;
    private final AtomicReference<StickerRecReq> stickerRecReq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static class StickerRecReq {
        private volatile String data;
        private final CountDownLatch latch = new CountDownLatch(1);
        private volatile String pass;
        private final String text;

        StickerRecReq(String str) {
            this.text = str;
        }
    }

    public QzoneIPCModule(String str) {
        super(str);
        this.stickerRecReq = new AtomicReference<>();
        this.redDotObserver = new RedpointObserver() { // from class: cooperation.qzone.QzoneIPCModule.1
            @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
            public void onDataChange(boolean z16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    Bundle miniGameTianShuAppInfo = QzoneIPCModule.this.getMiniGameTianShuAppInfo((AppInterface) peekAppRuntime);
                    if (miniGameTianShuAppInfo == null) {
                        QLog.w("QzoneIPCModule", 2, "redDotObserver onDataChange bundle is null");
                    } else {
                        ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).broadcastBannerGameRedDot(peekAppRuntime.getApp().getApplicationContext(), miniGameTianShuAppInfo);
                    }
                }
            }
        };
    }

    public static QzoneIPCModule getInstance() {
        if (sInstance == null) {
            synchronized (QzoneIPCModule.class) {
                if (sInstance == null) {
                    sInstance = new QzoneIPCModule("QzoneIPCModule");
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Bundle getMiniGameTianShuAppInfo(AppInterface appInterface) {
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager == null) {
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(2, "140112");
        if (appInfo == null) {
            QLog.e("QzoneIPCModule", 1, "updateGameEntranceRedTouch appInfo null");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", appInfo.toByteArray());
        return bundle;
    }

    private static List<StickerRecData> parseJson2Sticker(String str, String str2, int i3) {
        JSONObject jSONObject;
        String str3;
        LinkedList linkedList = new LinkedList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            QLog.w("QzoneIPCModule", 2, "parseJson2Sticker: failed to parse json", e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return linkedList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            for (int i16 = 0; i16 < optJSONArray.length() && i16 <= i3; i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                String optString = optJSONObject.optString("url");
                String optString2 = optJSONObject.optString("md5");
                StickerRecData stickerRecData = new StickerRecData();
                stickerRecData.setImgUrl(optString);
                stickerRecData.setImgMd5(optString2);
                if (str2 != null && str2.equals(optString)) {
                    stickerRecData.setClicked(true);
                    str2 = null;
                }
                linkedList.add(stickerRecData);
            }
            return linkedList;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("parseJson2Sticker: empty data ");
        if (optJSONArray == null) {
            str3 = "null";
        } else {
            str3 = "0";
        }
        sb5.append(str3);
        QLog.i("QzoneIPCModule", 2, sb5.toString());
        return linkedList;
    }

    public static JSONObject parseSticker2Json(List<IStickerRecEmoticon> list) {
        Object valueOf;
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (IStickerRecEmoticon iStickerRecEmoticon : list) {
                if (iStickerRecEmoticon != null && (iStickerRecEmoticon instanceof StickerRecData)) {
                    StickerRecData stickerRecData = (StickerRecData) iStickerRecEmoticon;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", stickerRecData.getImgUrl()).put("thumbUrl", stickerRecData.getThumbUrl()).put("md5", stickerRecData.getImgMd5());
                        jSONArray.mo162put(jSONObject2);
                    } catch (JSONException e16) {
                        QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to create data json", e16);
                    }
                }
            }
            try {
                jSONObject.put("data", jSONArray);
                return jSONObject;
            } catch (JSONException e17) {
                QLog.w("QzoneIPCModule", 2, "parseSticker2Json: failed to put data json", e17);
                return null;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("parseSticker2Json: empty img list ");
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        QLog.i("QzoneIPCModule", 2, sb5.toString());
        return null;
    }

    private void reportTianShu(boolean z16, AppInterface appInterface, Bundle bundle) {
        byte[] byteArray;
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager != null && bundle != null && (byteArray = bundle.getByteArray("data")) != null && byteArray.length > 0) {
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            try {
                appInfo.mergeFrom(byteArray);
                if (z16) {
                    iRedTouchManager.onRedTouchItemExposure(appInfo, null);
                    return;
                }
                if (!TextUtils.isEmpty(appInfo.buffer.get())) {
                    ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoBuffer(appInfo.buffer.get());
                }
                if (!TextUtils.isEmpty(appInfo.extend.get())) {
                    ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoTraceInfo(appInfo.extend.get());
                }
                iRedTouchManager.onRedTouchItemClick(appInfo, null);
            } catch (Throwable th5) {
                QLog.e("QzoneIPCModule", 1, "reportTianShu throwable:" + th5);
            }
        }
    }

    public void getCertifiedAccountTaskList() {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", NAME_CLIENT_PUBACCOUNT, ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST, null, new EIPCResultCallback() { // from class: cooperation.qzone.QzoneIPCModule.4
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                Bundle bundle;
                int size;
                if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
                    bundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList(CertifiedFakeFeed.BUNDLE_KEY_LIST);
                    if (parcelableArrayList != null) {
                        SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(parcelableArrayList));
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new PublishBoxStatusEvent(bundle));
                    Object[] objArr = new Object[1];
                    if (parcelableArrayList == null) {
                        size = 0;
                    } else {
                        size = parcelableArrayList.size();
                    }
                    objArr[0] = Integer.valueOf(size);
                    QLog.d("QzoneIPCModule", 4, String.format("Get certifed account task list %b", objArr));
                }
            }
        });
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x0052 -> B:183:0x007b). Please report as a decompilation issue!!! */
    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        boolean z16;
        String string;
        String string2;
        String string3;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (ACTION_START_DOWNLOAD_VOICECHANGE_SO.equals(str)) {
            try {
                if (AVCoreSystemInfo.getCpuArchitecture() <= 2) {
                    try {
                        b earlyHandler = ((IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(m.O());
                        if (earlyHandler != null) {
                            earlyHandler.I(false);
                        } else {
                            QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
                        }
                    } catch (Exception e16) {
                        QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + e16.getMessage());
                    }
                } else {
                    AVSoUtils.i(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
                }
            } catch (Exception e17) {
                QLog.e("QzoneIPCModule", 1, e17, new Object[0]);
            }
            return EIPCResult.createResult(0, new Bundle());
        }
        if (ACTION_QZONE_PIC_PRE_SEND.equals(str)) {
            try {
                g.b(qQAppInterface, bundle);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("qzone_pre_send_result", true);
                return EIPCResult.createResult(0, bundle2);
            } catch (Exception e18) {
                QLog.e("QzoneIPCModule", 1, "action QzonePic preSend exception: ", e18);
            }
        } else if (ACTION_SAVE_CUSTOMEMOTION.equals(str)) {
            if (bundle != null) {
                String string4 = bundle.getString(PIC_PATH);
                if (!TextUtils.isEmpty(string4)) {
                    int d16 = c.d(qQAppInterface, string4);
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(RESULT_CODE, d16);
                    return EIPCResult.createSuccessResult(bundle3);
                }
            }
        } else if (ACTION_PRE_PULL_MINI_APP.equals(str)) {
            if (bundle != null) {
                QLog.d("QzoneIPCModule", 4, "ACTION_PRE_PULL_MINI_APP change to qq_process by QzoneIPCModule");
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(bundle.getString(MINIAPP_PRELOAD_LINK), bundle.getInt(MINIAPP_PRELOAD_LINK_TYPE), bundle.getBoolean(MINIAPP_PRELOAD_WITH_PACKAGE_AND_CACHE_PRELOAD, false), new IPrePullListener() { // from class: cooperation.qzone.QzoneIPCModule.2
                    @Override // com.tencent.mobileqq.mini.api.IPrePullListener
                    public void onPrePullCallback(boolean z17, JSONObject jSONObject) {
                        QLog.d("QzoneIPCModule", 4, String.format("after preload For QQ MINI Program %b", Boolean.valueOf(z17)));
                    }
                });
            }
        } else if (ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE.equalsIgnoreCase(str)) {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_CREATE to qq_process by QzoneIPCModule");
            bundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            Parcelable parcelable = bundle.getParcelable(CertifiedFakeFeed.BUNDLE_KEY);
            if (parcelable instanceof CertifiedFakeFeed) {
                SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent((CertifiedFakeFeed) parcelable, 1));
            }
        } else if (ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE.equalsIgnoreCase(str)) {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_UPDATE to qq_process by QzoneIPCModule");
            bundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            Parcelable parcelable2 = bundle.getParcelable(CertifiedFakeFeed.BUNDLE_KEY);
            if (parcelable2 instanceof CertifiedFakeFeed) {
                SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent((CertifiedFakeFeed) parcelable2, 2));
            }
        } else if (ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE.equalsIgnoreCase(str)) {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE to qq_process by QzoneIPCModule");
            bundle.setClassLoader(CertifiedFakeFeed.class.getClassLoader());
            Parcelable parcelable3 = bundle.getParcelable(CertifiedFakeFeed.BUNDLE_KEY);
            if (parcelable3 instanceof CertifiedFakeFeed) {
                SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent((CertifiedFakeFeed) parcelable3, 3));
            }
        } else if (ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED.equalsIgnoreCase(str)) {
            QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED to qq_process by QzoneIPCModule");
            SimpleEventBus.getInstance().dispatchEvent(new PublishBoxStatusEvent(bundle));
            SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(4));
        } else if (ACTION_GET_THEMEID.equalsIgnoreCase(str)) {
            try {
                Bundle bundle4 = new Bundle();
                bundle4.putString("themeId", ThemeUtil.getCurrentThemeId());
                return EIPCResult.createResult(0, bundle4);
            } catch (Exception e19) {
                QLog.e("QzoneIPCModule", 1, "action getThemeId exception: ", e19);
            }
        } else if (ACTION_PUBLIC_ACCOUNT_UNFOLLOW.equalsIgnoreCase(str)) {
            if (bundle != null && (string3 = bundle.getString("uin", null)) != null) {
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(qQAppInterface, qQAppInterface.getApp().getApplicationContext(), string3, false, null, true);
                ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).broadcastFollowIfNeed(qQAppInterface.getApp().getApplicationContext(), string3, 0);
            }
        } else if (ACTION_QZONE_MAIN_PROCESS_PROP_SET.equalsIgnoreCase(str)) {
            if (bundle != null && (string2 = bundle.getString("key", null)) != null) {
                qQAppInterface.getApp().getSharedPreferences(PREFS_NAME_QZ_MAIN_SETTING, 0).edit().putBoolean(string2, bundle.getBoolean("value")).apply();
                return EIPCResult.createSuccessResult(null);
            }
        } else if (ACTION_QZONE_MAIN_PROCESS_PROP_GET.equalsIgnoreCase(str)) {
            if (bundle != null && (string = bundle.getString("key", null)) != null) {
                boolean z17 = qQAppInterface.getApp().getSharedPreferences(PREFS_NAME_QZ_MAIN_SETTING, 0).getBoolean(string, false);
                Bundle bundle5 = new Bundle();
                bundle5.putBoolean("value", z17);
                return EIPCResult.createSuccessResult(bundle5);
            }
        } else {
            if (ACTION_QZONE_SEND_EVENT.equalsIgnoreCase(str)) {
                if (QZoneApiProxy.isInQZoneEnvironment()) {
                    return EIPCResult.createResult(-1, null);
                }
                if (bundle != null) {
                    bundle.setClassLoader(((IQzoneEventApi) QRoute.api(IQzoneEventApi.class)).getLoader());
                    IQzoneEventApi.ExoticEventInterface exoticEventInterface = (IQzoneEventApi.ExoticEventInterface) bundle.getParcelable("event");
                    if (exoticEventInterface != null) {
                        boolean onEventReceived = ((IQzoneEventApi) QRoute.api(IQzoneEventApi.class)).onEventReceived(exoticEventInterface);
                        Bundle bundle6 = new Bundle();
                        bundle6.putBoolean("re", onEventReceived);
                        return EIPCResult.createSuccessResult(bundle6);
                    }
                }
                return EIPCResult.createResult(-1, null);
            }
            if (ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH.equalsIgnoreCase(str)) {
                QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH to qq_process by QzoneIPCModule");
                try {
                    byte[] byteArray = bundle.getByteArray(BUNDLE_KEY_FEED_BYTE_ARRAY);
                    CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
                    if (byteArray != null) {
                        CertifiedAccountMeta$StFeed mergeFrom = certifiedAccountMeta$StFeed.mergeFrom(byteArray);
                        QLog.d("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH publishFeed" + mergeFrom.f24925id.get());
                        SimpleEventBus.getInstance().dispatchEvent(new SubscribePublishFeedsEvent(mergeFrom, 1));
                    }
                } catch (Exception e26) {
                    e26.printStackTrace();
                    QLog.e("QzoneIPCModule", 4, "ACTION_PUBLIC_ACCOUNT_FEED_PUBLISH error" + e26);
                }
            } else {
                if (ACTION_SHOW_PUSH_SETTING_BANNER.equalsIgnoreCase(str)) {
                    Bundle bundle7 = new Bundle();
                    h g16 = h.g(qQAppInterface);
                    if (g16 == null) {
                        QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null mgr");
                        return EIPCResult.createResult(-102, null);
                    }
                    boolean e27 = g16.e();
                    bundle7.putBoolean(NodeProps.VISIBLE, e27);
                    if (e27) {
                        ae d17 = NotificationBannerConfProcessor.d();
                        if (d17 != null) {
                            String c16 = d17.c();
                            String b16 = d17.b();
                            bundle7.putString("msg", c16);
                            bundle7.putString("setting", b16);
                        } else {
                            QLog.d("QzoneIPCModule", 1, "ACTION_SHOW_PUSH_SETTING_BANNER null conf bean");
                        }
                    }
                    return EIPCResult.createSuccessResult(bundle7);
                }
                if (ACTION_CLOSE_PUSH_SETTING_BANNER.equalsIgnoreCase(str)) {
                    h g17 = h.g(qQAppInterface);
                    if (g17 == null) {
                        QLog.d("QzoneIPCModule", 1, "ACTION_CLOSE_PUSH_SETTING_BANNER null mgr");
                        return EIPCResult.createResult(-102, null);
                    }
                    g17.t();
                    return EIPCResult.createSuccessResult(null);
                }
                if (ACTION_QZONE_FLOW_QQ_CIRCLE.equalsIgnoreCase(str)) {
                    Bundle bundle8 = new Bundle();
                    if (bundle == null) {
                        QLog.w("QzoneIPCModule", 1, "flow qq circle no param");
                        bundle8.putInt("code", -1);
                        return EIPCResult.createResult(-102, bundle8);
                    }
                    String string5 = bundle.getString("circle_uin");
                    if (TextUtils.isEmpty(string5)) {
                        QLog.w("QzoneIPCModule", 1, "flow qq circle no uin");
                    }
                    boolean z18 = bundle.getBoolean("circle_follow");
                    FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                    feedCloudMeta$StUser.f398463id.set(string5);
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final boolean[] zArr = {false};
                    VSNetworkHelper.getInstance().sendRequest(new QCircleDoFollowRequest(feedCloudMeta$StUser, z18 ? 1 : 0, null), new VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoFollowRsp>() { // from class: cooperation.qzone.QzoneIPCModule.3
                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public void onReceive(BaseRequest baseRequest, boolean z19, long j3, String str2, FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp) {
                            QLog.i("QzoneIPCModule", 1, "flow qq circle resp " + z19 + " " + j3 + " " + str2);
                            zArr[0] = z19;
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        z16 = countDownLatch.await(10L, TimeUnit.SECONDS);
                    } catch (InterruptedException e28) {
                        QLog.w("QzoneIPCModule", 1, "flow qq circle is interrupted", e28);
                        z16 = false;
                    }
                    if (zArr[0]) {
                        QLog.d("QzoneIPCModule", 1, "flow qq circle ok");
                        return EIPCResult.createSuccessResult(null);
                    }
                    if (z16) {
                        QLog.d("QzoneIPCModule", 1, "flow qq circle failed");
                        bundle8.putInt("code", -2);
                        return EIPCResult.createResult(-102, bundle8);
                    }
                    QLog.d("QzoneIPCModule", 1, "flow qq circle over time");
                    bundle8.putInt("code", -3);
                    return EIPCResult.createResult(-102, bundle8);
                }
                if (!ACTION_QZONE_PRELOAD_CM_DATA.equalsIgnoreCase(str) && !ACTION_QCIRCLE_PUBLISH_GET_BUSI_INFO.equalsIgnoreCase(str)) {
                    if (ACTION_IS_FLUTTER_EXTEND.equalsIgnoreCase(str)) {
                        e eVar = (e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
                        Bundle bundle9 = new Bundle();
                        bundle9.putBoolean(ACTION_IS_FLUTTER_EXTEND, eVar.F());
                        return EIPCResult.createSuccessResult(bundle9);
                    }
                    if (ACTION_EXTEND_REPORT.equalsIgnoreCase(str)) {
                        String string6 = bundle.getString("event");
                        if ("click#all_page#entrance".equals(string6)) {
                            String string7 = bundle.getString("source");
                            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick(string7);
                            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandPage(string7);
                        } else {
                            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel(string6, true, (HashMap) bundle.getSerializable("params"));
                        }
                    } else {
                        if (ACTION_MINIGAME_GET_TIANSHU_APPINFO.equals(str)) {
                            Bundle miniGameTianShuAppInfo = getMiniGameTianShuAppInfo(qQAppInterface);
                            if (miniGameTianShuAppInfo == null) {
                                return EIPCResult.createResult(-102, null);
                            }
                            return EIPCResult.createSuccessResult(miniGameTianShuAppInfo);
                        }
                        if (ACTION_REGISTER_RED_DOT_OBSERVER.equals(str)) {
                            qQAppInterface.addObserver(this.redDotObserver);
                            QLog.d("QzoneIPCModule", 4, str);
                        } else if (ACTION_UNREGISTER_RED_DOT_OBSERVER.equals(str)) {
                            qQAppInterface.removeObserver(this.redDotObserver);
                            QLog.d("QzoneIPCModule", 4, str);
                        } else if (ACTION_MINIGAME_RED_DOT_CLICK.equals(str)) {
                            reportTianShu(false, qQAppInterface, bundle);
                        } else if (ACTION_MINIGAME_RED_DOT_EXPOSE.equals(str)) {
                            reportTianShu(true, qQAppInterface, bundle);
                        }
                    }
                }
            }
        }
        return null;
    }

    public void onGetStickerRecResp(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QLog.i("QzoneIPCModule", 1, "onGetStickerRecResp: " + str + " " + str2);
            StickerRecReq stickerRecReq = this.stickerRecReq.get();
            if (stickerRecReq != null && str.equals(stickerRecReq.text) && androidx.lifecycle.c.a(this.stickerRecReq, stickerRecReq, null)) {
                stickerRecReq.data = str2;
                stickerRecReq.pass = str3;
                stickerRecReq.latch.countDown();
            }
        }
    }
}

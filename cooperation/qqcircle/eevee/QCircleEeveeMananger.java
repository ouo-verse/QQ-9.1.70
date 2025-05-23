package cooperation.qqcircle.eevee;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.gcloudsdk.gcloud.voice.GCloudVoiceVersion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.data.QFSClockInBean;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.mobileqq.qcircle.api.event.QCirclePushEffectUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSClockInPendantChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSPersonalRecommendSwitchClosedEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSPushRocketChargeTipsEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSSpringPrizePopupInfoEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSStudyModeChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSTagPolymerizationTaskDoneShowDialogEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig;
import com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig;
import com.tencent.mobileqq.qcircle.api.global.QFSCommentEffectConfig;
import com.tencent.mobileqq.qcircle.api.global.QFSPushConfig;
import com.tencent.mobileqq.qcircle.api.global.QFSTeenModeConfig;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleEeveeAttachInfoHelper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleEeveeUndealMsgRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleSecurityStatusUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.beans.QCircleVVGameConfigBean;
import cooperation.qqcircle.beans.SingleUndealMsg;
import cooperation.qqcircle.helpers.QCircleSilenceInsertHelper;
import cooperation.qqcircle.helpers.QCircleVVGameHelper;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.AdUtils;
import cooperation.qqcircle.utils.QFSGalleryEntranceRedPointInfoUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommonDialog$Dialog;
import feedcloud.FeedCloudEeveeBase$ClientInfo;
import feedcloud.FeedCloudEeveeBase$StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeBase$StEeveeDialogData;
import feedcloud.FeedCloudEeveeUndealmsg$BizUndealMsg;
import feedcloud.FeedCloudEeveeUndealmsg$FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg$IntervalControl;
import feedcloud.FeedCloudEeveeUndealmsg$SignalMsg;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$CommDialog;
import feedcloud.FeedCloudRead$DialogJumpInfo;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudToastshowsvr$StGetToastDetailRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qqcircle.Hotspots$HotSpotRsp;
import qqcircle.QQCircleBase$StPublishButtonAnimationInfo;
import qqcircle.QQCircleClient$EeveeLoginEvent;
import qqcircle.QQCircleCounter$AttachInfo;
import qqcircle.QQCircleCounter$CountInfoRsp;
import qqcircle.QQCircleCounter$PrivateMessage;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$StyleBubble;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleEnvHub$GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub$UserInfo;
import qqcircle.QQCircleSac$SenceBeatInfo;
import qqcircle.QQCircleSac$SenceBeatInfos;
import qqcircle.TaskCenterReader$EeveeMyFuel;
import qqcircle.TaskCenterReader$PushStyleTest;
import uq3.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleEeveeMananger {
    private static final String ATTACH_INFO_HOTSPOTS = "104_104001_hotSpotStatus";
    private static final String ATTACH_INFO_KEY_ADREQ = "106_1060001_ADReq";
    private static final String ATTACH_INFO_KEY_ENTRY_SHOW_TYPE = "entrance_show_type";
    private static final String ATTACH_INFO_KEY_PRELOAD_ALL_PUSH = "106_1060001_PreLoad";
    private static final String ATTACH_INFO_KEY_PRELOAD_FRIEND = "106_1060001_friendPreload";
    private static final String ATTACH_INFO_RED_DOT_BY_TIANSHU = "reddot_by_tianshu";
    private static final String ATTACH_INFO_VVGAME = "104_104001_Flag";
    private static final String ENTRY_TYPE_DYNAMIC = "dynamic";
    private static final String ENTRY_TYPE_TAB = "main";
    public static final long MULTI_REQUEST_INTERVAL = 1500;
    private static final String PUSH_V5_EXP_ID = "exp_pushrocket";
    private static final String TAG = "QCircleEeveeMananger";
    private static final Object dbLock = new Object();
    private static volatile QCircleEeveeMananger mInstance;
    private static StudyModeChangeListener mStudyModeChangeListener;
    private static final MqqHandler sHandler;
    public static long sLastPollingTime;
    public static long sLastRequestTime;
    private EntityManager mEm;
    private String mLastUin;
    private final Runnable mPollingTask;
    private final IQQFrontBackListener mQQFrontBackListener;
    public long mPollingInterval = 60000;
    public long mSceneSwitchInterval = 5000;
    public long mHomeSwitchInterval = 45000;
    private long mLastGetBySwitchTab = 0;
    private long mLastEnterQCircleTab = 0;
    private long mLastGetBySwitchHome = 0;

    static {
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("eevee_timer", 0);
        newFreeHandlerThread.start();
        sHandler = new MqqHandler(newFreeHandlerThread.getLooper());
    }

    QCircleEeveeMananger() {
        IQQFrontBackListener iQQFrontBackListener = new IQQFrontBackListener() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.1
            @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
            public void onQQEnterBackground() {
                QCircleEeveeMananger.sHandler.removeCallbacks(QCircleEeveeMananger.this.mPollingTask);
            }

            @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
            public void onQQEnterForeground() {
                QCircleEeveeMananger.sHandler.removeCallbacks(QCircleEeveeMananger.this.mPollingTask);
                QCircleEeveeMananger.sHandler.postDelayed(QCircleEeveeMananger.this.mPollingTask, QCircleEeveeMananger.this.mPollingInterval);
            }
        };
        this.mQQFrontBackListener = iQQFrontBackListener;
        this.mPollingTask = new Runnable() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.5
            @Override // java.lang.Runnable
            public void run() {
                QCircleEeveeMananger.getInstance().onSend(999, null, null);
            }
        };
        getmEm();
        if (mStudyModeChangeListener == null) {
            mStudyModeChangeListener = new StudyModeChangeListener() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.2
                @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
                public void onChange(boolean z16) {
                    QLog.d(QCircleEeveeMananger.TAG, 1, "refreshFolderPage onChange " + z16);
                    SimpleEventBus.getInstance().dispatchEvent(new QFSStudyModeChangeEvent(z16));
                    QCircleEeveeMananger.this.clearNormalModeData();
                }
            };
            ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(mStudyModeChangeListener);
        }
        QCircleListenerProxyManager.getInstance().addQQFrontBackListener(iQQFrontBackListener);
    }

    private List<FeedCloudEeveeBase$StEeveeAttachInfo> appendLightSDKVersion(@NonNull List<FeedCloudEeveeBase$StEeveeAttachInfo> list) {
        String str;
        for (FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo : list) {
            if (feedCloudEeveeBase$StEeveeAttachInfo != null && "110_1100001_LightSDKVersion".equals(feedCloudEeveeBase$StEeveeAttachInfo.key.get())) {
                return list;
            }
        }
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo2 = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo2.key.set("110_1100001_LightSDKVersion");
        feedCloudEeveeBase$StEeveeAttachInfo2.tag.set(0);
        if (!TextUtils.isEmpty("3.1.0.11")) {
            String[] split = "3.1.0.11".split("\\.");
            if (split.length > 3) {
                str = split[0] + "." + split[1] + "." + split[2];
                feedCloudEeveeBase$StEeveeAttachInfo2.value.set(str);
                list.add(feedCloudEeveeBase$StEeveeAttachInfo2);
                return list;
            }
        }
        str = GCloudVoiceVersion.GCLOUD_VERSION;
        feedCloudEeveeBase$StEeveeAttachInfo2.value.set(str);
        list.add(feedCloudEeveeBase$StEeveeAttachInfo2);
        return list;
    }

    private String buildLogInfo(String str, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(qQCircleCounter$RedPointInfo.appid.get());
        sb5.append(", redType: ");
        sb5.append(qQCircleCounter$RedPointInfo.redType.get());
        sb5.append(", redTotalNum: ");
        sb5.append(qQCircleCounter$RedPointInfo.redTotalNum.get());
        sb5.append(", wording: ");
        sb5.append(qQCircleCounter$RedPointInfo.wording.get());
        sb5.append(", tabTipWording: ");
        sb5.append(qQCircleCounter$RedPointInfo.allPushInfo.tabTipWording.get());
        sb5.append(", combineRedTypes: ");
        sb5.append(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get());
        sb5.append(", tabType: ");
        sb5.append(qQCircleCounter$RedPointInfo.tabType.get());
        sb5.append(", jumpLink: ");
        sb5.append(qQCircleCounter$RedPointInfo.redJumpInfo.jumpLink.get());
        sb5.append(", numRedPointClear: ");
        sb5.append(EeveeRedpointUtil.enableNumRedClear(qQCircleCounter$RedPointInfo));
        sb5.append(", extend: ");
        sb5.append(qQCircleCounter$RedPointInfo.extend.get());
        sb5.append(", msgId: ");
        sb5.append(str);
        sb5.append(", transInfo length: ");
        sb5.append(qQCircleCounter$RedPointInfo.transInfo.get().toByteArray().length);
        List<QQCircleCounterMsg$RedDisplayInfo> list = qQCircleCounter$RedPointInfo.rptRedInfo.get();
        if (list != null && list.size() > 0) {
            sb5.append(", uinInfo: ");
            for (QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo : list) {
                sb5.append("(");
                sb5.append(qQCircleCounterMsg$RedDisplayInfo.headImg.get());
                sb5.append(",");
                sb5.append(qQCircleCounterMsg$RedDisplayInfo.num.get());
                sb5.append(")");
            }
        }
        return sb5.toString();
    }

    private boolean checkNeedBlock(int i3, String str, String str2, FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg) {
        switch (i3) {
            case 2:
                if (System.currentTimeMillis() - this.mLastGetBySwitchHome < this.mHomeSwitchInterval) {
                    return true;
                }
                this.mLastGetBySwitchHome = System.currentTimeMillis();
                return false;
            case 3:
                if (System.currentTimeMillis() - this.mLastGetBySwitchTab < this.mSceneSwitchInterval) {
                    return true;
                }
                this.mLastGetBySwitchTab = System.currentTimeMillis();
                return false;
            case 4:
                handleLoginScene(i3, str, str2, feedCloudEeveeUndealmsg$SignalMsg);
                return true;
            case 5:
                if (System.currentTimeMillis() - this.mLastEnterQCircleTab < this.mSceneSwitchInterval) {
                    return true;
                }
                this.mLastEnterQCircleTab = System.currentTimeMillis();
                return false;
            case 6:
            case 7:
                break;
            default:
                switch (i3) {
                    case 999:
                        break;
                    case 1000:
                        if (!TextUtils.isEmpty(str)) {
                            feedCloudEeveeUndealmsg$SignalMsg.signalBuff.set(ByteStringMicro.copyFromUtf8(str));
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            feedCloudEeveeUndealmsg$SignalMsg.msgid.set(str2);
                            return false;
                        }
                        return false;
                    case 1001:
                        handlePushData(str);
                        return true;
                    default:
                        return false;
                }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastPollingTime < this.mPollingInterval) {
            QLog.d(TAG, 2, "onSend.pollingInterval time is not enough" + this.mPollingInterval);
            scheduleEeveeTask();
            return true;
        }
        sLastPollingTime = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNormalModeData() {
        QCircleEeveeAttachInfoHelper.getInstance().clearMemoryInfo();
        QCircleChatBoxHelper.releaseInstance();
        QCircleHostGlobalInfo.clearMemoryInfo();
        ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).release();
        QCircleHostRedPointHelper.clearPedPoint();
        QCircleInvokeProxy.invoke(2, 1, new Object[0]);
        QCircleInvokeProxy.invoke(1, 1, new Object[0]);
    }

    private List<QQCircleCounter$RedPointInfo> filterValidRedPointInfoList(int i3, List<QQCircleCounter$RedPointInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo : list) {
            if (EeveeRedpointUtil.isValidRedPointInfo(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, i3, qQCircleCounter$RedPointInfo)) {
                arrayList.add(qQCircleCounter$RedPointInfo);
            } else {
                QLog.i(TAG, 1, "[filterValidRedPointInfoList] invalid red point info! ignore it, info=" + buildLogInfo("", qQCircleCounter$RedPointInfo));
            }
        }
        return arrayList;
    }

    private String getAccount() {
        try {
            return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return "";
        }
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getAdTopViewAttachInfo() {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set(ATTACH_INFO_KEY_ADREQ);
        feedCloudEeveeBase$StEeveeAttachInfo.busiData.set(AdUtils.getAdReqByte(23));
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private String getColdBootTag() {
        return "QCircleColdBootPreloadFeedManagerV2_QCircleEeveeMananger";
    }

    private List<FeedCloudEeveeBase$StEeveeAttachInfo> getEeeveeAttachInfo() {
        ArrayList arrayList = new ArrayList();
        if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            arrayList.add(getPreloadFeedAttachInfo(10, ATTACH_INFO_KEY_PRELOAD_ALL_PUSH));
            arrayList.add(getPreloadFeedAttachInfo(75, ATTACH_INFO_KEY_PRELOAD_FRIEND));
        }
        arrayList.add(getVVGameAttachInfo());
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return arrayList;
        }
        arrayList.addAll(QCircleEeveeAttachInfoHelper.getInstance().getEeveeAttachInfos());
        arrayList.add(getPrivateMessageAttachInfo());
        arrayList.add(getAdTopViewAttachInfo());
        arrayList.add(getHotspotsAttachInfo());
        arrayList.add(getEntranceShowTypeAttachInfo());
        if (((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            arrayList.add(getTianshuRedDotFlagAttachInfo());
        }
        appendLightSDKVersion(arrayList);
        return arrayList;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getEntranceShowTypeAttachInfo() {
        String str;
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set(ATTACH_INFO_KEY_ENTRY_SHOW_TYPE);
        PBStringField pBStringField = feedCloudEeveeBase$StEeveeAttachInfo.value;
        if (uq3.c.M6()) {
            str = "main";
        } else {
            str = "dynamic";
        }
        pBStringField.set(str);
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getHotspotsAttachInfo() {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set(ATTACH_INFO_HOTSPOTS);
        feedCloudEeveeBase$StEeveeAttachInfo.busiData.set(QCircleSilenceInsertHelper.getInstance().getReqByte());
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    public static QCircleEeveeMananger getInstance() {
        if (mInstance == null) {
            synchronized (QCircleEeveeMananger.class) {
                if (mInstance == null) {
                    QLog.e(TAG, 1, "getInstance");
                    mInstance = new QCircleEeveeMananger();
                }
            }
        }
        return mInstance;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getPreloadFeedAttachInfo(int i3, String str) {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        byte[] preloadReqByte = ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).getPreloadReqByte(i3);
        if (preloadReqByte != null && preloadReqByte.length != 0) {
            feedCloudEeveeBase$StEeveeAttachInfo.key.set(str);
            feedCloudEeveeBase$StEeveeAttachInfo.busiData.set(ByteStringMicro.copyFrom(preloadReqByte));
            QLog.d(getColdBootTag(), 1, "getPreloadFeedAttachInfo with valid data, source:" + i3);
            return feedCloudEeveeBase$StEeveeAttachInfo;
        }
        QLog.d(getColdBootTag(), 1, "getPreloadFeedAttachInfo empty ,source:" + i3);
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getPrivateMessageAttachInfo() {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        Pair<Integer, List<QQCircleCounter$PrivateMessage>> unReadMessages = QCircleChatBoxHelper.getInstance().getUnReadMessages();
        if (unReadMessages != null && unReadMessages.second != null) {
            QQCircleCounter$AttachInfo qQCircleCounter$AttachInfo = new QQCircleCounter$AttachInfo();
            QLog.d(TAG, 1, "getPrivateMessageAttachInfo unReadMessages size =" + ((List) unReadMessages.second).size());
            qQCircleCounter$AttachInfo.privateMsgList.set((List) unReadMessages.second);
            feedCloudEeveeBase$StEeveeAttachInfo.key.set("106_1060001_AttachInfo");
            feedCloudEeveeBase$StEeveeAttachInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleCounter$AttachInfo.toByteArray()));
        }
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getTianshuRedDotFlagAttachInfo() {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set(ATTACH_INFO_RED_DOT_BY_TIANSHU);
        feedCloudEeveeBase$StEeveeAttachInfo.value.set("1");
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private FeedCloudEeveeBase$StEeveeAttachInfo getVVGameAttachInfo() {
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set(ATTACH_INFO_VVGAME);
        feedCloudEeveeBase$StEeveeAttachInfo.busiData.set(QCircleVVGameHelper.INSTANCE.getReqByte());
        return feedCloudEeveeBase$StEeveeAttachInfo;
    }

    private synchronized EntityManager getmEm() {
        EntityManager entityManager = this.mEm;
        if (entityManager != null) {
            return entityManager;
        }
        if (mInstance == null) {
            return null;
        }
        try {
            EntityManager entityManager2 = QCircleServiceImpl.getEntityManager();
            this.mEm = entityManager2;
            return entityManager2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getmEm " + e16);
            return null;
        }
    }

    private void handleBizUndealMsg(@NonNull BaseRequest baseRequest, FeedCloudEeveeUndealmsg$BizUndealMsg feedCloudEeveeUndealmsg$BizUndealMsg, int i3, FeedCloudEeveeUndealmsg$IntervalControl feedCloudEeveeUndealmsg$IntervalControl) {
        if (feedCloudEeveeUndealmsg$BizUndealMsg == null) {
            return;
        }
        int i16 = feedCloudEeveeUndealmsg$BizUndealMsg.mainType.get();
        int i17 = feedCloudEeveeUndealmsg$BizUndealMsg.subid.get();
        byte[] byteArray = feedCloudEeveeUndealmsg$BizUndealMsg.bufferData.get().toByteArray();
        switch (i16) {
            case 101:
            case 102:
            case 105:
            case 106:
            case 115:
            case 116:
                QLog.d("QFSRedDot", 2, "receive red dot rsp");
                handleRedDotMsg(baseRequest, i16, i17, byteArray, feedCloudEeveeUndealmsg$BizUndealMsg, feedCloudEeveeUndealmsg$IntervalControl);
                return;
            case 103:
                try {
                    FeedCloudToastshowsvr$StGetToastDetailRsp feedCloudToastshowsvr$StGetToastDetailRsp = new FeedCloudToastshowsvr$StGetToastDetailRsp();
                    feedCloudToastshowsvr$StGetToastDetailRsp.mergeFrom(byteArray);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[handleBizUndealMsg] receive toast. showPageType: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.showControl.showPageType.get());
                    sb5.append(", showTimeType: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.showControl.showTime.showTimeType.get());
                    sb5.append(", showTime: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.showControl.showTime.value.get());
                    sb5.append(", showDuration: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.showControl.showTime.showDuration.get());
                    sb5.append(", title: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.toastContent.title.get());
                    sb5.append(", content: ");
                    sb5.append(feedCloudToastshowsvr$StGetToastDetailRsp.toastInfo.toastContent.content.get());
                    QLog.d(TAG, 1, sb5);
                    saveBizUndealMsgBuffer(i16, byteArray);
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "handleBizUndealMsg error: mainType " + i16, e16);
                    return;
                }
            case 104:
                handleFuelData(byteArray, i17);
                saveBizUndealMsgBuffer(i16, byteArray);
                return;
            case 107:
                if (byteArray != null) {
                    try {
                        QQCircleBase$StPublishButtonAnimationInfo qQCircleBase$StPublishButtonAnimationInfo = new QQCircleBase$StPublishButtonAnimationInfo();
                        qQCircleBase$StPublishButtonAnimationInfo.mergeFrom(byteArray);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("[handleBizUndealMsg] receive publish button conf.");
                        sb6.append(" isShowAnimation: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.isShowAnimation.get());
                        sb6.append(", hashIcon: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.hashIcon.get());
                        sb6.append(", hashTag: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.hashTag.get());
                        sb6.append(", words: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.words.get());
                        sb6.append(", backImg: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.backImg.get());
                        sb6.append(", operatorIcon: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.operatorIcon.get());
                        sb6.append(", jumpUrl: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.jumpUrl.get());
                        sb6.append(", animationStartupTime: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.animationStartupTime.get());
                        sb6.append(", animationShowTime: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.animationShowTime.get());
                        sb6.append(", reportExt: ");
                        sb6.append(qQCircleBase$StPublishButtonAnimationInfo.reportExt.get());
                        QLog.d(TAG, 1, sb6);
                        SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishButtonEvent(qQCircleBase$StPublishButtonAnimationInfo.toByteArray()));
                        saveBizUndealMsgBuffer(i16, byteArray);
                        return;
                    } catch (InvalidProtocolBufferMicroException e17) {
                        QLog.e(TAG, 1, "handleBizUndealMsg error: mainType " + i16, e17);
                        return;
                    }
                }
                return;
            case 108:
                initUserEnv(byteArray);
                return;
            case 109:
            case 111:
            case 112:
            case 118:
            default:
                return;
            case 110:
                try {
                    saveBizUndealMsgBuffer(i16, byteArray);
                    LocalMultiProcConfig.putLong(AEEditorConstants.SP_GET_PHOTO_CLUSTER_LAST_TIME, System.currentTimeMillis());
                    return;
                } catch (Exception e18) {
                    QLog.e(TAG, 1, "handleBizUndealMsg error: mainType " + i16, e18);
                    return;
                }
            case 113:
                handleCommonDialog(byteArray);
                return;
            case 114:
                handleHotSpotReqData(byteArray);
                return;
            case 117:
                handleSecurityStatusRsp(i17, byteArray);
                return;
            case 119:
                handleSpringPrizePopupMsg(i17, byteArray);
                return;
        }
    }

    private void handleClockInPendantData(@NonNull TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel) {
        QLog.d(TAG, 1, "handleClockInPendantData status = " + taskCenterReader$EeveeMyFuel.clockInInfo.status.get() + "daysCount = " + taskCenterReader$EeveeMyFuel.clockInInfo.daysCount.get() + "duration = " + taskCenterReader$EeveeMyFuel.clockInInfo.duration.get() + "isLastDay = " + taskCenterReader$EeveeMyFuel.clockInInfo.isLastDay.get() + "jumpURL = " + taskCenterReader$EeveeMyFuel.clockInInfo.jumpURL.get());
        QFSClockInBean qFSClockInBean = new QFSClockInBean();
        qFSClockInBean.setDayCount(taskCenterReader$EeveeMyFuel.clockInInfo.daysCount.get());
        qFSClockInBean.setStatus(taskCenterReader$EeveeMyFuel.clockInInfo.status.get());
        qFSClockInBean.setDuration(taskCenterReader$EeveeMyFuel.clockInInfo.duration.get());
        qFSClockInBean.setLastDay(taskCenterReader$EeveeMyFuel.clockInInfo.isLastDay.get());
        qFSClockInBean.setTransInfo(taskCenterReader$EeveeMyFuel.clockInInfo.transInfo.get());
        qFSClockInBean.setJumpUrl(taskCenterReader$EeveeMyFuel.clockInInfo.jumpURL.get());
        parseClockInTexts(taskCenterReader$EeveeMyFuel, qFSClockInBean);
        parseClockInImages(taskCenterReader$EeveeMyFuel, qFSClockInBean);
        QCircleHostGlobalInfo.setClockInfoBean(qFSClockInBean);
        SimpleEventBus.getInstance().dispatchEvent(new QFSClockInPendantChangeEvent());
    }

    private void handleDialogData(JSONObject jSONObject) {
        JsonParser jsonParser = new JsonParser();
        JsonObject asJsonObject = jsonParser.parse(jsonParser.parse(jSONObject.toString()).getAsJsonObject().getAsJsonPrimitive("pushStr").getAsString()).getAsJsonObject();
        if (asJsonObject.getAsJsonPrimitive("type").getAsInt() == 0) {
            QLog.d(TAG, 1, "[handleDialogData] QFSTagPolymerizationTaskDoneDialogPart");
            handleXhhTypeDialog(asJsonObject);
        }
    }

    private void handleFuelData(byte[] bArr, int i3) {
        switch (i3) {
            case 1040001:
                handleTaskCenterEeveeMyFuel(bArr);
                return;
            case 1040002:
                handleLoginRocketChargeTips(bArr);
                return;
            default:
                return;
        }
    }

    private void handleHotSpotReqData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            Hotspots$HotSpotRsp hotspots$HotSpotRsp = new Hotspots$HotSpotRsp();
            hotspots$HotSpotRsp.mergeFrom(bArr);
            QLog.d(TAG, 1, "handleHotSpotReqData ");
            QCircleSilenceInsertHelper.getInstance().receiveHotSpotReqData(hotspots$HotSpotRsp);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleHotSpotReqData" + e16);
        }
    }

    private void handleLoginRocketChargeTips(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleLoginFuelChargeTips");
            }
            QQCircleClient$EeveeLoginEvent qQCircleClient$EeveeLoginEvent = new QQCircleClient$EeveeLoginEvent();
            qQCircleClient$EeveeLoginEvent.mergeFrom(bArr);
            QFSPushConfig.setCurrentUin(getAccount());
            QFSPushConfig.saveRocketChargeTipsText(qQCircleClient$EeveeLoginEvent.toast_text.get());
            QFSPushConfig.saveRocketChargeTipsShowCountLimit(qQCircleClient$EeveeLoginEvent.toast_count.get());
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void handleLoginScene(final int i3, final String str, final String str2, final FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg) {
        ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).doPrepare(new IQCircleColdBootServiceV2.a() { // from class: cooperation.qqcircle.eevee.a
            @Override // com.tencent.mobileqq.qcircle.api.IQCircleColdBootServiceV2.a
            public final void onPrepared() {
                QCircleEeveeMananger.this.lambda$handleLoginScene$3(i3, str, str2, feedCloudEeveeUndealmsg$SignalMsg);
            }
        });
    }

    private void handleNvvGameData(TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel) {
        if (taskCenterReader$EeveeMyFuel == null) {
            return;
        }
        QCircleVVGameConfigBean qCircleVVGameConfigBean = new QCircleVVGameConfigBean();
        if (taskCenterReader$EeveeMyFuel.vvCount.get() < 0) {
            QLog.d(TAG, 1, "handleNvvGameData vvCount:" + taskCenterReader$EeveeMyFuel.vvCount.get());
            return;
        }
        qCircleVVGameConfigBean.setVVCount(taskCenterReader$EeveeMyFuel.vvCount.get());
        qCircleVVGameConfigBean.setVVReason(taskCenterReader$EeveeMyFuel.vvReason.get());
        qCircleVVGameConfigBean.setVVFailedTip(taskCenterReader$EeveeMyFuel.vvTabTip.get());
        qCircleVVGameConfigBean.setVVTopSucceedTip(taskCenterReader$EeveeMyFuel.vvTopTip.get());
        qCircleVVGameConfigBean.setGetConfigTime(System.currentTimeMillis());
        QCircleVVGameHelper.INSTANCE.setVVConfigBean(qCircleVVGameConfigBean);
        QLog.d(TAG, 1, "handleNvvGameData vvConfigBean:" + qCircleVVGameConfigBean);
    }

    private void handleOverPushConfig(@NonNull TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel) {
        boolean z16;
        Iterator<TaskCenterReader$PushStyleTest> it = taskCenterReader$EeveeMyFuel.fuelConf.pushtype.get().iterator();
        while (true) {
            if (it.hasNext()) {
                TaskCenterReader$PushStyleTest next = it.next();
                if (next.adtestID.get().equals(PUSH_V5_EXP_ID) && next.isHitABTest.get()) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        k.a().j("qfs_push_v5_enable", z16);
        k.a().j("qfs_push_v4_enable", taskCenterReader$EeveeMyFuel.fuelConf.isv4test.get());
        k.a().p("qfs_push_v4_push_choices", new Gson().toJson(taskCenterReader$EeveeMyFuel.fuelConf.fuelcount.get()));
        QLog.d(TAG, 1, "[handleOverPushConfig] is hit push v5: " + z16);
    }

    private void handleRedDotMsg(@NonNull BaseRequest baseRequest, int i3, int i16, byte[] bArr, FeedCloudEeveeUndealmsg$BizUndealMsg feedCloudEeveeUndealmsg$BizUndealMsg, FeedCloudEeveeUndealmsg$IntervalControl feedCloudEeveeUndealmsg$IntervalControl) {
        try {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                return;
            }
            QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp = new QQCircleCounter$CountInfoRsp();
            qQCircleCounter$CountInfoRsp.mergeFrom(bArr);
            QLog.d(TAG, 1, "handleBizUndealMsg mainType " + i3 + ", " + qQCircleCounter$CountInfoRsp.rptRedPoint.size());
            List<QQCircleCounter$RedPointInfo> redPointInfoListByAppid = EeveeRedpointUtil.getRedPointInfoListByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, baseRequest, qQCircleCounter$CountInfoRsp);
            if (redPointInfoListByAppid.isEmpty()) {
                QLog.d(TAG, 1, "[handleBizUndealMsg] don't have qcircle entrance reddot!");
                return;
            }
            QLog.d(TAG, 1, "[FeedLine_handleBizUndealMsg] redPointInfoList size:" + redPointInfoListByAppid.size() + ",traceId:" + baseRequest.getTraceId());
            printRedPointInfo(feedCloudEeveeUndealmsg$BizUndealMsg, redPointInfoListByAppid);
            List<QQCircleCounter$RedPointInfo> filterValidRedPointInfoList = filterValidRedPointInfoList(i3, redPointInfoListByAppid);
            if (filterValidRedPointInfoList.isEmpty()) {
                QLog.i(TAG, 1, "[handleBizUndealMsg] no valid RedPointInfo, mainType=" + i3 + ",subType=" + i16);
                return;
            }
            rewriteBubbleExpiredTime(filterValidRedPointInfoList, feedCloudEeveeUndealmsg$IntervalControl.pollingInterval.get() * 1000);
            if (i3 == 101) {
                handleSmallRedDotInner(qQCircleCounter$CountInfoRsp);
            }
            if (i3 == 116 && i16 == 116001 && filterValidRedPointInfoList.size() > 0) {
                QFSGalleryEntranceRedPointInfoUtil.updateGalleryEntranceRedPointInfo(filterValidRedPointInfoList.get(0));
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleRedPointEvent(i3, i16, filterValidRedPointInfoList, qQCircleCounter$CountInfoRsp.extInfo));
            EeveeRedpointUtil.setReceiveRedPointTimeStamp(System.currentTimeMillis());
            saveRedPointInfoToSP(i3, filterValidRedPointInfoList);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleBizUndealMsg error: mainType " + i3, e16);
        }
    }

    private void handleSecurityStatusRsp(int i3, byte[] bArr) {
        if (i3 != 117001) {
            QLog.e(TAG, 1, "handleSecurityStatusResp: Unknown subType " + i3);
            return;
        }
        QQCircleSac$SenceBeatInfos qQCircleSac$SenceBeatInfos = new QQCircleSac$SenceBeatInfos();
        try {
            qQCircleSac$SenceBeatInfos.mergeFrom(bArr);
            List<QQCircleSac$SenceBeatInfo> list = qQCircleSac$SenceBeatInfos.infos.get();
            QLog.e(TAG, 1, "handleSecurityStatusRsp | beatInfoList size=" + list.size());
            for (QQCircleSac$SenceBeatInfo qQCircleSac$SenceBeatInfo : list) {
                if (qQCircleSac$SenceBeatInfo != null) {
                    QLog.e(TAG, 1, "handleSecurityStatusRsp | beatStatus =" + qQCircleSac$SenceBeatInfo.beatStatus.get() + ", sence =" + qQCircleSac$SenceBeatInfo.sence.get());
                }
            }
            QCircleSecurityStatusUtil.setBeatInfoList(list);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleSecurityStatusResp: ", e16);
        }
    }

    private void handleSmallRedDotInner(QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp) {
        List<FeedCloudCommon$BytesEntry> list = qQCircleCounter$CountInfoRsp.extInfo.mapBytesInfo.get();
        if (list == null) {
            return;
        }
        for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : list) {
            if (feedCloudCommon$BytesEntry != null && TextUtils.equals(EeveeRedpointUtil.MAP_KEY_CIRCLE_FOLLOW_TAB_CLEAR_RED_DOT_DELAY_SECOND, feedCloudCommon$BytesEntry.key.get()) && feedCloudCommon$BytesEntry.value.get() != null) {
                try {
                    EeveeRedpointUtil.saveFollowTabClearRedDotDelayInSecond(Long.parseLong(feedCloudCommon$BytesEntry.value.get().toStringUtf8()));
                } catch (NumberFormatException e16) {
                    QLog.e(TAG, 1, "handleBizUndealMsg  saveFollowTabClearRedDotDelayInSecond error!", e16);
                }
            }
        }
    }

    private void handleSpringPrizePopupMsg(int i3, byte[] bArr) {
        QLog.i(TAG, 1, "[handleSpringPrizePopupMsg] subType=" + i3);
        if (i3 == 119001) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSSpringPrizePopupInfoEvent(bArr));
        }
    }

    private void handleTaskCenterEeveeMyFuel(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleFuelData");
            }
            TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel = new TaskCenterReader$EeveeMyFuel();
            taskCenterReader$EeveeMyFuel.mergeFrom(bArr);
            handleNvvGameData(taskCenterReader$EeveeMyFuel);
            handleClockInPendantData(taskCenterReader$EeveeMyFuel);
            handleOverPushConfig(taskCenterReader$EeveeMyFuel);
            long j3 = taskCenterReader$EeveeMyFuel.pushTime.get();
            if (j3 > QCircleHostConfig.getPushFuleCountTime()) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "handleFuelData fuelcount:" + taskCenterReader$EeveeMyFuel.myFuelValue.get());
                }
                QCircleConfig.getInstance().saveFuleCount(taskCenterReader$EeveeMyFuel.myFuelValue.get());
                QCircleHostConfig.savePushFuleCountTime(j3);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void handleXhhTypeDialog(JsonObject jsonObject) {
        FeedCloudEeveeBase$StEeveeDialogData feedCloudEeveeBase$StEeveeDialogData = new FeedCloudEeveeBase$StEeveeDialogData();
        FeedCloudRead$CommDialog feedCloudRead$CommDialog = new FeedCloudRead$CommDialog();
        JsonObject asJsonObject = jsonObject.getAsJsonObject("dialog");
        feedCloudRead$CommDialog.title.set(asJsonObject.getAsJsonPrimitive("title").getAsString());
        feedCloudRead$CommDialog.text.set(asJsonObject.getAsJsonPrimitive("text").getAsString());
        feedCloudRead$CommDialog.ok_btn_text.set(asJsonObject.getAsJsonPrimitive("ok_btn_text").getAsString());
        feedCloudRead$CommDialog.cancel_btn_text.set(asJsonObject.getAsJsonPrimitive("cancel_btn_text").getAsString());
        JsonArray asJsonArray = asJsonObject.getAsJsonArray("jump_infos");
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = asJsonArray.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            FeedCloudRead$DialogJumpInfo feedCloudRead$DialogJumpInfo = new FeedCloudRead$DialogJumpInfo();
            JsonObject asJsonObject2 = next.getAsJsonObject();
            feedCloudRead$DialogJumpInfo.key_word.set(asJsonObject2.getAsJsonPrimitive(QCircleSchemeAttr.Detail.KEY_WORD).getAsString());
            feedCloudRead$DialogJumpInfo.jump_url.set(asJsonObject2.getAsJsonPrimitive("jump_url").getAsString());
            arrayList.add(feedCloudRead$DialogJumpInfo);
        }
        feedCloudRead$CommDialog.jump_infos.set(arrayList);
        feedCloudEeveeBase$StEeveeDialogData.dialog.set(feedCloudRead$CommDialog);
        JsonArray asJsonArray2 = jsonObject.getAsJsonArray("entries");
        ArrayList arrayList2 = new ArrayList();
        Iterator<JsonElement> it5 = asJsonArray2.iterator();
        while (it5.hasNext()) {
            JsonElement next2 = it5.next();
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            JsonObject asJsonObject3 = next2.getAsJsonObject();
            feedCloudCommon$Entry.key.set(asJsonObject3.getAsJsonPrimitive("key").getAsString());
            feedCloudCommon$Entry.value.set(asJsonObject3.getAsJsonPrimitive("value").getAsString());
            arrayList2.add(feedCloudCommon$Entry);
        }
        feedCloudEeveeBase$StEeveeDialogData.entries.set(arrayList2);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTagPolymerizationTaskDoneShowDialogEvent(feedCloudEeveeBase$StEeveeDialogData));
    }

    private void initPushEffect(QQCircleEnvHub$GetUserFullEnvRsp qQCircleEnvHub$GetUserFullEnvRsp) {
        QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo = qQCircleEnvHub$GetUserFullEnvRsp.userInfo;
        if (qQCircleEnvHub$UserInfo == null) {
            QLog.d(TAG, 1, "QCircleRefreshPushEffect initPushEffect push info is null");
            return;
        }
        QLog.d(TAG, 1, "QCircleRefreshPushEffect initPushEffect form GetUserFullEnvRsp startTime :" + qQCircleEnvHub$UserInfo.pushEffectStartTime.get() + ", endTime :" + qQCircleEnvHub$UserInfo.pushEffectEndTime.get());
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePushEffectUpdateEvent(qQCircleEnvHub$UserInfo.pushEffectStartTime.get(), qQCircleEnvHub$UserInfo.pushEffectEndTime.get()));
    }

    private void initUserEnv(byte[] bArr) {
        QLog.d(TAG, 1, "\u521d\u59cb\u5316\u7528\u6237\u914d\u7f6e\u4fe1\u606f");
        try {
            QQCircleEnvHub$GetUserFullEnvRsp qQCircleEnvHub$GetUserFullEnvRsp = new QQCircleEnvHub$GetUserFullEnvRsp();
            qQCircleEnvHub$GetUserFullEnvRsp.mergeFrom(bArr);
            QCircleHostGlobalInfo.setUserInfo(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
            updateQQVip(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
            QCircleTipsConfig.getInstance().initTipsConfig(qQCircleEnvHub$GetUserFullEnvRsp);
            QCircleUserLabelConfig.INSTANCE.updateLabel(qQCircleEnvHub$GetUserFullEnvRsp);
            QCircleHostGlobalInfo.setIsLostUser(qQCircleEnvHub$GetUserFullEnvRsp.userLayerInfo.isHaveLostUser.get());
            initPushEffect(qQCircleEnvHub$GetUserFullEnvRsp);
            updateUserAvatarAndNick(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
            updatePersonalRecommendSwitchPanel(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
            QFSCommentEffectConfig.saveCommentEffectInfo(qQCircleEnvHub$GetUserFullEnvRsp.commentEffectInfo);
            updateRecentlyShareExp(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
            updateMultiSharePanelConfig(qQCircleEnvHub$GetUserFullEnvRsp.userInfo);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    private void initWinkConfig(PBStringField pBStringField) {
        boolean z16 = true;
        boolean z17 = false;
        try {
            String str = pBStringField.get();
            QLog.i(TAG, 1, "[initWinkConfig], config=" + str);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeInt(QQWinkConstants.KEY_VIDEO_EDIT_MAX_DURATION_SEC, jSONObject.optInt("qqcircle_editor_max_export_duration_sec", 0)).encodeInt(QQWinkConstants.KEY_VIDEO_UPLOAD_FILE_SIZE_LIMIT_BYTES, jSONObject.optInt("qqcircle_upload_filesize_limit_byte", 0)).commitAsync();
            } else {
                z16 = false;
            }
            z17 = z16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "initWinkConfig error", e16);
        }
        if (!z17) {
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).removeKey(QQWinkConstants.KEY_VIDEO_EDIT_MAX_DURATION_SEC).removeKey(QQWinkConstants.KEY_VIDEO_UPLOAD_FILE_SIZE_LIMIT_BYTES).commitAsync();
        }
    }

    private boolean isQCircleShowEntrance() {
        if (!uq3.c.x6(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && !uq3.c.M6()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLoginScene$3(final int i3, final String str, final String str2, final FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg) {
        sHandler.post(new Runnable() { // from class: cooperation.qqcircle.eevee.b
            @Override // java.lang.Runnable
            public final void run() {
                QCircleEeveeMananger.this.lambda$handleLoginScene$2(i3, str, str2, feedCloudEeveeUndealmsg$SignalMsg);
            }
        });
    }

    private boolean needDelaySend(long j3, int i3) {
        if (j3 < 1500 && i3 != 5 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_eevee_delay_request", true)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponse(@NonNull BaseRequest baseRequest, FeedCloudEeveeUndealmsg$FcUndealMsgsRsp feedCloudEeveeUndealmsg$FcUndealMsgsRsp, int i3) {
        int i16;
        if (feedCloudEeveeUndealmsg$FcUndealMsgsRsp != null) {
            List<FeedCloudEeveeUndealmsg$BizUndealMsg> list = feedCloudEeveeUndealmsg$FcUndealMsgsRsp.msgs.get();
            if (!list.isEmpty()) {
                for (FeedCloudEeveeUndealmsg$BizUndealMsg feedCloudEeveeUndealmsg$BizUndealMsg : list) {
                    handleBizUndealMsg(baseRequest, feedCloudEeveeUndealmsg$BizUndealMsg, i3, feedCloudEeveeUndealmsg$FcUndealMsgsRsp.intervalCtl);
                    QCircleLpReportDc010001.DataBuilder actionType = new QCircleLpReportDc010001.DataBuilder().setActionType(500);
                    if (i3 == 1000) {
                        i16 = 15;
                    } else {
                        i16 = 20;
                    }
                    QCircleLpReportDc010001.report(actionType.setSubActionType(i16).setThrActionType(1).setEeveeMsgId(feedCloudEeveeUndealmsg$BizUndealMsg.msgid.get()).setScene(i3));
                }
            }
            saveInterval(feedCloudEeveeUndealmsg$FcUndealMsgsRsp.intervalCtl);
            QLog.i(TAG, 2, "attachInfo size = " + feedCloudEeveeUndealmsg$FcUndealMsgsRsp.attachInfo.get().size() + "\uff0cvisitScene = " + i3);
            saveAttachInfo(baseRequest, feedCloudEeveeUndealmsg$FcUndealMsgsRsp.attachInfo.get());
            return;
        }
        QLog.e(TAG, 1, "onResponse visitScene = " + i3 + ", fcUndealMsgsRsp == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSendInner, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$onSend$1(int i3, String str, String str2) {
        if (!isQCircleShowEntrance()) {
            if (5 == i3) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.3
                    @Override // java.lang.Runnable
                    public void run() {
                        uq3.c.h7("qqcircle", "qqcircle_show_entrance_on_recommend_tab", "1");
                        uq3.c.h7("qqcircle", "qqcircle_show_entrance_on_message_tab", "1");
                    }
                });
                QLog.e(TAG, 1, "visitScene = " + i3 + " isQQCircleShow= " + isQCircleShowEntrance());
            } else {
                QLog.e(TAG, 1, " isQQCircleShow= " + isQCircleShowEntrance());
                return;
            }
        }
        if (i3 == 999 && isBackGround()) {
            scheduleEeveeTask();
            return;
        }
        FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg = new FeedCloudEeveeUndealmsg$SignalMsg();
        if (checkNeedBlock(i3, str, str2, feedCloudEeveeUndealmsg$SignalMsg)) {
            return;
        }
        lambda$handleLoginScene$2(i3, str, str2, feedCloudEeveeUndealmsg$SignalMsg);
    }

    private void parseClockInImages(@NonNull TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel, @NonNull QFSClockInBean qFSClockInBean) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : taskCenterReader$EeveeMyFuel.clockInInfo.images.get()) {
            if (QFSClockInBean.KEY_CLOCK_LOCKED_IMG.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setLockedImgUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_UNLOCKED_IMG.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setUnLockedImgUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_BACK_PLATE_FINISHED.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setBackPlateFinishedUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_BACK_PLATE_SIGNED.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setBackPlateSignedUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_BACK_PLATE_NUMBER.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setBackPlateNumberUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_LOCKED_TO_SIGNED_RESOURCE.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setLockedToSignedUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_LOCKED_TO_FINISHED_RESOURCE.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setLockedToFinishedUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_FINISHED_REFRESHING_RESOURCE.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setFinishedRefreshUrl(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_SIGNED_REFRESHING_RESOURCE.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setSignedRefreshingUrl(feedCloudCommon$Entry.value.get());
            }
        }
    }

    private void parseClockInTexts(@NonNull TaskCenterReader$EeveeMyFuel taskCenterReader$EeveeMyFuel, @NonNull QFSClockInBean qFSClockInBean) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : taskCenterReader$EeveeMyFuel.clockInInfo.texts.get()) {
            if (QFSClockInBean.KEY_CLOCK_LOCKED_TEXT.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setClockedText(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_SIGNED_TEXT.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setSignedText(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_NUMBER_TEXT.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setExpandClockText(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_BACK_PLATE_NUMBER_TEXT.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setCollapseClockText(feedCloudCommon$Entry.value.get());
            } else if (QFSClockInBean.KEY_CLOCK_SLIDE_TEXT.equals(feedCloudCommon$Entry.key.get())) {
                qFSClockInBean.setSlideText(feedCloudCommon$Entry.value.get());
            }
        }
    }

    private void parsePreloadFeedAttachInfo(@NonNull BaseRequest baseRequest, List<FeedCloudEeveeBase$StEeveeAttachInfo> list) {
        if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn() && list != null && list.size() != 0) {
            Iterator<FeedCloudEeveeBase$StEeveeAttachInfo> it = list.iterator();
            while (it.hasNext()) {
                FeedCloudEeveeBase$StEeveeAttachInfo next = it.next();
                if (next != null) {
                    if (ATTACH_INFO_KEY_PRELOAD_ALL_PUSH.equals(next.key.get())) {
                        ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).parsePreloadRspByte(baseRequest.getTraceId(), next.busiData.get().toByteArray(), 10);
                        it.remove();
                        QLog.d(getColdBootTag(), 1, "parsePreloadFeedAttachInfo find all push preload rsp");
                    } else if (ATTACH_INFO_KEY_PRELOAD_FRIEND.equals(next.key.get())) {
                        ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).parsePreloadRspByte(baseRequest.getTraceId(), next.busiData.get().toByteArray(), 75);
                        it.remove();
                        QLog.d(getColdBootTag(), 1, "parsePreloadFeedAttachInfo find friend preload rsp");
                    }
                }
            }
        }
    }

    private void printRedPointInfo(FeedCloudEeveeUndealmsg$BizUndealMsg feedCloudEeveeUndealmsg$BizUndealMsg, List<QQCircleCounter$RedPointInfo> list) {
        Iterator<QQCircleCounter$RedPointInfo> it = list.iterator();
        while (it.hasNext()) {
            QLog.d(TAG, 1, "[handleBizUndealMsg] receive redpoint. appid: " + buildLogInfo(feedCloudEeveeUndealmsg$BizUndealMsg.msgid.get(), it.next()));
        }
    }

    public static void releaseInstance() {
        QLog.e(TAG, 1, "releaseInstance");
        if (mInstance != null) {
            synchronized (QCircleEeveeMananger.class) {
                if (mInstance != null) {
                    QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(mInstance.mQQFrontBackListener);
                    sHandler.removeCallbacks(mInstance.mPollingTask);
                    mInstance = new QCircleEeveeMananger();
                }
            }
        }
    }

    private void resetAccountInfo() {
        QCircleEeveeAttachInfoHelper.getInstance().clearMemoryInfo();
        QCircleChatBoxHelper.releaseInstance();
        QCircleHostGlobalInfo.clearMemoryInfo();
        QCircleHostRedPointHelper.clearPedPoint();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_layer_enable_db_red_point", true)) {
            QCircleHostRedPointHelper.loadRedPointFromDB();
        }
        QCircleVVGameHelper.INSTANCE.resetInfo();
        QCircleSilenceInsertHelper.getInstance().clear();
        QCircleSecurityStatusUtil.clearBeatInfoList();
    }

    private void rewriteBubbleExpiredTime(@NonNull List<QQCircleCounter$RedPointInfo> list, long j3) {
        Iterator<QQCircleCounter$RedPointInfo> it = list.iterator();
        while (it.hasNext()) {
            QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble = it.next().allPushInfo.styleBottomTab.bubble;
            if (!qQCircleCounterStyle$StyleBubble.has()) {
                return;
            }
            long j16 = qQCircleCounterStyle$StyleBubble.expireTime.get();
            if (j3 < 0) {
                j3 = this.mPollingInterval;
            }
            long serverTime = (j3 / 1000) + NetConnInfoCenter.getServerTime();
            QLog.i(TAG, 1, "rewriteBubbleExpiredTime, expireTime=" + j16 + ",pollingInterval=" + j3 + ", localExpireTime=" + serverTime);
            qQCircleCounterStyle$StyleBubble.expireTime.set(Math.min(j16, serverTime));
        }
    }

    private void saveAttachInfo(@NonNull BaseRequest baseRequest, List<FeedCloudEeveeBase$StEeveeAttachInfo> list) {
        if (list != null && list.size() != 0) {
            parsePreloadFeedAttachInfo(baseRequest, list);
            QCircleEeveeAttachInfoHelper.getInstance().setEeveeAttachInfos(list);
        }
    }

    private void saveInterval(FeedCloudEeveeUndealmsg$IntervalControl feedCloudEeveeUndealmsg$IntervalControl) {
        if (feedCloudEeveeUndealmsg$IntervalControl == null) {
            return;
        }
        int i3 = feedCloudEeveeUndealmsg$IntervalControl.pollingInterval.get();
        if (i3 > 0) {
            this.mPollingInterval = i3 * 1000;
        }
        int i16 = feedCloudEeveeUndealmsg$IntervalControl.sceneSwitchInterval.get();
        if (i16 > 0) {
            this.mSceneSwitchInterval = i16 * 1000;
        }
        int i17 = feedCloudEeveeUndealmsg$IntervalControl.homeSwitchInterval.get();
        if (i17 > 0) {
            this.mHomeSwitchInterval = i17 * 1000;
        }
        QLog.e(TAG, 1, "saveInterval pollingInterval= " + i3 + "sceneSwitchInterval =" + i16 + "homeSwitchInterval" + i17);
    }

    private void saveRedPointInfoToSP(int i3, @NonNull List<QQCircleCounter$RedPointInfo> list) {
        if (i3 != 106) {
            return;
        }
        QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp = new QQCircleCounter$CountInfoRsp();
        qQCircleCounter$CountInfoRsp.rptRedPoint.set(list);
        QLog.i(TAG, 1, "[saveRedPointInfoToSP] uin: " + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        k.a().k("QFS_OUT_LAYER_RED_POINT_DATA", qQCircleCounter$CountInfoRsp.toByteArray());
    }

    private void scheduleEeveeTask() {
        boolean isBackGround = isBackGround();
        QLog.d(TAG, 1, "scheduleEeveeTask pollingInterval= " + this.mPollingInterval + " isBackGround= " + isBackGround);
        if (isBackGround) {
            return;
        }
        MqqHandler mqqHandler = sHandler;
        mqqHandler.removeCallbacks(this.mPollingTask);
        mqqHandler.postDelayed(this.mPollingTask, this.mPollingInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendToServer, reason: merged with bridge method [inline-methods] */
    public void lambda$handleLoginScene$2(final int i3, String str, final String str2, FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg) {
        int i16;
        FeedCloudEeveeBase$ClientInfo feedCloudEeveeBase$ClientInfo = new FeedCloudEeveeBase$ClientInfo();
        feedCloudEeveeBase$ClientInfo.clientAppVersion.set(QUA.getQUA3());
        if (QCircleReportHelper.isQQCircleActive()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        final QCircleEeveeUndealMsgRequest qCircleEeveeUndealMsgRequest = new QCircleEeveeUndealMsgRequest(feedCloudEeveeBase$ClientInfo, i3, i16, feedCloudEeveeUndealmsg$SignalMsg, getEeeveeAttachInfo());
        QLog.e(TAG, 1, "request traceid" + qCircleEeveeUndealMsgRequest.getTraceId() + "visitScene= " + i3 + " extinfo =" + str + " msgId = " + str2 + " isQQCircleActive() = " + QCircleReportHelper.isQQCircleActive());
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_save_last_request_time_immediately", true)) {
            sLastRequestTime = System.currentTimeMillis();
        }
        VSNetworkHelper.getInstance().sendRequest(qCircleEeveeUndealMsgRequest, new VSDispatchObserver.OnVSRspCallBack<FeedCloudEeveeUndealmsg$FcUndealMsgsRsp>() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.4
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str3, final FeedCloudEeveeUndealmsg$FcUndealMsgsRsp feedCloudEeveeUndealmsg$FcUndealMsgsRsp) {
                if (z16 && QCircleEeveeMananger.mInstance != null) {
                    if (Looper.myLooper() == null || !Looper.myLooper().equals(Looper.getMainLooper())) {
                        QCircleEeveeMananger.this.onResponse(qCircleEeveeUndealMsgRequest, feedCloudEeveeUndealmsg$FcUndealMsgsRsp, i3);
                    } else {
                        QCircleEeveeMananger.sHandler.post(new Runnable() { // from class: cooperation.qqcircle.eevee.QCircleEeveeMananger.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                QCircleEeveeMananger.this.onResponse(qCircleEeveeUndealMsgRequest, feedCloudEeveeUndealmsg$FcUndealMsgsRsp, i3);
                            }
                        });
                    }
                    QLog.d(QCircleEeveeMananger.TAG, 1, "onReceive retCode= " + j3 + ", errMsg= " + str3 + ", mInstance= " + QCircleEeveeMananger.mInstance + ", trace_id= " + qCircleEeveeUndealMsgRequest.getTraceId());
                    return;
                }
                QLog.e(QCircleEeveeMananger.TAG, 1, "onReceive retCode= " + j3 + ", errMsg= " + str3 + ", mInstance= " + QCircleEeveeMananger.mInstance);
                if (i3 == 1000) {
                    QCircleLpReportDc010001.report(new QCircleLpReportDc010001.DataBuilder().setActionType(500).setSubActionType(15).setThrActionType(2).setEeveeMsgId(str2).setScene(i3));
                }
            }
        });
        scheduleEeveeTask();
    }

    private void switchLogin() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disenable_same_account_clear_eevee_cache", true);
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        QLog.d(TAG, 1, "switchLogin disableClearCache: " + isSwitchOn + "uin: " + account + "last uin" + this.mLastUin);
        if (isSwitchOn && TextUtils.isEmpty(this.mLastUin)) {
            this.mLastUin = account;
            return;
        }
        if (isSwitchOn && TextUtils.equals(this.mLastUin, account)) {
            return;
        }
        releaseInstance();
        resetAccountInfo();
        ((IQCircleColdBootServiceV2) QRoute.api(IQCircleColdBootServiceV2.class)).release();
        getInstance().mLastUin = account;
    }

    private void updateMultiSharePanelConfig(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        boolean z16;
        if (qQCircleEnvHub$UserInfo == null) {
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_multi_share_panel", true);
        if (isSwitchOn) {
            z16 = true;
        } else {
            z16 = false;
        }
        QCircleHostGlobalInfo.setIsEnableMultiShare(z16);
        QLog.d(TAG, 1, "[updateMultiSharePanelConfig] isInMultiShareExp: true, isSwitchOn: " + isSwitchOn);
    }

    private void updatePersonalRecommendSwitchPanel(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        if (qQCircleEnvHub$UserInfo.isCloseRecommend.get()) {
            int i3 = qQCircleEnvHub$UserInfo.recommendMaxToastTime.get();
            k.a().j("sp_key_personal_recommend_switch_open", false);
            k.a().m("sp_key_personal_recommend_switch_panel_should_show_times", i3);
            QLog.d(TAG, 1, "[updatePersonalRecommendSwitchPanel] shouldShowTimes =" + i3);
            if (i3 != 0) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalRecommendSwitchClosedEvent());
                return;
            }
            return;
        }
        k.a().j("sp_key_personal_recommend_switch_open", true);
        QLog.d(TAG, 1, "[updatePersonalRecommendSwitchPanel] personal recommend switch is open");
        k.a().m("sp_key_personal_recommend_switch_panel_should_show_times", 0);
    }

    private void updateQQVip(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        int i3;
        boolean z16 = false;
        if (qQCircleEnvHub$UserInfo != null) {
            VipInfoForBusiness vipInfoForBusiness = new VipInfoForBusiness(qQCircleEnvHub$UserInfo.uid.get());
            vipInfoForBusiness.fromBuffer(qQCircleEnvHub$UserInfo.qq_vip.get().toByteArray());
            i3 = vipInfoForBusiness.getNameplateType();
        } else {
            i3 = 0;
        }
        QLog.d(TAG, 1, "[updateQQVip] nameplateType = " + i3);
        if (i3 > 0) {
            z16 = true;
        }
        QCircleHostGlobalInfo.setQQVip(z16);
    }

    private void updateRecentlyShareExp(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        uq3.c.j7(qQCircleEnvHub$UserInfo.sharePanelRecentFirst.get());
    }

    private void updateUserAvatarAndNick(QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo) {
        if (qQCircleEnvHub$UserInfo == null) {
            return;
        }
        QLog.d(TAG, 1, "\u66f4\u65b0\u7528\u6237\u5934\u50cf\u548c\u6635\u79f0\uff0c\u4ee5\u53ca\u4f1a\u5458\u4fe1\u606f");
        String str = qQCircleEnvHub$UserInfo.headUrl.get();
        if (!TextUtils.isEmpty(str)) {
            uq3.c.d7(str);
        }
        String str2 = qQCircleEnvHub$UserInfo.nickname.get();
        if (!TextUtils.isEmpty(str2)) {
            uq3.c.g7(str2);
        }
        PBBytesField pBBytesField = qQCircleEnvHub$UserInfo.qq_vip;
        if (pBBytesField != null) {
            uq3.c.k7(pBBytesField.get().toByteArray());
        }
        initWinkConfig(qQCircleEnvHub$UserInfo.publishConfig);
    }

    public void deleteAllRecomAutoTemplateData() {
        deleteBizUndealMsgBuffer(110);
    }

    public void deleteBizUndealMsgBuffer(int i3) {
        QLog.e(TAG, 1, "deleteBizUndealMsgBuffer type=" + i3);
        if (getmEm() != null) {
            synchronized (dbLock) {
                getmEm().delete(SingleUndealMsg.class.getSimpleName(), "mType = ?", new String[]{i3 + ""});
            }
        }
    }

    public void deleteOneRecomAutoTemplateData(String str) {
        byte[] bizUndealMsgBuffer;
        boolean z16;
        if (!TextUtils.isEmpty(str) && (bizUndealMsgBuffer = getBizUndealMsgBuffer(110)) != null) {
            try {
                FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
                feedCloudRead$StGetFeedListRsp.mergeFrom(bizUndealMsgBuffer);
                List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
                if (list.size() == 0) {
                    return;
                }
                QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
                qQCircleDitto$StCircleDittoDataNew.mergeFrom(list.get(0).dittoFeed.dittoDataNew.get().toByteArray());
                List<QQCircleDitto$StItemInfo> list2 = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get();
                if (list2 == null) {
                    return;
                }
                Iterator<QQCircleDitto$StItemInfo> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        QQCircleDitto$StItemInfo next = it.next();
                        if (str.equals(next.f429300id.get())) {
                            list2.remove(next);
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    list.get(0).dittoFeed.dittoDataNew.set(ByteStringMicro.copyFrom(qQCircleDitto$StCircleDittoDataNew.toByteArray()));
                    saveBizUndealMsgBuffer(110, feedCloudRead$StGetFeedListRsp.toByteArray());
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "deleteRecomAutoTemplateData " + e16);
            }
        }
    }

    public byte[] getBizUndealMsgBuffer(int i3) {
        QLog.e(TAG, 1, "getBizUndealMsgBuffer type=" + i3);
        if (getmEm() != null) {
            List<? extends Entity> query = getmEm().query(SingleUndealMsg.class, SingleUndealMsg.class.getSimpleName(), true, "mType = ?", new String[]{i3 + ""}, (String) null, (String) null, (String) null, (String) null);
            if (query != null && query.size() > 0) {
                return ((SingleUndealMsg) query.get(0)).mBizBufferData;
            }
            return null;
        }
        return null;
    }

    public void handleCommonDialog(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog = new FeedCloudCommonDialog$Dialog();
            feedCloudCommonDialog$Dialog.mergeFrom(bArr);
            int i3 = feedCloudCommonDialog$Dialog.dialog_type.get();
            if (i3 != 1 && (i3 != 2 || TextUtils.isEmpty(feedCloudCommonDialog$Dialog.content.get()))) {
                if (i3 == 0) {
                    QFSTeenModeConfig.setIsNeedShowTeenModeWindow(false);
                    QLog.d(TAG, 1, "Don't Need show TeenMode Window.");
                    return;
                }
                return;
            }
            QFSTeenModeConfig.setIsNeedShowTeenModeWindow(true);
            QFSTeenModeConfig.setTeenModeDialogRsp(feedCloudCommonDialog$Dialog);
            QLog.d(TAG, 1, "Need show TeenMode Window, dialogType = " + i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void handlePushData(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "pushData == null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "qcircle pushdata:" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("msgMainType");
            int optInt2 = jSONObject.optInt("msgSubType");
            if (optInt != 104) {
                if (optInt == 118 && optInt2 == 118001) {
                    handleDialogData(jSONObject);
                    return;
                }
                return;
            }
            switch (optInt2) {
                case 1040001:
                    String optString = jSONObject.optString("pushStr");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        long optLong = jSONObject2.optLong("pushTime");
                        if (optLong > QCircleHostConfig.getPushFuleCountTime()) {
                            int optInt3 = jSONObject2.optInt("myFuelValue");
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "handleFuelData fuelcount:" + optInt3);
                            }
                            QCircleConfig.getInstance().saveFuleCount(optInt3);
                            QCircleHostConfig.savePushFuleCountTime(optLong);
                            return;
                        }
                        return;
                    }
                    return;
                case 1040002:
                    String optString2 = jSONObject.optString("pushStr");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject3 = new JSONObject(optString2);
                        QFSPushConfig.setCurrentUin(getAccount());
                        String optString3 = jSONObject3.optString("toast_text");
                        QFSPushConfig.saveRocketChargeTipsText(optString3);
                        QFSPushConfig.saveRocketChargeTipsShowCountLimit(jSONObject3.optInt("toast_count"));
                        SimpleEventBus.getInstance().dispatchEvent(new QFSPushRocketChargeTipsEvent(optString3));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[handlePushData] e = " + e16);
        }
    }

    public boolean isBackGround() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).isBackgroundPause;
    }

    public void onSend(final int i3, final String str, final String str2) {
        if (i3 == 4) {
            switchLogin();
        }
        long currentTimeMillis = System.currentTimeMillis() - sLastRequestTime;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_save_last_request_time_immediately", true)) {
            sLastRequestTime = System.currentTimeMillis();
        }
        if (needDelaySend(currentTimeMillis, i3)) {
            QLog.d(TAG, 1, "on send delayed visitScene: " + i3 + " interval: " + currentTimeMillis);
            sHandler.postDelayed(new Runnable() { // from class: cooperation.qqcircle.eevee.c
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleEeveeMananger.this.lambda$onSend$0(i3, str, str2);
                }
            }, 1500 - currentTimeMillis);
            return;
        }
        sHandler.post(new Runnable() { // from class: cooperation.qqcircle.eevee.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleEeveeMananger.this.lambda$onSend$1(i3, str, str2);
            }
        });
    }

    public void refreshRedPoint() {
        QLog.d(TAG, 1, "refreshRedPoint");
        sLastPollingTime = 0L;
        onSend(999, null, null);
    }

    public void saveBizUndealMsgBuffer(int i3, byte[] bArr) {
        QLog.e(TAG, 1, "saveBizUndealMsgBuffer type=" + i3);
        SingleUndealMsg singleUndealMsg = new SingleUndealMsg(i3, bArr);
        if (getmEm() != null) {
            synchronized (dbLock) {
                getmEm().delete(SingleUndealMsg.class.getSimpleName(), "mType = ?", new String[]{singleUndealMsg.mType + ""});
                getmEm().persistOrReplace(singleUndealMsg);
            }
        }
    }
}

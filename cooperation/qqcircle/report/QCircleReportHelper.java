package cooperation.qqcircle.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetSessionInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.intercept.QCircleDc05501Interceptor;
import cooperation.qqcircle.report.intercept.QCircleDc05504Interceptor;
import cooperation.qqcircle.report.intercept.QCircleDc05507Interceptor;
import cooperation.qqcircle.report.intercept.QCircleDc05530Interceptor;
import cooperation.qqcircle.report.intercept.QCircleDc05531Interceptor;
import cooperation.qqcircle.report.intercept.QCircleDcBaseInterceptor;
import cooperation.qqcircle.report.requests.QCircleHeartbeatSignalReportRequest;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudRead$StGetSessionInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleReport$SingleDcData;
import qqcircle.QQCircleReport$StHeartbeatSignalRsp;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportHelper {
    private static final Map<Integer, QCircleDcBaseInterceptor> DC_REPORT_INTERCEPTOR_MAP = new HashMap();
    public static final String MAP_KEY_CIRCLE_INVITE_ID = "circle_invite";
    public static final String MAP_KEY_COMMON_REPORT_INFO = "CommExtReportInfo";
    public static final String MAP_KEY_FEED_REPORT_INFO = "FeedReportInfo";
    public static final String MAP_KEY_MSG_REPORT_INFO = "MsgReportInfo";
    public static final String MAP_KEY_SESSION = "SessionID";
    public static final String MAP_KEY_SHOW_AI_COMMENT_AGREE_DIALOG = "showAiCommentAgreeDialog";
    public static final String MAP_KEY_SUB_SESSION = "SubSessionID";
    private static final int REPORT_HEAER_BEAT_INTERVAL_TIME = 600000;
    public static final int SCENE_MAIN_PAGE = 0;
    public static final int SCENE_PAGE_AVATAR_APERTURE = 1053;
    public static final int SCENE_PAGE_ID_ALL_PUSH = 3;
    public static final int SCENE_PAGE_ID_BACK_FLOW_SPLASH_PAGE = 94;
    public static final int SCENE_PAGE_ID_BIG_GALLERY = 101;
    public static final int SCENE_PAGE_ID_COMMENT_PAGE = 61;
    public static final int SCENE_PAGE_ID_CONTENT_PAGE = 57;
    public static final int SCENE_PAGE_ID_DRAFT_PAGE = 33;
    public static final int SCENE_PAGE_ID_FEED_DETAIL_PAGE = 69;
    public static final int SCENE_PAGE_ID_FEED_RELATE_REC_PAGE = 1100;
    public static final int SCENE_PAGE_ID_FOLLOW = 1;
    public static final int SCENE_PAGE_ID_FRIEND_PUBLIC_ACCOUNTS_PAGE = 86;
    public static final int SCENE_PAGE_ID_HOT_EVENT_POLYMERIZATION_PAGE = 303;
    public static final int SCENE_PAGE_ID_HOT_EVENT_RANK_PAGE = 302;
    public static final int SCENE_PAGE_ID_LAYER_GAME = 97;
    public static final int SCENE_PAGE_ID_LBS_POLYMERIZATION_PAGE = 73;
    public static final int SCENE_PAGE_ID_MESSAGE_BOX = 92;
    public static final int SCENE_PAGE_ID_MESSAGE_PAGE = 59;
    public static final int SCENE_PAGE_ID_MORE_SETTING_PAGE = 95;
    public static final int SCENE_PAGE_ID_NEARBY = 91;
    public static final int SCENE_PAGE_ID_NEW_FEED_DETAIL_PAGE = 691;
    public static final int SCENE_PAGE_ID_NEW_FRIEND_PAGE = 90;
    public static final int SCENE_PAGE_ID_NEW_LAYER_ALL_PUSH = 503;
    public static final int SCENE_PAGE_ID_NEW_LAYER_FOLLOW = 501;
    public static final int SCENE_PAGE_ID_NEW_LAYER_NEARBY = 591;
    public static final int SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_GROUP_PAGE = 831;
    public static final int SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE = 851;
    public static final int SCENE_PAGE_ID_PAT_NAME_POLYMERIZATION_PAGE = 72;
    public static final int SCENE_PAGE_ID_PERSONAL_DETAIL_PAGE = 32;
    public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_PAGE = 89;
    public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_TOPIC_PAGE = 88;
    public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_FRIEND_PAGE = 84;
    public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_GROUP_PAGE = 83;
    public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_QZONE_PAGE = 85;
    public static final int SCENE_PAGE_ID_PUBLIC_ACCOUNT_FOLLOWING_PAGE = 307;
    public static final int SCENE_PAGE_ID_PUBLIC_ACCOUNT_PAGE = 301;
    public static final int SCENE_PAGE_ID_PUBLIC_ACCOUNT_PROFILE_PAGE = 304;
    public static final int SCENE_PAGE_ID_PUBLIC_ACCOUNT_PROFILE_SETTING_PAGE = 305;
    public static final int SCENE_PAGE_ID_PUBLIC_ACCOUNT_STAGGERED_PAGE = 306;
    public static final int SCENE_PAGE_ID_PUBLISH_PLUS = 36;
    public static final int SCENE_PAGE_ID_QQ_VIDEO = 200;
    public static final int SCENE_PAGE_ID_SEARCH_PAGE = 128;
    public static final int SCENE_PAGE_ID_SPLASH_PAGE = 82;
    public static final int SCENE_PAGE_ID_TAG_PAGE = 31;
    public static final int SCENE_PAGE_ID_TAG_POLYMERIZATION_PAGE = 71;
    public static final int SCENE_PAGE_ID_TROOP_AGGREGATION_PAGE = 70;
    public static final String TAG = "QCircleReportHelper";
    private static volatile QCircleReportHelper sInstance;
    private int mCurrentScene;
    private long mLastActiveTimestamp;
    private String mLaunchFrom;
    private String mLaunchId;
    private int mLaunchScene;
    private long mLaunchTimestamp;
    private volatile byte[] mOldSession;
    private HashMap<String, String> mSchemeAttrs;
    private int mSessionLifeCircle;
    private String mToUin;
    private final ConcurrentHashMap<Integer, byte[]> mSceneSubSessionMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, String> mInviteIdMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, String> mInviteUinMap = new ConcurrentHashMap<>();
    private final ArrayList<Integer> mPageStack = new ArrayList<>();
    private final ConcurrentHashMap<Integer, Long> mPageLifeMap = new ConcurrentHashMap<>();
    private boolean mIsForeground = false;
    private boolean mHasLaunchReport = false;
    private volatile byte[] mSession = null;
    private boolean mIsTabSelected = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class LaunchParam implements Parcelable {
        public static final Parcelable.Creator<LaunchParam> CREATOR = new Parcelable.Creator<LaunchParam>() { // from class: cooperation.qqcircle.report.QCircleReportHelper.LaunchParam.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchParam createFromParcel(Parcel parcel) {
                try {
                    return LaunchParam.wrap(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readHashMap(HashMap.class.getClassLoader()));
                } catch (Throwable th5) {
                    QLog.e(QCircleReportHelper.TAG, 1, th5, new Object[0]);
                    return null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaunchParam[] newArray(int i3) {
                return new LaunchParam[i3];
            }
        };
        public String launchFrom;
        public String launchId;
        public int launchScene;
        public HashMap<String, String> schemeAttrs;
        public String toUin;

        public static LaunchParam wrap(String str, String str2, String str3, int i3, HashMap<String, String> hashMap) {
            LaunchParam launchParam = new LaunchParam();
            launchParam.launchFrom = str;
            launchParam.launchId = str2;
            launchParam.toUin = str3;
            launchParam.launchScene = i3;
            launchParam.schemeAttrs = hashMap;
            return launchParam;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.launchFrom);
            parcel.writeString(this.launchId);
            parcel.writeString(this.toUin);
            parcel.writeInt(this.launchScene);
            parcel.writeMap(this.schemeAttrs);
        }
    }

    static {
        addFilterData(new QCircleDc05501Interceptor());
        addFilterData(new QCircleDc05504Interceptor());
        addFilterData(new QCircleDc05507Interceptor());
        addFilterData(new QCircleDc05530Interceptor());
        addFilterData(new QCircleDc05531Interceptor());
    }

    private static void addFilterData(QCircleDcBaseInterceptor qCircleDcBaseInterceptor) {
        DC_REPORT_INTERCEPTOR_MAP.put(Integer.valueOf(qCircleDcBaseInterceptor.getDcId()), qCircleDcBaseInterceptor);
    }

    private void checkNeedReportHeartBeat() {
        if (isQQCircleActive() && this.mLastActiveTimestamp > 0 && System.currentTimeMillis() - this.mLastActiveTimestamp >= 600000) {
            reportQCircleActiveIntervalTime(3);
            if (this.mIsForeground) {
                this.mLastActiveTimestamp = System.currentTimeMillis();
            }
        }
    }

    private void checkNeedReportLaunch() {
        String str;
        String str2;
        if (this.mHasLaunchReport || TextUtils.isEmpty(this.mLaunchFrom) || this.mSession == null) {
            return;
        }
        HashMap<String, String> hashMap = this.mSchemeAttrs;
        if (hashMap != null) {
            str = hashMap.get(QCircleReportFirstLogin.FEED_ID);
            str2 = this.mSchemeAttrs.get(QCircleReportFirstLogin.SHARE_ID);
        } else {
            str = "";
            str2 = str;
        }
        QCircleLpReportDc05493.report(this.mToUin, this.mLaunchFrom, this.mLaunchId, this.mLaunchTimestamp, this.mLaunchScene, str, str2);
        this.mHasLaunchReport = true;
    }

    private void checkSessionRetired() {
        if (this.mLastActiveTimestamp > 0 && System.currentTimeMillis() - this.mLastActiveTimestamp >= this.mSessionLifeCircle * 1000) {
            updateReportSessionWhenExpired();
        } else {
            this.mLastActiveTimestamp = System.currentTimeMillis();
        }
    }

    public static List<FeedCloudCommon$Entry> convertEntryList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(newEntry(it.next()));
        }
        return arrayList;
    }

    public static List<FeedCloudCommon$Entry> convertEntryListFromObjMap(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(newEntryObj(it.next()));
        }
        return arrayList;
    }

    public static void filterData(ArrayList<QQCircleReport$SingleDcData> arrayList) {
        QCircleDcBaseInterceptor qCircleDcBaseInterceptor;
        if (!c.P()) {
            QLog.d(TAG, 2, "close dc report intercept");
            return;
        }
        QLog.d(TAG, 2, "open dc report intercept");
        Iterator<QQCircleReport$SingleDcData> it = arrayList.iterator();
        while (it.hasNext()) {
            QQCircleReport$SingleDcData next = it.next();
            if (next != null && (qCircleDcBaseInterceptor = DC_REPORT_INTERCEPTOR_MAP.get(Integer.valueOf(next.dcid.get()))) != null) {
                qCircleDcBaseInterceptor.filter(next);
            }
        }
    }

    public static QCircleReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (QCircleReportHelper.class) {
                if (sInstance == null) {
                    sInstance = new QCircleReportHelper();
                }
            }
        }
        return sInstance;
    }

    public static String getNetworkType() {
        int networkType = NetworkState.getNetworkType();
        if (networkType == 0) {
            networkType = 9;
        }
        return String.valueOf(networkType);
    }

    public static int getQQCirclePageStackNum() {
        return getInstance().mPageStack.size();
    }

    private void handleInActivatedState() {
        if (isQQCircleActive()) {
            QLog.d(TAG, 1, "onQCircle enter activate state!");
            checkSessionRetired();
            this.mIsForeground = true;
        }
    }

    private void handleInDeactivatedState() {
        if (isQQCircleActive()) {
            QLog.d(TAG, 1, "onQCircle enter deactivate state!");
            reportQCircleActiveIntervalTime(2);
            QCircleReporter.getInstance().flush();
            this.mIsForeground = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportSessionRsp(FeedCloudRead$StGetSessionInfoRsp feedCloudRead$StGetSessionInfoRsp, int i3) {
        if (feedCloudRead$StGetSessionInfoRsp != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && 2 == feedCloudRead$StGetSessionInfoRsp.sessionType.get()) {
                        updateSubSession(36, feedCloudRead$StGetSessionInfoRsp.subSessonID.get().toByteArray());
                        return;
                    }
                    return;
                }
                if (1 == feedCloudRead$StGetSessionInfoRsp.sessionType.get()) {
                    this.mSession = feedCloudRead$StGetSessionInfoRsp.sessonID.get().toByteArray();
                    this.mSessionLifeCircle = feedCloudRead$StGetSessionInfoRsp.expireTime.get();
                    this.mLastActiveTimestamp = System.currentTimeMillis();
                    QLog.d(TAG, 1, "handleReportSessionRsp scene:EXPIRED\uff0cSession:" + new String(this.mSession));
                    return;
                }
                return;
            }
            if (1 == feedCloudRead$StGetSessionInfoRsp.sessionType.get()) {
                this.mSession = feedCloudRead$StGetSessionInfoRsp.sessonID.get().toByteArray();
                this.mSessionLifeCircle = feedCloudRead$StGetSessionInfoRsp.expireTime.get();
                long currentTimeMillis = System.currentTimeMillis();
                this.mLastActiveTimestamp = currentTimeMillis;
                this.mLaunchTimestamp = currentTimeMillis;
                checkNeedReportLaunch();
                if (this.mSession != null) {
                    QLog.d(TAG, 1, "handleReportSessionRsp scene:ENTRY_APP\uff0cSession:" + new String(this.mSession));
                    QCircleReporter.getInstance().reportCacheDataListToServerWithSession(this.mSession);
                }
            }
        }
    }

    private boolean isFolderPage(int i3) {
        if (1 == i3 || 3 == i3 || 91 == i3 || i3 == 0 || 501 == i3 || 503 == i3 || 591 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isQCircleNotFolderPageActive() {
        return getInstance().isInQCircleNotFolderPage();
    }

    public static boolean isQQCircleActive() {
        if (c.M6()) {
            return getInstance().mIsTabSelected;
        }
        if (getInstance().mPageStack.size() > 0) {
            return true;
        }
        return false;
    }

    public static FeedCloudCommon$Entry newEntry(Map.Entry<String, String> entry) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        if (entry.getKey() != null) {
            feedCloudCommon$Entry.key.set(entry.getKey());
        }
        if (entry.getValue() != null) {
            feedCloudCommon$Entry.value.set(entry.getValue());
        }
        return feedCloudCommon$Entry;
    }

    public static FeedCloudCommon$Entry newEntryObj(Map.Entry<String, Object> entry) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        if (entry.getKey() != null) {
            feedCloudCommon$Entry.key.set(entry.getKey());
        }
        if (entry.getValue() != null) {
            feedCloudCommon$Entry.value.set(entry.getValue().toString());
        }
        return feedCloudCommon$Entry;
    }

    public static QQCircleReport$SingleDcData newSingleDcData(int i3, List<FeedCloudCommon$Entry> list, List<FeedCloudCommon$Entry> list2, List<FeedCloudCommon$BytesEntry> list3) {
        QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
        qQCircleReport$SingleDcData.dcid.set(i3);
        if (list != null && !list.isEmpty()) {
            qQCircleReport$SingleDcData.report_data.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            qQCircleReport$SingleDcData.extinfo.addAll(list2);
        }
        if (list3 != null && !list3.isEmpty()) {
            qQCircleReport$SingleDcData.byteExtinfo.addAll(list3);
        }
        return qQCircleReport$SingleDcData;
    }

    private void printPageStack() {
        if (!this.mPageStack.isEmpty()) {
            QLog.d(TAG, 1, "printPageStack:" + Arrays.toString(this.mPageStack.toArray()));
        }
    }

    private void reportPageStayTime(int i3, boolean z16) {
        String str;
        Long l3 = this.mPageLifeMap.get(Integer.valueOf(i3));
        if (l3 != null && l3.longValue() > 0) {
            long j3 = this.mLaunchTimestamp;
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            long j16 = i3;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            QCircleLpReportDc05503.report(j3, currentTimeMillis, j16, str, "", "", "", "", "", i3);
            QLog.d(TAG, 1, "recordPageEndShow:scene:" + i3 + ",cost:" + (System.currentTimeMillis() - l3.longValue()) + "ms");
            this.mPageLifeMap.remove(Integer.valueOf(i3));
        }
    }

    private void reportQCircleActiveIntervalTime(int i3) {
        byte[] bArr;
        if (this.mLastActiveTimestamp != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mLastActiveTimestamp;
            this.mLastActiveTimestamp = 0L;
            QLog.w(TAG, 1, "reportQCircleActiveIntervalTime intervalTime:" + currentTimeMillis + "ms,signalOptType:" + i3);
            if (this.mSession == null) {
                bArr = this.mOldSession;
            } else {
                bArr = this.mSession;
            }
            VSNetworkHelper.getInstance().sendRequest(new QCircleHeartbeatSignalReportRequest(currentTimeMillis, i3, bArr), new VSDispatchObserver.OnVSRspCallBack<QQCircleReport$StHeartbeatSignalRsp>() { // from class: cooperation.qqcircle.report.QCircleReportHelper.2
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StHeartbeatSignalRsp qQCircleReport$StHeartbeatSignalRsp) {
                    if ((z16 && j3 == 0 && qQCircleReport$StHeartbeatSignalRsp != null) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    QLog.e(QCircleReportHelper.TAG, 1, "reportQCircleActiveIntervalTime error:" + str + ",traceId:" + baseRequest.getTraceId());
                }
            });
            printPageStack();
            checkNeedReportLaunch();
        }
    }

    private void requestReportSession(final int i3) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleGetSessionInfoRequest(null, i3), new VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSessionInfoRsp>() { // from class: cooperation.qqcircle.report.QCircleReportHelper.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetSessionInfoRsp feedCloudRead$StGetSessionInfoRsp) {
                if (z16 && j3 == 0 && feedCloudRead$StGetSessionInfoRsp != null) {
                    QCircleReportHelper.this.handleReportSessionRsp(feedCloudRead$StGetSessionInfoRsp, i3);
                    QLog.d(QCircleReportHelper.TAG, 1, "requestReportSession success!scene:" + i3);
                    return;
                }
                QLog.e(QCircleReportHelper.TAG, 1, "requestReportSession scene:" + i3 + ",retCode:" + j3 + ",error:" + str);
            }
        });
    }

    private void retireSession() {
        this.mOldSession = this.mSession;
        this.mSession = null;
        this.mSceneSubSessionMap.clear();
        this.mIsForeground = false;
    }

    public int getCurrentScene() {
        return this.mCurrentScene;
    }

    public String getInviteId() {
        return this.mInviteIdMap.get(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
    }

    public String getInviteUin() {
        return this.mInviteUinMap.get(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
    }

    public int getPageStackSize() {
        return this.mPageStack.size();
    }

    public void getPublishReportSession() {
        requestReportSession(3);
    }

    public byte[] getSession() {
        return this.mSession;
    }

    public byte[] getSubSession(int i3) {
        if (this.mSceneSubSessionMap.containsKey(Integer.valueOf(i3))) {
            return this.mSceneSubSessionMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    public List<FeedCloudCommon$BytesEntry> getTransferEntry(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            arrayList.add(newEntry(MAP_KEY_FEED_REPORT_INFO, bArr));
        }
        return arrayList;
    }

    public boolean hasValidSession() {
        if (this.mOldSession == null && this.mSession == null) {
            return false;
        }
        return true;
    }

    public void initReportSession() {
        QLog.w(TAG, 1, "initReportSession");
        this.mOldSession = null;
        requestReportSession(1);
    }

    public boolean isInQCircleNotFolderPage() {
        if (this.mPageStack.isEmpty()) {
            return false;
        }
        ArrayList<Integer> arrayList = this.mPageStack;
        return !isFolderPage(arrayList.get(arrayList.size() - 1).intValue());
    }

    public boolean isLaunchFromFolderPage() {
        if (this.mPageStack.size() < 1 || this.mPageStack.get(0).intValue() != 0) {
            return false;
        }
        return true;
    }

    public boolean isPageStackEmpty() {
        if ((!this.mPageStack.contains(0) || this.mPageStack.size() != 1) && this.mPageStack.size() != 0) {
            return false;
        }
        return true;
    }

    public List<FeedCloudCommon$Entry> newBaseEntries() {
        checkNeedReportHeartBeat();
        return new ArrayList(Arrays.asList(newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), newEntry("network_type", getNetworkType()), newEntry("app_version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName()), newEntry("qua", QUA.getQUA3()), newEntry("platform", "android"), newEntry("report_from", "1"), newEntry("os_version", Build.VERSION.RELEASE), newEntry("mobile_type", DeviceInfoMonitor.getModel()), newEntry("respond_type", QCircleHostStubUtil.getMobileResolution()), newEntry("device_info", Build.DEVICE), newEntry("idfa", ""), newEntry("idfv", "")));
    }

    public List<FeedCloudCommon$BytesEntry> newSessionEntries() {
        if (this.mSession != null) {
            return new ArrayList(Collections.singletonList(newEntry(MAP_KEY_SESSION, this.mSession)));
        }
        return null;
    }

    public void onEnterBackground() {
        QLog.d(TAG, 1, "onQQEnterBackground!");
        handleInDeactivatedState();
    }

    public void onEnterForeground() {
        QLog.d(TAG, 1, "onQQEnterForeground!");
        handleInActivatedState();
    }

    public void popPageScene(int i3) {
        if (i3 < 0) {
            return;
        }
        if (this.mPageStack.contains(Integer.valueOf(i3))) {
            this.mPageStack.remove(Integer.valueOf(i3));
            QLog.d(TAG, 1, "popPageScene success, scene: " + i3);
        } else {
            QLog.e(TAG, 1, "popPageScene error! mismatch scene: " + i3 + ", current Page:" + this.mPageStack);
        }
        if (this.mPageStack.size() == 0) {
            QLog.w(TAG, 1, "no QQCircle Page Alive, exit QQCircle and retire session.");
            retireSession();
            this.mPageLifeMap.clear();
            reportQCircleActiveIntervalTime(1);
        }
        printPageStack();
    }

    public void pushPageScene(int i3) {
        if (i3 < 0) {
            return;
        }
        this.mPageStack.add(Integer.valueOf(i3));
        QCircleReporter.getInstance().flush();
        QLog.d(TAG, 1, "pushPageScene success, scene: " + i3);
        printPageStack();
    }

    public void recordPageEndShow(int i3, boolean z16) {
        reportPageStayTime(i3, z16);
        QLog.d(TAG, 1, "recordPageEndShow:scene:" + i3 + ",hasActiveAction:" + z16);
    }

    public void recordPageStartShow(int i3) {
        this.mPageLifeMap.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        this.mCurrentScene = i3;
        QLog.d(TAG, 1, "recordPageStartShow:scene:" + i3);
    }

    public void setInviteId(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mInviteIdMap.remove(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
        } else {
            this.mInviteIdMap.put(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()), str);
        }
    }

    public void setInviteUin(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mInviteUinMap.remove(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
        } else {
            this.mInviteUinMap.put(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()), str);
        }
    }

    public void setLaunchParms(LaunchParam launchParam) {
        if (launchParam != null) {
            this.mHasLaunchReport = false;
            String str = launchParam.launchFrom;
            this.mLaunchFrom = str;
            this.mLaunchId = launchParam.launchId;
            this.mToUin = launchParam.toUin;
            this.mLaunchScene = launchParam.launchScene;
            this.mSchemeAttrs = launchParam.schemeAttrs;
            if (TextUtils.isEmpty(str)) {
                QLog.e(TAG, 1, "setLaunchParms invalid launchfrom params");
            }
            initReportSession();
            QLog.w(TAG, 1, "launchPageScene:" + this.mLaunchScene);
            checkNeedReportLaunch();
        }
    }

    public void setQCircleIsActivate(boolean z16) {
        this.mIsTabSelected = z16;
        if (z16) {
            handleInActivatedState();
        } else {
            handleInDeactivatedState();
        }
    }

    public void updateReportSessionWhenExpired() {
        QLog.d(TAG, 1, "updateReportSessionWhenExpired");
        requestReportSession(2);
    }

    public void updateSubSession(int i3, byte[] bArr) {
        this.mSceneSubSessionMap.put(Integer.valueOf(i3), bArr);
    }

    public List<FeedCloudCommon$BytesEntry> newSessionEntries(int i3) {
        return newSessionEntries(i3, null);
    }

    public List<FeedCloudCommon$BytesEntry> newSessionEntries(int i3, byte[] bArr) {
        return newSessionEntries(i3, bArr, null);
    }

    public List<FeedCloudCommon$BytesEntry> newSessionEntries(int i3, byte[] bArr, byte[] bArr2) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            arrayList.add(newEntry(MAP_KEY_FEED_REPORT_INFO, bArr));
        }
        if (bArr2 != null) {
            arrayList.add(newEntry(MAP_KEY_MSG_REPORT_INFO, bArr2));
        }
        if (this.mSession != null) {
            arrayList.add(newEntry(MAP_KEY_SESSION, this.mSession));
        } else if (this.mOldSession != null) {
            arrayList.add(newEntry(MAP_KEY_SESSION, this.mOldSession));
            QLog.w(TAG, 1, "newSessionEntries mSession retired!try use oldSession");
        } else {
            QLog.e(TAG, 1, "newSessionEntries mSession is null!");
        }
        if (getSubSession(i3) != null) {
            arrayList.add(newEntry(MAP_KEY_SUB_SESSION, getSubSession(i3)));
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static FeedCloudCommon$Entry newEntry(String str, String str2) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        if (str != null) {
            feedCloudCommon$Entry.key.set(str);
        }
        if (str2 != null) {
            feedCloudCommon$Entry.value.set(str2);
        }
        return feedCloudCommon$Entry;
    }

    public static FeedCloudCommon$BytesEntry newEntry(String str, byte[] bArr) {
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        if (str != null) {
            feedCloudCommon$BytesEntry.key.set(str);
        }
        if (bArr != null) {
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bArr));
        }
        return feedCloudCommon$BytesEntry;
    }

    public List<FeedCloudCommon$BytesEntry> newSessionEntries(int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        List<FeedCloudCommon$BytesEntry> newSessionEntries = newSessionEntries(i3, bArr, bArr2);
        if (newSessionEntries != null) {
            if (bArr3 == null) {
                return newSessionEntries;
            }
            newSessionEntries.add(newEntry(MAP_KEY_COMMON_REPORT_INFO, bArr3));
            return newSessionEntries;
        }
        if (bArr3 == null) {
            return newSessionEntries;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(newEntry(MAP_KEY_COMMON_REPORT_INFO, bArr3));
        return arrayList;
    }
}

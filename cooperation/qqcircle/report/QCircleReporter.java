package cooperation.qqcircle.report;

import NS_COMM.COMM;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qcircle.api.requests.CommandReportRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleClientReportRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTask;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import h20.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleReport$SingleDcData;
import qqcircle.QQCircleReport$StDataReportRsp;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReporter {
    private static final int MESSAGE_CHECK_SHOULD_IMMEDIATE_REPORT_TO_SERVER = 4098;
    private static final int MESSAGE_CHECK_SHOULD_REPORT_TO_SERVER = 4097;
    private static final int REPORT_COUNT_THRESHOLD_NORMAL;
    private static final int REPORT_COUNT_THRESHOLD_QUALITY;
    private static final long REPORT_IMMEDIATE_INTERVAL = 1000;
    private static final long REPORT_NORMAL_INTERVAL;
    private static final long REPORT_QUALITY_INTERVAL;
    public static final String TAG = "QCircleReporter";
    private static volatile QCircleReporter sInstance;
    private final CopyOnWriteArrayList<QCircleReportListener> mListeners = new CopyOnWriteArrayList<>();
    private List<QQCircleReport$SingleDcData> mNormalDataListPool = new ArrayList();
    private List<QQCircleReport$SingleDcData> mImmediateDataListPool = new ArrayList();
    private List<QQCircleReport$SingleDcData> mQualityDataListPool = new ArrayList();
    private List<APP_REPORT_TRANSFER.SingleDcData> mCommandListPool = new ArrayList();
    private List<QQCircleReport$SingleDcData> mReRankListPool = new ArrayList();
    private List<QQCircleReport$SingleDcData> mMissSessionDataListPool = new ArrayList();
    private long mLastReportTimeMillis = System.currentTimeMillis();
    private long mLastQualityReportTimeMillis = System.currentTimeMillis();
    private long mLastCommandReportTimeMillis = System.currentTimeMillis();
    private Handler reportHandler = RFWThreadManager.createNewThreadHandler("qqcircle_report", 10, new Handler.Callback() { // from class: cooperation.qqcircle.report.QCircleReporter.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i3 = message.what;
            if (i3 == 4097) {
                QCircleReporter.this.checkShouldReportToServer();
            } else if (i3 == 4098) {
                QCircleReporter.this.performImmediateDataListReportToServer();
                QCircleReporter.this.performReRankDataListReportToServer();
            }
            return false;
        }
    });

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface QCircleReportListener {
        void onAddReportData(int i3, List<FeedCloudCommon$Entry> list);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface QCircleReportRspCallback {
        void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp);
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        REPORT_NORMAL_INTERVAL = timeUnit.toMillis(c.Z3());
        REPORT_COUNT_THRESHOLD_NORMAL = c.Y3();
        REPORT_QUALITY_INTERVAL = timeUnit.toMillis(c.W3());
        REPORT_COUNT_THRESHOLD_QUALITY = c.V3();
    }

    QCircleReporter() {
        initOutbox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShouldImmediateReportToServer() {
        if (!this.reportHandler.hasMessages(4098)) {
            this.reportHandler.sendEmptyMessageDelayed(4098, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShouldReportToServer() {
        boolean z16;
        if (this.mNormalDataListPool.size() <= 0 && this.mQualityDataListPool.size() <= 0 && this.mCommandListPool.size() <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (System.currentTimeMillis() - this.mLastReportTimeMillis > REPORT_NORMAL_INTERVAL || this.mNormalDataListPool.size() >= REPORT_COUNT_THRESHOLD_NORMAL) {
                performNormalDataListReportToServer();
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mLastQualityReportTimeMillis;
            long j3 = REPORT_QUALITY_INTERVAL;
            if (currentTimeMillis > j3 || this.mQualityDataListPool.size() >= REPORT_COUNT_THRESHOLD_QUALITY) {
                performQualityDataListReportToServer();
            }
            if (System.currentTimeMillis() - this.mLastCommandReportTimeMillis > j3 || this.mCommandListPool.size() >= REPORT_COUNT_THRESHOLD_QUALITY) {
                performCommandDataListReportToServer();
            }
        }
        if (!this.reportHandler.hasMessages(4097)) {
            if (!z16 && System.currentTimeMillis() - this.mLastReportTimeMillis > REPORT_NORMAL_INTERVAL * 10) {
                QLog.w(TAG, 1, "[checkShouldReportToServer] stop check");
                return;
            }
            try {
                this.reportHandler.sendEmptyMessageDelayed(4097, REPORT_NORMAL_INTERVAL);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[checkShouldReportToServer] ex: ", th5);
            }
        }
    }

    private void flushVideoReport(final List<QQCircleReport$SingleDcData> list) {
        if (list != null && list.size() != 0) {
            this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.13
                @Override // java.lang.Runnable
                public void run() {
                    QCircleReporter.this.performVideoDataListReportToServer(list);
                }
            });
        } else {
            QLog.d(TAG, 1, "flushVideoReport data error");
        }
    }

    public static QCircleReporter getInstance() {
        if (sInstance == null) {
            synchronized (QCircleReporter.class) {
                if (sInstance == null) {
                    sInstance = new QCircleReporter();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyReportListener(QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        if (this.mListeners.size() > 0 && qQCircleReport$SingleDcData != null) {
            Iterator<QCircleReportListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onAddReportData(qQCircleReport$SingleDcData.dcid.get(), qQCircleReport$SingleDcData.report_data.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String parseCommandString(APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (singleDcData != null) {
            sb5.append("dcid:");
            sb5.append(singleDcData.dcid.get());
            sb5.append(",report_data:{");
            for (COMM.Entry entry : singleDcData.report_data.get()) {
                sb5.append(entry.key.get());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.value.get());
                sb5.append(", ");
            }
            if (singleDcData.extinfo.has()) {
                sb5.append("},byteExtInfo:{");
                Iterator<COMM.Entry> it = singleDcData.extinfo.get().iterator();
                while (it.hasNext()) {
                    sb5.append(it.next().key.get());
                    sb5.append(", ");
                }
            }
            sb5.append("}\n");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String parseString(QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        StringBuilder sb5 = new StringBuilder();
        if (qQCircleReport$SingleDcData != null) {
            sb5.append("dcid:");
            sb5.append(qQCircleReport$SingleDcData.dcid.get());
            sb5.append(",report_data:{");
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleReport$SingleDcData.report_data.get()) {
                if (feedCloudCommon$Entry != null && !TextUtils.isEmpty(feedCloudCommon$Entry.key.get())) {
                    sb5.append(feedCloudCommon$Entry.key.get());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(feedCloudCommon$Entry.value.get());
                    sb5.append(", ");
                }
            }
            if (qQCircleReport$SingleDcData.byteExtinfo.has()) {
                sb5.append("},byteExtInfo:{");
                for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : qQCircleReport$SingleDcData.byteExtinfo.get()) {
                    if (feedCloudCommon$BytesEntry != null && !TextUtils.isEmpty(feedCloudCommon$BytesEntry.key.get())) {
                        sb5.append(feedCloudCommon$BytesEntry.key.get());
                        sb5.append(", ");
                    }
                }
            }
            sb5.append("}\n");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performClientReport(final List<QQCircleReport$SingleDcData> list, final boolean z16) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list);
            QCircleReportHelper.filterData(arrayList);
            QCircleClientReportRequest qCircleClientReportRequest = new QCircleClientReportRequest(arrayList);
            QLog.d(TAG, 2, "[performClientReport] traceid:" + qCircleClientReportRequest.getTraceId());
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.d(TAG, 1, "performClientReport fail! network is not available,save in cache first");
                QCircleReportOutboxTaskQueue.getInstance().addPausedTask(new QCircleReportOutboxTask(qCircleClientReportRequest));
            } else {
                VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), qCircleClientReportRequest, new VSDispatchObserver.OnVSRspCallBack<QQCircleReport$StDataReportRsp>() { // from class: cooperation.qqcircle.report.QCircleReporter.4
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
                        if (z17 && j3 == 0 && qQCircleReport$StDataReportRsp != null) {
                            if (baseRequest != null) {
                                QLog.d(QCircleReporter.TAG, 4, "[performClientReport] performClientReport success, traceid:" + baseRequest.getTraceId());
                                return;
                            }
                            return;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            QLog.e(QCircleReporter.TAG, 1, "performClientReport error:" + str + ",traceId:" + baseRequest.getTraceId());
                        }
                        QCircleQualityReportResetManager.instance().handleReportFail(z16, list, baseRequest, j3, str);
                    }
                });
            }
        }
    }

    private void performCommandDataListReportToServer() {
        this.mLastCommandReportTimeMillis = System.currentTimeMillis();
        performCommandReport(this.mCommandListPool);
        this.mCommandListPool.clear();
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            QLog.d(TAG, 2, "performQualityDataListReportToServer called");
        }
    }

    private void performCommandReport(List<APP_REPORT_TRANSFER.SingleDcData> list) {
        if (list != null && list.size() > 0) {
            VSNetworkHelper.getInstance().sendRequest(new CommandReportRequest(list), new VSDispatchObserver.OnVSRspCallBack<APP_REPORT_TRANSFER.StDataReportRsp>() { // from class: cooperation.qqcircle.report.QCircleReporter.6
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, APP_REPORT_TRANSFER.StDataReportRsp stDataReportRsp) {
                    if (z16 && j3 == 0 && stDataReportRsp != null) {
                        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                            QLog.d(QCircleReporter.TAG, 2, "performCommandReport success!");
                        }
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        QLog.e(QCircleReporter.TAG, 1, "performCommandReport error:" + str + ",traceId:" + baseRequest.getTraceId());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performImmediateDataListReportToServer() {
        performClientReport(this.mImmediateDataListPool, false);
        this.mImmediateDataListPool.clear();
        QLog.d(TAG, 2, "performImmediateDataListReportToServer called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performNormalDataListReportToServer() {
        this.mLastReportTimeMillis = System.currentTimeMillis();
        performClientReport(this.mNormalDataListPool, false);
        this.mNormalDataListPool.clear();
        QLog.d(TAG, 2, "performNormalDataListReportToServer called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performQualityDataListReportToServer() {
        this.mLastQualityReportTimeMillis = System.currentTimeMillis();
        performClientReport(this.mQualityDataListPool, true);
        this.mQualityDataListPool.clear();
        QLog.d(TAG, 1, "performQualityDataListReportToServer called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performReRankDataListReportToServer() {
        performClientReport(this.mReRankListPool, false);
        this.mReRankListPool.clear();
        QLog.d(TAG, 2, "performReRankDataListReportToServer called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performVideoDataListReportToServer(List<QQCircleReport$SingleDcData> list) {
        performClientReport(list, false);
        for (QQCircleReport$SingleDcData qQCircleReport$SingleDcData : list) {
            if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                QLog.d(TAG, 2, "perform video Data:" + parseString(qQCircleReport$SingleDcData));
            }
        }
        QLog.d(TAG, 2, "performVideoDataListReportToServer called");
    }

    public void add(final QQCircleReport$SingleDcData qQCircleReport$SingleDcData, final boolean z16) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.7
            @Override // java.lang.Runnable
            public void run() {
                String str;
                QCircleReporter.this.notifyReportListener(qQCircleReport$SingleDcData);
                if (z16) {
                    QCircleReporter.this.mImmediateDataListPool.add(qQCircleReport$SingleDcData);
                    QCircleReporter.this.checkShouldImmediateReportToServer();
                } else {
                    QCircleReporter.this.mNormalDataListPool.add(qQCircleReport$SingleDcData);
                }
                QCircleReporter.this.checkShouldReportToServer();
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(QCircleReporter.TAG);
                    if (z16) {
                        str = "_DoImmediate";
                    } else {
                        str = "_DoNormal";
                    }
                    sb5.append(str);
                    QLog.d(sb5.toString(), 2, "add one SingleDcData:" + QCircleReporter.parseString(qQCircleReport$SingleDcData));
                }
            }
        });
    }

    public void addCommandReportData(final APP_REPORT_TRANSFER.SingleDcData singleDcData) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.10
            @Override // java.lang.Runnable
            public void run() {
                QCircleReporter.this.mCommandListPool.add(singleDcData);
                QCircleReporter.this.checkShouldReportToServer();
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.d("QCircleReporter_DoCommandReport", 2, "add one SingleDcData:" + QCircleReporter.parseCommandString(singleDcData));
                }
            }
        });
    }

    public void addMissSessionReportDataCache(final QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.11
            @Override // java.lang.Runnable
            public void run() {
                QCircleReporter.this.mMissSessionDataListPool.add(qQCircleReport$SingleDcData);
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.d("QCircleReporter_DoCacheFirst", 2, "add one SingleDcData:" + QCircleReporter.parseString(qQCircleReport$SingleDcData));
                }
            }
        });
    }

    public void addQualityReportData(QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        addQualityReportData(qQCircleReport$SingleDcData, false);
    }

    public void addReRankReportData(final QQCircleReport$SingleDcData qQCircleReport$SingleDcData) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.8
            @Override // java.lang.Runnable
            public void run() {
                QCircleReporter.this.mReRankListPool.add(qQCircleReport$SingleDcData);
                QCircleReporter.this.checkShouldImmediateReportToServer();
                if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                    QLog.d("QCircleReporter_DoReRank", 2, "add one SingleDcData:" + QCircleReporter.parseString(qQCircleReport$SingleDcData));
                }
            }
        });
    }

    public void addReportListener(QCircleReportListener qCircleReportListener) {
        if (!containsReportListener(qCircleReportListener)) {
            this.mListeners.add(qCircleReportListener);
        }
    }

    public boolean containsReportListener(QCircleReportListener qCircleReportListener) {
        return this.mListeners.contains(qCircleReportListener);
    }

    public void flush() {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.12
            @Override // java.lang.Runnable
            public void run() {
                QCircleReporter.this.performNormalDataListReportToServer();
                QCircleReporter.this.performQualityDataListReportToServer();
            }
        });
    }

    public void flushVideoReportByByte(List<byte[]> list) {
        flushVideoReport(b.b(list));
    }

    public Handler getReportHandler() {
        return this.reportHandler;
    }

    public void initOutbox() {
        this.reportHandler.postDelayed(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QCircleReportOutboxTaskQueue.TAG, 1, "initOutbox...");
                QCircleReportOutboxTaskQueue.getInstance();
            }
        }, 10000L);
    }

    public void removeReportListener(QCircleReportListener qCircleReportListener) {
        this.mListeners.remove(qCircleReportListener);
    }

    public void reportCacheDataListToServerWithSession(final byte[] bArr) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.3
            @Override // java.lang.Runnable
            public void run() {
                if (QCircleReporter.this.mMissSessionDataListPool.size() == 0) {
                    return;
                }
                QLog.w(QCircleReporter.TAG, 1, "reportCacheDataListToServer size:" + QCircleReporter.this.mMissSessionDataListPool.size());
                QLog.d(QCircleReporter.TAG, 1, "reportCacheDataListToServerWithSession called");
                Iterator it = QCircleReporter.this.mMissSessionDataListPool.iterator();
                while (it.hasNext()) {
                    ((QQCircleReport$SingleDcData) it.next()).byteExtinfo.add(QCircleReportHelper.newEntry(QCircleReportHelper.MAP_KEY_SESSION, bArr));
                }
                QCircleReporter qCircleReporter = QCircleReporter.this;
                qCircleReporter.performClientReport(qCircleReporter.mMissSessionDataListPool, false);
                QCircleReporter.this.mMissSessionDataListPool.clear();
            }
        });
    }

    public void sendListReport(final List<QQCircleReport$SingleDcData> list, final QCircleReportRspCallback qCircleReportRspCallback) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.5
            @Override // java.lang.Runnable
            public void run() {
                List list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), new QCircleClientReportRequest(new ArrayList(list)), new VSDispatchObserver.OnVSRspCallBack<QQCircleReport$StDataReportRsp>() { // from class: cooperation.qqcircle.report.QCircleReporter.5.1
                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
                            QCircleReportRspCallback qCircleReportRspCallback2 = qCircleReportRspCallback;
                            if (qCircleReportRspCallback2 != null) {
                                qCircleReportRspCallback2.onReceive(baseRequest, z16, j3, str, qQCircleReport$StDataReportRsp);
                            }
                        }
                    });
                }
            }
        });
    }

    public void addQualityReportData(final QQCircleReport$SingleDcData qQCircleReport$SingleDcData, final boolean z16) {
        this.reportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleReporter.9
            @Override // java.lang.Runnable
            public void run() {
                QCircleReporter.this.mQualityDataListPool.add(qQCircleReport$SingleDcData);
                if (z16) {
                    QLog.d("QCircleReporter_DoQuality", 1, "add one SingleDcData:" + QCircleReporter.parseString(qQCircleReport$SingleDcData));
                } else if (QLog.isColorLevel()) {
                    QLog.d("QCircleReporter_DoQuality", 2, "add one SingleDcData:" + QCircleReporter.parseString(qQCircleReport$SingleDcData));
                }
                QCircleReporter.this.checkShouldReportToServer();
            }
        });
    }
}

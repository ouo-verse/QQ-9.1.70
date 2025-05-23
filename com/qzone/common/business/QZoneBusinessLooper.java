package com.qzone.common.business;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.app.ParamConstants;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneTrafficService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.al;
import com.tencent.common.config.AppSetting;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.report.lp.LpReportInfo_DC02293;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import xe.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneBusinessLooper implements Handler.Callback {
    private static final int MSG_COMPLETE_TASK = 1;
    private static final int MSG_RUN_TASK = 0;
    private static final String TAG = "QZoneBusinessLooper";
    public Handler mHandler;
    private static final al<QZoneBusinessLooper, Void> sSingleton = new a();
    private static String reportCmds = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneBusinessLooper, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneBusinessLooper a(Void r16) {
            return new QZoneBusinessLooper();
        }
    }

    public static QZoneBusinessLooper getInstance() {
        return sSingleton.get(null);
    }

    private void prepareReport(QZoneTask qZoneTask) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        if (qZoneTask == null || qZoneTask.mRequest == null) {
            return;
        }
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, qZoneTask.mRequest.getReportEventName());
        statistic.setValue(WnsKeys.APN, NetworkState.getAPN());
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(qZoneTask.mResultCode));
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(LoginData.getInstance().getUin()));
        Key key = WnsKeys.TimeCost;
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        statistic.setValue(key, Long.valueOf(qZoneRequest.endTime - qZoneRequest.startTime));
        statistic.setValue(WnsKeys.RequestSize, Long.valueOf(qZoneTask.mRequest.reqSize));
        statistic.setValue(WnsKeys.ResponseSize, Long.valueOf(qZoneTask.mRequest.respSize));
        statistic.setValue(WnsKeys.Qua, QUA.getQUA3());
        statistic.setValue(WnsKeys.Sequence, Integer.valueOf(qZoneTask.mRequest.reqId));
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        statistic.setValue(WnsKeys.ServerIP, qZoneTask.mRequest.getParameter(ParamConstants.KEY_REQUEST_SERVER_IP));
        statistic.setValue(WnsKeys.Port, qZoneTask.mRequest.getParameter(ParamConstants.KEY_REQUEST_SERVER_PORT));
        String str = (String) qZoneTask.mRequest.getParameter(ParamConstants.KEY_REPORT_BUSI_SERVERIP);
        if (!TextUtils.isEmpty(str)) {
            statistic.setValue(WnsKeys.BusiServerip, str);
        }
        if (qZoneTask.mResultCode != 0) {
            Object parameter = qZoneTask.mRequest.getParameter(ParamConstants.KEY_REPORT_DETAIL_MSG);
            if (parameter != null) {
                statistic.setValue(WnsKeys.Detail, parameter);
            }
            statistic.setValue(WnsKeys.Frequency, 1);
        }
        statisticCollector.put(statistic);
        if (qZoneTask.mResultCode != 0) {
            statisticCollector.forceReport();
        }
        boolean isWifiConn = NetworkState.isWifiConn();
        QZoneRequest qZoneRequest2 = qZoneTask.mRequest;
        QZoneTrafficService.e(isWifiConn, qZoneRequest2.reqSize + qZoneRequest2.respSize);
    }

    public void comleteTask(QZoneTask qZoneTask) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = qZoneTask;
        this.mHandler.sendMessage(obtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        QZoneRequest qZoneRequest;
        int i3 = message.what;
        if (i3 == 0) {
            try {
                QZoneTask qZoneTask = (QZoneTask) message.obj;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("runTask cmd=");
                QZoneRequest qZoneRequest2 = qZoneTask.mRequest;
                if (qZoneRequest2 != null) {
                    str = qZoneRequest2.getCmdString();
                } else {
                    str = "mRequest is null";
                }
                sb5.append(str);
                QZLog.i(TAG, 1, sb5.toString());
                qZoneTask.run();
                return false;
            } catch (Exception e16) {
                b.f447841a.d(e16);
                return false;
            }
        }
        if (i3 != 1) {
            return false;
        }
        QZoneTask qZoneTask2 = (QZoneTask) message.obj;
        QZoneRequest qZoneRequest3 = qZoneTask2.mRequest;
        if (qZoneRequest3 != null && qZoneRequest3.getCmdString() != null && !qZoneTask2.mRequest.getCmdString().contains("ClientReport")) {
            QZLog.i(TAG, 1, "completeTask resultCode:" + qZoneTask2.mResultCode + ", cmd=" + qZoneTask2.mRequest.getCmdString());
        }
        if (qZoneTask2.mListener != null) {
            try {
                reportRequest(qZoneTask2);
                qZoneTask2.mListener.onTaskResponse(qZoneTask2);
            } catch (Exception e17) {
                b.f447841a.d(e17);
            }
        }
        if (qZoneTask2.mResultCode == 1000006 || (qZoneRequest = qZoneTask2.mRequest) == null || !qZoneRequest.needReport() || qZoneTask2.mRequest.endTime <= 0) {
            return false;
        }
        prepareReport(qZoneTask2);
        return false;
    }

    public void runTask(QZoneTask qZoneTask) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getLooper(), this);
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = qZoneTask;
        this.mHandler.sendMessage(obtain);
    }

    private static void reportRequest(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && !TextUtils.isEmpty(qZoneRequest.getRequestCmd())) {
            try {
                if (reportCmds == null) {
                    reportCmds = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LINK_REPORT_CMD_LIST, "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
                }
                String requestCmd = qZoneTask.mRequest.getRequestCmd();
                if (!reportCmds.contains(requestCmd) || qZoneTask.mResultCode == 0) {
                    return;
                }
                QZLog.e(TAG, "cmd error report! cmd=" + requestCmd + " retCode=" + qZoneTask.mResultCode + " msg=" + qZoneTask.f45835msg + " duration=" + (System.currentTimeMillis() - qZoneTask.timestamp));
                LpReportManager.getInstance().reportToDC02293(new LpReportInfo_DC02293(requestCmd, qZoneTask.mResultCode, qZoneTask.f45835msg, qZoneTask.timestamp));
            } catch (Exception unused) {
            }
        }
    }
}

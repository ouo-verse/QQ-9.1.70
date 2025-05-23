package com.tencent.av.video.call;

import QQService.strupbuff;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.b;
import com.tencent.av.ui.funchat.record.e;
import com.tencent.avcore.jni.log.ClientLogReportJni;
import com.tencent.avcore.jni.log.IClientLogReport;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClientLogReport implements IClientLogReport {
    private static final String CONN_RATE_BEACON_REPORT_APP_KEY = "0DOU09AAM746YHNI";
    private static final String CONN_RATE_BEACON_REPORT_DAV_EVENT = "DAV_Conn_Rate";
    private static final String CONN_RATE_BEACON_REPORT_MAV_EVENT = "MAV_Conn_Rate";
    private static final String GACS_REPORT_NEW_KEY = "2085";
    private static final String GACS_REPORT_NEW_KEY_2 = "2207";
    private static final String HW_CODEC_CAPABILITY_TEST_KEY = "dc05274";
    public static final String HW_CODEC_CAPABILITY_TEST_TOPIC_ID = "5274";
    private static final int LOG_SEND_RET_FAIL = 0;
    private static final int LOG_SEND_RET_OK = 1;
    private static final int LOG_SEND_RET_PENDING = 2;
    private static final String NEW_GACS_REPORT = "dc02085";
    private static final String NEW_GACS_REPORT_2 = "dc02207";
    private static final long REPORT_FAIL_RETRY_MAX_INTERVAL = 86400000;
    private static final String REPORT_RECORD_IS_RETRY = "report_record_is_retry";
    private static final String REPORT_RECORD_SEQ = "report_record_seq";
    private static final String SEND_LOG_ID = "0";
    private static final String SERVER_FILTER_KEY = "video_log";
    private static final String TAG = "ClientLogReport";
    private static final String TECH_QUA_LOG_ID = "918";
    private static final String UDP_CHECK_LOG_ID = "1";
    private static final String UDP_CHECK_RESULT_SERVER_FILTER_KEY = "video_udpcheck_log";
    public static volatile String sGatewayIP = "";
    public static volatile int sGatewayPort;
    private int mAppId;
    private AppInterface mAppInterface;
    private Context mContext;
    private MsfServiceSdk mMsfSub;
    private int mSeqNo;
    private static final String KEY_CLIENT_IP = "client_ip";
    private static final String[] S_CONN_RATE_KEYS = {"selfUin", AudienceReportConst.CLIENT_TYPE, "client_version", "net_type", "net_status", KEY_CLIENT_IP, "buss_type", "cmd", "union_room_id", "f9", "f10", "f11", "f12", "f13", "f14", "conn_ip", "conn_family", "tcp_socket_status", "conn_count", "conn_status", "ret_code", "cost_time", "conn_index", "f22", "f23", "f24", "f25", "f26"};
    private static final String REPORT_FAIL_LOG_DIR = b.s();
    private static ClientLogReport instance = null;
    private boolean mInit = false;
    private final Map<Integer, ReportRecord> mReportRecordCache = new ConcurrentHashMap();
    private final ClientLogReportJni mJni = new ClientLogReportJni(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ReportRecord implements Serializable {
        private static final long serialVersionUID = 1;
        byte[] mLog;
        long mTimestamp;
        String mTopicId;
        long mUin;

        ReportRecord() {
        }

        public static ReportRecord readFromFile(File file) {
            ObjectInputStream objectInputStream;
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                objectInputStream = null;
                fileInputStream = null;
            }
            try {
                ReportRecord reportRecord = (ReportRecord) objectInputStream.readObject();
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                try {
                    objectInputStream.close();
                } catch (Throwable unused2) {
                }
                return reportRecord;
            } catch (Throwable th7) {
                th = th7;
                try {
                    AVCoreLog.e(ClientLogReport.TAG, "readFromFile fail.", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (objectInputStream == null) {
                        return null;
                    }
                    try {
                        objectInputStream.close();
                        return null;
                    } catch (Throwable unused4) {
                        return null;
                    }
                } finally {
                }
            }
        }

        public String toString() {
            return String.format("ReportRecord{mUin=%s mTopicId=%s mLog=%s mTimestamp=%s}", Long.valueOf(this.mUin), this.mTopicId, this.mLog, Long.valueOf(this.mTimestamp));
        }

        public void writeToFile(File file) {
            FileOutputStream fileOutputStream;
            Throwable th5;
            ObjectOutputStream objectOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (Throwable th6) {
                    th5 = th6;
                    objectOutputStream = null;
                }
            } catch (Throwable th7) {
                fileOutputStream = null;
                th5 = th7;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(this);
                objectOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable th8) {
                th5 = th8;
                try {
                    AVCoreLog.e(ClientLogReport.TAG, "writeToFile fail.", th5);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (objectOutputStream == null) {
                        return;
                    }
                    objectOutputStream.close();
                } finally {
                }
            }
            try {
                objectOutputStream.close();
            } catch (Throwable unused3) {
            }
        }
    }

    ClientLogReport() {
    }

    public static ClientLogReport instance() {
        if (instance == null) {
            instance = new ClientLogReport();
        }
        return instance;
    }

    private Map<String, String> unPacketConnRateData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (String str : S_CONN_RATE_KEYS) {
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                if (i3 < bArr.length) {
                    int i16 = i3 + 1;
                    char c16 = (char) bArr[i3];
                    if (c16 == '|') {
                        hashMap.put(str, sb5.toString());
                        i3 = i16;
                        break;
                    }
                    sb5.append(c16);
                    i3 = i16;
                }
            }
        }
        hashMap.put(KEY_CLIENT_IP, sGatewayIP);
        return hashMap;
    }

    public void checkLocalReportRecord() {
        QLog.d(TAG, 1, "checkLocalReportRecord");
        if (!this.mInit) {
            QLog.e(TAG, 1, "checkLocalReportRecord mInit is false.");
        } else if (!NetworkUtil.isNetworkAvailable(this.mContext)) {
            QLog.e(TAG, 1, "checkLocalReportRecord network is invalid.");
        } else {
            new Handler(ThreadManagerV2.getFileThreadLooper()).post(new Runnable() { // from class: com.tencent.av.video.call.ClientLogReport.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File file = new File(ClientLogReport.REPORT_FAIL_LOG_DIR);
                        if (file.exists() && file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                ReportRecord readFromFile = ReportRecord.readFromFile(file2);
                                if (readFromFile != null && System.currentTimeMillis() - readFromFile.mTimestamp < 86400000) {
                                    ClientLogReport.this.sendLog(readFromFile.mUin, readFromFile.mTopicId, readFromFile.mLog, true);
                                }
                                try {
                                    file2.delete();
                                } catch (Throwable th5) {
                                    QLog.e(ClientLogReport.TAG, 1, "checkLocalReportRecord delete file fail.", th5);
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        QLog.e(ClientLogReport.TAG, 1, "checkLocalReportRecord fail.", th6);
                    }
                }
            });
        }
    }

    public void handleServerResp(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleServerResp request=%s response=%s", intent, fromServiceMsg));
        }
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        } else {
            toServiceMsg = null;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int intValue = ((Integer) toServiceMsg.getAttribute(REPORT_RECORD_SEQ)).intValue();
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(REPORT_RECORD_IS_RETRY)).booleanValue();
            boolean isSuccess = fromServiceMsg.isSuccess();
            ReportRecord reportRecord = this.mReportRecordCache.get(Integer.valueOf(intValue));
            QLog.d(TAG, 1, String.format("handleServerResp seq=%s isRetry=%s success=%s record=%s", Integer.valueOf(intValue), Boolean.valueOf(booleanValue), Boolean.valueOf(isSuccess), reportRecord));
            if (reportRecord != null) {
                if (booleanValue) {
                    VideoRecoveryReporter.b(isSuccess);
                } else if (!isSuccess) {
                    String str = REPORT_FAIL_LOG_DIR;
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    reportRecord.writeToFile(new File(str, String.valueOf(reportRecord.mTimestamp)));
                    VideoRecoveryReporter.a();
                }
            }
            this.mReportRecordCache.remove(Integer.valueOf(intValue));
        }
    }

    public void init(Context context, int i3) {
        if (this.mJni.mNativeInit) {
            this.mContext = context;
            this.mAppId = i3;
            this.mMsfSub = MsfServiceSdk.get();
            QQBeaconReport.start();
            this.mInit = true;
            QLog.d(TAG, 1, "init");
        }
    }

    @Override // com.tencent.avcore.jni.log.IClientLogReport
    public int sendLog(long j3, String str, byte[] bArr, boolean z16) {
        String str2;
        if (!this.mInit) {
            QLog.e(TAG, 1, "sendLog mInit is false.");
            return 0;
        }
        if (bArr != null && bArr.length != 0) {
            if (this.mMsfSub == null) {
                QLog.e(TAG, 1, "sendLog mMsfSub is null.");
                return 0;
            }
            if ("0".equalsIgnoreCase(str)) {
                str2 = SERVER_FILTER_KEY;
            } else if ("1".equalsIgnoreCase(str)) {
                str2 = UDP_CHECK_RESULT_SERVER_FILTER_KEY;
            } else if (GACS_REPORT_NEW_KEY.equalsIgnoreCase(str)) {
                str2 = NEW_GACS_REPORT;
            } else if (GACS_REPORT_NEW_KEY_2.equalsIgnoreCase(str)) {
                str2 = NEW_GACS_REPORT_2;
            } else if (HW_CODEC_CAPABILITY_TEST_TOPIC_ID.equalsIgnoreCase(str)) {
                str2 = HW_CODEC_CAPABILITY_TEST_KEY;
            } else if ("0DOU09AAM746YHNI_DAV_Conn_Rate".equalsIgnoreCase(str)) {
                str2 = CONN_RATE_BEACON_REPORT_DAV_EVENT;
            } else if ("0DOU09AAM746YHNI_MAV_Conn_Rate".equalsIgnoreCase(str)) {
                str2 = CONN_RATE_BEACON_REPORT_MAV_EVENT;
            } else {
                str2 = str;
            }
            if (!CONN_RATE_BEACON_REPORT_DAV_EVENT.equals(str2) && !CONN_RATE_BEACON_REPORT_MAV_EVENT.equals(str2)) {
                try {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str2, new ArrayList());
                    ((ArrayList) concurrentHashMap.get(str2)).add(bArr);
                    if (e.a().f75886r == 1 && this.mAppInterface != null && TECH_QUA_LOG_ID.equalsIgnoreCase(str)) {
                        this.mSeqNo++;
                        strupbuff strupbuffVar = new strupbuff();
                        strupbuffVar.logstring = concurrentHashMap;
                        strupbuffVar.seqno = this.mSeqNo;
                        UniPacket uniPacket = new UniPacket(true);
                        uniPacket.setServantName("QQService.CliLogSvc.MainServantObj");
                        uniPacket.setFuncName("UploadReq");
                        uniPacket.put("Data", strupbuffVar);
                        byte[] encode = uniPacket.encode();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, String.format("sendLog with response length=%s wupBuf=%s", Integer.valueOf(encode.length), Arrays.toString(encode)));
                        }
                        byte[] copyOfRange = Arrays.copyOfRange(encode, 4, encode.length);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, String.format("sendLog length=%s wupBuf1=%s", Integer.valueOf(copyOfRange.length), Arrays.toString(copyOfRange)));
                        }
                        ReportRecord reportRecord = new ReportRecord();
                        reportRecord.mUin = j3;
                        reportRecord.mTopicId = str;
                        reportRecord.mLog = bArr;
                        reportRecord.mTimestamp = System.currentTimeMillis();
                        this.mReportRecordCache.put(Integer.valueOf(this.mSeqNo), reportRecord);
                        ToServiceMsg toServiceMsg = new ToServiceMsg(null, String.valueOf(j3), BaseConstants.CMD_REPORTSTAT);
                        toServiceMsg.putWupBuffer(copyOfRange);
                        toServiceMsg.setNeedCallback(true);
                        toServiceMsg.setTimeout(15000L);
                        toServiceMsg.addAttribute(REPORT_RECORD_SEQ, Integer.valueOf(this.mSeqNo));
                        toServiceMsg.addAttribute(REPORT_RECORD_IS_RETRY, Boolean.valueOf(z16));
                        this.mAppInterface.sendToService(toServiceMsg);
                    } else {
                        com.tencent.av.video.jce.QQService.strupbuff strupbuffVar2 = new com.tencent.av.video.jce.QQService.strupbuff();
                        strupbuffVar2.logstring = concurrentHashMap;
                        UniPacket uniPacket2 = new UniPacket(true);
                        uniPacket2.put("Data", strupbuffVar2);
                        byte[] encode2 = uniPacket2.encode();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, String.format("sendLog without response length=%s wupBuf=%s", Integer.valueOf(encode2.length), Arrays.toString(encode2)));
                        }
                        ToServiceMsg toServiceMsg2 = new ToServiceMsg(this.mMsfSub.getMsfServiceName(), String.valueOf(j3), BaseConstants.CMD_REPORTSTAT);
                        toServiceMsg2.putWupBuffer(encode2);
                        toServiceMsg2.setNeedCallback(false);
                        this.mMsfSub.sendMsg(toServiceMsg2);
                    }
                    return 1;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "callbackSendLog fail.", th5);
                    return 0;
                }
            }
            Map<String, String> unPacketConnRateData = unPacketConnRateData(bArr);
            QQBeaconReport.reportWithAppKey(CONN_RATE_BEACON_REPORT_APP_KEY, String.valueOf(j3), str2, true, unPacketConnRateData, true);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "report conn rate, ip[" + unPacketConnRateData.get(KEY_CLIENT_IP) + "], event[" + str2 + "]");
            }
            return 1;
        }
        QLog.e(TAG, 1, "sendLog log is empty.");
        return 0;
    }

    public void setAppInterface(AppInterface appInterface) {
        this.mAppInterface = appInterface;
    }
}

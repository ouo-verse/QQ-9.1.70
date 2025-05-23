package com.tencent.mobileqq.qcircle.picload.listener;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.QFSNetFlowReporter;
import feedcloud.FeedCloudCommon$Entry;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class RFWPicLoaderResultListener implements ILoaderResultListener {
    public static final int DEFAULT_DOWN_SPEED = -1;
    public static final int DEFAULT_TIME_COST = -1;
    public static final String LOAD_REFER_GUILD = "4";
    public static final String LOAD_REFER_KUIKLY = "7";
    public static final String LOAD_REFER_NT = "6";
    public static final String LOAD_REFER_QFS = "3";
    public static final String LOAD_REFER_QQSEARCH = "8";
    public static final String LOAD_REFER_QZONE = "5";
    public static final long ONE_KB = 1024;
    public static final float ONE_SECONDS = 1000.0f;
    public static final int SCALE = 2;
    private static final String TAG = "LibraPicLoader_RFWPicLoaderResultListener";
    private final String mReferValue;

    public RFWPicLoaderResultListener(String str) {
        this.mReferValue = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<FeedCloudCommon$Entry> getCommonReportData(Option option) {
        String str;
        ArrayList arrayList = new ArrayList();
        String subRefer = getSubRefer(option);
        if (TextUtils.isEmpty(subRefer)) {
            str = this.mReferValue;
        } else {
            str = this.mReferValue + "|" + subRefer;
        }
        arrayList.add(QCircleReportHelper.newEntry("refer", str));
        return arrayList;
    }

    private List<FeedCloudCommon$Entry> getDownLoadSpeed(Option option, double d16, int i3) {
        double d17 = -1.0d;
        if (i3 == 0 && d16 > -1.0d && RFWFileUtils.fileExists(option.getLocalPath()) && option.getPicType() != 3) {
            long fileSizes = RFWFileUtils.getFileSizes(option.getLocalPath()) / 1024;
            try {
                d17 = new BigDecimal(fileSizes / d16).setScale(2, 4).doubleValue();
                a.b(d17);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getDownloadSpeed error:" + e16.getMessage(), e16);
            }
            QLog.d(TAG, 1, "seq=", Integer.valueOf(option.getSeq()), " [getDownLoadSpeed] mReferValue:", this.mReferValue, " timeCost:", Double.valueOf(d16), " fileSize:", Long.valueOf(fileSizes), " download speed:", Double.valueOf(d17), " kb/s");
        } else if (i3 != 0) {
            a.a();
        }
        List<FeedCloudCommon$Entry> commonReportData = getCommonReportData(option);
        commonReportData.add(QCircleReportHelper.newEntry("rate", String.valueOf(d17)));
        return commonReportData;
    }

    @NonNull
    private String getSubRefer(@NonNull Option option) {
        Object obj = option.getExtraData().get("refer");
        if (obj instanceof String) {
            return (String) obj;
        }
        return "";
    }

    @Override // com.tencent.libra.listener.ILoaderResultListener
    public void onDecodeResult(Option option, int i3) {
        if (option != null && option.mDecodeStartTime != null) {
            QCircleQualityReporter.reportImageQualityEvent(QCircleQualityReporter.KEY_EVENT_ID_IMAGE_DECODE, String.valueOf(((float) (System.currentTimeMillis() - option.mDecodeStartTime.longValue())) / 1000.0f), String.valueOf(i3), option.getUrl(), option.getPicType(), getCommonReportData(option));
            return;
        }
        QLog.w(TAG, 1, "onDecodeResult option = null || option.mDecodeStartTime = null");
    }

    @Override // com.tencent.libra.listener.ILoaderResultListener
    public void onDownloadResult(Option option, int i3) {
        long j3;
        int i16;
        if (option != null && option.mDownLoadStartTime != null) {
            long currentTimeMillis = System.currentTimeMillis() - option.mDownLoadStartTime.longValue();
            double d16 = ((float) currentTimeMillis) / 1000.0f;
            List<FeedCloudCommon$Entry> downLoadSpeed = getDownLoadSpeed(option, d16, i3);
            if (i3 == 0 && !TextUtils.isEmpty(option.getLocalPath())) {
                j3 = new File(option.getLocalPath()).length();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file_size", j16);
                com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
                if (aVar.k(option)) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                jSONObject.put("use_quic", i16);
                jSONObject.put("quic_fail_count", aVar.e(option));
                if (i3 != 0) {
                    jSONObject.put("url", option.getUrl());
                    String j17 = aVar.j(option);
                    jSONObject.put("remote_ip", j17);
                    String gateWayIp = NetConnInfoCenter.getGateWayIp();
                    jSONObject.put("local_ip", gateWayIp);
                    LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[onDownloadResult] fail, remoteIp = ", j17, ", local_ip = ", gateWayIp);
                }
            } catch (JSONException unused) {
            }
            downLoadSpeed.add(QCircleReportHelper.newEntry("attach_info", jSONObject.toString()));
            QCircleQualityReporter.reportImageQualityEvent(QCircleQualityReporter.KEY_EVENT_ID_IMAGE_DOWNLOAD, String.valueOf(d16), String.valueOf(i3), "", option.getPicType(), downLoadSpeed);
            QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_IMAGE_DOWNLOAD, option.getUrl(), option.getLocalPath(), j16, currentTimeMillis, "", "");
            return;
        }
        QLog.w(TAG, 1, "[onDownloadResult] option = null || option.mDownLoadStartTime = null");
    }

    @Override // com.tencent.libra.listener.ILoaderResultListener
    public void onLoadResult(final Option option, final int i3) {
        if (option != null && option.mStartTime != null) {
            final double currentTimeMillis = ((float) (System.currentTimeMillis() - option.mStartTime.longValue())) / 1000.0f;
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleQualityReporter.reportImageQualityEvent(QCircleQualityReporter.KEY_EVENT_ID_IMAGE_LOAD, String.valueOf(currentTimeMillis), String.valueOf(i3), option.getUrl(), option.mLoadType, RFWPicLoaderResultListener.this.getCommonReportData(option));
                }
            });
        } else {
            QLog.w(TAG, 1, "onLoadResult option = null || option.mStartTime = null");
        }
    }
}

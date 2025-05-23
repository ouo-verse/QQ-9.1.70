package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleQualityReportResetManager {
    private static volatile QCircleQualityReportResetManager INSTANCE = null;
    private static final String TAG = "QCircleQualityReportResetManager";
    private static final List<String> mResetEventWhiteList;
    private OnQualityReportResendResultListener mOnQualityReportResetResultListener;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface OnQualityReportResendResultListener {
        void onQualityReportResendList(List<QQCircleReport$SingleDcData> list);
    }

    static {
        ArrayList arrayList = new ArrayList();
        mResetEventWhiteList = arrayList;
        arrayList.add(QCircleAlphaUserReporter.KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT);
    }

    QCircleQualityReportResetManager() {
    }

    private List<QQCircleReport$SingleDcData> findEventWhiteList(List<QQCircleReport$SingleDcData> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (QQCircleReport$SingleDcData qQCircleReport$SingleDcData : list) {
                if (isWhiteEventDcData(qQCircleReport$SingleDcData.report_data.get())) {
                    arrayList.add(qQCircleReport$SingleDcData);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static QCircleQualityReportResetManager instance() {
        if (INSTANCE == null) {
            synchronized (QCircleQualityReportResetManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QCircleQualityReportResetManager();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isWhiteEventDcData(List<FeedCloudCommon$Entry> list) {
        String str;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<FeedCloudCommon$Entry> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                FeedCloudCommon$Entry next = it.next();
                if (TextUtils.equals(next.key.get(), "event_id")) {
                    str = next.value.get();
                    break;
                }
            } else {
                str = "";
                break;
            }
        }
        if (TextUtils.isEmpty(str) || !mResetEventWhiteList.contains(str)) {
            return false;
        }
        return true;
    }

    public void handleReportFail(boolean z16, List<QQCircleReport$SingleDcData> list, BaseRequest baseRequest, long j3, String str) {
        if (!z16 || this.mOnQualityReportResetResultListener == null) {
            return;
        }
        QLog.d(TAG, 1, "[handleReportFail] retCode: " + j3 + " | errMsg: " + str);
        try {
            List<QQCircleReport$SingleDcData> findEventWhiteList = findEventWhiteList(list);
            if (findEventWhiteList != null && !findEventWhiteList.isEmpty()) {
                this.mOnQualityReportResetResultListener.onQualityReportResendList(findEventWhiteList);
            }
            QLog.d(TAG, 4, "[handleReportFail] current single dc data list should not be null.");
        } catch (Throwable unused) {
        }
    }

    public void setOnQualityReportResetResultListener(OnQualityReportResendResultListener onQualityReportResendResultListener) {
        this.mOnQualityReportResetResultListener = onQualityReportResendResultListener;
    }
}

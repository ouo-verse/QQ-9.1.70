package cooperation.qqcircle.whitelist;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import uq3.o;

/* loaded from: classes28.dex */
public class QCirclePreLoadManager {
    private static final int DEF_ALLOW_LONG_VIDEO = 0;
    private static final long DEF_FEATURE_MASK = 1;
    private static final String DEF_TEMP_CONVERSION_UIN = "3499975001|2148726188|2142943237|2043441633|3160614329|2901075335|1171936068|3108218354";
    private static final int DEF_VIDEO_LENGTH = 180;
    private static final String DEVICE_SPLIT_DIVISION = "\\|";
    public static final String SP_KEY_ALLOW_LONG_VIDEO_SWITCH = "sp_key_allow_long_video_switch";
    public static final String SP_KEY_MAX_LIMIT_VIDEO_LENGTH = "sp_key_max_limit_video_length";
    private static final String TAG = "QCirclePreLoadManager";
    private static Object lock = new Object();
    private static volatile QCirclePreLoadManager mInstance;
    private String mChatNoLimitWhiteList;
    private String mClientReportSuccessRateCmd;
    private long mFeatureMask = 0;
    private long mVideoAllowLong = 0;
    private long mVideoLength = 0;

    private List<Long> convertUinList(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : str.split(DEVICE_SPLIT_DIVISION)) {
                arrayList.add(Long.valueOf(Long.parseLong(str2)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public static QCirclePreLoadManager getInstance() {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    QLog.e(TAG, 1, "getInstance");
                    mInstance = new QCirclePreLoadManager();
                }
            }
        }
        return mInstance;
    }

    private void updateChatNoLimitWhiteList(List<Long> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (Long l3 : list) {
                        if (l3 != null) {
                            arrayList.add(l3.toString());
                        }
                    }
                    HostChatUtils.saveChatNoLimitWhiteList(arrayList);
                    QLog.d(TAG, 1, "[updateChatNoLimitWhiteList] whiteList: " + list);
                    return;
                }
            } catch (Throwable th5) {
                QLog.w(TAG, 1, "[updateChatNoLimitWhiteList] ex: ", th5);
                return;
            }
        }
        QLog.d(TAG, 1, "[updateChatNoLimitWhiteList] whiteList == null || whiteList.isEmpty().");
    }

    private void updateMoonCakeParams(long j3) {
        long d06 = o.d0(1L);
        if (this.mFeatureMask != d06) {
            updatePeriodCollectMask(d06);
            this.mFeatureMask = d06;
        }
        String b06 = o.b0(DEF_TEMP_CONVERSION_UIN);
        if (!TextUtils.equals(this.mChatNoLimitWhiteList, b06)) {
            updateChatNoLimitWhiteList(convertUinList(b06));
            this.mChatNoLimitWhiteList = b06;
        }
        int e06 = o.e0(0);
        int f06 = o.f0(180);
        long j16 = e06;
        if (this.mVideoAllowLong != j16 || this.mVideoLength != f06) {
            updateVideoLength(j3, e06, f06);
            this.mVideoAllowLong = j16;
            this.mVideoLength = f06;
        }
        String c06 = o.c0(QCircleAlphaUserReporter.DEF_RATE_CMD_LIST);
        if (!TextUtils.equals(this.mClientReportSuccessRateCmd, c06)) {
            updateNeedClientReportSuccessRateCmd(j3, QCircleAlphaUserReporter.convertWhiteList(c06));
            this.mClientReportSuccessRateCmd = c06;
        }
        QLog.d(TAG, 1, "[updateMoonCakeParams] uin: " + j3);
    }

    private void updateNeedClientReportSuccessRateCmd(long j3, List<String> list) {
        if (list != null && !list.isEmpty()) {
            QLog.d(TAG, 1, "[updateNeedClientReportSuccessRateCmd] cmdList: " + RFSafeListUtils.getSize(list));
            try {
                String convertListToStr = QCircleAlphaUserReporter.convertListToStr(list);
                QCircleAlphaUserReporter.updateCmdList(list);
                QLog.d(TAG, 1, "[updateNeedClientReportSuccessRateCmd] cmdListStr: " + convertListToStr);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[updateNeedClientReportSuccessRateCmd] throwable: ", th5);
                return;
            }
        }
        QLog.d(TAG, 1, "[updateNeedClientReportSuccessRateCmd] current cmd list not is empty.");
    }

    private void updatePeriodCollectMask(long j3) {
        try {
            boolean checkOpmask = QCircleHostConfig.checkOpmask(j3, 0);
            QCirclePeriodCollect.setEnableCollect(checkOpmask);
            QCircleHostConfig.saveEnablePeriodCollect(checkOpmask);
            QLog.d(TAG, 1, "[updatePeriodCollectMask] featureMask: " + j3);
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "[updatePeriodCollectMask] ex: ", th5);
        }
    }

    private void updateVideoLength(long j3, int i3, int i16) {
        try {
            LocalMultiProcConfig.putInt4Uin(SP_KEY_ALLOW_LONG_VIDEO_SWITCH, i3, j3);
            LocalMultiProcConfig.putInt4Uin(SP_KEY_MAX_LIMIT_VIDEO_LENGTH, i16, j3);
            QLog.d(TAG, 1, "[updateVideoLength] uin: " + j3 + " | preloadVideoAllowLong: " + i3 + " | preloadVideoLength: " + i16);
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[updateVideoLength] ex: ", th5);
        }
    }

    public void loadWhiteList(String str) {
        AtomicReference atomicReference = new AtomicReference(str);
        QLog.d(TAG, 1, "[loadWhiteList] app.getLongAccountUin():", atomicReference.get());
        if (TextUtils.isEmpty((CharSequence) atomicReference.get())) {
            return;
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        try {
            atomicLong.set(Long.parseLong((String) atomicReference.get()));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[requestWhiteList] ex: ", th5);
        }
        updateMoonCakeParams(atomicLong.get());
    }
}

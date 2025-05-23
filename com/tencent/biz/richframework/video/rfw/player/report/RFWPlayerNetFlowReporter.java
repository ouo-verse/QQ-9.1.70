package com.tencent.biz.richframework.video.rfw.player.report;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import uq3.c;

/* loaded from: classes5.dex */
public class RFWPlayerNetFlowReporter {
    private static final Map<String, PlayerNetFlowBean> mNetFlowBeanMap;
    private static final Map<Integer, String> mNetFlowPlayerMap;
    private static final AtomicReference<String> sAtomicCurrentScreenFileId;

    /* loaded from: classes5.dex */
    public static class PlayerNetFlowBean {
        private long mCDNFlowTotal;
        private String mCurrentPlayerTag;
        private RFWPlayerReportInfo mFeed;
        private String mFeedId;
        private String mFileId;
        private int mFrom;
        private long mPCDNFlowTotal;
        private String mPlayerUrl;
        private long mVideoPlayId;

        public long getCDNFlowTotal() {
            return this.mCDNFlowTotal;
        }

        public String getCurrentPlayerTag() {
            return this.mCurrentPlayerTag;
        }

        public String getFileId() {
            return this.mFileId;
        }

        public int getFrom() {
            return this.mFrom;
        }

        public long getPCDNFlowTotal() {
            return this.mPCDNFlowTotal;
        }

        public String getPlayerUrl() {
            return this.mPlayerUrl;
        }

        public RFWPlayerReportInfo getReportInfo() {
            return this.mFeed;
        }

        public long getVideoPlayId() {
            return this.mVideoPlayId;
        }

        public PlayerNetFlowBean setCDNFlowTotal(long j3) {
            this.mCDNFlowTotal = Math.max(this.mCDNFlowTotal, j3);
            return this;
        }

        public PlayerNetFlowBean setCurrentPlayerTag(String str) {
            this.mCurrentPlayerTag = str;
            return this;
        }

        public PlayerNetFlowBean setFeedId(String str) {
            this.mFeedId = str;
            return this;
        }

        public PlayerNetFlowBean setFileId(String str) {
            this.mFileId = str;
            return this;
        }

        public PlayerNetFlowBean setFrom(int i3) {
            this.mFrom = i3;
            return this;
        }

        public PlayerNetFlowBean setPCDNFlowTotal(long j3) {
            this.mPCDNFlowTotal = Math.max(this.mPCDNFlowTotal, j3);
            return this;
        }

        public PlayerNetFlowBean setPlayerUrl(String str) {
            this.mPlayerUrl = str;
            return this;
        }

        public PlayerNetFlowBean setReportInfo(RFWPlayerReportInfo rFWPlayerReportInfo) {
            this.mFeed = rFWPlayerReportInfo;
            return this;
        }

        public PlayerNetFlowBean setVideoPlayId(long j3) {
            this.mVideoPlayId = j3;
            return this;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        mNetFlowPlayerMap = concurrentHashMap;
        mNetFlowBeanMap = new ConcurrentHashMap();
        sAtomicCurrentScreenFileId = new AtomicReference<>();
        concurrentHashMap.put(0, "flow_from_type_unknown");
        concurrentHashMap.put(1, "flow_from_type_pre_download");
        concurrentHashMap.put(2, "flow_from_type_pre_player");
        concurrentHashMap.put(3, "flow_from_type_play");
    }

    public static void addPlayerNetFlowItem(String str, PlayerNetFlowBean playerNetFlowBean, String str2) {
        if (playerNetFlowBean == null) {
            return;
        }
        Pair<Long, Long> parseExtraInfoToPair = parseExtraInfoToPair(str2);
        playerNetFlowBean.setCDNFlowTotal(((Long) parseExtraInfoToPair.first).longValue());
        playerNetFlowBean.setPCDNFlowTotal(((Long) parseExtraInfoToPair.second).longValue());
        mNetFlowBeanMap.put(str, playerNetFlowBean);
    }

    private static void clearNetFlowBeanKey(PlayerNetFlowBean playerNetFlowBean) {
        String str;
        Map<String, PlayerNetFlowBean> map = mNetFlowBeanMap;
        if (map != null && !map.isEmpty()) {
            Iterator<String> it = map.keySet().iterator();
            loop0: while (true) {
                str = null;
                while (it.hasNext()) {
                    str = it.next();
                    if (mNetFlowBeanMap.get(str) == playerNetFlowBean) {
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                mNetFlowBeanMap.remove(str);
            }
        }
    }

    private static String convertTypeToStr(int i3) {
        return mNetFlowPlayerMap.get(Integer.valueOf(i3));
    }

    private static int getCurrentPlayerType(@NonNull PlayerNetFlowBean playerNetFlowBean) {
        int from = playerNetFlowBean.getFrom();
        playerNetFlowBean.getCurrentPlayerTag();
        if (from == 1) {
            return 1;
        }
        if (from == 2) {
            if (!isCurrentPlayToScreen(playerNetFlowBean.getFileId())) {
                return 2;
            }
            return 3;
        }
        return 0;
    }

    public static PlayerNetFlowBean getHistoryAndUpdateNetFlowBean(RFWPlayerOptions rFWPlayerOptions, int i3) {
        PlayerNetFlowBean historyNetFlowBean = getHistoryNetFlowBean(String.valueOf(i3));
        if (historyNetFlowBean == null) {
            historyNetFlowBean = new PlayerNetFlowBean();
            historyNetFlowBean.setVideoPlayId(RFWVideoReporter.obtainVideoPlayId());
        }
        updateNetflowReportBean(historyNetFlowBean, rFWPlayerOptions, historyNetFlowBean.getVideoPlayId(), 1, 0L, 0L);
        return historyNetFlowBean;
    }

    private static PlayerNetFlowBean getHistoryNetFlowBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mNetFlowBeanMap.get(str);
    }

    private static boolean isCurrentPlayToScreen(String str) {
        String str2 = sAtomicCurrentScreenFileId.get();
        QLog.d("RFWPlayerNetFlowReporter", 1, "[isCurrentPlayToScreen] file id: " + str + " | screen file id: " + str2);
        return TextUtils.equals(str2, str);
    }

    private static boolean isEnabledPlayerNetFlowReport() {
        return c.T5();
    }

    private static Pair<Long, Long> parseExtraInfoToPair(String str) {
        long j3;
        long j16 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("HttpDownloadSize")) {
                j3 = jSONObject.optLong("HttpDownloadSize");
            } else {
                j3 = 0;
            }
            try {
                if (jSONObject.has("PcdnDownloadSize")) {
                    j16 = jSONObject.optLong("PcdnDownloadSize");
                }
            } catch (Exception e16) {
                e = e16;
                QLog.e("RFWPlayerNetFlowReporter", 1, "[parseExtraInfoToReportBean] error: ", e);
                return new Pair<>(Long.valueOf(j3 - j16), Long.valueOf(j16));
            }
        } catch (Exception e17) {
            e = e17;
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3 - j16), Long.valueOf(j16));
    }

    private static void report(PlayerNetFlowBean playerNetFlowBean, String str, List<FeedCloudCommon$Entry> list) {
        if (playerNetFlowBean != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                arrayList.add(QCircleReportHelper.newEntry("video_url", playerNetFlowBean.getPlayerUrl()));
                RFWVideoReporter.getInstance().report(playerNetFlowBean.getVideoPlayId(), str, playerNetFlowBean.getReportInfo(), arrayList);
            } catch (Throwable th5) {
                QLog.e("RFWPlayerNetFlowReporter", 1, "error: ", th5);
            }
        }
    }

    private static void reportNetFlow(PlayerNetFlowBean playerNetFlowBean) {
        long j3;
        long j16;
        if (playerNetFlowBean == null || !isEnabledPlayerNetFlowReport()) {
            return;
        }
        long cDNFlowTotal = playerNetFlowBean.getCDNFlowTotal();
        if (cDNFlowTotal > 0) {
            j3 = cDNFlowTotal / 1024;
        } else {
            j3 = 0;
        }
        long pCDNFlowTotal = playerNetFlowBean.getPCDNFlowTotal();
        if (pCDNFlowTotal > 0) {
            j16 = pCDNFlowTotal / 1024;
        } else {
            j16 = 0;
        }
        int currentPlayerType = getCurrentPlayerType(playerNetFlowBean);
        QLog.d("RFWPlayerNetFlowReporter", 1, "[reportNetFlow] type:" + convertTypeToStr(currentPlayerType) + " | cdnFlowTotalKb: " + j3 + "KB | pcdnFlowTotalKb: " + j16 + "KB | videFileId: " + playerNetFlowBean.getFileId());
        if (j3 == 0 && j16 == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(j3)));
        arrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(j16)));
        arrayList.add(QCircleReportHelper.newEntry("ret_code", String.valueOf(currentPlayerType)));
        report(playerNetFlowBean, "video_flow_bandwidth", arrayList);
        clearNetFlowBeanKey(playerNetFlowBean);
    }

    public static void reportPlayerNetFlow(PlayerNetFlowBean playerNetFlowBean) {
        reportNetFlow(playerNetFlowBean);
    }

    public static void updateNetflowReportBean(PlayerNetFlowBean playerNetFlowBean, RFWPlayerOptions rFWPlayerOptions, long j3, int i3, long j16, long j17) {
        RFWPlayerReportInfo businessReportInfo;
        String str;
        if (rFWPlayerOptions != null && playerNetFlowBean != null) {
            RFWPlayerIOC ioc = rFWPlayerOptions.getIOC();
            if (ioc == null) {
                businessReportInfo = null;
            } else {
                businessReportInfo = ioc.getBusinessReportInfo();
            }
            if (businessReportInfo != null) {
                str = businessReportInfo.getFeedId();
            } else {
                str = "";
            }
            playerNetFlowBean.setFrom(i3).setFileId(rFWPlayerOptions.getFileId()).setPlayerUrl(rFWPlayerOptions.getRealPlayUrl()).setCurrentPlayerTag(rFWPlayerOptions.tag()).setFeedId(str).setReportInfo(businessReportInfo).setVideoPlayId(j3).setCDNFlowTotal(j16).setPCDNFlowTotal(j17);
        }
    }

    public static void updateScreenFileId(String str) {
        QLog.d("RFWPlayerNetFlowReporter", 1, "[updateScreenFileId] file id: " + str);
        sAtomicCurrentScreenFileId.set(str);
    }

    public static void reportPlayerNetFlow(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("RFWPlayerNetFlowReporter", 1, "[reportPlayerNetFlow] current key should not be empty.");
            return;
        }
        Map<String, PlayerNetFlowBean> map = mNetFlowBeanMap;
        PlayerNetFlowBean playerNetFlowBean = map.get(str);
        if (playerNetFlowBean == null) {
            QLog.e("RFWPlayerNetFlowReporter", 1, "[reportPlayerNetFlow] bean should not be null.");
        } else {
            reportNetFlow(playerNetFlowBean);
            map.remove(str);
        }
    }
}

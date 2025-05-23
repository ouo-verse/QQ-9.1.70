package com.tencent.gamematrix.gmcg.base.delaycount;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgDelayCounter {
    private static final String TAG = "GmCgDelayCounter";
    private AtomicBoolean enableDetect;
    private boolean isReportAllocateEnd;
    private META meta;
    private String nowMainProcess;
    private Reporter reporter;
    private CGDelayResult result;
    private Map<String, Long> timeSaveMap;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface CGDelayLifeCycle {
        public static final String MAIN_PROCESS_ALLOCATE = "perf.cloud.game.startup.allocate";
        public static final String MAIN_PROCESS_BUSSINESS_PREPARE = "perf.cloud.game.startup.bussinessprepare";
        public static final String MAIN_PROCESS_LOAD_ARCHIVE_WEBRTC_LINK = "perf.cloud.game.startup.webrtclink";
        public static final String MAIN_PROCESS_PREPARE_LINK = "perf.cloud.game.startup.linkprepare";

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes6.dex */
        public @interface CGWebrtcSubProcessLifeCycle {
            public static final String SUB_PROCESS_ALLOC_DEVICE = "perf.cloud.game.startup.sub.allocdevice";
            public static final String SUB_PROCESS_AUTH_USER = "perf.cloud.game.startup.sub.authuser";

            @Deprecated
            public static final String SUB_PROCESS_CHECK_SR_TRIGER = "perf.cloud.game.startup.sub.checksrtriger";
            public static final String SUB_PROCESS_DECODE_RENDER = "perf.cloud.game.startup.sub.decoderender";
            public static final String SUB_PROCESS_GATE_LINK = "perf.cloud.game.startup.sub.linkgate";
            public static final String SUB_PROCESS_GATE_PREPARE = "perf.cloud.game.startup.sub.preparegate";
            public static final String SUB_PROCESS_ICE = "perf.cloud.game.startup.sub.ice";
            public static final String SUB_PROCESS_LINK_WEBRTC = "perf.cloud.game.startup.sub.linkwebrtc";
            public static final String SUB_PROCESS_LOAD_ARCHIVE = "perf.cloud.game.startup.sub.loadarchive";
            public static final String SUB_PROCESS_LOAD_MIDAS = "perf.cloud.game.startup.sub.configmidas";
            public static final String SUB_PROCESS_LOGIN = "perf.cloud.game.startup.sub.userlogin";
            public static final String SUB_PROCESS_QUERY_DEVICE = "perf.cloud.game.startup.sub.querydevice";
            public static final String SUB_PROCESS_QUERY_GAME_CONFIG = "perf.cloud.game.startup.sub.querygameconfig";
            public static final String SUB_PROCESS_QUERY_GATEWAY = "perf.cloud.game.startup.sub.querygateway";
            public static final String SUB_PROCESS_QUERY_SR_CONFIG = "perf.cloud.game.startup.sub.querysrconfig";
            public static final String SUB_PROCESS_SET_RESOLUTION = "perf.cloud.game.startup.sub.setresolution";
            public static final String SUB_PROCESS_SPEED_TEST = "perf.cloud.game.startup.sub.speedtest";
            public static final String SUB_RPOCESS_MERGE_REQUEST = "perf.cloud.game.startup.sub.mergerequest";
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CGDelayResult {
        private static final String TAG = "CGDelayResult";
        public long allocateCost;
        public long bussinessCost;
        public long linkPrepareCost;
        public META metaInfo;
        public Map<String, Process> process = new HashMap();
        public long subDecodeRenderCost;
        public long subLinkWebrtcCost;
        public long subWebrtcIceCost;
        public long subWebrtcLinkGateCost;
        public long subWebrtcPrepareGateCost;
        public long webrtcLinkCost;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class Item {
            String belongProcess;
            long endTime;
            public String processName;
            long startTime;
            public long time;
        }

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class Process {
            long endTime;
            public String name;
            long startTime;
            public List<Item> subProcess = new ArrayList();
            public long time;

            public Process(String str) {
                this.name = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class INNER {

        @SuppressLint({"StaticFieldLeak"})
        static GmCgDelayCounter INSTANCE = new GmCgDelayCounter();

        INNER() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class META {
        private String gameId = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String deviceId = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String websocketUrl = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String area = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String cgsdkVersion = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String cluster = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        private String userCarrier = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Reporter {
        void reportCheckpoint(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void reportMainProcess(long j3, long j16, long j17, long j18, String str, String str2, String str3, String str4, String str5, String str6, String str7);

        void reportWebrtcProcess(long j3, long j16, long j17, long j18, long j19, String str, String str2, String str3, String str4, String str5, String str6, String str7);
    }

    public static GmCgDelayCounter getInstance() {
        return INNER.INSTANCE;
    }

    private long recordMainProcess(String str, boolean z16) {
        String str2;
        if (!this.enableDetect.get()) {
            return -1L;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GmCgDelayCounter/recordMainProcess: \u73b0\u5728\u8bb0\u5f55");
        sb5.append(str);
        sb5.append(",");
        if (z16) {
            str2 = "\u5f00\u59cb";
        } else {
            str2 = "\u7ed3\u675f";
        }
        sb5.append(str2);
        Log.i("rogers-test ", sb5.toString());
        if (z16) {
            this.timeSaveMap.put(str, Long.valueOf(System.currentTimeMillis()));
            this.nowMainProcess = str;
            this.result.process.put(str, new CGDelayResult.Process(str));
            return 0L;
        }
        Long l3 = this.timeSaveMap.get(str);
        reportCheckPoint(str);
        if (l3 == null) {
            Log.i("rogers-test ", "GmCgDelayCounter/recordMainProcess: " + str + ",never begin !!!");
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        CGDelayResult.Process process = this.result.process.get(str);
        if (process == null) {
            CGLog.i("rogers-test , GmCgDelayCounter/recordMainProcess: no " + str + " exist, it never start!");
            return -1L;
        }
        process.time = currentTimeMillis - l3.longValue();
        process.startTime = l3.longValue();
        process.endTime = currentTimeMillis;
        return process.time;
    }

    private void reportCheckPoint(String str) {
        if (this.enableDetect.get() && this.reporter != null) {
            if (this.meta == null) {
                this.meta = new META();
            }
            CGLog.i("rogers-test , GmCgDelayCounter/reportCheckPoint: now report " + str);
            this.reporter.reportCheckpoint(str, this.meta.gameId, this.meta.deviceId, this.meta.websocketUrl, this.meta.area, this.meta.cluster, this.meta.userCarrier, this.meta.cgsdkVersion);
        }
    }

    public void enableDetect() {
        this.enableDetect.set(true);
    }

    public boolean isEnableDetect() {
        return this.enableDetect.get();
    }

    public void recordAllocateProcessEnd() {
        if (!this.enableDetect.get() || this.isReportAllocateEnd) {
            return;
        }
        long recordMainProcess = recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_ALLOCATE, false);
        if (recordMainProcess > 0) {
            this.result.allocateCost = recordMainProcess;
        }
        this.isReportAllocateEnd = true;
    }

    public void recordAllocateProcessStart(String str) {
        if (!this.enableDetect.get()) {
            return;
        }
        META meta = this.meta;
        if (meta != null) {
            meta.gameId = str;
            this.meta.cgsdkVersion = "3.0.0.241111110.3.9-SNAPSHOT";
        }
        recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_ALLOCATE, true);
    }

    public void recordBussinessProcessEnd() {
        if (!this.enableDetect.get()) {
            return;
        }
        long recordMainProcess = recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_BUSSINESS_PREPARE, false);
        if (recordMainProcess > 0) {
            this.result.bussinessCost = recordMainProcess;
        }
    }

    public void recordBussinessProcessStart(String str) {
        if (!this.enableDetect.get()) {
            return;
        }
        META meta = this.meta;
        if (meta != null) {
            meta.gameId = str;
            this.meta.cgsdkVersion = "3.0.0.241111110.3.9-SNAPSHOT";
        }
        recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_BUSSINESS_PREPARE, true);
    }

    public void recordPrepareLinkProcessEnd() {
        if (!this.enableDetect.get()) {
            return;
        }
        long recordMainProcess = recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_PREPARE_LINK, false);
        if (recordMainProcess > 0) {
            this.result.linkPrepareCost = recordMainProcess;
        }
    }

    public void recordPrepareLinkProcessStart() {
        if (!this.enableDetect.get()) {
            return;
        }
        recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_PREPARE_LINK, true);
    }

    public void recordSubProcess(String str, boolean z16) {
        recordSubProcess(this.nowMainProcess, str, z16);
    }

    public void recordWebrtcLinkProcessEnd() {
        if (!this.enableDetect.get()) {
            return;
        }
        long recordMainProcess = getInstance().recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_LOAD_ARCHIVE_WEBRTC_LINK, false);
        if (recordMainProcess > 0) {
            this.result.webrtcLinkCost = recordMainProcess;
        }
    }

    public void recordWebrtcLinkProcessStart() {
        if (!this.enableDetect.get()) {
            return;
        }
        getInstance().recordMainProcess(CGDelayLifeCycle.MAIN_PROCESS_LOAD_ARCHIVE_WEBRTC_LINK, true);
    }

    public void reportStartUpDelay() {
        if (this.enableDetect.get() && this.reporter != null) {
            this.enableDetect.set(false);
            CGDelayResult cGDelayResult = this.result;
            if (cGDelayResult.metaInfo == null) {
                cGDelayResult.metaInfo = new META();
            }
            CGLog.i("rogers-test , GmCgDelayCounter/reportStartUpDelay: " + new Gson().toJson(this.result));
            Reporter reporter = this.reporter;
            CGDelayResult cGDelayResult2 = this.result;
            reporter.reportMainProcess(cGDelayResult2.bussinessCost, cGDelayResult2.allocateCost, cGDelayResult2.linkPrepareCost, cGDelayResult2.webrtcLinkCost, cGDelayResult2.metaInfo.gameId, this.result.metaInfo.deviceId, this.result.metaInfo.websocketUrl, this.result.metaInfo.area, this.result.metaInfo.cluster, this.result.metaInfo.userCarrier, this.result.metaInfo.cgsdkVersion);
            Reporter reporter2 = this.reporter;
            CGDelayResult cGDelayResult3 = this.result;
            reporter2.reportWebrtcProcess(cGDelayResult3.subWebrtcPrepareGateCost, cGDelayResult3.subWebrtcLinkGateCost, cGDelayResult3.subWebrtcIceCost, cGDelayResult3.subLinkWebrtcCost, cGDelayResult3.subDecodeRenderCost, cGDelayResult3.metaInfo.gameId, this.result.metaInfo.deviceId, this.result.metaInfo.websocketUrl, this.result.metaInfo.area, this.result.metaInfo.cluster, this.result.metaInfo.userCarrier, this.result.metaInfo.cgsdkVersion);
        }
    }

    public void reset() {
        CGDelayResult cGDelayResult = new CGDelayResult();
        this.result = cGDelayResult;
        cGDelayResult.metaInfo = new META();
        this.timeSaveMap = new HashMap();
        this.meta = this.result.metaInfo;
        this.isReportAllocateEnd = false;
    }

    public void setArea(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.area = str;
        }
    }

    public void setCluster(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.cluster = str;
        }
    }

    public void setDeviceId(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.deviceId = str;
        }
    }

    public void setGameId(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.gameId = str;
        }
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void setSdkVersion(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.cgsdkVersion = str;
        }
    }

    public void setUserCarrier(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.userCarrier = str;
        }
    }

    public void setWebsocktUrl(String str) {
        META meta = this.meta;
        if (meta != null) {
            meta.websocketUrl = str;
        }
    }

    GmCgDelayCounter() {
        this.result = new CGDelayResult();
        this.timeSaveMap = new HashMap();
        this.enableDetect = new AtomicBoolean(false);
        this.isReportAllocateEnd = false;
    }

    public void recordSubProcess(String str, String str2, boolean z16) {
        if (this.enableDetect.get()) {
            if (TextUtils.isEmpty(str)) {
                str = this.nowMainProcess;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("rogers-test , GmCgDelayCounter/recordSubProcess: \u73b0\u5728\u8bb0\u5f55 ");
            sb5.append(str);
            sb5.append(" - ");
            sb5.append(str2);
            sb5.append(" - ");
            sb5.append(z16 ? "\u5f00\u542f" : "\u7ed3\u675f");
            CGLog.i(sb5.toString());
            String str3 = str + str2;
            if (z16) {
                this.timeSaveMap.put(str3, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            Long l3 = this.timeSaveMap.get(str3);
            if (l3 == null) {
                Log.i("rogers-test", "GmCgDelayCounter/recordSubProcess: " + str + "/" + str2 + ",never begin !!!");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                CGDelayResult.Item item = new CGDelayResult.Item();
                item.belongProcess = str;
                item.processName = str2;
                item.time = currentTimeMillis - l3.longValue();
                item.startTime = l3.longValue();
                item.endTime = currentTimeMillis;
                CGDelayResult.Process process = this.result.process.get(str);
                if (process == null) {
                    CGLog.i("rogers-test , GmCgDelayCounter/recordSubProcess: add subprocess " + str2 + " end but mainprocess " + str + " never begin !");
                    return;
                }
                if (this.result != null) {
                    if (TextUtils.equals(item.processName, CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_PREPARE)) {
                        this.result.subWebrtcPrepareGateCost = item.time;
                        reportCheckPoint(item.processName);
                    } else if (TextUtils.equals(item.processName, CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_LINK)) {
                        this.result.subWebrtcLinkGateCost = item.time;
                        reportCheckPoint(item.processName);
                    } else if (TextUtils.equals(item.processName, CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ICE)) {
                        this.result.subWebrtcIceCost = item.time;
                        reportCheckPoint(item.processName);
                    } else if (TextUtils.equals(item.processName, CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LINK_WEBRTC)) {
                        this.result.subLinkWebrtcCost = item.time;
                        reportCheckPoint(item.processName);
                    } else if (TextUtils.equals(item.processName, CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_DECODE_RENDER)) {
                        this.result.subDecodeRenderCost = item.time;
                        reportCheckPoint(item.processName);
                    }
                }
                process.subProcess.add(item);
            }
            this.timeSaveMap.remove(str3);
        }
    }
}

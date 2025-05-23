package com.tencent.bugly.traffic;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.network.INetworkStateListener;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.NetWorkUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.traffic.custom.CustomTrafficStatistic;
import com.tencent.bugly.traffic.custom.SocketInfo;
import com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic;
import com.tencent.bugly.traffic.statistic.MobileBackendStatistic;
import com.tencent.bugly.traffic.statistic.MobileFrontendStatistic;
import com.tencent.bugly.traffic.statistic.WiFiBackendStatistic;
import com.tencent.bugly.traffic.statistic.WiFiFrontendStatistic;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.TrafficDetailPluginConfig;
import com.tencent.rmonitor.base.db.table.TrafficInfoTable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.TrafficInfo;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.b;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrafficMonitor implements INetworkStateListener, b {
    public static final int BACKGROUND = 2;
    private static final long CHECK_DELAY = 60000;
    private static final long DETAIL_REPORT_DELAY = 600000;
    public static final int FOREGROUND = 1;
    private static final String TAG = "TrafficMonitor";
    private static final int TRAFFIC_CHECK_MESSAGE = 1;
    public static String operatorName = "unknown";
    private ArrayList<TrafficMsg> globalTrafficList;
    private final Handler handler;
    private boolean hasInited;
    private long lastReportTime;
    private AbstractTrafficStatistic mobileBackendRecordStatistic;
    private AbstractTrafficStatistic mobileBackendReportStatistic;
    private AbstractTrafficStatistic mobileFrontendRecordStatistic;
    private AbstractTrafficStatistic mobileFrontendReportStatistic;
    private List<AbstractTrafficStatistic> recordStatistics;
    private List<AbstractTrafficStatistic> reportStatistics;
    private AtomicBoolean started;
    private boolean trafficDetailEnabled;
    private final TrafficDetailPluginConfig trafficDetailPluginConfig;
    private boolean trafficEnabled;
    private AbstractTrafficStatistic wifiBackendRecordStatistic;
    private AbstractTrafficStatistic wifiBackendReportStatistic;
    private AbstractTrafficStatistic wifiFrontendRecordStatistic;
    private AbstractTrafficStatistic wifiFrontendReportStatistic;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static final class SInstanceHolder {
        static final TrafficMonitor sInstance = new TrafficMonitor();

        SInstanceHolder() {
        }
    }

    private ArrayList<TrafficMsg> convertMapToList(Map<String, TrafficMsg> map, Map<String, TrafficMsg> map2) {
        ArrayList<TrafficMsg> arrayList = new ArrayList<>();
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, TrafficMsg>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        if (map2 != null && !map2.isEmpty()) {
            Iterator<Map.Entry<String, TrafficMsg>> it5 = map2.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList.add(it5.next().getValue());
            }
        }
        return arrayList;
    }

    private ArrayList<TrafficMsg> filterLocalAddress(ArrayList<TrafficMsg> arrayList) {
        if (this.trafficDetailPluginConfig.G) {
            ArrayList<TrafficMsg> arrayList2 = new ArrayList<>();
            Iterator<TrafficMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                TrafficMsg next = it.next();
                if (!NetWorkUtil.isLocalAddress(next.mHost)) {
                    TrafficMsg trafficMsg = new TrafficMsg();
                    trafficMsg.mCollectType = next.mCollectType;
                    trafficMsg.mHost = next.mHost;
                    trafficMsg.mRx = next.mRx;
                    trafficMsg.mTx = next.mTx;
                    trafficMsg.mFore = next.mFore;
                    trafficMsg.mId = next.mId;
                    trafficMsg.mNet = next.mNet;
                    trafficMsg.mTime = next.mTime;
                    arrayList2.add(trafficMsg);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    private boolean findGlobalTrafficListInternal(TrafficMsg trafficMsg) {
        Iterator<TrafficMsg> it = this.globalTrafficList.iterator();
        while (it.hasNext()) {
            TrafficMsg next = it.next();
            if (trafficMsg.mCollectType.equals(next.mCollectType)) {
                if (trafficMsg.mCollectType.equals("custom") && next.mHost.equals(trafficMsg.mHost)) {
                    next.mRx += trafficMsg.mRx;
                    next.mTx += trafficMsg.mTx;
                    return true;
                }
                long j3 = trafficMsg.mId;
                if (j3 != -1 && j3 == next.mId && trafficMsg.mCollectType.equals("auto")) {
                    next.mRx += trafficMsg.mRx;
                    next.mTx += trafficMsg.mTx;
                    return true;
                }
            }
        }
        return false;
    }

    private int getExceptionValue() {
        int i3;
        if (this.wifiFrontendReportStatistic.getAutoSize() + this.wifiBackendReportStatistic.getAutoSize() + this.mobileFrontendReportStatistic.getAutoSize() + this.mobileBackendReportStatistic.getAutoSize() > this.trafficDetailPluginConfig.f365308m * 1024.0d * 1024.0d) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.mobileBackendReportStatistic.getAutoSize() + this.wifiBackendReportStatistic.getAutoSize() > this.trafficDetailPluginConfig.C * 1024.0d * 1024.0d) {
            i3 += 2;
        }
        if (this.mobileFrontendReportStatistic.getAutoSize() + this.mobileBackendReportStatistic.getAutoSize() > this.trafficDetailPluginConfig.D * 1024.0d * 1024.0d) {
            i3 += 4;
        }
        if (this.wifiBackendReportStatistic.getCustomSize() + this.wifiFrontendReportStatistic.getCustomSize() + this.mobileFrontendReportStatistic.getCustomSize() + this.mobileBackendReportStatistic.getCustomSize() > this.trafficDetailPluginConfig.E * 1024.0d * 1024.0d) {
            return i3 + 16;
        }
        return i3;
    }

    public static TrafficMonitor getInstance() {
        return SInstanceHolder.sInstance;
    }

    private void initOnce() {
        this.reportStatistics.add(this.wifiFrontendReportStatistic);
        this.reportStatistics.add(this.wifiBackendReportStatistic);
        this.reportStatistics.add(this.mobileFrontendReportStatistic);
        this.reportStatistics.add(this.mobileBackendReportStatistic);
        this.recordStatistics.add(this.wifiFrontendRecordStatistic);
        this.recordStatistics.add(this.wifiBackendRecordStatistic);
        this.recordStatistics.add(this.mobileFrontendRecordStatistic);
        this.recordStatistics.add(this.mobileBackendRecordStatistic);
        NetworkWatcher networkWatcher = NetworkWatcher.INSTANCE;
        operatorName = networkWatcher.getOperatorName();
        System.loadLibrary("rmonitor_base");
        String[] strArr = new String[0];
        List<String> list = this.trafficDetailPluginConfig.J;
        if (list != null) {
            strArr = (String[]) list.toArray(new String[0]);
        }
        networkWatcher.registerListener(this);
        if (networkWatcher.isWiFiConnectedRealtime()) {
            nativeSetNetworkState(1);
        } else if (networkWatcher.isNetworkConnectedRealtime()) {
            nativeSetNetworkState(2);
        } else {
            nativeSetNetworkState(3);
        }
        LifecycleCallback.r(this);
        if (LifecycleCallback.G.m()) {
            nativeSetForegroundState(1);
        } else {
            nativeSetForegroundState(2);
        }
        nativeInitMatrixTraffic(true, true, true, strArr);
    }

    private boolean isCheckPermitted() {
        if (!AndroidVersion.isOverO()) {
            Logger.f365497g.i(TAG, "below android o, could not open traffic");
            return false;
        }
        return true;
    }

    private static native void nativeClearTrafficInfo();

    private static native void nativeGetTrafficInfo(ArrayList<TrafficMsg> arrayList);

    private static native void nativeInitMatrixTraffic(boolean z16, boolean z17, boolean z18, String[] strArr);

    private static native void nativeReleaseMatrixTraffic();

    private static native void nativeRestart();

    private static native void nativeSetForegroundState(int i3);

    private static native void nativeSetNetworkState(int i3);

    private void reportTrafficMsgs(ArrayList<TrafficMsg> arrayList, boolean z16) {
        addToGlobalTrafficList(arrayList);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime >= 600000 || z16) {
            this.lastReportTime = currentTimeMillis;
            Iterator<AbstractTrafficStatistic> it = this.reportStatistics.iterator();
            while (it.hasNext()) {
                it.next().process(this.globalTrafficList);
            }
            int exceptionValue = getExceptionValue();
            if (exceptionValue == 0 && Math.random() < this.trafficDetailPluginConfig.H) {
                TrafficReport.report(exceptionValue, this.globalTrafficList, this.reportStatistics);
            } else if (exceptionValue != 0 && Math.random() < this.trafficDetailPluginConfig.I) {
                TrafficReport.report(exceptionValue, this.globalTrafficList, this.reportStatistics);
            }
            this.globalTrafficList.clear();
        }
    }

    private void saveTrafficMsgs(ArrayList<TrafficMsg> arrayList) {
        for (AbstractTrafficStatistic abstractTrafficStatistic : this.recordStatistics) {
            abstractTrafficStatistic.process(arrayList);
            Iterator<TrafficMsg> it = convertMapToList(abstractTrafficStatistic.getCustomMaps(), abstractTrafficStatistic.getAutoMaps()).iterator();
            while (it.hasNext()) {
                TrafficMsg next = it.next();
                ArrayList<TrafficInfo> searchDB = searchDB(next.mHost, next);
                if (searchDB.size() >= 1) {
                    TrafficInfo trafficInfo = searchDB.get(0);
                    for (int i3 = 1; i3 < searchDB.size(); i3++) {
                        trafficInfo.setRx(trafficInfo.getRx() + searchDB.get(i3).getRx());
                        trafficInfo.setTx(trafficInfo.getTx() + searchDB.get(i3).getTx());
                        TrafficInfoTable.g().f(searchDB.get(i3));
                    }
                    trafficInfo.setRx(trafficInfo.getRx() + next.mRx);
                    trafficInfo.setTx(trafficInfo.getTx() + next.mTx);
                    TrafficInfoTable.g().j(trafficInfo);
                } else {
                    TrafficInfo trafficInfo2 = new TrafficInfo();
                    trafficInfo2.setHost(next.mHost);
                    trafficInfo2.setLaunchID(TraceGenerator.getLaunchId(BaseInfo.app));
                    trafficInfo2.setProcessName(a.e(BaseInfo.app));
                    trafficInfo2.setProcessLaunchID(TraceGenerator.getProcessLaunchId());
                    trafficInfo2.setFrontState(TrafficTools.frontStateToString(next.mFore));
                    trafficInfo2.setNetState(TrafficTools.netStateToString(next.mNet));
                    trafficInfo2.setRx(next.mRx);
                    trafficInfo2.setTx(next.mTx);
                    trafficInfo2.setAppVersion(BaseInfo.userMeta.appVersion);
                    trafficInfo2.setType(next.mCollectType);
                    trafficInfo2.setHotPatchNum(HotPatchWrapper.getInstance().getAppHotPatchNum());
                    JSONObject o16 = com.tencent.rmonitor.custom.b.a().o();
                    if (o16 != null) {
                        trafficInfo2.setUserData(o16);
                    }
                    TrafficInfoTable.g().j(trafficInfo2);
                }
            }
        }
    }

    private ArrayList<TrafficInfo> searchDB(String str, TrafficMsg trafficMsg) {
        return (ArrayList) TrafficInfoTable.g().i(null, "host = ? AND front_state = ? AND net_state = ? AND process_name = ? AND process_launch_id = ? AND type = ?", new String[]{str, TrafficTools.frontStateToString(trafficMsg.mFore), TrafficTools.netStateToString(trafficMsg.mNet), a.e(BaseInfo.app), TraceGenerator.getProcessLaunchId(), trafficMsg.mCollectType}, false, null, null, null, null);
    }

    public ArrayList<TrafficMsg> addToGlobalTrafficList(ArrayList<TrafficMsg> arrayList) {
        Iterator<TrafficMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            TrafficMsg next = it.next();
            if (!findGlobalTrafficListInternal(next)) {
                this.globalTrafficList.add(next);
            }
        }
        return this.globalTrafficList;
    }

    public void clearTrafficInfo() {
        nativeClearTrafficInfo();
        CustomTrafficStatistic.getInstance().getHttpQueue().clear();
        CustomTrafficStatistic.getInstance().getSocketToQueue().clear();
    }

    public ArrayList<TrafficMsg> getTrafficInfo() {
        ArrayList<TrafficMsg> arrayList = new ArrayList<>();
        nativeGetTrafficInfo(arrayList);
        Iterator<SocketInfo> it = CustomTrafficStatistic.getInstance().getHttpQueue().iterator();
        while (it.hasNext()) {
            SocketInfo next = it.next();
            TrafficMsg trafficMsg = new TrafficMsg();
            trafficMsg.mRx = (int) next.receivedBytes;
            trafficMsg.mTx = (int) next.sendBytes;
            trafficMsg.mCollectType = "custom";
            trafficMsg.mNet = next.networkType;
            trafficMsg.mFore = next.frontState;
            trafficMsg.mHost = next.host;
            trafficMsg.mTime = next.startTimeStamp;
            arrayList.add(trafficMsg);
        }
        return filterLocalAddress(arrayList);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onBackground() {
        nativeSetForegroundState(2);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onForeground() {
        nativeSetForegroundState(1);
    }

    @Override // com.tencent.bugly.common.network.INetworkStateListener
    public void onNetworkStateChanged(int i3) {
        nativeSetNetworkState(i3);
    }

    public void saveAndReportTrafficInfo(boolean z16) {
        ArrayList<TrafficMsg> trafficInfo = getTrafficInfo();
        if (this.trafficEnabled) {
            Logger.f365497g.d(TAG, "saveTrafficMsgs");
            saveTrafficMsgs(trafficInfo);
        }
        if (this.trafficDetailEnabled) {
            Logger.f365497g.d(TAG, "reportTrafficMsgs");
            reportTrafficMsgs(trafficInfo, z16);
        }
    }

    public boolean setTrafficDetailEnabled(boolean z16) {
        this.trafficDetailEnabled = z16;
        return z16;
    }

    public boolean setTrafficEnabled(boolean z16) {
        this.trafficEnabled = z16;
        return z16;
    }

    public void start() {
        if ((this.trafficEnabled || this.trafficDetailEnabled) && !this.started.get() && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "traffic monitor start");
            this.started.set(true);
            this.lastReportTime = System.currentTimeMillis();
            if (!this.hasInited) {
                initOnce();
                this.hasInited = true;
            } else {
                nativeRestart();
            }
            Handler handler = this.handler;
            handler.sendMessageDelayed(handler.obtainMessage(1), 60000L);
        }
    }

    public void stop(boolean z16) {
        if (z16) {
            ArrayList<TrafficMsg> trafficInfo = getTrafficInfo();
            saveTrafficMsgs(trafficInfo);
            reportTrafficMsgs(trafficInfo, false);
            clearTrafficInfo();
        }
        if (!this.trafficEnabled && !this.trafficDetailEnabled) {
            Logger.f365497g.i(TAG, "traffic monitor stop");
            this.started.set(false);
            this.handler.removeMessages(1);
            nativeReleaseMatrixTraffic();
        }
    }

    TrafficMonitor() {
        this.lastReportTime = 0L;
        this.started = new AtomicBoolean(false);
        this.trafficEnabled = false;
        this.trafficDetailEnabled = false;
        this.hasInited = false;
        this.globalTrafficList = new ArrayList<>();
        this.wifiFrontendReportStatistic = new WiFiFrontendStatistic();
        this.wifiBackendReportStatistic = new WiFiBackendStatistic();
        this.mobileFrontendReportStatistic = new MobileFrontendStatistic();
        this.mobileBackendReportStatistic = new MobileBackendStatistic();
        this.reportStatistics = new ArrayList();
        this.wifiFrontendRecordStatistic = new WiFiFrontendStatistic();
        this.wifiBackendRecordStatistic = new WiFiBackendStatistic();
        this.mobileFrontendRecordStatistic = new MobileFrontendStatistic();
        this.mobileBackendRecordStatistic = new MobileBackendStatistic();
        this.recordStatistics = new ArrayList();
        this.handler = new Handler(ThreadManager.getMonitorThreadLooper()) { // from class: com.tencent.bugly.traffic.TrafficMonitor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    TrafficMonitor.this.saveAndReportTrafficInfo(false);
                    TrafficMonitor.this.clearTrafficInfo();
                    sendMessageDelayed(obtainMessage(1), 60000L);
                }
            }
        };
        this.trafficDetailPluginConfig = (TrafficDetailPluginConfig) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.TRAFFIC_DETAIL);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onCreate(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onDestroy(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPause(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPostCreate(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onResume(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStart(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStop(@NonNull Activity activity) {
    }
}

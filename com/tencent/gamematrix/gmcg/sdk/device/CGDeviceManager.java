package com.tencent.gamematrix.gmcg.sdk.device;

import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.device.CGDeviceManager;
import com.tencent.gamematrix.gmcg.sdk.device.CGGetServerListTask;
import com.tencent.gamematrix.gmcg.sdk.device.CGMeasureServerIntervalTask;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDeviceManager implements CGGetServerListTask.GetServerListResultListener, CGMeasureServerIntervalTask.CalcServerReqIntervalListener {
    private static final CGSingletonHelper<CGDeviceManager> sInstance = new CGSingletonHelper<CGDeviceManager>() { // from class: com.tencent.gamematrix.gmcg.sdk.device.CGDeviceManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGDeviceManager create() {
            return new CGDeviceManager();
        }
    };

    @NonNull
    private List<ServerInfo> mAvailableServerList;
    private Map<String, Integer> mCachedServersWithPing;
    private ExecutorService mExecutorService;
    private CGGetServerListTask mGetServerListTask;
    private List<CGMeasureServerIntervalTask> mMeasureServerIntervalTaskList;
    private CGQueryDeviceServersListener mQueryDeviceServersListener;
    private int mReqSeq;
    private String mReqTag;
    private int mServerMeasuredCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class ServerInfo {
        String address;
        boolean intervalMeasured = false;
        int interval = Integer.MAX_VALUE;

        ServerInfo(String str) {
            this.address = str;
        }
    }

    private void generateReqTag() {
        this.mReqTag = "PingTask-" + System.currentTimeMillis() + "-" + this.mReqSeq;
        this.mReqSeq = this.mReqSeq + 1;
    }

    public static CGDeviceManager get() {
        return sInstance.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$onAllServerMeasured$0(ServerInfo serverInfo, ServerInfo serverInfo2) {
        return Integer.compare(serverInfo.interval, serverInfo2.interval);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void onAllServerMeasured() {
        Collections.sort(this.mAvailableServerList, new Comparator() { // from class: com.tencent.gamematrix.gmcg.sdk.device.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$onAllServerMeasured$0;
                lambda$onAllServerMeasured$0 = CGDeviceManager.lambda$onAllServerMeasured$0((CGDeviceManager.ServerInfo) obj, (CGDeviceManager.ServerInfo) obj2);
                return lambda$onAllServerMeasured$0;
            }
        });
        this.mCachedServersWithPing = new HashMap();
        for (ServerInfo serverInfo : this.mAvailableServerList) {
            this.mCachedServersWithPing.put(CGStringUtil.parseNetworkAddress(serverInfo.address).first, Integer.valueOf(serverInfo.interval));
        }
        returnResult(this.mCachedServersWithPing);
    }

    private void returnResult(@NonNull Map<String, Integer> map) {
        CGLog.i("CGDeviceManager queryDeviceServers: return result");
        stopWorking();
        CGQueryDeviceServersListener cGQueryDeviceServersListener = this.mQueryDeviceServersListener;
        if (cGQueryDeviceServersListener != null) {
            cGQueryDeviceServersListener.onQueryDeviceServersGot(map);
            this.mQueryDeviceServersListener = null;
        }
    }

    private void stopWorking() {
        CGGetServerListTask cGGetServerListTask = this.mGetServerListTask;
        if (cGGetServerListTask != null) {
            cGGetServerListTask.cancel(true);
        }
        Iterator<CGMeasureServerIntervalTask> it = this.mMeasureServerIntervalTaskList.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.mGetServerListTask = null;
        this.mMeasureServerIntervalTaskList.clear();
        this.mAvailableServerList.clear();
        this.mServerMeasuredCount = 0;
        this.mReqSeq = 0;
    }

    private void tryGetAvailableServerList(String str) {
        CGGetServerListTask cGGetServerListTask = new CGGetServerListTask(this.mReqTag, str, this);
        this.mGetServerListTask = cGGetServerListTask;
        cGGetServerListTask.executeOnExecutor(this.mExecutorService, new Void[0]);
    }

    public void markCachePingsAsDirty() {
        stopWorking();
        this.mCachedServersWithPing = null;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.device.CGGetServerListTask.GetServerListResultListener
    public synchronized void onServerListGot(String str, List<String> list, boolean z16) {
        if (z16) {
            if (this.mReqTag.equals(str)) {
                this.mAvailableServerList.clear();
                if (list != null && list.size() > 0) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        this.mAvailableServerList.add(new ServerInfo(it.next()));
                    }
                    for (int i3 = 0; i3 < this.mAvailableServerList.size(); i3++) {
                        CGMeasureServerIntervalTask cGMeasureServerIntervalTask = new CGMeasureServerIntervalTask(this.mReqTag, this.mAvailableServerList.get(i3).address, i3, this);
                        cGMeasureServerIntervalTask.executeOnExecutor(this.mExecutorService, new Void[0]);
                        this.mMeasureServerIntervalTaskList.add(cGMeasureServerIntervalTask);
                    }
                } else {
                    returnResult(Collections.emptyMap());
                }
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.device.CGMeasureServerIntervalTask.CalcServerReqIntervalListener
    public synchronized void onServerReqIntervalGot(String str, int i3, String str2, int i16, boolean z16) {
        if (z16) {
            if (this.mReqTag.equals(str)) {
                if (i16 >= 0 && i16 < this.mAvailableServerList.size()) {
                    ServerInfo serverInfo = this.mAvailableServerList.get(i16);
                    if (serverInfo.address.equals(str2)) {
                        serverInfo.intervalMeasured = true;
                        serverInfo.interval = i3;
                        this.mServerMeasuredCount++;
                    }
                }
                if (this.mServerMeasuredCount == this.mAvailableServerList.size()) {
                    onAllServerMeasured();
                }
            }
        }
    }

    public void queryDeviceServers(String str, CGQueryDeviceServersListener cGQueryDeviceServersListener) {
        generateReqTag();
        stopWorking();
        this.mQueryDeviceServersListener = cGQueryDeviceServersListener;
        Map<String, Integer> map = this.mCachedServersWithPing;
        if (map != null && !map.isEmpty()) {
            returnResult(this.mCachedServersWithPing);
        } else {
            tryGetAvailableServerList(str);
        }
    }

    CGDeviceManager() {
        this.mAvailableServerList = new ArrayList();
        this.mServerMeasuredCount = 0;
        this.mExecutorService = ProxyExecutors.newCachedThreadPool();
        this.mMeasureServerIntervalTaskList = new ArrayList();
        this.mReqTag = "";
        this.mReqSeq = 0;
    }
}

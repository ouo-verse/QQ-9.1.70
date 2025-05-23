package com.tencent.tmassistant.st;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.h;
import com.tencent.tmassistantbase.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SDKReportManager2 implements com.tencent.tmassistant.st.c, INetworkChangedObserver {
    private static final int MSG_BATCH_REPORT = 2;
    private static final int MSG_POST_REPORT = 1;
    private static final String TAG = "SDKReportManager2";
    private static volatile SDKReportManager2 sInstance;
    private Handler mPostHandler;
    private d mStatReportEngine;
    private SparseArray<ArrayList<StatItem>> mTimelyStatListCache = new SparseArray<>();
    private Map<Integer, ArrayList<String>> mPostCache = new ConcurrentHashMap();
    private long mBatchReportInterval = 1800000;
    private int mBatchReportMaxCount = 50;
    private int mReportRetryCount = 2;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        a(SDKReportManager2 sDKReportManager2) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.tmdownloader.c.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                SDKReportManager2.this.timlyReport();
            } else if (i3 == 2) {
                SDKReportManager2.this.batchReport();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SDKReportManager2.this.mPostHandler != null) {
                h.c();
                if (com.tencent.tmdownloader.internal.downloadservice.b.b()) {
                    if (!SDKReportManager2.this.mPostHandler.hasMessages(2)) {
                        SDKReportManager2.this.mPostHandler.sendEmptyMessage(2);
                    }
                } else if (SDKReportManager2.this.mPostHandler.hasMessages(2)) {
                    SDKReportManager2.this.mPostHandler.removeMessages(2);
                }
            }
        }
    }

    SDKReportManager2() {
        if (!l.e()) {
            e.a().post(new a(this));
            return;
        }
        d dVar = new d();
        this.mStatReportEngine = dVar;
        dVar.a(this);
        initHandler();
        initConfig();
        registerNetWork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void batchReport() {
        Map<Integer, List<String>> c16 = com.tencent.tmdownloader.internal.storage.table.a.c();
        ArrayList<StatItem> arrayList = new ArrayList<>();
        if (c16 != null && c16.size() > 0) {
            Iterator<Integer> it = c16.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                ArrayList arrayList2 = (ArrayList) c16.get(Integer.valueOf(intValue));
                if (arrayList2.size() > 0) {
                    arrayList.add(new StatItem(intValue, arrayList2));
                }
            }
        }
        if (arrayList.size() > 0) {
            this.mStatReportEngine.a(arrayList);
        }
        this.mPostHandler.sendEmptyMessageDelayed(2, this.mBatchReportInterval);
    }

    private void cacheDataOnFailed(ArrayList<StatItem> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            SparseArray sparseArray = new SparseArray();
            Iterator<StatItem> it = arrayList.iterator();
            while (it.hasNext()) {
                StatItem next = it.next();
                List list = (List) sparseArray.get(next.type);
                if (list == null) {
                    list = new ArrayList();
                    sparseArray.put(next.type, list);
                }
                list.addAll(next.records);
            }
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                List list2 = (List) sparseArray.get(keyAt);
                ArrayList arrayList2 = new ArrayList();
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList2.add((String) it5.next());
                }
                com.tencent.tmdownloader.internal.storage.table.a.a(String.valueOf(keyAt), arrayList2);
            }
        }
    }

    public static SDKReportManager2 getInstance() {
        if (sInstance == null) {
            synchronized (SDKReportManager2.class) {
                if (sInstance == null) {
                    sInstance = new SDKReportManager2();
                }
            }
        }
        return sInstance;
    }

    private void initConfig() {
        com.tencent.tmdownloader.f.a.a.a().e();
        BatchReportConfig c16 = com.tencent.tmdownloader.f.b.b.a().c();
        if (c16 != null) {
            long j3 = c16.batchReportInterval;
            if (j3 > 0) {
                this.mBatchReportInterval = j3;
                this.mBatchReportMaxCount = c16.batchReportMaxCount;
                this.mReportRetryCount = c16.reportRetryCount;
            }
        }
    }

    private void initHandler() {
        b bVar = new b(e.b(e.b.f380463a));
        this.mPostHandler = bVar;
        bVar.sendEmptyMessage(2);
    }

    private void registerNetWork() {
        NetworkMonitorReceiver.getInstance().registerReceiver();
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timlyReport() {
        Set<Integer> keySet = this.mPostCache.keySet();
        if (keySet != null && keySet.size() > 0) {
            ArrayList<StatItem> arrayList = new ArrayList<>();
            Iterator<Integer> it = keySet.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue > 0 && this.mPostCache.get(Integer.valueOf(intValue)) != null) {
                    StatItem statItem = new StatItem();
                    statItem.type = intValue;
                    statItem.records = this.mPostCache.get(Integer.valueOf(intValue));
                    arrayList.add(statItem);
                }
            }
            this.mPostCache.clear();
            if (arrayList.size() > 0) {
                this.mTimelyStatListCache.put(this.mStatReportEngine.a(arrayList), arrayList);
            }
        }
    }

    @Override // com.tencent.tmassistantbase.network.INetworkChangedObserver
    public void onNetworkChanged() {
        e.a().post(new c());
    }

    @Override // com.tencent.tmassistant.st.c
    public void onStatReportFinish(int i3, StatReportRequest statReportRequest, StatReportResponse statReportResponse, int i16) {
        ArrayList<StatItem> arrayList = this.mTimelyStatListCache.get(i3);
        if (i16 != 0) {
            cacheDataOnFailed(arrayList);
        }
        this.mTimelyStatListCache.delete(i3);
    }

    public synchronized void postReport(int i3, String str) {
        if (!l.e()) {
            com.tencent.tmdownloader.c.a().a(i3, str);
            return;
        }
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = this.mPostCache.get(Integer.valueOf(i3));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mPostCache.put(Integer.valueOf(i3), arrayList);
            }
            arrayList.add(str);
            this.mPostHandler.removeMessages(1);
            this.mPostHandler.sendEmptyMessageDelayed(1, 500L);
        }
    }
}

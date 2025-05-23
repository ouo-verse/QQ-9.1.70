package np3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.open.agent.report.d;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lp3.a;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements a.InterfaceC10743a, NetworkState.NetworkStateListener {

    /* renamed from: g, reason: collision with root package name */
    private static a f420660g;

    /* renamed from: a, reason: collision with root package name */
    private lp3.a f420661a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f420662b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<ArrayList<StatItem>> f420663c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<ArrayList<StatItem>> f420664d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, ArrayList<String>> f420665e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private long f420666f = 1800000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: np3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class HandlerC10861a extends Handler {
        HandlerC10861a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                Set keySet = a.this.f420665e.keySet();
                if (keySet != null && keySet.size() > 0) {
                    ArrayList<StatItem> arrayList = new ArrayList<>();
                    Iterator it = keySet.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        StatItem statItem = new StatItem();
                        statItem.type = intValue;
                        statItem.records = (ArrayList) a.this.f420665e.get(Integer.valueOf(intValue));
                        arrayList.add(statItem);
                    }
                    a.this.f420665e.clear();
                    if (arrayList.size() > 0) {
                        a.this.f420663c.put(a.this.f420661a.b(arrayList), arrayList);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == 2) {
                List<Integer> d16 = d.e().d();
                ArrayList<StatItem> arrayList2 = new ArrayList<>();
                Iterator<Integer> it5 = d16.iterator();
                while (it5.hasNext()) {
                    int intValue2 = it5.next().intValue();
                    List<Serializable> f16 = d.e().f(String.valueOf(intValue2));
                    ArrayList arrayList3 = new ArrayList();
                    if (f16 != null) {
                        Iterator<Serializable> it6 = f16.iterator();
                        while (it6.hasNext()) {
                            try {
                                arrayList3.add((String) it6.next());
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    if (arrayList3.size() > 0) {
                        arrayList2.add(new StatItem(intValue2, arrayList3));
                    }
                }
                if (arrayList2.size() > 0) {
                    a.this.f420664d.put(a.this.f420661a.b(arrayList2), arrayList2);
                }
                a.this.f420662b.sendEmptyMessageDelayed(2, a.this.f420666f);
            }
        }
    }

    a() {
        lp3.a aVar = new lp3.a();
        this.f420661a = aVar;
        aVar.c(this);
        h();
    }

    public static synchronized a g() {
        a aVar;
        synchronized (a.class) {
            if (f420660g == null) {
                f420660g = new a();
            }
            aVar = f420660g;
        }
        return aVar;
    }

    private void h() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("thread_report");
        baseHandlerThread.start();
        HandlerC10861a handlerC10861a = new HandlerC10861a(baseHandlerThread.getLooper());
        this.f420662b = handlerC10861a;
        handlerC10861a.sendEmptyMessage(2);
    }

    public void i(int i3, DownloadInfo downloadInfo) {
        boolean z16;
        if (MobileQQ.sProcessId == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (downloadInfo != null && z16) {
            j(9, (System.currentTimeMillis() / 1000) + "|" + downloadInfo.f341184e + "|" + downloadInfo.I + "|" + downloadInfo.f341189h + "|" + downloadInfo.J + "|" + i3 + "|" + downloadInfo.f341180b0 + "|" + downloadInfo.C);
        }
    }

    public void j(int i3, String str) {
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = this.f420665e.get(Integer.valueOf(i3));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f420665e.put(Integer.valueOf(i3), arrayList);
            }
            arrayList.add(str);
            this.f420662b.removeMessages(1);
            this.f420662b.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.tencent.component.network.module.common.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16) {
            if (!this.f420662b.hasMessages(2)) {
                this.f420662b.sendEmptyMessage(2);
            }
        } else if (this.f420662b.hasMessages(2)) {
            this.f420662b.removeMessages(2);
        }
    }

    @Override // lp3.a.InterfaceC10743a
    public void onStatReportFinish(int i3, StatReportRequest statReportRequest, StatReportResponse statReportResponse, int i16) {
        boolean z16;
        Log.i("selfupdeReport", "circleTest reportLog onReportFinish errorCode = " + i16);
        ArrayList<StatItem> arrayList = this.f420663c.get(i3);
        if (arrayList == null) {
            arrayList = this.f420664d.get(i3);
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 != 0) {
            if (arrayList != null && arrayList.size() > 0 && !z16) {
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
                for (int i17 = 0; i17 < size; i17++) {
                    int keyAt = sparseArray.keyAt(i17);
                    List list2 = (List) sparseArray.get(keyAt);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList2.add((String) it5.next());
                    }
                    List<Serializable> f16 = d.e().f(String.valueOf(keyAt));
                    if (f16 != null) {
                        arrayList2.addAll(f16);
                    }
                    d.e().h(String.valueOf(keyAt), arrayList2);
                }
            }
        } else if (z16 && arrayList != null && arrayList.size() > 0) {
            Iterator<StatItem> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                d.e().a(String.valueOf(it6.next().type));
            }
        }
        this.f420663c.delete(i3);
        this.f420664d.delete(i3);
    }
}

package kj;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements RFWDownloadQueueResultListener, NetworkState.NetworkStateListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f412540f;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Set<RFWDownloadQueueResultListener>> f412541d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, List<RFWDownloadTaskStateData>> f412542e = new HashMap<>();

    b() {
        RFWDownloadQueue.getInstance().addDownloadListener(j9.a.f409661a.b(), this);
    }

    public static b l() {
        if (f412540f == null) {
            synchronized (b.class) {
                f412540f = new b();
            }
        }
        return f412540f;
    }

    public void c(String str) {
        RFWDownloadQueue.getInstance().cancelTask(j9.a.f409661a.b(), str);
    }

    public void d(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        if (list == null) {
            return;
        }
        Iterator<RFWDownloadTaskStateData> it = list.iterator();
        while (it.hasNext()) {
            RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.b(), it.next().getUrl());
        }
    }

    public void e(String str) {
        RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.b(), str);
    }

    public List<RFWDownloadTaskStateData> g(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        return list != null ? list : new ArrayList();
    }

    public int h(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long i(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        long j3 = 0;
        if (list == null) {
            return 0L;
        }
        for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
            if (rFWDownloadTaskStateData.getTaskGenerateTime() > j3) {
                j3 = rFWDownloadTaskStateData.getTaskGenerateTime();
            }
        }
        return j3;
    }

    public boolean j(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        if (list == null) {
            return false;
        }
        for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
            if (rFWDownloadTaskStateData.getState() == DownloadState.STATE_START_RUN || rFWDownloadTaskStateData.getState() == DownloadState.STATE_RUNNING) {
                return true;
            }
        }
        return false;
    }

    public boolean k(String str) {
        List<RFWDownloadTaskStateData> list = this.f412542e.get(str);
        if (list == null) {
            return false;
        }
        Iterator<RFWDownloadTaskStateData> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getState() == DownloadState.STATE_WAITING) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        RFWDownloadQueue.getInstance().cancelBizAllTask(j9.a.f409661a.b());
        this.f412541d.clear();
        this.f412542e.clear();
    }

    public void q(String str) {
        RFWDownloadQueue.getInstance().pauseTask(j9.a.f409661a.b(), str);
    }

    public void r(final String str, final RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback) {
        RFWDownloadQueue.getInstance().queryBizTaskStateList(j9.a.f409661a.b(), new RFWDownloadQueue.QueryBizTaskStateCallback() { // from class: kj.a
            @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
            public final void onTaskListRsp(List list) {
                b.this.o(queryBizTaskStateCallback, str, list);
            }
        });
    }

    public void s(String str, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        if (TextUtils.isEmpty(str) || rFWDownloadQueueResultListener == null) {
            return;
        }
        Set<RFWDownloadQueueResultListener> set = this.f412541d.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.f412541d.put(str, set);
        }
        set.add(rFWDownloadQueueResultListener);
    }

    public void b(RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        if (rFWDownloadQueueTaskInfo == null) {
            QLog.e("QZoneIntimateAlbumDownloadManager", 1, "[addDownloadTask]  taskInfo == null");
        } else if (rFWDownloadQueueTaskInfo.getExtMap() != null && !TextUtils.isEmpty(m(rFWDownloadQueueTaskInfo.getExtMap()))) {
            RFWDownloadQueue.getInstance().addTask(j9.a.f409661a.b(), rFWDownloadQueueTaskInfo);
            f("ev_qz_launch_download", rFWDownloadQueueTaskInfo.getExtMap());
        } else {
            QLog.e("QZoneIntimateAlbumDownloadManager", 1, "[addDownloadTask]  no add spaceId");
        }
    }

    private void f(String str, HashMap<String, String> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("close_friend_space_id", hashMap.get("ext_key_space_id"));
        hashMap2.put("close_friend_space_type", hashMap.get("ext_key_space_type"));
        hashMap2.put("uin", hashMap.get("ext_key_uin"));
        hashMap2.put("uid", hashMap.get("ext_key_uid"));
        hashMap2.put("pic_id", hashMap.get("ext_key_pic_id"));
        hashMap2.put("video_id", hashMap.get("ext_key_video_id"));
        fo.c.c(str, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void o(RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, List<RFWDownloadTaskStateData> list, String str) {
        if (list != null) {
            for (RFWDownloadTaskStateData rFWDownloadTaskStateData : list) {
                String m3 = m(rFWDownloadTaskStateData.getExtMap());
                List<RFWDownloadTaskStateData> list2 = this.f412542e.get(m3);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.f412542e.put(m3, list2);
                }
                ListIterator<RFWDownloadTaskStateData> listIterator = list2.listIterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        if (TextUtils.equals(rFWDownloadTaskStateData.getUrl(), listIterator.next().getUrl())) {
                            listIterator.remove();
                            break;
                        }
                    }
                }
                list2.add(rFWDownloadTaskStateData);
            }
        }
        List<RFWDownloadTaskStateData> list3 = this.f412542e.get(str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleQueryBizTaskStateList] | querySpaceId = ");
        sb5.append(str);
        sb5.append(" | list = ");
        sb5.append(list3 != null ? list3.size() : 0);
        sb5.append(" | allSize = ");
        sb5.append(this.f412542e.values().size());
        QLog.i("QZoneIntimateAlbumDownloadManager", 1, sb5.toString());
        if (queryBizTaskStateCallback == null || TextUtils.isEmpty(str)) {
            return;
        }
        queryBizTaskStateCallback.onTaskListRsp(list3);
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData == null || !TextUtils.equals(rFWDownloadTaskStateData.getBusinessKey(), j9.a.f409661a.b().getBusinessKey())) {
            return;
        }
        String m3 = m(rFWDownloadTaskStateData.getExtMap());
        List<RFWDownloadTaskStateData> list = this.f412542e.get(m3);
        if (list == null) {
            list = new ArrayList<>();
            this.f412542e.put(m3, list);
        }
        ListIterator<RFWDownloadTaskStateData> listIterator = list.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (TextUtils.equals(rFWDownloadTaskStateData.getUrl(), listIterator.next().getUrl())) {
                listIterator.remove();
                break;
            }
        }
        if (rFWDownloadTaskStateData.getState() == DownloadState.STATE_SUCCESS) {
            f("ev_qz_download_complete", rFWDownloadTaskStateData.getExtMap());
        } else if (rFWDownloadTaskStateData.getState() != DownloadState.STATE_CANCEL) {
            list.add(rFWDownloadTaskStateData);
        }
        QLog.i("QZoneIntimateAlbumDownloadManager", 1, "[onStateChange]  after filter | spaceId = " + m3 + " | listSize = " + this.f412542e.values().size());
        Set<RFWDownloadQueueResultListener> set = this.f412541d.get(m3);
        if (set != null) {
            Iterator<RFWDownloadQueueResultListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onStateChange(rFWDownloadTaskStateData);
            }
        }
    }

    public void t(String str, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        if (rFWDownloadQueueResultListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("QZoneIntimateAlbumDownloadManager", RFWLog.USR, "unregisterDownloadListener spaceId is null");
            Iterator<Map.Entry<String, Set<RFWDownloadQueueResultListener>>> it = this.f412541d.entrySet().iterator();
            while (it.hasNext()) {
                Set<RFWDownloadQueueResultListener> value = it.next().getValue();
                if (value != null) {
                    value.remove(rFWDownloadQueueResultListener);
                }
            }
            return;
        }
        Set<RFWDownloadQueueResultListener> set = this.f412541d.get(str);
        if (set == null) {
            return;
        }
        set.remove(rFWDownloadQueueResultListener);
    }

    private String m(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return hashMap.get("ext_key_space_id");
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
    }
}

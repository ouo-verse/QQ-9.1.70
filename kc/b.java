package kc;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u00010B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J2\u0010\u0007\u001a\u0004\u0018\u00010\u00042&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0002J,\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001f\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0010\u0010!\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0012\u0010#\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010%\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0001J\u001a\u0010&\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0001J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u001dH\u0016R@\u0010+\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010)0\u0003j\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010)`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010*R@\u0010-\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,0\u0003j\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0,`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*\u00a8\u00061"}, d2 = {"Lkc/b;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "Lcooperation/qzone/util/NetworkState$NetworkStateListener;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/queue/RFWDownloadQueue$QueryBizTaskStateCallback;", "callback", "", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskStateDataList", "queryQzoneId", "", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueTaskInfo;", "taskInfo", "d", "url", "o", "g", "qzoneId", "f", "e", "p", "", "i", h.F, "", "k", "l", "", "j", "taskState", "onStateChange", "listener", "r", ReportConstant.COSTREPORT_PREFIX, "connected", "onNetworkConnect", "", "Ljava/util/HashMap;", "mListenerMap", "", "mTaskStateListMap", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements RFWDownloadQueueResultListener, NetworkState.NetworkStateListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static volatile b f412000h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Set<RFWDownloadQueueResultListener>> mListenerMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, List<RFWDownloadTaskStateData>> mTaskStateListMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lkc/b$a;", "", "Lkc/b;", "a", "()Lkc/b;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "sInstance", "Lkc/b;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kc.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            if (b.f412000h == null) {
                synchronized (b.class) {
                    b.f412000h = new b(null);
                    Unit unit = Unit.INSTANCE;
                }
            }
            b bVar = b.f412000h;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void n(RFWDownloadQueue.QueryBizTaskStateCallback callback, List<? extends RFWDownloadTaskStateData> taskStateDataList, String queryQzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(queryQzoneId);
        if (list != null) {
            list.clear();
        }
        if (taskStateDataList != null) {
            for (RFWDownloadTaskStateData rFWDownloadTaskStateData : taskStateDataList) {
                String m3 = m(rFWDownloadTaskStateData.getExtMap());
                List<RFWDownloadTaskStateData> list2 = this.mTaskStateListMap.get(m3);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.mTaskStateListMap.put(m3, list2);
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
        List<RFWDownloadTaskStateData> list3 = this.mTaskStateListMap.get(queryQzoneId);
        int size = list3 != null ? list3.size() : 0;
        QLog.i("QZAlbumxAlbumDownloadManager", 1, "[handleQueryBizTaskStateList] | queryQzoneId = " + queryQzoneId + " | list = " + size + " | allSize = " + this.mTaskStateListMap.values().size());
        if (callback == null || TextUtils.isEmpty(queryQzoneId)) {
            return;
        }
        callback.onTaskListRsp(list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(b this$0, RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, String str, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n(queryBizTaskStateCallback, list, str);
    }

    public final void e(String url) {
        RFWDownloadQueue.getInstance().cancelTask(j9.a.f409661a.c(), url);
    }

    public final void f(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
        if (list == null) {
            return;
        }
        Iterator<RFWDownloadTaskStateData> it = list.iterator();
        while (it.hasNext()) {
            RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.c(), it.next().getUrl());
        }
    }

    public final void g(String url) {
        RFWDownloadQueue.getInstance().continueTask(j9.a.f409661a.c(), url);
    }

    public final List<RFWDownloadTaskStateData> h(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
        return list == null ? new ArrayList() : list;
    }

    public final int i(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final long j(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
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

    public final boolean k(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
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

    public final boolean l(String qzoneId) {
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(qzoneId);
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

    public final void o(String url) {
        RFWDownloadQueue.getInstance().pauseTask(j9.a.f409661a.c(), url);
    }

    public final void p(final String qzoneId, final RFWDownloadQueue.QueryBizTaskStateCallback callback) {
        RFWDownloadQueue.getInstance().queryBizTaskStateList(j9.a.f409661a.c(), new RFWDownloadQueue.QueryBizTaskStateCallback() { // from class: kc.a
            @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
            public final void onTaskListRsp(List list) {
                b.q(b.this, callback, qzoneId, list);
            }
        });
    }

    public final void r(String qzoneId, RFWDownloadQueueResultListener listener) {
        if (TextUtils.isEmpty(qzoneId) || listener == null) {
            return;
        }
        Set<RFWDownloadQueueResultListener> set = this.mListenerMap.get(qzoneId);
        if (set == null) {
            set = new HashSet<>();
            this.mListenerMap.put(qzoneId, set);
        }
        set.add(listener);
    }

    b() {
        this.mListenerMap = new HashMap<>();
        this.mTaskStateListMap = new HashMap<>();
        RFWDownloadQueue.getInstance().addDownloadListener(j9.a.f409661a.c(), this);
    }

    public final void d(RFWDownloadQueueTaskInfo taskInfo) {
        if (taskInfo == null) {
            QLog.e("QZAlbumxAlbumDownloadManager", 1, "[addDownloadTask]  taskInfo == null");
        } else if (taskInfo.getExtMap() != null && !TextUtils.isEmpty(m(taskInfo.getExtMap()))) {
            RFWDownloadQueue.getInstance().addTask(j9.a.f409661a.c(), taskInfo);
        } else {
            QLog.e("QZAlbumxAlbumDownloadManager", 1, "[addDownloadTask]  no add groupId");
        }
    }

    private final String m(HashMap<String, String> extMap) {
        if (extMap != null) {
            return extMap.get("ext_key_space_id");
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData taskState) {
        if (taskState == null || !TextUtils.equals(taskState.getBusinessKey(), j9.a.f409661a.c().getBusinessKey())) {
            return;
        }
        String m3 = m(taskState.getExtMap());
        List<RFWDownloadTaskStateData> list = this.mTaskStateListMap.get(m3);
        if (list == null) {
            list = new ArrayList<>();
            this.mTaskStateListMap.put(m3, list);
        }
        ListIterator<RFWDownloadTaskStateData> listIterator = list.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (TextUtils.equals(taskState.getUrl(), listIterator.next().getUrl())) {
                listIterator.remove();
                break;
            }
        }
        if (taskState.getState() != DownloadState.STATE_SUCCESS && taskState.getState() != DownloadState.STATE_CANCEL) {
            list.add(taskState);
        }
        if (taskState.getState() != DownloadState.STATE_RUNNING) {
            QLog.i("QZAlbumxAlbumDownloadManager", 1, "[onStateChange]  after filter | qzoneId = " + m3 + " | listSize = " + this.mTaskStateListMap.values().size());
        }
        Set<RFWDownloadQueueResultListener> set = this.mListenerMap.get(m3);
        if (set != null) {
            try {
                Iterator<RFWDownloadQueueResultListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onStateChange(taskState);
                }
            } catch (Exception e16) {
                xe.b.f447841a.d(e16);
            }
        }
    }

    public final void s(String qzoneId, RFWDownloadQueueResultListener listener) {
        if (listener == null) {
            return;
        }
        if (TextUtils.isEmpty(qzoneId)) {
            RFWLog.e("QZAlbumxAlbumDownloadManager", RFWLog.USR, "unregisterDownloadListener qzoneId is null");
            Set<Map.Entry<String, Set<RFWDownloadQueueResultListener>>> entrySet = this.mListenerMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "mListenerMap.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                Set set = (Set) value;
                if (set != null) {
                    set.remove(listener);
                }
            }
            return;
        }
        Set<RFWDownloadQueueResultListener> set2 = this.mListenerMap.get(qzoneId);
        if (set2 == null) {
            return;
        }
        set2.remove(listener);
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean connected) {
    }
}

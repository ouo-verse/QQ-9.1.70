package com.tencent.biz.qqcircle.immersive.feed.ad.preload;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSLifecycleCollectionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSReplaceFeedSourceEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.manager.c;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRecomInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import seal.SealEdgeComputing$AdvertInfo;
import seal.SealEdgeComputing$ClientItemInfo;
import uq3.o;

/* loaded from: classes4.dex */
public class QFSAdFeedSourcePreloadManager implements c.a, a.InterfaceC0880a {

    /* renamed from: g, reason: collision with root package name */
    private static volatile QFSAdFeedSourcePreloadManager f85720g;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QFSTabFeedViewModel> f85721a;

    /* renamed from: b, reason: collision with root package name */
    private a f85722b;

    /* renamed from: c, reason: collision with root package name */
    private QFSLifecycleCollectionEvent.d f85723c;

    /* renamed from: d, reason: collision with root package name */
    private QFSLifecycleCollectionEvent.b f85724d;

    /* renamed from: e, reason: collision with root package name */
    private String f85725e = "";

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Integer> f85726f = new ConcurrentHashMap();

    /* loaded from: classes4.dex */
    public enum UpdateSnapshotType {
        REGISTER,
        SEL_POI,
        RESUME
    }

    QFSAdFeedSourcePreloadManager() {
        c.d().f(this);
        com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.c cVar = new com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.c();
        this.f85722b = cVar;
        cVar.d(this);
    }

    private Pair<List<b>, List<b>> d(List<b> list, List<b> list2, String str) {
        FeedCloudMeta$StFeed g16;
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo;
        SealEdgeComputing$AdvertInfo sealEdgeComputing$AdvertInfo;
        PBStringField pBStringField;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Pair<List<b>, List<b>> pair = new Pair<>(arrayList, arrayList2);
        if (list2 != null && !list2.isEmpty()) {
            for (b bVar : list2) {
                b bVar2 = null;
                if (bVar == null) {
                    g16 = null;
                } else {
                    g16 = bVar.g();
                }
                if (g16 != null && (feedCloudMeta$StRecomInfo = g16.recomInfo) != null && feedCloudMeta$StRecomInfo.clientSealData != null) {
                    try {
                        sealEdgeComputing$AdvertInfo = new SealEdgeComputing$ClientItemInfo().mergeFrom(g16.recomInfo.clientSealData.get().toByteArray()).advert_info;
                    } catch (Throwable unused) {
                    }
                    if (sealEdgeComputing$AdvertInfo != null && (pBStringField = sealEdgeComputing$AdvertInfo.replaced_ad_feedid) != null && (bVar2 = e(pBStringField.get(), list)) != null) {
                        if (TextUtils.equals(bj.g(bVar2), bj.g(bVar))) {
                            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[convertReplaceSourcePair] origin and replace is equal,add fail");
                        } else {
                            arrayList.add(bVar2);
                            arrayList2.add(bVar);
                            r(bVar2, bVar, str);
                        }
                    }
                }
            }
        }
        return pair;
    }

    private b e(String str, List<b> list) {
        FeedCloudMeta$StFeed g16;
        if (list != null && !list.isEmpty()) {
            for (b bVar : list) {
                if (bVar == null) {
                    g16 = null;
                } else {
                    g16 = bVar.g();
                }
                if (g16 != null && TextUtils.equals(str, g16.f398449id.get())) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private void f(QFSLifecycleCollectionEvent.a aVar) {
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[handlerApplicationLifecycle] info: " + aVar);
        if (aVar.a() == QFSLifecycleCollectionEvent.QFSApplicationLifecycleEnum.FOREGROUND && l()) {
            s();
        }
    }

    private void g(QFSLifecycleCollectionEvent.b bVar) {
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[handlerBusinessLifecycle] info: " + bVar);
        if (bVar.a() == QFSLifecycleCollectionEvent.QFSBusinessLifecycleEnum.RELEASE) {
            q();
        }
        this.f85724d = bVar;
    }

    private void h(QFSLifecycleCollectionEvent.c cVar) {
        if (cVar == null || cVar.b() != QFSLifecycleCollectionEvent.QFSListLifecycleEnum.SELECTED || !m(cVar.a()) || !n()) {
            return;
        }
        if (this.f85722b == null) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[handlerListLifecycle] ad feed source preload task should not null.");
            return;
        }
        int c16 = cVar.c();
        String a16 = cVar.a();
        Integer num = this.f85726f.get(a16);
        if (num == null || num.intValue() != c16) {
            t(UpdateSnapshotType.SEL_POI);
            this.f85722b.c(c16);
            this.f85726f.put(a16, Integer.valueOf(c16));
        }
    }

    private void i(QFSLifecycleCollectionEvent.d dVar) {
        this.f85723c = dVar;
        if (l() && dVar.c() == QFSLifecycleCollectionEvent.QFSPageLifecycleEnum.ON_RESUME) {
            s();
        }
    }

    public static QFSAdFeedSourcePreloadManager k() {
        if (f85720g == null) {
            synchronized (QFSAdFeedSourcePreloadManager.class) {
                if (f85720g == null) {
                    f85720g = new QFSAdFeedSourcePreloadManager();
                }
            }
        }
        return f85720g;
    }

    private boolean l() {
        String b16;
        QFSLifecycleCollectionEvent.d dVar = this.f85723c;
        if (dVar == null) {
            b16 = null;
        } else {
            b16 = dVar.b();
        }
        return m(b16);
    }

    private boolean m(String str) {
        return TextUtils.equals(str, "pg_xsj_explore_page");
    }

    private boolean n() {
        return o.z1();
    }

    private void q() {
        if (!n()) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[releaseTask] close preload ad feed.");
            return;
        }
        a aVar = this.f85722b;
        if (aVar == null) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[releaseTask] release ad feed source preload task.");
        } else {
            aVar.release();
        }
    }

    private void r(b bVar, b bVar2, String str) {
        FeedCloudMeta$StFeed g16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (bVar2 == null) {
            g16 = null;
        } else {
            g16 = bVar2.g();
        }
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        }
        if (g16 != null && feedCloudMeta$StFeed != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(400);
            dataBuilder.setSubActionType(100);
            dataBuilder.setPageId(this.f85723c.a());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("replace_result", 1);
                jSONObject.put("after_replace_feedid", bj.g(g16));
                jSONObject.put("replace_traceid", str);
            } catch (JSONException e16) {
                RFWLog.e("QASP-QFSAdPreloadManager", RFWLog.USR, "[reportReplaceAdFeedToDC5507] error: ", e16);
            }
            dataBuilder.setExt10(jSONObject.toString());
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void s() {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        String name;
        if (!n()) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[updatePageResumeState] close preload ad feed.");
            return;
        }
        if (this.f85722b != null && this.f85723c != null) {
            WeakReference<QFSTabFeedViewModel> weakReference = this.f85721a;
            QCircleTabInfo qCircleTabInfo = null;
            if (weakReference == null) {
                qFSTabFeedViewModel = null;
            } else {
                qFSTabFeedViewModel = weakReference.get();
            }
            if (qFSTabFeedViewModel != null) {
                qCircleTabInfo = qFSTabFeedViewModel.w2();
            }
            if (qCircleTabInfo == null) {
                name = "";
            } else {
                name = qCircleTabInfo.getName();
            }
            if (TextUtils.isEmpty(name)) {
                RFWLog.w("QASP-QFSAdPreloadManager", RFWLog.DEV, "[updatePageResumeState] current scene tab name should not be null.");
                return;
            } else {
                t(UpdateSnapshotType.RESUME);
                this.f85722b.b(this.f85723c.b());
                return;
            }
        }
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[updatePageResumeState] start ad feed source preload task.");
    }

    private void t(UpdateSnapshotType updateSnapshotType) {
        QFSTabFeedViewModel qFSTabFeedViewModel;
        QCircleTabInfo w26;
        String name;
        MutableLiveData<QFSTabFeedViewModel.c> v26;
        QFSTabFeedViewModel.c value;
        if (this.f85722b == null) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[updateViewModelSnapshot] feed source preload task should not be null.");
            return;
        }
        WeakReference<QFSTabFeedViewModel> weakReference = this.f85721a;
        List<b> list = null;
        if (weakReference == null) {
            qFSTabFeedViewModel = null;
        } else {
            qFSTabFeedViewModel = weakReference.get();
        }
        if (qFSTabFeedViewModel == null) {
            w26 = null;
        } else {
            w26 = qFSTabFeedViewModel.w2();
        }
        if (w26 == null) {
            name = "";
        } else {
            name = w26.getName();
        }
        if (qFSTabFeedViewModel == null) {
            v26 = null;
        } else {
            v26 = qFSTabFeedViewModel.v2();
        }
        if (v26 == null) {
            value = null;
        } else {
            value = v26.getValue();
        }
        this.f85722b.a(value);
        if (value != null) {
            list = value.a();
        }
        String str = "tab name: " + name + " | snapshotSize: " + RFSafeListUtils.getSize(list) + " | type: " + updateSnapshotType;
        if (!TextUtils.equals(str, this.f85725e)) {
            this.f85725e = str;
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[updateViewModelSnapshot] updateSnapshotLog: " + str);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a.InterfaceC0880a
    public void a(long j3, String str, String str2) {
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[onAdFeedSourcePreloadFail] error code: " + j3 + " | error msg: " + str + " | traceId: " + str2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.manager.c.a
    public void b(QFSLifecycleCollectionEvent qFSLifecycleCollectionEvent) {
        if (qFSLifecycleCollectionEvent.c() == QFSLifecycleCollectionEvent.QFSCollectionType.LIST_LIFECYCLE) {
            h(qFSLifecycleCollectionEvent.d());
            return;
        }
        if (qFSLifecycleCollectionEvent.c() == QFSLifecycleCollectionEvent.QFSCollectionType.PAGE_LIFECYCLE) {
            i(qFSLifecycleCollectionEvent.e());
        } else if (qFSLifecycleCollectionEvent.c() == QFSLifecycleCollectionEvent.QFSCollectionType.BUSINESS_LIFECYCLE) {
            g(qFSLifecycleCollectionEvent.b());
        } else if (qFSLifecycleCollectionEvent.c() == QFSLifecycleCollectionEvent.QFSCollectionType.APPLICATION_LIFECYCLE) {
            f(qFSLifecycleCollectionEvent.a());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a.InterfaceC0880a
    public void c(List<b> list, List<b> list2, String str) {
        int size;
        int size2;
        List<b> list3;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (list2 == null) {
            size2 = 0;
        } else {
            size2 = list2.size();
        }
        Pair<List<b>, List<b>> d16 = d(list, list2, str);
        List<b> list4 = d16.first;
        if (list4 != null && !list4.isEmpty() && (list3 = d16.second) != null && !list3.isEmpty()) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[onAdFeedSourcePreloadFinish] originSourceSize: " + size + " | replaceSourceSize: " + size2 + " | replaceResultFirstSize: " + d16.first.size() + " | replaceResultSecondSize: " + d16.second.size() + " | traceId: " + str);
            SimpleEventBus.getInstance().dispatchEvent(new QFSReplaceFeedSourceEvent(d16.first, d16.second));
            return;
        }
        RFWLog.w("QASP-QFSAdPreloadManager", RFWLog.USR, "[onAdFeedSourcePreloadFinish] current replace source is null.");
    }

    public void j() {
        if (!n()) {
            return;
        }
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[init] init feed source preload, hash code: " + hashCode());
        s();
    }

    public void o(QFSTabFeedViewModel qFSTabFeedViewModel) {
        if (!n()) {
            return;
        }
        if (qFSTabFeedViewModel == null) {
            RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[registerViewModel] current update view model should not be null.");
        } else {
            this.f85721a = new WeakReference<>(qFSTabFeedViewModel);
            t(UpdateSnapshotType.REGISTER);
        }
    }

    public void p() {
        RFWLog.d("QASP-QFSAdPreloadManager", RFWLog.USR, "[release] release task, hash code: " + hashCode());
    }
}

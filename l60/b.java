package l60;

import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSMainPageLayerShareAdRequest;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$GetMainPageLayerShareADRsp;
import feedcloud.FeedCloudRead$ShareADItem;
import j30.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements j30.b, Call.OnRspCallBack<QCircleBaseRequest> {

    /* renamed from: d, reason: collision with root package name */
    private c f413879d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f413880e = 0;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f413881f = 0;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f413882h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f413883i = true;

    private void d(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            QLog.d("QFSPersonalLayerShareAdControl", 4, "debug req FeedIdList:", it.next());
        }
    }

    private void e(FeedCloudRead$GetMainPageLayerShareADRsp feedCloudRead$GetMainPageLayerShareADRsp, List<String> list, int i3, int i16) {
        QLog.d("QFSPersonalLayerShareAdControl", 1, "handleGetMainPageLayerShareAdRsp");
        this.f413882h = feedCloudRead$GetMainPageLayerShareADRsp.attach_info.get();
        List<FeedCloudRead$ShareADItem> list2 = feedCloudRead$GetMainPageLayerShareADRsp.items.get();
        HashMap hashMap = new HashMap();
        for (FeedCloudRead$ShareADItem feedCloudRead$ShareADItem : list2) {
            int i17 = feedCloudRead$ShareADItem.position.get() - 1;
            if (i17 < list.size()) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCloudRead$ShareADItem.ad_feed.get();
                if (i17 < 0) {
                    hashMap.put("0", feedCloudMeta$StFeed);
                } else {
                    hashMap.put(list.get(i17), feedCloudMeta$StFeed);
                }
                QLog.d("QFSPersonalLayerShareAdControl", 1, "shareADItem pos:", Integer.valueOf(feedCloudRead$ShareADItem.position.get()));
                QLog.d("QFSPersonalLayerShareAdControl", 1, "shareADItem content:", feedCloudMeta$StFeed.content.get());
            }
        }
        if (this.f413879d == null) {
            QLog.e("QFSPersonalLayerShareAdControl", 1, "insertFeedData error: mLayerController is null");
            return;
        }
        QLog.d("QFSPersonalLayerShareAdControl", 1, "insertFeedData start: startPos:", Integer.valueOf(i3), ", endPos:", Integer.valueOf(i16));
        this.f413879d.K7(i3, i16, hashMap, 1);
        this.f413881f = Math.max(i16 + hashMap.size(), this.f413881f);
        QLog.d("QFSPersonalLayerShareAdControl", 1, "update requestedEndPosIndex:", Integer.valueOf(this.f413881f));
    }

    private boolean f() {
        if (this.f413879d != null && j.f90213a.G()) {
            return true;
        }
        c cVar = this.f413879d;
        if (cVar != null && cVar.L4()) {
            return true;
        }
        return false;
    }

    private void h(int i3) {
        int i16;
        String str;
        int i17;
        if (this.f413879d == null) {
            QLog.e("QFSPersonalLayerShareAdControl", 1, "requestShareAds error: mLayerController is null");
            return;
        }
        int i18 = i3 + 10;
        if (!this.f413883i) {
            if (i3 >= this.f413880e && i18 <= this.f413881f) {
                QLog.d("QFSPersonalLayerShareAdControl", 1, "requestShareAds return, already requested");
                return;
            }
            if (i3 <= this.f413880e && i18 <= this.f413881f) {
                i18 = Math.max(this.f413880e - 1, 0);
                i17 = Math.max(i18 - 10, 0);
            } else if (i3 > this.f413881f && i18 > this.f413881f) {
                i17 = this.f413881f + 1;
                i18 = i17 + 10;
            } else {
                i17 = i3;
            }
            if (i3 < this.f413880e && i18 > this.f413880e) {
                i18 = this.f413880e;
            }
            if (i17 <= i18 && i17 >= 0) {
                i16 = i17;
            } else {
                QLog.e("QFSPersonalLayerShareAdControl", 1, "requestShareAds index error: startIndex:", Integer.valueOf(i17), ", endIndex:", Integer.valueOf(i18));
                return;
            }
        } else {
            i16 = i3;
        }
        QLog.d("QFSPersonalLayerShareAdControl", 1, "mIsFirstRequest:", Boolean.valueOf(this.f413883i), ", startIndex:", Integer.valueOf(i16), ", endIndex:", Integer.valueOf(i18));
        List<String> o26 = this.f413879d.o2(i16, i18);
        if (o26 != null && !o26.isEmpty()) {
            d(o26);
            int min = Math.min((o26.size() + i16) - 1, i18);
            if (this.f413879d.o6() != null) {
                str = this.f413879d.o6().f398463id.get();
            } else {
                str = "";
            }
            String str2 = str;
            this.f413879d.M4();
            com.tencent.biz.qqcircle.immersive.personal.request.b.n(o26, this.f413882h, str2, i16, min, this);
            if (this.f413883i) {
                this.f413880e = i16;
                this.f413881f = min;
                j.f90213a.T(str2);
            } else {
                this.f413880e = Math.min(i16, this.f413880e);
                this.f413881f = Math.max(min, this.f413881f);
            }
            this.f413883i = false;
            QLog.d("QFSPersonalLayerShareAdControl", 1, "mRequestedStartPosIndex:", Integer.valueOf(this.f413880e), ", mRequestedEndPosIndex:", Integer.valueOf(this.f413881f));
            return;
        }
        QLog.d("QFSPersonalLayerShareAdControl", 1, "requestShareAds return: feedIdList is null");
    }

    private void i() {
        this.f413880e = 0;
        this.f413881f = 0;
        this.f413882h = "";
        this.f413883i = true;
        j.f90213a.T("");
    }

    @Override // j30.b
    public void a(int i3) {
        if (!f()) {
            return;
        }
        QLog.d("QFSPersonalLayerShareAdControl", 1, "onPageSelect position:", Integer.valueOf(i3));
        if (!this.f413883i && i3 >= this.f413880e && i3 <= this.f413881f) {
            QLog.d("QFSPersonalLayerShareAdControl", 1, "onPageSelect return: no need to request, pos:", Integer.valueOf(i3), ", reqStartPos:", Integer.valueOf(this.f413880e), ", reqEndPos:", Integer.valueOf(this.f413881f));
        } else {
            h(i3);
        }
    }

    @Override // j30.b
    public void b(c cVar) {
        this.f413879d = cVar;
    }

    @Override // j30.b
    public void c() {
        if (!f()) {
            return;
        }
        QLog.d("QFSPersonalLayerShareAdControl", 1, "onPageBack");
        i();
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        if (qCircleBaseRequest instanceof QFSMainPageLayerShareAdRequest) {
            QLog.d("QFSPersonalLayerShareAdControl", 4, "QFSMainPageLayerShareAdRequest rsp trace_id:", qCircleBaseRequest.getTraceId());
            if (z16 && j3 == 0 && (obj instanceof FeedCloudRead$GetMainPageLayerShareADRsp)) {
                QFSMainPageLayerShareAdRequest qFSMainPageLayerShareAdRequest = (QFSMainPageLayerShareAdRequest) qCircleBaseRequest;
                e((FeedCloudRead$GetMainPageLayerShareADRsp) obj, qFSMainPageLayerShareAdRequest.getReqFeedIds(), qFSMainPageLayerShareAdRequest.getStartPos(), qFSMainPageLayerShareAdRequest.getEndPos());
            } else {
                QLog.d("QFSPersonalLayerShareAdControl", 1, "QFSMainPageLayerShareAdRequest rsp isSuccess:", Boolean.valueOf(z16), ", retCode:", Long.valueOf(j3), ", errMsg:", str);
            }
        }
    }
}

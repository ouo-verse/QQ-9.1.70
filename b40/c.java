package b40;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetUserAlbumRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudRead$GetUserAlbumListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a {
    public static final String D = "b40.c";

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<d> f27861m = new MutableLiveData<>();
    private MutableLiveData<a> C = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends LoadInfo {

        /* renamed from: a, reason: collision with root package name */
        public boolean f27862a;
    }

    private void Q1(QCircleGetUserAlbumRequest qCircleGetUserAlbumRequest, String str, boolean z16, long j3, String str2, FeedCloudRead$GetUserAlbumListRsp feedCloudRead$GetUserAlbumListRsp) {
        a aVar = new a();
        String str3 = D;
        QLog.d(str3, 1, "handleLoadMoreUserAlbumResponse isSuccess:" + z16 + " retCode:" + j3 + "errMsg:" + str2);
        if (z16 && j3 == 0 && feedCloudRead$GetUserAlbumListRsp != null) {
            aVar.f27862a = true;
            boolean z17 = feedCloudRead$GetUserAlbumListRsp.has_more.get();
            aVar.setFinish(!z17);
            if (feedCloudRead$GetUserAlbumListRsp.albums.get() == null) {
                aVar.setCurrentState(4);
                QLog.e(str3, 1, "no albums");
                this.C.setValue(aVar);
                return;
            }
            List<FeedCloudMeta$FeedAlbum> list = feedCloudRead$GetUserAlbumListRsp.albums.get();
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                Iterator<FeedCloudMeta$FeedAlbum> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new b40.a(it.next()));
                }
            }
            if (this.f27861m.getValue() != null && this.f27861m.getValue().a() != null) {
                arrayList.addAll(0, this.f27861m.getValue().a());
            }
            d dVar = new d(str, feedCloudRead$GetUserAlbumListRsp.attach_info.get(), z17, arrayList);
            dVar.f(feedCloudRead$GetUserAlbumListRsp.extInfo.get());
            this.f27861m.setValue(dVar);
            aVar.setCurrentState(4);
            this.C.setValue(aVar);
            return;
        }
        QLog.e(getLogTag(), 1, "[requestData] onReceive dispatch Error: | TraceId:" + qCircleGetUserAlbumRequest.getTraceId() + " | SeqId:" + qCircleGetUserAlbumRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2);
        d dVar2 = new d(str, null, false, null);
        aVar.setCurrentState(4);
        aVar.setFinish(false);
        aVar.f27862a = false;
        this.C.setValue(aVar);
        this.f27861m.setValue(dVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(QCircleGetUserAlbumRequest qCircleGetUserAlbumRequest, String str, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRead$GetUserAlbumListRsp feedCloudRead$GetUserAlbumListRsp) {
        Q1(qCircleGetUserAlbumRequest, str, z16, j3, str2, feedCloudRead$GetUserAlbumListRsp);
        QLog.d(D, 1, "requestData onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2 + " | isCache:" + VSNetworkHelper.isProtocolCache(str2));
    }

    private void U1(final String str) {
        String str2;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        if (str != null && !str.isEmpty()) {
            X1();
            final QCircleGetUserAlbumRequest qCircleGetUserAlbumRequest = new QCircleGetUserAlbumRequest();
            qCircleGetUserAlbumRequest.getRequest().user_id.set(str);
            String str3 = "";
            if (this.f27861m.getValue() == null) {
                str2 = "";
            } else {
                str2 = this.f27861m.getValue().c();
            }
            if (str2 != null) {
                str3 = str2;
            }
            qCircleGetUserAlbumRequest.getRequest().attach_info.set(str3);
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt2 = qCircleGetUserAlbumRequest.getRequest().extInfo;
            if (this.f27861m.getValue() != null) {
                feedCloudCommon$StCommonExt = this.f27861m.getValue().b();
            } else {
                feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
            }
            feedCloudCommon$StCommonExt2.set(feedCloudCommon$StCommonExt);
            VSNetworkHelper.getInstance().sendRequest(qCircleGetUserAlbumRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: b40.b
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str4, Object obj) {
                    c.this.S1(qCircleGetUserAlbumRequest, str, baseRequest, z16, j3, str4, (FeedCloudRead$GetUserAlbumListRsp) obj);
                }
            });
            return;
        }
        QLog.e(D, 1, "empty uin");
    }

    private void W1(Boolean bool) {
        a aVar = new a();
        aVar.setCurrentState(4);
        aVar.setFinish(!bool.booleanValue());
        aVar.f27862a = true;
        this.C.setValue(aVar);
    }

    private void X1() {
        a aVar = new a();
        aVar.setCurrentState(3);
        aVar.setFinish(false);
        aVar.f27862a = true;
        this.C.setValue(aVar);
    }

    public boolean M1() {
        if (this.f27861m.getValue() != null && this.f27861m.getValue().d() != null) {
            return true;
        }
        QLog.e(D, 1, "NO uer album or the uin is null");
        return false;
    }

    public void N1(long j3) {
        if (this.f27861m.getValue() == null) {
            return;
        }
        List<b40.a> a16 = this.f27861m.getValue().a();
        Iterator<b40.a> it = a16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().k().longValue() == j3) {
                it.remove();
                break;
            }
        }
        this.f27861m.setValue(new d(this.f27861m.getValue().d(), this.f27861m.getValue().c(), this.f27861m.getValue().e(), a16));
    }

    public MutableLiveData<a> O1() {
        return this.C;
    }

    public MutableLiveData<d> P1() {
        return this.f27861m;
    }

    public void R1(d dVar) {
        this.f27861m.setValue(dVar);
        W1(Boolean.valueOf(dVar.e()));
    }

    public void T1() {
        if (M1()) {
            U1(String.valueOf(this.f27861m.getValue().d()));
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return D;
    }
}

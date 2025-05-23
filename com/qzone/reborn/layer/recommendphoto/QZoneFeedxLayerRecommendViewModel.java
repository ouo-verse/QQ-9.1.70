package com.qzone.reborn.layer.recommendphoto;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.reborn.base.n;
import com.qzone.reborn.util.h;
import com.qzone.util.ac;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerRecommendViewModel extends n {
    private boolean D;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> f58096i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<QZoneFeedxLayerGalleryBean>> f58097m = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<AlumBasicData>> C = new MutableLiveData<>();
    private int E = 0;
    private final VasAdMetaCallback F = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(hashCode());
            sb5.append(" | requestFeedsData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | traceId: ");
            sb5.append(baseRequest.getTraceId());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | size:");
            sb5.append(feedCloudRead$StGetFeedListRsp != null ? feedCloudRead$StGetFeedListRsp.vecFeed.size() : 0);
            QLog.d("GuestInfoPanel", 1, sb5.toString());
            if (z16 && j3 == 0) {
                QZoneFeedxLayerRecommendViewModel.this.Z1(feedCloudRead$StGetFeedListRsp);
                return;
            }
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "get gallery entrance info fail, retCode is " + j3);
        }
    }

    private ArrayList<String> R1(List<FeedCloudMeta$StUser> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                FeedCloudMeta$StUser feedCloudMeta$StUser = list.get(i3);
                if (feedCloudMeta$StUser != null && !TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
                    arrayList.add(feedCloudMeta$StUser.f398463id.get());
                }
            }
            return arrayList;
        }
        RFWLog.e("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "stUsers is null or empty");
        return arrayList;
    }

    private void T1(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        String str;
        QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean = new QZoneFeedxLayerGalleryBean();
        if (qQCircleDitto$StItemContainer == null) {
            c2(qZoneFeedxLayerGalleryBean, false);
            return;
        }
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        if (list != null && list.size() >= 3) {
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size() && arrayList.size() < 3; i3++) {
                if (list.get(i3) != null && list.get(i3).images.get() != null && list.get(i3).images.get().get(0) != null && !TextUtils.isEmpty(list.get(i3).images.get().get(0).picUrl.get())) {
                    arrayList.add(list.get(i3).images.get().get(0).picUrl.get());
                    sb5.append(list.get(i3).f429300id.get());
                    if (arrayList.size() == 3) {
                        str = "";
                    } else {
                        str = Marker.ANY_NON_NULL_MARKER;
                    }
                    sb5.append(str);
                }
            }
            if (arrayList.size() < 3) {
                RFWLog.d("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "size less than 3 after filter");
                c2(qZoneFeedxLayerGalleryBean, false);
                return;
            }
            qZoneFeedxLayerGalleryBean.coverUrlList = arrayList;
            qZoneFeedxLayerGalleryBean.userList = R1(qQCircleDitto$StItemContainer.userList.get());
            qZoneFeedxLayerGalleryBean.jumpUrl = W1(qQCircleDitto$StItemContainer.urlInfo.get());
            qZoneFeedxLayerGalleryBean.galleryTitle = qQCircleDitto$StItemContainer.title.get();
            qZoneFeedxLayerGalleryBean.feedIdString = sb5.toString();
            c2(qZoneFeedxLayerGalleryBean, true);
            return;
        }
        RFWLog.d("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "size less than 3");
        c2(qZoneFeedxLayerGalleryBean, false);
    }

    private String W1(List<FeedCloudCommon$Entry> list) {
        if (list == null) {
            return "";
        }
        String g16 = h.g(list, WadlProxyConsts.KEY_JUMP_URL);
        if (TextUtils.isEmpty(g16)) {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "jump url is empty");
            return "";
        }
        return g16 + "&from=8";
    }

    private void b2(FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
        try {
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StDittoFeed.dittoDataNew.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZoneFeedxLayerRecommendViewModel", 1, "fetch tag data error", Log.getStackTraceString(e16));
        }
        i2(qQCircleDitto$StCircleDittoDataNew.itemContainter.get());
    }

    public void S1(RecomAlbumList recomAlbumList) {
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = new QZoneFeedxLayerRecommendPhotoBean();
        if (recomAlbumList == null) {
            d2(qZoneFeedxLayerRecommendPhotoBean, false);
            return;
        }
        List<AlbumCacheData[]> changeDataStructure = recomAlbumList.changeDataStructure(1);
        if (changeDataStructure != null && !changeDataStructure.isEmpty()) {
            if (changeDataStructure.size() < 2) {
                RFWLog.e("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "album cache data is illegal, size is smaller than 2");
                d2(qZoneFeedxLayerRecommendPhotoBean, false);
                return;
            }
            ArrayList arrayList = new ArrayList();
            long j3 = 0;
            String str = "";
            for (int i3 = 0; i3 < changeDataStructure.size(); i3++) {
                if (changeDataStructure.get(i3) != null && changeDataStructure.get(i3).length != 0 && changeDataStructure.get(i3)[0] != null) {
                    if (arrayList.size() >= 3) {
                        break;
                    }
                    if (TextUtils.isEmpty(str)) {
                        j3 = changeDataStructure.get(i3)[0].ownerUin;
                        str = changeDataStructure.get(i3)[0].albumOwner;
                    }
                    arrayList.add(changeDataStructure.get(i3)[0]);
                } else {
                    RFWLog.e("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "album cache data is illegal");
                }
            }
            if (arrayList.size() < 2) {
                d2(qZoneFeedxLayerRecommendPhotoBean, false);
                RFWLog.e("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "album cache data is illegal after filter, size is smaller than 2");
                return;
            }
            qZoneFeedxLayerRecommendPhotoBean.albumCacheDataList = arrayList;
            qZoneFeedxLayerRecommendPhotoBean.isShowHasMoreBtn = recomAlbumList.hasMore;
            qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin = j3;
            qZoneFeedxLayerRecommendPhotoBean.albumOwnerTitle = str;
            qZoneFeedxLayerRecommendPhotoBean.recomAlbumList = recomAlbumList;
            qZoneFeedxLayerRecommendPhotoBean.isDefaultStyle = arrayList.size() >= 3;
            d2(qZoneFeedxLayerRecommendPhotoBean, recomAlbumList.canBeShown());
            return;
        }
        RFWLog.e("QZoneFeedxLayerRecommendViewModel", RFWLog.USR, "recommend album list is null or empty");
        d2(qZoneFeedxLayerRecommendPhotoBean, false);
    }

    public MutableLiveData<UIStateData<AlumBasicData>> U1() {
        return this.C;
    }

    public MutableLiveData<UIStateData<QZoneFeedxLayerRecommendPhotoBean>> X1() {
        return this.f58096i;
    }

    public void e2() {
        final long uin = LoginData.getInstance().getUin();
        if (QZLog.isColorLevel()) {
            QZLog.i("DynamicPictureAdapter", "getGdtInfoRequest uin= " + uin + "advType = 2");
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                vac_adv_get.QzoneBusiMsg qzoneBusiMsg = new vac_adv_get.QzoneBusiMsg();
                qzoneBusiMsg.device_info.set(QZoneRequest.getDeiviceInfoDetail(true));
                ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).requestAdvAsync(new VasAdMetaParam(uin, 2, qzoneBusiMsg, QZoneFeedxLayerRecommendViewModel.this.E), QZoneFeedxLayerRecommendViewModel.this.F);
            }
        });
    }

    public void f2() {
        if (this.D) {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "request count up to limit");
            return;
        }
        this.D = true;
        if (!ac.b(LoginData.getInstance().getUinString())) {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "gallery switch close, cannot send request");
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QZoneFeedxLayerGalleryEntranceRequest(), new b());
        }
    }

    public void g2(int i3) {
        this.E = i3;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxLayerRecommendViewModel";
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements VasAdMetaCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback
        public void onGetAdInfoResponse(VasAdvServiceCode vasAdvServiceCode, String str, AlumBasicData alumBasicData) {
            if (alumBasicData == null) {
                return;
            }
            alumBasicData.retCode = vasAdvServiceCode;
            QZoneFeedxLayerRecommendViewModel.this.C.postValue(UIStateData.obtainSuccess(true).setMsg(str).setDataList(alumBasicData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                if (feedCloudMeta$StFeed.dittoFeed.has()) {
                    a2(feedCloudMeta$StFeed);
                }
            }
            return;
        }
        QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "feed list is null");
    }

    private void i2(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer != null && qQCircleDitto$StItemContainer.containerType.get() == 13) {
            T1(qQCircleDitto$StItemContainer);
        } else {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "item null or item type is not correct");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "rsp is null ,return");
        } else {
            final List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendViewModel.4
                @Override // java.lang.Runnable
                public void run() {
                    QZoneFeedxLayerRecommendViewModel.this.h2(list);
                }
            });
        }
    }

    private void a2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QZoneFeedxLayerRecommendViewModel", 1, "feed is null");
        } else if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 40) {
            b2(feedCloudMeta$StFeed.dittoFeed);
        }
    }

    private void c2(QZoneFeedxLayerGalleryBean qZoneFeedxLayerGalleryBean, boolean z16) {
        if (qZoneFeedxLayerGalleryBean == null) {
            return;
        }
        qZoneFeedxLayerGalleryBean.isDataIllegal = !z16;
        this.f58097m.postValue(UIStateData.obtainSuccess(true).setDataList(qZoneFeedxLayerGalleryBean));
    }

    private void d2(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean, boolean z16) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        qZoneFeedxLayerRecommendPhotoBean.isDataIllegal = !z16;
        this.f58096i.postValue(UIStateData.obtainSuccess(true).setDataList(qZoneFeedxLayerRecommendPhotoBean));
    }
}

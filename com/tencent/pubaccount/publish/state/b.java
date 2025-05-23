package com.tencent.pubaccount.publish.state;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StVideo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanGood;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes34.dex */
public class b extends a {

    /* renamed from: h, reason: collision with root package name */
    private CertifiedAccountMeta$StFeed f342342h;

    public b(QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        super(qQPublicAccountPublishFeedFragment);
    }

    private ArrayList<CommodityBean> n(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        List<CertifiedAccountMeta$StYouZanGood> list = certifiedAccountMeta$StFeed.goods.get();
        ArrayList<CommodityBean> arrayList = new ArrayList<>();
        for (CertifiedAccountMeta$StYouZanGood certifiedAccountMeta$StYouZanGood : list) {
            CommodityBean commodityBean = new CommodityBean();
            commodityBean.mTitle = certifiedAccountMeta$StYouZanGood.title.get();
            commodityBean.mPrice = certifiedAccountMeta$StYouZanGood.price.get();
            commodityBean.mAlias = certifiedAccountMeta$StYouZanGood.alias.get();
            commodityBean.mImg = certifiedAccountMeta$StYouZanGood.img.get();
            commodityBean.mItemID = certifiedAccountMeta$StYouZanGood.itemID.get();
            arrayList.add(commodityBean);
        }
        return arrayList;
    }

    private LbsDataV2.PoiInfo o(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        CertifiedAccountMeta$StPoiInfoV2 certifiedAccountMeta$StPoiInfoV2 = certifiedAccountMeta$StFeed.poiInfo.get();
        if (certifiedAccountMeta$StPoiInfoV2.poiId.has()) {
            poiInfo.poiId = certifiedAccountMeta$StPoiInfoV2.poiId.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.name.has()) {
            poiInfo.poiName = certifiedAccountMeta$StPoiInfoV2.name.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.typeName.has()) {
            poiInfo.poiTypeName = certifiedAccountMeta$StPoiInfoV2.typeName.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.address.has()) {
            poiInfo.address = certifiedAccountMeta$StPoiInfoV2.address.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.districtCode.has()) {
            poiInfo.districtCode = certifiedAccountMeta$StPoiInfoV2.districtCode.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.gps.has()) {
            LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
            poiInfo.gpsInfo = gpsInfo;
            gpsInfo.lat = (int) certifiedAccountMeta$StPoiInfoV2.gps.lat.get();
            poiInfo.gpsInfo.lon = (int) certifiedAccountMeta$StPoiInfoV2.gps.lon.get();
            poiInfo.gpsInfo.gpsType = (int) certifiedAccountMeta$StPoiInfoV2.gps.eType.get();
            poiInfo.gpsInfo.alt = (int) certifiedAccountMeta$StPoiInfoV2.gps.alt.get();
        }
        poiInfo.distance = certifiedAccountMeta$StPoiInfoV2.distance.get();
        poiInfo.hotValue = certifiedAccountMeta$StPoiInfoV2.hotValue.get();
        if (certifiedAccountMeta$StPoiInfoV2.phone.has()) {
            poiInfo.phoneNumber = certifiedAccountMeta$StPoiInfoV2.phone.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.country.has()) {
            poiInfo.country = certifiedAccountMeta$StPoiInfoV2.country.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.province.has()) {
            poiInfo.province = certifiedAccountMeta$StPoiInfoV2.province.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.city.has()) {
            poiInfo.city = certifiedAccountMeta$StPoiInfoV2.city.get();
        }
        poiInfo.poiNum = certifiedAccountMeta$StPoiInfoV2.poiNum.get();
        poiInfo.poiOrderType = certifiedAccountMeta$StPoiInfoV2.poiOrderType.get();
        if (certifiedAccountMeta$StPoiInfoV2.defaultName.has()) {
            poiInfo.poiDefaultName = certifiedAccountMeta$StPoiInfoV2.defaultName.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.district.has()) {
            poiInfo.district = certifiedAccountMeta$StPoiInfoV2.district.get();
        }
        if (certifiedAccountMeta$StPoiInfoV2.dianPingId.has()) {
            poiInfo.dianPingId = certifiedAccountMeta$StPoiInfoV2.dianPingId.get();
        }
        return poiInfo;
    }

    private ShuoshuoVideoInfo p(CertifiedAccountMeta$StVideo certifiedAccountMeta$StVideo, String str) {
        ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo.mVideoPath = certifiedAccountMeta$StVideo.playUrl.get();
        shuoshuoVideoInfo.mSize = certifiedAccountMeta$StVideo.fileSize.get();
        shuoshuoVideoInfo.mCoverUrl = str;
        shuoshuoVideoInfo.mVideoHeight = certifiedAccountMeta$StVideo.height.get();
        shuoshuoVideoInfo.mVideoWidth = certifiedAccountMeta$StVideo.width.get();
        shuoshuoVideoInfo.mStartTime = 0L;
        shuoshuoVideoInfo.mEndTime = certifiedAccountMeta$StVideo.duration.get();
        shuoshuoVideoInfo.mDuration = certifiedAccountMeta$StVideo.duration.get();
        shuoshuoVideoInfo.mTotalDuration = certifiedAccountMeta$StVideo.duration.get();
        j.a("UIStateEdit", 2, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo.mCoverUrl);
        return shuoshuoVideoInfo;
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void a() {
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        qQPublicAccountPublishFeedFragment.Kn(this.f342342h);
        List<CertifiedAccountMeta$StImage> list = this.f342342h.images.get();
        if (list != null && list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (CertifiedAccountMeta$StImage certifiedAccountMeta$StImage : list) {
                if (certifiedAccountMeta$StImage != null) {
                    String str = certifiedAccountMeta$StImage.url.get();
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
            qQPublicAccountPublishFeedFragment.dm(arrayList);
        }
        if (!TextUtils.isEmpty(this.f342342h.video.playUrl.get())) {
            String str2 = this.f342342h.video.playUrl.get();
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(this.f342342h.video.playUrl.get());
            qQPublicAccountPublishFeedFragment.dm(arrayList2);
            HashMap<String, ShuoshuoVideoInfo> hashMap = new HashMap<>();
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.f342342h;
            hashMap.put(str2, p(certifiedAccountMeta$StFeed.video, certifiedAccountMeta$StFeed.cover.url.get()));
            qQPublicAccountPublishFeedFragment.xl(hashMap);
        }
        qQPublicAccountPublishFeedFragment.Sn();
        if (this.f342342h.poiInfo.has()) {
            qQPublicAccountPublishFeedFragment.Rn(o(this.f342342h));
        }
        if (this.f342342h.goods.has()) {
            qQPublicAccountPublishFeedFragment.Qn(n(this.f342342h));
        }
        qQPublicAccountPublishFeedFragment.Dm();
        qQPublicAccountPublishFeedFragment.ui();
        qQPublicAccountPublishFeedFragment.Km();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public int g() {
        return 1;
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void h(Intent intent) {
        super.h(intent);
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        try {
            byte[] byteArrayExtra = intent.getByteArrayExtra("feed");
            if (byteArrayExtra != null) {
                CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
                this.f342342h = certifiedAccountMeta$StFeed;
                certifiedAccountMeta$StFeed.mergeFrom(byteArrayExtra);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            j.c("UIStateEdit", "get feed error!" + e16.toString());
        }
        this.f342337c = false;
        qQPublicAccountPublishFeedFragment.nn();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void m() {
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        qQPublicAccountPublishFeedFragment.finish();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void k() {
    }
}

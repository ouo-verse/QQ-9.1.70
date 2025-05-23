package com.tencent.biz.qqcircle.immersive.feed.ad.preload.model;

import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudAdrepull$GetADRePullReq;
import feedcloud.FeedCloudAdrepull$GetADRePullRsp;
import feedcloud.FeedCloudMeta$AdvertClientInfo;
import feedcloud.FeedCloudMeta$AdvertItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSAdFeedPreloadRequest extends QCircleBaseRequest {
    private String mAttachInfo;
    private final List<FeedCloudMeta$AdvertItem> mReplaceAdList;

    public QFSAdFeedPreloadRequest(List<FeedCloudMeta$AdvertItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.mReplaceAdList = arrayList;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        this.mAttachInfo = str;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.adrepull.AdRePull.Get";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        int size;
        String str;
        int size2;
        int size3;
        FeedCloudAdrepull$GetADRePullReq feedCloudAdrepull$GetADRePullReq = new FeedCloudAdrepull$GetADRePullReq();
        feedCloudAdrepull$GetADRePullReq.adres.set(j.f90213a.j());
        feedCloudAdrepull$GetADRePullReq.attach_info.set(this.mAttachInfo);
        FeedCloudMeta$AdvertClientInfo feedCloudMeta$AdvertClientInfo = new FeedCloudMeta$AdvertClientInfo();
        feedCloudMeta$AdvertClientInfo.items.addAll(this.mReplaceAdList);
        feedCloudAdrepull$GetADRePullReq.client_info.set(ByteStringMicro.copyFrom(feedCloudMeta$AdvertClientInfo.toByteArray()));
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getRequestByteData] adres length: ");
        PBBytesField pBBytesField = feedCloudAdrepull$GetADRePullReq.adres;
        if (pBBytesField == null) {
            size = 0;
        } else {
            size = pBBytesField.get().size();
        }
        sb5.append(size);
        sb5.append(" | req attach_info: ");
        PBStringField pBStringField = feedCloudAdrepull$GetADRePullReq.attach_info;
        if (pBStringField == null) {
            str = "";
        } else {
            str = pBStringField.get();
        }
        sb5.append(str);
        sb5.append(" | clientInfo items: ");
        PBRepeatMessageField<FeedCloudMeta$AdvertItem> pBRepeatMessageField = feedCloudMeta$AdvertClientInfo.items;
        if (pBRepeatMessageField == null) {
            size2 = 0;
        } else {
            size2 = pBRepeatMessageField.size();
        }
        sb5.append(size2);
        sb5.append(" | clientInfo length: ");
        PBBytesField pBBytesField2 = feedCloudAdrepull$GetADRePullReq.client_info;
        if (pBBytesField2 == null) {
            size3 = 0;
        } else {
            size3 = pBBytesField2.get().size();
        }
        sb5.append(size3);
        objArr[0] = sb5.toString();
        RFWLog.d("QASP-QFSAdFeedPreloadRequest", i3, objArr);
        return feedCloudAdrepull$GetADRePullReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudAdrepull$GetADRePullRsp decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new FeedCloudAdrepull$GetADRePullRsp().mergeFrom(bArr);
        } catch (Throwable th5) {
            RFWLog.d("QASP-QFSAdFeedPreloadRequest", RFWLog.USR, "[decode] e: ", th5);
            return null;
        }
    }
}

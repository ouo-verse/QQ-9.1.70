package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedListRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.vac_adv_get;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GetSubscribeFeedListRequest extends VSBaseRequest {
    public static final int SOURCE_TYPE_DETAIL = 1;
    public static final int SOURCE_TYPE_RECOMMEND = 0;
    private CertifiedAccountRead$StGetFeedListReq req;

    public GetSubscribeFeedListRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, String str) {
        this(certifiedAccountMeta$StFeed, 1, (COMM.StCommonExt) null, str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_read.GetFeedList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    public GetSubscribeFeedListRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3, COMM.StCommonExt stCommonExt, String str) {
        if (certifiedAccountMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        CertifiedAccountRead$StGetFeedListReq certifiedAccountRead$StGetFeedListReq = new CertifiedAccountRead$StGetFeedListReq();
        this.req = certifiedAccountRead$StGetFeedListReq;
        certifiedAccountRead$StGetFeedListReq.from.set(0);
        this.req.feed.set(certifiedAccountMeta$StFeed);
        this.req.source.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt.get());
        }
        qq_ad_get.QQAdGet.DeviceInfo c16 = SubscribeAdDeviceInfoHelper.e().c();
        if (c16 != null) {
            vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
            vacFeedsAdvMetaReq.device_info.set(c16);
            this.req.adres.set(ByteStringMicro.copyFrom(vacFeedsAdvMetaReq.toByteArray()));
        }
        if (str != null) {
            this.req.adAttchInfo.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetFeedListRsp certifiedAccountRead$StGetFeedListRsp = new CertifiedAccountRead$StGetFeedListRsp();
        try {
            certifiedAccountRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetFeedListRsp;
    }

    public GetSubscribeFeedListRequest(int i3, COMM.StCommonExt stCommonExt, String str) {
        CertifiedAccountRead$StGetFeedListReq certifiedAccountRead$StGetFeedListReq = new CertifiedAccountRead$StGetFeedListReq();
        this.req = certifiedAccountRead$StGetFeedListReq;
        certifiedAccountRead$StGetFeedListReq.from.set(0);
        this.req.source.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt.get());
        }
        qq_ad_get.QQAdGet.DeviceInfo c16 = SubscribeAdDeviceInfoHelper.e().c();
        if (c16 != null) {
            vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
            vacFeedsAdvMetaReq.device_info.set(c16);
            this.req.adres.set(ByteStringMicro.copyFrom(vacFeedsAdvMetaReq.toByteArray()));
        }
        if (str != null) {
            this.req.adAttchInfo.set(str);
        }
    }

    public GetSubscribeFeedListRequest(int i3, COMM.StCommonExt stCommonExt, String str, String str2) {
        CertifiedAccountRead$StGetFeedListReq certifiedAccountRead$StGetFeedListReq = new CertifiedAccountRead$StGetFeedListReq();
        this.req = certifiedAccountRead$StGetFeedListReq;
        certifiedAccountRead$StGetFeedListReq.from.set(0);
        this.req.source.set(i3);
        if (str2 != null) {
            this.req.livePageInfo.set(str2);
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt.get());
        }
        qq_ad_get.QQAdGet.DeviceInfo c16 = SubscribeAdDeviceInfoHelper.e().c();
        if (c16 != null) {
            vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
            vacFeedsAdvMetaReq.device_info.set(c16);
            this.req.adres.set(ByteStringMicro.copyFrom(vacFeedsAdvMetaReq.toByteArray()));
        }
        if (str != null) {
            this.req.adAttchInfo.set(str);
        }
    }
}

package com.qzone.reborn.intimate.request;

import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSpaceInitRequestBean;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.a;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageFeedsReq;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetFeedListRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageFeedsReq;", "mGetSpaceFeedsReq", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageFeedsReq;", "attachInfo", "Lcom/qzone/reborn/intimate/bean/init/b;", "requestBean", "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/intimate/bean/init/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateGetFeedListRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceReader$GetSpaceMainPageFeedsReq mGetSpaceFeedsReq;

    public QZoneIntimateGetFeedListRequest(String attachInfo, QZoneIntimateSpaceInitRequestBean requestBean) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        QZIntimateSpaceReader$GetSpaceMainPageFeedsReq qZIntimateSpaceReader$GetSpaceMainPageFeedsReq = new QZIntimateSpaceReader$GetSpaceMainPageFeedsReq();
        this.mGetSpaceFeedsReq = qZIntimateSpaceReader$GetSpaceMainPageFeedsReq;
        qZIntimateSpaceReader$GetSpaceMainPageFeedsReq.space_id.set(requestBean.getSpaceId());
        this.mGetSpaceFeedsReq.attach_info.set(attachInfo);
        this.mGetSpaceFeedsReq.is_draft_space.set(requestBean.getIsDraft());
        if ((requestBean.getSpaceId().length() == 0) && requestBean.getIsDraft()) {
            PBEnumField pBEnumField = this.mGetSpaceFeedsReq.space_type;
            QZoneIntimateActivateSpaceBean activateSpaceBean = requestBean.getActivateSpaceBean();
            pBEnumField.set(activateSpaceBean != null ? activateSpaceBean.getSpaceType() : 0);
            a aVar = a.f423008a;
            QZoneIntimateActivateSpaceBean activateSpaceBean2 = requestBean.getActivateSpaceBean();
            this.mGetSpaceFeedsReq.uids.set(aVar.p(aVar.h(activateSpaceBean2 != null ? activateSpaceBean2.getUsers() : null)));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "IntimateSpace.trpc.qzone.intimate_space_commreader.FeedReader.GetSpaceMainPageFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mGetSpaceFeedsReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetSpaceFeedsReq.toByteArray()");
        return byteArray;
    }
}

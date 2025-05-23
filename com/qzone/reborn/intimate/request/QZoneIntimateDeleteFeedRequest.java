package com.qzone.reborn.intimate.request;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.a;
import qzone.QZIntimateSpaceWriter$StDeleteFeedReq;
import qzone.QZIntimateSpaceWriter$StDeleteFeedRsp;
import qzone.QZoneBaseMeta$StFeedCellCommon;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateDeleteFeedRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "spaceId", "", "isDelMediaFileInAlbum", "", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;Ljava/lang/String;Z)V", "mDeleteFeedsReq", "Lqzone/QZIntimateSpaceWriter$StDeleteFeedReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateDeleteFeedRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceWriter$StDeleteFeedReq mDeleteFeedsReq;

    public QZoneIntimateDeleteFeedRequest(BusinessFeedData feedData, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QZIntimateSpaceWriter$StDeleteFeedReq qZIntimateSpaceWriter$StDeleteFeedReq = new QZIntimateSpaceWriter$StDeleteFeedReq();
        this.mDeleteFeedsReq = qZIntimateSpaceWriter$StDeleteFeedReq;
        qZIntimateSpaceWriter$StDeleteFeedReq.feed.setHasFlag(true);
        this.mDeleteFeedsReq.feed.cell_common.setHasFlag(true);
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = this.mDeleteFeedsReq.feed.cell_common;
        a aVar = a.f423008a;
        qZoneBaseMeta$StFeedCellCommon.set(aVar.k(feedData.getFeedCommInfo()));
        this.mDeleteFeedsReq.feed.cell_space_info.setHasFlag(true);
        if (str != null) {
            this.mDeleteFeedsReq.feed.cell_space_info.space_id.set(str);
        }
        this.mDeleteFeedsReq.feed.cell_user_info.setHasFlag(true);
        this.mDeleteFeedsReq.feed.cell_user_info.user.set(aVar.n(feedData.getUser()));
        this.mDeleteFeedsReq.is_delete_photo.set(z16);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateSpaceWriter$StDeleteFeedRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceWriter$StDeleteFeedRsp>() { // from class: qzone.QZIntimateSpaceWriter$StDeleteFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24}, new String[]{"ext_info", "next_publish_time"}, new Object[]{null, 0L}, QZIntimateSpaceWriter$StDeleteFeedRsp.class);
            public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
            public final PBUInt64Field next_publish_time = PBField.initUInt64(0);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.DeleteFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mDeleteFeedsReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mDeleteFeedsReq.toByteArray()");
        return byteArray;
    }
}

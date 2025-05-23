package com.qzone.reborn.qzmoment.publish.request;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.qzmoment.request.QZMBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.xaction.log.b;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StImage;
import qzonemoment.QZMomentMeta$StPoiInfo;
import qzonemoment.QZMomentMeta$StUser;
import qzonemoment.QZMomentWriter$StPublishFeedReq;
import qzonemoment.QZMomentWriter$StPublishFeedRsp;

/* loaded from: classes37.dex */
public class QZMPublishRequest extends QZMBaseRequest {
    private QZMomentWriter$StPublishFeedReq mPublishFeedReq;

    public QZMPublishRequest(QZMomentMeta$StImage qZMomentMeta$StImage, QZMomentMeta$StImage qZMomentMeta$StImage2, String str, QZMomentMeta$StPoiInfo qZMomentMeta$StPoiInfo) {
        QZMomentWriter$StPublishFeedReq qZMomentWriter$StPublishFeedReq = new QZMomentWriter$StPublishFeedReq();
        this.mPublishFeedReq = qZMomentWriter$StPublishFeedReq;
        qZMomentWriter$StPublishFeedReq.from.set(0);
        QZMomentMeta$StFeed qZMomentMeta$StFeed = new QZMomentMeta$StFeed();
        QZMomentMeta$StUser qZMomentMeta$StUser = new QZMomentMeta$StUser();
        qZMomentMeta$StUser.f430367id.set(LoginData.getInstance().getUinString());
        qZMomentMeta$StUser.nick.set(LoginData.getInstance().getNickName(LoginData.getInstance().getUinString()));
        qZMomentMeta$StFeed.poster.set(qZMomentMeta$StUser);
        qZMomentMeta$StFeed.images.add(qZMomentMeta$StImage);
        qZMomentMeta$StFeed.images.add(qZMomentMeta$StImage2);
        if (!TextUtils.isEmpty(str)) {
            qZMomentMeta$StFeed.content.set(str);
        }
        qZMomentMeta$StFeed.poiInfo.set(qZMomentMeta$StPoiInfo);
        this.mPublishFeedReq.feed.set(qZMomentMeta$StFeed);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commwriter.ComWriter.PublishFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mPublishFeedReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentWriter$StPublishFeedRsp qZMomentWriter$StPublishFeedRsp = new QZMomentWriter$StPublishFeedRsp();
        try {
            qZMomentWriter$StPublishFeedRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            b.c("QZMPublishRequest", 1, "decode error: ", e16);
        }
        return qZMomentWriter$StPublishFeedRsp;
    }
}

package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM;
import NS_QQ_STORY_CLIENT.CLIENT$StPublishStoryFeedReq;
import NS_QQ_STORY_CLIENT.CLIENT$StPublishStoryFeedRsp;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes5.dex */
public class PublishVideoFeedRequest extends VSBaseRequest {
    private CLIENT$StPublishStoryFeedReq req;

    public PublishVideoFeedRequest(META$StStoryFeed mETA$StStoryFeed) {
        CLIENT$StPublishStoryFeedReq cLIENT$StPublishStoryFeedReq = new CLIENT$StPublishStoryFeedReq();
        this.req = cLIENT$StPublishStoryFeedReq;
        cLIENT$StPublishStoryFeedReq.storyFeed.set(mETA$StStoryFeed);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "LightAppSvc.qq_story_client.PublishStoryFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<CLIENT$StPublishStoryFeedRsp> messageMicro = new MessageMicro<CLIENT$StPublishStoryFeedRsp>() { // from class: NS_QQ_STORY_CLIENT.CLIENT$StPublishStoryFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "storyFeed"}, new Object[]{null, null}, CLIENT$StPublishStoryFeedRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
            public META$StStoryFeed storyFeed = new META$StStoryFeed();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}

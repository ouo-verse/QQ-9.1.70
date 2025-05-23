package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM;
import NS_QQ_STORY_CONFIG.CONFIG$StGetStoryConfigReq;
import NS_QQ_STORY_CONFIG.CONFIG$StGetStoryConfigRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GetStoryConfigRequest extends VSBaseRequest {
    private final CONFIG$StGetStoryConfigReq req = new MessageMicro<CONFIG$StGetStoryConfigReq>() { // from class: NS_QQ_STORY_CONFIG.CONFIG$StGetStoryConfigReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CONFIG$StGetStoryConfigReq.class);
        public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "LightAppSvc.qq_story_config.GetStoryConfig";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CONFIG$StGetStoryConfigRsp cONFIG$StGetStoryConfigRsp = new CONFIG$StGetStoryConfigRsp();
        try {
            cONFIG$StGetStoryConfigRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return cONFIG$StGetStoryConfigRsp;
    }
}

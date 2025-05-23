package com.tencent.mobileqq.mini.servlet;

import NS_FOLLOW.Follow$StBatchGetFollowingCountReq;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BatchGetFollowingCountRequest extends ProtoBufRequest {
    public static final String APPID_SUFFIX = "|3";
    public static final String CMD_STRING = "LightAppSvc.follow_svr.BatchGetFollowingCount";
    private final Follow$StBatchGetFollowingCountReq req;

    public BatchGetFollowingCountRequest(List<String> list) {
        Follow$StBatchGetFollowingCountReq follow$StBatchGetFollowingCountReq = new Follow$StBatchGetFollowingCountReq();
        this.req = follow$StBatchGetFollowingCountReq;
        follow$StBatchGetFollowingCountReq.business.set("UserAppUse");
        for (String str : list) {
            this.req.followers.add(str + APPID_SUFFIX);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}

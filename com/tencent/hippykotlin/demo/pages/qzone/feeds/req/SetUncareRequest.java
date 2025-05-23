package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetUncareReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetUncareRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SetUncareRequest extends QZoneBaseRequest<SetUncareReq, SetUncareRsp> {
    public final List<StUser> users;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final SetUncareRsp decodeBusiRsp(byte[] bArr) {
        return (SetUncareRsp) i.b(new SetUncareRsp(null, 1, 0 == true ? 1 : 0), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final SetUncareReq getBusiReq() {
        return new SetUncareReq(null, this.users);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.SetUncare";
    }

    public SetUncareRequest(StCommonExt stCommonExt, List<StUser> list) {
        super(null, 1, 0 == true ? 1 : 0);
        this.users = list;
    }
}

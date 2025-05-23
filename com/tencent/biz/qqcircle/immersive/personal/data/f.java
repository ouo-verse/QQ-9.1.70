package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase$StMainPageCommBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends c {

    /* renamed from: c, reason: collision with root package name */
    protected g f88536c;

    public f(a aVar) {
        super(aVar);
        this.f88536c = new g();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public String a() {
        return "QFSExtendData";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public List<b> b() {
        return Arrays.asList(new d(), new e());
    }

    public void f(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp, long j3) {
        this.f88536c.k(feedCloudRead$StGetMainPageCommDataRsp.feedCount.get());
        this.f88536c.l(feedCloudRead$StGetMainPageCommDataRsp.likedFeedCount.get());
        this.f88536c.o(feedCloudRead$StGetMainPageCommDataRsp.pushRocketCount.get());
        this.f88536c.j(feedCloudRead$StGetMainPageCommDataRsp.collectionCount.get());
        QQCircleFeedBase$StMainPageCommBusiRspData qQCircleFeedBase$StMainPageCommBusiRspData = new QQCircleFeedBase$StMainPageCommBusiRspData();
        try {
            qQCircleFeedBase$StMainPageCommBusiRspData.mergeFrom(feedCloudRead$StGetMainPageCommDataRsp.busiRspData.get().toByteArray());
            this.f88536c.p(qQCircleFeedBase$StMainPageCommBusiRspData.showSubButtonsPos.get());
            this.f88536c.m(qQCircleFeedBase$StMainPageCommBusiRspData.subButtons.get());
            this.f88536c.n(qQCircleFeedBase$StMainPageCommBusiRspData.op_mask.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSExtendData", 1, e16.toString());
        }
        e("update_version_extend_feed", j3);
    }

    public void g(boolean z16, long j3) {
        this.f88536c.i(z16);
        e("key_version_extend_base_info", j3);
    }
}

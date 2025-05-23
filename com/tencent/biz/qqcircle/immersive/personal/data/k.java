package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$StProfileBizData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends c {

    /* renamed from: c, reason: collision with root package name */
    protected QQCircleFeedBase$StMainPageBasicBusiRspData f88546c;

    /* renamed from: d, reason: collision with root package name */
    protected QQCircleProfile$StProfileBizData f88547d;

    /* renamed from: e, reason: collision with root package name */
    protected i f88548e;

    public k(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public String a() {
        return "QFSMainBasicBusiData";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public List<b> b() {
        i iVar = new i();
        this.f88548e = iVar;
        return Arrays.asList(iVar, new h(), new l(), new j());
    }

    public void f(byte[] bArr, long j3) {
        try {
            QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData = new QQCircleFeedBase$StMainPageBasicBusiRspData();
            this.f88546c = qQCircleFeedBase$StMainPageBasicBusiRspData;
            qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(bArr);
            this.f88547d = new QQCircleProfile$StProfileBizData();
            if (this.f88546c.profileBusiData.has()) {
                this.f88547d.mergeFrom(this.f88546c.profileBusiData.get().toByteArray());
            }
            d(j3);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSMainBasicBusiData", 1, "mergeFrom StMainPageBusiRspData error");
            e16.printStackTrace();
        }
    }
}

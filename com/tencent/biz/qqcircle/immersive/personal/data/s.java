package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends c {

    /* renamed from: c, reason: collision with root package name */
    protected QQCircleBase$StUserBusiData f88574c;

    public s(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public String a() {
        return "QFSUserBusiDataInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public List<b> b() {
        return Arrays.asList(new r());
    }

    public void f(byte[] bArr, long j3) {
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        this.f88574c = qQCircleBase$StUserBusiData;
        try {
            qQCircleBase$StUserBusiData.mergeFrom(bArr);
            d(j3);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSUserBusiDataInfo", 1, "mergeFrom StUserBusiData error");
            e16.printStackTrace();
        }
    }
}

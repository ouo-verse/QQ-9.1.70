package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.service.QQKMPCore;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyServiceImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyService;", "()V", "TAG", "", "destroyQQKMPCore", "", "isStartQQKMPCore", "", "sendEventToKMPCore", "event", "data", "", "startKMPCore", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQKuiklyServiceImpl implements IQQKuiklyService {
    private final String TAG = "QQKuiklyServiceImpl";

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService
    public void destroyQQKMPCore() {
        QLog.i(this.TAG, 1, "destroyQQKMPCore");
        QQKMPCore.f263203d.i();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService
    public boolean isStartQQKMPCore() {
        QLog.i(this.TAG, 1, "isStartQQKMPCore");
        return QQKMPCore.f263203d.l();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService
    public void sendEventToKMPCore(String event, Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(this.TAG, 1, "sendEventToKMPCore event: " + event);
        QQKMPCore.f263203d.p(event, data);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService
    public void startKMPCore() {
        QLog.i(this.TAG, 1, "startKMPCore");
        QQKMPCore.f263203d.q();
    }
}

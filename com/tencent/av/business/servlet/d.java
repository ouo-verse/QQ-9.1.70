package com.tencent.av.business.servlet;

import com.tencent.av.business.handler.MobileNetSwitchHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Servlet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0004B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J&\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/av/business/servlet/d;", "Lcom/tencent/av/business/servlet/BaseService;", "Ljava/lang/Class;", "Lmqq/app/Servlet;", "a", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", "c", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class d extends BaseService {
    public d(@Nullable AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.av.business.servlet.BaseService
    @NotNull
    public Class<? extends Servlet> a() {
        return e.class;
    }

    @Override // com.tencent.av.business.servlet.BaseService
    protected void c(@Nullable ToServiceMsg request, @Nullable FromServiceMsg response, @Nullable Object data) {
        if (QLog.isColorLevel()) {
            QLog.i("MobileNetService", 2, "notifyResult");
        }
        BusinessHandler businessHandler = this.f73467a.getBusinessHandler(MobileNetSwitchHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.av.business.handler.MobileNetSwitchHandler");
        ((MobileNetSwitchHandler) businessHandler).onReceive(request, response, data);
    }
}

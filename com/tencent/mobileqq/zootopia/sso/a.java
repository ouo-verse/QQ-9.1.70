package com.tencent.mobileqq.zootopia.sso;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MSFServlet;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/a;", "Lcom/tencent/mobileqq/service/MobileQQServiceBase;", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "Ljava/lang/Class;", "Lmqq/app/MSFServlet;", "getServlet", "", "cmd", "", "isPBPushCmd", "a", "Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends MobileQQServiceBase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AppInterface appInterface;

    public a(AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.appInterface = appInterface;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        return this.appInterface;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public boolean isPBPushCmd(String cmd) {
        return true;
    }
}

package com.tencent.mobileqq.zplan.proxy;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import zx4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/s;", "Lzx4/n;", "", "cmdName", "", "reqBuffer", "Lzx4/n$a;", "callback", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s implements zx4.n {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/proxy/s$b", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n.a f335016e;

        b(String str, n.a aVar) {
            this.f335015d = str;
            this.f335016e = aVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            byte[] bArr = (byte[]) data;
            QLog.d("[zplan]_QQZPlanReuqestProxy", 1, "sendSSORequest, cmdName:" + this.f335015d + ", success:" + isSuccess + ", response data size:" + (bArr != null ? Integer.valueOf(bArr.length) : null));
            this.f335016e.a(isSuccess, this.f335015d, bArr);
        }
    }

    @Override // zx4.n
    public void a(String cmdName, byte[] reqBuffer, n.a callback) {
        Intrinsics.checkNotNullParameter(cmdName, "cmdName");
        Intrinsics.checkNotNullParameter(reqBuffer, "reqBuffer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof ToolRuntimePeak) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("peak");
        } else if (waitAppRuntime instanceof VideoAppInterface) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("module_video");
        }
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) waitAppRuntime).getBusinessHandler(Reflection.getOrCreateKotlinClass(ZPlanRequestHandler.class).getQualifiedName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
        ((ZPlanRequestHandler) businessHandler).request(cmdName, reqBuffer, new b(cmdName, callback));
    }
}

package com.tencent.qqnt.kernel.api.impl;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import kotlin.Metadata;
import kotlin.TuplesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class RobotService$checkEnableWithSimpleCallback$2$1$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f357365d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f357366e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f357367f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f357368h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ IGProRobotSimpleResultCallback f357369i;
    final /* synthetic */ RobotService this$0;

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        KLog.f359087a.d(this.this$0.getSubTag(), new Object[]{TuplesKt.to("method", this.f357365d), TuplesKt.to("result", Integer.valueOf(this.f357366e)), TuplesKt.to("errMsg", this.f357367f)}, Integer.valueOf(this.f357368h));
        IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = this.f357369i;
        if (iGProRobotSimpleResultCallback != null) {
            iGProRobotSimpleResultCallback.onResult(this.f357366e, this.f357367f);
        }
    }
}

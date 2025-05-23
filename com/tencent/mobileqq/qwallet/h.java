package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h;", "", "", "b", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f277153a = new h();

    h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(boolean z16) {
        QLog.i("QWalletWebUtils", 1, "preload webProcess finish: " + z16);
    }

    public final void b() {
        IWebProcessManagerService iWebProcessManagerService;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iWebProcessManagerService = (IWebProcessManagerService) peekAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
            } else {
                iWebProcessManagerService = null;
            }
            if (iWebProcessManagerService != null) {
                iWebProcessManagerService.startWebProcess(37, new u() { // from class: com.tencent.mobileqq.qwallet.g
                    @Override // com.tencent.mobileqq.webview.util.u
                    public final void onResult(boolean z16) {
                        h.c(z16);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.w("QWalletWebUtils", 1, "preload webProcess fail: ", e16);
        }
    }
}

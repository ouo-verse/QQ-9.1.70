package com.tencent.mobileqq.dt.web;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/dt/web/b;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "", "service", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "Lmqq/app/Packet;", "packet", "onSend", "<init>", "()V", "d", "a", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class b extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/dt/web/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.web.b$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25291);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @NotNull FromServiceMsg response) {
        AppInterface appInterface;
        O3BusinessHandler o3BusinessHandler;
        ToServiceMsg toServiceMsg;
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(response, "response");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (MobileQQ.sProcessId == 7) {
            if (peekAppRuntime != null) {
                appRuntime = peekAppRuntime.getAppRuntime("modular_web");
            } else {
                appRuntime = null;
            }
            if (appRuntime instanceof AppInterface) {
                appInterface = (AppInterface) appRuntime;
            }
            appInterface = null;
        } else {
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            }
            appInterface = null;
        }
        if (appInterface == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive but app is null, ");
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getClass().getSimpleName();
            }
            sb5.append(str);
            QLog.e("O3MsfServlet", 1, sb5.toString());
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
        if (businessHandler instanceof O3BusinessHandler) {
            o3BusinessHandler = (O3BusinessHandler) businessHandler;
        } else {
            o3BusinessHandler = null;
        }
        if (o3BusinessHandler == null) {
            QLog.e("O3MsfServlet", 1, "onReceive but handler is null");
            return;
        }
        if (request != null) {
            toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        } else {
            toServiceMsg = null;
        }
        if (toServiceMsg == null) {
            QLog.e("O3MsfServlet", 1, "onReceive but toMsg is null");
        } else {
            o3BusinessHandler.onReceive(toServiceMsg, response, null);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) packet);
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(@Nullable Intent request) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        if (request != null) {
            toServiceMsg = (ToServiceMsg) request.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        } else {
            toServiceMsg = null;
        }
        if (toServiceMsg == null) {
            QLog.e("O3MsfServlet", 1, "request is null");
        } else {
            sendToMSF(request, toServiceMsg);
        }
    }
}

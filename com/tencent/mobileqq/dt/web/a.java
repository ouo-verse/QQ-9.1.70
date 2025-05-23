package com.tencent.mobileqq.dt.web;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH&R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/dt/web/a;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "a", "Lcom/tencent/mobileqq/dt/web/O3BusinessHandler;", "handler", "c", "", "type", "", "isSuccess", "", "data", "onUpdate", "code", "", "b", "d", "Lcom/tencent/mobileqq/dt/web/O3BusinessHandler;", "<init>", "()V", "e", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private O3BusinessHandler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/dt/web/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.web.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        O3BusinessHandler o3BusinessHandler = this.handler;
        if (o3BusinessHandler != null) {
            o3BusinessHandler.F2("trpc.o3.report.Report.SsoReport");
        }
    }

    public abstract void b(int code, @NotNull byte[] data);

    public final void c(@NotNull O3BusinessHandler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) handler);
        } else {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.handler = handler;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        FromServiceMsg fromServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
            return;
        }
        if (data instanceof FromServiceMsg) {
            fromServiceMsg = (FromServiceMsg) data;
        } else {
            fromServiceMsg = null;
        }
        if (fromServiceMsg == null) {
            QLog.e("O3BusinessObserver", 1, "onUpdate fromMsg is null");
            return;
        }
        Integer code = (Integer) fromServiceMsg.getAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_RET, -1);
        byte[] bArr = (byte[]) fromServiceMsg.getAttribute(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_DATA, new byte[0]);
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (code != null && code.intValue() == 907) {
            a();
        }
        Intrinsics.checkNotNullExpressionValue(code, "code");
        b(code.intValue(), bArr);
    }
}

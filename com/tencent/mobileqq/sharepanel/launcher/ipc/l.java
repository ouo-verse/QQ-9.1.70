package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/l;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "b", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final l f287393d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f287393d = new l();
            hasInit = new AtomicBoolean(false);
        }
    }

    l() {
        super("SharePanelIPCClient");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!hasInit.getAndSet(true)) {
            QIPCClientHelper.getInstance().register(this);
        }
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, this, action, params, Integer.valueOf(callbackId));
        }
        if (action != null && params != null) {
            params.setClassLoader(l.class.getClassLoader());
            SimpleEventBus.getInstance().dispatchEvent(new SharePanelIPCClientEvent(action, params));
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }
}

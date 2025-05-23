package com.tencent.qqnt.aio.interceptor.sendmsg;

import android.os.Bundle;
import com.tencent.aio.msgservice.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "", "Lcom/tencent/aio/msgservice/k;", "a", "Lcom/tencent/aio/msgservice/k;", "d", "()Lcom/tencent/aio/msgservice/k;", "sendReq", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extData", "Lkotlin/Lazy;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/Lazy;", "()Lkotlin/Lazy;", "msgElementSupplier", "<init>", "(Lcom/tencent/aio/msgservice/k;Lcom/tencent/aio/api/runtime/a;Landroid/os/Bundle;Lkotlin/Lazy;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k sendReq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle extData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<List<MsgElement>> msgElementSupplier;

    public c(@NotNull k sendReq, @NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable Bundle bundle, @NotNull Lazy<? extends List<MsgElement>> msgElementSupplier) {
        Intrinsics.checkNotNullParameter(sendReq, "sendReq");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgElementSupplier, "msgElementSupplier");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sendReq, aioContext, bundle, msgElementSupplier);
            return;
        }
        this.sendReq = sendReq;
        this.aioContext = aioContext;
        this.extData = bundle;
        this.msgElementSupplier = msgElementSupplier;
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioContext;
    }

    @Nullable
    public final Bundle b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extData;
    }

    @NotNull
    public final Lazy<List<MsgElement>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Lazy) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msgElementSupplier;
    }

    @NotNull
    public final k d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sendReq;
    }
}

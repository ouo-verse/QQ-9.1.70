package com.tencent.qqnt.remote;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MainService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u000f\u0010\u000bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/remote/b;", "", "", "a", "I", "b", "()I", QzoneIPCModule.RESULT_CODE, "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "resultMsg", "getServiceName", "serviceName", "d", "getUin", "uin", "e", MainService.SERVICE_CMD, "f", "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "data", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int resultCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resultMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String serviceName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceCmd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object data;

    public b(int i3, @NotNull String resultMsg, @Nullable String str, @Nullable String str2, @NotNull String serviceCmd) {
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        Intrinsics.checkNotNullParameter(serviceCmd, "serviceCmd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), resultMsg, str, str2, serviceCmd);
            return;
        }
        this.resultCode = i3;
        this.resultMsg = resultMsg;
        this.serviceName = str;
        this.uin = str2;
        this.serviceCmd = serviceCmd;
    }

    @Nullable
    public final Object a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.data;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.resultCode;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.resultMsg;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.serviceCmd;
    }

    public final void e(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, obj);
        } else {
            this.data = obj;
        }
    }
}

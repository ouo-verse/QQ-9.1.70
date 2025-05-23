package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/b;", "", "", "a", "I", "()I", "pluginType", "", "b", "Ljava/lang/String;", "getModuleId", "()Ljava/lang/String;", "moduleId", "c", "getHost", "host", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int pluginType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String moduleId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String host;

    public b() {
        this(0, null, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.pluginType;
    }

    public b(int i3, @NotNull String moduleId, @NotNull String host) {
        Intrinsics.checkParameterIsNotNull(moduleId, "moduleId");
        Intrinsics.checkParameterIsNotNull(host, "host");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), moduleId, host);
            return;
        }
        this.pluginType = i3;
        this.moduleId = moduleId;
        this.host = host;
    }

    public /* synthetic */ b(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), defaultConstructorMarker);
    }
}

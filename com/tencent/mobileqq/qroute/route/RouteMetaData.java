package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "Lcom/tencent/mobileqq/qroute/route/b;", "", "d", "I", "c", "()I", "routeType", "", "e", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "f", "getPath", "path", "g", "b", "clazz", "pluginType", "moduleId", "host", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class RouteMetaData extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int routeType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String clazz;

    public RouteMetaData() {
        this(0, null, null, 0, null, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.clazz;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.routeType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteMetaData(int i3, @NotNull String moduleId, @NotNull String host, int i16, @NotNull String name, @NotNull String path, @NotNull String clazz) {
        super(i3, moduleId, host);
        Intrinsics.checkParameterIsNotNull(moduleId, "moduleId");
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), moduleId, host, Integer.valueOf(i16), name, path, clazz);
            return;
        }
        this.routeType = i16;
        this.name = name;
        this.path = path;
        this.clazz = clazz;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RouteMetaData(int i3, String str, String str2, int i16, String str3, String str4, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, r7, r8, r9);
        String str6;
        int i18 = (i17 & 1) != 0 ? 0 : i3;
        String str7 = (i17 & 2) != 0 ? "" : str;
        String str8 = (i17 & 4) != 0 ? "" : str2;
        int i19 = (i17 & 8) != 0 ? -1 : i16;
        String str9 = (i17 & 16) != 0 ? "undefine" : str3;
        String str10 = (i17 & 32) != 0 ? "" : str4;
        if ((i17 & 64) != 0) {
            String name = Object.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "Any::class.java.name");
            str6 = name;
        } else {
            str6 = str5;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3, str4, str5, Integer.valueOf(i17), defaultConstructorMarker);
    }
}

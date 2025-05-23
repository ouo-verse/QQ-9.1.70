package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/InterceptorMetaData;", "Lcom/tencent/mobileqq/qroute/route/b;", "Lcom/tencent/mobileqq/qroute/route/h;", "c", "d", "Lcom/tencent/mobileqq/qroute/route/h;", "_interceptor", "", "e", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "f", "getName", "name", "g", "getClazz", "clazz", "b", "()Lcom/tencent/mobileqq/qroute/route/h;", "interceptor", "", "pluginType", "moduleId", "host", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class InterceptorMetaData extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private h _interceptor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String clazz;

    public InterceptorMetaData() {
        this(0, null, null, null, null, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    private final h c() {
        try {
            Object newInstance = Class.forName(this.clazz).newInstance();
            if (newInstance != null) {
                h hVar = (h) newInstance;
                this._interceptor = hVar;
                return hVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qroute.route.IPathInterceptor");
        } catch (ClassCastException e16) {
            throw new QRouteException(1004, this.clazz + " can not be cast to " + h.class.getName() + '!', e16);
        } catch (ClassNotFoundException e17) {
            throw new QRouteException(1002, this.clazz + " interceptor not found!", e17);
        }
    }

    @NotNull
    public final h b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (h) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        h hVar = this._interceptor;
        if (hVar == null) {
            return c();
        }
        return hVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ InterceptorMetaData(int i3, String str, String str2, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, r7, r8);
        String str6;
        int i17 = (i16 & 1) != 0 ? 0 : i3;
        String str7 = (i16 & 2) != 0 ? "" : str;
        String str8 = (i16 & 4) != 0 ? "" : str2;
        String str9 = (i16 & 8) != 0 ? "" : str3;
        String str10 = (i16 & 16) != 0 ? "undefine" : str4;
        if ((i16 & 32) != 0) {
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
        iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, str3, str4, str5, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptorMetaData(int i3, @NotNull String moduleId, @NotNull String host, @NotNull String path, @NotNull String name, @NotNull String clazz) {
        super(i3, moduleId, host);
        Intrinsics.checkParameterIsNotNull(moduleId, "moduleId");
        Intrinsics.checkParameterIsNotNull(host, "host");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), moduleId, host, path, name, clazz);
            return;
        }
        this.path = path;
        this.name = name;
        this.clazz = clazz;
    }
}

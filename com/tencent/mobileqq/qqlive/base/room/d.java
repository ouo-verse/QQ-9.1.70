package com.tencent.mobileqq.qqlive.base.room;

import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.component.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B3\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/d;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "FROM", ky.f149103i, "", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "a", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "()Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "conn", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "b", "Lcom/tencent/mobileqq/qqlive/framework/component/d;", "()Lcom/tencent/mobileqq/qqlive/framework/component/d;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "()Ljava/lang/Class;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "toKey", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/connector/b;Lcom/tencent/mobileqq/qqlive/framework/component/d;Ljava/lang/Class;Ljava/lang/String;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d<FROM extends e, TO extends e> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.connector.b conn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.component.d<FROM> first;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<TO> second;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String toKey;

    public d(@NotNull com.tencent.mobileqq.qqlive.framework.connector.b conn, @NotNull com.tencent.mobileqq.qqlive.framework.component.d<FROM> first, @NotNull Class<TO> second, @NotNull String toKey) {
        Intrinsics.checkNotNullParameter(conn, "conn");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(toKey, "toKey");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, conn, first, second, toKey);
            return;
        }
        this.conn = conn;
        this.first = first;
        this.second = second;
        this.toKey = toKey;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.framework.connector.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.framework.connector.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.conn;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.framework.component.d<FROM> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.framework.component.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.first;
    }

    @NotNull
    public final Class<TO> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.second;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.toKey;
    }
}

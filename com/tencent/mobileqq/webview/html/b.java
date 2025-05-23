package com.tencent.mobileqq.webview.html;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.DBBuildUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/webview/html/b;", "", "Lcom/tencent/mobileqq/persistence/EntityManager;", "c", "", "sessionId", "Lcom/tencent/mobileqq/webview/html/SessionData;", "e", "", "d", "sessionData", "", "f", "", "b", "", "a", "Lcom/tencent/mobileqq/persistence/EntityManager;", "mEntityManager", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f313880a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static EntityManager mEntityManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40004);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f313880a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return c().drop("HtmlSessionData");
    }

    public final int b(@NotNull String sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) sessionId)).intValue();
        }
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return c().delete("HtmlSessionData", "sessionId = ?", new String[]{sessionId});
    }

    @NotNull
    public final synchronized EntityManager c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (mEntityManager == null) {
            mEntityManager = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(null).build().createEntityManager();
        }
        EntityManager entityManager = mEntityManager;
        Intrinsics.checkNotNull(entityManager);
        return entityManager;
    }

    @Nullable
    public final List<SessionData> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        List<? extends Entity> query = c().query(SessionData.class, "HtmlSessionData", false, (String) null, (String[]) null, (String) null, (String) null, "hitCount ASC", "500");
        if (query != null) {
            return TypeIntrinsics.asMutableList(query);
        }
        return null;
    }

    @Nullable
    public final SessionData e(@NotNull String sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SessionData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sessionId);
        }
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        List<? extends Entity> query = c().query(SessionData.class, "HtmlSessionData", false, "sessionId = ?", new String[]{sessionId}, (String) null, (String) null, (String) null, "1");
        if (query != null && query.size() > 0) {
            Entity entity = query.get(0);
            Intrinsics.checkNotNull(entity, "null cannot be cast to non-null type com.tencent.mobileqq.webview.html.SessionData");
            return (SessionData) entity;
        }
        return null;
    }

    public final void f(@NotNull SessionData sessionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) sessionData);
            return;
        }
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (sessionData.getStatus() == 1000) {
            c().persistOrReplace(sessionData);
        } else {
            c().update(sessionData);
        }
    }
}

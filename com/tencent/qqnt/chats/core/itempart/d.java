package com.tencent.qqnt.chats.core.itempart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u000e\u0010\u001fR\u0017\u0010$\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b\b\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/d;", "", "Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "a", "Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "()Lcom/tencent/qqnt/chats/core/itempart/avatar/a;", "avatarPart", "Lcom/tencent/qqnt/chats/core/itempart/title/a;", "b", "Lcom/tencent/qqnt/chats/core/itempart/title/a;", "f", "()Lcom/tencent/qqnt/chats/core/itempart/title/a;", "titlePart", "Lcom/tencent/qqnt/chats/core/itempart/time/a;", "c", "Lcom/tencent/qqnt/chats/core/itempart/time/a;", "e", "()Lcom/tencent/qqnt/chats/core/itempart/time/a;", "timePart", "Lcom/tencent/qqnt/chats/core/itempart/unread/a;", "d", "Lcom/tencent/qqnt/chats/core/itempart/unread/a;", "g", "()Lcom/tencent/qqnt/chats/core/itempart/unread/a;", "unreadPart", "Lcom/tencent/qqnt/chats/core/itempart/summary/a;", "Lcom/tencent/qqnt/chats/core/itempart/summary/a;", "()Lcom/tencent/qqnt/chats/core/itempart/summary/a;", "summaryPart", "Lcom/tencent/qqnt/chats/core/itempart/content/a;", "Lcom/tencent/qqnt/chats/core/itempart/content/a;", "()Lcom/tencent/qqnt/chats/core/itempart/content/a;", "contentPart", "Lcom/tencent/qqnt/chats/core/itempart/background/a;", "Lcom/tencent/qqnt/chats/core/itempart/background/a;", "()Lcom/tencent/qqnt/chats/core/itempart/background/a;", "backgroundPart", "<init>", "(Lcom/tencent/qqnt/chats/core/itempart/avatar/a;Lcom/tencent/qqnt/chats/core/itempart/title/a;Lcom/tencent/qqnt/chats/core/itempart/time/a;Lcom/tencent/qqnt/chats/core/itempart/unread/a;Lcom/tencent/qqnt/chats/core/itempart/summary/a;Lcom/tencent/qqnt/chats/core/itempart/content/a;Lcom/tencent/qqnt/chats/core/itempart/background/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.avatar.a avatarPart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.title.a titlePart;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.time.a timePart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.unread.a unreadPart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.summary.a summaryPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.content.a contentPart;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.itempart.background.a backgroundPart;

    public d(@NotNull com.tencent.qqnt.chats.core.itempart.avatar.a avatarPart, @NotNull com.tencent.qqnt.chats.core.itempart.title.a titlePart, @NotNull com.tencent.qqnt.chats.core.itempart.time.a timePart, @NotNull com.tencent.qqnt.chats.core.itempart.unread.a unreadPart, @NotNull com.tencent.qqnt.chats.core.itempart.summary.a summaryPart, @NotNull com.tencent.qqnt.chats.core.itempart.content.a contentPart, @NotNull com.tencent.qqnt.chats.core.itempart.background.a backgroundPart) {
        Intrinsics.checkNotNullParameter(avatarPart, "avatarPart");
        Intrinsics.checkNotNullParameter(titlePart, "titlePart");
        Intrinsics.checkNotNullParameter(timePart, "timePart");
        Intrinsics.checkNotNullParameter(unreadPart, "unreadPart");
        Intrinsics.checkNotNullParameter(summaryPart, "summaryPart");
        Intrinsics.checkNotNullParameter(contentPart, "contentPart");
        Intrinsics.checkNotNullParameter(backgroundPart, "backgroundPart");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatarPart, titlePart, timePart, unreadPart, summaryPart, contentPart, backgroundPart);
            return;
        }
        this.avatarPart = avatarPart;
        this.titlePart = titlePart;
        this.timePart = timePart;
        this.unreadPart = unreadPart;
        this.summaryPart = summaryPart;
        this.contentPart = contentPart;
        this.backgroundPart = backgroundPart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.avatar.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.itempart.avatar.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.avatarPart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.background.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.chats.core.itempart.background.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.backgroundPart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.content.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.chats.core.itempart.content.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.contentPart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.summary.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.core.itempart.summary.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.summaryPart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.time.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.chats.core.itempart.time.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.timePart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.title.a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.core.itempart.title.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.titlePart;
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.itempart.unread.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.chats.core.itempart.unread.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.unreadPart;
    }
}

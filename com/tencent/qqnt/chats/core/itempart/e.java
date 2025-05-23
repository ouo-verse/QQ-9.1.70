package com.tencent.qqnt.chats.core.itempart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/e;", "", "Lcom/tencent/qqnt/chats/core/itempart/d;", "b", "Lcom/tencent/qqnt/chats/core/itempart/d;", "a", "()Lcom/tencent/qqnt/chats/core/itempart/d;", "sDefaultCollect", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f354799a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final d sDefaultCollect;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f354799a = new e();
            sDefaultCollect = new d(new com.tencent.qqnt.chats.core.itempart.avatar.a(), new com.tencent.qqnt.chats.core.itempart.title.a(), new com.tencent.qqnt.chats.core.itempart.time.a(), new com.tencent.qqnt.chats.core.itempart.unread.a(), new com.tencent.qqnt.chats.core.itempart.summary.a(), new com.tencent.qqnt.chats.core.itempart.content.a(), new com.tencent.qqnt.chats.core.itempart.background.a());
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sDefaultCollect;
    }
}

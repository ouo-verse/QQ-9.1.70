package com.tencent.qqnt.chats.core.adapter.preload;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/preload/a;", "", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader;", "d", "preLoader", "", "a", "b", "c", "e", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/preload/a$a;", "", "", "DEFAULT_RECENT_ITEM", "Ljava/lang/String;", "GUILD_RECENT_ITEM", "PRELOAD_TAG", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.adapter.preload.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(LayoutPreLoader preLoader) {
        preLoader.i("Default_Recent_Item", 5, new c());
        preLoader.i("GUILD_Recent_Item", 3, new fw3.a());
    }

    private final void b(LayoutPreLoader preLoader) {
        com.tencent.qqnt.chats.core.adapter.menu.a aVar = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 0, 0, 0, 0, 0, 123, null);
        com.tencent.qqnt.chats.core.adapter.menu.a aVar2 = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 3, 0, 0, 0, 0, 123, null);
        com.tencent.qqnt.chats.core.adapter.menu.a aVar3 = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 4, 0, 0, 0, 0, 123, null);
        com.tencent.qqnt.chats.core.adapter.menu.a aVar4 = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 5, 0, 0, 0, 0, 123, null);
        com.tencent.qqnt.chats.core.adapter.menu.a aVar5 = new com.tencent.qqnt.chats.core.adapter.menu.a(null, null, 2, 0, 0, 0, 0, 123, null);
        preLoader.i(aVar, 8, new b(aVar));
        preLoader.i(aVar2, 8, new b(aVar2));
        preLoader.i(aVar3, 8, new b(aVar3));
        preLoader.i(aVar4, 8, new b(aVar4));
        preLoader.i(aVar5, 8, new b(aVar5));
        c.Companion companion = com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE;
        preLoader.i(companion.f(), 8, new b(companion.f()));
    }

    private final LayoutPreLoader d(Context context, CoroutineScope scope) {
        LayoutPreLoader layoutPreLoader = new LayoutPreLoader(new LayoutPreLoader.b(context), scope);
        a(layoutPreLoader);
        b(layoutPreLoader);
        layoutPreLoader.m();
        return layoutPreLoader;
    }

    public final void c(@NotNull Context context, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        com.tencent.qqnt.chats.utils.preload.b.f355561a.b("chat_list", d(context, scope));
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.qqnt.chats.utils.preload.b.f355561a.c("chat_list");
        }
    }
}

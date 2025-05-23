package com.tencent.qqnt.chats.core.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0002\u0005\u0006B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/l;", "", "", "scene", "", "a", "b", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Ljava/lang/Boolean;", "shouldLockLayout", "Lcom/tencent/qqnt/chats/core/ui/l$b;", "listener", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/qqnt/chats/core/ui/l$b;)V", "c", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Boolean shouldLockLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.ui.l$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/l$b;", "", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@NotNull RecyclerView recyclerView, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.recyclerView = recyclerView;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) bVar);
        }
    }

    public final synchronized boolean a(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) scene)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.recyclerView.isLayoutSuppressed()) {
            QLog.i("ChatsLockLayoutHelper", 1, "[doLock] already locked, scene=" + scene);
            return false;
        }
        this.recyclerView.suppressLayout(true);
        QLog.i("ChatsLockLayoutHelper", 1, "[doLock] start locking, scene=" + scene);
        return true;
    }

    public final synchronized boolean b(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) scene)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.shouldLockLayout = Boolean.FALSE;
        if (!this.recyclerView.isLayoutSuppressed()) {
            QLog.i("ChatsLockLayoutHelper", 1, "[unlock] already unlocked, scene=" + scene);
            return false;
        }
        this.recyclerView.suppressLayout(false);
        QLog.i("ChatsLockLayoutHelper", 1, "[unlock] stop locking, scene=" + scene);
        return true;
    }

    public /* synthetic */ l(RecyclerView recyclerView, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i3 & 2) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, recyclerView, bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

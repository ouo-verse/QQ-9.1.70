package com.tencent.mobileqq.troop.shortcut.aio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "HideSubMenu", "ShowSubmenu", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState$HideSubMenu;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState$ShowSubmenu;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class ShortcutAioUIState implements MviUIState {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState$HideSubMenu;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState;", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class HideSubMenu extends ShortcutAioUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideSubMenu f298457d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55066);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f298457d = new HideSubMenu();
            }
        }

        HideSubMenu() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState$ShowSubmenu;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "d", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "c", "()Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "shortcutInfo", "Lcom/tencent/mobileqq/troop/shortcut/action/a;", "e", "Lcom/tencent/mobileqq/troop/shortcut/action/a;", "b", "()Lcom/tencent/mobileqq/troop/shortcut/action/a;", "executor", "", "f", "I", "a", "()I", "barYPosition", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;Lcom/tencent/mobileqq/troop/shortcut/action/a;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class ShowSubmenu extends ShortcutAioUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TroopShortcutInfo shortcutInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.troop.shortcut.action.a executor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int barYPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSubmenu(@NotNull TroopShortcutInfo shortcutInfo, @NotNull com.tencent.mobileqq.troop.shortcut.action.a executor, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
            Intrinsics.checkNotNullParameter(executor, "executor");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, shortcutInfo, executor, Integer.valueOf(i3));
                return;
            }
            this.shortcutInfo = shortcutInfo;
            this.executor = executor;
            this.barYPosition = i3;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.barYPosition;
        }

        @NotNull
        public final com.tencent.mobileqq.troop.shortcut.action.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.troop.shortcut.action.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.executor;
        }

        @NotNull
        public final TroopShortcutInfo c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopShortcutInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.shortcutInfo;
        }
    }

    public /* synthetic */ ShortcutAioUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    ShortcutAioUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

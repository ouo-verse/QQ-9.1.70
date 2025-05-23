package com.tencent.mobileqq.troop.shortcut.aio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnSubmenuHide", "OnSubmenuShown", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage$OnSubmenuHide;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage$OnSubmenuShown;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class ShortcutMessage implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage$OnSubmenuHide;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "d", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "getShortcutInfo", "()Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "shortcutInfo", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class OnSubmenuHide extends ShortcutMessage {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final TroopShortcutInfo shortcutInfo;

        public OnSubmenuHide(@Nullable TroopShortcutInfo troopShortcutInfo) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopShortcutInfo);
            } else {
                this.shortcutInfo = troopShortcutInfo;
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.troop.shortcut.aio.ShortcutMessage.OnSubmenuHide";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage$OnSubmenuShown;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutMessage;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "d", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "a", "()Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "shortcutInfo", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class OnSubmenuShown extends ShortcutMessage {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final TroopShortcutInfo shortcutInfo;

        public OnSubmenuShown(@Nullable TroopShortcutInfo troopShortcutInfo) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopShortcutInfo);
            } else {
                this.shortcutInfo = troopShortcutInfo;
            }
        }

        @Nullable
        public final TroopShortcutInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopShortcutInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.shortcutInfo;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.troop.shortcut.aio.ShortcutMessage.OnSubmenuShown";
        }
    }

    public /* synthetic */ ShortcutMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    ShortcutMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

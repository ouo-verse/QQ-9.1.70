package com.tencent.mobileqq.troop.shortcut.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u00013Bq\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0018\u0010%R\u0019\u0010+\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\t\u0010*R\u0017\u0010-\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b(\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "appId", "b", "f", "name", "d", "icon", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "g", "()Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "type", "e", "Z", "getRemovable", "()Z", "removable", "getDesc", "desc", "getAdded", "added", "", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", h.F, "Ljava/util/List;", "()Ljava/util/List;", "menu", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "i", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "()Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "j", "adId", "k", "(Z)V", "isSelected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;ZLjava/lang/String;ZLjava/util/List;Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;Ljava/lang/String;)V", "AppType", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopShortcutInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean removable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean added;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TroopShortcutMenu> menu;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopShortcutAction action;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String adId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo$AppType;", "", "(Ljava/lang/String;I)V", "TYPE_DEFAULT", "TYPE_PLATFORM", "TYPE_MINI_PROGRAM", "TYPE_ROBOT", "TYPE_CAPSULE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class AppType {
        private static final /* synthetic */ AppType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AppType TYPE_CAPSULE;
        public static final AppType TYPE_DEFAULT;
        public static final AppType TYPE_MINI_PROGRAM;
        public static final AppType TYPE_PLATFORM;
        public static final AppType TYPE_ROBOT;

        private static final /* synthetic */ AppType[] $values() {
            return new AppType[]{TYPE_DEFAULT, TYPE_PLATFORM, TYPE_MINI_PROGRAM, TYPE_ROBOT, TYPE_CAPSULE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55263);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TYPE_DEFAULT = new AppType("TYPE_DEFAULT", 0);
            TYPE_PLATFORM = new AppType("TYPE_PLATFORM", 1);
            TYPE_MINI_PROGRAM = new AppType("TYPE_MINI_PROGRAM", 2);
            TYPE_ROBOT = new AppType("TYPE_ROBOT", 3);
            TYPE_CAPSULE = new AppType("TYPE_CAPSULE", 4);
            $VALUES = $values();
        }

        AppType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static AppType valueOf(String str) {
            return (AppType) Enum.valueOf(AppType.class, str);
        }

        public static AppType[] values() {
            return (AppType[]) $VALUES.clone();
        }
    }

    public TroopShortcutInfo(@NotNull String appId, @NotNull String name, @NotNull String icon, @NotNull AppType type, boolean z16, @NotNull String desc, boolean z17, @NotNull List<TroopShortcutMenu> menu, @Nullable TroopShortcutAction troopShortcutAction, @NotNull String adId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(adId, "adId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, name, icon, type, Boolean.valueOf(z16), desc, Boolean.valueOf(z17), menu, troopShortcutAction, adId);
            return;
        }
        this.appId = appId;
        this.name = name;
        this.icon = icon;
        this.type = type;
        this.removable = z16;
        this.desc = desc;
        this.added = z17;
        this.menu = menu;
        this.action = troopShortcutAction;
        this.adId = adId;
    }

    @Nullable
    public final TroopShortcutAction a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TroopShortcutAction) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.action;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.adId;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.icon;
    }

    @NotNull
    public final List<TroopShortcutMenu> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.menu;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopShortcutInfo)) {
            return false;
        }
        TroopShortcutInfo troopShortcutInfo = (TroopShortcutInfo) other;
        if (Intrinsics.areEqual(this.appId, troopShortcutInfo.appId) && Intrinsics.areEqual(this.name, troopShortcutInfo.name) && Intrinsics.areEqual(this.icon, troopShortcutInfo.icon) && this.type == troopShortcutInfo.type && this.removable == troopShortcutInfo.removable && Intrinsics.areEqual(this.desc, troopShortcutInfo.desc) && this.added == troopShortcutInfo.added && Intrinsics.areEqual(this.menu, troopShortcutInfo.menu) && Intrinsics.areEqual(this.action, troopShortcutInfo.action) && Intrinsics.areEqual(this.adId, troopShortcutInfo.adId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final AppType g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppType) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.type;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.isSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.appId.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z16 = this.removable;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode3 = (((hashCode2 + i16) * 31) + this.desc.hashCode()) * 31;
        boolean z17 = this.added;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int hashCode4 = (((hashCode3 + i3) * 31) + this.menu.hashCode()) * 31;
        TroopShortcutAction troopShortcutAction = this.action;
        if (troopShortcutAction == null) {
            hashCode = 0;
        } else {
            hashCode = troopShortcutAction.hashCode();
        }
        return ((hashCode4 + hashCode) * 31) + this.adId.hashCode();
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.isSelected = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "TroopShortcutInfo(appId=" + this.appId + ", name=" + this.name + ", icon=" + this.icon + ", type=" + this.type + ", removable=" + this.removable + ", desc=" + this.desc + ", added=" + this.added + ", menu=" + this.menu + ", action=" + this.action + ", adId=" + this.adId + ")";
    }
}

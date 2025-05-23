package com.tencent.mobileqq.troop.shortcut.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#BU\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\t\u0010\u001eR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0018\u0010\f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "id", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "b", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "f", "()Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "template", "c", "icon", h.F, "title", "e", "desc", "g", "text", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "()Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "rightText", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;Ljava/lang/String;)V", "MenuTemplate", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopShortcutMenu {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MenuTemplate template;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopShortcutAction action;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String rightText;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "", "(Ljava/lang/String;I)V", "TEMPLATE_DEFAULT", "TEMPLATE_SINGLE_LINE_TEXT_TEXT", "TEMPLATE_SINGLE_LINE_ICON_TEXT", "TEMPLATE_SINGLE_LINE_TEXT_ICON", "TEMPLATE_SINGLE_LINE_ICON_ICON", "TEMPLATE_TWO_LINE_TEXT_BTN", "TEMPLATE_TWO_LINE_ICON_BTN", "TEMPLATE_TWO_LINE_TEXT_ICON", "TEMPLATE_TWO_LINE_ICON_ICON", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class MenuTemplate {
        private static final /* synthetic */ MenuTemplate[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MenuTemplate TEMPLATE_DEFAULT;
        public static final MenuTemplate TEMPLATE_SINGLE_LINE_ICON_ICON;
        public static final MenuTemplate TEMPLATE_SINGLE_LINE_ICON_TEXT;
        public static final MenuTemplate TEMPLATE_SINGLE_LINE_TEXT_ICON;
        public static final MenuTemplate TEMPLATE_SINGLE_LINE_TEXT_TEXT;
        public static final MenuTemplate TEMPLATE_TWO_LINE_ICON_BTN;
        public static final MenuTemplate TEMPLATE_TWO_LINE_ICON_ICON;
        public static final MenuTemplate TEMPLATE_TWO_LINE_TEXT_BTN;
        public static final MenuTemplate TEMPLATE_TWO_LINE_TEXT_ICON;

        private static final /* synthetic */ MenuTemplate[] $values() {
            return new MenuTemplate[]{TEMPLATE_DEFAULT, TEMPLATE_SINGLE_LINE_TEXT_TEXT, TEMPLATE_SINGLE_LINE_ICON_TEXT, TEMPLATE_SINGLE_LINE_TEXT_ICON, TEMPLATE_SINGLE_LINE_ICON_ICON, TEMPLATE_TWO_LINE_TEXT_BTN, TEMPLATE_TWO_LINE_ICON_BTN, TEMPLATE_TWO_LINE_TEXT_ICON, TEMPLATE_TWO_LINE_ICON_ICON};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55268);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TEMPLATE_DEFAULT = new MenuTemplate("TEMPLATE_DEFAULT", 0);
            TEMPLATE_SINGLE_LINE_TEXT_TEXT = new MenuTemplate("TEMPLATE_SINGLE_LINE_TEXT_TEXT", 1);
            TEMPLATE_SINGLE_LINE_ICON_TEXT = new MenuTemplate("TEMPLATE_SINGLE_LINE_ICON_TEXT", 2);
            TEMPLATE_SINGLE_LINE_TEXT_ICON = new MenuTemplate("TEMPLATE_SINGLE_LINE_TEXT_ICON", 3);
            TEMPLATE_SINGLE_LINE_ICON_ICON = new MenuTemplate("TEMPLATE_SINGLE_LINE_ICON_ICON", 4);
            TEMPLATE_TWO_LINE_TEXT_BTN = new MenuTemplate("TEMPLATE_TWO_LINE_TEXT_BTN", 5);
            TEMPLATE_TWO_LINE_ICON_BTN = new MenuTemplate("TEMPLATE_TWO_LINE_ICON_BTN", 6);
            TEMPLATE_TWO_LINE_TEXT_ICON = new MenuTemplate("TEMPLATE_TWO_LINE_TEXT_ICON", 7);
            TEMPLATE_TWO_LINE_ICON_ICON = new MenuTemplate("TEMPLATE_TWO_LINE_ICON_ICON", 8);
            $VALUES = $values();
        }

        MenuTemplate(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static MenuTemplate valueOf(String str) {
            return (MenuTemplate) Enum.valueOf(MenuTemplate.class, str);
        }

        public static MenuTemplate[] values() {
            return (MenuTemplate[]) $VALUES.clone();
        }
    }

    public TroopShortcutMenu(@NotNull String id5, @NotNull MenuTemplate template, @NotNull String icon, @NotNull String title, @NotNull String desc, @NotNull String text, @NotNull TroopShortcutAction action, @NotNull String rightText) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, template, icon, title, desc, text, action, rightText);
            return;
        }
        this.id = id5;
        this.template = template;
        this.icon = icon;
        this.title = title;
        this.desc = desc;
        this.text = text;
        this.action = action;
        this.rightText = rightText;
    }

    @NotNull
    public final TroopShortcutAction a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopShortcutAction) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.action;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.desc;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.icon;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.rightText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopShortcutMenu)) {
            return false;
        }
        TroopShortcutMenu troopShortcutMenu = (TroopShortcutMenu) other;
        if (Intrinsics.areEqual(this.id, troopShortcutMenu.id) && this.template == troopShortcutMenu.template && Intrinsics.areEqual(this.icon, troopShortcutMenu.icon) && Intrinsics.areEqual(this.title, troopShortcutMenu.title) && Intrinsics.areEqual(this.desc, troopShortcutMenu.desc) && Intrinsics.areEqual(this.text, troopShortcutMenu.text) && Intrinsics.areEqual(this.action, troopShortcutMenu.action) && Intrinsics.areEqual(this.rightText, troopShortcutMenu.rightText)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MenuTemplate f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MenuTemplate) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.template;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.text;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.title;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (((((((((((((this.id.hashCode() * 31) + this.template.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.text.hashCode()) * 31) + this.action.hashCode()) * 31) + this.rightText.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "TroopShortcutMenu(id=" + this.id + ", template=" + this.template + ", icon=" + this.icon + ", title=" + this.title + ", desc=" + this.desc + ", text=" + this.text + ", action=" + this.action + ", rightText=" + this.rightText + ")";
    }
}

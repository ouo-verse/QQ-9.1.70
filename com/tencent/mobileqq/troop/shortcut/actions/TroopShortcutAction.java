package com.tencent.mobileqq.troop.shortcut.actions;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$BQ\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "a", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "f", "()Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "", "Lcom/tencent/mobileqq/troop/shortcut/actions/Message;", "c", "Ljava/util/List;", "d", "()Ljava/util/List;", "content", "e", "troopUin", "appUrl", "Z", "g", "()Z", "isGuildApp", "associatedId", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "Type", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class TroopShortcutAction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Type type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Message> content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isGuildApp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String associatedId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction$Type;", "", "(Ljava/lang/String;I)V", "ACTION_DEFAULT", "APP_ID", "SCHEMA", CheckForwardServlet.KEY_CMD, "OPEN_MENU", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class Type {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Type ACTION_DEFAULT;
        public static final Type APP_ID;
        public static final Type CMD;
        public static final Type OPEN_MENU;
        public static final Type SCHEMA;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{ACTION_DEFAULT, APP_ID, SCHEMA, CMD, OPEN_MENU};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24960);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ACTION_DEFAULT = new Type("ACTION_DEFAULT", 0);
            APP_ID = new Type("APP_ID", 1);
            SCHEMA = new Type("SCHEMA", 2);
            CMD = new Type(CheckForwardServlet.KEY_CMD, 3);
            OPEN_MENU = new Type("OPEN_MENU", 4);
            $VALUES = $values();
        }

        Type(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public TroopShortcutAction(@NotNull Type type, @NotNull String appId, @NotNull List<Message> content, @NotNull String troopUin, @NotNull String appUrl, boolean z16, @NotNull String associatedId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(appUrl, "appUrl");
        Intrinsics.checkNotNullParameter(associatedId, "associatedId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, type, appId, content, troopUin, appUrl, Boolean.valueOf(z16), associatedId);
            return;
        }
        this.type = type;
        this.appId = appId;
        this.content = content;
        this.troopUin = troopUin;
        this.appUrl = appUrl;
        this.isGuildApp = z16;
        this.associatedId = associatedId;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.appUrl;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.associatedId;
    }

    @NotNull
    public final List<Message> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopShortcutAction)) {
            return false;
        }
        TroopShortcutAction troopShortcutAction = (TroopShortcutAction) other;
        if (this.type == troopShortcutAction.type && Intrinsics.areEqual(this.appId, troopShortcutAction.appId) && Intrinsics.areEqual(this.content, troopShortcutAction.content) && Intrinsics.areEqual(this.troopUin, troopShortcutAction.troopUin) && Intrinsics.areEqual(this.appUrl, troopShortcutAction.appUrl) && this.isGuildApp == troopShortcutAction.isGuildApp && Intrinsics.areEqual(this.associatedId, troopShortcutAction.associatedId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Type f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Type) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.type;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isGuildApp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int hashCode = ((((((((this.type.hashCode() * 31) + this.appId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.troopUin.hashCode()) * 31) + this.appUrl.hashCode()) * 31;
        boolean z16 = this.isGuildApp;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.associatedId.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TroopShortcutAction(type=" + this.type + ", appId=" + this.appId + ", content=" + this.content + ", troopUin=" + this.troopUin + ", appUrl=" + this.appUrl + ", isGuildApp=" + this.isGuildApp + ", associatedId=" + this.associatedId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TroopShortcutAction(Type type, String str, List list, String str2, String str3, boolean z16, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, r4, r5, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? "" : str4);
        List list2;
        List emptyList;
        String str5 = (i3 & 2) != 0 ? "" : str;
        if ((i3 & 4) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, type, str, list, str2, str3, Boolean.valueOf(z16), str4, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

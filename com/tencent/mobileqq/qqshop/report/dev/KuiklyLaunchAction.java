package com.tencent.mobileqq.qqshop.report.dev;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchAction;", "", "key", "", "milestone", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getMilestone", "()I", "USER_CLICK", "PAGE_OPEN_START", "LOAD_VIEW_START", "LOAD_VIEW_END", "KUIKLY_INIT_START", "KUIKLY_CONTENT_VIEW_CREATED", "FIRST_SCREEN", "FETCH_MSG_START", "FETCH_MSG_END", "MSG_CARD_SHOW", "PAGE_EXIT", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class KuiklyLaunchAction {
    private static final /* synthetic */ KuiklyLaunchAction[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final KuiklyLaunchAction FETCH_MSG_END;
    public static final KuiklyLaunchAction FETCH_MSG_START;
    public static final KuiklyLaunchAction FIRST_SCREEN;
    public static final KuiklyLaunchAction KUIKLY_CONTENT_VIEW_CREATED;
    public static final KuiklyLaunchAction KUIKLY_INIT_START;
    public static final KuiklyLaunchAction LOAD_VIEW_END;
    public static final KuiklyLaunchAction LOAD_VIEW_START;
    public static final KuiklyLaunchAction MSG_CARD_SHOW;
    public static final KuiklyLaunchAction PAGE_EXIT;
    public static final KuiklyLaunchAction PAGE_OPEN_START;
    public static final KuiklyLaunchAction USER_CLICK;

    @NotNull
    private final String key;
    private final int milestone;

    private static final /* synthetic */ KuiklyLaunchAction[] $values() {
        return new KuiklyLaunchAction[]{USER_CLICK, PAGE_OPEN_START, LOAD_VIEW_START, LOAD_VIEW_END, KUIKLY_INIT_START, KUIKLY_CONTENT_VIEW_CREATED, FIRST_SCREEN, FETCH_MSG_START, FETCH_MSG_END, MSG_CARD_SHOW, PAGE_EXIT};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        USER_CLICK = new KuiklyLaunchAction("USER_CLICK", 0, "user_click", 0, 2, null);
        PAGE_OPEN_START = new KuiklyLaunchAction("PAGE_OPEN_START", 1, "page_open_start", 1);
        int i3 = 0;
        int i16 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LOAD_VIEW_START = new KuiklyLaunchAction("LOAD_VIEW_START", 2, "load_view_start", i3, i16, defaultConstructorMarker);
        int i17 = 0;
        int i18 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        LOAD_VIEW_END = new KuiklyLaunchAction("LOAD_VIEW_END", 3, "load_view_end", i17, i18, defaultConstructorMarker2);
        KUIKLY_INIT_START = new KuiklyLaunchAction("KUIKLY_INIT_START", 4, "kuikly_init_start", 2);
        KUIKLY_CONTENT_VIEW_CREATED = new KuiklyLaunchAction("KUIKLY_CONTENT_VIEW_CREATED", 5, "kuikly_content_view_created", 4);
        FIRST_SCREEN = new KuiklyLaunchAction("FIRST_SCREEN", 6, "first_screen", 8);
        FETCH_MSG_START = new KuiklyLaunchAction("FETCH_MSG_START", 7, "fetch_msg_start", i3, i16, defaultConstructorMarker);
        FETCH_MSG_END = new KuiklyLaunchAction("FETCH_MSG_END", 8, "fetch_msg_end", i17, i18, defaultConstructorMarker2);
        MSG_CARD_SHOW = new KuiklyLaunchAction("MSG_CARD_SHOW", 9, "msg_card_show", 16);
        PAGE_EXIT = new KuiklyLaunchAction("PAGE_EXIT", 10, "page_exit", 32);
        $VALUES = $values();
    }

    KuiklyLaunchAction(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
        } else {
            this.key = str2;
            this.milestone = i16;
        }
    }

    public static KuiklyLaunchAction valueOf(String str) {
        return (KuiklyLaunchAction) Enum.valueOf(KuiklyLaunchAction.class, str);
    }

    public static KuiklyLaunchAction[] values() {
        return (KuiklyLaunchAction[]) $VALUES.clone();
    }

    @NotNull
    public final String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.key;
    }

    public final int getMilestone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.milestone;
    }

    /* synthetic */ KuiklyLaunchAction(String str, int i3, String str2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i17 & 2) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}

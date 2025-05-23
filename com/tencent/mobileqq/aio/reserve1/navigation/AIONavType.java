package com.tencent.mobileqq.aio.reserve1.navigation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "AT_ME", "ANONYMOUS_AT_ME", "REPLY_AT_ME", "CONFESS_AT_ME", "MY_RED_ENVELOPE", "AT_ONE_RED_ENVELOPE", "GIFT_AT_ME", "AT_ALL", "NEW_FILE", "NORMAL_RED_ENVELOPE", "HOMEWORK", "ANNOUNCE", "ANNOUNCE_NEED_CONFIRM", "KEYWORD_NOTIFY", "SPECIAL_NOTIFY", "UNREAD", "TEAM_UP", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIONavType {
    private static final /* synthetic */ AIONavType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AIONavType ANNOUNCE;
    public static final AIONavType ANNOUNCE_NEED_CONFIRM;
    public static final AIONavType ANONYMOUS_AT_ME;
    public static final AIONavType AT_ALL;
    public static final AIONavType AT_ME;
    public static final AIONavType AT_ONE_RED_ENVELOPE;
    public static final AIONavType CONFESS_AT_ME;
    public static final AIONavType GIFT_AT_ME;
    public static final AIONavType HOMEWORK;
    public static final AIONavType KEYWORD_NOTIFY;
    public static final AIONavType MY_RED_ENVELOPE;
    public static final AIONavType NEW_FILE;
    public static final AIONavType NORMAL_RED_ENVELOPE;
    public static final AIONavType REPLY_AT_ME;
    public static final AIONavType SPECIAL_NOTIFY;
    public static final AIONavType TEAM_UP;
    public static final AIONavType UNKNOWN;
    public static final AIONavType UNREAD;

    private static final /* synthetic */ AIONavType[] $values() {
        return new AIONavType[]{UNKNOWN, AT_ME, ANONYMOUS_AT_ME, REPLY_AT_ME, CONFESS_AT_ME, MY_RED_ENVELOPE, AT_ONE_RED_ENVELOPE, GIFT_AT_ME, AT_ALL, NEW_FILE, NORMAL_RED_ENVELOPE, HOMEWORK, ANNOUNCE, ANNOUNCE_NEED_CONFIRM, KEYWORD_NOTIFY, SPECIAL_NOTIFY, UNREAD, TEAM_UP};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UNKNOWN = new AIONavType("UNKNOWN", 0);
        AT_ME = new AIONavType("AT_ME", 1);
        ANONYMOUS_AT_ME = new AIONavType("ANONYMOUS_AT_ME", 2);
        REPLY_AT_ME = new AIONavType("REPLY_AT_ME", 3);
        CONFESS_AT_ME = new AIONavType("CONFESS_AT_ME", 4);
        MY_RED_ENVELOPE = new AIONavType("MY_RED_ENVELOPE", 5);
        AT_ONE_RED_ENVELOPE = new AIONavType("AT_ONE_RED_ENVELOPE", 6);
        GIFT_AT_ME = new AIONavType("GIFT_AT_ME", 7);
        AT_ALL = new AIONavType("AT_ALL", 8);
        NEW_FILE = new AIONavType("NEW_FILE", 9);
        NORMAL_RED_ENVELOPE = new AIONavType("NORMAL_RED_ENVELOPE", 10);
        HOMEWORK = new AIONavType("HOMEWORK", 11);
        ANNOUNCE = new AIONavType("ANNOUNCE", 12);
        ANNOUNCE_NEED_CONFIRM = new AIONavType("ANNOUNCE_NEED_CONFIRM", 13);
        KEYWORD_NOTIFY = new AIONavType("KEYWORD_NOTIFY", 14);
        SPECIAL_NOTIFY = new AIONavType("SPECIAL_NOTIFY", 15);
        UNREAD = new AIONavType("UNREAD", 16);
        TEAM_UP = new AIONavType("TEAM_UP", 17);
        $VALUES = $values();
    }

    AIONavType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AIONavType valueOf(String str) {
        return (AIONavType) Enum.valueOf(AIONavType.class, str);
    }

    public static AIONavType[] values() {
        return (AIONavType[]) $VALUES.clone();
    }
}

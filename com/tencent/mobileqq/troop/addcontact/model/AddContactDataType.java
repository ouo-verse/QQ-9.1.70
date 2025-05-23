package com.tencent.mobileqq.troop.addcontact.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "", "(Ljava/lang/String;I)V", "GROUP", "PERSON", "GUILD", "FLOCK", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class AddContactDataType {
    private static final /* synthetic */ AddContactDataType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AddContactDataType FLOCK;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final AddContactDataType f293812GROUP;
    public static final AddContactDataType GUILD;
    public static final AddContactDataType PERSON;

    private static final /* synthetic */ AddContactDataType[] $values() {
        return new AddContactDataType[]{f293812GROUP, PERSON, GUILD, FLOCK};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293812GROUP = new AddContactDataType("GROUP", 0);
        PERSON = new AddContactDataType("PERSON", 1);
        GUILD = new AddContactDataType("GUILD", 2);
        FLOCK = new AddContactDataType("FLOCK", 3);
        $VALUES = $values();
    }

    AddContactDataType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AddContactDataType valueOf(String str) {
        return (AddContactDataType) Enum.valueOf(AddContactDataType.class, str);
    }

    public static AddContactDataType[] values() {
        return (AddContactDataType[]) $VALUES.clone();
    }
}

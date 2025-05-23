package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class CommandType {
    private static final /* synthetic */ CommandType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CommandType COMMANDTYPEM8;
    public static final CommandType COMMANDTYPEM8LORD;
    public static final CommandType COMMANDTYPEQQ;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CommandType commandType = new CommandType("COMMANDTYPEQQ", 0);
        COMMANDTYPEQQ = commandType;
        CommandType commandType2 = new CommandType("COMMANDTYPEM8", 1);
        COMMANDTYPEM8 = commandType2;
        CommandType commandType3 = new CommandType("COMMANDTYPEM8LORD", 2);
        COMMANDTYPEM8LORD = commandType3;
        $VALUES = new CommandType[]{commandType, commandType2, commandType3};
    }

    CommandType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static CommandType valueOf(String str) {
        return (CommandType) Enum.valueOf(CommandType.class, str);
    }

    public static CommandType[] values() {
        return (CommandType[]) $VALUES.clone();
    }
}

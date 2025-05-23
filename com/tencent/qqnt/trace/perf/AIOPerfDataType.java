package com.tencent.qqnt.trace.perf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "", "(Ljava/lang/String;I)V", "CHAT_LIST_SHOW", "SYNC_MSG_TIME", "CHAT_LIST_REFRESH_COUNT", "AIO_LOAD_TIME", "AIO_TRANSITION_ANIMATION_PERF", "MEMORY_STATUS", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AIOPerfDataType {
    private static final /* synthetic */ AIOPerfDataType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AIOPerfDataType AIO_LOAD_TIME;
    public static final AIOPerfDataType AIO_TRANSITION_ANIMATION_PERF;
    public static final AIOPerfDataType CHAT_LIST_REFRESH_COUNT;
    public static final AIOPerfDataType CHAT_LIST_SHOW;
    public static final AIOPerfDataType MEMORY_STATUS;
    public static final AIOPerfDataType SYNC_MSG_TIME;

    private static final /* synthetic */ AIOPerfDataType[] $values() {
        return new AIOPerfDataType[]{CHAT_LIST_SHOW, SYNC_MSG_TIME, CHAT_LIST_REFRESH_COUNT, AIO_LOAD_TIME, AIO_TRANSITION_ANIMATION_PERF, MEMORY_STATUS};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CHAT_LIST_SHOW = new AIOPerfDataType("CHAT_LIST_SHOW", 0);
        SYNC_MSG_TIME = new AIOPerfDataType("SYNC_MSG_TIME", 1);
        CHAT_LIST_REFRESH_COUNT = new AIOPerfDataType("CHAT_LIST_REFRESH_COUNT", 2);
        AIO_LOAD_TIME = new AIOPerfDataType("AIO_LOAD_TIME", 3);
        AIO_TRANSITION_ANIMATION_PERF = new AIOPerfDataType("AIO_TRANSITION_ANIMATION_PERF", 4);
        MEMORY_STATUS = new AIOPerfDataType("MEMORY_STATUS", 5);
        $VALUES = $values();
    }

    AIOPerfDataType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AIOPerfDataType valueOf(String str) {
        return (AIOPerfDataType) Enum.valueOf(AIOPerfDataType.class, str);
    }

    public static AIOPerfDataType[] values() {
        return (AIOPerfDataType[]) $VALUES.clone();
    }
}

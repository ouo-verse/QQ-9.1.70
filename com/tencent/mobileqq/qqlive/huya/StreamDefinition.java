package com.tencent.mobileqq.qqlive.huya;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/StreamDefinition;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNKNOWN", "ORIGIN", "SD", "HD", "SHD", "FHD", "THFD", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class StreamDefinition {
    private static final /* synthetic */ StreamDefinition[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final StreamDefinition FHD;
    public static final StreamDefinition HD;
    public static final StreamDefinition ORIGIN;
    public static final StreamDefinition SD;
    public static final StreamDefinition SHD;
    public static final StreamDefinition THFD;
    public static final StreamDefinition UNKNOWN;
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/StreamDefinition$a;", "", "<init>", "()V", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.huya.StreamDefinition$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ StreamDefinition[] $values() {
        return new StreamDefinition[]{UNKNOWN, ORIGIN, SD, HD, SHD, FHD, THFD};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        UNKNOWN = new StreamDefinition("UNKNOWN", 0, -1);
        ORIGIN = new StreamDefinition("ORIGIN", 1, 0);
        SD = new StreamDefinition("SD", 2, 1);
        HD = new StreamDefinition("HD", 3, 2);
        SHD = new StreamDefinition("SHD", 4, 3);
        FHD = new StreamDefinition("FHD", 5, 4);
        THFD = new StreamDefinition("THFD", 6, 5);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    StreamDefinition(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static StreamDefinition valueOf(String str) {
        return (StreamDefinition) Enum.valueOf(StreamDefinition.class, str);
    }

    public static StreamDefinition[] values() {
        return (StreamDefinition[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}

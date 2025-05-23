package com.tencent.mobileqq.qqlive.widget.chat.font;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "", "desc", "", "sp", "", "(Ljava/lang/String;ILjava/lang/String;F)V", "getDesc", "()Ljava/lang/String;", "getSp", "()F", "SMALL", "STANDARD", "LARGE", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class FontSize {
    private static final /* synthetic */ FontSize[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FontSize LARGE;
    public static final FontSize SMALL;
    public static final FontSize STANDARD;

    @NotNull
    private final String desc;
    private final float sp;

    private static final /* synthetic */ FontSize[] $values() {
        return new FontSize[]{SMALL, STANDARD, LARGE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        SMALL = new FontSize("SMALL", 0, "\u5c0f", 12.0f);
        STANDARD = new FontSize("STANDARD", 1, "\u6807\u51c6", 14.0f);
        LARGE = new FontSize("LARGE", 2, "\u5927", 16.0f);
        $VALUES = $values();
    }

    FontSize(String str, int i3, String str2, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Float.valueOf(f16));
        } else {
            this.desc = str2;
            this.sp = f16;
        }
    }

    public static FontSize valueOf(String str) {
        return (FontSize) Enum.valueOf(FontSize.class, str);
    }

    public static FontSize[] values() {
        return (FontSize[]) $VALUES.clone();
    }

    @NotNull
    public final String getDesc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.desc;
    }

    public final float getSp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.sp;
    }
}

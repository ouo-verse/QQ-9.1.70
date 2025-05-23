package com.tencent.qqnt.chathistory.ui.widget.bottomBar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarType;", "", "(Ljava/lang/String;I)V", "MEDIA", "STICKER", "FILE", "DOCUMENT", "LINK", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class BottomBarType {
    private static final /* synthetic */ BottomBarType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final BottomBarType DOCUMENT;
    public static final BottomBarType FILE;
    public static final BottomBarType LINK;
    public static final BottomBarType MEDIA;
    public static final BottomBarType STICKER;

    private static final /* synthetic */ BottomBarType[] $values() {
        return new BottomBarType[]{MEDIA, STICKER, FILE, DOCUMENT, LINK};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MEDIA = new BottomBarType("MEDIA", 0);
        STICKER = new BottomBarType("STICKER", 1);
        FILE = new BottomBarType("FILE", 2);
        DOCUMENT = new BottomBarType("DOCUMENT", 3);
        LINK = new BottomBarType("LINK", 4);
        $VALUES = $values();
    }

    BottomBarType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static BottomBarType valueOf(String str) {
        return (BottomBarType) Enum.valueOf(BottomBarType.class, str);
    }

    public static BottomBarType[] values() {
        return (BottomBarType[]) $VALUES.clone();
    }
}

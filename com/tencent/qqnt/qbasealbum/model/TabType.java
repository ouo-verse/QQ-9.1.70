package com.tencent.qqnt.qbasealbum.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/TabType;", "", "(Ljava/lang/String;I)V", "TAB_ALL", "TAB_MEDIA", "TAB_IMAGE", "TAB_VIDEO", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TabType {
    private static final /* synthetic */ TabType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TabType TAB_ALL;
    public static final TabType TAB_IMAGE;
    public static final TabType TAB_MEDIA;
    public static final TabType TAB_VIDEO;

    private static final /* synthetic */ TabType[] $values() {
        return new TabType[]{TAB_ALL, TAB_MEDIA, TAB_IMAGE, TAB_VIDEO};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAB_ALL = new TabType("TAB_ALL", 0);
        TAB_MEDIA = new TabType("TAB_MEDIA", 1);
        TAB_IMAGE = new TabType("TAB_IMAGE", 2);
        TAB_VIDEO = new TabType("TAB_VIDEO", 3);
        $VALUES = $values();
    }

    TabType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TabType valueOf(String str) {
        return (TabType) Enum.valueOf(TabType.class, str);
    }

    public static TabType[] values() {
        return (TabType[]) $VALUES.clone();
    }
}

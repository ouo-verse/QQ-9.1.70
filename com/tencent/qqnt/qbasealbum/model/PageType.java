package com.tencent.qqnt.qbasealbum.model;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PageType;", "", "(Ljava/lang/String;I)V", "isImage", "", "isLocalMedia", "isOnlineMedia", "isQZoneMedia", BaseProfileQZoneComponent.KEY_IS_VIDEO, "LOCAL_ALL", "LOCAL_IMAGE", "LOCAL_VIDEO", "QZONE_ALL", "QZONE_IMAGE", "QZONE_VIDEO", "ONLINE_ALL", "ONLINE_IMAGE", "ONLINE_VIDEO", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PageType {
    private static final /* synthetic */ PageType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PageType LOCAL_ALL;
    public static final PageType LOCAL_IMAGE;
    public static final PageType LOCAL_VIDEO;
    public static final PageType ONLINE_ALL;
    public static final PageType ONLINE_IMAGE;
    public static final PageType ONLINE_VIDEO;
    public static final PageType QZONE_ALL;
    public static final PageType QZONE_IMAGE;
    public static final PageType QZONE_VIDEO;

    private static final /* synthetic */ PageType[] $values() {
        return new PageType[]{LOCAL_ALL, LOCAL_IMAGE, LOCAL_VIDEO, QZONE_ALL, QZONE_IMAGE, QZONE_VIDEO, ONLINE_ALL, ONLINE_IMAGE, ONLINE_VIDEO};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        LOCAL_ALL = new PageType("LOCAL_ALL", 0);
        LOCAL_IMAGE = new PageType("LOCAL_IMAGE", 1);
        LOCAL_VIDEO = new PageType("LOCAL_VIDEO", 2);
        QZONE_ALL = new PageType("QZONE_ALL", 3);
        QZONE_IMAGE = new PageType("QZONE_IMAGE", 4);
        QZONE_VIDEO = new PageType("QZONE_VIDEO", 5);
        ONLINE_ALL = new PageType("ONLINE_ALL", 6);
        ONLINE_IMAGE = new PageType("ONLINE_IMAGE", 7);
        ONLINE_VIDEO = new PageType("ONLINE_VIDEO", 8);
        $VALUES = $values();
    }

    PageType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PageType valueOf(String str) {
        return (PageType) Enum.valueOf(PageType.class, str);
    }

    public static PageType[] values() {
        return (PageType[]) $VALUES.clone();
    }

    public final boolean isImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this != QZONE_IMAGE && this != LOCAL_IMAGE && this != ONLINE_IMAGE) {
            return false;
        }
        return true;
    }

    public final boolean isLocalMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this != LOCAL_ALL && this != LOCAL_IMAGE && this != LOCAL_VIDEO) {
            return false;
        }
        return true;
    }

    public final boolean isOnlineMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this != ONLINE_ALL && this != ONLINE_IMAGE && this != ONLINE_VIDEO) {
            return false;
        }
        return true;
    }

    public final boolean isQZoneMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this != QZONE_ALL && this != QZONE_IMAGE && this != QZONE_VIDEO) {
            return false;
        }
        return true;
    }

    public final boolean isVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this != QZONE_VIDEO && this != LOCAL_VIDEO && this != ONLINE_VIDEO) {
            return false;
        }
        return true;
    }
}

package com.tencent.qqnt.chats.core.ui.third.p013const;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/const/RelativeEnum;", "", "(Ljava/lang/String;I)V", "BottomToBannerBottom", "TopToBannerBottom", "StartToParentLeft", "EndToParentEnd", "TopToBannerTop", "BannerCenter", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class RelativeEnum {
    private static final /* synthetic */ RelativeEnum[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RelativeEnum BannerCenter;
    public static final RelativeEnum BottomToBannerBottom;
    public static final RelativeEnum EndToParentEnd;
    public static final RelativeEnum StartToParentLeft;
    public static final RelativeEnum TopToBannerBottom;
    public static final RelativeEnum TopToBannerTop;

    private static final /* synthetic */ RelativeEnum[] $values() {
        return new RelativeEnum[]{BottomToBannerBottom, TopToBannerBottom, StartToParentLeft, EndToParentEnd, TopToBannerTop, BannerCenter};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BottomToBannerBottom = new RelativeEnum("BottomToBannerBottom", 0);
        TopToBannerBottom = new RelativeEnum("TopToBannerBottom", 1);
        StartToParentLeft = new RelativeEnum("StartToParentLeft", 2);
        EndToParentEnd = new RelativeEnum("EndToParentEnd", 3);
        TopToBannerTop = new RelativeEnum("TopToBannerTop", 4);
        BannerCenter = new RelativeEnum("BannerCenter", 5);
        $VALUES = $values();
    }

    RelativeEnum(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static RelativeEnum valueOf(String str) {
        return (RelativeEnum) Enum.valueOf(RelativeEnum.class, str);
    }

    public static RelativeEnum[] values() {
        return (RelativeEnum[]) $VALUES.clone();
    }
}

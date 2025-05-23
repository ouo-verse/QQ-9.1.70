package com.tencent.qqnt.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/avatar/AvatarSizeType;", "", "width", "", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "getWidth", "SMALL", "BIG", "avatar_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AvatarSizeType {
    private static final /* synthetic */ AvatarSizeType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AvatarSizeType BIG;
    public static final AvatarSizeType SMALL;
    private final int height;
    private final int width;

    private static final /* synthetic */ AvatarSizeType[] $values() {
        return new AvatarSizeType[]{SMALL, BIG};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        SMALL = new AvatarSizeType("SMALL", 0, 100, 100);
        BIG = new AvatarSizeType("BIG", 1, 640, 640);
        $VALUES = $values();
    }

    AvatarSizeType(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.width = i16;
            this.height = i17;
        }
    }

    public static AvatarSizeType valueOf(String str) {
        return (AvatarSizeType) Enum.valueOf(AvatarSizeType.class, str);
    }

    public static AvatarSizeType[] values() {
        return (AvatarSizeType[]) $VALUES.clone();
    }

    public final int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.height;
    }

    public final int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.width;
    }
}

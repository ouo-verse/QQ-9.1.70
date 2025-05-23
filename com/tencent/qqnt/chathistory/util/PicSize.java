package com.tencent.qqnt.chathistory.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chathistory/util/PicSize;", "", "(Ljava/lang/String;I)V", "PIC_DOWNLOAD_THUMB", "PIC_DOWNLOAD_ORI", "PIC_DOWNLOAD_AIO", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PicSize {
    private static final /* synthetic */ PicSize[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PicSize PIC_DOWNLOAD_AIO;
    public static final PicSize PIC_DOWNLOAD_ORI;
    public static final PicSize PIC_DOWNLOAD_THUMB;

    private static final /* synthetic */ PicSize[] $values() {
        return new PicSize[]{PIC_DOWNLOAD_THUMB, PIC_DOWNLOAD_ORI, PIC_DOWNLOAD_AIO};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PIC_DOWNLOAD_THUMB = new PicSize("PIC_DOWNLOAD_THUMB", 0);
        PIC_DOWNLOAD_ORI = new PicSize("PIC_DOWNLOAD_ORI", 1);
        PIC_DOWNLOAD_AIO = new PicSize("PIC_DOWNLOAD_AIO", 2);
        $VALUES = $values();
    }

    PicSize(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static PicSize valueOf(String str) {
        return (PicSize) Enum.valueOf(PicSize.class, str);
    }

    public static PicSize[] values() {
        return (PicSize[]) $VALUES.clone();
    }
}

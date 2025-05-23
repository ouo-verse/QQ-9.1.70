package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/adapter/mvp/StickerRecKeywordFrom;", "", "(Ljava/lang/String;I)V", "INPUT", "LITE_ACTION", "QZONE", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class StickerRecKeywordFrom {
    private static final /* synthetic */ StickerRecKeywordFrom[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final StickerRecKeywordFrom INPUT;
    public static final StickerRecKeywordFrom LITE_ACTION;
    public static final StickerRecKeywordFrom QZONE;

    private static final /* synthetic */ StickerRecKeywordFrom[] $values() {
        return new StickerRecKeywordFrom[]{INPUT, LITE_ACTION, QZONE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38889);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INPUT = new StickerRecKeywordFrom("INPUT", 0);
        LITE_ACTION = new StickerRecKeywordFrom("LITE_ACTION", 1);
        QZONE = new StickerRecKeywordFrom("QZONE", 2);
        $VALUES = $values();
    }

    StickerRecKeywordFrom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static StickerRecKeywordFrom valueOf(String str) {
        return (StickerRecKeywordFrom) Enum.valueOf(StickerRecKeywordFrom.class, str);
    }

    public static StickerRecKeywordFrom[] values() {
        return (StickerRecKeywordFrom[]) $VALUES.clone();
    }
}

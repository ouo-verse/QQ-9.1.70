package com.tencent.qqnt.audio.tts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "", "(Ljava/lang/String;I)V", "TYPE_TEXT", "TYPE_AUTO_TTS", "TYPE_NONE", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class TtsPlayType {
    private static final /* synthetic */ TtsPlayType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TtsPlayType TYPE_AUTO_TTS;
    public static final TtsPlayType TYPE_NONE;
    public static final TtsPlayType TYPE_TEXT;

    private static final /* synthetic */ TtsPlayType[] $values() {
        return new TtsPlayType[]{TYPE_TEXT, TYPE_AUTO_TTS, TYPE_NONE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TYPE_TEXT = new TtsPlayType("TYPE_TEXT", 0);
        TYPE_AUTO_TTS = new TtsPlayType("TYPE_AUTO_TTS", 1);
        TYPE_NONE = new TtsPlayType("TYPE_NONE", 2);
        $VALUES = $values();
    }

    TtsPlayType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TtsPlayType valueOf(String str) {
        return (TtsPlayType) Enum.valueOf(TtsPlayType.class, str);
    }

    public static TtsPlayType[] values() {
        return (TtsPlayType[]) $VALUES.clone();
    }
}

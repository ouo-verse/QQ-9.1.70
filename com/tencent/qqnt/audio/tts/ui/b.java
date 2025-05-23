package com.tencent.qqnt.audio.tts.ui;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020 \u00a2\u0006\u0004\b&\u0010'J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0006\u0010\rR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010!\u001a\u0004\b\u0018\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/b;", "", "", "j", "toString", "", "a", "J", "c", "()J", "sessionId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "e", "toUin", "d", "text", "", "Z", tl.h.F, "()Z", "isAutoTrigger", "f", "i", "isWelcomeMsg", "g", "msgBytes", "setVoiceType", "(Ljava/lang/String;)V", "voiceType", "Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "()Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "setTtsPlayType", "(Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;)V", "ttsPlayType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;)V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String senderUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String toUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isAutoTrigger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isWelcomeMsg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String msgBytes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String voiceType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TtsPlayType ttsPlayType;

    public b(long j3, @NotNull String senderUin, @NotNull String toUin, @NotNull String text, boolean z16, boolean z17, @Nullable String str, @Nullable String str2, @NotNull TtsPlayType ttsPlayType) {
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ttsPlayType, "ttsPlayType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), senderUin, toUin, text, Boolean.valueOf(z16), Boolean.valueOf(z17), str, str2, ttsPlayType);
            return;
        }
        this.sessionId = j3;
        this.senderUin = senderUin;
        this.toUin = toUin;
        this.text = text;
        this.isAutoTrigger = z16;
        this.isWelcomeMsg = z17;
        this.msgBytes = str;
        this.voiceType = str2;
        this.ttsPlayType = ttsPlayType;
    }

    private final String j(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "(empty)";
        }
        return str.charAt(0) + "|" + str.length() + "}";
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.msgBytes;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.senderUin;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.sessionId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.text;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.toUin;
    }

    @NotNull
    public final TtsPlayType f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TtsPlayType) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.ttsPlayType;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.voiceType;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isAutoTrigger;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isWelcomeMsg;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "TtsPlayData(textToRead=" + j(this.text) + ", senderUin=" + this.senderUin + ", toUin=" + this.toUin + ", voiceType=" + this.voiceType + ")";
    }

    public /* synthetic */ b(long j3, String str, String str2, String str3, boolean z16, boolean z17, String str4, String str5, TtsPlayType ttsPlayType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, str2, str3, z16, z17, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? TtsPlayType.TYPE_NONE : ttsPlayType);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), str4, str5, ttsPlayType, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

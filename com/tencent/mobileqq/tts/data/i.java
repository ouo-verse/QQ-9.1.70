package com.tencent.mobileqq.tts.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.audio.tts.ui.TtsPlayType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u001d\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0018\u0010\"R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b \u0010\u001e\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/tts/data/i;", "", "", "toString", "", "a", "J", "d", "()J", "sessionId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "e", "j", "(Ljava/lang/String;)V", "text", "msgBytes", "", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "modelType", "f", "g", "voiceType", "", "Z", "isAutoTrigger", "()Z", "Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", tl.h.F, "Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "()Lcom/tencent/qqnt/audio/tts/ui/TtsPlayType;", "ttsPlayType", "i", "(Z)V", "isHitCache", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLcom/tencent/qqnt/audio/tts/ui/TtsPlayType;Z)V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String senderUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String msgBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer modelType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String voiceType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isAutoTrigger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TtsPlayType ttsPlayType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHitCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public i(long j3, @NotNull String senderUin, @NotNull String text, @Nullable String str, @Nullable Integer num, @Nullable String str2, boolean z16, @NotNull TtsPlayType ttsPlayType) {
        this(j3, senderUin, text, str, num, str2, z16, ttsPlayType, false, 256, null);
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ttsPlayType, "ttsPlayType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), senderUin, text, str, num, str2, Boolean.valueOf(z16), ttsPlayType);
    }

    @Nullable
    public final Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Integer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.modelType;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msgBytes;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.senderUin;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.sessionId;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.text;
    }

    @NotNull
    public final TtsPlayType f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TtsPlayType) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.ttsPlayType;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.voiceType;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isHitCache;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isHitCache = z16;
        }
    }

    public final void j(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }

    @NotNull
    public String toString() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sessionId = " + this.sessionId);
        sb5.append(" senderUin = " + this.senderUin);
        sb5.append(" textLength = " + this.text.length());
        if (this.msgBytes != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(" msgBytes = " + z16);
        sb5.append(" voiceType = " + this.voiceType);
        sb5.append(" ttsPlayType = " + this.ttsPlayType);
        sb5.append(" modelType = " + this.modelType);
        sb5.append(" isAutoTrigger = " + this.isAutoTrigger);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder()\n        \u2026)\n            .toString()");
        return sb6;
    }

    @JvmOverloads
    public i(long j3, @NotNull String senderUin, @NotNull String text, @Nullable String str, @Nullable Integer num, @Nullable String str2, boolean z16, @NotNull TtsPlayType ttsPlayType, boolean z17) {
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ttsPlayType, "ttsPlayType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), senderUin, text, str, num, str2, Boolean.valueOf(z16), ttsPlayType, Boolean.valueOf(z17));
            return;
        }
        this.sessionId = j3;
        this.senderUin = senderUin;
        this.text = text;
        this.msgBytes = str;
        this.modelType = num;
        this.voiceType = str2;
        this.isAutoTrigger = z16;
        this.ttsPlayType = ttsPlayType;
        this.isHitCache = z17;
    }

    public /* synthetic */ i(long j3, String str, String str2, String str3, Integer num, String str4, boolean z16, TtsPlayType ttsPlayType, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, str2, str3, num, str4, z16, (i3 & 128) != 0 ? TtsPlayType.TYPE_TEXT : ttsPlayType, (i3 & 256) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, num, str4, Boolean.valueOf(z16), ttsPlayType, Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

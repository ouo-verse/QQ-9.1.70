package com.tencent.mobileqq.tts.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0002\t\nB\u0007\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0005R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00060\u001cj\u0002`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/tts/stream/c;", "", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "end", "", "c", "", "text", "a", "b", "", "I", "getMinSegmentCount", "()I", "setMinSegmentCount", "(I)V", "minSegmentCount", "getMaxSegmentCount", "setMaxSegmentCount", "maxSegmentCount", "Lcom/tencent/mobileqq/tts/stream/c$b;", "Lcom/tencent/mobileqq/tts/stream/c$b;", "getOnOutputTextSegment", "()Lcom/tencent/mobileqq/tts/stream/c$b;", "e", "(Lcom/tencent/mobileqq/tts/stream/c$b;)V", "onOutputTextSegment", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "Ljava/lang/StringBuilder;", "outputText", "Z", "parseLetterOrDigit", "<init>", "()V", "f", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int minSegmentCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int maxSegmentCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b onOutputTextSegment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private StringBuilder outputText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean parseLetterOrDigit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tts/stream/c$a;", "", "", "MAX_SEGMENT_COUNT", "I", "MIN_SEGMENT_COUNT", "", "PUNCTUATION", "Ljava/lang/String;", "SEPARATOR", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tts.stream.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tts/stream/c$b;", "", "", "text", "", "isEnd", "", "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface b {
        void a(@NotNull String text, boolean isEnd);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.minSegmentCount = 30;
        this.maxSegmentCount = 100;
        this.outputText = new StringBuilder();
    }

    private final void c(boolean force, boolean end) {
        boolean z16;
        b bVar;
        if (this.outputText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (end && (bVar = this.onOutputTextSegment) != null) {
                bVar.a("", true);
                return;
            }
            return;
        }
        if (force || this.outputText.length() > this.minSegmentCount) {
            b bVar2 = this.onOutputTextSegment;
            if (bVar2 != null) {
                String sb5 = this.outputText.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "outputText.toString()");
                bVar2.a(sb5, end);
            }
            StringsKt__StringBuilderJVMKt.clear(this.outputText);
        }
    }

    static /* synthetic */ void d(c cVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        cVar.c(z16, z17);
    }

    public final void a(@NotNull String text) {
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = text.charAt(i3);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) "\uff0c\u3002\uff01\uff1f\uff1b\uff1a,.!?;:", charAt, false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) "\u3000 \n\t", charAt, false, 2, (Object) null);
                if (!contains$default2) {
                    if (Character.isLetterOrDigit(charAt) ^ this.parseLetterOrDigit) {
                        d(this, false, false, 3, null);
                    }
                    this.parseLetterOrDigit = Character.isLetterOrDigit(charAt);
                    this.outputText.append(charAt);
                    if (!this.parseLetterOrDigit && this.outputText.length() > this.maxSegmentCount) {
                        d(this, true, false, 2, null);
                    }
                }
            }
            this.outputText.append(charAt);
            d(this, false, false, 3, null);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            c(true, true);
        }
    }

    public final void e(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.onOutputTextSegment = bVar;
        }
    }
}

package com.tencent.android.androidbypass;

import com.tencent.bypass.nativeinterface.IBypassSoEngine;
import com.tencent.bypass.nativeinterface.IGlobalAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/android/androidbypass/BypassSoEngine;", "", "()V", "TAG", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/bypass/nativeinterface/IBypassSoEngine;", "getEngine", "()Lcom/tencent/bypass/nativeinterface/IBypassSoEngine;", "processMarkdownV2", "Lcom/tencent/bypass/nativeinterface/Document;", "markdown", "enableParseCodeBlock", "", "parseCodeBlockLine", "", "start", "", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class BypassSoEngine {
    static IPatchRedirector $redirector_ = null;
    public static final BypassSoEngine INSTANCE;
    private static final String TAG = "BypassSoEngine";

    @Nullable
    private static final IBypassSoEngine engine;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "level", "", "msg", "", "onLog"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    static final class a implements IGlobalAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f71938a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11481);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f71938a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.bypass.nativeinterface.IGlobalAdapter
        public final void onLog(int i3, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                com.tencent.android.androidbypass.config.a.f72049a.onLog(i3, BypassSoEngine.TAG, msg2);
            }
        }
    }

    static {
        Object m476constructorimpl;
        String stackTraceToString;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new BypassSoEngine();
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            IBypassSoEngine a16 = com.tencent.bypass.nativeinterface.a.a();
            if (a16 != null) {
                a16.startEngine(a.f71938a);
            } else {
                a16 = null;
            }
            m476constructorimpl = Result.m476constructorimpl(a16);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl == null) {
            obj = m476constructorimpl;
        } else {
            com.tencent.android.androidbypass.config.g gVar = com.tencent.android.androidbypass.config.a.f72049a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startEngine error: ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            sb5.append(stackTraceToString);
            gVar.e(TAG, sb5.toString());
        }
        engine = (IBypassSoEngine) obj;
    }

    BypassSoEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Nullable
    public final IBypassSoEngine getEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IBypassSoEngine) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return engine;
    }

    @Nullable
    public final com.tencent.bypass.nativeinterface.Document processMarkdownV2(@NotNull String markdown, boolean enableParseCodeBlock, int parseCodeBlockLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.bypass.nativeinterface.Document) iPatchRedirector.redirect((short) 3, this, markdown, Boolean.valueOf(enableParseCodeBlock), Integer.valueOf(parseCodeBlockLine));
        }
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        IBypassSoEngine iBypassSoEngine = engine;
        if (iBypassSoEngine != null) {
            return iBypassSoEngine.processMarkdown(markdown, enableParseCodeBlock, parseCodeBlockLine);
        }
        return null;
    }

    public final void start() {
        Object m476constructorimpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.android.androidbypass.config.g gVar = com.tencent.android.androidbypass.config.a.f72049a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initialize: ");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(engine);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        sb5.append(Result.m484toStringimpl(m476constructorimpl));
        sb5.append("\n  ");
        sb5.append("ANDROID_BYPASS_COMMIT_ID:38b89019\n ");
        sb5.append("BYPASS_CPP_COMMIT_ID:e9e92b89");
        gVar.e(TAG, sb5.toString());
    }
}

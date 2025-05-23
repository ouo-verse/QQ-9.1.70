package com.tencent.android.androidbypass.codeblock.entry;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.android.androidbypass.codeblock.config.c;
import com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan;
import com.tencent.android.androidbypass.codeblock.span.b;
import com.tencent.android.androidbypass.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/entry/CodeBlockProcessEntry;", "", "", "a", "Landroid/widget/TextView;", "textView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/android/androidbypass/codeblock/span/b;", "parseResult", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "codeBlockConfig", "Landroid/text/SpannableStringBuilder;", "b", "", "J", "CODE_BLOCK_INDEX", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockProcessEntry {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static long CODE_BLOCK_INDEX;

    /* renamed from: b, reason: collision with root package name */
    public static final CodeBlockProcessEntry f71977b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f71977b = new CodeBlockProcessEntry();
        }
    }

    CodeBlockProcessEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private final String a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qq_code_block_text");
        long j3 = CODE_BLOCK_INDEX + 1;
        CODE_BLOCK_INDEX = j3;
        sb5.append(j3);
        return sb5.toString();
    }

    @NotNull
    public final SpannableStringBuilder b(@NotNull TextView textView, @NotNull LifecycleOwner lifecycleOwner, @NotNull b parseResult, @NotNull c codeBlockConfig) {
        String joinToString$default;
        String replace$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 1, this, textView, lifecycleOwner, parseResult, codeBlockConfig);
        }
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(parseResult, "parseResult");
        Intrinsics.checkNotNullParameter(codeBlockConfig, "codeBlockConfig");
        String a16 = a();
        if (!parseResult.e()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(parseResult.a(), "", null, null, 0, null, CodeBlockProcessEntry$processCodeBlock$spanText$1.INSTANCE, 30, null);
        } else {
            joinToString$default = parseResult.c().toString();
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(joinToString$default, "\n", " ", false, 4, (Object) null);
        CodeBlockSpan codeBlockSpan = new CodeBlockSpan(new com.tencent.android.androidbypass.codeblock.span.c(a16, new WeakReference(textView), new WeakReference(lifecycleOwner), parseResult, codeBlockConfig, replace$default));
        g gVar = new g();
        gVar.append((CharSequence) replace$default);
        gVar.setSpan(codeBlockSpan, 0, gVar.length(), 17);
        return gVar;
    }
}

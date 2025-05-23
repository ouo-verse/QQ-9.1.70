package com.tencent.android.androidbypass.codeblock.span;

import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\t\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u0019\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getCodeBlockId", "()Ljava/lang/String;", "codeBlockId", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "b", "Ljava/lang/ref/WeakReference;", "e", "()Ljava/lang/ref/WeakReference;", "tvRef", "Landroidx/lifecycle/LifecycleOwner;", "c", "lifecycleOwnerRef", "Lcom/tencent/android/androidbypass/codeblock/span/b;", "d", "Lcom/tencent/android/androidbypass/codeblock/span/b;", "()Lcom/tencent/android/androidbypass/codeblock/span/b;", "parseResult", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "()Lcom/tencent/android/androidbypass/codeblock/config/c;", "codeBlockConfig", "f", "spanText", "<init>", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Lcom/tencent/android/androidbypass/codeblock/span/b;Lcom/tencent/android/androidbypass/codeblock/config/c;Ljava/lang/String;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String codeBlockId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<TextView> tvRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<LifecycleOwner> lifecycleOwnerRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b parseResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.codeblock.config.c codeBlockConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String spanText;

    public c(@NotNull String codeBlockId, @NotNull WeakReference<TextView> tvRef, @NotNull WeakReference<LifecycleOwner> lifecycleOwnerRef, @NotNull b parseResult, @NotNull com.tencent.android.androidbypass.codeblock.config.c codeBlockConfig, @NotNull String spanText) {
        Intrinsics.checkNotNullParameter(codeBlockId, "codeBlockId");
        Intrinsics.checkNotNullParameter(tvRef, "tvRef");
        Intrinsics.checkNotNullParameter(lifecycleOwnerRef, "lifecycleOwnerRef");
        Intrinsics.checkNotNullParameter(parseResult, "parseResult");
        Intrinsics.checkNotNullParameter(codeBlockConfig, "codeBlockConfig");
        Intrinsics.checkNotNullParameter(spanText, "spanText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, codeBlockId, tvRef, lifecycleOwnerRef, parseResult, codeBlockConfig, spanText);
            return;
        }
        this.codeBlockId = codeBlockId;
        this.tvRef = tvRef;
        this.lifecycleOwnerRef = lifecycleOwnerRef;
        this.parseResult = parseResult;
        this.codeBlockConfig = codeBlockConfig;
        this.spanText = spanText;
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.config.c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.android.androidbypass.codeblock.config.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.codeBlockConfig;
    }

    @NotNull
    public final WeakReference<LifecycleOwner> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.lifecycleOwnerRef;
    }

    @NotNull
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.parseResult;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.spanText;
    }

    @NotNull
    public final WeakReference<TextView> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tvRef;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof c) {
                c cVar = (c) other;
                if (!Intrinsics.areEqual(this.codeBlockId, cVar.codeBlockId) || !Intrinsics.areEqual(this.tvRef, cVar.tvRef) || !Intrinsics.areEqual(this.lifecycleOwnerRef, cVar.lifecycleOwnerRef) || !Intrinsics.areEqual(this.parseResult, cVar.parseResult) || !Intrinsics.areEqual(this.codeBlockConfig, cVar.codeBlockConfig) || !Intrinsics.areEqual(this.spanText, cVar.spanText)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        String str = this.codeBlockId;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        WeakReference<TextView> weakReference = this.tvRef;
        if (weakReference != null) {
            i16 = weakReference.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        WeakReference<LifecycleOwner> weakReference2 = this.lifecycleOwnerRef;
        if (weakReference2 != null) {
            i17 = weakReference2.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        b bVar = this.parseResult;
        if (bVar != null) {
            i18 = bVar.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        com.tencent.android.androidbypass.codeblock.config.c cVar = this.codeBlockConfig;
        if (cVar != null) {
            i19 = cVar.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        String str2 = this.spanText;
        if (str2 != null) {
            i26 = str2.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "CodeBlockSpanInfo(codeBlockId=" + this.codeBlockId + ", tvRef=" + this.tvRef + ", lifecycleOwnerRef=" + this.lifecycleOwnerRef + ", parseResult=" + this.parseResult + ", codeBlockConfig=" + this.codeBlockConfig + ", spanText=" + this.spanText + ")";
    }
}

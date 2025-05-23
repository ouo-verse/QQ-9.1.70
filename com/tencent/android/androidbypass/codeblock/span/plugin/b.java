package com.tencent.android.androidbypass.codeblock.span.plugin;

import android.content.Context;
import com.tencent.android.androidbypass.codeblock.config.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u0015\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/codeblock/span/b;", "Lcom/tencent/android/androidbypass/codeblock/span/b;", "d", "()Lcom/tencent/android/androidbypass/codeblock/span/b;", "parseResult", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "c", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "()Lcom/tencent/android/androidbypass/codeblock/config/c;", "codeBlockConfig", "Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "()Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "eventDelegate", "<init>", "(Landroid/content/Context;Lcom/tencent/android/androidbypass/codeblock/span/b;Lcom/tencent/android/androidbypass/codeblock/config/c;Lcom/tencent/android/androidbypass/codeblock/span/event/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.codeblock.span.b parseResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c codeBlockConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.codeblock.span.event.b eventDelegate;

    public b(@NotNull Context context, @NotNull com.tencent.android.androidbypass.codeblock.span.b parseResult, @NotNull c codeBlockConfig, @NotNull com.tencent.android.androidbypass.codeblock.span.event.b eventDelegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parseResult, "parseResult");
        Intrinsics.checkNotNullParameter(codeBlockConfig, "codeBlockConfig");
        Intrinsics.checkNotNullParameter(eventDelegate, "eventDelegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, parseResult, codeBlockConfig, eventDelegate);
            return;
        }
        this.context = context;
        this.parseResult = parseResult;
        this.codeBlockConfig = codeBlockConfig;
        this.eventDelegate = eventDelegate;
    }

    @NotNull
    public final c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.codeBlockConfig;
    }

    @NotNull
    public final Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Context) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.span.event.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.android.androidbypass.codeblock.span.event.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.eventDelegate;
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.span.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.android.androidbypass.codeblock.span.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.parseResult;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof b) {
                b bVar = (b) other;
                if (!Intrinsics.areEqual(this.context, bVar.context) || !Intrinsics.areEqual(this.parseResult, bVar.parseResult) || !Intrinsics.areEqual(this.codeBlockConfig, bVar.codeBlockConfig) || !Intrinsics.areEqual(this.eventDelegate, bVar.eventDelegate)) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        Context context = this.context;
        int i18 = 0;
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        com.tencent.android.androidbypass.codeblock.span.b bVar = this.parseResult;
        if (bVar != null) {
            i16 = bVar.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        c cVar = this.codeBlockConfig;
        if (cVar != null) {
            i17 = cVar.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        com.tencent.android.androidbypass.codeblock.span.event.b bVar2 = this.eventDelegate;
        if (bVar2 != null) {
            i18 = bVar2.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "PluginContext(context=" + this.context + ", parseResult=" + this.parseResult + ", codeBlockConfig=" + this.codeBlockConfig + ", eventDelegate=" + this.eventDelegate + ")";
    }
}

package com.tencent.aio.widget.textView.cache;

import android.text.StaticLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/widget/textView/cache/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/text/StaticLayout;", "a", "Landroid/text/StaticLayout;", "b", "()Landroid/text/StaticLayout;", "staticLayout", "", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "source", "<init>", "(Landroid/text/StaticLayout;Ljava/lang/CharSequence;)V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final StaticLayout staticLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final CharSequence source;

    public a(@Nullable StaticLayout staticLayout, @Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) staticLayout, (Object) charSequence);
        } else {
            this.staticLayout = staticLayout;
            this.source = charSequence;
        }
    }

    @Nullable
    public final CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.source;
    }

    @Nullable
    public final StaticLayout b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (StaticLayout) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.staticLayout;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.staticLayout, aVar.staticLayout) || !Intrinsics.areEqual(this.source, aVar.source)) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        StaticLayout staticLayout = this.staticLayout;
        int i16 = 0;
        if (staticLayout != null) {
            i3 = staticLayout.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        CharSequence charSequence = this.source;
        if (charSequence != null) {
            i16 = charSequence.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "CacheResult(staticLayout=" + this.staticLayout + ", source=" + this.source + ")";
    }
}

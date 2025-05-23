package com.tencent.android.androidbypass.codeblock.span;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "lineText", "", "Lcom/tencent/android/androidbypass/codeblock/span/e;", "Ljava/util/List;", "()Ljava/util/List;", "highlightNodeList", "<init>", "(Ljava/lang/CharSequence;Ljava/util/List;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence lineText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> highlightNodeList;

    public d(@NotNull CharSequence lineText, @NotNull List<e> highlightNodeList) {
        Intrinsics.checkNotNullParameter(lineText, "lineText");
        Intrinsics.checkNotNullParameter(highlightNodeList, "highlightNodeList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lineText, (Object) highlightNodeList);
        } else {
            this.lineText = lineText;
            this.highlightNodeList = highlightNodeList;
        }
    }

    @NotNull
    public final List<e> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.highlightNodeList;
    }

    @NotNull
    public final CharSequence b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.lineText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (!Intrinsics.areEqual(this.lineText, dVar.lineText) || !Intrinsics.areEqual(this.highlightNodeList, dVar.highlightNodeList)) {
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
        CharSequence charSequence = this.lineText;
        int i16 = 0;
        if (charSequence != null) {
            i3 = charSequence.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        List<e> list = this.highlightNodeList;
        if (list != null) {
            i16 = list.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "HighlightLine(lineText=" + this.lineText + ", highlightNodeList=" + this.highlightNodeList + ")";
    }
}

package com.tencent.android.androidbypass.codeblock.span;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "lineText", "b", "I", "()I", "beginNodeIndex", "beginNodeInternalIndex", "d", "getEndNodeIndex", "endNodeIndex", "e", "getEndNodeInternalIndex", "endNodeInternalIndex", "<init>", "(Ljava/lang/CharSequence;IIII)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence lineText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int beginNodeIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int beginNodeInternalIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int endNodeIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int endNodeInternalIndex;

    public a(@NotNull CharSequence lineText, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(lineText, "lineText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, lineText, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.lineText = lineText;
        this.beginNodeIndex = i3;
        this.beginNodeInternalIndex = i16;
        this.endNodeIndex = i17;
        this.endNodeInternalIndex = i18;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.beginNodeIndex;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.beginNodeInternalIndex;
    }

    @NotNull
    public final CharSequence c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (CharSequence) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.lineText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.lineText, aVar.lineText) || this.beginNodeIndex != aVar.beginNodeIndex || this.beginNodeInternalIndex != aVar.beginNodeInternalIndex || this.endNodeIndex != aVar.endNodeIndex || this.endNodeInternalIndex != aVar.endNodeInternalIndex) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        CharSequence charSequence = this.lineText;
        if (charSequence != null) {
            i3 = charSequence.hashCode();
        } else {
            i3 = 0;
        }
        return (((((((i3 * 31) + this.beginNodeIndex) * 31) + this.beginNodeInternalIndex) * 31) + this.endNodeIndex) * 31) + this.endNodeInternalIndex;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "BreakTextLine(lineText=" + this.lineText + ", beginNodeIndex=" + this.beginNodeIndex + ", beginNodeInternalIndex=" + this.beginNodeInternalIndex + ", endNodeIndex=" + this.endNodeIndex + ", endNodeInternalIndex=" + this.endNodeInternalIndex + ")";
    }
}

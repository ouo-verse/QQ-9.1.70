package com.tencent.android.androidbypass.codeblock.span;

import com.tencent.bypass.nativeinterface.CodeNode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0013\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/bypass/nativeinterface/CodeNode;", "a", "Ljava/util/List;", "()Ljava/util/List;", "codeNodeList", "b", "Ljava/lang/String;", "()Ljava/lang/String;", IjkMediaMeta.IJKM_KEY_LANGUAGE, "c", "Z", "e", "()Z", "isParseAllCode", "", "d", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "originText", "isEndElement", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/CharSequence;Z)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<CodeNode> codeNodeList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String language;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isParseAllCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence originText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isEndElement;

    public b(@NotNull List<CodeNode> codeNodeList, @NotNull String language, boolean z16, @NotNull CharSequence originText, boolean z17) {
        Intrinsics.checkNotNullParameter(codeNodeList, "codeNodeList");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(originText, "originText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, codeNodeList, language, Boolean.valueOf(z16), originText, Boolean.valueOf(z17));
            return;
        }
        this.codeNodeList = codeNodeList;
        this.language = language;
        this.isParseAllCode = z16;
        this.originText = originText;
        this.isEndElement = z17;
    }

    @NotNull
    public final List<CodeNode> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.codeNodeList;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.language;
    }

    @NotNull
    public final CharSequence c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.originText;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isEndElement;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isParseAllCode;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof b) {
                b bVar = (b) other;
                if (!Intrinsics.areEqual(this.codeNodeList, bVar.codeNodeList) || !Intrinsics.areEqual(this.language, bVar.language) || this.isParseAllCode != bVar.isParseAllCode || !Intrinsics.areEqual(this.originText, bVar.originText) || this.isEndElement != bVar.isEndElement) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        List<CodeNode> list = this.codeNodeList;
        int i17 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str = this.language;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        boolean z16 = this.isParseAllCode;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (i19 + i27) * 31;
        CharSequence charSequence = this.originText;
        if (charSequence != null) {
            i17 = charSequence.hashCode();
        }
        int i29 = (i28 + i17) * 31;
        boolean z17 = this.isEndElement;
        if (!z17) {
            i26 = z17 ? 1 : 0;
        }
        return i29 + i26;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "CodeBlockParseResult(codeNodeList=" + this.codeNodeList + ", language=" + this.language + ", isParseAllCode=" + this.isParseAllCode + ", originText=" + this.originText + ", isEndElement=" + this.isEndElement + ")";
    }
}

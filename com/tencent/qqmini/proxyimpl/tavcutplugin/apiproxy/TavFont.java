package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "fontFamily", "b", "c", "fontStyle", "fontPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.k, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class TavFont {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fontFamily;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fontStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fontPath;

    public TavFont(String fontFamily, String fontStyle, String fontPath) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
        Intrinsics.checkNotNullParameter(fontPath, "fontPath");
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontPath = fontPath;
    }

    /* renamed from: a, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: b, reason: from getter */
    public final String getFontPath() {
        return this.fontPath;
    }

    /* renamed from: c, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    public int hashCode() {
        return (((this.fontFamily.hashCode() * 31) + this.fontStyle.hashCode()) * 31) + this.fontPath.hashCode();
    }

    public String toString() {
        return "TavFont(fontFamily=" + this.fontFamily + ", fontStyle=" + this.fontStyle + ", fontPath=" + this.fontPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TavFont)) {
            return false;
        }
        TavFont tavFont = (TavFont) other;
        return Intrinsics.areEqual(this.fontFamily, tavFont.fontFamily) && Intrinsics.areEqual(this.fontStyle, tavFont.fontStyle) && Intrinsics.areEqual(this.fontPath, tavFont.fontPath);
    }
}

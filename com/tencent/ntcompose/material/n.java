package com.tencent.ntcompose.material;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ntcompose/material/n;", "", "other", "", "equals", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "fontName", "<init>", "(Ljava/lang/String;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final int f339436b = 0;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String fontName;

    public n(String fontName) {
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        this.fontName = fontName;
    }

    /* renamed from: a, reason: from getter */
    public final String getFontName() {
        return this.fontName;
    }

    public boolean equals(Object other) {
        return (other instanceof n) && Intrinsics.areEqual(this.fontName, ((n) other).fontName);
    }
}

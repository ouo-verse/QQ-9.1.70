package com.tencent.biz.qui.quitagview;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qui/quitagview/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "resIs", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "iconUrl", "Z", "()Z", "setNeedTint", "(Z)V", "needTint", "<init>", "(ILjava/lang/String;Z)V", "QUITagView_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.biz.qui.quitagview.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class QUITagIcon {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resIs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String iconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needTint;

    public QUITagIcon() {
        this(0, null, false, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedTint() {
        return this.needTint;
    }

    /* renamed from: c, reason: from getter */
    public final int getResIs() {
        return this.resIs;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof QUITagIcon) {
                QUITagIcon qUITagIcon = (QUITagIcon) other;
                if (this.resIs != qUITagIcon.resIs || !Intrinsics.areEqual(this.iconUrl, qUITagIcon.iconUrl) || this.needTint != qUITagIcon.needTint) {
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
        int i16 = this.resIs * 31;
        String str = this.iconUrl;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.needTint;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    @NotNull
    public String toString() {
        return "QUITagIcon(resIs=" + this.resIs + ", iconUrl=" + this.iconUrl + ", needTint=" + this.needTint + ")";
    }

    public QUITagIcon(int i3, @Nullable String str, boolean z16) {
        this.resIs = i3;
        this.iconUrl = str;
        this.needTint = z16;
    }

    public /* synthetic */ QUITagIcon(int i3, String str, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? true : z16);
    }
}

package com.tencent.mobileqq.zplan.nameplate;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/net/Uri;", "a", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", "jumpTo", "Ljava/io/File;", "b", "Ljava/io/File;", "()Ljava/io/File;", "icon", "I", "()I", "id", "<init>", "(Landroid/net/Uri;Ljava/io/File;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.nameplate.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class Nameplate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Uri jumpTo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final File icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    public Nameplate(Uri uri, File icon, int i3) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.jumpTo = uri;
        this.icon = icon;
        this.id = i3;
    }

    /* renamed from: a, reason: from getter */
    public final File getIcon() {
        return this.icon;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final Uri getJumpTo() {
        return this.jumpTo;
    }

    public int hashCode() {
        Uri uri = this.jumpTo;
        return ((((uri == null ? 0 : uri.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.id;
    }

    public String toString() {
        return "Nameplate(jumpTo=" + this.jumpTo + ", icon=" + this.icon + ", id=" + this.id + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Nameplate)) {
            return false;
        }
        Nameplate nameplate = (Nameplate) other;
        return Intrinsics.areEqual(this.jumpTo, nameplate.jumpTo) && Intrinsics.areEqual(this.icon, nameplate.icon) && this.id == nameplate.id;
    }
}

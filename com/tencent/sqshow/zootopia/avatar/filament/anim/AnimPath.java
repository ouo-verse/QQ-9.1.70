package com.tencent.sqshow.zootopia.avatar.filament.anim;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "", "other", "", "c", "", "toString", "", "hashCode", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "head", "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.avatar.filament.anim.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class AnimPath {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String head;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String body;

    public AnimPath(String head, String body) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(body, "body");
        this.head = head;
        this.body = body;
    }

    /* renamed from: a, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: b, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    public int hashCode() {
        return (this.head.hashCode() * 31) + this.body.hashCode();
    }

    public String toString() {
        return "AnimPath(head=" + this.head + ", body=" + this.body + ")";
    }

    public final boolean c(AnimPath other) {
        return other != null && Intrinsics.areEqual(this.head, other.head) && Intrinsics.areEqual(this.body, other.body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimPath)) {
            return false;
        }
        AnimPath animPath = (AnimPath) other;
        return Intrinsics.areEqual(this.head, animPath.head) && Intrinsics.areEqual(this.body, animPath.body);
    }
}

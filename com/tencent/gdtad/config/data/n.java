package com.tencent.gdtad.config.data;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/gdtad/config/data/n;", "", "", "", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "adPosIdSet", "", "b", "I", "c", "()I", "jumpType", "", "Ljava/util/List;", "()Ljava/util/List;", "insideJumpOriginIds", "d", "outsideJumpOriginIds", "", "e", "Z", "()Z", "isGlobal", "<init>", "(Ljava/util/Set;ILjava/util/List;Ljava/util/List;Z)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> adPosIdSet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int jumpType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> insideJumpOriginIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> outsideJumpOriginIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isGlobal;

    public n(@NotNull Set<String> adPosIdSet, int i3, @NotNull List<String> insideJumpOriginIds, @NotNull List<String> outsideJumpOriginIds, boolean z16) {
        Intrinsics.checkNotNullParameter(adPosIdSet, "adPosIdSet");
        Intrinsics.checkNotNullParameter(insideJumpOriginIds, "insideJumpOriginIds");
        Intrinsics.checkNotNullParameter(outsideJumpOriginIds, "outsideJumpOriginIds");
        this.adPosIdSet = adPosIdSet;
        this.jumpType = i3;
        this.insideJumpOriginIds = insideJumpOriginIds;
        this.outsideJumpOriginIds = outsideJumpOriginIds;
        this.isGlobal = z16;
    }

    @NotNull
    public final Set<String> a() {
        return this.adPosIdSet;
    }

    @NotNull
    public final List<String> b() {
        return this.insideJumpOriginIds;
    }

    /* renamed from: c, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final List<String> d() {
        return this.outsideJumpOriginIds;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsGlobal() {
        return this.isGlobal;
    }
}

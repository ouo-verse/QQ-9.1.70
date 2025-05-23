package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes$ClipResType;", "a", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes$ClipResType;", "b", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes$ClipResType;", "type", "", "J", "()J", "durationInMillis", "<init>", "(Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes$ClipResType;J)V", "ClipResType", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class ClipRes {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ClipResType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long durationInMillis;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/ClipRes$ClipResType;", "", "(Ljava/lang/String;I)V", "VIDEO", "PHOTO", "UNKNOWN", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum ClipResType {
        VIDEO,
        PHOTO,
        UNKNOWN
    }

    public ClipRes(@NotNull ClipResType type, long j3) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.durationInMillis = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getDurationInMillis() {
        return this.durationInMillis;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ClipResType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClipRes)) {
            return false;
        }
        ClipRes clipRes = (ClipRes) other;
        if (this.type == clipRes.type && this.durationInMillis == clipRes.durationInMillis) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + androidx.fragment.app.a.a(this.durationInMillis);
    }

    @NotNull
    public String toString() {
        return "ClipRes(type=" + this.type + ", durationInMillis=" + this.durationInMillis + ")";
    }
}

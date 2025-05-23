package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/c;", "", "", "toString", "", "a", "J", "getLoop", "()J", "loop", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "b", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "getBeat", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "beat", "c", "getMusicDuration", "musicDuration", "<init>", "(JLcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long loop;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MusicTimePoint beat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long musicDuration;

    public c(long j3, @NotNull MusicTimePoint beat, long j16) {
        Intrinsics.checkNotNullParameter(beat, "beat");
        this.loop = j3;
        this.beat = beat;
        this.musicDuration = j16;
    }

    public final long a() {
        return (this.loop * this.musicDuration) + this.beat.getTimeInMillis();
    }

    @NotNull
    public String toString() {
        return "loop=" + this.loop + ", beat={type=" + this.beat.getType() + ", time=" + this.beat.getTimeInMillis() + "}";
    }
}

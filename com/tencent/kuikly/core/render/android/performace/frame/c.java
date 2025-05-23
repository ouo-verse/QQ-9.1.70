package com.tencent.kuikly.core.render.android.performace.frame;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u001d\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "", "", "c", "f", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "g", "()J", "l", "(J)V", "totalDuration", "b", "e", "k", "hitchesDuration", "i", "driveHitchesDuration", "d", "j", "frameCount", h.F, "driveFrameCount", "<init>", "(JJJJJ)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long totalDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long hitchesDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long driveHitchesDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long frameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long driveFrameCount;

    public c() {
        this(0L, 0L, 0L, 0L, 0L, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getDriveFrameCount() {
        return this.driveFrameCount;
    }

    /* renamed from: b, reason: from getter */
    public final long getDriveHitchesDuration() {
        return this.driveHitchesDuration;
    }

    public final float c() {
        long j3 = this.totalDuration;
        if (j3 > 0) {
            return (((float) (j3 - this.hitchesDuration)) / ((float) j3)) * 60;
        }
        return 0.0f;
    }

    /* renamed from: d, reason: from getter */
    public final long getFrameCount() {
        return this.frameCount;
    }

    /* renamed from: e, reason: from getter */
    public final long getHitchesDuration() {
        return this.hitchesDuration;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof c) {
                c cVar = (c) other;
                if (this.totalDuration != cVar.totalDuration || this.hitchesDuration != cVar.hitchesDuration || this.driveHitchesDuration != cVar.driveHitchesDuration || this.frameCount != cVar.frameCount || this.driveFrameCount != cVar.driveFrameCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final float f() {
        long j3 = this.totalDuration;
        if (j3 > 0) {
            return (((float) (j3 - this.driveHitchesDuration)) / ((float) j3)) * 60;
        }
        return 0.0f;
    }

    /* renamed from: g, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final void h(long j3) {
        this.driveFrameCount = j3;
    }

    public int hashCode() {
        long j3 = this.totalDuration;
        long j16 = this.hitchesDuration;
        int i3 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.driveHitchesDuration;
        int i16 = (i3 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.frameCount;
        int i17 = (i16 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.driveFrameCount;
        return i17 + ((int) ((j19 >>> 32) ^ j19));
    }

    public final void i(long j3) {
        this.driveHitchesDuration = j3;
    }

    public final void j(long j3) {
        this.frameCount = j3;
    }

    public final void k(long j3) {
        this.hitchesDuration = j3;
    }

    public final void l(long j3) {
        this.totalDuration = j3;
    }

    @NotNull
    public String toString() {
        return "[KRFrameMeta] \ntotalDuration: " + this.totalDuration + " \nhitchesDuration: " + this.hitchesDuration + " \ndriveHitchesDuration: " + this.driveHitchesDuration + " \nframeCount: " + this.frameCount + " \ndriveFrameCount: " + this.driveFrameCount + " \n";
    }

    public c(long j3, long j16, long j17, long j18, long j19) {
        this.totalDuration = j3;
        this.hitchesDuration = j16;
        this.driveHitchesDuration = j17;
        this.frameCount = j18;
        this.driveFrameCount = j19;
    }

    public /* synthetic */ c(long j3, long j16, long j17, long j18, long j19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0L : j18, (i3 & 16) == 0 ? j19 : 0L);
    }
}

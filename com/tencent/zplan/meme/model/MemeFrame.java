package com.tencent.zplan.meme.model;

import com.tencent.zplan.meme.action.MemeAction;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b!\u0010\"J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001a\u0010\u001eR\u0017\u0010 \u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/zplan/meme/model/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/zplan/meme/action/MemeAction;", "a", "Lcom/tencent/zplan/meme/action/MemeAction;", "()Lcom/tencent/zplan/meme/action/MemeAction;", "action", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "recordKey", "c", "I", "d", "()I", "index", "g", "width", "e", "height", "", "[B", "()[B", "pixels", "frameTime", "<init>", "(Lcom/tencent/zplan/meme/action/MemeAction;Ljava/lang/String;III[BI)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.meme.model.c, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class MemeFrame {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MemeAction action;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String recordKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final byte[] pixels;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameTime;

    public MemeFrame(@NotNull MemeAction action, @NotNull String recordKey, int i3, int i16, int i17, @NotNull byte[] pixels, int i18) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        this.action = action;
        this.recordKey = recordKey;
        this.index = i3;
        this.width = i16;
        this.height = i17;
        this.pixels = pixels;
        this.frameTime = i18;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final MemeAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final int getFrameTime() {
        return this.frameTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: d, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final byte[] getPixels() {
        return this.pixels;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MemeFrame.class, cls)) {
            return false;
        }
        if (other != null) {
            MemeFrame memeFrame = (MemeFrame) other;
            if (!(!Intrinsics.areEqual(this.action, memeFrame.action)) && !(!Intrinsics.areEqual(this.recordKey, memeFrame.recordKey)) && this.index == memeFrame.index && this.width == memeFrame.width && this.height == memeFrame.height && this.frameTime == memeFrame.frameTime) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.zplan.meme.model.MemeFrame");
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRecordKey() {
        return this.recordKey;
    }

    /* renamed from: g, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((this.action.hashCode() * 31) + this.recordKey.hashCode()) * 31) + this.index) * 31) + this.width) * 31) + this.height) * 31) + this.frameTime;
    }

    @NotNull
    public String toString() {
        return "MemeFrame(action=" + this.action + ", recordKey=" + this.recordKey + ", index=" + this.index + ", width=" + this.width + ", height=" + this.height + ", pixels=" + Arrays.toString(this.pixels) + ", frameTime=" + this.frameTime + ")";
    }
}

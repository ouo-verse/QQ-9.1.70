package com.tencent.mobileqq.wink.editor.draft;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u0000 92\u00020\u0001:\u0001:Ba\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b7\u00108J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003Jc\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/TrackStickerInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", HippyTKDListViewAdapter.X, "y", "w", h.F, "radian", "imageW", "imageH", "confidence", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, "getX", "()F", "setX", "(F)V", "getY", "setY", "getW", "setW", "getH", "setH", "getRadian", "setRadian", "getImageW", "setImageW", "getImageH", "setImageH", "getConfidence", "setConfidence", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "<init>", "(FFFFFFFFJ)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class TrackStickerInfo implements Serializable {
    private static final long serialVersionUID = 599093938747237761L;
    private float confidence;
    private float h;
    private float imageH;
    private float imageW;
    private float radian;
    private long timestamp;
    private float w;
    private float x;
    private float y;

    public TrackStickerInfo() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 511, null);
    }

    public static /* synthetic */ TrackStickerInfo copy$default(TrackStickerInfo trackStickerInfo, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, long j3, int i3, Object obj) {
        float f36;
        float f37;
        float f38;
        float f39;
        float f46;
        float f47;
        float f48;
        float f49;
        long j16;
        if ((i3 & 1) != 0) {
            f36 = trackStickerInfo.x;
        } else {
            f36 = f16;
        }
        if ((i3 & 2) != 0) {
            f37 = trackStickerInfo.y;
        } else {
            f37 = f17;
        }
        if ((i3 & 4) != 0) {
            f38 = trackStickerInfo.w;
        } else {
            f38 = f18;
        }
        if ((i3 & 8) != 0) {
            f39 = trackStickerInfo.h;
        } else {
            f39 = f19;
        }
        if ((i3 & 16) != 0) {
            f46 = trackStickerInfo.radian;
        } else {
            f46 = f26;
        }
        if ((i3 & 32) != 0) {
            f47 = trackStickerInfo.imageW;
        } else {
            f47 = f27;
        }
        if ((i3 & 64) != 0) {
            f48 = trackStickerInfo.imageH;
        } else {
            f48 = f28;
        }
        if ((i3 & 128) != 0) {
            f49 = trackStickerInfo.confidence;
        } else {
            f49 = f29;
        }
        if ((i3 & 256) != 0) {
            j16 = trackStickerInfo.timestamp;
        } else {
            j16 = j3;
        }
        return trackStickerInfo.copy(f36, f37, f38, f39, f46, f47, f48, f49, j16);
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final float getW() {
        return this.w;
    }

    /* renamed from: component4, reason: from getter */
    public final float getH() {
        return this.h;
    }

    /* renamed from: component5, reason: from getter */
    public final float getRadian() {
        return this.radian;
    }

    /* renamed from: component6, reason: from getter */
    public final float getImageW() {
        return this.imageW;
    }

    /* renamed from: component7, reason: from getter */
    public final float getImageH() {
        return this.imageH;
    }

    /* renamed from: component8, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* renamed from: component9, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final TrackStickerInfo copy(float x16, float y16, float w3, float h16, float radian, float imageW, float imageH, float confidence, long timestamp) {
        return new TrackStickerInfo(x16, y16, w3, h16, radian, imageW, imageH, confidence, timestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStickerInfo)) {
            return false;
        }
        TrackStickerInfo trackStickerInfo = (TrackStickerInfo) other;
        if (Float.compare(this.x, trackStickerInfo.x) == 0 && Float.compare(this.y, trackStickerInfo.y) == 0 && Float.compare(this.w, trackStickerInfo.w) == 0 && Float.compare(this.h, trackStickerInfo.h) == 0 && Float.compare(this.radian, trackStickerInfo.radian) == 0 && Float.compare(this.imageW, trackStickerInfo.imageW) == 0 && Float.compare(this.imageH, trackStickerInfo.imageH) == 0 && Float.compare(this.confidence, trackStickerInfo.confidence) == 0 && this.timestamp == trackStickerInfo.timestamp) {
            return true;
        }
        return false;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final float getH() {
        return this.h;
    }

    public final float getImageH() {
        return this.imageH;
    }

    public final float getImageW() {
        return this.imageW;
    }

    public final float getRadian() {
        return this.radian;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getW() {
        return this.w;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((((((((((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.w)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.radian)) * 31) + Float.floatToIntBits(this.imageW)) * 31) + Float.floatToIntBits(this.imageH)) * 31) + Float.floatToIntBits(this.confidence)) * 31) + androidx.fragment.app.a.a(this.timestamp);
    }

    public final void setConfidence(float f16) {
        this.confidence = f16;
    }

    public final void setH(float f16) {
        this.h = f16;
    }

    public final void setImageH(float f16) {
        this.imageH = f16;
    }

    public final void setImageW(float f16) {
        this.imageW = f16;
    }

    public final void setRadian(float f16) {
        this.radian = f16;
    }

    public final void setTimestamp(long j3) {
        this.timestamp = j3;
    }

    public final void setW(float f16) {
        this.w = f16;
    }

    public final void setX(float f16) {
        this.x = f16;
    }

    public final void setY(float f16) {
        this.y = f16;
    }

    @NotNull
    public String toString() {
        return "TrackStickerInfo(x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", radian=" + this.radian + ", imageW=" + this.imageW + ", imageH=" + this.imageH + ", confidence=" + this.confidence + ", timestamp=" + this.timestamp + ")";
    }

    public TrackStickerInfo(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, long j3) {
        this.x = f16;
        this.y = f17;
        this.w = f18;
        this.h = f19;
        this.radian = f26;
        this.imageW = f27;
        this.imageH = f28;
        this.confidence = f29;
        this.timestamp = j3;
    }

    public /* synthetic */ TrackStickerInfo(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 0.0f : f26, (i3 & 32) != 0 ? 0.0f : f27, (i3 & 64) != 0 ? 0.0f : f28, (i3 & 128) == 0 ? f29 : 0.0f, (i3 & 256) != 0 ? 0L : j3);
    }
}

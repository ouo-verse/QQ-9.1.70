package com.tencent.karaoke.audiobasesdk.segment;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/SingScoreData;", "", "startTime", "", "endTime", LocalPhotoFaceInfo.SCORE, "(III)V", "getEndTime", "()I", "getScore", "getStartTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class SingScoreData {
    private final int endTime;
    private final int score;
    private final int startTime;

    public SingScoreData(int i3, int i16, int i17) {
        this.startTime = i3;
        this.endTime = i16;
        this.score = i17;
    }

    @NotNull
    public static /* synthetic */ SingScoreData copy$default(SingScoreData singScoreData, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = singScoreData.startTime;
        }
        if ((i18 & 2) != 0) {
            i16 = singScoreData.endTime;
        }
        if ((i18 & 4) != 0) {
            i17 = singScoreData.score;
        }
        return singScoreData.copy(i3, i16, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStartTime() {
        return this.startTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEndTime() {
        return this.endTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    @NotNull
    public final SingScoreData copy(int startTime, int endTime, int score) {
        return new SingScoreData(startTime, endTime, score);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this != other) {
            if (other instanceof SingScoreData) {
                SingScoreData singScoreData = (SingScoreData) other;
                if (this.startTime == singScoreData.startTime) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.endTime == singScoreData.endTime) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (this.score == singScoreData.score) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((this.startTime * 31) + this.endTime) * 31) + this.score;
    }

    @NotNull
    public String toString() {
        return "SingScoreData(startTime=" + this.startTime + ", endTime=" + this.endTime + ", score=" + this.score + ")";
    }
}

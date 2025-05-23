package com.tencent.mobileqq.icgame.api.av;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/av/LiveMediaConfig;", "", "resolution", "", "fps", "bitRate", "minBitRate", "(IIII)V", "getBitRate", "()I", "getFps", "getMinBitRate", "getResolution", "resolutionHeight", "getResolutionHeight", "resolutionWidth", "getResolutionWidth", "toString", "", "Companion", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class LiveMediaConfig {
    public static final int DEFAULT_FPS = 15;
    public static final int HIGH_FPS = 30;
    private final int bitRate;
    private final int fps;
    private final int minBitRate;
    private final int resolution;

    public LiveMediaConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getMinBitRate() {
        return this.minBitRate;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final int getResolutionHeight() {
        int i3 = this.resolution;
        if (i3 == 0) {
            return 480;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 480;
                    }
                    return 1920;
                }
                return 1280;
            }
            return 960;
        }
        return 640;
    }

    public final int getResolutionWidth() {
        int i3 = this.resolution;
        if (i3 == 0) {
            return 270;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return 270;
                    }
                    return 1080;
                }
                return 720;
            }
            return 540;
        }
        return 360;
    }

    @NotNull
    public String toString() {
        return "LiveMediaConfig(fps=" + this.fps + ", bitRate=" + this.bitRate + ", minBitRate=" + this.minBitRate + ", resolutionWidth=" + getResolutionWidth() + ", resolutionHeight=" + getResolutionHeight() + ")";
    }

    public LiveMediaConfig(int i3, int i16, int i17, int i18) {
        this.resolution = i3;
        this.fps = i16;
        this.bitRate = i17;
        this.minBitRate = i18;
    }

    public /* synthetic */ LiveMediaConfig(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 3 : i3, (i19 & 2) != 0 ? 15 : i16, (i19 & 4) != 0 ? 2000 : i17, (i19 & 8) != 0 ? 1400 : i18);
    }
}

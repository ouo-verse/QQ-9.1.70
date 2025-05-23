package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/n;", "Lcom/tencent/robot/adelie/kuikly/module/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "sampleRate", UserInfo.SEX_FEMALE, "c", "()F", "bitsPerChannel", "I", "a", "()I", "channelsPerFrame", "b", "format", "Ljava/lang/String;", "getFormat", "()Ljava/lang/String;", "<init>", "(FIILjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.kuikly.module.n, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieTtsRecordParam implements p {

    @SerializedName("bitsPerChannel")
    private final int bitsPerChannel;

    @SerializedName("channelsPerFrame")
    private final int channelsPerFrame;

    @SerializedName("format")
    @NotNull
    private final String format;

    @SerializedName("sampleRate")
    private final float sampleRate;

    public AdelieTtsRecordParam() {
        this(0.0f, 0, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBitsPerChannel() {
        return this.bitsPerChannel;
    }

    /* renamed from: b, reason: from getter */
    public final int getChannelsPerFrame() {
        return this.channelsPerFrame;
    }

    /* renamed from: c, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieTtsRecordParam)) {
            return false;
        }
        AdelieTtsRecordParam adelieTtsRecordParam = (AdelieTtsRecordParam) other;
        if (Float.compare(this.sampleRate, adelieTtsRecordParam.sampleRate) == 0 && this.bitsPerChannel == adelieTtsRecordParam.bitsPerChannel && this.channelsPerFrame == adelieTtsRecordParam.channelsPerFrame && Intrinsics.areEqual(this.format, adelieTtsRecordParam.format)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.sampleRate) * 31) + this.bitsPerChannel) * 31) + this.channelsPerFrame) * 31) + this.format.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieTtsRecordParam(sampleRate=" + this.sampleRate + ", bitsPerChannel=" + this.bitsPerChannel + ", channelsPerFrame=" + this.channelsPerFrame + ", format=" + this.format + ")";
    }

    public AdelieTtsRecordParam(float f16, int i3, int i16, @NotNull String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.sampleRate = f16;
        this.bitsPerChannel = i3;
        this.channelsPerFrame = i16;
        this.format = format;
    }

    public /* synthetic */ AdelieTtsRecordParam(float f16, int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 24000.0f : f16, (i17 & 2) != 0 ? 16 : i3, (i17 & 4) != 0 ? 1 : i16, (i17 & 8) != 0 ? "WAV" : str);
    }
}

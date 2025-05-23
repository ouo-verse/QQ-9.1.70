package com.tencent.mobileqq.search.record;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\n\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/search/record/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "sampleRate", "b", "bitRate", "I", "getBitsPerChannel", "()I", "bitsPerChannel", "d", "getChannelsPerFrame", "channelsPerFrame", "e", "audioType", "<init>", "(FFIII)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.record.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class RecordParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float sampleRate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float bitRate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bitsPerChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelsPerFrame;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int audioType;

    public RecordParam() {
        this(0.0f, 0.0f, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAudioType() {
        return this.audioType;
    }

    /* renamed from: b, reason: from getter */
    public final float getBitRate() {
        return this.bitRate;
    }

    /* renamed from: c, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordParam)) {
            return false;
        }
        RecordParam recordParam = (RecordParam) other;
        if (Float.compare(this.sampleRate, recordParam.sampleRate) == 0 && Float.compare(this.bitRate, recordParam.bitRate) == 0 && this.bitsPerChannel == recordParam.bitsPerChannel && this.channelsPerFrame == recordParam.channelsPerFrame && this.audioType == recordParam.audioType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.sampleRate) * 31) + Float.floatToIntBits(this.bitRate)) * 31) + this.bitsPerChannel) * 31) + this.channelsPerFrame) * 31) + this.audioType;
    }

    @NotNull
    public String toString() {
        return "RecordParam(sampleRate=" + this.sampleRate + ", bitRate=" + this.bitRate + ", bitsPerChannel=" + this.bitsPerChannel + ", channelsPerFrame=" + this.channelsPerFrame + ", audioType=" + this.audioType + ")";
    }

    public RecordParam(float f16, float f17, int i3, int i16, int i17) {
        this.sampleRate = f16;
        this.bitRate = f17;
        this.bitsPerChannel = i3;
        this.channelsPerFrame = i16;
        this.audioType = i17;
    }

    public /* synthetic */ RecordParam(float f16, float f17, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 16000.0f : f16, (i18 & 2) == 0 ? f17 : 16000.0f, (i18 & 4) != 0 ? 16 : i3, (i18 & 8) != 0 ? 1 : i16, (i18 & 16) != 0 ? 1 : i17);
    }
}

package com.tencent.tavcut.core.render.builder.light.model.pag;

import androidx.fragment.app.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/pag/LayerMarkData;", "", "startTimeUs", "", "durationUs", "desc", "", "(JJLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getDurationUs", "()J", "getStartTimeUs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class LayerMarkData {

    @Nullable
    private final String desc;
    private final long durationUs;
    private final long startTimeUs;

    public LayerMarkData(long j3, long j16, @Nullable String str) {
        this.startTimeUs = j3;
        this.durationUs = j16;
        this.desc = str;
    }

    public static /* synthetic */ LayerMarkData copy$default(LayerMarkData layerMarkData, long j3, long j16, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = layerMarkData.startTimeUs;
        }
        long j17 = j3;
        if ((i3 & 2) != 0) {
            j16 = layerMarkData.durationUs;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            str = layerMarkData.desc;
        }
        return layerMarkData.copy(j17, j18, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartTimeUs() {
        return this.startTimeUs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final LayerMarkData copy(long startTimeUs, long durationUs, @Nullable String desc) {
        return new LayerMarkData(startTimeUs, durationUs, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LayerMarkData) {
                LayerMarkData layerMarkData = (LayerMarkData) other;
                if (this.startTimeUs != layerMarkData.startTimeUs || this.durationUs != layerMarkData.durationUs || !Intrinsics.areEqual(this.desc, layerMarkData.desc)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final long getStartTimeUs() {
        return this.startTimeUs;
    }

    public int hashCode() {
        int i3;
        int a16 = ((a.a(this.startTimeUs) * 31) + a.a(this.durationUs)) * 31;
        String str = this.desc;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "LayerMarkData(startTimeUs=" + this.startTimeUs + ", durationUs=" + this.durationUs + ", desc=" + this.desc + ")";
    }

    public /* synthetic */ LayerMarkData(long j3, long j16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, (i3 & 4) != 0 ? null : str);
    }
}

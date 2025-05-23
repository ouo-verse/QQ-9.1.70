package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.TimeRange;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "", "entityID", "", "type", "", DownloaderConstant.KEY_RANGE, "Lorg/light/TimeRange;", "time", "", "event", "(Ljava/lang/Integer;Ljava/lang/String;Lorg/light/TimeRange;Ljava/lang/Long;Ljava/lang/String;)V", "getEntityID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEvent", "()Ljava/lang/String;", "getRange", "()Lorg/light/TimeRange;", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lorg/light/TimeRange;Ljava/lang/Long;Ljava/lang/String;)Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "equals", "", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Timeline {

    @Nullable
    private final Integer entityID;

    @Nullable
    private final String event;

    @Nullable
    private final TimeRange range;

    @Nullable
    private final Long time;

    @Nullable
    private final String type;

    public Timeline() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Timeline copy$default(Timeline timeline, Integer num, String str, TimeRange timeRange, Long l3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = timeline.entityID;
        }
        if ((i3 & 2) != 0) {
            str = timeline.type;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            timeRange = timeline.range;
        }
        TimeRange timeRange2 = timeRange;
        if ((i3 & 8) != 0) {
            l3 = timeline.time;
        }
        Long l16 = l3;
        if ((i3 & 16) != 0) {
            str2 = timeline.event;
        }
        return timeline.copy(num, str3, timeRange2, l16, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getEntityID() {
        return this.entityID;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final TimeRange getRange() {
        return this.range;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getTime() {
        return this.time;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    @NotNull
    public final Timeline copy(@Nullable Integer entityID, @Nullable String type, @Nullable TimeRange range, @Nullable Long time, @Nullable String event) {
        return new Timeline(entityID, type, range, time, event);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Timeline) {
                Timeline timeline = (Timeline) other;
                if (!Intrinsics.areEqual(this.entityID, timeline.entityID) || !Intrinsics.areEqual(this.type, timeline.type) || !Intrinsics.areEqual(this.range, timeline.range) || !Intrinsics.areEqual(this.time, timeline.time) || !Intrinsics.areEqual(this.event, timeline.event)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getEntityID() {
        return this.entityID;
    }

    @Nullable
    public final String getEvent() {
        return this.event;
    }

    @Nullable
    public final TimeRange getRange() {
        return this.range;
    }

    @Nullable
    public final Long getTime() {
        return this.time;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        Integer num = this.entityID;
        int i19 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str = this.type;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        TimeRange timeRange = this.range;
        if (timeRange != null) {
            i17 = timeRange.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        Long l3 = this.time;
        if (l3 != null) {
            i18 = l3.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str2 = this.event;
        if (str2 != null) {
            i19 = str2.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "Timeline(entityID=" + this.entityID + ", type=" + this.type + ", range=" + this.range + ", time=" + this.time + ", event=" + this.event + ")";
    }

    public Timeline(@Nullable Integer num, @Nullable String str, @Nullable TimeRange timeRange, @Nullable Long l3, @Nullable String str2) {
        this.entityID = num;
        this.type = str;
        this.range = timeRange;
        this.time = l3;
        this.event = str2;
    }

    public /* synthetic */ Timeline(Integer num, String str, TimeRange timeRange, Long l3, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : timeRange, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : str2);
    }
}

package com.tencent.state.square.data;

import com.tencent.state.square.api.SongInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u00c6\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/data/SpecialStatus;", "", "batteryLevel", "", "weatherDesc", "", "id", "type", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/state/square/api/SongInfo;)V", "getBatteryLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getSongInfo", "()Lcom/tencent/state/square/api/SongInfo;", "getType", "getWeatherDesc", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/state/square/api/SongInfo;)Lcom/tencent/state/square/data/SpecialStatus;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SpecialStatus {
    private final Integer batteryLevel;
    private final Integer id;
    private final SongInfo songInfo;
    private final Integer type;
    private final String weatherDesc;

    public SpecialStatus() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWeatherDesc() {
        return this.weatherDesc;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final SongInfo getSongInfo() {
        return this.songInfo;
    }

    public final SpecialStatus copy(Integer batteryLevel, String weatherDesc, Integer id5, Integer type, SongInfo songInfo) {
        return new SpecialStatus(batteryLevel, weatherDesc, id5, type, songInfo);
    }

    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    public final Integer getId() {
        return this.id;
    }

    public final SongInfo getSongInfo() {
        return this.songInfo;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getWeatherDesc() {
        return this.weatherDesc;
    }

    public int hashCode() {
        Integer num = this.batteryLevel;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.weatherDesc;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.type;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
        SongInfo songInfo = this.songInfo;
        return hashCode4 + (songInfo != null ? songInfo.hashCode() : 0);
    }

    public String toString() {
        return "SpecialStatus(batteryLevel=" + this.batteryLevel + ", weatherDesc=" + this.weatherDesc + ", id=" + this.id + ", type=" + this.type + ", songInfo=" + this.songInfo + ")";
    }

    public SpecialStatus(Integer num, String str, Integer num2, Integer num3, SongInfo songInfo) {
        this.batteryLevel = num;
        this.weatherDesc = str;
        this.id = num2;
        this.type = num3;
        this.songInfo = songInfo;
    }

    public /* synthetic */ SpecialStatus(Integer num, String str, Integer num2, Integer num3, SongInfo songInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : songInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpecialStatus)) {
            return false;
        }
        SpecialStatus specialStatus = (SpecialStatus) other;
        return Intrinsics.areEqual(this.batteryLevel, specialStatus.batteryLevel) && Intrinsics.areEqual(this.weatherDesc, specialStatus.weatherDesc) && Intrinsics.areEqual(this.id, specialStatus.id) && Intrinsics.areEqual(this.type, specialStatus.type) && Intrinsics.areEqual(this.songInfo, specialStatus.songInfo);
    }

    public static /* synthetic */ SpecialStatus copy$default(SpecialStatus specialStatus, Integer num, String str, Integer num2, Integer num3, SongInfo songInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = specialStatus.batteryLevel;
        }
        if ((i3 & 2) != 0) {
            str = specialStatus.weatherDesc;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            num2 = specialStatus.id;
        }
        Integer num4 = num2;
        if ((i3 & 8) != 0) {
            num3 = specialStatus.type;
        }
        Integer num5 = num3;
        if ((i3 & 16) != 0) {
            songInfo = specialStatus.songInfo;
        }
        return specialStatus.copy(num, str2, num4, num5, songInfo);
    }
}

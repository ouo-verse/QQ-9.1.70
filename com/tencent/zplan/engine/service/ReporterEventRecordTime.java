package com.tencent.zplan.engine.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/zplan/engine/service/ReporterEventRecordTime;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", "", "e", "J", "c", "()J", "setTime", "(J)V", "time", "", "f", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setReportMap", "(Ljava/util/Map;)V", "reportMap", "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class ReporterEventRecordTime implements Parcelable {
    public static final Parcelable.Creator<ReporterEventRecordTime> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String message;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long time;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Map<String, String> reportMap;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<ReporterEventRecordTime> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ReporterEventRecordTime createFromParcel(@NotNull Parcel in5) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(in5, "in");
            String readString = in5.readString();
            long readLong = in5.readLong();
            if (in5.readInt() != 0) {
                int readInt = in5.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    linkedHashMap.put(in5.readString(), in5.readString());
                    readInt--;
                }
            } else {
                linkedHashMap = null;
            }
            return new ReporterEventRecordTime(readString, readLong, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ReporterEventRecordTime[] newArray(int i3) {
            return new ReporterEventRecordTime[i3];
        }
    }

    public ReporterEventRecordTime(@Nullable String str, long j3, @Nullable Map<String, String> map) {
        this.message = str;
        this.time = j3;
        this.reportMap = map;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Map<String, String> b() {
        return this.reportMap;
    }

    /* renamed from: c, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ReporterEventRecordTime) {
                ReporterEventRecordTime reporterEventRecordTime = (ReporterEventRecordTime) other;
                if (!Intrinsics.areEqual(this.message, reporterEventRecordTime.message) || this.time != reporterEventRecordTime.time || !Intrinsics.areEqual(this.reportMap, reporterEventRecordTime.reportMap)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.message;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.time;
        int i17 = ((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Map<String, String> map = this.reportMap;
        if (map != null) {
            i16 = map.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ReporterEventRecordTime(message=" + this.message + ", time=" + this.time + ", reportMap=" + this.reportMap + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.message);
        parcel.writeLong(this.time);
        Map<String, String> map = this.reportMap;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }
}

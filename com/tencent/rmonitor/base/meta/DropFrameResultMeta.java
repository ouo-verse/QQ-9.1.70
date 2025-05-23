package com.tencent.rmonitor.base.meta;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.rmonitor.custom.a;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J[\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0000J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0000H\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0000J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0000H\u0002J\b\u0010'\u001a\u00020\u001bH\u0016J\u0006\u0010(\u001a\u00020\rJ\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "scene", "", "totalDuration", "", "refreshDuration", "", "refreshCount", "hitchesDuration", "suspendDuration", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "userCustom", "Lorg/json/JSONObject;", "(Ljava/lang/String;J[J[JJJJLorg/json/JSONObject;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "computeFPS", "", "copy", "copyFrom", "", "other", "equals", "", "", "equalsOther", "fromJSONObject", "jsonObject", "hashCode", "", DeviceType.DeviceCategory.MERGER, "mergeUserCustom", "reset", "toJSONObject", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class DropFrameResultMeta extends MonitorMeta {

    @JvmField
    public long hitchesDuration;

    @JvmField
    @NotNull
    public final long[] refreshCount;

    @JvmField
    @NotNull
    public final long[] refreshDuration;

    @JvmField
    @NotNull
    public String scene;

    @JvmField
    public long suspendDuration;

    @JvmField
    public long timeStamp;

    @JvmField
    public long totalDuration;

    @JvmField
    @Nullable
    public JSONObject userCustom;

    public DropFrameResultMeta() {
        this(null, 0L, null, null, 0L, 0L, 0L, null, 255, null);
    }

    public static /* synthetic */ DropFrameResultMeta copy$default(DropFrameResultMeta dropFrameResultMeta, String str, long j3, long[] jArr, long[] jArr2, long j16, long j17, long j18, JSONObject jSONObject, int i3, Object obj) {
        String str2;
        long j19;
        long[] jArr3;
        long[] jArr4;
        long j26;
        long j27;
        long j28;
        JSONObject jSONObject2;
        if ((i3 & 1) != 0) {
            str2 = dropFrameResultMeta.scene;
        } else {
            str2 = str;
        }
        if ((i3 & 2) != 0) {
            j19 = dropFrameResultMeta.totalDuration;
        } else {
            j19 = j3;
        }
        if ((i3 & 4) != 0) {
            jArr3 = dropFrameResultMeta.refreshDuration;
        } else {
            jArr3 = jArr;
        }
        if ((i3 & 8) != 0) {
            jArr4 = dropFrameResultMeta.refreshCount;
        } else {
            jArr4 = jArr2;
        }
        if ((i3 & 16) != 0) {
            j26 = dropFrameResultMeta.hitchesDuration;
        } else {
            j26 = j16;
        }
        if ((i3 & 32) != 0) {
            j27 = dropFrameResultMeta.suspendDuration;
        } else {
            j27 = j17;
        }
        if ((i3 & 64) != 0) {
            j28 = dropFrameResultMeta.timeStamp;
        } else {
            j28 = j18;
        }
        if ((i3 & 128) != 0) {
            jSONObject2 = dropFrameResultMeta.userCustom;
        } else {
            jSONObject2 = jSONObject;
        }
        return dropFrameResultMeta.copy(str2, j19, jArr3, jArr4, j26, j27, j28, jSONObject2);
    }

    private final boolean equalsOther(DropFrameResultMeta other) {
        if (!(!Intrinsics.areEqual(this.scene, other.scene)) && this.totalDuration == other.totalDuration && Arrays.equals(this.refreshDuration, other.refreshDuration) && Arrays.equals(this.refreshCount, other.refreshCount) && this.hitchesDuration == other.hitchesDuration && this.suspendDuration == other.suspendDuration && this.timeStamp == other.timeStamp && !(!Intrinsics.areEqual(this.userCustom, other.userCustom))) {
            return true;
        }
        return false;
    }

    private final void mergeUserCustom(DropFrameResultMeta other) {
        JSONObject jSONObject = other.userCustom;
        JSONObject jSONObject2 = this.userCustom;
        if (jSONObject != null) {
            if (jSONObject2 != null) {
                ArrayList<String> arrayList = new ArrayList(40);
                String[] strArr = ICustomDataEditor.NUMBER_PARAM_KEYS;
                Intrinsics.checkExpressionValueIsNotNull(strArr, "ICustomDataEditor.NUMBER_PARAM_KEYS");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, strArr);
                String[] strArr2 = ICustomDataEditor.STRING_PARAM_KEYS;
                Intrinsics.checkExpressionValueIsNotNull(strArr2, "ICustomDataEditor.STRING_PARAM_KEYS");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, strArr2);
                String[] strArr3 = ICustomDataEditor.STRING_ARRAY_PARAM_KEYS;
                Intrinsics.checkExpressionValueIsNotNull(strArr3, "ICustomDataEditor.STRING_ARRAY_PARAM_KEYS");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, strArr3);
                String[] strArr4 = a.f365540j;
                Intrinsics.checkExpressionValueIsNotNull(strArr4, "CustomData.RESERVED_PARAM_KEYS");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, strArr4);
                for (String str : arrayList) {
                    if (!jSONObject2.has(str) && jSONObject.has(str)) {
                        jSONObject2.put(str, jSONObject.get(str));
                    }
                }
            }
            this.userCustom = jSONObject;
        }
        jSONObject = jSONObject2;
        this.userCustom = jSONObject;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final long[] getRefreshDuration() {
        return this.refreshDuration;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final long[] getRefreshCount() {
        return this.refreshCount;
    }

    /* renamed from: component5, reason: from getter */
    public final long getHitchesDuration() {
        return this.hitchesDuration;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSuspendDuration() {
        return this.suspendDuration;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final JSONObject getUserCustom() {
        return this.userCustom;
    }

    public final float computeFPS() {
        long j3 = 0;
        for (long j16 : this.refreshDuration) {
            j3 += j16;
        }
        if (j3 > 0) {
            return (((float) (j3 - this.hitchesDuration)) * 60.0f) / ((float) j3);
        }
        return 0.0f;
    }

    @NotNull
    public final DropFrameResultMeta copy(@NotNull String scene, long totalDuration, @NotNull long[] refreshDuration, @NotNull long[] refreshCount, long hitchesDuration, long suspendDuration, long timeStamp, @Nullable JSONObject userCustom) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(refreshDuration, "refreshDuration");
        Intrinsics.checkParameterIsNotNull(refreshCount, "refreshCount");
        return new DropFrameResultMeta(scene, totalDuration, refreshDuration, refreshCount, hitchesDuration, suspendDuration, timeStamp, userCustom);
    }

    public final void copyFrom(@NotNull DropFrameResultMeta other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        this.scene = other.scene;
        this.timeStamp = other.timeStamp;
        this.totalDuration = other.totalDuration;
        this.hitchesDuration = other.hitchesDuration;
        this.suspendDuration = other.suspendDuration;
        int length = this.refreshCount.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.refreshCount[i3] = other.refreshCount[i3];
        }
        int length2 = this.refreshDuration.length;
        for (int i16 = 0; i16 < length2; i16++) {
            this.refreshDuration[i16] = other.refreshDuration[i16];
        }
        this.userCustom = other.userCustom;
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
        if (true ^ Intrinsics.areEqual(DropFrameResultMeta.class, cls)) {
            return false;
        }
        if (other != null) {
            return equalsOther((DropFrameResultMeta) other);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.rmonitor.base.meta.DropFrameResultMeta");
    }

    public final void fromJSONObject(@NotNull JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        try {
            String optString = jsonObject.optString("stage");
            Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(\"stage\")");
            this.scene = optString;
            this.totalDuration = jsonObject.optLong(PeakConstants.VIDEO_TOTAL_DURATION);
            this.hitchesDuration = jsonObject.optLong("hitches_duration");
            this.suspendDuration = jsonObject.optLong("suspend_duration");
            this.timeStamp = jsonObject.optLong("timestamp");
            JSONArray optJSONArray = jsonObject.optJSONArray("refresh_count");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                long[] jArr = this.refreshCount;
                if (length == jArr.length) {
                    int length2 = jArr.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        this.refreshCount[i3] = optJSONArray.optLong(i3);
                    }
                }
            }
            JSONArray optJSONArray2 = jsonObject.optJSONArray("refresh_duration");
            if (optJSONArray2 != null) {
                int length3 = optJSONArray2.length();
                long[] jArr2 = this.refreshDuration;
                if (length3 == jArr2.length) {
                    int length4 = jArr2.length;
                    for (int i16 = 0; i16 < length4; i16++) {
                        this.refreshDuration[i16] = optJSONArray2.optLong(i16);
                    }
                }
            }
            this.userCustom = jsonObject.optJSONObject(ReportDataBuilder.KEY_USER_CUSTOM);
        } catch (Throwable th5) {
            Logger.f365497g.d("RMonitor_looper", th5.toString());
        }
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.scene.hashCode() * 31) + Long.valueOf(this.totalDuration).hashCode()) * 31) + Arrays.hashCode(this.refreshDuration)) * 31) + Arrays.hashCode(this.refreshCount)) * 31) + Long.valueOf(this.hitchesDuration).hashCode()) * 31) + Long.valueOf(this.suspendDuration).hashCode()) * 31) + Long.valueOf(this.timeStamp).hashCode()) * 31;
        JSONObject jSONObject = this.userCustom;
        int i3 = 0;
        if (jSONObject != null && jSONObject != null) {
            i3 = jSONObject.hashCode();
        }
        return hashCode + i3;
    }

    public final void merge(@NotNull DropFrameResultMeta other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        this.totalDuration += other.totalDuration;
        int length = this.refreshDuration.length;
        for (int i3 = 0; i3 < length; i3++) {
            long[] jArr = this.refreshDuration;
            jArr[i3] = jArr[i3] + other.refreshDuration[i3];
        }
        int length2 = this.refreshCount.length;
        for (int i16 = 0; i16 < length2; i16++) {
            long[] jArr2 = this.refreshCount;
            jArr2[i16] = jArr2[i16] + other.refreshCount[i16];
        }
        this.hitchesDuration += other.hitchesDuration;
        this.suspendDuration += other.suspendDuration;
        mergeUserCustom(other);
    }

    @Override // com.tencent.bugly.common.utils.RecyclablePool.Recyclable
    public void reset() {
        this.scene = "";
        this.timeStamp = 0L;
        this.totalDuration = 0L;
        this.hitchesDuration = 0L;
        this.suspendDuration = 0L;
        int length = this.refreshCount.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.refreshCount[i3] = 0;
        }
        int length2 = this.refreshDuration.length;
        for (int i16 = 0; i16 < length2; i16++) {
            this.refreshDuration[i16] = 0;
        }
        this.userCustom = null;
    }

    @NotNull
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stage", this.scene);
        jSONObject.put(PeakConstants.VIDEO_TOTAL_DURATION, this.totalDuration);
        jSONObject.put("hitches_duration", this.hitchesDuration);
        jSONObject.put("suspend_duration", this.suspendDuration);
        jSONObject.put("timestamp", this.timeStamp);
        JSONArray jSONArray = new JSONArray();
        int length = this.refreshCount.length;
        long j3 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            jSONArray.put(i3, this.refreshCount[i3]);
            j3 += this.refreshCount[i3];
        }
        jSONObject.put("refresh_count", jSONArray);
        jSONObject.put("total_refresh_count", j3);
        JSONArray jSONArray2 = new JSONArray();
        int length2 = this.refreshDuration.length;
        for (int i16 = 0; i16 < length2; i16++) {
            jSONArray2.put(i16, this.refreshDuration[i16]);
        }
        jSONObject.put("refresh_duration", jSONArray2);
        JSONObject jSONObject2 = this.userCustom;
        if (jSONObject2 != null) {
            jSONObject.put(ReportDataBuilder.KEY_USER_CUSTOM, jSONObject2);
        }
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "DropFrameResultMeta(scene=" + this.scene + ", totalDuration=" + this.totalDuration + ", refreshDuration=" + Arrays.toString(this.refreshDuration) + ", refreshCount=" + Arrays.toString(this.refreshCount) + ", hitchesDuration=" + this.hitchesDuration + ", suspendDuration=" + this.suspendDuration + ", timeStamp=" + this.timeStamp + ", userCustom=" + this.userCustom + ")";
    }

    public DropFrameResultMeta(@NotNull String scene, long j3, @NotNull long[] refreshDuration, @NotNull long[] refreshCount, long j16, long j17, long j18, @Nullable JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(refreshDuration, "refreshDuration");
        Intrinsics.checkParameterIsNotNull(refreshCount, "refreshCount");
        this.scene = scene;
        this.totalDuration = j3;
        this.refreshDuration = refreshDuration;
        this.refreshCount = refreshCount;
        this.hitchesDuration = j16;
        this.suspendDuration = j17;
        this.timeStamp = j18;
        this.userCustom = jSONObject;
    }

    public /* synthetic */ DropFrameResultMeta(String str, long j3, long[] jArr, long[] jArr2, long j16, long j17, long j18, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? new long[60] : jArr, (i3 & 8) != 0 ? new long[60] : jArr2, (i3 & 16) != 0 ? 0L : j16, (i3 & 32) != 0 ? 0L : j17, (i3 & 64) == 0 ? j18 : 0L, (i3 & 128) != 0 ? null : jSONObject);
    }
}

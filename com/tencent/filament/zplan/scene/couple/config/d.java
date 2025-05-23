package com.tencent.filament.zplan.scene.couple.config;

import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB1\u0012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\f\b\u0002\u0010\b\u001a\u00060\u0004j\u0002`\u0007\u0012\f\b\u0002\u0010\n\u001a\u00060\u0004j\u0002`\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J3\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\f\b\u0002\u0010\b\u001a\u00060\u0004j\u0002`\u00072\f\b\u0002\u0010\n\u001a\u00060\u0004j\u0002`\tH\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001e\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00060\u0004j\u0002`\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\n\u001a\u00060\u0004j\u0002`\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/d;", "", "", "toString", "", "Lcom/tencent/filament/zplan/scene/couple/config/Location;", "location", "Lcom/tencent/filament/zplan/scene/couple/config/Rotation;", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/filament/zplan/scene/couple/config/Scale;", "scale", "a", "", "hashCode", "other", "", "equals", "[D", "c", "()[D", "getRotation", "getScale", "<init>", "([D[D[D)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("location")
    @NotNull
    private final double[] location;

    @SerializedName(BasicAnimation.KeyPath.ROTATION)
    @NotNull
    private final double[] rotation;

    @SerializedName("scale")
    @NotNull
    private final double[] scale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0005R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/d$a;", "", "Lorg/json/JSONObject;", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "b", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.couple.config.d$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final d a(@Nullable String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return null;
            }
            try {
                return (d) GsonUtil.f385283b.a().fromJson(str, d.class);
            } catch (JsonSyntaxException unused) {
                return null;
            }
        }

        @Nullable
        public final d b(@Nullable JSONObject jSONObject) {
            String str;
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = null;
            }
            return a(str);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ d b(d dVar, double[] dArr, double[] dArr2, double[] dArr3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dArr = dVar.location;
        }
        if ((i3 & 2) != 0) {
            dArr2 = dVar.rotation;
        }
        if ((i3 & 4) != 0) {
            dArr3 = dVar.scale;
        }
        return dVar.a(dArr, dArr2, dArr3);
    }

    @NotNull
    public final d a(@NotNull double[] location, @NotNull double[] rotation, @NotNull double[] scale) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(scale, "scale");
        return new d(location, rotation, scale);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final double[] getLocation() {
        return this.location;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (!Intrinsics.areEqual(this.location, dVar.location) || !Intrinsics.areEqual(this.rotation, dVar.rotation) || !Intrinsics.areEqual(this.scale, dVar.scale)) {
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
        int i16;
        double[] dArr = this.location;
        int i17 = 0;
        if (dArr != null) {
            i3 = Arrays.hashCode(dArr);
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        double[] dArr2 = this.rotation;
        if (dArr2 != null) {
            i16 = Arrays.hashCode(dArr2);
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        double[] dArr3 = this.scale;
        if (dArr3 != null) {
            i17 = Arrays.hashCode(dArr3);
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        try {
            String json = GsonUtil.f385283b.a().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "GsonUtil.gson.toJson(this)");
            return json;
        } catch (Throwable th5) {
            FLog.INSTANCE.e("Transform", "toString exception", th5);
            return "";
        }
    }

    public d(@NotNull double[] location, @NotNull double[] rotation, @NotNull double[] scale) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(scale, "scale");
        this.location = location;
        this.rotation = rotation;
        this.scale = scale;
    }

    public /* synthetic */ d(double[] dArr, double[] dArr2, double[] dArr3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new double[]{0.0d, 0.0d, 0.0d} : dArr, (i3 & 2) != 0 ? new double[]{0.0d, 0.0d, 0.0d, 0.0d} : dArr2, (i3 & 4) != 0 ? new double[]{1.0d, 1.0d, 1.0d} : dArr3);
    }
}

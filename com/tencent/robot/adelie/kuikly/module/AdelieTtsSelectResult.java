package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/o;", "Lcom/tencent/robot/adelie/kuikly/module/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "ttsId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ttsName", "b", "ttsType", "I", "c", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.kuikly.module.o, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieTtsSelectResult implements p {

    @SerializedName("ttsId")
    @NotNull
    private final String ttsId;

    @SerializedName("ttsName")
    @NotNull
    private final String ttsName;

    @SerializedName("ttsType")
    private final int ttsType;

    public AdelieTtsSelectResult() {
        this(null, null, 0, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getTtsId() {
        return this.ttsId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTtsName() {
        return this.ttsName;
    }

    /* renamed from: c, reason: from getter */
    public final int getTtsType() {
        return this.ttsType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieTtsSelectResult)) {
            return false;
        }
        AdelieTtsSelectResult adelieTtsSelectResult = (AdelieTtsSelectResult) other;
        if (Intrinsics.areEqual(this.ttsId, adelieTtsSelectResult.ttsId) && Intrinsics.areEqual(this.ttsName, adelieTtsSelectResult.ttsName) && this.ttsType == adelieTtsSelectResult.ttsType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.ttsId.hashCode() * 31) + this.ttsName.hashCode()) * 31) + this.ttsType;
    }

    @NotNull
    public String toString() {
        return "AdelieTtsSelectResult(ttsId=" + this.ttsId + ", ttsName=" + this.ttsName + ", ttsType=" + this.ttsType + ")";
    }

    public AdelieTtsSelectResult(@NotNull String ttsId, @NotNull String ttsName, int i3) {
        Intrinsics.checkNotNullParameter(ttsId, "ttsId");
        Intrinsics.checkNotNullParameter(ttsName, "ttsName");
        this.ttsId = ttsId;
        this.ttsName = ttsName;
        this.ttsType = i3;
    }

    public /* synthetic */ AdelieTtsSelectResult(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3);
    }
}

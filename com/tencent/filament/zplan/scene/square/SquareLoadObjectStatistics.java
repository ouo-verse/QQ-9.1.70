package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\nH\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\nH\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\t\u00106\u001a\u00020\nH\u00c6\u0003Jm\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u00c6\u0001J\u0013\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020;H\u00d6\u0001J\t\u0010<\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006="}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "", "objectId", "", "objectType", "Lcom/tencent/filament/zplan/scene/square/ObjectType;", "loadCost", "", "loadAvatarResourceCost", "loadAvatarResourceFromNet", "", "createObjectCost", "loadAnimationCost", "applyAnimationCost", "hasGuest", "hasExtra", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/ObjectType;JJZJJJZZ)V", "getApplyAnimationCost", "()J", "setApplyAnimationCost", "(J)V", "getCreateObjectCost", "setCreateObjectCost", "getHasExtra", "()Z", "setHasExtra", "(Z)V", "getHasGuest", "setHasGuest", "getLoadAnimationCost", "setLoadAnimationCost", "getLoadAvatarResourceCost", "setLoadAvatarResourceCost", "getLoadAvatarResourceFromNet", "setLoadAvatarResourceFromNet", "getLoadCost", "setLoadCost", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "getObjectType", "()Lcom/tencent/filament/zplan/scene/square/ObjectType;", "setObjectType", "(Lcom/tencent/filament/zplan/scene/square/ObjectType;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareLoadObjectStatistics {
    private long applyAnimationCost;
    private long createObjectCost;
    private boolean hasExtra;
    private boolean hasGuest;
    private long loadAnimationCost;
    private long loadAvatarResourceCost;
    private boolean loadAvatarResourceFromNet;
    private long loadCost;

    @NotNull
    private String objectId;

    @NotNull
    private ObjectType objectType;

    public SquareLoadObjectStatistics(@NotNull String objectId, @NotNull ObjectType objectType, long j3, long j16, boolean z16, long j17, long j18, long j19, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        this.objectId = objectId;
        this.objectType = objectType;
        this.loadCost = j3;
        this.loadAvatarResourceCost = j16;
        this.loadAvatarResourceFromNet = z16;
        this.createObjectCost = j17;
        this.loadAnimationCost = j18;
        this.applyAnimationCost = j19;
        this.hasGuest = z17;
        this.hasExtra = z18;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getObjectId() {
        return this.objectId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getHasExtra() {
        return this.hasExtra;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ObjectType getObjectType() {
        return this.objectType;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLoadCost() {
        return this.loadCost;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLoadAvatarResourceCost() {
        return this.loadAvatarResourceCost;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getLoadAvatarResourceFromNet() {
        return this.loadAvatarResourceFromNet;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreateObjectCost() {
        return this.createObjectCost;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLoadAnimationCost() {
        return this.loadAnimationCost;
    }

    /* renamed from: component8, reason: from getter */
    public final long getApplyAnimationCost() {
        return this.applyAnimationCost;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getHasGuest() {
        return this.hasGuest;
    }

    @NotNull
    public final SquareLoadObjectStatistics copy(@NotNull String objectId, @NotNull ObjectType objectType, long loadCost, long loadAvatarResourceCost, boolean loadAvatarResourceFromNet, long createObjectCost, long loadAnimationCost, long applyAnimationCost, boolean hasGuest, boolean hasExtra) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        return new SquareLoadObjectStatistics(objectId, objectType, loadCost, loadAvatarResourceCost, loadAvatarResourceFromNet, createObjectCost, loadAnimationCost, applyAnimationCost, hasGuest, hasExtra);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareLoadObjectStatistics) {
                SquareLoadObjectStatistics squareLoadObjectStatistics = (SquareLoadObjectStatistics) other;
                if (!Intrinsics.areEqual(this.objectId, squareLoadObjectStatistics.objectId) || !Intrinsics.areEqual(this.objectType, squareLoadObjectStatistics.objectType) || this.loadCost != squareLoadObjectStatistics.loadCost || this.loadAvatarResourceCost != squareLoadObjectStatistics.loadAvatarResourceCost || this.loadAvatarResourceFromNet != squareLoadObjectStatistics.loadAvatarResourceFromNet || this.createObjectCost != squareLoadObjectStatistics.createObjectCost || this.loadAnimationCost != squareLoadObjectStatistics.loadAnimationCost || this.applyAnimationCost != squareLoadObjectStatistics.applyAnimationCost || this.hasGuest != squareLoadObjectStatistics.hasGuest || this.hasExtra != squareLoadObjectStatistics.hasExtra) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getApplyAnimationCost() {
        return this.applyAnimationCost;
    }

    public final long getCreateObjectCost() {
        return this.createObjectCost;
    }

    public final boolean getHasExtra() {
        return this.hasExtra;
    }

    public final boolean getHasGuest() {
        return this.hasGuest;
    }

    public final long getLoadAnimationCost() {
        return this.loadAnimationCost;
    }

    public final long getLoadAvatarResourceCost() {
        return this.loadAvatarResourceCost;
    }

    public final boolean getLoadAvatarResourceFromNet() {
        return this.loadAvatarResourceFromNet;
    }

    public final long getLoadCost() {
        return this.loadCost;
    }

    @NotNull
    public final String getObjectId() {
        return this.objectId;
    }

    @NotNull
    public final ObjectType getObjectType() {
        return this.objectType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.objectId;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        ObjectType objectType = this.objectType;
        if (objectType != null) {
            i16 = objectType.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        long j3 = this.loadCost;
        int i19 = (i18 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.loadAvatarResourceCost;
        int i26 = (i19 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        boolean z16 = this.loadAvatarResourceFromNet;
        int i27 = 1;
        int i28 = z16;
        if (z16 != 0) {
            i28 = 1;
        }
        long j17 = this.createObjectCost;
        int i29 = (((i26 + i28) * 31) + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.loadAnimationCost;
        int i36 = (i29 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.applyAnimationCost;
        int i37 = (i36 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        boolean z17 = this.hasGuest;
        int i38 = z17;
        if (z17 != 0) {
            i38 = 1;
        }
        int i39 = (i37 + i38) * 31;
        boolean z18 = this.hasExtra;
        if (!z18) {
            i27 = z18 ? 1 : 0;
        }
        return i39 + i27;
    }

    public final void setApplyAnimationCost(long j3) {
        this.applyAnimationCost = j3;
    }

    public final void setCreateObjectCost(long j3) {
        this.createObjectCost = j3;
    }

    public final void setHasExtra(boolean z16) {
        this.hasExtra = z16;
    }

    public final void setHasGuest(boolean z16) {
        this.hasGuest = z16;
    }

    public final void setLoadAnimationCost(long j3) {
        this.loadAnimationCost = j3;
    }

    public final void setLoadAvatarResourceCost(long j3) {
        this.loadAvatarResourceCost = j3;
    }

    public final void setLoadAvatarResourceFromNet(boolean z16) {
        this.loadAvatarResourceFromNet = z16;
    }

    public final void setLoadCost(long j3) {
        this.loadCost = j3;
    }

    public final void setObjectId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.objectId = str;
    }

    public final void setObjectType(@NotNull ObjectType objectType) {
        Intrinsics.checkNotNullParameter(objectType, "<set-?>");
        this.objectType = objectType;
    }

    @NotNull
    public String toString() {
        return "SquareLoadObjectStatistics(objectId=" + this.objectId + ", objectType=" + this.objectType + ", loadCost=" + this.loadCost + ", loadAvatarResourceCost=" + this.loadAvatarResourceCost + ", loadAvatarResourceFromNet=" + this.loadAvatarResourceFromNet + ", createObjectCost=" + this.createObjectCost + ", loadAnimationCost=" + this.loadAnimationCost + ", applyAnimationCost=" + this.applyAnimationCost + ", hasGuest=" + this.hasGuest + ", hasExtra=" + this.hasExtra + ")";
    }

    public /* synthetic */ SquareLoadObjectStatistics(String str, ObjectType objectType, long j3, long j16, boolean z16, long j17, long j18, long j19, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, objectType, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? 0L : j17, (i3 & 64) != 0 ? 0L : j18, (i3 & 128) != 0 ? 0L : j19, (i3 & 256) != 0 ? false : z17, (i3 & 512) != 0 ? false : z18);
    }
}

package com.tencent.zplan.world.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.live2.impl.V2TXLiveDefInner;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bH\u00c6\u0003J=\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\b\u0010-\u001a\u00020.H\u0016J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017\u00a8\u00064"}, d2 = {"Lcom/tencent/zplan/world/model/ZPlanWorld;", "Landroid/os/Parcelable;", "worldID", "", "worldWidth", "worldHeight", "scene", "surface", "Landroid/view/Surface;", "(IIIILandroid/view/Surface;)V", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getCountDownLatch", "()Ljava/util/concurrent/CountDownLatch;", "setCountDownLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "renderHashSet", "", "getRenderHashSet", "()Ljava/util/Set;", "getScene", "()I", "setScene", "(I)V", "getSurface", "()Landroid/view/Surface;", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "(Landroid/view/Surface;)V", "getWorldHeight", "setWorldHeight", "getWorldID", "getWorldWidth", "setWorldWidth", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class ZPlanWorld implements Parcelable {
    public static final Parcelable.Creator<ZPlanWorld> CREATOR = new a();

    @Nullable
    private CountDownLatch countDownLatch;

    @NotNull
    private final Set<Integer> renderHashSet;
    private int scene;

    @Nullable
    private Surface surface;
    private int worldHeight;
    private final int worldID;
    private int worldWidth;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a implements Parcelable.Creator<ZPlanWorld> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanWorld createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanWorld(in5.readInt(), in5.readInt(), in5.readInt(), in5.readInt(), (Surface) in5.readParcelable(ZPlanWorld.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanWorld[] newArray(int i3) {
            return new ZPlanWorld[i3];
        }
    }

    public ZPlanWorld(int i3, int i16, int i17, int i18, @Nullable Surface surface) {
        this.worldID = i3;
        this.worldWidth = i16;
        this.worldHeight = i17;
        this.scene = i18;
        this.surface = surface;
        this.countDownLatch = new CountDownLatch(1);
        this.renderHashSet = new LinkedHashSet();
    }

    public static /* synthetic */ ZPlanWorld copy$default(ZPlanWorld zPlanWorld, int i3, int i16, int i17, int i18, Surface surface, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = zPlanWorld.worldID;
        }
        if ((i19 & 2) != 0) {
            i16 = zPlanWorld.worldWidth;
        }
        int i26 = i16;
        if ((i19 & 4) != 0) {
            i17 = zPlanWorld.worldHeight;
        }
        int i27 = i17;
        if ((i19 & 8) != 0) {
            i18 = zPlanWorld.scene;
        }
        int i28 = i18;
        if ((i19 & 16) != 0) {
            surface = zPlanWorld.surface;
        }
        return zPlanWorld.copy(i3, i26, i27, i28, surface);
    }

    /* renamed from: component1, reason: from getter */
    public final int getWorldID() {
        return this.worldID;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWorldWidth() {
        return this.worldWidth;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWorldHeight() {
        return this.worldHeight;
    }

    /* renamed from: component4, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Surface getSurface() {
        return this.surface;
    }

    @NotNull
    public final ZPlanWorld copy(int worldID, int worldWidth, int worldHeight, int scene, @Nullable Surface surface) {
        return new ZPlanWorld(worldID, worldWidth, worldHeight, scene, surface);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanWorld) {
                ZPlanWorld zPlanWorld = (ZPlanWorld) other;
                if (this.worldID != zPlanWorld.worldID || this.worldWidth != zPlanWorld.worldWidth || this.worldHeight != zPlanWorld.worldHeight || this.scene != zPlanWorld.scene || !Intrinsics.areEqual(this.surface, zPlanWorld.surface)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final CountDownLatch getCountDownLatch() {
        return this.countDownLatch;
    }

    @NotNull
    public final Set<Integer> getRenderHashSet() {
        return this.renderHashSet;
    }

    public final int getScene() {
        return this.scene;
    }

    @Nullable
    public final Surface getSurface() {
        return this.surface;
    }

    public final int getWorldHeight() {
        return this.worldHeight;
    }

    public final int getWorldID() {
        return this.worldID;
    }

    public final int getWorldWidth() {
        return this.worldWidth;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((((this.worldID * 31) + this.worldWidth) * 31) + this.worldHeight) * 31) + this.scene) * 31;
        Surface surface = this.surface;
        if (surface != null) {
            i3 = surface.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    public final void setCountDownLatch(@Nullable CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    public final void setSurface(@Nullable Surface surface) {
        this.surface = surface;
    }

    public final void setWorldHeight(int i3) {
        this.worldHeight = i3;
    }

    public final void setWorldWidth(int i3) {
        this.worldWidth = i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanWorld(worldID=" + this.worldID + ", worldWidth=" + this.worldWidth + ", worldHeight=" + this.worldHeight + ", scene=" + this.scene + ", surface=" + this.surface + ", renderHashSet=" + this.renderHashSet.size() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.worldID);
        parcel.writeInt(this.worldWidth);
        parcel.writeInt(this.worldHeight);
        parcel.writeInt(this.scene);
        parcel.writeParcelable(this.surface, flags);
    }

    public /* synthetic */ ZPlanWorld(int i3, int i16, int i17, int i18, Surface surface, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i19 & 2) != 0 ? -1 : i16, (i19 & 4) != 0 ? -1 : i17, (i19 & 8) != 0 ? 0 : i18, (i19 & 16) != 0 ? null : surface);
    }
}

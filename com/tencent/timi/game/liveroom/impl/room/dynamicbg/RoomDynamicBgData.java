package com.tencent.timi.game.liveroom.impl.room.dynamicbg;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "b", "()Landroid/graphics/Bitmap;", "topBitmap", "bottomBitmap", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.dynamicbg.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class RoomDynamicBgData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bitmap topBitmap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bitmap bottomBitmap;

    public RoomDynamicBgData(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        this.topBitmap = bitmap;
        this.bottomBitmap = bitmap2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bitmap getBottomBitmap() {
        return this.bottomBitmap;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bitmap getTopBitmap() {
        return this.topBitmap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomDynamicBgData)) {
            return false;
        }
        RoomDynamicBgData roomDynamicBgData = (RoomDynamicBgData) other;
        if (Intrinsics.areEqual(this.topBitmap, roomDynamicBgData.topBitmap) && Intrinsics.areEqual(this.bottomBitmap, roomDynamicBgData.bottomBitmap)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Bitmap bitmap = this.topBitmap;
        int i3 = 0;
        if (bitmap == null) {
            hashCode = 0;
        } else {
            hashCode = bitmap.hashCode();
        }
        int i16 = hashCode * 31;
        Bitmap bitmap2 = this.bottomBitmap;
        if (bitmap2 != null) {
            i3 = bitmap2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "RoomDynamicBgData(topBitmap=" + this.topBitmap + ", bottomBitmap=" + this.bottomBitmap + ")";
    }
}

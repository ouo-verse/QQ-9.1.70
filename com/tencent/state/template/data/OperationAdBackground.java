package com.tencent.state.template.data;

import android.graphics.Rect;
import com.tencent.state.map.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/template/data/OperationAdBackground;", "", "location", "Lcom/tencent/state/map/Location;", "src", "", "(Lcom/tencent/state/map/Location;Ljava/lang/String;)V", "getLocation", "()Lcom/tencent/state/map/Location;", "getSrc", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "getItemPosition", "Landroid/graphics/Rect;", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class OperationAdBackground {
    private final Location location;
    private final String src;

    public OperationAdBackground(Location location, String src) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(src, "src");
        this.location = location;
        this.src = src;
    }

    /* renamed from: component1, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    public final OperationAdBackground copy(Location location, String src) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(src, "src");
        return new OperationAdBackground(location, src);
    }

    public final Rect getItemPosition() {
        return new Rect(this.location.getX(), this.location.getY(), this.location.getX() + this.location.getWidth(), this.location.getY() + this.location.getHeight());
    }

    public final Location getLocation() {
        return this.location;
    }

    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        Location location = this.location;
        int hashCode = (location != null ? location.hashCode() : 0) * 31;
        String str = this.src;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "OperationAdBackground(location=" + this.location + ", src=" + this.src + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationAdBackground)) {
            return false;
        }
        OperationAdBackground operationAdBackground = (OperationAdBackground) other;
        return Intrinsics.areEqual(this.location, operationAdBackground.location) && Intrinsics.areEqual(this.src, operationAdBackground.src);
    }

    public static /* synthetic */ OperationAdBackground copy$default(OperationAdBackground operationAdBackground, Location location, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            location = operationAdBackground.location;
        }
        if ((i3 & 2) != 0) {
            str = operationAdBackground.src;
        }
        return operationAdBackground.copy(location, str);
    }
}

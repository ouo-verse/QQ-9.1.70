package com.tencent.state.template.data;

import android.graphics.Rect;
import com.tencent.state.map.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/template/data/OperationAdVideo;", "", "location", "Lcom/tencent/state/map/Location;", "url", "", "(Lcom/tencent/state/map/Location;Ljava/lang/String;)V", "getLocation", "()Lcom/tencent/state/map/Location;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "getItemPosition", "Landroid/graphics/Rect;", "hashCode", "", "isInViewPort", "viewPort", "offsetX", "offsetY", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class OperationAdVideo {
    private final Location location;
    private final String url;

    public OperationAdVideo(Location location, String url) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(url, "url");
        this.location = location;
        this.url = url;
    }

    /* renamed from: component1, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final OperationAdVideo copy(Location location, String url) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(url, "url");
        return new OperationAdVideo(location, url);
    }

    public final Rect getItemPosition() {
        return new Rect(this.location.getX(), this.location.getY(), this.location.getX() + this.location.getWidth(), this.location.getY() + this.location.getHeight());
    }

    public final Location getLocation() {
        return this.location;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Location location = this.location;
        int hashCode = (location != null ? location.hashCode() : 0) * 31;
        String str = this.url;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isInViewPort(Rect viewPort, int offsetX, int offsetY) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        Rect itemPosition = getItemPosition();
        int i3 = itemPosition.left + offsetX;
        int i16 = itemPosition.top + offsetY;
        return viewPort.intersects(i3, i16, itemPosition.width() + i3, itemPosition.height() + i16);
    }

    public String toString() {
        return "OperationAdVideo(location=" + this.location + ", url=" + this.url + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationAdVideo)) {
            return false;
        }
        OperationAdVideo operationAdVideo = (OperationAdVideo) other;
        return Intrinsics.areEqual(this.location, operationAdVideo.location) && Intrinsics.areEqual(this.url, operationAdVideo.url);
    }

    public static /* synthetic */ OperationAdVideo copy$default(OperationAdVideo operationAdVideo, Location location, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            location = operationAdVideo.location;
        }
        if ((i3 & 2) != 0) {
            str = operationAdVideo.url;
        }
        return operationAdVideo.copy(location, str);
    }

    public static /* synthetic */ boolean isInViewPort$default(OperationAdVideo operationAdVideo, Rect rect, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return operationAdVideo.isInViewPort(rect, i3, i16);
    }
}

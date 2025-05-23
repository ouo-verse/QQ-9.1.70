package com.tencent.state.template.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.state.data.Image;
import com.tencent.state.map.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/template/data/BuildingDecorator;", "Lcom/tencent/state/template/data/Decorator;", "jumpType", "", WadlProxyConsts.KEY_JUMP_URL, "", "img", "Lcom/tencent/state/data/Image;", "loc", "Lcom/tencent/state/map/Location;", "(ILjava/lang/String;Lcom/tencent/state/data/Image;Lcom/tencent/state/map/Location;)V", "getImg", "()Lcom/tencent/state/data/Image;", "getJumpType", "()I", "getJumpUrl", "()Ljava/lang/String;", "getLoc", "()Lcom/tencent/state/map/Location;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class BuildingDecorator extends Decorator {
    private final Image img;
    private final int jumpType;
    private final String jumpUrl;
    private final Location loc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildingDecorator(int i3, String str, Image img, Location loc) {
        super(img, loc, null);
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(loc, "loc");
        this.jumpType = i3;
        this.jumpUrl = str;
        this.img = img;
        this.loc = loc;
    }

    /* renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final Image getImg() {
        return this.img;
    }

    /* renamed from: component4, reason: from getter */
    public final Location getLoc() {
        return this.loc;
    }

    public final BuildingDecorator copy(int jumpType, String jumpUrl, Image img, Location loc) {
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(loc, "loc");
        return new BuildingDecorator(jumpType, jumpUrl, img, loc);
    }

    public final Image getImg() {
        return this.img;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Location getLoc() {
        return this.loc;
    }

    public int hashCode() {
        int i3 = this.jumpType * 31;
        String str = this.jumpUrl;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        Image image = this.img;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        Location location = this.loc;
        return hashCode2 + (location != null ? location.hashCode() : 0);
    }

    public String toString() {
        return "BuildingDecorator(jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", img=" + this.img + ", loc=" + this.loc + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildingDecorator)) {
            return false;
        }
        BuildingDecorator buildingDecorator = (BuildingDecorator) other;
        return this.jumpType == buildingDecorator.jumpType && Intrinsics.areEqual(this.jumpUrl, buildingDecorator.jumpUrl) && Intrinsics.areEqual(this.img, buildingDecorator.img) && Intrinsics.areEqual(this.loc, buildingDecorator.loc);
    }

    public static /* synthetic */ BuildingDecorator copy$default(BuildingDecorator buildingDecorator, int i3, String str, Image image, Location location, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = buildingDecorator.jumpType;
        }
        if ((i16 & 2) != 0) {
            str = buildingDecorator.jumpUrl;
        }
        if ((i16 & 4) != 0) {
            image = buildingDecorator.img;
        }
        if ((i16 & 8) != 0) {
            location = buildingDecorator.loc;
        }
        return buildingDecorator.copy(i3, str, image, location);
    }
}

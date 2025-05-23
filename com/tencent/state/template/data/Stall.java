package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.Image;
import com.tencent.state.map.Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/template/data/Stall;", "", "id", "", "tables", "", "location", "Lcom/tencent/state/map/Location;", "image", "Lcom/tencent/state/data/Image;", "categoryId", "", "(JLjava/util/List;Lcom/tencent/state/map/Location;Lcom/tencent/state/data/Image;Ljava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getId", "()J", "getImage", "()Lcom/tencent/state/data/Image;", "getLocation", "()Lcom/tencent/state/map/Location;", "getTables", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Stall {
    private final String categoryId;
    private final long id;
    private final Image image;
    private final Location location;
    private final List<Long> tables;

    public Stall(long j3, List<Long> tables, Location location, Image image, String categoryId) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.id = j3;
        this.tables = tables;
        this.location = location;
        this.image = image;
        this.categoryId = categoryId;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.tables;
    }

    /* renamed from: component3, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* renamed from: component4, reason: from getter */
    public final Image getImage() {
        return this.image;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Stall copy(long id5, List<Long> tables, Location location, Image image, String categoryId) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return new Stall(id5, tables, location, image, categoryId);
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final long getId() {
        return this.id;
    }

    public final Image getImage() {
        return this.image;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final List<Long> getTables() {
        return this.tables;
    }

    public int hashCode() {
        int a16 = c.a(this.id) * 31;
        List<Long> list = this.tables;
        int hashCode = (a16 + (list != null ? list.hashCode() : 0)) * 31;
        Location location = this.location;
        int hashCode2 = (hashCode + (location != null ? location.hashCode() : 0)) * 31;
        Image image = this.image;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        String str = this.categoryId;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Stall(id=" + this.id + ", tables=" + this.tables + ", location=" + this.location + ", image=" + this.image + ", categoryId=" + this.categoryId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stall)) {
            return false;
        }
        Stall stall = (Stall) other;
        return this.id == stall.id && Intrinsics.areEqual(this.tables, stall.tables) && Intrinsics.areEqual(this.location, stall.location) && Intrinsics.areEqual(this.image, stall.image) && Intrinsics.areEqual(this.categoryId, stall.categoryId);
    }

    public static /* synthetic */ Stall copy$default(Stall stall, long j3, List list, Location location, Image image, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = stall.id;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            list = stall.tables;
        }
        List list2 = list;
        if ((i3 & 4) != 0) {
            location = stall.location;
        }
        Location location2 = location;
        if ((i3 & 8) != 0) {
            image = stall.image;
        }
        Image image2 = image;
        if ((i3 & 16) != 0) {
            str = stall.categoryId;
        }
        return stall.copy(j16, list2, location2, image2, str);
    }
}

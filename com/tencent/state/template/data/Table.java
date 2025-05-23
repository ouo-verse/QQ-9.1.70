package com.tencent.state.template.data;

import android.graphics.Point;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.Image;
import com.tencent.state.map.Location;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0007H\u00c6\u0003J\t\u0010M\u001a\u00020\tH\u00c6\u0003J\t\u0010N\u001a\u00020\u000bH\u00c6\u0003J\t\u0010O\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010Q\u001a\u00020\u0010H\u00c6\u0003Je\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010S\u001a\u00020$2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010U\u001a\u00020VH\u00d6\u0001J\t\u0010W\u001a\u00020XH\u00d6\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010 \u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u0011\u0010#\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010&R\u0011\u0010,\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010&R\u001c\u0010.\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b7\u00100R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0019R\u001c\u00109\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006Y"}, d2 = {"Lcom/tencent/state/template/data/Table;", "", "id", "", "leftTableId", "rightTableId", "location", "Lcom/tencent/state/map/Location;", "image", "Lcom/tencent/state/data/Image;", "bubbleCoordinate", "Landroid/graphics/Point;", "prizeCoordinate", "stall", "Lcom/tencent/state/template/data/Stall;", "tableType", "Lcom/tencent/state/template/data/TableType;", "(JJJLcom/tencent/state/map/Location;Lcom/tencent/state/data/Image;Landroid/graphics/Point;Landroid/graphics/Point;Lcom/tencent/state/template/data/Stall;Lcom/tencent/state/template/data/TableType;)V", "brand", "Lcom/tencent/state/template/data/Decorator;", "getBrand", "()Lcom/tencent/state/template/data/Decorator;", "setBrand", "(Lcom/tencent/state/template/data/Decorator;)V", "getBubbleCoordinate", "()Landroid/graphics/Point;", "expect", "getExpect", "setExpect", "expectWithEdit", "getExpectWithEdit", "setExpectWithEdit", "expectWithShare", "getExpectWithShare", "setExpectWithShare", "hasNeighbor", "", "getHasNeighbor", "()Z", "getId", "()J", "getImage", "()Lcom/tencent/state/data/Image;", "isEmpty", "isLeft", "isRight", "leftTable", "getLeftTable", "()Lcom/tencent/state/template/data/Table;", "setLeftTable", "(Lcom/tencent/state/template/data/Table;)V", "getLeftTableId", "getLocation", "()Lcom/tencent/state/map/Location;", "neighbor", "getNeighbor", "getPrizeCoordinate", "rightTable", "getRightTable", "setRightTable", "getRightTableId", "getStall", "()Lcom/tencent/state/template/data/Stall;", "setStall", "(Lcom/tencent/state/template/data/Stall;)V", "getTableType", "()Lcom/tencent/state/template/data/TableType;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "getUser", "()Lcom/tencent/state/template/data/User;", "setUser", "(Lcom/tencent/state/template/data/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Table {
    private Decorator brand;
    private final Point bubbleCoordinate;
    private Decorator expect;
    private Decorator expectWithEdit;
    private Decorator expectWithShare;
    private final long id;
    private final Image image;
    private Table leftTable;
    private final long leftTableId;
    private final Location location;
    private final Point prizeCoordinate;
    private Table rightTable;
    private final long rightTableId;
    private Stall stall;
    private final TableType tableType;
    private User user;

    public Table(long j3, long j16, long j17, Location location, Image image, Point bubbleCoordinate, Point prizeCoordinate, Stall stall, TableType tableType) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bubbleCoordinate, "bubbleCoordinate");
        Intrinsics.checkNotNullParameter(prizeCoordinate, "prizeCoordinate");
        Intrinsics.checkNotNullParameter(tableType, "tableType");
        this.id = j3;
        this.leftTableId = j16;
        this.rightTableId = j17;
        this.location = location;
        this.image = image;
        this.bubbleCoordinate = bubbleCoordinate;
        this.prizeCoordinate = prizeCoordinate;
        this.stall = stall;
        this.tableType = tableType;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLeftTableId() {
        return this.leftTableId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRightTableId() {
        return this.rightTableId;
    }

    /* renamed from: component4, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* renamed from: component5, reason: from getter */
    public final Image getImage() {
        return this.image;
    }

    /* renamed from: component6, reason: from getter */
    public final Point getBubbleCoordinate() {
        return this.bubbleCoordinate;
    }

    /* renamed from: component7, reason: from getter */
    public final Point getPrizeCoordinate() {
        return this.prizeCoordinate;
    }

    /* renamed from: component8, reason: from getter */
    public final Stall getStall() {
        return this.stall;
    }

    /* renamed from: component9, reason: from getter */
    public final TableType getTableType() {
        return this.tableType;
    }

    public final Table copy(long id5, long leftTableId, long rightTableId, Location location, Image image, Point bubbleCoordinate, Point prizeCoordinate, Stall stall, TableType tableType) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bubbleCoordinate, "bubbleCoordinate");
        Intrinsics.checkNotNullParameter(prizeCoordinate, "prizeCoordinate");
        Intrinsics.checkNotNullParameter(tableType, "tableType");
        return new Table(id5, leftTableId, rightTableId, location, image, bubbleCoordinate, prizeCoordinate, stall, tableType);
    }

    public final Decorator getBrand() {
        return this.brand;
    }

    public final Point getBubbleCoordinate() {
        return this.bubbleCoordinate;
    }

    public final Decorator getExpect() {
        return this.expect;
    }

    public final Decorator getExpectWithEdit() {
        return this.expectWithEdit;
    }

    public final Decorator getExpectWithShare() {
        return this.expectWithShare;
    }

    public final boolean getHasNeighbor() {
        return getNeighbor() != null;
    }

    public final long getId() {
        return this.id;
    }

    public final Image getImage() {
        return this.image;
    }

    public final Table getLeftTable() {
        return this.leftTable;
    }

    public final long getLeftTableId() {
        return this.leftTableId;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final Table getNeighbor() {
        Table table = this.leftTable;
        return table != null ? table : this.rightTable;
    }

    public final Point getPrizeCoordinate() {
        return this.prizeCoordinate;
    }

    public final Table getRightTable() {
        return this.rightTable;
    }

    public final long getRightTableId() {
        return this.rightTableId;
    }

    public final Stall getStall() {
        return this.stall;
    }

    public final TableType getTableType() {
        return this.tableType;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int a16 = ((((c.a(this.id) * 31) + c.a(this.leftTableId)) * 31) + c.a(this.rightTableId)) * 31;
        Location location = this.location;
        int hashCode = (a16 + (location != null ? location.hashCode() : 0)) * 31;
        Image image = this.image;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        Point point = this.bubbleCoordinate;
        int hashCode3 = (hashCode2 + (point != null ? point.hashCode() : 0)) * 31;
        Point point2 = this.prizeCoordinate;
        int hashCode4 = (hashCode3 + (point2 != null ? point2.hashCode() : 0)) * 31;
        Stall stall = this.stall;
        int hashCode5 = (hashCode4 + (stall != null ? stall.hashCode() : 0)) * 31;
        TableType tableType = this.tableType;
        return hashCode5 + (tableType != null ? tableType.hashCode() : 0);
    }

    public final boolean isEmpty() {
        return this.user == null;
    }

    public final boolean isLeft() {
        return this.leftTable == null && this.rightTable != null;
    }

    public final boolean isRight() {
        return this.leftTable != null && this.rightTable == null;
    }

    public final void setBrand(Decorator decorator) {
        this.brand = decorator;
    }

    public final void setExpect(Decorator decorator) {
        this.expect = decorator;
    }

    public final void setExpectWithEdit(Decorator decorator) {
        this.expectWithEdit = decorator;
    }

    public final void setExpectWithShare(Decorator decorator) {
        this.expectWithShare = decorator;
    }

    public final void setLeftTable(Table table) {
        this.leftTable = table;
    }

    public final void setRightTable(Table table) {
        this.rightTable = table;
    }

    public final void setStall(Stall stall) {
        this.stall = stall;
    }

    public final void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "Table(id=" + this.id + ", leftTableId=" + this.leftTableId + ", rightTableId=" + this.rightTableId + ", location=" + this.location + ", image=" + this.image + ", bubbleCoordinate=" + this.bubbleCoordinate + ", prizeCoordinate=" + this.prizeCoordinate + ", stall=" + this.stall + ", tableType=" + this.tableType + ")";
    }

    public /* synthetic */ Table(long j3, long j16, long j17, Location location, Image image, Point point, Point point2, Stall stall, TableType tableType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, j17, location, image, point, (i3 & 64) != 0 ? new Point() : point2, (i3 & 128) != 0 ? null : stall, (i3 & 256) != 0 ? TableType.TABLE_TYPE_NOT_FIXED : tableType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Table)) {
            return false;
        }
        Table table = (Table) other;
        return this.id == table.id && this.leftTableId == table.leftTableId && this.rightTableId == table.rightTableId && Intrinsics.areEqual(this.location, table.location) && Intrinsics.areEqual(this.image, table.image) && Intrinsics.areEqual(this.bubbleCoordinate, table.bubbleCoordinate) && Intrinsics.areEqual(this.prizeCoordinate, table.prizeCoordinate) && Intrinsics.areEqual(this.stall, table.stall) && Intrinsics.areEqual(this.tableType, table.tableType);
    }
}

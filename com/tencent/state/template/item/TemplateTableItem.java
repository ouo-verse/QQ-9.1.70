package com.tencent.state.template.item;

import android.graphics.Rect;
import com.tencent.state.map.MapItem;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.Table;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/template/item/TemplateTableItem;", "Lcom/tencent/state/map/MapItem;", "table", "Lcom/tencent/state/template/data/Table;", "extra", "", "itemType", "", "(Lcom/tencent/state/template/data/Table;Ljava/lang/Object;I)V", "brand", "Lcom/tencent/state/template/data/Decorator;", "getBrand", "()Lcom/tencent/state/template/data/Decorator;", "expect", "getExpect", "expectWithEdit", "getExpectWithEdit", "expectWithShare", "getExpectWithShare", "getExtra", "()Ljava/lang/Object;", "isFixed", "", "()Z", "getTable", "()Lcom/tencent/state/template/data/Table;", "getItemViewLocation", "Landroid/graphics/Rect;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateTableItem extends MapItem {
    private final Decorator brand;
    private final Decorator expect;
    private final Decorator expectWithEdit;
    private final Decorator expectWithShare;
    private final Object extra;
    private final Table table;

    public /* synthetic */ TemplateTableItem(Table table, Object obj, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(table, (i16 & 2) != 0 ? null : obj, (i16 & 4) != 0 ? 2 : i3);
    }

    public final Decorator getBrand() {
        return this.brand;
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

    public final Object getExtra() {
        return this.extra;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return new Rect(getLocation().getX(), getLocation().getY(), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    public final Table getTable() {
        return this.table;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed */
    public boolean getIsFixed() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateTableItem(Table table, Object obj, int i3) {
        super(i3, String.valueOf(table.getId()), false, table.getLocation());
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.extra = obj;
        this.brand = table.getBrand();
        this.expect = table.getExpect();
        this.expectWithShare = table.getExpectWithShare();
        this.expectWithEdit = table.getExpectWithEdit();
    }
}

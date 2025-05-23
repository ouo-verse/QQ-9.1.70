package com.tencent.state.template.item;

import android.graphics.Rect;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.template.data.Stall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/template/item/TemplateStallItem;", "Lcom/tencent/state/map/MapItem;", "stall", "Lcom/tencent/state/template/data/Stall;", "extra", "", "(Lcom/tencent/state/template/data/Stall;Ljava/lang/Object;)V", "getExtra", "()Ljava/lang/Object;", "isFixed", "", "()Z", "getStall", "()Lcom/tencent/state/template/data/Stall;", "getItemViewLocation", "Landroid/graphics/Rect;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateStallItem extends MapItem {
    private final Object extra;
    private final boolean isFixed;
    private final Stall stall;

    public /* synthetic */ TemplateStallItem(Stall stall, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(stall, (i3 & 2) != 0 ? null : obj);
    }

    public final Object getExtra() {
        return this.extra;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return new Rect(getLocation().getX(), getLocation().getY(), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    public final Stall getStall() {
        return this.stall;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateStallItem(Stall stall, Object obj) {
        super(4, String.valueOf(stall.getId()), false, new Location(stall.getLocation().getX(), stall.getLocation().getY(), stall.getImage().getSize().getWidth(), stall.getImage().getSize().getHeight(), 0, 0, 48, null));
        Intrinsics.checkNotNullParameter(stall, "stall");
        this.stall = stall;
        this.extra = obj;
        this.isFixed = true;
    }
}

package com.tencent.state.template.item;

import android.graphics.Rect;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.template.data.Decorator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/template/item/TemplateDecoratorItem;", "Lcom/tencent/state/map/MapItem;", "decorator", "Lcom/tencent/state/template/data/Decorator;", "extra", "", "(Lcom/tencent/state/template/data/Decorator;Ljava/lang/Object;)V", "getDecorator", "()Lcom/tencent/state/template/data/Decorator;", "getExtra", "()Ljava/lang/Object;", "isFixed", "", "()Z", "getItemViewLocation", "Landroid/graphics/Rect;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateDecoratorItem extends MapItem {
    private final Decorator decorator;
    private final Object extra;
    private final boolean isFixed;

    public /* synthetic */ TemplateDecoratorItem(Decorator decorator, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(decorator, (i3 & 2) != 0 ? null : obj);
    }

    public final Decorator getDecorator() {
        return this.decorator;
    }

    public final Object getExtra() {
        return this.extra;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return new Rect(getLocation().getX(), getLocation().getY(), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TemplateDecoratorItem(Decorator decorator, Object obj) {
        super(3, r0, false, new Location(decorator.getLocation().getX(), decorator.getLocation().getY(), decorator.getImage().getSize().getWidth(), decorator.getImage().getSize().getHeight(), 0, 0, 48, null));
        Intrinsics.checkNotNullParameter(decorator, "decorator");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        this.decorator = decorator;
        this.extra = obj;
        this.isFixed = true;
    }
}

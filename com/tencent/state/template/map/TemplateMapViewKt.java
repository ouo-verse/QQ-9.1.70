package com.tencent.state.template.map;

import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.item.TemplateTableItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u00a8\u0006\u0004"}, d2 = {"isMeSeated", "", "Lcom/tencent/state/template/map/TemplateMapView;", "isRoomFull", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TemplateMapViewKt {
    public static final boolean isRoomFull(TemplateMapView<?> templateMapView) {
        MapAdapter adapter;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (templateMapView != null && (adapter = templateMapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.template.map.TemplateMapViewKt$isRoomFull$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, MapItem mapItem) {
                    if (mapItem instanceof TemplateTableItem) {
                        Ref.BooleanRef.this.element = false;
                    }
                }
            });
        }
        return booleanRef.element;
    }

    public static final boolean isMeSeated(TemplateMapView<?> templateMapView) {
        MapAdapter adapter;
        MapAdapter adapter2;
        MapItem itemData = (templateMapView == null || (adapter = templateMapView.getAdapter()) == null) ? null : adapter.getItemData((templateMapView == null || (adapter2 = templateMapView.getAdapter()) == null) ? -1 : adapter2.getMeIndex());
        return ((TemplateAvatarItem) (itemData instanceof TemplateAvatarItem ? itemData : null)) != null;
    }
}

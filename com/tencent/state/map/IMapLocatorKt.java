package com.tencent.state.map;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002\u001a.\u0010\r\u001a\u00020\b*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006\u00a8\u0006\u0012"}, d2 = {"findIndexesInViewPort", "", "", "Lcom/tencent/state/map/IMapLocator;", "findIndexesInViewPortPercentile", "ratio", "", "isInViewPort", "", "location", "Landroid/graphics/Rect;", "offsetX", "offsetY", "isInViewPortPercentile", "percent", "updateViewPort", "", "zoomRatio", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class IMapLocatorKt {
    public static final List<Integer> findIndexesInViewPort(final IMapLocator findIndexesInViewPort) {
        Intrinsics.checkNotNullParameter(findIndexesInViewPort, "$this$findIndexesInViewPort");
        final ArrayList arrayList = new ArrayList();
        Rect itemPosition = findIndexesInViewPort.getItemPosition(findIndexesInViewPort.getCenterIndex());
        int mapWidth = (findIndexesInViewPort.getMapWidth() - itemPosition.width()) / 2;
        int mapHeight = (findIndexesInViewPort.getMapHeight() - itemPosition.height()) / 2;
        final int i3 = mapWidth - itemPosition.left;
        final int i16 = mapHeight - itemPosition.top;
        findIndexesInViewPort.forEachLocation(new Function2<Integer, Rect, Unit>() { // from class: com.tencent.state.map.IMapLocatorKt$findIndexesInViewPort$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Rect rect) {
                invoke(num.intValue(), rect);
                return Unit.INSTANCE;
            }

            public final void invoke(int i17, Rect location) {
                Intrinsics.checkNotNullParameter(location, "location");
                if (IMapLocatorKt.isInViewPort(IMapLocator.this, location, i3, i16) || i17 == IMapLocator.this.getCenterIndex()) {
                    arrayList.add(Integer.valueOf(i17));
                }
            }
        });
        return arrayList;
    }

    public static final List<Integer> findIndexesInViewPortPercentile(final IMapLocator findIndexesInViewPortPercentile, final float f16) {
        Intrinsics.checkNotNullParameter(findIndexesInViewPortPercentile, "$this$findIndexesInViewPortPercentile");
        final ArrayList arrayList = new ArrayList();
        Rect itemPosition = findIndexesInViewPortPercentile.getItemPosition(findIndexesInViewPortPercentile.getCenterIndex());
        int mapWidth = (findIndexesInViewPortPercentile.getMapWidth() - itemPosition.width()) / 2;
        int mapHeight = (findIndexesInViewPortPercentile.getMapHeight() - itemPosition.height()) / 2;
        final int i3 = mapWidth - itemPosition.left;
        final int i16 = mapHeight - itemPosition.top;
        findIndexesInViewPortPercentile.forEachLocation(new Function2<Integer, Rect, Unit>() { // from class: com.tencent.state.map.IMapLocatorKt$findIndexesInViewPortPercentile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Rect rect) {
                invoke(num.intValue(), rect);
                return Unit.INSTANCE;
            }

            public final void invoke(int i17, Rect location) {
                Intrinsics.checkNotNullParameter(location, "location");
                if (IMapLocatorKt.isInViewPortPercentile(IMapLocator.this, location, f16, i3, i16) || i17 == IMapLocator.this.getCenterIndex()) {
                    arrayList.add(Integer.valueOf(i17));
                }
            }
        });
        return arrayList;
    }

    public static final boolean isInViewPort(IMapLocator isInViewPort, Rect location, int i3, int i16) {
        Intrinsics.checkNotNullParameter(isInViewPort, "$this$isInViewPort");
        Intrinsics.checkNotNullParameter(location, "location");
        int i17 = location.left + i3;
        int i18 = location.top + i16;
        return isInViewPort.getViewPort().intersects(i17, i18, location.width() + i17, location.height() + i18);
    }

    public static final boolean isInViewPortPercentile(IMapLocator isInViewPortPercentile, Rect location, float f16, int i3, int i16) {
        Intrinsics.checkNotNullParameter(isInViewPortPercentile, "$this$isInViewPortPercentile");
        Intrinsics.checkNotNullParameter(location, "location");
        int i17 = location.left + i3;
        int i18 = location.top + i16;
        int width = location.width();
        int height = location.height();
        int i19 = isInViewPortPercentile.getViewPort().left;
        int i26 = isInViewPortPercentile.getViewPort().right;
        int i27 = isInViewPortPercentile.getViewPort().top;
        int i28 = isInViewPortPercentile.getViewPort().bottom;
        if (isInViewPortPercentile.getViewPort().left < isInViewPortPercentile.getViewPort().right && isInViewPortPercentile.getViewPort().top < isInViewPortPercentile.getViewPort().bottom) {
            float f17 = i19 - i17;
            float f18 = width * f16;
            if (f17 <= f18) {
                float f19 = f16 * height;
                if (i27 - i18 <= f19 && (i17 + width) - i26 <= f18 && (i18 + height) - i28 <= f19) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void updateViewPort(IMapLocator updateViewPort, float f16) {
        Intrinsics.checkNotNullParameter(updateViewPort, "$this$updateViewPort");
        float mapWidth = updateViewPort.getMapWidth() * f16;
        float mapHeight = updateViewPort.getMapHeight() * f16;
        int width = updateViewPort.getViewPort().width();
        int height = updateViewPort.getViewPort().height();
        float f17 = 2;
        int i3 = (int) ((mapWidth - width) / f17);
        int i16 = (int) ((mapHeight - height) / f17);
        updateViewPort.getViewPort().set(i3, i16, width + i3, height + i16);
    }

    public static /* synthetic */ boolean isInViewPort$default(IMapLocator iMapLocator, Rect rect, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        return isInViewPort(iMapLocator, rect, i3, i16);
    }

    public static /* synthetic */ boolean isInViewPortPercentile$default(IMapLocator iMapLocator, Rect rect, float f16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i3 = 0;
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        return isInViewPortPercentile(iMapLocator, rect, f16, i3, i16);
    }
}

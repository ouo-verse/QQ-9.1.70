package com.tencent.state.library.holder;

import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"adjustHitAreaLocation", "", "Landroid/view/View;", "itemLocation", "Landroid/graphics/Rect;", "avatarLocation", "Lcom/tencent/state/map/Location;", "data", "Lcom/tencent/state/map/MapItem;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class ViewHolderExtensionsKt {
    public static final void adjustHitAreaLocation(View adjustHitAreaLocation, final Rect itemLocation, final Location avatarLocation) {
        Intrinsics.checkNotNullParameter(adjustHitAreaLocation, "$this$adjustHitAreaLocation");
        Intrinsics.checkNotNullParameter(itemLocation, "itemLocation");
        Intrinsics.checkNotNullParameter(avatarLocation, "avatarLocation");
        final int width = (int) (avatarLocation.getWidth() * 0.4d);
        final int height = (int) (avatarLocation.getHeight() * 0.6d);
        ViewExtensionsKt.updateLayoutParams(adjustHitAreaLocation, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.holder.ViewHolderExtensionsKt$adjustHitAreaLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = width;
                receiver.height = height;
                receiver.leftMargin = (avatarLocation.getX() - itemLocation.left) + ((avatarLocation.getWidth() - width) / 2);
                receiver.topMargin = (avatarLocation.getY() - itemLocation.top) + ((avatarLocation.getHeight() - height) / 2);
            }
        });
    }

    public static final void adjustHitAreaLocation(View adjustHitAreaLocation, MapItem data) {
        Intrinsics.checkNotNullParameter(adjustHitAreaLocation, "$this$adjustHitAreaLocation");
        Intrinsics.checkNotNullParameter(data, "data");
        adjustHitAreaLocation(adjustHitAreaLocation, data.getItemViewLocation(), data.getLocation());
    }
}

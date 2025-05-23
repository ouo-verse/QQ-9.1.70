package com.tencent.state.map;

import android.content.Context;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"LIMIT_SMALL_SCREEN_HEIGHT", "", "defaultDetailAvatarConfig", "Lcom/tencent/state/map/AvatarLocationConfig;", "defaultFocusAnimaConfig", "defaultMapConfig", "Lcom/tencent/state/map/MapViewConfig;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapViewConfigKt {
    public static final int LIMIT_SMALL_SCREEN_HEIGHT = 1600;

    public static final AvatarLocationConfig defaultDetailAvatarConfig() {
        Square square = Square.INSTANCE;
        return new AvatarLocationConfig(ViewExtensionsKt.dip((Context) square.getApplication(), 300), ViewExtensionsKt.dip((Context) square.getApplication(), 300), 0, 0, 12, null);
    }

    public static final AvatarLocationConfig defaultFocusAnimaConfig() {
        Square square = Square.INSTANCE;
        return new AvatarLocationConfig(ViewExtensionsKt.dip((Context) square.getApplication(), QidPagView.DESIGN_PAG_WIDTH), ViewExtensionsKt.dip((Context) square.getApplication(), QidPagView.DESIGN_PAG_WIDTH), ViewExtensionsKt.dip((Context) square.getApplication(), 133), ViewExtensionsKt.dip((Context) square.getApplication(), 110));
    }

    public static final MapViewConfig defaultMapConfig() {
        SquareUtil squareUtil = SquareUtil.INSTANCE;
        return new MapViewConfig(SquareUtil.getScreenWidth$default(squareUtil, 0.0f, 1, null), SquareUtil.getScreenHeight$default(squareUtil, 0.0f, 1, null), false, 0, 0, null, null, 124, null);
    }
}

package com.tencent.state.square.detail;

import android.content.Context;
import android.util.Size;
import com.tencent.luggage.wxa.v1.b;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.utils.SquareSwitchUtils;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/detail/DetailAvatarConfig;", "", "()V", "BUBBLE_CONTENT_HEIGHT_DIP", "", "Tag", "", "bubbleContentHeight", "editPageAvatarBottomMargin", "editPageAvatarSize", "defaultDetailConfig", "Lcom/tencent/state/square/detail/DetailAnimaConfig;", "getHeightOutScreen", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailAvatarConfig {
    private static final int BUBBLE_CONTENT_HEIGHT_DIP = 120;
    public static final DetailAvatarConfig INSTANCE;
    private static final String Tag = "DetailAvatarConfig";
    private static final int bubbleContentHeight;
    private static int editPageAvatarBottomMargin;
    private static int editPageAvatarSize;

    static {
        DetailAvatarConfig detailAvatarConfig = new DetailAvatarConfig();
        INSTANCE = detailAvatarConfig;
        Square square = Square.INSTANCE;
        bubbleContentHeight = ViewExtensionsKt.dip((Context) square.getApplication(), 120);
        if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
            editPageAvatarSize = ViewExtensionsKt.dip((Context) square.getApplication(), 300);
            editPageAvatarBottomMargin = ViewExtensionsKt.dip((Context) square.getApplication(), 400);
        } else {
            editPageAvatarSize = ViewExtensionsKt.dip((Context) square.getApplication(), 210);
            editPageAvatarBottomMargin = ViewExtensionsKt.dip((Context) square.getApplication(), 412);
        }
        if (detailAvatarConfig.getHeightOutScreen() > 750) {
            editPageAvatarSize = ViewExtensionsKt.dip((Context) square.getApplication(), 210);
            editPageAvatarBottomMargin = ViewExtensionsKt.dip((Context) square.getApplication(), b.CTRL_INDEX);
        }
    }

    DetailAvatarConfig() {
    }

    public final DetailAnimaConfig defaultDetailConfig() {
        int heightOutScreen = getHeightOutScreen();
        int i3 = editPageAvatarSize;
        Size size = new Size(i3, i3);
        int i16 = editPageAvatarBottomMargin - heightOutScreen;
        Square square = Square.INSTANCE;
        return new DetailAnimaConfig(size, i16, ViewExtensionsKt.dip((Context) square.getApplication(), 300), ViewExtensionsKt.dip((Context) square.getApplication(), 300));
    }

    public final int getHeightOutScreen() {
        int coerceAtLeast;
        int screenHeight$default = SquareUtil.getScreenHeight$default(SquareUtil.INSTANCE, 0.0f, 1, null);
        int i3 = ((editPageAvatarSize + editPageAvatarBottomMargin) + bubbleContentHeight) - screenHeight$default;
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().i(Tag, "out: " + i3 + ", height: " + screenHeight$default);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        return coerceAtLeast;
    }
}

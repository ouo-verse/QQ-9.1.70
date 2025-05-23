package com.tencent.state.square.media.utils;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/media/utils/GLUtils;", "", "()V", "createTextureVertex", "", "width", "", "height", CanvasView.ACTION_RECT, "Lcom/tencent/state/square/media/utils/PointRect;", HippyControllerProps.ARRAY, "createVertex", "switchX", "", HippyTKDListViewAdapter.X, "switchY", "y", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class GLUtils {
    public static final GLUtils INSTANCE = new GLUtils();

    GLUtils() {
    }

    private final float switchX(float x16) {
        return (x16 * 2.0f) - 1.0f;
    }

    private final float switchY(float y16) {
        return (((y16 * 2.0f) - 2.0f) * (-1.0f)) - 1.0f;
    }

    public final float[] createTextureVertex(int width, int height, PointRect rect, float[] array) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(array, "array");
        float f16 = width;
        array[0] = rect.getX() / f16;
        float f17 = height;
        array[1] = rect.getY() / f17;
        array[2] = rect.getX() / f16;
        array[3] = (rect.getY() + rect.getH()) / f17;
        array[4] = (rect.getX() + rect.getW()) / f16;
        array[5] = rect.getY() / f17;
        array[6] = (rect.getX() + rect.getW()) / f16;
        array[7] = (rect.getY() + rect.getH()) / f17;
        return array;
    }

    public final float[] createVertex(int width, int height, PointRect rect, float[] array) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(array, "array");
        float f16 = width;
        array[0] = switchX(rect.getX() / f16);
        float f17 = height;
        array[1] = switchY(rect.getY() / f17);
        array[2] = switchX(rect.getX() / f16);
        array[3] = switchY((rect.getY() + rect.getH()) / f17);
        array[4] = switchX((rect.getX() + rect.getW()) / f16);
        array[5] = switchY(rect.getY() / f17);
        array[6] = switchX((rect.getX() + rect.getW()) / f16);
        array[7] = switchY((rect.getY() + rect.getH()) / f17);
        return array;
    }
}

package l01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.KuiklyRenderView;
import d01.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0000\u001a-\u0010\f\u001a\u00020\n*\u00020\u00052!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u001a\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r*\u00020\u0005\u001a\u0012\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u0012\u0010\u0014\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012\u001a&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000\u001a \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0002\u001a&\u0010 \u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0015H\u0002\u001a\f\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0002\u00a8\u0006\""}, d2 = {"Landroid/view/View;", "Landroid/graphics/Bitmap;", h.F, "", "a", "Landroid/view/ViewGroup;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "child", "", "block", "c", "", "b", "", "touchPoint", "i", "Landroid/view/MotionEvent;", "motionEvent", "k", "", HippyTKDListViewAdapter.X, "y", "parentView", "", "e", "point", "j", "localX", "localY", "slop", "f", "d", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {
    @Nullable
    public static final Bitmap a(@NotNull String base64ImageStrDecodeToBitmap) {
        List split$default;
        Intrinsics.checkNotNullParameter(base64ImageStrDecodeToBitmap, "$this$base64ImageStrDecodeToBitmap");
        BitmapFactory.Options options = new BitmapFactory.Options();
        split$default = StringsKt__StringsKt.split$default((CharSequence) base64ImageStrDecodeToBitmap, new String[]{","}, false, 0, 6, (Object) null);
        byte[] decode = Base64.decode((String) split$default.get(1), 0);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        } catch (OutOfMemoryError e16) {
            w.f392617a.b("base64ImageStrDecodeToBitmap", "base64ImageStrDecodeToBitmap oom: " + e16);
            return null;
        }
    }

    @NotNull
    public static final List<View> b(@NotNull ViewGroup buildOrderedChildList) {
        Intrinsics.checkNotNullParameter(buildOrderedChildList, "$this$buildOrderedChildList");
        ArrayList arrayList = new ArrayList();
        int childCount = buildOrderedChildList.getChildCount();
        if (childCount > 1 && d(buildOrderedChildList)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View nextChild = buildOrderedChildList.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(nextChild, "nextChild");
                float z16 = nextChild.getZ();
                int i16 = i3;
                while (i16 > 0 && ((View) arrayList.get(i16 - 1)).getZ() > z16) {
                    i16--;
                }
                arrayList.add(i16, nextChild);
            }
        }
        return arrayList;
    }

    public static final void c(@NotNull ViewGroup foreachOrderedChild, @NotNull Function1<? super View, Unit> block) {
        View subView;
        Intrinsics.checkNotNullParameter(foreachOrderedChild, "$this$foreachOrderedChild");
        Intrinsics.checkNotNullParameter(block, "block");
        List<View> b16 = b(foreachOrderedChild);
        boolean isEmpty = b16.isEmpty();
        for (int childCount = foreachOrderedChild.getChildCount() - 1; childCount >= 0; childCount--) {
            if (!isEmpty) {
                subView = b16.get(childCount);
            } else {
                subView = foreachOrderedChild.getChildAt(childCount);
            }
            Intrinsics.checkNotNullExpressionValue(subView, "subView");
            block.invoke(subView);
        }
    }

    private static final boolean d(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            if (childAt.getZ() != 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(float f16, float f17, @NotNull View child, @NotNull View parentView) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        float[] fArr = {f16, f17};
        j(fArr, child, parentView);
        return g(child, fArr[0], fArr[1], 0.0f, 4, null);
    }

    private static final boolean f(View view, float f16, float f17, float f18) {
        float f19 = -f18;
        if (f16 >= f19 && f17 >= f19 && f16 < (view.getRight() - view.getLeft()) + f18 && f17 < (view.getBottom() - view.getTop()) + f18) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean g(View view, float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        return f(view, f16, f17, f18);
    }

    @Nullable
    public static final Bitmap h(@NotNull View toBitmap) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        if (toBitmap.getWidth() <= 0 || toBitmap.getHeight() <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(toBitmap.getWidth(), toBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            toBitmap.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception e16) {
            w.f392617a.b("toBitmap", "Draw bitmap error: " + e16.getMessage());
            try {
                boolean isDrawingCacheEnabled = toBitmap.isDrawingCacheEnabled();
                boolean willNotCacheDrawing = toBitmap.willNotCacheDrawing();
                toBitmap.setDrawingCacheEnabled(true);
                toBitmap.setWillNotCacheDrawing(false);
                Bitmap drawingCache = toBitmap.getDrawingCache();
                if (drawingCache != null) {
                    bitmap = drawingCache.copy(Bitmap.Config.ARGB_8888, false);
                } else {
                    bitmap = null;
                }
                toBitmap.destroyDrawingCache();
                toBitmap.setWillNotCacheDrawing(willNotCacheDrawing);
                toBitmap.setDrawingCacheEnabled(isDrawingCacheEnabled);
                return bitmap;
            } catch (Exception e17) {
                w.f392617a.b("toBitmap", "Draw bitmap fallback error: " + e17.getMessage());
                return null;
            }
        } catch (OutOfMemoryError e18) {
            w.f392617a.b("toBitmap", "Out of memory error: " + e18.getMessage());
            return null;
        }
    }

    public static final void i(@NotNull View transformPointToRootView, @NotNull float[] touchPoint) {
        Intrinsics.checkNotNullParameter(transformPointToRootView, "$this$transformPointToRootView");
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
        Matrix viewMatrix = transformPointToRootView.getMatrix();
        Intrinsics.checkNotNullExpressionValue(viewMatrix, "viewMatrix");
        if (!viewMatrix.isIdentity()) {
            transformPointToRootView.getMatrix().mapPoints(touchPoint);
        }
        ViewParent parent = transformPointToRootView.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "parent");
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            touchPoint[0] = touchPoint[0] - viewGroup.getScrollX();
            touchPoint[1] = touchPoint[1] - viewGroup.getScrollY();
            Matrix m3 = viewGroup.getMatrix();
            Intrinsics.checkNotNullExpressionValue(m3, "m");
            if (!m3.isIdentity()) {
                m3.mapPoints(touchPoint);
            }
            touchPoint[0] = touchPoint[0] + viewGroup.getLeft();
            touchPoint[1] = touchPoint[1] + viewGroup.getTop();
            parent = viewGroup.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "view.parent");
            if (parent instanceof KuiklyRenderView) {
                return;
            }
        }
    }

    private static final void j(float[] fArr, View view, View view2) {
        fArr[0] = (fArr[0] + view2.getScrollX()) - view.getLeft();
        fArr[1] = (fArr[1] + view2.getScrollY()) - view.getTop();
        Matrix viewMatrix = view.getMatrix();
        Intrinsics.checkNotNullExpressionValue(viewMatrix, "viewMatrix");
        if (!viewMatrix.isIdentity()) {
            Matrix matrix = new Matrix();
            viewMatrix.invert(matrix);
            matrix.mapPoints(fArr);
        }
    }

    @NotNull
    public static final MotionEvent k(@NotNull View transformedToParentMotionEvent, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(transformedToParentMotionEvent, "$this$transformedToParentMotionEvent");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        ViewParent parent = transformedToParentMotionEvent.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            MotionEvent parentEvent = MotionEvent.obtain(motionEvent);
            Matrix viewMatrix = transformedToParentMotionEvent.getMatrix();
            Intrinsics.checkNotNullExpressionValue(viewMatrix, "viewMatrix");
            if (!viewMatrix.isIdentity()) {
                parentEvent.transform(viewMatrix);
            }
            parentEvent.offsetLocation(-(viewGroup.getScrollX() - transformedToParentMotionEvent.getLeft()), -(viewGroup.getScrollY() - transformedToParentMotionEvent.getTop()));
            Intrinsics.checkNotNullExpressionValue(parentEvent, "parentEvent");
            return parentEvent;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}

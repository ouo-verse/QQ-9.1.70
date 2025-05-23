package com.tencent.state.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/utils/ViewUtils;", "", "()V", "expendTouchArea", "", "view", "Landroid/view/View;", "top", "", "right", "bottom", "left", "getNameById", "", "getViewName", "getViewParentName", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewParent;", "loadImageDrawable", "url", "Landroid/widget/ImageView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    ViewUtils() {
    }

    private final String getNameById(View view) {
        try {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            return context.getResources().getResourceEntryName(view.getId());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getViewParentName(ViewParent parent) {
        boolean z16 = parent instanceof View;
        View view = parent;
        if (!z16) {
            view = null;
        }
        View view2 = view;
        if (view2 != null) {
            String nameById = getNameById(view2);
            return nameById != null ? nameById : String.valueOf(view2.getId());
        }
        return "";
    }

    public final String getViewName(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getViewParentName(view.getParent()));
        sb5.append('#');
        Object nameById = getNameById(view);
        if (nameById == null) {
            nameById = Integer.valueOf(view.getId());
        }
        sb5.append(nameById);
        return sb5.toString();
    }

    public final void loadImageDrawable(String url, ImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            final WeakReference weakReference = new WeakReference(view);
            URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.utils.ViewUtils$loadImageDrawable$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ViewUtils", "onLoadFailed $", null, 4, null);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setImageDrawable(drawable2);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            view.setImageDrawable(drawable);
        }
    }

    public final void expendTouchArea(final View view, final int top, final int right, final int bottom, final int left) {
        if (view != null) {
            Object parent = view.getParent();
            if (parent != null) {
                final View view2 = (View) parent;
                view2.post(new Runnable() { // from class: com.tencent.state.utils.ViewUtils$expendTouchArea$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Rect rect = new Rect();
                        view.getHitRect(rect);
                        rect.top -= top;
                        rect.right += right;
                        rect.bottom += bottom;
                        rect.left -= left;
                        view2.setTouchDelegate(new TouchDelegate(rect, view));
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
    }
}

package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.trace.Tracer;
import com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback;
import com.tencent.qqlive.module.videoreport.traversal.IViewTraverser;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ExposureDetector {
    private static final String TAG = "ExposureDetector";

    private static boolean calculateRestrictedRect(View view, AncestorInfo ancestorInfo, AncestorInfo ancestorInfo2, Rect rect, ViewGroup viewGroup) {
        Rect rect2 = ancestorInfo2.restrictedRect;
        if (!ancestorInfo.clipChildren) {
            rect2.set(ancestorInfo.restrictedRect);
            return true;
        }
        rect2.set(0, 0, rect.right - rect.left, rect.bottom - rect.top);
        Rect clipBounds = ViewCompat.getClipBounds(view);
        if (clipBounds != null && !rect2.intersect(clipBounds)) {
            return false;
        }
        if (ViewCompatUtils.getClipToPadding(viewGroup) && !rect2.intersect(view.getPaddingLeft(), view.getPaddingTop(), view.getWidth() - view.getPaddingRight(), view.getHeight() - view.getPaddingBottom())) {
            return false;
        }
        rect2.offset(rect.left, rect.top);
        return true;
    }

    public static <T extends DetectionData> void detect(View view, final boolean z16, final IExposureDetectCallback<T> iExposureDetectCallback, IViewTraverser iViewTraverser) {
        if (view != null && iExposureDetectCallback != null && iViewTraverser != null) {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Tracer.begin("detect");
            }
            final T createDetectionData = iExposureDetectCallback.createDetectionData();
            AncestorInfo ancestorInfo = createDetectionData.ancestorsInfo.get(0);
            if (!view.getGlobalVisibleRect(ancestorInfo.visibleRect)) {
                return;
            }
            Rect rect = ancestorInfo.visibleRect;
            ancestorInfo.restrictedRect = rect;
            ancestorInfo.actualRect = rect;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                ancestorInfo.scrollX = viewGroup.getScrollX();
                ancestorInfo.scrollY = viewGroup.getScrollY();
                ancestorInfo.clipChildren = ViewCompatUtils.getClipChildren(viewGroup);
            }
            iViewTraverser.perform(view, new IViewTraverseCallback() { // from class: com.tencent.qqlive.module.videoreport.exposure.ExposureDetector.1
                @Override // com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback
                public boolean onEnter(View view2, int i3) {
                    return ExposureDetector.performOnEnter(view2, i3, DetectionData.this, iExposureDetectCallback, z16);
                }

                @Override // com.tencent.qqlive.module.videoreport.traversal.IViewTraverseCallback
                public void onLeave(View view2, int i3) {
                    AreaInfo areaInfo = DetectionData.this.mAreaInfo.get(i3);
                    if (areaInfo != null && !z16) {
                        iExposureDetectCallback.onExposed(view2, DetectionData.this, areaInfo);
                    }
                    iExposureDetectCallback.onLeave(view2, DetectionData.this);
                }
            });
        }
    }

    private static boolean isExposureAreaValid(long j3) {
        if (j3 != 0) {
            return true;
        }
        return false;
    }

    private static boolean isSelfRectInvalid(AncestorInfo ancestorInfo, Rect rect) {
        if (rect.intersect(ancestorInfo.restrictedRect) && !rect.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends DetectionData> boolean performOnEnter(View view, int i3, T t16, IExposureDetectCallback<T> iExposureDetectCallback, boolean z16) {
        t16.viewsDetected++;
        t16.mAreaInfo.set(i3, null);
        if (!iExposureDetectCallback.onEnter(view, t16) || view.getVisibility() != 0) {
            return false;
        }
        AncestorInfo ancestorInfo = t16.ancestorsInfo.get(i3 - 1);
        int left = (ancestorInfo.actualRect.left + view.getLeft()) - ancestorInfo.scrollX;
        int top = (ancestorInfo.actualRect.top + view.getTop()) - ancestorInfo.scrollY;
        RectF rectF = t16.helperRectF;
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(left, top);
        AncestorInfo ancestorInfo2 = t16.ancestorsInfo.get(i3);
        Rect rect = ancestorInfo2.visibleRect;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        ancestorInfo2.actualRect.set(rect);
        if (isSelfRectInvalid(ancestorInfo, rect)) {
            return false;
        }
        Rect rect2 = t16.helperRectForExclusion;
        rect2.set(rect);
        processExclusion(view, i3, t16, iExposureDetectCallback, iExposureDetectCallback.getExcludeRect(), z16, rect, rect2);
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (!calculateRestrictedRect(view, ancestorInfo, ancestorInfo2, rect, viewGroup)) {
            return false;
        }
        ancestorInfo2.scrollX = view.getScrollX();
        ancestorInfo2.scrollY = view.getScrollY();
        ancestorInfo2.clipChildren = ViewCompatUtils.getClipChildren(viewGroup);
        return true;
    }

    private static <T extends DetectionData> void processExclusion(View view, int i3, T t16, IExposureDetectCallback<T> iExposureDetectCallback, Rect rect, boolean z16, Rect rect2, Rect rect3) {
        long j3;
        if (rect != null && rect3.intersect(rect)) {
            j3 = rect3.width() * rect3.height();
        } else {
            j3 = 0;
        }
        long width = (rect2.width() * rect2.height()) - j3;
        if (isExposureAreaValid(width)) {
            AreaInfo areaInfo = new AreaInfo(view.getWidth() * view.getHeight(), width, (((float) width) * 1.0f) / ((float) r6));
            t16.mAreaInfo.set(i3, areaInfo);
            if (z16) {
                iExposureDetectCallback.onExposed(view, t16, areaInfo);
            }
        }
    }
}

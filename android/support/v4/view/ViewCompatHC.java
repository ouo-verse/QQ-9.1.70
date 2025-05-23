package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatHC {
    ViewCompatHC() {
    }

    public static int combineMeasuredStates(int i3, int i16) {
        return View.combineMeasuredStates(i3, i16);
    }

    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static float getRotation(View view) {
        return view.getRotation();
    }

    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getX(View view) {
        return view.getX();
    }

    public static float getY(View view) {
        return view.getY();
    }

    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view, int i3) {
        view.offsetLeftAndRight(i3);
        Object parent = view.getParent();
        if (parent instanceof View) {
            tickleInvalidationFlag((View) parent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view, int i3) {
        view.offsetTopAndBottom(i3);
        Object parent = view.getParent();
        if (parent instanceof View) {
            tickleInvalidationFlag((View) parent);
        }
    }

    public static int resolveSizeAndState(int i3, int i16, int i17) {
        return View.resolveSizeAndState(i3, i16, i17);
    }

    public static void setActivated(View view, boolean z16) {
        view.setActivated(z16);
    }

    public static void setAlpha(View view, float f16) {
        view.setAlpha(f16);
    }

    public static void setLayerType(View view, int i3, Paint paint) {
        view.setLayerType(i3, paint);
    }

    public static void setPivotX(View view, float f16) {
        view.setPivotX(f16);
    }

    public static void setPivotY(View view, float f16) {
        view.setPivotY(f16);
    }

    public static void setRotation(View view, float f16) {
        view.setRotation(f16);
    }

    public static void setRotationX(View view, float f16) {
        view.setRotationX(f16);
    }

    public static void setRotationY(View view, float f16) {
        view.setRotationY(f16);
    }

    public static void setSaveFromParentEnabled(View view, boolean z16) {
        view.setSaveFromParentEnabled(z16);
    }

    public static void setScaleX(View view, float f16) {
        view.setScaleX(f16);
    }

    public static void setScaleY(View view, float f16) {
        view.setScaleY(f16);
    }

    public static void setTranslationX(View view, float f16) {
        view.setTranslationX(f16);
    }

    public static void setTranslationY(View view, float f16) {
        view.setTranslationY(f16);
    }

    public static void setX(View view, float f16) {
        view.setX(f16);
    }

    public static void setY(View view, float f16) {
        view.setY(f16);
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}

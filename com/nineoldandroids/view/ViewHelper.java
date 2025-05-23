package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ViewHelper {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class Honeycomb {
        Honeycomb() {
        }

        static float getAlpha(View view) {
            return AnimatorProxy.wrap(view).getAlpha();
        }

        static float getPivotX(View view) {
            return AnimatorProxy.wrap(view).getPivotX();
        }

        static float getPivotY(View view) {
            return AnimatorProxy.wrap(view).getPivotY();
        }

        static float getRotation(View view) {
            return AnimatorProxy.wrap(view).getRotation();
        }

        static float getRotationX(View view) {
            return AnimatorProxy.wrap(view).getRotationX();
        }

        static float getRotationY(View view) {
            return AnimatorProxy.wrap(view).getRotationY();
        }

        static float getScaleX(View view) {
            return AnimatorProxy.wrap(view).getScaleX();
        }

        static float getScaleY(View view) {
            return AnimatorProxy.wrap(view).getScaleY();
        }

        static float getScrollX(View view) {
            return AnimatorProxy.wrap(view).getScrollX();
        }

        static float getScrollY(View view) {
            return AnimatorProxy.wrap(view).getScrollY();
        }

        static float getTranslationX(View view) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }

        static float getTranslationY(View view) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }

        static float getX(View view) {
            return AnimatorProxy.wrap(view).getX();
        }

        static float getY(View view) {
            return AnimatorProxy.wrap(view).getY();
        }

        static void setAlpha(View view, float f16) {
            AnimatorProxy.wrap(view).setAlpha(f16);
        }

        static void setPivotX(View view, float f16) {
            AnimatorProxy.wrap(view).setPivotX(f16);
        }

        static void setPivotY(View view, float f16) {
            AnimatorProxy.wrap(view).setPivotY(f16);
        }

        static void setRotation(View view, float f16) {
            AnimatorProxy.wrap(view).setRotation(f16);
        }

        static void setRotationX(View view, float f16) {
            AnimatorProxy.wrap(view).setRotationX(f16);
        }

        static void setRotationY(View view, float f16) {
            AnimatorProxy.wrap(view).setRotationY(f16);
        }

        static void setScaleX(View view, float f16) {
            AnimatorProxy.wrap(view).setScaleX(f16);
        }

        static void setScaleY(View view, float f16) {
            AnimatorProxy.wrap(view).setScaleY(f16);
        }

        static void setScrollX(View view, int i3) {
            AnimatorProxy.wrap(view).setScrollX(i3);
        }

        static void setScrollY(View view, int i3) {
            AnimatorProxy.wrap(view).setScrollY(i3);
        }

        static void setTranslationX(View view, float f16) {
            AnimatorProxy.wrap(view).setTranslationX(f16);
        }

        static void setTranslationY(View view, float f16) {
            AnimatorProxy.wrap(view).setTranslationY(f16);
        }

        static void setX(View view, float f16) {
            AnimatorProxy.wrap(view).setX(f16);
        }

        static void setY(View view, float f16) {
            AnimatorProxy.wrap(view).setY(f16);
        }
    }

    ViewHelper() {
    }

    public static float getAlpha(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getAlpha();
        }
        return Honeycomb.getAlpha(view);
    }

    public static float getPivotX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotX();
        }
        return Honeycomb.getPivotX(view);
    }

    public static float getPivotY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotY();
        }
        return Honeycomb.getPivotY(view);
    }

    public static float getRotation(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotation();
        }
        return Honeycomb.getRotation(view);
    }

    public static float getRotationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationX();
        }
        return Honeycomb.getRotationX(view);
    }

    public static float getRotationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationY();
        }
        return Honeycomb.getRotationY(view);
    }

    public static float getScaleX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleX();
        }
        return Honeycomb.getScaleX(view);
    }

    public static float getScaleY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleY();
        }
        return Honeycomb.getScaleY(view);
    }

    public static float getScrollX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScrollX();
        }
        return Honeycomb.getScrollX(view);
    }

    public static float getScrollY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScrollY();
        }
        return Honeycomb.getScrollY(view);
    }

    public static float getTranslationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }
        return Honeycomb.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }
        return Honeycomb.getTranslationY(view);
    }

    public static float getX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getX();
        }
        return Honeycomb.getX(view);
    }

    public static float getY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getY();
        }
        return Honeycomb.getY(view);
    }

    public static void setAlpha(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f16);
        } else {
            Honeycomb.setAlpha(view, f16);
        }
    }

    public static void setPivotX(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f16);
        } else {
            Honeycomb.setPivotX(view, f16);
        }
    }

    public static void setPivotY(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f16);
        } else {
            Honeycomb.setPivotY(view, f16);
        }
    }

    public static void setRotation(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f16);
        } else {
            Honeycomb.setRotation(view, f16);
        }
    }

    public static void setRotationX(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f16);
        } else {
            Honeycomb.setRotationX(view, f16);
        }
    }

    public static void setRotationY(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f16);
        } else {
            Honeycomb.setRotationY(view, f16);
        }
    }

    public static void setScaleX(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f16);
        } else {
            Honeycomb.setScaleX(view, f16);
        }
    }

    public static void setScaleY(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f16);
        } else {
            Honeycomb.setScaleY(view, f16);
        }
    }

    public static void setScrollX(View view, int i3) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i3);
        } else {
            Honeycomb.setScrollX(view, i3);
        }
    }

    public static void setScrollY(View view, int i3) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i3);
        } else {
            Honeycomb.setScrollY(view, i3);
        }
    }

    public static void setTranslationX(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f16);
        } else {
            Honeycomb.setTranslationX(view, f16);
        }
    }

    public static void setTranslationY(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f16);
        } else {
            Honeycomb.setTranslationY(view, f16);
        }
    }

    public static void setX(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f16);
        } else {
            Honeycomb.setX(view, f16);
        }
    }

    public static void setY(View view, float f16) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f16);
        } else {
            Honeycomb.setY(view, f16);
        }
    }
}

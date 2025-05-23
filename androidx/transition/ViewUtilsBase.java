package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        if (!sSetFrameFetched) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e16) {
                Log.i(TAG, "Failed to retrieve setFrame method", e16);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(com.tencent.mobileqq.R.id.f794049o, null);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        Float f16 = (Float) view.getTag(com.tencent.mobileqq.R.id.f794049o);
        if (f16 != null) {
            return view.getAlpha() / f16.floatValue();
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        if (view.getTag(com.tencent.mobileqq.R.id.f794049o) == null) {
            view.setTag(com.tencent.mobileqq.R.id.f794049o, Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        int i3;
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArr = this.mMatrixValues;
            if (fArr == null) {
                fArr = new float[9];
                this.mMatrixValues = fArr;
            }
            matrix.getValues(fArr);
            float f16 = fArr[3];
            float sqrt = (float) Math.sqrt(1.0f - (f16 * f16));
            if (fArr[0] < 0.0f) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            float f17 = sqrt * i3;
            float degrees = (float) Math.toDegrees(Math.atan2(f16, f17));
            float f18 = fArr[0] / f17;
            float f19 = fArr[4] / f17;
            float f26 = fArr[2];
            float f27 = fArr[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f26);
            view.setTranslationY(f27);
            view.setRotation(degrees);
            view.setScaleX(f18);
            view.setScaleY(f19);
            return;
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
    }

    public void setLeftTopRightBottom(@NonNull View view, int i3, int i16, int i17, int i18) {
        fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e16) {
                throw new RuntimeException(e16.getCause());
            }
        }
    }

    public void setTransitionAlpha(@NonNull View view, float f16) {
        Float f17 = (Float) view.getTag(com.tencent.mobileqq.R.id.f794049o);
        if (f17 != null) {
            view.setAlpha(f17.floatValue() * f16);
        } else {
            view.setAlpha(f16);
        }
    }

    public void setTransitionVisibility(@NonNull View view, int i3) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            transformMatrixToGlobal((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            transformMatrixToLocal((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}

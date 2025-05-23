package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes.dex */
class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    private static final boolean HAS_OVERLAY;
    private static final boolean HAS_PICTURE_BITMAP;
    private static final int MAX_IMAGE_SIZE = 1048576;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempStartValues = new float[9];
        final float[] mTempEndValues = new float[9];
        final Matrix mTempMatrix = new Matrix();

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f16, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.mTempEndValues;
                float f17 = fArr[i3];
                float f18 = this.mTempStartValues[i3];
                fArr[i3] = f18 + ((f17 - f18) * f16);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        boolean z16 = true;
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        if (i3 < 28) {
            z16 = false;
        }
        HAS_PICTURE_BITMAP = z16;
    }

    TransitionUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap createViewBitmap = createViewBitmap(view, matrix, rectF, viewGroup);
        if (createViewBitmap != null) {
            imageView.setImageBitmap(createViewBitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z16;
        boolean z17;
        int i3;
        ViewGroup viewGroup2;
        if (HAS_IS_ATTACHED_TO_WINDOW) {
            z16 = !view.isAttachedToWindow();
            if (viewGroup == null) {
                z17 = false;
            } else {
                z17 = viewGroup.isAttachedToWindow();
            }
        } else {
            z16 = false;
            z17 = false;
        }
        boolean z18 = HAS_OVERLAY;
        Bitmap bitmap = null;
        if (z18 && z16) {
            if (!z17) {
                return null;
            }
            viewGroup2 = (ViewGroup) view.getParent();
            i3 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        } else {
            i3 = 0;
            viewGroup2 = null;
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / (round * round2));
            int round3 = Math.round(round * min);
            int round4 = Math.round(round2 * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (HAS_PICTURE_BITMAP) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z18 && z16) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i3);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}

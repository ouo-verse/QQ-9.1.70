package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class Space extends View {
    @Deprecated
    public Space(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int getDefaultSize2(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                return size;
            }
            return i3;
        }
        return Math.min(i3, size);
    }

    @Override // android.view.View
    @Deprecated
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i3), getDefaultSize2(getSuggestedMinimumHeight(), i16));
    }

    @Deprecated
    public Space(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas canvas) {
    }
}

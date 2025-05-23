package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class AIOCoreLayoutParam extends RecyclerView.LayoutParams {
    public boolean whenOutScreenLocation;

    public AIOCoreLayoutParam(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.whenOutScreenLocation = false;
    }

    public AIOCoreLayoutParam(int i3, int i16) {
        super(i3, i16);
        this.whenOutScreenLocation = false;
    }

    public AIOCoreLayoutParam(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.whenOutScreenLocation = false;
    }

    public AIOCoreLayoutParam(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.whenOutScreenLocation = false;
    }

    public AIOCoreLayoutParam(RecyclerView.LayoutParams layoutParams) {
        super(layoutParams);
        this.whenOutScreenLocation = false;
    }
}

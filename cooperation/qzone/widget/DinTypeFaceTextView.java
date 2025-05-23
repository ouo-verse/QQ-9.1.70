package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DinTypeFaceTextView extends TextView {
    private static final String TAG = "DinTypeFaceTextView";
    static Typeface dinTypeface = null;
    static boolean loadTypeFaced = false;

    public DinTypeFaceTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (dinTypeface == null) {
            loadTypeFace();
        }
        Typeface typeface = dinTypeface;
        if (typeface != null) {
            setTypeface(typeface);
        }
    }

    private void loadTypeFace() {
        if (loadTypeFaced) {
            return;
        }
        try {
            dinTypeface = Typeface.defaultFromStyle(0);
        } finally {
            try {
            } finally {
            }
        }
    }

    public DinTypeFaceTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DinTypeFaceTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        init(context, attributeSet, i3, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i3, int i16) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i3, i16);
        int i17 = R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes.hasValue(i17)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(i17, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z16) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z16;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z16);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i16 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i16);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i16, int i17, int i18) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i16 -= view.getHeight();
        }
        super.update(view, i3, i16, i17, i18);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        init(context, attributeSet, i3, i16);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16, int i17) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i16 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i16, i17);
    }
}

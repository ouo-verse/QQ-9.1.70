package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i3, int i16);

    void setShadowPadding(int i3, int i16, int i17, int i18);
}

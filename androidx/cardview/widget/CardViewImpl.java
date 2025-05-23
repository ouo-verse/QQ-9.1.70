package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate);

    float getElevation(CardViewDelegate cardViewDelegate);

    float getMaxElevation(CardViewDelegate cardViewDelegate);

    float getMinHeight(CardViewDelegate cardViewDelegate);

    float getMinWidth(CardViewDelegate cardViewDelegate);

    float getRadius(CardViewDelegate cardViewDelegate);

    void initStatic();

    void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f16, float f17, float f18);

    void onCompatPaddingChanged(CardViewDelegate cardViewDelegate);

    void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate);

    void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList);

    void setElevation(CardViewDelegate cardViewDelegate, float f16);

    void setMaxElevation(CardViewDelegate cardViewDelegate, float f16);

    void setRadius(CardViewDelegate cardViewDelegate, float f16);

    void updatePadding(CardViewDelegate cardViewDelegate);
}
